package DataStructure;

/**
 * @Desc: 描述
 * @Author: Heyyw
 * @CreateDate: 2019/1/4 16:25
 * @UpdateAuthor:
 * @UpdateDate:
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class BinaryTreeMehod {
    /** 
    * @Description: 创建二叉搜索树
    * @param: [values]
    * @return: DataStructure.BinaryTree        
    * @Author: heyyw 
    * @Date: 2019/01/04 16:28 
    */ 
    public BinaryTree createBinaryTree(int[] values) {
        BinaryTree root = null;
        for (int value : values) {
            root = addNode(root, value);
        }
        return root;
    }

    private BinaryTree addNode(BinaryTree root, int value) {
        if (root == null) {
            root = new BinaryTree();
            root.value = value;
        } else {
            if (value < root.value) {
                root.leftNode = addNode(root.leftNode, value);
            } else {
                root.rightNode = addNode(root.rightNode, value);
            }
        }
        return root;
    }

    /**
     * @Description: 遍历二叉树 中序遍历
     * @param:
     * @return:
     * @Author: heyyw
     * @Date: 2019/01/04 16:16
     */
    public void Traversal(BinaryTree root) {
        if (root == null)
            return;
        Traversal(root.leftNode);
        System.out.print(root.value + "  ");
        Traversal(root.rightNode);
    }


    /**
    * @Description: 二叉树查找节点
    * @param:
    * @return:
    * @Author: heyyw
    * @Date: 2019/01/04 16:34
    */
    public BinaryTree search (BinaryTree root, int value) {
        if (root == null || root.value == value)
            return root;
        if (value < root.value)
            return search(root.leftNode, value);
        else
            return search(root.rightNode, value);
    }

    /**
    * @Description: 查找父节点
    * @param: [root, value]
    * @return: DataStructure.BinaryTree
    * @Author: heyyw
    * @Date: 2019/01/04 16:57
    */
    public BinaryTree searchParent(BinaryTree root, int value) {
        if (root == null)
            return root;
        else {
            if ((root.leftNode != null && root.leftNode.value == value) ||
                    root.rightNode != null && root.rightNode.value == value)
                return root;
            else {
                if (value < root.value && root.leftNode != null)
                    return searchParent(root.leftNode, value);
                if (value >= root.value && root.rightNode != null)
                    return searchParent(root.rightNode, value);
                return null;

            }
        }
    }

    /**
    * @Description: 删除节点
    * @param: [root, value]
    * @return: DataStructure.BinaryTree
    * @Author: heyyw
    * @Date: 2019/01/04 19:36
    */
    public BinaryTree delete(BinaryTree root, int value) {
        BinaryTree delete = search(root, value);
        //找不到节点
        if (delete == null)
            return root;
        if (root.value == value) {
            if (root.leftNode == null && root.rightNode == null)
                root = null;
            //左子树不为空
            else if (root.rightNode == null) {
                root = root.leftNode;
            }
            //右子树不为空
            else if (root.leftNode == null) {
                root = root.rightNode;
            }
            //都不为空
            else {
                BinaryTree temp = root;
                BinaryTree select = root.leftNode;
                if (select.rightNode == null)
                {
                    select.rightNode = root.rightNode;
                } else
                {
                    while (select.rightNode != null) {
                        temp = select;
                        select = select.rightNode;
                    }
                    temp.rightNode = select.leftNode;
                    select.leftNode = root.leftNode;
                    select.rightNode = root.rightNode;
                }
                root = select;
            }
            return root;
        }
        //父节点
        BinaryTree parent = searchParent(root, value);

        //为叶子节点
        if (delete.leftNode == null && delete.rightNode ==null) {
            delete = null;
            if (parent.leftNode != null && parent.leftNode.value == value)
                parent.leftNode = null;
            else
                parent.rightNode = null;
        }
        //左子树不为空
        else if (delete.rightNode == null) {
            if (parent.leftNode != null && parent.leftNode.value == value){
                parent.leftNode = delete.leftNode;
                delete = null;
            } else {
                parent.rightNode = delete.leftNode;
                delete = null;
            }

        }
        //右子树不为空
        else if (delete.leftNode == null) {
            if (parent.leftNode != null && parent.leftNode.value == value) {
                parent.leftNode = delete.rightNode;
                delete = null;
            } else {
                parent.rightNode = delete.rightNode;
                delete = null;
            }
        }
        //都不为空,选择左子树最大的那个数继承删除节点
        else {
            BinaryTree temp = delete;
            BinaryTree select = temp.leftNode;
            if (select.rightNode == null) {
                select.rightNode = delete.rightNode;
            } else
            {
                while (select.rightNode != null) {
                    temp = select;
                    select = select.rightNode;
                }
                temp.rightNode = select.leftNode;
                select.leftNode = delete.leftNode;
                select.rightNode = delete.rightNode;
            }
            if (parent.leftNode != null && parent.leftNode.value == value) {
                parent.leftNode = select;
            } else {
                parent.rightNode = select;
            }
        }
        return root;
    }

    /**
    * @Description: 二叉树深度
    * @param: [root]
    * @return: int
    * @Author: heyyw
    * @Date: 2019/01/04 20:56
    */
    public int depthOfTree(BinaryTree root) {
        if (root == null)
            return 0;
        if (root.leftNode == null && root.rightNode == null)
            return 1;
        return Math.max(depthOfTree(root.leftNode), depthOfTree(root.rightNode)) + 1;
    }
}

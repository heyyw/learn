package DataStructure;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;

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

    /**
     * @Description: 二叉树的宽度
     * @param: [root]
     * @return: int
     * @Author: heyyw
     * @Date: 2019/01/05 09:21
     */
    public int widthOfTree(BinaryTree root) {
        if (root == null)
            return 0;
        Queue<BinaryTree> queue = new LinkedList<>();
        queue.offer(root);
        int width = 1;
        int currentWidth = 1;
        while (!queue.isEmpty()) {
            currentWidth = queue.size();
            for (int i = 0; i < currentWidth; i++) {
                BinaryTree bt = queue.peek();
                queue.poll();
                if (bt.leftNode != null)
                    queue.add(bt.leftNode);
                if (bt.rightNode != null)
                    queue.add(bt.rightNode);
            }
            width = Math.max(width, queue.size());
//            List<BinaryTree> list = new ArrayList<>();
//            while (!queue.isEmpty()) {
//                list.add(queue.poll());
//            }
//            width = Math.max(width, list.size());
//            for (BinaryTree bt : list) {
//                if (bt.leftNode != null)
//                    queue.add(bt.leftNode);
//                if (bt.rightNode != null)
//                    queue.add(bt.rightNode);
//            }
        }
        return width;
    }

    /**
     * @Description: 二叉树某层节点数
     * @param: [root, level]
     * @return: int
     * @Author: heyyw
     * @Date: 2019/01/05 09:44
     */
    public int numOfNodesonLevel(BinaryTree root, int level) {
        int result = 0;
        if (root == null || level < 1)
            return result;
        if (level == 1) {
            result = 1;
            return result;
        }
        return numOfNodesonLevel(root.leftNode, level - 1) + numOfNodesonLevel(root.rightNode, level - 1);
//        int depth = depthOfTree(root);
//        if (root == null || level < 1 || level > depth)
//            return 0;
//        int nums = 0;
//        int k = 0;
//        int currentnums = 0;
//        Queue<BinaryTree> queue = new LinkedList<>();
//        queue.add(root);
//        while (k < level) {
//            currentnums = queue.size();
//            for (int i = 0; i < currentnums; i++) {
//                BinaryTree bt = queue.peek();
//                queue.poll();
//                if (bt.leftNode != null)
//                    queue.add(bt.leftNode);
//                if (bt.rightNode != null)
//                    queue.add(bt.rightNode);
//            }
//            k++;
//        }
//        return currentnums;
    }

    /**
     * @Description: 二叉树叶子节点数量
     * @param: [root]
     * @return: int
     * @Author: heyyw
     * @Date: 2019/01/05 09:51
     */
    public int numsOfLeafsInTree(BinaryTree root) {
        if (root == null)
            return 0;
        if (root.leftNode == null && root.rightNode == null)
            return 1;
        return numsOfLeafsInTree(root.leftNode) + numsOfLeafsInTree(root.rightNode);
    }

    /**
     * @Description: 二叉树两个节点之间最大的距离
     * @param: [root]
     * @return: int
     * @Author: heyyw
     * @Date: 2019/01/05 10:16
     */
    public int maxDistanceOfTree(BinaryTree root) {
        if (root == null)
            return 0;
        if (root.leftNode == null && root.rightNode == null)
            return 1;
        int width = depthOfTree(root.leftNode) + depthOfTree(root.rightNode);
        return Math.max(Math.max(maxDistanceOfTree(root.leftNode), maxDistanceOfTree(root.rightNode)),width);
    }

    /**
     * @Description: 查找某个节点到根节点的路径
     * @param: [root, value]
     * @return: java.util.Stack<DataStructure.BinaryTree>
     * @Author: heyyw
     * @Date: 2019/01/05 10:18
     */
    public Stack<BinaryTree> pathOfNode(BinaryTree root,int value) {
        Stack<BinaryTree> stack = new Stack<>();
        isFoundNode(root, value, stack);
        return stack;
    }
    private Boolean isFoundNode(BinaryTree root, int value, Stack<BinaryTree> stack) {
        if (root == null)
            return false;
        if (root.value == value) {
            stack.add(root);
            return true;
        }
        stack.add(root);
        Boolean isFind = isFoundNode(root.leftNode, value, stack);
        if (!isFind) {
            isFind = isFoundNode(root.rightNode, value, stack);
        }
        if (!isFind)
            stack.pop();
        return isFind;
    }

    /**
     * @Description: 两个节点的最近父节点
     * @param: [root, value1, value2]
     * @return: DataStructure.BinaryTree
     * @Author: heyyw
     * @Date: 2019/01/05 14:48
     */
    public BinaryTree parentOfNodes(BinaryTree root, int value1, int value2) {
        Stack<BinaryTree> stack1 = pathOfNode(root, value1);
        Stack<BinaryTree> stack2 = pathOfNode(root, value2);
        if (stack1.size() == 0 || stack2.size() == 0)
            return null;
        BinaryTree bt = null;
        BinaryTree[] arr1 = new BinaryTree[stack1.size()];
        BinaryTree[] arr2 = new BinaryTree[stack2.size()];
        for (int i = stack1.size() - 1; i >= 0; i--) {
            arr1[i] = stack1.pop();
        }
        for (int i = stack2.size() - 1; i >= 0; i--) {
            arr2[i] = stack2.pop();
        }
        for (int i = 0; i < arr1.length - 1 && i < arr2.length - 1; i++) {
            if (arr1[i + 1] != arr2[i + 1])
                return arr1[i];
            if (i + 1 == arr1.length - 1)
                return arr1[arr1.length - 1];
            if (i + 1 == arr2.length - 1)
                return  arr2[arr2.length - 1];
        }
        return null;
    }

    public List<Integer> pathFromNode(BinaryTree root, int value1, int value2) {
        Stack<BinaryTree> stack1 = pathOfNode(root, value1);
        Stack<BinaryTree> stack2 = pathOfNode(root, value2);
        if (stack1.size() == 0 || stack2.size() == 0)
            return null;
        int[] arr1 = new int[stack1.size()];
        int[] arr2 = new int[stack2.size()];
        for (int i = stack1.size() - 1; i >= 0; i--) {
            arr1[i] = stack1.pop().value;
        }
        for (int i = stack2.size() - 1; i >= 0; i--) {
            arr2[i] = stack2.pop().value;
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i < arr1.length && i < arr2.length; i++) {
            if (arr1[i] != arr2[i]){
                for (int j = arr1.length - 1; j >= i - 1; j--){
                    result.add(arr1[j]);
                }
                for (int j = i; j < arr2.length; j++){
                    result.add(arr2[j]);
                }
                break;
            }
            if (i == arr1.length - 1) {
                for (int j = i; j < arr2.length; j++){
                    result.add(arr2[j]);
                }
            }
            if (i == arr2.length - 1) {
                for (int j = i; j < arr1.length; j++) {
                    result.add(arr1[j]);
                }
            }
        }
        return result;
    }



}

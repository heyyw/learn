import DataStructure.BinaryTree;
import DataStructure.BinaryTreeMehod;
import DataStructure.MyQueue;

/**
 * @Desc: 描述
 * @Author: Heyyw
 * @CreateDate: 2019/1/3 9:58
 * @UpdateAuthor:
 * @UpdateDate:
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class dataStructure {
    public static void main(String[] args) {
//        MyQueue<String> myQueue = new MyQueue(10);
//        myQueue.insert("wyw");
//        myQueue.insert("lt");
//        System.out.println(myQueue.peek());

        BinaryTreeMehod btm = new BinaryTreeMehod();
        int[] value = {26,16,86,6,7,56,4,12,8,90};
        BinaryTree root = btm.createBinaryTree(value);
//        btm.Traversal(root);
//        System.out.println("\n");
//        root = btm.delete(root,16);
//        btm.Traversal(root);
//        BinaryTree node = btm.search(root, 12);
//        System.out.println(node.value);
//        BinaryTree parent = btm.searchParent(root, 8);
//        System.out.println(parent.value);
        int depth = btm.depthOfTree(root);
        System.out.println(depth);
    }
}

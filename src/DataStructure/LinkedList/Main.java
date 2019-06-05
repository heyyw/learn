package DataStructure.LinkedList;

import java.util.SortedSet;

/**
 * @Desc: 描述
 * @Author: Heyyw
 * @CreateDate: 2019/1/20 20:36
 * @UpdateAuthor:
 * @UpdateDate:
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class Main {
    public static void main(String[] args) {
        int[] input = {3,5,6,2,9,23,56,12,27};
        Node head = CreateLinkedList(input);
        //Sorts(head);
        //Node findNode = FindNode(head, 6);
        //System.out.println(findNode.data);
        //head = ReverseLinkedList2(head);
        //PrintReverse(head);
        Node midNode = FindMidNode(head);
        System.out.println(midNode.data);
        Prints(head);
    }

    /**
    * @Description: 创建单链表
    * @param: [input]
    * @return: DataStructure.LinkedList.Node
    * @Author: heyyw
    * @Date: 2019/01/20 20:42
    */
    public static Node CreateLinkedList(int[] input) {
        Node head = null;
        for (int i = 0; i < input.length; i++) {
            Node next = new Node(input[i]);
            if (head == null)
                head = next;
            else {
                Node temp = head;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = next;
            }
        }
        return head;
    }

    /**
    * @Description: 打印单链表
    * @param: [head]
    * @return: void
    * @Author: heyyw
    * @Date: 2019/01/20 20:47
    */
    public static void Prints(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    /**
    * @Description: 单链表排序
    * @param: [head]
    * @return: void
    * @Author: heyyw
    * @Date: 2019/01/20 20:56
    */
    public static void Sorts(Node head) {
        Node curNode = head;
        Node nextNode = null;
        int temp = 0;
        while (curNode != null) {
            nextNode = curNode.next;
            while (nextNode != null) {
                if (curNode.data > nextNode.data) {
                    temp = curNode.data;
                    curNode.data = nextNode.data;
                    nextNode.data = temp;
                }
                nextNode = nextNode.next;
            }
            curNode = curNode.next;
        }
    }

    /**
    * @Description: 查找倒数第k个node
    * @param: [head, k]
    * @return: DataStructure.LinkedList.Node
    * @Author: heyyw
    * @Date: 2019/01/20 21:17
    */
    public static Node FindNode(Node head, int k) {
        Node p1 = head;
        Node p2 = head;
        if (k < 1)
            return null;
        int i = 0;
        while (i < k - 1 && p1 != null) {
            p1 = p1.next;
            i++;
        }
        if (p1 == null) {
            System.out.println("k error");
            return null;
        }
        while (p1.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;

    }

    /**
    * @Description: 迭代方法 翻转单链表
    * @param: [head]
    * @return: DataStructure.LinkedList.Node
    * @Author: heyyw
    * @Date: 2019/01/20 21:31
    */
    public static Node ReverseLinkedList(Node head) {
        Node pre = null;
        Node next = null;
        //Node cur = head;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    /**
    * @Description: 递归方法 翻转单链表
    * @param: [head]
    * @return: DataStructure.LinkedList.Node
    * @Author: heyyw
    * @Date: 2019/01/21 10:30
    */
    public static Node ReverseLinkedList2(Node head) {
        if (head == null || head.next ==null)
            return head;
        Node temp = head.next;
        Node reNode = ReverseLinkedList2(head.next);
        temp.next = head;
        head.next = null;
        return reNode;
    }

    /**
    * @Description: 倒序打印单链表
    * @param: [head]
    * @return: void
    * @Author: heyyw
    * @Date: 2019/01/21 10:34
    */
    public static void PrintReverse(Node head) {
        if (head.next != null)
            PrintReverse(head.next);
        System.out.print(head.data + " ");
    }

    /**
    * @Description: 查找中间节点 双指针法
    * @param: [head]
    * @return: DataStructure.LinkedList.Node
    * @Author: heyyw
    * @Date: 2019/01/21 10:40
    */
    public static Node FindMidNode(Node head) {
        Node p1 = head;
        Node p2 = head;
        while (p2.next != null && p2.next.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return p1;
    }

    /** 
    * @Description: 判断单链表是否有环
    * @param: [head]
    * @return: boolean        
    * @Author: heyyw 
    * @Date: 2019/01/21 11:13 
    */ 
    public static boolean HasRing(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                return true;
        }
        return false;
    }

    /** 
    * @Description: 寻找环的入口点
    * @param: [head]
    * @return: DataStructure.LinkedList.Node        
    * @Author: heyyw 
    * @Date: 2019/01/21 11:17 
    */ 
    public static Node FindEnterNode(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                break;
        }
        if (fast == null || fast.next == null)
            return null;
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}

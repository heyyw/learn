package DataStructure;

/**
 * @Desc: 数组实现队列
 * @Author: Heyyw
 * @CreateDate: 2019/1/3 9:38
 * @UpdateAuthor:
 * @UpdateDate:
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class MyQueue<T> {
    private Object[] data;
    private int front;
    private int rear;
    private int size;
    private int length;

    public MyQueue(int size){
        if (size < 0)
            throw new IllegalArgumentException("error size");
        this.size = size;
        this.data = new Object[size];
        this.front = this.rear = this.length = 0;
    }
    /**
    * @Description: 插入元素
    * @param:
    * @return:
    * @Author: heyyw
    * @Date: 2019/01/03 09:43
    */
    public void insert(Object obj) {
        if (rear == size) {
            System.out.println("queue is full, insert failed");
            return;
        }
        data[rear++] = obj;
        System.out.println("insert success");
        length++;
        return;
    }

    /**
    * @Description: 移除
    * @param: []
    * @return: void
    * @Author: heyyw
    * @Date: 2019/01/03 09:50
    */
    public void remove() {
        if (front == rear){
            System.out.println("queue is empty, remove failed");
            return;
        }
        data[front++] = null;
        System.out.println("remove success");
        length--;
        return;
    }

    /**
    * @Description: 取队首元素
    * @param: []
    * @return: java.lang.Object
    * @Author: heyyw
    * @Date: 2019/01/03 09:51
    */
    public T peek() {
        if (front == rear){
            System.out.println("quere is empty, null");
            return null;
        }
        return (T)data[front];
    }

    /**
    * @Description: 取队尾元素
    * @param: []
    * @return: java.lang.Object
    * @Author: heyyw
    * @Date: 2019/01/03 09:56
    */
//    public T poll() {
//        if (front == rear){
//            System.out.println("quere is empty, null");
//            return null;
//        }
//        return (T)data[rear - 1];
//    }

    /**
    * @Description: 是否为空
    * @param: []
    * @return: boolean
    * @Author: heyyw
    * @Date: 2019/01/03 09:57
    */
    public boolean isEmpty() {
        return front == rear;
    }
}

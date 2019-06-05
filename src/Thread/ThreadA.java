package Thread;

/**
 * @Desc: 描述
 * @Author: Heyyw
 * @CreateDate: 2018/11/3 14:20
 * @UpdateAuthor:
 * @UpdateDate:
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class ThreadA extends Thread {
    public ThreadA(String name){
        super(name);
    }

    public void run(){
        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + " call notify()");
            notify();
        }
    }
}

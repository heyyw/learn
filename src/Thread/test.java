package Thread;

/**
 * @Desc: 描述
 * @Author: Heyyw
 * @CreateDate: 2019/4/1 13:08
 * @UpdateAuthor:
 * @UpdateDate:
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class test {
    static final ATest t = new ATest();
    public static void main(String[] args) {
        ThreadLocal threadLocal = new ThreadLocal();
        new Thread(()->{
            t.classmethod();
        }).start();
        new Thread(()->{
            t.method();
        }).start();

    }
}
class ATest{
    public synchronized static void staticMethod(){
        System.out.println("begin static");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end static");
    }
    public synchronized void method(){
        System.out.println("general method");
    }
    public void classmethod(){
        synchronized (ATest.class){
            System.out.println("class");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("class end");
        }

    }
}

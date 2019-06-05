package Thread.deadlock;

/**
 * @Desc: 描述
 * @Author: Heyyw
 * @CreateDate: 2019/6/5 19:51
 * @UpdateAuthor:
 * @UpdateDate:
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class StaticDeadLockMain extends Thread {
    private char flag;
    public StaticDeadLockMain(char flag){
        this.flag = flag;
    }
    @Override
    public void run(){
        try{
            Class.forName("Thread.deadlock.Static" + flag);
        } catch (ClassNotFoundException e){

        }
    }

    public static void main(String[] args) {
        StaticDeadLockMain a = new StaticDeadLockMain('A');
        StaticDeadLockMain b = new StaticDeadLockMain('B');
        a.start();
        b.start();
    }
}

class StaticA{
    static{
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e){

        }
        try {
            Class.forName("Thread.deadlock.StaticB");
        }catch (ClassNotFoundException e){

        }
        System.out.println("StaticA is ok");
    }
}

class StaticB{
    static{
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e){

        }
        try {
            Class.forName("Thread.deadlock.StaticA");
        }catch (ClassNotFoundException e){

        }
        System.out.println("StaticB is ok");
    }
}
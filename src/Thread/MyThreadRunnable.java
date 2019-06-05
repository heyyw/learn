package Thread;

/**
 * @Desc: 描述
 * @Author: Heyyw
 * @CreateDate: 2018/11/3 10:14
 * @UpdateAuthor:
 * @UpdateDate:
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class MyThreadRunnable extends Object implements Runnable {
    private int ticket = 10;
    @Override
    public void run() {
        for(int i = 0; i < 20; i++){
            if(this.ticket > 0){
                System.out.println(Thread.currentThread() + " sail: ticket" + this.ticket--);
            }
        }
    }
}

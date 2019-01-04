package thread;

/**
 * @Desc: 描述
 * @Author: Heyyw
 * @CreateDate: 2018/11/3 10:06
 * @UpdateAuthor:
 * @UpdateDate:
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class MyThread extends Thread {
    private int ticket = 10;
    public void run(){
        for(int i = 0; i < 20; i++){
            if(this.ticket > 0){
                System.out.println(this.getName() + " sail: ticket" + this.ticket--);
            }
        }
    }
}

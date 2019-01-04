package ohter;

/**
 * @Desc: 描述
 * @Author: Heyyw
 * @CreateDate: 2018/11/11 21:29
 * @UpdateAuthor:
 * @UpdateDate:
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class Business {
    Boolean flag = true;
    public synchronized void main() {
        if(flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for(int i = 0; i < 100; i++){
            System.out.println("main loop = " + i);
        }
        flag = true;
        this.notify();
    }

    public synchronized void sub() {
        if(!flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for(int i = 0; i < 10; i++) {
            System.out.println("sub loop = " + i);
        }
        flag = false;
        this.notify();
    }
}

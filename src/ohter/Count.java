package ohter;

/**
 * @Desc: 描述
 * @Author: Heyyw
 * @CreateDate: 2018/11/3 10:34
 * @UpdateAuthor:
 * @UpdateDate:
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class Count {
    public void sysMethod() {
        synchronized (this) {
            try {
                double sum = 0;
                for(int i = 0; i < 100000000; i++){
                    sum += i;
                    //Thread.sleep(10);
                    //System.out.println(Thread.currentThread().getName() + " synMethod loop " + i);
                }
            } catch (Exception ie) {

            }
        }
    }

    public void nonSynMethod() {
        try {
            double sum = 0;
             for (int i = 0; i < 50000000; i++) {
                 sum += i;
                     //Thread.sleep(10);
                     //System.out.println(Thread.currentThread().getName() + " nonSynMethod loop " + i);
                 }
            } catch (Exception ie) {
            }
    }
}

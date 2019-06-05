package Thread.provideconsume;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc: 描述
 * @Author: Heyyw
 * @CreateDate: 2019/3/28 13:44
 * @UpdateAuthor:
 * @UpdateDate:
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class consume implements Runnable{
    private List<Integer> list;
    public consume(List<Integer> list) {
        this.list = list;
    }
    @Override
    public void run() {
        while(true) {
            synchronized (list) {
                if(list.size() == 0){
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    list.notifyAll();
                }
                System.out.println(Thread.currentThread() + "consume" + list.get(list.size() - 1));
                list.remove(list.size() - 1);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

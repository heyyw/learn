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
public class provide implements Runnable{
    private List<Integer> list;
    public provide(List<Integer> list) {
        this.list = list;
    }
    @Override
    public void run() {
        while(true) {
            synchronized(list) {
                if(list.size() == 20) {
                    list.notifyAll();
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread() + "provide" + list.size());
                list.add(list.size());
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

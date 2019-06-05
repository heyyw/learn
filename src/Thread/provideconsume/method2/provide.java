package Thread.provideconsume.method2;

import java.util.concurrent.BlockingQueue;

/**
 * @Desc: 描述
 * @Author: Heyyw
 * @CreateDate: 2019/3/28 14:48
 * @UpdateAuthor:
 * @UpdateDate:
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class provide implements Runnable{
    private BlockingQueue<Integer> queue;

    public provide(BlockingQueue<Integer> queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            queue.offer(10);
            System.out.println("provide--" + queue.size());
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

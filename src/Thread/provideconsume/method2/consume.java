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
public class consume implements Runnable{
    private BlockingQueue<Integer> queue;

    public consume(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }
    @Override
    public void run() {
        while (true) {
            try {
                int i = queue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("consume--" + queue.size());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

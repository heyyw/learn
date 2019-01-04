import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.util.concurrent.Executors.newFixedThreadPool;

/**
 * @Desc: 线程池
 * @Author: Heyyw
 * @CreateDate: 2018/11/13 9:38
 * @UpdateAuthor:
 * @UpdateDate:
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class threadpool {
    public static void main(String[] args) {
       ExecutorService threadPool =  Executors.newFixedThreadPool(3);
       for(int j = 0; j < 10; j++) {
           threadPool.execute(new Runnable() {
               @Override
               public void run() {
                   for(int i = 0; i < 10; i++) {
                       try {
                           Thread.sleep(50);
                       } catch (InterruptedException e) {
                           e.printStackTrace();
                       }
                       System.out.println(Thread.currentThread().getName() + " loop " + i);
                   }
               }
           });
       }
        System.out.println("done");
       threadPool.shutdown();
    }
}

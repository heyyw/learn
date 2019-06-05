package Thread.provideconsume.method2;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @Desc: 描述
 * @Author: Heyyw
 * @CreateDate: 2019/3/28 14:47
 * @UpdateAuthor:
 * @UpdateDate:
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class product {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);

        new Thread(new provide(queue)).start();
        new Thread(new consume(queue)).start();
        new Thread(new consume(queue)).start();
        new Thread(new consume(queue)).start();
    }


}

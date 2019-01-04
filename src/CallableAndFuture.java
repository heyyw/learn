import java.util.concurrent.*;

/**
 * @Desc: 描述
 * @Author: Heyyw
 * @CreateDate: 2018/11/13 9:56
 * @UpdateAuthor:
 * @UpdateDate:
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class CallableAndFuture {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newSingleThreadExecutor();
        Future<String> future =
        threadPool.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "hello";
            }
        });

        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}

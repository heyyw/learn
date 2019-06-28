package Advance.Cache;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * java类简单作用描述
 *
 * @Package: Advance.Cache
 * @Author: heyyw
 * @CreateDate: 2019/6/12 3:27 PM
 * @UpdateUser: none
 * @UpdateDate: 2019/6/12 3:27 PM
 * @UpdateRemark: none
 * @Version: 1.0
 **/
public class CacheTest {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        String key = "id";
        System.out.println("-----不设置过期时间-------");
        Cache.put(key, 123);
        System.out.println(Cache.get(key));
        System.out.println(Cache.remove(key));
        System.out.println(Cache.get(key));

        System.out.println("------设置过期时间------");
        Cache.put(key,"123455", 1000);
        System.out.println(Cache.get(key));
        Thread.sleep(1500);
        System.out.println(Cache.get(key));

        /*******并发测试************/
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Future[] futures = new Future[10];
        {
            long start = System.currentTimeMillis();
            for (int i = 0; i < 10; i++) {
                futures[i] = executorService.submit(()->{
                    for (int j = 0; j < 100000; j++) {
                        Cache.put(Thread.currentThread().getId() + key + j, j , 300000);
                    }
                });
            }
            //等待全部线程执行完毕
            for(Future future : futures){
                future.get();
            }
            System.out.println("添加耗时：" + (System.currentTimeMillis() - start));
        }

        {
            long start = System.currentTimeMillis();
            for (int i = 0; i < 10; i++) {
                futures[i] = executorService.submit(()->{
                    for (int j = 0; j < 100000; j++) {
                        Cache.get(Thread.currentThread().getId() + key + j);
                    }
                });
            }
            //等待全部线程执行完毕
            for(Future future : futures){
                future.get();
            }
            System.out.println("查询耗时：" + (System.currentTimeMillis() - start));
        }

        System.out.println("当前容量：" + Cache.size());

    }
}

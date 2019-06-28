package Advance.Cache;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 自定义缓存类 hashmap + 定时器线程
 *
 * @Package: Advance.Cache
 * @Author: heyyw
 * @CreateDate: 2019/6/12 2:42 PM
 * @UpdateUser: none
 * @UpdateDate: 2019/6/12 2:42 PM
 * @UpdateRemark: none
 * @Version: 1.0
 **/
public class Cache {
    //键值对集合
    private static final Map<String, Entity> map = new HashMap<>();
    //定时器线程，用于清除过期缓存
    private static final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

    //添加缓存
    public synchronized static void put(String key, Object data){
        Cache.put(key,data,0);
    }


    /**
     *
     * @date 2019/6/12 3:15 PM
     * @author heyyw
     * @param key
     * @param data
     * @param expire 过期时间 0 表示无限期
     * @return void
     */
    public synchronized static void put(String key, Object data, long expire){
        Cache.remove(key);
        //set expire time
        if(expire > 0) {
            Future future = executor.schedule(new Runnable() {
                @Override
                public void run() {
                    synchronized(Cache.class) {
                        map.remove(key);
                    }
                }
            }, expire, TimeUnit.MILLISECONDS);
            map.put(key, new Entity(data, future));
        } else {
            map.put(key, new Entity(data, null));
        }
    }

    /**
     * 获取缓存值
     * @date 2019/6/12 3:17 PM
     * @author heyyw
     * @param key
     * @return java.lang.Object
     */
    public synchronized static Object get(String key){
        Entity entity = map.get(key);
        return entity == null ? null : entity.getValue();
    }

    /**
     * 读取缓存
     * @date 2019/6/12 3:18 PM
     * @author heyyw
     * @param key
     * @param clazz 值类型
     * @return T
     */
    public synchronized static <T> T get(String key, Class<T> clazz){
        return clazz.cast(Cache.get(key));
    }

    /**
     * 清除缓存
     * @date 2019/6/12 3:22 PM
     * @author heyyw
     * @param key
     * @return java.lang.Object
     */
    public synchronized static Object remove(String key){
        //清除缓存数据
        Entity entity = map.remove(key);
        if(entity == null)
            return null;
        //清除原键值对定时器
        Future future = entity.getFuture();
        if(future != null)
            future.cancel(true);
        return entity.getValue();
    }


    public synchronized static int size(){
        return map.size();
    }

    public static class Entity{
        //键值对的value
        private Object value;
        //定时器Future
        private Future future;

        public Entity(Object val, Future future){
            this.value = val;
            this.future = future;
        }

        public Object getValue() {
            return value;
        }

        public Future getFuture() {
            return future;
        }
    }
}

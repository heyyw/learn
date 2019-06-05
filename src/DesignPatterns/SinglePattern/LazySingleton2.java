package DesignPatterns.SinglePattern;

/**
 * @Desc: 双重检测法 线程安全
 * @Author: Heyyw
 * @CreateDate: 2019/1/15 14:11
 * @UpdateAuthor:
 * @UpdateDate:
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class LazySingleton2 {
    private volatile static LazySingleton2 unique;
    private LazySingleton2() {};
    public static LazySingleton2 getUniqueInstance() {
        if (unique == null) {
            synchronized (LazySingleton2.class) {
                if (unique == null)
                    unique = new LazySingleton2();
            }
        }
        return unique;
    }
}

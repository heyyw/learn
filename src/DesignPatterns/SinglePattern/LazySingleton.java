package DesignPatterns.SinglePattern;

/**
 * @Desc: 懒汉模式，非线程安全
 * @Author: Heyyw
 * @CreateDate: 2019/1/15 14:05
 * @UpdateAuthor:
 * @UpdateDate:
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class LazySingleton {
    private LazySingleton() {};
    private static LazySingleton unique = null;
    public static LazySingleton getUniqueInstance() {
        if (unique == null){
            unique = new LazySingleton();
        }
        return unique;
    }
}

package DesignPatterns.SinglePattern;

/**
 * @Desc: 饿汉模式，线程安全
 * @Author: Heyyw
 * @CreateDate: 2019/1/15 14:00
 * @UpdateAuthor:
 * @UpdateDate:
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class HungrySingleton {
    private HungrySingleton(){};
    private static HungrySingleton unique = new HungrySingleton();
    public static HungrySingleton getUniqueInstance(){
        return unique;
    }
}

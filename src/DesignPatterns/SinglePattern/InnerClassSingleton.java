package DesignPatterns.SinglePattern;

/**
 * @Desc: 静态内部类
 * @Author: Heyyw
 * @CreateDate: 2019/1/15 14:14
 * @UpdateAuthor:
 * @UpdateDate:
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class InnerClassSingleton {
    private static class innerclass {
        public static final InnerClassSingleton unique = new InnerClassSingleton();
    }
    private InnerClassSingleton() {};
    public static final InnerClassSingleton getUniqueInstance() {
        return innerclass.unique;
    }
}

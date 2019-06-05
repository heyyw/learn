package DesignPatterns.FactoryPattern.StaticFactory;

/**
 * @Desc: 反射
 * @Author: Heyyw
 * @CreateDate: 2019/1/14 19:21
 * @UpdateAuthor:
 * @UpdateDate:
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class Factory2 {
    public static Object getClass(Class<? extends Shape> clazz) {
        Object obj = null;
        try {
            obj = Class.forName(clazz.getName()).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return obj;
    }
}

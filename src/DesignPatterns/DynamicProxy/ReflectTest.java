package DesignPatterns.DynamicProxy;

/**
 * @Desc: 描述
 * @Author: Heyyw
 * @CreateDate: 2019/3/8 16:41
 * @UpdateAuthor:
 * @UpdateDate:
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class ReflectTest {
    public static void main(String[] args) {
//        Fruit f = (Fruit) DynamicAgent.agent(Fruit.class, new Apple());
//        f.show();
        JdkProxy jdkProxy = new JdkProxy();
        Fruit f =(Fruit)jdkProxy.bind(new Apple());
        f.show();
    }
}

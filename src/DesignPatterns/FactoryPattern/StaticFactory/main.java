package DesignPatterns.FactoryPattern.StaticFactory;

/**
 * @Desc: 描述
 * @Author: Heyyw
 * @CreateDate: 2019/1/14 19:19
 * @UpdateAuthor:
 * @UpdateDate:
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class main {
    public static void main(String[] args) {
        Shape s = Factory.createShape("circle");
        s.Draw();
        Shape shape = (Shape) Factory2.getClass(DesignPatterns.FactoryPattern.StaticFactory.Circle.class);
        shape.Draw();
    }
}

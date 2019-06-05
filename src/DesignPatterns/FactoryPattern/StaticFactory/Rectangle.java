package DesignPatterns.FactoryPattern.StaticFactory;

/**
 * @Desc: 描述
 * @Author: Heyyw
 * @CreateDate: 2019/1/14 19:14
 * @UpdateAuthor:
 * @UpdateDate:
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class Rectangle implements Shape {
    public Rectangle() {
        System.out.println("rectangle");
    }
    @Override
    public void Draw() {
        System.out.println("draw rectangle");
    }
}

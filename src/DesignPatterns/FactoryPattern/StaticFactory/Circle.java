package DesignPatterns.FactoryPattern.StaticFactory;

/**
 * @Desc: 描述
 * @Author: Heyyw
 * @CreateDate: 2019/1/14 19:13
 * @UpdateAuthor:
 * @UpdateDate:
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class Circle implements Shape{
    public Circle() {
        System.out.println("circle");
    }
    @Override
    public void Draw() {
        System.out.println("draw circle");
    }
}

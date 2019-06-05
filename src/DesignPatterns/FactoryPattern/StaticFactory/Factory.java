package DesignPatterns.FactoryPattern.StaticFactory;

/**
 * @Desc: 描述
 * @Author: Heyyw
 * @CreateDate: 2019/1/14 19:16
 * @UpdateAuthor:
 * @UpdateDate:
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class Factory {
    public static Shape createShape(String type) {
        Shape shape;
        if (type.equals("circle")) {
            shape = new Circle();
        } else if (type.equals("rectangle")) {
            shape = new Rectangle();
        } else {
            shape = null;
        }
        return shape;
    }
}

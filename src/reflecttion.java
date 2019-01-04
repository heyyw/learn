/**
 * @Desc: 描述
 * @Author: Heyyw
 * @CreateDate: 2018/11/14 17:25
 * @UpdateAuthor:
 * @UpdateDate:
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
import ohter.test;

import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class reflecttion {
    public static void main(String[] args) {
        Class test = test.class;
        Field[] fields = test.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            System.out.println("field: " + fields[i].getName());
        }

        List<Object> result = new ArrayList<>();
        try {
            test instance = (test)test.newInstance();
            for (Field field : fields) {
                field.setAccessible(true);
                Object value = "haha";
                field.set(instance, value);
            }
            System.out.println(instance.getAge() + "   " +instance.getName());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }



    }
}

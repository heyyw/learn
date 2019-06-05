package Thread.ThreadPool;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Desc: 描述
 * @Author: Heyyw
 * @CreateDate: 2019/1/19 21:47
 * @UpdateAuthor:
 * @UpdateDate:
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class Main {

    private String getString() {
        return "test";
    }

    public static void main(String[] args) {
        String test = null;
        Main main = new Main();
        while (test != null || (test = main.getString())!= null) {
            System.out.println("test");
        }
    }
}

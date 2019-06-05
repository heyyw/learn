package Thread.provideconsume;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc: 描述
 * @Author: Heyyw
 * @CreateDate: 2019/3/28 13:43
 * @UpdateAuthor:
 * @UpdateDate:
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class product {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        provide p = new provide(list);
        consume c = new consume(list);
        Thread pp = new Thread(p);
        Thread cc = new Thread(c);
        Thread ppp = new Thread(p);
        Thread ccc = new Thread(c);
        pp.start();
        cc.start();
        ppp.start();
        ccc.start();
    }
}

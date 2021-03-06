package DesignPatterns.Oberseve;

import java.util.Observable;
import java.util.Observer;

/**
 * @Desc: 描述
 * @Author: Heyyw
 * @CreateDate: 2019/5/26 14:57
 * @UpdateAuthor:
 * @UpdateDate:
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class TaobaoObserver implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        String newProduct = (String) arg;
        System.out.println("发送新商品【" + newProduct + "】到淘宝商城" );
    }
}

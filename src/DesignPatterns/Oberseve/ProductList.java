package DesignPatterns.Oberseve;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * @Desc: 被观察者 商品列表 需要继承java.util.Observable 为单例
 * @Author: Heyyw
 * @CreateDate: 2019/5/26 14:51
 * @UpdateAuthor:
 * @UpdateDate:
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class ProductList extends Observable{
    public ArrayList<String> productList = null;
    private static ProductList instance;
    private ProductList(){
        this.productList = new ArrayList<>();
    }

    public static ProductList getInstance(){
        if(instance == null){
            instance = new ProductList();
        }
        return instance;
    }

    /**
    * @Description: 增加观察者
    * @param: [observer]
    * @return: void
    * @Author: heyyw
    * @Date: 2019/05/26 14:55
    */
    public void addProductListObserver(Observer observer){
        this.addObserver(observer);
    }

    /**
    * @Description: 增加商品
    * @param: [newProduct]
    * @return: void
    * @Author: heyyw
    * @Date: 2019/05/26 14:55
    */
    public void addProduct(String newProduct){
        this.productList.add(newProduct);
        this.setChanged(); //设置被观察对象发生变化
        this.notifyObservers(newProduct); //通知观察者
    }

    public static void main(String[] args) {
        ProductList productList = ProductList.getInstance();
        productList.addObserver(new JingdongObserver());
        productList.addObserver(new TaobaoObserver());
        productList.addProduct("Casio 手表");

    }
}

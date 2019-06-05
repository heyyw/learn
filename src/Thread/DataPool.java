package Thread;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Desc: 描述
 * @Author: 简易数据库连接池
 * @CreateDate: 2019/5/16 22:50
 * @UpdateAuthor:
 * @UpdateDate:
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class DataPool {
    private LinkedList<Connection> dataPool = new LinkedList<>();
    private ReentrantLock lock = new ReentrantLock();
    private Condition c = lock.newCondition();
    private final int poolsize = 20;
    private String url = "";
    private String user = "";
    private String pass = "";

    public DataPool(){

    }
    private Connection getConn(){
        Connection conn = null;
        lock.lock();
        try {
            while (dataPool.size() <= 0){
                try {
                    c.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (!dataPool.isEmpty())
                conn =  dataPool.removeFirst();
            return conn;
        } finally {
            lock.unlock();
        }
    }
    private void releaseConn(Connection conn){
        lock.lock();
        try {
            dataPool.add(conn);
            c.signal();
        }finally {
            lock.unlock();
        }
    }

}

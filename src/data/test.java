package data;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @Desc: 描述
 * @Author: Heyyw
 * @CreateDate: 2019/3/7 16:33
 * @UpdateAuthor:
 * @UpdateDate:
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class test {
    public static void main(String[] args) {
//        Solution s = new Solution();
//        double test = s.Power(-2, -8);
//        System.out.println(test);

//        Bitmap bitmap = new Bitmap();
//        bitmap.addValue(14);
//        boolean exist = bitmap.exist(14);
//        System.out.println(exist);
//        bitmap.addValue(1);
//        boolean exist1 = bitmap.exist(1);
//        System.out.println(exist1);
        short i = 10;
        i >>>= 1;
        String c = Integer.toBinaryString(i);
        System.out.println(c);
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        System.out.println(jedis.ping());
        Transaction transaction = jedis.multi();
        transaction.set("k1", "k1");
        transaction.set("k2", "k2");
        transaction.exec();
        LinkedList<Integer> list = new LinkedList<>();
        list.add(0,1);
        list.poll();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    }
}

class Solution {
    public double Power(double base, int exponent) {
        int n = 0;
        if (exponent < 0)
            n = 0 - exponent;
        else if (exponent == 0)
            return 1;
        else
            n = exponent;
        double res = PowerDivide(base, exponent);
        if (exponent < 0)
            return 1 / res;
        else
            return res;
    }
    public double PowerDivide(double base, int n) {
        if (n == 1)
            return base;
        double temp = 0;
        if (n % 2 == 0) {
            temp = PowerDivide(base, n / 2);
            return temp * temp;
        } else {
            temp = PowerDivide(base, (n + 1) / 2);
            return temp * temp / base;
        }
    }
}
package ohter;

import statistic.DelayItem;

import java.sql.Timestamp;
import java.util.Map;
import java.util.TreeMap;

/**
 * @Desc: 描述
 * @Author: Heyyw
 * @CreateDate: 2018/11/23 11:31
 * @UpdateAuthor:
 * @UpdateDate:
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class TestMapModify {
    public static void main(String[] args) {
//        double l1 = 1234.4;
//        double l2 = 343545.5;
//        Map<Double,Double> summaryResult = new TreeMap<Double, Double>();
//        summaryResult.put(l1, l2);
//        //l1 = 334.4;
//        l2 = 3344.5;
//        double d = summaryResult.get(l1);
//        d = 1111111.1;
//        for (Object obj : summaryResult.values()) {
//            System.out.println(obj);
//        }
        Long time = Timestamp.valueOf("2016-03-30 09:25:26.568").getTime();
        DelayItem delayItem = new DelayItem(time);
        System.out.println("origin ----" + time);
        delayItem.getTotalDelay().addAndGet(123l);
        Long l = 121l;
        final Map<Long, DelayItem> summaryResult;
        summaryResult = new TreeMap<Long, DelayItem>();
        summaryResult.put(l,delayItem);


        delayItem.getTotalDelay().addAndGet(123l);

//        DelayItem ndelayItem = summaryResult.get(l);
//        ndelayItem.getTotalDelay().addAndGet(123l);
//        System.out.println("modify ----" + ndelayItem.getTimeStamp());
//        System.out.println(ndelayItem.getTotalDelay());

        System.out.println(summaryResult.get(l).getTotalDelay());

    }
}

package data;

/**
 * @Desc: 描述
 * @Author: Heyyw
 * @CreateDate: 2019/3/17 20:16
 * @UpdateAuthor:
 * @UpdateDate:
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class Bitmap {
    private static final int N = 10000000;
    private int[] bitmap = new int[N / 32 + 1];

    public void addValue(int value) {
        int n = value / 32;
        bitmap[n] |= 1 << (value % 32);
    }

    public boolean exist(int value) {
        int row = value / 32;
        int n =  (bitmap[row] & (1 << (value % 32))) ;
        return n != 1;
    }
}

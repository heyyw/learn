import java.util.HashMap;
import java.util.Map;

/**
 * @Desc: 描述
 * @Author: Heyyw
 * @CreateDate: 2019/5/28 21:54
 * @UpdateAuthor:
 * @UpdateDate:
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class test {
    Map<String, Integer> memo;
    int x;
    public int leastOpsExpressTarget(int x, int target) {
        memo = new HashMap();
        this.x = x;
        return dp(0, target) - 1;
    }

    public int dp(int i, int target) {
        String code = "" + i + "#" + target;
        if (memo.containsKey(code))
            return memo.get(code);

        int ans;
        if (target == 0) {
            ans = 0;
        } else if (target == 1) {
            ans = cost(i);
        } else {
            int t = target / x;
            int r = target % x;
            ans = Math.min(r * cost(i) + dp(i+1, t),
                    (x-r) * cost(i) + dp(i+1, t+1));
        }

        memo.put(code, ans);
        return ans;
    }

    public int cost(int x) {
        return x > 0 ? x : 2;
    }

    public static void main(String[] args) {
        test test = new test();
        test.leastOpsExpressTarget(2,125046);
    }
}

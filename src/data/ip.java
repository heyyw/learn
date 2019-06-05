package data;

/**
 * @Desc: 描述
 * @Author: Heyyw
 * @CreateDate: 2019/5/26 10:54
 * @UpdateAuthor:
 * @UpdateDate:
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class ip {
    public static void main(String[] args) {
        String ip = "192.168.1.204";
        String[] strs = ip.split("\\.");
        int ipint = 0;
        for (int i = 0; i < 4; i++) {
            ipint = ipint << 8;
            System.out.println(Integer.toBinaryString(ipint));
            ipint = ipint | Integer.parseInt(strs[i]);
            System.out.println(Integer.toBinaryString(ipint));
        }
        String ipbinary = Integer.toBinaryString(ipint);
        System.out.println(ipbinary);
    }
}

package IO.BIO;

import java.io.*;
import java.net.Socket;

/**
 * @Desc: 描述
 * @Author: Heyyw
 * @CreateDate: 2019/1/18 15:31
 * @UpdateAuthor:
 * @UpdateDate:
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class Client {
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Socket client = new Socket("localhost", 10086);
                        OutputStream os = client.getOutputStream();
                        PrintWriter pw = new PrintWriter(os);
                        pw.write("hello, server");
                        pw.flush();
                        client.shutdownInput();

                        InputStream is = client.getInputStream();
                        InputStreamReader isr = new InputStreamReader(is);
                        BufferedReader br = new BufferedReader(isr);
                        String temp = null;
                        while ((temp = br.readLine()) != null) {
                            System.out.println("接收到服务器发来消息" + temp);
                        }
                        br.close();
                        isr.close();
                        is.close();
                        pw.close();
                        os.close();
                        client.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}

package IO.BIO;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Desc: BIO服务端
 * @Author: Heyyw
 * @CreateDate: 2019/1/18 15:23
 * @UpdateAuthor:
 * @UpdateDate:
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(10086);
        System.out.println("等待客户端连接");
        while (true) {
            Socket socket = server.accept();
            new Thread().start();
        }
    }
}

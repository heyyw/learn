package IO.BIO;

import java.io.*;
import java.net.Socket;

/**
 * @Desc: 描述
 * @Author: Heyyw
 * @CreateDate: 2019/1/18 15:25
 * @UpdateAuthor:
 * @UpdateDate:
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class SocketThread implements Runnable {
    private Socket socket;

    public SocketThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String temp = null;
            while ((temp = br.readLine()) != null) {
                System.out.println("接收到端口号为" + socket.getPort() + "的客户端发来的数据" + temp);
            }
            socket.shutdownInput();
            OutputStream os = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(os);
            pw.write("hello,client");
            pw.flush();

            pw.close();
            os.close();
            br.close();
            isr.close();
            is.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

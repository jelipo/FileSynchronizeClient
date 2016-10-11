package cao.mine.service;

import cao.mine.Listen.SocketListener;
import cao.mine.Listen.SocketTemp;
import cao.mine.init.Context;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.ExecutorService;

/**
 * Created by 10441 on 2016/10/9.
 */
public class SendTestMsg implements ButtonRun {
    private Socket socket;
    private ExecutorService executorService;//软件全局线程池

    public SendTestMsg(Context context) {
        this.socket = context.getSocket();
        this.executorService = context.getThreadPool();
    }

    public void go() {
        try {
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
            printWriter.println("我是客户端" + 1);
            printWriter.flush();
            SocketTemp temp=new SocketTemp();
            temp.setSocket(socket);
            temp.setTime(5000);
            executorService.execute(new SocketListener(temp));//开启监听线程，监听此连接超过5秒阻塞时自动关闭连接
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String str = in.readLine();
            temp.setLock(false); //执行readline完成后，释放锁，子线程关闭
            if (str == null) {
                System.out.print("服务器返回空，可能断开socket连接");
                socket.close();
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }


}

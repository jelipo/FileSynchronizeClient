package cao.mine.service;

import cao.mine.Listen.SocketListener;
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
    private ExecutorService executorService;
    private int lock = 1;

    public SendTestMsg(Context context) {
        this.socket = context.getSocket();
        this.executorService = context.getThreadPool();

    }

    public void run() {
        long a = System.currentTimeMillis();
        try {
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
            printWriter.println("我是客户端" + 1);
            printWriter.flush();
            executorService.execute(listen());
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String str = in.readLine();
            lock = 0;
            if (str == null) {
                System.out.print("服务器返回空，可能断开socket连接");
            }
            System.out.println(str);
            System.out.println("执行耗时 : " + (System.currentTimeMillis() - a) / 1000f + " 秒 ");
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    private Runnable listen() {
        return new Runnable() {
            @Override
            public void run() {
                try {
                    int time = 5000;
                    while (time >= 0) {

                        if (lock == 0) {
                            break;
                        }
                        Thread.sleep(1000);

                        time = time - 1000;
                    }
                    System.out.println("1");
                    if (lock == 1) {
                        System.out.println("2");
                        SwingUtilities.invokeLater(new Runnable() {
                            public void run() {
                                JOptionPane.showMessageDialog(null, "DDD");
                            }
                        });
                        socket.close();
                    }
                    System.out.println("3");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
    }
}

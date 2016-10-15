package cao.mine.service;

import cao.mine.Listen.SocketListener;
import cao.mine.Listen.SocketTemp;
import cao.mine.init.Context;
import cao.mine.service.sendsocket.SendSocket;
import com.alibaba.fastjson.JSONObject;

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
    private ExecutorService executorService;//软件全局线程池
    private Context context;

    public SendTestMsg(Context context) {
        this.context=context;
        this.executorService = context.getThreadPool();
    }

    public void go() {
        JSONObject json=new JSONObject();
        json.put("flag","msg");
        json.put("msg","你好，我是客户端");
        SendSocket sendSocket=new SendSocket(context,json,5000);
        try {
            System.out.println(sendSocket.getResult());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

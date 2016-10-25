package cao.mine.service;

import cao.mine.MySocket.core.SendSocket;
import cao.mine.MySocket.file.SendSocketFile;
import cao.mine.MySocket.msg.SendSocketMsg;
import cao.mine.init.Context;
import com.alibaba.fastjson.JSONObject;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;

/**
 * Created by 10441 on 2016/10/9.
 */
public class SendTestMsg implements ButtonRun {
    private ExecutorService executorService;//软件全局线程池
    private Context context;

    public SendTestMsg(Context context) {
        this.context = context;
        this.executorService = context.getThreadPool();
    }

    public void go() {

        JSONObject json = new JSONObject();
        json.put("msg", "getFileJson");
        json.put("path","C:/Users/10441/Desktop");
        SendSocketMsg sendSocketMsg=new SendSocketMsg(context,json);
        try {
            System.out.println(sendSocketMsg.getResult());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

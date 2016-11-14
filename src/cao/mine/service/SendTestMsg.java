package cao.mine.service;

import cao.mine.MySocket.file.SendSocketFile;
import cao.mine.MySocket.msg.SendSocketMsg;
import cao.mine.file.FileTool;
import cao.mine.file.compare.FileCompare;
import cao.mine.init.Context;
import com.alibaba.fastjson.JSONObject;

import java.io.IOException;
import java.util.Iterator;
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
        String serverPath="C:/Users/10441/Desktop/Work";
        JSONObject json = new JSONObject();
        json.put("msg", "getFileJson");
        json.put("path",serverPath);
        SendSocketMsg sendSocketMsg=new SendSocketMsg(context,json);
        try {

            JSONObject serverJson=sendSocketMsg.getResult().getJSONObject("data");
            JSONObject clientJson = new FileTool("C:/Users\\10441\\Desktop\\Work1").getFileStructure();
            JSONObject compareJson=new FileCompare().compare(serverJson, clientJson);
            Iterator<String> it=compareJson.getJSONObject("neddToDel").keySet().iterator();
            List<JSONObject> fileList=new LinkedList<>();
            while (it.hasNext()){
                String filename=it.next();
                JSONObject singleFileMsg=compareJson.getJSONObject(filename);
                singleFileMsg.put("filename",filename);
                fileList.add(singleFileMsg);
            }
            SendSocketFile sendSocketFile=new SendSocketFile(context,fileList,serverPath,"neddToDel");
            JSONObject result=sendSocketFile.getResult();
            System.out.println(result);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

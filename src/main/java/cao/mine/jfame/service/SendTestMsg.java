package cao.mine.jfame.service;

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
    private String serverPath;
    private String clientPath;
    public SendTestMsg(Context context,String serverPath,String clientPath) {
        this.context = context;
        this.executorService = context.getThreadPool();
        this.serverPath=serverPath;
        this.clientPath=clientPath;
    }

    public void go() {
        JSONObject json = new JSONObject();
        json.put("msg", "getFileJson");
        json.put("path",serverPath);
        SendSocketMsg sendSocketMsg=new SendSocketMsg(context,json);
        try {
            JSONObject serverJson=sendSocketMsg.getResult().getJSONObject("data");
            JSONObject clientJson = new FileTool(clientPath).getFileStructure();
            JSONObject compareJson=new FileCompare().compare(serverJson, clientJson);
            System.out.println(compareJson);
            JSONObject needToDel=compareJson.getJSONObject("needToDel");
            JSONObject needToReplace=compareJson.getJSONObject("needToReplace");
            JSONObject needToAdd=compareJson.getJSONObject("needToAdd");
            send(needToDel,"needToDel");
            send(needToReplace,"needToReplace");
            send(needToAdd,"needToAdd");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private void send(JSONObject needToDoList,String needToDo) throws IOException {
        Iterator<String> it=needToDoList.keySet().iterator();
        System.out.println(needToDoList);
        List<JSONObject> fileList=new LinkedList<>();
        while (it.hasNext()){
            String filename=it.next();
            JSONObject singleFileMsg=needToDoList.getJSONObject(filename);
            if (needToDoList.getJSONObject(filename).getInteger("isFile")==1){
                singleFileMsg.put("filename",filename);
            }else{
                singleFileMsg.put("filename","/");
            }
            fileList.add(singleFileMsg);
        }
        SendSocketFile sendSocketFile=new SendSocketFile(context,fileList,serverPath,clientPath,needToDo);
        JSONObject result=sendSocketFile.getResult();
        System.out.println(result.get("msg"));
    }

}

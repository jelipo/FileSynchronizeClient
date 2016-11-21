package cao.mine.jfame.service;

import cao.mine.MySocket.file.SendSocketFile;
import cao.mine.init.Context;
import cao.mine.jfame.Frame.CompareFrame;
import com.alibaba.fastjson.JSONObject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by 10441 on 2016/11/20.
 */
public class CompareService {

    public ActionListener sendDel(CompareFrame compareFrame){
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Context context=compareFrame.context;
                try {
                    JSONObject result=send(compareFrame.compareJson.getJSONObject("needToDel"),"needToDel",context);
                    System.out.println(result.get("msg"));
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        };
    }
    public ActionListener sendReplace(CompareFrame compareFrame){
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Context context=compareFrame.context;
                try {
                    JSONObject result=send(compareFrame.compareJson.getJSONObject("needToReplace"),"needToAdd",context);
                    System.out.println(result.get("msg"));
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        };
    }
    public ActionListener sendAdd(CompareFrame compareFrame){
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Context context=compareFrame.context;
                try {
                    JSONObject result=send(compareFrame.compareJson.getJSONObject("needToAdd"),"needToAdd",context);
                    System.out.println(result.get("msg"));
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        };
    }
    private JSONObject send(JSONObject needToDoList, String needToDo, Context context) throws IOException {
        Iterator<String> it=needToDoList.keySet().iterator();
        System.out.println(needToDoList);
        List<JSONObject> fileList=new LinkedList<>();
        while (it.hasNext()){
            String filename=it.next();
            JSONObject singleFileMsg=needToDoList.getJSONObject(filename);
            if (needToDoList.getJSONObject(filename).getInteger("isFile")==1){
                singleFileMsg.put("filename",cleanFilename(filename));
            }else{
                singleFileMsg.put("filename","/");
            }
            fileList.add(singleFileMsg);
        }
        JSONObject initText=context.getInitText();
        SendSocketFile sendSocketFile=new SendSocketFile(context,fileList,initText.getString("lastServerPath"),initText.getString("lastClientPath"),needToDo);
        return sendSocketFile.getResult();

    }
    private String cleanFilename(String filename){
        return filename.split("/")[0];
    }
}

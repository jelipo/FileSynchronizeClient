package cao.mine.jfame.service;

import cao.mine.MySocket.msg.SendSocketMsg;
import cao.mine.file.FileTool;
import cao.mine.file.compare.FileCompare;
import cao.mine.init.Context;
import cao.mine.jfame.Frame.CompareFrame;
import cao.mine.jfame.Frame.MainFrame;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by 10441 on 2016/11/20.
 */
public class MainService {


    public ActionListener sendCompareRequest(MainFrame mainFrame) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               doSome(mainFrame);
            }
        };
    }



    private void linkAgain(IOException e1,MainFrame mainFrame){
        e1.printStackTrace();
        Object[] options = {"重新连接", "取消"};
        int m = JOptionPane.showOptionDialog(null, "socket已断开！是否重新连接！", "连接断开", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        if (m==0){
            Context context=mainFrame.context;
            Socket socket = null;
            try {
                socket = new Socket(context.getServerIp(), Integer.parseInt(context.getServerPort()));
                context.setSocket(socket);
            } catch (IOException e2) {
                System.out.println("服务器连接失败");
                e1.printStackTrace();
                JOptionPane.showMessageDialog(null, "连接失败！请检查网络或服务端！", "连接失败", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    public void doSome(MainFrame mainFrame){
        JSONObject json = new JSONObject();
        json.put("msg", "getFileJson");
        json.put("path", mainFrame.serverPathText.getText());
        SendSocketMsg sendSocketMsg = new SendSocketMsg(mainFrame.context, json);
        try {
            mainFrame.context.setConfText("lastServerPath",mainFrame.serverPathText.getText());
            mainFrame.context.setConfText("lastClientPath",mainFrame.clientPathText.getText());
            JSONObject serverJson = sendSocketMsg.getResult().getJSONObject("data");
            JSONObject clientJson = new FileTool(mainFrame.clientPathText.getText()).getFileStructure();
            JSONObject compareJson = new FileCompare().compare(serverJson, clientJson);
            System.out.println(compareJson);
            if (!mainFrame.isCompareFrameCreated){
                mainFrame.compareFrame=new CompareFrame(mainFrame.context,mainFrame);
                mainFrame.isCompareFrameCreated=true;
            }
            mainFrame.compareFrame.show(compareJson);
        } catch (IOException e1) {
            linkAgain(e1,mainFrame);
        }
    }
}

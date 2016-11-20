package cao.mine.jfame;

import cao.mine.init.Context;
import cao.mine.jfame.service.SendTestMsg;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by 10441 on 2016/10/9.
 */
public class MyButtonCtrl {

    private  Socket socket;
    private Context context;
    public MyButtonCtrl(Context context){
        this.context=context;
        this.socket=context.getSocket();
        if (this.socket.isClosed()){
            JOptionPane.showMessageDialog(null, "socket可能已经断开，正在尝试重新连接");
            Socket socket1= null;
            try {
                socket1 = new Socket(context.getInitText().getString("serveraddress"),context.getInitText().getInteger("serverport"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            context.setSocket(socket1);
        }
    }
    public ActionListener sendTest(){
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //String serverPath="/home/cao/桌面/server";
                String serverPath="C:/Users/10441/Desktop/server";
                String clientPath="C:/Users/10441/Desktop/client";
                new SendTestMsg(context,serverPath,clientPath).go();
            }
        };
    }

}

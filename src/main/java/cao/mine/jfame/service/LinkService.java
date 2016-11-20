package cao.mine.jfame.service;

import cao.mine.init.Context;
import cao.mine.jfame.Frame.LinkFrame;
import cao.mine.jfame.Frame.MainFrame;
import org.apache.commons.lang3.StringUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by 10441 on 2016/11/20.
 */
public class LinkService {

    public ActionListener startLink(LinkFrame link) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String serverIp = link.serverIpText.getText();
                String serverPort = link.serverPortText.getText();
                Context context = link.context;
                if (checkTextWorng(serverIp, serverPort)) {
                    System.out.println("开始连接服务器");
                    Socket socket = null;
                    try {
                        context.setConfText("serverIp",serverIp);
                        context.setConfText("serverPort",serverPort);
                        socket = new Socket(serverIp, Integer.parseInt(serverPort));
                        context.setSocket(socket);
                        link.hide();
                        MainFrame mainFrame=new MainFrame(context);
                        mainFrame.showme();
                    } catch (IOException e1) {
                        System.out.println("服务器连接失败");
                        e1.printStackTrace();
                        JOptionPane.showMessageDialog(null, "连接失败！请检查网络或服务端！", "连接失败", JOptionPane.ERROR_MESSAGE);
                    }

                }
            }
        };
    }

    private Boolean checkTextWorng(String serverIp, String serverPort) {
        if(!(serverIp.equals("localhost"))){
            String[] ipArray = serverIp.split("\\.");
            if (ipArray.length != 4 ||(!StringUtils.isNumeric(ipArray[0]))||(!StringUtils.isNumeric(ipArray[1]))||(!StringUtils.isNumeric(ipArray[2]))||(!StringUtils.isNumeric(ipArray[3]))) {
                JOptionPane.showMessageDialog(null, "IP地址输入有问题！", "输入错误", JOptionPane.WARNING_MESSAGE);
                return false;
            }
        }
        if (!StringUtils.isNumeric(serverPort)) {
            JOptionPane.showMessageDialog(null, "输入端口号必须为纯数字！", "输入错误", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }
}

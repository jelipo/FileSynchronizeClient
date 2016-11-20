package cao.mine.jfame.Frame;

import cao.mine.init.Context;
import cao.mine.jfame.service.MainService;
import com.alibaba.fastjson.JSONObject;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

public class MainFrame {
    private JFrame jf;
    private JLabel serverPathLabel, clientPathLabel;
    public JTextField serverPathText, clientPathText;
    private JButton compareButton;
    public Context context;
    private MainService mainService;
    public JButton deleteButton,replaceButton,addButton;
    public JSONObject needToDel,needToReplace,needToAdd;
    public CompareFrame compareFrame;
    public MainFrame(Context context) {
        this.jf = new JFrame("主界面 - 文件比对客户端");
        this.serverPathLabel = new JLabel("服务器路径:");
        this.clientPathLabel = new JLabel("客户端路径:");
        Object lastServerPath=context.getConfText("lastServerPath");
        this.serverPathText = new JTextField(lastServerPath==null?"":lastServerPath.toString());
        Object lastClientPath=context.getConfText("lastClientPath");
        this.clientPathText = new JTextField(lastClientPath==null?"":lastClientPath.toString());
        this.compareButton = new JButton("文件对比");
        this.deleteButton = new JButton("删除");
        this.replaceButton = new JButton("替换");
        this.addButton = new JButton("添加");
        this.context = context;
        mainService = new MainService();
    }

    private void init() {
        jf.setLayout(null);
        jf.add(serverPathLabel);
        jf.add(clientPathLabel);
        jf.add(serverPathText);
        jf.add(clientPathText);
        jf.add(compareButton);
        jf.add(deleteButton);
        jf.add(replaceButton);
        jf.add(addButton);
        serverPathLabel.setBounds(20, 42, 100, 30);
        serverPathText.setBounds(120, 50, 300, 20);
        clientPathLabel.setBounds(20, 94, 100, 30);
        clientPathText.setBounds(120, 100, 300, 20);
        compareButton.setBounds(100, 150, 100, 30);
        deleteButton.setBounds(50,200,70,30);
        replaceButton.setBounds(140,200,70,30);
        addButton.setBounds(230,200,70,30);
        deleteButton.setEnabled(false);
        replaceButton.setEnabled(false);
        addButton.setEnabled(false);
        compareButton.addActionListener(mainService.sendCompareRequest(this));
        deleteButton.addActionListener(mainService.send(context,needToDel,"needToDel"));
        replaceButton.addActionListener(mainService.send(context,needToReplace,"needToReplace"));
        addButton.addActionListener(mainService.send(context,needToAdd,"needToAdd"));
    }

    public void hide() {
        jf.setVisible(false);
    }


    public void showme() {
        init();
        jf.setVisible(true);
        jf.setSize(450, 400);
        jf.setResizable(false);
        jf.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    context.getSocket().close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                } finally {
                    System.exit(0);
                }
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
    }

}

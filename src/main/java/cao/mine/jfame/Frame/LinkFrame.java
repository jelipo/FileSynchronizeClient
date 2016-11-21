package cao.mine.jfame.Frame;

import cao.mine.init.Context;
import cao.mine.jfame.service.LinkService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.net.Socket;

public class LinkFrame{
    private JFrame jf;
    private JLabel serverIpLable, serverPortLable;
    private JButton startLinkButton;
    public Context context;
    public JTextField serverIpText,serverPortText;
    private LinkService linkService;
    public LinkFrame(Context context) {
        this.jf = new JFrame("连接 -  文件比对客户端");
        this.serverIpLable = new JLabel("服务器ip：");
        this.serverPortLable = new JLabel("服务器端口：");
        this.serverIpText=new JTextField(context.getServerIp());
        this.serverPortText=new JTextField(context.getServerPort());
        this.startLinkButton=new JButton("连接");
        this.context=context;
        this.linkService=new LinkService();
    }

    public void init() {
        jf.setLayout(null);
        jf.add(serverIpLable);
        jf.add(serverPortLable);
        jf.add(serverIpText);
        jf.add(serverPortText);
        jf.add(startLinkButton);
        serverIpLable.setBounds(50, 50, 100, 30);
        serverPortLable.setBounds(50, 100, 100, 30);
        serverIpText.setBounds(160, 50, 100, 25);
        serverPortText.setBounds(160, 100, 100, 25);
        startLinkButton.setBounds(110,150,80,30);
        startLinkButton.addActionListener(linkService.startLink(this));
    }
    public void hide(){
        jf.setVisible(false);
    }
    public void showme() {
        init();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        jf.setLocation((int)(screenSize.getWidth()/2)-150,(int)(screenSize.getHeight()/2)-150);
        jf.setVisible(true);
        jf.setSize(300, 300);
        jf.setResizable(false);
        jf.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    context.getSocket().close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }finally {
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

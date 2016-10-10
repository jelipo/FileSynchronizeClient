package cao.mine.jfame;

import cao.mine.init.Context;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainFrame {
    private JFrame jf;
    private JLabel startServer, send;
    private JButton startServerButton, sendButton;
    private Socket socket;
    private Context context;

    public MainFrame(Context context) {
        jf = new JFrame("文件比对客户端");
        startServer = new JLabel("运行");
        send = new JLabel("发送");
        startServerButton = new JButton("运行");
        sendButton = new JButton("");
        this.socket = context.getSocket();
        this.context=context;
    }

    public void init() {
        jf.setLayout(null);
        jf.add(send);
        jf.add(sendButton);
        jf.add(startServer);
        jf.add(startServerButton);

        startServer.setBounds(100, 100, 60, 30);
        send.setBounds(100, 200, 60, 30);
        startServerButton.setBounds(200, 100, 60, 30);
        sendButton.setBounds(200, 200, 60, 30);
        startServerButton.addActionListener(new MyButtonCtrl(context).sendTest());
        sendButton.addActionListener(new MyButtonCtrl(context).sendTest());
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
                    socket.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                System.exit(0);
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

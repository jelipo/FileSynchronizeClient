package cao.mine.Listen;

import javax.swing.*;
import java.net.Socket;

/**
 * Created by 10441 on 2016/10/9.
 */
public class SocketListener implements Runnable {

    private int time;
    private Boolean lock;
    private Socket socket;

    public SocketListener(SocketTemp temp){
        this.time=temp.getTime();
        this.lock=temp.getLock();
        this.socket=temp.getSocket();
    }

    @Override
    public void run() {
        try {
            int time =this.time;
            while (time >= 0) {
                if (lock) {
                    break;
                }
                Thread.sleep(1000);
                time = time - 1000;
            }
            if (lock) {
                showDialog();
                socket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void showDialog(){
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JOptionPane.showMessageDialog(null, "线程超过"+String.valueOf(time)+"毫秒没有相应，关闭scoket连接");
            }
        });
    }
}

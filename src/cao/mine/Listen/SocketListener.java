package cao.mine.Listen;

import javax.swing.*;
import java.net.Socket;

/**
 * Created by 10441 on 2016/10/9.
 */
public class SocketListener implements Runnable {

    private SocketTemp temp;

    public SocketListener(SocketTemp temp){
        this.temp=temp;
    }

    @Override
    public void run() {
        try {
            int time =temp.getTime();
            while (time >= 0) {
                if (!temp.getLock()) {
                    break;
                }
                Thread.sleep(1000);
                time = time - 1000;
            }
            if (temp.getLock()) {
                showDialog();
                temp.getSocket().close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void showDialog(){
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JOptionPane.showMessageDialog(null, "线程超过"+String.valueOf(temp.getTime())+"毫秒没有相应，关闭scoket连接");
            }
        });
    }
}

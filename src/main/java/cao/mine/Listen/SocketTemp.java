package cao.mine.Listen;

import java.net.Socket;

/**
 * Created by 10441 on 2016/10/11.
 */
public class SocketTemp {
    private int time;
    private Boolean lock=true;
    private Socket socket;
    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public Boolean getLock() {
        return lock;
    }

    public void setLock(Boolean lock) {
        this.lock = lock;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }
}

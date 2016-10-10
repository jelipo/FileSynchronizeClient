package cao.mine.Listen;

/**
 * Created by 10441 on 2016/10/9.
 */
public class SocketListener implements Runnable {

    private int time;
    private int lock;

    public SocketListener(int time,int lock){
        this.time=time;
        this.lock=lock;
    }

    @Override
    public void run() {

    }
}

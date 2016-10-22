package cao.mine.MySocket.core;

import cao.mine.Listen.SocketListener;
import cao.mine.Listen.SocketTemp;
import cao.mine.init.Context;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.ArrayUtils;
import sun.misc.BASE64Encoder;

import java.io.*;
import java.net.Socket;
import java.util.concurrent.ExecutorService;

/**
 * Created by 10441 on 2016/10/13.
 */
public class SendSocket {

    private Socket socket;
    private ExecutorService executorService;//软件全局线程池
    private int outTime;
    private byte[] byteStream;
    public SendSocket(Context context, int outTime,byte[] byteStream) {
        this.socket = context.getSocket();
        this.executorService = context.getThreadPool();
        this.outTime = outTime;
        this.byteStream=byteStream;
    }


    public JSONObject getResult() throws IOException {
        String msg = null;
//      PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
        String firstCut = "/0!F/";
        String headCut = "/0!H/";
        String endCut = "/0!E/";
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        byte[] bytes =
                ArrayUtils.addAll(ArrayUtils.addAll(ArrayUtils.addAll(firstCut.getBytes(), String.valueOf(byteStream.length).getBytes()), endCut.getBytes()),byteStream);
        out.write(bytes);
        SocketTemp temp = new SocketTemp();
        temp.setSocket(socket);
        temp.setTime(this.outTime);
        temp.setLock(true);
        executorService.execute(new SocketListener(temp));
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        msg = in.readLine();
        temp.setLock(false); //执行readline完成后，释放锁（其实是flag），子线程关闭
        if (msg == null) {
            System.out.println("服务器返回空，可能断开socket连接");
            socket.close();
        }

        return JSON.parseObject(msg);
    }




}

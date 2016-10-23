package cao.mine.MySocket.core;

import cao.mine.Listen.SocketListener;
import cao.mine.Listen.SocketTemp;
import cao.mine.init.Context;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.codec.binary.Base64;
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
    private byte[] dataStream;
    private JSONObject head;
    public SendSocket(Context context, int outTime,byte[] dataStream,JSONObject head) {
        this.socket = context.getSocket();
        this.executorService = context.getThreadPool();
        this.outTime = outTime;
        this.dataStream=dataStream;
        this.head=head;
    }


    public JSONObject getResult() throws IOException {
        String msg = null;
//      PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
        byte[] firstCut = "/0!F/".getBytes();
        byte[] headCut = "/0!H/".getBytes();
        byte[] endCut = "/0!E/".getBytes();
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        byte[] headByte=new Base64().encode(head.toString().getBytes());
        byte[] headAndDaTa=ArrayUtils.addAll(ArrayUtils.addAll(headByte,headCut),dataStream);

        byte[] socketFirst=ArrayUtils.addAll(ArrayUtils.addAll(firstCut,  String.valueOf(headAndDaTa.length).getBytes()), endCut);
        byte[] socketData=ArrayUtils.addAll(socketFirst,headAndDaTa);

        out.write(socketData);
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

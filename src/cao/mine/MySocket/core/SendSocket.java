package cao.mine.MySocket.core;

import cao.mine.Listen.SocketListener;
import cao.mine.Listen.SocketTemp;
import cao.mine.init.Context;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.ArrayUtils;


import java.io.*;
import java.net.Socket;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;

/**
 * Created by 10441 on 2016/10/13.
 */

/**
 * socket自定义协议说明
 * /0!F/  (JSON)head  /0!H/     data       /0!E/
 * \___dataSize___\
 * /0!F/,/0!H/,/0!E/均为自定义协议中的分隔符
 * head传来时为JSON格式，此类会向head中插入data的长度，为了避免传递时中文乱码的情况，传输之前，会对head进行base64编码
 */
public class SendSocket {

    private Socket socket;
    private ExecutorService executorService;//软件全局线程池
    private int outTime;
    private byte[] dataStream;
    private JSONObject head;
    private String firsFlag = "/0!F/";
    private String endFlag = "/0!E/";

    public SendSocket(Context context, int outTime, byte[] dataStream, JSONObject head) {
        this.socket = context.getSocket();
        this.executorService = context.getThreadPool();
        this.outTime = outTime;
        this.dataStream = dataStream;
        this.head = head;
    }


    public JSONObject getResult() throws IOException {
        int msg = 0;
        byte[] firstCut = "/0!F/".getBytes();
        byte[] headCut = "/0!H/".getBytes();
        byte[] endCut = "/0!E/".getBytes();
        byte[] dataAndEndCut = ArrayUtils.addAll(dataStream, endCut);
        head.put("dataSize", dataStream.length);
        byte[] headByte = Base64.encodeBase64(head.toString().getBytes());
        byte[] headAndCuts = ArrayUtils.addAll(ArrayUtils.addAll(firstCut, headByte), headCut);
        byte[] allBytes = ArrayUtils.addAll(headAndCuts, dataAndEndCut);
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        out.write(allBytes);
        SocketTemp temp = new SocketTemp();
        temp.setSocket(socket);
        temp.setTime(this.outTime);
        temp.setLock(true);
        executorService.execute(new SocketListener(temp));
        JSONObject json = runListener(socket);

        return json;
    }


    private JSONObject runListener(Socket socket) throws IOException {
        int r = 0;
        Boolean overFlag = false;
        BufferedInputStream in = new BufferedInputStream(socket.getInputStream());
        GetSocket getSocket = new GetSocket(firsFlag, endFlag, in, socket);
        JSONObject json = null;
        while (overFlag || r == -1) {
            json = getSocket.getResult();
            if (json.getBoolean("status")) {
                break;
            }
        }
        return json;
    }


}

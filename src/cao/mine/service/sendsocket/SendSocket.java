package cao.mine.service.sendsocket;

import cao.mine.Listen.SocketListener;
import cao.mine.Listen.SocketTemp;
import cao.mine.init.Context;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sun.deploy.util.ArrayUtil;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.ArrayUtils;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.*;
import java.net.Socket;
import java.util.concurrent.ExecutorService;

/**
 * Created by 10441 on 2016/10/13.
 */
public class SendSocket {
    private JSONObject sendMsg;
    private Socket socket;
    private ExecutorService executorService;//软件全局线程池
    private int outTime;

    public SendSocket(Context context, JSONObject sendMsg, int outTime) {
        this.socket = context.getSocket();
        this.sendMsg = sendMsg;
        this.executorService = context.getThreadPool();
        this.executorService = context.getThreadPool();
        this.outTime = outTime;
    }


    public JSONObject getResult() throws IOException {
        String msg = null;
        try {
//            PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
            String a = new String(new BASE64Encoder().encode(sendMsg.toString().getBytes("utf-8")));
            JSONObject headJson = new JSONObject();
            headJson.put("bodyLength", a.length());
            headJson.put("flag", "msg");
            long timeA=System.currentTimeMillis();
            byte[] buffer = getBytes("F:/360安全浏览器下载/BaiduNetdisk_5.5.0.exe");
            String firstCut = "/0!F/";
            String headCut = "/0!H/";
            String endCut = "/0!E/";
            DataOutputStream out= new DataOutputStream(socket.getOutputStream());
            byte[] bytes=
                    ArrayUtils.addAll(ArrayUtils.addAll(ArrayUtils.addAll(firstCut.getBytes(),String.valueOf(buffer.length).getBytes()),endCut.getBytes()),buffer);
            out.write(bytes);
            System.out.println(System.currentTimeMillis()-timeA);
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
        } catch (IOException e1) {
            e1.printStackTrace();
            System.out.println("出现异常，连接可能已断开");
            socket.close();
        }
        return JSON.parseObject(msg);
    }

    private byte[] getBytes(String filePath) {
        byte[] buffer = null;
        try {
            File file = new File(filePath);
            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream bos = new ByteArrayOutputStream(1000);
            byte[] b = new byte[1000];
            int n;
            while ((n = fis.read(b)) != -1) {
                bos.write(b, 0, n);
            }
            fis.close();
            bos.close();
            buffer = bos.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer;
    }


}

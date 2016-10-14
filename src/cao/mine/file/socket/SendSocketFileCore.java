package cao.mine.file.socket;

import cao.mine.init.Context;
import cao.mine.service.sendsocket.SendSocket;
import com.alibaba.fastjson.JSONObject;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * Created by 10441 on 2016/10/13.
 */
public class SendSocketFileCore {
    private Context context;
    private String path;
    private Socket socket;
    private String filename;
    private File file;
    private long fileLength;
    private final static int ADD=1;
    private final static int DEL=2;
    private final static int REPLACE=3;
    private int need;
    public SendSocketFileCore(Context context, String filePath,int need){
        this.socket=context.getSocket();
        this.path=filePath;
        this.file = new File(filePath);
        this.filename=file.getName();
        this.fileLength=file.length();
        this.context=context;
    }
    public void send() throws IOException {
        JSONObject hello=new JSONObject();
        hello.put("flag","file");
        hello.put("filename",filename);
        hello.put("filelength",fileLength);
        hello.put("need",need);
        SendSocket sendSocket=new SendSocket(context,hello,5000);
        System.out.println(sendSocket.getResult());

        int length = 0;
        double sumL = 0 ;
        byte[] sendBytes = null;
        DataOutputStream dos = null;
        FileInputStream fis = null;
        boolean bool = false;
        try {
             //要传输的文件路径
            dos = new DataOutputStream(this.socket.getOutputStream());
            fis = new FileInputStream(file);
            sendBytes = new byte[1024];
            while ((length = fis.read(sendBytes, 0, sendBytes.length)) > 0) {
                sumL += length;
                System.out.println("已传输："+((sumL/fileLength)*100)+"%");
                dos.write(sendBytes, 0, length);
                dos.flush();
            }
            if(sumL==fileLength){
                bool = true;
            }
        }catch (Exception e) {
            System.out.println("客户端文件传输异常");
            bool = false;
            e.printStackTrace();
        } finally{
            if (dos != null)
                dos.close();
            if (fis != null)
                fis.close();
            if (socket != null)
                socket.close();
        }
        System.out.println(bool?"成功":"失败");
    }
}


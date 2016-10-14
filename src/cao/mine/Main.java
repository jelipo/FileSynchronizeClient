package cao.mine;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import cao.mine.file.compare.FileCompare;
import cao.mine.file.FileTool;
import cao.mine.init.Context;
import cao.mine.jfame.MainFrame;
import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.net.Socket;

import static java.lang.System.currentTimeMillis;

public class Main {
    public static final String address = "localhost";
    public static final int port = 12345;


    public static void main(String[] args) throws IOException {
        xianShi();

    }
    private void duiBi(){
        long a= currentTimeMillis();
        JSONObject clientJson=new FileTool("C:/Users\\10441\\Desktop\\Work").getFileStructure();
        JSONObject serverJson=new FileTool("C:\\Users\\10441\\Desktop\\Work1").getFileStructure();
//        JSONObject clientJson=new FileTool("G:\\GOT").getFileStructure();
//        JSONObject serverJson=new FileTool("G:\\GOT").getFileStructure();

        System.out.println(new FileCompare().compare(serverJson,clientJson));
        System.out.println("消耗时间："+ (currentTimeMillis()-a)+"毫秒");
    }
    private static void xianShi() throws IOException {
                System.out.println("客户端启动...初始化");
        Context context=new Context();
        System.out.println("开始连接服务器");
        Socket socket = new Socket(context.getInitText().getString("serveraddress"), context.getInitText().getInteger("serverport"));
        context.setSocket(socket);
        MainFrame frame=new MainFrame(context);
        context.setMainFrame(frame);
        frame.showme();
    }



}

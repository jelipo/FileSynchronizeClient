package cao.mine;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import cao.mine.file.FileCompare;
import cao.mine.file.FileTool;
import com.alibaba.fastjson.JSONObject;

import java.io.IOException;

import static java.lang.System.currentTimeMillis;

public class Main {
    public static final String address = "localhost";
    public static final int port = 12345;


    public static void main(String[] args) throws IOException {
//        System.out.println("客户端启动...初始化");
//        Context context=new Context();
//        System.out.println("开始连接服务器");
//        Socket socket = new Socket(context.getInitText().getString("serveraddress"), context.getInitText().getInteger("serverport"));
//        context.setSocket(socket);
//        MainFrame frame=new MainFrame(context);
//        context.setMainFrame(frame);
//        frame.showme();

        //System.out.println(json.keySet().iterator().next());
//        isFile(ob);
//        System.out.println("执行耗时 : " + (System.currentTimeMillis() - a));
        long a= currentTimeMillis();
        JSONObject newJson=new FileTool("C:/Users\\10441\\Desktop\\Work/").getFileStructure();
        JSONObject oldJson=new FileTool("C:\\Users\\10441\\Desktop\\Work1").getFileStructure();

        System.out.println(new FileCompare().compare(oldJson,newJson));
        System.out.println("消耗时间："+ (currentTimeMillis()-a)+"毫秒");

    }



}

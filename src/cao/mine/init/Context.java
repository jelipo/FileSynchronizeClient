package cao.mine.init;

import cao.mine.jfame.MainFrame;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import javax.swing.*;
import java.io.File;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by 10441 on 2016/10/9.
 */
public class Context {
    private JSONObject initText;
    private ExecutorService executor;
    private Socket socket;
    private MainFrame frame;

    public  Context(){
        init();
    }
    private void init(){
        File file = new File("src/context.json");
        Scanner scanner = null;
        StringBuffer buffer = new StringBuffer();
        try {
            scanner = new Scanner(file, "utf-8");
            while (scanner.hasNextLine()) {
                buffer.append(scanner.nextLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print("配置文件没有找到");
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
        initText= JSON.parseObject(buffer.toString());
        executor= Executors.newCachedThreadPool();
    }
    public JSONObject getInitText(){
        return initText;
    }
    public ExecutorService getThreadPool(){
        return executor;
    }
    public void setSocket(Socket socket){
        this.socket=socket;
    }
    public Socket getSocket(){
        return this.socket;
    }
    public void setMainFrame(MainFrame frame){
        this.frame=frame;
    }
    public MainFrame getMainFrame(){
        return frame;
    }
}

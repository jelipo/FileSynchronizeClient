package cao.mine.init;

import cao.mine.Main;
import cao.mine.jfame.Frame.MainFrame;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.*;
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
    private File confFile;

    public Context() {
        init();
    }

    private void init() {
        this.initText = readConf();
        executor = Executors.newCachedThreadPool();
    }

    public JSONObject getInitText() {
        return this.initText;
    }

    public String getServerIp() {
        return this.initText.getString("serverIp");
    }

    public String getServerPort() {
        return this.initText.getString("serverPort");
    }

    public ExecutorService getThreadPool() {
        return executor;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public Socket getSocket() {
        return this.socket;
    }

    public void setMainFrame(MainFrame frame) {
        this.frame = frame;
    }

    public Object getConfText(String name) {
        return initText.get(name);
    }


    private JSONObject readConf() {
        JSONObject initText = new JSONObject();
        String jarFilePath = Main.class.getProtectionDomain().getCodeSource().getLocation().getFile();
        try {
            jarFilePath = java.net.URLDecoder.decode(jarFilePath, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        confFile = new File(new File(jarFilePath).getParent(), "client.json");
        if (confFile.exists()) {
            //File file = new File("context.json");
            Scanner scanner = null;
            StringBuffer buffer = new StringBuffer();
            try {
                scanner = new Scanner(confFile, "utf-8");
                while (scanner.hasNextLine()) {
                    buffer.append(scanner.nextLine());
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("配置文件没有找到");
            } finally {
                if (scanner != null) {
                    scanner.close();
                }
            }
            initText = JSON.parseObject(buffer.toString());

        } else {
            try {
                String jsonText = "{\"serverIp\":\"\",\"serverPort\":\"\"}";
                initText = JSON.parseObject(jsonText);
                confFile.createNewFile();
                OutputStreamWriter pw = null;//定义一个流
                pw = new OutputStreamWriter(new FileOutputStream(confFile), "UTF-8");//确认流的输出文件和编码格式，此过程创建了“test.txt”实例
                pw.write(jsonText);
                pw.close();//关闭流
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return initText;
    }

    public void setConfText(String name, String value) throws IOException {
        initText.put(name, value);
        OutputStreamWriter pw = null;//定义一个流
        pw = new OutputStreamWriter(new FileOutputStream(confFile), "UTF-8");//确认流的输出文件和编码格式，此过程创建了“test.txt”实例
        pw.write(initText.toString());
        pw.close();//关闭流
    }
}

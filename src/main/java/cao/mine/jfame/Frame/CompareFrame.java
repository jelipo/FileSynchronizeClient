package cao.mine.jfame.Frame;

import cao.mine.init.Context;
import cao.mine.jfame.service.MainService;
import com.alibaba.fastjson.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

public class CompareFrame {
    private JFrame jf;

    private JScrollPane scrollPane;
    public Context context;

    public CompareFrame(Context context) {
        this.jf = new JFrame("主界面 - 文件比对客户端");
        this.context=context;
        Object[][] playerInfo = {
                        {"阿呆", new Integer(66), new Integer(32), new Integer(98), new Boolean(false)},
                        {"阿呆", new Integer(82), new Integer(69), new Integer(128), new Boolean(true)},
                };
        String[] Names = {"姓名", "语文", "数学", "总分", "及格"};

        JTable table = new JTable(playerInfo,Names);
        scrollPane = new JScrollPane(table);
        jf.setLayout(null);
        jf.add(scrollPane);
        scrollPane.setBounds(0,0,300,300);

        jf.setVisible(false);
        jf.setSize(450, 400);
        jf.setResizable(false);
        jf.setAlwaysOnTop(true);
    }
    private void init() {



    }

    public void hide() {
        jf.setVisible(false);
    }


    public void show(JSONObject json,String whatNeedToDo) {
        jf.setVisible(true);
    }

}
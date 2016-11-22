package cao.mine.jfame.Frame;

import cao.mine.Main;
import cao.mine.init.Context;
import cao.mine.jfame.service.CompareService;
import cao.mine.jfame.service.MainService;
import com.alibaba.fastjson.JSONObject;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class CompareFrame {
    private JFrame jf;
    private JLabel delLable,replaceLable,addLable;
    private JScrollPane delScrollPane,replaceScrollPane,addScrollPane;
    public  JSONObject compareJson;
    public Context context;
    private JTable delTable,replaceTable,addTable;
    private java.util.List<JTable> tableList;
    private JButton delButton,replaceButton,addButton;
    private CompareService compareService;
    private MainFrame mainFrame;

    public CompareFrame(Context context,MainFrame mainFrame) {
        this.jf = new JFrame("主界面 - 文件比对客户端");
        this.context=context;
        compareService=new CompareService();
        String[] Names = {"文件名", "路径"};
        Object[][] fileTable={{"",""},{"",""}};
        this.delTable = new JTable(fileTable,Names);
        this.replaceTable = new JTable(fileTable,Names);
        this.addTable = new JTable(fileTable,Names);
        this.mainFrame=mainFrame;
        tableList=new LinkedList();
        tableList.add(delTable);
        tableList.add(replaceTable);
        tableList.add(addTable);
        delButton=new JButton("发送并删除");
        replaceButton=new JButton("发送并替换");
        addButton=new JButton("发送并添加");
        delLable=new JLabel("删除列表：");
        replaceLable=new JLabel("替换列表：");
        addLable=new JLabel("添加列表：");
        delScrollPane = new JScrollPane(delTable);
        replaceScrollPane = new JScrollPane(replaceTable);
        addScrollPane= new JScrollPane(addTable);

        delScrollPane.setBounds(10,50,280,200);
        replaceScrollPane.setBounds(300,50,280,200);
        addScrollPane.setBounds(590,50,280,200);
        delLable .setBounds(30,10,80,30);
        replaceLable.setBounds(310,10,80,30);
        addLable.setBounds(600,10,80,30);
        delButton.setBounds(80,260,100,30);
        replaceButton.setBounds(380,260,100,30);
        addButton.setBounds(680,260,100,30);

        jf.add(delScrollPane);
        jf.add(replaceScrollPane);
        jf.add(addScrollPane);
        jf.add(delLable);
        jf.add(replaceLable);
        jf.add(addLable);
        jf.add(delButton);
        jf.add(replaceButton);
        jf.add(addButton);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        jf.setLocation((int)(screenSize.getWidth()/2)-450,(int)(screenSize.getHeight()/2)-200);
        jf.setLayout(null);
        jf.setVisible(false);
        jf.setSize(900, 400);
        jf.setResizable(false);

        delButton.addActionListener(compareService.sendDel(this,mainFrame));
        replaceButton.addActionListener(compareService.sendReplace(this,mainFrame));
        addButton.addActionListener(compareService.sendAdd(this,mainFrame));
    }
    private void setTable(List<JTable> list) {
        for (int i=0;i<list.size();i++){
            JTable table=list.get(i);
            table.getTableHeader().setResizingAllowed(false);
            table.getTableHeader().setReorderingAllowed(false);
            table.getColumnModel().getColumn(0).setMaxWidth(80);
        }

    }

    public void hide() {
        jf.setVisible(false);
    }


    public void show(JSONObject json) {
        this.compareJson=json;
        Object[][] delList=getArray("needToDel",compareJson);
        Object[][] replaceList=getArray("needToReplace",compareJson);
        Object[][] addList=getArray("needToAdd",compareJson);
        setTableArray(delList,delTable);
        setTableArray(replaceList,replaceTable);
        setTableArray(addList,addTable);

        setTable(tableList);
        jf.setVisible(true);
    }
    private void  setTableArray(Object[][] list,JTable table){
        String[] Names = {"文件名", "路径"};
        DefaultTableModel listRecords = new DefaultTableModel(null, Names);//初始化，headings是标题的数组
        for(int i=0;i<list.length;i++){
            listRecords.addRow(list[i]);
        }
        table.setModel(listRecords);//初始化表格
    }
    private Object[][] getArray(String whatNeedToDo,JSONObject json){
        JSONObject list=json.getJSONObject(whatNeedToDo);
        Object[][] fileTable=new Object[list.size()][2];
        Iterator it=list.keySet().iterator();
        int i=0;
        while (it.hasNext()){
            Object key=it.next();
            fileTable[i][0]= key;
            fileTable[i][1]=list.getJSONObject(key.toString()).get("path");
            i++;
        }
        return fileTable;
    }

}
package cao.mine.MySocket.file;

import cao.mine.MySocket.core.SendSocket;
import cao.mine.init.Context;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.ArrayUtils;

import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by 10441 on 2016/10/21.
 */
public class SendSocketFile {
    private List<JSONObject> list = new LinkedList<>();
    private String realPath;
    private String needToDO;
    private Context context;
    public SendSocketFile(Context context,List<JSONObject> list, String realPath,String needToDO) {
        this.list = list;
        this.realPath = realPath;
        this.needToDO=needToDO;
        this.context=context;
    }

    public JSONObject getResult() throws IOException {
        Iterator<JSONObject> it = list.iterator();
        JSONObject head=new JSONObject();
        head.put("flag","file");
        head.put("need",needToDO);
        byte fileByte[]=new byte[0];
        JSONArray fileKeyList=new JSONArray();
        if(!(needToDO.equals("DEL"))){
            JSONObject newSingleJson=new JSONObject();
            while (it.hasNext()) {
                JSONObject fileKey =it.next();
                File file = new File(realPath+"/"+fileKey.get("path"));
                byte[] singleFileByte=getBytes(file);
                newSingleJson.put("path",fileKey.get("path"));
                newSingleJson.put("filename",file.getName());
                newSingleJson.put("fileSize",singleFileByte.length);
                fileByte=ArrayUtils.addAll(fileByte,singleFileByte);
                fileKeyList.add(newSingleJson);
            }
        }
        head.put("fileKeyList",fileKeyList);
        byte[] headByte=new Base64().encode(head.toString().getBytes());
        byte[] buffer=ArrayUtils.addAll(ArrayUtils.addAll(headByte,"/0!H/".getBytes()),fileByte);
        SendSocket sendSocket=new SendSocket(context,50000,buffer);

        return sendSocket.getResult();
    }

    private byte[] getBytes(File file) {
        byte[] buffer = null;
        try {
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

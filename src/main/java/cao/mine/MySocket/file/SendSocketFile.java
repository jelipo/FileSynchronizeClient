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

/**
 * head格式样例
 * {
 * "flag"="file",
 * "need"="ADD/REPLACE/DEL"  need="DEL"时，"fileKeyList"值为空
 * "parentPath"+"/home/cao/Desktop/"     服务端绝对父路径
 * "fileKeyList"=
 * [
 * {"path"="/src/images","filename"="hello.jpg","fileSize"=(int)469}
 * {"path"="/src/mp3","filename"="go.mp3","fileSize"=(int)1196}
 * ]
 * }
 */
public class SendSocketFile {
    private List<JSONObject> list = new LinkedList<>();
    private String serverPath;
    private String clientPath;
    private String needToDO;
    private Context context;


    public SendSocketFile(Context context, List<JSONObject> list, String serverPath, String clientPath, String needToDO) {
        this.list = list;
        this.serverPath = serverPath;
        this.clientPath = clientPath;
        this.needToDO = needToDO;
        this.context = context;
    }


    public JSONObject getResult() throws IOException {
        Iterator<JSONObject> it = list.iterator();
        JSONObject head = new JSONObject();
        head.put("flag", "file");
        head.put("need", needToDO);
        head.put("parentPath",serverPath);
        byte fileByte[] = new byte[0];
        JSONArray fileKeyList = new JSONArray();
        if (!(needToDO.equals("needToDel"))) {
            while (it.hasNext()) {
                JSONObject newSingleJson = new JSONObject();
                JSONObject fileKey = it.next();
                File file = new File(clientPath + "/" + fileKey.get("path") + "/" + fileKey.get("filename"));
                if (file.isFile()) {
                    byte[] singleFileByte = getBytes(file);
                    newSingleJson.put("path", fileKey.get("path"));
                    newSingleJson.put("filename", fileKey.get("filename"));
                    newSingleJson.put("fileSize", singleFileByte.length);
                    newSingleJson.put("isFile", 1);
                    fileByte = ArrayUtils.addAll(fileByte, singleFileByte);
                    fileKeyList.add(newSingleJson);
                }else{
                    newSingleJson.put("path", fileKey.get("path"));
                    newSingleJson.put("filename", fileKey.get("filename"));
                    newSingleJson.put("isFile",0);
                    newSingleJson.put("fileSize", 0);
                    fileKeyList.add(newSingleJson);
                }
            }
        }else{
            JSONObject fileKey;
            while (it.hasNext()) {
                JSONObject newSingleJson = new JSONObject();
                fileKey= it.next();
                newSingleJson.put("path", fileKey.get("path"));
                newSingleJson.put("filename",fileKey.getString("filename"));
                newSingleJson.put("fileSize", fileKey.getInteger("size"));
                newSingleJson.put("isFile", fileKey.getInteger("isFile"));
                fileKeyList.add(newSingleJson);
            }
            System.out.println(fileKeyList);
        }
        head.put("fileKeyList", fileKeyList);
        SendSocket sendSocket = new SendSocket(context, 50000, fileByte, head);
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

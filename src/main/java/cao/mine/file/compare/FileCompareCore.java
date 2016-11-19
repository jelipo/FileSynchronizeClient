package cao.mine.file.compare;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by 10441 on 2016/10/11.
 */
public class FileCompareCore {
    private JSONObject compareList=new JSONObject();
    private JSONObject needToReplaceList=new JSONObject();
    private Boolean isGetReplaceList;
    private List folder=new LinkedList();
    private JSONObject singleDe=new JSONObject();
    //                              server            client
    private void compare(JSONObject before, JSONObject after) {
        Iterator it = after.keySet().iterator();
        while (it.hasNext()) {
            Object key = it.next();
            if (isFile(after.get(key))) {
                if (before==null||before.get(key) == null) {
                    compareList.put(key.toString(), after.get(key));
                } else if (isGetReplaceList) {
                    if (!(((JSONObject) after.get(key)).get("md5").equals(((JSONObject) before.get(key)).get("md5")))) {
                        needToReplaceList.put(key.toString(), after.get(key));
                    }
                }
            } else {
                if (before!=null){
                    compare((JSONObject) before.get(key), (JSONObject) after.get(key));
                }
            }
        }

    }

    private static Boolean isFile(Object ob) {
        JSONObject json = (JSONObject) ob;
        if (json.get("isFile") == null) {
            return false;
        } else {
            return true;
        }
    }

    public JSONObject getCompareList(JSONObject before, JSONObject after, Boolean isGetReplaceList) {
        this.isGetReplaceList = isGetReplaceList;
        compare(before, after);
        return compareList;
    }
    public JSONObject getCompareDelList(JSONObject before, JSONObject after, Boolean isGetReplaceList) {
        this.isGetReplaceList = isGetReplaceList;
        singleDe.put("isFile",0);
        compareDel(before, after);
        return compareList;
    }
    private void compareDel(JSONObject before, JSONObject after) {
        Iterator it = after.keySet().iterator();
        while (it.hasNext()) {
            Object key = it.next();
            Object fileOrDe=after.get(key);
            if (isFile(fileOrDe)) {
                if (before==null||before.get(key) == null) {
                    compareList.put(key.toString(), after.get(key));
                } else if (isGetReplaceList) {
                    if (!(((JSONObject) after.get(key)).get("md5").equals(((JSONObject) before.get(key)).get("md5")))) {
                        needToReplaceList.put(key.toString(), after.get(key));
                    }
                }
            } else {
                folder.add(key);
                if (((JSONObject)fileOrDe).size()==0||before==null){
                    singleDe.put("path",getDePath());
                    compareList.put(key.toString(),singleDe);
                }else{
                    compareDel((JSONObject) before.get(key), (JSONObject) after.get(key));
                }
            }
        }
        if (folder.size()!=0) {
            folder.remove(folder.size() - 1);
        }
    }


    public JSONObject getNeedToReplaceList(){
        return needToReplaceList;
    }
    private String getDePath(){
        StringBuffer path=new StringBuffer("");
        for(int i=0;i<folder.size();i++){
            path.append(folder.get(i)+"/");
        }
        return path.toString();
    }
}

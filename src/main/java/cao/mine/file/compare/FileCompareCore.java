package cao.mine.file.compare;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
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
    private List addFolder=new ArrayList();
    private JSONObject singleDe=new JSONObject();
    private List<String> fileRepeatList=new ArrayList();
    //                              server            client
    private void compare(JSONObject before, JSONObject after) {
        Iterator it = after.keySet().iterator();
        while (it.hasNext()) {
            Object key = it.next();
            if (isFile(after.get(key))) {
                if (before==null||before.get(key) == null) {
                    String name=isReapeat(key.toString());
                    compareList.put(name, after.get(key));
                    fileRepeatList.add(name);
                } else if (isGetReplaceList) {
                    if (!(((JSONObject) after.get(key)).get("md5").equals(((JSONObject) before.get(key)).get("md5")))) {
                        needToReplaceList.put(key.toString(), after.get(key));
                    }
                }
            } else {
                if (before!=null){
                    folder.add(key);
                    if (before.get(key) == null){
                        JSONObject singleDe=new JSONObject();
                        singleDe.put("isFile",0);
                        singleDe.put("path",getDePath());
                        String name=isReapeat(key.toString());
                        compareList.put(name,singleDe);
                        fileRepeatList.add(name);
                        addCompare(after.getJSONObject(key.toString()));
                    }
                    compare((JSONObject) before.get(key), (JSONObject) after.get(key));
                }

            }
        }
        if (folder.size()!=0) {
            folder.remove(folder.size() - 1);
        }

    }
    private String isReapeat (String name){
        if (fileRepeatList.contains(name)){
            return name+"/"+System.currentTimeMillis();
        }
        return name;
    }
    private void addCompare(JSONObject client){
        Iterator it=client.keySet().iterator();
        while (it.hasNext()){
            Object key=it.next();
            if (client.size()==0){
                addFolder.add(key);
                JSONObject singleDe=new JSONObject();
                singleDe.put("isFile",0);
                singleDe.put("path",getAddDePath());
                String name=isReapeat(key.toString());
                compareList.put(name,singleDe);
                fileRepeatList.add(name);
            }else{
                if(isFile(client.get(key))){
                    String name=isReapeat(key.toString());
                    compareList.put(name, client.get(key));
                    fileRepeatList.add(name);
                }else{
                    addFolder.add(key);
                    JSONObject singleDe=new JSONObject();
                    singleDe.put("isFile",0);
                    singleDe.put("path",getAddDePath());
                    String name=isReapeat(key.toString());
                    compareList.put(name,singleDe);
                    fileRepeatList.add(name);
                    addCompare(client.getJSONObject(key.toString()));
                }
            }
        }
        if (addFolder.size()!=0) {
            addFolder.remove(addFolder.size() - 1);
        }
    }
    private String getAddDePath(){
        StringBuffer path=new StringBuffer("");
        for(int i=0;i<addFolder.size();i++){
            path.append(addFolder.get(i)+"/");
        }
        return getDePath()+"/"+path.toString();
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
        singleDe.put("isFile",0);
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

package cao.mine.file;

import com.alibaba.fastjson.JSONObject;

import java.io.IOException;
import java.util.Iterator;

/**
 * Created by 10441 on 2016/10/10.
 */
public class FileCompare {

    private JSONObject compareList=new JSONObject();

    private  static Boolean isFile(Object ob) {
        JSONObject json= (JSONObject) ob;
        if (json.get("isFile")==null) {
            return false;
        } else {
            return true;
        }
    }
    public void compare(JSONObject oldJson, JSONObject newJson) throws IOException {

        Iterator it=newJson.keySet().iterator();
        while(it.hasNext()) {
            Object key= it.next();
            if (isFile(newJson.get(key))) {
                if (oldJson.get(key)==null){
                    compareList.put(key.toString(),(JSONObject)newJson.get(key));
                }
            }else{
                compare((JSONObject) oldJson.get(key), (JSONObject) newJson.get(key));
            }
        }
    }
    public JSONObject getCompareList(){
        return compareList;
    }
}

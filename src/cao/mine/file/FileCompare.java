package cao.mine.file;

import com.alibaba.fastjson.JSONObject;

import java.io.IOException;
import java.util.Iterator;

/**
 * Created by 10441 on 2016/10/10.
 */
public class FileCompare {

    public JSONObject compare(JSONObject server, JSONObject client) {
//        JSONObject json = new JSONObject();
        FileCompareCore core=new FileCompareCore();
        JSONObject needToAdd=core.getCompareList(server, client,true);
        JSONObject needToReplace=core.getNeedToReplaceList();
        JSONObject needToDel=new FileCompareCore().getCompareList(client,server,false);
        JSONObject json=new JSONObject();
        json.put("needToAdd",needToAdd);
        json.put("needToDel",needToDel);
        json.put("needToReplace",needToReplace);
        return json;
    }

}

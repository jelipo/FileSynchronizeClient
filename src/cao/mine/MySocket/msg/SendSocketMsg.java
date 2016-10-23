package cao.mine.MySocket.msg;

import cao.mine.MySocket.core.SendSocket;
import cao.mine.init.Context;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.ArrayUtils;

/**
 * Created by 10441 on 2016/10/23.
 */
public class SendSocketMsg {
    private String whatNeedToDo;
    private Context context;
    private JSONObject parameter;
    public SendSocketMsg(Context context,String whatNeedToDo,JSONObject parameter){
        this.parameter=parameter;
        this.context=context;
        this.whatNeedToDo=whatNeedToDo;
    }
    public JSONObject getResult() {
        JSONObject head=new JSONObject();
        head.put("flag","msg");
        head.put("msg",whatNeedToDo);
        head.put("parameter",parameter);
        byte[] headByte=new Base64().encode(head.toString().getBytes());


        return head;
    }
}

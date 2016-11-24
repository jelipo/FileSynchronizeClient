package cao.mine.MySocket.msg;

import cao.mine.MySocket.core.SendSocket;
import cao.mine.init.Context;
import com.alibaba.fastjson.JSONObject;

import java.io.IOException;

/**
 * Created by 10441 on 2016/10/23.
 */
public class SendSocketMsg {
    private Context context;
    private JSONObject parameter;
    public SendSocketMsg(Context context,JSONObject parameter){
        this.parameter=parameter;
        this.context=context;
    }
    public JSONObject getResult() throws IOException {
        parameter.put("flag","msg");
        byte[] data=new byte[0];
        SendSocket sendSocket=new SendSocket(context,50000,data,parameter);
        return sendSocket.getResult();
    }
}

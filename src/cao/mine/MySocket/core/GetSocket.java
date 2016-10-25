package cao.mine.MySocket.core;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.codec.binary.Base64;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by 10441 on 2016/10/25.
 */
public class GetSocket {


    private String firstCut;
    private String endCut;
    private BufferedInputStream in;
    private Socket socket;
    private byte[] FIRST_BYTE;
    private byte[] END_BYTE;

    public GetSocket(String firstCut, String endCut, BufferedInputStream in, Socket socket) {
        this.firstCut = firstCut;
        this.endCut = endCut;
        this.in = in;
        this.FIRST_BYTE = firstCut.getBytes();
        this.socket = socket;
        this.END_BYTE = endCut.getBytes();
    }

    public JSONObject getResult() throws IOException {
        int r = 0;
        Boolean isFindFirst = false;
        List<Byte> temp = new LinkedList<Byte>();
        int[] endTemp = new int[END_BYTE.length - 1];
        while ((r = in.read()) != -1) {
            if (r == FIRST_BYTE[0] && (!isFindFirst)) {
                for (int i = 0; i < (firstCut.length() - 1); i++) {
                    r = in.read();
                    if (FIRST_BYTE[i + 1] != r) {
                        break;
                    } else {
                        if (i == (FIRST_BYTE.length - 2))
                            isFindFirst = true;
                    }
                }
            } else if (isFindFirst) {
                temp.add((byte) r);
                while ((r = in.read()) != -1) {
                    if (r == END_BYTE[0]) {
                        for (int i = 0; i < (END_BYTE.length - 1); i++) {
                            r = in.read();
                            endTemp[i] = r;
                        }
                        if (endTemp[0] == END_BYTE[1] && endTemp[1] == END_BYTE[2] && endTemp[2] == END_BYTE[3] && endTemp[3] == END_BYTE[4]) {
                            return whatNeedToDO(temp, in);
                        } else {
                            temp.add((byte) END_BYTE[0]);
                            for (int i = 0; i < endTemp.length; i++) {
                                temp.add((byte) endTemp[i]);
                            }
                        }
                    } else {
                        temp.add((byte) r);
                    }
                }
            }
        }

        if (r == -1) {
            socket.close();
            System.out.println("连接已经断开");
        }
        return new JSONObject();
    }

    private JSONObject whatNeedToDO(List<Byte> data, BufferedInputStream in) throws IOException {
        List<Byte> list = new LinkedList();
        list.addAll(data);
        int size = list.size();
        byte[] by = new byte[size];
        Iterator<Byte> it = list.iterator();
        int i = 0;
        while (it.hasNext()) {
            by[i] = it.next();
            i++;
        }
        return JSON.parseObject(new String(Base64.decodeBase64(by)));
    }
}

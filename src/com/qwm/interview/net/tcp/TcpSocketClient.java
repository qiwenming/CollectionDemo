package com.qwm.interview.net.tcp;

import java.io.DataOutputStream;
import java.net.Socket;

/**
 * Created by Administrator on 2017/3/17.
 */
public class TcpSocketClient {
    public void sendMsg(String msg){
        try {
            Socket s = new Socket("127.0.0.1",9898);
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            dos.writeInt(msg.length());//数据的长度
            dos.writeUTF(msg);
            dos.flush();
            dos.close();
            s.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

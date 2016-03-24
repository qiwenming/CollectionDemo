package com.qwm.interview.net.tcp;

import java.io.DataOutputStream;
import java.net.Socket;

/**
 * Created by qiwenming on 16/3/24.
 * 客户端
 */
public class SocketClient {

    /**
     * 发送数据
     *  1.创建Socket服务
     *  2.获取输出流
     *  3.使用输出流写数据
     *  4.关闭资源
     * @param msg
     */
    public void testSend(String msg){
        try {
            Socket s = new Socket("127.0.0.1",8888);
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

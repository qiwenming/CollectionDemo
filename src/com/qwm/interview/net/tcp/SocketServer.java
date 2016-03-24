package com.qwm.interview.net.tcp;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by qiwenming on 16/3/24.
 */
public class SocketServer {
    /**
     * 接收数据
     * 1.创建ServerSocket服务
     * 2.获取客户端对象 Socket
     * 3.获取输入流
     * 4.使用输入流读取数据
     * 5.关闭资源
     */
    public void testReceive(){
        try {
            ServerSocket ss = new ServerSocket(8888);
            Socket s = ss.accept();
            DataInputStream dis = new DataInputStream(s.getInputStream());
            int datalength = dis.readInt();//数据的长度
            //读数据
            int length = 0;
            System.out.println("ip:"+s.getInetAddress().getHostAddress()+"\r\ndata:");
            while (length<datalength){
                String msg = dis.readUTF();
                length +=msg.length();
                System.out.println(msg);
            }
            System.out.println("长度是:"+datalength);
            dis.close();
            s.close();
            ss.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package com.qwm.interview.net.tcp;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Administrator on 2017/3/17.
 */
public class TcpSocketServer {
    public void start(){
        ServerSocket ss = null ;
        Socket socket= null ;
        DataInputStream dis= null ;
        try {
            ss = new ServerSocket(9898);
            socket = ss.accept();
            dis = new DataInputStream(socket.getInputStream());
            int datalength = dis.readInt();//数据的长度
            //读数据
            int length = 0;
            System.out.println("ip:"+socket.getInetAddress().getHostAddress()+"\r\ndata:");
            while (length<datalength){
                String msg = dis.readUTF();
                length +=msg.length();
                System.out.println(msg);
            }
            System.out.println("长度是:"+datalength);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if (dis != null) {
                    dis.close();
                }
                if (socket != null) {
                    socket.close();
                }
                if (ss != null) {
                    ss.close();
                }
            }catch (Exception e){

            }
        }
    }
}

package com.qwm.interview.net.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * Created by qiwenming on 16/3/24.
 * Udp发送数据
 */
public class UdpSend {

    public void testSend(String msg){
        try {
            //1.创建服务
            DatagramSocket ds = new DatagramSocket();

            //2.创建数据包,封装数据
            byte[] data = msg.getBytes();
            DatagramPacket dp = new DatagramPacket(data,data.length, InetAddress.getByName("127.0.0.1"),8888);

            //3.发送数据
            ds.send(dp);

            //4.关闭流
            ds.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package com.qwm.interview.net.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * Created by qiwenming on 16/3/24.
 */
public class UdpReceive {
    /**
     * udp数据的接收
     */
    public void testReceive(){

        try {
            //1.创建udp服务
            DatagramSocket ds = new DatagramSocket(8888);

            //2.定义一个数据包,用于接收数据
            byte[] buf = new byte[1024];
            DatagramPacket dp = new DatagramPacket(buf,buf.length);

            //3.接收
            ds.receive(dp);

            //4.取数据
            String ip = dp.getAddress().getHostAddress();
            String data = new String(dp.getData(),0,dp.getLength());

            //5.关闭流
            ds.close();

            System.out.println("ip:"+ip+"\ndata:"+data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

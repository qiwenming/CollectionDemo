package com.qwm.interview.net.tcp;

import java.util.Date;

/**
 * Created by Administrator on 2017/3/17.
 */
public class TcpTest {
    public static void main(String[] args) throws Exception{
        new Thread(){
            @Override
            public void run() {
                new TcpSocketServer().start();
            }
        }.start();
        TcpSocketClient tcpClient = new TcpSocketClient();
        tcpClient.sendMsg("lalallalal "+new Date().toString());
    }
}

package com.qwm.interview;

import com.qwm.interview.Collection.CollectionsTool;
import com.qwm.interview.Collection.MapJava;
import com.qwm.interview.net.tcp.SocketClient;
import com.qwm.interview.net.tcp.SocketServer;
import com.qwm.interview.net.udp.UdpReceive;
import com.qwm.interview.net.udp.UdpSend;
import com.qwm.interview.streamdemo.StreamDemo;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by qiwenming on 2016/3/22.
 * 复习集合框架的demo
 */
public class MainJava {

    public static void main(String[] args){

//        CollectionJava collectionJava  = new CollectionJava();
//        collectionJava.testSet();
//        collectionJava.testTreeSet();
//        collectionJava.testTreeSetComparable();

//        MapJava mapJava = new MapJava();
////        mapJava.testGetValue();
////        mapJava.testProperties();
//        mapJava.testProperties2();

//        CollectionsTool tool = new CollectionsTool();
//        tool.testCollections();

        //流测试

//        StreamDemo streamDemo = new StreamDemo();
//        streamDemo.testStream();
//        streamDemo.testStream2();
//        streamDemo.testStream3();
//        streamDemo.testReaderAndWriter();
//        streamDemo.testReaderAndWriter2();
//        streamDemo.testStreamReaderWriter();

//        //接收数据
//        new Thread(){
//            @Override
//            public void run() {
//                UdpReceive udpReceive = new UdpReceive();
//                udpReceive.testReceive();
//            }
//        }.start();
//        //发送数据
//        UdpSend udpSend = new UdpSend();
//        udpSend.testSend("我是你大爷");

        //TCP测试
        new Thread(){
            @Override
            public void run() {
                new SocketServer().testReceive();
            }
        }.start();

        new SocketClient().testSend("我是杞小明");

    }


}

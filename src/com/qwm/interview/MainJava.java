package com.qwm.interview;

import com.qwm.interview.threaddemo.FutureTest;
import com.qwm.interview.threaddemo.ThreadDemo;

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

//        //TCP测试
//        new Thread(){
//            @Override
//            public void run() {
//                new SocketServer().testReceive();
//            }
//        }.start();
//
//        new SocketClient().testSend("我是杞小明，现在是tcp测试");

////        多线程测试
//        FutureTest futureTest = new FutureTest();
////        futureTest.test();
////        futureTest.test2();
//        futureTest.test3();

        ThreadDemo threadDemo = new ThreadDemo();
        threadDemo.test();
    }
}

package com.qwm.interview;

import com.qwm.interview.Collection.CollectionsTool;
import com.qwm.interview.Collection.MapJava;
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

        StreamDemo streamDemo = new StreamDemo();
//        streamDemo.testStream();
//        streamDemo.testStream2();
//        streamDemo.testStream3();
//        streamDemo.testReaderAndWriter();
//        streamDemo.testReaderAndWriter2();
        streamDemo.testStreamReaderWriter();
    }


}

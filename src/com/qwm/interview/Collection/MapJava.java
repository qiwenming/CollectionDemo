package com.qwm.interview.Collection;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * Created by qiwenming on 2016/3/23.
 */
public class MapJava {

    public void testLinkedHashMap(){
        HashMap<String,String> hashMap = new HashMap<>();
        HashMap<String,String> linkedHashMap = new LinkedHashMap<>();
        for (int i = 0; i < 10; i++) {
            hashMap.put(i+"","hashMap_"+i);
            linkedHashMap.put(i+"","linkedHashMap_"+i);
        }
        System.out.println("-------hashMap-----------");
        printMap(hashMap);
        System.out.println("-------linkedHashMap-----------");
        printMap(linkedHashMap);
    }

    public void printMap(Map map){
        Set<Map.Entry<Object,Object>> entrySet= map.entrySet();
        for (Map.Entry<Object,Object> entry: entrySet) {
            System.out.println("key:"+entry.getKey()+"\tvalue:"+entry.getValue());
        }
    }

    //=====================================四种遍历值===========================================
    /**
     * 四种遍历值
     */
    public void testGetValue(){
        Map<Integer ,String> map = new HashMap<Integer ,String>();
        for (int i = 0; i < 5; i++) {
            map.put(i,"item---"+i);
        }

        //第一种遍历方式  map.keySet
        System.out.println("第一种遍历方式  map.keySet");
        for (Integer integer : map.keySet()) {
            System.out.println("key:"+integer+"\tvalue:"+map.get(integer));
        }

        //第二种方式 map.values
        System.out.println("\n第二种方式 map.values");
        for (String value : map.values()) {
            System.out.println("value:"+value);
        }

        //第三种 map.entrySet  while iterator
        System.out.println("\n第三种map.entrySet  while iterator");
        Set<Map.Entry<Integer,String>> entrySet= map.entrySet();
       Iterator<Map.Entry<Integer,String>> iterator =  entrySet.iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer,String> entry = iterator.next();
            System.out.println("key:"+entry.getKey()+"\tvalue:"+entry.getValue());
        }

        //第四种 map.entrySet foreach
        System.out.println("\n第四种 map.entrySet foreach");
        for (Map.Entry<Integer,String> entry: entrySet) {
            System.out.println("key:"+entry.getKey()+"\tvalue:"+entry.getValue());
        }
    }

    //=====================================Properties===========================================

    public void testProperties(){
        Properties pps = System.getProperties();
//        pps.list(System.out);
        System.out.println(pps.getProperty("java.runtime.version"));
        try {
            FileWriter fileWriter = new FileWriter("D:\\IdeaProjects\\CollectionDemo/systempro.properties");
            pps.store(fileWriter,pps.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testProperties2(){
        Properties pps = new Properties();
        pps.setProperty("xm","明夜");
        pps.setProperty("xm2","明夜");
        pps.setProperty("xm3","明夜");
        pps.setProperty("xm4","明夜");
        try {
            FileWriter fileWriter = new FileWriter("D:\\IdeaProjects\\CollectionDemo/xm.properties");
            pps.store(fileWriter,pps.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public void testgetProperties2(){
//        Properties pps = new Properties();
//        pps.setProperty("xm","明夜");
//        pps.setProperty("xm2","明夜");
//        pps.setProperty("xm3","明夜");
//        pps.setProperty("xm4","明夜");
//        try {
//            FileWriter fileWriter = new FileWriter("D:\\IdeaProjects\\CollectionDemo/xm.properties");
//            pps.store(fileWriter,pps.toString());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

}

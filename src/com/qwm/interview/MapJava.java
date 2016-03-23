package com.qwm.interview;

import java.util.*;

/**
 * Created by qiwenming on 2016/3/23.
 */
public class MapJava {

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


}

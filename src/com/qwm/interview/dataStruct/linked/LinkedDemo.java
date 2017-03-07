package com.qwm.interview.dataStruct.linked;

/**
 * Created by Administrator on 2017/3/6.
 */
public class LinkedDemo {
    public static void main(String[] args){
        QwmLinkedList linkedList = new QwmLinkedList();
        linkedList.add("fdsafd");
        linkedList.add("fff");
        linkedList.add("adfda");
        linkedList.add("trht");
        linkedList.add(999);
        printLinked(linkedList);
        System.out.println(linkedList.delete("trht"));
        printLinked(linkedList);
    }

    public static void printLinked(QwmLinkedList linkedList){
        System.out.println("-------遍历开始--------");
        linkedList.ergodic();
//        linkedList.ergodicReverse();
        System.out.println("-------遍历结束--------");
        System.out.println("----第一个："+linkedList.getFirst());
        System.out.println("----最后一个："+linkedList.getLast());
    }
}

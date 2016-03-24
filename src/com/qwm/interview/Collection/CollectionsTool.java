package com.qwm.interview.Collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by qiwenming on 2016/3/24.
 * 集合工具类的测试
 */
public class CollectionsTool {

    /**
     * Collections集合工具类
     */
    public void testCollections(){
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 5; i > 0; i--) {
            list.add(i+1);
            list.add(i-4);
        }

        printList(list,"原始的");
        //==========================sort===================================
        //默认自然排序
        Collections.sort(list);
        printList(list,"默认自然排序");

        //使用比较器 逆自然顺序
        Collections.sort(list,new XmComparator());
        printList(list,"使用比较器逆自然顺序");

        //==========================swap===================================
        Collections.swap(list,2,4);
        printList(list,"使用swap交换 2,4的位置");

        //==========================shuffle===================================
        Collections.shuffle(list);
        printList(list,"使用shuffle洗牌随机排序");

        //==========================shuffle===================================
        Collections.reverse(list);
        printList(list,"使用reverse逆转");

        //==========================fill===================================
        Collections.fill(list,30);
        printList(list,"使用fill 将集合元素替换为指定对象");
    }

    /**
     * 打印集合
     * @param list
     * @param msg
     */
    public void printList(List<Integer> list,String msg){
        System.out.println("\n"+msg);
        for (Integer integer : list) {
            System.out.print("\t"+integer);
        }
    }

    class XmComparator implements Comparator<Integer>{

        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    }

}

package com.qwm.interview.Collection;

import java.util.*;

/**
 * Created by qiwenming on 2016/3/23.
 * 集合练习
 */
public class CollectionJava {
    ArrayList arrayList = new ArrayList<>();
    LinkedList linkedList = new LinkedList();
    public void test(){
        arrayList.contains(null);
        arrayList.remove(null);
        linkedList.contains(null);
        linkedList.remove(null);
        arrayList.iterator();

    }

    public void testSet(){
        HashSet<String> hashSet = new HashSet<String>();
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<String>();

        for (int i = 0; i < 5; i++) {
            hashSet.add("hashset__"+i);
            linkedHashSet.add("linkedHashSet__"+i);
        }
        Iterator<String> iterator1 = hashSet.iterator();
        while (iterator1.hasNext()){
            System.out.println(iterator1.next());
        }

        System.out.println("\n");

        Iterator<String> iterator2 = linkedHashSet.iterator();
        while (iterator2.hasNext()){
            System.out.println(iterator2.next());
        }
    }



    //==========================================================================================
    public void testTreeSet(){
        System.out.println("------testTreeSet--------");
//        TreeSet<Integer> treeSet = new TreeSet<Integer>(new XmComparator());
        TreeSet<Integer> treeSet = new TreeSet<Integer>(new XmComparator());
        treeSet.add(1);
        treeSet.add(3);
        treeSet.add(9);
        treeSet.add(2);

        Iterator<Integer> iterator = treeSet.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }


    public void testTreeSetComparable(){
        System.out.println("------testTreeSetComparable--------");

        TreeSet<XmComparableBean> treeSetCom = new TreeSet<XmComparableBean>();
        treeSetCom.add(new XmComparableBean(1));
        treeSetCom.add(new XmComparableBean(3));
        treeSetCom.add(new XmComparableBean(9));
        treeSetCom.add(new XmComparableBean(6));
        treeSetCom.add(new XmComparableBean(2));

        Iterator<XmComparableBean> iterator = treeSetCom.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next().number);
        }
    }

    /**
     * 比较器 Comparator  compare
     */
    class XmComparator implements  Comparator<Integer>{
        @Override
        public int compare(Integer param1, Integer param2) {
            return param2-param1;
        }
    }

    /**
     * 实现 Comparable借口  compareTo
     */
    class XmComparableBean implements Comparable<XmComparableBean>{
        public Integer number;
        public XmComparableBean(Integer number){
            this.number = number;
        }

        @Override
        public int compareTo(XmComparableBean param) {
            return this.number-param.number;
        }
    }
//==========================================================================================

}


/**
 * 集合
 * Collection
 *
 * Map
 */
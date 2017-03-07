package com.qwm.interview.Collection;

import java.util.*;

/**
 * Created by qiwenming on 2016/3/23.
 * 集合练习
 */
public class CollectionJava {
    ArrayList arrayList = new ArrayList<>();
    LinkedList linkedList = new LinkedList<>();
    Vector vector = new Vector();
    public void test(){
//        arrayList.contains(null);
//        arrayList.remove(null);
//        linkedList.contains(null);
//        linkedList.remove(null);
//        arrayList.iterator();
//        vector.contains(null);
//        vector.remove(null);
//
//        linkedList.peekFirst();
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
//        testDefualtTreeSet();
        testComparator();
    }

    /**
     * 默认的TreeSet 自然顺序
     */
    public void testDefualtTreeSet(){
        System.out.println("------testDefualtTreeSet--------");
        TreeSet<String> testTreeSet = new TreeSet<>();
        testTreeSet.add("testDefualtTreeSet_9");
        testTreeSet.add("testDefualtTreeSet_7");
        testTreeSet.add("testDefualtTreeSet_8");
        testTreeSet.add("testDefualtTreeSet_1");
        testTreeSet.add("testDefualtTreeSet_3");
        printCollection(testTreeSet);
    }

    /**
     * 比较器的使用
     */
    public void testComparator(){
        TreeSet<Integer> treeSet = new TreeSet<Integer>(new XmComparator());
        treeSet.add(1);
        treeSet.add(3);
        treeSet.add(9);
        treeSet.add(2);
        printCollection(treeSet);

        TreeSet<String> set2 = new TreeSet<>();
        set2.add("asd");
        set2.add("sadg");
        set2.add("aaaa");
        printCollection(set2);
    }

    /**
     * 元素比较
     */
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
     * 比较器，字符串的比较器，这个其实没必要，因为String实现了Comparable接口
     */
    class XmStringComparator implements Comparator<String>{

        @Override
        public int compare(String param1, String param2) {
            return param1.compareTo(param2);
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

        @Override
        public String toString() {
            return number+"";
        }
    }

    /**
     * 实现 Comparable借口  compareTo
     */
    class XmComparableBean2 implements Comparable<XmComparableBean2>{
        private Double doubleNum;

        public XmComparableBean2(Double doubleNum) {
            this.doubleNum = doubleNum;
        }

        @Override
        public int compareTo(XmComparableBean2 o) {
            return 0;
        }

        @Override
        public String toString() {
            return ""+doubleNum;
        }
    }

    public void printCollection(Collection c){
        Iterator iterator = c.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
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
package com.qwm.interview.dataStruct.tree;

/**
 * Created by Administrator on 2017/3/13.
 */
public class TreeTest {
    public static void main(String[] args){
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(6);
        tree.insert(2);
        tree.insert(1);
//        tree.insert(5);
        tree.insert(3);
        tree.insert(4);
        tree.insert(8);
//        tree.printTree();
//        System.out.println("-------------------");
//        tree.remove(2);
//        System.out.println("-------------------");
//        tree.printTree();
        System.out.println(tree.contains(74));
    }
}

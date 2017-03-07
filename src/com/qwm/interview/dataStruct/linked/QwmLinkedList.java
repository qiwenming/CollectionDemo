package com.qwm.interview.dataStruct.linked;

/**
 * Author: qiwenming<br>
 * Create Date: 2017/3/7
 * Description: 模拟的一个集合
 */
public class QwmLinkedList {
    public Node head;
    public Node last;

    /**
     * 添加
     * @param object
     */
    public void add(Object object){
        if(object==null) return;
        if(head==null){//创建
            head = new Node();
            head.object = object;
            last = head;
        }else{
            last.after = new Node();
            last.after.before = last;
            last = last.after;
            last.object = object;
        }
    }

    /**
     * 删除对象
     * @param object
     * @return
     */
    public boolean delete(Object object){
        if(object==null) return false;
        //遍历判断这个对象在不在集合里面
        Node node = head;
        while (node!=null){
            if(node.object.hashCode()==object.hashCode()){
                return deleteNode(node);
            }
            node = node.after;
        }
        return false;
    }

    /**
     * 删除节点
     * @param node
     * @return
     */
    public boolean deleteNode(Node node){
        if(node==null){
            return false;
        }
        if(node.before==null){//说明是第一个,那么我们把头指针向后移一个
            head = node.after;
        }else{//不是第一个
            node.before.after = node.after;
            if(node.after==null){//最有一个
                last=node.before;
                last.after = null;
            }
        }
        return true;
    }

    /**
     * 遍历
     */
    public void ergodic(){
        Node node = head;
        while (node!=null){
            System.out.println(node.object);
            node = node.after;
        }
    }

    /**
     * 逆序遍历
     */
    public void ergodicReverse(){
        Node node = last;
        while (node!=null){
            System.out.println(node.object);
            node = node.before;
        }
    }

    /**
     * 获取第一个节点
     * @return
     */
    public Object getFirst(){
        if(head==null){
            return null;
        }
        return head.object;
    }

    /**
     * 获取最后一个节点
     * @return
     */
    public Object getLast(){
        if(last==null){
            return null;
        }
        return last.object;
    }
}

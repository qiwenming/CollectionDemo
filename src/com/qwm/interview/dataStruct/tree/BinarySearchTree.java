package com.qwm.interview.dataStruct.tree;

import java.nio.BufferUnderflowException;

/**
 * Author: qiwenming<br>
 * Create Date: 2017/3/13
 * Description: 二叉查找树
 */
public class BinarySearchTree<AnyType extends Comparable<? super AnyType>> {

    private String treeStructStr = "";

    /**
     * 根
     */
    private BinaryNode<AnyType> root;

    public BinarySearchTree( )
    {
        root = null;
    }

    /**
     * 插入
     * @param x
     */
    public void insert( AnyType x )
    {
        root = insert(x,root);
    }

    /**
     * 删除
     * @param x
     */
    public void remove( AnyType x )
    {
        root = remove( x, root );
    }

    /**
     * 查找到最大的
     * @return
     */
    public AnyType findMin( )
    {
        if(isEmpty())
            throw new BufferUnderflowException();
        return findMax(root).element;
    }

    /**
     * 查找到最小的
     * @return
     */
    public AnyType findMax( )
    {
        if(isEmpty())
            throw new BufferUnderflowException();
        return findMin(root).element;
    }

    public int height(){
        if(isEmpty())
            throw new BufferUnderflowException();
        return height(root);
    }

    /**
     * 包含
     * @param x
     * @return
     */
    public boolean contains( AnyType x )
    {
        return contains( x, root );
    }

    public void makeEmpty( )
    {
        root = null;
    }

    /**
     * 空判断
     * @return
     */
    public boolean isEmpty( )
    {
        return root == null;
    }

    /**
     * 打印树
     */
    public void printTree( )
    {
        if(root==null)
            System.out.println("Tree is empty");
        else
            printTree(root);
    }

    /**
     * 插入
     * @param x 插入值
     * @param t 根
     * @return 返回插入的新值
     */
    private BinaryNode<AnyType> insert( AnyType x, BinaryNode<AnyType> t )
    {
        if(t==null)
            return new BinaryNode<AnyType>(x);
        //比较，获取到插入的位置
        int compareResualt = x.compareTo(t.element);
        if(compareResualt<0)//左边
            t.left = insert(x,t.left);
        else if(compareResualt>0) //右边
            t.right =  insert(x,t.right);
        return t;
    }

    /**
     * 删除
     * @param x
     * @param t
     * @return
     */
    private BinaryNode<AnyType> remove( AnyType x, BinaryNode<AnyType> t )
    {
        if(t==null)
            return t;
        int compareResult = x.compareTo(t.element);
        if(compareResult<0)
            t.left = remove(x,t.left);
        else if(compareResult>0)
            t.right = remove(x,t.right);
        else if(t.left != null && t.right != null){//两个儿子
            t.element = findMin(t.right).element;
            t.right = remove(t.element,t.right);
        }else
            t = t.left!=null?t.left:t.right;
        return t;
    }

    /**
     * 找到小的
     * @param t
     * @return
     */
    private BinaryNode<AnyType> findMin( BinaryNode<AnyType> t )
    {
        if(t==null)
            return null;
        else if(t.left==null)
            return t;
        return findMin(t.left);
    }

    /**
     * 找到最大的
     * @param t
     * @return
     */
    private BinaryNode<AnyType> findMax( BinaryNode<AnyType> t )
    {
        if(t!=null)
            while (t.right!=null)
                t = t.right;
       return t;
    }

    /**
     * 包含
     * @param x
     * @param t
     * @return
     */
    private boolean contains( AnyType x, BinaryNode<AnyType> t )
    {
        if(t==null)
            return false;
        int compareResult = x.compareTo(t.element);
        if(compareResult<0)
            return contains(x,t.left);
        else if(compareResult>0)
            return contains(x,t.right);
        return true;
    }

    /**
     * 打印
     * @param t
     */
    private void printTree( BinaryNode<AnyType> t )
    {
        if(t!=null){
            printTree(t.left);
            System.out.println(t.element);
            printTree(t.right);
        }
    }

    /**
     * 高度
     * @param t
     * @return
     */
    private int height( BinaryNode<AnyType> t )
    {
        if(t==null)
            return -1;
        else
            return 1+Math.max(height(t.left),height(t.right));
    }

    /**
     * 节点
     * @param <AnyType>
     */
    private static class BinaryNode<AnyType>
    {
        public BinaryNode<AnyType> left;
        public BinaryNode<AnyType> right;
        public AnyType element;

        public BinaryNode(AnyType element) {
            this(element,null,null);
        }

        public BinaryNode(AnyType element, BinaryNode<AnyType> left, BinaryNode<AnyType> right) {
            this.element = element;
            this.left = left;
            this.right = right;
        }
    }
}

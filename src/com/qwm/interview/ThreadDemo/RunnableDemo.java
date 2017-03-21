package com.qwm.interview.ThreadDemo;
/**
 * Author: qiwenming<br>
 * Create Date: 2017/3/21
 * Description:RunnableDemo
 */
public class RunnableDemo {
    public static void main(String[] args){
        Thread thread = new Thread(new MyRunnable());
        thread.start();
    }
}

class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("Runnable---->"+Thread.currentThread());
    }
}

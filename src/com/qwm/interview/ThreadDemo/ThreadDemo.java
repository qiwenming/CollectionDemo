package com.qwm.interview.ThreadDemo;

/**
 * Author: qiwenming
 * Create Date: 2017/3/21
 * Description: Thread测试
 */
public class ThreadDemo {
    public static void main(String[] args){
//        for (int i = 0; i < 5; i++) {
//            ThreadTest01 test01 = new ThreadTest01();
//            test01.start();
//        }

        ThreadTest02 thread02 = new ThreadTest02(new MyRunnable01());
        thread02.start();
    }
}

class ThreadTest01 extends Thread{
    @Override
    public void run() {
        System.out.println("---->"+Thread.currentThread()+"---->"+System.currentTimeMillis());
    }
}

/**
 * Author: qiwenming<br>
 * Create Date: 2017/3/21
 * Description:
 */
class ThreadTest02 extends Thread{

    public ThreadTest02(Runnable runnable){
        super(runnable);
    }
    @Override
    public void run() {
//        super.run();
        System.out.println("------Thread-run-------"+Thread.currentThread());
    }
}

/**
 * Author: qiwenming<br>
 * Create Date: 2017/3/21
 * Description:
 */
class MyRunnable01 implements Runnable{
    @Override
    public void run() {
        System.out.println("------Runnable-run-------"+Thread.currentThread());
    }
}


package com.qwm.interview.ThreadDemo;

import jdk.nashorn.internal.codegen.CompilerConstants;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by qiwenming on 2016/3/25.
 * 多线程的测试
 */
public class FutureTest {

    /**
     * 测试一
     */
    public void test() {
        try {
            //1.创建Executor
            ExecutorService executor = Executors.newCachedThreadPool();

            //2.添加任务
            MyTask task = new MyTask();
            Future<Integer> future = executor.submit(task);
            executor.shutdown();//关闭线程

            //3.获取返回数据
            Integer resualt = future.get();
            System.out.println("获取的值：" + resualt + "\n当前的线程：" + Thread.currentThread());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    class MyTask implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            Random r = new Random();
            System.out.println("当前的线程：" + Thread.currentThread().getName());
            return r.nextInt(1000);
        }
    }

    /**
     * 测试二
     */
    public void test2() {
        try {
            //1.创建executor
            ExecutorService es = Executors.newFixedThreadPool(5);
            //2.提交任务
            MyTask task = new MyTask();
            FutureTask<Integer> futureTask = new FutureTask<Integer>(task);
            es.submit(futureTask);
            es.shutdown();
            //3.获取值
            System.out.println(futureTask.get());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 测试二
     */
    public void test3() {
        try {
            //1.创建executor
            ExecutorService es = Executors.newFixedThreadPool(5);
            for (int i = 0; i < 20; i++) {
                //2.提交任务
                MyTask task = new MyTask();
                FutureTask<Integer> futureTask = new FutureTask<Integer>(task);
                es.submit(futureTask);
//

                //3.获取值
                System.out.println(futureTask.get());
            }
            es.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //=====================================================================================================
    //=====================================================================================================
    //=====================================================================================================


    public static  void main(String[] args){
        FutureTest test = new FutureTest();
//        test.testFutrueTask01();
        test.testFutrueTask02();
    }

    //==========================使用普通的 Thread方法=================================
    public void testFutrueTask01(){

        Callable<Integer> myCallable = new MyCallable();
        FutureTask<Integer> ft = new FutureTask<Integer>(myCallable);
        Thread thread = new Thread(ft);

        thread.start();
        try {
            int sum = ft.get();
            System.out.println("获取值：sum="+sum);
        } catch (InterruptedException e) {
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    //===========================线程池================================
    public void testFutrueTask02(){
//        Executors.newCachedThreadPool();
//        Executors.newFixedThreadPool(2);
//        Executors.newScheduledThreadPool(3);
//        Executors.newSingleThreadExecutor();
        ExecutorService es = Executors.newScheduledThreadPool(3);//DelayedWorkQueue
        FutureTask<String> futureTask = new FutureTask<String>(new MyCallable2("my_test1"));
        es.submit(futureTask);
        es.shutdown();
        try {
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    class MyCallable implements Callable<Integer>{

        private String mTag;

        public MyCallable(){}

        public MyCallable(String tag){this.mTag = tag;}

        @Override
        public Integer call() throws Exception {
            int sum = 0;
            for (int i = 1; i <100 ; i++) {
                System.out.println(Thread.currentThread()+"--->"+i);
                sum += i;
            }
            return sum;
        }
    }

    class MyCallable2 implements Callable<String> {

        private String mTag;

        public MyCallable2(String tag) {
            this.mTag = tag;
        }

        @Override
        public String call() throws Exception {
            return mTag+"___"+System.currentTimeMillis();
        }
    }
}

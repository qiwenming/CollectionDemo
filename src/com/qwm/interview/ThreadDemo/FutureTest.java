package com.qwm.interview.threaddemo;

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

}

package com.qwm.interview.ThreadDemo;

import com.sun.glass.ui.DelayedCallback;
import com.sun.scenario.DelayedRunnable;

import java.util.Date;
import java.util.concurrent.*;

/**
 * Author: qiwenming<br>
 * Create Date: 2017/3/22
 * Description:
 */
public class ThreadPoolTest {

    private static ThreadPoolTest instance = new ThreadPoolTest();

    public static void main(String[] args){
//        instance.threadPoolExecutorTest();
//        instance.cacheThreadPoolTest();
//        instance.singleThreadPoolTest();
//        instance.fixedThreaddPoolTest();
        instance.scheduledThreadPoolTest();
//        instance.blockingQueueTest();
    }

    public void threadPoolExecutorTest(){
//        cachedThreadPool 修改 60L 可以看缓存的效果
//        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(0, Integer.MAX_VALUE,60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
        // singleThreadPool
//        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(1, 1,0L,TimeUnit.MILLISECONDS , new LinkedBlockingQueue<Runnable>());
        //fixedThreadPool
//        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(3,3,0L,TimeUnit.MILLISECONDS,new LinkedBlockingQueue<Runnable>());
      //  threadPool.allowCoreThreadTimeOut(true);//允许核心线程超时，就是可以被回收
        //scheduledThreadPool
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(2,Integer.MAX_VALUE,0L,TimeUnit.MILLISECONDS,new SynchronousQueue());
//        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(3,3,60L,TimeUnit.MILLISECONDS,new LinkedBlockingQueue());
        addThreadTask(threadPool);
    }


    //============================newCachedThreadPool()==================================
    public void cacheThreadPoolTest(){
        //0, Integer.MAX_VALUE,60L, TimeUnit.SECONDS,
        ExecutorService cachedThreadPool=  Executors.newCachedThreadPool();
        addThreadTask(cachedThreadPool);
    }

    //============================newSingleThreadExecutor()==================================
    public void singleThreadPoolTest(){
        //(1, 1,0L, TimeUnit.MILLISECONDS,
        ExecutorService singleThreadPool = Executors.newSingleThreadExecutor();
        addThreadTask(singleThreadPool);
    }

    //============================newFixedThreadPool()==================================
    public void fixedThreaddPoolTest(){
        //nThreads, nThreads,0L, TimeUnit.MILLISECONDS
        ExecutorService fixedThreaddPool = Executors.newFixedThreadPool(2);
        addThreadTask(fixedThreaddPool);
    }

    //============================newScheduledThreadPool()==================================
    public void scheduledThreadPoolTest(){

        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(3);
        scheduledThreadPool.schedule(new PoolRunnable2("0.5s"),500,TimeUnit.MICROSECONDS);
        scheduledThreadPool.schedule(new PoolRunnable2("2s"),2,TimeUnit.SECONDS);
        scheduledThreadPool.schedule(new PoolRunnable2("6s"),6,TimeUnit.SECONDS);
        scheduledThreadPool.schedule(new PoolRunnable2("8s"),8,TimeUnit.SECONDS);
        //corePoolSize, Integer.MAX_VALUE, 0, NANOSECONDS
//        ExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(3);
//        addThreadTask(scheduledThreadPool);
    }


    //==============================================================================
    //=============================BlockingQueueTest==================================
    //==============================================================================
    public void blockingQueueTest(){
        //SynchronousQueue
//        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(2,Integer.MAX_VALUE,60L,TimeUnit.MILLISECONDS,new SynchronousQueue<Runnable>());
//        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(2,4,0L,TimeUnit.MILLISECONDS,new SynchronousQueue<Runnable>());
//        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(1,Integer.MAX_VALUE,60L,TimeUnit.MILLISECONDS,new ArrayBlockingQueue<Runnable>(10));
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(1,Integer.MAX_VALUE,60L,TimeUnit.MILLISECONDS,new LinkedBlockingDeque<Runnable>(10));
//        threadPool.allowCoreThreadTimeOut(true);
        threadPool.submit(new PoolCallable());
        threadPool.submit(new PoolCallable());
        threadPool.submit(new PoolCallable());
        threadPool.submit(new PoolCallable());
        try {
            Thread.sleep(2000);
            threadPool.submit(new PoolCallable());
            threadPool.submit(new PoolCallable());
        }catch (Exception e){}
    }






    public void addThreadTask(ExecutorService threadPool){
        threadPool.execute(new PoolRunnable());
        threadPool.execute(new PoolRunnable());
        threadPool.submit(new PoolRunnable());
        threadPool.submit(new PoolRunnable());
        threadPool.submit(new PoolCallable());
        threadPool.submit(new PoolCallable());
        threadPool.submit(new PoolRunnable());
        threadPool.submit(new PoolCallable());
        threadPool.submit(new PoolCallable());
    }

    //============================接口的实现==================================
    class PoolRunnable implements Runnable{
        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            }catch (Exception e){}
            System.out.println("Runnable-----------"+Thread.currentThread().getName());
        }
    }

    class PoolCallable implements Callable<String>{
        @Override
        public String call() throws Exception {
            try {
                Thread.sleep(1000);
            }catch (Exception e){}
            System.out.println("Runnable-----------"+Thread.currentThread().getName());
            return new Date().toString();
        }
    }

    class PoolRunnable2 implements Runnable{
        private String msg = "";

        public PoolRunnable2(String msg){
            this.msg = msg;
        }
        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            }catch (Exception e){}
            System.out.println("PoolRunnable2------time:"+msg+"-----"+Thread.currentThread().getName());
        }
    }
}

package com.qwm.interview.ThreadDemo;

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
        instance.threadPoolExecutorTest();
//        instance.cacheThreadPoolTest();
//        instance.singleThreadPoolTest();
//        instance.fixedThreaddPoolTest();
//        instance.scheduledThreadPoolTest();
    }

    public void threadPoolExecutorTest(){
//        cachedThreadPool 修改 60L 可以看缓存的效果
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(0, Integer.MAX_VALUE,60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
        // singleThreadPool
//        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(1, 1,0L,TimeUnit.MILLISECONDS , new LinkedBlockingQueue<Runnable>());
        //fixedThreadPool
//        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(3,3,0L,TimeUnit.MILLISECONDS,new LinkedBlockingQueue<Runnable>());
      //  threadPool.allowCoreThreadTimeOut(true);//允许核心线程超时，就是可以被回收
        //scheduledThreadPool
//        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(2,Integer.MAX_VALUE,0L,TimeUnit.MILLISECONDS,new LinkedBlockingQueue());
//        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(0,3,60L,TimeUnit.MILLISECONDS,new LinkedBlockingQueue());
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
        //corePoolSize, Integer.MAX_VALUE, 0, NANOSECONDS
        ExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(3);
        addThreadTask(scheduledThreadPool);
    }

    public void addThreadTask(ExecutorService threadPool){
        threadPool.execute(new PoolRunnable());
        threadPool.execute(new PoolRunnable());
        threadPool.submit(new PoolRunnable());
        threadPool.submit(new PoolRunnable());
        threadPool.submit(new PoolCallable());
        threadPool.submit(new PoolCallable());
        try {
            Thread.sleep(3000);
            threadPool.submit(new PoolRunnable());
            threadPool.submit(new PoolCallable());
            threadPool.submit(new PoolCallable());
        }catch (Exception e){}
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
}

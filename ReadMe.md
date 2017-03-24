# java基础复习
[TOC]

## 一、集合 ##
### 1.Iterator   ###

---

### 2.Collection
#### 2.1 List--->有序、有索引、元素可重复 ####

1.ArrayList:  底层是数组结构、查询快、增删慢、不同步      
添加第一个元素的时候，创建默认个数是10个，如果超出了10个，就创建一个长度为 10+10>>1=15的数组       
2.LinkedList: 底层是链表结构、查询慢、增删快、不同步。双向链表       
3.Vector:     底层是数组结构、线程同步、被ArrayList取代 
判断是否存在和删除依赖的是equals方法
	 
	 
#### 2.2 Set --->无序、无索引、元素不可重复   

1.HashSet: 底层是Hash表，线程不同步，无序、高效 ---->内部使用的是一个HashMap集合key值当做我们存储的对象，value值是一个固定的Object对象
保证唯一性：元素hashCode和equals方法。hashCode方法相同，判断equals方法       
---LinkedHashSet: 有序，是HashSet的子类     
2.TreeSet: 底层是二叉树，可对元素进行排序，默认是自然顺序
保证唯一性：Comparable接口的comparaTo方法返回的值

#### 2.3 Collections 集合工具类
操作集合（一般是List集合）的工具类。方法全为静态的       
**sort(List list)** 对list集合排序     
**sort(List list,Comparator c)** 按指定比较器排序    
**fill(List list,T obj)** 将集合元素替换为指定对象     
**swap(List list,int i,int j)** 交换集合中指定位置的元素       
**shuffle(List list)**  随机对集合排序     
**reverseOrder()** 返回比较器，强行逆转，实现了Comparable接口的自然顺序     
**reverseOrder(Comparator c)** 返回比较器，强行逆转指定比较器的顺序    


---

### 3.Map

#### 3.1 HashMap: 底层数据结构是Hash表，允许存入null键和null值，不同步，高效

---LinkedHashMap: 底层数据结构是Hash表和双向链表           
 理解LinkedHashMap  http://www.cnblogs.com/children/archive/2012/10/02/2710624.html      
 JAVA实现链表面试题  http://blog.csdn.net/u010442302/article/details/51864187     
**com.qwm.interview.dataStruct.linked** java链表实现		 
		 
#### 3.2 HashTable: 底层数据结构是Hash表，不允许存入null键和null值，同步

Properties继承自HashTable，可保存在流中或从流中加载，是集合和IO流的结合产物
  
#### 3.3 TreeMap: 底层数据结构是二叉树，不同步，可排序

**com.qwm.interview.dataStruct.tree** 二叉树


---

### 4.Arrays
用于操作数组对象的工具类，全为静态方法    
**asList()** 将数组转为List集合   


---
            
            
## 二、IO

### 1.结构   
![结构](/img/iostruct.png)  

### 2.基本的流 
**字节流：InputStream,OutputStream**      
**字符流：Reader,Writer**
#### 2.1 字节流
```
InputStream
   ---ByteArrayInputStream  含缓冲数组，读取内存中字节数组的数组，未涉及到流
   ---FileInputStream   从文件中获取输入字节。 如：媒体文件
   ---FilterInputStream
      ---BufferedInputStream 带有缓冲区的字节输入流
      ---DataInputStream  数据输入流，读取基本数据类型的数据
   ---ObjectInputStream  用于读取对象的输入流
   ---PipedInputStream   管道流，线程间通信，与PipedOutputStream配合使用
   ---SequenceInputStream 合并流，将多个输入流逻辑串联  

OutputStream
   ---ByteArrayOutputStream
   ---FileOutputStream
   ---FilterOutputStream
      ---BufferedOutputStream
      ---DataOutputSream
      ---PrintStream 打印流
   ---ObjectOutputStream
   ---PipedOutputStream
```


#### 2.2 字符流
```
Reader
   ---BufferedReader
      ---LineNumberReader 带行号的字符缓冲输入流
   ---InputStreamReader
      ---FileReader 写入文件的便捷类
Writer
   ---BufferedWriter
   ---OutputStreamWriter
      ---FileWriter 
```


### 3.网络编程  

```
OSI参考模型              TCP/IP参考模型
----------------------------------------
   应用层                
   表示层                    应用层
   会话层
----------------------------------------   
   传输层                    传输层
----------------------------------------
   网络层                    网际层
----------------------------------------
 数据链路层
   物理层                 主机至网络层     
---------------------------------------- 
```

**TCP和UDP的区别**

|TCP|UDP|
|---|---|
| 建立连接，形成传输数据的通道 | 将数据及源和目的封装成数据包，***不需要建立连接***|
| 在连接中进行大量的数据传输 | 每个数据包的大小限制在 ***64k*** 内 |
| 通过三次握手完成连接，是可靠协议| 因无连接，是不可靠的|
| 必须建立连接，效率会降低| 不需要建立连接，速度快|


#### 3.1 Socket

Socket就是为网络服务提供的一种机制
通信两端都是Socket
网络通信其实就是Socket之间的通信
数据在两个Socket间通过IO传输

#### 3.2 UDP

**DatagramSocket DatagramPacket**



#### 3.3 UDP


## 三、多线程

### 1.线程和进程

### 2.Thread
```
1.定义一个类继承Thread
2.覆盖Thread中的run方法
3.直接创建Thread子类的对象
4.调用start方法
```

Thread是Runnable的一个实现类，
**run()** 中的 **target** 就是传递进来的Runnable对象（通过Runnable方式来启动线程的方式）
```
public class Thread implements Runnable{
 ....
    @Override
    public void run() {
        if (target != null) {
            target.run();
        }
    }
 ....
}
```

### 3.Runable
```
1.定义一个类实现Runnable接口
2.覆盖Runnable接口的run方法
3.通过Thread创建线程对象
4.并将Runnable接口的子类对象作为Thread类的构造函数参数进行传递
  作为参数传递的原因是让线程对象明确要运行的run方法所属的对象。
```
Runnable接口，只定义了一个 run()
```
public interface Runnable {
    public abstract void run();
}
```
如果我们两种方式都使用了，那么我们执行的是 继承的run()。其实Runnable方式我们执行到它run()方法，是在Thread的run()中调用了 Runnable示例target的run()。

### 4.Callable
#### 4.1 UML图
![结构](/img/FutureTask_uml.png)

#### 4.2 Callable
```
public interface Callable<V> {
    V call() throws Exception;
}
```

#### 4.3 Runnable
```
public interface Runnable {
    public abstract void run();
}
```

#### 4.4 Future
```
public interface Future<V> {
    boolean cancel(boolean mayInterruptIfRunning);
    boolean isCancelled();
    boolean isDone();
    V get() throws InterruptedException, ExecutionException;
    V get(long timeout, TimeUnit unit)
        throws InterruptedException, ExecutionException, TimeoutException;
}
```

#### 4.5 RunnableFuture
```
public interface RunnableFuture<V> extends Runnable, Future<V> {
    void run();
}
```

#### 4.6 FutureTask
```
public class FutureTask<V> implements RunnableFuture<V> {
  ...
}
```

### 5. 线程池
[深入分析java线程池的实现原理](http://www.jianshu.com/p/87bff5cc8d8c)
#### 5.1 ThreadPoolExecutor
```
public ThreadPoolExecutor(int corePoolSize,
                          int maximumPoolSize,
                          long keepAliveTime,
                          TimeUnit unit,
                          BlockingQueue<Runnable> workQueue) {
                              ...
    }

public ThreadPoolExecutor(int corePoolSize,
                          int maximumPoolSize,
                          long keepAliveTime,
                          TimeUnit unit,
                          BlockingQueue<Runnable> workQueue,
                          ThreadFactory threadFactory) {
                              ...
  }

public ThreadPoolExecutor(int corePoolSize,
                          int maximumPoolSize,
                          long keepAliveTime,
                          TimeUnit unit,
                          BlockingQueue<Runnable> workQueue,
                          RejectedExecutionHandler handler) {
                          ...
}

public ThreadPoolExecutor(int corePoolSize,
                          int maximumPoolSize,
                          long keepAliveTime,
                          TimeUnit unit,
                          BlockingQueue<Runnable> workQueue,
                          ThreadFactory threadFactory,
                          RejectedExecutionHandler handler) {
                         ...
}

```

|参数| 说明 |
|----|----|
|corePoolSize| 核心线程数 |
|maximumPoolSize| 最大线程数|
|keepAliveTime|存活时间 |
|unit| 时间单位|
|...|...|

#### 5.2 Executors
##### 5.2.1 newCachedThreadPool()
```
    public static ExecutorService newCachedThreadPool() {
        return new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                                      60L, TimeUnit.SECONDS,
                                      new SynchronousQueue<Runnable>());
    }
```

##### 5.2.2 newSingleThreadPool()
```
    public static ExecutorService newSingleThreadExecutor() {
        return new FinalizableDelegatedExecutorService
            (new ThreadPoolExecutor(1, 1,
                                    0L, TimeUnit.MILLISECONDS,
                                    new LinkedBlockingQueue<Runnable>()));
    }
```

#####  5.2.3 newFixedThreadPool()
```
    public static ExecutorService newFixedThreadPool(int nThreads) {
        return new ThreadPoolExecutor(nThreads, nThreads,
                                      0L, TimeUnit.MILLISECONDS,
                                      new LinkedBlockingQueue<Runnable>());
    }
```

#####  5.2.4 newScheduledThreadPool()
```
    public static ScheduledExecutorService newScheduledThreadPool(int corePoolSize) {
        return new ScheduledThreadPoolExecutor(corePoolSize);
    }
```

```
    public ScheduledThreadPoolExecutor(int corePoolSize) {
        super(corePoolSize, Integer.MAX_VALUE, 0, NANOSECONDS,
              new DelayedWorkQueue());
    }
```

##### 5.2.5 几种队列的说明
[java自带线程池和队列详细讲解](http://blog.csdn.net/sd0902/article/details/8395677)

[Java并发包中的同步队列SynchronousQueue实现原理](http://ifeve.com/java-synchronousqueue/)

|BlockingQueue| 说明 |
|----|----|
|SynchronousQueue|  |
|ArrayBlockingQueue|  |
|LinkedBlockingQueue|  |
|DelayedWorkQueue|  |




集合
    --Collection
       有序、元素可重复、有索引
         --List
            结构不同
              --ArrayList   删除和增加都是根据 equals 方法
              --LinkedList  删除和增加都是根据 equals 方法
         --Set
            结构不同
              --HashSet （哈希表） hashCode  equals
                ---LinkedHashSet 有序的
              --TreeSet  （二叉树） 可对元素进行排序，默认是自然顺序
                比较:
                 -- Comparator---->compare
                 -- Comparable---->compareTo

    --Map
       ---HashTable 哈希表 键值不能为null 同步
       ---HashMap   哈希表 键值都能为null 不同步
       ---TreeMap   二叉树  排序


    集合工具类
    Collections (一般是list集合)工具类，静态方法
       --sort(list)
       --sort(list,comparator)
       --fill(list,obj) 将集合元素替换为指定的元素
       --swap(list,i,j)
       --shuffle(list)随机排序(洗牌)
       --reverse
       --reverseOrder()
       --reverseOrder(comparator)



IO
  字节流
     --InputStream
       --ByteArrayInputStream
       --FileInputStream
          --BufferedInputStream
          --DataInputStream
       --ObjectInputStream
       --PipedInputStream
       --SequenceInputStream
     --OutputStream
       --ByteArrayOutputStream
       --FileOutputStream
        --BufferedOutputStream
        --DataOutputStream
        --PrintStream
       --ObjectOutputStream
       --PipedOutputStream
  字符流
     --Reader
     --Writer


网络编程
 udp  http://blog.csdn.net/qiwenmingshiwo/article/details/46196223
 tcp  http://blog.csdn.net/qiwenmingshiwo/article/details/46203307
 http://blog.csdn.net/qiwenmingshiwo/article/details/46279577
 http://blog.csdn.net/qiwenmingshiwo/article/details/46284681

 socket
 udp
   DatagramSocket  udp的发送到和接收端  DatagramScoket
   DatagramPacket  数据包 DatagramPacket

     DatagramSocket
       --send(dp)
       --receive(dp)
 tcp
   Socket
   ServerSocket
   DataOutputStream
   DataInputStream

    Socket
      getInputStream
      getOutputStream
    ServerSocket
      accept

进程和线程
  --Thread
  --Runnable
  --Callable
    --ExecutorService
    --Callable
    --Future
      --FutureTask Future的唯一实现类

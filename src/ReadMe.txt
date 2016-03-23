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


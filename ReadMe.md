#java基础复习
[TOC]

##一、集合
###1.Iterator   

---

###2.Collection
####2.1 List--->有序、有索引、元素可重复

1.ArrayList:  底层是数组结构、查询快、增删慢、不同步      
添加第一个元素的时候，创建默认个数是10个，如果超出了10个，就创建一个长度为 10+10>>1=15的数组       
2.LinkedList: 底层是链表结构、查询慢、增删快、不同步。双向链表       
3.Vector:     底层是数组结构、线程同步、被ArrayList取代 
判断是否存在和删除依赖的是equals方法
	 
	 
####2.2 Set --->无序、无索引、元素不可重复   

1.HashSet: 底层是Hash表，线程不同步，无序、高效 ---->内部使用的是一个HashMap集合key值当做我们存储的对象，value值是一个固定的Object对象
保证唯一性：元素hashCode和equals方法。hashCode方法相同，判断equals方法       
---LinkedHashSet: 有序，是HashSet的子类     
2.TreeSet: 底层是二叉树，可对元素进行排序，默认是自然顺序
保证唯一性：Comparable接口的comparaTo方法返回的值

####2.3 Collections

---

###3.Map

####3.1 HashMap: 底层数据结构是Hash表，允许存入null键和null值，不同步，高效

---LinkedHashMap: 底层数据结构是Hash表和双向链表           
 理解LinkedHashMap  http://www.cnblogs.com/children/archive/2012/10/02/2710624.html      
 JAVA实现链表面试题  http://blog.csdn.net/u010442302/article/details/51864187     
**com.qwm.interview.dataStruct.linked** java链表实现		 
		 
####3.2 HashTable: 底层数据结构是Hash表，不允许存入null键和null值，同步

Properties继承自HashTable，可保存在流中或从流中加载，是集合和IO流的结合产物
  
####3.3 TreeMap: 底层数据结构是二叉树，不同步，可排序

**com.qwm.interview.dataStruct.tree** 二叉树	
学习笔记
==
数据结构
-
>`一维:`<br>
 >>* 数组array<br>
    特征：数组静态分配内存，在内存中连续<br>
    优点:随机访问性强（通过下标进行快速定位,查找速度快<br>
    缺点:<br>
       1.插入和删除效率低（插入和删除需要移动数据）<br>
       2.可能浪费内存（因为是连续的，所以每次申请数组之前必须规定数组的大小，如果大小不合理，则可能会浪费内存）<br>
       3.内存空间要求高，必须有足够的连续内存空间<br>
       4.数组大小固定，不能动态拓展<br>
 >>* 链表: linked list<br> 
    特征：链表是动态分配内存在内存中不连续，单链表只有一个向下的指针，指向下一个节点，单链表的定位时间复杂度是O(n)，插入删除的时间复杂度是O(1)<br> 
    优点:<br>
        1.插入删除速度快（因为有next指针指向其下一个节点，通过改变指针的指向可以方便的增加删除元素）<br>
        2.内存利用率高，不会浪费内存（可以使用内存中细小的不连续空间（大于node节点的大小），并且在需要空间的时候才创建空间）<br>
        3.大小没有固定，拓展很灵活<br>
        4.不需要初始化容量，可以任意加减元素<br>
        5.添加或者删除元素时只需要改变前后两个元素结点的指针域指向地址即可，所以添加，删除很快<br>
    缺点:不能随机查找，必须从第一个开始遍历，查找效率低<br>
        

  >>* 高级：栈 stack, 队列 queue, 双端队列 deque, 集合 set, 映射 map (hash or map), etc<br>
       Stack:先进后出，后进先出,基于动态数组或链表实现，主要方法peek(),pop()时间复杂度:只涉及头部操作O(1),设计栈尾O(n)<br>
       Queue:先进先出，后进后出,基于动态数组或链表实现,主要方法getFront(),enqueue(E e),dequeue()<br>
       Deque:双端队列，既实现了栈Stack，又实现了队列Queue,主要方法:addfirst(),offerFirst(),removeFirst(),pollFirst(),getFirst(),peekFirst()<br>

算法复杂度:
---
          O(1): Constant Complexity 常数复杂度<br>
          O(log n): Logarithmic Complexity 对数复杂度<br>
          O(n): Linear Complexity 线性时间复杂度<br>
          O(n^2): N square Complexity 平方<br>
          O(n^3): N cubic Complexity 立方<br>
          O(2^n): Exponential Growth 指数<br>
          O(n!): Factorial 阶乘<br>
  
  
  
 作业：
 -
```java
Deque<String> deque = new LinkedList<String>();
    deque.push("a");
    deque.push("b");
    deque.push("c");
    System.out.println(deque);

    String str = deque.peek();
    System.out.println(str);
    System.out.println(deque);

    while(deque.size()>0){
        System.out.println(deque.pop());
    }
    System.out.println(deque);

// 新接口的实现
Deque<String> deque = new LinkedList<String>();
    deque.addLast("a");
    deque.addLast("b");
    deque.addLast("c");
    System.out.println(deque);

    String str = deque.peek();
    System.out.println(str);
    System.out.println(deque);

    while(deque.size()>0){
        System.out.println(deque.pop());
    }
    System.out.println(deque);
```

刷题心得:<br>
---
  由于之前没有刷过leetcode上的题，基础薄弱第一次遇到比较慌，没思路喜欢死磕，看了五毒神掌后刷了三遍，对于数组的操作时间空间复杂度分析开始入了门，能通过暴力求解解决一些比较简单的问题，后面还会坚持刷题加大遍数.<br>

---
 参考链接:https://zhuanlan.zhihu.com/c_1213528985856188416

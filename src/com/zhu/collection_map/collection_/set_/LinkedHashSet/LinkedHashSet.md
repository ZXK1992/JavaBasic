# 1.LinkedHashSet的全面说明
    1）LinkedHashSet是HashSet的子类
    2）LinkedHashSet底层是一个LinkedHashMap，底层维护了一个数组+
       双向链表
    3）LinkedHashSet根据元素的hashCode值来决定元素的存储位置，同时使
       用链表维护元素的次序，这使得元素看起来是以插入顺序保存的。
    4）LinkedHashSet不允许添加重复元素

    说明：
        1）在LinkedHashSet中维护了一个hash表和双向链表
           (LinkedHashSet有head和tail)
        2）每一个结点有before和after属性，这样可以形成双向链表
        3）在添加一个元素时，先求hash值，再求索引，确定该元素在
           table的位置，然后将添加的元素加入到双向链表（如果已经存在
           ，不添加[原则和hashset一样]）
           tail.next=newElement;//示意代码
           newElement.pre=tail;
           tail=newElement;
        4)这样的话，我们遍历LinkedHashSet也能确保插入顺序和遍
          历顺序一致
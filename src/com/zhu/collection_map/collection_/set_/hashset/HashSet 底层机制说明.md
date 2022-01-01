#1.HashSet 底层机制说明
    分析HashSet底层是HashMap，HashMap底层是（数组+链表+红黑树）
        1.先获取元素的哈希值（hashCode方法）
        2.对哈希值进行运算，得出一个索引值即为要存放在哈希表中的位置号
        3.如果该位置上没有其他元素，则直接存放
          如果该位置上已经有其他元素，则需要进行equals判断，如果相等，则不再添加
          如果不相等，则以链表的方式添加
    分析HashSet的添加元素底层是任何实现
        1. HashSet底层是HashMap，HashMap底层是（数组+链表+红黑树）
        2.添加一个元素时，先得到hash值--会转成-->索引值
        3.找到存储数据表table，看这个索引位置是否已经存放的有元素
        4.如果没有，直接加入
        5.如果有，调用equals方法比较，如果相同，就放弃添加，如果不相同，则添加
        到最后
        6.在Java8中，如果一条链表的元素到达TREEIFY_THRESHOLD（默认是8），并且table
        的大小>=MIN_TREEIFY_CAPACITY(默认64），就会进行树化（红黑树）

#2.分析HashSet的扩容和转成红黑树机制
    1.HashSet底层是HashMap，第一次添加时，table数组扩容到16，临界值
      （threshold）是16*加载因子（loadFactor）是0.75=12
    2.如果table数组使用到了临界值12，就会扩容到16*2=32，新的临界值
      就是32*0.75=24，依次类推
    3.在Java8中，如果一条链表的元素个数到达TREEIFY_THRESHOLD（默认是8），
      并且table的大小>=
      MIN_TREEIFY_CAPACITY(默认64),就会进行树化(红黑树),否则仍然采用数组扩容机制

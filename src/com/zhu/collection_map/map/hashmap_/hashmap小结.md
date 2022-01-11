# 1.HashMap小结
    1）Map接口的常用实现类：HashMap，hashtable 和 Properties
    2)HashMap是Map接口使用频率最高的实现类
    3）HashMap是以key-value对的方式来存储数据（HashMap$Node类型）
    4）key不能重复，但是值可以重复，允许使用null键和null值
    5）如果添加相同的key，则会覆盖原来的key-value，等同于修改（key包含替换，value会替换）
    6）与hashSet一样，不能保证映射顺序，因为底层是以hash表的方式来存储的（jdk8 HashMap底层：
       数组+链表+红黑树）
    7）HashMap没有实现同步，因此是线程不安全的，方法没有做同步互斥的操作，没有synchronized

# 2.HashMap底层机制及源码剖析
    1）(k,v)是一个Node实现了Map。Entry<K,V>,查看HashMap的原码可以看到
    2）jdk7的HashMap底层实现[数组+链表]，jdk8底层[数组+链表+红黑树]
    扩容机制[和HashSet相同]
    1)HashMap底层维护Node类型数组table,默认null；
    2）当创建对象时，将加载因子（loadfactor）初始化0.75
    3）当添加key-value时，通过key的哈希值得到table的索引。然后判断该索引处是否有元素，
       如果没有元素直接添加，如果该索引处有元素继续判断该元素的key和准备加入的key是否
       相等，如果相等，则直接替换val,如果不相等需要判断是树结构还是链表结构，做出相应
       处理。如果添加时发现容量不够，则需要扩容。
    4）第1次添加，则需要扩容table容量为16，临界值(threshold)为12 (16*0.75)
    5)以后再扩容，则需要扩容table容量为原来的2倍(32),临界值为原来的对倍，即24，依次类推，
    6）在Java8中，如果一条链表的元素个数超过TREEIFY_THRESHOLD（默认是8），并且table
       的大小>=MIN_TREEIFY_CAPACITY(默认64)，就会进行树化(红黑树）


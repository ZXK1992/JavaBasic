# 1.hashtable的基本介绍
    1）存放的元素是键值对：即k-v
    2）hashtable的键和值都不能为null，否则会抛出NullPointerExcption
    3）hashtable使用方法和hasmap一样
    4）hashtable是线程安全的（synchronized),hashmap是线程不安全的
# 2.Hashtable和HashMap对比
    出来的版本：
        HashMap：1.2
        Hashtable：1.0
    线程安全（同步）
        HashMap：不安全
        Hashtable：安全
    效率
        HashMap：高
        Hashtable：较低
    允许null键null值
        HashMap：可以
        Hashtable：不可以
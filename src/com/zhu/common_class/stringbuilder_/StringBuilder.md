# 1.StringBuilder基本介绍
    1）一个可变的字符序列，此类提供一个与StringBuffer兼容的API，
       但不保证同步（StringBuilder不是线程安全）。该类被设计用作
       StringBuffer的一个简易替换，用在字符串缓冲区被耽搁线程使用
       的时候。如果可能，建议优先采用该类，因为在大多数实现中，他
       比StringBuffer要快。
    2）在StringBuilder上的主要操作是append和insert方法，可重载
       这些方法，以接受任意类型的数据。
# 2.StringBuilder常用方法
    1. StringBuilder和 StringBuffer均代表可变的字符序列，方法是一样的，所以
      使用和StringBuffer一样。
    2. StringBuilder是final类不能被继承
    3. 继承AbstractStringBuilder，属性char[]value,内容存到value
      因此，字符序列是堆中
      实现了Serializable，可序列化，(对象可以网络传输,可以保存到文件
    4. StringBuilder 的方法，没有做互斥的处理,即没有 synchronized 关键字,
      因此在单线程的情况下使用

# 3.String、StringBuffer和StringBuilder的比较
    1）StringBuffer和StringBuilder非常类似，均代表可变字符序列，而且方法
       也一样
    2）String：不可变字符序列，效率低，但是复用率高
    3）StringBuffer：可变字符序列、效率较高（增删）、线程安全
    4）StringBuilder：可变字符序列、效率最高）、线程不安全
    5）String使用注意说明：
       String s="a";//创建了一个字符串
       s+="b";//实际上原来的"a"字符串对象已经丢弃了，现在又产生了一个
       字符串s+"b"(也就是"ab")。如果多次执行这些改变串内容的操作，会导
       致大量副本字符串对象存留在内存中，降低效率。如果这样的操作放到循
       环中会极大影响程序的性能 => 结论：如果我们对String做大量的修改不
       要使用String

# 4.String、StringBuffer和StringBuilder的执行效率
    StringBuilder > StringBuffer > String

# 5.String、StringBuffer 和 StringBuilder 的选择
    使用的原则，结论：
        1.如果字符串存在大量的修改操作，一般使用StringBuffer或StringBuilder
        2.如果字符串存在大量的修改操作,并且在单线程情况，使用StringBuilder
        3.如果字符串存在大量的修改操作,并且在多线程情况，使用StringBuffer
        4.如果我们字符串很少修改,被多个对象引用，使用String，比如配置信息等
    StringBuffer的方法使用 和 StringBuilder 一样


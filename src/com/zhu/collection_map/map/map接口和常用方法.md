# 1. Map 接口实现类的特点
    注意：这里讲的是JDK8的Map接口特点
    1）Map与Collection并列存在。用于保存具有映射关系的数据：Key-Value；
    2）Map中的key和value可以是任何引用类型的数据，会封装到HashMap$Node
       对象中
    3）Map中的key不允许重复，原因和HashSet一样
    4）Map中的value可以重复
    5）Map的key可以为null，value也可以为null，注意key为null只能有一个，
       value为null，可以多个
    6）常用String类作为Map的key
    7)key和value之间存在单向一对一关系，即通过指定的key总能找到对应的value
    8）Map存放数据的key-value是放在一个HashMap$Node中的，又因为Node实现了Entry
       接口，有些书上也说一堆key-value就是一个Entry
# 2.Map遍历方式
    1）containsKey：查找键是否存在
    2）keySet：获取所有的键
    3）entrySet：获取所有的关系k-v
    4）values：获取所有的值
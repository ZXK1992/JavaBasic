# 底层结构
    ArrayList：可变数组Object[] elementData
    Vector：   可变数组Object[] elementData
# 出来的版本
    ArrayList ：jdk1.2
    Vector  ：jdk1.0
# 线程安全（同步）效率
    ArrayList ：不安全，效率高
    Vector  ：安全，效率低
# 扩容倍数
    ArrayList ：
        如果有参构造1.5倍
        如果是无参构造
            1.第一次10
            2.从第二次开始按1.5倍扩容
    Vector  ：
            如果是无参构造，默认10，满后，就按2倍扩容
            如果指定大小，则每次按照2倍扩容


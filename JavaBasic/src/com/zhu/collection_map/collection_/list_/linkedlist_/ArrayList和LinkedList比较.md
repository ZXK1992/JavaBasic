#1. ArrayList 和 LinkedList 的比较
    底层结构：
        ArrayList：可变数组
        LinkedList：双向链表
    增删效率：
       ArrayList：较低，由于涉及数组扩容
       LinkedList：较高，通过链表追加
    改查效率：
        ArrayList：较高
        LinkedList：较低
    如何选择ArrayList和LinkedList：
        1）如果我们改查操作多，选择ArrayList
        2）如果我们增删操作多，选择LinkedList
        3）一般来说，在程序中，80%-90%都是查询，因此大部分情况下选择ArrayList
        4）在一个项目中，根据业务灵活选择，也可以这样，一个模块使用的是ArrayList，
           另一个模块是LinkedList，也就是说，要根据业务来选择

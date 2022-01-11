# 1.Collection接口实现类的特点
    1）collection实现子类可以存放多个元素，每个元素可以是Object
    2）有些Collection的实现类，可以存放重复的元素，有些不可以
    3）有些Collection的实现类，有些是有序的(List)，有些不是有序(Set)
    4)Collection接口没有直接的实现子类，是通过它的子接口Set和List来
      实现的
# 2. Collection 接口遍历元素方式
    1.使用Iterator(迭代器)
        基本介绍
        1）Iterator对象称为迭代器，主要用于遍历Collection集合元素
        2）所有实现了Collection接口垫集合类都有一个iterator()方法，用以
           返回一个实现了Iterator接口的对象，即可以返回一个迭代器。
        3）Iterator仅用于遍历集合，Iterator本身并不存放对象
        迭代器的执行原理
        Iterator iterator=coll.iterator();//得到一个集合的迭代器
        //hasNext();判断是否还有 下一个元素
        while(iterator.hasNext()){
        //next()作用：1.下移 2.将下移以后集合位置上的元素返回
        System.out.println(iterator.next())
        }
         提示：在调用iterator.next()方法之前必须要调用iterator.hasNext()
         进行检测。若不调用，且下一条记录无效，直接调用iterator.next()会
         抛出NoSuchElementException异常。
    2.增强for循环遍历
        增强for循环，可以代替Iterator迭代器，特点：增强for就是简化版的iterator
        ，本质一样，只能用于遍历集合或数组
        基本语法
         for (元素类型 元素名 : 集合或数组名) {
                    访问元素
                }
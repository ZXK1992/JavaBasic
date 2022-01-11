# 1.List接口基本介绍
    List接口是Collection接口的子接口
    1）List集合类中元素有序（即添加顺序和取出顺序一致）、且可重复
    2）List集合类中的每个元素都有其对应的顺序索引，即支持索引
    3）List容器中的元素都对应一个整数型的序号记载其在容器中的位置
      ，可以根据序号存取容器中的元素。
    4）JDK API中List接口实现类常用有：
       ArrayList、LinkedList和Vector
# 2.List 的三种遍历方式 [ArrayList, LinkedList,Vector]
    1）方式一：使用Iterator
    Iterator iterator = list.iterator();
    while(iterator.hasNext()){
    Object obj = iterator.next();
    }
    2)方式二：使用增强for
    for(Object obj:list){
    }
    3)方式三：使用普通for
     for (int i = 0; i < list.size(); i++) {
            Object o = list.get(i);
            System.out.println(o);
        }
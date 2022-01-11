# 1.Collections工具类介绍
    1)Collections是一个操作Set，List，Map等集合的工具类
    2）Collections中提供了一系列静态的方法对集合元素进行排序
# 2.排序操作（均为static方法）
    1）reverse（list）：反转list中的元素顺序
    2）shuffle（list）：对list集合元素进行随机排序
    3）sort（list）：根据元素的自然顺序对指定List集合元素按升序排序
    4）sort（list，Comparator）:根据指定的Comparator产生的顺序对list排序
    5）swap（list，int，int）：将指定list集合中的i处元素进行交换
# 3.查找、替换
    1）object max（collection）:根据元素的自然顺序，返回给定集合中的最大元素
    2）object max（collection,Comparator）:根据Comparator中的顺序，返回给定集合的最大元素
    3）object min（collection）:
    4）object min（collection，Comparator）：
    5）int frequency（collection，object）：返回指定集合中指定元素的出现次数
    6）void copy（List desc,List src）:将src中的内容复制到dest中
    7）boolean replaceAll（List list，Object oldVal，Object newVal）：使用新值替换L斯坦对象的所有旧值

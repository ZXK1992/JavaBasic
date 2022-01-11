# 1.String 类的理解和创建对象
    1）String对象用于保存字符串，也就是一组字符序列
    2）字符串常量对象是用双引号括起的字符序列
    3）字符串的字符使用Unicode字符编码，一个字符(不区分字母还是汉字）
       占两个字节
    4)常用的构造器有
       String s1 = new String(); //
      //String s2 = new String(String original);
      //String s3 = new String(char[] a);
      //String s4 = new String(char[] a,int startIndex,int count)
      //String s5 = new String(byte[] b)
# 2.String 的创建对象的方式
    1）方式一：直接赋值String s ="zxk";
    2）方式二：调用构造器String s2 = new String("zxk");
    区别：
        1.方式一：先从常量池查看是否有"zxk"数据空间，如果有，直接指向；
          如果没有则重新创建，然后指向。s最终指向的是常量池的空间地址
        2.方式二：先在堆中创建空间，里面维护了value属性，指向常量池的
          "zxk"空间，如果常量池没有"zxk"，重新创建，如果有，直接通过
          value指向，最终指向的是堆中的空间地址
    知识点：当调用intern方法时，如果池已经包含一个等与此String对象的字符串
    (用equals(Object)方法确定),则返回池中的字符串。否则，对此String对象添
    加到池中，并返回此String对象的引用
    调用intern方法最终返回的是常量池的地址(对象）。
# 3.字符串的特性
    1)String是一个final类，代表不可变字符序列
    2)字符串是不可变的，一个字符串对象一旦被分配，其内容是不可变的
# 4.String常用方法（可参考StringMethod.Java）
    说明：String类是保存字符串常量的。每次更新都需要重新开辟空间，效率较低
    equals 区分大小写，判断内容是否相等
    equalsIgnoreCase 忽略大小写判断内容是否相等
    length 获取字符的个数，字符串的长度
    indexOf 获取字符在字符串中第一次出现的索引，索引从0开始，如果找不到，返回-1
    lastIndexOf 获取字符在字符串中最后一次出现的索引，索引从0开始，如果找不到，返回-1
    substring 截取指定范围的子串
    trim 去前后空格
    charAt 获取某索引处的字符，注意不能使用Str[index]这种方式。
    toUpperCase 转换成大写
    toLowerCase 转换成小写
    concat 拼接字符串
    replace替换字符串中的字符
           返回的结果才是替换过的
    split 分割字符串，对于某些分割字符，我们需要转义比如| \\等
          在对字符串进行分割时，如果有特殊字符，需要加入 转义符 \
    compareTo 比较两字符串的大小
              1）如果前者大，返回正数，后者大返回负数，相等返回0
              2）如果长度相同，并且每个字符也想通，就返回0
              3）如果长度相同或者不相同，但是进行比较时，可以区分大小
              //c1表示前面的字符，出表示后面的字符
              // 就返回 if (c1 != c2) {
              // return c1 - c2;
              // }
              4）如果前面的部分都相同，就返回str1.len - str2.len（str1表示前面的字符串，
              str2表示后面的字符串）
    toCharArray转换成字符数组
    format 格式字符串，
            %s 字符串
            %c字符
            %d 整型
            %.2f 浮点型 ，替换后，只会保留小数点两位, 并且进行四舍五入的处理



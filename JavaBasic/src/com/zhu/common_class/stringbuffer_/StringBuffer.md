#1.StringBuffer的基本介绍
    StringBuffer代表可变的字符序列，可以对字符串内容进行增删。
    很多方法与String相同 ，但StringBuffer是可变长度的
    StringBuffer是一个容器
#2.String与StringBuffer比较
    1）String保存的是字符串常量，里面的值不能更改，每次String类的
       更新实际上就是更改地址，效率较低//private final char value[];
    2) StringBuffer保存的是字符串变量，里面的值可以更改，每次
       StringBuffer的更新实际上可以更新内容，不用每次更新地址，
       效率较高 //char []value;//这个放在堆里
       
#3. String 和 StringBuffer 相互转换
    String->StringBuffer
    //方式 1 使用构造器
    //注意： 返回的才是 StringBuffer 对象，对 str 本身没有影响
    StringBuffer stringBuffer = new StringBuffer(str);
    //方式 2 使用的是 append 方法
    StringBuffer stringBuffer1 = new StringBuffer();
    stringBuffer1 = stringBuffer1.append(str);
    //看看 StringBuffer ->String
    StringBuffer stringBuffer3 = new StringBuffer("韩顺平教育");
    //方式 1 使用 StringBuffer 提供的 toString 方法
    String s = stringBuffer3.toString();
    //方式 2: 使用构造器来搞定
    String s1 = new String(stringBuffer3);
#4. StringBuffer 类常见方法
    [参考StringBufferMethod.java]

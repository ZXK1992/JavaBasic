# 1.基本介绍
    1.Class也是类,因此也继承Object类
2.Class类对象不是new出来的,而是系统创建的
3.对于某个类的Class类对象,在内存中只有一份,因为类只加载一次
4.每个类的实例都会记得自己是由哪个Class实例所生成
5.通过Class对象可以完整地得到一个类的完整结构,通过一系列API
6.Class对象是存放在堆中的
7.类的字节码二进制数据,是放在方法区的.有的地方称为类的元数据
(包括方法代码,变量名,方法名,访问权限等等)
https://www.zhihu.com/question/38496907[示意图]
## 2.Class类的常用方法
    static Class forName    返回指定类名name的Class对象
    Object newInstance()    调用缺省构造函数,返回该Class对象的一个实例
    getName()               返回此Class对象所表示的实例(类,接口,数组类,基本类型等)
    Class[] getInterface            获取当前Class对象的接口
    ClassLoader getClassLoader()     返回该对象的类加载器
    Class getSuperClass()             返回表示此Class所表示的实体的超类的Class
    Constructor[] getConstructors()   返回表示一个包含某些Constructor对象的数组
    Filed [] getDeclaredFields()     返回Field对象的一个数组
    Method getMethod(String name, Class<?>... parameterTypes) 返回一个Method对象,此对象的形参类型为paramType
## 4.获取Class类对象
    1.前提:已知一个类的全类名,且该类在类路径下,可通过Class类的静态方法
        forName()获取,可能抛出ClassNotFoundException,实例:Class cls1=
        Class.forName("java.lang.Cat");
        应用场景:多用于配置文件,读取类全路径,加载类
    2.前提:若一致具体的类,通过类的class获取,该方式最为安全可靠,程序性能
        最高,实例:Class cls2=Cat.class;
        应用场景:多用于参数传递,比如通过反射得到对应构造器对象
    3.前提:已知某个类的实例,调用该实例的getClass()方法获取Class对象,实例:
        Class clazz=对象.getClass();//运行类型
        应用场景:通过创建好的对象,获取Class对象
    4.其他方式
    ClassLoader cl = 对象.getClass().getClassLoader();
    Class clazz4 = cl.loadClass("类的全类名");
    5.基本数据(int,char,byte,shot,long,float,double,boolean),按如下方式得到Class类
        对象
        Class cls = 基本数据类型.class;
    6.基本数据类型对应的包装类,可以通过.TYPE得到Class类对象
Class cls = 包装类.TYPE


# 1.前面两代日期类的不足分析
    JDK1.0中包含java.util.Date类，但是它的大多数方法已经在JDK1.1
    引入Calendar类之后被弃用了，而Calendar也存在问题是：
    1）可变性：像日期和时间这样的类应该是不可变的。
    2）偏移性：Date中的年份是从1900开始的，而且月份都从0开始
    3）格式化： 格式化只对Date有用，Calendar则不行
    4）此外，他们也不是线程安全的；不能处理闰秒等（每隔两天，多出1s)

    1)LocalDate（日期/年月日），LocalTime（时间/时分秒）、LocalDateTime
      日期时间/年月日时分秒）JDK8加入
      LocalDate只包含日期，可以获取日期字段
      LocalTime只包含时间，可以获取时间字段
      LocalDateTime包含日期+时间，可以获取日期和时间字段
# 2.DateTimeFormatter格式日期类
    类似SimpleDateFormat
     DateTimeFormatter dtf = DateTimeFormatter.ofPattern(格式);
     String str = dtf.format(日期对象);
# 3.Instant时间戳
    类似于Date
    提供了一系列和Date类转换的方式
    Instant————>Date:
    Date date = Date.from(instant);
    Date————>Instant:
    Instant instant = date.toInstant();





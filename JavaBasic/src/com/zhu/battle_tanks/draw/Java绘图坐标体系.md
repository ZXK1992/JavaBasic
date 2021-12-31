#1 坐标体系-介绍
    坐标原点位于左上角，以像素为单位。在Java坐标系中第一
    个是x坐标，表示当前位置为水平方向，距离坐标原点x个像素；
    第二个是y坐标，表示当前位置为垂直方向，距离坐标原点y个
    像素
#2 坐标体系-像素
    1.绘图还必须要搞清楚一个非常重要的概念-像素
    2.计算机在屏幕上显示的内容都是由屏幕上的每一个像素组成的。
      例如，计算机显示器的分辨率是800X600,表示计算机屏幕上每
      一行由800个点组成，共有600行，整个计算机屏幕公有480000
      个像素。像素是一个密集单位
#3 绘图原理
    Component类提供了两个和绘图相关最重要的方法
    1.paint(Graphics g)绘制组件的外观
    2.repaint()刷新组件外观
    当组件第一次在屏幕显示的时候，程序会自动的调用paint()方法来绘制组件
    在以下情况paint()将会被调用
    1.窗口最小化，再最大化
    2.窗口的大小发生变化
    3.repaint方法被调用
#4.Graphics 类
    Graphics 类你可以理解就是画笔，为我们提供了工资绘制图形的方法
    1.画直线drawLine(int x1,int y1,int x2,int y2)
    2.画矩形边框drawRect(int x, int y, int width, int height)
    3.画椭圆边框drawOval(int x, int y, int width, int height)
    4.填充矩形fillRect(int x, int y, int width, int height)
    5.填充椭圆 fillOval(int x, int y, int width, int height)
    6.画图片drawImage(Image img, int x, int y, ..)
        //1. 获取图片资源, /bg.png 表示在该项目的根目录去获取 bg.png 图片资源
        // Image image = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bg.png"));
        // g.drawImage(image, 10, 10, 175, 221, this);
    7.画字符串drawString(String str, int x, int y)
        //这里设置的 100， 100， 是 "北京你好"左下角
        g.drawString("北京你好", 100, 100);
    8.设置画笔的字体setFont(Font font)
    9.设置画笔的颜色setColor(Color c)

        //给画笔设置颜色和字体
        g.setColor(Color.red);
        g.setFont(new Font("隶书", Font.BOLD, 50));

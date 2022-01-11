# 基本介绍
    1）专门用于读写配置文件的集合类
        配置文件的格式：
        键=值
        键=值
    2）注意：键值对不需要有空格，值不需要用引号引起了，默认类型String
    3）Properties的常见方法
        load加载配置文件的键值对到Properties对象
        list将数据显示到指定设备
        getProperty(key)根据键获取值
        setProperty(key,value)设置键值对到Properties对象
        store将Properties中的键值对存储到配置文件，在idea中，保存信息到配置文件
           如果含有中文，会存储Unicode码
> 应用案例

    1.使用Properties类完成对mysql.Properties的读取
    2.使用Properties类添加到新文件mysql2.Properties中
    3.使用Properties类完成对mysql2.Properties的读取，并修改某个key-value


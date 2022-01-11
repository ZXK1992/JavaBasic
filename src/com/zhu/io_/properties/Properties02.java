package com.zhu.io_.properties;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * @author: ZHUXIAOKANG
 * @date: 2022/1/9 22:17
 * @description:
 */
public class Properties02 {
    /*
    1.使用Properties类完成对mysql.Properties的读取
    2.使用Properties类添加到新文件mysql2.Properties中
    3.使用Properties类完成对mysql2.Properties的读取，并修改某个key-value
     */
    public static void main(String[] args) throws IOException {
        //创建Properties对象
        Properties properties = new Properties();
        String path="D:\\MyCode\\JavaBasic\\src\\com\\zhu\\io_\\properties\\mysql.properties";
        //加载
        properties.load(new FileReader(path));
        //3. 把 k-v 显示控制台
        properties.list(System.out);
        //4. 根据 key 获取对应的值
        String user = properties.getProperty("user");
        String pwd = properties.getProperty("pwd");
        System.out.println("用户名=" + user);
        System.out.println("密码是=" + pwd);
    }
}

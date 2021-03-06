package com.zhu.collection_map.map.properties;

import java.util.Properties;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/12/13 20:57
 * @description:
 */
public class Properties_ {
    public static void main(String[] args) {
        //老韩解读
//1. Properties 继承.md Hashtable
//2. 可以通过 k-v 存放数据，当然 key 和 value 不能为 null
//增加
        Properties properties = new Properties();
//properties.md.put(null, "abc");//抛出 空指针异常
//properties.md.put("abc", null); //抛出 空指针异常
        properties.put("john", 100);//k-v
        properties.put("lucy", 100);
        properties.put("lic", 100);
        properties.put("lic", 88);//如果有相同的 key ， value 被替换
        System.out.println("properties.md=" + properties);
        //通过 k 获取对应值
        System.out.println(properties.get("lic"));//88
//删除
        properties.remove("lic");
        System.out.println("properties.md=" + properties);
//修改
        properties.put("john", "约翰");
        System.out.println("properties.md=" + properties);
    }
}

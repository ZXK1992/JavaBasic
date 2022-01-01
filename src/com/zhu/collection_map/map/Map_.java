package com.zhu.collection_map.map;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/12/7 17:13
 * @description:
 */
@SuppressWarnings({"all"})
public class Map_ {
    public static void main(String[] args) {
//        1）Map与Collection并列存在。用于保存具有映射关系的数据：Key-Value；
//        2）Map中的key和value可以是任何引用类型的数据，会封装到HashMap$Node
//                对象中
//        3）Map中的key不允许重复，原因和HashSet一样
//        4）Map中的value可以重复
//        5）Map的key可以为null，value也可以为null，注意key为null只能有一个，
//        value为null，可以多个
//        6）常用String类作为Map的key
//        7)key和value之间存在单向一对一关系，即通过指定的key总能找到对应的value
        Map map = new HashMap();
        map.put("no1", "韩顺平");//k-v
        map.put("no2", "张无忌");//k-v
        map.put("no1", "张三丰");//当有相同的 k , 就等价于替换.
        map.put("no3", "张三丰");//k-v
        map.put(null, null); //k-v
        map.put(null, "abc"); //等价替换
        map.put("no4", null); //k-v
        map.put("no5", null); //k-v
        map.put(1, "赵敏");//k-v
        map.put(new Object(), "金毛狮王");//k-v
// 通过 get 方法，传入 key ,会返回对应的 value
        System.out.println(map.get("no2"));//张无忌
        System.out.println("map=" + map);
    }
}

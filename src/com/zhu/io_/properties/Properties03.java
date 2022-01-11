package com.zhu.io_.properties;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author: ZHUXIAOKANG
 * @date: 2022/1/9 22:57
 * @description:
 */
public class Properties03 {
    public static void main(String[] args) throws IOException {
        //使用 Properties 类来创建 配置文件, 修改配置文件内容
        Properties properties = new Properties();
        //创建
        //1.如果该文件没有 key 就是创建
        //2.如果该文件有 key ,就是修改
        /*
        Properties 父类是 Hashtable ， 底层就是 Hashtable 核心方法

        public synchronized V put(K key, V value) {
            // Make sure the value is not null
            if (value == null) {
                throw new NullPointerException();
            }

            // Makes sure the key is not already in the hashtable.
            Entry<?,?> tab[] = table;
            int hash = key.hashCode();
            int index = (hash & 0x7FFFFFFF) % tab.length;
            @SuppressWarnings("unchecked")
            Entry<K,V> entry = (Entry<K,V>)tab[index];
            for(; entry != null ; entry = entry.next) {
                if ((entry.hash == hash) && entry.key.equals(key)) {
                    V old = entry.value;
                    entry.value = value;
                    return old;
                }
            }

            addEntry(hash, key, value, index);
            return null;
        }

         */
        properties.setProperty("charset", "utf8");
        properties.setProperty("user", "汤姆");//注意保存时，是中文的 unicode 码值
        properties.setProperty("pwd", "888888");
        //将 k-v 存储文件中即可
        properties.store(new FileOutputStream("D:\\MyCode\\JavaBasic\\src\\com\\zhu\\io_\\properties\\mysql2.properties"), null);
        System.out.println("保存配置文件成功~");
    }
}

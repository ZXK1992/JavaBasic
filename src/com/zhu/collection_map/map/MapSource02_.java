package com.zhu.collection_map.map;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/12/12 15:57
 * @description:
 */
public class MapSource02_ {
    public static void main(String[] args) {
        /*
        1.k-v最后是HashMap$Node node=newNode(hash,key,value,)
        2.k-v为了方便程序员的遍历，还会创建EntrySet集合，该集合存放的元素类型Entry,而一个Entry
          对象就有k,v EntrySet<Entry<k,v>> 即，transient Set<Map.Entry<K,V>> entrySet;
        3.在entrySet中，定义的类型是Map.Entry，但是实际上存放的还是HashMap$Node
          这是因为static class Node<K,V> implements Map.Entry<K,V>
        4.当把HashMap$Node对象存放到entrySet就方便遍历，因为map.Entry提供了两个重要方法
           K getKey(); V getValue();
         */

    }
}

package com.zhu.collection_map.collection_.set_.hashset;

import java.util.HashSet;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/12/4 11:22
 * @description:
 */
public class HashSetSource {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        hashSet.add("java");//到此位置，第 1 次 add 分析完毕.
        hashSet.add("php");//到此位置，第 2 次 add 分析完毕
        hashSet.add("java");
        System.out.println("set=" + hashSet);


        /*
        源码解读：
        1.调用无参构造生成HashMap
         public HashSet() {
            map = new HashMap<>();
        }
        2.调用add
        public boolean add(E e) {//e="java" ,PRESENT是共享
            // private static final Object PRESENT = new Object();
            return map.put(e, PRESENT)==null;
        }
        3.执行put，该方法会执行hash(key)得到key对应的hash值h = key.hashCode()) ^ (h >>> 16)
         public V put(K key, V value) {
            return putVal(hash(key), key, value, false, true);
        }
        4.执行putVal
          final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
                   boolean evict) {
            Node<K,V>[] tab; Node<K,V> p; int n, i;//定义了辅助变量
            //table是HashMap的一个数组属性，类型Node<K,V>[]
            //if语句表示如果当前table是null，或者大小=0
            //就是第一次扩容，到16空间
            if ((tab = table) == null || (n = tab.length) == 0)
                n = (tab = resize()).length;
             //1.根据key,得到hash 去计算该key应该存放到table表的哪个索引位置
             //2.判断p是否为null，
             //2.1如果p为null，表示还没有存放元素，就创建一个Node(key="java",value=PRESENT)
             //2.2就放在该位置 tab[i] = newNode(hash, key, value, null)
            if ((p = tab[i = (n - 1) & hash]) == null)
                tab[i] = newNode(hash, key, value, null);
            else {
                //一个开发技巧提示：定义变量时不要把所有变量都定义到上面，在需要局部变量
                //(辅助变量)的时候，再创建
                Node<K,V> e; K k;//
                //如果当前索引位置对应链表的第一个元素和准备添加到key的哈时候值一样
                //并且满足 下面两个条件之一：
                //(1)准备加入的key 和p指向的Node结点的key是同一个对象
                //(2)P指向的Node结点的key的equals（）和准备加入的key比较后相同
                //就不能加入
                if (p.hash == hash &&
                    ((k = p.key) == key || (key != null && key.equals(k))))
                    e = p;
                 //在判断p是不是一颗红黑树，
                 //如果是一颗红黑树，就调用putTreeVal，来进行添加
                else if (p instanceof TreeNode)
                    e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
                else {//如果table对应的索引位置，已经是一个链表，就使用for循环比较
                       //（1）依次和该链表的每一个元素比较后，都不相同，则加入到该链表的最后
                       //  注意在把元素添加到链表后，立即判断 该链表是否已经达到8个结点
                       //，就调用treeifyBin()对当前这个链表进行树化（转成红黑树）
                       //注意，在转出红黑树的时候，要进行判断，判断条件
                       if (tab == null || (n = tab.length) < MIN_TREEIFY_CAPACITY(64))
                               resize();
                               如果上面条件成立，先 table 扩容.
                               只有在上面条件不成立时，才进行转成红黑树
                       //(2)依次和该链表的每一个比较过程中，如果相同情况，就直接break

                    for (int binCount = 0; ; ++binCount) {
                        if ((e = p.next) == null) {
                            p.next = newNode(hash, key, value, null);
                            if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                                treeifyBin(tab, hash);
                            break;
                        }
                        if (e.hash == hash &&
                            ((k = e.key) == key || (key != null && key.equals(k))))
                            break;
                        p = e;
                    }
                }
                if (e != null) { // existing mapping for key
                    V oldValue = e.value;
                    if (!onlyIfAbsent || oldValue == null)
                        e.value = value;
                    afterNodeAccess(e);
                    return oldValue;
                }
            }
            ++modCount;
            if (++size > threshold)
                resize();
            afterNodeInsertion(evict);//HashMap留给它的子类去实现一些动作
            return null;//代表成功
    }
         */
    }
}

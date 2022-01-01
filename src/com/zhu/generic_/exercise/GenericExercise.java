package com.zhu.generic_.exercise;

import java.util.*;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/12/15 17:56
 * @description:
 */
public class GenericExercise {
    public static void main(String[] args) {
        Student zs = new Student("zs");
        Student ls = new Student("ls");
        Student ww = new Student("ww");
        HashSet<Student> hashSet = new HashSet<>();
        hashSet.add(zs);
        hashSet.add(ls);
        hashSet.add(ww);
        //使用泛型方式给 HashMap 放入 3 个学生对象
        //K -> String.md V->Student
        HashMap<String, Student> hashMap = new HashMap<>();
        /*
        public class HashMap<K,V> {}

        */
        hashMap.put("zs", zs);
        hashMap.put("ls", ls);
        hashMap.put("ww", ww);
        //遍历
        System.out.println("set增强for");
        for (Student student : hashSet) {
            System.out.println(student);
        }
        System.out.println("map增强for");
        for (String name : hashMap.keySet()) {
            System.out.println(name + "-" + hashMap.get(name));
        }
        //迭代器
        System.out.println("set迭代器");
        Iterator<Student> iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            Student next = iterator.next();
            System.out.println(next);
        }
        System.out.println("map迭代器");
        Iterator<String> iterator1 = hashMap.keySet().iterator();
        while (iterator1.hasNext()) {
            String next = iterator1.next();
            System.out.println(next + "-" + hashMap.get(next));
        }

        //迭代器 EntrySet
        /*
        public Set<Map.Entry<K,V>> entrySet() {
            Set<Map.Entry<K,V>> es;
            return (es = entrySet) == null ? (entrySet = new EntrySet()) : es;
        }
    */
        Set<Map.Entry<String, Student>> entries = hashMap.entrySet();
        /*
        public final.md Iterator<Map.Entry<K,V>> iterator() {
            return new EntryIterator();
        }
    */
        Iterator<Map.Entry<String, Student>> iterator2 = entries.iterator();
        System.out.println("迭代器 EntrySet");
        while (iterator2.hasNext()) {
            Map.Entry<String, Student> next = iterator2.next();
            System.out.println(next.getKey() + "-" + next.getValue());
        }

    }

}

class Student {

    private String name;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student(String name) {
        this.name = name;
    }
}
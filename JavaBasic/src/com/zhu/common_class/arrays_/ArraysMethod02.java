package com.zhu.common_class.arrays_;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/11/25 11:04
 * @description:
 */
public class ArraysMethod02 {
    public static void main(String[] args) {
        Integer[] arr = {1, 2, 90, 123, 567};
        // 3)binarySearch 通过二分搜索法进行查找，要求必须排好
        //1. 使用 binarySearch 二叉查找
        //2. 要求该数组是有序的. 如果该数组是无序的，不能使用 binarySearch
        //3. 如果数组中不存在该元素，就返回 return -(low + 1); // key not found.
        int index = Arrays.binarySearch(arr, 567);
        System.out.println("index=" + index);
        //4) fill 数组元素的填充
        Integer[] num = new Integer[]{9, 3, 2};
        //1. 使用 99 去填充 num 数组，可以理解成是替换原理的元素
        Arrays.fill(num, 99);
        System.out.println("==num 数组填充后==");
        System.out.println(Arrays.toString(num));
        //5) copyOf数组元素的复制
        //1. 从 arr 数组中，拷贝 arr.length 个元素到 newArr 数组中
        //2. 如果拷贝的长度 > arr.length 就在新数组的后面 增加 null
        //3. 如果拷贝长度 < 0 就抛出异常 NegativeArraySizeException
        //Arrays.copyOf(arr, -1);
        //4. 该方法的底层使用的是 System.arraycopy()
        Integer[] arr02 = {1, 2, 90, 123, 567};
        //使用Arrays.copyOf扩容数组两倍
        arr02 = Arrays.copyOf(arr02, arr02.length << 1);
        System.out.println("扩容后：" + Arrays.toString(arr02));
        //5) asList 将一组值，转换成 list
        //1. asList 方法，会将 (2,3,4,5,6,1)数据转成一个 List 集合
        //2. 返回的 asList 编译类型 List(接口)
        //3. asList 运行类型 java.util.Arrays#ArrayList, 是 Arrays 类的
        // 静态内部类 private static class ArrayList<E> extends AbstractList<E>
        // implements RandomAccess, java.io.Serializable
        int[] arr03 = {2, 3, 4, 5, 6, 1};
        List<int[]> ints = Arrays.asList(arr03);
        System.out.println(ints.getClass());

    }
}

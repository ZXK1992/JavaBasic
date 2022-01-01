#1.System 类常见方法
    1)exit退出当前程序
    2）arraycopy：复制数组元素，比较适合底层调用，一般使用
       Arrays.copyOf完成复制数组
       int[]src={1,2,3};
       int[]dest=new int[3];
       System.arraycopy(src,0,dest,0,3);
       五个参数的解释
       //* @param src the source array. // srcPos： 从源数组的哪个索引位置开始拷贝
       // * @param srcPos starting position in the source array. // dest : 目标数组，即把源数组的数据拷贝到哪个数组
       // * @param dest the destination array. // destPos: 把源数组的数据拷贝到 目标数组的哪个索引
       // * @param destPos starting position in the destination data. // length: 从源数组拷贝多少个数据到目标数组
       // * @param length the number of array elements
    3)currentTimeMillis:返回当前时间距离1970-1-1的毫秒数
    4）gc:运行垃圾回收机制System.gc();
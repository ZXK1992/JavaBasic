#1.Arrays类的常用方法
    Arrays里面包含一系列静态方法，用于管理或者操作数组(比如排序和搜索)
    1)toString 返回数组的字符串形式
    2)sort排序 (自然排序和定制排序)
        1.定制排序传入Comparator接口
        2.通过匿名内部类重写compare方法
        3.如果返回o1-o2从小到大排
          如果返回o2-o1从大到小排
    3)binarySearch通过二分搜索法进行查找，要求必须排好序
        //1. 使用 binarySearch 二叉查找
        //2. 要求该数组是有序的. 如果该数组是无序的，不能使用 binarySearch
        //3. 如果数组中不存在该元素，就返回 return -(low + 1);// key not found.
    4)copyOf数组元素的复制
        //1. 从 arr 数组中，拷贝 arr.length 个元素到 newArr 数组中
        //2. 如果拷贝的长度 > arr.length 就在新数组的后面 增加 null
        //3. 如果拷贝长度 < 0 就抛出异常 NegativeArraySizeException
        //4. 该方法的底层使用的是 System.arraycopy()
    5)fill数组元素填充
        可以理解成是替换原来的所有元素
    6)equals 比较两个数组元素内容是否完全一致
    7）asList 将一组值，转换成list

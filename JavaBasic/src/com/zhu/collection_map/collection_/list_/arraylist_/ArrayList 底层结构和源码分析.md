#1.ArrayList的注意事项
    1)permits all elements, including null,ArrayList可以加入null，并且多个
    2）ArrayList是由数组来实现数据存储的
    3）ArrayList基本等同于Vector，除了ArrayList是线程不安全(执行效率高）
       在多线程情况下，不建议使用ArrayList
#2.ArrayList 的底层操作机制源码分析
    1）ArrayList中维护了一个Object类型的数组elementData，
       transient Object[] elementData;//transient表示瞬间，短暂的，表示该属性不会被序列化
    2）当创建ArrayList对象时，如果使用的是无参构造器，则初始elementData容量为0，
       第1次添加，则扩容elementData为10，如需要再次扩容，则扩容elementData为1.5倍
    3）如果使用的是指定大小的构造器，则初始elementData容量为指定大小，如果需要扩容，则
    直接扩容elementData的1.5倍

    分析使用无参构造器，创建和使用ArrayList的源码：
        1.执行构造器创建了一个空的elementData数组={};
             public ArrayList() {
                this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
             }
        2.执行list.add
             public boolean add(E e) {
                ensureCapacityInternal(size + 1);  // Increments modCount!!
                elementData[size++] = e;
                return true;
             }
            1.先确定是否要扩容
            2.然后再执行赋值
        3.
            private void ensureCapacityInternal(int minCapacity) {
                ensureExplicitCapacity(calculateCapacity(elementData, minCapacity));
            }

            private static int calculateCapacity(Object[] elementData, int minCapacity) {
                if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
                        return Math.max(DEFAULT_CAPACITY, minCapacity);
                }
                return minCapacity;
            }
            上面方法确定minCapacity
                1)第一次扩容为10
            private void ensureExplicitCapacity(int minCapacity) {
                modCount++;

                // overflow-conscious code
                if (minCapacity - elementData.length > 0)
                    grow(minCapacity);
            }
                (1) modCount++记录集合被修改的次数
                (2)如果elementData的大小不够，就调用grow()去扩容
            private void grow(int minCapacity) {
                // overflow-conscious code
                int oldCapacity = elementData.length;
                int newCapacity = oldCapacity + (oldCapacity >> 1);
                if (newCapacity - minCapacity < 0)
                 newCapacity = minCapacity;
                if (newCapacity - MAX_ARRAY_SIZE > 0)
                 newCapacity = hugeCapacity(minCapacity);
                // minCapacity is usually close to size, so this is a win:
                elementData = Arrays.copyOf(elementData, newCapacity);
            }
                1)真的扩容
                2)使用扩容机制来确定要扩容到多大
                3）第一次newCapacity=10
                4）第二次及以后，按照1.5倍扩容
                5）扩容使用的是Arrays.copyOf();
         分析使用有参构造器，创建和使用ArrayList的源码：
             public ArrayList(int initialCapacity) {
                 if (initialCapacity > 0) {
                     this.elementData = new Object[initialCapacity];
                 } else if (initialCapacity == 0) {
                     this.elementData = EMPTY_ELEMENTDATA;
                 } else {
                     throw new IllegalArgumentException("Illegal Capacity: "+
                                                        initialCapacity);
                 }
             }
                创建了一个指定大小elementData数组
                this.elementData = new Object[initialCapacity];
                如果是有参构造器，扩容机制
                    1）底层扩容，就按照elementData的1.5倍扩容、
                    2）后面add整个执行的流程还是和无参add一样


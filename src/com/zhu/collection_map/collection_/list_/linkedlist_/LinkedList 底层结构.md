# 1.LinkedList 底层结构
    1）LinkedList底层实现了双向链表和双端队列特点
    2）可以添加任意元素（元素可以重复的)包括null
    3)线程不安全，没有实现同步
# 2.LinkedList的底层操作机制
    1)LinkedList底层维护了一个双向链表
    2）LinkedList中维护了两个属性first和last分别指向首节点和尾结点
    3）每个节点（Node对象），里面又维护了prev、next、item三个属性
       prev指向前一个，通过next指向后一个节点。最终实现双向链表
    4）所以LinkedList的元素的添加和删除，不是通过数组完成的，相对来说
       效率高
    5）模拟一个简单的双向链表LinkedList01.java
        //定义一个node 类 ，node
        class Node{
            Object item;
            Node next;
            Node pre;

            public Node(Object name) {
                this.item = name;
            }
            @Override
            public String toString() {
                return "Node name=" + item;
            }
        }


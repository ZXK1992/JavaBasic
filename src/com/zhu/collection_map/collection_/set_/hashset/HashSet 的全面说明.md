#1. HashSet 的全面说明
    1)HashSet 实现了Set接口
    2）HashSet 实际上是HashMap
         public HashSet() {
                map = new HashMap<>();
            }
    3）可以存放null值，但是只能有一个null
    4）HashSet 不保证元素是有序的，取决于hash后，再确定索引的结果
       （即，不保证存放元素的顺序和取出顺序一致）
    5）不能有重复元素/对象
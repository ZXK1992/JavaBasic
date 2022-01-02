package com.zhu.generic_.homework;





import org.junit.Test;

import java.util.*;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/11/1 17:55
 * @description:
 */
public class Homework01 {
   @Test
   public void test(){
       DAO<User> userDAO = new DAO<>();
       User user = new User();
       user.setId(1);
       user.setAge(18);
       user.setName("小明");
       userDAO.save("1",user);
       User user1 = userDAO.get("1");
       System.out.println("保存user后获取"+user1);
       User user2=new User();
       user.setId(2);
       user.setAge(19);
       user.setName("小红");
       userDAO.update("1",user2);
       System.out.println("更新id为1的user后遍历");
       List<User> list = userDAO.list();
       for (User user3 : list) {
           System.out.println(user3);
       }

        userDAO.delete("1");
       System.out.println("删除id 为1后获取");
       User user3 = userDAO.get("1");
       System.out.println(user3);

   }
}

/**
 * 定义个泛型类DAO<T>，在其中定义一个Map成员变量，Map的键为String类型，值为T类型。
 * 分别创建一下方法：
 * （1）public void save(String.md id,T entity)：保存T类型的对象放到Map成员变量中
 * （2）public T get(String.md id)：从map中获取ID对应的对象
 * （3）public void update(String.md id,T entity):替换map中key为id的内容，改为entity对象
 * （4）public List<T> list()：返回map中存放的所有T对象
 * （5）public void delete(String.md id):删除指定id对象
 * <p>
 * 定义一个User类：
 * 该类包含：private成员变量（int 类型）id,age ;（String类型）name。
 * <p>
 * 创建DAO类的对象，分别调用save，get，update，list ，delete 方法来操作User对象，
 * 使用Junit单元测试类进行测试。
 *
 * @param <T>
 */
class DAO<T> {
    Map<String, T> map = new HashMap<>();

    /**
     * 保存T类型的对象放到Map成员变量中
     *
     * @param id
     * @param entity
     */
    public void save(String id, T entity) {
        map.put(id, entity);
    }

    /**
     * 从map中获取ID对应的对象
     *
     * @param id
     * @return
     */
    public T get(String id) {
        T t = map.get(id);
        return t;
    }

    /**
     * 替换map中key为id的内容，改为entity对象
     *
     * @param id
     * @param entity
     */
    public void update(String id, T entity) {
        T t = map.get(id);
        t = entity;
    }

    /**
     * 返回map中存放的所有T对象
     * @return
     */
    public List<T> list() {
        List<T> ts = new ArrayList<>();
        Set<Map.Entry<String, T>> entries = map.entrySet();
        for (Map.Entry<String, T> entry : entries) {
            ts.add(entry.getValue());
        }
        return ts;
    }

    /**
     * 删除指定id对象
     * @param id
     */
    public void delete(String id) {
        map.remove(id);
    }
}

/**
 *  定义一个User类：
 *  该类包含：private成员变量（int 类型）id,age ;（String类型）name。
 */
class User{
    private int id;
    private int age;
    private String name;

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
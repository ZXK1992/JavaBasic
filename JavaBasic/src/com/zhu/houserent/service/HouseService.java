package com.zhu.houserent.service;

import com.zhu.houserent.model.House;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/11/12 10:09
 * @description:
 */
public class HouseService {
    private House[] houses;//存放房屋信息
    private int houseNum = 1;//记录当前有多少房屋信息
    private int idCounter = 1;//记录id增长到哪个值了

    public HouseService(int size) {
        houses = new House[size];//当创建houseService对象时，指定数组大小
        //为了配合测试列表信息，初始化一个House对象
        houses[0] = new House(1, "jack", "132", "昌平区", 1000, "未出租");
    }

    /**
     * 添加
     * @param newHouse
     * @return
     */
    public boolean add(House newHouse) {
        //判断是否还可以继续添加（暂时不考虑扩容）
        //houseNum记录当前有多少个房屋信息
        if (houseNum == houses.length) {
            //System.out.println("数组已满，不能再添加了..");
            //进行扩容
            houses = Arrays.copyOf(this.houses, houses.length << 1);
        }
        //把newHouse对象加入到，houseNum++代表新增一个
        houses[houseNum++] = newHouse;
        //我们程序员需要设计一个id自增长的机制，然后更新newHouse的id
        newHouse.setId(++idCounter);
        return true;
    }

    /**根据id查找
     * 返回House对象或null
     * @param id
     * @return
     */
    public House findHouseById(int id) {
        for (int i=0;i<houseNum;i++){
            if (id==houses[i].getId()){
                return houses[i];
            }
        }
        return null;
    }

    /**
     * 列表
     * @return
     */
    public House[] listHouse() {
        return houses;
    }

    /**
     * 删除
     * @param delId
     * @return
     */
    public boolean delHouse(int delId) {
        int index = -1;
        //循环找id是否存在
        for (int i = 0; i < houseNum; i++) {
            if (delId == houses[i].getId()) {
                //找到了，给index赋值
                index = i;
            }
        }
        //index=-1;说明没找到
        if (index == -1) {
            return false;
        }
        for (int i = index; i < houseNum - 1; i++) {
            houses[i] = houses[i + 1];
        }
        houses[--houseNum] = null;
        return true;
    }
}

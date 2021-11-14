package com.zhu.houserent.view;

import com.zhu.houserent.model.House;
import com.zhu.houserent.service.HouseService;
import com.zhu.houserent.utils.Utility;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/11/11 10:43
 * @description: 1.显示界面
 * 2.接收用户输入
 * 3.调用HouseService完成对房屋信息的各种操作
 */
public class HouseView {
    private boolean loop = true;//控制显示菜单
    private char key = ' ';//接收用户选择
    private int id = 1;
    private HouseService houseService = new HouseService(2);

    /**
     * 显示主菜单
     */
    public void mainMenu() {
        do {
            System.out.println("----------------房屋出租系统----------------");
            System.out.println("\t\t\t1 新 增 房 源");
            System.out.println("\t\t\t2 查 找 房 屋");
            System.out.println("\t\t\t3 删 除 房 屋");
            System.out.println("\t\t\t4 修 改 房 屋 信 息");
            System.out.println("\t\t\t5 房 屋 列 表");
            System.out.println("\t\t\t6 退       出");
            System.out.print("请选择(1-6):");
            key = Utility.readChar();
            switch (key) {
                case '1':
                    addHouse();
                    break;
                case '2':
                    findHouse();
                    break;
                case '3':
                    delHouse();
                    break;
                case '4':
                    updateHouse();
                    break;
                case '5':
                    listHouse();
                    break;
                case '6':
                    exit();
                    break;
                default:
                    System.out.println("输入有误，请重新输入。");
            }
            System.out.println();
        } while (loop);

    }

    /**
     * 添加房屋界面，接收输入，创建House对象，调用add方法
     */
    public void addHouse() {
        System.out.println("----------------添加房屋----------------");
        System.out.print("姓名：");
        String name = Utility.readString(10);
        System.out.print("电话：");
        String phoneNum = Utility.readString(11);
        System.out.print("地址：");
        String adderss = Utility.readString(20);
        System.out.print("月租：");
        int rent = Utility.readInt();
        System.out.print("状态：");
        String state = Utility.readString(3);
        //创建一个新的House对象，注意id是系统分配的
        House newHouse = new House(0, name, phoneNum, adderss, rent, state);
        if (houseService.add(newHouse)) {
            System.out.println("----------------添加完成----------------");
        } else {
            System.out.println("----------------添加失败----------------");
        }
    }

    /**
     * 查找
     */
    public void findHouse() {
        System.out.println("-----------------查找房屋-----------------");
        System.out.print("请输入你要查找id: ");
        int findId = Utility.readInt();
        //调用方法
        House house = houseService.findHouseById(findId);
        if (house != null) {
            System.out.println(house);

        } else {
            System.out.println("-----------------查找房屋id不存在 -----------------");
        }

    }

    /**
     * 删除
     */
    public void delHouse() {
        System.out.println("-----------------删除房屋-----------------");
        System.out.println("请选择待删除房屋编号(-1退出): ");
        int delId = Utility.readInt();
        if (delId == -1) {//-1退出
            System.out.println("-----------------你放弃删除-----------------");
            return;
        }
        char choice = Utility.readConfirmSelection();
        if (choice == 'Y') {
            if (houseService.delHouse(delId)) {
                System.out.println("-----------------删除完成-----------------");
            } else {
                System.out.println("删除失败，编号不存在");
            }
        } else {
            System.out.println("-----------------你放弃删除-----------------");
        }
    }

    /**
     * 修改
     */
    public void updateHouse() {
        System.out.println("-----------------修改房屋-----------------");
        System.out.println("请选择待修改房屋编号(-1退出): ");
        int updateId = Utility.readInt();
        if (updateId == -1) {
            System.out.println("-----------------你放弃修改-----------------");
            return;
        }
        House house = houseService.findHouseById(updateId);
        if (house == null) {
            System.out.println("-----------------你要修改的编号不存在-----------------");
            return;
        }
        System.out.print("姓名(" + house.getName() + "): ");
        //这里如果用户直接回车表示不修改该信息，默认""
        String updateName = Utility.readString(10,"");
        if (!"".equals(updateName)){//修改
            house.setName(updateName);
        }
        System.out.print("电话(" + house.getPhoneNum() + "):");
        String updatePhone = Utility.readString(11,"");
        if (!"".equals(updatePhone)){//修改
         house.setPhoneNum(updatePhone);
        }
        System.out.print("地址(" + house.getAdderss() + "):");
        String updateAdderss = Utility.readString(20,"");
        if (!"".equals(updateAdderss)){//修改
            house.setAdderss(updateAdderss);
        }
        System.out.print("租金(" + house.getRent() + "):");
        int updateRent = Utility.readInt(-1);
        if (updateRent!=-1){//修改
            house.setRent(updateRent);
        }
        System.out.print("状态(" + house.getState() + "):");
        String updateState = Utility.readString(3,"");
        if (!"".equals(updateState)){//修改
            house.setState(updateState);
        }
        System.out.println("-----------------修改完成-----------------");
    }

    /**
     * 列表
     */
    public void listHouse() {
        System.out.println("-----------------房屋列表-----------------");
        System.out.println("编号\t\t房主\t\t电话\t\t地址\t\t月租\t\t状态(未出租/已出租)");
        House[] houses = houseService.listHouse();
        for (int i = 0; i < houses.length; i++) {
            if (houses[i] == null) {
                break;
            }
            System.out.println(houses[i]);
        }
        System.out.println("----------------房屋列表完成----------------");
    }

    /**
     * 退出
     */
    public void exit() {
        char choice = Utility.readConfirmSelection();
        if (choice == 'Y') {
            loop = false;
            System.out.println("你退出了程序~~~");
        }
    }
}

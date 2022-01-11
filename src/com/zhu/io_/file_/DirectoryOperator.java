package com.zhu.io_.file_;

import java.io.File;

/**
 * @author: ZHUXIAOKANG
 * @date: 2022/1/5 15:14
 * @description:
 */
public class DirectoryOperator {
    /*
    1）判断D:\\news1.txt是否存在，如果存在就删除
    2）判断D:\\demo02是否存在，如果存在就删除,否则提示不存在
    3）判断D:\\demo\\a\\b\\c 目录是否存在，如果存在就提示已经存在，否则就创建
     */
    public static void main(String[] args) {
        File file1 = new File("D:\\news1.txt");
        if (file1.exists()) {//判断D:\\news1.txt是否存在，如果存在就删除
            file1.delete();//delete删除空目录或文件
        }
        //2）判断D:\\demo02是否存在，如果存在就删除,否则提示不存在
        File file2 = new File("D:\\\\demo02");
        if (file2.exists()){
            file2.delete();//delete删除空目录或文件
        }else {
            System.out.println("目录D:\\demo02不存在");
        }
        //    3）判断D:\\demo\\a\\b\\c 目录是否存在，如果存在就提示已经存在，否则就创建
        File file3 = new File("D:\\demo\\a\\b\\c");
        if (file3.exists()){//是否存在
            System.out.println("目录D:\\demo\\a\\b\\c已经存在");
        }else {
            file3.mkdirs();//mkdirs创建多级目录
            System.out.println("目录D:\\demo\\a\\b\\c创建成功");
        }
    }
}

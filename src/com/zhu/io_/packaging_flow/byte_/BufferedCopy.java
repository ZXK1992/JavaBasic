package com.zhu.io_.packaging_flow.byte_;

import java.io.*;

/**
 * @author: ZHUXIAOKANG
 * @date: 2022/1/8 13:48
 * @description:
 *演示使用 BufferedOutputStream 和 BufferedInputStream 使用
 *使用他们，可以完成二进制文件拷贝.
 * 思考：字节流可以操作二进制文件，可以操作文本文件吗？当然可以
 */
public class BufferedCopy {
    public static void main(String[] args) {
        String srcpath = "D:\\MyCode\\JavaBasic\\src\\com\\zhu\\io_\\packaging_flow\\byte_\\BufferedInputStream.uml";
        String destpath = "D:\\MyCode\\JavaBasic\\src\\com\\zhu\\io_\\packaging_flow\\byte_\\a1.uml";
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            //因为 FileInputStream 是 InputStream 子类
            bis = new BufferedInputStream(new FileInputStream(srcpath));
            bos = new BufferedOutputStream(new FileOutputStream(destpath));
            //循环的读取文件，并写入到 destFilePath
            byte[] buff = new byte[1024];
            int len = 0;
            //当返回 -1 时，就表示文件读取完毕
            while ((len = bis.read(buff)) != -1) {
                bos.write(buff, 0, len);
            }
            System.out.println("复制完毕");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭流 , 关闭外层的处理流即可，底层会去关闭节点流
            try {
                if (bis != null) {
                    bis.close();
                }
                if (bos != null) {
                    bos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}

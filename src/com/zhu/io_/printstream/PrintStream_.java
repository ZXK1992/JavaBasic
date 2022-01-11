package com.zhu.io_.printstream;

import java.io.IOException;
import java.io.PrintStream;

/**
 * @author: ZHUXIAOKANG
 * @date: 2022/1/9 17:48
 * @description:
 */
public class PrintStream_ {
    public static void main(String[] args) throws IOException {
        PrintStream out = System.out;
        //在默认情况下，PrintStream 输出数据的位置是 标准输出，即显示器
        /*
         public void print(String s) {
            if (s == null) {
                s = "null";
            }
             write(s);
        }

         */
        out.print("nh");
        //因为 print 底层使用的是 write , 所以我们可以直接调用 write进行打印/输出
        out.write("王八蛋".getBytes());
        out.close();
        //我们可以去修改打印流输出的位置/设备
        //1.输出修改成到"D:\MyCode\JavaBasic\src\com\zhu\io_\printstream\f1.txt
        //2."hello ,你好啊"就会输出到文件
        String destpath = "D:\\MyCode\\JavaBasic\\src\\com\\zhu\\io_\\printstream\\f1.txt";
        System.setOut(new PrintStream(destpath));
        System.out.println("hello,你好啊");
    }

}

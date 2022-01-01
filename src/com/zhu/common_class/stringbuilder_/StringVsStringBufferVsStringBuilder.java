package com.zhu.common_class.stringbuilder_;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/11/24 22:46
 * @description:
 */
public class StringVsStringBufferVsStringBuilder {
    public static void main(String[] args) {
        long start1 = System.currentTimeMillis();
        String a="";
        for (int i = 0; i < 100000; i++) {
            a+=i;
        }
        System.out.println("string="+(System.currentTimeMillis()-start1));

        long start2 = System.currentTimeMillis();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 100000; i++) {
            stringBuffer.append(i);
        }
        System.out.println("stringBuffer="+(System.currentTimeMillis()-start2));
        long start3 = System.currentTimeMillis();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 100000; i++) {
            stringBuilder.append(i);
        }
        System.out.println("stringBuilder="+(System.currentTimeMillis()-start3));
    }
}

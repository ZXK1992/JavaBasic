package com.zhu.excption_;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/10/10 0:26
 * @description:
 */
public class Excption_ {
    public static void main(String[] args) {
        //Throwable
        try{
            //代码、可能有异常

        }catch (Exception e){
            //捕获到异常
            //1.当异常发生时
              //  2.系统将异常封装成Exception对象e,传递给catch
            //3.得到异常对象后程序员，自己处理
            //4.注意，如果没有发生异常catch代码块不执行
        }finally {
            //1.不管try代码块是否有异常发生，始终要执行finally
            //2.所以，通常将释放资源的代码放在finally
        }
    }
}

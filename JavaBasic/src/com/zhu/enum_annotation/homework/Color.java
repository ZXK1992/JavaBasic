package com.zhu.enum_annotation.homework;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/11/15 21:51
 * @description:
 */
public enum Color implements IShowColor{
    RED(255,0,0),BLUE(0,0,255)
    ,BLACK(0,0,0),YELLOW(255,255,0),
    GREEN(0,255,0);
    private int redValue;
    private int greenValue;
    private int blueValue;

    Color(int redValue, int greenValue, int blueValue) {
        this.redValue = redValue;
        this.greenValue = greenValue;
        this.blueValue = blueValue;
    }

    @Override
    public void show(){
        System.out.println(redValue+","+greenValue+","+blueValue);

    }
}

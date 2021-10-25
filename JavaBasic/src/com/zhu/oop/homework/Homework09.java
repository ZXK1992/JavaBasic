package com.zhu.oop.homework;

/**
 * @author: ZHUXIAOKANG
 * @date: 2021/10/25 0:40
 * @description:
 */
public class Homework09 {
    public static void main(String[] args) {
        Music music = new Music("菊花台", 300);
        music.play();
        System.out.println(music.getInfo(music));
    }
}

/**
 * 定义Music类，里面有音乐名name,音乐时长times属性，
 * 并有播放play功能和返回本身属性信息的功能方法getInfo
 */
class Music{
    String name;
    double times;

    public Music(String name, double times) {
        this.name = name;
        this.times = times;
    }

    public void play(){
        System.out.println("正在播放"+this.name+"音乐");
    }

    @Override
    public String toString() {
        return "Music{" +
                "name='" + name + '\'' +
                ", times=" + times +
                '}';
    }

    public Music getInfo(Music music){
        return  music;
    }
}
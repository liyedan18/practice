package com.ch8.bean;

import org.springframework.beans.factory.annotation.Value;

/**
 * 使用@Value赋值
 * 1.直接赋值 基本字符
 * 2.使用springEL表达式
 *      —— “${20-2}”，得到计算结果18
 * 3.读取配置文件的值(运行在环境变量里的值)
 *      —— “${bird.color}”
 *      要先加载配置文件，@PropertySource(value="classpath:/test.properties")
 */
public class Bird {

    @Value("Tom")
    String name;

    @Value("#{20-2}")
    Integer num;

    @Value("${bird.color}")
    String color;

    public Bird(){}

    public Bird(String name, Integer num, String color) {
        this.name = name;
        this.num = num;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Bird{" +
                "name='" + name + '\'' +
                ", num=" + num +
                ", color='" + color + '\'' +
                '}';
    }
}

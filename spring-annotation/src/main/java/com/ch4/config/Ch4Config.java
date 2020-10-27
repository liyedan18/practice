package com.ch4.config;

import com.ch1.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * 演示@Lazy
 */
@Configuration
public class Ch4Config {

    //针对的是单实例bean
//    @Lazy
    @Bean
    public Person person(){
        //在bean创建前打印
        System.out.println("正在往IOC容器中添加bean...person...");
        return new Person("Tom", 22);
    }
}

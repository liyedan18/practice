package com.ch5.config;

import com.ch1.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * 演示@Conditional作用
 *
 * 演示在linux环境下添加tom
 * 在windows环境下添加jason
 */
@Configuration
public class Ch5Config {

    @Bean
    public Person person(){
        System.out.println("给容器中添加jary...");
        return new Person("jary", 22);
    }

    @Conditional(LinuxCondition.class)
    @Bean
    public Person tom(){
        System.out.println("给容器中添加tom...");
        return new Person("tom", 23);
    }

    @Conditional(WindowsCondition.class)
    @Bean
    public Person jason(){
        System.out.println("给容器中添加jason...");
        return new Person("jason", 24);
    }

}

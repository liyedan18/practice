package com.ch3.config;

import com.ch1.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * 演示@Scope
 */
@Configuration
public class Ch3MainConfig {

    //默认是单例
//    @Scope("prototype")
    @Bean
    public Person person(){
        return new Person("Tom", 21);
    }
}

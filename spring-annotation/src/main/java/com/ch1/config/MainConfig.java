package com.ch1.config;

import com.ch1.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


//配置类 == 配置文件
@Configuration
public class MainConfig {

    /**
     * 1.方法名即是bean的id
     * 2.也可以指定beanId @Bean(Value="")
     */
//    @Bean("abcPerson")
    @Bean
    public Person person1(){
        return new Person("tom", 20);
    }
}

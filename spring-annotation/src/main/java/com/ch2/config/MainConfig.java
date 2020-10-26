package com.ch2.config;

import com.ch2.bean.Person;
import com.ch2.service.OrderService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;


//配置类 == 配置文件
@Configuration
//@Component @Controller @Service @Repository
@ComponentScan(value = "com.ch2", includeFilters = {
//        @Filter(type = FilterType.ANNOTATION, classes = Controller.class),
//        @Filter(type = FilterType.ASSIGNABLE_TYPE, classes = OrderService.class)
        @Filter(type = FilterType.CUSTOM, classes = MyTypeFilter.class)
}, useDefaultFilters = false)
public class MainConfig {

    /**
     * 1.方法名即是bean的id
     * 2.也可以指定beanId @Bean(Value="")
     */
//    @Bean("abcPerson")
    @Bean
    public Person person(){
        return new Person("tom", 20);
    }
}

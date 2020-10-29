package com.ch6.config;

import com.ch1.bean.Person;
import com.ch6.bean.Cat;
import com.ch6.bean.Dog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 演示@Import作用
 * ImportSelector
 *
 *
 *
 */
@Configuration
//id默认是全类名
@Import({Dog.class, Cat.class, MyImportSelector.class, MyImportBeanDefinitionRegister.class})
public class Ch6Config {

    @Bean
    public Person person(){
        return new Person("tom", 30);
    }

    /**
     * 写在这里是不行的，这里只能添加名称为register的bean
     * 不能添加自定义的pig
     * 需要添加到@Import中
     */
    // @Bean
    // public MyImportBeanDefinitionRegister register() {
    //     return new MyImportBeanDefinitionRegister();
    // }

    @Bean
    public MyFactoryBean myFactoryBean(){
        return new MyFactoryBean();
    }
}

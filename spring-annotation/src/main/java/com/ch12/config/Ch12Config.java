package com.ch12.config;

import com.ch12.processor.MyBeanDefinitionRegistryPostProcessor;
import com.ch12.processor.MyBeanFactoryPostProcessor;
import com.ch7.bean.Jeep;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("com.ch12.processor")    //或可以用@Import
// @Import(MyBeanDefinitionRegistryPostProcessor.class)
public class Ch12Config {
    @Bean
    public Jeep getJeep(){
        return new Jeep();
    }

    @Bean
    public MyBeanFactoryPostProcessor myBeanFactoryPostProcessor(){
        return new MyBeanFactoryPostProcessor();
    }
}

package com.ch7.config;

import com.ch7.bean.Bike;
import com.ch7.bean.Jeep;
import com.ch7.bean.Train;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * 演示bean的生命周期
 */
@Configuration
@ComponentScan("com.ch7.bean")
public class Ch7Config {

    //单实例和多实例生命周期的区别
    // @Scope("prototype")
    @Bean(initMethod = "init", destroyMethod = "destory")
    public Bike bike(){
        return new Bike();
    }

    @Bean
    public Train train(){
        return new Train();
    }
    //
    // @Bean
    // public Jeep jeep(){
    //     return new Jeep();
    // }

}

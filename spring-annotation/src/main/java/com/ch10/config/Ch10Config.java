package com.ch10.config;

import com.ch10.aop.Calculator;
import com.ch10.aop.LogAspect;
import com.ch10.aop.LogAspectJointPoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class Ch10Config {

    @Bean
    public Calculator calculator(){
        return new Calculator();
    }

    // 测试LogAspect时开启
    // @Bean
    // public LogAspect logAspect(){
    //     return new LogAspect();
    // }

    @Bean
    public LogAspectJointPoint logAspectJointPoint(){
        return new LogAspectJointPoint();
    }
}

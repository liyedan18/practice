package com.ch5.config;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;


/**
 * 判断是否为linux环境
 */
public class LinuxCondition implements Condition {

    /**
     * ConditionContext 判断条件能使用的上下文环境
     * AnnotatedTypeMetadata   注解的信息
     *
     */
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        //获取到IOC使用的beanFactory
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        //获取到类加载器
        ClassLoader classLoader = context.getClassLoader();
        //获取当前环境信息
        Environment environment = context.getEnvironment();
        //获取bean定义的注册类
        BeanDefinitionRegistry beanDefinitionRegistry = context.getRegistry();

        //获取当前操作系统类型
        String os = environment.getProperty("os.name");
        return os.toLowerCase().contains("linux");
    }
}

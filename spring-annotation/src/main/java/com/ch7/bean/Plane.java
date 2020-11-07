package com.ch7.bean;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 验证BeanPostProcessor的处理流程
 *
 * 这里会经过ApplicationContextAwareProcessor的处理
 */
public class Plane implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    public Plane(){
        System.out.println("Plane...constructor...");
    }

    @PostConstruct
    public void init(){
        System.out.println("Plane...init...");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("Plane...destroy...");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        //将IOC容器applicationContext传进来，这里可以拿到并做修改
        this.applicationContext = applicationContext;
    }
}

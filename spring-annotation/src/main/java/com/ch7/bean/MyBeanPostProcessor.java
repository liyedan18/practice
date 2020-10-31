package com.ch7.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * 后置处理器  管理Bean的生命周期
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor{

    /**
     * 返回一个对象（也是从方法参数中传过来的对象）
     * 在初始化方法调用之前做后置处理工作
     *
     * 什么时候调用：init-method=init之前
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessBeforeInitialization..."+ beanName + "=" + bean);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessAfterInitialization..." + beanName + "=" + bean);
        return bean;
    }
}

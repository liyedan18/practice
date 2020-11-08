package com.ch9.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;

/**
 * 验证Aware相关接口
 */
@Component
public class Light implements ApplicationContextAware, BeanNameAware, EmbeddedValueResolverAware {

    private ApplicationContext applicationContext;

    //获取IOC中的bean名称
    @Override
    public void setBeanName(String name) {
        System.out.println("current beanName == " + name);
    }

    //获取IOC容器
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        //将IOC容器applicationContext传进来，这里可以拿到并做修改,其他方法也可以获得IOC容器了
        //这里会经过ApplicationContextAwareProcessor的处理
        //这里获取的applicationContext，与new AnnotationConfigApplicationContext(Ch9Config.class);是同一个
        System.out.println("传入的IOC容器：" + applicationContext);
        this.applicationContext = applicationContext;
    }

    //获取value解析器，@Vaule注解实现原理就是这个解析器
    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        String result = resolver.resolveStringValue("当前系统是：${os.name}, 计算数值：#{20-8}");
        System.out.println("解析器解析结果 == " + result);
    }
}

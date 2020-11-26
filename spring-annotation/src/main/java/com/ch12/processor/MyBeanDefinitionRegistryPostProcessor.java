package com.ch12.processor;

import com.ch7.bean.Jeep;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.stereotype.Component;

/**
 * 注意两个方法的执行先后顺序
 * 看源码中是哪个先执行，哪个后执行
 */
@Component
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        System.out.println("MyBeanDefinition...postProcessorBeanDefinition...Bean的数量是："
                + registry.getBeanDefinitionCount());

        //向容器中再注册一个bean
        RootBeanDefinition rbd = new RootBeanDefinition(Jeep.class);    //bean定义包装类
        registry.registerBeanDefinition("newBean", rbd);

        //另一种注册bean定义的方式
        AbstractBeanDefinition rbd1 = BeanDefinitionBuilder.genericBeanDefinition(Jeep.class).getBeanDefinition();
        registry.registerBeanDefinition("otherJeep", rbd1);

    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("MyBeanDefinition...postProcessorBeanFactory...Bean的数量："
                + beanFactory.getBeanDefinitionCount());
    }
}

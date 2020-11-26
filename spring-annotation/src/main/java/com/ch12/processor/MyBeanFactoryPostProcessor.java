package com.ch12.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

import java.util.Arrays;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor{

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("...MyBeanFactoryPostProcessor...正在调用BeanFactoryPostProcessor.postProcessBeanFactory...");

        //获取此时共有多少个bean已经被定义。
        //此时，bean只是定义好了，加载到了BeanFactory，但是bean实例还没有被创建
        int beanDefinitionCount = beanFactory.getBeanDefinitionCount();
        String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();

        System.out.println("当前BeanFactory中有几个Bean:" + beanDefinitionCount);
        System.out.println("BeanNames:" + Arrays.toString(beanDefinitionNames));
    }
}

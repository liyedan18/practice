package com.ch6.config;

import com.ch6.bean.Pig;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportBeanDefinitionRegister implements ImportBeanDefinitionRegistrar {

    /**
     * AnnotationMetadata 当前类的注解信息
     *  BeanDefinitionRegistry  bean定义注册类
     *
     *  把所有需要注册到容器中的bean，通过BeanDefinitionRegistry.registerBeanDefinition
     *  手动注册到容器中
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata,
                                        BeanDefinitionRegistry registry) {

        //打印当前类的注解
        // importingClassMetadata.getAnnotations().forEach(System.out::println);

        //要用全类名
        // boolean catFlag = registry.containsBeanDefinition("cat");
        // boolean dogFlag = registry.containsBeanDefinition("dog");
        boolean catFlag = registry.containsBeanDefinition("com.ch6.bean.Cat");
        boolean dogFlag = registry.containsBeanDefinition("com.ch6.bean.Dog");

        /**
         * 如果存在Cat和Dog组件，则添加Pig组件
         */
        if (catFlag && dogFlag){
            //将要导入的组件包装一下
            //包含bean的类型，scope信息
            RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(Pig.class);
            //可以断点进去第二个参数查看bean的定义信息（包含bean的类型，scope信息）
            //注册一个bean，bean名自定义为pig
            registry.registerBeanDefinition("pig", rootBeanDefinition);
        }

    }
}

package com.ch6.config;

import com.ch6.bean.Monkey;
import org.springframework.beans.factory.FactoryBean;

/**
 * 实现FactoryBean接口方式，向容器中注册bean
 *
 */
public class MyFactoryBean implements FactoryBean<Monkey> {

    /**
     * 返回对象，也是向容器中添加的bean
     */
    @Override
    public Monkey getObject() throws Exception {
        return new Monkey();
    }

    /**
     * 返回对象类型
     */
    @Override
    public Class<?> getObjectType() {
        return Monkey.class;
    }

    /**
     * 是否是单例
     */
    @Override
    public boolean isSingleton() {
        return true;
    }

}

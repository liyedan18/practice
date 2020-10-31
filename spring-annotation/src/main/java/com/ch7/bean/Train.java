package com.ch7.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

// @Component
public class Train implements InitializingBean, DisposableBean {

    public Train(){
        System.out.println("Train...constructor...");
    }

    //容器创建时调用
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Tran...afterPropertiesSet...");
    }

    // 容器关闭时调用
    @Override
    public void destroy() throws Exception {
        System.out.println("Train...destroy...");
    }

}

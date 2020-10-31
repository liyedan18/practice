package com.ch7.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//JSR250注解
public class Jeep {

    public Jeep(){
        System.out.println("Jeep...constructor...");
    }

    @PostConstruct
    public void init(){
        System.out.println("jeep...@PostConstruct...");
    }

    @PreDestroy
    public void destory(){
        System.out.println("jeep...@PreDestory...");
    }

}

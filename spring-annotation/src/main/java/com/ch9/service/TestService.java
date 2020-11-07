package com.ch9.service;

import com.ch9.repo.TestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.inject.Inject;

@Service
public class TestService {

    // @Qualifier("testDao")  //指定用id=testDao的bean
    // @Autowired(required = false)
    // @Resource
    @Inject
    private TestDao testDao;

    public void print(){
        System.out.println("service..." + testDao);
    }
}

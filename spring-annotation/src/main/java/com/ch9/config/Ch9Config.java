package com.ch9.config;

import com.ch9.repo.TestDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan({"com.ch9.controller", "com.ch9.service", "com.ch9.repo"})
public class Ch9Config {

    @Primary
    // @Bean
    @Bean("testDao3")
    public TestDao testDao(){
        TestDao testDao2 = new TestDao();
        testDao2.setFlag("2");
        return testDao2;
    }
}

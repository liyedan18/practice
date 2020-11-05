package com.ch8.config;

import com.ch8.bean.Bird;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@ComponentScan
@PropertySource("classpath:/bird.properties")
public class Ch8Config {

    @Bean
    public Bird bird(){
        return new Bird();
    }
}

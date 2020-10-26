package com.ch1;

import com.ch1.bean.Person;
import com.ch1.config.MainConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class MainTest {
    public static void main(String[] args) {

        //获取到IOC容器
        ApplicationContext app = new AnnotationConfigApplicationContext(MainConfig.class);
        String[] beanNames = app.getBeanNamesForType(Person.class);

        Arrays.stream(beanNames).forEach(System.out::println);

//        for (String name : beanNames) {
//            System.out.println(name);
//        }

        //从容器中获取bean
        Person person = (Person) app.getBean("person1");
        System.out.println(person);

    }
}

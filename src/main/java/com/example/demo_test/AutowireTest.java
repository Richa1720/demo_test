package com.example.demo_test;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AutowireTest {


    //@Autowired
    //@Qualifier("yash")
    private String name;


    @Autowired // it works without using Autowired annotation
    public AutowireTest(@Qualifier("test") String name)
    {
        this.name=name;
    }


    @Value("${spring.application.name}")
    String appName;   //this variable stores value of variable passed in @Value annotation

    @PostConstruct
    public void init()
    {
        System.out.println(appName);
        System.out.println(name);
        System.out.println(name);
    }


}

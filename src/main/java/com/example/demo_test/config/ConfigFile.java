package com.example.demo_test.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration   //where configuration is defined
public class ConfigFile {

/* @Bean --//a method-level annotation that indicates a method instantiates, configures,
and initializes a new object for the Spring IoC container to manage. */
    @Bean
    @Primary    //this beans will be called by default when no bean called manually
    public String varsha()
    {
        return "Varsha";
    }

    @Bean("test")
    public String yash()
    {
        return "Yash";
    }


}

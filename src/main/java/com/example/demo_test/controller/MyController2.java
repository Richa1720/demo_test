package com.example.demo_test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class MyController2 {

    @GetMapping("hello2")
    //@ResponseBody               //method level as well class level annotation
    public String hello2()
    {
        return "Hello from Controller annotation...";
    }
}

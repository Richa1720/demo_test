package com.example.demo_test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController1 {

    @GetMapping("/hello1")
    public String hello()
    {
        return "Hello, from RestController annotation ...";
    }

}

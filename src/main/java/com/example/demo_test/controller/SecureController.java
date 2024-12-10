package com.example.demo_test.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecureController {


    // hasRole() method in spring security is used to specify access restrictions
    // based on user roles.
    // where 'USER' is defining a role on the basis of credential passed

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/user/home")
    public String userHome() {
        return "User Home";
    }

    @PreAuthorize("hasRole('ADMIN')")   // here we have to authenticate b'coz @PreAuthorise annotation is applied
    @GetMapping("/admin/home")
    public String adminHome()
    {
        return "Admin Home";
    }

    //No need to create token to access this api
    @GetMapping("/public/home")
    public String publicHome()
    {

        return "Public Home";

    }


}
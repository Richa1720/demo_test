package com.example.demo_test.controller;


import com.example.demo_test.model.AuthenticationRequest;
import com.example.demo_test.service.MyUserDetailsService;
import com.example.demo_test.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JwtAuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;



    // 3 injected to generate token by passing userDetails
    @Autowired
    private JwtTokenUtil jwtTokenUtil;


    //2 step
    @Autowired
    private MyUserDetailsService userDetailsService;



    @PostMapping("/authenticate")
    public String createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception
    {


        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername()); //loading data from UDS
        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return jwt;

    }
}
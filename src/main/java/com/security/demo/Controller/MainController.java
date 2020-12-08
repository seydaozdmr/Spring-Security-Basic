package com.security.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    //home path
    @GetMapping("/")
    public String home(){
        return "index";
    }
    //admin path
    @GetMapping("/admin")
    public String admin(){
        return "admin";
    }
    //user path
    @GetMapping("/user")
    public String user(){
        return "user";
    }
    //her birinin templates içersinde html olarak karşılığı bulunmalı

}

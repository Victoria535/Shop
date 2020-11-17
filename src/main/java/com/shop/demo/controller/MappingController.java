package com.shop.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MappingController {

    @GetMapping("/")
    public String start(){
        return "index";
    }

    @GetMapping("/registration")
    public String hello(){
        return "registration";
    }
}

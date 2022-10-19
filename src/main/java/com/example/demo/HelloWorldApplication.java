package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldApplication {
    @GetMapping("/")
    public String index(){
        return "Hello World";
    }
}

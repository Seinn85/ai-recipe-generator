package com.example.airecipe.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello, AI Recipe App!";
    }

    @GetMapping("/hello/name")
    public String helloName(@RequestParam(defaultValue = "Guest") String name) {
        return "Hello, " + name + "! Welcome to AI Recipe App!";
    }
}
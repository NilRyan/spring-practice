package com.indifferentcat.practice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api/hello")
@RequiredArgsConstructor
public class HelloWorldController {

    @GetMapping
    public String helloWorld() {
        return "Hello World!a";
    }

    @GetMapping("/test")
    public String test(Principal principal) {
        return principal.getName();
    }


}

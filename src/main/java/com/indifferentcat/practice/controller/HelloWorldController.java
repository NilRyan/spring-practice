package com.indifferentcat.practice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api/hello")
@RequiredArgsConstructor
public class HelloWorldController {

    @GetMapping
    @PreAuthorize("hasAuthority('READ')")
    public String helloWorld() {
        return "Hello World!a";
    }

    @GetMapping("/test")
    @PreAuthorize("hasAuthority('READ')")
    public String test(Principal principal) {
        return principal.getName();
    }


}

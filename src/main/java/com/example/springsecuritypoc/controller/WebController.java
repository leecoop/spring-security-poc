package com.example.springsecuritypoc.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@PreAuthorize("isAuthenticated()")
public class WebController {

//    @PreAuthorize("permitAll()")
//        @PreAuthorize("isAuthenticated()")

    @RequestMapping("/")
    public String home() {
        return "Welcome home!";
    }

    //    @PreAuthorize("hasAnyRole(USER)")
    @PreAuthorize("isAuthenticated()")
    @RequestMapping("/restricted")
    public String restricted() {
        return "You found the secret lair!";
    }
}
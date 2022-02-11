package com.countdown.vote.securinglogin.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class AuthenticationController {

    @GetMapping("/login")
    public String showLoginForm() {
        return "users/login";
    }

    @GetMapping("/home")
    public String showHome() {
        return "/home";
    }
}





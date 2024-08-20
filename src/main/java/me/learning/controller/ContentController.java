package me.learning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContentController {
    @GetMapping("/home")
    public String handleWelcome() {
        return "home";
    }

    @GetMapping("/login")
    public String handleLogin() {
        return "login";
    }
}

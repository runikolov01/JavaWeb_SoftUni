package com.dictionaryapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    @GetMapping("/index")
    public String openIndexPage() {
        return "index";
    }

    @GetMapping("/home")
    public String openHomePage() {
        return "home";
    }


    @GetMapping("/login")
    public String openLoginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String openRegisterPage() {
        return "register";
    }

    @GetMapping("/word-add")
    public String openAddingWordPage() {
        return "word-add";
    }

}

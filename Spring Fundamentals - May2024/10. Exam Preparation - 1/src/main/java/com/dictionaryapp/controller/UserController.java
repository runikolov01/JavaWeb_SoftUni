package com.dictionaryapp.controller;

import com.dictionaryapp.model.entity.UserRegisterDTO;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {
    @ModelAttribute
    public UserRegisterDTO createEmptyDTO() {
        return new UserRegisterDTO();
    }

    @GetMapping("/index")
    public String openIndexPage() {
        return "index";
    }

    @GetMapping("/home")
    public String openHomePage() {
        return "home";
    }

    @GetMapping("/register")
    public String openRegisterPage(Model model) {
        return "register";
    }

    @PostMapping("register")
    public String registerUser(@Valid UserRegisterDTO data,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("registerData", data);
            return "redirect:/register";
        }
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String openLoginPage() {
        return "login";
    }


    @GetMapping("/word-add")
    public String openAddingWordPage() {
        return "word-add";
    }

}
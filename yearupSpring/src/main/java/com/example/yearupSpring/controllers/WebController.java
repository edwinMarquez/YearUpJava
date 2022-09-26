package com.example.yearupSpring.controllers;


import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {

    @RequestMapping("/")
    String indexPage(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        boolean authenticated = !(authentication instanceof AnonymousAuthenticationToken);
        System.out.println("************* auth: " + authenticated);
        model.addAttribute("auth",authenticated);
        model.addAttribute("username",username);
        return "index";
    }

    @RequestMapping("/login")
    String loginPage(Model model){
        return "login";
    }

}

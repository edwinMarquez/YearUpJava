package com.example.yearupSpring.controllers;


import com.example.yearupSpring.models.Account;
import com.example.yearupSpring.models.AccountRepository;
import com.example.yearupSpring.models.User;
import com.example.yearupSpring.models.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.thymeleaf.util.ArrayUtils;

import java.util.Arrays;
import java.util.List;

@Controller
public class WebController {

    @Autowired
    AccountRepository accountRepo;
    @Autowired
    UserRepository userRepository;

    @RequestMapping("/")
    String indexPage(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        boolean authenticated = !(authentication instanceof AnonymousAuthenticationToken);
        if(authenticated){
            User user = userRepository.findByUsername(username);
            Account account = accountRepo.findByUser(user);
            model.addAttribute("balance",(account.getBalance()/100));
            List<User> users = userRepository.findAll();
            String[] userNames = new String[users.size()-1];

            for(int i =0, j = 0; j < users.size(); j++){
                if(!users.get(j).getUsername().equals(username)){
                    userNames[i] = users.get(j).getUsername();
                    i++;
                }
            }
            model.addAttribute("otherUsers",userNames);
        }
        model.addAttribute("auth",authenticated);
        model.addAttribute("username",username);

        return "index";
    }

    @RequestMapping("/login")
    String loginPage(Model model){
        return "login";
    }

    @RequestMapping("/signup")
    String signUp(Model model){
        return "signup";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    String signUpPost(Model model){
        return "index";
    }


}

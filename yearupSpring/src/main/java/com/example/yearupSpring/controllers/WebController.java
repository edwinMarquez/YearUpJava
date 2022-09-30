package com.example.yearupSpring.controllers;


import com.example.yearupSpring.models.Account;
import com.example.yearupSpring.models.AccountRepository;
import com.example.yearupSpring.models.User;
import com.example.yearupSpring.models.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.ArrayUtils;

import java.util.Arrays;
import java.util.Base64;
import java.util.List;

@Controller
public class WebController {

    @Autowired
    AccountRepository accountRepo;
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

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

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    String signUp(Model model){
        return "signup";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    @Transactional
    String signUpPost(Model model, @RequestParam String username, @RequestParam String name,
                      @RequestParam String password, @RequestParam String passwordverify){

        if(password.isEmpty()){
            model.addAttribute("error", "password can't be empty");
            return "signup";
        }
        if(!password.equals(passwordverify)){
            model.addAttribute("error","Passwords don't match");
            return "signup";
        }
        User user = userRepository.findByUsername(username);
        if(user != null){
            model.addAttribute("error","username is taken, please choose a new one");
            return "signup";
        }

        int totalUsers = (int) userRepository.count();
        user = new User();
        user.setName(name);
        user.setUsername(username);
        user.setPassword(base64ToBytes(passwordEncoder.encode(password)));
        user = userRepository.save(user);

        //give the user an account.
        Account account = new Account();
        account.setUser(user);
        account.setBalance(500000);
        accountRepo.save(account);
        model.addAttribute("success", "Success!");
        return "signup";

//        return "redirect:/";
    }

    private byte[] base64ToBytes(String base64){
        return Base64.getDecoder().decode(base64);
    }


}

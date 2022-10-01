package com.example.yearupSpring.controllers;


import com.example.yearupSpring.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Base64;
import java.util.List;

@Controller
public class WebController {

    @Autowired
    AccountRepository accountRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @RequestMapping("/")
    String indexPage(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        boolean authenticated = !(authentication instanceof AnonymousAuthenticationToken);
        if(authenticated){
            User user = userRepository.findByUsername(username);
            Account account = accountRepository.findByUser(user);
            model.addAttribute("balance",(account.getBalance()/100));
            List<User> users = userRepository.findAll();
            String[] userNames = new String[users.size()-1];

            for(int i =0, j = 0; j < users.size(); j++){
                if(!users.get(j).getUsername().equals(username)){
                    userNames[i] = users.get(j).getUsername();
                    i++;
                }
            }
            if(userNames.length > 0){
                model.addAttribute("otherUsers",userNames);
            }
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
        accountRepository.save(account);
        model.addAttribute("success", "Success!");
        return "signup";
    }


    @RequestMapping(value = "/transfer", method = RequestMethod.POST)
    @Transactional
    String postTransfer(RedirectAttributes redirectAttributes, @RequestParam String transferTo, @RequestParam String amount){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        boolean authenticated = !(authentication instanceof AnonymousAuthenticationToken);
        if(!authenticated){
            redirectAttributes.addFlashAttribute("error","you need to be authenticated in order to make a transfer");
            return "redirect:/";
        }
        int transferAmount = (int)(Float.parseFloat(amount) * 100);
        if(transferAmount <= 0){
            redirectAttributes.addFlashAttribute("error","only positive amounts are allowed for transfer");
            return "redirect:/";
        }
        String thisUser = authentication.getName();
        User fromUser = userRepository.findByUsername(thisUser);
        User toUser = userRepository.findByUsername(transferTo);
        if(toUser == null){
            redirectAttributes.addFlashAttribute("error","wrong user to send to");
            return "redirect:/";
        }
        Account fromAccount = accountRepository.findByUser(fromUser);
        if(fromAccount.getBalance() < transferAmount){
            redirectAttributes.addFlashAttribute("error","Insufficient funds");
            return "redirect:/";
        }
        Account toAccount = accountRepository.findByUser(toUser);
        //update account balances.
        fromAccount.setBalance(fromAccount.getBalance() - transferAmount);
        toAccount.setBalance(toAccount.getBalance() + transferAmount);
        //create related transaction record
        Transaction transaction = new Transaction();
        transaction.setFromUser(fromUser);
        transaction.setToUser(toUser);
        transaction.setAmount(transferAmount);
        transaction.setTransactionTime(System.currentTimeMillis());
        //save modified information
        userRepository.save(fromUser);
        userRepository.save(toUser);
        accountRepository.save(fromAccount);
        accountRepository.save(toAccount);
        transactionRepository.save(transaction);
        redirectAttributes.addFlashAttribute("success","SUCCESS! transfer completed");
        return "redirect:/";
    }

    private byte[] base64ToBytes(String base64){
        return Base64.getDecoder().decode(base64);
    }


}

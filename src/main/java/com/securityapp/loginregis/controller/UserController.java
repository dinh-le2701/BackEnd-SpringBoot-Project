package com.securityapp.loginregis.controller;

import com.securityapp.loginregis.dto.UserDto;
import com.securityapp.loginregis.service.UserService;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("")
public class UserController {
    @Autowired
    private UserService userService;
    
    @Autowired
    private UserDetailsService userDetailsService;

    @GetMapping("/registration")
    public String getRegistrationPage(@ModelAttribute("user") UserDto userDto){
        return "register";
    }

    @PostMapping("/registration")
    public String saveUser(@ModelAttribute("user")UserDto userDto, Model model){
        userService.saveUser(userDto);
        model.addAttribute("message", "Registered Successfully");
        return "register";
    }
    
    @GetMapping("/login")
    public String login(@ModelAttribute("user") UserDto userDto, Model model) {
    	model.addAttribute("message", "Registered Successfully");
    	return "login";
    }
    
    @GetMapping("/user-page")
    public String userPage(Model model, Principal principal) {
    	UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
    	model.addAttribute("user", userDetails);
    	return "user";
    }
    
    @GetMapping("/admin-page")
    public String adminPage(Model model, Principal principal) {
    	UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
    	model.addAttribute("user", userDetails);
    	return "admin";
    }
}

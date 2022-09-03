package com.example.servingwebcontent.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.servingwebcontent.service.AuthenticationService;

@Controller
@RequestMapping("/login")
public class LoginController {

    

    @GetMapping()
    public String loginView() {
        return "login";
    }

 


}

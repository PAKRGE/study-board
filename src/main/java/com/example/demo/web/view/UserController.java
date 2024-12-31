package com.example.demo.web.view;

import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    @GetMapping("/login")
    public void login() {
    }

    @GetMapping("/sign-up")
    public String signUp() {
        return "users/signUp";
    }

    @GetMapping("/find-account")
    public String findAccount() {
        return "users/findAccount";
    }

}

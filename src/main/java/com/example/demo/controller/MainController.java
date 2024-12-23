package com.example.demo.controller;

import com.example.demo.controller.request.UserIdCheckRequest;
import com.example.demo.controller.request.UserRequest;
import com.example.demo.controller.response.UserIdCheckResponse;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class MainController {
    private final UserService userService;

    @GetMapping("/login")
    public void login() {

    }

    @GetMapping("/sign-up")
    public String signUp() {
        return "signUp";
    }

    @ResponseBody
    @PostMapping("/sign-up")
    public void signUpPost(
            @RequestBody UserRequest userRequest
    ) {
        System.out.println("userRequest : " + userRequest);
        userService.signUpUser(userRequest.userId(), userRequest.userName(), userRequest.password());
    }

    @ResponseBody
    @PostMapping("/user-id-check")
    public UserIdCheckResponse userIdCheckPost(
            @RequestBody UserIdCheckRequest userIdCheckRequest
    ) {
        if (!userService.checkPassword(userIdCheckRequest.userId())) {
            return UserIdCheckResponse.fail();
        }
        return UserIdCheckResponse.successful();
    }

}

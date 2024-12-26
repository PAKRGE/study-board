package com.example.demo.controller;

import com.example.demo.controller.request.*;
import com.example.demo.controller.response.FindUserIdResponse;
import com.example.demo.controller.response.UserEmailCheckResponse;
import com.example.demo.controller.response.UserIdCheckResponse;
import com.example.demo.controller.response.UserLoginResponse;
import com.example.demo.model.FindUserIdData;
import com.example.demo.model.UserData;
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

    @ResponseBody
    @PostMapping("/login")
    public UserLoginResponse loginPost(
            @RequestBody UserLoginRequest userLoginRequest
    ) {
        UserData userData = userService.loginUser(userLoginRequest.userId(), userLoginRequest.password());
        if (userData != null) {
            return UserLoginResponse.successful(userData.getUserName());
        }
        return UserLoginResponse.fail();
    }

    @GetMapping("/sign-up")
    public String signUp() {
        return "signUp";
    }

    @GetMapping("/user-board")
    public String userBoard() {
        return "userBoard";
    }


    @ResponseBody
    @PostMapping("/sign-up")
    public void signUpPost(
            @RequestBody UserRequest userRequest
    ) {
        System.out.println("userRequest : " + userRequest);
        userService.signUpUser(userRequest.userId(), userRequest.email(), userRequest.userName(), userRequest.password());
    }

    @ResponseBody
    @PostMapping("/user-id-check")
    public UserIdCheckResponse userIdCheck(
            @RequestBody UserIdCheckRequest userIdCheckRequest
    ) {
        if (!userService.checkId(userIdCheckRequest.userId())) {
            return UserIdCheckResponse.fail();
        }
        return UserIdCheckResponse.successful();
    }

    @ResponseBody
    @PostMapping("/check-email")
    public UserEmailCheckResponse userEmailCheck(
            @RequestBody UserEmailCheckRequest userEmailCheckRequest
    ) {
        if (!userService.checkEmail(userEmailCheckRequest.email())) {
            return UserEmailCheckResponse.fail();
        }
        return UserEmailCheckResponse.successful();
    }

    @GetMapping("/find-account")
    public String findAccount() {
        return "findAccount";
    }

    @ResponseBody
    @PostMapping("/find-user-id")
    public FindUserIdResponse findID(
            @RequestBody FindUserIdRequest findUserIdRequest
    ) {
        FindUserIdData findUserIdData = userService.findUserId(findUserIdRequest.email());
        if (findUserIdData != null) {
            return FindUserIdResponse.successful(findUserIdData);
        }
        return FindUserIdResponse.fail();
    }

}

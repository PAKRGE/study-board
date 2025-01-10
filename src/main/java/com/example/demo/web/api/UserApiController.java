package com.example.demo.web.api;

import com.example.demo.model.FindUserIdData;
import com.example.demo.model.FindUserPasswordData;
import com.example.demo.model.UserData;
import com.example.demo.service.UserService;
import com.example.demo.web.model.request.*;
import com.example.demo.web.model.response.*;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserApiController {
    private final UserService userService;

    @PostMapping("/login")
    public UserLoginResponse loginPost(
            HttpSession session,
            @RequestBody UserLoginRequest userLoginRequest
    ) {
        UserData userData = userService.loginUser(userLoginRequest.userId(), userLoginRequest.password());
        if (userData != null) {
            session.setAttribute("userData", userData);
            return UserLoginResponse.successful(userData.getUserName());
        }
        return UserLoginResponse.fail();
    }

    @PostMapping("/find-user-id")
    public FindUserIdResponse findId(
            @RequestBody FindUserIdRequest findUserIdRequest
    ) {
        FindUserIdData findUserIdData = userService.findUserId(findUserIdRequest.email());
        if (findUserIdData != null) {
            return FindUserIdResponse.successful(findUserIdData);
        }
        return FindUserIdResponse.fail();
    }

    @PostMapping("/find-user-password")
    public FindUserPasswordResponse findPassword(
            @RequestBody FindUserPasswordRequest findUserPasswordRequest
    ) {
        FindUserPasswordData findUserPasswordData = userService.findUserPassword(findUserPasswordRequest.userId(), findUserPasswordRequest.email());
        if (findUserPasswordData != null) {
            return FindUserPasswordResponse.successful(findUserPasswordData.getPassword());
        }
        return FindUserPasswordResponse.fail();
    }

    @PostMapping("/sign-up")
    public void signUpPost(
            @RequestBody UserRequest userRequest
    ) {
        System.out.println("userRequest : " + userRequest);
        userService.signUpUser(userRequest.userId(), userRequest.email(), userRequest.userName(), userRequest.password());
    }

    @PostMapping("/user-id-check")
    public UserIdCheckResponse userIdCheck(
            @RequestBody UserIdCheckRequest userIdCheckRequest
    ) {
        if (!userService.checkId(userIdCheckRequest.userId())) {
            return UserIdCheckResponse.fail();
        }
        return UserIdCheckResponse.successful();
    }

    @PostMapping("/check-email")
    public UserEmailCheckResponse userEmailCheck(
            @RequestBody UserEmailCheckRequest userEmailCheckRequest
    ) {
        if (!userService.checkEmail(userEmailCheckRequest.email())) {
            return UserEmailCheckResponse.fail();
        }
        return UserEmailCheckResponse.successful();
    }
}

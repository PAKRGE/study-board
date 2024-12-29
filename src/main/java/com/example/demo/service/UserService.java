package com.example.demo.service;

import com.example.demo.model.FindUserIdData;
import com.example.demo.model.FindUserPasswordData;
import com.example.demo.model.UserData;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void signUpUser(String userId, String email, String userName, String password) {
        userRepository.signUpUser(userId, email, userName, password);
    }

    public boolean checkId(String userId) {
        if (userRepository.selectUserId(userId) == null) {
            return false;
        }
        return true;
    }

    public boolean checkEmail(String email) {
        if (userRepository.selectEmail(email) == null) {
            return false;
        }
        return true;
    }

    public UserData loginUser(String userId, String password) {
        return userRepository.loginUser(userId, password);
    }

    public FindUserIdData findUserId(String email) {
        return userRepository.findUserId(email);
    }

    public FindUserPasswordData findUserPassword(String userId, String email) {
        return userRepository.findUserPassword(userId, email);
    }
}

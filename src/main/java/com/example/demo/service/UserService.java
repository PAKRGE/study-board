package com.example.demo.service;

import com.example.demo.model.UserData;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void signUpUser(String userId, String userName, String password) {
        userRepository.signUpUser(userId, userName, password);
    }

    public boolean checkPassword(String userId) {
        if(userRepository.selectPassword(userId) != null) {
            return true;
        } else {
            return false;
        }
    }

    public UserData loginUser(String userId, String password) {
        return userRepository.loginUser(userId, password);
    }
}

package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FindUserPasswordData {
    private final String userName;
    private final String userId;
    private final String email;
    private final String password;
}

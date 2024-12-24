package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class UserData {
    private final String userId;
    private final String userName;
    private final String password;
}

package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@ToString
@AllArgsConstructor
public class UserData {
    private final String userId;
    private final String userName;
    private final String password;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;
    private final String email;
}

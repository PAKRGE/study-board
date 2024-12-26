package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FindUserIdData {
    private final String userName;
    private final String userId;
    private final String email;
}

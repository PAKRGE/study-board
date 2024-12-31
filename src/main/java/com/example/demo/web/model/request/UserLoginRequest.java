package com.example.demo.web.model.request;

public record UserLoginRequest(
        String userId,
        String password
) {
}

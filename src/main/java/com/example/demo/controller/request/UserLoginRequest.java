package com.example.demo.controller.request;

public record UserLoginRequest(
        String userId,
        String password
) {
}

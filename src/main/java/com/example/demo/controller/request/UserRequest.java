package com.example.demo.controller.request;

public record UserRequest(
        String userId,
        String email,
        String userName,
        String password
) {
}

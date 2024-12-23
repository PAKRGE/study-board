package com.example.demo.controller.request;

public record UserRequest(
        String userId,
        String userName,
        String password
) {
}

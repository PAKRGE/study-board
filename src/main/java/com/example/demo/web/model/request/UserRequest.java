package com.example.demo.web.model.request;

public record UserRequest(
        String userId,
        String email,
        String userName,
        String password
) {
}

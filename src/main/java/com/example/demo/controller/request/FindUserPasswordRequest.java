package com.example.demo.controller.request;

public record FindUserPasswordRequest(
        String userId,
        String email
) {
}

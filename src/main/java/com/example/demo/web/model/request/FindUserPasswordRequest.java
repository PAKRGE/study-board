package com.example.demo.web.model.request;

public record FindUserPasswordRequest(
        String userId,
        String email
) {
}

package com.example.demo.web.model.response;

public record UserEmailCheckResponse(
        boolean success
) {
    public static UserEmailCheckResponse fail() {
        return new UserEmailCheckResponse(
                false
        );
    }

    public static UserEmailCheckResponse successful() {
        return new UserEmailCheckResponse(
                true
        );
    }
}

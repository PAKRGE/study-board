package com.example.demo.web.model.response;

public record UserIdCheckResponse(
        boolean success
) {
    public static UserIdCheckResponse fail() {
        return new UserIdCheckResponse(false);
    }

    public static UserIdCheckResponse successful() {
        return new UserIdCheckResponse(true);
    }
}

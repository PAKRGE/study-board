package com.example.demo.web.model.response;

public record UserLoginResponse(
        boolean success,
        String userName
) {
    public static UserLoginResponse fail() {
        return new UserLoginResponse(
                false,
                ""
        );
    }

    public static UserLoginResponse successful(String userName) {
        return new UserLoginResponse(
                true,
                userName
        );
    }
}

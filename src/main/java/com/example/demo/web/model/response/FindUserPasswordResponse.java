package com.example.demo.web.model.response;

public record FindUserPasswordResponse(
        boolean success,
        String password
) {
    public static FindUserPasswordResponse fail() {
        return new FindUserPasswordResponse(
                false,
                null
        );
    }

    public static FindUserPasswordResponse successful(String password) {
        return new FindUserPasswordResponse(
                true,
                password
        );
    }

}

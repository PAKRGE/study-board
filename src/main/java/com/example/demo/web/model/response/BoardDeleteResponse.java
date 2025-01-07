package com.example.demo.web.model.response;

public record BoardDeleteResponse(
        boolean success
) {
    public static BoardDeleteResponse successful() {
        return new BoardDeleteResponse(
                true
        );
    }
    public static BoardDeleteResponse fail() {
        return new BoardDeleteResponse(
                false
        );
    }
}

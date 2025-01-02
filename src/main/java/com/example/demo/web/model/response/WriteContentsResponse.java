package com.example.demo.web.model.response;

public record WriteContentsResponse(
        boolean success
) {
    public static WriteContentsResponse fail() {
        return new WriteContentsResponse(
                false
        );
    }

    public static WriteContentsResponse successful() {
        return new WriteContentsResponse(
                true
        );
    }
}

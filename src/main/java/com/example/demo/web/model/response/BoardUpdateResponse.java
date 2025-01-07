package com.example.demo.web.model.response;

public record BoardUpdateResponse(
        boolean success
) {
    public static BoardUpdateResponse successful() {
        return new BoardUpdateResponse(
                true
        );
    }

    public static BoardUpdateResponse fail() {
        return new BoardUpdateResponse(
                false
        );
    }

    @Override
    public String toString() {
        return "BoardUpdateResponse{" +
                "success=" + success +
                '}';
    }
}

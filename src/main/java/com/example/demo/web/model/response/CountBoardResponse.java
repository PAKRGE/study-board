package com.example.demo.web.model.response;

public record CountBoardResponse(
        boolean success,
        int countBoard
) {
    public static CountBoardResponse fail() {
        return new CountBoardResponse(
                false,
                0
        );
    }

    public static CountBoardResponse successful(int countBoard) {
        return new CountBoardResponse(
                true,
                countBoard
        );
    }
}

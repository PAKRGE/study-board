package com.example.demo.web.model.response;

import com.example.demo.repository.model.BoardData;

import java.util.List;

public record BoardListResponse(
        boolean success,
        List<BoardData> boardDataList
) {
    public static BoardListResponse fail() {
        return new BoardListResponse(
                false,
                null
        );
    }

    public static BoardListResponse successful(List<BoardData> boardDataList) {
        return new BoardListResponse(
                true,
                boardDataList
        );
    }
}

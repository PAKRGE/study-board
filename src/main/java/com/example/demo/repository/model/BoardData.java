package com.example.demo.repository.model;

import java.time.LocalDateTime;

public record BoardData(
        int id,
        String userId,
        String boardContents,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        String boardTitle
) {
    public BoardData updateContent(String contents, String title) {
        return new BoardData(
                id,
                userId,
                contents,
                createdAt,
                updatedAt,
                title
        );
    }
}

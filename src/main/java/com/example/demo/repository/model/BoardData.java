package com.example.demo.repository.model;

import java.time.LocalDateTime;

public record BoardData(
        int id,
        String userId,
        String boardContents,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
    public BoardData updateContent(String contents) {
        return new BoardData(
                id,
                userId,
                contents,
                createdAt,
                updatedAt
        );
    }
}

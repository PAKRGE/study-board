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
    public BoardData updateBoardData(String contents, String title) {
        return new BoardData(
                id,
                userId,
                contents,
                createdAt,
                LocalDateTime.now(),
                title
        );
    }

    @Override
    public String toString() {
        return "BoardData{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", boardContents='" + boardContents + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", boardTitle='" + boardTitle + '\'' +
                '}';
    }
}

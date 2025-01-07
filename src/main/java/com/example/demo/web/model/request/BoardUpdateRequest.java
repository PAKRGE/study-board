package com.example.demo.web.model.request;

public record BoardUpdateRequest(
        String boardTitle,
        String boardContents,
        String userId,
        int id
) {
}

package com.example.demo.web.model.request;

public record BoardDeleteRequest(
        int boardId,
        String userId
) {
}

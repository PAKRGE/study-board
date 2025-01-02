package com.example.demo.web.model.request;

public record WriteContentsRequest(
        String userId,
        String boardContents,
        String boardTitle
) {
}

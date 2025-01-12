package com.example.demo.web.model.request;

public record WriteContentsRequest(
        String boardContents,
        String boardTitle
) {
}

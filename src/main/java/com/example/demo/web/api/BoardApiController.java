package com.example.demo.web.api;

import com.example.demo.service.BoardService;
import com.example.demo.web.model.request.BoardDeleteRequest;
import com.example.demo.web.model.request.WriteContentsRequest;
import com.example.demo.web.model.response.CountBoardResponse;
import com.example.demo.web.model.response.BoardDeleteResponse;
import com.example.demo.web.model.response.WriteContentsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/boards")
public class BoardApiController {
    private final BoardService boardService;

    @PostMapping("/write-contents")
    public WriteContentsResponse writeContents(
            @RequestBody WriteContentsRequest writeContentsRequest
    ) {
        boardService.writeContents(writeContentsRequest.userId(), writeContentsRequest.boardContents(), writeContentsRequest.boardTitle());
        return WriteContentsResponse.successful();

    }

    @PostMapping("/count-board")
    public CountBoardResponse countBoard() {
        int countBoard = boardService.countBoard();
        if (countBoard != 0) {
            return CountBoardResponse.successful(countBoard);
        }
        return CountBoardResponse.fail();
    }

    @PostMapping("/board-delete")
    public BoardDeleteResponse boardDelete(
            @RequestBody BoardDeleteRequest boardDeleteRequest
    ) {
        if (boardService.deleteBoard(boardDeleteRequest.boardId()) != 0) {
            return BoardDeleteResponse.successful();
        }
        return BoardDeleteResponse.fail();
    }
}

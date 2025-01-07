package com.example.demo.web.api;

import com.example.demo.repository.model.BoardData;
import com.example.demo.service.BoardService;
import com.example.demo.web.model.request.BoardListRequest;
import com.example.demo.web.model.request.WriteContentsRequest;
import com.example.demo.web.model.response.BoardListResponse;
import com.example.demo.web.model.response.CountBoardResponse;
import com.example.demo.web.model.response.WriteContentsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @PostMapping("/board-list")
    public BoardListResponse boardList(
                @RequestBody BoardListRequest boardListRequest
    ) {
        int minPage = 0;
        int maxPage = 0;
        if(boardListRequest.page() != 0) {
            minPage = (boardListRequest.page() - 1) * 4;
            maxPage = 4;
        }

        List<BoardData> boardDataList = boardService.boardList(minPage, maxPage);
        if (boardDataList != null) {
            return BoardListResponse.successful(boardDataList);
        }
        return BoardListResponse.fail();
    }

    @PostMapping("/count-board")
    public CountBoardResponse countBoard() {
        int countBoard = boardService.countBoard();
        if (countBoard != 0) {
            return CountBoardResponse.successful(countBoard);
        }
        return CountBoardResponse.fail();
    }
}

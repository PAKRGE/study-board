package com.example.demo.web.api;

import com.example.demo.model.UserData;
import com.example.demo.service.BoardService;
import com.example.demo.web.model.request.BoardDeleteRequest;
import com.example.demo.web.model.request.BoardUpdateRequest;
import com.example.demo.web.model.request.WriteContentsRequest;
import com.example.demo.web.model.response.BoardDeleteResponse;
import com.example.demo.web.model.response.BoardUpdateResponse;
import com.example.demo.web.model.response.CountBoardResponse;
import com.example.demo.web.model.response.WriteContentsResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/boards")
public class BoardApiController {
    private final BoardService boardService;

    @PostMapping("/write-contents")
    public WriteContentsResponse writeContents(
            HttpServletRequest request,
            @RequestBody WriteContentsRequest writeContentsRequest
    ) {
        UserData userData = (UserData) request.getSession().getAttribute("userData");
        boardService.writeContents(userData.getUserId(), writeContentsRequest.boardContents(), writeContentsRequest.boardTitle());
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
            HttpServletRequest request,
            @RequestBody BoardDeleteRequest boardDeleteRequest
    ) {
        UserData userData = (UserData) request.getSession().getAttribute("userData");
        if (incorrectUserId(boardDeleteRequest, userData)) {
            boardService.deleteBoard(boardDeleteRequest.boardId());
            return BoardDeleteResponse.successful();
        }
        return BoardDeleteResponse.fail();
    }

    private static boolean incorrectUserId(BoardDeleteRequest boardDeleteRequest, UserData userData) {
        return userData.getUserId().equals(boardDeleteRequest.userId());
    }

    @PostMapping("/board-update")
    public BoardUpdateResponse boardUpdate(
            @RequestBody BoardUpdateRequest boardUpdateRequest
    ) {
        log.info("boardUpdateRequest : " + boardUpdateRequest.toString());
        boardService.updateBoard(boardUpdateRequest.boardTitle(),boardUpdateRequest.boardContents(),boardUpdateRequest.id());
        return BoardUpdateResponse.successful();
    }
}

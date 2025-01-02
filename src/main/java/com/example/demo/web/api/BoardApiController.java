package com.example.demo.web.api;

import com.example.demo.service.BoardService;
import com.example.demo.web.model.request.WriteContentsRequest;
import com.example.demo.web.model.response.WriteContentsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequiredArgsConstructor
@RequestMapping("/boards")
public class BoardApiController {
    private final BoardService boardService;

    @PostMapping("/write-contents")
    public WriteContentsResponse writeContents(
            @RequestBody WriteContentsRequest writeContentsRequest
    ) {
        if(boardService.writeContents(writeContentsRequest.userId(), writeContentsRequest.boardContents(), writeContentsRequest.boardTitle())) {
            return WriteContentsResponse.successful();
        }
        return WriteContentsResponse.fail();
    }
}

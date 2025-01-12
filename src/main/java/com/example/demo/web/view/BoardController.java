package com.example.demo.web.view;

import com.example.demo.model.Page;
import com.example.demo.repository.model.BoardData;
import com.example.demo.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/boards")
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/board-list")
    public String boardList(
            @RequestParam(value = "page", defaultValue = "1") int page,
            Model model
    ) {
        int offset = (page - 1) * 4;
        int limit = 4;

        Page<List<BoardData>> paging = boardService.pagingList(offset, limit);
        paging.setCurrentPage(page);

        model.addAttribute("board", paging);

        return "boards/boardList";
    }

    @GetMapping("/write-contents")
    public String writeContents() {
        return "boards/writeContents";
    }

    @GetMapping("/board-update")
    public String boardUpdate(
            @RequestParam(value = "id") int id,
            Model model
    ) {
        BoardData board = boardService.selectBoard(id);
        log.info(board.toString());
        model.addAttribute("board", board);
        return "boards/updateBoard";
    }

}

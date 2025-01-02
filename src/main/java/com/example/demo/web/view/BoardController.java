package com.example.demo.web.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/boards")
public class BoardController {

    @GetMapping("/board-list")
    public String boardList() {
        return "boards/boardList";
    }

    @GetMapping("/write-contents")
    public String writeContents() {
        return "boards/writeContents";
    }

}

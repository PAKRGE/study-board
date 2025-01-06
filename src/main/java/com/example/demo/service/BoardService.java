package com.example.demo.service;

import com.example.demo.repository.BoardRepository;
import com.example.demo.repository.model.BoardData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public boolean writeContents(String userId, String boardContents, String boardTitle) {
        try {
            boardRepository.writeContents(userId,boardContents,boardTitle);
            System.out.println("ture!!!!!!!!!!!!!");
            return true;
        } catch (Exception e) {
            System.out.println("exception : " + e);
            return false;
        }
    }

    public List<BoardData> boardList(int minPage, int maxPage) {
        return boardRepository.boardList(minPage, maxPage);
    }

    public int countBoard() {
        return boardRepository.countBoard();
    }
}

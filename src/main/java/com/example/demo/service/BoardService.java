package com.example.demo.service;

import com.example.demo.model.Page;
import com.example.demo.repository.BoardRepository;
import com.example.demo.repository.model.BoardData;
import com.example.demo.service.exception.UserNotFoundException;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public void writeContents(String userId, String boardContents, String boardTitle) {
        try {
            boardRepository.writeContents(userId, boardContents, boardTitle);
            System.out.println("ture!!!!!!!!!!!!!");
        } catch (DataIntegrityViolationException e) {
            throw new UserNotFoundException(e.getMessage());
        }
    }

    public List<BoardData> boardList(int minPage, int maxPage) {
        return boardRepository.boardList(minPage, maxPage);
    }

    public Page<List<BoardData>> pagingList(int offset, int limit) {
        return new Page<>(
                this.boardList(offset, limit),
                this.countBoard(),
                limit
        );
    }

    public int countBoard() {
        return boardRepository.countBoard();
    }
}

class Person {
    private final String name;
    private final int age;

    @Builder
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
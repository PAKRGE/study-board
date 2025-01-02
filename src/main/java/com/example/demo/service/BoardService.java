package com.example.demo.service;

import com.example.demo.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
}

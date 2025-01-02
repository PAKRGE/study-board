package com.example.demo.repository;

import com.example.demo.repository.model.BoardData;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BoardRepository {

    @Insert("""
            INSERT INTO BOARD (user_id, board_contents, board_title)
            VALUES (#{userId}, #{boardContents}, #{boardTitle})
    """)
    void writeContents(String userId, String boardContents, String boardTitle);

    @Select("""
            SELECT *
            FROM BOARD
    """)
    List<BoardData> boardList();

}

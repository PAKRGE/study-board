package com.example.demo.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardRepository {

    @Insert("""
            INSERT INTO board (user_id, board_contents, board_title)
            VALUES (#{userId}, #{boardContents}, #{boardTitle})
    """)
    void writeContents(String userId, String boardContents, String boardTitle);


}

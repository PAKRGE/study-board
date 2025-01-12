package com.example.demo.repository;

import com.example.demo.repository.model.BoardData;
import org.apache.ibatis.annotations.*;

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
            ORDER BY ID DESC
            LIMIT #{limit} OFFSET #{offset}
    """)
    List<BoardData> boardList(int offset, int limit);

    @Select("""
            SELECT COUNT(*)
            FROM BOARD
    """)
    int countBoard();

    @Delete("""
            DELETE
            FROM BOARD
            WHERE id = #{id}
    """)
    int deleteBoard(int id);

    @Select("""
            SELECT *
            FROM BOARD
            WHERE ID = #{id}
    """)
    BoardData selectBoard(int id);

    @Update("""
            UPDATE BOARD
            SET board_title = #{title},
                board_contents = #{content},
                updatedAt = CURRENT_TIMESTAMP
            WHERE id = #{id}
    """)
    void updateBoard(String title, String content, int id);

}

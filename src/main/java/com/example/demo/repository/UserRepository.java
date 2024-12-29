package com.example.demo.repository;

import com.example.demo.model.FindUserIdData;
import com.example.demo.model.FindUserPasswordData;
import com.example.demo.model.UserData;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface UserRepository {

    //sign-up 회원가입
    @Insert("""
            INSERT INTO users (user_id, email, user_name, password)
            VALUES (#{userId}, #{email}, #{userName}, #{password})
            """)
    void signUpUser(String userId, String email, String userName, String password);

    //ID찾기 check-Id
    @Select("""
            SELECT user_id
              FROM users
             WHERE user_id = #{userId}
            """)
    String selectUserId(String userId);

    //email찾기 check-email
    @Select("""
            SELECT email
              FROM users
             WHERE email = #{email}
    """)
    String selectEmail(String email);

    //login
    @Select("""
            SELECT user_id
                 , user_name
                 , password
            FROM users
            WHERE user_id = #{userId}
              AND password = #{password}
    """)
    UserData loginUser(String userId, String password);

    //find-id
    @Select("""
            SELECT user_name
              , user_id
              , email
            FROM users
            WHERE email = #{email}
    """)
    FindUserIdData findUserId(String email);

    //find-password
    @Select("""
            SELECT user_name
              , user_id
              , email
              , password
            FROM users
            WHERE user_id = #{userId}
              AND email = #{email}
    """)
    FindUserPasswordData findUserPassword(String userId, String email);


}

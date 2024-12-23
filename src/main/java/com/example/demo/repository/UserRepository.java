package com.example.demo.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserRepository {

    //sign-up 회원가입
    @Insert("INSERT INTO users (user_id, user_name, password) VALUES (#{userId}, #{userName}, #{password})")
    void signUpUser(String userId, String userName, String password);

    //password찾기 check-password
    @Select("SELECT password FROM users WHERE user_id = #{userId}")
    String selectPassword(String userId);

}

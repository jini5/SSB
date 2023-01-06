package com.example.jpatest01.service;

import com.example.jpatest01.dto.UserRequest;

public interface UserService {

    //유저 등록
    String insertUser(UserRequest userRequest);

    //유저 로그인
    String selectUser(UserRequest userRequest);
}

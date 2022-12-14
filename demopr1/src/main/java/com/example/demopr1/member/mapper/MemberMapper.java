package com.example.demopr1.member.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;

@Mapper
public interface MemberMapper {
    public int signup(HashMap<String,String> params);

    public HashMap<String,String> login(String params);

    public HashMap<String,String> findMember(String id, String password);

    boolean selectMemberByEmail(String email);
    boolean selectMemberById(String id);
}

package com.example.allproject.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;

@Mapper
public interface MemberMapper {

    public int signup(HashMap<String,String> params);

    public HashMap<String,String> login(String params);


}
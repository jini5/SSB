package com.example.demoweb.mapper;


import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;

@Mapper
public interface MemberMapper {
    public int signup(HashMap<String,String> memberInfo);

    public HashMap<String, String> login(HashMap<String,String> memberInfo);
}

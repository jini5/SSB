package com.example.demoweb.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;

@Mapper
public interface SendMapper {

    public int requestCall(HashMap<String, String> requestInfo);

    public int subscribe(String email);
}

package com.example.demoweb.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;

@Mapper
public interface CoinMapper {
    public int buyCoin(HashMap<String,String> buyInfo);
}

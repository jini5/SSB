package com.example.bitcoinproject.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;

@Mapper
public interface ContactMapper {

    public int insertSubscribe(HashMap<String,String> params);
    public int insertContact(HashMap<String,String> params);
}

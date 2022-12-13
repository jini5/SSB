package com.example.bitcointest.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.HashMap;

@Mapper
public interface MemberMapper {


    public int insertMember(HashMap<String,String> member);

    public HashMap<String,Object> loginMember(HashMap<String,String> member);


    public int hadBalance(String email);
    public ArrayList<HashMap<String,Object>> havingBalance(String email);
}

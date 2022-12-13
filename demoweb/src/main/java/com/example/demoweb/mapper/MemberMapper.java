package com.example.demoweb.mapper;


import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.HashMap;

@Mapper
public interface MemberMapper {
    public int signup(HashMap<String,String> memberInfo);

    public HashMap<String, String> login(HashMap<String,String> memberInfo);


    public int hadBalance(String email);
    public int moneyBalance(String email);
    public ArrayList<HashMap<String,Object>> havingBalance(String email);

    public ArrayList<HashMap<String,String>> getMemberCoinInfo(String email);

    public ArrayList<HashMap<String,Object>> MemberPoint(String email);

    public ArrayList<HashMap<String,Object>> MemberCoin(String email);

}

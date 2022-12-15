package com.example.bitcointest.member.repository;

import com.example.bitcointest.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;

@Repository
public class MemberRepository {

    @Autowired
    MemberMapper mapper;

    public int insertMember(HashMap<String,String> member){
        return mapper.insertMember(member);
    }

    public HashMap<String,Object> loginMember(HashMap<String,String> member){
        return mapper.loginMember(member);
    }


    public int hadBalance(String email){
        return mapper.hadBalance(email);
    }

    public ArrayList<HashMap<String,Object>> havingBalance(String email){
        return mapper.havingBalance(email);
    }
}

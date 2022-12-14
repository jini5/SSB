package com.example.demopr1.member.repository;

import com.example.demopr1.member.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class MemberRepository {

    @Autowired
    MemberMapper mapper;


    public int signup(HashMap<String,String> params){

        return mapper.signup(params);
    }

    public HashMap<String, String> login(String params){

        return mapper.login(params);
    }


}

package com.example.allproject.repository;

import com.example.allproject.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class MemberRepository {

    @Autowired
    MemberMapper mapper;


    public int signup(HashMap<String,String> params){
        System.out.println("repo param"+params);
        return mapper.signup(params);
    }

    public HashMap<String, String> login(String params){
        System.out.println("repo param"+params);
        return mapper.login(params);
    }


}

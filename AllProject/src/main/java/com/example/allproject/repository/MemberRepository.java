package com.example.allproject.repository;

import com.example.allproject.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class MemberRepository {

    @Autowired
    MemberMapper mapper;

    public int signup(HashMap<String,String> member){
        return mapper.signup(member);
    }

    public HashMap<String,Object> login(HashMap<String,String> member){
        return mapper.login(member);
    }




}

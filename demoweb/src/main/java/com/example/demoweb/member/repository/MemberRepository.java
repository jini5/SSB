package com.example.demoweb.member.repository;


import com.example.demoweb.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class MemberRepository {

    @Autowired
    MemberMapper mm;

    public int signup(HashMap<String, String> memberInfo){
        return mm.signup(memberInfo);
    }

    public HashMap<String, String> login(HashMap<String, String> memberInfo){
        return mm.login(memberInfo);
    }


}

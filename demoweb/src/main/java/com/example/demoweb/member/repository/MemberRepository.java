package com.example.demoweb.member.repository;


import com.example.demoweb.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
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


    public int hadBalance(String email){
        return mm.hadBalance(email);
    }

    public ArrayList<HashMap<String,Object>> havingBalance(String email){
        return mm.havingBalance(email);
    }
    public int moneyBalance(String email){
        return mm.moneyBalance(email);
    }

    public ArrayList<HashMap<String,Object>> MemberPoint(String email){
        return mm.MemberPoint(email);
    }

    public ArrayList<HashMap<String,Object>> MemberCoin(String email){
        return mm.MemberCoin(email);
    }


}

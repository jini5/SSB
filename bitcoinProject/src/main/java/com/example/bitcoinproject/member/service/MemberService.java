package com.example.bitcoinproject.member.service;

import com.example.bitcoinproject.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class MemberService {

    @Autowired
    MemberRepository repo;

    //멤버가입
    public int insertMember(HashMap<String,String> member){
        return repo.insertMember(member);
    }
    //로그인
    public HashMap<String,Object> loginMember(HashMap<String,String> member){
        return repo.loginMember(member);
    }

    public int hadBalance(String email){
        return repo.hadBalance(email);
    }

    public ArrayList<HashMap<String,Object>> havingBalance(String email){
        return repo.havingBalance(email);
    }
    public int moneyBalance(String email){
        return repo.moneyBalance(email);
    }
}

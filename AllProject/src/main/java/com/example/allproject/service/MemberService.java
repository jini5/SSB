package com.example.allproject.service;

import com.example.allproject.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class MemberService {

    @Autowired
    MemberRepository repo;


    public int signup(HashMap<String,String> member){
        return repo.signup(member);
    }
    public HashMap<String,Object> login(HashMap<String,String> member){
        return repo.login(member);
    }

}

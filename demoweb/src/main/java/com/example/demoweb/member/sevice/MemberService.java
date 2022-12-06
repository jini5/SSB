package com.example.demoweb.member.sevice;


import com.example.demoweb.member.DTO.MemberDTO;
import com.example.demoweb.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class MemberService {
    @Autowired
    MemberRepository mr;

    public int signup(HashMap<String, String> memberInfo){
        return 1;
    }

    public MemberDTO login(HashMap<String,String> memberInfo){
     return null;
    }




}

package com.example.demopr1.member.service;


import com.example.demopr1.member.mapper.MemberMapper;
import com.example.demopr1.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashMap;

@Service
public class MemberService {


    @Autowired
    MemberRepository mr;


    public int signup(HashMap<String,String> params){

        return mr.signup(params);
    }

    public String login(String id, String password){

        try {
            if(mr.login(id).get("password").equals(password)){
                System.out.println(mr.login(id).get("name"));
                return mr.login(id).get("name");
            }
        }catch (Exception e){
            e.printStackTrace();
        }return null;
    }


}

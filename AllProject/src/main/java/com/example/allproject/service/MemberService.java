package com.example.allproject.service;

import com.example.allproject.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class MemberService {

    @Autowired
    MemberRepository mr;

    public int signup(HashMap<String,String> params){
        return mr.signup(params);
    }

    public String login(String email, String password){

        try {
            if(mr.login(email).get("password").equals(password)){
                return mr.login(email).get("firstName");
            }
        }catch (Exception e){
            e.printStackTrace();
        }return null;
    }

}

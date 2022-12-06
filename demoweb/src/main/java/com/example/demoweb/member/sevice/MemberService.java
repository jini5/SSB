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
        try {
            mr.signup(memberInfo);
            return 1;
        }catch (Exception e){
            return -1;
        }
    }


    public MemberDTO login(HashMap<String,String> memberInfo){
        try {
            HashMap<String,String> member = mr.login(memberInfo);
            return new MemberDTO(member.get("email"),member.get("name"),member.get("phone"),member.get("address"),member.get("detail"));
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }




}

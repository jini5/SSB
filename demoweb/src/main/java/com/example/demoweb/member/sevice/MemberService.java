package com.example.demoweb.member.sevice;


import com.example.demoweb.member.DTO.MemberDto;
import com.example.demoweb.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class MemberService {
    @Autowired
    MemberRepository mr;

    public boolean signup(HashMap<String, String> memberInfo){
        try {
            System.out.println(memberInfo.toString());
            return mr.signup(memberInfo)>0;

        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }


    public MemberDto login(HashMap<String,String> memberInfo){
        try {
            HashMap<String,String> member = mr.login(memberInfo);
            return new MemberDto(member.get("email"),member.get("name"),member.get("phone"),member.get("address"),member.get("detail"));
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }


    public int hadBalance(String email){
        return mr.hadBalance(email);
    }

    public ArrayList<HashMap<String,Object>> havingBalance(String email){
        return mr.havingBalance(email);
    }

    public int moneyBalance(String email){
        return mr.moneyBalance(email);
    }

    public ArrayList<HashMap<String,Object>> MemberPoint(String email){
        return mr.MemberPoint(email);
    }

    public ArrayList<HashMap<String,Object>> MemberCoin(String email){
        return mr.MemberCoin(email);
    }




}

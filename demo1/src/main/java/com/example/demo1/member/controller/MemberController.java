package com.example.demo1.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;

@Controller
public class MemberController {
    ArrayList<HashMap<String,String>> memberList = new ArrayList<>();

    @PostMapping("/signup")
    public String signup(@RequestParam HashMap<String,String> params){

        memberList.add(params);

        return"index";
    }

    @PostMapping("/login")
    public String login(@RequestParam HashMap<String, String> params, HttpSession session){
        for(HashMap<String,String> mem : memberList) {
            if (params.get("email").equals(mem.get("email")) && params.get("password").equals(mem.get("password"))) {
                //가입된 회원인 경우
                session.setAttribute("email", mem.get("email"));
                System.out.println(mem.get("email"));
            }
        }

        return "selectpage";
    }


    @GetMapping("logout")
    public String logOut(HttpSession session){
        //session.invalidate(); 웬만하면 안쓰도록 - 다른 값도 초기화 시켜서

        session.setAttribute("email",null);
        return "index";
    }
}

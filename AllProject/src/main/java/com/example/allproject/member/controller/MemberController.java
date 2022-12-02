package com.example.allproject.member.controller;

import com.example.allproject.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Controller
public class MemberController {


    @Autowired
    MemberService ms;


    @PostMapping("/signup")
    public String signup(@RequestParam HashMap<String, String> params){
        System.out.println("controller param"+params);
        if(ms.signup(params)>0) {
            return "index";
        }

        return"signup";
    }

    @PostMapping("/login")
    public String login(@RequestParam HashMap<String, String> member, HttpSession session){


        String name = ms.login(member.get("email"),member.get("password"));

        if (name != null) { // 로그인이 되어있는 상태
            System.out.println("로그인이 되어있는 상태");
            session.setAttribute("SESSION_NAME",name);
            return "index";
        }
        return "login";
    }



}

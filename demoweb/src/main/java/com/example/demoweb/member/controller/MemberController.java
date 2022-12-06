package com.example.demoweb.member.controller;


import com.example.demoweb.member.DTO.MemberDTO;
import com.example.demoweb.member.sevice.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Controller
public class MemberController {

    @Autowired
    MemberService ms;

    @PostMapping("/signup")
    public String signup(@RequestParam HashMap<String, String> memberInfo){
        if(ms.signup(memberInfo)) {
            return "index";
        }
        return"signup";
    }

    @PostMapping("/login")
    public String login(@RequestParam HashMap<String, String> memberInfo, HttpSession session){


        MemberDTO memberDTO = ms.login(memberInfo);

        if (memberDTO != null) { // 로그인이 되어있는 상태
            System.out.println("로그인이 되어있는 상태");
            session.setAttribute("SESSION_INFO",memberDTO);
            return "index";
        }
        return "login";
    }

    @GetMapping("/goLogout")
    public String logout(HttpSession session){
        session.setAttribute("SESSION_INFO",null);
        return "index";
    }


}
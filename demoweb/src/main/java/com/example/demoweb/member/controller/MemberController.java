package com.example.demoweb.member.controller;


import com.example.demoweb.member.DTO.MemberDto;
import com.example.demoweb.member.sevice.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
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


        MemberDto memberDTO = ms.login(memberInfo);

        if (memberDTO != null) { // 로그인이 되어있는 상태
            System.out.println("로그인이 되어있는 상태");
            session.setAttribute("SESSION_INFO",memberDTO);
            return "index";
        }
        return "login";
    }


    @GetMapping("/hadBalance")
    public @ResponseBody int hadBalance(HttpSession session){
        if(session.getAttribute("email")!=null){
            String email = String.valueOf(session.getAttribute("email"));
            return ms.hadBalance(email);
        }
        return 0;
    }

    @GetMapping("/havingBalance")
    public @ResponseBody ArrayList<HashMap<String, Object>> havingBalance(HttpSession session){
        if(session.getAttribute("email")!=null){
            String email = String.valueOf(session.getAttribute("email"));
            return ms.havingBalance(email);
        }
        return null;
    }

    @GetMapping("/moneyBalance")
    public @ResponseBody int moneyBalance(HttpSession session){
        if(session.getAttribute("email")!=null){
            String email = String.valueOf(session.getAttribute("email"));
            return ms.moneyBalance(email);
        }
        return 0;
    }



    @GetMapping("/pointList")
    public @ResponseBody ArrayList<HashMap<String,Object>> pointList(HttpSession session){
        if(session.getAttribute("SESSION_INFO")==null)return null;
        MemberDto memberDTO = (MemberDto)session.getAttribute("SESSION_INFO");
        return ms.MemberPoint(memberDTO.getEmail());
    }

    @GetMapping("/buyList")
    public @ResponseBody ArrayList<HashMap<String,Object>> buyList(HttpSession session){
        if(session.getAttribute("SESSION_INFO")==null)return null;
        MemberDto memberDTO = (MemberDto)session.getAttribute("SESSION_INFO");
        return ms.MemberCoin(memberDTO.getEmail());
    }

    @GetMapping("/goSell")
    public String goSell(){
        return "sell";
    }




}

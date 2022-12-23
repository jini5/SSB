package com.example.allproject.controller;

import com.example.allproject.service.MemberService;
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
    public String signup(@RequestParam HashMap<String,String> params){
        ms.signup(params);
        return "redirect:/";
    }

    @PostMapping("/login")
    public String login(@RequestParam HashMap<String,String> params, HttpSession session){
        HashMap<String,Object> verified=ms.login(params);
        if(verified!=null) {
            String email = String.valueOf(verified.get("email"));
            session.setAttribute("email", email);

            session.setAttribute("name", String.valueOf(verified.get("name")));
            session.setAttribute("phone", String.valueOf(verified.get("phone")));
            session.setAttribute("address", String.valueOf(verified.get("address")));
            session.setAttribute("detail", String.valueOf(verified.get("detail")));
        }
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.setAttribute("SESSION_INFO",null);
        return "index";
    }

}

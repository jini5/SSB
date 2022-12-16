package com.example.bitcointest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class PageController {

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/goSignup")
    public String goSignup(){
        return "signup";
    }

    @GetMapping("/goLogin")
    public String goLogin(){
        return "login";
    }

    @GetMapping("/goLogout")
    public String logout(HttpSession session){

        session.invalidate();
        return "index";
    }

    @GetMapping("/goPay")
    public String goPay(){
        return "pay";
    }

    @GetMapping("/goMarket")
    public String goMarket(){
        return "market";
    }

    @GetMapping("/goHistory")
    public String goHistory(){
        return "history";
    }

    @GetMapping("/goUserInfo")
    public String goUserInfo(HttpSession session){
        if(session.getAttribute("email")==null){
            return "login";
        }
        return "userinfo";
    }
}

package com.example.bitcoinproject.controller;

import com.example.bitcoinproject.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Controller
public class PageController {
    HttpSession session;

    @Autowired
    AdminService as;

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
    public String goUserInfo(){
        return "userinfo";
    }

    @GetMapping("/adminindex")
    public String adminIndex(){
        if(session.getAttribute("email")==null){
            return "adminlogin";
        }
        return "adminindex";
    }

    @GetMapping("/admin")
    public String login(){
        return "adminlogin";
    }

    @GetMapping("/goMember")
    public String goMemberList(){
        return "memberList";
    }

    @GetMapping("/goPayment")
    public String goPayment(){
        return "paymentList";
    }

    @GetMapping("/goBuy")
    public String goBuy(){
        return "buyList";
    }

    @GetMapping("/goContact")
    public String goContact(){
        return "contactList";
    }

    @GetMapping("/goSubscribe")
    public String goSubscribe(){
        return "subscribeList";
    }


    @PostMapping("/adminlogin")
    public String loginAdmin(@RequestParam HashMap<String,String> admin, HttpSession session){
        HashMap<String,Object> verified = as.loginAdmin(admin);
        if(verified!=null){
            String id = String.valueOf(verified.get("id"));
            session.setAttribute("id",id);
            return "adminindex";
        }
        return "adminlogin";
    }

}

package com.example.demoweb.page.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class PageController {
    @Autowired
    HttpSession session;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/goSignup")
    public String goSignup() {
        if (checkLoginStatus()) {
            return "index";
        }
        return "signup";
    }

    @GetMapping("/goLogin")
    public String goLogin() {
        if (checkLoginStatus()) {
            return "index";
        }
        return "login";
    }

    @GetMapping("/goPay")
    public String goPay() {
        if (!checkLoginStatus()) {
            return "login";
        }
        return "pay";
    }

    @GetMapping("/goHistory")
    public String goHistory() {
        if (!checkLoginStatus()) {
            return "login";
        }
        return "history";
    }

    @GetMapping("/goMarket")
    public String goMarket() {
        if (!checkLoginStatus()) {
            return "login";
        }
        return "market";
    }



    public boolean checkLoginStatus() {
        if (session.getAttribute("SESSION_INFO") != null) {
            return true;
        } else return false;
    }

}
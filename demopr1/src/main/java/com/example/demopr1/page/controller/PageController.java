package com.example.demopr1.page.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/goMain")
    public String goMain(){
        return "main";
    }

    @GetMapping("/goSignUp")
    public String goSignUp(){
        return "signup";
    }

    @GetMapping("/goLogin")
    public String goLogin(){
        return "login";
    }

    @GetMapping("/goLogout")
    public String goLogout(){
        return "logout";
    }

    @GetMapping("/goTodo")
    public String goTodo(){
        return "todo";
    }

    @GetMapping("/chat")
    public String goChat(){
        return "chat";
    }

    @GetMapping("/nickname")
    public String goNickName(){
        return "nickname";
    }

    @GetMapping("/chatting")
    public String goChatting(){
        return "chatting";
    }


}




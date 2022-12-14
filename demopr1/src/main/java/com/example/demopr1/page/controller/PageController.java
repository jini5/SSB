package com.example.demopr1.page.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class PageController {

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/goMain")
    public String goMain(){
        return "memberpage";
    }

    @GetMapping("/goSignUp")
    public String goSignUp(HttpSession session){
        if(session.getAttribute("SESSION_NAME")!=null){
            return "index";
        }
        return "signup";
    }

    @GetMapping("/goLogin")
    public String goLogin(HttpSession session){
        if(session.getAttribute("SESSION_NAME")!=null){
            return "index";
        }
        return "login";
    }

    @GetMapping("/goLogout")
    public String goLogout(HttpSession session){
        session.setAttribute("SESSION_NAME",null);
        return "index";
    }

    @GetMapping("/goMemberPage")
    public String goMember(HttpSession session){
        if(session.getAttribute("SESSION_NAME")==null){
            return "signup";
        }
        else{
            return "memberpage";
        }
    }

    @GetMapping("/goTodo")
    public String goTodo(){
        return "todo";
    }

    @GetMapping("/gochat")
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




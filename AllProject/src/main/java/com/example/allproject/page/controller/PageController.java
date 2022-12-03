package com.example.allproject.page.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class PageController {

    @GetMapping("/")
    public String index(){
        return "index";
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

    @GetMapping("/goMember")
    public String goMember(HttpSession session){
        if(session.getAttribute("SESSION_NAME")==null){
            return "login";
        }
        else{
            return "memberpage";
        }
    }

    @GetMapping("/goLogout")
    public String goLogout(HttpSession session){
        session.setAttribute("SESSION_NAME",null);
        return "index";
    }

    @GetMapping("/goTodo")
    public String goTodo(HttpSession session){
        if(session.getAttribute("SESSION_NAME")==null){
            return "login";
        }

        return "todo";
    }

}
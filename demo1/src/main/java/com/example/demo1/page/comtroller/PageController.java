package com.example.demo1.page.comtroller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class PageController {

    @GetMapping("/")
    public String index(){

        return "index";
    }
    @GetMapping("/goLogin")
    public String login(){

        return "login";
    }
    @GetMapping("/goSignUp")
    public String signup(){

        return "signup";
    }


    @GetMapping("/goLogout")
    public String logout(){

        return "logout";
    }


    @GetMapping("goTodo")
    public String todo(){
        return "todo";
    }

    @GetMapping("goCalendar")
    public String calendar(){

        return "calendar";
    }

    @GetMapping("/goChat")
    public String goMember(HttpSession session){
        if(session.getAttribute("email")==null){
            return "signup";
        }
        else{
            session.setAttribute("nickName", session.getAttribute("email"));
            return "chatting";
        }
    }

}

package com.example.reservation.page.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class PageController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/goCalendar")
    public String goCalendar(String place, String id, Model model) {
        model.addAttribute("place", place);
        model.addAttribute("id", id);
        return "calendar";
    }

    @GetMapping("/map")
    public String goMap() {
        return "map";
    }

    @GetMapping("/login")
    public String goLogin() {
        return "index";
    }

    @GetMapping("/logout")
    public String goLogout(HttpSession session) {
        session.setAttribute("Account", null);
        return "index";
    }


}

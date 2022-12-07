package com.example.demoweb.send.controller;

import com.example.demoweb.send.service.SendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;


@Controller
public class SendController {

    @Autowired
    SendService ss;

    @PostMapping("requestCall")
    public String goRequestCall(@RequestParam HashMap<String,String> requestInfo){
        if(ss.requestCall(requestInfo)){
            System.out.println("연락처를 보냈습니다.");
        }
        return "index";
    }

    @GetMapping("subscribe")
    public String goSubscribe(@RequestParam String email){
        if(ss.subscribe(email)){
            System.out.println("구독이 완료되었습니다.");
        }
        return "index";
    }
}

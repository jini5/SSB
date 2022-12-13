package com.example.demoweb.point.controller;

import com.example.demoweb.member.DTO.MemberDto;
import com.example.demoweb.point.service.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

@Controller
public class PointController {

    @Autowired
    PointService ps;



    @GetMapping("/point")
    public String insertPoint(@RequestParam HashMap<String, String> chargeInfo, HttpSession session){

        MemberDto memberDTO = (MemberDto)session.getAttribute("SESSION_INFO");
        if(ps.insertPoint(chargeInfo,memberDTO.getEmail())){
            System.out.println("충전 완료");
        }

        return "pay";
    }

//    @GetMapping("/pointList")
//    public ArrayList<HashMap<String, Object>> pointList(HttpSession session){
//        if(session.getAttribute("email")!=null){
//            String email = String.valueOf(session.getAttribute("email"));
//            return ps.selectPoint(email);
//        }
//        return null;
//    }


    @GetMapping("/checkBalance")
    public String checkBalance(HttpSession session,String total){
        if(session.getAttribute("email")!=null){

            String email=String.valueOf(session.getAttribute("email"));
            double balance=ps.checkBalance(email);
            double totalAmount=Double.valueOf(total);

            if((balance-totalAmount)>0){
                return "can";
            }else{
                return "cannot";
            }
        }else{
            return "login";
        }
    }

}

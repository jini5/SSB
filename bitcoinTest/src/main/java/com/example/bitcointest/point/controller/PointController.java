package com.example.bitcointest.point.controller;

import com.example.bitcointest.point.service.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class PointController {

    @Autowired
    PointService ps;

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

    @GetMapping("/point")
    public String insertPoint(@RequestParam HashMap<String,String> point, HttpSession session){
        if(session.getAttribute("email")!=null){

            String email=String.valueOf(session.getAttribute("email"));
            point.put("email",email);
            ps.insertPoint(point);

        }else{
            return "로그인해주세요.";
        }
         return "충전 성공하였습니다.";
    }
    @GetMapping("/pointList")
    public @ResponseBody ArrayList<HashMap<String,Object>> pointList(HttpSession session){
        if(session.getAttribute("email")!=null){
            String email = String.valueOf(session.getAttribute("email"));
            return ps.selectPoint(email);
        }
        return null;
    }
}

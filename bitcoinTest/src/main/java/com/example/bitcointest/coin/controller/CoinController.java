package com.example.bitcointest.coin.controller;

import com.example.bitcointest.coin.service.CoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;

@Controller
public class CoinController {

    @Autowired
    CoinService cs;

    @PostMapping("/buyCoin")
    public @ResponseBody String insertBuy(@RequestParam HashMap<String,String> params, HttpSession session){
        if(session.getAttribute("email")!=null){
           String email = String.valueOf(session.getAttribute("email"));
            params.put("email",email);
            cs.insertBuy(params);
            return "success";
        }
        return "failed";
    }

    @GetMapping("/buyList")
    public @ResponseBody ArrayList<HashMap<String,Object>> buyList(HttpSession session){
        if(session.getAttribute("email")!=null){
            String email = String.valueOf(session.getAttribute("email"));
            return cs.selectBuy(email);
        }
        return null;
    }
}

package com.example.demoweb.coin.controller;

import com.example.demoweb.coin.service.CoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

@Controller
public class CoinController {

    @Autowired
    CoinService cs;

    @GetMapping("buyCoin")
    public String goBuyCoin(@RequestParam HashMap<String,String> buyInfo){

        return "market";
    }

}

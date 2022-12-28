package com.example.bitcoinproject.admin.controller;

import com.example.bitcoinproject.admin.service.AdminService;
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
public class AdminController {

    @Autowired
    AdminService as;



    @GetMapping("/selectMember")
    public @ResponseBody ArrayList<HashMap<String,Object>> selectMember(HttpSession session){
        for (HashMap<String,Object> arr : as.selectMember()){
            System.out.println(arr.toString());
        }
        return as.selectMember();
    }

    @GetMapping("/selectPayment")
    public @ResponseBody ArrayList<HashMap<String,Object>> selectPayment(HttpSession session){
        return as.selectPayment();
    }

    @GetMapping("/selectBuy")
    public @ResponseBody ArrayList<HashMap<String,Object>> selectBuy(HttpSession session){
        return as.selectBuy();
    }

    @GetMapping("/selectContact")
    public @ResponseBody ArrayList<HashMap<String,Object>> selectContact(HttpSession session){
        return as.selectContact();
    }

    @GetMapping("/selectSubscribe")
    public @ResponseBody ArrayList<HashMap<String,Object>> selectSubscribe(HttpSession session){
        return as.selectSubscribe();
    }

    @GetMapping("/selectCntMember")
    public @ResponseBody int selectCntMember(){
        return as.selectCntMember();
    }

    @GetMapping("/selectCntContact")
    public @ResponseBody int selectCntContact(){
        return as.selectCntContact();
    }

    @GetMapping("/selectCntBuy")
    public @ResponseBody int selectCntBuy(){
        return as.selectCntBuy();
    }

    @GetMapping("/selectAmountPayment")
    public @ResponseBody double selectAmountPayment(){
        return as.selectAmountPayment();
    }

//    public int selectCntMember(){return repo.selectCntMember();}
//    public double selectAmountPayment(){return repo.selectAmountPayment();}
//    public int selectCntBuy(){return repo.selectCntBuy();}
//    public int selectCntContact(){return repo.selectCntContact();}

}

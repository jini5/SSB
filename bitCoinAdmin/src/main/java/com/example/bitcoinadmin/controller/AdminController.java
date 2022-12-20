package com.example.bitcoinadmin.controller;

import com.example.bitcoinadmin.service.AdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;

@Api(tags = {"관리자서비스"}, description = "관리자 관련 서비스")
@RestController
public class AdminController {

    @Autowired
    AdminService as;


    @ApiOperation(value = "고객 내역", notes = "고객의 정보 리스트")
    @GetMapping("/selectMember")
    public @ResponseBody ArrayList<HashMap<String,Object>> selectMember(HttpSession session){
//        for (HashMap<String,Object> arr : as.selectMember()){
//            System.out.println(arr.toString());
//        }
        return as.selectMember();
    }

    @ApiOperation(value = "사용자 충전 금액", notes = "사용자가 충전한 금액")
    @GetMapping("/selectPayment")
    public @ResponseBody ArrayList<HashMap<String,Object>> selectPayment(HttpSession session){
        return as.selectPayment();
    }

    @ApiOperation(value = "사용자 구매 내역", notes = "사용자가 구매한 코인")
    @GetMapping("/selectBuy")
    public @ResponseBody ArrayList<HashMap<String,Object>> selectBuy(HttpSession session){
        return as.selectBuy();
    }

    @ApiOperation(value = "연락을 원하는 사용자", notes = "연락하길 원하는 사용자")
    @GetMapping("/selectContact")
    public @ResponseBody ArrayList<HashMap<String,Object>> selectContact(HttpSession session){
        return as.selectContact();
    }

    @ApiOperation(value = "구독하는 사용자", notes = "구독하는 사용자")
    @GetMapping("/selectSubscribe")
    public @ResponseBody ArrayList<HashMap<String,Object>> selectSubscribe(HttpSession session){
        return as.selectSubscribe();
    }

    @ApiOperation(value = "총 가입자 수", notes = "가입한 고객 수")
    @GetMapping("/selectCntMember")
    public @ResponseBody int selectCntMember(){
        return as.selectCntMember();
    }

    @ApiOperation(value = "총 연락 요청 건수", notes = "연락 요청한 사람의 수")
    @GetMapping("/selectCntContact")
    public @ResponseBody int selectCntContact(){
        return as.selectCntContact();
    }

    @ApiOperation(value = "총 코인 구매 건수", notes = "고객들이 구매한 코인의 총 건수")
    @GetMapping("/selectCntBuy")
    public @ResponseBody int selectCntBuy(){
        return as.selectCntBuy();
    }


    @ApiOperation(value = "총 포인트 판매량", notes = "총 포인트 판매량을 조회한다")
    @GetMapping("/selectAmountPayment")
    public  double selectAmountPayment(){
        return as.selectAmountPayment();
    }


}

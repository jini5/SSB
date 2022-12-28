package com.example.bitcoinproject.admin.repository;

import com.example.bitcoinproject.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;

@Repository
public class AdminRepository {
    @Autowired
    AdminMapper mapper;

    public HashMap<String,Object> loginAdmin(HashMap<String,String> admin){
        System.out.println("bf"+admin);
        System.out.println("af"+mapper.loginAdmin(admin).toString());
        return mapper.loginAdmin(admin);}

    public ArrayList<HashMap<String,Object>> selectMember(){return mapper.selectMember();}
    public ArrayList<HashMap<String,Object>> selectPayment(){return mapper.selectPayment();}
    public ArrayList<HashMap<String,Object>> selectBuy(){return mapper.selectBuy();}
    public ArrayList<HashMap<String,Object>> selectContact(){return mapper.selectContact();};
    public ArrayList<HashMap<String,Object>> selectSubscribe(){return mapper.selectSubscribe();}

    public int selectCntMember(){return mapper.selectCntMember();}
    public double selectAmountPayment(){return mapper.selectAmountPayment();}
    public int selectCntBuy(){return mapper.selectCntBuy();}
    public int selectCntContact(){return mapper.selectCntContact();}

}

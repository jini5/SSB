package com.example.bitcoinadmin.service;

import com.example.bitcoinadmin.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class AdminService {

    @Autowired
    AdminRepository repo;

    public HashMap<String,Object> loginAdmin(HashMap<String,String> admin){return repo.loginAdmin(admin);}

    public ArrayList<HashMap<String,Object>> selectMember(){return repo.selectMember();}
    public ArrayList<HashMap<String,Object>> selectPayment(){return repo.selectPayment();}
    public ArrayList<HashMap<String,Object>> selectBuy(){return repo.selectBuy();}
    public ArrayList<HashMap<String,Object>> selectContact(){return repo.selectContact();};
    public ArrayList<HashMap<String,Object>> selectSubscribe(){return repo.selectSubscribe();}

    public int selectCntMember(){return repo.selectCntMember();}
    public double selectAmountPayment(){return repo.selectAmountPayment();}
    public int selectCntBuy(){return repo.selectCntBuy();}
    public int selectCntContact(){return repo.selectCntContact();}
}

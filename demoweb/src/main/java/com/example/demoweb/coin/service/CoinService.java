package com.example.demoweb.coin.service;

import com.example.demoweb.coin.repository.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class CoinService {

    @Autowired
    CoinRepository cr;

    public int buyCoin(HashMap<String,String> params){
        return cr.buyCoin(params);
    }


    public ArrayList<HashMap<String,Object>> selectBuy(String email){
        return cr.selectBuy(email);
    }

}

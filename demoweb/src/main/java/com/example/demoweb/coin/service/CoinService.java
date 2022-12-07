package com.example.demoweb.coin.service;

import com.example.demoweb.coin.repository.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class CoinService {

    @Autowired
    CoinRepository cr;

    public boolean buyCoin(HashMap<String,String> buyInfo){
        boolean status = false;
        try {
            status = cr.buyCoin(buyInfo)>0;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            return status;
        }

    }
}

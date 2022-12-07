package com.example.demoweb.coin.repository;

import com.example.demoweb.mapper.CoinMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class CoinRepository {
    @Autowired
    CoinMapper cm;

    public int buyCoin(HashMap<String,String> buyInfo){
        return cm.buyCoin(buyInfo);
    }

}

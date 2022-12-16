package com.example.bitcointest.point.service;

import com.example.bitcointest.point.repository.PointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class PointService {

    @Autowired
    PointRepository repo;

    public int insertPoint(HashMap<String,String> point){
        return repo.insertPoint(point);
    }
    public double checkBalance(String email){return repo.checkBalance(email);};
    public ArrayList<HashMap<String,Object>> selectPoint(String email){
        return repo.selectPoint(email);
    }
}

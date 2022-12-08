package com.example.demoweb.point.service;


import com.example.demoweb.point.repository.PointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class PointService {


    @Autowired
    PointRepository pr;

    public boolean insertPoint(HashMap<String,String> chargeInfo, String email){

        boolean status = false;
        chargeInfo.put("email",email);
        try{
            status= pr.insertPoint(chargeInfo) > 0;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            return status;
        }
    }

    public ArrayList<HashMap<String,Object>> selectPoint(String email){
        return pr.selectPoint(email);
    }


}

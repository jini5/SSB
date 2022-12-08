package com.example.demoweb.point.repository;


import com.example.demoweb.mapper.PointMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;

@Repository
public class PointRepository {


    @Autowired
    PointMapper pm;

    public int insertPoint(HashMap<String,String> chargeInfo){
        return pm.insertPoint(chargeInfo);
    }

    public ArrayList<HashMap<String,Object>> selectPoint(String email){
        return pm.selectPoint(email);
    }


}

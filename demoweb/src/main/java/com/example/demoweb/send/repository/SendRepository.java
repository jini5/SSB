package com.example.demoweb.send.repository;

import com.example.demoweb.mapper.SendMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class SendRepository {

    @Autowired
    SendMapper sm;

    public int requestCall(HashMap<String,String> requestInfo){
        return sm.requestCall(requestInfo);
    }

    public int subscribe(String email){
        return sm.subscribe(email);
    }

}

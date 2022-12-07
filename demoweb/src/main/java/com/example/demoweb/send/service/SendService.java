package com.example.demoweb.send.service;

import com.example.demoweb.send.repository.SendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class SendService {

    @Autowired
    SendRepository sr;


    public boolean requestCall(HashMap<String,String> requestInfo){
        boolean status = false;
        try{
            status = sr.requestCall(requestInfo)>0;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            return status;
        }
    }

    public boolean subscribe(String email){
        boolean status = false;
        try{
            status = sr.subscribe(email)>0;
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            return status;
        }
    }

}

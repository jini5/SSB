package com.example.bitcoinproject.contact.repository;

import com.example.bitcoinproject.mapper.ContactMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class ContactRepository {

    @Autowired
    ContactMapper mapper;

    public int insertSubscribe(HashMap<String,String> params){
        return mapper.insertSubscribe(params);
    }
    public int insertContact(HashMap<String,String> params){
        return mapper.insertContact(params);
    }
}

package com.example.bitcointest.contact.service;

import com.example.bitcointest.contact.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class ContactService {

    @Autowired
    ContactRepository repo;
    public int insertSubscribe(HashMap<String,String> params){
        return repo.insertSubscribe(params);
    }
    public int insertContact(HashMap<String,String> params){
        return repo.insertContact(params);
    }
}

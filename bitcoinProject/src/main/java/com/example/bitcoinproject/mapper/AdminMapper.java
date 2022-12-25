package com.example.bitcoinproject.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.HashMap;

@Mapper
public interface AdminMapper {

    public HashMap<String,Object> loginAdmin(HashMap<String,String> admin);
    public ArrayList<HashMap<String,Object>> selectMember();
    public ArrayList<HashMap<String,Object>> selectPayment();
    public ArrayList<HashMap<String,Object>> selectBuy();
    public ArrayList<HashMap<String,Object>> selectContact();
    public ArrayList<HashMap<String,Object>> selectSubscribe();

    public int selectCntMember();
    public double selectAmountPayment();
    public int selectCntBuy();
    public int selectCntContact();
}

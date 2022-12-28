package com.example.demoxenium.member.repository;


import com.example.demoxenium.mapper.MemberMapper;
import com.example.demoxenium.member.dto.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MemberRepository {

    @Autowired
    MemberMapper mapper;

    public int signup(Member member){
        return mapper.signup(member);
    }
    public Member login(Member member){return mapper.login(member);}

    public List<HashMap<String,Object>> selectUserCart(String id){
        return mapper.selectUserCart(id);
    }
    public List<HashMap<String,Object>>  selectCart(String id){
        return mapper.selectCart(id);
    }
    public int updateCartAmount(Map<String,String> param){
        return mapper.updateCartAmount(param);
    }
    public int insertCart(Map<String,String> param){
        return mapper.insertCart(param);

    }
    public int selectAvailAmount(Map<String,String> param){
        return mapper.selectAvailAmount(param);
    }
    public int deleteCart(Map<String,String> param){
        return mapper.deleteCart(param);
    }
    public int deleteCartAll(String param){
        return mapper.deleteCartAll(param);
    }

    public int updateAmountProduct(Map<String, String> param) {
        return mapper.updateAmountProduct(param);
    }

    public int insertOrderBook(Map<String, String> param) {
        return mapper.insertOrderBook(param);
    }

    public int insertOrderDetail(Map<String, String> param) {
        return mapper.insertOrderDetail(param);
    }

    public List<HashMap<String, Object>> selectOrderBook(String id) {
        return mapper.selectOrderBook(id);

    }
    public List<HashMap<String, Object>> selectOrderDetail(HashMap<String, String> params) {
        return mapper.selectOrderDetail(params);

    }

}

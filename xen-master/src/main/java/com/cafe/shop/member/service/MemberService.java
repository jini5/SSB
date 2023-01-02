package com.cafe.shop.member.service;

import com.cafe.shop.mapper.MemberMapper;
import com.cafe.shop.member.dto.Member;
import com.cafe.shop.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MemberService {

    @Autowired
    MemberRepository repo;

    public int signup(Member member){
        int result=0;
        try{
            result=repo.signup(member);
        }catch(Exception e){
            result=-1;
        }

        return result;
    }

    public Member login(Member member){
        return repo.login(member);

    }

    public List<HashMap<String,Object>> selectUserCart(String id){
        return repo.selectUserCart(id);
    }
    public List<HashMap<String,Object>>  selectCart(String id){
        return repo.selectCart(id);

    }
    public int updateCartAmount(Map<String,String> param){
        return repo.updateCartAmount(param);
    }
    public int insertCart(Map<String,String> param){
        return repo.insertCart(param);
    }
    public int selectAvailAmount(Map<String,String> param){
        return repo.selectAvailAmount(param);
    }
    public int deleteCart(Map<String,String> param){
        return repo.deleteCart(param);
    }
    public int deleteCartAll(String param){
        return repo.deleteCartAll(param);
    }
    public int updateAmountProduct(Map<String, String> param) {
        return repo.updateAmountProduct(param);
    }

    public int insertOrderBook(Map<String, String> param) {
        return repo.insertOrderBook(param);
    }

    public int insertOrderDetail(Map<String, String> param) {
        return repo.insertOrderDetail(param);
    }

    public List<HashMap<String, Object>> selectOrderBook(String id) {
        return repo.selectOrderBook(id);

    }
    public List<HashMap<String, Object>> selectOrderDetail(HashMap<String, String> params) {
        return repo.selectOrderDetail(params);

    }
}

package com.example.demoxenium.mapper;


import com.example.demoxenium.member.dto.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
public interface MemberMapper {

    int signup(Member member);

    Member login(Member member);

    List<HashMap<String, Object>> selectUserCart(String id);

    List<HashMap<String, Object>> selectCart(String id);

    int updateCartAmount(Map<String, String> param);

    int insertCart(Map<String, String> param);

    int deleteCartAll(String param);

    int deleteCart(Map<String, String> param);

    int selectAvailAmount(Map<String, String> param);

    int updateAmountProduct(Map<String, String> param);

    int insertOrderBook(Map<String, String> param);

    int insertOrderDetail(Map<String, String> param);

    List<HashMap<String, Object>> selectOrderDetail(HashMap<String, String> param);

    List<HashMap<String, Object>> selectOrderBook(String id);

}

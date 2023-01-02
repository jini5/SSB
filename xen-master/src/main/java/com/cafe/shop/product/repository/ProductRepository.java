package com.cafe.shop.product.repository;

import com.cafe.shop.mapper.ProductMapper;
import com.cafe.shop.product.dto.Product;
import com.cafe.shop.util.SearchDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository {

    @Autowired
    ProductMapper mapper;

    public List<Product> selectProduct(SearchDto params){
        return mapper.selectProduct(params);
    }
    public int count(SearchDto params){
        return mapper.count(params);
    }
    public int selectAvailAmount(HashMap<String,String> params){
        return mapper.selectAvailAmount(params);
    }
    public List<HashMap<String, Object>> checkAvailProductId(){
        return mapper.checkAvailProductId();
    }
    public HashMap<String, Object> checkAmountProduct(HashMap<String, String> params){
        return mapper.checkAmountProduct(params);
    }
}

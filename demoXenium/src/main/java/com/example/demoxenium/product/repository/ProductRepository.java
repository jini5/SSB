package com.example.demoxenium.product.repository;


import com.example.demoxenium.mapper.ProductMapper;
import com.example.demoxenium.product.dto.Product;
import com.example.demoxenium.util.SearchDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

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

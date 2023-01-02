package com.cafe.shop.product.service;

import com.cafe.shop.product.dto.Product;
import com.cafe.shop.product.dto.ProductList;
import com.cafe.shop.product.repository.ProductRepository;
import com.cafe.shop.util.Pagination;
import com.cafe.shop.util.SearchDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository pr;

    public ProductList findAll(SearchDto params){

        int count=pr.count(params);
        if (count < 1) {
            return new ProductList(Collections.emptyList(), null);
        }
        Pagination pagination = new Pagination(count, params);
        params.setPagination(pagination);

        List<Product> list = pr.selectProduct(params);

        return  new ProductList(list, pagination);


    }
    public int selectAvailAmount(HashMap<String,String> params){
        return pr.selectAvailAmount(params);
    }
    public List<HashMap<String, Object>> checkAvailProductId(){
        return pr.checkAvailProductId();
    }
    public HashMap<String, Object> checkAmountProduct(HashMap<String, String> params){
        return pr.checkAmountProduct(params);
    }
}

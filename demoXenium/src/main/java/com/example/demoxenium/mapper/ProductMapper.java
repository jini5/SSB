package com.example.demoxenium.mapper;


import com.example.demoxenium.product.dto.Product;
import com.example.demoxenium.util.SearchDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface ProductMapper {

    List<Product> selectProduct(SearchDto params);

    int count(SearchDto params);

    int selectAvailAmount(HashMap<String, String> params);

    List<HashMap<String, Object>> checkAvailProductId();

    HashMap<String, Object> checkAmountProduct(HashMap<String, String> params);


}

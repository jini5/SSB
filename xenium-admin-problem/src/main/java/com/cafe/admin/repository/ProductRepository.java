package com.cafe.admin.repository;

import com.cafe.admin.dto.ProductDTO;
import com.cafe.admin.dto.SellTimeDTO;
import com.cafe.admin.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository {
    @Autowired
    ProductMapper mapper;

    public int insertProducts(ProductDTO productDTO) {
        return mapper.insertProducts(productDTO);
    }

    public List<ProductDTO> selectProducts() {
        return mapper.selectProducts();
    }

    public ProductDTO selectProduct(String id) {
        return mapper.selectProduct(id);
    }

    public int deleteProducts(ProductDTO productDTO) {
        return mapper.deleteProducts(productDTO);
    }

    public int insertCatemaps(ProductDTO productDTO) {
        return mapper.insertCatemaps(productDTO);
    }

    public int deleteCatemaps(ProductDTO productDTO) {
        return mapper.deleteCatemaps(productDTO);
    }

    public int updateProducts(ProductDTO productDTO) {
        return mapper.updateProducts(productDTO);
    }

    public int insertSellTimes(SellTimeDTO sellTimeDTO) {
        return mapper.insertSellTimes(sellTimeDTO);
    }

    public int deleteSellTimes(SellTimeDTO sellTimeDTO) {
        return mapper.deleteSellTimes(sellTimeDTO);
    }

    public List<SellTimeDTO> selectSellTimes() {
        return mapper.selectSellTimes();
    }

}

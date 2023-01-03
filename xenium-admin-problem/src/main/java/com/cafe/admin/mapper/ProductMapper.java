package com.cafe.admin.mapper;

import com.cafe.admin.dto.ProductDTO;
import com.cafe.admin.dto.SellTimeDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {

    int insertProducts(ProductDTO productDTO);
    List<ProductDTO> selectProducts();
    ProductDTO selectProduct(String id);
    int deleteProducts(ProductDTO productDTO);
    int insertCatemaps(ProductDTO productDTO);
    int deleteCatemaps(ProductDTO productDTO);
    int updateProducts(ProductDTO productDTO);
    int insertSellTimes(SellTimeDTO sellTimeDTO);
    int deleteSellTimes(SellTimeDTO sellTimeDTO);
    List<SellTimeDTO> selectSellTimes();
}

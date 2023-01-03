package com.cafe.admin.service;

import com.cafe.admin.dto.ProductDTO;
import com.cafe.admin.dto.SellTimeDTO;
import com.cafe.admin.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository repo;

    //전체 제품 리스트를 반환합니다.
    public List<ProductDTO> selectProducts() {
        return repo.selectProducts();
    }

    //특정 제품을 반환합니다. id를 기준으로 반환합니다.
    public ProductDTO selectProduct(String id) {
        return repo.selectProduct(id);
    }

    //카테고리 맵핑(CATEMAP) 테이블을 선 삭제 한 후, 제품(PRODUCT)를 삭제 합니다.
    //@Transactional은 이 둘 중 하나라도 오류가 나면 둘 다 실행 하지 않습니다. (트랜젝션 처리)
    //이번 예제는 String을 반환하며, 무조건 성공시에는 "success", 실패시에는 "failed"를 반환합니다.
    @Transactional
    public String deleteProducts(ProductDTO productDTO) {
        int result = 0;
        result += repo.deleteCatemaps(productDTO);
        result += repo.deleteProducts(productDTO);
        if (result > 0) {
            return "success";
        } else {
            return "failed";
        }
    }
    // 1.카테고리 맵핑(CATEMAP) 테이블에서 product id 기준으로 선 삭제 한 후,
    // 2.CATEMAP에 다시 insert 하고,
    // 3.제품(PRODUCT)을 수정 합니다.
    //@Transactional은 이 둘 중 하나라도 오류가 나면 둘 다 실행 하지 않습니다. (트랜젝션 처리)
    @Transactional
    public String updateProducts(ProductDTO productDTO) {
        int result = 0;
        result += repo.deleteCatemaps(productDTO);
        result += repo.insertCatemaps(productDTO);
        result += repo.updateProducts(productDTO);
        if (result > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

    //제품(PRODUCT)을 테이블에 선 삽입 한 후, 카테고리 맵핑 테이블에 삽입합니다.
    //@Transactional은 이 둘 중 하나라도 오류가 나면 둘 다 실행 하지 않습니다. (트랜젝션 처리)
    @Transactional
    public String insertProducts(ProductDTO productDTO) {
        int result = 0;
        result += repo.insertProducts(productDTO);
        result += repo.insertCatemaps(productDTO);
        if (result > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

    //SellTimeDTO 객체를 테이블에 insert 합니다.
    //Swagger 문서를 참고하여 넣을 값 정리 합니다.
    public String insertSellTimes(SellTimeDTO sellTimeDTO) {
        int result = 0;
        result += repo.insertSellTimes(sellTimeDTO);
        if (result == 1) {
            return "success";
        } else {
            return "failed";
        }
    }
    //SellTimeDTO 객체를 테이블에 delete 합니다. dto의 id 기준으로 삭제 합니다.
    //Swagger 문서를 참고하여 넣을 값 정리 합니다.
    public String deleteSellTimes(SellTimeDTO sellTimeDTO) {
        int result = 0;
        result += repo.deleteSellTimes(sellTimeDTO);
        if (result == 1) {
            return "success";
        } else {
            return "failed";
        }
    }

    //SellTime 전체를 반환합니다.
    public List<SellTimeDTO> selectSellTimes() {
        return repo.selectSellTimes();

    }

}

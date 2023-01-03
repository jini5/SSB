package com.cafe.admin.service;

import com.cafe.admin.dto.CategoryDTO;
import com.cafe.admin.repository.CategoryRepository;
import com.cafe.admin.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository repo;
    @Autowired
    ProductRepository pr;

    public List<CategoryDTO> selectAllCategory() {
        return repo.selectAllCategory();
    }

    //카테고리 맵핑(CATEMAP) 테이블을 선 삭제 한 후, 카테고리(CATEGORY)를 삭제 합니다.
    //@Transactional은 이 둘 중 하나라도 오류가 나면 둘 다 실행 하지 않습니다. (트랜젝션 처리)
    //이번 예제는 String을 반환하며, 무조건 성공시에는 "success", 실패시에는 "failed"를 반환합니다.
    @Transactional
    public String deleteCategories(CategoryDTO categoryDTO) {
        int result = 0;
        result += repo.deleteCatemaps(categoryDTO);
        result += repo.deleteCategories(categoryDTO);
        if (result == 1) {
            return "success";
        } else {
            return "failed";
        }
    }

    //받은 카테고리DTO를 insert 합니다. cateType은 "PRODUCT" 고정으로 insert 합니다.
    public String insertCategories(CategoryDTO categoryDTO) {
        int result = 0;
        result += repo.insertCategories(categoryDTO);
        if (result == 1) {
            return "success";
        } else {
            return "failed";
        }
    }


    //받은 카테고리DTO를 id기준으로 카테고리명을 update 합니다. cateType은 "PRODUCT" 고정입니다.
    public String updateCategories(CategoryDTO categoryDTO) {
        int result = 0;
        result += repo.updateCategories(categoryDTO);
        if (result == 1) {
            return "success";
        } else {
            return "failed";
        }

    }
}

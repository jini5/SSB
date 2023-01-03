package com.cafe.admin.repository;

import com.cafe.admin.dto.CategoryDTO;
import com.cafe.admin.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryRepository {
    @Autowired
    CategoryMapper mapper;

    public List<CategoryDTO> selectAllCategory() {
        return mapper.selectCategories();
    }


    public int deleteCategories(CategoryDTO categoryDTO) {
        return mapper.deleteCategories(categoryDTO);
    }

    public int insertCategories(CategoryDTO categoryDTO) {
        return mapper.insertCategories(categoryDTO);
    }

    public int updateCategories(CategoryDTO categoryDTO) {
        return mapper.updateCategories(categoryDTO);

    }

    public int deleteCatemaps(CategoryDTO categoryDTO) {
        return mapper.deleteCatemaps(categoryDTO);
    }
}

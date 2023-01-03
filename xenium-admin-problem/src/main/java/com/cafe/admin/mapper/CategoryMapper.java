package com.cafe.admin.mapper;

import com.cafe.admin.dto.CategoryDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryMapper {


    List<CategoryDTO> selectCategories();
    int deleteCategories(CategoryDTO categoryDTO);
    int insertCategories(CategoryDTO categoryDTO);
    int updateCategories(CategoryDTO categoryDTO);
    int deleteCatemaps(CategoryDTO categoryDTO);

}

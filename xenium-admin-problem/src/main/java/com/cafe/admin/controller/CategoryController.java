package com.cafe.admin.controller;

import com.cafe.admin.dto.CategoryDTO;
import com.cafe.admin.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@Api(tags = {"카테고리 관련 서비스"}, description = "카테고리 등록,수정 및 삭제 서비스를 담당합니다.")
@RestController
public class CategoryController {

    @Autowired
    CategoryService cs;

    @GetMapping("/categories")
    @ApiOperation(value = "전체 카테고리 조회", notes = "전체 카테고리를 조회한다.")
    public List<CategoryDTO> selectCategories() {
        return cs.selectAllCategory();
    }

    @DeleteMapping("/categories")
    @ApiOperation(value = "카테고리 삭제", notes = "카테고리를 id 기준으로 삭제한다.")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", dataType = "string", paramType = "query", value = "삭제할 카테고리 id", required = true)
    })
    public String deleteCategories(@ApiIgnore CategoryDTO categoryDTO) {
        return cs.deleteCategories(categoryDTO);
    }

    @PostMapping("/categories")
    @ApiOperation(value = "카테고리 생성", notes = "카테고리를 생성한다.")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "cateName", dataType = "string", paramType = "query", value = "생성할 카테고리명", required = true)
    })
    public String insertCategories(@ApiIgnore CategoryDTO categoryDTO) {
        return cs.insertCategories(categoryDTO);
    }

    @PutMapping("/categories")
    @ApiOperation(value = "카테고리 수정", notes = "카테고리를 id기준으로 수정한다.")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", dataType = "string", paramType = "query", value = "수정할 카테고리id", required = true),
            @ApiImplicitParam(name = "cateName", dataType = "string", paramType = "query", value = "수정될 카테고리명", required = true)
    })
    public String updateCategories(@ApiIgnore CategoryDTO categoryDTO) {
        return cs.updateCategories(categoryDTO);
    }
}

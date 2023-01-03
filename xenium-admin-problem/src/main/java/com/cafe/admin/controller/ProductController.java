package com.cafe.admin.controller;

import com.cafe.admin.dto.ProductDTO;
import com.cafe.admin.dto.SellTimeDTO;
import com.cafe.admin.service.PictureService;
import com.cafe.admin.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

import java.io.IOException;
import java.util.List;

@Api(tags = {"제품 관련 서비스"}, description = "제품 및 판매시각 관련 서비스를 담당합니다.")
@RestController
public class ProductController {
    @Autowired
    ProductService ps;
    @Autowired
    PictureService pics;

    @GetMapping("/products")
    @ApiOperation(value = "전체 상품 조회", notes = "전체 상품을 조회한다.")
    public List<ProductDTO> selectProducts() {
        return ps.selectProducts();
    }

    @DeleteMapping("/products")
    @ApiOperation(value = "상품 삭제", notes = "특정 상품을 id기준으로 삭제한다.")
    public String deleteProducts(ProductDTO productDTO) {
        return ps.deleteProducts(productDTO);
    }

    @PutMapping("/products")
    @ApiOperation(value = "상품 수정(구현X)", notes = "특정 상품을 id기준으로 수정한다.")
    public String updateProducts(ProductDTO productDTO) {
        return ps.updateProducts(productDTO);
    }

    @PostMapping("/products")
    @ApiOperation(value = "상품 생성", notes = "상품을 생성한다.")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "thumb", dataType = "string", paramType = "query", value = "제품이미지", required = true),
            @ApiImplicitParam(name = "productName", dataType = "string", paramType = "query", value = "제품명", required = true),
            @ApiImplicitParam(name = "amount", dataType = "string", paramType = "query", value = "수량", required = true),
            @ApiImplicitParam(name = "price", dataType = "string", paramType = "query", value = "개당 가격", required = true),
            @ApiImplicitParam(name = "content", dataType = "string", paramType = "query", value = "제품상세소개", required = true),
            @ApiImplicitParam(name = "cateId", dataType = "string", paramType = "query", value = "카테고리아이디", required = true),
            @ApiImplicitParam(name = "marketType", dataType = "string", paramType = "query", value = "상시판매/기간판매", required = true),
            @ApiImplicitParam(name = "orderNum", dataType = "string", paramType = "query", value = "표시순서", required = true),
            @ApiImplicitParam(name = "summary", dataType = "string", paramType = "query", value = "간략소개", required = true),
            @ApiImplicitParam(name = "status", dataType = "string", paramType = "query", value = "판매가능/판매대기", required = true)
    })
    public String insertProducts(@ApiIgnore ProductDTO productDTO) {
        return ps.insertProducts(productDTO);
    }

    @ApiOperation(value = "특정 상품 조회", notes = "특정 상품을 id 기준으로 조회한다.")
    @GetMapping("/products/{id}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", dataType = "string", paramType = "path", value = "제품 id", required = true)
    })
    public ProductDTO selectProduct(@PathVariable String id) {
        return ps.selectProduct(id);
    }

    @ApiOperation(value = "사진 업로드", notes = "사진파일을 업로드한다.")
    @PostMapping("/pictures")
    public String insertPictures(@RequestParam("filedata") MultipartFile filedata) throws IOException {
        return pics.uploadPic(filedata);
    }

    @ApiOperation(value = "판매시각 생성", notes = "판매시각 생성을 한다.")
    @PostMapping("/selltimes")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "startTime", dataType = "string", paramType = "query", value = "판매시작시간(2022-12-26T16:20)", required = true),
            @ApiImplicitParam(name = "endTime", dataType = "string", paramType = "query", value = "판매끝시간(2022-12-26T16:20)", required = true)
    })
    public String insertSellTimes(@ApiIgnore SellTimeDTO sellTimeDTO) {
        return ps.insertSellTimes(sellTimeDTO);
    }

    @ApiOperation(value = "판매시각 삭제", notes = "판매시각을 삭제한다.")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", dataType = "string", paramType = "query", value = "삭제할 판매시간 id", required = true)
    })
    @DeleteMapping("/selltimes")
    public String deleteSellTimes(@ApiIgnore SellTimeDTO sellTimeDTO) {
        return ps.deleteSellTimes(sellTimeDTO);
    }

    @ApiOperation(value = "전체 판매시각 조회", notes = "전체 판매시각을 조회한다.")
    @GetMapping("/selltimes")
    public List<SellTimeDTO> selectSellTimes() {
        return ps.selectSellTimes();
    }

}

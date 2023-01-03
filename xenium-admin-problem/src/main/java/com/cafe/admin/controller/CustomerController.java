package com.cafe.admin.controller;

import com.cafe.admin.dto.CustomerDTO;
import com.cafe.admin.dto.OrderDTO;
import com.cafe.admin.service.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@Api(tags = {"고객 관련 서비스"}, description = "고객 변경 및 주문관련 서비스를 담당합니다.")
@RestController
public class CustomerController {

    @Autowired
    CustomerService cs;

    @ApiOperation(value = "전체 고객 조회", notes = "전체 고객을 조회한다.")
    @GetMapping("/customers")
    public List<CustomerDTO> selectCustomers() {
        return cs.selectAllCustomers();
    }

    @ApiOperation(value = "고객 비활성화/활성화", notes = "ismem을 인입 id기준으로 Y 또는 N으로 변경")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", dataType = "string", paramType = "query", value = "수정할 고객 id", required = true),
            @ApiImplicitParam(name = "ismem", dataType = "string", paramType = "query", value = "비활성화/활성화 Y/N", required = true)
    })
    @PutMapping("/customers")
    public String updateCustomers(@ApiIgnore CustomerDTO customerDTO) {
        return cs.customerStatus(customerDTO);
    }

    @ApiOperation(value = "고객들의 주문 정보 전체 조회", notes = "고객들의 주문 전체 정보를 조회한다.")
    @GetMapping("/orders")
    public List<OrderDTO> selectOrderBook() {
        return cs.selectOrderBook();
    }

    @ApiOperation(value = "고객의 주문 정보 상세 조회", notes = "고객의 특정 주문 정보를 조회한다.(제품명,수량,가격)")
    @GetMapping("/order")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", dataType = "string", paramType = "query", value = "조회 할 주문id", required = true)
    })
    public List<OrderDTO> selectOrderDetail(@ApiIgnore OrderDTO orderDTO) {
        return cs.selectOrderDetail(orderDTO);
    }
}

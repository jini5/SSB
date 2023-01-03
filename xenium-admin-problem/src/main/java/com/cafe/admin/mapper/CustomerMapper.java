package com.cafe.admin.mapper;

import com.cafe.admin.dto.AdminDTO;
import com.cafe.admin.dto.CustomerDTO;
import com.cafe.admin.dto.OrderDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CustomerMapper {

    AdminDTO selectAdmin(AdminDTO adminDTO);
    List<CustomerDTO> selectAllCustomers();
    int customerStatus(CustomerDTO customerDTO);
    List<OrderDTO> selectOrderBook();
    List<OrderDTO> selectOrderDetail(OrderDTO orderDTO);

}

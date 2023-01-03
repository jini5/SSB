package com.cafe.admin.repository;

import com.cafe.admin.dto.AdminDTO;
import com.cafe.admin.dto.CustomerDTO;
import com.cafe.admin.dto.OrderDTO;
import com.cafe.admin.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class CustomerRepository {

    @Autowired
    CustomerMapper mapper;

    public AdminDTO selectAdmin(AdminDTO adminDTO) {
        return mapper.selectAdmin(adminDTO);
    }

    public List<CustomerDTO> selectAllCustomers() {
        return mapper.selectAllCustomers();
    }

    public int customerStatus(CustomerDTO customerDTO) {
        return mapper.customerStatus(customerDTO);
    }

    public List<OrderDTO> selectOrderBook() {
        return mapper.selectOrderBook();
    }

    public List<OrderDTO> selectOrderDetail(OrderDTO orderDTO) {
        return mapper.selectOrderDetail(orderDTO);
    }
}

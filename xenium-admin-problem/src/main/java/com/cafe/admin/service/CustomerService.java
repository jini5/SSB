package com.cafe.admin.service;

import com.cafe.admin.dto.AdminDTO;
import com.cafe.admin.dto.CustomerDTO;
import com.cafe.admin.dto.OrderDTO;
import com.cafe.admin.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository repo;
    @Autowired
    HttpSession session;
    //이번 예제는 String을 반환하며, 무조건 성공시에는 "success", 실패시에는 "failed"를 반환합니다.
    //admin 계정이 있는지 확인 합니다. id와 password 가 일치 하면 admin이라는 이름으로 세션에 넣습니다.
    public String selectAdmin(AdminDTO adminDTO) {
        AdminDTO fetched = repo.selectAdmin(adminDTO);
        if (fetched == null) {
            return "";
        } else {
            session.setAttribute("admin", fetched);
            return "success";
        }
    }

    //고객 전체 리스트를 반환합니다.
    public List<CustomerDTO> selectAllCustomers() {
        return repo.selectAllCustomers();
    }

    //고객 상태(ismem)을 Y나 N 으로 update 합니다.
    public String customerStatus(CustomerDTO customerDTO) {
        return String.valueOf(repo.customerStatus(customerDTO));
    }

    //고객의 주문정보 전체를 반환합니다.
    public List<OrderDTO> selectOrderBook() {
        return repo.selectOrderBook();
    }

    //고객의 주문상세를 반환합니다. orderDTO의 id 기준으로 가져옵니다.
    public List<OrderDTO> selectOrderDetail(OrderDTO orderDTO) {
        return repo.selectOrderDetail(orderDTO);
    }
}

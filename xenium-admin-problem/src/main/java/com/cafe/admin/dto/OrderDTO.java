package com.cafe.admin.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class OrderDTO {
    private int id;
    private String userId;
    private String name;
    private String phone;
    private String address;
    private String addressDetail;
    private String indate;
    private String productName;
    private int price;
    private int amount;
}

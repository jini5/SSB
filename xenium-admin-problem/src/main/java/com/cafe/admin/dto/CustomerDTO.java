package com.cafe.admin.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CustomerDTO {

    private String id;
    private String pw;
    private String name;
    private String phone;
    private String address;
    private String email;
    private String gender;
    private String sns;
    private String birth;
    private String indate;
    private String ismem;

}

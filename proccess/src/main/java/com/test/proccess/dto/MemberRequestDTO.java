package com.test.proccess.dto;

import com.test.proccess.entity.Member;
import lombok.Setter;

@Setter
public class MemberRequestDTO {

    private String userId;
    private String password;
    private String name;
    private String age;
    private String phone;
    private String address;

    public Member toEntity(){
        return Member.builder()
                .id(userId)
                .password(password)
                .name(name)
                .age(Integer.parseInt(age))
                .phone(phone)
                .address(address)
                .build();
    }
}

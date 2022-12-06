package com.example.demoweb.member.DTO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MemberDTO {

    private String email;
    private String name;
    private String phone;
    private String address;
    private String detail;

    public MemberDTO(String email, String name, String phone, String address, String detail) {
        this.email = email;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "MemberDTO{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", detail='" + detail + '\'' +
                '}';
    }
}

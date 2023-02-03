package com.test.proccess.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Builder
@AllArgsConstructor
@Table(name="tn_member")
@NoArgsConstructor
public class Member {

    @Id
    @Column
    private String id;

    @Column
    private String password;

    @Column
    private String name;

    @Column
    private int age;

    @Column
    private String phone;

    @Column
    private String address;
}

package com.example.reservation.entity;

import lombok.*;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "th_user") // 클래스명과 테이블명이 다를때 매핑시켜주기위해 사용
@Entity
public class Account {
    @Id
    @Column(name = "usr_id")
    private String usrId;

    @Column(name = "gr_id")
    private String grId;

    @Column(name = "usr_pw")
    private String usrPw;

    @Column(name = "usr_nm")
    private String usrNm;

    @Column(name = "usr_type")
    private String usrType;

    @OneToMany(mappedBy = "owner", fetch = FetchType.EAGER)
    private Set<Schedule> scheduleList = new LinkedHashSet<>();


}

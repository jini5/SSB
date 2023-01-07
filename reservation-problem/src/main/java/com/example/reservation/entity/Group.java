package com.example.reservation.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "th_rm_grp") // 클래스명과 테이블명이 다를때 매핑시켜주기위해 사용
@Entity
public class Group {

    @Id
    @Column(name = "gr_id")
    private Long grId;

    @Column(name = "gr_nm")
    private String grNm;

}

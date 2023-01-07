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
@Table(name = "th_room") // 클래스명과 테이블명이 다를때 매핑시켜주기위해 사용
@Entity
public class Room {

    @Id
    @Column(name = "rm_id")
    private Long rmId;

    @Column(name = "gr_id")
    private Long grId;

    @Column(name = "rm_nm")
    private String rmNm;

    @OneToMany(mappedBy = "rsvRm", fetch = FetchType.EAGER)
    private Set<Schedule> scheduleList = new LinkedHashSet<>();
}

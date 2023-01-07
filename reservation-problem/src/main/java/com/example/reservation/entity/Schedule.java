package com.example.reservation.entity;

import lombok.*;

import javax.persistence.*;

@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "th_rsv_cn") // 클래스명과 테이블명이 다를때 매핑시켜주기위해 사용
@Entity
public class Schedule {

    @Id
    @Column(name = "rsv_cn_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rsvCnNo;

    @ManyToOne
    @JoinColumn(name = "usr_id", referencedColumnName = "usr_id")
    private Account owner;

    @ManyToOne
    @JoinColumn(name = "rm_id", referencedColumnName = "rm_id")
    private Room rsvRm;

    @Column(name = "gr_id")
    private Long grId;

    @Column(name = "rsv_prrt")
    private String priority;

    @Column(name = "rsv_title")
    private String title;

    @Column(name = "rsv_cn_dtl")
    private String contentDetail;

    @Column(name = "rsv_str_dt")
    private String reserveStart;

    @Column(name = "rsv_end_dt")
    private String reserveEnd;

    @Column(name = "rsv_allday")
    private String reserveAllday;

}

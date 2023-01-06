package com.example.jpatest01.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.ConnectionBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="schedule")
@Getter
@Builder
public class Schedule {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="email")
    private User user;



}
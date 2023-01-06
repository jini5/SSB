package com.example.jpatest01.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="schedule_user")
@Getter
public class User {

    @Id
    @Column(name="email")
    private String email;
    @Column(name="password")
    private String password;

    @OneToMany(fetch = FetchType.LAZY)
    @OrderBy("date desc")
    private List<Schedule> schedules; //list, set

}

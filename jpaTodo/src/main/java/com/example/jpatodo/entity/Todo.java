package com.example.jpatodo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="todo")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class Todo {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="todos")
    private String todos;

    @Column(name="indate", insertable = false)
    private String indate;



}

package com.example.jpatest01.repository;

import com.example.jpatest01.entity.Schedule;
import com.example.jpatest01.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ScheduleRepository extends JpaRepository<Schedule,Long> {

    List<Schedule> findByUser(User user);



}
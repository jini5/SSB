package com.example.jpatest01.service;

import com.example.jpatest01.dto.ScheduleRequest;
import com.example.jpatest01.dto.ScheduleResponse;
import com.example.jpatest01.entity.Schedule;
import com.example.jpatest01.repository.ScheduleRepository;

import java.util.List;

public interface ScheduleService {

    //스케쥴 목록
    List<ScheduleResponse> schedulelist(String email);

    //스케쥴 삭제
    String deleteSchedules(String id);

    //스케쥴 등록
    String insertSchedules(ScheduleRequest scheduleRequest)
;
}

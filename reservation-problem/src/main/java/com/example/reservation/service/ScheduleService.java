package com.example.reservation.service;

import com.example.reservation.dto.ScheduleInsertRequest;
import com.example.reservation.dto.ScheduleResponse;
import com.example.reservation.dto.ScheduleUpdateRequest;
import com.example.reservation.entity.Account;
import com.example.reservation.entity.Room;
import com.example.reservation.entity.Schedule;
import com.example.reservation.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScheduleService {

    private final ScheduleRepository repo;


    //스케쥴을 조회합니다.
    //회의실ID가 조회 조건입니다.
    public List<ScheduleResponse> schedules(String id) {
        return repo.findAllByRsvRm(Room.builder().rmId(Long.valueOf(id)).build()).stream()
                .map(schedule -> new ScheduleResponse()).collect(Collectors.toList());
    }

    //특정 스케쥴을 조회합니다.
    //스케쥴 ID가 조회 조건입니다.
    public ScheduleResponse detailSchedules(String id) {
        Schedule ds = repo.findById(Long.valueOf(id)).orElse(null);
        return null;
    }

    //단순히 스케쥴을 삽입합니다.
    //성공:success, 실패:failed
    //고급 : 다른 스케쥴이 겹치지 않을때만 삽입하세요.
    public String insertSchedule(ScheduleInsertRequest req) {



        return null;
    }

    //스케쥴을 삭제합니다.
    //성공:success, 실패:failed
    public String deleteSchedule(String id) {
        try{
            repo.deleteById(Long.valueOf(id));
        }catch (Exception e){
            return "failed";
        }
        return "success";
    }

    //스케쥴을 수정합니다.
    //성공:success, 실패:failed
    //고급 : 다른 스케쥴이 겹치지 않을때만 수정하세요.
    public String updateSchedule(ScheduleUpdateRequest req) {
            return null;

    }

    // 필드 캡슐화
    @Autowired
    public ScheduleService(ScheduleRepository repo) {
        this.repo = repo;
    }
}

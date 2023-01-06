package com.example.jpatest01.service.impl;

import com.example.jpatest01.dto.ScheduleRequest;
import com.example.jpatest01.dto.ScheduleResponse;
import com.example.jpatest01.entity.User;
import com.example.jpatest01.repository.ScheduleRepository;
import com.example.jpatest01.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ScheduleServiceImpl implements ScheduleService {

    private final ScheduleRepository scheduleRepository;

    @Override
    public List<ScheduleResponse> schedulelist(String email) {

        return scheduleRepository.findByUser(User.builder().email(email)
                .build()).stream().map(schedule -> new ScheduleResponse(schedule))
                .collect(Collectors.toList());

    }

    @Override
    public String deleteSchedules(String id) {
        try{
            scheduleRepository.deleteById(Long.valueOf(id));
        }catch (Exception e){
            e.printStackTrace();
            return "failed";
        }
        return "success";
    }

    @Override
    public String insertSchedules(ScheduleRequest scheduleRequest) {

        try{
            scheduleRepository.save(scheduleRequest.toEntity());

        }catch (Exception e) {
            e.printStackTrace();
            return "failed";
        }
        return "success";
    }
}

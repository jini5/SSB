package com.example.jpatest01.dto;


import com.example.jpatest01.entity.Schedule;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ScheduleResponse {

    private String id;
    private String title;
    private String date;

    public ScheduleResponse(Schedule schedule){
        this.id=String.valueOf(schedule.getId());
        this.title=schedule.getTitle();
        this.date=schedule.getDate();
    }
}

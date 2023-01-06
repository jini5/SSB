package com.example.jpatest01.dto;



import com.example.jpatest01.entity.Schedule;
import com.example.jpatest01.entity.User;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ScheduleRequest {

    private String email;
    private String title;
    private String date;

    public Schedule toEntity(){
        return Schedule.builder().user(User.builder().email(email).build())
                .title(title).date(date).build();
    }
}

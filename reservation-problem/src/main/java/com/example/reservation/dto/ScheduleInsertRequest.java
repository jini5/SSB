package com.example.reservation.dto;

import com.example.reservation.entity.Account;
import com.example.reservation.entity.Room;
import com.example.reservation.entity.Schedule;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ScheduleInsertRequest {

    private String usrId;
    private String roomId;
    private String grId;
    private String priority;
    private String title;
    private String contentDetail;
    private String reserveStart;
    private String reserveEnd;
    private String reserveAllday;

    public Schedule toEntity() {
        if (this.reserveAllday.equals("true")) {
            this.reserveAllday = "1";
        } else {
            this.reserveAllday = "0";
        }
        return Schedule.builder()
                .owner(Account.builder().usrId(this.usrId).build())
                .rsvRm(Room.builder().rmId(Long.parseLong(this.roomId)).build())
                .grId(Long.valueOf(this.grId))
                .priority(this.priority)
                .title(this.title)
                .contentDetail(this.contentDetail)
                .reserveStart(this.reserveStart)
                .reserveEnd(this.reserveEnd)
                .reserveAllday(this.reserveAllday)
                .build();
    }


}
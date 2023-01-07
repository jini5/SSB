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
public class ScheduleUpdateRequest {

    private String id;
    private String usrId;
    private String priority;
    private String title;
    private String contentDetail;
    private String reserveStart;
    private String reserveEnd;
    private String reserveAllday;
    private String grId;
    private String roomId;

    public Schedule toEntity() {
        if (this.reserveAllday.equals("true")) {
            this.reserveAllday = "1";
        } else {
            this.reserveAllday = "0";
        }
        return Schedule.builder().rsvCnNo(Long.valueOf(id))
                .owner(Account.builder().usrId(this.usrId).build())
                .priority(this.priority)
                .title(this.title)
                .contentDetail(this.contentDetail)
                .reserveStart(this.reserveStart)
                .reserveEnd(this.reserveEnd)
                .grId(Long.valueOf(this.grId))
                .rsvRm(Room.builder().rmId(Long.valueOf(roomId)).build())
                .reserveAllday(this.reserveAllday)
                .build();
    }

}

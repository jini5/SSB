package com.example.reservation.dto;

import com.example.reservation.entity.Schedule;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ScheduleResponse {

    private String cnNo;
    private String usrId;
    private String rmId;
    private String grId;
    private String priority;
    private String title;
    private String contents;
    private String startDt;
    private String endDt;
    private String allDay;
    private String usrNm;

    public ScheduleResponse(Schedule schedule) {
        this.cnNo = String.valueOf(schedule.getRsvCnNo());
        this.usrId = String.valueOf(schedule.getOwner().getUsrId());
        this.rmId = String.valueOf(schedule.getRsvRm().getRmId());
        this.grId = String.valueOf(schedule.getOwner().getGrId());
        this.priority = String.valueOf(schedule.getPriority());
        this.title = String.valueOf(schedule.getTitle());
        this.contents = String.valueOf(schedule.getContentDetail());
        this.startDt = String.valueOf(schedule.getReserveStart());
        this.endDt = String.valueOf(schedule.getReserveEnd());
        this.allDay = String.valueOf(schedule.getReserveAllday());
        this.usrNm = String.valueOf(schedule.getOwner().getUsrNm());
    }

}

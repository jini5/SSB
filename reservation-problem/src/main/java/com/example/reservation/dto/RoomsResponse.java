package com.example.reservation.dto;


import com.example.reservation.entity.Room;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RoomsResponse {

    private String roomId;
    private String groupId;
    private String roomName;

    public RoomsResponse(Room room) {
        this.roomId = String.valueOf(room.getRmId());
        this.groupId = String.valueOf(room.getGrId());
        this.roomName = String.valueOf(room.getRmNm());
    }
}

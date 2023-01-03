package com.cafe.admin.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SellTimeDTO {

    private int id;
    private String startTime;
    private String endTime;
    private String indate;

}

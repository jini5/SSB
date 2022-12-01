package com.example.democalendar.calendar.controller;

import com.example.democalendar.dto.Calendar;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class CalendarController {

    private ArrayList<Calendar> calList = new ArrayList<>();

    @GetMapping("/all/schedule")
    public ArrayList<Calendar> allSchedule(){
        return calList;
    }

    @GetMapping("/put/schedule")
    public ArrayList<Calendar> putSchedule(Calendar cal){
        calList.add(cal);

        return calList;
    }

}

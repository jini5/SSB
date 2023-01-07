package com.example.reservation.controller;

import com.example.reservation.dto.ScheduleInsertRequest;
import com.example.reservation.dto.ScheduleResponse;
import com.example.reservation.dto.ScheduleUpdateRequest;
import com.example.reservation.service.ScheduleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@Api(tags = {"스케쥴 관련 서비스"}, description = "스케쥴 관련 서비스를 담당합니다.")
@RestController
public class ScheduleController {
    private final ScheduleService ss;

    @ApiOperation(value = "스케쥴 조회", notes = "스케쥴을 룸ID 별로 조회 한다.")
    @GetMapping("/schedules/rmId/{id}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", dataType = "string", paramType = "path", value = "룸ID", required = true)
    })
    public List<ScheduleResponse> schedules(@PathVariable("id") String id) {
        return ss.schedules(id);
    }

    @ApiOperation(value = "특정 스케쥴 조회", notes = "특정 스케쥴을 스케쥴ID로 조회 한다.")
    @GetMapping("/schedules/{id}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", dataType = "string", paramType = "path", value = "스케쥴ID", required = true)
    })
    public ScheduleResponse detailSchedules(@PathVariable("id") String id) {
        return ss.detailSchedules(id);
    }

    @ApiOperation(value = "스케쥴 삽입", notes = "특정 스케쥴을 삽입 한다.")
    @PostMapping("/schedules")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "usrId", dataType = "string", paramType = "query", value = "유저ID", required = true),
            @ApiImplicitParam(name = "roomId", dataType = "string", paramType = "query", value = "회의룸ID", required = true),
            @ApiImplicitParam(name = "grId", dataType = "string", paramType = "query", value = "회의룸그룹ID", required = true),
            @ApiImplicitParam(name = "priority", dataType = "string", paramType = "query", value = "회의중요도(ni:낮음,i:중간,vi:높음)", required = true),
            @ApiImplicitParam(name = "title", dataType = "string", paramType = "query", value = "회의제목", required = true),
            @ApiImplicitParam(name = "contentDetail", dataType = "string", paramType = "query", value = "회의내용", required = true),
            @ApiImplicitParam(name = "reserveStart", dataType = "string", paramType = "query", value = "회의시작시간", required = true),
            @ApiImplicitParam(name = "reserveEnd", dataType = "string", paramType = "query", value = "회의끝시간", required = true),
            @ApiImplicitParam(name = "reserveAllday", dataType = "string", paramType = "query", value = "하루종일 여부", required = true)
    })
    public String schedules(@ApiIgnore ScheduleInsertRequest scheduleInsertRequest) {
        return ss.insertSchedule(scheduleInsertRequest);
    }

    @ApiOperation(value = "특정 스케쥴 삭제", notes = "특정 스케쥴을 스케쥴ID로 삭제 한다.")
    @DeleteMapping("/schedules/{id}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", dataType = "string", paramType = "path", value = "스케쥴ID", required = true)
    })
    public String deleteSchedules(@PathVariable("id") String id) {
        return ss.deleteSchedule(id);
    }

    @ApiOperation(value = "특정 스케쥴 수정", notes = "특정 스케쥴을 스케쥴ID/유저아이디 기준으로 수정 한다.")
    @PutMapping("/schedules")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", dataType = "string", paramType = "query", value = "스케쥴ID", required = true),
            @ApiImplicitParam(name = "usrId", dataType = "string", paramType = "query", value = "유저ID", required = true),
            @ApiImplicitParam(name = "roomId", dataType = "string", paramType = "query", value = "회의룸ID", required = true),
            @ApiImplicitParam(name = "grId", dataType = "string", paramType = "query", value = "회의룸그룹ID", required = true),
            @ApiImplicitParam(name = "priority", dataType = "string", paramType = "query", value = "회의중요도(ni:낮음,i:중간,vi:높음)", required = true),
            @ApiImplicitParam(name = "title", dataType = "string", paramType = "query", value = "회의제목", required = true),
            @ApiImplicitParam(name = "contentDetail", dataType = "string", paramType = "query", value = "회의내용", required = true),
            @ApiImplicitParam(name = "reserveStart", dataType = "string", paramType = "query", value = "회의시작시간", required = true),
            @ApiImplicitParam(name = "reserveEnd", dataType = "string", paramType = "query", value = "회의끝시간", required = true),
            @ApiImplicitParam(name = "reserveAllday", dataType = "string", paramType = "query", value = "하루종일 여부", required = true)
    })
    public String updateSchedules(@ApiIgnore ScheduleUpdateRequest scheduleUpdateRequest) {
        return ss.updateSchedule(scheduleUpdateRequest);
    }

    // 필드 캡슐화
    @Autowired
    public ScheduleController(ScheduleService ss) {
        this.ss = ss;
    }
}

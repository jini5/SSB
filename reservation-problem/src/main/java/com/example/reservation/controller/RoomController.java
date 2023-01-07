package com.example.reservation.controller;

import com.example.reservation.dto.RoomsResponse;
import com.example.reservation.service.RoomService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = {"회의실 관련 서비스"}, description = "회의실 서비스를 담당합니다.")
@RestController
public class RoomController {

    private final RoomService rs;

    @ApiOperation(value = "회의실 조회", notes = "회의실을 그룹ID 별로 조회 한다.")
    @GetMapping("/rooms/grId/{id}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", dataType = "string", paramType = "path", value = "그룹id(기본값:1)", required = true)
    })
    public List<RoomsResponse> rooms(@PathVariable("id") String id) {
        return rs.rooms(id);
    }

    // 필드 캡슐화
    @Autowired
    public RoomController(RoomService rs) {
        this.rs = rs;
    }
}

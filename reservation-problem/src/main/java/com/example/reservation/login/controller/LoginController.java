package com.example.reservation.login.controller;

import com.example.reservation.dto.AccountSignUpRequest;
import com.example.reservation.dto.AccountSignUpResponse;
import com.example.reservation.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@Api(tags = {"로그인 관련 서비스"}, description = "로그인 서비스를 담당합니다.")
@RestController
public class LoginController {

    final private LoginService ls;

    @PostMapping("/login")
    @ApiOperation(value = "로그인 한다.", notes = "로그인을 진행한다.")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "usrId", dataType = "string", paramType = "query", value = "유저ID", required = true),
            @ApiImplicitParam(name = "usrPw", dataType = "string", paramType = "query", value = "유저PW", required = true)
    })
    public String map(@ApiIgnore AccountSignUpRequest req) {
        AccountSignUpResponse res = ls.login(req);
        if (res != null) {
            return "map";
        }
        return "index";
    }

    @Autowired
    public LoginController(LoginService ls) {
        this.ls = ls;
    }
}

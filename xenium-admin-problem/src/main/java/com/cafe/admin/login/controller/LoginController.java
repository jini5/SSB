package com.cafe.admin.login.controller;

import com.cafe.admin.dto.AdminDTO;
import com.cafe.admin.service.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"로그인 서비스"}, description = "로그인 서비스를 담당합니다.")
@RestController
public class LoginController {

    @Autowired
    CustomerService cs;

    @ApiOperation(value = "Swagger 로그인", notes = "Swagger에서 로그인한다.")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "어드민 id", required = true),
            @ApiImplicitParam(name = "password", value = "어드민 pw", required = true)
    })
    @PostMapping("/login")
    public String login(AdminDTO adminDTO) {
        return cs.selectAdmin(adminDTO);
    }
}

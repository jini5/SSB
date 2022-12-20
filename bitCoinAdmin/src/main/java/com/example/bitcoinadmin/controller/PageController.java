package com.example.bitcoinadmin.controller;

import com.example.bitcoinadmin.admin.AdminDTO;
import com.example.bitcoinadmin.service.AdminService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Controller
public class PageController {

    @Autowired
    AdminService as;

    @GetMapping("/index")
    public String index(){
        return "index";
    }


    @PostMapping("/login")
    @ApiOperation(value = "사용자별 인증 정보 CHECK", notes = "인증된 사용자인지 판단하는 API입니다.")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "사용자 식별 ID", required = true),
            @ApiImplicitParam(name = "password", value = "사용자 비밀번호", required = true)
    })
    public String loginAdmin(AdminDTO adminDTO, @ApiIgnore HttpSession session){
        HashMap<String, String> map = new HashMap<>();
        map.put("id",adminDTO.getId());
        map.put("password",adminDTO.getPassword());

        HashMap<String,Object> verified = as.loginAdmin(map);
//        System.out.println(admin.toString());
//        System.out.println(verified.toString());
        if(verified!=null){
            String id = String.valueOf(verified.get("id"));
            session.setAttribute("id",id);
            return "index";
        }
        return "login";
    }

    @ApiOperation(value = "메인 화면", notes = "URL 입장 후 맨 첫번째 페이지")
    @GetMapping("/")
    public String login(){return "login";
    }


    @ApiOperation(value = "사용자별 정보 내역", notes = "가입한 고객 관리")
    @GetMapping("/goMember")
    public String goMemberList(){
        return "memberList";
    }

    @ApiOperation(value = "사용자 충전 내역", notes = "사용자가 충전한 금액 관리")
    @GetMapping("/goPayment")
    public String goPayment(){
        return "paymentList";
    }

    @ApiOperation(value = "사용자 가상 화폐 구매 내역", notes = "사용자가 구매한 리스트 관리")
    @GetMapping("/goBuy")
    public String goBuy(){
        return "buyList";
    }

    @ApiOperation(value = "연락 내역", notes = "연락을 원하는 사람의 정보 관리")
    @GetMapping("/goContact")
    public String goContact(){
        return "contactList";
    }

    @ApiOperation(value = "구독 내역", notes = "구독을 원하는 사람의 정보 관리")
    @GetMapping("/goSubscribe")
    public String goSubscribe(){
        return "subscribeList";
    }

    @ApiOperation(value = "사용자 로그아웃", notes = "로그인된 사용자를 로그아웃시킵니다.")
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

}

package com.test.proccess.controller;

import com.test.proccess.dto.MemberRequestDTO;
import com.test.proccess.dto.MemberResponseDTO;
import com.test.proccess.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

    //@Autowired
    //private MemberService memberService; --|> 캡슐화가 안되어있어서 사용하면 안된다.

    private final MemberService memberService;

    @PostMapping("/signup")
    public MemberResponseDTO insertMember(MemberRequestDTO request){

        return memberService.insertMember(request);
    }


}

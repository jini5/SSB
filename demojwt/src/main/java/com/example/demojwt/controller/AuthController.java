package com.example.demojwt.controller;

import com.example.demojwt.dto.UserDTO;
import com.example.demojwt.entity.Token;
import com.example.demojwt.repository.TokenRepository;
import com.example.demojwt.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
public class AuthController {

    private final UserService userService;
    private final TokenRepository tokenRepository;

    @PostMapping("/sign-up")
    public String signUp(UserDTO addUserDto) {
        userService.signup(addUserDto);
        return "success";
    }

    @PostMapping("/sign-in")
    public String signIn(UserDTO loginUserDto) {
        String loginUserResponse = userService.signin(loginUserDto);
        return loginUserResponse;
    }

    @GetMapping("/hello")
    @PreAuthorize("hasAnyRole('USER')") // USER 권한만 호출 가능
    public String hello(@AuthenticationPrincipal UserDTO user) {
        return user.getEmail() + ", 안녕하세요!";
    }

    @PostMapping("/logout")
    public String logout(@RequestHeader(name="Authorization") String header){
        tokenRepository.save(Token.builder().token(header).build());
        return "success";
    }

}

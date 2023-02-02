package com.example.jwt.controller;

import com.example.jwt.dto.TokenDto;
import com.example.jwt.dto.UserDto;
import com.example.jwt.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
@RestController
public class LoginController {
    private final UserService userAccountService;

    @PostMapping("/sign-up")
    public UserDto signUp(UserDto addUserDto) {
        UserDto savedUser = userAccountService.signUp(addUserDto);
        return savedUser;
    }

    @PostMapping("/sign-in")
    public TokenDto signIn(UserDto loginUserDto) {
        TokenDto loginUserResponse = userAccountService.signIn(loginUserDto);
        return loginUserResponse;
    }

    @GetMapping("/hello")
    @PreAuthorize("hasAnyRole('USER')") // USER 권한만 호출 가능
    public String hello(@AuthenticationPrincipal UserDto user) {
        return user.getEmail() + ", 안녕하세요!";
    }

    @GetMapping("/helloAdmin")
    @PreAuthorize("hasAnyRole('ADMIN')") // ADMIN 권한만 호출 가능
    public String helloAdmin(@AuthenticationPrincipal UserDto user) {
        return user.getEmail() + ", 안녕하세요!";
    }
}

package com.example.jwt.service;

import com.example.jwt.dto.TokenDto;
import com.example.jwt.dto.UserDto;
import com.example.jwt.entity.User;
import com.example.jwt.ext.JwtTokenProvider;
import com.example.jwt.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class UserService {

    Logger logger=LoggerFactory.getLogger(this.getClass());

    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;

    //회원가입(비밀번호 암호화)
    public UserDto signUp(UserDto user) {
        logger.info("user :"+user);
        String encodingPassword = encodingPassword(user.getPassword());
        user.setPassword(encodingPassword);
        User savedUser = userRepository.save(user.toEntity());

        return new UserDto(savedUser);
    }

    //회원 로그인(토큰 발급해줌)
    public TokenDto signIn(UserDto userDto) {
        logger.info("userDto :"+userDto);
        User user = userRepository.findByEmail(userDto.getEmail())
                .orElseThrow(IllegalArgumentException::new);
        logger.info("user :"+user);

        passwordMustBeSame(userDto.getPassword(), user.getPassword());

        String token = jwtTokenProvider.makeJwtToken(user);
        return new TokenDto(token);
    }

    private void passwordMustBeSame(String requestPassword, String password) {
        if (!passwordEncoder.matches(requestPassword, password)) {
            throw new IllegalArgumentException();
        }
    }

    private String encodingPassword(String password) {
        return passwordEncoder.encode(password);
    }


}

package com.example.jwt.ext;

import com.example.jwt.dto.UserDto;
import com.example.jwt.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

//토큰 발급, 생성
@RequiredArgsConstructor
@Component
public class JwtTokenProvider {// 토큰 생성, 검증 하는 객체

    //토큰 생성에 필요한 변수값
    private final JwtProperties jwtProperties;
    Logger logger = LoggerFactory.getLogger(this.getClass());

    public String makeJwtToken(User user) {//토큰 생성
        Date now = new Date();

        return Jwts.builder()
                .setHeaderParam(Header.TYPE, Header.JWT_TYPE)
                .setIssuer(jwtProperties.getIssuer())
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + Duration.ofMinutes(30).toMillis()))
                .claim("email", user.getEmail())
                .claim("role", user.getRole())
                .signWith(SignatureAlgorithm.HS256, jwtProperties.getSecretKey())
                .compact();
    }

    public UserDto getUserDtoOf(String authorizationHeader) {
        validationAuthorizationHeader(authorizationHeader); //토큰이 Bearer로 시작하는지 형식이 맞는지 확인
        String token ="";
        Claims claims=null;

        try {
            token = extractToken(authorizationHeader); // header에서 토큰 추출 (Bearer뗌)
            claims = parsingToken(token);//
            return new UserDto(claims);
        }catch (Exception e){
            logger.error("토큰이 없습니다.(2)");
        }
        return null;
    }

    private Claims parsingToken(String token) { //Token 값을 claims로 바꿔주는 메서드
        return Jwts.parser()
                .setSigningKey(jwtProperties.getSecretKey())
                .parseClaimsJws(token)
                .getBody();
    }

    private void validationAuthorizationHeader(String header) { //헤더값이 유효한지 검증하는 메서드

        if (header == null || !header.startsWith(jwtProperties.getTokenPrefix())) {
            logger.error("토큰이 없습니다.(1)");
        }
    }

    private String extractToken(String authorizationHeader) { //토큰 (Bearer) 떼고 토큰값만 가져오는 메서드
        return authorizationHeader.substring(jwtProperties.getTokenPrefix().length());
    }

}

package com.example.demojwt.jwt;

import com.example.demojwt.dto.UserDTO;
import com.example.demojwt.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtProvider {
    //토큰을 발급하거나, 토근을 유저 객체로 바꾸는 클래스

    //토큰 발급, 로그인 서비스에서 사용
    public String token(User user){

        Date date = new Date();

        return Jwts.builder()
                .setHeaderParam("typ","JWT")
                .setIssuer("james") // 발급자
                .setIssuedAt(date)
                .setExpiration(new Date(date.getTime()*3600000))
                .claim("email",user.getEmail())
                .signWith(SignatureAlgorithm.ES256,"12345")
                .compact();

    }

    //토큰에서 userDTO로 바꿈, jwt필터에서 사용, 유효성검사 해야한다
    public Claims tokenToUser(String token){

        if(token!=null) {
            token = token.substring("Bearer".length());

            return Jwts.parser()
                    .setSigningKey("12345")
                    .parseClaimsJws(token)
                    .getBody();
        }else{
            return null;
        }
    }
}

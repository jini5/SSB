package com.example.demojwt.jwt;


import com.example.demojwt.dto.UserDTO;
import com.example.demojwt.repository.TokenRepository;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {
    //시큐리티 필터 전에 유저 권한이나 인증 관련 정보를 넘겨주는 클래스

    private final JwtProvider jwtProvider;
    private final TokenRepository tokenRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String token = request.getHeader(HttpHeaders.AUTHORIZATION); //상수형태

        if(!tokenRepository.existsByToken(token)) {

            Claims claims = jwtProvider.tokenToUser(token);

            if (claims != null) {
                UserDTO dto = new UserDTO(claims);
                SecurityContextHolder.getContext()
                        .setAuthentication(new UsernamePasswordAuthenticationToken(null, dto.getAuthorities()));
            }

        }

        filterChain.doFilter(request,response);
    }

}

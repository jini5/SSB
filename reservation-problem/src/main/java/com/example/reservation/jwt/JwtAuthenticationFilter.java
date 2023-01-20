package com.example.reservation.jwt;

import com.example.reservation.dto.AccountSignUpRequest;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


//클라이언트에서 보낸 토큰을 유저DTO로 변경
@Getter
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtTokenProvider jwtTokenProvider;

    @Builder
    private JwtAuthenticationFilter(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    public static JwtAuthenticationFilter of(JwtTokenProvider jwtTokenProvider) {
        return JwtAuthenticationFilter.builder()
                .jwtTokenProvider(jwtTokenProvider)
                .build();
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws IOException, ServletException {
        //filter에서 header를 가져옴
        String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);

        try {
            //token 값에서 유효값 (email, role)을 추출하여 userDTO를 만듦
            AccountSignUpRequest user = jwtTokenProvider.getUserDtoOf(authorizationHeader);
            SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(
                    user,
                    "",
                    user.getAuthorities()));

            filterChain.doFilter(request, response);
        } catch (ExpiredJwtException exception) {
            logger.error("ExpiredJwtException : expired token");
        } catch (Exception exception) {
            logger.error("Exception : no token");
            filterChain.doFilter(request, response);
        }
    }
}

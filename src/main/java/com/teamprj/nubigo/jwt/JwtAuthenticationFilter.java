package com.teamprj.nubigo.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.teamprj.nubigo.entity.Users;
import com.teamprj.nubigo.jwt.auth.PrincipalDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@RequiredArgsConstructor
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;


    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        ObjectMapper om = new ObjectMapper();
        Users loginRequestDto = null;
        try {
            loginRequestDto = om.readValue(request.getInputStream(), Users.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 유저네임패스워드 토큰 생성
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(
                        loginRequestDto.getUserId(),
                        loginRequestDto.getUserPassword());

        Authentication authentication =
                authenticationManager.authenticate(authenticationToken);


        PrincipalDetails principalDetailis = (PrincipalDetails) authentication.getPrincipal();
        System.out.println(principalDetailis.getUser().getRoleList());

        return authentication;
    }


    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {

        PrincipalDetails principalDetails = (PrincipalDetails)authResult.getPrincipal();
        System.out.println("successfulAuthentication Start!!");
        // Hash암호방식
        String jwtToken = JWT.create()
                .withSubject("cos토큰")
                .withExpiresAt(new Date(System.currentTimeMillis()+(60000)*100))     // 60000(<- 1분 / 1초 = 1000 . 1000/1이기때문)
                .withClaim("id", principalDetails.getUser().getId())
                .withClaim("username", principalDetails.getUser().getUserId())
                .sign(Algorithm.HMAC512("cos"));

        response.addHeader("authorization","Bearer " + jwtToken); // Bearaer 하고 한 칸 반드시 띄우기

    }
}

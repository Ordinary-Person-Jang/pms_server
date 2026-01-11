package com.aiden.pms.global.security.filter;

import com.aiden.pms.global.security.jwt.*;
import com.aiden.pms.web.form.security.LoginRequestForm;
import com.aiden.pms.web.handler.exHandler.ErrorResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.aiden.pms.global.security.dto.LoginUsrInfoDto;
import com.aiden.pms.global.security.entity.PrincipalDetails;
import com.aiden.pms.global.security.entity.RefreshToken;
import com.aiden.pms.global.security.repository.UsrRedisRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;
import java.util.Date;

@Slf4j
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private final UsrRedisRepository redisRepository;
    private final ObjectMapper mapper;
    private final JwtTokenProvider jwtTokenProvider;

    @SneakyThrows
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {
        log.info("mapperAfter");
        LoginRequestForm form = mapper.readValue(request.getInputStream(), LoginRequestForm.class);

        log.info("Login Eemploee Info [{}] [{}] [{}] [{}]",form.getId(), form.getPjtId(), form.getPassword());
        String loginInfoStr = form.getId() + "::" + form.getPjtId();
        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(loginInfoStr, form.getPassword());

        Authentication authentication = this.getAuthenticationManager().authenticate(token);

        PrincipalDetails principal = (PrincipalDetails) authentication.getPrincipal();

        log.info("LOGIN Token [{}][{}][{}]", principal.getUsr().getUsrId(), principal.getUsr().getPjtId(),
                principal.getAuthorities().stream().findFirst().get().getAuthority());


        return authentication;
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        PrincipalDetails principal = (PrincipalDetails) authResult.getPrincipal();
        LoginUsrInfoDto usr = principal.getUsr();
        String jwtToken = jwtTokenProvider.createAccessToken(new JwtPayload(usr.getUsrId(), usr.getPjtId()));

        request.setAttribute("principal", principal);
        response.addHeader(JwtConstants.HEADER_STRING, JwtConstants.TOKEN_PREFIX + jwtToken);

        RefreshToken redisToken = new RefreshToken(jwtToken, usr.getUsrId());
        redisRepository.save(redisToken);

        chain.doFilter(request, response);
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        response.setStatus(401);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        try {
            ErrorResult errorResult = new ErrorResult("401", "아이디 또는 비밀번호를 확인해 주세요");
            String json = mapper.writeValueAsString(errorResult);
            response.getWriter().write(json);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}

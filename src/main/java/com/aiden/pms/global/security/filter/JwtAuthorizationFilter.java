package com.aiden.pms.global.security.filter;

import com.aiden.pms.domain.common.constant.Constants;
import com.aiden.pms.global.security.jwt.*;
import com.aiden.pms.global.security.store.RedisTokenStore;
import com.aiden.pms.web.form.security.LoginRequestForm;
import com.aiden.pms.web.handler.exHandler.ErrorCode;
import com.aiden.pms.web.handler.exHandler.ErrorResult;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.aiden.pms.domain.usr.entity.Role;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.aiden.pms.global.security.dto.LoginUsrAuthDto;
import com.aiden.pms.global.security.entity.PrincipalDetails;
import com.aiden.pms.global.security.entity.RefreshToken;
import com.aiden.pms.global.security.repository.UsrRedisRepository;
import com.aiden.pms.global.security.service.LoginService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Slf4j
@RequiredArgsConstructor
public class JwtAuthorizationFilter extends OncePerRequestFilter {

    private final UserDetailsService detailsService;
    private final RedisTokenStore redisTokenStore;
    private final LoginService loginService;
    private final ObjectMapper mapper;
    private final JwtTokenResolver jwtTokenResolver;
    private final JwtTokenProvider jwtTokenProvider;

    private static final Set<String> ADMIN_AUTHORITIES = Set.of(
            Constants.ADMIN_AUTH,
            Role.PM.name(),
            Role.QAM.name()
    );

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        Optional<String> tokenOpt = jwtTokenResolver.resolve(request);

        if (tokenOpt.isEmpty()) {
            chain.doFilter(request, response);
            return;
        }

        String token = tokenOpt.get();

        JwtPayload jwtPayload;

        try {
            jwtPayload = jwtTokenProvider.parse(token);
        } catch (Exception e) {
            exceptionHandler(response, ErrorCode.Expried_Token);
            return;
        }

        boolean byID = redisTokenStore.exists(token);
        log.info("ById  [{}]", byID);
        if(byID) {
            redisTokenStore.extendTtl(token, jwtPayload.loginId());
            String loginInfoStr = jwtPayload.loginId() + "::" + jwtPayload.pjtId();

            PrincipalDetails principalDetails = (PrincipalDetails) detailsService.loadUserByUsername(loginInfoStr); // 여기서 유저 INFO를 부를것인가? (개선 필요)
            principalDetails.getUsr().setRole(loginService.setLoginUsrAuth(new LoginRequestForm(jwtPayload.loginId(), jwtPayload.pjtId())));

            List<LoginUsrAuthDto> roles = principalDetails.getUsr().getRole();
//                log.info("롤  : " + role.getAuthority());
            //관리자 롤이 있는 경우
            boolean isAdmin = roles.stream()
                    .map(LoginUsrAuthDto::getAuthority)
                    .anyMatch(ADMIN_AUTHORITIES::contains);

            principalDetails.getUsr().setIsAdmin(isAdmin ? "Y" : "N");

            UsernamePasswordAuthenticationToken logintoken =
                    new UsernamePasswordAuthenticationToken(principalDetails, "" ,principalDetails.getAuthorities());

//            PrincipalDetails principalDetails = (PrincipalDetails) userDetails;
//            request.setAttribute("principal", principalDetails);

            SecurityContext context = SecurityContextHolder.createEmptyContext();
            context.setAuthentication(logintoken);
            SecurityContextHolder.setContext(context);

            log.info("SecurityContextHolder.getContext() [{}]", SecurityContextHolder.getContext());
            chain.doFilter(request, response);
        }else {
            exceptionHandler(response, ErrorCode.No_Exist_Token);
            return;
        }
        log.info("[{}] [{}] [{}]",token, jwtPayload.loginId(), byID);

    }


    public void exceptionHandler(HttpServletResponse response, ErrorCode error) {
        response.setStatus(error.getCode());
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        try {
            ErrorResult errorResult = new ErrorResult(String.valueOf(error.getCode()), error.getMsg());
            String json = mapper.writeValueAsString(errorResult);
            response.getWriter().write(json);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

}

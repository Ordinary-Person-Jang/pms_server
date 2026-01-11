package com.aiden.pms.global.security.config;


import com.aiden.pms.global.security.filter.JwtAuthenticationFilter;
import com.aiden.pms.global.security.filter.JwtAuthorizationFilter;
import com.aiden.pms.global.security.jwt.JwtProperties;
import com.aiden.pms.global.security.jwt.JwtTokenProvider;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.aiden.pms.global.security.handler.JwtAccessDeniedHandler;
import com.aiden.pms.global.security.repository.UsrRedisRepository;
import com.aiden.pms.global.security.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.MessageDigestPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {
    private final CorsFilter corsFilter;
    private final UserDetailsService detailsService;
    private final JwtAccessDeniedHandler accessDeniedHandler;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new MessageDigestPasswordEncoder("SHA-256");
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception{
        return config.getAuthenticationManager();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();

        daoAuthenticationProvider.setUserDetailsService(detailsService);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());

        return daoAuthenticationProvider;
    }

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter(AuthenticationManager authenticationManager, UsrRedisRepository redisRepository,
                                                           ObjectMapper objectMapper, JwtTokenProvider jwtTokenProvider){
        JwtAuthenticationFilter filter = new JwtAuthenticationFilter(redisRepository, objectMapper, jwtTokenProvider);
        filter.setAuthenticationManager(authenticationManager);

        return filter;
    }

    @Bean
    public JwtAuthorizationFilter jwtAuthorizationFilter(UserDetailsService detailsService, UsrRedisRepository redisRepository,
                                                         LoginService loginService, ObjectMapper objectMapper, JwtTokenProvider jwtTokenProvider){

        return new JwtAuthorizationFilter(detailsService, redisRepository, loginService, objectMapper, jwtTokenProvider);
    }



    @Bean
    public SecurityFilterChain filterChain(HttpSecurity security, JwtAuthenticationFilter jwtAuthenticationFilter,
                                           JwtAuthorizationFilter jwtAuthorizationFilter) throws Exception {
        security.csrf(AbstractHttpConfigurer::disable);
        security.authenticationProvider(authenticationProvider());
        security.sessionManagement((sessionManagement) ->
                        sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(corsFilter, UsernamePasswordAuthenticationFilter.class)
                .formLogin(AbstractHttpConfigurer::disable)
                .addFilterAt(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling(exceptionConfig ->
                        exceptionConfig.accessDeniedHandler(accessDeniedHandler))
                .httpBasic(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests((authorizeRequests) -> {
                    authorizeRequests.requestMatchers(HttpMethod.OPTIONS, "/**").permitAll();
                    authorizeRequests.requestMatchers("/api/bi/bim/pjtinfoReg/getPjtList").permitAll();
//                    authorizeRequests.requestMatchers("/api/**").hasAnyRole("OUT", "CUS");

                    authorizeRequests.requestMatchers("/api/**").hasAnyAuthority("OUT", "CUS");
                    authorizeRequests.anyRequest().permitAll();
                });

        return security.build();
    }

}

package org.example.springjwt.config;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.example.springjwt.filter.CustomGenericFilter;
import org.example.springjwt.filter.CustomOnceFilter;
import org.example.springjwt.jwt.JWTFilter;
import org.example.springjwt.jwt.JWTUtil;
import org.example.springjwt.jwt.LoginFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import java.util.Collections;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
//@EnableWebSecurity(debug = true) // securityFilterChain 어디를 거치는지 로그찍게해줌(개발모드에만)?
@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig {


    private final AuthenticationConfiguration authenticationConfiguration;
    private final JWTUtil jwtUtil;
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {

        return new BCryptPasswordEncoder();
    }

    // LoginFilter는 AuthenticationManager가 필요 -> autehtnicationManager는 AuthenticationConfiguration 필요 -> configuration 생성자 주입
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    //securityFilterChain이 여러개라면 하나만 선택해서 요청 전달
    // 기준 -> 1. 등록 인덱스 순, 필터 체인에 대한 ReqeustMacther값이 일치하는지 확인(인가 설정x)

    // SecurityFilterChain 등록하기
    @Bean
    @Order(1) // 숫자가 낮은게 먼저 우선순위로 FilterChain에 등록 [FilterChain에 우선순위 부여]
    public SecurityFilterChain filterChain1(HttpSecurity http) throws Exception {

        http
                // authorizeHttpRequests만 쓰면 모두 해당 url로 와서 다음 filterChain이 안먹히고 바로 거부됨
                // 이 SecurityFitlerChain은 '/user' 경로에 대해서만 받아옴
                .securityMatchers((auth) -> auth.requestMatchers("/user"));

        http
                .authorizeHttpRequests((auth) -> auth
                        .requestMatchers("/user").permitAll());

        return http.build();
    }

    @Bean
    public SecurityFilterChain filterChain2(HttpSecurity http) throws Exception {

        http
                .cors((cors) -> cors.disable()); // cors 비활성화

        http
                .csrf((csrf) -> csrf.disable()); // csrf 비활성화

        http
                .securityMatchers((auth) -> auth.requestMatchers("/admin"));

        //활성
        http
                .formLogin(withDefaults());

        //비활성
        http
                .formLogin((login) -> login.disable());

        http
                .authorizeHttpRequests((auth) -> auth
                        .requestMatchers("/admin").authenticated());

        //formLogin 메소드 설정시 기본적으로 활성화//커스텀시 기본 필터 비활성
        http
                .formLogin((login) -> login.loginPage("/login").permitAll());

        //활성
        http
                .httpBasic(withDefaults());

        //비활성
        http
                .httpBasic((basic) -> basic.disable());

//        //특정필터이전
//        http
//                .addFilterBefore(추가할필터, 기존필터.class);
//
//        //특정필터위치
//        http
//                .addFilterAt(추가할필터, 기존필터.class);
//
//        //특정필터이후
//        http
//                .addFilterAfter(추가할필터, 기존필터.class);
        http
                .addFilterAfter(new CustomGenericFilter(), LogoutFilter.class);
        http
                .addFilterAfter(new CustomOnceFilter(), LogoutFilter.class);


        return http.build();
    }
    
    
    // 원하지 않는 경로에서는 FilterChain  거지치 않도록
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {

        return web -> web.ignoring().requestMatchers("/img/**");
    }
}

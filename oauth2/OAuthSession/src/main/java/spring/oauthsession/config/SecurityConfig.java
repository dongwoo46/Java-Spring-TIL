package spring.oauthsession.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import spring.oauthsession.oauth2.CustomClientRegistrationRepo;
import spring.oauthsession.oauth2.CustomOAuth2AuthorizedClientService;
import spring.oauthsession.service.CustomOAuth2UserService;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final CustomOAuth2UserService customOAuth2UserService;
    //jdbc로 client-id, client-secret 등 등록해서 하는 클래스
    private final CustomClientRegistrationRepo customClientRegistrationRepo;
    private final CustomOAuth2AuthorizedClientService customOAuth2AuthorizedClientService;
    private final JdbcTemplate jdbcTemplate;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        //  csrf 설정끄기
        http.csrf((csrf) -> csrf.disable());
        // 폼 로그인 방식 끄기
        http.formLogin((login) -> login.disable());
        // httpBassic 방식 끄기
        http.httpBasic((basic) -> basic.disable());
        // oauth2Client -> 필터와 등록정보를 일일히 해야함
        // oauth2Login 사용
        // 람다 메소드로 세팅이 필요
//        http.oauth2Login((oauth2)-> oauth2
//                .loginPage("/login") // uri 등록시 커스텀 로그인 페이지로 이동
//                .userInfoEndpoint((userInfoEndpointConfig ->
//                userInfoEndpointConfig.userService(customOAuth2UserService))));

        // application.yml 말고 jdbc로 설정 클래스 만들어서 repo등록하는 방법
        http.oauth2Login((oauth2)-> oauth2
                .loginPage("/login") // uri 등록시 커스텀 로그인 페이지로 이동
                .clientRegistrationRepository(customClientRegistrationRepo.clientRegistrationRepository())
                .authorizedClientService(customOAuth2AuthorizedClientService.oAuth2AuthorizedClientService(jdbcTemplate, customClientRegistrationRepo.clientRegistrationRepository()))
                .userInfoEndpoint((userInfoEndpointConfig ->
                        userInfoEndpointConfig.userService(customOAuth2UserService))));


        http.authorizeHttpRequests((auth)-> auth
                .requestMatchers("/", "/oauth2/**", "/login/**").permitAll() // 해당 url의 경로는 모두 허용
                .anyRequest().authenticated()); // 나머지 url은 인증 필요

        return  http.build();
    }
}

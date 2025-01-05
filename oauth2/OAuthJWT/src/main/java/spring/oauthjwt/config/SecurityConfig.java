package spring.oauthjwt.config;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import spring.oauthjwt.jwt.JWTFilter;
import spring.oauthjwt.jwt.JWTUtil;
import spring.oauthjwt.oauth2.CustomSuccessHandler;
import spring.oauthjwt.service.CustomOAuth2UserService;

import java.util.Arrays;
import java.util.Collections;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final CustomOAuth2UserService customOAuth2UserService;
    private final CustomSuccessHandler customSuccessHandler;
    private final JWTUtil jwtUtil;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .cors(corsCustomizer -> corsCustomizer.configurationSource(new CorsConfigurationSource() {
                    @Override
                    public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {

                        CorsConfiguration configuration = new CorsConfiguration();

                        // 클라이언트가 허용할 헤더 설정
                        // 허용할 Origin
                        configuration.setAllowedOrigins(Collections.singletonList("http://localhost:3000"));

                        // 허용할 HTTP 메서드
                        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));

                        // 자격 증명 허용 (쿠키, 인증 정보 포함)
                        configuration.setAllowCredentials(true);

                        // 허용할 요청 헤더
                        configuration.setAllowedHeaders(Arrays.asList("Content-Type", "Authorization"));

                        // Preflight 요청 캐싱 시간 (1시간)
                        configuration.setMaxAge(3600L);

                        // 브라우저가 클라이언트에 노출할 헤더를 설정
                        configuration.setExposedHeaders(Arrays.asList("Set-Cookie", "Authorization"));

                        return configuration;
                    }
                }));

        //csrf disable
        http
                .csrf((auth) -> auth.disable());

        //From 로그인 방식 disable
        http
                .formLogin((auth) -> auth.disable());

        //HTTP Basic 인증 방식 disable
        http
                .httpBasic((auth) -> auth.disable());

        //JWTFilter 추가
        http
                .addFilterAfter(new JWTFilter(jwtUtil), UsernamePasswordAuthenticationFilter.class);

        //oauth2
        http
                .oauth2Login((oAuth2)-> oAuth2.userInfoEndpoint((
                        userInfoEndpointConfig -> userInfoEndpointConfig
                        .userService(customOAuth2UserService)))
                        .successHandler(customSuccessHandler)
                );

        //경로별 인가 작업
        http
                .authorizeHttpRequests((auth) -> auth
                        .requestMatchers("/").permitAll()
                        .anyRequest().authenticated());

        //세션 설정 : STATELESS
        http
                .sessionManagement((session) -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return http.build();
    }
}

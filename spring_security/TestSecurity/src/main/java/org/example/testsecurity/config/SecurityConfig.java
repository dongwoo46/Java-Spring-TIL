package org.example.testsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;

@Configuration // spring security에 Configuration으로 등록
@EnableWebSecurity // 해당 클래스가 spring security에서 관리됨
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public RoleHierarchy roleHierarchy() {

        RoleHierarchyImpl hierarchy = new RoleHierarchyImpl();

        hierarchy.setHierarchy("ROLE_C > ROLE_B\n" +
                "ROLE_B > ROLE_A");

        return hierarchy;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        //특정 경로에 대해서 작업을 진행할 것이다. ex) root와 login경로에 작업진행
        http.authorizeHttpRequests((auth)-> auth //인증, 인가가 필요한 URL 지정
                // permitAll -> 모든 유저
                .requestMatchers("/","/login", "/loginProc", "/join", "/joinProc").permitAll()
                .requestMatchers("/admin").hasRole("ADMIN")
                .requestMatchers("/my/**").hasAnyRole("ADMIN","USER")
                // 나머지 모든 경로에 대해서는 로그인만 되면 접근 가능
                .anyRequest().authenticated()
        );

        /*
        권한 차이에 맡게 페이지 오픈
        http.authorizeHttpRequests((auth) -> auth
                .requestMatchers("/login").permitAll()
                .requestMatchers("/").hasAnyRole("A")
                .requestMatchers("/manager").hasAnyRole("B")
                .requestMatchers("/admin").hasAnyRole("C")
                .anyRequest().authenticated()
        );
         */


        // formLogin 방식 로그인
//        http.formLogin((auth)-> auth.loginPage("/login") //login page 경로 설정 admin등 페이지 접속시 로그인 페이지로 자동 redireciton
//                .loginProcessingUrl("/loginProc") // html의 loginProc이라는 경로로 데이터 보내기
//                .permitAll()
//        );

        //httpBasic 이용 로그인
        http.httpBasic((Customizer.withDefaults()));

//        http.csrf((auth)->auth.disable());

        http.sessionManagement((auth)->auth
                .maximumSessions(1)
                .maxSessionsPreventsLogin(true));

        http.sessionManagement((auth)->auth
                .sessionFixation() //세션 고정 여부
                .changeSessionId()); // newSession 모든 값이 변경

        return http.build();
    }
//    InMemory 방식으로 유저 정보 저장하기
//    @Bean
//    public UserDetailsService userDetailsService() {
//
//        UserDetails user1 = User.builder()
//                .username("user1")
//                .password(bCryptPasswordEncoder().encode("1234"))
//                .roles("ADMIN")
//                .build();
//
//        UserDetails user2 = User.builder()
//                .username("user2")
//                .password(bCryptPasswordEncoder().encode("1234"))
//                .roles("USER")
//                .build();
//
//        return new InMemoryUserDetailsManager(user1, user2);
//    }
}

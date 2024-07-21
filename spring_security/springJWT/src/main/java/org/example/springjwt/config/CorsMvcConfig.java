package org.example.springjwt.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsMvcConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry corsRegistry) {

        // 모든 경로에대해서 frontend 3000번 포트로 오는 것을 허용
        corsRegistry.addMapping("/**")
                .allowedOrigins("http://localhost:3000");
    }
}

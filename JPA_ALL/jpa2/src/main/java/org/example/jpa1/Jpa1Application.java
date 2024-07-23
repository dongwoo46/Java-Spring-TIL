package org.example.jpa1;

import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import org.hibernate.Hibernate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Jpa1Application {

    public static void main(String[] args) {
        SpringApplication.run(Jpa1Application.class, args);
    }

    // 엔티티를 직접적으로 노출할때 해결방법 -> lazy 로딩시 프록시객체를 조회해서 발생하는 문제 해결
    // dto 사용시 필요없음
//    @Bean
//    Hibernate5Module hibernate5Module() {
//        return new Hibernate5Module();
//    }
}

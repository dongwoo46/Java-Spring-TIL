package com.codersee.springcoroutines.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("applilcation.comapny")
data class Company(
        //Spring Data R2DBC는 id 필드가 null일 경우, 데이터베이스가 값을 생성하도록 허용합니다.
        // 이를 위해 데이터 클래스에서 id를 nullable(Long?)로 선언
        @Id val id: Long? = null,
        val name: String,
        val address: String
)

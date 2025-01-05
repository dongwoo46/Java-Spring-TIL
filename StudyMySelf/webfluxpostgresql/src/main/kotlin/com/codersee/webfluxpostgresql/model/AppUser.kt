package com.codersee.webfluxpostgresql.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

// @Table에 테이블 명 작성
@Table("app_user")
data class AppUser(
        @Id val id: Long? = null,
        val name: String,
        val email: String,
)

package com.codersee.webfluxpostgresql.model

import jakarta.validation.constraints.NotBlank

data class AppUserRequest(
        @field:NotBlank val name: String,
        @field:NotBlank val email: String
)

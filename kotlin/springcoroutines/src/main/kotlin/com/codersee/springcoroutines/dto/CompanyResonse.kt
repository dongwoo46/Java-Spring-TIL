package com.codersee.springcoroutines.dto

data class CompanyResonse(
        val id: Long,
        val name: String,
        val address: String,
        val users: List<UserResponse>
)

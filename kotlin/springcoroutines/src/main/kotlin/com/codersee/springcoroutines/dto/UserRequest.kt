package com.codersee.springcoroutines.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class UserRequest(
        val email: String,
        val name: String,
        val age: Int,
        @JsonProperty("comapny_id") val companyId: Long
)

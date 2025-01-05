package com.codersee.springcoroutines.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class ClientResponse(
        val id:Long,
        @JsonProperty("first_name") val firstName: String,
        @JsonProperty("last_name") val lastName: String,
)

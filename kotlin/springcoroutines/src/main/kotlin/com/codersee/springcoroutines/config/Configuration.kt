package com.codersee.springcoroutines.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient

@Configuration
class Configuration {
    @Bean
    fun webClient(builder:WebClient.Builder): WebClient =
            builder
                    .baseUrl("http://localhost:8090")
                    .build()
}
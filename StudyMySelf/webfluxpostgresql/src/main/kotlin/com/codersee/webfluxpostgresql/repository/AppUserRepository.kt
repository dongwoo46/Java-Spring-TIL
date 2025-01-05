package com.codersee.webfluxpostgresql.repository

import com.codersee.webfluxpostgresql.model.AppUser
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Mono

interface AppUserRepository: ReactiveCrudRepository<AppUser, Long> {
    fun findByEmail(email: String): Mono<AppUser>
}
package com.codersee.webfluxpostgresql.controller

import com.codersee.webfluxpostgresql.model.AppUser
import com.codersee.webfluxpostgresql.model.AppUserRequest
import com.codersee.webfluxpostgresql.model.BadRequestException
import com.codersee.webfluxpostgresql.model.NotFoundException
import com.codersee.webfluxpostgresql.repository.AppUserRepository
import com.codersee.webfluxpostgresql.service.AppUserService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/api")
class AppUserController (
        private val appUserService:AppUserService,
        private val appUserRepository: AppUserRepository

) {

    @GetMapping("/users")
    fun getAll() : Flux<AppUser> = appUserService.findAll();

    @GetMapping("/users/{id}")
    fun getById(@PathVariable id:Long) : Mono<AppUser> = appUserService.findById(id)
            .switchIfEmpty(
                    Mono.error(NotFoundException("User with id $id was not fouond")
                    )
            );

    @PostMapping("/users")
    fun createUser(@Valid @RequestBody appUserRequest: AppUserRequest): Mono<AppUser> =
            appUserService.createUser(appUserRequest)

    @PutMapping("/users/{id}")
    fun updateUser(@Valid @RequestBody appUserRequest: AppUserRequest, @PathVariable id:Long) : Mono<AppUser> =
            appUserService.updateUser(id, appUserRequest)


    @DeleteMapping("/users/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteUser(@PathVariable id:Long):Mono<Void> = appUserService.deleteUser(id)
}
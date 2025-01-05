package com.codersee.webfluxpostgresql.service

import com.codersee.webfluxpostgresql.model.AppUser
import com.codersee.webfluxpostgresql.model.AppUserRequest
import com.codersee.webfluxpostgresql.model.BadRequestException
import com.codersee.webfluxpostgresql.repository.AppUserRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.switchIfEmpty

@Service
class AppUserService(
        private val appUserRepository: AppUserRepository
) {

    fun findAll(): Flux<AppUser> = appUserRepository.findAll();

    fun findById(id:Long):Mono<AppUser> = appUserRepository.findById(id);

    fun createUser(appUserRequest: AppUserRequest): Mono<AppUser> =
        findByEmailOrError(appUserRequest)
                .switchIfEmpty(
                        // 사용자가 존재하지 않으면 새 사용자 생성
                        appUserRepository.save(
                                AppUser(
                                        name = appUserRequest.name,
                                        email = appUserRequest.email
                                )
                        )
                )

    private fun findByEmailOrError(appUserRequest: AppUserRequest) =
            appUserRepository.findByEmail(appUserRequest.email)
                    .flatMap {
                        // 이미 사용자가 존재하면 에러 반환
                        Mono.error<AppUser>(
                                BadRequestException("User with email ${appUserRequest.email} already exists")
                        )
                    }

    fun updateUser(id: Long, appUserRequest: AppUserRequest): Mono<AppUser> =
            findById(id)
                    .flatMap {
                        findByEmailOrError(appUserRequest)
                                .switchIfEmpty {
                                    appUserRepository.save(
                                            AppUser(
                                                    id = id,
                                                    name= appUserRequest.name,
                                                    email = appUserRequest.email
                                            )
                                    )
                                }
                    }

    fun deleteUser(id: Long): Mono<Void> =
            findById(id)
                    .flatMap {foundUser-> appUserRepository.delete(foundUser) }


}
package com.codersee.springcoroutines.controller

import com.codersee.springcoroutines.dto.UserRequest
import com.codersee.springcoroutines.dto.UserResponse
import com.codersee.springcoroutines.model.User
import com.codersee.springcoroutines.service.UserApiService
import com.codersee.springcoroutines.service.UserService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/api/users")
class UserController(
        private val userService: UserService,
        private val userApiService: UserApiService
) {

    @PostMapping
    suspend fun createUser(
            @RequestBody userRequest: UserRequest
    ): UserResponse =
            userService.saveUser(
                    user = userRequest.toModel()
            )
                    ?.toResponse()
                    ?: throw ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR)


    @GetMapping
    suspend fun findAll(
            @RequestParam("name", required=false) name: String?
    ): Flow<UserResponse> {
        val users = name?.let { userService.findByNameLike(it) } ?: userService.findAllUsers()
        return users.map(User::toResponse)
    }

    @GetMapping("/{id}")
    suspend fun findById(@PathVariable id:Long): UserResponse =
            userService.findById(id)
                    ?.let(User::toResponse)
                    ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)

    @DeleteMapping("/{id}")
    suspend fun deleteById(@PathVariable id:Long) {
        userService.findById(id)
    }

    @GetMapping("/webclient")
    suspend fun findAllUsers() =
            userApiService.findAllUsers()

    @GetMapping("/webclient/flow")
    suspend fun findAllFlowUsers() =
            userApiService.findAllUsersFlow()

    @GetMapping("/webclient/exchange")
    suspend fun findAllExchangeUsers() =
            userApiService.findAllUsersUsingExchange()

    @DeleteMapping("/webclient/{id}")
    suspend fun deleteUserById(@PathVariable id:Long) =
            userApiService.deleteUserById(id)

    @DeleteMapping("/webclient/responseEntity/{id}")
    suspend fun deleteUserByIdReponseEntity(@PathVariable id:Long) =
            userApiService.deleteUserByIdResponseEntity(id)

    @GetMapping("/webclient/{id}")
    suspend fun findUserById(@PathVariable id:Long) =
            userApiService.findUserById(id)

    @GetMapping("/webclient/throwException/{id}")
    suspend fun findUserByIdThrowException(@PathVariable id:Long) =
            userApiService.findUserByIdNotFoundHandling(id)
}

private fun UserRequest.toModel(): User =
        User(
                email=this.email,
                name=this.name,
                age=this.age,
                companyId = this.companyId
        )

fun User.toResponse(): UserResponse =
        UserResponse(
                id = this.id!!,
                email= this.email,
                name=this.name,
                age=this.age
        )
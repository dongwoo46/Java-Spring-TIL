package com.codersee.springcoroutines.service

import com.codersee.springcoroutines.dto.ClientResponse
import com.codersee.springcoroutines.dto.UserResponse
import kotlinx.coroutines.flow.Flow
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.*
import org.springframework.web.server.ResponseStatusException

@Service
class UserApiService(
        private val webClient: WebClient
) {

    private val logger = LoggerFactory.getLogger(UserApiService::class.java)

    suspend fun findAllUsers(): List<ClientResponse> =
            webClient.get()
                    .uri("/users")
                    .retrieve()
                    .awaitBody()


    suspend fun findUserById(id: Long): ClientResponse? =
            webClient.get()
                    .uri("/users/$id")
                    .retrieve()
                    .awaitBodyOrNull()

    fun findAllUsersFlow(): Flow<ClientResponse> =
            webClient.get()
                    .uri("/users")
                    .retrieve()
                    .bodyToFlow()

    suspend fun findAllUsersUsingExchange(): List<ClientResponse> =
            webClient.get()
                    .uri("/users")
                    .awaitExchange { clientResponse ->
                        val headers = clientResponse.headers().asHttpHeaders()
                        logger.info("Received response from the users API, headers: $headers")
                        clientResponse.awaitBody()

                    }

    fun findAllUsersUsingExchangeFlow(): Flow<UserResponse> =
            webClient.get()
                    .uri("/users")
                    .exchangeToFlow { clientResponse ->
                        val headers = clientResponse.headers().asHttpHeaders()
                        logger.info("Received response from the users API, headers: $headers")
                        clientResponse.bodyToFlow()
                    }

    suspend fun deleteUserById(id:Long): Unit =
            webClient.delete()
                    .uri("/users/$id")
                    .retrieve()
                    .awaitBody()

    suspend fun deleteUserByIdResponseEntity(id:Long): ResponseEntity<Void> =
            webClient.delete()
                    .uri("/users/$id")
                    .retrieve()
                    .awaitBodilessEntity()

    suspend fun findUserByIdNotFoundHandling(id:Long): UserResponse =
            webClient.get()
                    .uri("/users/$id")
                    .retrieve()
                    .onStatus({responseStatus->
                        responseStatus == HttpStatus.NOT_FOUND
                    }) {
                        throw ResponseStatusException(HttpStatus.NOT_FOUND)
                    }
                    .awaitBody()

}
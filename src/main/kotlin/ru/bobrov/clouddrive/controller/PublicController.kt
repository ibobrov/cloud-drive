package ru.bobrov.clouddrive.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import ru.bobrov.clouddrive.dto.AuthenticationRequest
import ru.bobrov.clouddrive.dto.AuthenticationResponse
import ru.bobrov.clouddrive.security.AuthenticationService

@RestController
class PublicController(
    private val authenticationService: AuthenticationService
) {

    @PostMapping("/api/public/auth")
    fun authenticate(@RequestBody authRequest: AuthenticationRequest): AuthenticationResponse =
        authenticationService.authentication(authRequest)
}

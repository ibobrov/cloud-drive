package ru.bobrov.clouddrive.security

import org.springframework.beans.factory.annotation.Value
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Service
import ru.bobrov.clouddrive.dto.AuthenticationRequest
import ru.bobrov.clouddrive.dto.AuthenticationResponse
import java.util.*

@Service
class AuthenticationService(
    private val authenticationManager: AuthenticationManager,
    private val userDetailsService: CustomUserDetailsService,
    private val jwtTokenService: JwtTokenService,
    @Value("\${token.expiration}")
    private val expiration: Long,
) {

    fun authentication(authRequest: AuthenticationRequest): AuthenticationResponse {
        authenticationManager.authenticate(
            UsernamePasswordAuthenticationToken(
                authRequest.login,
                authRequest.password,
            )
        )
        val user = userDetailsService.loadUserByUsername(authRequest.login)
        val accessToken = generateAccessToken(user)

        return AuthenticationResponse(token = accessToken)
    }

    private fun generateAccessToken(user: UserDetails): String =
        jwtTokenService.generate(
            userDetails = user,
            expirationDate = Date(System.currentTimeMillis() + expiration * 1000),
        )
}

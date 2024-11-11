package ru.bobrov.clouddrive.security

import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter

@Component
class JwtAuthenticationFilter(
    private val userDetailsService: UserDetailsService,
    private val tokenService: TokenService
) : OncePerRequestFilter() {

    override fun doFilterInternal(
        req: HttpServletRequest, resp: HttpServletResponse,
        filterChain: FilterChain
    ) {
        val authorization: String? = req.getHeader(AUTHORIZATION_HEADER_NAME)
        if (authorization == null || !authorization.startsWith(BEARER_PREFIX)) {
            filterChain.doFilter(req, resp)
            return
        }

        val jwtToken: String = authorization.substring(BEARER_PREFIX.length)
        val username: String = tokenService.extractEmail(jwtToken)

        if (SecurityContextHolder.getContext().authentication == null) {
            val userDetails: UserDetails = userDetailsService.loadUserByUsername(username)

            if (tokenService.isValid(jwtToken, userDetails) && userDetails.isEnabled
                && userDetails.isAccountNonLocked) {

                updateContext(userDetails, req)
            }
        }

        filterChain.doFilter(req, resp)
    }

    private fun updateContext(userDetails: UserDetails, request: HttpServletRequest) {
        val authToken = UsernamePasswordAuthenticationToken(
            userDetails,
            null,
            userDetails.authorities
        )

        authToken.details = WebAuthenticationDetailsSource().buildDetails(request)
        SecurityContextHolder.getContext().authentication = authToken
    }

    companion object {
        const val BEARER_PREFIX: String = "Bearer "
        const val AUTHORIZATION_HEADER_NAME: String = "Authorization"
    }
}

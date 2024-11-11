package ru.bobrov.clouddrive.security

import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import ru.bobrov.clouddrive.repositories.UserRepository

@Service
class CustomUserDetailsService(
    private val userRepository: UserRepository
) : UserDetailsService {

    override fun loadUserByUsername(username: String): UserDetails =
        userRepository.findUserByLogin(username)
            ?.mapToUserDetails()
            ?: throw UsernameNotFoundException("Not found!")
}
package ru.bobrov.clouddrive.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails

@Table("users")
data class User(
    @Id
    var id: Long?,
    var login: String,
    var password: String,
    var role: String = "USER"
) {

    fun mapToUserDetails(): UserDetails =
        User.builder()
            .username(this.login)
            .password(this.password)
            .roles(this.role)
            .build()
}

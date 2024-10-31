package ru.bobrov.clouddrive.model

import org.springframework.data.annotation.Id
import java.util.UUID

data class User(
    @Id
    var id: UUID?,
    var login: String,
    var email: String,
    var password: String
)

package ru.bobrov.clouddrive.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import ru.bobrov.clouddrive.model.User
import java.util.*

@Repository
interface UserRepository : CrudRepository<User, UUID> {

    fun findUserByLogin(login: String): User?
}

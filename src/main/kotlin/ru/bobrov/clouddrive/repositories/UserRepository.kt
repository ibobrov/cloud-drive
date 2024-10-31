package ru.bobrov.clouddrive.repositories

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import ru.bobrov.clouddrive.model.Directory
import java.util.*

@Repository
interface UserRepository : CrudRepository<Directory, UUID>
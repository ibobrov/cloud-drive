package ru.bobrov.clouddrive.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository
import ru.bobrov.clouddrive.model.Directory
import java.util.*

@Repository
interface DirectoryRepository : CrudRepository<Directory, UUID>, PagingAndSortingRepository<Directory, UUID>

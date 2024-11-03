package ru.bobrov.clouddrive.repositories

import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository
import ru.bobrov.clouddrive.model.Directory
import java.util.*

@Repository
interface DirectoryRepository : PagingAndSortingRepository<Directory, UUID>
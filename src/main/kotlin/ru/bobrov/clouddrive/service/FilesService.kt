package ru.bobrov.clouddrive.service

import org.springframework.stereotype.Service
import ru.bobrov.clouddrive.minio.MinioService
import ru.bobrov.clouddrive.repository.DirectoryRepository

@Service
class FilesService(
    private val directoryRepository: DirectoryRepository,
    private val minioService: MinioService
) {


}
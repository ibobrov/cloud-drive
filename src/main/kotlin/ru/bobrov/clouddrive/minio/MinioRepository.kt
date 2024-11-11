package ru.bobrov.clouddrive.minio

import io.minio.GetObjectArgs
import io.minio.MinioClient
import io.minio.PutObjectArgs
import io.minio.RemoveObjectArgs
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.multipart.MultipartFile
import java.io.ByteArrayInputStream
import java.io.InputStream
import java.util.*


class MinioRepository(
    private val minioClient: MinioClient,
    @Value("\${spring.minio.bucket}")
    private val bucketName: String
) {

    fun save(uuid: UUID, multipartFile: MultipartFile) {
        val inputStream: InputStream = ByteArrayInputStream(multipartFile.bytes)
        minioClient.putObject(
            PutObjectArgs
                .builder()
                .stream(inputStream, inputStream.available().toLong(), -1)
                .bucket(bucketName)
                .`object`(uuid.toString())
                .build()
        )
    }

    fun delete(uuid: UUID) =
        minioClient.removeObject(
            RemoveObjectArgs
                .builder()
                .bucket(bucketName)
                .`object`(uuid.toString())
                .build()
        )

    fun find(uuid: UUID): InputStream =
        minioClient.getObject(
            GetObjectArgs
                .builder()
                .bucket(bucketName)
                .`object`(uuid.toString())
                .build()
        )
}

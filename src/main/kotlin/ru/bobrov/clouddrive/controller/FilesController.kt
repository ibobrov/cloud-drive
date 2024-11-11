package ru.bobrov.clouddrive.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile
import java.util.UUID

@RestController
class FilesController {

    @GetMapping("/api/download")
    fun downloadFile(@RequestParam("uuid") uuid: UUID) =
        "OK"

    @PostMapping("/api/upload")
    fun uploadFile(@RequestParam("file") file: MultipartFile) =
        "OK"
}

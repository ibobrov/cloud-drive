package ru.bobrov.clouddrive.controllers

import org.springframework.data.domain.Sort
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import ru.bobrov.clouddrive.dto.FolderCreateResponse
import ru.bobrov.clouddrive.model.Directory
import ru.bobrov.clouddrive.repositories.DirectoryRepository

@RestController("/api/folders")
class FoldersController(
    val directoryRepository: DirectoryRepository
) {

    @GetMapping
    fun findAll(model: Model): Iterable<Directory> =
        directoryRepository.findAll(Sort.by(Sort.Order.asc("name")))

    @PostMapping
    fun save(@RequestBody response: FolderCreateResponse): ResponseEntity<Void> {
        directoryRepository.save(Directory(null, response.name))
        return ResponseEntity.status(HttpStatus.CREATED).build()
    }
}

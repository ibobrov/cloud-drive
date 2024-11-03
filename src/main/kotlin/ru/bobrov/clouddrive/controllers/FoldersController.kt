package ru.bobrov.clouddrive.controllers

import org.springframework.data.domain.Sort
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import ru.bobrov.clouddrive.dto.FolderCreateResponse
import ru.bobrov.clouddrive.model.Directory
import ru.bobrov.clouddrive.repositories.DirectoryRepository

@RestController
class FoldersController(
    val directoryRepository: DirectoryRepository
) {

    @GetMapping("/api/folders")
    fun findAll(): Iterable<Directory> =
        directoryRepository.findAll(Sort.by(Sort.Order.asc("name")))

    @PostMapping("/api/folders")
    fun save(@RequestBody response: FolderCreateResponse): ResponseEntity<Directory> {
        val newDirectory = directoryRepository.save(Directory(null, response.name))
        return ResponseEntity.status(HttpStatus.CREATED).body(newDirectory)
    }
}

package ru.bobrov.clouddrive.controllers

import org.springframework.data.domain.Sort
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import ru.bobrov.clouddrive.dto.FolderCreateResponse
import ru.bobrov.clouddrive.model.Directory
import ru.bobrov.clouddrive.repositories.DirectoryRepository
import java.util.*

@Controller
class IndexController(
    val directoryRepository: DirectoryRepository
) {

    @GetMapping("/", "/index")
    fun getIndexPage(model: Model) : String {
        model.addAttribute("directories", directoryRepository.findAll(Sort.by(Sort.Order.asc("name"))))
        return "index"
    }

    @PostMapping("/api/folders")
    fun createDirectory(@RequestBody response: FolderCreateResponse) : String {
        directoryRepository.save(Directory(null, response.name))

        return "redirect:/"
    }
}

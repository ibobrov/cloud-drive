package ru.bobrov.clouddrive.controllers

import org.springframework.data.domain.Sort
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import ru.bobrov.clouddrive.model.Directory
import ru.bobrov.clouddrive.repositories.DirectoryRepository

@Controller
class IndexController(
    val directoryRepository: DirectoryRepository
) {

    @GetMapping("/", "/index")
    fun getIndexPage(model: Model) : String {
        model.addAttribute("directories", directoryRepository.findAll(Sort.by(Sort.Order.asc("name"))))
        return "index"
    }
}

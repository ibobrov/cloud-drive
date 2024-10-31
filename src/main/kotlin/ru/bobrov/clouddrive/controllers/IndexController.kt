package ru.bobrov.clouddrive.controllers

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import ru.bobrov.clouddrive.repositories.DirectoryRepository

@Controller
class IndexController(
    val directoryRepository: DirectoryRepository
) {
    private val logger = org.slf4j.LoggerFactory.getLogger(javaClass)

    @GetMapping("", "/index")
    fun getIndexPage(model: Model) : String {
        model.addAttribute("directories", directoryRepository.findAll())
        logger.info("hi")
        logger.info(directoryRepository.findAll().toString())
        return "index"
    }
}

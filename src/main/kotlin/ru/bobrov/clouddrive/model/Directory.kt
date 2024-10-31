package ru.bobrov.clouddrive.model

import org.springframework.data.annotation.Id
import java.util.*

data class Directory(
    @Id
    var id: UUID?,
    var name: String
)

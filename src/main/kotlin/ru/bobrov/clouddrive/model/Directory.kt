package ru.bobrov.clouddrive.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.util.*

@Table("directories")
data class Directory(
    @Id
    var id: UUID?,
    var name: String
)

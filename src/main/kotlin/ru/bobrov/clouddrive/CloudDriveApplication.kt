package ru.bobrov.clouddrive

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CloudDriveApplication

fun main(args: Array<String>) {
    runApplication<CloudDriveApplication>(*args)
}

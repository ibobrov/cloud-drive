package ru.bobrov.clouddrive.config

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class WebConfig : WebMvcConfigurer {

    override fun addCorsMappings(registry: CorsRegistry) {
        registry.addMapping("/**")
            .allowedOrigins("*") // Разрешить все источники
            .allowedMethods("*") // Разрешить все методы (GET, POST, PUT, DELETE и т.д.)
            .allowedHeaders("*") // Разрешить все заголовки
    }
}
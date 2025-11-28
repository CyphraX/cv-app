package com.philippsaal.cvbackend.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class CvController {

    @GetMapping("/health")
    fun health(): Map<String, String> = mapOf("status" to "UP")

    @GetMapping("/cv")
    fun getCv(): Map<String, Any> = mapOf(
        "name" to "Philipp Saal",
        "title" to "Software Developer",
        "skills" to listOf("Kotlin", "Spring Boot", "Kubernetes", "SvelteKit"),
        "experience" to listOf(
            mapOf(
                "company" to "Example Corp",
                "role" to "Software Developer",
                "period" to "2023 - Present"
            )
        )
    )
}

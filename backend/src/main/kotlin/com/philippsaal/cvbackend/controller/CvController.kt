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
    fun getCv(): CvData = CvData(
        name = "Philipp Saal",
        title = "Java Backend Developer",
        location = "Bernau bei Berlin",
        email = "philipp.saal@proton.me",
        phone = "+49 176 20690117",
        github = "CyphraX",
        profile = "Java Backend Developer mit 4+ Jahren Erfahrung in der Entwicklung skalierbarer Plattform-Architekturen für Kommunalsoftware. Spezialisiert auf API-Design, Infrastruktur-Integration (Elasticsearch, Hazelcast) und technische Modernisierungsprojekte. Starke Affinität für Software-Architektur mit Fokus auf eigenverantwortliche technische Entscheidungsfindung und Dokumentation (ADRs, arc42).",
        skills = SkillCategories(
            coreExpertise = listOf(
                "Java (11–21)",
                "REST API Design",
                "Elasticsearch",
                "MSSQL / Oracle",
                "Platform Architecture"
            ),
            solidKnowledge = listOf(
                "OSGi",
                "Hazelcast",
                "Docker",
                "ADRs & arc42",
                "On-Premise Deployment"
            ),
            exploration = listOf(
                "Spring Boot",
                "Kotlin",
                "Kubernetes",
                "Rust",
                "SvelteKit"
            )
        ),
        experience = listOf(
            Experience(
                company = "HSH-Berlin",
                role = "Java Backend Developer",
                period = "März 2022 - heute",
                type = "Kommunalsoftware",
                highlights = listOf(
                    "Plattform-Entwicklung für 20-40 Fachverfahren",
                    "Elasticsearch-Migration 7.17 → 8.19 mit komplettem Architektur-Refactoring",
                    "Performance-Optimierung: 6 Min → 12 Sek (30x Verbesserung)",
                    "Design einer Meta-Configuration-Lösung für UI-Modernisierung",
                    "Einführung von ADRs und arc42-Dokumentation",
                    "Mentoring von Werkstudenten und Auszubildenden"
                )
            ),
            Experience(
                company = "HSH-Berlin",
                role = "Werkstudent Java Development",
                period = "Oktober 2021 - März 2022",
                type = "Kommunalsoftware",
                highlights = listOf(
                    "Java-Backend-Entwicklung in der Plattform-Abteilung"
                )
            ),
            Experience(
                company = "neofonie",
                role = "Werkstudent Quality Assurance",
                period = "April 2020 - Oktober 2021",
                type = "Projekt-Arbeit",
                highlights = listOf(
                    "Testautomatisierung mit Java Selenium",
                    "Manuelles und automatisiertes Testing von Magnolia-CMS"
                )
            )
        ),
        education = listOf(
            Education(
                institution = "BHT Berlin",
                degree = "Master of Science",
                field = "Medieninformatik",
                period = "geplant ab April 2026",
                note = "Berufsbegleitend (online)"
            ),
            Education(
                institution = "HTW Berlin",
                degree = "Bachelor of Science",
                field = "Angewandte Informatik",
                period = "Abgeschlossen",
                note = null
            )
        ),
        languages = listOf(
            Language("Deutsch", "Muttersprache"),
            Language("Englisch", "Gut")
        )
    )
}

data class CvData(
    val name: String,
    val title: String,
    val location: String,
    val email: String,
    val phone: String,
    val github: String,
    val profile: String,
    val skills: SkillCategories,
    val experience: List<Experience>,
    val education: List<Education>,
    val languages: List<Language>
)

data class SkillCategories(
    val coreExpertise: List<String>,
    val solidKnowledge: List<String>,
    val exploration: List<String>
)

data class Experience(
    val company: String,
    val role: String,
    val period: String,
    val type: String,
    val highlights: List<String>
)

data class Education(
    val institution: String,
    val degree: String,
    val field: String,
    val period: String,
    val note: String?
)

data class Language(
    val language: String,
    val level: String
)

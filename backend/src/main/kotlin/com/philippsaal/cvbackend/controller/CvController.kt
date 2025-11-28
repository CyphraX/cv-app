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
        subtitle = "Richtung Software Architecture",
        location = "Bernau bei Berlin",
        email = "philipp.saal@proton.me",
        github = "CyphraX",
        profile = "Java Backend Developer mit 4+ Jahren Erfahrung in der Entwicklung skalierbarer Plattform-Architekturen für Kommunalsoftware. Spezialisiert auf API-Design, Infrastruktur-Integration (Elasticsearch, Hazelcast) und technische Modernisierungsprojekte. Starke Affinität für Software-Architektur mit Fokus auf eigenverantwortliche technische Entscheidungsfindung, Dokumentation (ADRs, arc42) und kontinuierliche Weiterentwicklung in Richtung Enterprise Architecture.",
        skills = SkillCategories(
            coreExpertise = listOf(
                "Java (11–21)",
                "REST APIs",
                "Elasticsearch",
                "MSSQL / Oracle",
                "API- & Schnittstellendesign"
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
                "Quarkus",
                "Micronaut",
                "Kotlin",
                "Rust",
                "C#",
                "Svelte",
                "Microservices",
                "PostgreSQL",
                "MongoDB"
            )
        ),
        experience = listOf(
            Experience(
                company = "HSH-Berlin",
                role = "Java Backend Developer",
                period = "März 2022 - heute",
                type = "Kommunalsoftware",
                description = "Kernverantwortung: Plattform-Entwicklung für 20-40 Fachverfahren (interne und externe Partnerfirmen)",
                highlights = listOf(
                    "Verantwortlich für die Integration und Bereitstellung von Elasticsearch als zentrale Such- und Indexierungslösung für ~60% aller Fachverfahren",
                    "Durchführung einer komplexen Elasticsearch-Migration von Version 7.17 auf 8.19, inklusive vollständigem Refactoring der Embedded-Node-Architektur auf eine Process-basierte JVM-Management-Lösung",
                    "Eigenständiges Design und Entwicklung einer Meta-Configuration-Lösung für die UI-Modernisierung (Angular): Konzeption eines Bundle-Tracker-Systems zur automatischen Verteilung von UI-Konfigurationen",
                    "Entwicklung einer Abrechnungsschnittstelle (OSGi Service) von Grund auf zur automatischen Distribution an die interne Buchhaltung",
                    "Performance-Optimierung im Kassensystem: Reduktion der Suchzeit für Belege und Tagesabschlüsse von 6 Minuten auf 12 Sekunden (30x Verbesserung)",
                    "Backend-Entwicklung für Angular-basierte UI-Modernisierung: REST-API-Design, Businesslogik für Detailsuche und Datenbereitstellung",
                    "Betreuung der Hazelcast-Integration für Caching-Anforderungen der Plattform",
                    "Initiative zur Etablierung von Architektur-Bewusstsein: Einführung von ADRs und arc42-Dokumentation"
                ),
                leadership = listOf(
                    "Mentoring eines Werkstudenten über 9 Monate",
                    "Vertretender Ansprechpartner für Auszubildende im Entwicklungsteam",
                    "Aktive Teilnahme an technischen Diskussionen und Entscheidungsfindung",
                    "Daily Code Reviews und Koordination mit Fachverfahren-Teams"
                )
            ),
            Experience(
                company = "HSH-Berlin",
                role = "Werkstudent Java Development",
                period = "Oktober 2021 - März 2022",
                type = "Kommunalsoftware",
                description = null,
                highlights = listOf(
                    "Java-Backend-Entwicklung in der Plattform-Abteilung während des Studiums"
                ),
                leadership = null
            ),
            Experience(
                company = "neofonie",
                role = "Werkstudent Quality Assurance",
                period = "April 2020 - Oktober 2021",
                type = "Projekt-Arbeit",
                description = null,
                highlights = listOf(
                    "Manuelles und automatisiertes Testing von Magnolia-CMS-basierten Websites",
                    "Durchführung von Smoke-Tests, Viewport-Prüfungen und Cross-Browser-Kompatibilitätstests",
                    "Entwicklung von Testautomatisierung mit Java Selenium"
                ),
                leadership = null
            )
        ),
        education = listOf(
            Education(
                institution = "BHT Berlin",
                degree = "Master of Science",
                field = "Medieninformatik",
                period = "geplant ab April 2026",
                note = "Berufsbegleitend (online)",
                focus = listOf("Mobile Computing und Sicherheit", "Software und Daten"),
                thesis = null
            ),
            Education(
                institution = "HTW Berlin",
                degree = "Bachelor of Science",
                field = "Angewandte Informatik",
                period = "Abgeschlossen",
                note = null,
                focus = null,
                thesis = "Entwicklung eines benutzerfreundlichen Werkzeugs zur Erstellung von individuellen PDF-Vorlagen für die Komponente „Auswertungen" im Produkt VOIS der HSH"
            )
        ),
        languages = listOf(
            Language("Deutsch", "Muttersprache"),
            Language("Englisch", "Gut", "technische Dokumentation, Blogs, internationale Kommunikation")
        ),
        additionalQualifications = listOf(
            "Eigeninitiative in der kontinuierlichen Weiterbildung zu Software-Architektur-Themen (Blogs, Fachliteratur)",
            "Experimentierfreude mit neuen Technologien und Frameworks (Rust, Kotlin, moderne Java-Frameworks)",
            "Starkes Verständnis für Non-Functional Requirements in On-Premise-Szenarien",
            "Erfahrung mit Code Reviews, technischen Diskussionen und Cross-Team-Koordination"
        )
    )
}

data class CvData(
    val name: String,
    val title: String,
    val subtitle: String?,
    val location: String,
    val email: String,
    val github: String,
    val profile: String,
    val skills: SkillCategories,
    val experience: List<Experience>,
    val education: List<Education>,
    val languages: List<Language>,
    val additionalQualifications: List<String>?
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
    val description: String?,
    val highlights: List<String>,
    val leadership: List<String>?
)

data class Education(
    val institution: String,
    val degree: String,
    val field: String,
    val period: String,
    val note: String?,
    val focus: List<String>?,
    val thesis: String?
)

data class Language(
    val language: String,
    val level: String,
    val details: String? = null
)

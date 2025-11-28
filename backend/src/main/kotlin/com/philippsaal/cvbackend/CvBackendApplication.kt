package com.philippsaal.cvbackend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CvBackendApplication

fun main(args: Array<String>) {
    runApplication<CvBackendApplication>(*args)
}

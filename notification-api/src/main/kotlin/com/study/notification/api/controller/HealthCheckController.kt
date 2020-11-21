package com.study.notification.api.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

/**
 * @author ray
 */
@RestController
class HealthCheckController {

    @GetMapping("/healthy")
    fun check(): String = "healthy"
}

package com.study.notification.api.controller

import com.study.notification.api.service.TopicService
import org.springframework.web.bind.annotation.*

/**
 * @author ray
 *
 * TODO
 */
@RestController
@RequestMapping("/api/v1/topic")
class TopicController(
    private val topicService: TopicService
) {

    // TODO
    @GetMapping("/list")
    fun getAll() {

    }

    // TODO update state for active or inactive
    @PutMapping("/active/{id}")
    fun active(@PathVariable id: Long) {

    }

    // TODO update state for active or inactive
    @PutMapping("/inactive/{id}")
    fun inActive(@PathVariable id: Long) {

    }
}

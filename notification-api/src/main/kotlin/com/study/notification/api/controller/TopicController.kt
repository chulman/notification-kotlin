package com.study.notification.api.controller

import com.study.notification.api.domain.model.Topic
import com.study.notification.api.dto.TopicStatus
import com.study.notification.api.service.TopicService
import org.springframework.web.bind.annotation.*

/**
 * @author ray
 */
@RestController
@RequestMapping("/api/v1/topic")
class TopicController(
    private val topicService: TopicService
) {

    @GetMapping("/list")
    fun getAll():List<Topic> = topicService.getAll()

    @PutMapping("/active/{id}")
    fun active(@PathVariable id: Long)
            = topicService.update(id, TopicStatus.ACTIVE)

    @PutMapping("/inactive/{id}")
    fun inActive(@PathVariable id: Long)
            = topicService.update(id, TopicStatus.INACTIVE)
}

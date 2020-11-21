package com.study.notification.api.controller

import com.study.notification.api.domain.model.Notification
import com.study.notification.api.domain.repository.NotificationRepository
import com.study.notification.common.utils.LoggerDelegate
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * @author ray
 */
@RestController
@RequestMapping("/api/v1/notification")
class NotificationController(
    private val notificationRepository: NotificationRepository
) {

    private val log by LoggerDelegate()

    @PostMapping("/send")
    @Transactional
    fun save(@RequestBody message: String) {
        log.info("notification message = $message")
        notificationRepository.save(Notification(message))
    }
}

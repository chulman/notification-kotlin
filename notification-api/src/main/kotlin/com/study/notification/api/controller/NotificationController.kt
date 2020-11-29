package com.study.notification.api.controller

import com.study.notification.api.dto.SendRequest
import com.study.notification.api.dto.SendResponse
import com.study.notification.api.service.MessageProvider
import com.study.notification.common.utils.LoggerDelegate
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
    private val messageProvider: MessageProvider
) {

    private val log by LoggerDelegate()

    @PostMapping("/send")
    fun send(@RequestBody sendRequest: SendRequest) : SendResponse {
        log.info("notification request = $sendRequest")
        return messageProvider.send(sendRequest.topic, sendRequest.message)
    }
}

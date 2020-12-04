package com.study.notification.api.controller

import com.study.notification.api.dto.SendRequest
import com.study.notification.api.dto.SendResponse
import com.study.notification.api.service.MessageProvider
import com.study.notification.api.service.TopicService
import com.study.notification.common.utils.LoggerDelegate
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.constraints.NotNull

/**
 * @author ray
 */
@RestController
@RequestMapping("/api/v1/notification")
class NotificationController(
    private val messageProvider: MessageProvider,
    private val topicService: TopicService
) {

    private val log by LoggerDelegate()

    @PostMapping("/send")
    fun send(@NotNull @RequestBody sendRequest: SendRequest): SendResponse {

        log.info("notification request = $sendRequest")

        val topic = topicService.find(sendRequest.topic)
            ?: throw RuntimeException("${sendRequest.topic} not found")

        return if (topicService.isActive(topic.status))
            messageProvider.send(topic, sendRequest.message)
        else
            SendResponse(HttpStatus.BAD_REQUEST,
                "${sendRequest.topic} is inActive", ""
            )
    }
}

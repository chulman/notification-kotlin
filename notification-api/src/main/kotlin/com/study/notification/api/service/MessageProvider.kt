package com.study.notification.api.service

import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.Message
import com.google.firebase.messaging.Notification
import com.study.notification.api.domain.model.Topic
import com.study.notification.api.domain.repository.NotificationRepository
import com.study.notification.api.dto.SendResponse
import com.study.notification.common.utils.LoggerDelegate
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 * @author ray
 */
@Service
@Transactional
class MessageProvider(
    val notificationRepository: NotificationRepository
) {

    private val log by LoggerDelegate()

    fun send(topic: Topic, message: String): SendResponse {
        val firebaseMessage = buildMessage(message, topic.topic)

        val messageId = FirebaseMessaging.getInstance()
            .send(firebaseMessage)

        log.info("response from firebase = $messageId")

        notificationRepository.save(
            com.study.notification.api.domain.model.Notification(
                message,
                topic
            )
        )
        return SendResponse(HttpStatus.OK, "success", messageId)
    }

    private fun buildMessage(
        message: String,
        topic: String
    ): Message {
        val notification: Notification = Notification.builder()
            .setBody(message)
            .build()
        return Message.builder()
            .setTopic(topic)
            .setNotification(notification).build()
    }
}

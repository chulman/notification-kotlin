package com.study.notification.api.service

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.Message
import com.google.firebase.messaging.Notification
import com.study.notification.api.domain.repository.NotificationRepository
import com.study.notification.api.dto.SendResponse
import com.study.notification.common.utils.LoggerDelegate
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 * @author ray
 * @deprecated GoogleCredential : modify to Credentials
 */
@Service
@Transactional
class MessageProvider(
    val notificationRepository: NotificationRepository
) {

    private val log by LoggerDelegate()

    fun send(topic: String, message: String): SendResponse {

        val message: Message = buildMessage(message, topic)

        log.info("request message = $message")

        val messageId = FirebaseMessaging.getInstance()
            .send(message)

        // TODO save repository
        // notificationRepository.save()

        // TODO response and advisor
        return SendResponse("", messageId)
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

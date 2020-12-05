package com.study.notification.api.service

import com.google.firebase.messaging.FirebaseMessaging
import com.study.notification.api.domain.model.Notification
import com.study.notification.api.domain.model.Topic
import com.study.notification.api.domain.repository.NotificationRepository
import com.study.notification.api.dto.TopicStatus
import io.mockk.*
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.http.HttpStatus

/**
 * c
 */
@ExtendWith(MockKExtension::class)
class MessageProviderTest {

    private val notificationRepository
            = spyk<NotificationRepository>()

    private val firebaseMockk
            = mockk<FirebaseMessaging>()

    private val messageProvider =
        MessageProvider(notificationRepository)

    @BeforeEach
    fun `setUp`() {
        mockkStatic(FirebaseMessaging::class)
        every {
            FirebaseMessaging.getInstance()
        } returns firebaseMockk
    }

    @Test
    fun `send test`() {
        //given
        val topic = Topic("news", TopicStatus.ACTIVE)
        val message = "test message"
        val notification = Notification(message, topic)

        val messageId = "asd-1111-1234"

        //when
        every {
            notificationRepository.save(notification)
        } returns notification

        every {
            firebaseMockk.send(any())
        } returns messageId

        val sendResponse = messageProvider.send(topic, message)

        //then
        assertEquals(HttpStatus.OK, sendResponse.result)
        assertEquals(messageId, sendResponse.messageId)
    }
}

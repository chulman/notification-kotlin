package com.study.notification.api.config

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential
import com.study.notification.api.domain.repository.NotificationRepository
import com.study.notification.api.service.MessageProvider
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.io.FileInputStream


@Configuration
class FirebaseConfiguration {

    val uri = "https://www.googleapis.com/auth/firebase.messaging"

    /**
     * @deprecated
     */
    @Bean
    fun googleCredential(): GoogleCredential {
        // TODO change file name - 파일 위치는 resource 하위에 두고 설정합니다.
        val fileInputStream = FileInputStream("adminFile")

        return GoogleCredential.fromStream(fileInputStream)
            .createScoped(listOf(uri))
    }

    @Bean
    fun messageProvider(
        notificationRepository: NotificationRepository,
        googleCredential: GoogleCredential
    ): MessageProvider {
        return MessageProvider(notificationRepository, googleCredential)
    }

}

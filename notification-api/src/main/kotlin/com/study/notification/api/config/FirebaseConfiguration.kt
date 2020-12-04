package com.study.notification.api.config

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.ClassPathResource


@Configuration
class FirebaseConfiguration {
    // TODO set real file
    val fileName =  "service-account.json"
    val uri = "https://www.googleapis.com/auth/firebase.messaging"

    /**
     * @deprecated
     */
    @Bean
    fun firebaseInitialize() {
        val fileInputStream =
            ClassPathResource(fileName).inputStream

        val options = FirebaseOptions.Builder()
            .setCredentials(
                GoogleCredentials.fromStream(
                    fileInputStream
                )
            )
            .build()
        FirebaseApp.initializeApp(options)
    }
}

package com.study.notification.api.dto

import org.springframework.http.HttpStatus


data class SendResponse(
    val result:HttpStatus,
    val messageId: String
)

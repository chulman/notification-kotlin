package com.study.notification.api.dto

data class SendRequest(
    val message: String,
    val topic: String
)

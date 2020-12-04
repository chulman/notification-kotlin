package com.study.notification.api.domain.repository

import com.study.notification.api.domain.model.Notification
import com.study.notification.api.domain.model.Topic
import org.springframework.data.jpa.repository.JpaRepository

/**
 * @author ray
 *
 * <pre> notification </pre> project 모든 repository 가 존재합니다.
 */

interface NotificationRepository : JpaRepository<Notification, Long>

interface TopicRepository : JpaRepository<Topic, Long> {
    fun findByTopic(topic: String): Topic?
}

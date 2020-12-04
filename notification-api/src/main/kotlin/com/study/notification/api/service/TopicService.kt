package com.study.notification.api.service

import com.study.notification.api.domain.model.Topic
import com.study.notification.api.domain.repository.TopicRepository
import com.study.notification.api.dto.TopicStatus
import com.study.notification.common.utils.LoggerDelegate
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class TopicService(
    private val topicRepository: TopicRepository
){
    private val log by LoggerDelegate()

    @Transactional(readOnly = true)
    fun find(topicName: String): Topic? {
        val topic = topicRepository.findByTopic(topicName)
        log.info("find topic = $topic name = $topicName")
        return topicRepository.findByTopic(topicName)
    }

    fun isActive(topicStatus: TopicStatus): Boolean {
        return TopicStatus.ACTIVE == topicStatus
    }
}

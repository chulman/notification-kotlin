package com.study.notification.api.domain.repository

import com.study.notification.api.domain.model.Notification
import com.study.notification.api.domain.model.Topic
import com.study.notification.api.dto.TopicStatus
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext
import javax.transaction.Transactional

/**
 * @author ray
 */
@DataJpaTest(showSql = true)
class NotificationRepositoriesTests @Autowired constructor(
    val notificationRepository: NotificationRepository,
    val topicRepository: TopicRepository
) {

    @PersistenceContext
    lateinit var entityManager: EntityManager

    @Test
    @Transactional
    internal fun `find by id test for notification repository`() {
        // given
        val topic = Topic("news", TopicStatus.ACTIVE)
        val message = "test message"
        val notification = Notification(message, topic)
        notificationRepository.save(notification)
        entityManager.flush()

        // when
        val find = notificationRepository.findById(1)
        val findTopic = topicRepository.findById(1)

        println(find.get())
        // then
        assertThat(find.get()).isNotNull
        assertThat(find.get().id).isEqualTo(1)
        assertThat(find.get().message).isEqualTo(message)

        assertThat(findTopic.get()).isNotNull
        assertThat(findTopic.get().id).isEqualTo(1)
        assertThat(findTopic.get().topic).isEqualTo("news")
        assertThat(findTopic.get().status).isEqualTo(TopicStatus.ACTIVE)
    }
}

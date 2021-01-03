package com.study.notification.api.domain.model

import com.study.notification.api.dto.TopicStatus
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated

@Entity
class Topic(
    @Column(name = "topic")
    var topic: String,

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    var status: TopicStatus

) : AuditingEntity() {
    override fun toString(): String {
        return "topic(" +
                "id=$id, " +
                "topic=$topic, " +
                "status=$status)";
    }

    fun updateStatus(status: TopicStatus) {
        this.status = status
    }
}

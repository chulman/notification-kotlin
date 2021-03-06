package com.study.notification.api.domain.model

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import javax.persistence.*

/**
 * @author ray
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
abstract class AuditingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    /** 생성일시  */
    @CreatedDate
    var createdAt: LocalDateTime = LocalDateTime.now()

    /** 수정일시  */
    @LastModifiedDate
    var updatedAt: LocalDateTime = LocalDateTime.now()
}

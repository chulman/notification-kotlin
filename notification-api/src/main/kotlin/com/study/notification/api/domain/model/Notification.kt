package com.study.notification.api.domain.model

import org.hibernate.annotations.DynamicUpdate
import javax.persistence.Column
import javax.persistence.Entity

/**
 * @author ray
 *
 * @see <a href ="https://kotlinlang.org/docs/reference/compiler-plugins.html"> JPA PlugIn </a>
 * @see <a href ="https://woowabros.github.io/experience/2020/05/11/kotlin-hibernate.html"> 우아한 형제들 기술 블로그 </a>
 * @see <a href ="https://docs.jboss.org/hibernate/orm/5.4/userguide/html_single/Hibernate_User_Guide.html#entity"> 하이버네이트 가이드 </a>
 */

//* Entity 를 data class 로 만드는 것은 지양한다.<p>
//* Entity는 반드시 javax.persistence.Entity 어노테이션이 붙어야 한다.<p>
//* <b>Entity는 반드시 public 혹은 protected 의 no-arg 생성자를 가지고 있어야 한다.</b><p>
//* Entity는 반드시 top-level 클래스여야 한다.<p>
//* Entity는 final 클래스일 수 없다.<p>
//* 모든 메소드와 엔티티 내에 영속되는 변수들 또한 final로 지정할 수 없다.<p>
//* 추상 클래스 혹은 구현 클래스 모두 Entity가 될 수 있다.<p>
//* 엔티티는 비-엔티티 객체와 엔티티인 객체 모두 상속할 수 있고, 그 반대도 가능하다.<p>
//* Entity의 상태 값은 JavaBean-style에 부합하는, 인스턴스 변수로 표현된다.<p>
//* 인스턴스 변수는 반드시 entity 자기 자신에 의해서만 접근해야 한다.<p>
@Entity
//@AttributeOverride(name = "id", column = Column(name = "notificationId"))
class Notification(
    @Column(name = "message")
    var message: String
) : AuditingEntity() {
    override fun toString(): String {
        return "Notification(" +
                "id=$id, " +
                "message=$message)"
    }
}

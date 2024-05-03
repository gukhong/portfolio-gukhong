package com.gukhong.portfolio.domain.entity

import jakarta.persistence.*
import java.time.LocalDate

@Entity
class Achievement(title: String,
                  description: String,
                  achievedDate: LocalDate?,
                  host: String,
                  isActive: Boolean
) : BaseEntity() {

    @Id // 이 필드가 PK임을 표시
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK생성 전략 IDENTIRY = 생성을 DB에 위임
    @Column(name = "achievement_id")
    var id: Long? = null

    var title: String = title

    var description: String = description

    var achivedDate: LocalDate? = achievedDate

    var host: String = host

    var isActive: Boolean = isActive



}
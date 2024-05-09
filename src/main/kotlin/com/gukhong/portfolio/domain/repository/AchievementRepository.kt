package com.gukhong.portfolio.domain.repository

import com.gukhong.portfolio.domain.entity.Achievement
import org.springframework.data.jpa.repository.JpaRepository

interface AchievementRepository : JpaRepository<Achievement, Long>{

    // select * from Achievement where is_active = :isActive

    fun findAllByIsActive(isActive: Boolean): List<Achievement>
}
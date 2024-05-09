package com.gukhong.portfolio.domain.repository

import com.gukhong.portfolio.domain.entity.Achievement
import com.gukhong.portfolio.domain.entity.Experience
import org.springframework.data.jpa.repository.JpaRepository

interface ExperienceRepository : JpaRepository<Experience, Long>{

    // select * from Experience where is_active = :isActive

    fun findAllByIsActive(isActive: Boolean): List<Experience>

}
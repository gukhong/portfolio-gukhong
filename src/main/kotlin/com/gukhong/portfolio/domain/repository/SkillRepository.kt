package com.gukhong.portfolio.domain.repository

import com.gukhong.portfolio.domain.entity.Skill
import org.springframework.data.jpa.repository.JpaRepository

interface SkillRepository : JpaRepository<Skill, Long>{


}
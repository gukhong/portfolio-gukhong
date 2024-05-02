package com.gukhong.portfolio.domain.repository

import com.gukhong.portfolio.domain.entity.Achievement
import org.springframework.data.jpa.repository.JpaRepository

interface LinkRepository : JpaRepository<Achievement, Long>
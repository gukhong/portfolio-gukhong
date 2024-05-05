package com.gukhong.portfolio.domain.repository

import com.gukhong.portfolio.domain.entity.Achievement
import com.gukhong.portfolio.domain.entity.Project
import org.springframework.data.jpa.repository.JpaRepository

interface ProjectRepository : JpaRepository<Project, Long>
package com.gukhong.portfolio.presentation.dto

import com.gukhong.portfolio.domain.entity.Introduction

data class IntroductionDTO (
    val content: String
) {
    constructor(introduction: Introduction) : this(
        content = introduction.content
    )

}
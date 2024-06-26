package com.gukhong.portfolio.admin.context.achievement.controller

import com.gukhong.portfolio.admin.context.achievement.service.AdminAchievementService
import com.gukhong.portfolio.admin.data.DateFormElementDTO
import com.gukhong.portfolio.admin.data.FormElementDTO
import com.gukhong.portfolio.admin.data.SelectFormElementDTO
import com.gukhong.portfolio.admin.data.TextFormElementDTO
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.ui.Model

@Controller
@RequestMapping("/admin/achievement")
class AdminAchievementViewController(
    private val adminAchievementService: AdminAchievementService
) {

    @GetMapping
    fun achievement(model: Model): String {
        val formElements = listOf<FormElementDTO>(
            TextFormElementDTO("title", 4),
            TextFormElementDTO("description", 8),
            DateFormElementDTO("achievedDate", 5),
            TextFormElementDTO("host", 5),
            SelectFormElementDTO("isActive", 2, listOf(true.toString(), false.toString()))
        )
        model.addAttribute("formElements", formElements)

        val table = adminAchievementService.getAchievementTable()
        model.addAttribute("table", table)
        model.addAttribute("detailTable", null)

        val pageAttributes = mutableMapOf<String, Any>(
            Pair("menuName", "Resume"),
            Pair("pageName", table.name),
            Pair("editable", true),
            Pair("deletable", false),
            Pair("hasDetails", false),
        )
        model.addAllAttributes(pageAttributes)

        return "admin/page-table"
    }

}
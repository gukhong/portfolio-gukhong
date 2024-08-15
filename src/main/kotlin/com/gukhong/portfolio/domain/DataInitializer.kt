package com.gukhong.portfolio.domain

import com.gukhong.portfolio.domain.constant.SkillType
import com.gukhong.portfolio.domain.entity.*
import com.gukhong.portfolio.domain.repository.*
import jakarta.annotation.PostConstruct
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component
import java.time.LocalDate

@Component
@Profile(value = ["default"])
class DataInitializer(
    private val achievementRepository: AchievementRepository,
    private val experienceRepository: ExperienceRepository,
    private val introductionRepository: IntroductionRepository,
    private val linkRepository: LinkRepository,
    private val projectRepository: ProjectRepository,
    private val skillRepository: SkillRepository,
    private val accountRepository: AccountRepository
) {

    val log = LoggerFactory.getLogger(DataInitializer::class.java)

    @PostConstruct
    fun initializeData() {

        log.info("스프링이 실행되었습니다. 테스트 데이터를 초기화합니다.")

        // achievement 초기화
        val achievements = mutableListOf<Achievement>(
            Achievement(
                title = "경북대학교 대학원 교육학과 교육심리전공 박사과정 수료",
                description = "KCI 등재지 학술논문 3편 게재",
                host = "경북대학교 일반대학원 교육학과",
                achievedDate = LocalDate.of(2018, 2, 28),
                isActive = true
            ),
            Achievement(
                title = "정보처리기사 (필기합격)",
                description = "자료구조, 운영체제, 알고리즘, 데이터베이스 등",
                host = "한국산업인력공단",
                achievedDate = LocalDate.of(2024, 3, 4),
                isActive = true
            )
        )
        achievementRepository.saveAll(achievements)

        // introduction 초기화
        val introductions = mutableListOf<Introduction>(
            Introduction(content = "뽐냄을 위한 지식이 아닌 쓰임을 위한 개발을 추구합니다.", isActive = true),
            Introduction(content = "소통과 참여의 즐거움을 누구보다 잘 알고 있습니다.", isActive = true),
            Introduction(content = "방향이 틀리지 않았다면 언젠가는 원하는 곳에 닿으리라 믿습니다.", isActive = true)
        )
        introductionRepository.saveAll(introductions)

        // link 초기화
        val links = mutableListOf<Link>(
            Link(name = "Github", content = "https://github.com/gukhong", isActive = true),
            Link(name = "Linkedin", content = "https://www.linkedin.com/in/gukhong", isActive = true),
        )
        linkRepository.saveAll(links)

        // experience / experience_detail 초기화
        val experience1 = Experience(
            title = "자바(Java)기반 AWS 클라우드 활용 스마트 웹&앱 서비스 풀스택 개발과정 수료",
            description = "그린컴퓨터아카데미(울산)",
            startYear = 2023,
            startMonth = 10,
            endYear = 2024,
            endMonth = 5,
            isActive = true
        )
        experience1.addDetails(
            mutableListOf(
                ExperienceDetail(content = "html5, css3, Javascript, jQuery를 활용한 웹 표준 화면 구현", isActive = true),
                ExperienceDetail(content = "Java 프로그래밍, JSP 웹 프로그래밍", isActive = true),
                ExperienceDetail(content = "Spring프레임워크, SpringBoot활용", isActive = true),
                ExperienceDetail(content = "AWS 클라우드 활용 백엔드 프로젝트", isActive = true)
            )
        )
        val experience2 = Experience(
            title = "울산북구청소년상담복지센터",
            description = "청소년안전망팀 팀장",
            startYear = 2022,
            startMonth = 3,
            endYear = 2023,
            endMonth = 5,
            isActive = true
        )
        experience2.addDetails(
            mutableListOf(
                ExperienceDetail(content = "청소년/학부모 심리상담 및 교육", isActive = true),
                ExperienceDetail(content = "지역사회 내 청소년안전망사업 총괄", isActive = true),
                ExperienceDetail(content = "고위기청소년 맞춤형 프로그램 총괄", isActive = true)
            )
        )
        experienceRepository.saveAll(mutableListOf(experience1, experience2))

        // skill 초기화
        val java = Skill(name = "Java", type = SkillType.LANGUAGE.name, isActive = true)
        val kotlin = Skill(name = "Kotlin", type = SkillType.LANGUAGE.name, isActive = true)
        val web = Skill(name = "Html,css,Js", type = SkillType.LANGUAGE.name, isActive = true)
        val spring = Skill(name = "Spring", type = SkillType.FRAMEWORK.name, isActive = true)
        val react = Skill(name = "React.js", type = SkillType.FRAMEWORK.name, isActive = true)
        val node = Skill(name = "Node.js", type = SkillType.FRAMEWORK.name, isActive = true)
        val mysql = Skill(name = "MySQL", type = SkillType.DATABASE.name, isActive = true)
        val mongodb = Skill(name = "MongoDB", type = SkillType.DATABASE.name, isActive = true)
        val git = Skill(name = "Git", type = SkillType.TOOL.name, isActive = true)
        val docker = Skill(name = "Docker", type = SkillType.TOOL.name, isActive = true)
        skillRepository.saveAll(mutableListOf(java, kotlin, web, spring, react, node, mysql, mongodb, git, docker))

        // project / project_detail / project_skill 초기화

        val project1 = Project(
            name = "웹 개발자 홍국진 포트폴리오 프로젝트",
            description = "상시 운영되는 이력/포트폴리오 게시 웹 프로젝트.",
            startYear = 2024,
            startMonth = 8,
            endYear = null,
            endMonth = null,
            isActive = true
        )
        project1.addDetails(
            mutableListOf(
                ProjectDetail(content = "Kotlin, SpringBoot등 새로운 개발언어 습득 및 실습", url = null, isActive = true),
                ProjectDetail(content = "Docker를 활용하여 가상 환경에서의 데이터베이스 운용", url = null, isActive = true)
            )
        )
        project1.skills.addAll(
            mutableListOf(
                ProjectSkill(project = project1, skill = kotlin),
                ProjectSkill(project = project1, skill = spring),
                ProjectSkill(project = project1, skill = mysql),
                ProjectSkill(project = project1, skill = docker)
            )
        )
        val project2 = Project(
            name = "ChatGPT를 활용한 운세봐주는 강아지 웹 프로젝트",
            description = "ChatGPT API를 활용한 대화형 웹서비스, 카카오 애드핏을 통한 배너 활용",
            startYear = 2024,
            startMonth = 5,
            endYear = null,
            endMonth = null,
            isActive = true
        )
        project2.addDetails(
            mutableListOf(
                ProjectDetail(content = "Node.js, Express를 통해 ChatGPT API서버와 소통하고 백엔드 서버 구축", url = null, isActive =
                true),
                ProjectDetail(content = "Cloudflare Pages를 통한 프런트엔드, AWS Lambda를 통한 서버리스 백엔드 배포", url = null,
                    isActive =
                true),
                ProjectDetail(content = "운영사이트", url = "https://chatdoge-hong.pages.dev/", isActive = true)
            )
        )
        project2.skills.addAll(
            mutableListOf(
                ProjectSkill(project = project2, skill = react),
                ProjectSkill(project = project2, skill = node),
                ProjectSkill(project = project2, skill = web)
            )
        )
        projectRepository.saveAll(mutableListOf(project1, project2))

        val account = Account(
            loginId = "admin1",
            pw = "\$2a\$10\$fnwOLVR6Zj3KZPMNRpyMsuMZ69jVYOLwZCPMU/oB994t2xsqd9toa"
        )
        accountRepository.save(account)

    }
}
package com.example.androidjavaandkotlindemo.data

/**
 * 进阶功能列表数据
 */
object AdvancedFeaturesData {
    
    fun getAdvancedFeatures(): List<AdvancedFeature> {
        return listOf(
            AdvancedFeature(
                id = "architecture",
                title = "架构设计",
                description = "Android应用架构设计和模式",
                items = listOf(
                    AdvancedFeatureItem("arch_patterns", "架构模式（MVC、MVP、MVVM、MVI、Clean Architecture）"),
                    AdvancedFeatureItem("arch_components", "Android架构组件深入（ViewModel、Repository、UseCase）"),
                    AdvancedFeatureItem("modularization", "模块化架构（单模块vs多模块、模块拆分策略）"),
                    AdvancedFeatureItem("arch_principles", "架构原则（SOLID、DRY、KISS、YAGNI）"),
                    AdvancedFeatureItem("arch_tools", "架构设计工具（UML、架构文档、架构评审）")
                )
            ),
            AdvancedFeature(
                id = "performance",
                title = "性能优化",
                description = "Android应用性能优化",
                items = listOf(
                    AdvancedFeatureItem("startup_opt", "启动性能优化（冷启动、温启动、热启动）"),
                    AdvancedFeatureItem("memory_opt", "内存优化（内存泄漏检测、大对象优化、图片内存优化）"),
                    AdvancedFeatureItem("ui_opt", "UI性能优化（过度绘制、布局层次、RecyclerView优化、Compose优化）"),
                    AdvancedFeatureItem("network_opt", "网络性能优化（请求优化、缓存策略、HTTP/2）"),
                    AdvancedFeatureItem("battery_opt", "电池优化（后台任务优化、定位服务优化、Doze模式适配）"),
                    AdvancedFeatureItem("apk_size", "包体积优化（代码混淆、资源优化、动态功能模块）"),
                    AdvancedFeatureItem("performance_monitor", "性能监控和分析（Android Profiler、Systrace）")
                )
            ),
            AdvancedFeature(
                id = "code_quality",
                title = "代码质量与工程化",
                description = "代码质量和工程化实践",
                items = listOf(
                    AdvancedFeatureItem("design_patterns", "设计模式深入（创建型、结构型、行为型模式）"),
                    AdvancedFeatureItem("code_standards", "代码规范（Kotlin/Java代码规范、命名规范、注释规范）"),
                    AdvancedFeatureItem("code_review", "代码审查（Code Review流程、审查要点）"),
                    AdvancedFeatureItem("refactoring", "重构技术（重构原则、重构时机、重构工具）"),
                    AdvancedFeatureItem("static_analysis", "静态代码分析（Lint、detekt、SonarQube）"),
                    AdvancedFeatureItem("documentation", "文档编写（代码文档、架构文档、API文档）")
                )
            ),
            AdvancedFeature(
                id = "testing",
                title = "测试策略与质量保证",
                description = "Android测试策略",
                items = listOf(
                    AdvancedFeatureItem("test_pyramid", "测试金字塔（单元测试、集成测试、UI测试）"),
                    AdvancedFeatureItem("unit_test", "单元测试（JUnit、Mockito、ViewModel测试、Repository测试）"),
                    AdvancedFeatureItem("integration_test", "集成测试（Room测试、Retrofit测试、端到端测试）"),
                    AdvancedFeatureItem("ui_test", "UI测试（Espresso、Compose UI测试、截图测试）"),
                    AdvancedFeatureItem("test_tools", "测试工具和框架（Robolectric、Truth、Turbine）"),
                    AdvancedFeatureItem("test_strategy", "测试策略（测试计划、测试用例设计、持续测试）")
                )
            ),
            AdvancedFeature(
                id = "cicd",
                title = "CI/CD持续集成部署",
                description = "持续集成和持续部署",
                items = listOf(
                    AdvancedFeatureItem("cicd_basic", "CI/CD基础（持续集成、持续部署概念）"),
                    AdvancedFeatureItem("git_workflow", "Git工作流（Git Flow、GitHub Flow、分支策略）"),
                    AdvancedFeatureItem("cicd_tools", "CI/CD工具（GitHub Actions、GitLab CI、Jenkins、Fastlane）"),
                    AdvancedFeatureItem("auto_build", "自动化构建（构建脚本、构建变体、签名配置）"),
                    AdvancedFeatureItem("auto_test", "自动化测试集成（测试报告、测试失败处理）"),
                    AdvancedFeatureItem("auto_deploy", "自动化部署（内测发布、生产发布、应用商店上传）")
                )
            ),
            AdvancedFeature(
                id = "security",
                title = "安全性深入",
                description = "Android应用安全",
                items = listOf(
                    AdvancedFeatureItem("data_security", "数据安全（数据加密、密钥管理、安全存储）"),
                    AdvancedFeatureItem("network_security", "网络安全（HTTPS、证书锁定、网络安全配置）"),
                    AdvancedFeatureItem("code_security", "代码安全（代码混淆、反编译防护、代码签名）"),
                    AdvancedFeatureItem("app_security", "应用安全（权限最小化、安全的数据传输、应用加固）"),
                    AdvancedFeatureItem("user_privacy", "用户隐私（隐私政策、数据保护、GDPR、CCPA）")
                )
            ),
            AdvancedFeature(
                id = "monitoring",
                title = "监控与分析",
                description = "应用监控和数据分析",
                items = listOf(
                    AdvancedFeatureItem("crash_monitoring", "崩溃监控（Firebase Crashlytics、Bugsnag、Sentry）"),
                    AdvancedFeatureItem("performance_monitoring", "性能监控（Firebase Performance、自定义指标）"),
                    AdvancedFeatureItem("user_analytics", "用户行为分析（Firebase Analytics、事件埋点、用户画像）"),
                    AdvancedFeatureItem("realtime_monitor", "实时监控（实时日志、实时性能、告警系统）"),
                    AdvancedFeatureItem("ab_testing", "A/B测试（A/B测试框架、实验设计）")
                )
            ),
            AdvancedFeature(
                id = "team_collaboration",
                title = "团队协作与流程",
                description = "团队协作和项目管理",
                items = listOf(
                    AdvancedFeatureItem("project_management", "项目管理（敏捷开发、任务管理工具、需求分析）"),
                    AdvancedFeatureItem("team_collaboration", "团队协作（代码审查、技术分享、知识管理）"),
                    AdvancedFeatureItem("version_management", "版本管理（版本号规范、发布计划、回滚策略）"),
                    AdvancedFeatureItem("documentation_management", "文档管理（技术文档、API文档、开发指南）")
                )
            ),
            AdvancedFeature(
                id = "new_tech",
                title = "新技术与趋势",
                description = "跟踪新技术和趋势",
                items = listOf(
                    AdvancedFeatureItem("tech_tracking", "新技术跟踪（Android新版本、Jetpack新组件、Kotlin新特性）"),
                    AdvancedFeatureItem("tech_evaluation", "新技术评估（技术选型、技术风险评估、技术迁移策略）"),
                    AdvancedFeatureItem("tech_research", "技术预研（技术预研流程、POC、技术方案验证）"),
                    AdvancedFeatureItem("tech_community", "技术社区参与（技术博客、开源贡献、技术会议）")
                )
            ),
            AdvancedFeature(
                id = "business",
                title = "业务理解与产品思维",
                description = "业务理解和产品思维",
                items = listOf(
                    AdvancedFeatureItem("business_understanding", "业务理解（业务领域知识、业务流程分析）"),
                    AdvancedFeatureItem("product_thinking", "产品思维（用户体验设计、用户需求分析、产品迭代）"),
                    AdvancedFeatureItem("data_driven", "数据驱动（数据分析能力、数据驱动决策、指标定义）"),
                    AdvancedFeatureItem("tech_business_value", "技术商业价值（技术方案成本评估、技术投入产出分析）")
                )
            ),
            AdvancedFeature(
                id = "system_deep",
                title = "系统底层与原理",
                description = "Android系统底层原理",
                items = listOf(
                    AdvancedFeatureItem("android_arch_deep", "Android系统架构深入（启动流程、AMS、Binder IPC）"),
                    AdvancedFeatureItem("jvm_art", "JVM和ART（JVM内存模型、垃圾回收、ART编译原理）"),
                    AdvancedFeatureItem("performance_principle", "性能优化原理（内存管理、渲染原理、网络协议）"),
                    AdvancedFeatureItem("system_api", "系统API深入（系统服务、Framework层理解）")
                )
            ),
            AdvancedFeature(
                id = "cross_platform",
                title = "跨平台技术",
                description = "跨平台开发技术",
                items = listOf(
                    AdvancedFeatureItem("cross_platform_overview", "跨平台技术概述（技术对比、技术选型）"),
                    AdvancedFeatureItem("kmm", "Kotlin Multiplatform（KMM架构、共享代码、平台特定实现）"),
                    AdvancedFeatureItem("flutter", "Flutter（基础了解、Flutter vs Native）"),
                    AdvancedFeatureItem("react_native", "React Native（基础了解、原生模块开发）"),
                    AdvancedFeatureItem("cross_platform_strategy", "跨平台开发策略（何时选择跨平台、混合开发方案）")
                )
            )
        )
    }
}


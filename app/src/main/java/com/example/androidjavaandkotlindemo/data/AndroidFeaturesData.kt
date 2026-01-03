package com.example.androidjavaandkotlindemo.data

/**
 * Android功能列表数据
 */
object AndroidFeaturesData {
    
    fun getAndroidFeatures(): List<AndroidFeature> {
        return listOf(
            AndroidFeature(
                id = "basic_arch",
                title = "Android基础架构",
                description = "Android系统架构和应用基础",
                items = listOf(
                    AndroidFeatureItem("system_arch", "Android系统分层架构"),
                    AndroidFeatureItem("app_basics", "应用基础知识（包名、签名、版本）"),
                    AndroidFeatureItem("gradle", "Gradle构建系统")
                )
            ),
            AndroidFeature(
                id = "activity_fragment",
                title = "Activity和Fragment",
                description = "Android核心组件",
                items = listOf(
                    AndroidFeatureItem("activity_basic", "Activity生命周期、启动模式、Intent"),
                    AndroidFeatureItem("fragment_basic", "Fragment生命周期、Fragment事务"),
                    AndroidFeatureItem("activity_fragment_advanced", "Activity和Fragment高级特性")
                )
            ),
            AndroidFeature(
                id = "ui_basic",
                title = "UI开发基础",
                description = "Android UI开发",
                items = listOf(
                    AndroidFeatureItem("view_system", "View系统、自定义View、事件分发"),
                    AndroidFeatureItem("layouts", "布局（LinearLayout、RelativeLayout、ConstraintLayout）"),
                    AndroidFeatureItem("ui_components", "常用UI组件（TextView、Button、RecyclerView等）"),
                    AndroidFeatureItem("material_design", "Material Design、Material Components"),
                    AndroidFeatureItem("resources", "资源管理（资源类型、资源限定符）")
                )
            ),
            AndroidFeature(
                id = "compose",
                title = "Jetpack Compose",
                description = "现代声明式UI框架",
                items = listOf(
                    AndroidFeatureItem("compose_basic", "Compose基础（声明式UI、@Composable函数、重组）"),
                    AndroidFeatureItem("compose_layout", "Compose布局（Column、Row、Box、Modifier）"),
                    AndroidFeatureItem("compose_material", "Material 3组件、主题系统"),
                    AndroidFeatureItem("compose_state", "状态管理（State、StateFlow、ViewModel集成）"),
                    AndroidFeatureItem("compose_navigation", "Compose导航（Navigation Compose）"),
                    AndroidFeatureItem("compose_animation", "Compose动画"),
                    AndroidFeatureItem("compose_advanced", "Compose高级特性（性能优化、自定义绘制）")
                )
            ),
            AndroidFeature(
                id = "data_storage",
                title = "数据存储",
                description = "Android数据持久化",
                items = listOf(
                    AndroidFeatureItem("shared_prefs", "SharedPreferences"),
                    AndroidFeatureItem("datastore", "DataStore（Preferences DataStore、Proto DataStore）"),
                    AndroidFeatureItem("room", "Room数据库（Entity、DAO、Database、迁移）"),
                    AndroidFeatureItem("file_storage", "文件存储（内部存储、外部存储、Scoped Storage）"),
                    AndroidFeatureItem("content_provider", "内容提供者（ContentProvider）")
                )
            ),
            AndroidFeature(
                id = "networking",
                title = "网络请求",
                description = "Android网络编程",
                items = listOf(
                    AndroidFeatureItem("http_basic", "HTTP基础"),
                    AndroidFeatureItem("retrofit", "Retrofit配置和使用"),
                    AndroidFeatureItem("okhttp", "OkHttp配置和拦截器"),
                    AndroidFeatureItem("data_parsing", "数据解析（JSON、XML、Protobuf）"),
                    AndroidFeatureItem("networking_best", "网络最佳实践")
                )
            ),
            AndroidFeature(
                id = "architecture",
                title = "架构组件",
                description = "Android Architecture Components",
                items = listOf(
                    AndroidFeatureItem("viewmodel", "ViewModel（生命周期、状态管理）"),
                    AndroidFeatureItem("livedata", "LiveData（观察、转换）"),
                    AndroidFeatureItem("data_binding", "数据绑定（Data Binding）"),
                    AndroidFeatureItem("view_binding", "视图绑定（View Binding）"),
                    AndroidFeatureItem("lifecycle", "生命周期感知组件")
                )
            ),
            AndroidFeature(
                id = "dependency_injection",
                title = "依赖注入",
                description = "Android依赖注入框架",
                items = listOf(
                    AndroidFeatureItem("di_concept", "依赖注入概念"),
                    AndroidFeatureItem("hilt", "Hilt（配置、模块、注入）"),
                    AndroidFeatureItem("dagger", "Dagger基础"),
                    AndroidFeatureItem("koin", "Koin（Kotlin原生DI框架）")
                )
            ),
            AndroidFeature(
                id = "navigation",
                title = "导航",
                description = "Android导航组件",
                items = listOf(
                    AndroidFeatureItem("navigation_basic", "Navigation Component基础"),
                    AndroidFeatureItem("navigation_compose", "Navigation Compose"),
                    AndroidFeatureItem("navigation_advanced", "导航高级特性（参数传递、深层链接）")
                )
            ),
            AndroidFeature(
                id = "background_tasks",
                title = "后台任务",
                description = "Android后台任务处理",
                items = listOf(
                    AndroidFeatureItem("thread_handler", "线程和Handler"),
                    AndroidFeatureItem("coroutines_android", "协程在Android中的应用"),
                    AndroidFeatureItem("workmanager", "WorkManager（Worker、WorkRequest、工作链）"),
                    AndroidFeatureItem("jobscheduler", "JobScheduler和AlarmManager")
                )
            ),
            AndroidFeature(
                id = "permissions",
                title = "权限管理",
                description = "Android权限系统",
                items = listOf(
                    AndroidFeatureItem("permission_system", "权限系统（普通权限、危险权限）"),
                    AndroidFeatureItem("permission_request", "权限请求（运行时权限）"),
                    AndroidFeatureItem("common_permissions", "常见权限（存储、相机、位置等）")
                )
            ),
            AndroidFeature(
                id = "multimedia",
                title = "多媒体开发",
                description = "Android多媒体功能",
                items = listOf(
                    AndroidFeatureItem("camera", "相机（Camera2、CameraX）"),
                    AndroidFeatureItem("image_processing", "图片处理（Glide、Coil、图片压缩）"),
                    AndroidFeatureItem("audio_video", "音频和视频（MediaPlayer、ExoPlayer）")
                )
            ),
            AndroidFeature(
                id = "notifications",
                title = "通知系统",
                description = "Android通知",
                items = listOf(
                    AndroidFeatureItem("notification_basic", "通知基础（NotificationManager、NotificationChannel）"),
                    AndroidFeatureItem("notification_advanced", "通知高级特性（操作、分组、优先级）")
                )
            ),
            AndroidFeature(
                id = "lifecycle",
                title = "应用生命周期",
                description = "Android应用生命周期",
                items = listOf(
                    AndroidFeatureItem("application", "Application类、进程生命周期"),
                    AndroidFeatureItem("memory_management", "内存管理、内存泄漏检测")
                )
            ),
            AndroidFeature(
                id = "performance",
                title = "性能优化",
                description = "Android性能优化",
                items = listOf(
                    AndroidFeatureItem("startup_opt", "启动性能优化"),
                    AndroidFeatureItem("memory_opt", "内存优化"),
                    AndroidFeatureItem("ui_opt", "UI性能优化"),
                    AndroidFeatureItem("network_opt", "网络性能优化"),
                    AndroidFeatureItem("battery_opt", "电池优化"),
                    AndroidFeatureItem("apk_size", "包体积优化")
                )
            ),
            AndroidFeature(
                id = "security",
                title = "安全性",
                description = "Android安全",
                items = listOf(
                    AndroidFeatureItem("data_security", "数据安全（加密、密钥管理）"),
                    AndroidFeatureItem("network_security", "网络安全（HTTPS、证书锁定）"),
                    AndroidFeatureItem("code_security", "代码安全（代码混淆、代码签名）"),
                    AndroidFeatureItem("app_security", "应用安全、用户隐私")
                )
            ),
            AndroidFeature(
                id = "testing",
                title = "测试",
                description = "Android测试",
                items = listOf(
                    AndroidFeatureItem("unit_test", "单元测试（JUnit、Mockito）"),
                    AndroidFeatureItem("integration_test", "集成测试"),
                    AndroidFeatureItem("ui_test", "UI测试（Espresso、Compose UI测试）")
                )
            ),
            AndroidFeature(
                id = "publishing",
                title = "发布和分发",
                description = "应用发布",
                items = listOf(
                    AndroidFeatureItem("packaging", "应用打包（APK、AAB、签名）"),
                    AndroidFeatureItem("play_publish", "Google Play发布"),
                    AndroidFeatureItem("analytics", "应用分析（Firebase Analytics、崩溃报告）")
                )
            )
        )
    }
}


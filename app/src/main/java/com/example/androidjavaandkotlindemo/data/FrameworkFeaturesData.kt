package com.example.androidjavaandkotlindemo.data

/**
 * Framework功能列表数据
 */
object FrameworkFeaturesData {
    
    fun getFrameworkFeatures(): List<FrameworkFeature> {
        return listOf(
            FrameworkFeature(
                id = "compose",
                title = "Jetpack Compose",
                description = "现代声明式UI框架",
                items = listOf(
                    FrameworkFeatureItem("compose_concept", "Compose基础概念（声明式UI、重组机制）"),
                    FrameworkFeatureItem("compose_layout", "Compose布局系统（Column、Row、Box、LazyColumn）"),
                    FrameworkFeatureItem("material3", "Material 3组件"),
                    FrameworkFeatureItem("compose_state", "Compose状态管理（State、StateFlow）"),
                    FrameworkFeatureItem("compose_navigation", "Compose导航"),
                    FrameworkFeatureItem("compose_animation", "Compose动画"),
                    FrameworkFeatureItem("compose_advanced", "Compose高级特性")
                )
            ),
            FrameworkFeature(
                id = "hilt",
                title = "Hilt依赖注入",
                description = "Android依赖注入框架",
                items = listOf(
                    FrameworkFeatureItem("hilt_basic", "Hilt基础（@HiltAndroidApp、@AndroidEntryPoint）"),
                    FrameworkFeatureItem("hilt_modules", "Hilt模块（@Module、@Provides、@InstallIn）"),
                    FrameworkFeatureItem("hilt_injection", "Hilt注入（构造函数注入、字段注入）"),
                    FrameworkFeatureItem("hilt_qualifiers", "Hilt限定符"),
                    FrameworkFeatureItem("hilt_scopes", "Hilt作用域（@Singleton等）"),
                    FrameworkFeatureItem("hilt_best", "Hilt最佳实践")
                )
            ),
            FrameworkFeature(
                id = "room",
                title = "Room数据库",
                description = "SQLite数据库抽象层",
                items = listOf(
                    FrameworkFeatureItem("room_basic", "Room基础（Entity、DAO、Database）"),
                    FrameworkFeatureItem("room_entity", "Entity实体类（@Entity、@PrimaryKey）"),
                    FrameworkFeatureItem("room_dao", "DAO数据访问对象（@Query、@Insert、@Update、@Delete）"),
                    FrameworkFeatureItem("room_database", "Database数据库类、版本管理"),
                    FrameworkFeatureItem("room_advanced", "Room高级特性（关系、类型转换器、Flow集成）"),
                    FrameworkFeatureItem("room_performance", "Room性能优化")
                )
            ),
            FrameworkFeature(
                id = "navigation",
                title = "Navigation组件",
                description = "Android导航框架",
                items = listOf(
                    FrameworkFeatureItem("navigation_basic", "Navigation基础（导航图、NavController）"),
                    FrameworkFeatureItem("navigation_compose", "Navigation Compose"),
                    FrameworkFeatureItem("navigation_advanced", "导航高级特性（参数传递、深层链接）"),
                    FrameworkFeatureItem("navigation_hilt", "Navigation与Hilt集成")
                )
            ),
            FrameworkFeature(
                id = "retrofit",
                title = "Retrofit网络框架",
                description = "类型安全的HTTP客户端",
                items = listOf(
                    FrameworkFeatureItem("retrofit_basic", "Retrofit基础（配置、Builder）"),
                    FrameworkFeatureItem("retrofit_api", "API接口定义（@GET、@POST、@Path、@Query）"),
                    FrameworkFeatureItem("retrofit_converters", "Retrofit转换器（Gson、Moshi）"),
                    FrameworkFeatureItem("retrofit_interceptors", "Retrofit拦截器"),
                    FrameworkFeatureItem("retrofit_coroutines", "Retrofit与协程"),
                    FrameworkFeatureItem("retrofit_best", "Retrofit最佳实践")
                )
            ),
            FrameworkFeature(
                id = "okhttp",
                title = "OkHttp HTTP客户端",
                description = "高效的HTTP客户端",
                items = listOf(
                    FrameworkFeatureItem("okhttp_basic", "OkHttp基础（Request、Response、Call）"),
                    FrameworkFeatureItem("okhttp_interceptors", "OkHttp拦截器（应用拦截器、网络拦截器）"),
                    FrameworkFeatureItem("okhttp_cache", "OkHttp缓存"),
                    FrameworkFeatureItem("okhttp_connection", "连接管理（连接池、超时配置）"),
                    FrameworkFeatureItem("okhttp_retrofit", "OkHttp与Retrofit集成")
                )
            ),
            FrameworkFeature(
                id = "datastore",
                title = "DataStore数据存储",
                description = "现代化数据存储方案",
                items = listOf(
                    FrameworkFeatureItem("datastore_basic", "DataStore基础（Preferences DataStore、Proto DataStore）"),
                    FrameworkFeatureItem("datastore_preferences", "Preferences DataStore使用"),
                    FrameworkFeatureItem("datastore_proto", "Proto DataStore使用"),
                    FrameworkFeatureItem("datastore_migration", "DataStore迁移"),
                    FrameworkFeatureItem("datastore_flow", "DataStore与Flow集成")
                )
            ),
            FrameworkFeature(
                id = "workmanager",
                title = "WorkManager后台任务",
                description = "可靠的后台任务调度",
                items = listOf(
                    FrameworkFeatureItem("workmanager_basic", "WorkManager基础（Worker、WorkRequest）"),
                    FrameworkFeatureItem("worker_types", "Worker类型（Worker、CoroutineWorker）"),
                    FrameworkFeatureItem("work_requests", "工作请求类型（一次性、周期性、约束）"),
                    FrameworkFeatureItem("work_chains", "工作链和组合"),
                    FrameworkFeatureItem("work_status", "工作状态和观察"),
                    FrameworkFeatureItem("workmanager_best", "WorkManager最佳实践")
                )
            ),
            FrameworkFeature(
                id = "camerax",
                title = "CameraX相机框架",
                description = "相机API框架",
                items = listOf(
                    FrameworkFeatureItem("camerax_basic", "CameraX基础（Preview、ImageCapture、ImageAnalysis）"),
                    FrameworkFeatureItem("camerax_usecases", "CameraX用例"),
                    FrameworkFeatureItem("camerax_lifecycle", "CameraX生命周期绑定"),
                    FrameworkFeatureItem("camerax_advanced", "CameraX高级特性"),
                    FrameworkFeatureItem("camerax_best", "CameraX最佳实践")
                )
            ),
            FrameworkFeature(
                id = "paging",
                title = "Paging分页库",
                description = "分页数据加载",
                items = listOf(
                    FrameworkFeatureItem("paging_basic", "Paging基础（PagingData、Pager、PagingSource）"),
                    FrameworkFeatureItem("paging_datasource", "数据源类型（RemoteMediator、PagingSource）"),
                    FrameworkFeatureItem("paging_ui", "Paging与UI集成（RecyclerView、Compose）"),
                    FrameworkFeatureItem("paging_advanced", "Paging高级特性")
                )
            ),
            FrameworkFeature(
                id = "viewmodel_livedata",
                title = "ViewModel和LiveData",
                description = "Android架构组件",
                items = listOf(
                    FrameworkFeatureItem("viewmodel", "ViewModel（生命周期、创建、作用域）"),
                    FrameworkFeatureItem("livedata", "LiveData（观察、转换、MediatorLiveData）"),
                    FrameworkFeatureItem("viewmodel_livedata", "ViewModel与LiveData集成")
                )
            ),
            FrameworkFeature(
                id = "coroutines",
                title = "Kotlin协程框架",
                description = "协程在Android中的应用",
                items = listOf(
                    FrameworkFeatureItem("coroutines_android", "协程基础（viewModelScope、lifecycleScope、Dispatchers）"),
                    FrameworkFeatureItem("coroutines_integration", "协程与Android组件集成（Room、Retrofit、WorkManager）"),
                    FrameworkFeatureItem("flow_android", "Flow在Android中的应用（StateFlow、SharedFlow）")
                )
            ),
            FrameworkFeature(
                id = "coil",
                title = "Coil图片加载",
                description = "Kotlin协程图片加载库",
                items = listOf(
                    FrameworkFeatureItem("coil_basic", "Coil基础（ImageLoader、基本加载）"),
                    FrameworkFeatureItem("coil_advanced", "Coil高级特性（转换、缓存）"),
                    FrameworkFeatureItem("coil_compose", "Coil与Compose集成")
                )
            ),
            FrameworkFeature(
                id = "material",
                title = "Material Design组件",
                description = "Material Design组件库",
                items = listOf(
                    FrameworkFeatureItem("material_basic", "Material Components基础"),
                    FrameworkFeatureItem("material_view", "Material Components（View系统）"),
                    FrameworkFeatureItem("material_compose", "Material Components（Compose）")
                )
            ),
            FrameworkFeature(
                id = "gradle",
                title = "Gradle构建框架",
                description = "Android构建系统",
                items = listOf(
                    FrameworkFeatureItem("gradle_basic", "Gradle基础（build.gradle、插件、任务）"),
                    FrameworkFeatureItem("agp", "Android Gradle Plugin（构建变体、构建类型）"),
                    FrameworkFeatureItem("dependency_management", "依赖管理（版本目录、依赖解析）"),
                    FrameworkFeatureItem("gradle_kotlin_dsl", "Gradle Kotlin DSL")
                )
            ),
            FrameworkFeature(
                id = "ksp",
                title = "KSP注解处理",
                description = "Kotlin符号处理",
                items = listOf(
                    FrameworkFeatureItem("ksp_basic", "KSP基础（KSP vs KAPT、配置）"),
                    FrameworkFeatureItem("ksp_usage", "KSP使用场景（Room、Hilt、自定义注解处理）")
                )
            ),
            FrameworkFeature(
                id = "other_jetpack",
                title = "其他Jetpack组件",
                description = "其他Jetpack组件",
                items = listOf(
                    FrameworkFeatureItem("data_binding", "Data Binding"),
                    FrameworkFeatureItem("view_binding", "View Binding"),
                    FrameworkFeatureItem("app_startup", "App Startup"),
                    FrameworkFeatureItem("security", "Security（EncryptedSharedPreferences）")
                )
            ),
            FrameworkFeature(
                id = "third_party",
                title = "第三方框架集成",
                description = "常用第三方框架",
                items = listOf(
                    FrameworkFeatureItem("image_libs", "图片处理框架（Glide、Picasso、Coil）"),
                    FrameworkFeatureItem("json_libs", "JSON解析框架（Gson、Moshi、Jackson）"),
                    FrameworkFeatureItem("log_libs", "日志框架（Timber、Logger）"),
                    FrameworkFeatureItem("database_libs", "数据库框架（Room、Realm、GreenDAO）"),
                    FrameworkFeatureItem("event_bus", "事件总线（EventBus、RxBus、Kotlin Flow）")
                )
            )
        )
    }
}


package com.example.androidjavaandkotlindemo.data

/**
 * Android模块详情数据仓库
 * 专门存储Android模块的详细学习内容
 * 使用Repository模式，便于后续扩展（如从网络或数据库加载）
 */
object AndroidDetailRepository {
    
    /**
     * 根据知识点ID获取Android详情
     * @param id 知识点ID（对应AndroidFeatureItem的id）
     * @return KnowledgeDetail对象，如果未找到则返回null
     */
    fun getAndroidDetail(id: String): KnowledgeDetail? {
        return allAndroidDetails.find { it.id == id }
    }
    
    /**
     * 获取所有Android详情列表
     */
    fun getAllAndroidDetails(): List<KnowledgeDetail> {
        return allAndroidDetails
    }
    
    /**
     * 所有Android模块的详细学习内容
     */
    private val allAndroidDetails = listOf(
        // ========== Android基础架构 ==========
        
        KnowledgeDetail(
            id = "system_arch",
            title = "Android系统分层架构",
            overview = "Android系统采用分层架构设计，从底层到上层包括Linux内核层、硬件抽象层、Android Runtime、原生库、Java API框架和应用层。理解这个架构有助于深入理解Android系统的工作原理。",
            keyPoints = listOf(
                "Linux内核层：提供底层硬件驱动、进程管理、内存管理等核心功能",
                "硬件抽象层（HAL）：为上层提供统一的硬件访问接口，屏蔽硬件差异",
                "Android Runtime（ART）：执行Android应用的运行时环境，负责字节码编译和垃圾回收",
                "原生C/C++库：提供系统级功能，如SQLite、WebKit、OpenGL等",
                "Java API框架：提供应用开发所需的各种API，如Activity、Service、ContentProvider等",
                "系统应用层：包含系统自带应用和第三方应用"
            ),
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：理解Android系统架构层次",
                    code = """
                        // Android系统架构（从下到上）：
                        // 
                        // 1. Linux内核层
                        //    - 进程管理、内存管理
                        //    - 设备驱动（显示、音频、相机等）
                        //    - 电源管理、网络协议栈
                        // 
                        // 2. 硬件抽象层（HAL）
                        //    - 为上层提供统一的硬件接口
                        //    - 例如：Camera HAL、Audio HAL
                        // 
                        // 3. Android Runtime（ART）
                        //    - 执行.dex文件（Dalvik字节码）
                        //    - AOT（Ahead-Of-Time）编译
                        //    - 垃圾回收（GC）
                        // 
                        // 4. 原生C/C++库
                        //    - SQLite：数据库
                        //    - WebKit：浏览器引擎
                        //    - OpenGL ES：图形渲染
                        //    - Media Framework：多媒体处理
                        // 
                        // 5. Java API框架
                        //    - Activity Manager：管理Activity生命周期
                        //    - Content Providers：数据共享
                        //    - View System：UI系统
                        //    - Resource Manager：资源管理
                        // 
                        // 6. 系统应用层
                        //    - 系统应用（设置、电话、短信等）
                        //    - 第三方应用
                    """.trimIndent(),
                    explanation = "Android系统采用分层架构，每一层都有明确的职责，上层依赖下层提供的服务。这种设计使得系统具有良好的可维护性和可扩展性。"
                )
            ),
            useCases = listOf(
                "系统优化：理解架构有助于优化应用性能，选择合适的API层级",
                "问题排查：当遇到系统级问题时，可以定位到具体的架构层",
                "NDK开发：需要调用原生库时，了解架构有助于理解JNI调用流程",
                "系统定制：ROM开发需要深入理解各层架构",
                "性能分析：理解ART运行时有助于优化应用启动速度和内存使用"
            ),
            notes = listOf(
                "不同Android版本的架构可能有细微差异，需要关注版本变化",
                "NDK开发时需要注意不同架构（arm64-v8a、armeabi-v7a、x86等）的兼容性",
                "ART在Android 5.0（API 21）后替代了Dalvik虚拟机",
                "理解架构有助于选择合适的API，避免使用过时的API"
            ),
            practiceTips = "建议通过阅读Android源码、使用系统工具（如adb、logcat）来深入理解系统架构。可以尝试编写简单的NDK应用来体验原生库的使用。"
        ),
        
        KnowledgeDetail(
            id = "app_basics",
            title = "应用基础知识（包名、签名、版本）",
            overview = "Android应用的基础配置包括包名、应用签名、版本信息等。这些配置在AndroidManifest.xml中定义，是应用的身份标识和发布基础。",
            keyPoints = listOf(
                "包名（Package Name）：应用的唯一标识符，必须唯一，通常使用反向域名格式",
                "应用签名：用于验证应用的身份和完整性，发布应用必须使用签名",
                "版本号：Version Code（整数，用于版本比较）和Version Name（字符串，用户可见）",
                "最小SDK（minSdkVersion）：应用支持的最低Android版本",
                "目标SDK（targetSdkVersion）：应用针对的Android版本，影响API行为",
                "权限声明：应用需要的系统权限必须在AndroidManifest.xml中声明"
            ),
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：AndroidManifest.xml基础配置",
                    code = """
                        <?xml version="1.0" encoding="utf-8"?>
                        <manifest xmlns:android="http://schemas.android.com/apk/res/android"
                            package="com.example.myapp">  <!-- 包名 -->
                            
                            <!-- 应用基本信息 -->
                            <application
                                android:allowBackup="true"
                                android:icon="@mipmap/ic_launcher"
                                android:label="@string/app_name"
                                android:theme="@style/Theme.MyApp">
                                
                                <!-- 主Activity -->
                                <activity
                                    android:name=".MainActivity"
                                    android:exported="true">
                                    <intent-filter>
                                        <action android:name="android.intent.action.MAIN" />
                                        <category android:name="android.intent.category.LAUNCHER" />
                                    </intent-filter>
                                </activity>
                            </application>
                            
                            <!-- 权限声明 -->
                            <uses-permission android:name="android.permission.INTERNET" />
                            <uses-permission android:name="android.permission.CAMERA" />
                            
                        </manifest>
                    """.trimIndent(),
                    explanation = "AndroidManifest.xml是应用的配置文件，定义了包名、组件、权限等关键信息。package属性是应用的唯一标识。"
                ),
                CodeExample(
                    title = "示例2：build.gradle中的版本配置",
                    code = """
                        android {
                            namespace 'com.example.myapp'
                            
                            defaultConfig {
                                applicationId "com.example.myapp"  // 应用ID（可以与包名不同）
                                minSdkVersion 24                  // 最小支持Android 7.0
                                targetSdkVersion 34               // 针对Android 14
                                versionCode 1                     // 版本号（整数，递增）
                                versionName "1.0.0"               // 版本名称（用户可见）
                            }
                            
                            // 签名配置
                            signingConfigs {
                                release {
                                    storeFile file('keystore.jks')
                                    storePassword 'your_store_password'
                                    keyAlias 'your_key_alias'
                                    keyPassword 'your_key_password'
                                }
                            }
                            
                            buildTypes {
                                release {
                                    signingConfig signingConfigs.release
                                    minifyEnabled true
                                    proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
                                }
                            }
                        }
                    """.trimIndent(),
                    explanation = "build.gradle中配置了应用的版本信息和签名配置。versionCode用于版本比较，每次发布必须递增。"
                )
            ),
            useCases = listOf(
                "应用发布：配置正确的包名、版本号和签名是发布应用的前提",
                "版本管理：通过versionCode管理应用版本，实现自动更新",
                "多包名：使用applicationId实现同一代码库发布多个应用（如免费版和付费版）",
                "权限管理：正确声明权限，避免运行时权限请求失败",
                "兼容性：合理设置minSdkVersion和targetSdkVersion，平衡兼容性和新特性"
            ),
            notes = listOf(
                "包名一旦发布到Google Play就不能更改，需要谨慎选择",
                "应用签名密钥丢失后无法更新应用，必须妥善保管",
                "targetSdkVersion应该设置为最新的稳定版本，以获得最佳性能和安全性",
                "minSdkVersion过低会影响新特性使用，过高会减少用户覆盖",
                "applicationId可以与package不同，但通常保持一致"
            ),
            practiceTips = "建议使用版本管理工具（如Git）管理版本号，使用密钥管理工具（如Android Keystore）安全存储签名密钥。发布前务必测试不同Android版本的兼容性。"
        ),
        
        KnowledgeDetail(
            id = "gradle",
            title = "Gradle构建系统",
            overview = "Gradle是Android项目的构建工具，负责编译代码、打包资源、管理依赖等。理解Gradle的配置和构建流程是Android开发的基础。",
            keyPoints = listOf(
                "build.gradle文件：项目级和模块级的构建配置文件，定义构建规则和依赖",
                "依赖管理：使用dependencies块声明项目依赖，支持implementation、api、kapt等配置",
                "构建变体（Build Variants）：构建类型（Build Types）和产品风味（Product Flavors）的组合",
                "构建类型：Debug和Release等不同类型，用于区分开发和生产环境",
                "产品风味：用于创建同一应用的不同版本（如免费版、付费版）",
                "签名配置：配置应用签名，Release版本必须使用正式签名",
                "版本目录（Version Catalogs）：统一管理依赖版本，提供类型安全的依赖访问"
            ),
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：项目级build.gradle配置",
                    code = """
                        // 项目根目录的build.gradle
                        plugins {
                            alias(libs.plugins.android.application) apply false
                            alias(libs.plugins.kotlin.android) apply false
                            alias(libs.plugins.kotlin.compose) apply false
                            alias(libs.plugins.kotlin.kapt) apply false
                            alias(libs.plugins.hilt) apply false
                        }
                        
                        // apply false表示插件在项目级声明但不立即应用
                        // 子模块可以选择性地应用这些插件
                    """.trimIndent(),
                    explanation = "项目级build.gradle用于配置所有子模块共用的插件和设置。使用alias引用版本目录中定义的插件，便于统一管理版本。"
                ),
                CodeExample(
                    title = "示例2：模块级build.gradle基础配置",
                    code = """
                        plugins {
                            alias(libs.plugins.android.application)
                            alias(libs.plugins.kotlin.android)
                            alias(libs.plugins.kotlin.compose)
                            alias(libs.plugins.kotlin.kapt)
                            alias(libs.plugins.hilt)
                        }
                        
                        android {
                            namespace 'com.example.myapp'
                            
                            compileSdk {
                                version = release(36)  // 编译SDK版本
                            }
                            
                            defaultConfig {
                                applicationId "com.example.myapp"
                                minSdk 24              // 最低支持Android 7.0
                                targetSdk 36           // 目标Android 16
                                versionCode 1
                                versionName "1.0"
                                
                                testInstrumentationRunner "androidx.test.runner.AndroidJUnitRunner"
                            }
                            
                            buildTypes {
                                debug {
                                    debuggable true
                                    minifyEnabled false
                                }
                                release {
                                    minifyEnabled true
                                    proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'),
                                                  'proguard-rules.pro'
                                }
                            }
                            
                            compileOptions {
                                sourceCompatibility JavaVersion.VERSION_11
                                targetCompatibility JavaVersion.VERSION_11
                            }
                            
                            kotlinOptions {
                                jvmTarget = '11'
                            }
                            
                            buildFeatures {
                                compose true
                                buildConfig true
                            }
                        }
                    """.trimIndent(),
                    explanation = "模块级build.gradle配置特定模块的构建选项。defaultConfig定义默认配置，buildTypes定义构建类型，compileOptions和kotlinOptions配置编译选项。"
                ),
                CodeExample(
                    title = "示例3：依赖管理",
                    code = """
                        dependencies {
                            // implementation：编译时和运行时依赖，不暴露给其他模块
                            implementation libs.androidx.core.ktx
                            implementation libs.androidx.compose.ui
                            
                            // kapt：Kotlin注解处理器（用于Room、Hilt等）
                            kapt libs.androidx.room.compiler
                            kapt libs.hilt.compiler
                            
                            // platform：BOM（Bill of Materials），统一管理版本
                            implementation platform(libs.androidx.compose.bom)
                            implementation libs.androidx.compose.material3
                            
                            // testImplementation：单元测试依赖
                            testImplementation libs.junit
                            
                            // androidTestImplementation：Android集成测试依赖
                            androidTestImplementation libs.androidx.junit
                            
                            // debugImplementation：仅在Debug构建中使用
                            debugImplementation libs.androidx.compose.ui.tooling
                        }
                        
                        // 依赖配置类型说明：
                        // - implementation：推荐使用，依赖不暴露给其他模块
                        // - api：依赖会暴露给其他模块（不推荐，会增加构建时间）
                        // - compileOnly：仅在编译时需要
                        // - runtimeOnly：仅在运行时需要
                        // - kapt：Kotlin注解处理（可考虑迁移到KSP，性能更好）
                    """.trimIndent(),
                    explanation = "dependencies块用于声明项目依赖。implementation是最常用的配置类型，kapt用于注解处理，platform用于统一管理版本。"
                ),
                CodeExample(
                    title = "示例4：构建变体和产品风味",
                    code = """
                        android {
                            // 构建类型
                            buildTypes {
                                debug {
                                    applicationIdSuffix ".debug"
                                    versionNameSuffix "-debug"
                                }
                                release {
                                    minifyEnabled true
                                    signingConfig signingConfigs.release
                                }
                            }
                            
                            // 产品风味维度
                            flavorDimensions += "version"
                            
                            productFlavors {
                                create("free") {
                                    dimension = "version"
                                    applicationIdSuffix = ".free"
                                    versionNameSuffix = "-free"
                                    resValue("string", "app_name", "MyApp Free")
                                }
                                
                                create("paid") {
                                    dimension = "version"
                                    applicationIdSuffix = ".paid"
                                    versionNameSuffix = "-paid"
                                    resValue("string", "app_name", "MyApp Pro")
                                }
                            }
                        }
                        
                        // 生成的构建变体：
                        // - freeDebug
                        // - freeRelease
                        // - paidDebug
                        // - paidRelease
                    """.trimIndent(),
                    explanation = "构建变体是构建类型和产品风味的组合。产品风味用于创建同一应用的不同版本，如免费版和付费版。"
                ),
                CodeExample(
                    title = "示例5：版本目录（Version Catalogs）",
                    code = """
                        // gradle/libs.versions.toml
                        [versions]
                        agp = "8.13.2"
                        kotlin = "2.0.21"
                        composeBom = "2024.09.00"
                        
                        [libraries]
                        androidx-core-ktx = { group = "androidx.core", name = "core-ktx", version.ref = "coreKtx" }
                        androidx-compose-bom = { group = "androidx.compose", name = "compose-bom", version.ref = "composeBom" }
                        
                        [plugins]
                        android-application = { id = "com.android.application", version.ref = "agp" }
                        kotlin-android = { id = "org.jetbrains.kotlin.android", version.ref = "kotlin" }
                        
                        // 在build.gradle中使用
                        plugins {
                            alias(libs.plugins.android.application)
                        }
                        
                        dependencies {
                            implementation libs.androidx.core.ktx
                            implementation platform(libs.androidx.compose.bom)
                        }
                        
                        // Version Catalog的优势：
                        // 1. 统一版本管理
                        // 2. 类型安全（IDE自动补全）
                        // 3. 易于维护（更新版本只需修改一处）
                    """.trimIndent(),
                    explanation = "Version Catalog是Gradle 7.0+引入的功能，用于统一管理依赖版本。使用TOML文件定义版本和库，在build.gradle中通过libs引用，提供类型安全的依赖访问。"
                ),
                CodeExample(
                    title = "示例6：签名配置",
                    code = """
                        android {
                            signingConfigs {
                                create("release") {
                                    // 方式1：直接在build.gradle中配置（不推荐，密钥暴露）
                                    // storeFile = file("release.keystore")
                                    // storePassword = "password"
                                    // keyAlias = "release"
                                    // keyPassword = "password"
                                    
                                    // 方式2：从gradle.properties读取（推荐）
                                    storeFile = file(project.findProperty("RELEASE_STORE_FILE") as String)
                                    storePassword = project.findProperty("RELEASE_STORE_PASSWORD") as String
                                    keyAlias = project.findProperty("RELEASE_KEY_ALIAS") as String
                                    keyPassword = project.findProperty("RELEASE_KEY_PASSWORD") as String
                                }
                            }
                            
                            buildTypes {
                                getByName("release") {
                                    signingConfig = signingConfigs.getByName("release")
                                }
                            }
                        }
                        
                        // gradle.properties（不提交到版本控制）
                        // RELEASE_STORE_FILE=release.keystore
                        // RELEASE_STORE_PASSWORD=your_store_password
                        // RELEASE_KEY_ALIAS=your_key_alias
                        // RELEASE_KEY_PASSWORD=your_key_password
                        
                        // 生成签名密钥：
                        // keytool -genkey -v -keystore release.keystore -alias release 
                        //         -keyalg RSA -keysize 2048 -validity 10000
                    """.trimIndent(),
                    explanation = "签名配置用于Release版本的签名。推荐从gradle.properties读取密钥信息，避免密钥暴露在代码中。签名密钥必须妥善保管，丢失后无法更新应用。"
                )
            ),
            useCases = listOf(
                "项目构建：配置Gradle构建脚本，实现自动化构建和打包",
                "依赖管理：统一管理项目依赖，确保版本兼容性",
                "多版本发布：使用产品风味创建免费版、付费版等不同版本",
                "构建优化：配置构建缓存、并行构建等优化构建速度",
                "版本管理：使用Version Catalog统一管理依赖版本",
                "签名管理：配置应用签名，确保Release版本正确签名"
            ),
            notes = listOf(
                "build.gradle文件使用Groovy或Kotlin DSL编写，Kotlin DSL提供更好的类型安全",
                "implementation比api更推荐，因为它不会暴露依赖给其他模块，构建更快",
                "kapt正在被KSP（Kotlin Symbol Processing）替代，KSP性能更好",
                "Version Catalog是管理依赖版本的最佳实践，建议使用",
                "签名密钥丢失后无法更新应用，必须妥善保管并备份",
                "构建变体数量 = 构建类型数量 × 产品风味数量，避免创建过多变体",
                "使用Gradle Wrapper确保所有开发者使用相同的Gradle版本"
            ),
            practiceTips = "建议使用Version Catalog统一管理依赖版本，使用implementation而非api配置依赖。对于注解处理，考虑迁移到KSP替代kapt。签名密钥应该从gradle.properties或环境变量读取，不要硬编码在代码中。使用构建缓存和并行构建优化构建速度。定期更新Gradle和AGP版本以获得最新特性和性能改进。"
        ),
        
        // ========== Activity和Fragment ==========
        
        KnowledgeDetail(
            id = "activity_basic",
            title = "Activity生命周期、启动模式、Intent",
            overview = "Activity是Android应用的核心组件，代表一个用户界面。理解Activity的生命周期、启动模式和Intent机制是Android开发的基础。",
            keyPoints = listOf(
                "生命周期：onCreate、onStart、onResume、onPause、onStop、onDestroy等回调方法",
                "启动模式：standard、singleTop、singleTask、singleInstance四种模式",
                "Intent：用于Activity间通信和启动，包括显式Intent和隐式Intent",
                "任务栈（Task Stack）：管理Activity的启动和返回",
                "配置变更：屏幕旋转等配置变更时的生命周期处理",
                "状态保存：onSaveInstanceState和onRestoreInstanceState保存和恢复状态"
            ),
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：Activity生命周期",
                    code = """
                        class MainActivity : AppCompatActivity() {
                            
                            override fun onCreate(savedInstanceState: Bundle?) {
                                super.onCreate(savedInstanceState)
                                setContentView(R.layout.activity_main)
                                // 初始化工作，只调用一次
                                Log.d("Lifecycle", "onCreate")
                            }
                            
                            override fun onStart() {
                                super.onStart()
                                // Activity可见但未获得焦点
                                Log.d("Lifecycle", "onStart")
                            }
                            
                            override fun onResume() {
                                super.onResume()
                                // Activity获得焦点，可以交互
                                Log.d("Lifecycle", "onResume")
                            }
                            
                            override fun onPause() {
                                super.onPause()
                                // Activity失去焦点，但仍可见
                                Log.d("Lifecycle", "onPause")
                            }
                            
                            override fun onStop() {
                                super.onStop()
                                // Activity不可见
                                Log.d("Lifecycle", "onStop")
                            }
                            
                            override fun onDestroy() {
                                super.onDestroy()
                                // Activity被销毁，释放资源
                                Log.d("Lifecycle", "onDestroy")
                            }
                            
                            override fun onRestart() {
                                super.onRestart()
                                // 从onStop恢复到onStart
                                Log.d("Lifecycle", "onRestart")
                            }
                        }
                    """.trimIndent(),
                    explanation = "Activity生命周期包括创建、启动、恢复、暂停、停止和销毁等阶段。理解生命周期有助于在合适的时机执行相应操作。"
                ),
                CodeExample(
                    title = "示例2：启动模式和Intent",
                    code = """
                        // 显式Intent - 明确指定要启动的Activity
                        val intent = Intent(this, SecondActivity::class.java)
                        intent.putExtra("key", "value")  // 传递数据
                        startActivity(intent)
                        
                        // 隐式Intent - 通过Action和Category启动
                        val implicitIntent = Intent().apply {
                            action = Intent.ACTION_VIEW
                            data = Uri.parse("https://www.example.com")
                        }
                        startActivity(implicitIntent)
                        
                        // 启动模式配置（在AndroidManifest.xml中）
                        // <activity
                        //     android:name=".MainActivity"
                        //     android:launchMode="singleTop" />
                        
                        // 四种启动模式：
                        // 1. standard：默认模式，每次启动都创建新实例
                        // 2. singleTop：如果Activity在栈顶，不创建新实例
                        // 3. singleTask：如果Activity在栈中，清除其上所有Activity
                        // 4. singleInstance：单独的任务栈，只有一个实例
                    """.trimIndent(),
                    explanation = "Intent用于Activity间通信，启动模式控制Activity的创建和任务栈行为。合理使用启动模式可以优化用户体验和内存使用。"
                ),
                CodeExample(
                    title = "示例3：状态保存和恢复",
                    code = """
                        class MainActivity : AppCompatActivity() {
                            private var counter = 0
                            
                            override fun onCreate(savedInstanceState: Bundle?) {
                                super.onCreate(savedInstanceState)
                                setContentView(R.layout.activity_main)
                                
                                // 恢复保存的状态
                                if (savedInstanceState != null) {
                                    counter = savedInstanceState.getInt("counter", 0)
                                }
                            }
                            
                            override fun onSaveInstanceState(outState: Bundle) {
                                super.onSaveInstanceState(outState)
                                // 保存状态（配置变更或系统回收时调用）
                                outState.putInt("counter", counter)
                            }
                            
                            // 注意：onSaveInstanceState只保存临时状态
                            // 重要数据应该使用ViewModel或持久化存储
                        }
                    """.trimIndent(),
                    explanation = "onSaveInstanceState用于保存Activity的临时状态，在配置变更或系统回收时恢复。重要数据应该使用ViewModel或数据库持久化。"
                )
            ),
            useCases = listOf(
                "页面导航：使用Intent在不同Activity间跳转和传递数据",
                "生命周期管理：在合适的生命周期方法中初始化、暂停和释放资源",
                "状态管理：使用onSaveInstanceState保存临时状态，使用ViewModel管理重要数据",
                "启动模式优化：使用singleTop避免重复创建相同Activity，使用singleTask实现单例模式",
                "深度链接：使用隐式Intent实现应用内深度链接和外部调用"
            ),
            notes = listOf(
                "onCreate只调用一次，适合进行一次性初始化",
                "onResume和onPause是配对的，适合启动和停止动画、传感器等",
                "不要在onPause中执行耗时操作，会影响下一个Activity的启动",
                "singleTask和singleInstance会影响返回栈行为，需要谨慎使用",
                "Intent传递的数据大小有限制，大数据应该使用其他方式（如数据库、文件）"
            ),
            practiceTips = "建议使用ViewModel管理Activity的数据，避免在配置变更时丢失数据。使用Navigation Component可以简化Activity间的导航。对于复杂的状态管理，考虑使用StateFlow或LiveData。"
        ),
        
        KnowledgeDetail(
            id = "fragment_basic",
            title = "Fragment生命周期、Fragment事务",
            overview = "Fragment是Android UI的模块化组件，可以在Activity中复用和组合。理解Fragment的生命周期和事务管理是构建灵活UI的关键。",
            keyPoints = listOf(
                "生命周期：Fragment有独立的生命周期，但受宿主Activity影响",
                "Fragment事务：使用FragmentTransaction添加、替换、移除Fragment",
                "回退栈：Fragment可以加入回退栈，支持返回操作",
                "Fragment通信：通过接口、ViewModel或Fragment Result API进行通信",
                "ViewPager集成：Fragment常用于ViewPager2实现页面滑动",
                "生命周期感知：Fragment可以观察Activity的生命周期"
            ),
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：Fragment生命周期",
                    code = """
                        class MyFragment : Fragment() {
                            
                            override fun onCreate(savedInstanceState: Bundle?) {
                                super.onCreate(savedInstanceState)
                                // Fragment创建，但视图未创建
                                Log.d("Fragment", "onCreate")
                            }
                            
                            override fun onCreateView(
                                inflater: LayoutInflater,
                                container: ViewGroup?,
                                savedInstanceState: Bundle?
                            ): View? {
                                // 创建Fragment的视图
                                Log.d("Fragment", "onCreateView")
                                return inflater.inflate(R.layout.fragment_my, container, false)
                            }
                            
                            override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
                                super.onViewCreated(view, savedInstanceState)
                                // 视图创建完成，可以初始化UI组件
                                Log.d("Fragment", "onViewCreated")
                            }
                            
                            override fun onStart() {
                                super.onStart()
                                // Fragment可见
                                Log.d("Fragment", "onStart")
                            }
                            
                            override fun onResume() {
                                super.onResume()
                                // Fragment可交互
                                Log.d("Fragment", "onResume")
                            }
                            
                            override fun onPause() {
                                super.onPause()
                                // Fragment失去焦点
                                Log.d("Fragment", "onPause")
                            }
                            
                            override fun onStop() {
                                super.onStop()
                                // Fragment不可见
                                Log.d("Fragment", "onStop")
                            }
                            
                            override fun onDestroyView() {
                                super.onDestroyView()
                                // 视图被销毁，但Fragment实例仍存在
                                Log.d("Fragment", "onDestroyView")
                            }
                            
                            override fun onDestroy() {
                                super.onDestroy()
                                // Fragment被销毁
                                Log.d("Fragment", "onDestroy")
                            }
                        }
                    """.trimIndent(),
                    explanation = "Fragment有独立的生命周期，但受宿主Activity影响。onCreateView创建视图，onViewCreated初始化UI，onDestroyView销毁视图但保留Fragment实例。"
                ),
                CodeExample(
                    title = "示例2：Fragment事务",
                    code = """
                        // 在Activity中使用Fragment事务
                        class MainActivity : AppCompatActivity() {
                            
                            fun addFragment() {
                                val fragment = MyFragment()
                                val transaction = supportFragmentManager.beginTransaction()
                                
                                // 添加Fragment
                                transaction.add(R.id.fragment_container, fragment, "MyFragment")
                                
                                // 添加到回退栈（可选）
                                transaction.addToBackStack(null)
                                
                                // 提交事务
                                transaction.commit()
                            }
                            
                            fun replaceFragment() {
                                val newFragment = AnotherFragment()
                                supportFragmentManager.beginTransaction()
                                    .replace(R.id.fragment_container, newFragment)
                                    .addToBackStack(null)
                                    .commit()
                            }
                            
                            fun removeFragment() {
                                val fragment = supportFragmentManager.findFragmentByTag("MyFragment")
                                fragment?.let {
                                    supportFragmentManager.beginTransaction()
                                        .remove(it)
                                        .commit()
                                }
                            }
                        }
                        
                        // 使用commitAllowingStateLoss（不推荐，仅在必要时使用）
                        // transaction.commitAllowingStateLoss()
                    """.trimIndent(),
                    explanation = "FragmentTransaction用于管理Fragment的添加、替换和移除。addToBackStack可以将Fragment加入回退栈，支持返回操作。"
                ),
                CodeExample(
                    title = "示例3：Fragment通信（Fragment Result API）",
                    code = """
                        // 发送Fragment（子Fragment）
                        class ChildFragment : Fragment() {
                            private fun sendResult() {
                                val result = "Hello from ChildFragment"
                                parentFragmentManager.setFragmentResult(
                                    "requestKey",
                                    bundleOf("data" to result)
                                )
                            }
                        }
                        
                        // 接收Fragment（父Fragment）
                        class ParentFragment : Fragment() {
                            override fun onCreate(savedInstanceState: Bundle?) {
                                super.onCreate(savedInstanceState)
                                
                                // 设置结果监听器
                                parentFragmentManager.setFragmentResultListener(
                                    "requestKey",
                                    this
                                ) { key, bundle ->
                                    val data = bundle.getString("data")
                                    // 处理结果
                                }
                            }
                        }
                        
                        // 或者使用接口方式（传统方式）
                        interface FragmentCommunication {
                            fun onDataReceived(data: String)
                        }
                    """.trimIndent(),
                    explanation = "Fragment Result API是推荐的Fragment间通信方式，比接口方式更简洁。也可以使用ViewModel实现Fragment间共享数据。"
                )
            ),
            useCases = listOf(
                "模块化UI：将复杂Activity拆分为多个Fragment，提高代码复用性",
                "ViewPager集成：使用Fragment实现可滑动的页面（如引导页、详情页）",
                "响应式布局：在平板和手机上使用不同Fragment布局",
                "导航管理：使用Fragment实现底部导航栏的多页面切换",
                "数据共享：使用ViewModel在Fragment间共享数据"
            ),
            notes = listOf(
                "Fragment的视图生命周期与Fragment实例生命周期不同，注意区分",
                "不要在onCreate中访问视图，应该在onViewCreated中访问",
                "Fragment事务必须在使用commit()提交后才生效",
                "addToBackStack会增加内存使用，避免过度使用",
                "Fragment Result API是AndroidX Fragment 1.3.0+引入的新特性",
                "避免在Fragment中直接持有Activity引用，使用接口或ViewModel通信"
            ),
            practiceTips = "建议使用Navigation Component管理Fragment导航，它简化了Fragment事务和参数传递。对于Fragment间通信，优先使用ViewModel或Fragment Result API，避免直接引用。使用ViewBinding可以简化Fragment中的视图访问。"
        ),
        
        KnowledgeDetail(
            id = "activity_fragment_advanced",
            title = "Activity和Fragment高级特性",
            overview = "Activity和Fragment的高级特性包括ViewModel集成、配置变更处理、状态保存和恢复、Fragment结果API、Navigation Component集成等。掌握这些特性可以构建更健壮和用户友好的应用。",
            keyPoints = listOf(
                "ViewModel集成：使用ViewModel在Activity和Fragment中管理数据，避免配置变更时数据丢失",
                "配置变更处理：处理屏幕旋转等配置变更，使用ViewModel或onRetainNonConfigurationInstance",
                "状态保存和恢复：使用onSaveInstanceState保存临时状态，使用ViewModel保存重要数据",
                "Fragment结果API：使用Fragment Result API实现Fragment间通信，替代接口方式",
                "Navigation Component：使用Navigation Component简化Activity和Fragment导航",
                "生命周期感知：使用LifecycleObserver观察生命周期，在合适的时机执行操作",
                "共享元素动画：实现Activity和Fragment间的共享元素转场动画"
            ),
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：ViewModel在Activity和Fragment中的使用",
                    code = """
                        // ViewModel定义
                        class UserViewModel : ViewModel() {
                            private val _users = MutableStateFlow<List<User>>(emptyList())
                            val users: StateFlow<List<User>> = _users.asStateFlow()
                            
                            fun loadUsers() {
                                viewModelScope.launch {
                                    _users.value = repository.getUsers()
                                }
                            }
                        }
                        
                        // 在Activity中使用ViewModel
                        class MainActivity : AppCompatActivity() {
                            private lateinit var viewModel: UserViewModel
                            
                            override fun onCreate(savedInstanceState: Bundle?) {
                                super.onCreate(savedInstanceState)
                                setContentView(R.layout.activity_main)
                                
                                // 获取ViewModel（配置变更时不会重新创建）
                                viewModel = ViewModelProvider(this)[UserViewModel::class.java]
                                
                                // 观察数据
                                lifecycleScope.launch {
                                    viewModel.users.collect { users ->
                                        // 更新UI
                                    }
                                }
                            }
                        }
                        
                        // 在Fragment中使用ViewModel
                        class UserListFragment : Fragment() {
                            private lateinit var viewModel: UserViewModel
                            
                            override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
                                super.onViewCreated(view, savedInstanceState)
                                
                                // 获取ViewModel（与Activity共享）
                                viewModel = ViewModelProvider(requireActivity())[UserViewModel::class.java]
                                
                                // 或者获取Fragment作用域的ViewModel
                                // viewModel = ViewModelProvider(this)[UserViewModel::class.java]
                            }
                        }
                    """.trimIndent(),
                    explanation = "ViewModel用于管理UI相关的数据，在配置变更（如屏幕旋转）时不会销毁，可以保存数据。Activity和Fragment可以共享同一个ViewModel实例。"
                ),
                CodeExample(
                    title = "示例2：配置变更处理",
                    code = """
                        // 方式1：使用ViewModel（推荐）
                        class MainActivity : AppCompatActivity() {
                            private val viewModel: MyViewModel by viewModels()
                            
                            override fun onCreate(savedInstanceState: Bundle?) {
                                super.onCreate(savedInstanceState)
                                setContentView(R.layout.activity_main)
                                
                                // ViewModel在配置变更时自动保留
                                viewModel.data.observe(this) { data ->
                                    // 更新UI
                                }
                            }
                        }
                        
                        // 方式2：使用onRetainNonConfigurationInstance（已过时，不推荐）
                        class MainActivity : AppCompatActivity() {
                            private var retainedData: RetainedData? = null
                            
                            override fun onCreate(savedInstanceState: Bundle?) {
                                super.onCreate(savedInstanceState)
                                
                                // 恢复保留的数据
                                retainedData = lastNonConfigurationInstance as? RetainedData
                                    ?: RetainedData()
                            }
                            
                            override fun onRetainCustomNonConfigurationInstance(): Any? {
                                return retainedData
                            }
                        }
                        
                        // 方式3：在AndroidManifest.xml中处理配置变更
                        // <activity
                        //     android:name=".MainActivity"
                        //     android:configChanges="orientation|screenSize|keyboardHidden" />
                        
                        // 注意：不推荐使用configChanges，应该让系统正常处理配置变更
                    """.trimIndent(),
                    explanation = "配置变更（如屏幕旋转）会导致Activity重建。使用ViewModel可以自动保留数据，避免数据丢失。不推荐使用configChanges属性，应该让系统正常处理配置变更。"
                ),
                CodeExample(
                    title = "示例3：状态保存和恢复（ViewModel + SavedStateHandle）",
                    code = """
                        // 使用SavedStateHandle保存和恢复状态
                        class MyViewModel(
                            private val savedStateHandle: SavedStateHandle
                        ) : ViewModel() {
                            
                            // 保存状态
                            var counter: Int
                                get() = savedStateHandle.get<Int>("counter") ?: 0
                                set(value) = savedStateHandle.set("counter", value)
                            
                            // 或者使用LiveData/StateFlow
                            val counterFlow: StateFlow<Int> = savedStateHandle
                                .getStateFlow("counter", 0)
                        }
                        
                        // 在Activity中使用
                        class MainActivity : AppCompatActivity() {
                            private val viewModel: MyViewModel by viewModels()
                            
                            override fun onCreate(savedInstanceState: Bundle?) {
                                super.onCreate(savedInstanceState)
                                setContentView(R.layout.activity_main)
                                
                                // 状态自动恢复
                                viewModel.counterFlow.observe(this) { count ->
                                    // 更新UI
                                }
                            }
                        }
                        
                        // 使用onSaveInstanceState保存临时状态（不推荐用于重要数据）
                        class MainActivity : AppCompatActivity() {
                            private var tempData: String? = null
                            
                            override fun onSaveInstanceState(outState: Bundle) {
                                super.onSaveInstanceState(outState)
                                outState.putString("temp_data", tempData)
                            }
                            
                            override fun onCreate(savedInstanceState: Bundle?) {
                                super.onCreate(savedInstanceState)
                                tempData = savedInstanceState?.getString("temp_data")
                            }
                        }
                    """.trimIndent(),
                    explanation = "SavedStateHandle用于在进程被系统杀死后恢复状态，比onSaveInstanceState更强大。重要数据应该使用ViewModel + SavedStateHandle，临时数据可以使用onSaveInstanceState。"
                ),
                CodeExample(
                    title = "示例4：Fragment Result API（推荐方式）",
                    code = """
                        // 发送Fragment（子Fragment）
                        class ChildFragment : Fragment() {
                            private fun sendResultToParent() {
                                val result = "Hello from ChildFragment"
                                parentFragmentManager.setFragmentResult(
                                    "requestKey",
                                    bundleOf("data" to result)
                                )
                            }
                            
                            // 或者发送给Activity
                            private fun sendResultToActivity() {
                                requireActivity().supportFragmentManager.setFragmentResult(
                                    "requestKey",
                                    bundleOf("data" to "result")
                                )
                            }
                        }
                        
                        // 接收Fragment（父Fragment或Activity）
                        class ParentFragment : Fragment() {
                            override fun onCreate(savedInstanceState: Bundle?) {
                                super.onCreate(savedInstanceState)
                                
                                // 设置结果监听器
                                parentFragmentManager.setFragmentResultListener(
                                    "requestKey",
                                    this
                                ) { key, bundle ->
                                    val data = bundle.getString("data")
                                    // 处理结果
                                }
                            }
                        }
                        
                        // 在Activity中接收
                        class MainActivity : AppCompatActivity() {
                            override fun onCreate(savedInstanceState: Bundle?) {
                                super.onCreate(savedInstanceState)
                                
                                supportFragmentManager.setFragmentResultListener(
                                    "requestKey",
                                    this
                                ) { key, bundle ->
                                    val data = bundle.getString("data")
                                    // 处理结果
                                }
                            }
                        }
                        
                        // Fragment Result API的优势：
                        // 1. 不需要接口定义
                        // 2. 类型安全
                        // 3. 支持多个监听器
                        // 4. 自动清理
                    """.trimIndent(),
                    explanation = "Fragment Result API是推荐的Fragment间通信方式，比接口方式更简洁和安全。支持Fragment到Fragment、Fragment到Activity的通信。"
                ),
                CodeExample(
                    title = "示例5：Navigation Component与Fragment集成",
                    code = """
                        // 导航图（nav_graph.xml）
                        // <navigation>
                        //     <fragment
                        //         android:id="@+id/homeFragment"
                        //         android:name="com.example.HomeFragment" />
                        //     <fragment
                        //         android:id="@+id/detailFragment"
                        //         android:name="com.example.DetailFragment">
                        //         <argument
                        //             android:name="itemId"
                        //             app:argType="string" />
                        //     </fragment>
                        // </navigation>
                        
                        // 在Activity中使用Navigation
                        class MainActivity : AppCompatActivity() {
                            override fun onCreate(savedInstanceState: Bundle?) {
                                super.onCreate(savedInstanceState)
                                setContentView(R.layout.activity_main)
                                
                                val navController = findNavController(R.id.nav_host_fragment)
                                
                                // 导航到详情页
                                navController.navigate(R.id.detailFragment)
                                
                                // 传递参数
                                val bundle = bundleOf("itemId" to "123")
                                navController.navigate(R.id.detailFragment, bundle)
                            }
                        }
                        
                        // 在Fragment中使用Navigation
                        class HomeFragment : Fragment() {
                            override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
                                super.onViewCreated(view, savedInstanceState)
                                
                                val navController = findNavController()
                                
                                button.setOnClickListener {
                                    // 导航到详情页
                                    navController.navigate(
                                        HomeFragmentDirections.actionHomeFragmentToDetailFragment("123")
                                    )
                                }
                            }
                        }
                        
                        // 接收参数
                        class DetailFragment : Fragment() {
                            override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
                                super.onViewCreated(view, savedInstanceState)
                                
                                val args = DetailFragmentArgs.fromBundle(requireArguments())
                                val itemId = args.itemId
                            }
                        }
                    """.trimIndent(),
                    explanation = "Navigation Component简化了Fragment导航和参数传递。使用Safe Args插件可以生成类型安全的导航代码，避免参数传递错误。"
                ),
                CodeExample(
                    title = "示例6：生命周期感知组件",
                    code = """
                        // 自定义生命周期感知组件
                        class MyLifecycleObserver(
                            private val lifecycle: Lifecycle
                        ) : LifecycleObserver {
                            
                            @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
                            fun onResume() {
                                // Activity/Fragment恢复时执行
                                Log.d("Lifecycle", "onResume")
                            }
                            
                            @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
                            fun onPause() {
                                // Activity/Fragment暂停时执行
                                Log.d("Lifecycle", "onPause")
                            }
                            
                            @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
                            fun onDestroy() {
                                // Activity/Fragment销毁时执行
                                Log.d("Lifecycle", "onDestroy")
                            }
                        }
                        
                        // 在Activity中使用
                        class MainActivity : AppCompatActivity() {
                            private lateinit var observer: MyLifecycleObserver
                            
                            override fun onCreate(savedInstanceState: Bundle?) {
                                super.onCreate(savedInstanceState)
                                setContentView(R.layout.activity_main)
                                
                                observer = MyLifecycleObserver(lifecycle)
                                lifecycle.addObserver(observer)
                            }
                        }
                        
                        // 在Fragment中使用
                        class MyFragment : Fragment() {
                            private lateinit var observer: MyLifecycleObserver
                            
                            override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
                                super.onViewCreated(view, savedInstanceState)
                                
                                observer = MyLifecycleObserver(viewLifecycleOwner.lifecycle)
                                viewLifecycleOwner.lifecycle.addObserver(observer)
                            }
                        }
                        
                        // 注意：Fragment应该使用viewLifecycleOwner，而不是lifecycleOwner
                        // viewLifecycleOwner的生命周期与Fragment视图绑定
                    """.trimIndent(),
                    explanation = "LifecycleObserver用于观察Activity和Fragment的生命周期。在Fragment中应该使用viewLifecycleOwner，它的生命周期与Fragment视图绑定，避免内存泄漏。"
                ),
                CodeExample(
                    title = "示例7：共享元素动画",
                    code = """
                        // 启动Activity时使用共享元素动画
                        val intent = Intent(this, DetailActivity::class.java)
                        val options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                            this,
                            // 共享元素：view（共享的视图）和"transition_name"（过渡名称）
                            Pair.create(imageView, "image_transition"),
                            Pair.create(titleView, "title_transition")
                        )
                        startActivity(intent, options.toBundle())
                        
                        // 在目标Activity中设置过渡名称
                        class DetailActivity : AppCompatActivity() {
                            override fun onCreate(savedInstanceState: Bundle?) {
                                super.onCreate(savedInstanceState)
                                setContentView(R.layout.activity_detail)
                                
                                // 设置过渡名称（必须与启动Activity中的名称一致）
                                detailImageView.transitionName = "image_transition"
                                detailTitleView.transitionName = "title_transition"
                            }
                        }
                        
                        // Fragment间共享元素动画（使用Navigation Component）
                        val extras = FragmentNavigator.Extras.Builder()
                            .addSharedElement(imageView, "image_transition")
                            .addSharedElement(titleView, "title_transition")
                            .build()
                        
                        navController.navigate(
                            R.id.detailFragment,
                            null,
                            null,
                            extras
                        )
                    """.trimIndent(),
                    explanation = "共享元素动画提供流畅的转场效果，提升用户体验。Activity和Fragment都支持共享元素动画，Fragment需要使用Navigation Component。"
                )
            ),
            useCases = listOf(
                "数据持久化：使用ViewModel在配置变更时保留数据，避免数据丢失",
                "状态管理：使用SavedStateHandle保存和恢复状态，支持进程被杀死后的恢复",
                "Fragment通信：使用Fragment Result API实现Fragment间通信，替代接口方式",
                "导航管理：使用Navigation Component简化Activity和Fragment导航，支持类型安全的参数传递",
                "生命周期管理：使用LifecycleObserver在合适的生命周期阶段执行操作",
                "用户体验优化：使用共享元素动画提供流畅的转场效果",
                "架构设计：遵循MVVM架构，使用ViewModel管理UI数据，Activity和Fragment只负责UI展示"
            ),
            notes = listOf(
                "ViewModel在配置变更时不会销毁，但进程被杀死时会销毁，需要使用SavedStateHandle保存状态",
                "Fragment应该使用viewLifecycleOwner而不是lifecycleOwner，避免内存泄漏",
                "Fragment Result API是AndroidX Fragment 1.3.0+引入的新特性，推荐使用",
                "Navigation Component使用Safe Args插件可以生成类型安全的导航代码",
                "不推荐使用configChanges属性处理配置变更，应该使用ViewModel",
                "共享元素动画需要设置transitionName，且启动和目标Activity/Fragment中的名称必须一致",
                "避免在Activity和Fragment中直接持有对方引用，使用接口、ViewModel或Fragment Result API通信"
            ),
            practiceTips = "建议使用ViewModel + SavedStateHandle管理所有UI数据，Activity和Fragment只负责UI展示。使用Navigation Component简化导航，使用Fragment Result API实现Fragment间通信。遵循MVVM架构，将业务逻辑放在ViewModel中，保持Activity和Fragment的简洁。使用LifecycleObserver观察生命周期，在合适的时机执行操作。对于复杂的转场动画，考虑使用共享元素动画提升用户体验。"
        ),
        
        // ========== UI开发基础 ==========
        
        KnowledgeDetail(
            id = "view_system",
            title = "View系统、自定义View、事件分发",
            overview = "View是Android UI的基础组件，理解View的绘制流程、自定义View的实现和事件分发机制是Android UI开发的核心。掌握这些知识可以创建高性能、交互流畅的自定义UI组件。",
            keyPoints = listOf(
                "View和ViewGroup：View是UI的基础单元，ViewGroup是View的容器，可以包含多个子View",
                "View绘制流程：Measure（测量）、Layout（布局）、Draw（绘制）三个阶段",
                "自定义View：继承View或ViewGroup，重写onMeasure、onLayout、onDraw等方法",
                "事件分发机制：事件从Activity传递到ViewGroup再到View，通过onInterceptTouchEvent和onTouchEvent处理",
                "自定义属性：使用attrs.xml定义自定义属性，在布局文件中使用",
                "性能优化：避免过度绘制、使用硬件加速、合理使用缓存"
            ),
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：View绘制流程",
                    code = """
                        class CustomView @JvmOverloads constructor(
                            context: Context,
                            attrs: AttributeSet? = null,
                            defStyleAttr: Int = 0
                        ) : View(context, attrs, defStyleAttr) {
                            
                            // 1. Measure阶段：测量View的宽高
                            override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
                                val width = MeasureSpec.getSize(widthMeasureSpec)
                                val height = MeasureSpec.getSize(heightMeasureSpec)
                                
                                // 设置测量后的宽高
                                setMeasuredDimension(width, height)
                            }
                            
                            // 2. Layout阶段：确定View的位置（ViewGroup需要重写）
                            override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
                                super.onLayout(changed, left, top, right, bottom)
                                // ViewGroup需要在这里布局子View
                            }
                            
                            // 3. Draw阶段：绘制View的内容
                            override fun onDraw(canvas: Canvas?) {
                                super.onDraw(canvas)
                                canvas?.let {
                                    val paint = Paint().apply {
                                        color = Color.RED
                                        style = Paint.Style.FILL
                                    }
                                    // 绘制圆形
                                    it.drawCircle(width / 2f, height / 2f, 50f, paint)
                                }
                            }
                        }
                    """.trimIndent(),
                    explanation = "View的绘制流程包括Measure（测量）、Layout（布局）、Draw（绘制）三个阶段。自定义View需要重写相应的方法来实现自定义绘制。"
                ),
                CodeExample(
                    title = "示例2：自定义ViewGroup",
                    code = """
                        class CustomLayout @JvmOverloads constructor(
                            context: Context,
                            attrs: AttributeSet? = null,
                            defStyleAttr: Int = 0
                        ) : ViewGroup(context, attrs, defStyleAttr) {
                            
                            override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
                                // 测量所有子View
                                var totalWidth = 0
                                var totalHeight = 0
                                
                                for (i in 0 until childCount) {
                                    val child = getChildAt(i)
                                    measureChild(child, widthMeasureSpec, heightMeasureSpec)
                                    totalWidth += child.measuredWidth
                                    totalHeight = max(totalHeight, child.measuredHeight)
                                }
                                
                                // 设置自己的尺寸
                                setMeasuredDimension(
                                    resolveSize(totalWidth, widthMeasureSpec),
                                    resolveSize(totalHeight, heightMeasureSpec)
                                )
                            }
                            
                            override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
                                var left = 0
                                
                                // 布局所有子View（水平排列）
                                for (i in 0 until childCount) {
                                    val child = getChildAt(i)
                                    val width = child.measuredWidth
                                    val height = child.measuredHeight
                                    
                                    child.layout(left, 0, left + width, height)
                                    left += width
                                }
                            }
                        }
                    """.trimIndent(),
                    explanation = "自定义ViewGroup需要重写onMeasure和onLayout方法。onMeasure测量所有子View，onLayout确定每个子View的位置。"
                ),
                CodeExample(
                    title = "示例3：事件分发机制",
                    code = """
                        class CustomViewGroup @JvmOverloads constructor(
                            context: Context,
                            attrs: AttributeSet? = null
                        ) : ViewGroup(context, attrs) {
                            
                            // 是否拦截事件
                            override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
                                // 返回true表示拦截事件，子View不会收到事件
                                // 返回false表示不拦截，事件继续传递给子View
                                return false
                            }
                            
                            // 处理事件
                            override fun onTouchEvent(event: MotionEvent?): Boolean {
                                when (event?.action) {
                                    MotionEvent.ACTION_DOWN -> {
                                        // 按下事件
                                        return true  // 返回true表示消费了事件
                                    }
                                    MotionEvent.ACTION_MOVE -> {
                                        // 移动事件
                                    }
                                    MotionEvent.ACTION_UP -> {
                                        // 抬起事件
                                    }
                                }
                                return super.onTouchEvent(event)
                            }
                        }
                        
                        class CustomView @JvmOverloads constructor(
                            context: Context,
                            attrs: AttributeSet? = null
                        ) : View(context, attrs) {
                            
                            override fun onTouchEvent(event: MotionEvent?): Boolean {
                                when (event?.action) {
                                    MotionEvent.ACTION_DOWN -> {
                                        // 处理按下事件
                                        return true
                                    }
                                }
                                return super.onTouchEvent(event)
                            }
                        }
                        
                        // 事件分发流程：
                        // Activity.dispatchTouchEvent() 
                        //   -> ViewGroup.onInterceptTouchEvent() (是否拦截)
                        //     -> ViewGroup.onTouchEvent() (如果拦截)
                        //     -> View.onTouchEvent() (如果不拦截)
                    """.trimIndent(),
                    explanation = "事件分发从Activity开始，经过ViewGroup的onInterceptTouchEvent判断是否拦截，如果不拦截则传递给子View。onTouchEvent返回true表示消费了事件。"
                ),
                CodeExample(
                    title = "示例4：自定义属性",
                    code = """
                        // res/values/attrs.xml
                        // <resources>
                        //     <declare-styleable name="CustomView">
                        //         <attr name="customColor" format="color" />
                        //         <attr name="customText" format="string" />
                        //         <attr name="customSize" format="dimension" />
                        //     </declare-styleable>
                        // </resources>
                        
                        class CustomView @JvmOverloads constructor(
                            context: Context,
                            attrs: AttributeSet? = null,
                            defStyleAttr: Int = 0
                        ) : View(context, attrs, defStyleAttr) {
                            
                            private var customColor: Int = Color.BLACK
                            private var customText: String = ""
                            private var customSize: Float = 0f
                            
                            init {
                                // 读取自定义属性
                                context.obtainStyledAttributes(
                                    attrs,
                                    R.styleable.CustomView
                                ).apply {
                                    customColor = getColor(R.styleable.CustomView_customColor, Color.BLACK)
                                    customText = getString(R.styleable.CustomView_customText) ?: ""
                                    customSize = getDimension(R.styleable.CustomView_customSize, 0f)
                                    recycle()
                                }
                            }
                            
                            override fun onDraw(canvas: Canvas?) {
                                super.onDraw(canvas)
                                canvas?.let {
                                    val paint = Paint().apply {
                                        color = customColor
                                        textSize = customSize
                                    }
                                    it.drawText(customText, 0f, height / 2f, paint)
                                }
                            }
                        }
                        
                        // 在布局文件中使用
                        // <com.example.CustomView
                        //     android:layout_width="wrap_content"
                        //     android:layout_height="wrap_content"
                        //     app:customColor="@color/red"
                        //     app:customText="Hello"
                        //     app:customSize="16sp" />
                    """.trimIndent(),
                    explanation = "自定义属性需要在attrs.xml中声明，然后在自定义View的构造函数中读取。这样可以在布局文件中直接设置自定义属性。"
                )
            ),
            useCases = listOf(
                "自定义UI组件：创建符合设计要求的自定义View和ViewGroup",
                "性能优化：理解绘制流程，优化View的绘制性能",
                "交互设计：通过事件分发机制实现复杂的触摸交互",
                "动画效果：在onDraw中实现自定义动画效果",
                "复杂布局：自定义ViewGroup实现特殊的布局需求"
            ),
            notes = listOf(
                "onMeasure必须调用setMeasuredDimension设置测量后的宽高",
                "ViewGroup的onLayout需要布局所有子View",
                "事件分发中，onInterceptTouchEvent返回true会拦截事件",
                "onTouchEvent返回true表示消费了事件，事件不会继续传递",
                "自定义属性需要在attrs.xml中声明，使用declare-styleable",
                "避免在onDraw中创建对象，应该复用Paint等对象",
                "使用硬件加速可以提升绘制性能"
            ),
            practiceTips = "建议先理解View的绘制流程，再实现自定义View。对于简单的自定义View，可以继承View；对于需要包含子View的，继承ViewGroup。事件分发机制比较复杂，建议通过实际测试来理解。自定义属性可以让View更灵活，建议为自定义View定义必要的属性。注意性能优化，避免过度绘制和不必要的重绘。"
        ),
        
        KnowledgeDetail(
            id = "layouts",
            title = "布局（LinearLayout、RelativeLayout、ConstraintLayout）",
            overview = "布局是Android UI的基础，用于组织和排列View。理解各种布局的特点和使用场景，选择合适的布局可以提高开发效率和UI性能。",
            keyPoints = listOf(
                "LinearLayout：线性布局，可以水平或垂直排列子View",
                "RelativeLayout：相对布局，通过相对位置关系排列子View",
                "ConstraintLayout：约束布局，使用约束关系排列View，性能最好，推荐使用",
                "FrameLayout：帧布局，子View叠加显示，常用于Fragment容器",
                "布局性能：ConstraintLayout性能最好，RelativeLayout次之，LinearLayout嵌套时性能较差",
                "布局优化：减少布局层次、使用merge标签、使用include标签复用布局"
            ),
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：LinearLayout使用",
                    code = """
                        <!-- 垂直排列的LinearLayout -->
                        <LinearLayout
                            android:layout_width="match_parent"
                            android:layout_height="wrap_content"
                            android:orientation="vertical"
                            android:padding="16dp">
                            
                            <TextView
                                android:layout_width="wrap_content"
                                android:layout_height="wrap_content"
                                android:text="标题"
                                android:textSize="18sp" />
                            
                            <TextView
                                android:layout_width="wrap_content"
                                android:layout_height="wrap_content"
                                android:text="内容"
                                android:layout_marginTop="8dp" />
                            
                            <Button
                                android:layout_width="match_parent"
                                android:layout_height="wrap_content"
                                android:text="按钮"
                                android:layout_marginTop="16dp" />
                        </LinearLayout>
                        
                        <!-- 水平排列的LinearLayout -->
                        <LinearLayout
                            android:layout_width="match_parent"
                            android:layout_height="wrap_content"
                            android:orientation="horizontal">
                            
                            <TextView
                                android:layout_width="0dp"
                                android:layout_height="wrap_content"
                                android:layout_weight="1"
                                android:text="左侧" />
                            
                            <TextView
                                android:layout_width="0dp"
                                android:layout_height="wrap_content"
                                android:layout_weight="1"
                                android:text="右侧" />
                        </LinearLayout>
                    """.trimIndent(),
                    explanation = "LinearLayout可以垂直或水平排列子View。使用layout_weight可以让子View按比例分配空间。"
                ),
                CodeExample(
                    title = "示例2：RelativeLayout使用",
                    code = """
                        <RelativeLayout
                            android:layout_width="match_parent"
                            android:layout_height="wrap_content">
                            
                            <!-- 相对于父布局 -->
                            <ImageView
                                android:id="@+id/avatar"
                                android:layout_width="48dp"
                                android:layout_height="48dp"
                                android:layout_alignParentStart="true"
                                android:layout_centerVertical="true"
                                android:src="@drawable/avatar" />
                            
                            <!-- 相对于其他View -->
                            <TextView
                                android:id="@+id/name"
                                android:layout_width="wrap_content"
                                android:layout_height="wrap_content"
                                android:layout_toEndOf="@id/avatar"
                                android:layout_alignTop="@id/avatar"
                                android:layout_marginStart="16dp"
                                android:text="用户名" />
                            
                            <TextView
                                android:layout_width="wrap_content"
                                android:layout_height="wrap_content"
                                android:layout_toEndOf="@id/avatar"
                                android:layout_below="@id/name"
                                android:layout_marginStart="16dp"
                                android:text="描述信息" />
                            
                            <!-- 相对于父布局底部 -->
                            <Button
                                android:layout_width="wrap_content"
                                android:layout_height="wrap_content"
                                android:layout_alignParentEnd="true"
                                android:layout_centerVertical="true"
                                android:text="操作" />
                        </RelativeLayout>
                    """.trimIndent(),
                    explanation = "RelativeLayout通过相对位置关系排列View，可以相对于父布局或其他View定位。适合复杂的布局需求，但性能不如ConstraintLayout。"
                ),
                CodeExample(
                    title = "示例3：ConstraintLayout使用（推荐）",
                    code = """
                        <androidx.constraintlayout.widget.ConstraintLayout
                            android:layout_width="match_parent"
                            android:layout_height="wrap_content"
                            android:padding="16dp">
                            
                            <ImageView
                                android:id="@+id/avatar"
                                android:layout_width="48dp"
                                android:layout_height="48dp"
                                app:layout_constraintStart_toStartOf="parent"
                                app:layout_constraintTop_toTopOf="parent"
                                android:src="@drawable/avatar" />
                            
                            <TextView
                                android:id="@+id/name"
                                android:layout_width="0dp"
                                android:layout_height="wrap_content"
                                app:layout_constraintStart_toEndOf="@id/avatar"
                                app:layout_constraintEnd_toStartOf="@id/button"
                                app:layout_constraintTop_toTopOf="@id/avatar"
                                android:layout_marginStart="16dp"
                                android:layout_marginEnd="16dp"
                                android:text="用户名" />
                            
                            <TextView
                                android:layout_width="0dp"
                                android:layout_height="wrap_content"
                                app:layout_constraintStart_toStartOf="@id/name"
                                app:layout_constraintEnd_toEndOf="@id/name"
                                app:layout_constraintTop_toBottomOf="@id/name"
                                android:layout_marginTop="4dp"
                                android:text="描述信息" />
                            
                            <Button
                                android:id="@+id/button"
                                android:layout_width="wrap_content"
                                android:layout_height="wrap_content"
                                app:layout_constraintEnd_toEndOf="parent"
                                app:layout_constraintTop_toTopOf="@id/avatar"
                                app:layout_constraintBottom_toBottomOf="@id/avatar"
                                android:text="操作" />
                        </androidx.constraintlayout.widget.ConstraintLayout>
                        
                        // ConstraintLayout的优势：
                        // 1. 性能最好，扁平化布局层次
                        // 2. 功能强大，支持链、屏障、引导线等
                        // 3. 可视化编辑，Android Studio支持可视化编辑
                    """.trimIndent(),
                    explanation = "ConstraintLayout是推荐的布局方式，使用约束关系排列View，性能最好。支持链、屏障、引导线等高级特性，适合复杂布局。"
                ),
                CodeExample(
                    title = "示例4：布局优化（include和merge）",
                    code = """
                        <!-- 可复用的布局：layout_header.xml -->
                        <merge xmlns:android="http://schemas.android.com/apk/res/android">
                            <TextView
                                android:layout_width="match_parent"
                                android:layout_height="wrap_content"
                                android:text="标题" />
                            
                            <TextView
                                android:layout_width="match_parent"
                                android:layout_height="wrap_content"
                                android:text="副标题" />
                        </merge>
                        
                        <!-- 使用include复用布局 -->
                        <LinearLayout
                            android:layout_width="match_parent"
                            android:layout_height="wrap_content"
                            android:orientation="vertical">
                            
                            <include
                                layout="@layout/layout_header"
                                android:layout_width="match_parent"
                                android:layout_height="wrap_content" />
                            
                            <TextView
                                android:layout_width="match_parent"
                                android:layout_height="wrap_content"
                                android:text="内容" />
                        </LinearLayout>
                        
                        // merge标签的作用：
                        // 1. 减少布局层次
                        // 2. 当include的父布局与merge中的根布局类型相同时，merge会被替换
                        // 3. 提升性能
                    """.trimIndent(),
                    explanation = "使用include标签可以复用布局，使用merge标签可以减少布局层次。这些优化可以提升布局性能和可维护性。"
                )
            ),
            useCases = listOf(
                "简单布局：使用LinearLayout实现简单的线性排列",
                "复杂布局：使用ConstraintLayout实现复杂的约束关系布局",
                "相对定位：使用RelativeLayout实现相对定位的布局",
                "布局复用：使用include标签复用常用布局",
                "性能优化：使用ConstraintLayout减少布局层次，提升性能"
            ),
            notes = listOf(
                "ConstraintLayout是推荐的布局方式，性能最好",
                "避免嵌套LinearLayout，会导致性能问题",
                "RelativeLayout适合复杂布局，但性能不如ConstraintLayout",
                "使用include和merge可以复用布局和减少层次",
                "FrameLayout常用于Fragment容器",
                "布局层次越深，性能越差，应该尽量扁平化",
                "使用Android Studio的布局检查器可以查看布局层次"
            ),
            practiceTips = "建议优先使用ConstraintLayout，它性能最好且功能强大。避免过度嵌套布局，尽量保持布局层次扁平化。使用include标签复用常用布局，使用merge标签减少不必要的布局层次。对于简单的线性排列，可以使用LinearLayout；对于复杂的相对定位，使用ConstraintLayout。定期使用布局检查器检查布局性能。"
        ),
        
        KnowledgeDetail(
            id = "ui_components",
            title = "常用UI组件（TextView、Button、RecyclerView等）",
            overview = "Android提供了丰富的UI组件，包括TextView、Button、RecyclerView等。理解这些组件的使用方法和特性是构建用户界面的基础。",
            keyPoints = listOf(
                "TextView：显示文本，支持富文本、链接、自定义字体等",
                "Button：按钮组件，支持点击事件和样式定制",
                "RecyclerView：高效的列表组件，替代ListView，支持多种布局",
                "EditText：文本输入框，支持输入验证和样式定制",
                "ImageView：图片显示组件，支持缩放、裁剪等",
                "ScrollView：可滚动的容器，用于内容超出屏幕的情况"
            ),
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：TextView和Button",
                    code = """
                        <!-- TextView基础使用 -->
                        <TextView
                            android:layout_width="wrap_content"
                            android:layout_height="wrap_content"
                            android:text="普通文本"
                            android:textSize="16sp"
                            android:textColor="@color/black" />
                        
                        <!-- TextView富文本 -->
                        <TextView
                            android:layout_width="wrap_content"
                            android:layout_height="wrap_content"
                            android:text="@string/rich_text" />
                        
                        // strings.xml
                        // <string name="rich_text">
                        //     <![CDATA[
                        //         这是<font color="#FF0000">红色</font>文本，
                        //         这是<b>粗体</b>，这是<i>斜体</i>
                        //     ]]>
                        // </string>
                        
                        <!-- Button使用 -->
                        <Button
                            android:id="@+id/button"
                            android:layout_width="match_parent"
                            android:layout_height="wrap_content"
                            android:text="点击按钮"
                            android:onClick="onButtonClick" />
                        
                        // 在Activity中处理点击
                        class MainActivity : AppCompatActivity() {
                            override fun onCreate(savedInstanceState: Bundle?) {
                                super.onCreate(savedInstanceState)
                                setContentView(R.layout.activity_main)
                                
                                findViewById<Button>(R.id.button).setOnClickListener {
                                    // 处理点击事件
                                    Toast.makeText(this, "按钮被点击", Toast.LENGTH_SHORT).show()
                                }
                            }
                            
                            // 或者使用XML中的onClick属性
                            fun onButtonClick(view: View) {
                                Toast.makeText(this, "按钮被点击", Toast.LENGTH_SHORT).show()
                            }
                        }
                    """.trimIndent(),
                    explanation = "TextView用于显示文本，支持富文本和样式定制。Button用于触发操作，可以通过setOnClickListener或XML的onClick属性处理点击事件。"
                ),
                CodeExample(
                    title = "示例2：RecyclerView使用",
                    code = """
                        // 数据类
                        data class Item(val id: Int, val title: String, val description: String)
                        
                        // ViewHolder
                        class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
                            private val titleView: TextView = itemView.findViewById(R.id.title)
                            private val descView: TextView = itemView.findViewById(R.id.description)
                            
                            fun bind(item: Item) {
                                titleView.text = item.title
                                descView.text = item.description
                            }
                        }
                        
                        // Adapter
                        class ItemAdapter(private val items: List<Item>) : 
                            RecyclerView.Adapter<ItemViewHolder>() {
                            
                            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
                                val view = LayoutInflater.from(parent.context)
                                    .inflate(R.layout.item_layout, parent, false)
                                return ItemViewHolder(view)
                            }
                            
                            override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
                                holder.bind(items[position])
                            }
                            
                            override fun getItemCount() = items.size
                        }
                        
                        // 在Activity中使用
                        class MainActivity : AppCompatActivity() {
                            override fun onCreate(savedInstanceState: Bundle?) {
                                super.onCreate(savedInstanceState)
                                setContentView(R.layout.activity_main)
                                
                                val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
                                val items = listOf(
                                    Item(1, "标题1", "描述1"),
                                    Item(2, "标题2", "描述2")
                                )
                                
                                recyclerView.layoutManager = LinearLayoutManager(this)
                                recyclerView.adapter = ItemAdapter(items)
                            }
                        }
                        
                        // item_layout.xml
                        // <LinearLayout>
                        //     <TextView android:id="@+id/title" />
                        //     <TextView android:id="@+id/description" />
                        // </LinearLayout>
                    """.trimIndent(),
                    explanation = "RecyclerView是高效的列表组件，使用ViewHolder模式复用View，性能优于ListView。需要Adapter和LayoutManager配合使用。"
                ),
                CodeExample(
                    title = "示例3：EditText和输入验证",
                    code = """
                        <EditText
                            android:id="@+id/emailEditText"
                            android:layout_width="match_parent"
                            android:layout_height="wrap_content"
                            android:hint="请输入邮箱"
                            android:inputType="textEmailAddress"
                            android:maxLines="1" />
                        
                        <EditText
                            android:id="@+id/passwordEditText"
                            android:layout_width="match_parent"
                            android:layout_height="wrap_content"
                            android:hint="请输入密码"
                            android:inputType="textPassword"
                            android:maxLines="1" />
                        
                        // 在Activity中验证输入
                        class MainActivity : AppCompatActivity() {
                            override fun onCreate(savedInstanceState: Bundle?) {
                                super.onCreate(savedInstanceState)
                                setContentView(R.layout.activity_main)
                                
                                val emailEditText = findViewById<EditText>(R.id.emailEditText)
                                val passwordEditText = findViewById<EditText>(R.id.passwordEditText)
                                
                                // 输入验证
                                emailEditText.addTextChangedListener(object : TextWatcher {
                                    override fun afterTextChanged(s: Editable?) {
                                        val email = s.toString()
                                        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                                            emailEditText.error = "邮箱格式不正确"
                                        }
                                    }
                                    // ... 其他方法
                                })
                            }
                        }
                    """.trimIndent(),
                    explanation = "EditText用于文本输入，inputType可以限制输入类型。使用TextWatcher可以监听输入变化并进行验证。"
                ),
                CodeExample(
                    title = "示例4：ImageView和图片加载",
                    code = """
                        <ImageView
                            android:id="@+id/imageView"
                            android:layout_width="match_parent"
                            android:layout_height="200dp"
                            android:scaleType="centerCrop"
                            android:src="@drawable/placeholder" />
                        
                        // 在代码中设置图片
                        class MainActivity : AppCompatActivity() {
                            override fun onCreate(savedInstanceState: Bundle?) {
                                super.onCreate(savedInstanceState)
                                setContentView(R.layout.activity_main)
                                
                                val imageView = findViewById<ImageView>(R.id.imageView)
                                
                                // 从资源加载
                                imageView.setImageResource(R.drawable.image)
                                
                                // 从网络加载（使用Glide或Coil）
                                // Glide.with(this).load("https://example.com/image.jpg").into(imageView)
                                // Coil.load("https://example.com/image.jpg").into(imageView)
                                
                                // 从文件加载
                                val bitmap = BitmapFactory.decodeFile("/path/to/image.jpg")
                                imageView.setImageBitmap(bitmap)
                            }
                        }
                        
                        // scaleType说明：
                        // - centerCrop：居中裁剪，保持宽高比
                        // - centerInside：居中显示，完整显示图片
                        // - fitCenter：居中缩放，保持宽高比
                        // - fitXY：拉伸填充，不保持宽高比
                    """.trimIndent(),
                    explanation = "ImageView用于显示图片，scaleType控制图片的缩放方式。从网络加载图片应该使用Glide或Coil等图片加载库。"
                )
            ),
            useCases = listOf(
                "文本显示：使用TextView显示各种文本内容",
                "用户交互：使用Button、EditText等组件实现用户交互",
                "列表展示：使用RecyclerView展示列表数据",
                "图片显示：使用ImageView显示图片，配合图片加载库从网络加载",
                "表单输入：使用EditText实现各种输入需求"
            ),
            notes = listOf(
                "RecyclerView性能优于ListView，推荐使用RecyclerView",
                "EditText的inputType可以限制输入类型，提升用户体验",
                "从网络加载图片应该使用Glide、Coil等图片加载库，不要直接使用BitmapFactory",
                "TextView支持富文本，可以使用SpannableString实现复杂样式",
                "Button的点击事件可以通过setOnClickListener或XML的onClick属性处理",
                "RecyclerView需要设置LayoutManager，常用的有LinearLayoutManager、GridLayoutManager",
                "ImageView的scaleType影响图片显示效果，需要根据需求选择"
            ),
            practiceTips = "建议使用RecyclerView替代ListView，性能更好且功能更强大。从网络加载图片使用Glide或Coil，它们提供了缓存、占位符等功能。EditText使用inputType限制输入类型，提升用户体验。TextView可以使用SpannableString实现富文本效果。注意组件的性能，避免在列表中使用复杂的布局。"
        ),
        
        KnowledgeDetail(
            id = "material_design",
            title = "Material Design、Material Components",
            overview = "Material Design是Google的设计语言，Material Components是Material Design的Android实现。使用Material Components可以快速构建符合Material Design规范的应用。",
            keyPoints = listOf(
                "Material Design：Google的设计语言，强调卡片、阴影、动画等视觉元素",
                "Material Components：Material Design的Android组件库，提供Material风格的UI组件",
                "主题系统：使用Theme和Style定义应用的外观，支持亮色和暗色主题",
                "颜色系统：使用Material颜色系统定义主色、辅助色等",
                "文字排版：使用Material文字排版系统定义文字样式",
                "动画：使用Material动画提供流畅的交互体验"
            ),
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：Material Components使用",
                    code = """
                        // build.gradle
                        // implementation 'com.google.android.material:material:1.9.0'
                        
                        <!-- MaterialButton -->
                        <com.google.android.material.button.MaterialButton
                            android:layout_width="wrap_content"
                            android:layout_height="wrap_content"
                            android:text="Material按钮"
                            app:icon="@drawable/ic_add"
                            style="@style/Widget.MaterialComponents.Button" />
                        
                        <!-- MaterialCardView -->
                        <com.google.android.material.card.MaterialCardView
                            android:layout_width="match_parent"
                            android:layout_height="wrap_content"
                            app:cardCornerRadius="8dp"
                            app:cardElevation="4dp">
                            
                            <TextView
                                android:layout_width="match_parent"
                                android:layout_height="wrap_content"
                                android:text="卡片内容" />
                        </com.google.android.material.card.MaterialCardView>
                        
                        <!-- TextInputLayout -->
                        <com.google.android.material.textfield.TextInputLayout
                            android:layout_width="match_parent"
                            android:layout_height="wrap_content"
                            app:hintEnabled="true"
                            app:hintAnimationEnabled="true">
                            
                            <com.google.android.material.textfield.TextInputEditText
                                android:layout_width="match_parent"
                                android:layout_height="wrap_content"
                                android:hint="请输入内容" />
                        </com.google.android.material.textfield.TextInputLayout>
                    """.trimIndent(),
                    explanation = "Material Components提供了Material风格的UI组件，如MaterialButton、MaterialCardView、TextInputLayout等。这些组件符合Material Design规范。"
                ),
                CodeExample(
                    title = "示例2：Material主题配置",
                    code = """
                        <!-- res/values/themes.xml -->
                        <resources>
                            <style name="Theme.MyApp" parent="Theme.MaterialComponents.DayNight">
                                <!-- 主色 -->
                                <item name="colorPrimary">@color/purple_500</item>
                                <item name="colorPrimaryVariant">@color/purple_700</item>
                                
                                <!-- 辅助色 -->
                                <item name="colorSecondary">@color/teal_200</item>
                                <item name="colorSecondaryVariant">@color/teal_700</item>
                                
                                <!-- 背景色 -->
                                <item name="colorSurface">@color/white</item>
                                <item name="colorBackground">@color/white</item>
                                
                                <!-- 文字颜色 -->
                                <item name="colorOnPrimary">@color/white</item>
                                <item name="colorOnSecondary">@color/black</item>
                                <item name="colorOnSurface">@color/black</item>
                                
                                <!-- 其他 -->
                                <item name="android:statusBarColor">@color/purple_700</item>
                            </style>
                        </resources>
                        
                        <!-- AndroidManifest.xml -->
                        // <application
                        //     android:theme="@style/Theme.MyApp">
                    """.trimIndent(),
                    explanation = "Material主题使用Theme.MaterialComponents作为父主题，可以配置颜色、文字等样式。支持亮色和暗色主题。"
                ),
                CodeExample(
                    title = "示例3：Material动画",
                    code = """
                        // 共享元素转场动画
                        val intent = Intent(this, DetailActivity::class.java)
                        val options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                            this,
                            Pair.create(imageView, "image_transition")
                        )
                        startActivity(intent, options.toBundle())
                        
                        // Material按钮波纹效果（自动支持）
                        <com.google.android.material.button.MaterialButton
                            android:layout_width="wrap_content"
                            android:layout_height="wrap_content"
                            android:text="按钮"
                            android:backgroundTint="@color/primary" />
                        
                        // FloatingActionButton
                        <com.google.android.material.floatingactionbutton.FloatingActionButton
                            android:layout_width="wrap_content"
                            android:layout_height="wrap_content"
                            android:src="@drawable/ic_add"
                            app:fabSize="normal" />
                    """.trimIndent(),
                    explanation = "Material Components自动支持Material动画，如波纹效果、共享元素转场等。这些动画提供了流畅的交互体验。"
                )
            ),
            useCases = listOf(
                "统一设计：使用Material Components实现统一的Material Design风格",
                "主题定制：使用Material主题系统定制应用外观",
                "用户体验：使用Material动画和交互提升用户体验",
                "快速开发：使用Material Components快速构建符合规范的UI",
                "暗色主题：使用Material主题系统支持暗色主题"
            ),
            notes = listOf(
                "Material Components是Material Design的Android实现",
                "使用Theme.MaterialComponents作为父主题",
                "Material颜色系统定义了主色、辅助色等颜色角色",
                "Material动画自动支持，如波纹效果、转场动画等",
                "支持亮色和暗色主题，可以通过系统设置切换",
                "Material Components提供了丰富的组件，如Button、Card、TextField等",
                "使用Material Components可以快速构建符合Material Design规范的应用"
            ),
            practiceTips = "建议使用Material Components构建应用，它提供了符合Material Design规范的组件和主题系统。使用Material主题可以快速定制应用外观，支持亮色和暗色主题。注意颜色系统的使用，确保文字在背景上的可读性。使用Material动画可以提升用户体验，但要注意性能。"
        ),
        
        KnowledgeDetail(
            id = "resources",
            title = "资源管理（资源类型、资源限定符）",
            overview = "Android使用资源系统管理应用中的各种资源，包括布局、图片、字符串、颜色等。理解资源类型和资源限定符可以实现多屏幕适配和国际化。",
            keyPoints = listOf(
                "资源类型：布局、图片、字符串、颜色、尺寸、样式等不同类型的资源",
                "资源限定符：使用限定符为不同配置提供不同资源，如屏幕尺寸、语言、方向等",
                "多屏幕支持：使用资源限定符为不同屏幕尺寸提供不同布局和资源",
                "国际化：使用语言限定符实现多语言支持",
                "资源访问：在代码和XML中访问资源",
                "资源命名：遵循资源命名规范，使用小写字母和下划线"
            ),
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：资源类型",
                    code = """
                        <!-- res/layout/activity_main.xml - 布局资源 -->
                        <LinearLayout>
                            <TextView android:text="@string/app_name" />
                        </LinearLayout>
                        
                        <!-- res/values/strings.xml - 字符串资源 -->
                        <resources>
                            <string name="app_name">我的应用</string>
                            <string name="welcome_message">欢迎使用</string>
                        </resources>
                        
                        <!-- res/values/colors.xml - 颜色资源 -->
                        <resources>
                            <color name="primary">#6200EE</color>
                            <color name="primary_dark">#3700B3</color>
                        </resources>
                        
                        <!-- res/values/dimens.xml - 尺寸资源 -->
                        <resources>
                            <dimen name="padding_small">8dp</dimen>
                            <dimen name="padding_medium">16dp</dimen>
                            <dimen name="padding_large">24dp</dimen>
                        </resources>
                        
                        <!-- res/drawable/ic_launcher.xml - 可绘制资源 -->
                        <vector xmlns:android="http://schemas.android.com/apk/res/android">
                            <path android:fillColor="#FF000000"
                                  android:pathData="M12,2L2,7v10c0,5.55 3.84,10.74 9,12 5.16,-1.26 9,-6.45 9,-12V7z"/>
                        </vector>
                    """.trimIndent(),
                    explanation = "Android支持多种资源类型，包括布局、字符串、颜色、尺寸、可绘制资源等。资源文件放在res目录下的相应子目录中。"
                ),
                CodeExample(
                    title = "示例2：资源限定符",
                    code = """
                        <!-- 默认布局：res/layout/activity_main.xml -->
                        <LinearLayout>
                            <TextView android:text="默认布局" />
                        </LinearLayout>
                        
                        <!-- 横屏布局：res/layout-land/activity_main.xml -->
                        <LinearLayout android:orientation="horizontal">
                            <TextView android:text="横屏布局" />
                        </LinearLayout>
                        
                        <!-- 大屏布局：res/layout-large/activity_main.xml -->
                        <LinearLayout>
                            <TextView android:text="大屏布局" />
                        </LinearLayout>
                        
                        <!-- 平板布局：res/layout-sw600dp/activity_main.xml -->
                        <LinearLayout>
                            <TextView android:text="平板布局" />
                        </LinearLayout>
                        
                        <!-- 不同密度图片 -->
                        // res/drawable-mdpi/icon.png (中密度)
                        // res/drawable-hdpi/icon.png (高密度)
                        // res/drawable-xhdpi/icon.png (超高密度)
                        // res/drawable-xxhdpi/icon.png (超超高密度)
                        // res/drawable-xxxhdpi/icon.png (超超超高密度)
                        
                        <!-- 不同语言字符串 -->
                        // res/values/strings.xml (默认，中文)
                        // res/values-en/strings.xml (英文)
                        // res/values-ja/strings.xml (日文)
                    """.trimIndent(),
                    explanation = "资源限定符用于为不同配置提供不同资源。常用限定符包括屏幕方向（land）、屏幕尺寸（large、sw600dp）、密度（mdpi、hdpi等）、语言（en、ja等）。"
                ),
                CodeExample(
                    title = "示例3：在代码中访问资源",
                    code = """
                        class MainActivity : AppCompatActivity() {
                            override fun onCreate(savedInstanceState: Bundle?) {
                                super.onCreate(savedInstanceState)
                                setContentView(R.layout.activity_main)
                                
                                // 访问字符串资源
                                val appName = getString(R.string.app_name)
                                
                                // 访问颜色资源
                                val primaryColor = getColor(R.color.primary)
                                
                                // 访问尺寸资源
                                val padding = resources.getDimensionPixelSize(R.dimen.padding_medium)
                                
                                // 访问可绘制资源
                                val drawable = getDrawable(R.drawable.ic_launcher)
                                
                                // 访问数组资源
                                val stringArray = resources.getStringArray(R.array.items)
                                
                                // 设置资源
                                findViewById<TextView>(R.id.textView).apply {
                                    text = getString(R.string.welcome_message)
                                    setTextColor(getColor(R.color.primary))
                                    setPadding(padding, padding, padding, padding)
                                    background = drawable
                                }
                            }
                        }
                    """.trimIndent(),
                    explanation = "在代码中可以通过resources对象或Context的方法访问资源。getString访问字符串，getColor访问颜色，getDimensionPixelSize访问尺寸等。"
                ),
                CodeExample(
                    title = "示例4：国际化（多语言）",
                    code = """
                        <!-- res/values/strings.xml (默认，中文) -->
                        <resources>
                            <string name="app_name">我的应用</string>
                            <string name="welcome">欢迎</string>
                        </resources>
                        
                        <!-- res/values-en/strings.xml (英文) -->
                        <resources>
                            <string name="app_name">My App</string>
                            <string name="welcome">Welcome</string>
                        </resources>
                        
                        <!-- res/values-ja/strings.xml (日文) -->
                        <resources>
                            <string name="app_name">私のアプリ</string>
                            <string name="welcome">ようこそ</string>
                        </resources>
                        
                        // 在代码中使用
                        class MainActivity : AppCompatActivity() {
                            override fun onCreate(savedInstanceState: Bundle?) {
                                super.onCreate(savedInstanceState)
                                setContentView(R.layout.activity_main)
                                
                                // 自动根据系统语言获取对应字符串
                                findViewById<TextView>(R.id.textView).text = getString(R.string.welcome)
                            }
                        }
                        
                        // 语言代码：
                        // - en: 英文
                        // - zh: 中文
                        // - ja: 日文
                        // - fr: 法文
                        // - de: 德文
                        // 等等...
                    """.trimIndent(),
                    explanation = "国际化通过为不同语言提供不同的字符串资源实现。系统会根据用户的语言设置自动选择对应的资源。使用values-语言代码目录存放不同语言的资源。"
                )
            ),
            useCases = listOf(
                "多屏幕适配：使用资源限定符为不同屏幕尺寸提供不同布局",
                "国际化：使用语言限定符实现多语言支持",
                "横竖屏适配：使用方向限定符为横竖屏提供不同布局",
                "不同密度适配：使用密度限定符为不同密度屏幕提供不同图片",
                "主题定制：使用样式资源定制应用外观"
            ),
            notes = listOf(
                "资源限定符可以组合使用，如layout-sw600dp-land表示宽度600dp且横屏",
                "系统会根据设备配置自动选择最匹配的资源",
                "如果没有匹配的资源，会使用默认资源（无限定符）",
                "资源命名使用小写字母和下划线，如app_name、primary_color",
                "字符串资源支持参数，使用%1\$s、%2\$d等占位符",
                "颜色资源可以使用颜色值或颜色资源引用",
                "尺寸资源使用dp、sp等单位，系统会根据密度自动转换"
            ),
            practiceTips = "建议使用资源系统管理所有资源，不要硬编码字符串、颜色等。使用资源限定符实现多屏幕适配和国际化。遵循资源命名规范，使用小写字母和下划线。为不同屏幕尺寸提供不同布局，提升用户体验。使用字符串资源支持国际化，避免硬编码文本。定期检查资源使用，避免未使用的资源增加APK体积。"
        ),
        
        // ========== Jetpack Compose ==========
        
        KnowledgeDetail(
            id = "compose_basic",
            title = "Compose基础（声明式UI、@Composable函数、重组）",
            overview = "Jetpack Compose是Android的现代UI工具包，采用声明式UI范式。理解Compose的核心概念（@Composable函数、重组机制）是掌握Compose开发的基础。",
            keyPoints = listOf(
                "声明式UI：描述UI应该是什么样子，而不是如何构建",
                "@Composable函数：用于构建UI的函数，可以组合其他Composable函数",
                "重组（Recomposition）：当状态变化时，Compose自动重新执行相关函数",
                "状态提升：将状态提升到共同父级，实现状态共享",
                "副作用：使用LaunchedEffect、DisposableEffect等处理副作用",
                "性能优化：使用remember、derivedStateOf等优化重组性能"
            ),
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：基础Composable函数",
                    code = """
                        @Composable
                        fun Greeting(name: String) {
                            // Text是Material Design的Composable函数
                            Text(
                                text = "Hello, ${'$'}name!",
                                style = MaterialTheme.typography.headlineMedium,
                                modifier = Modifier.padding(16.dp)
                            )
                        }
                        
                        // 使用Composable函数
                        @Composable
                        fun MyScreen() {
                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(16.dp),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Greeting("Android")
                                Spacer(modifier = Modifier.height(16.dp))
                                Button(onClick = { /* 处理点击 */ }) {
                                    Text("Click Me")
                                }
                            }
                        }
                    """.trimIndent(),
                    explanation = "@Composable函数用于构建UI，可以组合其他Composable函数。函数名通常使用PascalCase命名。"
                ),
                CodeExample(
                    title = "示例2：状态管理和重组",
                    code = """
                        @Composable
                        fun Counter() {
                            // 使用remember保存状态，避免每次重组时重置
                            var count by remember { mutableStateOf(0) }
                            
                            Column(
                                modifier = Modifier.padding(16.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = "Count: ${'$'}count",
                                    style = MaterialTheme.typography.headlineMedium
                                )
                                
                                Spacer(modifier = Modifier.height(16.dp))
                                
                                Row(
                                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                                ) {
                                    Button(onClick = { count-- }) {
                                        Text("-")
                                    }
                                    Button(onClick = { count++ }) {
                                        Text("+")
                                    }
                                }
                            }
                        }
                        
                        // 状态提升示例
                        @Composable
                        fun CounterScreen() {
                            var count by remember { mutableStateOf(0) }
                            
                            // 状态提升到父级，可以传递给多个子组件
                            Counter(
                                count = count,
                                onIncrement = { count++ },
                                onDecrement = { count-- }
                            )
                        }
                        
                        @Composable
                        fun Counter(
                            count: Int,
                            onIncrement: () -> Unit,
                            onDecrement: () -> Unit
                        ) {
                            // 无状态Composable，更容易测试和复用
                        }
                    """.trimIndent(),
                    explanation = "remember用于在重组间保持状态，mutableStateOf创建可变状态。状态变化会触发重组，只重组读取该状态的Composable函数。"
                ),
                CodeExample(
                    title = "示例3：副作用处理",
                    code = """
                        @Composable
                        fun TimerScreen() {
                            var time by remember { mutableStateOf(0) }
                            
                            // LaunchedEffect：在Composable进入组合时执行一次
                            LaunchedEffect(Unit) {
                                while (true) {
                                    delay(1000)
                                    time++
                                }
                            }
                            
                            Text("Time: ${'$'}time seconds")
                        }
                        
                        @Composable
                        fun DataScreen(key: String) {
                            var data by remember { mutableStateOf<String?>(null) }
                            
                            // LaunchedEffect：当key变化时重新执行
                            LaunchedEffect(key) {
                                data = loadData(key)  // 假设的加载函数
                            }
                            
                            data?.let {
                                Text(it)
                            } ?: CircularProgressIndicator()
                        }
                        
                        @Composable
                        fun DisposableEffectExample() {
                            val lifecycleOwner = LocalLifecycleOwner.current
                            
                            // DisposableEffect：在进入组合时执行，退出时清理
                            DisposableEffect(lifecycleOwner) {
                                val observer = LifecycleEventObserver { _, event ->
                                    // 处理生命周期事件
                                }
                                lifecycleOwner.lifecycle.addObserver(observer)
                                
                                onDispose {
                                    lifecycleOwner.lifecycle.removeObserver(observer)
                                }
                            }
                        }
                    """.trimIndent(),
                    explanation = "LaunchedEffect用于执行副作用（如协程、API调用），DisposableEffect用于需要清理的副作用（如注册监听器）。"
                )
            ),
            useCases = listOf(
                "现代UI开发：使用Compose构建声明式、响应式的用户界面",
                "状态管理：使用State和StateFlow管理UI状态",
                "动画：使用Compose Animation API创建流畅的动画效果",
                "主题定制：使用Material 3主题系统实现应用主题",
                "列表展示：使用LazyColumn和LazyRow实现高效的长列表"
            ),
            notes = listOf(
                "@Composable函数可以在任何地方调用，但只能在其他@Composable函数中调用",
                "重组是智能的，只重组读取变化状态的Composable函数",
                "避免在Composable函数中执行耗时操作，应该使用LaunchedEffect",
                "remember用于在重组间保持值，不要用于跨配置变更保持（使用rememberSaveable）",
                "状态提升是Compose的重要模式，有助于提高代码可测试性",
                "避免在Composable函数中创建对象，应该使用remember"
            ),
            practiceTips = "建议从简单的Composable函数开始，逐步学习状态管理、布局和动画。使用Compose Preview可以快速预览UI。对于复杂的状态管理，考虑使用ViewModel和StateFlow。注意性能优化，避免不必要的重组。"
        ),
        
        KnowledgeDetail(
            id = "compose_layout",
            title = "Compose布局（Column、Row、Box、Modifier）",
            overview = "Compose布局系统使用Column、Row、Box等基础布局组件和Modifier修饰符来构建UI。理解布局系统和Modifier的使用是掌握Compose布局的关键。",
            keyPoints = listOf(
                "Column：垂直排列子组件的布局容器",
                "Row：水平排列子组件的布局容器",
                "Box：叠加排列子组件的布局容器",
                "Modifier：修饰符系统，用于设置组件的样式、大小、间距等",
                "布局约束：理解Compose的布局约束系统，实现复杂布局",
                "自定义布局：使用Layout Composable创建自定义布局"
            ),
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：Column和Row基础使用",
                    code = """
                        @Composable
                        fun LayoutExample() {
                            // Column：垂直排列
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp),
                                verticalArrangement = Arrangement.spacedBy(8.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text("标题")
                                Text("内容1")
                                Text("内容2")
                                Button(onClick = { }) {
                                    Text("按钮")
                                }
                            }
                            
                            // Row：水平排列
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text("左侧")
                                Text("中间")
                                Text("右侧")
                            }
                        }
                    """.trimIndent(),
                    explanation = "Column用于垂直排列，Row用于水平排列。verticalArrangement和horizontalArrangement控制子组件的排列方式，alignment控制对齐方式。"
                ),
                CodeExample(
                    title = "示例2：Box叠加布局",
                    code = """
                        @Composable
                        fun BoxExample() {
                            Box(
                                modifier = Modifier
                                    .size(200.dp)
                                    .background(Color.Gray)
                            ) {
                                // 底层：图片
                                Image(
                                    painter = rememberImagePainter("https://example.com/image.jpg"),
                                    contentDescription = null,
                                    modifier = Modifier.fillMaxSize()
                                )
                                
                                // 中层：渐变遮罩
                                Box(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .background(
                                            Brush.verticalGradient(
                                                colors = listOf(
                                                    Color.Transparent,
                                                    Color.Black.copy(alpha = 0.7f)
                                                )
                                            )
                                        )
                                )
                                
                                // 顶层：文字
                                Text(
                                    text = "标题",
                                    color = Color.White,
                                    modifier = Modifier
                                        .align(Alignment.BottomCenter)
                                        .padding(16.dp),
                                    style = MaterialTheme.typography.headlineMedium
                                )
                            }
                        }
                    """.trimIndent(),
                    explanation = "Box用于叠加排列子组件，后添加的组件在上层。使用align可以控制子组件在Box中的位置。"
                ),
                CodeExample(
                    title = "示例3：Modifier修饰符系统",
                    code = """
                        @Composable
                        fun ModifierExample() {
                            Text(
                                text = "Hello Compose",
                                modifier = Modifier
                                    // 尺寸
                                    .size(width = 200.dp, height = 100.dp)
                                    .fillMaxWidth()  // 填充最大宽度
                                    .fillMaxHeight()  // 填充最大高度
                                    
                                    // 间距
                                    .padding(16.dp)  // 内边距
                                    .padding(horizontal = 16.dp, vertical = 8.dp)
                                    
                                    // 背景和边框
                                    .background(Color.Blue)
                                    .border(2.dp, Color.Red, RoundedCornerShape(8.dp))
                                    
                                    // 点击事件
                                    .clickable { /* 处理点击 */ }
                                    
                                    // 滚动
                                    .verticalScroll(rememberScrollState())
                                    
                                    // 透明度
                                    .alpha(0.8f)
                                    
                                    // 旋转和缩放
                                    .rotate(45f)
                                    .scale(1.2f)
                            )
                            
                            // Modifier可以链式调用，顺序很重要
                            // 例如：padding在background之前，padding会影响background的范围
                        }
                    """.trimIndent(),
                    explanation = "Modifier用于设置组件的样式、大小、间距等。可以链式调用多个Modifier，顺序会影响效果。"
                ),
                CodeExample(
                    title = "示例4：自定义布局",
                    code = """
                        @Composable
                        fun CustomLayout(
                            modifier: Modifier = Modifier,
                            content: @Composable () -> Unit
                        ) {
                            Layout(
                                modifier = modifier,
                                content = content
                            ) { measurables, constraints ->
                                // 测量所有子组件
                                val placeables = measurables.map { it.measure(constraints) }
                                
                                // 计算布局大小
                                val width = placeables.maxOfOrNull { it.width } ?: 0
                                val height = placeables.sumOf { it.height }
                                
                                // 布局子组件
                                layout(width, height) {
                                    var yPosition = 0
                                    placeables.forEach { placeable ->
                                        placeable.placeRelative(x = 0, y = yPosition)
                                        yPosition += placeable.height
                                    }
                                }
                            }
                        }
                        
                        // 使用自定义布局
                        @Composable
                        fun CustomLayoutExample() {
                            CustomLayout(
                                modifier = Modifier.padding(16.dp)
                            ) {
                                Text("项目1")
                                Text("项目2")
                                Text("项目3")
                            }
                        }
                    """.trimIndent(),
                    explanation = "使用Layout Composable可以创建自定义布局。需要实现测量（measure）和布局（layout）逻辑。"
                )
            ),
            useCases = listOf(
                "页面布局：使用Column、Row、Box构建页面布局",
                "列表项布局：使用Row和Column构建列表项",
                "叠加效果：使用Box实现图片叠加文字等效果",
                "样式定制：使用Modifier定制组件的外观和行为",
                "复杂布局：使用自定义Layout实现特殊布局需求"
            ),
            notes = listOf(
                "Column和Row的arrangement控制子组件的排列方式",
                "Modifier的顺序很重要，会影响最终效果",
                "Box用于叠加布局，后添加的组件在上层",
                "使用fillMaxSize()可以让组件填充父容器",
                "padding和margin在Compose中都是使用padding Modifier",
                "自定义布局需要理解Compose的测量和布局流程",
                "使用Layout Inspector可以查看Compose的布局层次"
            ),
            practiceTips = "建议先掌握Column、Row、Box这三个基础布局，它们是Compose布局的基础。理解Modifier的使用，它是Compose样式系统的核心。对于复杂布局，考虑使用自定义Layout。注意Modifier的顺序，它会影响最终效果。使用Compose Preview可以快速预览布局效果。"
        ),
        
        KnowledgeDetail(
            id = "compose_material",
            title = "Material 3组件、主题系统",
            overview = "Material 3是Google最新的设计系统，Compose提供了完整的Material 3组件库和主题系统。使用Material 3可以快速构建符合现代设计规范的应用。",
            keyPoints = listOf(
                "Material 3组件：Button、TextField、Card、FloatingActionButton等组件",
                "主题系统：使用MaterialTheme定义应用的主题，包括颜色、文字、形状等",
                "颜色系统：Material 3的颜色系统，包括主色、辅助色、表面色等",
                "文字排版：Material 3的文字排版系统，定义文字样式",
                "形状系统：Material 3的形状系统，定义组件的圆角等",
                "暗色主题：支持亮色和暗色主题切换"
            ),
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：Material 3组件使用",
                    code = """
                        @Composable
                        fun MaterialComponentsExample() {
                            Column(
                                modifier = Modifier.padding(16.dp),
                                verticalArrangement = Arrangement.spacedBy(16.dp)
                            ) {
                                // Button
                                Button(onClick = { }) {
                                    Text("按钮")
                                }
                                
                                // TextField
                                var text by remember { mutableStateOf("") }
                                TextField(
                                    value = text,
                                    onValueChange = { text = it },
                                    label = { Text("输入框") },
                                    placeholder = { Text("请输入内容") }
                                )
                                
                                // Card
                                Card(
                                    onClick = { },
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Column(modifier = Modifier.padding(16.dp)) {
                                        Text("卡片标题")
                                        Text("卡片内容")
                                    }
                                }
                                
                                // FloatingActionButton
                                FloatingActionButton(onClick = { }) {
                                    Icon(Icons.Default.Add, contentDescription = "添加")
                                }
                                
                                // Switch
                                var checked by remember { mutableStateOf(false) }
                                Switch(
                                    checked = checked,
                                    onCheckedChange = { checked = it }
                                )
                            }
                        }
                    """.trimIndent(),
                    explanation = "Material 3提供了丰富的组件，如Button、TextField、Card等。这些组件符合Material Design规范，提供一致的用户体验。"
                ),
                CodeExample(
                    title = "示例2：Material主题配置",
                    code = """
                        // 定义颜色方案
                        private val LightColorScheme = lightColorScheme(
                            primary = Color(0xFF6750A4),
                            onPrimary = Color(0xFFFFFFFF),
                            primaryContainer = Color(0xFFEADDFF),
                            onPrimaryContainer = Color(0xFF21005D),
                            secondary = Color(0xFF625B71),
                            onSecondary = Color(0xFFFFFFFF),
                            // ... 其他颜色
                        )
                        
                        private val DarkColorScheme = darkColorScheme(
                            primary = Color(0xFFD0BCFF),
                            onPrimary = Color(0xFF381E72),
                            // ... 其他颜色
                        )
                        
                        // 应用主题
                        @Composable
                        fun MyApp() {
                            val colorScheme = if (isSystemInDarkTheme()) {
                                DarkColorScheme
                            } else {
                                LightColorScheme
                            }
                            
                            MaterialTheme(
                                colorScheme = colorScheme,
                                typography = Typography,
                                shapes = Shapes
                            ) {
                                // 应用内容
                                Surface(
                                    modifier = Modifier.fillMaxSize(),
                                    color = MaterialTheme.colorScheme.background
                                ) {
                                    MyScreen()
                                }
                            }
                        }
                        
                        // 使用主题
                        @Composable
                        fun MyScreen() {
                            Text(
                                text = "Hello",
                                color = MaterialTheme.colorScheme.primary,
                                style = MaterialTheme.typography.headlineLarge
                            )
                        }
                    """.trimIndent(),
                    explanation = "MaterialTheme用于定义应用的主题，包括颜色方案、文字排版、形状等。支持亮色和暗色主题。"
                ),
                CodeExample(
                    title = "示例3：Material形状系统",
                    code = """
                        // 定义形状
                        val Shapes = Shapes(
                            extraSmall = RoundedCornerShape(4.dp),
                            small = RoundedCornerShape(8.dp),
                            medium = RoundedCornerShape(12.dp),
                            large = RoundedCornerShape(16.dp),
                            extraLarge = RoundedCornerShape(28.dp)
                        )
                        
                        // 在主题中使用
                        MaterialTheme(
                            colorScheme = colorScheme,
                            typography = Typography,
                            shapes = Shapes
                        ) {
                            // 组件会自动使用主题中的形状
                            Card(
                                shape = MaterialTheme.shapes.medium,
                                modifier = Modifier.padding(16.dp)
                            ) {
                                Text("卡片内容")
                            }
                        }
                    """.trimIndent(),
                    explanation = "Material形状系统定义了组件的圆角等形状属性。不同尺寸的组件使用不同大小的形状，保持视觉一致性。"
                )
            ),
            useCases = listOf(
                "快速开发：使用Material 3组件快速构建符合规范的UI",
                "主题定制：使用Material主题系统定制应用外观",
                "暗色主题：使用Material主题系统支持暗色主题",
                "一致性：使用Material组件保持应用UI的一致性",
                "现代化：使用Material 3实现现代化的UI设计"
            ),
            notes = listOf(
                "Material 3是Google最新的设计系统，替代了Material 2",
                "MaterialTheme用于定义应用的主题，包括颜色、文字、形状",
                "支持亮色和暗色主题，可以通过isSystemInDarkTheme()检测",
                "Material组件会自动使用主题中的颜色、文字、形状",
                "颜色系统定义了主色、辅助色、表面色等颜色角色",
                "文字排版系统定义了不同级别的文字样式",
                "形状系统定义了组件的圆角等形状属性"
            ),
            practiceTips = "建议使用Material 3组件构建应用，它提供了符合现代设计规范的组件和主题系统。使用MaterialTheme定义应用主题，支持亮色和暗色主题。注意颜色系统的使用，确保文字在背景上的可读性。使用Material形状系统保持视觉一致性。定期更新Material组件库以获得最新特性。"
        ),
        
        KnowledgeDetail(
            id = "compose_state",
            title = "状态管理（State、StateFlow、ViewModel集成）",
            overview = "Compose的状态管理是构建响应式UI的关键。理解State、StateFlow和ViewModel的使用，可以实现数据驱动的UI更新。",
            keyPoints = listOf(
                "State：Compose的状态类型，使用mutableStateOf创建可变状态",
                "StateFlow：Kotlin Flow的状态流，用于在ViewModel中管理状态",
                "ViewModel集成：使用ViewModel管理业务逻辑和状态，与Compose集成",
                "状态提升：将状态提升到共同父级，实现状态共享",
                "状态恢复：使用rememberSaveable保存和恢复状态",
                "状态收集：使用collectAsState收集StateFlow，自动更新UI"
            ),
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：State基础使用",
                    code = """
                        @Composable
                        fun StateExample() {
                            // 使用remember和mutableStateOf创建状态
                            var count by remember { mutableStateOf(0) }
                            
                            Column {
                                Text("Count: ${'$'}count")
                                Button(onClick = { count++ }) {
                                    Text("增加")
                                }
                            }
                            
                            // 多个状态
                            var name by remember { mutableStateOf("") }
                            var age by remember { mutableStateOf(0) }
                            
                            Column {
                                TextField(
                                    value = name,
                                    onValueChange = { name = it },
                                    label = { Text("姓名") }
                                )
                                TextField(
                                    value = age.toString(),
                                    onValueChange = { age = it.toIntOrNull() ?: 0 },
                                    label = { Text("年龄") }
                                )
                            }
                        }
                    """.trimIndent(),
                    explanation = "使用remember和mutableStateOf创建状态。状态变化会触发重组，只重组读取该状态的Composable函数。"
                ),
                CodeExample(
                    title = "示例2：ViewModel和StateFlow集成",
                    code = """
                        // ViewModel
                        class MyViewModel : ViewModel() {
                            private val _uiState = MutableStateFlow(MyUiState())
                            val uiState: StateFlow<MyUiState> = _uiState.asStateFlow()
                            
                            fun updateName(name: String) {
                                _uiState.update { it.copy(name = name) }
                            }
                        }
                        
                        data class MyUiState(
                            val name: String = "",
                            val isLoading: Boolean = false
                        )
                        
                        // 在Compose中使用
                        @Composable
                        fun MyScreen(viewModel: MyViewModel = viewModel()) {
                            // 收集StateFlow
                            val uiState by viewModel.uiState.collectAsState()
                            
                            Column {
                                TextField(
                                    value = uiState.name,
                                    onValueChange = { viewModel.updateName(it) },
                                    label = { Text("姓名") }
                                )
                                
                                if (uiState.isLoading) {
                                    CircularProgressIndicator()
                                }
                            }
                        }
                    """.trimIndent(),
                    explanation = "ViewModel使用StateFlow管理状态，Compose使用collectAsState收集StateFlow。状态变化会自动更新UI。"
                ),
                CodeExample(
                    title = "示例3：状态提升",
                    code = """
                        // 无状态Composable（推荐）
                        @Composable
                        fun Counter(
                            count: Int,
                            onIncrement: () -> Unit,
                            onDecrement: () -> Unit
                        ) {
                            Column {
                                Text("Count: ${'$'}count")
                                Row {
                                    Button(onClick = onDecrement) { Text("-") }
                                    Button(onClick = onIncrement) { Text("+") }
                                }
                            }
                        }
                        
                        // 有状态Composable（状态提升到父级）
                        @Composable
                        fun CounterScreen() {
                            var count by remember { mutableStateOf(0) }
                            
                            // 状态提升，可以传递给多个子组件
                            Counter(
                                count = count,
                                onIncrement = { count++ },
                                onDecrement = { count-- }
                            )
                            
                            // 另一个组件也可以使用同一个状态
                            Text("当前计数: ${'$'}count")
                        }
                    """.trimIndent(),
                    explanation = "状态提升是将状态提升到共同父级，子组件通过参数接收状态和回调。这样可以让组件更容易测试和复用。"
                ),
                CodeExample(
                    title = "示例4：状态恢复（rememberSaveable）",
                    code = """
                        @Composable
                        fun StateRestorationExample() {
                            // rememberSaveable：配置变更时保存和恢复状态
                            var count by rememberSaveable { mutableStateOf(0) }
                            
                            // 自定义Saver
                            var customData by rememberSaveable(
                                saver = Saver(
                                    save = { it.toString() },
                                    restore = { it.toIntOrNull() ?: 0 }
                                )
                            ) { mutableStateOf(0) }
                            
                            Column {
                                Text("Count: ${'$'}count")
                                Button(onClick = { count++ }) {
                                    Text("增加")
                                }
                            }
                        }
                    """.trimIndent(),
                    explanation = "rememberSaveable用于在配置变更（如屏幕旋转）时保存和恢复状态。remember只会在重组间保持状态，不会跨配置变更。"
                )
            ),
            useCases = listOf(
                "UI状态管理：使用State管理UI组件的状态",
                "业务逻辑：使用ViewModel管理业务逻辑和状态",
                "数据驱动：使用StateFlow实现数据驱动的UI更新",
                "状态共享：使用状态提升在多个组件间共享状态",
                "状态持久化：使用rememberSaveable保存和恢复状态"
            ),
            notes = listOf(
                "State变化会触发重组，只重组读取该状态的Composable函数",
                "remember用于在重组间保持值，rememberSaveable用于跨配置变更保持",
                "ViewModel使用StateFlow管理状态，Compose使用collectAsState收集",
                "状态提升是Compose的重要模式，有助于提高代码可测试性",
                "避免在Composable函数中创建ViewModel实例，应该使用viewModel()",
                "StateFlow是热流，会立即发送当前值给新的收集者",
                "使用derivedStateOf可以基于其他状态计算新状态"
            ),
            practiceTips = "建议使用ViewModel管理业务逻辑和状态，Compose只负责UI展示。使用StateFlow在ViewModel中管理状态，使用collectAsState在Compose中收集。遵循状态提升模式，让组件更容易测试和复用。使用rememberSaveable保存需要跨配置变更的状态。注意性能优化，避免不必要的重组。"
        ),
        
        KnowledgeDetail(
            id = "compose_navigation",
            title = "Compose导航（Navigation Compose）",
            overview = "Navigation Compose是Compose的导航库，用于在Compose应用中进行页面导航。理解Navigation Compose的使用可以实现类型安全的导航。",
            keyPoints = listOf(
                "NavController：导航控制器，用于执行导航操作",
                "NavHost：导航宿主，定义导航图和路由",
                "路由定义：使用composable函数定义路由和参数",
                "类型安全：使用Safe Args生成类型安全的导航代码",
                "深层链接：支持深层链接导航",
                "嵌套导航：支持嵌套导航图"
            ),
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：基础导航",
                    code = """
                        @Composable
                        fun NavigationExample() {
                            val navController = rememberNavController()
                            
                            NavHost(
                                navController = navController,
                                startDestination = "home"
                            ) {
                                composable("home") {
                                    HomeScreen(
                                        onNavigateToDetail = {
                                            navController.navigate("detail")
                                        }
                                    )
                                }
                                
                                composable("detail") {
                                    DetailScreen(
                                        onNavigateBack = {
                                            navController.popBackStack()
                                        }
                                    )
                                }
                            }
                        }
                        
                        @Composable
                        fun HomeScreen(onNavigateToDetail: () -> Unit) {
                            Column {
                                Text("首页")
                                Button(onClick = onNavigateToDetail) {
                                    Text("跳转到详情")
                                }
                            }
                        }
                        
                        @Composable
                        fun DetailScreen(onNavigateBack: () -> Unit) {
                            Column {
                                Text("详情页")
                                Button(onClick = onNavigateBack) {
                                    Text("返回")
                                }
                            }
                        }
                    """.trimIndent(),
                    explanation = "NavHost定义导航图，composable定义路由。使用navController.navigate导航，使用popBackStack返回。"
                ),
                CodeExample(
                    title = "示例2：参数传递",
                    code = """
                        @Composable
                        fun NavigationWithArgs() {
                            val navController = rememberNavController()
                            
                            NavHost(
                                navController = navController,
                                startDestination = "home"
                            ) {
                                composable("home") {
                                    HomeScreen(
                                        onNavigateToDetail = { id ->
                                            navController.navigate("detail/${'$'}id")
                                        }
                                    )
                                }
                                
                                composable(
                                    route = "detail/{itemId}",
                                    arguments = listOf(
                                        navArgument("itemId") { type = NavType.StringType }
                                    )
                                ) { backStackEntry ->
                                    val itemId = backStackEntry.arguments?.getString("itemId") ?: ""
                                    DetailScreen(
                                        itemId = itemId,
                                        onNavigateBack = {
                                            navController.popBackStack()
                                        }
                                    )
                                }
                            }
                        }
                        
                        // 使用类型安全的导航（推荐）
                        // 在build.gradle中添加：
                        // implementation "androidx.navigation:navigation-compose:2.8.4"
                        
                        // 定义路由（使用sealed class）
                        sealed class Screen(val route: String) {
                            object Home : Screen("home")
                            data class Detail(val id: String) : Screen("detail/${'$'}id")
                        }
                        
                        @Composable
                        fun TypeSafeNavigation() {
                            val navController = rememberNavController()
                            
                            NavHost(
                                navController = navController,
                                startDestination = Screen.Home.route
                            ) {
                                composable(Screen.Home.route) {
                                    HomeScreen(
                                        onNavigateToDetail = { id ->
                                            navController.navigate(Screen.Detail(id).route)
                                        }
                                    )
                                }
                                
                                composable(
                                    route = Screen.Detail.route,
                                    arguments = listOf(
                                        navArgument("id") { type = NavType.StringType }
                                    )
                                ) { backStackEntry ->
                                    val id = backStackEntry.arguments?.getString("id") ?: ""
                                    DetailScreen(itemId = id)
                                }
                            }
                        }
                    """.trimIndent(),
                    explanation = "可以通过路由参数传递数据。使用sealed class定义路由可以实现类型安全的导航。"
                ),
                CodeExample(
                    title = "示例3：深层链接",
                    code = """
                        @Composable
                        fun DeepLinkNavigation() {
                            val navController = rememberNavController()
                            
                            NavHost(
                                navController = navController,
                                startDestination = "home"
                            ) {
                                composable("home") {
                                    HomeScreen()
                                }
                                
                                composable(
                                    route = "detail/{id}",
                                    deepLinks = listOf(
                                        navDeepLink {
                                            uriPattern = "https://example.com/detail/{id}"
                                        },
                                        navDeepLink {
                                            uriPattern = "myapp://detail/{id}"
                                        }
                                    )
                                ) { backStackEntry ->
                                    val id = backStackEntry.arguments?.getString("id") ?: ""
                                    DetailScreen(itemId = id)
                                }
                            }
                        }
                        
                        // AndroidManifest.xml中配置
                        // <activity>
                        //     <intent-filter>
                        //         <action android:name="android.intent.action.VIEW" />
                        //         <category android:name="android.intent.category.DEFAULT" />
                        //         <category android:name="android.intent.category.BROWSABLE" />
                        //         <data android:scheme="https" android:host="example.com" />
                        //     </intent-filter>
                        // </activity>
                    """.trimIndent(),
                    explanation = "深层链接允许通过URL直接导航到应用内的特定页面。需要在NavHost中定义deepLinks，并在AndroidManifest.xml中配置intent-filter。"
                )
            ),
            useCases = listOf(
                "页面导航：在Compose应用中进行页面间的导航",
                "参数传递：在导航时传递参数",
                "深层链接：支持通过URL直接导航到应用内页面",
                "返回栈管理：管理导航返回栈",
                "嵌套导航：实现复杂的导航结构"
            ),
            notes = listOf(
                "NavController用于执行导航操作，NavHost定义导航图",
                "使用composable函数定义路由，可以传递参数",
                "使用sealed class定义路由可以实现类型安全的导航",
                "深层链接需要在NavHost和AndroidManifest.xml中配置",
                "popBackStack用于返回上一页，可以传递路由或ID",
                "支持嵌套导航图，可以组织复杂的导航结构",
                "导航参数可以是String、Int、Float等类型"
            ),
            practiceTips = "建议使用sealed class定义路由，实现类型安全的导航。使用NavHost定义导航图，使用composable定义路由。对于需要传递参数的路由，使用navArgument定义参数类型。支持深层链接可以提升用户体验。注意返回栈的管理，避免创建过深的返回栈。"
        ),
        
        KnowledgeDetail(
            id = "compose_animation",
            title = "Compose动画",
            overview = "Compose提供了强大的动画API，可以创建流畅的动画效果。理解Compose动画的使用可以提升用户体验。",
            keyPoints = listOf(
                "animateAsState：基于状态变化自动创建动画",
                "Transition动画：多个值之间的过渡动画",
                "AnimatedVisibility：显示和隐藏的动画",
                "手势动画：基于手势的动画",
                "自定义动画：使用AnimationSpec自定义动画曲线",
                "性能优化：动画性能优化技巧"
            ),
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：animateAsState基础使用",
                    code = """
                        @Composable
                        fun AnimateAsStateExample() {
                            var expanded by remember { mutableStateOf(false) }
                            
                            // 基于状态自动创建动画
                            val rotation by animateFloatAsState(
                                targetValue = if (expanded) 180f else 0f,
                                animationSpec = tween(durationMillis = 300)
                            )
                            
                            val scale by animateFloatAsState(
                                targetValue = if (expanded) 1.2f else 1f
                            )
                            
                            Column {
                                Icon(
                                    imageVector = Icons.Default.ExpandMore,
                                    contentDescription = null,
                                    modifier = Modifier
                                        .rotate(rotation)
                                        .scale(scale)
                                        .clickable { expanded = !expanded }
                                )
                                
                                if (expanded) {
                                    Text("展开的内容")
                                }
                            }
                        }
                    """.trimIndent(),
                    explanation = "animateAsState基于状态变化自动创建动画。当targetValue变化时，会自动从当前值动画到目标值。"
                ),
                CodeExample(
                    title = "示例2：AnimatedVisibility",
                    code = """
                        @Composable
                        fun AnimatedVisibilityExample() {
                            var visible by remember { mutableStateOf(false) }
                            
                            Column {
                                Button(onClick = { visible = !visible }) {
                                    Text(if (visible) "隐藏" else "显示")
                                }
                                
                                AnimatedVisibility(
                                    visible = visible,
                                    enter = fadeIn() + expandVertically(),
                                    exit = fadeOut() + shrinkVertically()
                                ) {
                                    Card(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(16.dp)
                                    ) {
                                        Text(
                                            "这是动画显示的内容",
                                            modifier = Modifier.padding(16.dp)
                                        )
                                    }
                                }
                            }
                        }
                        
                        // 常用动画效果：
                        // - fadeIn/fadeOut：淡入淡出
                        // - slideIn/slideOut：滑入滑出
                        // - expandIn/expandOut：展开收缩
                        // - scaleIn/scaleOut：缩放
                    """.trimIndent(),
                    explanation = "AnimatedVisibility用于显示和隐藏的动画。可以组合多个动画效果，如fadeIn + expandVertically。"
                ),
                CodeExample(
                    title = "示例3：Transition动画",
                    code = """
                        @Composable
                        fun TransitionExample() {
                            var currentState by remember { mutableStateOf(BoxState.Collapsed) }
                            
                            val transition = updateTransition(
                                targetState = currentState,
                                label = "box_transition"
                            )
                            
                            val alpha by transition.animateFloat(
                                transitionSpec = { tween(300) },
                                label = "alpha"
                            ) { state ->
                                if (state == BoxState.Expanded) 1f else 0.5f
                            }
                            
                            val scale by transition.animateFloat(
                                label = "scale"
                            ) { state ->
                                if (state == BoxState.Expanded) 1f else 0.8f
                            }
                            
                            Box(
                                modifier = Modifier
                                    .size(200.dp)
                                    .alpha(alpha)
                                    .scale(scale)
                                    .clickable {
                                        currentState = when (currentState) {
                                            BoxState.Collapsed -> BoxState.Expanded
                                            BoxState.Expanded -> BoxState.Collapsed
                                        }
                                    }
                            ) {
                                Text("点击切换状态")
                            }
                        }
                        
                        enum class BoxState { Collapsed, Expanded }
                    """.trimIndent(),
                    explanation = "Transition用于多个值之间的过渡动画。使用updateTransition创建Transition，然后为每个需要动画的值定义动画。"
                ),
                CodeExample(
                    title = "示例4：自定义动画曲线",
                    code = """
                        @Composable
                        fun CustomAnimationExample() {
                            var offset by remember { mutableStateOf(0f) }
                            
                            val animatedOffset by animateFloatAsState(
                                targetValue = offset,
                                animationSpec = spring(
                                    dampingRatio = Spring.DampingRatioMediumBouncy,
                                    stiffness = Spring.StiffnessLow
                                )
                            )
                            
                            // 其他动画曲线：
                            // - tween：线性插值
                            // - spring：弹簧动画
                            // - keyframes：关键帧动画
                            // - repeatable：重复动画
                            // - infiniteRepeatable：无限重复动画
                            
                            Box(
                                modifier = Modifier
                                    .offset(x = animatedOffset.dp)
                                    .clickable { offset = if (offset == 0f) 200f else 0f }
                            ) {
                                Text("点击移动")
                            }
                        }
                    """.trimIndent(),
                    explanation = "AnimationSpec用于自定义动画曲线。spring创建弹簧动画，tween创建线性动画，keyframes创建关键帧动画。"
                )
            ),
            useCases = listOf(
                "UI动画：为UI组件添加动画效果，提升用户体验",
                "状态切换：为状态切换添加过渡动画",
                "交互反馈：为用户交互添加动画反馈",
                "页面转场：为页面切换添加转场动画",
                "加载动画：为加载状态添加动画效果"
            ),
            notes = listOf(
                "animateAsState基于状态变化自动创建动画",
                "AnimatedVisibility用于显示和隐藏的动画",
                "Transition用于多个值之间的过渡动画",
                "AnimationSpec用于自定义动画曲线",
                "动画应该在UI线程执行，Compose会自动处理",
                "注意动画性能，避免创建过多动画",
                "使用remember保存动画状态，避免每次重组时重新创建"
            ),
            practiceTips = "建议使用animateAsState实现简单的状态动画，使用Transition实现复杂的状态切换动画。使用AnimatedVisibility实现显示隐藏动画。注意动画性能，避免创建过多动画。使用合适的动画曲线，如spring实现自然的动画效果。测试动画在不同设备上的性能。"
        ),
        
        KnowledgeDetail(
            id = "compose_advanced",
            title = "Compose高级特性（性能优化、自定义绘制）",
            overview = "Compose的高级特性包括性能优化、自定义绘制、与View系统互操作等。掌握这些特性可以构建高性能、功能丰富的应用。",
            keyPoints = listOf(
                "性能优化：使用LazyColumn、LazyRow实现高效列表，避免不必要的重组",
                "自定义绘制：使用Canvas和自定义绘制实现复杂图形",
                "与View系统互操作：在Compose中使用传统View，在View中使用Compose",
                "重组优化：使用derivedStateOf、remember等优化重组",
                "布局优化：使用SubcomposeLayout等优化布局性能",
                "调试工具：使用Compose工具调试和优化性能"
            ),
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：LazyColumn性能优化",
                    code = """
                        @Composable
                        fun LazyColumnExample(items: List<Item>) {
                            LazyColumn(
                                modifier = Modifier.fillMaxSize(),
                                contentPadding = PaddingValues(16.dp),
                                verticalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                items(
                                    items = items,
                                    key = { it.id }  // 使用key提升性能
                                ) { item ->
                                    ItemCard(item = item)
                                }
                                
                                // 添加头部
                                item {
                                    Header()
                                }
                                
                                // 添加尾部
                                item {
                                    Footer()
                                }
                            }
                        }
                        
                        @Composable
                        fun ItemCard(item: Item) {
                            // 使用remember避免每次重组时重新创建对象
                            val formattedDate = remember(item.date) {
                                formatDate(item.date)
                            }
                            
                            Card(
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Column(modifier = Modifier.padding(16.dp)) {
                                    Text(item.title)
                                    Text(formattedDate)
                                }
                            }
                        }
                        
                        // 性能优化技巧：
                        // 1. 使用key参数提升列表性能
                        // 2. 使用remember缓存计算结果
                        // 3. 避免在列表项中创建复杂对象
                        // 4. 使用contentPadding而不是在item中添加padding
                    """.trimIndent(),
                    explanation = "LazyColumn和LazyRow只组合可见的item，性能优于Column和Row。使用key参数可以提升列表性能，使用remember缓存计算结果。"
                ),
                CodeExample(
                    title = "示例2：自定义绘制",
                    code = """
                        @Composable
                        fun CustomDrawExample() {
                            Canvas(
                                modifier = Modifier
                                    .size(200.dp)
                                    .background(Color.White)
                            ) {
                                // 绘制圆形
                                drawCircle(
                                    color = Color.Blue,
                                    radius = 50.dp.toPx(),
                                    center = center
                                )
                                
                                // 绘制矩形
                                drawRect(
                                    color = Color.Red,
                                    topLeft = Offset(50.dp.toPx(), 50.dp.toPx()),
                                    size = Size(100.dp.toPx(), 100.dp.toPx())
                                )
                                
                                // 绘制路径
                                val path = Path().apply {
                                    moveTo(0f, 0f)
                                    lineTo(size.width, size.height)
                                }
                                drawPath(
                                    path = path,
                                    color = Color.Green,
                                    style = Stroke(width = 4.dp.toPx())
                                )
                                
                                // 绘制文字
                                drawContext.canvas.nativeCanvas.apply {
                    drawText(
                        "Hello",
                        100f,
                        100f,
                        android.graphics.Paint().apply {
                            color = android.graphics.Color.BLACK
                            textSize = 40f
                        }
                    )
                }
                            }
                        }
                    """.trimIndent(),
                    explanation = "Canvas用于自定义绘制。可以使用drawCircle、drawRect、drawPath等方法绘制各种图形。"
                ),
                CodeExample(
                    title = "示例3：与View系统互操作",
                    code = """
                        // 在Compose中使用传统View
                        @Composable
                        fun ViewInCompose() {
                            AndroidView(
                                factory = { context ->
                                    // 创建传统View
                                    WebView(context).apply {
                                        loadUrl("https://example.com")
                                    }
                                },
                                modifier = Modifier.fillMaxSize(),
                                update = { view ->
                                    // 更新View（可选）
                                    view.loadUrl("https://example.com")
                                }
                            )
                        }
                        
                        // 在传统View中使用Compose
                        class MainActivity : AppCompatActivity() {
                            override fun onCreate(savedInstanceState: Bundle?) {
                                super.onCreate(savedInstanceState)
                                
                                setContentView(
                                    ComposeView(this).apply {
                                        setContent {
                                            MaterialTheme {
                                                MyComposeScreen()
                                            }
                                        }
                                    }
                                )
                            }
                        }
                    """.trimIndent(),
                    explanation = "AndroidView用于在Compose中使用传统View，ComposeView用于在传统View中使用Compose。这样可以逐步迁移到Compose。"
                ),
                CodeExample(
                    title = "示例4：重组优化",
                    code = """
                        @Composable
                        fun RecompositionOptimization() {
                            var count by remember { mutableStateOf(0) }
                            var name by remember { mutableStateOf("") }
                            
                            // derivedStateOf：基于其他状态计算新状态，只在依赖变化时重组
                            val displayText by remember {
                                derivedStateOf {
                                    "Count: ${'$'}count, Name: ${'$'}name"
                                }
                            }
                            
                            Column {
                                // 只有count变化时才会重组
                                Text("Count: ${'$'}count")
                                
                                // 只有name变化时才会重组
                                Text("Name: ${'$'}name")
                                
                                // 只有count或name变化时才会重组
                                Text(displayText)
                                
                                Button(onClick = { count++ }) {
                                    Text("增加")
                                }
                            }
                            
                            // 优化技巧：
                            // 1. 使用derivedStateOf计算派生状态
                            // 2. 使用remember缓存计算结果
                            // 3. 将状态提升到最小范围
                            // 4. 使用key参数稳定列表项
                        }
                    """.trimIndent(),
                    explanation = "使用derivedStateOf可以基于其他状态计算新状态，只在依赖变化时重组。使用remember缓存计算结果，避免每次重组时重新计算。"
                )
            ),
            useCases = listOf(
                "列表性能：使用LazyColumn和LazyRow实现高效的长列表",
                "自定义UI：使用Canvas实现自定义图形和动画",
                "渐进迁移：使用互操作功能逐步从View迁移到Compose",
                "性能优化：优化重组和布局性能",
                "复杂绘制：实现复杂的自定义绘制效果"
            ),
            notes = listOf(
                "LazyColumn和LazyRow只组合可见的item，性能优于Column和Row",
                "使用key参数可以提升列表性能，帮助Compose识别item",
                "Canvas用于自定义绘制，可以使用各种draw方法",
                "AndroidView用于在Compose中使用传统View",
                "derivedStateOf用于计算派生状态，只在依赖变化时重组",
                "使用remember缓存计算结果，避免每次重组时重新计算",
                "使用Compose工具可以调试和优化性能"
            ),
            practiceTips = "建议使用LazyColumn和LazyRow实现长列表，它们只组合可见的item。使用key参数提升列表性能。使用derivedStateOf计算派生状态，使用remember缓存计算结果。对于复杂的自定义UI，使用Canvas实现。使用Compose工具调试和优化性能。注意重组范围，将状态提升到最小范围。"
        ),
        
        // ========== 数据存储 ==========
        
        KnowledgeDetail(
            id = "room",
            title = "Room数据库（Entity、DAO、Database、迁移）",
            overview = "Room是Android的SQLite对象映射库，提供了编译时SQL验证和类型安全的数据访问。理解Entity、DAO和Database的关系是使用Room的基础。",
            keyPoints = listOf(
                "Entity：数据表对应的数据类，使用@Entity注解",
                "DAO（Data Access Object）：定义数据库操作方法，使用@Dao注解",
                "Database：数据库类，使用@Database注解，继承RoomDatabase",
                "迁移（Migration）：处理数据库版本升级时的数据迁移",
                "关系：使用@Relation定义实体间的关系（一对一、一对多、多对多）",
                "类型转换器：使用@TypeConverter处理复杂类型（如Date、List）"
            ),
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：Entity定义",
                    code = """
                        // Entity：定义数据表结构
                        @Entity(tableName = "users")
                        data class User(
                            @PrimaryKey(autoGenerate = true)
                            val id: Long = 0,
                            
                            @ColumnInfo(name = "user_name")
                            val name: String,
                            
                            @ColumnInfo(name = "user_email")
                            val email: String,
                            
                            val age: Int,
                            
                            @ColumnInfo(name = "created_at")
                            val createdAt: Long = System.currentTimeMillis()
                        )
                        
                        // 定义索引
                        @Entity(
                            tableName = "users",
                            indices = [Index(value = ["email"], unique = true)]
                        )
                        data class UserWithIndex(...)
                        
                        // 复合主键
                        @Entity(primaryKeys = ["firstName", "lastName"])
                        data class UserCompositeKey(...)
                    """.trimIndent(),
                    explanation = "Entity使用@Entity注解标记，@PrimaryKey定义主键，@ColumnInfo自定义列名。可以定义索引和复合主键。"
                ),
                CodeExample(
                    title = "示例2：DAO定义",
                    code = """
                        @Dao
                        interface UserDao {
                            // 查询所有用户
                            @Query("SELECT * FROM users")
                            fun getAllUsers(): Flow<List<User>>
                            
                            // 根据ID查询
                            @Query("SELECT * FROM users WHERE id = :id")
                            suspend fun getUserById(id: Long): User?
                            
                            // 插入用户
                            @Insert(onConflict = OnConflictStrategy.REPLACE)
                            suspend fun insertUser(user: User): Long
                            
                            // 插入多个用户
                            @Insert(onConflict = OnConflictStrategy.IGNORE)
                            suspend fun insertUsers(users: List<User>)
                            
                            // 更新用户
                            @Update
                            suspend fun updateUser(user: User)
                            
                            // 删除用户
                            @Delete
                            suspend fun deleteUser(user: User)
                            
                            // 自定义删除
                            @Query("DELETE FROM users WHERE id = :id")
                            suspend fun deleteUserById(id: Long)
                            
                            // 复杂查询
                            @Query("SELECT * FROM users WHERE age > :minAge ORDER BY created_at DESC")
                            fun getUsersOlderThan(minAge: Int): Flow<List<User>>
                        }
                    """.trimIndent(),
                    explanation = "DAO使用@Dao注解，定义数据库操作方法。@Query用于自定义SQL查询，@Insert、@Update、@Delete用于基本操作。可以返回Flow实现响应式数据流。"
                ),
                CodeExample(
                    title = "示例3：Database定义和迁移",
                    code = """
                        // 定义类型转换器
                        class Converters {
                            @TypeConverter
                            fun fromTimestamp(value: Long?): Date? {
                                return value?.let { Date(it) }
                            }
                            
                            @TypeConverter
                            fun dateToTimestamp(date: Date?): Long? {
                                return date?.time
                            }
                        }
                        
                        // 定义Database
                        @Database(
                            entities = [User::class],
                            version = 2,  // 数据库版本
                            exportSchema = true
                        )
                        @TypeConverters(Converters::class)
                        abstract class AppDatabase : RoomDatabase() {
                            abstract fun userDao(): UserDao
                            
                            companion object {
                                @Volatile
                                private var INSTANCE: AppDatabase? = null
                                
                                fun getDatabase(context: Context): AppDatabase {
                                    return INSTANCE ?: synchronized(this) {
                                        val instance = Room.databaseBuilder(
                                            context.applicationContext,
                                            AppDatabase::class.java,
                                            "app_database"
                                        )
                                            .addMigrations(MIGRATION_1_2)  // 添加迁移
                                            .build()
                                        INSTANCE = instance
                                        instance
                                    }
                                }
                            }
                        }
                        
                        // 数据库迁移（从版本1到版本2）
                        val MIGRATION_1_2 = object : Migration(1, 2) {
                            override fun migrate(database: SupportSQLiteDatabase) {
                                // 添加新列
                                database.execSQL("ALTER TABLE users ADD COLUMN phone TEXT")
                            }
                        }
                    """.trimIndent(),
                    explanation = "Database使用@Database注解，指定entities和version。Migration用于处理数据库版本升级，必须为每个版本变更定义迁移策略。"
                )
            ),
            useCases = listOf(
                "本地数据存储：使用Room存储应用数据（用户信息、设置、缓存等）",
                "离线数据：实现离线功能，数据先存储到Room，网络恢复后同步",
                "数据查询：使用Room的查询功能实现复杂的数据检索",
                "数据关系：使用Room的关系功能处理关联数据",
                "数据迁移：使用Migration处理数据库结构变更"
            ),
            notes = listOf(
                "Room在编译时验证SQL查询，避免运行时错误",
                "DAO方法可以返回Flow，实现响应式数据流",
                "suspend函数必须在协程中调用，普通函数可以在主线程调用（不推荐）",
                "数据库迁移是必需的，不能跳过版本",
                "exportSchema = true会生成数据库schema JSON文件，便于版本控制",
                "使用@Transaction确保多个操作的原子性"
            ),
            practiceTips = "建议使用Repository模式封装Room访问，ViewModel通过Repository访问数据。使用Flow实现响应式数据流，自动更新UI。数据库操作应该在后台线程执行，Room的suspend函数会自动处理。定期备份数据库，使用Migration处理版本升级。"
        ),
        
        KnowledgeDetail(
            id = "datastore",
            title = "DataStore（Preferences DataStore、Proto DataStore）",
            overview = "DataStore是Android推荐的现代数据存储解决方案，替代SharedPreferences。支持类型安全的数据存储和响应式数据流。",
            keyPoints = listOf(
                "Preferences DataStore：类似SharedPreferences，但支持异步和类型安全",
                "Proto DataStore：使用Protocol Buffers存储结构化数据",
                "响应式：使用Flow提供数据流，自动响应数据变化",
                "类型安全：编译时类型检查，避免类型错误",
                "事务支持：支持原子性读写操作",
                "迁移：可以从SharedPreferences迁移到DataStore"
            ),
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：Preferences DataStore基础使用",
                    code = """
                        // 创建DataStore
                        val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")
                        
                        // 定义键
                        object PreferencesKeys {
                            val USER_NAME = stringPreferencesKey("user_name")
                            val USER_AGE = intPreferencesKey("user_age")
                            val IS_LOGGED_IN = booleanPreferencesKey("is_logged_in")
                        }
                        
                        // 读取数据
                        class SettingsRepository(private val dataStore: DataStore<Preferences>) {
                            val userNameFlow: Flow<String> = dataStore.data
                                .map { preferences ->
                                    preferences[PreferencesKeys.USER_NAME] ?: ""
                                }
                            
                            suspend fun getUserName(): String {
                                return dataStore.data.first()[PreferencesKeys.USER_NAME] ?: ""
                            }
                            
                            // 写入数据
                            suspend fun saveUserName(name: String) {
                                dataStore.edit { preferences ->
                                    preferences[PreferencesKeys.USER_NAME] = name
                                }
                            }
                            
                            // 保存多个值
                            suspend fun saveUserInfo(name: String, age: Int) {
                                dataStore.edit { preferences ->
                                    preferences[PreferencesKeys.USER_NAME] = name
                                    preferences[PreferencesKeys.USER_AGE] = age
                                }
                            }
                            
                            // 删除数据
                            suspend fun clearUserData() {
                                dataStore.edit { preferences ->
                                    preferences.remove(PreferencesKeys.USER_NAME)
                                    preferences.remove(PreferencesKeys.USER_AGE)
                                }
                            }
                        }
                    """.trimIndent(),
                    explanation = "Preferences DataStore使用preferencesDataStore创建，通过PreferencesKeys定义类型安全的键。使用Flow读取数据，使用edit写入数据。"
                ),
                CodeExample(
                    title = "示例2：在Compose中使用DataStore",
                    code = """
                        @Composable
                        fun SettingsScreen(repository: SettingsRepository) {
                            // 使用collectAsState收集Flow
                            val userName by repository.userNameFlow.collectAsState(initial = "")
                            
                            Column(modifier = Modifier.padding(16.dp)) {
                                TextField(
                                    value = userName,
                                    onValueChange = { newName ->
                                        // 在协程中写入数据
                                        lifecycleScope.launch {
                                            repository.saveUserName(newName)
                                        }
                                    },
                                    label = { Text("用户名") }
                                )
                            }
                        }
                        
                        // 或者使用ViewModel
                        class SettingsViewModel(
                            private val repository: SettingsRepository
                        ) : ViewModel() {
                            val userName: StateFlow<String> = repository.userNameFlow
                                .stateIn(
                                    scope = viewModelScope,
                                    started = SharingStarted.WhileSubscribed(5000),
                                    initialValue = ""
                                )
                            
                            fun saveUserName(name: String) {
                                viewModelScope.launch {
                                    repository.saveUserName(name)
                                }
                            }
                        }
                    """.trimIndent(),
                    explanation = "在Compose中使用collectAsState收集DataStore的Flow，在ViewModel中使用stateIn转换为StateFlow。写入操作应该在协程中执行。"
                ),
                CodeExample(
                    title = "示例3：从SharedPreferences迁移",
                    code = """
                        // 迁移函数
                        suspend fun migrateSharedPreferences(
                            context: Context,
                            dataStore: DataStore<Preferences>
                        ) {
                            val sharedPrefs = context.getSharedPreferences("old_prefs", Context.MODE_PRIVATE)
                            val allEntries = sharedPrefs.all
                            
                            dataStore.edit { preferences ->
                                allEntries.forEach { (key, value) ->
                                    when (value) {
                                        is String -> {
                                            preferences[stringPreferencesKey(key)] = value
                                        }
                                        is Int -> {
                                            preferences[intPreferencesKey(key)] = value
                                        }
                                        is Boolean -> {
                                            preferences[booleanPreferencesKey(key)] = value
                                        }
                                        // 处理其他类型...
                                    }
                                }
                            }
                        }
                    """.trimIndent(),
                    explanation = "可以从SharedPreferences迁移到DataStore，读取SharedPreferences的所有数据并写入DataStore。迁移应该在应用启动时执行一次。"
                )
            ),
            useCases = listOf(
                "应用设置：存储用户设置（主题、语言、通知偏好等）",
                "用户偏好：存储用户个性化配置",
                "缓存数据：存储临时缓存数据（如API响应）",
                "状态持久化：保存应用状态，应用重启后恢复",
                "配置管理：存储应用配置信息"
            ),
            notes = listOf(
                "DataStore是异步的，所有操作都是挂起函数",
                "Preferences DataStore适合存储简单的键值对数据",
                "Proto DataStore适合存储结构化数据，但需要定义.proto文件",
                "DataStore支持Flow，可以响应式地观察数据变化",
                "迁移SharedPreferences时，应该先迁移再删除SharedPreferences",
                "DataStore不支持多进程访问，多进程场景需要使用其他方案"
            ),
            practiceTips = "建议使用Repository模式封装DataStore访问，ViewModel通过Repository访问数据。使用Flow实现响应式数据流，在Compose中使用collectAsState。对于复杂数据，考虑使用Proto DataStore或Room。迁移SharedPreferences时，确保数据完整性。"
        ),
        
        KnowledgeDetail(
            id = "shared_prefs",
            title = "SharedPreferences",
            overview = "SharedPreferences是Android提供的轻量级键值对存储方案，用于存储简单的配置数据。虽然DataStore是推荐的替代方案，但理解SharedPreferences仍然重要，特别是在维护旧代码时。",
            keyPoints = listOf(
                "键值对存储：使用键值对方式存储简单的配置数据",
                "同步操作：SharedPreferences是同步的，可能阻塞主线程",
                "数据类型：支持String、Int、Long、Float、Boolean、Set<String>等类型",
                "文件存储：数据存储在XML文件中",
                "多进程：支持多进程访问，但需要MODE_MULTI_PROCESS（已过时）",
                "迁移：可以从SharedPreferences迁移到DataStore"
            ),
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：SharedPreferences基础使用",
                    code = """
                        class SettingsManager(context: Context) {
                            private val prefs = context.getSharedPreferences(
                                "settings",
                                Context.MODE_PRIVATE
                            )
                            
                            // 写入数据
                            fun saveUserName(name: String) {
                                prefs.edit().apply {
                                    putString("user_name", name)
                                    apply()  // 异步提交
                                    // 或使用commit()同步提交
                                }
                            }
                            
                            fun saveUserAge(age: Int) {
                                prefs.edit()
                                    .putInt("user_age", age)
                                    .apply()
                            }
                            
                            fun saveIsLoggedIn(isLoggedIn: Boolean) {
                                prefs.edit()
                                    .putBoolean("is_logged_in", isLoggedIn)
                                    .apply()
                            }
                            
                            // 读取数据
                            fun getUserName(): String {
                                return prefs.getString("user_name", "") ?: ""
                            }
                            
                            fun getUserAge(): Int {
                                return prefs.getInt("user_age", 0)
                            }
                            
                            fun isLoggedIn(): Boolean {
                                return prefs.getBoolean("is_logged_in", false)
                            }
                            
                            // 删除数据
                            fun clearUserData() {
                                prefs.edit().clear().apply()
                            }
                            
                            fun removeUserName() {
                                prefs.edit().remove("user_name").apply()
                            }
                        }
                    """.trimIndent(),
                    explanation = "SharedPreferences使用getSharedPreferences获取实例，使用edit()获取Editor进行写入操作。apply()异步提交，commit()同步提交。"
                ),
                CodeExample(
                    title = "示例2：SharedPreferences监听器",
                    code = """
                        class SettingsManager(context: Context) {
                            private val prefs = context.getSharedPreferences(
                                "settings",
                                Context.MODE_PRIVATE
                            )
                            
                            // 注册监听器
                            fun registerListener(listener: SharedPreferences.OnSharedPreferenceChangeListener) {
                                prefs.registerOnSharedPreferenceChangeListener(listener)
                            }
                            
                            // 取消注册监听器
                            fun unregisterListener(listener: SharedPreferences.OnSharedPreferenceChangeListener) {
                                prefs.unregisterOnSharedPreferenceChangeListener(listener)
                            }
                        }
                        
                        // 在Activity中使用
                        class MainActivity : AppCompatActivity() {
                            private val settingsManager = SettingsManager(this)
                            
                            override fun onCreate(savedInstanceState: Bundle?) {
                                super.onCreate(savedInstanceState)
                                
                                val listener = SharedPreferences.OnSharedPreferenceChangeListener { prefs, key ->
                                    when (key) {
                                        "user_name" -> {
                                            // 处理用户名变化
                                            val newName = prefs.getString(key, "")
                                        }
                                    }
                                }
                                
                                settingsManager.registerListener(listener)
                            }
                            
                            override fun onDestroy() {
                                super.onDestroy()
                                // 记得取消注册，避免内存泄漏
                                // settingsManager.unregisterListener(listener)
                            }
                        }
                    """.trimIndent(),
                    explanation = "SharedPreferences支持监听器，可以监听数据变化。但需要注意在适当时机取消注册，避免内存泄漏。"
                ),
                CodeExample(
                    title = "示例3：SharedPreferences的限制和迁移",
                    code = """
                        // SharedPreferences的限制：
                        // 1. 同步操作可能阻塞主线程
                        // 2. 不支持类型安全
                        // 3. 不支持Flow响应式数据流
                        // 4. 多进程支持有限
                        
                        // 迁移到DataStore
                        class MigrationHelper(
                            private val context: Context,
                            private val dataStore: DataStore<Preferences>
                        ) {
                            suspend fun migrateFromSharedPreferences() {
                                val sharedPrefs = context.getSharedPreferences(
                                    "settings",
                                    Context.MODE_PRIVATE
                                )
                                
                                val allEntries = sharedPrefs.all
                                
                                dataStore.edit { preferences ->
                                    allEntries.forEach { (key, value) ->
                                        when (value) {
                                            is String -> {
                                                preferences[stringPreferencesKey(key)] = value
                                            }
                                            is Int -> {
                                                preferences[intPreferencesKey(key)] = value
                                            }
                                            is Long -> {
                                                preferences[longPreferencesKey(key)] = value
                                            }
                                            is Float -> {
                                                preferences[floatPreferencesKey(key)] = value
                                            }
                                            is Boolean -> {
                                                preferences[booleanPreferencesKey(key)] = value
                                            }
                                            is Set<*> -> {
                                                preferences[stringSetPreferencesKey(key)] = value as Set<String>
                                            }
                                        }
                                    }
                                }
                                
                                // 迁移完成后，可以删除SharedPreferences
                                // sharedPrefs.edit().clear().apply()
                            }
                        }
                    """.trimIndent(),
                    explanation = "SharedPreferences有诸多限制，建议迁移到DataStore。迁移时读取SharedPreferences的所有数据并写入DataStore。"
                )
            ),
            useCases = listOf(
                "简单配置：存储简单的应用配置数据",
                "用户偏好：存储用户偏好设置",
                "临时数据：存储临时数据（不推荐，应该使用DataStore）",
                "旧代码维护：维护使用SharedPreferences的旧代码",
                "快速原型：在快速原型开发中使用（不推荐用于生产环境）"
            ),
            notes = listOf(
                "SharedPreferences是同步的，可能阻塞主线程，应该使用apply()而不是commit()",
                "apply()是异步的，commit()是同步的，推荐使用apply()",
                "SharedPreferences不支持类型安全，容易出现类型错误",
                "不支持Flow响应式数据流，无法自动响应数据变化",
                "多进程支持有限，MODE_MULTI_PROCESS已过时",
                "数据存储在XML文件中，不适合存储大量数据",
                "建议迁移到DataStore，它是Android推荐的现代数据存储方案"
            ),
            practiceTips = "虽然SharedPreferences仍然可用，但建议新项目使用DataStore。如果必须使用SharedPreferences，使用apply()而不是commit()，避免阻塞主线程。对于旧代码，考虑逐步迁移到DataStore。注意监听器的注册和取消注册，避免内存泄漏。不要使用SharedPreferences存储敏感数据，应该使用EncryptedSharedPreferences。"
        ),
        
        KnowledgeDetail(
            id = "file_storage",
            title = "文件存储（内部存储、外部存储、Scoped Storage）",
            overview = "Android提供了多种文件存储方式，包括内部存储、外部存储和Scoped Storage。理解这些存储方式的特点和使用场景是Android文件操作的基础。",
            keyPoints = listOf(
                "内部存储：应用私有存储，其他应用无法访问，卸载应用时删除",
                "外部存储：共享存储，其他应用可以访问，分为公共目录和应用私有目录",
                "Scoped Storage：Android 10+引入的存储范围限制，提升用户隐私",
                "MediaStore API：访问媒体文件（图片、视频、音频）的标准API",
                "SAF（Storage Access Framework）：用户选择文件和目录的框架",
                "权限：访问外部存储需要相应的权限"
            ),
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：内部存储",
                    code = """
                        class FileStorageManager(private val context: Context) {
                            
                            // 写入内部存储
                            fun writeToInternalStorage(filename: String, content: String) {
                                try {
                                    context.openFileOutput(filename, Context.MODE_PRIVATE).use { output ->
                                        output.write(content.toByteArray())
                                    }
                                } catch (e: Exception) {
                                    e.printStackTrace()
                                }
                            }
                            
                            // 读取内部存储
                            fun readFromInternalStorage(filename: String): String {
                                return try {
                                    context.openFileInput(filename).use { input ->
                                        input.bufferedReader().use { reader ->
                                            reader.readText()
                                        }
                                    }
                                } catch (e: Exception) {
                                    ""
                                }
                            }
                            
                            // 获取内部存储目录
                            fun getInternalStorageDir(): File {
                                return context.filesDir  // /data/data/包名/files
                            }
                            
                            // 获取缓存目录
                            fun getCacheDir(): File {
                                return context.cacheDir  // /data/data/包名/cache
                            }
                            
                            // 列出内部文件
                            fun listInternalFiles(): Array<String> {
                                return context.fileList()
                            }
                            
                            // 删除内部文件
                            fun deleteInternalFile(filename: String): Boolean {
                                return context.deleteFile(filename)
                            }
                        }
                    """.trimIndent(),
                    explanation = "内部存储使用openFileOutput和openFileInput进行文件操作。数据存储在应用私有目录，其他应用无法访问。"
                ),
                CodeExample(
                    title = "示例2：外部存储（Android 9及以下）",
                    code = """
                        class ExternalStorageManager(private val context: Context) {
                            
                            // 检查外部存储是否可用
                            fun isExternalStorageWritable(): Boolean {
                                return Environment.getExternalStorageState() == Environment.MEDIA_MOUNTED
                            }
                            
                            // 获取外部存储目录（需要权限）
                            fun getExternalStorageDir(): File? {
                                return if (isExternalStorageWritable()) {
                                    context.getExternalFilesDir(null)  // 应用私有目录
                                    // 或 Environment.getExternalStorageDirectory()  // 公共目录（已过时）
                                } else {
                                    null
                                }
                            }
                            
                            // 写入外部存储
                            fun writeToExternalStorage(filename: String, content: String) {
                                val file = File(context.getExternalFilesDir(null), filename)
                                try {
                                    file.writeText(content)
                                } catch (e: Exception) {
                                    e.printStackTrace()
                                }
                            }
                            
                            // 读取外部存储
                            fun readFromExternalStorage(filename: String): String {
                                val file = File(context.getExternalFilesDir(null), filename)
                                return try {
                                    file.readText()
                                } catch (e: Exception) {
                                    ""
                                }
                            }
                        }
                        
                        // AndroidManifest.xml
                        // <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
                        // <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />
                    """.trimIndent(),
                    explanation = "外部存储分为应用私有目录（getExternalFilesDir）和公共目录。Android 10+引入了Scoped Storage，限制了公共目录的访问。"
                ),
                CodeExample(
                    title = "示例3：Scoped Storage和MediaStore API（Android 10+）",
                    code = """
                        class ScopedStorageManager(private val context: Context) {
                            
                            // 使用MediaStore保存图片
                            suspend fun saveImage(bitmap: Bitmap, displayName: String): Uri? {
                                val contentValues = ContentValues().apply {
                                    put(android.provider.MediaStore.Images.Media.DISPLAY_NAME, displayName)
                                    put(android.provider.MediaStore.Images.Media.MIME_TYPE, "image/jpeg")
                                    put(android.provider.MediaStore.Images.Media.RELATIVE_PATH, Environment.DIRECTORY_PICTURES)
                                }
                                
                                val uri = context.contentResolver.insert(
                                    android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                                    contentValues
                                )
                                
                                uri?.let {
                                    context.contentResolver.openOutputStream(it)?.use { output ->
                                        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, output)
                                    }
                                }
                                
                                return uri
                            }
                            
                            // 使用MediaStore读取图片
                            suspend fun loadImages(): List<Uri> {
                                val projection = arrayOf(android.provider.MediaStore.Images.Media._ID)
                                val selection = "${android.provider.MediaStore.Images.Media.DATE_ADDED} >= ?"
                                val selectionArgs = arrayOf(
                                    (System.currentTimeMillis() / 1000 - 86400).toString()
                                )
                                
                                val images = mutableListOf<Uri>()
                                
                                context.contentResolver.query(
                                    android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                                    projection,
                                    selection,
                                    selectionArgs,
                                    "${android.provider.MediaStore.Images.Media.DATE_ADDED} DESC"
                                )?.use { cursor ->
                                    val idColumn = cursor.getColumnIndexOrThrow(android.provider.MediaStore.Images.Media._ID)
                                    while (cursor.moveToNext()) {
                                        val id = cursor.getLong(idColumn)
                                        val uri = ContentUris.withAppendedId(
                                            android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                                            id
                                        )
                                        images.add(uri)
                                    }
                                }
                                
                                return images
                            }
                        }
                        
                        // AndroidManifest.xml（Android 10+不需要存储权限）
                        // 但访问其他应用的媒体文件需要权限
                        // <uses-permission android:name="android.permission.READ_MEDIA_IMAGES" />
                    """.trimIndent(),
                    explanation = "Scoped Storage限制了应用对公共目录的访问。使用MediaStore API访问媒体文件，这是Android 10+推荐的方式。"
                ),
                CodeExample(
                    title = "示例4：SAF（Storage Access Framework）",
                    code = """
                        class SAFManager(private val activity: Activity) {
                            
                            // 选择文件
                            fun selectFile() {
                                val intent = Intent(Intent.ACTION_OPEN_DOCUMENT).apply {
                                    addCategory(Intent.CATEGORY_OPENABLE)
                                    type = "*/*"
                                    // 或指定类型：type = "image/*"
                                }
                                activity.startActivityForResult(intent, REQUEST_CODE_SELECT_FILE)
                            }
                            
                            // 创建文件
                            fun createFile() {
                                val intent = Intent(Intent.ACTION_CREATE_DOCUMENT).apply {
                                    addCategory(Intent.CATEGORY_OPENABLE)
                                    type = "text/plain"
                                    putExtra(Intent.EXTRA_TITLE, "new_file.txt")
                                }
                                activity.startActivityForResult(intent, REQUEST_CODE_CREATE_FILE)
                            }
                            
                            // 处理结果
                            fun handleActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
                                if (resultCode == Activity.RESULT_OK && data != null) {
                                    val uri = data.data
                                    uri?.let {
                                        // 读取文件
                                        readFile(uri)
                                        
                                        // 写入文件
                                        writeFile(uri, "content")
                                    }
                                }
                            }
                            
                            // 读取文件
                            private fun readFile(uri: Uri): String {
                                return try {
                                    activity.contentResolver.openInputStream(uri)?.use { input ->
                                        input.bufferedReader().use { reader ->
                                            reader.readText()
                                        }
                                    } ?: ""
                                } catch (e: Exception) {
                                    ""
                                }
                            }
                            
                            // 写入文件
                            private fun writeFile(uri: Uri, content: String) {
                                try {
                                    activity.contentResolver.openOutputStream(uri)?.use { output ->
                                        output.write(content.toByteArray())
                                    }
                                } catch (e: Exception) {
                                    e.printStackTrace()
                                }
                            }
                            
                            companion object {
                                const val REQUEST_CODE_SELECT_FILE = 1001
                                const val REQUEST_CODE_CREATE_FILE = 1002
                            }
                        }
                    """.trimIndent(),
                    explanation = "SAF允许用户选择文件和目录，无需存储权限。使用Intent.ACTION_OPEN_DOCUMENT选择文件，使用Intent.ACTION_CREATE_DOCUMENT创建文件。"
                )
            ),
            useCases = listOf(
                "应用数据：使用内部存储存储应用私有数据",
                "缓存数据：使用缓存目录存储临时缓存数据",
                "媒体文件：使用MediaStore API访问图片、视频、音频等媒体文件",
                "用户文件：使用SAF让用户选择和管理文件",
                "数据备份：使用外部存储备份应用数据"
            ),
            notes = listOf(
                "内部存储是应用私有的，其他应用无法访问，卸载应用时删除",
                "外部存储分为应用私有目录和公共目录",
                "Android 10+引入了Scoped Storage，限制了公共目录的访问",
                "使用MediaStore API访问媒体文件，这是Android 10+推荐的方式",
                "SAF允许用户选择文件，无需存储权限",
                "访问外部存储需要相应的权限（Android 9及以下）",
                "缓存目录可能被系统清理，不适合存储重要数据"
            ),
            practiceTips = "建议使用内部存储存储应用私有数据，使用缓存目录存储临时数据。对于媒体文件，使用MediaStore API（Android 10+）。对于用户文件选择，使用SAF。注意权限处理，Android 10+对存储权限有新的要求。定期清理缓存，避免占用过多存储空间。重要数据应该备份到云端。"
        ),
        
        KnowledgeDetail(
            id = "content_provider",
            title = "内容提供者（ContentProvider）",
            overview = "ContentProvider是Android四大组件之一，用于在不同应用间共享数据。理解ContentProvider的使用可以实现应用间的数据共享和安全访问。",
            keyPoints = listOf(
                "数据共享：ContentProvider允许应用间共享数据",
                "URI机制：使用URI标识和访问数据",
                "CRUD操作：支持查询、插入、更新、删除操作",
                "权限控制：通过权限控制数据访问",
                "系统ContentProvider：使用系统提供的ContentProvider（联系人、媒体等）",
                "自定义ContentProvider：创建自定义ContentProvider共享应用数据"
            ),
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：使用系统ContentProvider（联系人）",
                    code = """
                        class ContactManager(private val context: Context) {
                            
                            // 查询联系人
                            fun queryContacts(): List<Contact> {
                                val contacts = mutableListOf<Contact>()
                                
                                val projection = arrayOf(
                                    android.provider.ContactsContract.Contacts._ID,
                                    android.provider.ContactsContract.Contacts.DISPLAY_NAME,
                                    android.provider.ContactsContract.Contacts.HAS_PHONE_NUMBER
                                )
                                
                                context.contentResolver.query(
                                    android.provider.ContactsContract.Contacts.CONTENT_URI,
                                    projection,
                                    null,
                                    null,
                                    android.provider.ContactsContract.Contacts.DISPLAY_NAME + " ASC"
                                )?.use { cursor ->
                                    val idColumn = cursor.getColumnIndex(android.provider.ContactsContract.Contacts._ID)
                                    val nameColumn = cursor.getColumnIndex(android.provider.ContactsContract.Contacts.DISPLAY_NAME)
                                    
                                    while (cursor.moveToNext()) {
                                        val id = cursor.getLong(idColumn)
                                        val name = cursor.getString(nameColumn)
                                        
                                        // 查询电话号码
                                        val phones = queryPhones(id)
                                        
                                        contacts.add(Contact(id, name, phones))
                                    }
                                }
                                
                                return contacts
                            }
                            
                            // 查询电话号码
                            private fun queryPhones(contactId: Long): List<String> {
                                val phones = mutableListOf<String>()
                                
                                context.contentResolver.query(
                                    android.provider.ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                                    arrayOf(android.provider.ContactsContract.CommonDataKinds.Phone.NUMBER),
                                    "${android.provider.ContactsContract.CommonDataKinds.Phone.CONTACT_ID} = ?",
                                    arrayOf(contactId.toString()),
                                    null
                                )?.use { cursor ->
                                    val numberColumn = cursor.getColumnIndex(android.provider.ContactsContract.CommonDataKinds.Phone.NUMBER)
                                    while (cursor.moveToNext()) {
                                        phones.add(cursor.getString(numberColumn))
                                    }
                                }
                                
                                return phones
                            }
                            
                            data class Contact(
                                val id: Long,
                                val name: String,
                                val phones: List<String>
                            )
                        }
                        
                        // AndroidManifest.xml
                        // <uses-permission android:name="android.permission.READ_CONTACTS" />
                    """.trimIndent(),
                    explanation = "使用ContentResolver查询系统ContentProvider。ContactsContract提供了访问联系人的API，需要READ_CONTACTS权限。"
                ),
                CodeExample(
                    title = "示例2：自定义ContentProvider",
                    code = """
                        // 定义Contract
                        object MyProviderContract {
                            const val AUTHORITY = "com.example.myapp.provider"
                            val CONTENT_URI = Uri.parse("content://${'$'}AUTHORITY/items")
                            
                            object Items {
                                const val _ID = "_id"
                                const val NAME = "name"
                                const val DESCRIPTION = "description"
                            }
                        }
                        
                        // 自定义ContentProvider
                        class MyContentProvider : ContentProvider() {
                            
                            private lateinit var dbHelper: DatabaseHelper
                            
                            override fun onCreate(): Boolean {
                                dbHelper = DatabaseHelper(context!!)
                                return true
                            }
                            
                            override fun query(
                                uri: Uri,
                                projection: Array<String>?,
                                selection: String?,
                                selectionArgs: Array<String>?,
                                sortOrder: String?
                            ): Cursor? {
                                val db = dbHelper.readableDatabase
                                val cursor = db.query(
                                    "items",
                                    projection,
                                    selection,
                                    selectionArgs,
                                    null,
                                    null,
                                    sortOrder
                                )
                                cursor.setNotificationUri(context!!.contentResolver, uri)
                                return cursor
                            }
                            
                            override fun insert(uri: Uri, values: ContentValues?): Uri? {
                                val db = dbHelper.writableDatabase
                                val id = db.insert("items", null, values)
                                context!!.contentResolver.notifyChange(uri, null)
                                return ContentUris.withAppendedId(uri, id)
                            }
                            
                            override fun update(
                                uri: Uri,
                                values: ContentValues?,
                                selection: String?,
                                selectionArgs: Array<String>?
                            ): Int {
                                val db = dbHelper.writableDatabase
                                val count = db.update("items", values, selection, selectionArgs)
                                context!!.contentResolver.notifyChange(uri, null)
                                return count
                            }
                            
                            override fun delete(
                                uri: Uri,
                                selection: String?,
                                selectionArgs: Array<String>?
                            ): Int {
                                val db = dbHelper.writableDatabase
                                val count = db.delete("items", selection, selectionArgs)
                                context!!.contentResolver.notifyChange(uri, null)
                                return count
                            }
                            
                            override fun getType(uri: Uri): String? {
                                return "vnd.android.cursor.dir/vnd.com.example.items"
                            }
                        }
                        
                        // AndroidManifest.xml
                        // <provider
                        //     android:name=".MyContentProvider"
                        //     android:authorities="com.example.myapp.provider"
                        //     android:exported="true"
                        //     android:permission="com.example.myapp.PERMISSION" />
                    """.trimIndent(),
                    explanation = "自定义ContentProvider需要继承ContentProvider类，实现query、insert、update、delete等方法。使用URI标识数据，通过权限控制访问。"
                ),
                CodeExample(
                    title = "示例3：使用自定义ContentProvider",
                    code = """
                        class MyProviderClient(private val context: Context) {
                            
                            // 查询数据
                            fun queryItems(): List<Item> {
                                val items = mutableListOf<Item>()
                                
                                context.contentResolver.query(
                                    MyProviderContract.CONTENT_URI,
                                    null,
                                    null,
                                    null,
                                    null
                                )?.use { cursor ->
                                    val idColumn = cursor.getColumnIndex(MyProviderContract.Items._ID)
                                    val nameColumn = cursor.getColumnIndex(MyProviderContract.Items.NAME)
                                    val descColumn = cursor.getColumnIndex(MyProviderContract.Items.DESCRIPTION)
                                    
                                    while (cursor.moveToNext()) {
                                        items.add(
                                            Item(
                                                id = cursor.getLong(idColumn),
                                                name = cursor.getString(nameColumn),
                                                description = cursor.getString(descColumn)
                                            )
                                        )
                                    }
                                }
                                
                                return items
                            }
                            
                            // 插入数据
                            fun insertItem(name: String, description: String): Uri? {
                                val values = ContentValues().apply {
                                    put(MyProviderContract.Items.NAME, name)
                                    put(MyProviderContract.Items.DESCRIPTION, description)
                                }
                                
                                return context.contentResolver.insert(
                                    MyProviderContract.CONTENT_URI,
                                    values
                                )
                            }
                            
                            // 更新数据
                            fun updateItem(id: Long, name: String): Int {
                                val values = ContentValues().apply {
                                    put(MyProviderContract.Items.NAME, name)
                                }
                                
                                val uri = ContentUris.withAppendedId(
                                    MyProviderContract.CONTENT_URI,
                                    id
                                )
                                
                                return context.contentResolver.update(uri, values, null, null)
                            }
                            
                            // 删除数据
                            fun deleteItem(id: Long): Int {
                                val uri = ContentUris.withAppendedId(
                                    MyProviderContract.CONTENT_URI,
                                    id
                                )
                                
                                return context.contentResolver.delete(uri, null, null)
                            }
                            
                            data class Item(
                                val id: Long,
                                val name: String,
                                val description: String
                            )
                        }
                    """.trimIndent(),
                    explanation = "使用ContentResolver访问自定义ContentProvider。通过URI标识数据，使用ContentValues传递数据，支持CRUD操作。"
                )
            ),
            useCases = listOf(
                "数据共享：在不同应用间共享数据",
                "系统数据访问：访问系统ContentProvider（联系人、媒体等）",
                "数据安全：通过权限控制数据访问",
                "数据同步：实现数据同步和更新通知",
                "插件化：支持插件化架构，插件间共享数据"
            ),
            notes = listOf(
                "ContentProvider使用URI标识和访问数据",
                "ContentResolver用于访问ContentProvider",
                "系统ContentProvider需要相应权限（如READ_CONTACTS）",
                "自定义ContentProvider需要在AndroidManifest.xml中注册",
                "使用notifyChange通知数据变化",
                "ContentProvider是Android四大组件之一，运行在主线程",
                "复杂查询应该在后台线程执行"
            ),
            practiceTips = "建议使用系统ContentProvider访问系统数据，如联系人、媒体等。对于应用间数据共享，考虑使用ContentProvider。注意权限控制，确保数据安全。使用URI匹配器处理不同的URI模式。注意性能，复杂查询应该在后台线程执行。考虑使用Room等现代数据库库，它们提供了ContentProvider支持。"
        ),
        
        // ========== 网络请求 ==========
        
        KnowledgeDetail(
            id = "http_basic",
            title = "HTTP基础",
            overview = "HTTP（HyperText Transfer Protocol）是应用层协议，用于客户端和服务器之间的通信。理解HTTP的基础知识是Android网络编程的基础。",
            keyPoints = listOf(
                "HTTP方法：GET、POST、PUT、DELETE、PATCH等，用于不同的操作",
                "HTTP状态码：200（成功）、404（未找到）、500（服务器错误）等",
                "HTTP头：请求头和响应头，包含元数据信息",
                "请求体：POST、PUT等方法可以携带请求体数据",
                "URL和URI：统一资源定位符和统一资源标识符",
                "HTTPS：加密的HTTP协议，保证数据传输安全"
            ),
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：HTTP请求和响应结构",
                    code = """
                        // HTTP请求结构
                        // GET /api/users HTTP/1.1
                        // Host: api.example.com
                        // User-Agent: MyApp/1.0
                        // Accept: application/json
                        // Authorization: Bearer token123
                        //
                        // （GET请求没有请求体）
                        
                        // HTTP响应结构
                        // HTTP/1.1 200 OK
                        // Content-Type: application/json
                        // Content-Length: 1234
                        // 
                        // {
                        //   "users": [...]
                        // }
                        
                        // HTTP方法说明：
                        // - GET：获取资源，参数在URL中
                        // - POST：创建资源，数据在请求体中
                        // - PUT：更新资源（完整更新），数据在请求体中
                        // - PATCH：更新资源（部分更新），数据在请求体中
                        // - DELETE：删除资源
                    """.trimIndent(),
                    explanation = "HTTP请求包含请求行、请求头和可选的请求体。HTTP响应包含状态行、响应头和响应体。不同的HTTP方法用于不同的操作。"
                ),
                CodeExample(
                    title = "示例2：HTTP状态码",
                    code = """
                        // 2xx - 成功
                        // 200 OK：请求成功
                        // 201 Created：资源创建成功
                        // 204 No Content：请求成功，无返回内容
                        
                        // 3xx - 重定向
                        // 301 Moved Permanently：永久重定向
                        // 302 Found：临时重定向
                        // 304 Not Modified：资源未修改（缓存有效）
                        
                        // 4xx - 客户端错误
                        // 400 Bad Request：请求错误
                        // 401 Unauthorized：未授权
                        // 403 Forbidden：禁止访问
                        // 404 Not Found：资源未找到
                        // 429 Too Many Requests：请求过多
                        
                        // 5xx - 服务器错误
                        // 500 Internal Server Error：服务器内部错误
                        // 502 Bad Gateway：网关错误
                        // 503 Service Unavailable：服务不可用
                        
                        // 在Android中处理状态码
                        class HttpResponseHandler {
                            fun handleResponse(response: Response) {
                                when (response.code) {
                                    200 -> {
                                        // 处理成功响应
                                    }
                                    401 -> {
                                        // 处理未授权，可能需要重新登录
                                    }
                                    404 -> {
                                        // 处理资源未找到
                                    }
                                    500 -> {
                                        // 处理服务器错误
                                    }
                                    else -> {
                                        // 处理其他状态码
                                    }
                                }
                            }
                        }
                    """.trimIndent(),
                    explanation = "HTTP状态码表示请求的处理结果。2xx表示成功，3xx表示重定向，4xx表示客户端错误，5xx表示服务器错误。需要根据不同的状态码进行相应处理。"
                ),
                CodeExample(
                    title = "示例3：HTTP头和Cookie",
                    code = """
                        // 常用请求头
                        // Content-Type: application/json  // 请求体类型
                        // Accept: application/json      // 期望的响应类型
                        // Authorization: Bearer token   // 认证信息
                        // User-Agent: MyApp/1.0         // 客户端信息
                        // Cookie: session=abc123        // Cookie信息
                        
                        // 常用响应头
                        // Content-Type: application/json  // 响应体类型
                        // Set-Cookie: session=abc123      // 设置Cookie
                        // Cache-Control: max-age=3600     // 缓存控制
                        // Location: /new-url              // 重定向地址
                        
                        // 在Android中使用Cookie
                        class CookieManager {
                            private val cookieStore = CookieManager()
                            
                            fun setupCookieManager() {
                                cookieStore.setCookiePolicy(CookiePolicy.ACCEPT_ALL)
                                CookieHandler.setDefault(cookieStore)
                            }
                            
                            fun getCookies(url: String): String? {
                                return cookieStore.cookieStore.get(URI(url))
                                    ?.joinToString("; ") { "${'$'}{it.name}=${'$'}{it.value}" }
                            }
                        }
                    """.trimIndent(),
                    explanation = "HTTP头包含请求和响应的元数据信息。Cookie用于在客户端和服务器之间传递状态信息。在Android中可以使用CookieManager管理Cookie。"
                ),
                CodeExample(
                    title = "示例4：HTTPS和安全",
                    code = """
                        // HTTPS是加密的HTTP协议，使用TLS/SSL加密
                        // 在Android中使用HTTPS
                        
                        // 1. 使用系统默认证书（推荐）
                        // Retrofit和OkHttp默认支持HTTPS，无需额外配置
                        
                        // 2. 自定义证书验证（不推荐，仅用于测试）
                        class UnsafeOkHttpClient {
                            fun getUnsafeOkHttpClient(): OkHttpClient {
                                val trustAllCerts = arrayOf<TrustManager>(
                                    object : X509TrustManager {
                                        override fun checkClientTrusted(
                                            chain: Array<out X509Certificate>?,
                                            authType: String?
                                        ) {}
                                        
                                        override fun checkServerTrusted(
                                            chain: Array<out X509Certificate>?,
                                            authType: String?
                                        ) {}
                                        
                                        override fun getAcceptedIssuers() = arrayOf<X509Certificate>()
                                    }
                                )
                                
                                val sslContext = SSLContext.getInstance("SSL")
                                sslContext.init(null, trustAllCerts, SecureRandom())
                                
                                return OkHttpClient.Builder()
                                    .sslSocketFactory(sslContext.socketFactory, trustAllCerts[0] as X509TrustManager)
                                    .hostnameVerifier { _, _ -> true }
                                    .build()
                            }
                        }
                        
                        // 3. 证书锁定（Certificate Pinning）- 增强安全性
                        class SecureOkHttpClient {
                            fun getSecureOkHttpClient(): OkHttpClient {
                                return OkHttpClient.Builder()
                                    .certificatePinner(
                                        CertificatePinner.Builder()
                                            .add("api.example.com", "sha256/AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA=")
                                            .build()
                                    )
                                    .build()
                            }
                        }
                        
                        // 注意：不要在生产环境中使用不安全的证书验证
                    """.trimIndent(),
                    explanation = "HTTPS使用TLS/SSL加密数据传输，保证安全性。Android默认支持HTTPS，无需额外配置。可以使用证书锁定增强安全性。"
                )
            ),
            useCases = listOf(
                "API调用：使用HTTP协议调用RESTful API",
                "数据获取：使用GET方法获取服务器数据",
                "数据提交：使用POST方法提交数据到服务器",
                "数据更新：使用PUT或PATCH方法更新服务器数据",
                "安全通信：使用HTTPS保证数据传输安全"
            ),
            notes = listOf(
                "GET请求参数在URL中，POST请求数据在请求体中",
                "HTTP是无状态协议，需要使用Cookie或Token维护状态",
                "HTTPS是加密的HTTP，保证数据传输安全",
                "不同的HTTP方法有不同的语义，应该正确使用",
                "HTTP状态码表示请求的处理结果，需要根据状态码进行相应处理",
                "HTTP头包含元数据信息，如Content-Type、Authorization等",
                "Android默认支持HTTPS，无需额外配置"
            ),
            practiceTips = "建议使用HTTPS保证数据传输安全。正确使用HTTP方法，GET用于获取数据，POST用于创建数据。根据HTTP状态码进行相应的错误处理。使用HTTP头传递必要的元数据信息。注意Cookie和Token的管理，保证安全性。"
        ),
        
        KnowledgeDetail(
            id = "retrofit",
            title = "Retrofit配置和使用",
            overview = "Retrofit是Square开发的类型安全的HTTP客户端库，用于Android和Java。它简化了HTTP API的调用，支持同步和异步请求。",
            keyPoints = listOf(
                "类型安全：使用接口定义API，编译时类型检查",
                "注解支持：使用注解定义HTTP方法、URL、参数等",
                "数据转换：支持多种数据转换器（Gson、Moshi等）",
                "协程支持：支持Kotlin协程，简化异步编程",
                "拦截器：支持OkHttp拦截器，实现认证、日志等功能",
                "错误处理：统一的错误处理机制"
            ),
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：Retrofit基础配置",
                    code = """
                        // 定义API接口
                        interface ApiService {
                            @GET("users")
                            suspend fun getUsers(): List<User>
                            
                            @GET("users/{id}")
                            suspend fun getUserById(@Path("id") id: Long): User
                            
                            @POST("users")
                            suspend fun createUser(@Body user: User): User
                            
                            @PUT("users/{id}")
                            suspend fun updateUser(
                                @Path("id") id: Long,
                                @Body user: User
                            ): User
                            
                            @DELETE("users/{id}")
                            suspend fun deleteUser(@Path("id") id: Long): Response<Unit>
                        }
                        
                        // 配置Retrofit
                        class RetrofitClient {
                            private val retrofit = Retrofit.Builder()
                                .baseUrl("https://api.example.com/")
                                .addConverterFactory(GsonConverterFactory.create())
                                .client(createOkHttpClient())
                                .build()
                            
                            val apiService: ApiService = retrofit.create(ApiService::class.java)
                            
                            private fun createOkHttpClient(): OkHttpClient {
                                return OkHttpClient.Builder()
                                    .addInterceptor(HttpLoggingInterceptor().apply {
                                        level = HttpLoggingInterceptor.Level.BODY
                                    })
                                    .connectTimeout(30, TimeUnit.SECONDS)
                                    .readTimeout(30, TimeUnit.SECONDS)
                                    .build()
                            }
                        }
                    """.trimIndent(),
                    explanation = "Retrofit使用接口定义API，通过注解指定HTTP方法和参数。使用Retrofit.Builder配置Retrofit，包括baseUrl、转换器等。"
                ),
                CodeExample(
                    title = "示例2：Retrofit注解使用",
                    code = """
                        interface ApiService {
                            // 路径参数
                            @GET("users/{id}/posts")
                            suspend fun getUserPosts(@Path("id") userId: Long): List<Post>
                            
                            // 查询参数
                            @GET("users")
                            suspend fun searchUsers(
                                @Query("name") name: String,
                                @Query("age") age: Int?,
                                @QueryMap params: Map<String, String>
                            ): List<User>
                            
                            // 请求头
                            @GET("profile")
                            @Headers("Authorization: Bearer token123")
                            suspend fun getProfile(): Profile
                            
                            // 动态请求头
                            @GET("profile")
                            suspend fun getProfile(
                                @Header("Authorization") token: String
                            ): Profile
                            
                            // 表单数据
                            @FormUrlEncoded
                            @POST("login")
                            suspend fun login(
                                @Field("username") username: String,
                                @Field("password") password: String
                            ): LoginResponse
                            
                            // 文件上传
                            @Multipart
                            @POST("upload")
                            suspend fun uploadFile(
                                @Part("description") description: RequestBody,
                                @Part file: MultipartBody.Part
                            ): UploadResponse
                        }
                    """.trimIndent(),
                    explanation = "Retrofit提供了丰富的注解：@Path用于路径参数，@Query用于查询参数，@Header用于请求头，@Body用于请求体，@FormUrlEncoded和@Field用于表单数据，@Multipart和@Part用于文件上传。"
                ),
                CodeExample(
                    title = "示例3：Retrofit与协程集成",
                    code = """
                        interface ApiService {
                            @GET("users")
                            suspend fun getUsers(): List<User>
                            
                            @GET("users/{id}")
                            suspend fun getUserById(@Path("id") id: Long): User
                        }
                        
                        class UserRepository(
                            private val apiService: ApiService
                        ) {
                            suspend fun getUsers(): Result<List<User>> {
                                return try {
                                    val users = apiService.getUsers()
                                    Result.success(users)
                                } catch (e: HttpException) {
                                    Result.failure(e)
                                } catch (e: IOException) {
                                    Result.failure(e)
                                }
                            }
                            
                            suspend fun getUserById(id: Long): Result<User> {
                                return try {
                                    val user = apiService.getUserById(id)
                                    Result.success(user)
                                } catch (e: HttpException) {
                                    when (e.code()) {
                                        404 -> Result.failure(Exception("用户未找到"))
                                        else -> Result.failure(e)
                                    }
                                } catch (e: IOException) {
                                    Result.failure(Exception("网络错误"))
                                }
                            }
                        }
                        
                        // 在ViewModel中使用
                        class UserViewModel(
                            private val repository: UserRepository
                        ) : ViewModel() {
                            
                            private val _users = MutableStateFlow<List<User>>(emptyList())
                            val users: StateFlow<List<User>> = _users.asStateFlow()
                            
                            fun loadUsers() {
                                viewModelScope.launch {
                                    repository.getUsers()
                                        .onSuccess { _users.value = it }
                                        .onFailure { /* 处理错误 */ }
                                }
                            }
                        }
                    """.trimIndent(),
                    explanation = "Retrofit支持Kotlin协程，使用suspend函数定义API方法。在Repository中处理错误，在ViewModel中使用viewModelScope调用。"
                ),
                CodeExample(
                    title = "示例4：Retrofit错误处理",
                    code = """
                        // 自定义错误响应
                        data class ErrorResponse(
                            val code: Int,
                            val message: String
                        )
                        
                        // 使用CallAdapter处理错误
                        class ApiCallAdapterFactory : CallAdapter.Factory() {
                            override fun get(
                                returnType: Type,
                                annotations: Array<Annotation>,
                                retrofit: Retrofit
                            ): CallAdapter<*, *>? {
                                // 实现自定义CallAdapter
                                return null
                            }
                        }
                        
                        // 在Repository中统一处理错误
                        class ApiRepository(
                            private val apiService: ApiService
                        ) {
                            suspend fun <T> safeApiCall(
                                apiCall: suspend () -> Response<T>
                            ): Result<T> {
                                return try {
                                    val response = apiCall()
                                    if (response.isSuccessful) {
                                        Result.success(response.body()!!)
                                    } else {
                                        val errorBody = response.errorBody()?.string()
                                        Result.failure(Exception("API错误: ${'$'}{response.code()}"))
                                    }
                                } catch (e: HttpException) {
                                    Result.failure(Exception("HTTP错误: ${'$'}{e.code()}"))
                                } catch (e: IOException) {
                                    Result.failure(Exception("网络错误: ${'$'}{e.message}"))
                                } catch (e: Exception) {
                                    Result.failure(e)
                                }
                            }
                            
                            suspend fun getUsers(): Result<List<User>> {
                                return safeApiCall { apiService.getUsers() }
                            }
                        }
                    """.trimIndent(),
                    explanation = "Retrofit的错误处理包括HTTP错误和网络错误。可以使用统一的错误处理函数，也可以使用CallAdapter自定义错误处理。"
                )
            ),
            useCases = listOf(
                "RESTful API调用：使用Retrofit调用RESTful API",
                "类型安全：使用接口定义API，编译时类型检查",
                "异步编程：使用协程简化异步网络请求",
                "数据转换：使用转换器自动序列化和反序列化数据",
                "统一配置：统一配置baseUrl、拦截器等"
            ),
            notes = listOf(
                "Retrofit使用接口定义API，通过注解指定HTTP方法和参数",
                "支持多种数据转换器，如Gson、Moshi、Jackson等",
                "支持Kotlin协程，使用suspend函数定义API方法",
                "使用OkHttp作为底层HTTP客户端",
                "支持拦截器，可以实现认证、日志等功能",
                "baseUrl必须以/结尾，相对路径不能以/开头",
                "错误处理包括HTTP错误和网络错误，需要统一处理"
            ),
            practiceTips = "建议使用Retrofit进行网络请求，它提供了类型安全和简洁的API。使用接口定义API，通过注解指定HTTP方法和参数。使用协程简化异步编程。统一配置baseUrl和拦截器。实现统一的错误处理机制。使用Repository模式封装API调用。"
        ),
        
        KnowledgeDetail(
            id = "okhttp",
            title = "OkHttp配置和拦截器",
            overview = "OkHttp是Square开发的HTTP客户端库，是Retrofit的底层实现。理解OkHttp的配置和拦截器可以实现认证、日志、缓存等功能。",
            keyPoints = listOf(
                "HTTP客户端：OkHttp是强大的HTTP客户端库",
                "拦截器：使用拦截器实现认证、日志、重试等功能",
                "连接池：OkHttp使用连接池复用连接，提升性能",
                "缓存：支持HTTP缓存，减少网络请求",
                "超时配置：可以配置连接、读取、写入超时",
                "Cookie管理：支持Cookie的自动管理"
            ),
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：OkHttp基础配置",
                    code = """
                        class OkHttpClientFactory {
                            fun createOkHttpClient(): OkHttpClient {
                                return OkHttpClient.Builder()
                                    // 连接超时
                                    .connectTimeout(30, TimeUnit.SECONDS)
                                    // 读取超时
                                    .readTimeout(30, TimeUnit.SECONDS)
                                    // 写入超时
                                    .writeTimeout(30, TimeUnit.SECONDS)
                                    // 连接池配置
                                    .connectionPool(ConnectionPool(10, 5, TimeUnit.MINUTES))
                                    // 重试配置
                                    .retryOnConnectionFailure(true)
                                    // 拦截器
                                    .addInterceptor(createLoggingInterceptor())
                                    .addInterceptor(createAuthInterceptor())
                                    .addNetworkInterceptor(createCacheInterceptor())
                                    // Cookie管理
                                    .cookieJar(createCookieJar())
                                    // 缓存
                                    .cache(createCache())
                                    .build()
                            }
                            
                            private fun createLoggingInterceptor(): Interceptor {
                                return HttpLoggingInterceptor().apply {
                                    level = if (BuildConfig.DEBUG) {
                                        HttpLoggingInterceptor.Level.BODY
                                    } else {
                                        HttpLoggingInterceptor.Level.NONE
                                    }
                                }
                            }
                            
                            private fun createCache(): Cache {
                                val cacheSize = 10 * 1024 * 1024L // 10MB
                                val cacheDir = File(context.cacheDir, "http_cache")
                                return Cache(cacheDir, cacheSize)
                            }
                        }
                    """.trimIndent(),
                    explanation = "OkHttp使用Builder模式配置，包括超时、连接池、拦截器、缓存等。可以配置连接、读取、写入超时，设置连接池大小，添加拦截器。"
                ),
                CodeExample(
                    title = "示例2：认证拦截器",
                    code = """
                        class AuthInterceptor(
                            private val tokenManager: TokenManager
                        ) : Interceptor {
                            
                            override fun intercept(chain: Interceptor.Chain): Response {
                                val originalRequest = chain.request()
                                
                                // 获取token
                                val token = tokenManager.getToken()
                                
                                // 添加认证头
                                val authenticatedRequest = originalRequest.newBuilder()
                                    .header("Authorization", "Bearer ${'$'}token")
                                    .build()
                                
                                // 执行请求
                                val response = chain.proceed(authenticatedRequest)
                                
                                // 如果token过期，尝试刷新token
                                if (response.code == 401) {
                                    val newToken = tokenManager.refreshToken()
                                    if (newToken != null) {
                                        val retryRequest = originalRequest.newBuilder()
                                            .header("Authorization", "Bearer ${'$'}newToken")
                                            .build()
                                        return chain.proceed(retryRequest)
                                    }
                                }
                                
                                return response
                            }
                        }
                        
                        class TokenManager {
                            private var token: String? = null
                            
                            fun getToken(): String? = token
                            
                            fun refreshToken(): String? {
                                // 刷新token的逻辑
                                return null
                            }
                        }
                    """.trimIndent(),
                    explanation = "认证拦截器用于自动添加认证头。如果请求返回401，可以尝试刷新token并重试请求。"
                ),
                CodeExample(
                    title = "示例3：日志拦截器",
                    code = """
                        class CustomLoggingInterceptor : Interceptor {
                            
                            override fun intercept(chain: Interceptor.Chain): Response {
                                val request = chain.request()
                                
                                // 记录请求信息
                                val requestBody = request.body
                                val requestLog = StringBuilder().apply {
                                    append("Request: ${'$'}{request.method} ${'$'}{request.url}\n")
                                    append("Headers: ${'$'}{request.headers}\n")
                                    if (requestBody != null) {
                                        append("Body: ${'$'}{requestBody.toString()}\n")
                                    }
                                }
                                Log.d("OkHttp", requestLog.toString())
                                
                                val startTime = System.currentTimeMillis()
                                val response = chain.proceed(request)
                                val endTime = System.currentTimeMillis()
                                
                                // 记录响应信息
                                val responseLog = StringBuilder().apply {
                                    append("Response: ${'$'}{response.code} ${'$'}{response.message}\n")
                                    append("Time: ${'$'}{endTime - startTime}ms\n")
                                    append("Headers: ${'$'}{response.headers}\n")
                                }
                                Log.d("OkHttp", responseLog.toString())
                                
                                return response
                            }
                        }
                        
                        // 或者使用HttpLoggingInterceptor
                        val loggingInterceptor = HttpLoggingInterceptor().apply {
                            level = HttpLoggingInterceptor.Level.BODY
                        }
                    """.trimIndent(),
                    explanation = "日志拦截器用于记录请求和响应信息，便于调试。可以使用自定义拦截器或HttpLoggingInterceptor。"
                ),
                CodeExample(
                    title = "示例4：缓存拦截器",
                    code = """
                        class CacheInterceptor : Interceptor {
                            
                            override fun intercept(chain: Interceptor.Chain): Response {
                                val request = chain.request()
                                
                                // 尝试从缓存获取响应
                                val cacheResponse = getCachedResponse(request)
                                if (cacheResponse != null) {
                                    return cacheResponse
                                }
                                
                                // 执行网络请求
                                val response = chain.proceed(request)
                                
                                // 缓存响应
                                cacheResponse(response)
                                
                                return response
                            }
                            
                            private fun getCachedResponse(request: Request): Response? {
                                // 从缓存获取响应的逻辑
                                return null
                            }
                            
                            private fun cacheResponse(response: Response) {
                                // 缓存响应的逻辑
                            }
                        }
                        
                        // 或者使用OkHttp内置缓存
                        val cache = Cache(
                            directory = File(context.cacheDir, "http_cache"),
                            maxSize = 10 * 1024 * 1024L // 10MB
                        )
                        
                        val client = OkHttpClient.Builder()
                            .cache(cache)
                            .build()
                    """.trimIndent(),
                    explanation = "缓存拦截器用于缓存HTTP响应，减少网络请求。可以使用自定义拦截器或OkHttp内置的Cache。"
                )
            ),
            useCases = listOf(
                "HTTP客户端：使用OkHttp作为HTTP客户端",
                "认证：使用拦截器实现自动认证",
                "日志：使用拦截器记录请求和响应日志",
                "缓存：使用缓存减少网络请求",
                "重试：实现请求重试机制"
            ),
            notes = listOf(
                "OkHttp是Retrofit的底层HTTP客户端",
                "拦截器分为应用拦截器和网络拦截器",
                "应用拦截器在请求发送前和响应返回后执行",
                "网络拦截器在建立连接后执行，可以访问实际网络请求",
                "连接池可以复用连接，提升性能",
                "缓存可以减少网络请求，提升响应速度",
                "超时配置包括连接、读取、写入超时"
            ),
            practiceTips = "建议使用OkHttp作为HTTP客户端，它提供了强大的功能和良好的性能。使用拦截器实现认证、日志等功能。配置连接池和缓存提升性能。注意超时配置，避免请求长时间等待。使用Cookie管理自动处理Cookie。"
        ),
        
        KnowledgeDetail(
            id = "data_parsing",
            title = "数据解析（JSON、XML、Protobuf）",
            overview = "网络请求返回的数据通常是JSON、XML或Protobuf格式，需要解析成对象。理解不同数据格式的解析方法是网络编程的基础。",
            keyPoints = listOf(
                "JSON解析：使用Gson、Moshi等库解析JSON数据",
                "XML解析：使用XmlPullParser等解析XML数据",
                "Protobuf：使用Protocol Buffers进行数据序列化",
                "数据转换：使用Retrofit的转换器自动解析数据",
                "自定义解析：实现自定义的数据解析逻辑",
                "错误处理：处理解析错误和异常情况"
            ),
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：JSON解析（Gson）",
                    code = """
                        // 数据类
                        data class User(
                            val id: Long,
                            val name: String,
                            val email: String,
                            val age: Int
                        )
                        
                        // 使用Gson解析JSON
                        class JsonParser {
                            private val gson = Gson()
                            
                            // 解析单个对象
                            fun parseUser(json: String): User {
                                return gson.fromJson(json, User::class.java)
                            }
                            
                            // 解析列表
                            fun parseUsers(json: String): List<User> {
                                val type = object : TypeToken<List<User>>() {}.type
                                return gson.fromJson(json, type)
                            }
                            
                            // 对象转JSON
                            fun toJson(user: User): String {
                                return gson.toJson(user)
                            }
                            
                            // 处理嵌套对象
                            data class UserResponse(
                                val code: Int,
                                val message: String,
                                val data: User
                            )
                            
                            fun parseUserResponse(json: String): UserResponse {
                                return gson.fromJson(json, UserResponse::class.java)
                            }
                        }
                        
                        // 在Retrofit中使用GsonConverterFactory
                        val retrofit = Retrofit.Builder()
                            .baseUrl("https://api.example.com/")
                            .addConverterFactory(GsonConverterFactory.create())
                            .build()
                    """.trimIndent(),
                    explanation = "Gson是Google开发的JSON解析库，可以自动将JSON转换为对象，也可以将对象转换为JSON。在Retrofit中使用GsonConverterFactory自动解析响应。"
                ),
                CodeExample(
                    title = "示例2：JSON解析（Moshi）",
                    code = """
                        // 使用Moshi解析JSON（Kotlin友好）
                        class MoshiParser {
                            private val moshi = Moshi.Builder()
                                .add(KotlinJsonAdapterFactory())
                                .build()
                            
                            private val userAdapter = moshi.adapter(User::class.java)
                            
                            // 解析JSON
                            fun parseUser(json: String): User? {
                                return try {
                                    userAdapter.fromJson(json)
                                } catch (e: Exception) {
                                    null
                                }
                            }
                            
                            // 对象转JSON
                            fun toJson(user: User): String {
                                return userAdapter.toJson(user)
                            }
                        }
                        
                        // 在Retrofit中使用MoshiConverterFactory
                        val moshi = Moshi.Builder()
                            .add(KotlinJsonAdapterFactory())
                            .build()
                        
                        val retrofit = Retrofit.Builder()
                            .baseUrl("https://api.example.com/")
                            .addConverterFactory(MoshiConverterFactory.create(moshi))
                            .build()
                    """.trimIndent(),
                    explanation = "Moshi是Square开发的JSON解析库，对Kotlin更友好。使用KotlinJsonAdapterFactory支持Kotlin特性，如数据类、可空类型等。"
                ),
                CodeExample(
                    title = "示例3：XML解析",
                    code = """
                        // XML数据
                        // <users>
                        //     <user>
                        //         <id>1</id>
                        //         <name>John</name>
                        //         <email>john@example.com</email>
                        //     </user>
                        // </users>
                        
                        class XmlParser(private val context: Context) {
                            
                            fun parseUsers(xml: String): List<User> {
                                val users = mutableListOf<User>()
                                
                                val parser = Xml.newPullParser()
                                parser.setInput(StringReader(xml))
                                
                                var eventType = parser.eventType
                                var currentUser: User? = null
                                var currentTag: String? = null
                                
                                while (eventType != XmlPullParser.END_DOCUMENT) {
                                    when (eventType) {
                                        XmlPullParser.START_TAG -> {
                                            when (parser.name) {
                                                "user" -> {
                                                    currentUser = User(0, "", "", 0)
                                                }
                                                "id", "name", "email", "age" -> {
                                                    currentTag = parser.name
                                                }
                                            }
                                        }
                                        XmlPullParser.TEXT -> {
                                            val text = parser.text
                                            currentUser?.let { user ->
                                                when (currentTag) {
                                                    "id" -> user.id = text.toLong()
                                                    "name" -> user.name = text
                                                    "email" -> user.email = text
                                                    "age" -> user.age = text.toInt()
                                                }
                                            }
                                        }
                                        XmlPullParser.END_TAG -> {
                                            if (parser.name == "user") {
                                                currentUser?.let { users.add(it) }
                                                currentUser = null
                                            }
                                            currentTag = null
                                        }
                                    }
                                    eventType = parser.next()
                                }
                                
                                return users
                            }
                        }
                    """.trimIndent(),
                    explanation = "XML解析使用XmlPullParser，通过事件驱动的方式解析XML。需要处理START_TAG、TEXT、END_TAG等事件。"
                ),
                CodeExample(
                    title = "示例4：Protobuf",
                    code = """
                        // 定义.proto文件
                        // syntax = "proto3";
                        // 
                        // message User {
                        //     int64 id = 1;
                        //     string name = 2;
                        //     string email = 3;
                        //     int32 age = 4;
                        // }
                        
                        // 使用Protobuf（需要先编译.proto文件生成Java类）
                        class ProtobufParser {
                            
                            // 序列化
                            fun serializeUser(user: User): ByteArray {
                                return user.toByteArray()
                            }
                            
                            // 反序列化
                            fun deserializeUser(data: ByteArray): User {
                                return User.parseFrom(data)
                            }
                        }
                        
                        // 在Retrofit中使用ProtobufConverterFactory
                        val retrofit = Retrofit.Builder()
                            .baseUrl("https://api.example.com/")
                            .addConverterFactory(ProtoConverterFactory.create())
                            .build()
                        
                        // Protobuf的优势：
                        // 1. 更小的数据体积
                        // 2. 更快的解析速度
                        // 3. 类型安全
                        // 4. 向后兼容
                    """.trimIndent(),
                    explanation = "Protobuf是Google开发的数据序列化格式，比JSON更小更快。需要先定义.proto文件，然后编译生成Java类。在Retrofit中使用ProtoConverterFactory。"
                )
            ),
            useCases = listOf(
                "API响应解析：解析RESTful API返回的JSON数据",
                "数据序列化：将对象序列化为JSON发送到服务器",
                "XML处理：处理XML格式的数据",
                "高性能场景：使用Protobuf提升性能",
                "数据转换：使用转换器自动解析数据"
            ),
            notes = listOf(
                "JSON是最常用的数据格式，Gson和Moshi是常用的解析库",
                "Moshi对Kotlin更友好，支持Kotlin特性",
                "XML解析使用XmlPullParser，是事件驱动的",
                "Protobuf比JSON更小更快，适合高性能场景",
                "Retrofit支持多种转换器，可以自动解析响应",
                "需要处理解析错误和异常情况",
                "自定义解析可以实现特殊的数据格式处理"
            ),
            practiceTips = "建议使用Gson或Moshi解析JSON数据，Moshi对Kotlin更友好。在Retrofit中使用转换器自动解析响应。对于XML数据，使用XmlPullParser解析。对于高性能场景，考虑使用Protobuf。注意处理解析错误和异常情况。"
        ),
        
        KnowledgeDetail(
            id = "networking_best",
            title = "网络最佳实践",
            overview = "网络编程的最佳实践包括错误处理、重试机制、缓存策略、性能优化等。遵循最佳实践可以构建稳定、高效的网络应用。",
            keyPoints = listOf(
                "错误处理：统一的错误处理机制，处理网络错误和业务错误",
                "重试机制：实现智能重试，处理临时网络故障",
                "缓存策略：使用缓存减少网络请求，提升响应速度",
                "性能优化：优化网络请求，减少数据传输",
                "安全性：使用HTTPS、证书锁定等保证安全性",
                "监控和日志：记录网络请求日志，监控网络性能"
            ),
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：统一错误处理",
                    code = """
                        // 定义错误类型
                        sealed class NetworkError {
                            data class HttpError(val code: Int, val message: String) : NetworkError()
                            data class NetworkException(val message: String) : NetworkError()
                            data class ParseError(val message: String) : NetworkError()
                            object UnknownError : NetworkError()
                        }
                        
                        // 统一错误处理函数
                        class NetworkErrorHandler {
                            
                            suspend fun <T> safeApiCall(
                                apiCall: suspend () -> Response<T>
                            ): Result<T, NetworkError> {
                                return try {
                                    val response = apiCall()
                                    if (response.isSuccessful) {
                                        Result.success(response.body()!!)
                                    } else {
                                        Result.failure(
                                            NetworkError.HttpError(
                                                response.code(),
                                                response.message()
                                            )
                                        )
                                    }
                                } catch (e: HttpException) {
                                    Result.failure(
                                        NetworkError.HttpError(e.code(), e.message())
                                    )
                                } catch (e: IOException) {
                                    Result.failure(
                                        NetworkError.NetworkException(e.message ?: "网络错误")
                                    )
                                } catch (e: Exception) {
                                    Result.failure(NetworkError.UnknownError)
                                }
                            }
                        }
                        
                        // 在Repository中使用
                        class UserRepository(
                            private val apiService: ApiService,
                            private val errorHandler: NetworkErrorHandler
                        ) {
                            suspend fun getUsers(): Result<List<User>, NetworkError> {
                                return errorHandler.safeApiCall { apiService.getUsers() }
                            }
                        }
                    """.trimIndent(),
                    explanation = "统一的错误处理机制可以简化错误处理逻辑。使用sealed class定义错误类型，使用统一的错误处理函数处理各种错误。"
                ),
                CodeExample(
                    title = "示例2：重试机制",
                    code = """
                        class RetryInterceptor(
                            private val maxRetries: Int = 3
                        ) : Interceptor {
                            
                            override fun intercept(chain: Interceptor.Chain): Response {
                                var request = chain.request()
                                var response: Response? = null
                                var lastException: IOException? = null
                                
                                for (attempt in 0..maxRetries) {
                                    try {
                                        response = chain.proceed(request)
                                        
                                        // 如果成功或不可重试的错误，直接返回
                                        if (response.isSuccessful || !shouldRetry(response, attempt)) {
                                            return response
                                        }
                                        
                                        // 关闭响应体
                                        response.close()
                                    } catch (e: IOException) {
                                        lastException = e
                                        
                                        // 如果是最后一次尝试，抛出异常
                                        if (attempt == maxRetries) {
                                            throw e
                                        }
                                    }
                                    
                                    // 等待后重试
                                    Thread.sleep(getRetryDelay(attempt))
                                }
                                
                                throw lastException ?: IOException("未知错误")
                            }
                            
                            private fun shouldRetry(response: Response, attempt: Int): Boolean {
                                // 只对特定错误码重试
                                return response.code in listOf(500, 502, 503, 504) && attempt < maxRetries
                            }
                            
                            private fun getRetryDelay(attempt: Int): Long {
                                // 指数退避
                                return (1000 * (1 shl attempt)).toLong()
                            }
                        }
                    """.trimIndent(),
                    explanation = "重试机制可以处理临时网络故障。使用拦截器实现重试逻辑，支持指数退避策略。只对特定错误码重试，避免无限重试。"
                ),
                CodeExample(
                    title = "示例3：缓存策略",
                    code = """
                        class CacheStrategy {
                            
                            // 使用OkHttp缓存
                            fun createCache(context: Context): Cache {
                                val cacheSize = 10 * 1024 * 1024L // 10MB
                                val cacheDir = File(context.cacheDir, "http_cache")
                                return Cache(cacheDir, cacheSize)
                            }
                            
                            // 缓存拦截器
                            class CacheInterceptor : Interceptor {
                                override fun intercept(chain: Interceptor.Chain): Response {
                                    val request = chain.request()
                                    
                                    // 检查缓存
                                    val cacheResponse = getCachedResponse(request)
                                    if (cacheResponse != null && isCacheValid(cacheResponse)) {
                                        return cacheResponse
                                    }
                                    
                                    // 执行网络请求
                                    val response = chain.proceed(request)
                                    
                                    // 缓存响应
                                    if (shouldCache(response)) {
                                        cacheResponse(response)
                                    }
                                    
                                    return response
                                }
                                
                                private fun getCachedResponse(request: Request): Response? {
                                    // 从缓存获取响应
                                    return null
                                }
                                
                                private fun isCacheValid(response: Response): Boolean {
                                    // 检查缓存是否有效
                                    val cacheControl = response.header("Cache-Control")
                                    return cacheControl?.contains("max-age") == true
                                }
                                
                                private fun shouldCache(response: Response): Boolean {
                                    // 判断是否应该缓存
                                    return response.isSuccessful && response.code == 200
                                }
                                
                                private fun cacheResponse(response: Response) {
                                    // 缓存响应
                                }
                            }
                            
                            // 在请求中设置缓存控制
                            fun createCachedRequest(url: String): Request {
                                return Request.Builder()
                                    .url(url)
                                    .header("Cache-Control", "max-age=3600") // 缓存1小时
                                    .build()
                            }
                        }
                    """.trimIndent(),
                    explanation = "缓存策略可以减少网络请求，提升响应速度。使用OkHttp缓存或自定义缓存拦截器实现缓存。根据响应头判断缓存是否有效。"
                ),
                CodeExample(
                    title = "示例4：性能优化",
                    code = """
                        class NetworkOptimizer {
                            
                            // 1. 使用连接池
                            fun createOptimizedClient(): OkHttpClient {
                                return OkHttpClient.Builder()
                                    .connectionPool(
                                        ConnectionPool(
                                            maxIdleConnections = 5,
                                            keepAliveDuration = 5,
                                            timeUnit = TimeUnit.MINUTES
                                        )
                                    )
                                    .build()
                            }
                            
                            // 2. 压缩请求和响应
                            class CompressionInterceptor : Interceptor {
                                override fun intercept(chain: Interceptor.Chain): Response {
                                    val request = chain.request().newBuilder()
                                        .header("Accept-Encoding", "gzip")
                                        .build()
                                    
                                    val response = chain.proceed(request)
                                    
                                    // 自动解压响应
                                    return response
                                }
                            }
                            
                            // 3. 批量请求
                            suspend fun batchRequest(requests: List<Request>): List<Response> {
                                return coroutineScope {
                                    requests.map { request ->
                                        async { executeRequest(request) }
                                    }.awaitAll()
                                }
                            }
                            
                            // 4. 请求去重
                            class RequestDeduplicationInterceptor : Interceptor {
                                private val pendingRequests = mutableMapOf<String, Deferred<Response>>()
                                
                                override fun intercept(chain: Interceptor.Chain): Response {
                                    val request = chain.request()
                                    val key = request.url.toString()
                                    
                                    // 如果已有相同请求在进行，等待其结果
                                    pendingRequests[key]?.let {
                                        return it.await()
                                    }
                                    
                                    // 执行请求
                                    val deferred = async { chain.proceed(request) }
                                    pendingRequests[key] = deferred
                                    
                                    return try {
                                        deferred.await()
                                    } finally {
                                        pendingRequests.remove(key)
                                    }
                                }
                            }
                        }
                    """.trimIndent(),
                    explanation = "网络性能优化包括使用连接池、压缩数据、批量请求、请求去重等。这些优化可以提升网络请求的效率和性能。"
                )
            ),
            useCases = listOf(
                "错误处理：统一的错误处理机制，提升用户体验",
                "重试机制：处理临时网络故障，提高请求成功率",
                "缓存策略：减少网络请求，提升响应速度",
                "性能优化：优化网络请求，提升应用性能",
                "安全性：保证数据传输安全"
            ),
            notes = listOf(
                "统一的错误处理可以简化错误处理逻辑",
                "重试机制应该使用指数退避策略，避免过度重试",
                "缓存策略可以减少网络请求，但需要注意缓存失效",
                "使用连接池可以复用连接，提升性能",
                "压缩数据可以减少传输量，提升速度",
                "使用HTTPS保证数据传输安全",
                "记录网络请求日志，便于调试和监控"
            ),
            practiceTips = "建议实现统一的错误处理机制，简化错误处理逻辑。使用重试机制处理临时网络故障，使用指数退避策略。实现缓存策略减少网络请求。优化网络性能，使用连接池、压缩等。使用HTTPS保证安全性。记录网络请求日志，便于调试和监控。"
        ),
        
        // ========== 架构组件 ==========
        
        KnowledgeDetail(
            id = "viewmodel",
            title = "ViewModel（生命周期、状态管理）",
            overview = "ViewModel是Android架构组件的核心，用于存储和管理UI相关的数据。ViewModel在配置变更（如屏幕旋转）时不会销毁，可以保存数据。",
            keyPoints = listOf(
                "生命周期：ViewModel的生命周期与Activity/Fragment不同，在配置变更时不会销毁",
                "数据保存：ViewModel可以保存UI数据，避免配置变更时数据丢失",
                "作用域：ViewModel可以绑定到Activity、Fragment或Navigation图",
                "状态管理：使用StateFlow或LiveData在ViewModel中管理状态",
                "协程支持：使用viewModelScope执行协程任务，自动取消",
                "依赖注入：使用Hilt等框架注入ViewModel"
            ),
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：ViewModel基础使用",
                    code = """
                        class UserViewModel : ViewModel() {
                            
                            // 使用StateFlow管理状态
                            private val _users = MutableStateFlow<List<User>>(emptyList())
                            val users: StateFlow<List<User>> = _users.asStateFlow()
                            
                            private val _isLoading = MutableStateFlow(false)
                            val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()
                            
                            // 加载数据
                            fun loadUsers() {
                                viewModelScope.launch {
                                    _isLoading.value = true
                                    try {
                                        val userList = repository.getUsers()
                                        _users.value = userList
                                    } catch (e: Exception) {
                                        // 处理错误
                                    } finally {
                                        _isLoading.value = false
                                    }
                                }
                            }
                            
                            // 添加用户
                            fun addUser(user: User) {
                                viewModelScope.launch {
                                    repository.insertUser(user)
                                    loadUsers() // 重新加载
                                }
                            }
                        }
                        
                        // 在Activity中使用
                        class MainActivity : AppCompatActivity() {
                            private val viewModel: UserViewModel by viewModels()
                            
                            override fun onCreate(savedInstanceState: Bundle?) {
                                super.onCreate(savedInstanceState)
                                
                                // 观察状态
                                lifecycleScope.launch {
                                    viewModel.users.collect { users ->
                                        // 更新UI
                                    }
                                }
                                
                                lifecycleScope.launch {
                                    viewModel.isLoading.collect { isLoading ->
                                        // 显示/隐藏加载指示器
                                    }
                                }
                            }
                        }
                    """.trimIndent(),
                    explanation = "ViewModel使用StateFlow管理状态，使用viewModelScope执行协程任务。在Activity中使用viewModels()委托获取ViewModel实例，观察StateFlow更新UI。"
                ),
                CodeExample(
                    title = "示例2：ViewModel生命周期",
                    code = """
                        class MyViewModel : ViewModel() {
                            
                            init {
                                // ViewModel创建时执行
                                Log.d("ViewModel", "ViewModel created")
                            }
                            
                            override fun onCleared() {
                                super.onCleared()
                                // ViewModel销毁时执行（Activity真正finish时）
                                Log.d("ViewModel", "ViewModel cleared")
                                // 清理资源
                            }
                        }
                        
                        // ViewModel生命周期说明：
                        // 1. ViewModel在Activity/Fragment创建时创建
                        // 2. 配置变更（如屏幕旋转）时，ViewModel不会销毁
                        // 3. Activity真正finish时，ViewModel才会销毁
                        // 4. Fragment的ViewModel在Fragment销毁时销毁
                        
                        // 在Fragment中使用
                        class MyFragment : Fragment() {
                            // Fragment作用域的ViewModel
                            private val viewModel: MyViewModel by viewModels()
                            
                            // 或者Activity作用域的ViewModel（多个Fragment共享）
                            private val sharedViewModel: MyViewModel by activityViewModels()
                        }
                    """.trimIndent(),
                    explanation = "ViewModel的生命周期与Activity/Fragment不同。配置变更时ViewModel不会销毁，只有在Activity真正finish时才会销毁。Fragment可以使用viewModels()或activityViewModels()获取不同作用域的ViewModel。"
                ),
                CodeExample(
                    title = "示例3：ViewModel与SavedStateHandle",
                    code = """
                        class MyViewModel(
                            private val savedStateHandle: SavedStateHandle
                        ) : ViewModel() {
                            
                            // 保存和恢复状态
                            var userName: String
                                get() = savedStateHandle.get<String>("user_name") ?: ""
                                set(value) = savedStateHandle.set("user_name", value)
                            
                            // 使用StateFlow
                            val userNameFlow: StateFlow<String> = savedStateHandle
                                .getStateFlow("user_name", "")
                            
                            // 保存复杂对象
                            var user: User?
                                get() = savedStateHandle.get<User>("user")
                                set(value) = savedStateHandle.set("user", value)
                        }
                        
                        // SavedStateHandle的优势：
                        // 1. 在配置变更时保存状态
                        // 2. 在进程被杀死后恢复状态
                        // 3. 支持StateFlow，自动响应状态变化
                    """.trimIndent(),
                    explanation = "SavedStateHandle用于保存和恢复ViewModel的状态。支持在配置变更和进程被杀死后恢复状态。可以使用getStateFlow创建StateFlow，自动响应状态变化。"
                ),
                CodeExample(
                    title = "示例4：ViewModel与Hilt集成",
                    code = """
                        // 使用@HiltViewModel注解
                        @HiltViewModel
                        class UserViewModel @Inject constructor(
                            private val userRepository: UserRepository
                        ) : ViewModel() {
                            
                            private val _users = MutableStateFlow<List<User>>(emptyList())
                            val users: StateFlow<List<User>> = _users.asStateFlow()
                            
                            fun loadUsers() {
                                viewModelScope.launch {
                                    _users.value = userRepository.getUsers()
                                }
                            }
                        }
                        
                        // 在Activity中使用（需要@AndroidEntryPoint）
                        @AndroidEntryPoint
                        class MainActivity : AppCompatActivity() {
                            private val viewModel: UserViewModel by viewModels()
                            // 直接使用，无需手动创建
                        }
                        
                        // 在Fragment中使用
                        @AndroidEntryPoint
                        class MyFragment : Fragment() {
                            private val viewModel: UserViewModel by viewModels()
                        }
                    """.trimIndent(),
                    explanation = "使用Hilt可以自动注入ViewModel的依赖。使用@HiltViewModel注解ViewModel，使用@Inject构造函数注入依赖。在Activity/Fragment中使用@AndroidEntryPoint，然后直接使用viewModels()获取ViewModel。"
                )
            ),
            useCases = listOf(
                "数据管理：使用ViewModel管理UI相关的数据",
                "配置变更：在配置变更时保存数据，避免数据丢失",
                "状态管理：使用StateFlow或LiveData管理UI状态",
                "业务逻辑：在ViewModel中处理业务逻辑，保持Activity/Fragment简洁",
                "数据共享：使用Activity作用域的ViewModel在Fragment间共享数据"
            ),
            notes = listOf(
                "ViewModel在配置变更时不会销毁，可以保存数据",
                "ViewModel的生命周期与Activity/Fragment不同",
                "使用viewModelScope执行协程任务，自动取消",
                "使用StateFlow或LiveData管理状态",
                "SavedStateHandle可以保存和恢复状态，支持进程被杀死后恢复",
                "使用Hilt可以自动注入ViewModel的依赖",
                "ViewModel不应该持有Activity/Fragment的引用，避免内存泄漏"
            ),
            practiceTips = "建议使用ViewModel管理所有UI相关的数据，Activity/Fragment只负责UI展示。使用StateFlow或LiveData管理状态，在UI中观察状态变化。使用viewModelScope执行协程任务。使用SavedStateHandle保存需要恢复的状态。使用Hilt注入ViewModel的依赖。注意ViewModel的生命周期，不要在ViewModel中持有Activity/Fragment的引用。"
        ),
        
        KnowledgeDetail(
            id = "livedata",
            title = "LiveData（观察、转换）",
            overview = "LiveData是Android架构组件提供的可观察数据持有者，具有生命周期感知能力。LiveData会在观察者处于活动状态时更新UI，自动处理生命周期。",
            keyPoints = listOf(
                "生命周期感知：LiveData自动感知生命周期，只在观察者处于活动状态时更新",
                "数据观察：使用observe方法观察LiveData的变化",
                "数据转换：使用Transformations.map和switchMap转换LiveData",
                "MediatorLiveData：组合多个LiveData源",
                "与ViewModel集成：在ViewModel中暴露LiveData",
                "与StateFlow对比：理解LiveData和StateFlow的区别"
            ),
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：LiveData基础使用",
                    code = """
                        class UserViewModel : ViewModel() {
                            
                            // MutableLiveData：可变的LiveData
                            private val _users = MutableLiveData<List<User>>()
                            val users: LiveData<List<User>> = _users
                            
                            private val _isLoading = MutableLiveData<Boolean>()
                            val isLoading: LiveData<Boolean> = _isLoading
                            
                            fun loadUsers() {
                                _isLoading.value = true
                                viewModelScope.launch {
                                    try {
                                        val userList = repository.getUsers()
                                        _users.postValue(userList)  // 后台线程使用postValue
                                        // 或 _users.value = userList  // 主线程使用value
                                    } finally {
                                        _isLoading.value = false
                                    }
                                }
                            }
                        }
                        
                        // 在Activity中观察
                        class MainActivity : AppCompatActivity() {
                            private val viewModel: UserViewModel by viewModels()
                            
                            override fun onCreate(savedInstanceState: Bundle?) {
                                super.onCreate(savedInstanceState)
                                
                                // 观察LiveData
                                viewModel.users.observe(this) { users ->
                                    // 更新UI（自动在主线程执行）
                                    updateUI(users)
                                }
                                
                                viewModel.isLoading.observe(this) { isLoading ->
                                    // 显示/隐藏加载指示器
                                    showLoading(isLoading)
                                }
                            }
                        }
                    """.trimIndent(),
                    explanation = "LiveData使用MutableLiveData创建可变LiveData，在ViewModel中暴露不可变的LiveData。使用observe方法观察LiveData，自动在主线程更新UI。"
                ),
                CodeExample(
                    title = "示例2：LiveData转换",
                    code = """
                        class UserViewModel : ViewModel() {
                            private val _userId = MutableLiveData<Long>()
                            val userId: LiveData<Long> = _userId
                            
                            // 使用Transformations.map转换数据
                            val userName: LiveData<String> = Transformations.map(_userId) { id ->
                                // 根据ID获取用户名
                                repository.getUserName(id)
                            }
                            
                            // 使用Transformations.switchMap切换LiveData源
                            val userPosts: LiveData<List<Post>> = Transformations.switchMap(_userId) { id ->
                                // 当userId变化时，切换到一个新的LiveData
                                repository.getUserPosts(id)
                            }
                            
                            fun setUserId(id: Long) {
                                _userId.value = id
                            }
                        }
                        
                        // 自定义转换函数
                        fun <X, Y> LiveData<X>.map(transform: (X) -> Y): LiveData<Y> {
                            val result = MutableLiveData<Y>()
                            this.observeForever { x ->
                                result.value = transform(x)
                            }
                            return result
                        }
                    """.trimIndent(),
                    explanation = "Transformations.map用于转换LiveData的值，Transformations.switchMap用于切换LiveData源。这些转换函数返回新的LiveData，可以链式调用。"
                ),
                CodeExample(
                    title = "示例3：MediatorLiveData",
                    code = """
                        class UserViewModel : ViewModel() {
                            private val _users = MutableLiveData<List<User>>()
                            val users: LiveData<List<User>> = _users
                            
                            private val _filter = MutableLiveData<String>()
                            val filter: LiveData<String> = _filter
                            
                            // 使用MediatorLiveData组合多个LiveData
                            val filteredUsers: LiveData<List<User>> = MediatorLiveData<List<User>>().apply {
                                // 添加users源
                                addSource(_users) { userList ->
                                    value = filterUsers(userList, _filter.value)
                                }
                                
                                // 添加filter源
                                addSource(_filter) { filterText ->
                                    value = filterUsers(_users.value, filterText)
                                }
                            }
                            
                            private fun filterUsers(users: List<User>?, filter: String?): List<User> {
                                if (users == null || filter.isNullOrEmpty()) {
                                    return users ?: emptyList()
                                }
                                return users.filter { it.name.contains(filter, ignoreCase = true) }
                            }
                            
                            fun setFilter(filter: String) {
                                _filter.value = filter
                            }
                        }
                    """.trimIndent(),
                    explanation = "MediatorLiveData用于组合多个LiveData源。当任何一个源发生变化时，MediatorLiveData都会重新计算值。适合需要组合多个数据源的场景。"
                ),
                CodeExample(
                    title = "示例4：LiveData vs StateFlow",
                    code = """
                        // LiveData特点：
                        // 1. 生命周期感知，自动取消观察
                        // 2. 只在观察者处于活动状态时更新
                        // 3. 只能在主线程设置值
                        // 4. 不支持协程
                        
                        class LiveDataViewModel : ViewModel() {
                            private val _users = MutableLiveData<List<User>>()
                            val users: LiveData<List<User>> = _users
                            
                            fun loadUsers() {
                                viewModelScope.launch {
                                    val userList = repository.getUsers()
                                    _users.postValue(userList)  // 后台线程使用postValue
                                }
                            }
                        }
                        
                        // StateFlow特点：
                        // 1. 支持协程，可以使用collect
                        // 2. 支持冷流和热流
                        // 3. 可以在任何线程设置值
                        // 4. 需要手动管理生命周期
                        
                        class StateFlowViewModel : ViewModel() {
                            private val _users = MutableStateFlow<List<User>>(emptyList())
                            val users: StateFlow<List<User>> = _users.asStateFlow()
                            
                            fun loadUsers() {
                                viewModelScope.launch {
                                    val userList = repository.getUsers()
                                    _users.value = userList  // 任何线程都可以设置
                                }
                            }
                        }
                        
                        // 在Compose中使用StateFlow
                        @Composable
                        fun UserScreen(viewModel: StateFlowViewModel) {
                            val users by viewModel.users.collectAsState()
                            // 使用users更新UI
                        }
                        
                        // 选择建议：
                        // - 新项目推荐使用StateFlow
                        // - 已有LiveData的项目可以继续使用
                        // - Compose项目推荐使用StateFlow
                    """.trimIndent(),
                    explanation = "LiveData和StateFlow都可以用于状态管理。LiveData具有生命周期感知能力，StateFlow支持协程和Compose。新项目推荐使用StateFlow，特别是使用Compose的项目。"
                )
            ),
            useCases = listOf(
                "状态管理：使用LiveData管理UI状态",
                "数据观察：观察数据变化，自动更新UI",
                "数据转换：使用Transformations转换LiveData",
                "数据组合：使用MediatorLiveData组合多个数据源",
                "生命周期感知：自动处理生命周期，避免内存泄漏"
            ),
            notes = listOf(
                "LiveData具有生命周期感知能力，只在观察者处于活动状态时更新",
                "使用MutableLiveData创建可变LiveData，暴露不可变的LiveData",
                "使用observe方法观察LiveData，自动在主线程更新UI",
                "使用postValue在后台线程设置值，使用value在主线程设置值",
                "Transformations.map和switchMap用于转换LiveData",
                "MediatorLiveData用于组合多个LiveData源",
                "StateFlow是更现代的选择，推荐在新项目中使用"
            ),
            practiceTips = "建议在新项目中使用StateFlow替代LiveData，特别是使用Compose的项目。如果使用LiveData，注意生命周期感知的特性，只在观察者处于活动状态时更新。使用Transformations转换LiveData，使用MediatorLiveData组合多个数据源。注意线程安全，使用postValue在后台线程设置值。"
        ),
        
        KnowledgeDetail(
            id = "data_binding",
            title = "数据绑定（Data Binding）",
            overview = "Data Binding是Android的数据绑定库，允许在布局文件中直接绑定数据，减少findViewById的使用。Data Binding支持双向绑定，可以自动更新UI。",
            keyPoints = listOf(
                "布局绑定：在布局文件中使用表达式绑定数据",
                "双向绑定：支持双向数据绑定，自动同步数据",
                "事件绑定：在布局文件中绑定事件处理",
                "BindingAdapter：自定义属性绑定",
                "可观察性：支持LiveData、Observable等可观察对象",
                "性能优化：编译时生成绑定类，性能优于findViewById"
            ),
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：Data Binding基础配置",
                    code = """
                        // build.gradle
                        android {
                            buildFeatures {
                                dataBinding = true
                            }
                        }
                        
                        // 布局文件：activity_main.xml
                        // <layout xmlns:android="http://schemas.android.com/apk/res/android">
                        //     <data>
                        //         <variable
                        //             name="user"
                        //             type="com.example.User" />
                        //         <variable
                        //             name="viewModel"
                        //             type="com.example.UserViewModel" />
                        //     </data>
                        //     
                        //     <LinearLayout>
                        //         <TextView
                        //             android:text="@{user.name}" />
                        //         <TextView
                        //             android:text="@{String.valueOf(user.age)}" />
                        //         <Button
                        //             android:onClick="@{() -> viewModel.onButtonClick()}" />
                        //     </LinearLayout>
                        // </layout>
                        
                        // 在Activity中使用
                        class MainActivity : AppCompatActivity() {
                            private lateinit var binding: ActivityMainBinding
                            
                            override fun onCreate(savedInstanceState: Bundle?) {
                                super.onCreate(savedInstanceState)
                                
                                binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
                                
                                val user = User("John", 25)
                                binding.user = user
                                
                                val viewModel = ViewModelProvider(this)[UserViewModel::class.java]
                                binding.viewModel = viewModel
                                binding.lifecycleOwner = this  // 支持LiveData
                            }
                        }
                    """.trimIndent(),
                    explanation = "Data Binding需要在build.gradle中启用，在布局文件中使用<layout>标签和<data>标签定义变量。使用DataBindingUtil.setContentView获取绑定类，设置数据。"
                ),
                CodeExample(
                    title = "示例2：双向数据绑定",
                    code = """
                        // 布局文件
                        // <layout>
                        //     <data>
                        //         <variable name="user" type="com.example.User" />
                        //     </data>
                        //     
                        //     <LinearLayout>
                        //         <!-- 单向绑定：数据 -> UI -->
                        //         <TextView android:text="@{user.name}" />
                        //         
                        //         <!-- 双向绑定：数据 <-> UI -->
                        //         <EditText
                        //             android:text="@={user.name}" />
                        //         
                        //         <!-- 注意：@= 表示双向绑定 -->
                        //     </LinearLayout>
                        // </layout>
                        
                        // User类需要实现Observable
                        class User : BaseObservable() {
                            @get:Bindable
                            var name: String = ""
                                set(value) {
                                    field = value
                                    notifyPropertyChanged(BR.name)
                                }
                            
                            @get:Bindable
                            var age: Int = 0
                                set(value) {
                                    field = value
                                    notifyPropertyChanged(BR.age)
                                }
                        }
                        
                        // 或者使用ObservableField
                        class User {
                            val name = ObservableField<String>("")
                            val age = ObservableField<Int>(0)
                        }
                    """.trimIndent(),
                    explanation = "双向绑定使用@=语法，数据变化时UI自动更新，UI变化时数据自动更新。需要实现Observable接口或使用ObservableField。"
                ),
                CodeExample(
                    title = "示例3：BindingAdapter自定义属性",
                    code = """
                        // 自定义BindingAdapter
                        object ImageBindingAdapters {
                            
                            @JvmStatic
                            @BindingAdapter("imageUrl")
                            fun setImageUrl(imageView: ImageView, url: String?) {
                                url?.let {
                                    // 使用Glide或Coil加载图片
                                    Glide.with(imageView.context)
                                        .load(it)
                                        .into(imageView)
                                }
                            }
                            
                            @JvmStatic
                            @BindingAdapter("imageUrl", "placeholder")
                            fun setImageUrlWithPlaceholder(
                                imageView: ImageView,
                                url: String?,
                                placeholder: Drawable?
                            ) {
                                Glide.with(imageView.context)
                                    .load(url)
                                    .placeholder(placeholder)
                                    .into(imageView)
                            }
                            
                            @JvmStatic
                            @BindingAdapter("visible")
                            fun setVisible(view: View, visible: Boolean) {
                                view.visibility = if (visible) View.VISIBLE else View.GONE
                            }
                        }
                        
                        // 在布局文件中使用
                        // <ImageView
                        //     app:imageUrl="@{user.avatarUrl}"
                        //     app:placeholder="@drawable/placeholder" />
                        // 
                        // <TextView
                        //     app:visible="@{user.isVisible}" />
                    """.trimIndent(),
                    explanation = "BindingAdapter用于自定义属性绑定。使用@BindingAdapter注解定义自定义属性，可以在布局文件中使用这些属性。支持多个参数和条件绑定。"
                ),
                CodeExample(
                    title = "示例4：Data Binding与LiveData集成",
                    code = """
                        class UserViewModel : ViewModel() {
                            private val _user = MutableLiveData<User>()
                            val user: LiveData<User> = _user
                            
                            fun loadUser() {
                                viewModelScope.launch {
                                    _user.value = repository.getUser()
                                }
                            }
                        }
                        
                        // 在Activity中使用
                        class MainActivity : AppCompatActivity() {
                            private lateinit var binding: ActivityMainBinding
                            private val viewModel: UserViewModel by viewModels()
                            
                            override fun onCreate(savedInstanceState: Bundle?) {
                                super.onCreate(savedInstanceState)
                                
                                binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
                                binding.viewModel = viewModel
                                binding.lifecycleOwner = this  // 重要：设置lifecycleOwner
                            }
                        }
                        
                        // 布局文件
                        // <layout>
                        //     <data>
                        //         <variable name="viewModel" type="com.example.UserViewModel" />
                        //     </data>
                        //     
                        //     <LinearLayout>
                        //         <!-- LiveData自动观察，无需手动observe -->
                        //         <TextView
                        //             android:text="@{viewModel.user.name}" />
                        //     </LinearLayout>
                        // </layout>
                    """.trimIndent(),
                    explanation = "Data Binding支持LiveData，设置lifecycleOwner后，LiveData会自动观察，数据变化时UI自动更新。无需手动调用observe方法。"
                )
            ),
            useCases = listOf(
                "减少样板代码：减少findViewById的使用，简化代码",
                "双向绑定：实现UI和数据之间的双向同步",
                "自定义属性：使用BindingAdapter创建自定义属性",
                "LiveData集成：与LiveData集成，自动更新UI",
                "表达式支持：在布局文件中使用表达式"
            ),
            notes = listOf(
                "Data Binding需要在build.gradle中启用",
                "布局文件需要使用<layout>标签包裹",
                "双向绑定使用@=语法，需要实现Observable",
                "BindingAdapter用于自定义属性绑定",
                "设置lifecycleOwner后，LiveData会自动观察",
                "编译时生成绑定类，性能优于findViewById",
                "Data Binding适合传统View系统，Compose项目不需要"
            ),
            practiceTips = "建议在传统View系统中使用Data Binding，可以减少findViewById的使用。使用双向绑定实现UI和数据同步。使用BindingAdapter创建自定义属性。设置lifecycleOwner支持LiveData。注意Data Binding的表达式语法，避免复杂逻辑。对于Compose项目，不需要Data Binding。"
        ),
        
        KnowledgeDetail(
            id = "view_binding",
            title = "视图绑定（View Binding）",
            overview = "View Binding是Android提供的视图绑定功能，可以替代findViewById，提供类型安全的视图访问。View Binding比Data Binding更轻量，只提供视图绑定，不提供数据绑定。",
            keyPoints = listOf(
                "类型安全：编译时生成绑定类，提供类型安全的视图访问",
                "空安全：自动处理空值，避免NullPointerException",
                "性能优化：编译时生成代码，性能优于findViewById",
                "简化代码：减少findViewById的使用，简化代码",
                "自动生成：根据布局文件自动生成绑定类",
                "与findViewById对比：理解View Binding的优势"
            ),
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：View Binding基础使用",
                    code = """
                        // build.gradle（Android Studio 3.6+默认启用）
                        android {
                            buildFeatures {
                                viewBinding = true
                            }
                        }
                        
                        // 布局文件：activity_main.xml
                        // <LinearLayout>
                        //     <TextView android:id="@+id/title" />
                        //     <Button android:id="@+id/button" />
                        // </LinearLayout>
                        
                        // 在Activity中使用
                        class MainActivity : AppCompatActivity() {
                            private lateinit var binding: ActivityMainBinding
                            
                            override fun onCreate(savedInstanceState: Bundle?) {
                                super.onCreate(savedInstanceState)
                                
                                binding = ActivityMainBinding.inflate(layoutInflater)
                                setContentView(binding.root)
                                
                                // 访问视图（类型安全）
                                binding.title.text = "Hello"
                                binding.button.setOnClickListener {
                                    // 处理点击
                                }
                            }
                        }
                        
                        // 在Fragment中使用
                        class MyFragment : Fragment() {
                            private var _binding: FragmentMyBinding? = null
                            private val binding get() = _binding!!
                            
                            override fun onCreateView(
                                inflater: LayoutInflater,
                                container: ViewGroup?,
                                savedInstanceState: Bundle?
                            ): View {
                                _binding = FragmentMyBinding.inflate(inflater, container, false)
                                return binding.root
                            }
                            
                            override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
                                super.onViewCreated(view, savedInstanceState)
                                
                                binding.title.text = "Hello"
                                binding.button.setOnClickListener {
                                    // 处理点击
                                }
                            }
                            
                            override fun onDestroyView() {
                                super.onDestroyView()
                                _binding = null  // 避免内存泄漏
                            }
                        }
                    """.trimIndent(),
                    explanation = "View Binding使用Binding类访问视图，提供类型安全。在Activity中使用inflate方法，在Fragment中需要在onDestroyView中置空binding避免内存泄漏。"
                ),
                CodeExample(
                    title = "示例2：View Binding与findViewById对比",
                    code = """
                        // 使用findViewById（旧方式）
                        class MainActivity : AppCompatActivity() {
                            private lateinit var titleTextView: TextView
                            private lateinit var button: Button
                            
                            override fun onCreate(savedInstanceState: Bundle?) {
                                super.onCreate(savedInstanceState)
                                setContentView(R.layout.activity_main)
                                
                                titleTextView = findViewById(R.id.title)
                                button = findViewById(R.id.button)
                                
                                titleTextView.text = "Hello"
                                button.setOnClickListener { }
                            }
                        }
                        
                        // 使用View Binding（新方式）
                        class MainActivity : AppCompatActivity() {
                            private lateinit var binding: ActivityMainBinding
                            
                            override fun onCreate(savedInstanceState: Bundle?) {
                                super.onCreate(savedInstanceState)
                                
                                binding = ActivityMainBinding.inflate(layoutInflater)
                                setContentView(binding.root)
                                
                                binding.title.text = "Hello"
                                binding.button.setOnClickListener { }
                            }
                        }
                        
                        // View Binding的优势：
                        // 1. 类型安全，编译时检查
                        // 2. 空安全，自动处理空值
                        // 3. 性能更好，编译时生成代码
                        // 4. 代码更简洁
                    """.trimIndent(),
                    explanation = "View Binding相比findViewById具有类型安全、空安全、性能更好等优势。编译时生成绑定类，避免运行时错误。"
                ),
                CodeExample(
                    title = "示例3：View Binding与include标签",
                    code = """
                        // 主布局：activity_main.xml
                        // <LinearLayout>
                        //     <include
                        //         android:id="@+id/header"
                        //         layout="@layout/layout_header" />
                        //     <TextView android:id="@+id/content" />
                        // </LinearLayout>
                        
                        // 子布局：layout_header.xml
                        // <LinearLayout>
                        //     <TextView android:id="@+id/headerTitle" />
                        //     <Button android:id="@+id/headerButton" />
                        // </LinearLayout>
                        
                        // 在Activity中使用
                        class MainActivity : AppCompatActivity() {
                            private lateinit var binding: ActivityMainBinding
                            
                            override fun onCreate(savedInstanceState: Bundle?) {
                                super.onCreate(savedInstanceState)
                                
                                binding = ActivityMainBinding.inflate(layoutInflater)
                                setContentView(binding.root)
                                
                                // 访问主布局的视图
                                binding.content.text = "Content"
                                
                                // 访问include布局的视图
                                binding.header.headerTitle.text = "Header"
                                binding.header.headerButton.setOnClickListener { }
                            }
                        }
                    """.trimIndent(),
                    explanation = "View Binding支持include标签，可以通过binding.includeId访问include布局中的视图。每个include布局都会生成对应的绑定类。"
                ),
                CodeExample(
                    title = "示例4：View Binding与Data Binding对比",
                    code = """
                        // View Binding特点：
                        // 1. 只提供视图绑定，不提供数据绑定
                        // 2. 更轻量，性能更好
                        // 3. 类型安全，编译时检查
                        // 4. 适合不需要数据绑定的场景
                        
                        // Data Binding特点：
                        // 1. 提供视图绑定和数据绑定
                        // 2. 支持表达式和双向绑定
                        // 3. 功能更强大，但更重
                        // 4. 适合需要数据绑定的场景
                        
                        // 选择建议：
                        // - 只需要视图绑定：使用View Binding
                        // - 需要数据绑定：使用Data Binding
                        // - 使用Compose：不需要View Binding或Data Binding
                        
                        // View Binding示例
                        class MainActivity : AppCompatActivity() {
                            private lateinit var binding: ActivityMainBinding
                            
                            override fun onCreate(savedInstanceState: Bundle?) {
                                super.onCreate(savedInstanceState)
                                binding = ActivityMainBinding.inflate(layoutInflater)
                                setContentView(binding.root)
                                
                                // 手动设置数据
                                binding.title.text = viewModel.title.value
                            }
                        }
                        
                        // Data Binding示例
                        class MainActivity : AppCompatActivity() {
                            private lateinit var binding: ActivityMainBinding
                            
                            override fun onCreate(savedInstanceState: Bundle?) {
                                super.onCreate(savedInstanceState)
                                binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
                                binding.viewModel = viewModel
                                binding.lifecycleOwner = this
                                // 自动绑定数据
                            }
                        }
                    """.trimIndent(),
                    explanation = "View Binding只提供视图绑定，Data Binding提供视图绑定和数据绑定。根据需求选择：只需要视图绑定使用View Binding，需要数据绑定使用Data Binding。"
                )
            ),
            useCases = listOf(
                "替代findViewById：使用View Binding替代findViewById",
                "类型安全：提供类型安全的视图访问",
                "简化代码：减少样板代码，简化视图访问",
                "性能优化：编译时生成代码，性能更好",
                "空安全：自动处理空值，避免NullPointerException"
            ),
            notes = listOf(
                "View Binding需要在build.gradle中启用（Android Studio 3.6+默认启用）",
                "编译时自动生成绑定类，类名基于布局文件名",
                "在Fragment中使用时，需要在onDestroyView中置空binding",
                "支持include标签，可以通过binding.includeId访问",
                "只提供视图绑定，不提供数据绑定",
                "比findViewById性能更好，类型安全",
                "使用Compose的项目不需要View Binding"
            ),
            practiceTips = "建议使用View Binding替代findViewById，它提供类型安全和更好的性能。在Fragment中使用时，注意在onDestroyView中置空binding避免内存泄漏。如果只需要视图绑定，使用View Binding；如果需要数据绑定，使用Data Binding。对于Compose项目，不需要View Binding。"
        ),
        
        KnowledgeDetail(
            id = "lifecycle",
            title = "生命周期感知组件",
            overview = "Lifecycle是Android架构组件的核心，用于管理组件的生命周期。理解Lifecycle的使用可以实现生命周期感知的组件，在合适的时机执行操作。",
            keyPoints = listOf(
                "LifecycleOwner：提供生命周期的组件，如Activity、Fragment",
                "LifecycleObserver：观察生命周期的观察者",
                "生命周期状态：CREATED、STARTED、RESUMED、DESTROYED等状态",
                "生命周期事件：ON_CREATE、ON_START、ON_RESUME等事件",
                "自定义LifecycleOwner：创建自定义的LifecycleOwner",
                "生命周期感知：在合适的生命周期阶段执行操作"
            ),
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：LifecycleObserver基础使用",
                    code = """
                        // 实现LifecycleObserver
                        class MyLifecycleObserver : LifecycleObserver {
                            
                            @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
                            fun onCreate() {
                                Log.d("Lifecycle", "onCreate")
                            }
                            
                            @OnLifecycleEvent(Lifecycle.Event.ON_START)
                            fun onStart() {
                                Log.d("Lifecycle", "onStart")
                            }
                            
                            @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
                            fun onResume() {
                                Log.d("Lifecycle", "onResume")
                            }
                            
                            @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
                            fun onPause() {
                                Log.d("Lifecycle", "onPause")
                            }
                            
                            @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
                            fun onStop() {
                                Log.d("Lifecycle", "onStop")
                            }
                            
                            @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
                            fun onDestroy() {
                                Log.d("Lifecycle", "onDestroy")
                            }
                        }
                        
                        // 在Activity中使用
                        class MainActivity : AppCompatActivity() {
                            private val observer = MyLifecycleObserver()
                            
                            override fun onCreate(savedInstanceState: Bundle?) {
                                super.onCreate(savedInstanceState)
                                setContentView(R.layout.activity_main)
                                
                                // 添加观察者
                                lifecycle.addObserver(observer)
                            }
                        }
                        
                        // 在Fragment中使用
                        class MyFragment : Fragment() {
                            private val observer = MyLifecycleObserver()
                            
                            override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
                                super.onViewCreated(view, savedInstanceState)
                                
                                // 使用viewLifecycleOwner（推荐）
                                viewLifecycleOwner.lifecycle.addObserver(observer)
                            }
                        }
                    """.trimIndent(),
                    explanation = "LifecycleObserver用于观察生命周期。使用@OnLifecycleEvent注解标记生命周期方法。在Activity中使用lifecycle，在Fragment中使用viewLifecycleOwner。"
                ),
                CodeExample(
                    title = "示例2：生命周期状态和事件",
                    code = """
                        class LifecycleStateObserver : LifecycleObserver {
                            
                            @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
                            fun onLifecycleChanged(
                                source: LifecycleOwner,
                                event: Lifecycle.Event
                            ) {
                                when (event) {
                                    Lifecycle.Event.ON_CREATE -> {
                                        Log.d("Lifecycle", "State: ${'$'}{source.lifecycle.currentState}")
                                    }
                                    Lifecycle.Event.ON_START -> {
                                        Log.d("Lifecycle", "State: ${'$'}{source.lifecycle.currentState}")
                                    }
                                    Lifecycle.Event.ON_RESUME -> {
                                        Log.d("Lifecycle", "State: ${'$'}{source.lifecycle.currentState}")
                                    }
                                    Lifecycle.Event.ON_PAUSE -> {
                                        Log.d("Lifecycle", "State: ${'$'}{source.lifecycle.currentState}")
                                    }
                                    Lifecycle.Event.ON_STOP -> {
                                        Log.d("Lifecycle", "State: ${'$'}{source.lifecycle.currentState}")
                                    }
                                    Lifecycle.Event.ON_DESTROY -> {
                                        Log.d("Lifecycle", "State: ${'$'}{source.lifecycle.currentState}")
                                    }
                                    Lifecycle.Event.ON_ANY -> {
                                        // 任何事件
                                    }
                                }
                            }
                            
                            // 生命周期状态：
                            // INITIALIZED -> CREATED -> STARTED -> RESUMED
                            // RESUMED -> STARTED -> CREATED -> DESTROYED
                            
                            // 检查当前状态
                            fun checkState(lifecycle: Lifecycle) {
                                if (lifecycle.currentState.isAtLeast(Lifecycle.State.STARTED)) {
                                    // 组件已启动
                                }
                                
                                if (lifecycle.currentState == Lifecycle.State.RESUMED) {
                                    // 组件已恢复
                                }
                            }
                        }
                    """.trimIndent(),
                    explanation = "生命周期状态包括INITIALIZED、CREATED、STARTED、RESUMED、DESTROYED。生命周期事件包括ON_CREATE、ON_START、ON_RESUME等。可以使用currentState检查当前状态。"
                ),
                CodeExample(
                    title = "示例3：自定义LifecycleOwner",
                    code = """
                        class MyLifecycleOwner : LifecycleOwner {
                            private val lifecycleRegistry = LifecycleRegistry(this)
                            
                            init {
                                lifecycleRegistry.currentState = Lifecycle.State.INITIALIZED
                            }
                            
                            override fun getLifecycle(): Lifecycle {
                                return lifecycleRegistry
                            }
                            
                            fun start() {
                                lifecycleRegistry.currentState = Lifecycle.State.STARTED
                            }
                            
                            fun resume() {
                                lifecycleRegistry.currentState = Lifecycle.State.RESUMED
                            }
                            
                            fun pause() {
                                lifecycleRegistry.currentState = Lifecycle.State.STARTED
                            }
                            
                            fun stop() {
                                lifecycleRegistry.currentState = Lifecycle.State.CREATED
                            }
                            
                            fun destroy() {
                                lifecycleRegistry.currentState = Lifecycle.State.DESTROYED
                            }
                        }
                        
                        // 使用自定义LifecycleOwner
                        class MyComponent {
                            private val lifecycleOwner = MyLifecycleOwner()
                            private val observer = MyLifecycleObserver()
                            
                            init {
                                lifecycleOwner.lifecycle.addObserver(observer)
                            }
                            
                            fun start() {
                                lifecycleOwner.start()
                            }
                            
                            fun stop() {
                                lifecycleOwner.stop()
                            }
                        }
                    """.trimIndent(),
                    explanation = "可以创建自定义LifecycleOwner，使用LifecycleRegistry管理生命周期状态。适合需要在非Activity/Fragment组件中管理生命周期的场景。"
                ),
                CodeExample(
                    title = "示例4：生命周期感知的实际应用",
                    code = """
                        // 生命周期感知的定位管理器
                        class LocationManager(
                            private val lifecycle: Lifecycle,
                            private val context: Context
                        ) : LifecycleObserver {
                            
                            private var locationCallback: LocationCallback? = null
                            
                            init {
                                lifecycle.addObserver(this)
                            }
                            
                            @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
                            fun startLocationUpdates() {
                                // 组件恢复时开始定位
                                locationCallback = object : LocationCallback() {
                                    override fun onLocationResult(result: LocationResult) {
                                        // 处理位置更新
                                    }
                                }
                                // 开始定位
                            }
                            
                            @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
                            fun stopLocationUpdates() {
                                // 组件暂停时停止定位
                                locationCallback?.let {
                                    // 停止定位
                                    locationCallback = null
                                }
                            }
                            
                            @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
                            fun cleanup() {
                                // 组件销毁时清理资源
                                lifecycle.removeObserver(this)
                            }
                        }
                        
                        // 在Activity中使用
                        class MainActivity : AppCompatActivity() {
                            private lateinit var locationManager: LocationManager
                            
                            override fun onCreate(savedInstanceState: Bundle?) {
                                super.onCreate(savedInstanceState)
                                
                                locationManager = LocationManager(lifecycle, this)
                                // 自动在ON_RESUME时开始定位，ON_PAUSE时停止
                            }
                        }
                    """.trimIndent(),
                    explanation = "生命周期感知组件可以在合适的生命周期阶段自动执行操作。例如定位管理器在组件恢复时开始定位，暂停时停止定位，避免资源浪费。"
                )
            ),
            useCases = listOf(
                "资源管理：在合适的生命周期阶段管理资源（如定位、传感器）",
                "自动操作：根据生命周期自动执行操作，无需手动调用",
                "内存优化：在组件销毁时自动清理资源，避免内存泄漏",
                "状态管理：根据生命周期状态管理组件状态",
                "自定义组件：创建生命周期感知的自定义组件"
            ),
            notes = listOf(
                "LifecycleOwner提供生命周期，LifecycleObserver观察生命周期",
                "使用@OnLifecycleEvent注解标记生命周期方法",
                "生命周期状态包括INITIALIZED、CREATED、STARTED、RESUMED、DESTROYED",
                "在Fragment中使用viewLifecycleOwner，它的生命周期与Fragment视图绑定",
                "可以创建自定义LifecycleOwner管理非Activity/Fragment组件的生命周期",
                "生命周期感知组件可以自动管理资源，避免内存泄漏",
                "ViewModel、LiveData等都是生命周期感知的组件"
            ),
            practiceTips = "建议使用生命周期感知组件管理资源，在合适的生命周期阶段自动执行操作。在Fragment中使用viewLifecycleOwner，它的生命周期与Fragment视图绑定。创建生命周期感知的自定义组件，自动管理资源。注意生命周期状态和事件的区别，状态是持续的状态，事件是瞬间的事件。"
        ),
        
        // ========== 权限管理 ==========
        
        KnowledgeDetail(
            id = "permission_system",
            title = "权限系统（普通权限、危险权限）",
            overview = "Android权限系统用于保护用户隐私和设备安全。理解权限的类型和申请机制是Android开发的基础。Android 6.0+引入了运行时权限，需要动态申请危险权限。",
            keyPoints = listOf(
                "普通权限：系统自动授予，无需用户确认，如INTERNET、ACCESS_NETWORK_STATE",
                "危险权限：需要用户确认，如CAMERA、READ_EXTERNAL_STORAGE、ACCESS_FINE_LOCATION",
                "权限组：危险权限按组分类，申请组内任一权限，组内其他权限自动授予",
                "权限声明：在AndroidManifest.xml中声明权限",
                "运行时权限：Android 6.0+需要运行时申请危险权限",
                "权限状态：检查权限是否已授予，处理权限被拒绝的情况"
            ),
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：权限类型和声明",
                    code = """
                        // AndroidManifest.xml
                        <manifest>
                            <!-- 普通权限：系统自动授予 -->
                            <uses-permission android:name="android.permission.INTERNET" />
                            <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
                            <uses-permission android:name="android.permission.ACCESS_WIFI_STATE" />
                            
                            <!-- 危险权限：需要运行时申请 -->
                            <uses-permission android:name="android.permission.CAMERA" />
                            <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />
                            <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
                            <uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
                            <uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION" />
                            <uses-permission android:name="android.permission.RECORD_AUDIO" />
                            <uses-permission android:name="android.permission.READ_CONTACTS" />
                            <uses-permission android:name="android.permission.READ_PHONE_STATE" />
                            
                            <!-- Android 13+ 细粒度媒体权限 -->
                            <uses-permission android:name="android.permission.READ_MEDIA_IMAGES" />
                            <uses-permission android:name="android.permission.READ_MEDIA_VIDEO" />
                            <uses-permission android:name="android.permission.READ_MEDIA_AUDIO" />
                        </manifest>
                        
                        // 权限组说明：
                        // - CALENDAR: READ_CALENDAR, WRITE_CALENDAR
                        // - CAMERA: CAMERA
                        // - CONTACTS: READ_CONTACTS, WRITE_CONTACTS, GET_ACCOUNTS
                        // - LOCATION: ACCESS_FINE_LOCATION, ACCESS_COARSE_LOCATION
                        // - MICROPHONE: RECORD_AUDIO
                        // - PHONE: READ_PHONE_STATE, CALL_PHONE, etc.
                        // - SENSORS: BODY_SENSORS (Android 6.0+)
                        // - SMS: SEND_SMS, RECEIVE_SMS, etc.
                        // - STORAGE: READ_EXTERNAL_STORAGE, WRITE_EXTERNAL_STORAGE (Android 12及以下)
                    """.trimIndent(),
                    explanation = "普通权限系统自动授予，危险权限需要运行时申请。权限在AndroidManifest.xml中声明，危险权限按组分类，申请组内任一权限，组内其他权限自动授予。"
                ),
                CodeExample(
                    title = "示例2：检查权限状态",
                    code = """
                        class PermissionChecker(private val context: Context) {
                            
                            // 检查单个权限
                            fun isPermissionGranted(permission: String): Boolean {
                                return ContextCompat.checkSelfPermission(
                                    context,
                                    permission
                                ) == PackageManager.PERMISSION_GRANTED
                            }
                            
                            // 检查多个权限
                            fun checkPermissions(permissions: Array<String>): Map<String, Boolean> {
                                return permissions.associateWith { permission ->
                                    isPermissionGranted(permission)
                                }
                            }
                            
                            // 检查权限组
                            fun checkPermissionGroup(permissions: Array<String>): Boolean {
                                return permissions.all { isPermissionGranted(it) }
                            }
                            
                            // 检查是否应该显示权限说明
                            fun shouldShowRequestPermissionRationale(
                                activity: Activity,
                                permission: String
                            ): Boolean {
                                return ActivityCompat.shouldShowRequestPermissionRationale(
                                    activity,
                                    permission
                                )
                            }
                        }
                        
                        // 使用示例
                        class MainActivity : AppCompatActivity() {
                            private val permissionChecker = PermissionChecker(this)
                            
                            fun checkCameraPermission() {
                                val hasPermission = permissionChecker.isPermissionGranted(
                                    Manifest.permission.CAMERA
                                )
                                
                                if (hasPermission) {
                                    // 权限已授予，可以使用相机
                                    openCamera()
                                } else {
                                    // 权限未授予，需要申请
                                    requestCameraPermission()
                                }
                            }
                        }
                    """.trimIndent(),
                    explanation = "使用ContextCompat.checkSelfPermission检查权限是否已授予。使用shouldShowRequestPermissionRationale检查是否应该显示权限说明（用户之前拒绝过）。"
                ),
                CodeExample(
                    title = "示例3：权限组和自动授予",
                    code = """
                        // 权限组说明
                        // 当用户授予组内任一权限时，组内其他权限也会自动授予
                        
                        class PermissionGroupExample {
                            
                            // 位置权限组
                            val locationPermissions = arrayOf(
                                Manifest.permission.ACCESS_FINE_LOCATION,
                                Manifest.permission.ACCESS_COARSE_LOCATION
                            )
                            
                            // 存储权限组（Android 12及以下）
                            val storagePermissions = arrayOf(
                                Manifest.permission.READ_EXTERNAL_STORAGE,
                                Manifest.permission.WRITE_EXTERNAL_STORAGE
                            )
                            
                            // 相机权限组（只有一个权限）
                            val cameraPermission = arrayOf(
                                Manifest.permission.CAMERA
                            )
                            
                            // 申请位置权限
                            fun requestLocationPermission(activity: Activity) {
                                // 只需要申请组内任一权限
                                ActivityCompat.requestPermissions(
                                    activity,
                                    arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                                    REQUEST_CODE_LOCATION
                                )
                                // 如果用户授予ACCESS_FINE_LOCATION，
                                // ACCESS_COARSE_LOCATION也会自动授予
                            }
                        }
                        
                        // 注意：Android 13+ 存储权限变化
                        // - READ_EXTERNAL_STORAGE 被细粒度权限替代
                        // - READ_MEDIA_IMAGES, READ_MEDIA_VIDEO, READ_MEDIA_AUDIO
                    """.trimIndent(),
                    explanation = "危险权限按组分类，申请组内任一权限，组内其他权限会自动授予。Android 13+对存储权限进行了细分，使用细粒度媒体权限。"
                )
            ),
            useCases = listOf(
                "功能访问：申请权限访问设备功能（相机、位置、存储等）",
                "隐私保护：保护用户隐私，只在需要时申请权限",
                "权限检查：检查权限状态，根据状态执行相应操作",
                "用户体验：合理申请权限，提供权限说明，提升用户体验",
                "兼容性：处理不同Android版本的权限差异"
            ),
            notes = listOf(
                "普通权限系统自动授予，无需用户确认",
                "危险权限需要运行时申请，用户可以选择授予或拒绝",
                "权限按组分类，申请组内任一权限，组内其他权限自动授予",
                "Android 6.0+需要运行时申请危险权限",
                "Android 13+对存储权限进行了细分，使用细粒度媒体权限",
                "权限在AndroidManifest.xml中声明，但声明不等于授予",
                "使用shouldShowRequestPermissionRationale检查是否应该显示权限说明"
            ),
            practiceTips = "建议只在需要时申请权限，不要一次性申请所有权限。提供权限说明，解释为什么需要权限。检查权限状态，根据状态执行相应操作。处理权限被拒绝的情况，提供替代方案。注意不同Android版本的权限差异，特别是Android 13+的存储权限变化。"
        ),
        
        KnowledgeDetail(
            id = "permission_request",
            title = "权限请求（运行时权限）",
            overview = "运行时权限是Android 6.0+引入的权限机制，需要在运行时动态申请危险权限。理解权限请求的流程和最佳实践是Android开发的重要技能。",
            keyPoints = listOf(
                "权限请求流程：检查权限 -> 申请权限 -> 处理结果",
                "Activity权限请求：在Activity中使用requestPermissions申请权限",
                "Fragment权限请求：在Fragment中使用requestPermissions申请权限",
                "权限结果处理：在onRequestPermissionsResult中处理权限结果",
                "权限说明：使用shouldShowRequestPermissionRationale显示权限说明",
                "权限库：使用权限请求库简化权限处理"
            ),
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：Activity权限请求",
                    code = """
                        class MainActivity : AppCompatActivity() {
                            
                            companion object {
                                private const val REQUEST_CODE_CAMERA = 1001
                                private const val REQUEST_CODE_LOCATION = 1002
                            }
                            
                            override fun onCreate(savedInstanceState: Bundle?) {
                                super.onCreate(savedInstanceState)
                                setContentView(R.layout.activity_main)
                                
                                // 检查并申请相机权限
                                checkAndRequestCameraPermission()
                            }
                            
                            private fun checkAndRequestCameraPermission() {
                                when {
                                    ContextCompat.checkSelfPermission(
                                        this,
                                        Manifest.permission.CAMERA
                                    ) == PackageManager.PERMISSION_GRANTED -> {
                                        // 权限已授予
                                        openCamera()
                                    }
                                    
                                    ActivityCompat.shouldShowRequestPermissionRationale(
                                        this,
                                        Manifest.permission.CAMERA
                                    ) -> {
                                        // 用户之前拒绝过，显示说明
                                        showPermissionRationale(
                                            "需要相机权限来拍照",
                                            { requestCameraPermission() }
                                        )
                                    }
                                    
                                    else -> {
                                        // 首次申请或用户选择了"不再询问"
                                        requestCameraPermission()
                                    }
                                }
                            }
                            
                            private fun requestCameraPermission() {
                                ActivityCompat.requestPermissions(
                                    this,
                                    arrayOf(Manifest.permission.CAMERA),
                                    REQUEST_CODE_CAMERA
                                )
                            }
                            
                            override fun onRequestPermissionsResult(
                                requestCode: Int,
                                permissions: Array<out String>,
                                grantResults: IntArray
                            ) {
                                super.onRequestPermissionsResult(requestCode, permissions, grantResults)
                                
                                when (requestCode) {
                                    REQUEST_CODE_CAMERA -> {
                                        if (grantResults.isNotEmpty() &&
                                            grantResults[0] == PackageManager.PERMISSION_GRANTED
                                        ) {
                                            // 权限已授予
                                            openCamera()
                                        } else {
                                            // 权限被拒绝
                                            handlePermissionDenied()
                                        }
                                    }
                                }
                            }
                            
                            private fun openCamera() {
                                // 打开相机
                            }
                            
                            private fun handlePermissionDenied() {
                                // 处理权限被拒绝的情况
                                Toast.makeText(
                                    this,
                                    "需要相机权限才能使用此功能",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                            
                            private fun showPermissionRationale(
                                message: String,
                                onConfirm: () -> Unit
                            ) {
                                AlertDialog.Builder(this)
                                    .setTitle("需要权限")
                                    .setMessage(message)
                                    .setPositiveButton("确定") { _, _ -> onConfirm() }
                                    .setNegativeButton("取消", null)
                                    .show()
                            }
                        }
                    """.trimIndent(),
                    explanation = "在Activity中申请权限的流程：检查权限状态 -> 显示权限说明（如果需要） -> 申请权限 -> 在onRequestPermissionsResult中处理结果。"
                ),
                CodeExample(
                    title = "示例2：Fragment权限请求",
                    code = """
                        class MyFragment : Fragment() {
                            
                            companion object {
                                private const val REQUEST_CODE_STORAGE = 1001
                            }
                            
                            override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
                                super.onViewCreated(view, savedInstanceState)
                                
                                button.setOnClickListener {
                                    checkAndRequestStoragePermission()
                                }
                            }
                            
                            private fun checkAndRequestStoragePermission() {
                                val permissions = arrayOf(
                                    Manifest.permission.READ_EXTERNAL_STORAGE,
                                    Manifest.permission.WRITE_EXTERNAL_STORAGE
                                )
                                
                                when {
                                    permissions.all { permission ->
                                        ContextCompat.checkSelfPermission(
                                            requireContext(),
                                            permission
                                        ) == PackageManager.PERMISSION_GRANTED
                                    } -> {
                                        // 权限已授予
                                        openFilePicker()
                                    }
                                    
                                    permissions.any { permission ->
                                        ActivityCompat.shouldShowRequestPermissionRationale(
                                            requireActivity(),
                                            permission
                                        )
                                    } -> {
                                        // 显示权限说明
                                        showPermissionRationale()
                                    }
                                    
                                    else -> {
                                        // 申请权限
                                        requestPermissions(
                                            permissions,
                                            REQUEST_CODE_STORAGE
                                        )
                                    }
                                }
                            }
                            
                            override fun onRequestPermissionsResult(
                                requestCode: Int,
                                permissions: Array<out String>,
                                grantResults: IntArray
                            ) {
                                super.onRequestPermissionsResult(
                                    requestCode,
                                    permissions,
                                    grantResults
                                )
                                
                                if (requestCode == REQUEST_CODE_STORAGE) {
                                    if (grantResults.all { it == PackageManager.PERMISSION_GRANTED }) {
                                        // 所有权限已授予
                                        openFilePicker()
                                    } else {
                                        // 权限被拒绝
                                        handlePermissionDenied()
                                    }
                                }
                            }
                            
                            private fun showPermissionRationale() {
                                AlertDialog.Builder(requireContext())
                                    .setTitle("需要存储权限")
                                    .setMessage("需要存储权限来访问文件")
                                    .setPositiveButton("确定") { _, _ ->
                                        requestPermissions(
                                            arrayOf(
                                                Manifest.permission.READ_EXTERNAL_STORAGE,
                                                Manifest.permission.WRITE_EXTERNAL_STORAGE
                                            ),
                                            REQUEST_CODE_STORAGE
                                        )
                                    }
                                    .setNegativeButton("取消", null)
                                    .show()
                            }
                            
                            private fun openFilePicker() {
                                // 打开文件选择器
                            }
                            
                            private fun handlePermissionDenied() {
                                // 处理权限被拒绝
                            }
                        }
                    """.trimIndent(),
                    explanation = "在Fragment中申请权限使用requestPermissions方法，在onRequestPermissionsResult中处理结果。注意使用requireContext()和requireActivity()获取Context和Activity。"
                ),
                CodeExample(
                    title = "示例3：使用权限请求库（简化处理）",
                    code = """
                        // 使用第三方库简化权限处理
                        // 例如：PermissionsDispatcher、EasyPermissions、RxPermissions等
                        
                        // 使用ActivityResultContracts（AndroidX Activity 1.2.0+）
                        class MainActivity : AppCompatActivity() {
                            
                            private val requestPermissionLauncher = registerForActivityResult(
                                ActivityResultContracts.RequestPermission()
                            ) { isGranted ->
                                if (isGranted) {
                                    // 权限已授予
                                    openCamera()
                                } else {
                                    // 权限被拒绝
                                    handlePermissionDenied()
                                }
                            }
                            
                            private val requestMultiplePermissionsLauncher = registerForActivityResult(
                                ActivityResultContracts.RequestMultiplePermissions()
                            ) { permissions ->
                                val allGranted = permissions.all { it.value }
                                if (allGranted) {
                                    // 所有权限已授予
                                    openFilePicker()
                                } else {
                                    // 部分或全部权限被拒绝
                                    handlePermissionDenied()
                                }
                            }
                            
                            fun requestCameraPermission() {
                                requestPermissionLauncher.launch(Manifest.permission.CAMERA)
                            }
                            
                            fun requestStoragePermissions() {
                                requestMultiplePermissionsLauncher.launch(
                                    arrayOf(
                                        Manifest.permission.READ_EXTERNAL_STORAGE,
                                        Manifest.permission.WRITE_EXTERNAL_STORAGE
                                    )
                                )
                            }
                        }
                        
                        // 使用ActivityResultContracts的优势：
                        // 1. 更简洁的API
                        // 2. 类型安全
                        // 3. 不需要重写onRequestPermissionsResult
                        // 4. 支持协程
                    """.trimIndent(),
                    explanation = "使用ActivityResultContracts可以简化权限请求处理，不需要重写onRequestPermissionsResult。这是Android推荐的现代方式。"
                ),
                CodeExample(
                    title = "示例4：权限请求最佳实践",
                    code = """
                        class PermissionHelper(private val activity: Activity) {
                            
                            // 统一的权限请求方法
                            suspend fun requestPermission(
                                permission: String,
                                rationale: String? = null
                            ): Boolean {
                                return suspendCoroutine { continuation ->
                                    // 检查权限
                                    if (ContextCompat.checkSelfPermission(
                                            activity,
                                            permission
                                        ) == PackageManager.PERMISSION_GRANTED
                                    ) {
                                        continuation.resume(true)
                                        return@suspendCoroutine
                                    }
                                    
                                    // 显示权限说明
                                    if (rationale != null &&
                                        ActivityCompat.shouldShowRequestPermissionRationale(
                                            activity,
                                            permission
                                        )
                                    ) {
                                        AlertDialog.Builder(activity)
                                            .setTitle("需要权限")
                                            .setMessage(rationale)
                                            .setPositiveButton("确定") { _, _ ->
                                                requestPermissionInternal(permission, continuation)
                                            }
                                            .setNegativeButton("取消") { _, _ ->
                                                continuation.resume(false)
                                            }
                                            .setCancelable(false)
                                            .show()
                                    } else {
                                        requestPermissionInternal(permission, continuation)
                                    }
                                }
                            }
                            
                            private fun requestPermissionInternal(
                                permission: String,
                                continuation: Continuation<Boolean>
                            ) {
                                val launcher = activity.registerForActivityResult(
                                    ActivityResultContracts.RequestPermission()
                                ) { isGranted ->
                                    continuation.resume(isGranted)
                                }
                                launcher.launch(permission)
                            }
                        }
                        
                        // 在ViewModel中使用
                        class MyViewModel : ViewModel() {
                            suspend fun requestCameraPermission(
                                permissionHelper: PermissionHelper
                            ): Boolean {
                                return permissionHelper.requestPermission(
                                    Manifest.permission.CAMERA,
                                    "需要相机权限来拍照"
                                )
                            }
                        }
                    """.trimIndent(),
                    explanation = "权限请求的最佳实践包括：检查权限状态、显示权限说明、统一处理权限请求、使用协程简化异步处理。"
                )
            ),
            useCases = listOf(
                "功能访问：申请权限访问设备功能",
                "用户体验：提供权限说明，提升用户体验",
                "错误处理：处理权限被拒绝的情况",
                "权限管理：统一管理权限请求逻辑",
                "现代化：使用ActivityResultContracts简化权限处理"
            ),
            notes = listOf(
                "使用ActivityCompat.requestPermissions申请权限",
                "在onRequestPermissionsResult中处理权限结果",
                "使用shouldShowRequestPermissionRationale检查是否应该显示权限说明",
                "ActivityResultContracts是Android推荐的现代方式",
                "权限请求是异步的，需要处理回调",
                "用户可以选择\"不再询问\"，需要引导用户到设置页面",
                "Fragment中使用requestPermissions，注意使用requireContext()"
            ),
            practiceTips = "建议使用ActivityResultContracts简化权限请求，这是Android推荐的现代方式。提供权限说明，解释为什么需要权限。处理权限被拒绝的情况，提供替代方案或引导用户到设置页面。统一管理权限请求逻辑，避免代码重复。使用协程简化异步权限请求处理。"
        ),
        
        KnowledgeDetail(
            id = "common_permissions",
            title = "常见权限（存储、相机、位置等）",
            overview = "Android应用常用的权限包括存储、相机、位置、联系人等。理解这些权限的特点和使用场景，可以正确申请和使用权限。",
            keyPoints = listOf(
                "存储权限：访问设备存储，Android 13+使用细粒度媒体权限",
                "相机权限：访问设备相机，用于拍照和录像",
                "位置权限：访问设备位置，包括精确位置和粗略位置",
                "联系人权限：访问设备联系人",
                "电话权限：访问电话功能，如拨打电话、读取电话状态",
                "权限版本差异：不同Android版本的权限要求不同"
            ),
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：存储权限（Android版本差异）",
                    code = """
                        class StoragePermissionHelper(private val activity: Activity) {
                            
                            // Android 13+ (API 33+)
                            private val android13StoragePermissions = arrayOf(
                                Manifest.permission.READ_MEDIA_IMAGES,
                                Manifest.permission.READ_MEDIA_VIDEO,
                                Manifest.permission.READ_MEDIA_AUDIO
                            )
                            
                            // Android 12及以下
                            private val legacyStoragePermissions = arrayOf(
                                Manifest.permission.READ_EXTERNAL_STORAGE,
                                Manifest.permission.WRITE_EXTERNAL_STORAGE
                            )
                            
                            fun getStoragePermissions(): Array<String> {
                                return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                                    // Android 13+
                                    android13StoragePermissions
                                } else {
                                    // Android 12及以下
                                    legacyStoragePermissions
                                }
                            }
                            
                            fun requestStoragePermission() {
                                val permissions = getStoragePermissions()
                                
                                if (permissions.all { permission ->
                                    ContextCompat.checkSelfPermission(
                                        activity,
                                        permission
                                    ) == PackageManager.PERMISSION_GRANTED
                                }) {
                                    // 权限已授予
                                    openFilePicker()
                                } else {
                                    // 申请权限
                                    ActivityCompat.requestPermissions(
                                        activity,
                                        permissions,
                                        REQUEST_CODE_STORAGE
                                    )
                                }
                            }
                        }
                        
                        // AndroidManifest.xml
                        // <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE"
                        //     android:maxSdkVersion="32" />
                        // <uses-permission android:name="android.permission.READ_MEDIA_IMAGES" />
                        // <uses-permission android:name="android.permission.READ_MEDIA_VIDEO" />
                        // <uses-permission android:name="android.permission.READ_MEDIA_AUDIO" />
                    """.trimIndent(),
                    explanation = "Android 13+对存储权限进行了细分，使用READ_MEDIA_IMAGES、READ_MEDIA_VIDEO、READ_MEDIA_AUDIO替代READ_EXTERNAL_STORAGE。需要根据Android版本申请不同的权限。"
                ),
                CodeExample(
                    title = "示例2：相机权限",
                    code = """
                        class CameraPermissionHelper(private val activity: Activity) {
                            
                            fun checkCameraPermission(): Boolean {
                                return ContextCompat.checkSelfPermission(
                                    activity,
                                    Manifest.permission.CAMERA
                                ) == PackageManager.PERMISSION_GRANTED
                            }
                            
                            fun requestCameraPermission() {
                                if (checkCameraPermission()) {
                                    openCamera()
                                } else {
                                    ActivityCompat.requestPermissions(
                                        activity,
                                        arrayOf(Manifest.permission.CAMERA),
                                        REQUEST_CODE_CAMERA
                                    )
                                }
                            }
                            
                            // 使用CameraX（推荐）
                            fun openCameraWithCameraX() {
                                val cameraProviderFuture = ProcessCameraProvider.getInstance(activity)
                                
                                cameraProviderFuture.addListener({
                                    val cameraProvider = cameraProviderFuture.get()
                                    
                                    // 检查权限
                                    if (checkCameraPermission()) {
                                        // 绑定相机用例
                                        bindCameraUseCases(cameraProvider)
                                    } else {
                                        requestCameraPermission()
                                    }
                                }, ContextCompat.getMainExecutor(activity))
                            }
                        }
                        
                        // AndroidManifest.xml
                        // <uses-permission android:name="android.permission.CAMERA" />
                        // <uses-feature android:name="android.hardware.camera" android:required="false" />
                    """.trimIndent(),
                    explanation = "相机权限用于访问设备相机。使用CameraX可以简化相机使用，但同样需要申请相机权限。在AndroidManifest.xml中声明相机权限和特性。"
                ),
                CodeExample(
                    title = "示例3：位置权限",
                    code = """
                        class LocationPermissionHelper(private val activity: Activity) {
                            
                            // 精确位置权限
                            private val fineLocationPermission = Manifest.permission.ACCESS_FINE_LOCATION
                            
                            // 粗略位置权限
                            private val coarseLocationPermission = Manifest.permission.ACCESS_COARSE_LOCATION
                            
                            fun checkLocationPermission(): Boolean {
                                return ContextCompat.checkSelfPermission(
                                    activity,
                                    fineLocationPermission
                                ) == PackageManager.PERMISSION_GRANTED ||
                                ContextCompat.checkSelfPermission(
                                    activity,
                                    coarseLocationPermission
                                ) == PackageManager.PERMISSION_GRANTED
                            }
                            
                            fun requestLocationPermission() {
                                if (checkLocationPermission()) {
                                    startLocationUpdates()
                                } else {
                                    // 优先申请精确位置权限
                                    ActivityCompat.requestPermissions(
                                        activity,
                                        arrayOf(fineLocationPermission),
                                        REQUEST_CODE_LOCATION
                                    )
                                }
                            }
                            
                            // 使用FusedLocationProviderClient
                            fun startLocationUpdates() {
                                val fusedLocationClient = LocationServices.getFusedLocationProviderClient(activity)
                                
                                if (checkLocationPermission()) {
                                    fusedLocationClient.lastLocation.addOnSuccessListener { location ->
                                        // 获取位置
                                        location?.let {
                                            // 处理位置
                                        }
                                    }
                                }
                            }
                        }
                        
                        // AndroidManifest.xml
                        // <uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
                        // <uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION" />
                        // 
                        // 注意：Android 10+需要在前台服务中使用位置权限时声明
                        // <uses-permission android:name="android.permission.ACCESS_BACKGROUND_LOCATION" />
                    """.trimIndent(),
                    explanation = "位置权限包括精确位置（ACCESS_FINE_LOCATION）和粗略位置（ACCESS_COARSE_LOCATION）。申请精确位置权限时，粗略位置权限也会自动授予。Android 10+在后台使用位置需要额外权限。"
                ),
                CodeExample(
                    title = "示例4：联系人权限",
                    code = """
                        class ContactPermissionHelper(private val activity: Activity) {
                            
                            fun checkContactPermission(): Boolean {
                                return ContextCompat.checkSelfPermission(
                                    activity,
                                    Manifest.permission.READ_CONTACTS
                                ) == PackageManager.PERMISSION_GRANTED
                            }
                            
                            fun requestContactPermission() {
                                if (checkContactPermission()) {
                                    readContacts()
                                } else {
                                    ActivityCompat.requestPermissions(
                                        activity,
                                        arrayOf(Manifest.permission.READ_CONTACTS),
                                        REQUEST_CODE_CONTACTS
                                    )
                                }
                            }
                            
                            fun readContacts() {
                                val contacts = mutableListOf<Contact>()
                                
                                val projection = arrayOf(
                                    android.provider.ContactsContract.Contacts._ID,
                                    android.provider.ContactsContract.Contacts.DISPLAY_NAME
                                )
                                
                                activity.contentResolver.query(
                                    android.provider.ContactsContract.Contacts.CONTENT_URI,
                                    projection,
                                    null,
                                    null,
                                    null
                                )?.use { cursor ->
                                    val idColumn = cursor.getColumnIndex(
                                        android.provider.ContactsContract.Contacts._ID
                                    )
                                    val nameColumn = cursor.getColumnIndex(
                                        android.provider.ContactsContract.Contacts.DISPLAY_NAME
                                    )
                                    
                                    while (cursor.moveToNext()) {
                                        val id = cursor.getLong(idColumn)
                                        val name = cursor.getString(nameColumn)
                                        contacts.add(Contact(id, name))
                                    }
                                }
                                
                                return contacts
                            }
                        }
                        
                        // AndroidManifest.xml
                        // <uses-permission android:name="android.permission.READ_CONTACTS" />
                        // <uses-permission android:name="android.permission.WRITE_CONTACTS" />
                    """.trimIndent(),
                    explanation = "联系人权限用于访问设备联系人。READ_CONTACTS用于读取联系人，WRITE_CONTACTS用于写入联系人。使用ContentResolver查询联系人数据。"
                ),
                CodeExample(
                    title = "示例5：电话权限",
                    code = """
                        class PhonePermissionHelper(private val activity: Activity) {
                            
                            fun checkPhonePermission(): Boolean {
                                return ContextCompat.checkSelfPermission(
                                    activity,
                                    Manifest.permission.CALL_PHONE
                                ) == PackageManager.PERMISSION_GRANTED
                            }
                            
                            fun requestPhonePermission() {
                                if (checkPhonePermission()) {
                                    makePhoneCall("1234567890")
                                } else {
                                    ActivityCompat.requestPermissions(
                                        activity,
                                        arrayOf(Manifest.permission.CALL_PHONE),
                                        REQUEST_CODE_PHONE
                                    )
                                }
                            }
                            
                            fun makePhoneCall(phoneNumber: String) {
                                val intent = Intent(Intent.ACTION_CALL).apply {
                                    data = Uri.parse("tel:${'$'}phoneNumber")
                                }
                                activity.startActivity(intent)
                            }
                            
                            // 读取电话状态
                            fun checkPhoneStatePermission(): Boolean {
                                return ContextCompat.checkSelfPermission(
                                    activity,
                                    Manifest.permission.READ_PHONE_STATE
                                ) == PackageManager.PERMISSION_GRANTED
                            }
                            
                            fun getPhoneInfo(): String? {
                                if (checkPhoneStatePermission()) {
                                    val telephonyManager = activity.getSystemService(
                                        Context.TELEPHONY_SERVICE
                                    ) as TelephonyManager
                                    
                                    return telephonyManager.deviceId
                                }
                                return null
                            }
                        }
                        
                        // AndroidManifest.xml
                        // <uses-permission android:name="android.permission.CALL_PHONE" />
                        // <uses-permission android:name="android.permission.READ_PHONE_STATE" />
                    """.trimIndent(),
                    explanation = "电话权限包括CALL_PHONE（拨打电话）和READ_PHONE_STATE（读取电话状态）。CALL_PHONE用于直接拨打电话，READ_PHONE_STATE用于读取设备信息。"
                )
            ),
            useCases = listOf(
                "文件访问：申请存储权限访问设备文件",
                "拍照功能：申请相机权限实现拍照功能",
                "定位服务：申请位置权限实现定位功能",
                "联系人管理：申请联系人权限访问联系人",
                "电话功能：申请电话权限实现拨打电话功能"
            ),
            notes = listOf(
                "Android 13+对存储权限进行了细分，使用细粒度媒体权限",
                "相机权限用于访问设备相机，CameraX也需要相机权限",
                "位置权限包括精确位置和粗略位置，申请精确位置时粗略位置自动授予",
                "联系人权限用于访问设备联系人，使用ContentResolver查询",
                "电话权限包括CALL_PHONE和READ_PHONE_STATE",
                "不同Android版本的权限要求不同，需要处理版本差异",
                "在AndroidManifest.xml中声明权限，但声明不等于授予"
            ),
            practiceTips = "建议根据Android版本申请不同的权限，特别是存储权限。只在需要时申请权限，不要一次性申请所有权限。提供权限说明，解释为什么需要权限。处理权限被拒绝的情况，提供替代方案。注意权限的版本差异，使用Build.VERSION.SDK_INT判断Android版本。"
        ),
        
        // ========== 多媒体开发 ==========
        
        KnowledgeDetail(
            id = "camera",
            title = "相机（Camera2、CameraX）",
            overview = "Android相机开发可以使用Camera2 API或CameraX库。CameraX是Google推荐的现代相机库，简化了相机使用，支持生命周期管理。",
            keyPoints = listOf(
                "Camera2 API：Android 5.0+引入的相机API，功能强大但使用复杂",
                "CameraX：Google推荐的现代相机库，简化相机使用，支持生命周期管理",
                "相机用例：Preview（预览）、ImageCapture（拍照）、ImageAnalysis（图像分析）、VideoCapture（录像）",
                "生命周期绑定：CameraX自动绑定生命周期，无需手动管理",
                "权限要求：需要CAMERA权限和相机特性声明",
                "多相机支持：支持前置和后置相机，多相机设备"
            ),
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：CameraX基础使用",
                    code = """
                        class CameraActivity : AppCompatActivity() {
                            
                            private lateinit var cameraProvider: ProcessCameraProvider
                            private var imageCapture: ImageCapture? = null
                            private var imageAnalyzer: ImageAnalysis? = null
                            
                            override fun onCreate(savedInstanceState: Bundle?) {
                                super.onCreate(savedInstanceState)
                                setContentView(R.layout.activity_camera)
                                
                                // 检查相机权限
                                if (checkCameraPermission()) {
                                    startCamera()
                                } else {
                                    requestCameraPermission()
                                }
                            }
                            
                            private fun startCamera() {
                                val cameraProviderFuture = ProcessCameraProvider.getInstance(this)
                                
                                cameraProviderFuture.addListener({
                                    cameraProvider = cameraProviderFuture.get()
                                
                                    // Preview用例
                                    val preview = Preview.Builder().build().also {
                                        it.setSurfaceProvider(binding.previewView.surfaceProvider)
                                    }
                                
                                    // ImageCapture用例
                                    imageCapture = ImageCapture.Builder()
                                        .setCaptureMode(ImageCapture.CAPTURE_MODE_MINIMIZE_LATENCY)
                                        .build()
                                
                                    // ImageAnalysis用例
                                    imageAnalyzer = ImageAnalysis.Builder()
                                        .setBackpressureStrategy(ImageAnalysis.STRATEGY_KEEP_ONLY_LATEST)
                                        .build()
                                        .also {
                                            it.setAnalyzer(cameraExecutor, LuminosityAnalyzer())
                                        }
                                
                                    // 选择相机（后置相机）
                                    val cameraSelector = CameraSelector.DEFAULT_BACK_CAMERA
                                
                                    try {
                                        // 解绑所有用例
                                        cameraProvider.unbindAll()
                                
                                        // 绑定用例到生命周期
                                        cameraProvider.bindToLifecycle(
                                            this,
                                            cameraSelector,
                                            preview,
                                            imageCapture,
                                            imageAnalyzer
                                        )
                                    } catch (e: Exception) {
                                        Log.e("Camera", "绑定失败", e)
                                    }
                                }, ContextCompat.getMainExecutor(this))
                            }
                            
                            private fun takePhoto() {
                                val imageCapture = imageCapture ?: return
                                
                                val outputFileOptions = ImageCapture.OutputFileOptions.Builder(
                                    File(getExternalFilesDir(Environment.DIRECTORY_PICTURES), "photo.jpg")
                                ).build()
                                
                                imageCapture.takePicture(
                                    outputFileOptions,
                                    ContextCompat.getMainExecutor(this),
                                    object : ImageCapture.OnImageSavedCallback {
                                        override fun onImageSaved(output: ImageCapture.OutputFileResults) {
                                            // 拍照成功
                                            val savedUri = output.savedUri
                                        }
                                
                                        override fun onError(exception: ImageCaptureException) {
                                            // 拍照失败
                                            Log.e("Camera", "拍照失败", exception)
                                        }
                                    }
                                )
                            }
                        }
                    """.trimIndent(),
                    explanation = "CameraX使用ProcessCameraProvider管理相机，支持Preview、ImageCapture、ImageAnalysis等用例。使用bindToLifecycle绑定生命周期，自动管理相机资源。"
                ),
                CodeExample(
                    title = "示例2：Camera2 API使用",
                    code = """
                        class Camera2Activity : AppCompatActivity() {
                            
                            private lateinit var cameraManager: CameraManager
                            private var cameraDevice: CameraDevice? = null
                            private var captureSession: CameraCaptureSession? = null
                            
                            override fun onCreate(savedInstanceState: Bundle?) {
                                super.onCreate(savedInstanceState)
                                setContentView(R.layout.activity_camera)
                                
                                cameraManager = getSystemService(Context.CAMERA_SERVICE) as CameraManager
                                
                                if (checkCameraPermission()) {
                                    openCamera()
                                } else {
                                    requestCameraPermission()
                                }
                            }
                            
                            private fun openCamera() {
                                try {
                                    val cameraId = cameraManager.cameraIdList[0]
                                    val characteristics = cameraManager.getCameraCharacteristics(cameraId)
                                
                                    // 获取相机能力
                                    val map = characteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP)
                                    val largest = Collections.max(
                                        Arrays.asList(*map!!.getOutputSizes(ImageFormat.JPEG)),
                                        CompareSizesByArea()
                                    )
                                
                                    // 打开相机
                                    if (ActivityCompat.checkSelfPermission(
                                            this,
                                            Manifest.permission.CAMERA
                                        ) == PackageManager.PERMISSION_GRANTED
                                    ) {
                                        cameraManager.openCamera(cameraId, stateCallback, backgroundHandler)
                                    }
                                } catch (e: Exception) {
                                    Log.e("Camera2", "打开相机失败", e)
                                }
                            }
                            
                            private val stateCallback = object : CameraDevice.StateCallback() {
                                override fun onOpened(camera: CameraDevice) {
                                    cameraDevice = camera
                                    createCaptureSession()
                                }
                            
                                override fun onDisconnected(camera: CameraDevice) {
                                    camera.close()
                                    cameraDevice = null
                                }
                            
                                override fun onError(camera: CameraDevice, error: Int) {
                                    camera.close()
                                    cameraDevice = null
                                }
                            }
                            
                            private fun createCaptureSession() {
                                // 创建CaptureSession
                                // ...
                            }
                        }
                        
                        // Camera2 API特点：
                        // 1. 功能强大，可以精确控制相机
                        // 2. 使用复杂，需要手动管理生命周期
                        // 3. 适合需要精细控制的场景
                        // 4. 推荐使用CameraX，除非有特殊需求
                    """.trimIndent(),
                    explanation = "Camera2 API提供了强大的相机控制能力，但使用复杂。需要手动管理CameraDevice、CaptureSession等，适合需要精细控制的场景。"
                ),
                CodeExample(
                    title = "示例3：CameraX高级特性",
                    code = """
                        class AdvancedCameraActivity : AppCompatActivity() {
                            
                            private var imageCapture: ImageCapture? = null
                            
                            // 切换相机
                            fun switchCamera() {
                                val currentSelector = cameraSelector
                                val newSelector = if (currentSelector == CameraSelector.DEFAULT_BACK_CAMERA) {
                                    CameraSelector.DEFAULT_FRONT_CAMERA
                                } else {
                                    CameraSelector.DEFAULT_BACK_CAMERA
                                }
                                
                                cameraProvider.unbindAll()
                                bindCameraUseCases(newSelector)
                            }
                            
                            // 缩放控制
                            fun setZoomRatio(ratio: Float) {
                                val cameraControl = camera?.cameraControl
                                cameraControl?.setZoomRatio(ratio)
                            }
                            
                            // 闪光灯控制
                            fun setFlashMode(mode: Int) {
                                imageCapture?.flashMode = mode
                            }
                            
                            // 对焦控制
                            fun focusOnPoint(x: Float, y: Float) {
                                val cameraControl = camera?.cameraControl
                                val meteringPointFactory = SurfaceOrientedMeteringPointFactory(
                                    binding.previewView.width.toFloat(),
                                    binding.previewView.height.toFloat()
                                )
                                val point = meteringPointFactory.createPoint(x, y)
                                val action = FocusMeteringAction.Builder(point).build()
                                cameraControl?.startFocusAndMetering(action)
                            }
                            
                            // 图像分析
                            class FaceAnalyzer : ImageAnalysis.Analyzer {
                                override fun analyze(image: ImageProxy) {
                                    // 分析图像（如人脸检测）
                                    // 注意：处理完成后调用image.close()
                                    image.close()
                                }
                            }
                        }
                    """.trimIndent(),
                    explanation = "CameraX支持切换相机、缩放控制、闪光灯控制、对焦控制等高级特性。ImageAnalysis用于实时分析图像，如人脸检测、二维码识别等。"
                )
            ),
            useCases = listOf(
                "拍照功能：使用ImageCapture实现拍照功能",
                "视频录制：使用VideoCapture实现视频录制",
                "实时预览：使用Preview实现相机预览",
                "图像分析：使用ImageAnalysis实现实时图像分析（如人脸检测、二维码识别）",
                "多相机支持：支持前置和后置相机切换"
            ),
            notes = listOf(
                "CameraX是Google推荐的现代相机库，简化了相机使用",
                "CameraX自动绑定生命周期，无需手动管理相机资源",
                "需要CAMERA权限和相机特性声明",
                "支持Preview、ImageCapture、ImageAnalysis、VideoCapture等用例",
                "Camera2 API功能强大但使用复杂，适合需要精细控制的场景",
                "ImageAnalysis用于实时分析图像，处理完成后需要调用image.close()",
                "支持多相机设备，可以切换前置和后置相机"
            ),
            practiceTips = "建议使用CameraX进行相机开发，它简化了相机使用并自动管理生命周期。使用Preview实现预览，使用ImageCapture实现拍照，使用ImageAnalysis实现图像分析。注意权限处理，需要申请CAMERA权限。对于需要精细控制的场景，可以考虑使用Camera2 API。"
        ),
        
        KnowledgeDetail(
            id = "image_processing",
            title = "图片处理（Glide、Coil、图片压缩）",
            overview = "Android图片处理包括图片加载、缓存、压缩等。Glide和Coil是常用的图片加载库，提供了强大的图片处理功能。",
            keyPoints = listOf(
                "Glide：功能强大的图片加载库，支持多种图片源和转换",
                "Coil：Kotlin友好的图片加载库，专为Kotlin协程设计",
                "图片压缩：压缩图片减少内存占用和文件大小",
                "图片缓存：内存缓存和磁盘缓存，提升加载速度",
                "图片转换：圆角、裁剪、模糊等图片转换效果",
                "占位符和错误处理：显示占位符和处理加载错误"
            ),
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：Glide基础使用",
                    code = """
                        // 在Activity/Fragment中使用Glide
                        class ImageActivity : AppCompatActivity() {
                            
                            override fun onCreate(savedInstanceState: Bundle?) {
                                super.onCreate(savedInstanceState)
                                setContentView(R.layout.activity_image)
                                
                                val imageView = findViewById<ImageView>(R.id.imageView)
                                
                                // 基础加载
                                Glide.with(this)
                                    .load("https://example.com/image.jpg")
                                    .into(imageView)
                                
                                // 带占位符和错误图片
                                Glide.with(this)
                                    .load("https://example.com/image.jpg")
                                    .placeholder(R.drawable.placeholder)
                                    .error(R.drawable.error)
                                    .into(imageView)
                                
                                // 从资源加载
                                Glide.with(this)
                                    .load(R.drawable.image)
                                    .into(imageView)
                                
                                // 从文件加载
                                Glide.with(this)
                                    .load(File("/path/to/image.jpg"))
                                    .into(imageView)
                                
                                // 从URI加载
                                Glide.with(this)
                                    .load(Uri.parse("content://..."))
                                    .into(imageView)
                            }
                        }
                        
                        // Glide配置
                        class MyApp : Application() {
                            override fun onCreate() {
                                super.onCreate()
                                
                                val builder = GlideBuilder()
                                builder.setMemoryCache(LruResourceCache(10 * 1024 * 1024)) // 10MB
                                builder.setDiskCache(
                                    InternalCacheDiskCacheFactory(this, 100 * 1024 * 1024) // 100MB
                                )
                                
                                Glide.init(this, builder)
                            }
                        }
                    """.trimIndent(),
                    explanation = "Glide是功能强大的图片加载库，支持从URL、资源、文件、URI等加载图片。可以配置占位符、错误图片、缓存等。"
                ),
                CodeExample(
                    title = "示例2：Coil使用（Kotlin友好）",
                    code = """
                        // 在Compose中使用Coil
                        @Composable
                        fun CoilImageExample() {
                            AsyncImage(
                                model = "https://example.com/image.jpg",
                                contentDescription = null,
                                modifier = Modifier.size(200.dp),
                                placeholder = painterResource(R.drawable.placeholder),
                                error = painterResource(R.drawable.error),
                                contentScale = ContentScale.Crop
                            )
                        }
                        
                        // 在传统View中使用Coil
                        class ImageActivity : AppCompatActivity() {
                            
                            override fun onCreate(savedInstanceState: Bundle?) {
                                super.onCreate(savedInstanceState)
                                setContentView(R.layout.activity_image)
                                
                                val imageView = findViewById<ImageView>(R.id.imageView)
                                
                                // 基础加载
                                imageView.load("https://example.com/image.jpg")
                                
                                // 带占位符和错误图片
                                imageView.load("https://example.com/image.jpg") {
                                    placeholder(R.drawable.placeholder)
                                    error(R.drawable.error)
                                    crossfade(true)
                                }
                                
                                // 图片转换
                                imageView.load("https://example.com/image.jpg") {
                                    transformations(
                                        CircleCropTransformation(),
                                        RoundedCornersTransformation(16f)
                                    )
                                }
                            }
                        }
                        
                        // Coil配置
                        class MyApp : Application() {
                            override fun onCreate() {
                                super.onCreate()
                                
                                val imageLoader = ImageLoader.Builder(this)
                                    .memoryCache {
                                        MemoryCache.Builder(this)
                                            .maxSizePercent(0.25)
                                            .build()
                                    }
                                    .diskCache {
                                        DiskCache.Builder()
                                            .directory(cacheDir.resolve("image_cache"))
                                            .maxSizePercent(0.02)
                                            .build()
                                    }
                                    .build()
                                
                                Coil.setImageLoader(imageLoader)
                            }
                        }
                    """.trimIndent(),
                    explanation = "Coil是Kotlin友好的图片加载库，专为Kotlin协程设计。在Compose中使用AsyncImage，在传统View中使用load扩展函数。支持图片转换和缓存配置。"
                ),
                CodeExample(
                    title = "示例3：图片压缩",
                    code = """
                        class ImageCompressor(private val context: Context) {
                            
                            // 压缩图片文件
                            fun compressImageFile(
                                imageFile: File,
                                maxSize: Long = 1024 * 1024 // 1MB
                            ): File? {
                                return try {
                                    var quality = 90
                                    var compressedFile = imageFile
                                    
                                    while (compressedFile.length() > maxSize && quality > 10) {
                                        val bitmap = BitmapFactory.decodeFile(compressedFile.absolutePath)
                                        val outputFile = File(context.cacheDir, "compressed_${'$'}{System.currentTimeMillis()}.jpg")
                                        
                                        outputFile.outputStream().use { out ->
                                            bitmap.compress(
                                                Bitmap.CompressFormat.JPEG,
                                                quality,
                                                out
                                            )
                                        }
                                        
                                        compressedFile = outputFile
                                        quality -= 10
                                    }
                                    
                                    compressedFile
                                } catch (e: Exception) {
                                    null
                                }
                            }
                            
                            // 压缩Bitmap
                            fun compressBitmap(
                                bitmap: Bitmap,
                                maxWidth: Int = 1920,
                                maxHeight: Int = 1080
                            ): Bitmap {
                                val width = bitmap.width
                                val height = bitmap.height
                                
                                if (width <= maxWidth && height <= maxHeight) {
                                    return bitmap
                                }
                                
                                val scale = minOf(
                                    maxWidth.toFloat() / width,
                                    maxHeight.toFloat() / height
                                )
                                
                                val newWidth = (width * scale).toInt()
                                val newHeight = (height * scale).toInt()
                                
                                return Bitmap.createScaledBitmap(bitmap, newWidth, newHeight, true)
                            }
                            
                            // 使用Glide压缩
                            fun loadCompressedImage(imageView: ImageView, url: String) {
                                Glide.with(context)
                                    .load(url)
                                    .override(800, 600) // 指定尺寸
                                    .encodeFormat(Bitmap.CompressFormat.JPEG)
                                    .encodeQuality(80) // 质量
                                    .into(imageView)
                            }
                        }
                    """.trimIndent(),
                    explanation = "图片压缩可以减少内存占用和文件大小。可以压缩图片文件或Bitmap，使用Glide可以自动压缩。注意平衡图片质量和文件大小。"
                ),
                CodeExample(
                    title = "示例4：图片转换和效果",
                    code = """
                        // 使用Glide图片转换
                        class ImageTransformExample {
                            
                            fun loadWithTransform(imageView: ImageView, url: String) {
                                Glide.with(context)
                                    .load(url)
                                    // 圆角
                                    .transform(RoundedCorners(16))
                                    // 或圆形
                                    .circleCrop()
                                    // 或自定义转换
                                    .transform(CustomTransform())
                                    .into(imageView)
                            }
                            
                            // 自定义转换
                            class CustomTransform : Transformation<Bitmap> {
                                override fun transform(
                                    context: Context,
                                    resource: Resource<Bitmap>,
                                    outWidth: Int,
                                    outHeight: Int
                                ): Resource<Bitmap> {
                                    val bitmap = resource.get()
                                    // 实现自定义转换逻辑
                                    return BitmapResource.obtain(bitmap, context)
                                }
                                
                                override fun getId(): String = "custom_transform"
                            }
                        }
                        
                        // 使用Coil图片转换
                        imageView.load("https://example.com/image.jpg") {
                            transformations(
                                CircleCropTransformation(),
                                RoundedCornersTransformation(16f),
                                BlurTransformation(context, 10f)
                            )
                        }
                    """.trimIndent(),
                    explanation = "图片转换可以实现圆角、圆形、模糊等效果。Glide和Coil都支持图片转换，可以链式调用多个转换。"
                )
            ),
            useCases = listOf(
                "图片加载：从网络、本地加载图片",
                "图片缓存：使用内存和磁盘缓存提升加载速度",
                "图片压缩：压缩图片减少内存占用和文件大小",
                "图片转换：实现圆角、圆形、模糊等效果",
                "占位符：显示加载占位符，提升用户体验"
            ),
            notes = listOf(
                "Glide是功能强大的图片加载库，支持多种图片源",
                "Coil是Kotlin友好的图片加载库，专为Kotlin协程设计",
                "图片压缩可以减少内存占用和文件大小",
                "使用内存缓存和磁盘缓存可以提升加载速度",
                "图片转换可以实现各种视觉效果",
                "占位符和错误处理可以提升用户体验",
                "注意图片内存管理，避免内存溢出"
            ),
            practiceTips = "建议使用Glide或Coil进行图片加载，它们提供了强大的功能和良好的性能。使用图片缓存提升加载速度。对于大图片，进行压缩处理。使用占位符和错误处理提升用户体验。注意图片内存管理，及时释放不需要的图片。"
        ),
        
        KnowledgeDetail(
            id = "audio_video",
            title = "音频和视频（MediaPlayer、ExoPlayer）",
            overview = "Android音频和视频播放可以使用MediaPlayer或ExoPlayer。ExoPlayer是Google推荐的现代媒体播放库，功能强大且可扩展。",
            keyPoints = listOf(
                "MediaPlayer：Android系统提供的音频播放API，简单易用",
                "ExoPlayer：Google开发的现代媒体播放库，功能强大且可扩展",
                "音频播放：播放本地和网络音频文件",
                "视频播放：播放本地和网络视频文件",
                "媒体控制：播放、暂停、进度控制等",
                "流媒体：支持流媒体播放，如HLS、DASH"
            ),
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：MediaPlayer音频播放",
                    code = """
                        class AudioPlayerActivity : AppCompatActivity() {
                            
                            private var mediaPlayer: MediaPlayer? = null
                            
                            override fun onCreate(savedInstanceState: Bundle?) {
                                super.onCreate(savedInstanceState)
                                setContentView(R.layout.activity_audio)
                                
                                buttonPlay.setOnClickListener { playAudio() }
                                buttonPause.setOnClickListener { pauseAudio() }
                                buttonStop.setOnClickListener { stopAudio() }
                            }
                            
                            private fun playAudio() {
                                try {
                                    if (mediaPlayer == null) {
                                        // 从资源播放
                                        mediaPlayer = MediaPlayer.create(
                                            this,
                                            R.raw.audio_file
                                        )
                                        
                                        // 或从文件播放
                                        // mediaPlayer = MediaPlayer().apply {
                                        //     setDataSource("/path/to/audio.mp3")
                                        //     prepare()
                                        // }
                                        
                                        // 或从网络播放
                                        // mediaPlayer = MediaPlayer().apply {
                                        //     setDataSource("https://example.com/audio.mp3")
                                        //     prepareAsync()
                                        // }
                                        
                                        mediaPlayer?.setOnPreparedListener {
                                            it.start()
                                        }
                                        
                                        mediaPlayer?.setOnCompletionListener {
                                            // 播放完成
                                            releaseMediaPlayer()
                                        }
                                        
                                        mediaPlayer?.setOnErrorListener { _, what, extra ->
                                            // 播放错误
                                            Log.e("MediaPlayer", "播放错误: ${'$'}what, ${'$'}extra")
                                            true
                                        }
                                    } else {
                                        mediaPlayer?.start()
                                    }
                                } catch (e: Exception) {
                                    Log.e("MediaPlayer", "播放失败", e)
                                }
                            }
                            
                            private fun pauseAudio() {
                                mediaPlayer?.pause()
                            }
                            
                            private fun stopAudio() {
                                mediaPlayer?.stop()
                                releaseMediaPlayer()
                            }
                            
                            private fun releaseMediaPlayer() {
                                mediaPlayer?.release()
                                mediaPlayer = null
                            }
                            
                            override fun onDestroy() {
                                super.onDestroy()
                                releaseMediaPlayer()
                            }
                        }
                    """.trimIndent(),
                    explanation = "MediaPlayer用于播放音频，支持从资源、文件、网络加载。需要管理MediaPlayer的生命周期，在不需要时释放资源。"
                ),
                CodeExample(
                    title = "示例2：ExoPlayer视频播放",
                    code = """
                        class VideoPlayerActivity : AppCompatActivity() {
                            
                            private var player: ExoPlayer? = null
                            
                            override fun onCreate(savedInstanceState: Bundle?) {
                                super.onCreate(savedInstanceState)
                                setContentView(R.layout.activity_video)
                                
                                initializePlayer()
                            }
                            
                            private fun initializePlayer() {
                                player = ExoPlayer.Builder(this).build()
                                
                                // 绑定到PlayerView
                                binding.playerView.player = player
                                
                                // 创建媒体项
                                val mediaItem = MediaItem.fromUri("https://example.com/video.mp4")
                                
                                // 或从本地文件
                                // val mediaItem = MediaItem.fromUri(Uri.fromFile(File("/path/to/video.mp4")))
                                
                                // 设置媒体项
                                player?.setMediaItem(mediaItem)
                                
                                // 准备播放
                                player?.prepare()
                                
                                // 自动播放
                                player?.playWhenReady = true
                                
                                // 监听播放状态
                                player?.addListener(object : Player.Listener {
                                    override fun onPlaybackStateChanged(state: Int) {
                                        when (state) {
                                            Player.STATE_READY -> {
                                                // 准备就绪
                                            }
                                            Player.STATE_BUFFERING -> {
                                                // 缓冲中
                                            }
                                            Player.STATE_ENDED -> {
                                                // 播放结束
                                            }
                                        }
                                    }
                                })
                            }
                            
                            override fun onResume() {
                                super.onResume()
                                if (player == null) {
                                    initializePlayer()
                                }
                            }
                            
                            override fun onPause() {
                                super.onPause()
                                player?.pause()
                            }
                            
                            override fun onDestroy() {
                                super.onDestroy()
                                releasePlayer()
                            }
                            
                            private fun releasePlayer() {
                                player?.release()
                                player = null
                            }
                        }
                        
                        // 布局文件：activity_video.xml
                        // <com.google.android.exoplayer2.ui.PlayerView
                        //     android:id="@+id/playerView"
                        //     android:layout_width="match_parent"
                        //     android:layout_height="wrap_content" />
                    """.trimIndent(),
                    explanation = "ExoPlayer用于播放视频，功能强大且可扩展。使用PlayerView显示视频，支持播放控制、全屏等功能。需要管理ExoPlayer的生命周期。"
                ),
                CodeExample(
                    title = "示例3：ExoPlayer音频播放",
                    code = """
                        class AudioExoPlayerActivity : AppCompatActivity() {
                            
                            private var player: ExoPlayer? = null
                            
                            private fun initializeAudioPlayer() {
                                player = ExoPlayer.Builder(this).build()
                                
                                // 创建音频媒体项
                                val mediaItem = MediaItem.fromUri("https://example.com/audio.mp3")
                                
                                player?.setMediaItem(mediaItem)
                                player?.prepare()
                                player?.playWhenReady = true
                                
                                // 监听播放进度
                                player?.addListener(object : Player.Listener {
                                    override fun onIsPlayingChanged(isPlaying: Boolean) {
                                        // 播放状态变化
                                    }
                                    
                                    override fun onPlaybackStateChanged(state: Int) {
                                        // 播放状态变化
                                    }
                                })
                            }
                            
                            // 播放控制
                            fun play() {
                                player?.play()
                            }
                            
                            fun pause() {
                                player?.pause()
                            }
                            
                            fun seekTo(position: Long) {
                                player?.seekTo(position)
                            }
                            
                            fun getCurrentPosition(): Long {
                                return player?.currentPosition ?: 0
                            }
                            
                            fun getDuration(): Long {
                                return player?.duration ?: 0
                            }
                        }
                    """.trimIndent(),
                    explanation = "ExoPlayer也可以用于播放音频，提供更强大的功能和更好的控制。支持播放控制、进度监听等功能。"
                ),
                CodeExample(
                    title = "示例4：ExoPlayer流媒体播放",
                    code = """
                        class StreamingPlayerActivity : AppCompatActivity() {
                            
                            private var player: ExoPlayer? = null
                            
                            private fun initializeStreamingPlayer() {
                                player = ExoPlayer.Builder(this).build()
                                
                                // HLS流媒体
                                val hlsMediaItem = MediaItem.fromUri("https://example.com/stream.m3u8")
                                
                                // DASH流媒体
                                val dashMediaItem = MediaItem.fromUri("https://example.com/stream.mpd")
                                
                                // 播放列表
                                val playlist = listOf(
                                    MediaItem.fromUri("https://example.com/video1.mp4"),
                                    MediaItem.fromUri("https://example.com/video2.mp4"),
                                    MediaItem.fromUri("https://example.com/video3.mp4")
                                )
                                
                                player?.setMediaItems(playlist)
                                player?.prepare()
                                player?.playWhenReady = true
                                
                                // 播放列表控制
                                player?.addListener(object : Player.Listener {
                                    override fun onMediaItemTransition(
                                        mediaItem: MediaItem?,
                                        reason: Int
                                    ) {
                                        // 切换到下一个媒体项
                                    }
                                })
                                
                                // 切换到下一个
                                player?.seekToNext()
                                
                                // 切换到上一个
                                player?.seekToPrevious()
                            }
                        }
                        
                        // ExoPlayer支持的格式：
                        // - MP4, WebM, Matroska
                        // - HLS (m3u8)
                        // - DASH (mpd)
                        // - SmoothStreaming
                        // - 等等
                    """.trimIndent(),
                    explanation = "ExoPlayer支持多种流媒体格式，如HLS、DASH等。支持播放列表，可以播放多个媒体项。适合流媒体播放场景。"
                )
            ),
            useCases = listOf(
                "音频播放：播放本地和网络音频文件",
                "视频播放：播放本地和网络视频文件",
                "流媒体：播放HLS、DASH等流媒体",
                "播放列表：播放多个媒体项",
                "媒体控制：实现播放、暂停、进度控制等功能"
            ),
            notes = listOf(
                "MediaPlayer简单易用，适合简单的音频播放",
                "ExoPlayer功能强大，适合视频播放和流媒体",
                "需要管理MediaPlayer和ExoPlayer的生命周期",
                "ExoPlayer支持多种媒体格式和流媒体协议",
                "使用PlayerView显示视频，提供播放控制",
                "注意释放媒体播放器资源，避免内存泄漏",
                "流媒体播放需要处理网络状态和缓冲"
            ),
            practiceTips = "建议使用ExoPlayer进行视频播放和流媒体播放，它功能强大且可扩展。对于简单的音频播放，可以使用MediaPlayer。注意管理播放器的生命周期，及时释放资源。使用PlayerView显示视频，提供良好的用户体验。处理播放错误和网络状态，提升稳定性。"
        ),
        
        // ========== 性能优化 ==========
        
        KnowledgeDetail(
            id = "startup_opt",
            title = "启动性能优化",
            overview = "应用启动性能直接影响用户体验。优化启动时间可以减少冷启动、温启动和热启动的时间，提升应用响应速度。",
            keyPoints = listOf(
                "启动类型：冷启动、温启动、热启动",
                "启动流程：Application.onCreate()、Activity.onCreate()、布局加载、数据初始化",
                "优化策略：延迟初始化、异步加载、减少启动任务",
                "启动监控：使用启动时间监控工具，如App Startup库",
                "懒加载：延迟非关键组件的初始化",
                "多进程优化：优化多进程应用的启动顺序"
            ),
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：延迟初始化",
                    code = """
                        class MyApplication : Application() {
                            
                            override fun onCreate() {
                                super.onCreate()
                                
                                // 不好的做法：在Application中初始化所有组件
                                // initAllComponents()
                                
                                // 好的做法：延迟初始化非关键组件
                                initCriticalComponents()
                                
                                // 使用App Startup延迟初始化
                                // 在AndroidManifest.xml中配置
                            }
                            
                            private fun initCriticalComponents() {
                                // 只初始化关键组件
                                // 如崩溃报告、日志等
                            }
                            
                            // 延迟初始化非关键组件
                            fun initNonCriticalComponents() {
                                // 在需要时再初始化
                                // 如第三方SDK、数据库等
                            }
                        }
                        
                        // 使用App Startup库延迟初始化
                        // 1. 添加依赖
                        // implementation "androidx.startup:startup-runtime:1.1.1"
                        
                        // 2. 创建Initializer
                        class MyInitializer : Initializer<Unit> {
                            override fun create(context: Context): Unit {
                                // 初始化逻辑
                                return Unit
                            }
                            
                            override fun dependencies(): List<Class<out Initializer<*>>> {
                                return emptyList()
                            }
                        }
                        
                        // 3. 在AndroidManifest.xml中配置
                        // <provider
                        //     android:name="androidx.startup.InitializationProvider"
                        //     android:authorities="${'$'}{applicationId}.androidx-startup"
                        //     android:exported="false"
                        //     tools:node="merge">
                        //     <meta-data
                        //         android:name="com.example.MyInitializer"
                        //         android:value="androidx.startup" />
                        // </provider>
                    """.trimIndent(),
                    explanation = "延迟初始化可以减少启动时间。在Application中只初始化关键组件，非关键组件延迟到需要时再初始化。使用App Startup库可以更好地管理初始化顺序。"
                ),
                CodeExample(
                    title = "示例2：异步加载数据",
                    code = """
                        class MainActivity : AppCompatActivity() {
                            
                            override fun onCreate(savedInstanceState: Bundle?) {
                                super.onCreate(savedInstanceState)
                                
                                // 不好的做法：在主线程加载数据
                                // val data = loadDataFromDatabase()
                                
                                // 好的做法：异步加载数据
                                setContentView(R.layout.activity_main)
                                
                                // 显示加载状态
                                showLoading()
                                
                                // 异步加载数据
                                lifecycleScope.launch {
                                    val data = withContext(Dispatchers.IO) {
                                        loadDataFromDatabase()
                                    }
                                    
                                    // 更新UI
                                    updateUI(data)
                                    hideLoading()
                                }
                            }
                            
                            private suspend fun loadDataFromDatabase(): List<Data> {
                                return withContext(Dispatchers.IO) {
                                    // 从数据库加载数据
                                    database.dataDao().getAll()
                                }
                            }
                            
                            // 使用ViewBinding延迟初始化
                            private val binding by lazy {
                                ActivityMainBinding.inflate(layoutInflater)
                            }
                        }
                        
                        // 优化布局加载
                        class OptimizedActivity : AppCompatActivity() {
                            
                            override fun onCreate(savedInstanceState: Bundle?) {
                                super.onCreate(savedInstanceState)
                                
                                // 使用ViewBinding，延迟初始化
                                val binding = ActivityMainBinding.inflate(layoutInflater)
                                setContentView(binding.root)
                                
                                // 异步加载数据，不阻塞UI
                                loadDataAsync()
                            }
                        }
                    """.trimIndent(),
                    explanation = "异步加载数据可以避免阻塞主线程，提升启动速度。使用协程或线程池异步加载数据，在数据加载完成后再更新UI。"
                ),
                CodeExample(
                    title = "示例3：启动时间监控",
                    code = """
                        class StartupMonitor {
                            
                            companion object {
                                private var appStartTime: Long = 0
                                private var activityStartTime: Long = 0
                                
                                fun recordAppStart() {
                                    appStartTime = System.currentTimeMillis()
                                }
                                
                                fun recordActivityStart() {
                                    activityStartTime = System.currentTimeMillis()
                                }
                                
                                fun recordActivityReady() {
                                    val totalTime = System.currentTimeMillis() - appStartTime
                                    val activityTime = System.currentTimeMillis() - activityStartTime
                                    
                                    Log.d("Startup", "总启动时间: ${'$'}totalTime ms")
                                    Log.d("Startup", "Activity启动时间: ${'$'}activityTime ms")
                                    
                                    // 上报到分析平台
                                    // Analytics.logEvent("app_startup", mapOf(
                                    //     "total_time" to totalTime,
                                    //     "activity_time" to activityTime
                                    // ))
                                }
                            }
                        }
                        
                        // 在Application中使用
                        class MyApplication : Application() {
                            override fun onCreate() {
                                StartupMonitor.recordAppStart()
                                super.onCreate()
                            }
                        }
                        
                        // 在Activity中使用
                        class MainActivity : AppCompatActivity() {
                            override fun onCreate(savedInstanceState: Bundle?) {
                                StartupMonitor.recordActivityStart()
                                super.onCreate(savedInstanceState)
                                setContentView(R.layout.activity_main)
                                
                                // 在UI准备好后记录
                                binding.root.post {
                                    StartupMonitor.recordActivityReady()
                                }
                            }
                        }
                        
                        // 使用Android Vitals监控启动时间
                        // 在Google Play Console中查看启动性能数据
                    """.trimIndent(),
                    explanation = "监控启动时间可以帮助识别性能瓶颈。记录Application启动时间、Activity启动时间等关键指标，上报到分析平台进行分析。"
                ),
                CodeExample(
                    title = "示例4：优化启动流程",
                    code = """
                        class OptimizedMainActivity : AppCompatActivity() {
                            
                            override fun onCreate(savedInstanceState: Bundle?) {
                                super.onCreate(savedInstanceState)
                                
                                // 1. 设置主题（避免白屏）
                                setTheme(R.style.AppTheme)
                                
                                // 2. 快速显示布局
                                setContentView(R.layout.activity_main)
                                
                                // 3. 延迟非关键初始化
                                binding.root.post {
                                    initNonCriticalComponents()
                                }
                                
                                // 4. 异步加载数据
                                loadDataAsync()
                            }
                            
                            private fun initNonCriticalComponents() {
                                // 初始化非关键组件
                                // 如第三方SDK、分析工具等
                            }
                            
                            private fun loadDataAsync() {
                                lifecycleScope.launch {
                                    val data = withContext(Dispatchers.IO) {
                                        loadData()
                                    }
                                    updateUI(data)
                                }
                            }
                        }
                        
                        // 优化Application启动
                        class OptimizedApplication : Application() {
                            
                            override fun onCreate() {
                                super.onCreate()
                                
                                // 使用StrictMode检测主线程操作
                                if (BuildConfig.DEBUG) {
                                    StrictMode.setThreadPolicy(
                                        StrictMode.ThreadPolicy.Builder()
                                            .detectAll()
                                            .penaltyLog()
                                            .build()
                                    )
                                }
                                
                                // 只初始化关键组件
                                initCriticalComponents()
                            }
                        }
                    """.trimIndent(),
                    explanation = "优化启动流程包括设置主题避免白屏、快速显示布局、延迟非关键初始化、异步加载数据等。使用StrictMode可以检测主线程操作。"
                )
            ),
            useCases = listOf(
                "冷启动优化：减少应用冷启动时间",
                "温启动优化：优化应用温启动速度",
                "热启动优化：提升应用热启动响应",
                "启动监控：监控和分析启动性能",
                "延迟初始化：延迟非关键组件初始化"
            ),
            notes = listOf(
                "启动性能直接影响用户体验，需要重点关注",
                "延迟初始化可以减少启动时间",
                "异步加载数据可以避免阻塞主线程",
                "使用App Startup库管理初始化顺序",
                "监控启动时间，识别性能瓶颈",
                "优化Application和Activity的onCreate方法",
                "使用StrictMode检测主线程操作"
            ),
            practiceTips = "建议延迟初始化非关键组件，使用异步加载数据。监控启动时间，识别性能瓶颈。优化Application和Activity的onCreate方法，减少主线程操作。使用App Startup库管理初始化顺序。设置主题避免白屏，快速显示布局。"
        ),
        
        KnowledgeDetail(
            id = "memory_opt",
            title = "内存优化",
            overview = "内存优化是Android性能优化的重要部分。合理管理内存可以避免OOM（Out of Memory）错误，提升应用性能和稳定性。",
            keyPoints = listOf(
                "内存泄漏：避免内存泄漏，及时释放资源",
                "内存监控：使用工具监控内存使用情况",
                "图片优化：优化图片加载，避免内存溢出",
                "对象池：使用对象池复用对象，减少GC",
                "内存缓存：合理使用内存缓存，控制缓存大小",
                "大对象：避免创建大对象，使用流式处理"
            ),
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：避免内存泄漏",
                    code = """
                        class MainActivity : AppCompatActivity() {
                            
                            // 不好的做法：持有Activity引用
                            private var handler = object : Handler(Looper.getMainLooper()) {
                                override fun handleMessage(msg: Message) {
                                    // 持有Activity引用，可能导致内存泄漏
                                }
                            }
                            
                            // 好的做法：使用弱引用或静态内部类
                            private class MyHandler(activity: MainActivity) : Handler(Looper.getMainLooper()) {
                                private val activityRef = WeakReference(activity)
                                
                                override fun handleMessage(msg: Message) {
                                    val activity = activityRef.get() ?: return
                                    // 处理消息
                                }
                            }
                            
                            // 更好的做法：使用Lifecycle-aware组件
                            private val handler = Handler(Looper.getMainLooper())
                            
                            override fun onCreate(savedInstanceState: Bundle?) {
                                super.onCreate(savedInstanceState)
                                
                                // 使用LifecycleObserver
                                lifecycle.addObserver(object : LifecycleObserver {
                                    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
                                    fun onDestroy() {
                                        handler.removeCallbacksAndMessages(null)
                                    }
                                })
                            }
                            
                            // 避免静态引用Activity
                            companion object {
                                // 不好的做法
                                // var instance: MainActivity? = null
                                
                                // 好的做法：使用WeakReference
                                private var instanceRef: WeakReference<MainActivity>? = null
                            }
                            
                            // 及时释放资源
                            override fun onDestroy() {
                                super.onDestroy()
                                // 取消网络请求
                                // 释放监听器
                                // 清理资源
                            }
                        }
                        
                        // 避免Context泄漏
                        class MySingleton private constructor(context: Context) {
                            // 不好的做法：持有Activity Context
                            // private val context: Context = context
                            
                            // 好的做法：使用Application Context
                            private val context: Context = context.applicationContext
                            
                            companion object {
                                @Volatile
                                private var INSTANCE: MySingleton? = null
                                
                                fun getInstance(context: Context): MySingleton {
                                    return INSTANCE ?: synchronized(this) {
                                        INSTANCE ?: MySingleton(context).also { INSTANCE = it }
                                    }
                                }
                            }
                        }
                    """.trimIndent(),
                    explanation = "避免内存泄漏是内存优化的关键。避免持有Activity引用，使用弱引用或静态内部类。使用Lifecycle-aware组件管理资源。使用Application Context而不是Activity Context。"
                ),
                CodeExample(
                    title = "示例2：图片内存优化",
                    code = """
                        class ImageMemoryOptimizer {
                            
                            // 使用Glide加载图片，自动管理内存
                            fun loadImage(imageView: ImageView, url: String) {
                                Glide.with(context)
                                    .load(url)
                                    .override(800, 600) // 指定尺寸
                                    .format(DecodeFormat.PREFER_RGB_565) // 使用RGB_565减少内存
                                    .into(imageView)
                            }
                            
                            // 压缩Bitmap
                            fun compressBitmap(bitmap: Bitmap, maxWidth: Int, maxHeight: Int): Bitmap {
                                val width = bitmap.width
                                val height = bitmap.height
                                
                                if (width <= maxWidth && height <= maxHeight) {
                                    return bitmap
                                }
                                
                                val scale = minOf(
                                    maxWidth.toFloat() / width,
                                    maxHeight.toFloat() / height
                                )
                                
                                val newWidth = (width * scale).toInt()
                                val newHeight = (height * scale).toInt()
                                
                                return Bitmap.createScaledBitmap(bitmap, newWidth, newHeight, true)
                            }
                            
                            // 使用inSampleSize加载大图
                            fun decodeSampledBitmapFromResource(
                                res: Resources,
                                resId: Int,
                                reqWidth: Int,
                                reqHeight: Int
                            ): Bitmap {
                                return BitmapFactory.Options().run {
                                    inJustDecodeBounds = true
                                    BitmapFactory.decodeResource(res, resId, this)
                                    
                                    inSampleSize = calculateInSampleSize(this, reqWidth, reqHeight)
                                    
                                    inJustDecodeBounds = false
                                    BitmapFactory.decodeResource(res, resId, this)
                                }
                            }
                            
                            private fun calculateInSampleSize(
                                options: BitmapFactory.Options,
                                reqWidth: Int,
                                reqHeight: Int
                            ): Int {
                                val (height: Int, width: Int) = options.run { outHeight to outWidth }
                                var inSampleSize = 1
                                
                                if (height > reqHeight || width > reqWidth) {
                                    val halfHeight: Int = height / 2
                                    val halfWidth: Int = width / 2
                                    
                                    while (halfHeight / inSampleSize >= reqHeight &&
                                        halfWidth / inSampleSize >= reqWidth) {
                                        inSampleSize *= 2
                                    }
                                }
                                
                                return inSampleSize
                            }
                            
                            // 及时回收Bitmap
                            fun recycleBitmap(bitmap: Bitmap?) {
                                if (bitmap != null && !bitmap.isRecycled) {
                                    bitmap.recycle()
                                }
                            }
                        }
                    """.trimIndent(),
                    explanation = "图片是内存消耗的主要来源。使用Glide等库自动管理内存，压缩Bitmap减少内存占用，使用inSampleSize加载大图，及时回收不需要的Bitmap。"
                ),
                CodeExample(
                    title = "示例3：对象池和缓存",
                    code = """
                        // 使用对象池复用对象
                        class ObjectPool<T>(private val factory: () -> T, private val maxSize: Int = 10) {
                            private val pool = mutableListOf<T>()
                            
                            fun acquire(): T {
                                return synchronized(pool) {
                                    if (pool.isNotEmpty()) {
                                        pool.removeAt(pool.size - 1)
                                    } else {
                                        factory()
                                    }
                                }
                            }
                            
                            fun release(obj: T) {
                                synchronized(pool) {
                                    if (pool.size < maxSize) {
                                        pool.add(obj)
                                    }
                                }
                            }
                        }
                        
                        // 使用LruCache控制内存缓存
                        class ImageCache(context: Context) {
                            private val cache = object : LruCache<String, Bitmap>(
                                (Runtime.getRuntime().maxMemory() / 8).toInt()
                            ) {
                                override fun sizeOf(key: String, bitmap: Bitmap): Int {
                                    return bitmap.byteCount
                                }
                                
                                override fun entryRemoved(
                                    evicted: Boolean,
                                    key: String,
                                    oldValue: Bitmap,
                                    newValue: Bitmap?
                                ) {
                                    if (evicted && !oldValue.isRecycled) {
                                        oldValue.recycle()
                                    }
                                }
                            }
                            
                            fun get(key: String): Bitmap? = cache.get(key)
                            
                            fun put(key: String, bitmap: Bitmap) {
                                cache.put(key, bitmap)
                            }
                            
                            fun clear() {
                                cache.evictAll()
                            }
                        }
                        
                        // 使用WeakReference缓存
                        class WeakCache<K, V> {
                            private val cache = mutableMapOf<K, WeakReference<V>>()
                            
                            fun get(key: K): V? {
                                val ref = cache[key]
                                val value = ref?.get()
                                if (value == null) {
                                    cache.remove(key)
                                }
                                return value
                            }
                            
                            fun put(key: K, value: V) {
                                cache[key] = WeakReference(value)
                            }
                        }
                    """.trimIndent(),
                    explanation = "使用对象池可以复用对象，减少GC压力。使用LruCache控制内存缓存大小，避免内存溢出。使用WeakReference缓存，允许GC回收不需要的对象。"
                ),
                CodeExample(
                    title = "示例4：内存监控",
                    code = """
                        class MemoryMonitor {
                            
                            fun getMemoryInfo(): String {
                                val runtime = Runtime.getRuntime()
                                val totalMemory = runtime.totalMemory()
                                val freeMemory = runtime.freeMemory()
                                val usedMemory = totalMemory - freeMemory
                                val maxMemory = runtime.maxMemory()
                                
                                return ${'$'}{'"'}${'$'}{'"'}${'$'}{'"'}
                                    Total Memory: ${'$'}{totalMemory / 1024 / 1024} MB
                                    Free Memory: ${'$'}{freeMemory / 1024 / 1024} MB
                                    Used Memory: ${'$'}{usedMemory / 1024 / 1024} MB
                                    Max Memory: ${'$'}{maxMemory / 1024 / 1024} MB
                                ${'$'}{'"'}${'$'}{'"'}${'$'}{'"'}.trimIndent()
                            }
                            
                            // 监控内存使用
                            fun monitorMemory() {
                                val memoryInfo = ActivityManager.MemoryInfo()
                                val activityManager = context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
                                activityManager.getMemoryInfo(memoryInfo)
                                
                                val availableMemory = memoryInfo.availMem
                                val totalMemory = memoryInfo.totalMem
                                val threshold = memoryInfo.threshold
                                
                                if (availableMemory < threshold) {
                                    // 内存不足，清理缓存
                                    clearCache()
                                }
                            }
                            
                            // 使用LeakCanary检测内存泄漏
                            // 1. 添加依赖
                            // debugImplementation 'com.squareup.leakcanary:leakcanary-android:2.12'
                            
                            // 2. 在Application中初始化（自动完成）
                            // LeakCanary会自动检测内存泄漏
                        }
                        
                        // 在Application中监控内存
                        class MyApplication : Application() {
                            
                            override fun onCreate() {
                                super.onCreate()
                                
                                // 监控内存使用
                                if (BuildConfig.DEBUG) {
                                    registerComponentCallbacks(object : ComponentCallbacks2 {
                                        override fun onTrimMemory(level: Int) {
                                            when (level) {
                                                ComponentCallbacks2.TRIM_MEMORY_RUNNING_CRITICAL -> {
                                                    // 内存严重不足，清理所有缓存
                                                    clearAllCache()
                                                }
                                                ComponentCallbacks2.TRIM_MEMORY_RUNNING_LOW -> {
                                                    // 内存不足，清理部分缓存
                                                    clearPartialCache()
                                                }
                                            }
                                        }
                                        
                                        override fun onConfigurationChanged(newConfig: Configuration) {}
                                        override fun onLowMemory() {
                                            clearAllCache()
                                        }
                                    })
                                }
                            }
                        }
                    """.trimIndent(),
                    explanation = "监控内存使用可以帮助识别内存问题。使用Runtime获取内存信息，使用ActivityManager监控系统内存，使用LeakCanary检测内存泄漏。在内存不足时清理缓存。"
                )
            ),
            useCases = listOf(
                "避免内存泄漏：及时释放资源，避免内存泄漏",
                "图片优化：优化图片加载，减少内存占用",
                "对象复用：使用对象池复用对象，减少GC",
                "内存缓存：合理使用内存缓存，控制缓存大小",
                "内存监控：监控内存使用，识别内存问题"
            ),
            notes = listOf(
                "内存优化是性能优化的重要部分",
                "避免内存泄漏，及时释放资源",
                "图片是内存消耗的主要来源，需要优化",
                "使用对象池可以复用对象，减少GC压力",
                "使用LruCache控制内存缓存大小",
                "监控内存使用，识别内存问题",
                "使用LeakCanary检测内存泄漏"
            ),
            practiceTips = "建议避免内存泄漏，及时释放资源。优化图片加载，使用Glide等库自动管理内存。使用对象池复用对象，减少GC压力。合理使用内存缓存，控制缓存大小。监控内存使用，使用LeakCanary检测内存泄漏。在内存不足时清理缓存。"
        ),
        
        KnowledgeDetail(
            id = "ui_opt",
            title = "UI性能优化",
            overview = "UI性能优化可以提升应用的流畅度和响应速度。优化布局、减少过度绘制、优化动画等可以显著提升用户体验。",
            keyPoints = listOf(
                "布局优化：优化布局层次，减少嵌套",
                "过度绘制：减少过度绘制，使用GPU渲染分析",
                "RecyclerView优化：优化RecyclerView性能",
                "动画优化：优化动画性能，使用硬件加速",
                "视图复用：复用视图，减少创建开销",
                "异步加载：异步加载数据，避免阻塞UI线程"
            ),
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：布局优化",
                    code = """
                        // 不好的做法：嵌套过多
                        // <LinearLayout>
                        //     <LinearLayout>
                        //         <LinearLayout>
                        //             <TextView />
                        //         </LinearLayout>
                        //     </LinearLayout>
                        // </LinearLayout>
                        
                        // 好的做法：使用ConstraintLayout减少嵌套
                        // <androidx.constraintlayout.widget.ConstraintLayout>
                        //     <TextView
                        //         app:layout_constraintTop_toTopOf="parent"
                        //         app:layout_constraintStart_toStartOf="parent" />
                        // </androidx.constraintlayout.widget.ConstraintLayout>
                        
                        // 使用ViewStub延迟加载
                        class MainActivity : AppCompatActivity() {
                            
                            override fun onCreate(savedInstanceState: Bundle?) {
                                super.onCreate(savedInstanceState)
                                setContentView(R.layout.activity_main)
                                
                                // ViewStub延迟加载
                                val viewStub = findViewById<ViewStub>(R.id.viewStub)
                                viewStub?.inflate()
                            }
                        }
                        
                        // 布局文件：activity_main.xml
                        // <ViewStub
                        //     android:id="@+id/viewStub"
                        //     android:layout_width="match_parent"
                        //     android:layout_height="wrap_content"
                        //     android:layout="@layout/inflated_layout" />
                        
                        // 使用include复用布局
                        // <include
                        //     android:id="@+id/includedLayout"
                        //     layout="@layout/common_layout" />
                        
                        // 使用merge减少布局层次
                        // <merge xmlns:android="http://schemas.android.com/apk/res/android">
                        //     <TextView />
                        //     <Button />
                        // </merge>
                    """.trimIndent(),
                    explanation = "布局优化可以减少布局层次，提升渲染性能。使用ConstraintLayout减少嵌套，使用ViewStub延迟加载，使用include复用布局，使用merge减少布局层次。"
                ),
                CodeExample(
                    title = "示例2：RecyclerView优化",
                    code = """
                        class OptimizedRecyclerViewAdapter : RecyclerView.Adapter<ViewHolder>() {
                            
                            // 使用ViewHolder复用
                            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
                                val view = LayoutInflater.from(parent.context)
                                    .inflate(R.layout.item_layout, parent, false)
                                return ViewHolder(view)
                            }
                            
                            override fun onBindViewHolder(holder: ViewHolder, position: Int) {
                                val item = items[position]
                                
                                // 避免在onBindViewHolder中创建对象
                                // 不好的做法：
                                // holder.textView.text = "Item ${'$'}position"
                                
                                // 好的做法：预加载数据
                                holder.bind(item)
                            }
                            
                            // 使用DiffUtil优化更新
                            fun updateItems(newItems: List<Item>) {
                                val diffCallback = ItemDiffCallback(items, newItems)
                                val diffResult = DiffUtil.calculateDiff(diffCallback)
                                items = newItems
                                diffResult.dispatchUpdatesTo(this)
                            }
                            
                            // 设置RecyclerView优化
                            fun setupRecyclerView(recyclerView: RecyclerView) {
                                recyclerView.setHasFixedSize(true) // 固定大小
                                recyclerView.setItemViewCacheSize(20) // 增加缓存
                                recyclerView.isDrawingCacheEnabled = true // 启用绘制缓存
                                
                                // 使用LinearLayoutManager
                                recyclerView.layoutManager = LinearLayoutManager(context)
                                
                                // 预加载
                                (recyclerView.layoutManager as? LinearLayoutManager)?.apply {
                                    initialPrefetchItemCount = 4
                                }
                            }
                        }
                        
                        // DiffUtil回调
                        class ItemDiffCallback(
                            private val oldList: List<Item>,
                            private val newList: List<Item>
                        ) : DiffUtil.Callback() {
                            
                            override fun getOldListSize(): Int = oldList.size
                            
                            override fun getNewListSize(): Int = newList.size
                            
                            override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                                return oldList[oldItemPosition].id == newList[newItemPosition].id
                            }
                            
                            override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                                return oldList[oldItemPosition] == newList[newItemPosition]
                            }
                        }
                    """.trimIndent(),
                    explanation = "RecyclerView优化包括使用ViewHolder复用、使用DiffUtil优化更新、设置固定大小、增加缓存等。避免在onBindViewHolder中创建对象，预加载数据。"
                ),
                CodeExample(
                    title = "示例3：减少过度绘制",
                    code = """
                        // 在开发者选项中启用"显示过度绘制"
                        // Settings > Developer options > Show layout bounds
                        
                        // 减少过度绘制的方法：
                        
                        // 1. 移除不必要的背景
                        // 不好的做法：
                        // <LinearLayout
                        //     android:background="@color/white">
                        //     <TextView
                        //         android:background="@color/white" />
                        // </LinearLayout>
                        
                        // 好的做法：
                        // <LinearLayout>
                        //     <TextView
                        //         android:background="@color/white" />
                        // </LinearLayout>
                        
                        // 2. 使用clipToPadding和clipChildren
                        class OptimizedActivity : AppCompatActivity() {
                            
                            override fun onCreate(savedInstanceState: Bundle?) {
                                super.onCreate(savedInstanceState)
                                setContentView(R.layout.activity_main)
                                
                                val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
                                
                                // 裁剪padding区域
                                recyclerView.clipToPadding = false
                                
                                // 裁剪子视图
                                recyclerView.clipChildren = false
                            }
                        }
                        
                        // 3. 使用View的willNotDraw优化
                        class OptimizedView @JvmOverloads constructor(
                            context: Context,
                            attrs: AttributeSet? = null
                        ) : View(context, attrs) {
                            
                            init {
                                // 如果View不需要绘制，设置为true可以优化性能
                                setWillNotDraw(true)
                            }
                        }
                        
                        // 4. 使用硬件加速
                        // 在AndroidManifest.xml中启用
                        // <activity
                        //     android:hardwareAccelerated="true" />
                        
                        // 或在代码中启用
                        view.setLayerType(View.LAYER_TYPE_HARDWARE, null)
                    """.trimIndent(),
                    explanation = "减少过度绘制可以提升渲染性能。移除不必要的背景，使用clipToPadding和clipChildren，使用View的willNotDraw优化，使用硬件加速。"
                ),
                CodeExample(
                    title = "示例4：动画优化",
                    code = """
                        class OptimizedAnimationActivity : AppCompatActivity() {
                            
                            private fun animateView(view: View) {
                                // 使用硬件加速
                                view.setLayerType(View.LAYER_TYPE_HARDWARE, null)
                                
                                // 使用ObjectAnimator
                                val animator = ObjectAnimator.ofFloat(view, "alpha", 0f, 1f)
                                animator.duration = 300
                                animator.start()
                                
                                // 动画结束后恢复
                                animator.addListener(object : AnimatorListenerAdapter() {
                                    override fun onAnimationEnd(animation: Animator) {
                                        view.setLayerType(View.LAYER_TYPE_NONE, null)
                                    }
                                })
                            }
                            
                            // 使用ViewPropertyAnimator（推荐）
                            private fun animateViewOptimized(view: View) {
                                view.animate()
                                    .alpha(1f)
                                    .scaleX(1f)
                                    .scaleY(1f)
                                    .setDuration(300)
                                    .start()
                            }
                            
                            // 使用Transition动画
                            private fun transitionAnimation() {
                                val transition = TransitionInflater.from(this)
                                    .inflateTransition(R.transition.fade_transition)
                                
                                TransitionManager.beginDelayedTransition(binding.root, transition)
                                
                                // 改变视图属性
                                view.visibility = View.VISIBLE
                            }
                        }
                        
                        // 在Compose中使用动画
                        @Composable
                        fun AnimatedContent() {
                            var visible by remember { mutableStateOf(false) }
                            
                            AnimatedVisibility(visible = visible) {
                                Text("Hello")
                            }
                        }
                    """.trimIndent(),
                    explanation = "动画优化包括使用硬件加速、使用ViewPropertyAnimator、使用Transition动画等。在动画期间启用硬件加速，动画结束后恢复。在Compose中使用AnimatedVisibility等组件。"
                )
            ),
            useCases = listOf(
                "布局优化：优化布局层次，减少嵌套",
                "RecyclerView优化：优化RecyclerView性能",
                "减少过度绘制：减少过度绘制，提升渲染性能",
                "动画优化：优化动画性能，使用硬件加速",
                "视图复用：复用视图，减少创建开销"
            ),
            notes = listOf(
                "UI性能优化可以提升应用的流畅度",
                "优化布局层次，减少嵌套",
                "使用ConstraintLayout减少嵌套",
                "优化RecyclerView性能，使用DiffUtil",
                "减少过度绘制，移除不必要的背景",
                "优化动画性能，使用硬件加速",
                "使用ViewStub延迟加载"
            ),
            practiceTips = "建议优化布局层次，使用ConstraintLayout减少嵌套。优化RecyclerView性能，使用DiffUtil优化更新。减少过度绘制，移除不必要的背景。优化动画性能，使用硬件加速。使用ViewStub延迟加载，使用include复用布局。"
        ),
        
        KnowledgeDetail(
            id = "network_opt",
            title = "网络性能优化",
            overview = "网络性能优化可以减少网络请求时间，提升应用响应速度。优化网络请求、使用缓存、压缩数据等可以显著提升用户体验。",
            keyPoints = listOf(
                "请求优化：减少请求次数，合并请求",
                "缓存策略：使用HTTP缓存和本地缓存",
                "数据压缩：压缩请求和响应数据",
                "连接复用：复用HTTP连接，减少连接开销",
                "请求优先级：设置请求优先级，优先加载关键数据",
                "离线策略：实现离线缓存，支持离线访问"
            ),
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：请求优化",
                    code = """
                        // 使用Retrofit进行网络请求优化
                        interface ApiService {
                            
                            // 不好的做法：多次请求
                            // @GET("user/{id}")
                            // suspend fun getUser(@Path("id") String): User
                            //
                            // @GET("user/{id}/posts")
                            // suspend fun getUserPosts(@Path("id") String): List<Post>
                            
                            // 好的做法：合并请求
                            @GET("user/{id}/data")
                            suspend fun getUserData(@Path("id") String): UserData
                            
                            // 使用@QueryMap传递多个参数
                            @GET("search")
                            suspend fun search(@QueryMap params: Map<String, String>): SearchResult
                            
                            // 使用@Body传递复杂对象
                            @POST("batch")
                            suspend fun batchRequest(@Body requests: List<Request>): BatchResponse
                        }
                        
                        // 使用OkHttp拦截器优化请求
                        class OptimizedOkHttpClient {
                            
                            fun createClient(): OkHttpClient {
                                return OkHttpClient.Builder()
                                    .addInterceptor(LoggingInterceptor())
                                    .addInterceptor(CacheInterceptor())
                                    .addInterceptor(CompressionInterceptor())
                                    .connectTimeout(10, TimeUnit.SECONDS)
                                    .readTimeout(10, TimeUnit.SECONDS)
                                    .writeTimeout(10, TimeUnit.SECONDS)
                                    .build()
                            }
                            
                            // 缓存拦截器
                            class CacheInterceptor : Interceptor {
                                override fun intercept(chain: Interceptor.Chain): Response {
                                    val request = chain.request()
                                    val response = chain.proceed(request)
                                    
                                    // 设置缓存
                                    return response.newBuilder()
                                        .header("Cache-Control", "public, max-age=3600")
                                        .build()
                                }
                            }
                            
                            // 压缩拦截器
                            class CompressionInterceptor : Interceptor {
                                override fun intercept(chain: Interceptor.Chain): Response {
                                    val request = chain.request().newBuilder()
                                        .header("Accept-Encoding", "gzip")
                                        .build()
                                    
                                    return chain.proceed(request)
                                }
                            }
                        }
                    """.trimIndent(),
                    explanation = "请求优化包括减少请求次数、合并请求、使用拦截器优化请求等。使用Retrofit的@QueryMap和@Body传递参数，使用OkHttp拦截器实现缓存和压缩。"
                ),
                CodeExample(
                    title = "示例2：缓存策略",
                    code = """
                        // HTTP缓存
                        class CacheManager {
                            
                            fun createOkHttpClient(context: Context): OkHttpClient {
                                val cacheSize = 10 * 1024 * 1024L // 10MB
                                val cache = Cache(context.cacheDir, cacheSize)
                                
                                return OkHttpClient.Builder()
                                    .cache(cache)
                                    .addInterceptor(CacheInterceptor())
                                    .addNetworkInterceptor(NetworkCacheInterceptor())
                                    .build()
                            }
                            
                            // 缓存拦截器（离线缓存）
                            class CacheInterceptor : Interceptor {
                                override fun intercept(chain: Interceptor.Chain): Response {
                                    var request = chain.request()
                                    
                                    // 检查网络连接
                                    if (!isNetworkAvailable()) {
                                        // 离线时，使用缓存
                                        request = request.newBuilder()
                                            .cacheControl(CacheControl.FORCE_CACHE)
                                            .build()
                                    }
                                    
                                    val response = chain.proceed(request)
                                    
                                    return if (isNetworkAvailable()) {
                                        // 在线时，缓存响应
                                        response.newBuilder()
                                            .header("Cache-Control", "public, max-age=3600")
                                            .removeHeader("Pragma")
                                            .build()
                                    } else {
                                        // 离线时，使用缓存
                                        response.newBuilder()
                                            .header("Cache-Control", "public, only-if-cached, max-stale=86400")
                                            .removeHeader("Pragma")
                                            .build()
                                    }
                                }
                            }
                            
                            // 网络缓存拦截器（在线缓存）
                            class NetworkCacheInterceptor : Interceptor {
                                override fun intercept(chain: Interceptor.Chain): Response {
                                    val response = chain.proceed(chain.request())
                                    
                                    return response.newBuilder()
                                        .header("Cache-Control", "public, max-age=3600")
                                        .build()
                                }
                            }
                        }
                        
                        // 本地缓存（Room数据库）
                        @Entity
                        data class CacheEntity(
                            @PrimaryKey val key: String,
                            val data: String,
                            val timestamp: Long
                        )
                        
                        @Dao
                        interface CacheDao {
                            @Query("SELECT * FROM cache WHERE key = :key AND timestamp > :expireTime")
                            suspend fun get(key: String, expireTime: Long): CacheEntity?
                            
                            @Insert(onConflict = OnConflictStrategy.REPLACE)
                            suspend fun insert(cache: CacheEntity)
                            
                            @Query("DELETE FROM cache WHERE timestamp < :expireTime")
                            suspend fun deleteExpired(expireTime: Long)
                        }
                    """.trimIndent(),
                    explanation = "缓存策略包括HTTP缓存和本地缓存。使用OkHttp的Cache实现HTTP缓存，使用拦截器控制缓存策略。使用Room数据库实现本地缓存，支持离线访问。"
                ),
                CodeExample(
                    title = "示例3：数据压缩和连接复用",
                    code = """
                        // 使用Gzip压缩
                        class CompressionInterceptor : Interceptor {
                            override fun intercept(chain: Interceptor.Chain): Response {
                                val request = chain.request()
                                
                                // 请求压缩
                                val compressedRequest = request.newBuilder()
                                    .header("Accept-Encoding", "gzip")
                                    .build()
                                
                                val response = chain.proceed(compressedRequest)
                                
                                // 解压响应
                                if (response.headers["Content-Encoding"] == "gzip") {
                                    val gzipSource = GzipSource(response.body!!.source())
                                    val decompressedBody = ResponseBody.create(
                                        response.body!!.contentType(),
                                        -1,
                                        gzipSource.buffer()
                                    )
                                    return response.newBuilder()
                                        .body(decompressedBody)
                                        .removeHeader("Content-Encoding")
                                        .removeHeader("Content-Length")
                                        .build()
                                }
                                
                                return response
                            }
                        }
                        
                        // 连接复用（OkHttp自动处理）
                        class ConnectionReuse {
                            
                            fun createClient(): OkHttpClient {
                                return OkHttpClient.Builder()
                                    .connectionPool(ConnectionPool(5, 5, TimeUnit.MINUTES))
                                    .build()
                            }
                            
                            // OkHttp自动复用连接，无需手动处理
                            // ConnectionPool管理连接池，自动复用连接
                        }
                        
                        // 使用Protobuf减少数据大小
                        data class User(
                            val id: Int,
                            val name: String,
                            val email: String
                        )
                        
                        // Protobuf定义
                        // syntax = "proto3";
                        // message User {
                        //     int32 id = 1;
                        //     string name = 2;
                        //     string email = 3;
                        // }
                        
                        // 使用Retrofit转换器
                        // val retrofit = Retrofit.Builder()
                        //     .baseUrl("https://api.example.com/")
                        //     .addConverterFactory(ProtoConverterFactory.create())
                        //     .build()
                    """.trimIndent(),
                    explanation = "数据压缩可以减少传输数据量，使用Gzip压缩请求和响应。OkHttp自动复用连接，使用ConnectionPool管理连接池。使用Protobuf可以减少数据大小。"
                ),
                CodeExample(
                    title = "示例4：请求优先级和离线策略",
                    code = """
                        // 请求优先级
                        class PriorityInterceptor : Interceptor {
                            override fun intercept(chain: Interceptor.Chain): Response {
                                val request = chain.request()
                                
                                // 根据请求类型设置优先级
                                val priority = when {
                                    request.url.encodedPath.contains("/user") -> Priority.HIGH
                                    request.url.encodedPath.contains("/image") -> Priority.LOW
                                    else -> Priority.NORMAL
                                }
                                
                                val newRequest = request.newBuilder()
                                    .header("X-Priority", priority.name)
                                    .build()
                                
                                return chain.proceed(newRequest)
                            }
                        }
                        
                        // 离线策略
                        class OfflineStrategy {
                            
                            suspend fun loadData(forceRefresh: Boolean = false): Result<Data> {
                                // 先尝试从缓存加载
                                if (!forceRefresh) {
                                    val cachedData = getCachedData()
                                    if (cachedData != null) {
                                        return Result.success(cachedData)
                                    }
                                }
                                
                                // 从网络加载
                                return try {
                                    val networkData = loadFromNetwork()
                                    
                                    // 保存到缓存
                                    saveToCache(networkData)
                                    
                                    Result.success(networkData)
                                } catch (e: Exception) {
                                    // 网络失败，使用缓存
                                    val cachedData = getCachedData()
                                    if (cachedData != null) {
                                        Result.success(cachedData)
                                    } else {
                                        Result.failure(e)
                                    }
                                }
                            }
                            
                            // 使用WorkManager后台同步
                            class SyncWorker(context: Context, params: WorkerParameters) : 
                                CoroutineWorker(context, params) {
                                
                                override suspend fun doWork(): Result {
                                    return try {
                                        // 同步数据
                                        syncData()
                                        Result.success()
                                    } catch (e: Exception) {
                                        Result.retry()
                                    }
                                }
                            }
                        }
                    """.trimIndent(),
                    explanation = "请求优先级可以根据请求类型设置优先级，优先加载关键数据。离线策略包括先使用缓存、网络失败时使用缓存、使用WorkManager后台同步等。"
                )
            ),
            useCases = listOf(
                "请求优化：减少请求次数，合并请求",
                "缓存策略：使用HTTP缓存和本地缓存",
                "数据压缩：压缩请求和响应数据",
                "连接复用：复用HTTP连接，减少连接开销",
                "离线策略：实现离线缓存，支持离线访问"
            ),
            notes = listOf(
                "网络性能优化可以减少网络请求时间",
                "减少请求次数，合并请求",
                "使用HTTP缓存和本地缓存",
                "压缩数据可以减少传输数据量",
                "OkHttp自动复用连接",
                "设置请求优先级，优先加载关键数据",
                "实现离线缓存，支持离线访问"
            ),
            practiceTips = "建议减少请求次数，合并请求。使用HTTP缓存和本地缓存，提升响应速度。压缩数据，减少传输数据量。OkHttp自动复用连接，无需手动处理。设置请求优先级，优先加载关键数据。实现离线缓存，支持离线访问。"
        ),
        
        KnowledgeDetail(
            id = "battery_opt",
            title = "电池优化",
            overview = "电池优化可以延长设备电池寿命，提升用户体验。优化后台任务、减少唤醒、使用JobScheduler等可以显著减少电池消耗。",
            keyPoints = listOf(
                "后台任务：优化后台任务，减少电池消耗",
                "唤醒锁：减少唤醒锁使用，及时释放",
                "JobScheduler：使用JobScheduler管理后台任务",
                "WorkManager：使用WorkManager管理后台工作",
                "定位优化：优化定位使用，减少定位频率",
                "网络优化：优化网络使用，减少网络请求"
            ),
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：后台任务优化",
                    code = """
                        // 使用WorkManager管理后台任务
                        class DataSyncWorker(context: Context, params: WorkerParameters) :
                            CoroutineWorker(context, params) {
                            
                            override suspend fun doWork(): Result {
                                return try {
                                    // 执行后台任务
                                    syncData()
                                    Result.success()
                                } catch (e: Exception) {
                                    // 失败时重试
                                    if (runAttemptCount < 3) {
                                        Result.retry()
                                    } else {
                                        Result.failure()
                                    }
                                }
                            }
                        }
                        
                        // 调度后台任务
                        class TaskScheduler {
                            
                            fun scheduleSyncWork(context: Context) {
                                val constraints = Constraints.Builder()
                                    .setRequiredNetworkType(NetworkType.CONNECTED)
                                    .setRequiresBatteryNotLow(true)
                                    .setRequiresCharging(false)
                                    .build()
                                
                                val workRequest = PeriodicWorkRequestBuilder<DataSyncWorker>(
                                    15, TimeUnit.MINUTES
                                )
                                    .setConstraints(constraints)
                                    .build()
                                
                                WorkManager.getInstance(context).enqueue(workRequest)
                            }
                            
                            // 一次性任务
                            fun scheduleOneTimeWork(context: Context) {
                                val workRequest = OneTimeWorkRequestBuilder<DataSyncWorker>()
                                    .setConstraints(constraints)
                                    .build()
                                
                                WorkManager.getInstance(context).enqueue(workRequest)
                            }
                        }
                        
                        // 使用JobScheduler（Android 5.0+）
                        class JobSchedulerExample {
                            
                            fun scheduleJob(context: Context) {
                                val jobScheduler = context.getSystemService(Context.JOB_SCHEDULER_SERVICE) 
                                    as JobScheduler
                                
                                val jobInfo = JobInfo.Builder(1, ComponentName(context, MyJobService::class.java))
                                    .setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY)
                                    .setRequiresCharging(false)
                                    .setRequiresDeviceIdle(false)
                                    .setPeriodic(15 * 60 * 1000) // 15分钟
                                    .build()
                                
                                jobScheduler.schedule(jobInfo)
                            }
                        }
                    """.trimIndent(),
                    explanation = "使用WorkManager或JobScheduler管理后台任务，可以优化电池使用。设置约束条件，如网络连接、电池状态等，避免在不合适的时机执行任务。"
                ),
                CodeExample(
                    title = "示例2：唤醒锁优化",
                    code = """
                        class WakeLockManager {
                            
                            private var wakeLock: PowerManager.WakeLock? = null
                            
                            fun acquireWakeLock(context: Context) {
                                val powerManager = context.getSystemService(Context.POWER_SERVICE) as PowerManager
                                
                                // 使用PARTIAL_WAKE_LOCK，最小化电池消耗
                                wakeLock = powerManager.newWakeLock(
                                    PowerManager.PARTIAL_WAKE_LOCK,
                                    "MyApp::WakeLock"
                                )
                                
                                // 设置超时，自动释放
                                wakeLock?.acquire(10 * 60 * 1000L) // 10分钟
                            }
                            
                            fun releaseWakeLock() {
                                wakeLock?.let {
                                    if (it.isHeld) {
                                        it.release()
                                    }
                                }
                                wakeLock = null
                            }
                            
                            // 使用WakefulBroadcastReceiver（已废弃，使用WorkManager替代）
                            // 或使用ForegroundService
                        }
                        
                        // 避免长时间持有WakeLock
                        class OptimizedWakeLock {
                            
                            fun performTask(context: Context) {
                                val wakeLock = acquireWakeLock(context)
                                
                                try {
                                    // 执行任务
                                    performTask()
                                } finally {
                                    // 确保释放WakeLock
                                    releaseWakeLock(wakeLock)
                                }
                            }
                        }
                    """.trimIndent(),
                    explanation = "唤醒锁会消耗电池，需要优化使用。使用PARTIAL_WAKE_LOCK最小化电池消耗，设置超时自动释放，及时释放不需要的WakeLock。"
                ),
                CodeExample(
                    title = "示例3：定位优化",
                    code = """
                        class LocationManager {
                            
                            private val locationClient: FusedLocationProviderClient
                            
                            init {
                                locationClient = LocationServices.getFusedLocationProviderClient(context)
                            }
                            
                            // 优化定位请求
                            fun requestLocationUpdates() {
                                val locationRequest = LocationRequest.Builder(
                                    Priority.PRIORITY_BALANCED_POWER_ACCURACY, // 平衡精度和电池
                                    10000L // 10秒
                                )
                                    .setMaxUpdateDelayMillis(20000) // 最大延迟20秒
                                    .setWaitForAccurateLocation(false) // 不等待高精度定位
                                    .build()
                                
                                val locationCallback = object : LocationCallback() {
                                    override fun onLocationResult(result: LocationResult) {
                                        // 处理定位结果
                                        val location = result.lastLocation
                                    }
                                }
                                
                                if (ActivityCompat.checkSelfPermission(
                                        context,
                                        Manifest.permission.ACCESS_FINE_LOCATION
                                    ) == PackageManager.PERMISSION_GRANTED
                                ) {
                                    locationClient.requestLocationUpdates(
                                        locationRequest,
                                        locationCallback,
                                        Looper.getMainLooper()
                                    )
                                }
                            }
                            
                            // 停止定位更新
                            fun stopLocationUpdates() {
                                locationClient.removeLocationUpdates(locationCallback)
                            }
                            
                            // 使用单次定位
                            fun getLastLocation() {
                                locationClient.lastLocation.addOnSuccessListener { location ->
                                    // 使用最后已知位置
                                }
                            }
                        }
                    """.trimIndent(),
                    explanation = "定位是电池消耗的主要来源。使用PRIORITY_BALANCED_POWER_ACCURACY平衡精度和电池，设置合理的更新间隔，及时停止定位更新，使用单次定位替代持续定位。"
                ),
                CodeExample(
                    title = "示例4：网络和传感器优化",
                    code = """
                        // 网络优化
                        class NetworkOptimizer {
                            
                            // 批量网络请求
                            fun batchNetworkRequests() {
                                // 合并多个请求为一个
                                // 减少网络唤醒次数
                            }
                            
                            // 使用推送替代轮询
                            fun usePushInsteadOfPolling() {
                                // 使用FCM推送替代定时轮询
                                // 减少网络请求，节省电池
                            }
                        }
                        
                        // 传感器优化
                        class SensorOptimizer {
                            
                            private var sensorManager: SensorManager? = null
                            private var sensor: Sensor? = null
                            
                            fun registerSensor() {
                                sensorManager = context.getSystemService(Context.SENSOR_SERVICE) as SensorManager
                                sensor = sensorManager?.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
                                
                                // 设置采样率，减少电池消耗
                                sensorManager?.registerListener(
                                    sensorListener,
                                    sensor,
                                    SensorManager.SENSOR_DELAY_NORMAL // 正常延迟
                                )
                            }
                            
                            fun unregisterSensor() {
                                sensorManager?.unregisterListener(sensorListener)
                            }
                            
                            private val sensorListener = object : SensorEventListener {
                                override fun onSensorChanged(event: SensorEvent) {
                                    // 处理传感器数据
                                }
                                
                                override fun onAccuracyChanged(sensor: Sensor, accuracy: Int) {
                                    // 精度变化
                                }
                            }
                        }
                        
                        // 使用Battery Historian分析电池使用
                        // adb shell dumpsys batterystats > batterystats.txt
                        // 使用Battery Historian工具分析
                    """.trimIndent(),
                    explanation = "网络和传感器优化可以减少电池消耗。批量网络请求，使用推送替代轮询，优化传感器采样率，及时注销传感器监听器。使用Battery Historian分析电池使用情况。"
                )
            ),
            useCases = listOf(
                "后台任务优化：优化后台任务，减少电池消耗",
                "唤醒锁优化：减少唤醒锁使用，及时释放",
                "定位优化：优化定位使用，减少定位频率",
                "网络优化：优化网络使用，减少网络请求",
                "传感器优化：优化传感器使用，减少电池消耗"
            ),
            notes = listOf(
                "电池优化可以延长设备电池寿命",
                "使用WorkManager或JobScheduler管理后台任务",
                "减少唤醒锁使用，及时释放",
                "优化定位使用，减少定位频率",
                "批量网络请求，使用推送替代轮询",
                "优化传感器采样率，及时注销监听器",
                "使用Battery Historian分析电池使用"
            ),
            practiceTips = "建议使用WorkManager或JobScheduler管理后台任务，设置约束条件。减少唤醒锁使用，及时释放。优化定位使用，使用PRIORITY_BALANCED_POWER_ACCURACY。批量网络请求，使用推送替代轮询。优化传感器采样率，及时注销监听器。使用Battery Historian分析电池使用情况。"
        ),
        
        KnowledgeDetail(
            id = "apk_size",
            title = "包体积优化",
            overview = "包体积优化可以减少APK大小，提升下载和安装速度。优化资源、代码混淆、使用App Bundle等可以显著减小APK体积。",
            keyPoints = listOf(
                "资源优化：优化图片、音频等资源文件",
                "代码优化：移除未使用的代码，使用ProGuard/R8",
                "App Bundle：使用Android App Bundle减小包体积",
                "动态加载：使用动态加载，按需加载功能",
                "资源压缩：压缩资源文件，减少体积",
                "多APK：使用多APK支持不同架构"
            ),
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：资源优化",
                    code = """
                        // 1. 优化图片资源
                        // - 使用WebP格式替代PNG/JPG
                        // - 使用Vector Drawable替代位图
                        // - 移除未使用的图片资源
                        
                        // 2. 使用Vector Drawable
                        // res/drawable/ic_arrow.xml
                        // <vector xmlns:android="http://schemas.android.com/apk/res/android"
                        //     android:width="24dp"
                        //     android:height="24dp"
                        //     android:viewportWidth="24"
                        //     android:viewportHeight="24">
                        //     <path
                        //         android:fillColor="#FF000000"
                        //         android:pathData="M12,4l-1.41,1.41L16.17,11H4v2h12.17l-5.58,5.59L12,20l8,-8z"/>
                        // </vector>
                        
                        // 3. 移除未使用的资源
                        // 在build.gradle中启用资源清理
                        android {
                            buildTypes {
                                release {
                                    shrinkResources = true // 移除未使用的资源
                                    minifyEnabled = true
                                }
                            }
                        }
                        
                        // 4. 使用资源别名
                        // res/values/strings.xml
                        // <string name="app_name">MyApp</string>
                        // res/values-zh/strings.xml
                        // <string name="app_name">我的应用</string>
                        
                        // 5. 优化音频资源
                        // - 使用压缩格式（如MP3）
                        // - 降低采样率
                        // - 移除未使用的音频
                    """.trimIndent(),
                    explanation = "资源优化包括优化图片、使用Vector Drawable、移除未使用的资源、使用资源别名等。启用shrinkResources可以自动移除未使用的资源。"
                ),
                CodeExample(
                    title = "示例2：代码优化",
                    code = """
                        // 1. 使用ProGuard/R8混淆和优化
                        android {
                            buildTypes {
                                release {
                                    minifyEnabled = true // 启用代码混淆
                                    shrinkResources = true // 移除未使用的资源
                                    proguardFiles(
                                        getDefaultProguardFile("proguard-android-optimize.txt"),
                                        "proguard-rules.pro"
                                    )
                                }
                            }
                        }
                        
                        // 2. ProGuard规则
                        // proguard-rules.pro
                        # 保留必要的类
                        -keep class com.example.MyClass { *; }
                        
                        # 移除日志
                        -assumenosideeffects class android.util.Log {
                            public static *** d(...);
                            public static *** v(...);
                        }
                        
                        # 优化
                        -optimizationpasses 5
                        -dontusemixedcaseclassnames
                        -dontskipnonpubliclibraryclasses
                        
                        // 3. 移除未使用的依赖
                        // 使用Android Studio的Analyze > Inspect Code
                        // 或使用工具检查未使用的依赖
                        
                        // 4. 使用代码分析工具
                        // - Lint检查未使用的代码
                        // - 使用ProGuard/R8自动移除未使用的代码
                        
                        // 5. 使用Kotlin的优化
                        // - 使用inline函数减少方法数
                        // - 使用data class减少代码量
                    """.trimIndent(),
                    explanation = "代码优化包括使用ProGuard/R8混淆和优化、移除未使用的依赖、使用代码分析工具等。启用minifyEnabled可以自动移除未使用的代码。"
                ),
                CodeExample(
                    title = "示例3：App Bundle和动态加载",
                    code = """
                        // 1. 使用Android App Bundle
                        // build.gradle
                        android {
                            bundle {
                                language {
                                    enableSplit = true // 按语言拆分
                                }
                                density {
                                    enableSplit = true // 按密度拆分
                                }
                                abi {
                                    enableSplit = true // 按架构拆分
                                }
                            }
                        }
                        
                        // 2. 构建App Bundle
                        // ./gradlew bundleRelease
                        // 生成app-release.aab文件
                        
                        // 3. 使用Dynamic Feature Modules
                        // 创建动态功能模块
                        // File > New > New Module > Dynamic Feature Module
                        
                        // 4. 动态加载功能
                        class DynamicFeatureLoader {
                            
                            suspend fun loadFeature(moduleName: String): Boolean {
                                val splitInstallManager = SplitInstallManagerFactory.create(context)
                                
                                val request = SplitInstallRequest.newBuilder()
                                    .addModule(moduleName)
                                    .build()
                                
                                return try {
                                    splitInstallManager.startInstall(request)
                                    true
                                } catch (e: Exception) {
                                    false
                                }
                            }
                            
                            fun checkFeatureInstalled(moduleName: String): Boolean {
                                val splitInstallManager = SplitInstallManagerFactory.create(context)
                                return splitInstallManager.installedModules.contains(moduleName)
                            }
                        }
                        
                        // 5. 使用Play Core Library
                        // implementation "com.google.android.play:core:1.10.3"
                        // implementation "com.google.android.play:core-ktx:1.8.1"
                    """.trimIndent(),
                    explanation = "使用Android App Bundle可以减小包体积，Google Play会根据设备特性只下载需要的资源。使用Dynamic Feature Modules可以按需加载功能模块。"
                ),
                CodeExample(
                    title = "示例4：多APK和资源压缩",
                    code = """
                        // 1. 使用多APK支持不同架构
                        android {
                            splits {
                                abi {
                                    isEnable = true
                                    reset()
                                    include("armeabi-v7a", "arm64-v8a", "x86", "x86_64")
                                    isUniversalApk = false
                                }
                            }
                        }
                        
                        // 2. 资源压缩
                        android {
                            aaptOptions {
                                // 压缩PNG文件
                                cruncherEnabled = true
                                
                                // 不压缩特定文件
                                noCompress("tflite", "lite")
                            }
                        }
                        
                        // 3. 使用资源压缩工具
                        // - pngquant: 压缩PNG
                        // - zopflipng: 压缩PNG
                        // - webp: 转换为WebP
                        
                        // 4. 分析APK大小
                        // Android Studio > Build > Analyze APK
                        // 查看APK各部分大小
                        
                        // 5. 使用APK Analyzer
                        // Tools > Android > APK Analyzer
                        // 分析APK组成，找出占用空间大的文件
                        
                        // 6. 移除调试信息
                        android {
                            buildTypes {
                                release {
                                    // 移除调试信息
                                    debuggable = false
                                    
                                    // 移除行号信息
                                    minifyEnabled = true
                                }
                            }
                        }
                    """.trimIndent(),
                    explanation = "使用多APK可以支持不同架构，减小单个APK大小。使用资源压缩工具压缩资源文件。使用APK Analyzer分析APK大小，找出占用空间大的文件。"
                )
            ),
            useCases = listOf(
                "资源优化：优化图片、音频等资源文件",
                "代码优化：移除未使用的代码，使用ProGuard/R8",
                "App Bundle：使用Android App Bundle减小包体积",
                "动态加载：使用动态加载，按需加载功能",
                "多APK：使用多APK支持不同架构"
            ),
            notes = listOf(
                "包体积优化可以减少APK大小",
                "优化资源，使用WebP和Vector Drawable",
                "使用ProGuard/R8移除未使用的代码",
                "使用Android App Bundle减小包体积",
                "使用Dynamic Feature Modules按需加载功能",
                "使用多APK支持不同架构",
                "使用APK Analyzer分析APK大小"
            ),
            practiceTips = "建议优化资源，使用WebP和Vector Drawable。使用ProGuard/R8移除未使用的代码。使用Android App Bundle减小包体积，Google Play会根据设备特性只下载需要的资源。使用Dynamic Feature Modules按需加载功能。使用多APK支持不同架构。使用APK Analyzer分析APK大小，找出占用空间大的文件。"
        ),
        
        // ========== 依赖注入 ==========
        
        KnowledgeDetail(
            id = "di_basics",
            title = "依赖注入基础概念",
            overview = "依赖注入（Dependency Injection，DI）是一种设计模式，通过外部提供依赖对象，而不是在类内部创建。这种模式可以降低类之间的耦合度，提高代码的可测试性和可维护性。",
            keyPoints = listOf(
                "依赖注入的核心思想：控制反转（IoC），将依赖的创建和管理交给外部容器",
                "依赖注入的优势：降低耦合度、提高可测试性、便于维护和扩展",
                "依赖注入的三种方式：构造函数注入、字段注入、方法注入",
                "依赖注入容器：负责创建和管理依赖对象的生命周期",
                "依赖注入框架：如Dagger、Hilt、Koin等，简化依赖注入的实现"
            ),
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：不使用依赖注入的问题",
                    code = """
                        // 问题：类内部直接创建依赖，耦合度高
                        class UserService {
                            private val userRepository = UserRepository() // 硬编码依赖
                            
                            fun getUser(id: String): User {
                                return userRepository.getUser(id)
                            }
                        }
                        
                        // 问题：
                        // 1. 无法替换UserRepository的实现（如用于测试）
                        // 2. UserService和UserRepository紧密耦合
                        // 3. 难以进行单元测试
                    """.trimIndent(),
                    explanation = "直接在类内部创建依赖会导致高耦合，难以测试和扩展。"
                ),
                CodeExample(
                    title = "示例2：使用依赖注入",
                    code = """
                        // 解决方案：通过构造函数注入依赖
                        class UserService(
                            private val userRepository: UserRepository // 依赖注入
                        ) {
                            fun getUser(id: String): User {
                                return userRepository.getUser(id)
                            }
                        }
                        
                        // 使用：
                        val userRepository = UserRepository()
                        val userService = UserService(userRepository) // 注入依赖
                        
                        // 优势：
                        // 1. 可以轻松替换UserRepository的实现
                        // 2. 便于单元测试（可以注入Mock对象）
                        // 3. UserService和UserRepository解耦
                    """.trimIndent(),
                    explanation = "通过构造函数注入依赖，将依赖的创建交给外部，降低耦合度。"
                ),
                CodeExample(
                    title = "示例3：接口抽象进一步解耦",
                    code = """
                        // 定义接口
                        interface UserRepository {
                            fun getUser(id: String): User
                        }
                        
                        // 实现类
                        class DatabaseUserRepository : UserRepository {
                            override fun getUser(id: String): User {
                                // 从数据库获取用户
                                return database.getUser(id)
                            }
                        }
                        
                        class NetworkUserRepository : UserRepository {
                            override fun getUser(id: String): User {
                                // 从网络获取用户
                                return api.getUser(id)
                            }
                        }
                        
                        // 使用接口注入
                        class UserService(
                            private val userRepository: UserRepository // 依赖接口，不依赖具体实现
                        ) {
                            fun getUser(id: String): User {
                                return userRepository.getUser(id)
                            }
                        }
                        
                        // 可以轻松切换实现
                        val dbRepo = DatabaseUserRepository()
                        val networkRepo = NetworkUserRepository()
                        val service1 = UserService(dbRepo)      // 使用数据库实现
                        val service2 = UserService(networkRepo) // 使用网络实现
                    """.trimIndent(),
                    explanation = "使用接口抽象可以进一步解耦，允许在不同实现之间切换。"
                )
            ),
            useCases = listOf(
                "降低耦合度：通过依赖注入减少类之间的直接依赖",
                "提高可测试性：可以轻松注入Mock对象进行单元测试",
                "便于维护：修改依赖实现不影响使用它的类",
                "支持多态：通过接口注入，可以在运行时切换不同的实现",
                "生命周期管理：依赖注入框架可以管理对象的生命周期"
            ),
            notes = listOf(
                "依赖注入不是银弹，过度使用会增加代码复杂度",
                "对于简单的依赖，手动注入即可，不需要框架",
                "依赖注入框架会增加编译时间和代码生成",
                "构造函数注入是推荐的方式，字段注入要谨慎使用",
                "注意循环依赖问题，避免A依赖B，B依赖A的情况"
            ),
            practiceTips = "建议优先使用构造函数注入，它最清晰且便于测试。对于Android开发，推荐使用Hilt（基于Dagger），它专门为Android设计，简化了配置。在小型项目中，手动依赖注入就足够了，不需要引入框架。"
        ),
        
        KnowledgeDetail(
            id = "hilt_di",
            title = "Hilt依赖注入框架",
            overview = "Hilt是Google官方推荐的Android依赖注入框架，基于Dagger构建，专门为Android设计。Hilt简化了Dagger的配置，提供了标准的Android组件作用域，让依赖注入在Android开发中更加简单易用。",
            keyPoints = listOf(
                "Hilt基于Dagger：使用Dagger的注解处理器，但简化了配置",
                "Application级别注入：使用@HiltAndroidApp标记Application类",
                "组件作用域：@Singleton（应用级）、@ActivityRetainedScope（ViewModel级）等",
                "模块提供依赖：使用@Module和@Provides注解提供依赖",
                "自动注入：使用@AndroidEntryPoint标记Activity、Fragment等，自动注入依赖"
            ),
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：Hilt基础配置",
                    code = """
                        // 1. 在Application类上添加@HiltAndroidApp
                        @HiltAndroidApp
                        class MyApplication : Application() {
                            override fun onCreate() {
                                super.onCreate()
                            }
                        }
                        
                        // 2. 在AndroidManifest.xml中注册
                        // <application
                        //     android:name=".MyApplication"
                        //     ...>
                        
                        // 3. 创建Module提供依赖
                        @Module
                        @InstallIn(SingletonComponent::class)
                        object AppModule {
                            @Provides
                            @Singleton
                            fun provideUserRepository(): UserRepository {
                                return UserRepository()
                            }
                        }
                        
                        // 4. 在Activity中使用
                        @AndroidEntryPoint
                        class MainActivity : AppCompatActivity() {
                            @Inject
                            lateinit var userRepository: UserRepository
                            
                            override fun onCreate(savedInstanceState: Bundle?) {
                                super.onCreate(savedInstanceState)
                                // userRepository已经被自动注入
                            }
                        }
                    """.trimIndent(),
                    explanation = "Hilt的基本配置包括：标记Application、创建Module、在Activity中使用@AndroidEntryPoint和@Inject。"
                ),
                CodeExample(
                    title = "示例2：构造函数注入",
                    code = """
                        // 使用@Inject标记构造函数，Hilt会自动提供依赖
                        class UserRepository @Inject constructor(
                            private val api: ApiService,
                            private val database: AppDatabase
                        ) {
                            fun getUser(id: String): User {
                                // 使用注入的依赖
                                return api.getUser(id)
                            }
                        }
                        
                        // Hilt会自动创建UserRepository实例
                        // 并注入ApiService和AppDatabase
                        
                        // 在Activity中使用
                        @AndroidEntryPoint
                        class MainActivity : AppCompatActivity() {
                            @Inject
                            lateinit var userRepository: UserRepository
                            
                            // userRepository已经包含了注入的api和database
                        }
                    """.trimIndent(),
                    explanation = "使用@Inject标记构造函数，Hilt会自动解析依赖并创建实例。"
                ),
                CodeExample(
                    title = "示例3：接口绑定",
                    code = """
                        // 定义接口
                        interface ApiService {
                            fun getUser(id: String): User
                        }
                        
                        // 实现类
                        class RetrofitApiService @Inject constructor(
                            private val retrofit: Retrofit
                        ) : ApiService {
                            override fun getUser(id: String): User {
                                return retrofit.create(ApiService::class.java).getUser(id)
                            }
                        }
                        
                        // 使用@Binds绑定接口和实现
                        @Module
                        @InstallIn(SingletonComponent::class)
                        abstract class ApiModule {
                            @Binds
                            @Singleton
                            abstract fun bindApiService(
                                retrofitApiService: RetrofitApiService
                            ): ApiService
                        }
                        
                        // 使用：注入接口类型
                        class UserRepository @Inject constructor(
                            private val apiService: ApiService // 注入接口
                        ) {
                            // Hilt会自动提供RetrofitApiService实例
                        }
                    """.trimIndent(),
                    explanation = "使用@Binds可以将接口绑定到具体实现，注入时使用接口类型。"
                ),
                CodeExample(
                    title = "示例4：ViewModel注入",
                    code = """
                        // 使用@HiltViewModel标记ViewModel
                        @HiltViewModel
                        class UserViewModel @Inject constructor(
                            private val userRepository: UserRepository
                        ) : ViewModel() {
                            private val _users = MutableStateFlow<List<User>>(emptyList())
                            val users: StateFlow<List<User>> = _users
                            
                            fun loadUsers() {
                                viewModelScope.launch {
                                    _users.value = userRepository.getAllUsers()
                                }
                            }
                        }
                        
                        // 在Activity或Fragment中使用
                        @AndroidEntryPoint
                        class MainActivity : AppCompatActivity() {
                            private val viewModel: UserViewModel by viewModels()
                            
                            override fun onCreate(savedInstanceState: Bundle?) {
                                super.onCreate(savedInstanceState)
                                viewModel.loadUsers()
                            }
                        }
                    """.trimIndent(),
                    explanation = "使用@HiltViewModel标记ViewModel，Hilt会自动注入依赖，然后使用by viewModels()获取实例。"
                )
            ),
            useCases = listOf(
                "Android应用开发：Hilt是Android官方推荐的依赖注入框架",
                "大型项目：管理复杂的依赖关系，提高代码可维护性",
                "单元测试：可以轻松注入Mock对象进行测试",
                "多环境配置：可以为不同环境提供不同的依赖实现",
                "生命周期管理：Hilt自动管理依赖的生命周期，避免内存泄漏"
            ),
            notes = listOf(
                "Hilt需要Kapt或KSP支持，会增加编译时间",
                "使用@Singleton时要小心，确保对象是线程安全的",
                "@AndroidEntryPoint只能用于Android组件（Activity、Fragment等）",
                "Hilt不支持注入私有字段，字段必须是public或internal",
                "注意作用域，不同作用域的依赖不能相互注入"
            ),
            practiceTips = "建议在项目开始时就引入Hilt，而不是后期重构。使用@Singleton要谨慎，确保对象确实是单例且线程安全。优先使用构造函数注入，字段注入只用于Android组件。使用接口绑定提高灵活性，便于测试和切换实现。"
        ),
        
        KnowledgeDetail(
            id = "di_methods",
            title = "依赖注入的三种方式",
            overview = "依赖注入有三种主要方式：构造函数注入、字段注入和方法注入。每种方式都有其适用场景，理解它们的区别和优缺点有助于选择合适的方式。",
            keyPoints = listOf(
                "构造函数注入：通过构造函数参数注入依赖，最推荐的方式",
                "字段注入：直接注入到字段中，适用于Android组件",
                "方法注入：通过方法参数注入依赖，适用于需要动态注入的场景",
                "选择原则：优先使用构造函数注入，字段注入用于Android组件，方法注入用于特殊场景"
            ),
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：构造函数注入（推荐）",
                    code = """
                        // 构造函数注入：通过构造函数参数注入依赖
                        class UserService @Inject constructor(
                            private val userRepository: UserRepository,
                            private val logger: Logger
                        ) {
                            fun getUser(id: String): User {
                                logger.log("Getting user: ${'$'}id")
                                return userRepository.getUser(id)
                            }
                        }
                        
                        // 优点：
                        // 1. 依赖关系明确，一目了然
                        // 2. 不可变（使用val），线程安全
                        // 3. 便于单元测试
                        // 4. 编译时就能发现依赖缺失
                        
                        // 缺点：
                        // 1. 构造函数参数过多时不够优雅
                        // 2. 不能用于Android组件（Activity、Fragment等）
                    """.trimIndent(),
                    explanation = "构造函数注入是最推荐的方式，依赖关系清晰，便于测试。"
                ),
                CodeExample(
                    title = "示例2：字段注入（Android组件）",
                    code = """
                        // 字段注入：直接注入到字段中
                        @AndroidEntryPoint
                        class MainActivity : AppCompatActivity() {
                            @Inject
                            lateinit var userRepository: UserRepository
                            
                            @Inject
                            lateinit var apiService: ApiService
                            
                            override fun onCreate(savedInstanceState: Bundle?) {
                                super.onCreate(savedInstanceState)
                                // 此时userRepository和apiService已经被注入
                                
                                // 注意：必须在super.onCreate()之后使用
                                // 因为Hilt在super.onCreate()中完成注入
                            }
                            
                            private fun loadData() {
                                // 使用注入的依赖
                                viewModelScope.launch {
                                    val user = userRepository.getUser("123")
                                }
                            }
                        }
                        
                        // 优点：
                        // 1. 适用于Android组件（Activity、Fragment等）
                        // 2. 不需要修改构造函数
                        
                        // 缺点：
                        // 1. 字段必须是lateinit var，不够安全
                        // 2. 运行时才能发现依赖缺失
                        // 3. 不能使用val，不够不可变
                    """.trimIndent(),
                    explanation = "字段注入适用于Android组件，但要注意在super.onCreate()之后才能使用。"
                ),
                CodeExample(
                    title = "示例3：方法注入（特殊场景）",
                    code = """
                        // 方法注入：通过方法参数注入依赖
                        class DataProcessor {
                            private lateinit var formatter: DataFormatter
                            private lateinit var validator: DataValidator
                            
                            // 方法注入：通过方法参数注入
                            @Inject
                            fun initialize(
                                formatter: DataFormatter,
                                validator: DataValidator
                            ) {
                                this.formatter = formatter
                                this.validator = validator
                            }
                            
                            fun process(data: String): String {
                                // 使用注入的依赖
                                if (validator.isValid(data)) {
                                    return formatter.format(data)
                                }
                                return ""
                            }
                        }
                        
                        // 使用场景：
                        // 1. 需要在对象创建后动态注入依赖
                        // 2. 需要根据条件注入不同的依赖
                        // 3. 循环依赖的解决方案之一
                        
                        // 注意：方法注入不常用，优先考虑其他方式
                    """.trimIndent(),
                    explanation = "方法注入适用于特殊场景，如需要动态注入或解决循环依赖。"
                ),
                CodeExample(
                    title = "示例4：混合使用",
                    code = """
                        // 实际开发中，可以混合使用多种注入方式
                        class UserViewModel @Inject constructor(
                            // 构造函数注入：必需的依赖
                            private val userRepository: UserRepository
                        ) : ViewModel() {
                            
                            // 字段注入：可选的依赖（使用@Inject lateinit var）
                            @Inject
                            lateinit var analytics: AnalyticsService
                            
                            // 方法注入：需要延迟初始化的依赖
                            @Inject
                            fun setupLogger(logger: Logger) {
                                // 在特定条件下初始化
                                if (BuildConfig.DEBUG) {
                                    logger.enableDebugMode()
                                }
                            }
                            
                            fun loadUser(id: String) {
                                // 使用构造函数注入的依赖
                                viewModelScope.launch {
                                    val user = userRepository.getUser(id)
                                    
                                    // 使用字段注入的依赖
                                    analytics.trackEvent("user_loaded", user.id)
                                }
                            }
                        }
                        
                        // 最佳实践：
                        // 1. 优先使用构造函数注入
                        // 2. Android组件使用字段注入
                        // 3. 特殊场景使用方法注入
                    """.trimIndent(),
                    explanation = "实际开发中可以混合使用多种注入方式，但要遵循最佳实践。"
                )
            ),
            useCases = listOf(
                "构造函数注入：适用于大多数普通类，最推荐的方式",
                "字段注入：适用于Android组件（Activity、Fragment、Service等）",
                "方法注入：适用于需要动态注入或解决循环依赖的特殊场景",
                "混合使用：根据实际需求选择合适的注入方式"
            ),
            notes = listOf(
                "构造函数注入是最安全、最清晰的方式，优先使用",
                "字段注入的字段必须是lateinit var，运行时才能发现缺失",
                "方法注入不常用，优先考虑重构代码结构",
                "Android组件必须使用字段注入，因为无法修改构造函数",
                "注意注入时机，字段注入在super.onCreate()之后才可用"
            ),
            practiceTips = "建议优先使用构造函数注入，它最清晰且安全。Android组件（Activity、Fragment）必须使用字段注入。方法注入只用于特殊场景，如需要动态注入或解决循环依赖。在实际开发中，大多数情况下构造函数注入就足够了。"
        ),
        
        KnowledgeDetail(
            id = "di_best_practices",
            title = "依赖注入最佳实践",
            overview = "依赖注入的最佳实践包括：合理使用作用域、避免循环依赖、正确管理生命周期、编写可测试的代码等。遵循这些实践可以让依赖注入发挥最大作用，提高代码质量。",
            keyPoints = listOf(
                "作用域管理：合理使用@Singleton、@ActivityRetainedScope等作用域注解",
                "避免循环依赖：通过接口抽象、延迟初始化等方式解决循环依赖",
                "生命周期管理：确保依赖的生命周期与使用它的组件匹配",
                "可测试性：使用接口抽象，便于注入Mock对象进行测试",
                "性能优化：避免不必要的单例，合理使用作用域"
            ),
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：合理使用作用域",
                    code = """
                        // 应用级单例：整个应用生命周期内只有一个实例
                        @Module
                        @InstallIn(SingletonComponent::class)
                        object AppModule {
                            @Provides
                            @Singleton
                            fun provideDatabase(): AppDatabase {
                                return Room.databaseBuilder(...).build()
                            }
                            
                            @Provides
                            @Singleton
                            fun provideApiService(): ApiService {
                                return Retrofit.Builder(...).build()
                            }
                        }
                        
                        // Activity级作用域：每个Activity一个实例
                        @Module
                        @InstallIn(ActivityComponent::class)
                        object ActivityModule {
                            @Provides
                            fun provideActivityScopedData(): ActivityData {
                                return ActivityData() // 每个Activity一个实例
                            }
                        }
                        
                        // ViewModel级作用域：配置变更后仍然存在
                        @Module
                        @InstallIn(ViewModelComponent::class)
                        object ViewModelModule {
                            @Provides
                            @ViewModelScoped
                            fun provideViewModelData(): ViewModelData {
                                return ViewModelData() // ViewModel生命周期内存在
                            }
                        }
                        
                        // 注意：
                        // 1. 不要过度使用@Singleton
                        // 2. 确保单例对象是线程安全的
                        // 3. 根据实际需求选择合适的作用域
                    """.trimIndent(),
                    explanation = "合理使用作用域可以优化内存使用，确保对象的生命周期与使用它的组件匹配。"
                ),
                CodeExample(
                    title = "示例2：避免循环依赖",
                    code = """
                        // 问题：循环依赖
                        class ServiceA @Inject constructor(
                            private val serviceB: ServiceB // A依赖B
                        )
                        
                        class ServiceB @Inject constructor(
                            private val serviceA: ServiceA // B依赖A，形成循环
                        )
                        
                        // 解决方案1：使用接口抽象
                        interface IServiceA {
                            fun doSomething()
                        }
                        
                        interface IServiceB {
                            fun doSomething()
                        }
                        
                        class ServiceA @Inject constructor(
                            private val serviceB: IServiceB // 依赖接口
                        ) : IServiceA {
                            override fun doSomething() {
                                serviceB.doSomething()
                            }
                        }
                        
                        class ServiceB @Inject constructor(
                            private val serviceA: IServiceA // 依赖接口
                        ) : IServiceB {
                            override fun doSomething() {
                                serviceA.doSomething()
                            }
                        }
                        
                        // 解决方案2：延迟初始化
                        class ServiceA @Inject constructor() {
                            @Inject
                            lateinit var serviceB: ServiceB // 延迟注入
                        }
                        
                        class ServiceB @Inject constructor(
                            private val serviceA: ServiceA
                        )
                    """.trimIndent(),
                    explanation = "通过接口抽象或延迟初始化可以解决循环依赖问题。"
                ),
                CodeExample(
                    title = "示例3：编写可测试的代码",
                    code = """
                        // 使用接口抽象，便于测试
                        interface UserRepository {
                            suspend fun getUser(id: String): User
                        }
                        
                        class DatabaseUserRepository @Inject constructor(
                            private val database: AppDatabase
                        ) : UserRepository {
                            override suspend fun getUser(id: String): User {
                                return database.userDao().getUser(id)
                            }
                        }
                        
                        // 生产代码使用真实实现
                        @Module
                        @InstallIn(SingletonComponent::class)
                        object RepositoryModule {
                            @Provides
                            @Singleton
                            fun provideUserRepository(
                                database: AppDatabase
                            ): UserRepository {
                                return DatabaseUserRepository(database)
                            }
                        }
                        
                        // 测试代码使用Mock实现
                        class UserViewModelTest {
                            @Test
                            fun testLoadUser() {
                                val mockRepository = mock<UserRepository>()
                                whenever(mockRepository.getUser("123")).thenReturn(User("123", "Test"))
                                
                                val viewModel = UserViewModel(mockRepository)
                                viewModel.loadUser("123")
                                
                                // 验证行为
                                verify(mockRepository).getUser("123")
                            }
                        }
                        
                        // 优势：
                        // 1. 可以轻松注入Mock对象
                        // 2. 不依赖真实数据库或网络
                        // 3. 测试速度快，可重复
                    """.trimIndent(),
                    explanation = "使用接口抽象可以让代码更容易测试，可以轻松注入Mock对象。"
                ),
                CodeExample(
                    title = "示例4：性能优化",
                    code = """
                        // 避免不必要的单例
                        // 错误：每个请求都创建新实例，但标记为单例
                        @Singleton
                        class RequestProcessor @Inject constructor() {
                            fun process(request: Request) {
                                // 处理请求
                            }
                        }
                        
                        // 正确：如果不需要单例，不要使用@Singleton
                        class RequestProcessor @Inject constructor() {
                            fun process(request: Request) {
                                // 处理请求
                            }
                        }
                        
                        // 使用Lazy延迟初始化
                        class HeavyService @Inject constructor() {
                            init {
                                // 初始化很耗时
                                Thread.sleep(1000)
                            }
                        }
                        
                        class UserService @Inject constructor(
                            private val heavyService: Lazy<HeavyService> // 延迟初始化
                        ) {
                            fun doSomething() {
                                // 只有在真正需要时才初始化
                                val service = heavyService.get()
                                service.process()
                            }
                        }
                        
                        // 使用Provider按需创建
                        class UserService @Inject constructor(
                            private val processorProvider: Provider<RequestProcessor>
                        ) {
                            fun processMultipleRequests(requests: List<Request>) {
                                requests.forEach { request ->
                                    // 每次创建新实例
                                    val processor = processorProvider.get()
                                    processor.process(request)
                                }
                            }
                        }
                    """.trimIndent(),
                    explanation = "合理使用作用域、Lazy和Provider可以优化性能，避免不必要的对象创建。"
                )
            ),
            useCases = listOf(
                "大型项目：管理复杂的依赖关系，提高代码质量",
                "团队协作：统一的依赖注入规范，提高代码可维护性",
                "单元测试：通过依赖注入轻松进行单元测试",
                "性能优化：合理使用作用域和延迟初始化优化性能",
                "代码重构：依赖注入使代码更容易重构和扩展"
            ),
            notes = listOf(
                "不要过度使用@Singleton，确保对象确实是单例且线程安全",
                "避免循环依赖，通过接口抽象或延迟初始化解决",
                "使用接口抽象提高可测试性，便于注入Mock对象",
                "注意依赖的生命周期，确保与使用它的组件匹配",
                "合理使用Lazy和Provider优化性能，避免不必要的对象创建"
            ),
            practiceTips = "建议在项目开始时制定依赖注入规范，统一使用方式。优先使用构造函数注入和接口抽象，提高代码可测试性。合理使用作用域，不要过度使用@Singleton。注意避免循环依赖，通过接口抽象解决。使用Lazy和Provider优化性能，避免不必要的对象创建。"
        ),
        
        // ========== 导航 ==========
        
        KnowledgeDetail(
            id = "navigation_basic",
            title = "Navigation Component基础",
            overview = "Navigation Component是Android Jetpack组件库的一部分，用于简化应用内的导航。它提供了一个统一的框架，用于处理Fragment、Activity和Compose之间的导航，支持类型安全的参数传递、深层链接和动画转场。",
            keyPoints = listOf(
                "导航图（Navigation Graph）：定义应用的所有导航路径和目标",
                "NavController：管理导航状态，控制页面跳转和返回栈",
                "NavHost：显示当前导航目标，是导航的容器",
                "Safe Args：类型安全的参数传递，避免运行时错误",
                "导航操作（Navigation Actions）：定义从一个目标到另一个目标的导航路径"
            ),
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：基础导航配置",
                    code = """
                        // 1. 添加依赖（build.gradle）
                        dependencies {
                            implementation "androidx.navigation:navigation-fragment-ktx:2.7.6"
                            implementation "androidx.navigation:navigation-ui-ktx:2.7.6"
                        }
                        
                        // 2. 创建导航图（res/navigation/nav_graph.xml）
                        <?xml version="1.0" encoding="utf-8"?>
                        <navigation xmlns:android="http://schemas.android.com/apk/res/android"
                            xmlns:app="http://schemas.android.com/apk/res-auto"
                            android:id="@+id/nav_graph"
                            app:startDestination="@id/homeFragment">
                            
                            <!-- 定义导航目标 -->
                            <fragment
                                android:id="@+id/homeFragment"
                                android:name="com.example.HomeFragment"
                                android:label="Home">
                                <!-- 定义导航操作 -->
                                <action
                                    android:id="@+id/action_home_to_detail"
                                    app:destination="@id/detailFragment" />
                            </fragment>
                            
                            <fragment
                                android:id="@+id/detailFragment"
                                android:name="com.example.DetailFragment"
                                android:label="Detail" />
                        </navigation>
                        
                        // 3. 在Activity中设置NavHost
                        class MainActivity : AppCompatActivity() {
                            override fun onCreate(savedInstanceState: Bundle?) {
                                super.onCreate(savedInstanceState)
                                setContentView(R.layout.activity_main)
                                
                                val navController = findNavController(R.id.nav_host_fragment)
                                // 使用NavController进行导航
                            }
                        }
                    """.trimIndent(),
                    explanation = "Navigation Component的基础配置包括：添加依赖、创建导航图、在Activity中设置NavHost。"
                ),
                CodeExample(
                    title = "示例2：Fragment间导航",
                    code = """
                        // 在Fragment中使用Navigation
                        class HomeFragment : Fragment() {
                            override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
                                super.onViewCreated(view, savedInstanceState)
                                
                                // 获取NavController
                                val navController = findNavController()
                                
                                // 导航到详情页
                                button.setOnClickListener {
                                    navController.navigate(R.id.action_home_to_detail)
                                }
                                
                                // 返回上一页
                                backButton.setOnClickListener {
                                    navController.popBackStack()
                                }
                                
                                // 导航到指定目标并清除返回栈
                                navController.navigate(
                                    R.id.detailFragment,
                                    null,
                                    navOptions {
                                        popUpTo(R.id.homeFragment) {
                                            inclusive = true
                                        }
                                    }
                                )
                            }
                        }
                        
                        // 使用Kotlin DSL方式导航
                        button.setOnClickListener {
                            findNavController().navigate(
                                HomeFragmentDirections.actionHomeToDetail()
                            )
                        }
                    """.trimIndent(),
                    explanation = "在Fragment中使用findNavController()获取NavController，然后调用navigate()方法进行导航。"
                ),
                CodeExample(
                    title = "示例3：传递参数",
                    code = """
                        // 1. 在导航图中定义参数
                        <fragment
                            android:id="@+id/detailFragment"
                            android:name="com.example.DetailFragment"
                            android:label="Detail">
                            <argument
                                android:name="itemId"
                                app:argType="string" />
                            <argument
                                android:name="itemCount"
                                app:argType="integer"
                                android:defaultValue="0" />
                        </fragment>
                        
                        // 2. 使用Safe Args传递参数（推荐）
                        // 在build.gradle中添加插件
                        plugins {
                            id "androidx.navigation.safeargs.kotlin"
                        }
                        
                        // 导航时传递参数
                        val action = HomeFragmentDirections
                            .actionHomeToDetail(itemId = "123", itemCount = 10)
                        findNavController().navigate(action)
                        
                        // 3. 在目标Fragment中接收参数
                        class DetailFragment : Fragment() {
                            private val args: DetailFragmentArgs by navArgs()
                            
                            override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
                                super.onViewCreated(view, savedInstanceState)
                                
                                val itemId = args.itemId
                                val itemCount = args.itemCount
                                
                                // 使用参数
                                textView.text = "Item: ${'$'}itemId, Count: ${'$'}itemCount"
                            }
                        }
                        
                        // 4. 不使用Safe Args的方式（不推荐）
                        val bundle = Bundle().apply {
                            putString("itemId", "123")
                            putInt("itemCount", 10)
                        }
                        findNavController().navigate(R.id.detailFragment, bundle)
                    """.trimIndent(),
                    explanation = "使用Safe Args可以类型安全地传递参数，避免运行时错误。在导航图中定义参数，使用生成的Directions类传递参数，在目标Fragment中使用navArgs()接收参数。"
                )
            ),
            useCases = listOf(
                "Fragment导航：简化Fragment之间的导航和参数传递",
                "底部导航栏：与BottomNavigationView集成，实现底部导航",
                "抽屉导航：与NavigationView集成，实现侧边栏导航",
                "类型安全：使用Safe Args确保参数类型正确",
                "返回栈管理：自动管理返回栈，简化返回逻辑"
            ),
            notes = listOf(
                "Navigation Component需要AndroidX库，确保使用最新版本",
                "使用Safe Args插件可以生成类型安全的导航代码",
                "NavController的生命周期与NavHost绑定",
                "导航操作必须在导航图中定义，不能动态创建",
                "注意返回栈的管理，避免栈过深导致内存问题"
            ),
            practiceTips = "建议使用Safe Args进行参数传递，它提供了类型安全和编译时检查。将导航逻辑集中在导航图中，便于维护。使用NavOptions控制导航行为，如动画、返回栈等。对于复杂的导航场景，考虑使用嵌套导航图。"
        ),
        
        KnowledgeDetail(
            id = "navigation_compose",
            title = "Navigation Compose",
            overview = "Navigation Compose是Jetpack Compose的导航解决方案，使用声明式的方式定义导航。它提供了类型安全的路由、参数传递和深层链接支持，是Compose应用的标准导航方式。",
            keyPoints = listOf(
                "NavController：使用rememberNavController()创建，管理导航状态",
                "NavHost：定义所有可用的路由和对应的Composable函数",
                "composable：定义路由和对应的屏幕组件",
                "类型安全路由：使用sealed class或enum定义路由，避免字符串错误",
                "参数传递：通过路由参数或NavBackStackEntry传递数据"
            ),
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：基础Navigation Compose配置",
                    code = """
                        // 1. 添加依赖（build.gradle）
                        dependencies {
                            implementation "androidx.navigation:navigation-compose:2.7.6"
                        }
                        
                        // 2. 创建NavController
                        @Composable
                        fun AppNavigation() {
                            val navController = rememberNavController()
                            
                            NavHost(
                                navController = navController,
                                startDestination = "home" // 起始路由
                            ) {
                                // 定义路由
                                composable("home") {
                                    HomeScreen(
                                        onNavigateToDetail = {
                                            navController.navigate("detail")
                                        }
                                    )
                                }
                                
                                composable("detail") {
                                    DetailScreen(
                                        onNavigateBack = {
                                            navController.popBackStack()
                                        }
                                    )
                                }
                            }
                        }
                        
                        // 3. 在Activity中使用
                        class MainActivity : ComponentActivity() {
                            override fun onCreate(savedInstanceState: Bundle?) {
                                super.onCreate(savedInstanceState)
                                setContent {
                                    AppNavigation()
                                }
                            }
                        }
                    """.trimIndent(),
                    explanation = "Navigation Compose的基础配置：创建NavController、定义NavHost、使用composable定义路由。"
                ),
                CodeExample(
                    title = "示例2：类型安全路由",
                    code = """
                        // 使用sealed class定义路由（推荐）
                        sealed class Screen(val route: String) {
                            object Home : Screen("home")
                            object Detail : Screen("detail")
                            data class UserDetail(val userId: String) : Screen("user_detail/${'$'}{userId}")
                        }
                        
                        // 在NavHost中使用
                        NavHost(
                            navController = navController,
                            startDestination = Screen.Home.route
                        ) {
                            composable(Screen.Home.route) {
                                HomeScreen(
                                    onNavigateToDetail = {
                                        navController.navigate(Screen.Detail.route)
                                    }
                                )
                            }
                            
                            composable(Screen.Detail.route) {
                                DetailScreen(
                                    onNavigateBack = {
                                        navController.popBackStack()
                                    }
                                )
                            }
                            
                            // 带参数的路由
                            composable(
                                route = "user_detail/{userId}",
                                arguments = listOf(
                                    navArgument("userId") {
                                        type = NavType.StringType
                                    }
                                )
                            ) { backStackEntry ->
                                val userId = backStackEntry.arguments?.getString("userId") ?: ""
                                UserDetailScreen(
                                    userId = userId,
                                    onNavigateBack = {
                                        navController.popBackStack()
                                    }
                                )
                            }
                        }
                        
                        // 导航到带参数的路由
                        navController.navigate("user_detail/123")
                    """.trimIndent(),
                    explanation = "使用sealed class定义路由可以提供类型安全，避免字符串错误。对于带参数的路由，使用navArgument定义参数类型。"
                ),
                CodeExample(
                    title = "示例3：传递复杂参数",
                    code = """
                        // 方式1：通过路由参数传递（简单数据）
                        composable(
                            route = "detail/{itemId}/{itemName}",
                            arguments = listOf(
                                navArgument("itemId") { type = NavType.StringType },
                                navArgument("itemName") { 
                                    type = NavType.StringType
                                    nullable = true
                                }
                            )
                        ) { backStackEntry ->
                            val itemId = backStackEntry.arguments?.getString("itemId") ?: ""
                            val itemName = backStackEntry.arguments?.getString("itemName")
                            
                            DetailScreen(itemId = itemId, itemName = itemName)
                        }
                        
                        // 导航
                        navController.navigate("detail/123/ItemName")
                        
                        // 方式2：通过NavBackStackEntry传递（复杂对象）
                        // 使用ViewModel或状态管理传递复杂数据
                        @Composable
                        fun HomeScreen(
                            viewModel: HomeViewModel = hiltViewModel()
                        ) {
                            val selectedItem by viewModel.selectedItem.collectAsState()
                            
                            Button(onClick = {
                                viewModel.selectItem(Item("123", "Test"))
                                navController.navigate("detail")
                            }) {
                                Text("Navigate to Detail")
                            }
                        }
                        
                        @Composable
                        fun DetailScreen(
                            viewModel: DetailViewModel = hiltViewModel()
                        ) {
                            // 从共享的ViewModel或状态中获取数据
                            val item = viewModel.getItem()
                        }
                        
                        // 方式3：使用自定义NavType（复杂对象序列化）
                        val itemNavType = object : NavType<Item>(isNullableAllowed = false) {
                            override fun get(bundle: Bundle, key: String): Item? {
                                return bundle.getParcelable(key)
                            }
                            
                            override fun parseValue(value: String): Item {
                                // 解析JSON字符串
                                return Gson().fromJson(value, Item::class.java)
                            }
                            
                            override fun put(bundle: Bundle, key: String, value: Item) {
                                bundle.putParcelable(key, value)
                            }
                            
                            override fun getName(): String = "Item"
                        }
                    """.trimIndent(),
                    explanation = "对于简单数据，通过路由参数传递。对于复杂对象，使用ViewModel或状态管理传递，或者使用自定义NavType进行序列化。"
                ),
                CodeExample(
                    title = "示例4：导航选项和动画",
                    code = """
                        // 使用NavOptions控制导航行为
                        navController.navigate(
                            route = "detail",
                            navOptions = NavOptions.Builder()
                                .setPopUpTo("home", inclusive = false) // 清除返回栈到home
                                .setLaunchSingleTop(true) // 如果已在栈顶，不创建新实例
                                .build()
                        )
                        
                        // 使用AnimatedNavHost添加转场动画
                        AnimatedNavHost(
                            navController = navController,
                            startDestination = "home"
                        ) {
                            composable(
                                route = "home",
                                enterTransition = {
                                    slideInHorizontally(
                                        initialOffsetX = { -it },
                                        animationSpec = tween(300)
                                    )
                                },
                                exitTransition = {
                                    slideOutHorizontally(
                                        targetOffsetX = { -it },
                                        animationSpec = tween(300)
                                    )
                                }
                            ) {
                                HomeScreen()
                            }
                            
                            composable(
                                route = "detail",
                                enterTransition = {
                                    slideInHorizontally(
                                        initialOffsetX = { it },
                                        animationSpec = tween(300)
                                    )
                                },
                                exitTransition = {
                                    slideOutHorizontally(
                                        targetOffsetX = { it },
                                        animationSpec = tween(300)
                                    )
                                }
                            ) {
                                DetailScreen()
                            }
                        }
                    """.trimIndent(),
                    explanation = "使用NavOptions控制导航行为，如返回栈管理、单例模式等。使用AnimatedNavHost可以添加转场动画，提升用户体验。"
                )
            ),
            useCases = listOf(
                "Compose应用导航：Jetpack Compose应用的标准导航方式",
                "类型安全：使用sealed class定义路由，避免字符串错误",
                "参数传递：通过路由参数或状态管理传递数据",
                "深层链接：支持深层链接，从外部跳转到应用内特定页面",
                "动画转场：使用AnimatedNavHost添加流畅的转场动画"
            ),
            notes = listOf(
                "NavController应该在Composable的顶层创建，使用rememberNavController()",
                "路由字符串应该使用常量或sealed class，避免硬编码",
                "对于复杂对象，优先使用ViewModel或状态管理传递，而不是路由参数",
                "注意导航栈的深度，避免内存问题",
                "使用AnimatedNavHost需要添加navigation-compose依赖"
            ),
            practiceTips = "建议使用sealed class定义路由，提供类型安全。对于简单数据，通过路由参数传递；对于复杂对象，使用ViewModel或状态管理。使用AnimatedNavHost添加转场动画，提升用户体验。注意导航栈的管理，避免栈过深。"
        ),
        
        KnowledgeDetail(
            id = "navigation_advanced",
            title = "导航高级特性（参数传递、深层链接）",
            overview = "Navigation Component的高级特性包括类型安全的参数传递、深层链接、嵌套导航图、条件导航等。掌握这些特性可以构建更复杂和用户友好的导航体验。",
            keyPoints = listOf(
                "深层链接（Deep Links）：支持从外部（如网页、通知）跳转到应用内特定页面",
                "嵌套导航图：将复杂的导航图分解为多个子导航图，提高可维护性",
                "条件导航：根据条件动态决定导航目标",
                "自定义NavType：支持传递复杂对象类型",
                "导航拦截：在导航前进行拦截和处理"
            ),
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：深层链接（Deep Links）",
                    code = """
                        // 1. 在导航图中定义深层链接
                        <fragment
                            android:id="@+id/detailFragment"
                            android:name="com.example.DetailFragment"
                            android:label="Detail">
                            <deepLink
                                app:uri="https://example.com/detail/{itemId}" />
                            <deepLink
                                app:uri="example://detail/{itemId}" />
                        </fragment>
                        
                        // 2. 在AndroidManifest.xml中配置
                        <activity
                            android:name=".MainActivity"
                            ...>
                            <nav-graph android:value="@navigation/nav_graph" />
                        </activity>
                        
                        // 3. 在代码中处理深层链接
                        val navController = findNavController()
                        navController.handleDeepLink(intent)
                        
                        // 4. 使用PendingIntent创建深层链接
                        val deepLink = NavDeepLinkBuilder(context)
                            .setGraph(R.navigation.nav_graph)
                            .setDestination(R.id.detailFragment)
                            .setArguments(bundleOf("itemId" to "123"))
                            .createPendingIntent()
                        
                        // 5. 在通知中使用深层链接
                        val notification = NotificationCompat.Builder(context, CHANNEL_ID)
                            .setContentTitle("New Item")
                            .setContentIntent(deepLink)
                            .build()
                        
                        // 6. Compose中的深层链接
                        NavHost(
                            navController = navController,
                            startDestination = "home"
                        ) {
                            composable(
                                route = "detail/{itemId}",
                                deepLinks = listOf(
                                    navDeepLink {
                                        uriPattern = "https://example.com/detail/{itemId}"
                                    },
                                    navDeepLink {
                                        uriPattern = "example://detail/{itemId}"
                                    }
                                )
                            ) { backStackEntry ->
                                val itemId = backStackEntry.arguments?.getString("itemId")
                                DetailScreen(itemId = itemId)
                            }
                        }
                    """.trimIndent(),
                    explanation = "深层链接允许从外部（网页、通知等）跳转到应用内特定页面。在导航图中定义deepLink，在AndroidManifest中配置，在代码中处理。"
                ),
                CodeExample(
                    title = "示例2：嵌套导航图",
                    code = """
                        // 主导航图（nav_graph.xml）
                        <navigation
                            android:id="@+id/main_nav_graph"
                            app:startDestination="@id/home">
                            
                            <fragment
                                android:id="@+id/home"
                                android:name="com.example.HomeFragment" />
                            
                            <!-- 嵌套导航图 -->
                            <include app:graph="@navigation/auth_nav_graph" />
                            <include app:graph="@navigation/main_nav_graph" />
                        </navigation>
                        
                        // 认证导航图（auth_nav_graph.xml）
                        <navigation
                            android:id="@+id/auth_nav_graph"
                            app:startDestination="@id/login">
                            
                            <fragment
                                android:id="@+id/login"
                                android:name="com.example.LoginFragment">
                                <action
                                    android:id="@+id/action_login_to_register"
                                    app:destination="@id/register" />
                            </fragment>
                            
                            <fragment
                                android:id="@+id/register"
                                android:name="com.example.RegisterFragment" />
                        </navigation>
                        
                        // 在代码中导航到嵌套导航图
                        navController.navigate(R.id.auth_nav_graph)
                        
                        // Compose中的嵌套导航图
                        NavHost(
                            navController = navController,
                            startDestination = "home"
                        ) {
                            composable("home") { HomeScreen() }
                            
                            // 嵌套导航图
                            navigation(
                                startDestination = "login",
                                route = "auth"
                            ) {
                                composable("login") { LoginScreen() }
                                composable("register") { RegisterScreen() }
                            }
                        }
                    """.trimIndent(),
                    explanation = "嵌套导航图可以将复杂的导航图分解为多个子导航图，提高可维护性。使用include标签包含子导航图，或在Compose中使用navigation函数。"
                ),
                CodeExample(
                    title = "示例3：条件导航和导航拦截",
                    code = """
                        // 条件导航：根据条件决定导航目标
                        fun navigateToDetail(itemId: String, isPremium: Boolean) {
                            val destination = if (isPremium) {
                                R.id.premiumDetailFragment
                            } else {
                                R.id.detailFragment
                            }
                            
                            navController.navigate(
                                destination,
                                bundleOf("itemId" to itemId)
                            )
                        }
                        
                        // 导航拦截：在导航前进行检查
                        navController.addOnDestinationChangedListener { controller, destination, arguments ->
                            when (destination.id) {
                                R.id.premiumDetailFragment -> {
                                    // 检查用户是否已登录
                                    if (!userRepository.isLoggedIn()) {
                                        // 拦截导航，跳转到登录页
                                        controller.navigate(R.id.loginFragment)
                                        return@addOnDestinationChangedListener
                                    }
                                    
                                    // 检查用户是否是高级用户
                                    if (!userRepository.isPremium()) {
                                        // 拦截导航，显示升级提示
                                        showUpgradeDialog()
                                        controller.popBackStack()
                                        return@addOnDestinationChangedListener
                                    }
                                }
                            }
                        }
                        
                        // Compose中的条件导航
                        @Composable
                        fun AppNavigation(
                            isLoggedIn: Boolean,
                            isPremium: Boolean
                        ) {
                            val navController = rememberNavController()
                            
                            NavHost(
                                navController = navController,
                                startDestination = if (isLoggedIn) "home" else "login"
                            ) {
                                composable("login") {
                                    LoginScreen(
                                        onLoginSuccess = {
                                            navController.navigate("home") {
                                                popUpTo("login") { inclusive = true }
                                        }
                                    )
                                }
                                
                                composable("home") {
                                    HomeScreen(
                                        onNavigateToDetail = { itemId ->
                                            val route = if (isPremium) {
                                                "premium_detail/${'$'}itemId"
                                            } else {
                                                "detail/${'$'}itemId"
                                            }
                                            navController.navigate(route)
                                        }
                                    )
                                }
                            }
                        }
                    """.trimIndent(),
                    explanation = "条件导航根据条件动态决定导航目标。导航拦截可以在导航前进行检查，如权限验证、登录状态等。"
                ),
                CodeExample(
                    title = "示例4：自定义NavType和复杂参数",
                    code = """
                        // 自定义NavType用于传递复杂对象
                        class ItemNavType : NavType<Item>(isNullableAllowed = false) {
                            override fun get(bundle: Bundle, key: String): Item? {
                                return bundle.getParcelable(key)
                            }
                            
                            override fun parseValue(value: String): Item {
                                // 从JSON字符串解析
                                return Gson().fromJson(value, Item::class.java)
                            }
                            
                            override fun put(bundle: Bundle, key: String, value: Item) {
                                bundle.putParcelable(key, value)
                            }
                            
                            override fun getName(): String = "Item"
                        }
                        
                        // 在导航图中使用自定义NavType
                        <fragment
                            android:id="@+id/detailFragment"
                            android:name="com.example.DetailFragment">
                            <argument
                                android:name="item"
                                app:argType="com.example.ItemNavType" />
                        </fragment>
                        
                        // Compose中使用自定义NavType
                        composable(
                            route = "detail/{itemJson}",
                            arguments = listOf(
                                navArgument("itemJson") {
                                    type = ItemNavType()
                                }
                            )
                        ) { backStackEntry ->
                            val item = backStackEntry.arguments?.getParcelable<Item>("item")
                            DetailScreen(item = item)
                        }
                        
                        // 导航时传递对象
                        val item = Item("123", "Test")
                        val itemJson = Gson().toJson(item)
                        navController.navigate("detail/${'$'}itemJson")
                    """.trimIndent(),
                    explanation = "自定义NavType可以传递复杂对象。实现NavType接口，重写get、parseValue、put等方法，然后在导航图中使用。"
                )
            ),
            useCases = listOf(
                "深层链接：从网页、通知等外部来源跳转到应用内特定页面",
                "嵌套导航：将复杂的导航图分解为多个子导航图，提高可维护性",
                "条件导航：根据用户状态、权限等条件动态决定导航目标",
                "导航拦截：在导航前进行权限验证、登录检查等",
                "复杂参数：传递复杂对象类型，如自定义数据类"
            ),
            notes = listOf(
                "深层链接需要在AndroidManifest.xml中配置",
                "嵌套导航图可以提高代码的可维护性，但不要过度嵌套",
                "导航拦截应该在导航前进行，避免用户看到不应该访问的页面",
                "自定义NavType需要实现序列化和反序列化",
                "注意深层链接的安全性，验证参数的有效性"
            ),
            practiceTips = "建议使用深层链接提升用户体验，允许从外部跳转到应用内。使用嵌套导航图组织复杂的导航结构。实现导航拦截确保安全性。对于复杂对象，使用自定义NavType或通过ViewModel传递。注意深层链接的参数验证，防止安全漏洞。"
        ),
        
        // ========== 测试 ==========
        
        KnowledgeDetail(
            id = "unit_test",
            title = "单元测试（Unit Testing）",
            overview = "单元测试是对代码中最小可测试单元（通常是函数或方法）进行的测试。在Android开发中，单元测试用于验证业务逻辑、工具类和ViewModel等非UI组件的正确性。单元测试运行在JVM上，不需要Android设备，执行速度快。",
            keyPoints = listOf(
                "测试框架：JUnit是Java/Kotlin的标准测试框架，Android项目使用JUnit 4或JUnit 5",
                "测试结构：使用@Test注解标记测试方法，使用断言验证结果",
                "Mock对象：使用Mockito等框架创建模拟对象，隔离被测试代码的依赖",
                "测试覆盖率：通过单元测试覆盖尽可能多的代码路径，提高代码质量",
                "测试命名：使用清晰的测试方法名，描述测试的场景和预期结果",
                "测试隔离：每个测试应该独立运行，不依赖其他测试的状态"
            ),
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：基础单元测试",
                    code = """
                        // 被测试的类
                        class Calculator {
                            fun add(a: Int, b: Int): Int {
                                return a + b
                            }
                            
                            fun divide(a: Int, b: Int): Double {
                                if (b == 0) {
                                    throw IllegalArgumentException("除数不能为0")
                                }
                                return a.toDouble() / b
                            }
                        }
                        
                        // 测试类
                        import org.junit.Test
                        import org.junit.Assert.*
                        
                        class CalculatorTest {
                            private val calculator = Calculator()
                            
                            @Test
                            fun testAdd_PositiveNumbers_ReturnsSum() {
                                // Given
                                val a = 5
                                val b = 3
                                
                                // When
                                val result = calculator.add(a, b)
                                
                                // Then
                                assertEquals(8, result)
                            }
                            
                            @Test
                            fun testAdd_NegativeNumbers_ReturnsSum() {
                                val result = calculator.add(-5, -3)
                                assertEquals(-8, result)
                            }
                            
                            @Test
                            fun testDivide_ValidNumbers_ReturnsQuotient() {
                                val result = calculator.divide(10, 2)
                                assertEquals(5.0, result, 0.001)
                            }
                            
                            @Test(expected = IllegalArgumentException::class)
                            fun testDivide_ByZero_ThrowsException() {
                                calculator.divide(10, 0)
                            }
                        }
                    """.trimIndent(),
                    explanation = "基础单元测试使用JUnit框架，通过@Test标记测试方法，使用断言（如assertEquals）验证结果。测试方法名应该清晰描述测试场景。"
                ),
                CodeExample(
                    title = "示例2：使用Mockito进行Mock测试",
                    code = """
                        // 被测试的类
                        class UserService(
                            private val userRepository: UserRepository,
                            private val emailService: EmailService
                        ) {
                            fun registerUser(name: String, email: String): User {
                                val user = userRepository.saveUser(name, email)
                                emailService.sendWelcomeEmail(email)
                                return user
                            }
                        }
                        
                        // 测试类使用Mockito
                        import org.junit.Test
                        import org.junit.Assert.*
                        import org.mockito.Mockito.*
                        import org.mockito.Mock
                        import org.mockito.MockitoAnnotations
                        
                        class UserServiceTest {
                            @Mock
                            private lateinit var userRepository: UserRepository
                            
                            @Mock
                            private lateinit var emailService: EmailService
                            
                            private lateinit var userService: UserService
                            
                            @Before
                            fun setup() {
                                MockitoAnnotations.openMocks(this)
                                userService = UserService(userRepository, emailService)
                            }
                            
                            @Test
                            fun testRegisterUser_Success_CallsRepositoryAndEmailService() {
                                // Given
                                val name = "张三"
                                val email = "zhangsan@example.com"
                                val expectedUser = User(1, name, email)
                                
                                // 配置Mock对象的行为
                                `when`(userRepository.saveUser(name, email)).thenReturn(expectedUser)
                                
                                // When
                                val result = userService.registerUser(name, email)
                                
                                // Then
                                assertEquals(expectedUser, result)
                                // 验证方法被调用
                                verify(userRepository).saveUser(name, email)
                                verify(emailService).sendWelcomeEmail(email)
                            }
                            
                            @Test
                            fun testRegisterUser_RepositoryThrowsException_PropagatesException() {
                                // Given
                                val name = "张三"
                                val email = "zhangsan@example.com"
                                `when`(userRepository.saveUser(name, email))
                                    .thenThrow(RuntimeException("数据库错误"))
                                
                                // When & Then
                                assertThrows(RuntimeException::class.java) {
                                    userService.registerUser(name, email)
                                }
                                
                                // 验证emailService没有被调用
                                verify(emailService, never()).sendWelcomeEmail(any())
                            }
                        }
                    """.trimIndent(),
                    explanation = "使用Mockito可以创建Mock对象，隔离被测试代码的依赖。通过when().thenReturn()配置Mock行为，使用verify()验证方法调用。"
                ),
                CodeExample(
                    title = "示例3：ViewModel单元测试",
                    code = """
                        // ViewModel
                        class UserViewModel(
                            private val userRepository: UserRepository
                        ) : ViewModel() {
                            private val _users = MutableStateFlow<List<User>>(emptyList())
                            val users: StateFlow<List<User>> = _users
                            
                            private val _loading = MutableStateFlow(false)
                            val loading: StateFlow<Boolean> = _loading
                            
                            fun loadUsers() {
                                viewModelScope.launch {
                                    _loading.value = true
                                    try {
                                        _users.value = userRepository.getUsers()
                                    } catch (e: Exception) {
                                        // 处理错误
                                    } finally {
                                        _loading.value = false
                                    }
                                }
                            }
                        }
                        
                        // ViewModel测试
                        import androidx.arch.core.executor.testing.InstantTaskExecutorRule
                        import kotlinx.coroutines.ExperimentalCoroutinesApi
                        import kotlinx.coroutines.test.*
                        import org.junit.Rule
                        import org.junit.Test
                        import org.mockito.Mock
                        import org.mockito.MockitoAnnotations
                        import org.mockito.kotlin.*
                        
                        @ExperimentalCoroutinesApi
                        class UserViewModelTest {
                            @get:Rule
                            val instantTaskExecutorRule = InstantTaskExecutorRule()
                            
                            @get:Rule
                            val mainDispatcherRule = MainDispatcherRule()
                            
                            @Mock
                            private lateinit var userRepository: UserRepository
                            
                            private lateinit var viewModel: UserViewModel
                            
                            @Before
                            fun setup() {
                                MockitoAnnotations.openMocks(this)
                                viewModel = UserViewModel(userRepository)
                            }
                            
                            @Test
                            fun testLoadUsers_Success_UpdatesUsersState() = runTest {
                                // Given
                                val expectedUsers = listOf(
                                    User(1, "张三", "zhangsan@example.com"),
                                    User(2, "李四", "lisi@example.com")
                                )
                                whenever(userRepository.getUsers()).thenReturn(expectedUsers)
                                
                                // When
                                viewModel.loadUsers()
                                
                                // Then
                                val users = viewModel.users.value
                                assertEquals(expectedUsers, users)
                                assertEquals(false, viewModel.loading.value)
                            }
                            
                            @Test
                            fun testLoadUsers_LoadingState_ChangesCorrectly() = runTest {
                                // Given
                                whenever(userRepository.getUsers()).thenReturn(emptyList())
                                
                                // When
                                viewModel.loadUsers()
                                
                                // Then
                                // 注意：由于协程的异步特性，需要等待状态更新
                                assertEquals(false, viewModel.loading.value)
                            }
                        }
                        
                        // 协程测试规则
                        @ExperimentalCoroutinesApi
                        class MainDispatcherRule : TestWatcher() {
                            private val testDispatcher = StandardTestDispatcher()
                            
                            override fun starting(description: Description) {
                                Dispatchers.setMain(testDispatcher)
                            }
                            
                            override fun finished(description: Description) {
                                Dispatchers.resetMain()
                            }
                        }
                    """.trimIndent(),
                    explanation = "ViewModel测试需要处理协程和LiveData/StateFlow。使用TestDispatcher控制协程执行，使用InstantTaskExecutorRule处理LiveData。"
                )
            ),
            useCases = listOf(
                "业务逻辑测试：验证工具类、业务逻辑类的正确性",
                "ViewModel测试：测试ViewModel的状态管理和业务逻辑",
                "数据转换测试：测试数据转换、格式化等纯函数",
                "算法测试：验证复杂算法的正确性",
                "边界条件测试：测试边界情况和异常情况"
            ),
            notes = listOf(
                "单元测试应该快速执行，避免依赖外部资源（网络、数据库等）",
                "使用Mock对象隔离依赖，确保测试的独立性",
                "测试方法名应该清晰描述测试场景，如testMethodName_Scenario_ExpectedResult",
                "保持测试代码简洁，遵循AAA模式（Arrange-Act-Assert）",
                "测试覆盖率不是唯一目标，重要的是测试质量",
                "避免测试实现细节，应该测试行为而非实现"
            ),
            practiceTips = "建议在编写代码的同时编写单元测试，遵循TDD（测试驱动开发）可以提高代码质量。使用Mock框架隔离依赖，保持测试独立。为每个公共方法编写测试，特别关注边界条件和异常情况。使用清晰的测试方法名，遵循命名规范。定期运行测试，确保代码修改不会破坏现有功能。"
        ),
        
        KnowledgeDetail(
            id = "integration_test",
            title = "集成测试（Integration Testing）",
            overview = "集成测试是测试多个组件协同工作的测试方式。在Android开发中，集成测试通常运行在Android设备或模拟器上，可以测试Activity、Fragment、数据库、网络请求等Android组件的集成。集成测试比单元测试更接近真实环境，但执行速度较慢。",
            keyPoints = listOf(
                "测试环境：集成测试运行在Android设备或模拟器上，需要AndroidTest依赖",
                "测试框架：使用AndroidJUnitRunner和Espresso进行UI测试，使用Room的in-memory数据库测试数据库",
                "测试范围：测试Activity、Fragment、Service、ContentProvider等Android组件的集成",
                "数据库测试：使用Room的in-memory数据库进行快速数据库测试",
                "网络测试：使用MockWebServer模拟网络请求，测试网络层集成",
                "测试数据：使用测试数据构建器创建测试数据，保持测试代码简洁"
            ),
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：Activity集成测试",
                    code = """
                        // Activity
                        class MainActivity : AppCompatActivity() {
                            private lateinit var viewModel: UserViewModel
                            
                            override fun onCreate(savedInstanceState: Bundle?) {
                                super.onCreate(savedInstanceState)
                                setContentView(R.layout.activity_main)
                                
                                viewModel = ViewModelProvider(this)[UserViewModel::class.java]
                                
                                viewModel.users.observe(this) { users ->
                                    // 更新UI
                                    updateUserList(users)
                                }
                                
                                findViewById<Button>(R.id.loadButton).setOnClickListener {
                                    viewModel.loadUsers()
                                }
                            }
                            
                            private fun updateUserList(users: List<User>) {
                                // 更新列表
                            }
                        }
                        
                        // 集成测试
                        import androidx.test.ext.junit.rules.ActivityScenarioRule
                        import androidx.test.ext.junit.runners.AndroidJUnit4
                        import androidx.test.espresso.Espresso.*
                        import androidx.test.espresso.assertion.ViewAssertions.*
                        import androidx.test.espresso.matcher.ViewMatchers.*
                        import androidx.test.espresso.action.ViewActions.*
                        import org.junit.Rule
                        import org.junit.Test
                        import org.junit.runner.RunWith
                        
                        @RunWith(AndroidJUnit4::class)
                        class MainActivityTest {
                            @get:Rule
                            val activityRule = ActivityScenarioRule(MainActivity::class.java)
                            
                            @Test
                            fun testLoadUsers_DisplaysUserList() {
                                // 点击加载按钮
                                onView(withId(R.id.loadButton))
                                    .perform(click())
                                
                                // 验证用户列表显示
                                onView(withId(R.id.userList))
                                    .check(matches(isDisplayed()))
                                
                                // 验证列表中有数据
                                onView(withText("张三"))
                                    .check(matches(isDisplayed()))
                            }
                            
                            @Test
                            fun testUserList_EmptyState_ShowsEmptyMessage() {
                                // 验证空状态显示
                                onView(withId(R.id.emptyMessage))
                                    .check(matches(isDisplayed()))
                                onView(withText("暂无数据"))
                                    .check(matches(isDisplayed()))
                            }
                        }
                    """.trimIndent(),
                    explanation = "Activity集成测试使用ActivityScenarioRule启动Activity，使用Espresso进行UI交互和验证。测试运行在Android设备上，可以测试真实的Activity行为。"
                ),
                CodeExample(
                    title = "示例2：Room数据库集成测试",
                    code = """
                        // 数据库
                        @Database(entities = [User::class], version = 1)
                        abstract class AppDatabase : RoomDatabase() {
                            abstract fun userDao(): UserDao
                        }
                        
                        // DAO
                        @Dao
                        interface UserDao {
                            @Query("SELECT * FROM users")
                            fun getAllUsers(): Flow<List<User>>
                            
                            @Insert
                            suspend fun insertUser(user: User)
                            
                            @Delete
                            suspend fun deleteUser(user: User)
                        }
                        
                        // 数据库集成测试
                        import androidx.room.Room
                        import androidx.room.testing.MigrationTestHelper
                        import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelperFactory
                        import androidx.test.platform.app.InstrumentationRegistry
                        import kotlinx.coroutines.flow.first
                        import kotlinx.coroutines.runBlocking
                        import org.junit.After
                        import org.junit.Before
                        import org.junit.Test
                        import org.junit.runner.RunWith
                        import androidx.test.ext.junit.runners.AndroidJUnit4
                        
                        @RunWith(AndroidJUnit4::class)
                        class UserDaoTest {
                            private lateinit var database: AppDatabase
                            
                            @Before
                            fun setup() {
                                // 使用in-memory数据库进行测试
                                database = Room.inMemoryDatabaseBuilder(
                                    InstrumentationRegistry.getInstrumentation().context,
                                    AppDatabase::class.java
                                ).allowMainThreadQueries()
                                    .build()
                            }
                            
                            @After
                            fun tearDown() {
                                database.close()
                            }
                            
                            @Test
                            fun testInsertUser_UserExistsInDatabase() = runBlocking {
                                // Given
                                val user = User(1, "张三", "zhangsan@example.com")
                                
                                // When
                                database.userDao().insertUser(user)
                                
                                // Then
                                val users = database.userDao().getAllUsers().first()
                                assertEquals(1, users.size)
                                assertEquals(user, users[0])
                            }
                            
                            @Test
                            fun testDeleteUser_UserRemovedFromDatabase() = runBlocking {
                                // Given
                                val user = User(1, "张三", "zhangsan@example.com")
                                database.userDao().insertUser(user)
                                
                                // When
                                database.userDao().deleteUser(user)
                                
                                // Then
                                val users = database.userDao().getAllUsers().first()
                                assertTrue(users.isEmpty())
                            }
                        }
                    """.trimIndent(),
                    explanation = "Room数据库集成测试使用in-memory数据库，测试速度快且不需要清理。使用runBlocking处理Flow的异步操作。"
                ),
                CodeExample(
                    title = "示例3：网络层集成测试（使用MockWebServer）",
                    code = """
                        // Repository
                        class UserRepository(
                            private val apiService: ApiService
                        ) {
                            suspend fun getUsers(): List<User> {
                                return apiService.getUsers()
                            }
                        }
                        
                        // API Service
                        interface ApiService {
                            @GET("users")
                            suspend fun getUsers(): List<User>
                        }
                        
                        // 网络集成测试
                        import okhttp3.mockwebserver.MockResponse
                        import okhttp3.mockwebserver.MockWebServer
                        import org.junit.After
                        import org.junit.Before
                        import org.junit.Test
                        import retrofit2.Retrofit
                        import retrofit2.converter.gson.GsonConverterFactory
                        import kotlinx.coroutines.runBlocking
                        import org.junit.Assert.*
                        
                        class UserRepositoryIntegrationTest {
                            private lateinit var mockWebServer: MockWebServer
                            private lateinit var repository: UserRepository
                            
                            @Before
                            fun setup() {
                                mockWebServer = MockWebServer()
                                mockWebServer.start()
                                
                                val retrofit = Retrofit.Builder()
                                    .baseUrl(mockWebServer.url("/"))
                                    .addConverterFactory(GsonConverterFactory.create())
                                    .build()
                                
                                val apiService = retrofit.create(ApiService::class.java)
                                repository = UserRepository(apiService)
                            }
                            
                            @After
                            fun tearDown() {
                                mockWebServer.shutdown()
                            }
                            
                            @Test
                            fun testGetUsers_Success_ReturnsUserList() = runBlocking {
                                // Given
                                val responseBody = "[{\"id\": 1, \"name\": \"张三\", \"email\": \"zhangsan@example.com\"}, {\"id\": 2, \"name\": \"李四\", \"email\": \"lisi@example.com\"}]"
                                
                                mockWebServer.enqueue(
                                    MockResponse()
                                        .setResponseCode(200)
                                        .setBody(responseBody)
                                )
                                
                                // When
                                val users = repository.getUsers()
                                
                                // Then
                                assertEquals(2, users.size)
                                assertEquals("张三", users[0].name)
                                assertEquals("李四", users[1].name)
                            }
                            
                            @Test
                            fun testGetUsers_ServerError_ThrowsException() = runBlocking {
                                // Given
                                mockWebServer.enqueue(
                                    MockResponse()
                                        .setResponseCode(500)
                                )
                                
                                // When & Then
                                try {
                                    repository.getUsers()
                                    fail("应该抛出异常")
                                } catch (e: Exception) {
                                    // 预期异常
                                }
                            }
                        }
                    """.trimIndent(),
                    explanation = "使用MockWebServer可以模拟网络请求，测试网络层的集成。可以模拟成功响应、错误响应等不同场景，无需真实的网络环境。"
                )
            ),
            useCases = listOf(
                "Activity/Fragment测试：测试UI组件与ViewModel的集成",
                "数据库测试：测试Room数据库的CRUD操作和数据迁移",
                "网络层测试：测试Retrofit、OkHttp等网络库的集成",
                "ContentProvider测试：测试ContentProvider的数据共享",
                "Service测试：测试后台服务的集成和生命周期"
            ),
            notes = listOf(
                "集成测试运行在Android设备上，执行速度比单元测试慢",
                "使用in-memory数据库可以加快数据库测试速度",
                "使用MockWebServer可以模拟网络请求，避免依赖真实网络",
                "集成测试应该测试组件间的交互，而不是重复单元测试",
                "保持测试数据独立，每个测试应该清理自己的数据",
                "使用测试数据构建器可以简化测试数据的创建"
            ),
            practiceTips = "建议使用in-memory数据库进行数据库测试，速度快且无需清理。使用MockWebServer模拟网络请求，测试网络层集成。为每个Android组件编写集成测试，验证组件间的协作。使用Espresso进行UI测试，验证用户交互。保持测试数据独立，避免测试间的相互影响。"
        ),
        
        KnowledgeDetail(
            id = "ui_test",
            title = "UI测试（UI Testing / Espresso）",
            overview = "UI测试是测试应用用户界面的测试方式，验证用户交互和UI显示的正确性。在Android开发中，主要使用Espresso框架进行UI测试。Espresso提供了简洁的API来查找视图、执行操作和验证结果，可以测试Activity、Fragment等UI组件的用户交互。",
            keyPoints = listOf(
                "Espresso框架：Google官方推荐的UI测试框架，提供简洁的API",
                "视图查找：使用onView()和onData()查找视图，支持多种匹配器",
                "用户操作：使用perform()执行点击、输入、滑动等用户操作",
                "结果验证：使用check()验证视图状态，如显示、文本内容、选中状态等",
                "异步处理：使用IdlingResource处理异步操作，确保测试等待异步任务完成",
                "测试数据：使用测试数据隔离，避免测试间的相互影响"
            ),
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：基础UI测试",
                    code = """
                        // Activity布局
                        // activity_main.xml
                        // <LinearLayout>
                        //     <EditText android:id="@+id/usernameInput" />
                        //     <EditText android:id="@+id/passwordInput" />
                        //     <Button android:id="@+id/loginButton" />
                        //     <TextView android:id="@+id/resultText" />
                        // </LinearLayout>
                        
                        // Activity
                        class LoginActivity : AppCompatActivity() {
                            override fun onCreate(savedInstanceState: Bundle?) {
                                super.onCreate(savedInstanceState)
                                setContentView(R.layout.activity_main)
                                
                                findViewById<Button>(R.id.loginButton).setOnClickListener {
                                    val username = findViewById<EditText>(R.id.usernameInput).text.toString()
                                    val password = findViewById<EditText>(R.id.passwordInput).text.toString()
                                    
                                    if (username == "admin" && password == "123456") {
                                        findViewById<TextView>(R.id.resultText).text = "登录成功"
                                    } else {
                                        findViewById<TextView>(R.id.resultText).text = "用户名或密码错误"
                                    }
                                }
                            }
                        }
                        
                        // UI测试
                        import androidx.test.ext.junit.rules.ActivityScenarioRule
                        import androidx.test.ext.junit.runners.AndroidJUnit4
                        import androidx.test.espresso.Espresso.*
                        import androidx.test.espresso.assertion.ViewAssertions.*
                        import androidx.test.espresso.matcher.ViewMatchers.*
                        import androidx.test.espresso.action.ViewActions.*
                        import org.junit.Rule
                        import org.junit.Test
                        import org.junit.runner.RunWith
                        
                        @RunWith(AndroidJUnit4::class)
                        class LoginActivityTest {
                            @get:Rule
                            val activityRule = ActivityScenarioRule(LoginActivity::class.java)
                            
                            @Test
                            fun testLogin_Success_ShowsSuccessMessage() {
                                // 输入用户名
                                onView(withId(R.id.usernameInput))
                                    .perform(typeText("admin"), closeSoftKeyboard())
                                
                                // 输入密码
                                onView(withId(R.id.passwordInput))
                                    .perform(typeText("123456"), closeSoftKeyboard())
                                
                                // 点击登录按钮
                                onView(withId(R.id.loginButton))
                                    .perform(click())
                                
                                // 验证显示成功消息
                                onView(withId(R.id.resultText))
                                    .check(matches(withText("登录成功")))
                            }
                            
                            @Test
                            fun testLogin_InvalidCredentials_ShowsErrorMessage() {
                                // 输入错误的用户名和密码
                                onView(withId(R.id.usernameInput))
                                    .perform(typeText("wrong"), closeSoftKeyboard())
                                onView(withId(R.id.passwordInput))
                                    .perform(typeText("wrong"), closeSoftKeyboard())
                                
                                // 点击登录
                                onView(withId(R.id.loginButton))
                                    .perform(click())
                                
                                // 验证显示错误消息
                                onView(withId(R.id.resultText))
                                    .check(matches(withText("用户名或密码错误")))
                            }
                            
                            @Test
                            fun testLogin_EmptyFields_ButtonDisabled() {
                                // 验证按钮初始状态
                                onView(withId(R.id.loginButton))
                                    .check(matches(not(isEnabled())))
                            }
                        }
                    """.trimIndent(),
                    explanation = "基础UI测试使用Espresso的onView()查找视图，perform()执行操作，check()验证结果。测试模拟用户的真实操作流程。"
                ),
                CodeExample(
                    title = "示例2：列表测试（RecyclerView）",
                    code = """
                        // Activity with RecyclerView
                        class UserListActivity : AppCompatActivity() {
                            private lateinit var recyclerView: RecyclerView
                            private lateinit var adapter: UserAdapter
                            
                            override fun onCreate(savedInstanceState: Bundle?) {
                                super.onCreate(savedInstanceState)
                                setContentView(R.layout.activity_user_list)
                                
                                recyclerView = findViewById(R.id.recyclerView)
                                adapter = UserAdapter()
                                recyclerView.adapter = adapter
                                recyclerView.layoutManager = LinearLayoutManager(this)
                                
                                // 加载数据
                                loadUsers()
                            }
                            
                            private fun loadUsers() {
                                val users = listOf(
                                    User(1, "张三", "zhangsan@example.com"),
                                    User(2, "李四", "lisi@example.com"),
                                    User(3, "王五", "wangwu@example.com")
                                )
                                adapter.submitList(users)
                            }
                        }
                        
                        // RecyclerView UI测试
                        import androidx.test.espresso.contrib.RecyclerViewActions
                        import androidx.test.espresso.matcher.ViewMatchers.hasDescendant
                        
                        @RunWith(AndroidJUnit4::class)
                        class UserListActivityTest {
                            @get:Rule
                            val activityRule = ActivityScenarioRule(UserListActivity::class.java)
                            
                            @Test
                            fun testUserList_DisplaysAllUsers() {
                                // 验证列表显示
                                onView(withId(R.id.recyclerView))
                                    .check(matches(isDisplayed()))
                                
                                // 验证列表项数量
                                onView(withId(R.id.recyclerView))
                                    .check(matches(hasItemCount(3)))
                                
                                // 验证特定项显示
                                onView(withId(R.id.recyclerView))
                                    .check(matches(hasDescendant(withText("张三"))))
                                onView(withId(R.id.recyclerView))
                                    .check(matches(hasDescendant(withText("李四"))))
                            }
                            
                            @Test
                            fun testUserList_ClickItem_NavigatesToDetail() {
                                // 点击第一项
                                onView(withId(R.id.recyclerView))
                                    .perform(
                                        RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                                            0,
                                            click()
                                        )
                                    )
                                
                                // 验证导航到详情页（假设使用Intent）
                                // 这里需要根据实际导航方式验证
                            }
                            
                            @Test
                            fun testUserList_Scroll_LoadsMoreItems() {
                                // 滚动到底部
                                onView(withId(R.id.recyclerView))
                                    .perform(
                                        RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(2)
                                    )
                                
                                // 验证最后一项显示
                                onView(withId(R.id.recyclerView))
                                    .check(matches(hasDescendant(withText("王五"))))
                            }
                        }
                    """.trimIndent(),
                    explanation = "RecyclerView测试使用RecyclerViewActions进行列表操作，如点击项、滚动等。使用hasDescendant验证列表项内容。"
                ),
                CodeExample(
                    title = "示例3：异步操作测试（IdlingResource）",
                    code = """
                        // Activity with async operation
                        class UserActivity : AppCompatActivity() {
                            private lateinit var progressBar: ProgressBar
                            private lateinit var userList: RecyclerView
                            
                            override fun onCreate(savedInstanceState: Bundle?) {
                                super.onCreate(savedInstanceState)
                                setContentView(R.layout.activity_user)
                                
                                progressBar = findViewById(R.id.progressBar)
                                userList = findViewById(R.id.userList)
                                
                                loadUsers()
                            }
                            
                            private fun loadUsers() {
                                progressBar.visibility = View.VISIBLE
                                
                                // 模拟网络请求
                                lifecycleScope.launch {
                                    delay(2000) // 模拟网络延迟
                                    val users = repository.getUsers()
                                    // 更新UI
                                    adapter.submitList(users)
                                    progressBar.visibility = View.GONE
                                }
                            }
                        }
                        
                        // 使用IdlingResource处理异步操作
                        import androidx.test.espresso.IdlingRegistry
                        import androidx.test.espresso.IdlingResource
                        import androidx.test.espresso.idling.CountingIdlingResource
                        
                        class UserActivityTest {
                            private lateinit var idlingResource: CountingIdlingResource
                            
                            @Before
                            fun setup() {
                                idlingResource = CountingIdlingResource("UserLoading")
                                IdlingRegistry.getInstance().register(idlingResource)
                            }
                            
                            @After
                            fun tearDown() {
                                IdlingRegistry.getInstance().unregister(idlingResource)
                            }
                            
                            @Test
                            fun testLoadUsers_AsyncOperation_WaitsForCompletion() {
                                // 注意：需要在Activity中注册IdlingResource
                                // 在开始加载时调用 idlingResource.increment()
                                // 在加载完成时调用 idlingResource.decrement()
                                
                                // 验证加载指示器显示
                                onView(withId(R.id.progressBar))
                                    .check(matches(isDisplayed()))
                                
                                // Espresso会自动等待IdlingResource变为空闲
                                // 验证列表显示
                                onView(withId(R.id.userList))
                                    .check(matches(isDisplayed()))
                                
                                // 验证加载指示器隐藏
                                onView(withId(R.id.progressBar))
                                    .check(matches(not(isDisplayed())))
                            }
                        }
                        
                        // 在Activity中集成IdlingResource
                        class UserActivity : AppCompatActivity() {
                            private val idlingResource = CountingIdlingResource("UserLoading")
                            
                            private fun loadUsers() {
                                progressBar.visibility = View.VISIBLE
                                idlingResource.increment() // 开始异步操作
                                
                                lifecycleScope.launch {
                                    delay(2000)
                                    val users = repository.getUsers()
                                    adapter.submitList(users)
                                    progressBar.visibility = View.GONE
                                    idlingResource.decrement() // 完成异步操作
                                }
                            }
                            
                            fun getIdlingResource(): IdlingResource = idlingResource
                        }
                    """.trimIndent(),
                    explanation = "使用IdlingResource处理异步操作，确保Espresso等待异步任务完成后再继续测试。在异步操作开始时increment()，完成时decrement()。"
                ),
                CodeExample(
                    title = "示例4：Intent测试",
                    code = """
                        // Activity that starts another Activity
                        class MainActivity : AppCompatActivity() {
                            override fun onCreate(savedInstanceState: Bundle?) {
                                super.onCreate(savedInstanceState)
                                setContentView(R.layout.activity_main)
                                
                                findViewById<Button>(R.id.detailButton).setOnClickListener {
                                    val intent = Intent(this, DetailActivity::class.java).apply {
                                        putExtra("userId", "123")
                                        putExtra("userName", "张三")
                                    }
                                    startActivity(intent)
                                }
                            }
                        }
                        
                        // Intent测试
                        import androidx.test.espresso.intent.Intents
                        import androidx.test.espresso.intent.matcher.IntentMatchers.*
                        import androidx.test.espresso.intent.rule.IntentsTestRule
                        
                        @RunWith(AndroidJUnit4::class)
                        class MainActivityIntentTest {
                            @get:Rule
                            val intentsRule = IntentsTestRule(MainActivity::class.java)
                            
                            @Test
                            fun testDetailButton_StartsDetailActivity_WithCorrectIntent() {
                                // 点击详情按钮
                                onView(withId(R.id.detailButton))
                                    .perform(click())
                                
                                // 验证Intent
                                intended(hasComponent(DetailActivity::class.java.name))
                                intended(hasExtra("userId", "123"))
                                intended(hasExtra("userName", "张三"))
                            }
                            
                            @Test
                            fun testDetailButton_StartsDetailActivity_WithAction() {
                                onView(withId(R.id.detailButton))
                                    .perform(click())
                                
                                // 验证Intent Action
                                intended(hasAction(Intent.ACTION_VIEW))
                            }
                        }
                    """.trimIndent(),
                    explanation = "使用Intents框架可以验证Activity启动的Intent，包括目标组件、Extra数据、Action等。使用intended()验证Intent是否符合预期。"
                )
            ),
            useCases = listOf(
                "用户流程测试：测试完整的用户操作流程，如登录、注册、浏览等",
                "UI交互测试：测试按钮点击、输入、滑动等用户交互",
                "列表测试：测试RecyclerView、ListView等列表组件的显示和交互",
                "导航测试：测试Activity、Fragment间的导航和参数传递",
                "表单验证测试：测试表单输入验证和错误提示"
            ),
            notes = listOf(
                "UI测试运行在Android设备上，执行速度较慢，应该只测试关键的用户流程",
                "使用IdlingResource处理异步操作，确保测试等待异步任务完成",
                "保持测试独立，每个测试应该清理自己的状态",
                "使用测试数据隔离，避免测试间的相互影响",
                "UI测试应该测试用户可见的行为，而不是实现细节",
                "避免过度测试UI细节，关注关键的用户交互"
            ),
            practiceTips = "建议为关键的用户流程编写UI测试，如登录、注册、主要功能流程等。使用IdlingResource处理异步操作，确保测试稳定性。保持测试独立，使用测试数据隔离。使用Espresso的简洁API，避免复杂的视图查找。定期运行UI测试，确保UI修改不会破坏现有功能。注意测试执行时间，优化慢速测试。"
        )
    )
}


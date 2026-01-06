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
        )
    )
}


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


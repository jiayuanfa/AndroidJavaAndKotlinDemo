# Gradle 构建系统详解

## 📚 目录

1. [Gradle基础概念](#gradle基础概念)
2. [项目结构](#项目结构)
3. [build.gradle文件详解](#buildgradle文件详解)
4. [依赖管理](#依赖管理)
5. [构建变体（Build Variants）](#构建变体build-variants)
6. [构建类型（Build Types）](#构建类型build-types)
7. [产品风味（Product Flavors）](#产品风味product-flavors)
8. [签名配置（Signing Configs）](#签名配置signing-configs)
9. [版本目录（Version Catalogs）](#版本目录version-catalogs)
10. [Gradle Kotlin DSL](#gradle-kotlin-dsl)
11. [构建优化](#构建优化)
12. [常见问题](#常见问题)

---

## Gradle基础概念

### 什么是Gradle？

Gradle是一个基于Apache Ant和Apache Maven概念的项目自动化构建工具。它使用基于Groovy或Kotlin的特定领域语言（DSL）来声明项目设置。

### Gradle在Android开发中的作用

- **编译代码**：将Java/Kotlin源代码编译成字节码
- **打包资源**：将资源文件打包到APK/AAB中
- **依赖管理**：管理项目依赖库
- **代码混淆**：使用R8/ProGuard进行代码混淆
- **多构建变体**：支持Debug、Release等不同构建配置
- **任务执行**：执行各种构建任务（assemble、install、test等）

### Gradle版本

- **Gradle Wrapper**：项目使用Gradle Wrapper确保所有开发者使用相同的Gradle版本
- **Android Gradle Plugin (AGP)**：Android专用的Gradle插件，当前项目使用版本 **8.13.2**

---

## 项目结构

### 标准Android项目Gradle文件结构

```
项目根目录/
├── build.gradle                    # 项目级构建文件
├── settings.gradle                 # 项目设置文件
├── gradle.properties              # Gradle属性配置
├── gradle/
│   ├── wrapper/
│   │   ├── gradle-wrapper.jar     # Gradle Wrapper JAR
│   │   └── gradle-wrapper.properties  # Wrapper配置
│   └── libs.versions.toml         # 版本目录（Version Catalog）
└── app/
    ├── build.gradle                # 模块级构建文件
    └── proguard-rules.pro          # ProGuard规则
```

---

## build.gradle文件详解

### 1. 项目级 build.gradle（根目录）

项目级`build.gradle`文件用于配置所有子项目/模块共用的设置。

#### 当前项目配置示例

```1:9:build.gradle
// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false
    alias(libs.plugins.kotlin.kapt) apply false
    alias(libs.plugins.hilt) apply false
    alias(libs.plugins.kotlinx.serialization) apply false
}
```

**说明**：
- `apply false`：表示插件在项目级声明，但不立即应用
- 子模块可以选择性地应用这些插件
- 使用`alias(libs.plugins.xxx)`引用版本目录中定义的插件

#### 传统写法（对比）

```groovy
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath 'com.android.tools.build:gradle:8.13.2'
        classpath 'org.jetbrains.kotlin:kotlin-gradle-plugin:2.0.21'
    }
}
```

**现代写法优势**：
- 使用版本目录统一管理版本
- 更简洁的插件声明方式
- 更好的类型安全支持

### 2. 模块级 build.gradle（app/build.gradle）

模块级`build.gradle`文件配置特定模块的构建选项。

#### 完整配置解析

```1:58:app/build.gradle
plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.hilt)
}

android {
    namespace 'com.example.androidjavaandkotlindemo'
    compileSdk {
        version = release(36)
    }

    defaultConfig {
        applicationId "com.example.androidjavaandkotlindemo"
        minSdk 24
        targetSdk 36
        versionCode 1
        versionName "1.0"

        testInstrumentationRunner "androidx.test.runner.AndroidJUnitRunner"
        
        // Room数据库schema导出位置
        javaCompileOptions {
            annotationProcessorOptions {
                arguments += ["room.schemaLocation": "$projectDir/schemas".toString()]
            }
        }
    }

    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
        }
    }
    
    // Java和Kotlin混编支持
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
    
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}
```

#### 配置项详解

##### plugins块

```kotlin
plugins {
    alias(libs.plugins.android.application)  // Android应用插件
    alias(libs.plugins.kotlin.android)       // Kotlin Android插件
    alias(libs.plugins.kotlin.compose)       // Kotlin Compose编译器插件
    alias(libs.plugins.kotlin.kapt)          // Kotlin注解处理器
    alias(libs.plugins.hilt)                 // Hilt依赖注入插件
}
```

##### android块

**namespace**：应用的包名命名空间
```kotlin
namespace 'com.example.androidjavaandkotlindemo'
```

**compileSdk**：编译SDK版本
```kotlin
compileSdk {
    version = release(36)  // Android 16
}
```

**defaultConfig**：默认配置，应用于所有构建变体
```kotlin
defaultConfig {
    applicationId "com.example.androidjavaandkotlindemo"  // 应用ID（唯一标识）
    minSdk 24              // 最低支持Android 7.0
    targetSdk 36           // 目标Android 16
    versionCode 1          // 内部版本号（整数）
    versionName "1.0"      // 用户可见版本号（字符串）
    
    testInstrumentationRunner "androidx.test.runner.AndroidJUnitRunner"
}
```

**buildTypes**：构建类型配置
```kotlin
buildTypes {
    debug {
        // Debug构建类型（默认存在，可省略）
        debuggable true
        minifyEnabled false
    }
    release {
        minifyEnabled false  // 是否启用代码混淆
        proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 
                      'proguard-rules.pro'
    }
}
```

**compileOptions**：Java编译选项
```kotlin
compileOptions {
    sourceCompatibility JavaVersion.VERSION_11  // 源代码兼容性
    targetCompatibility JavaVersion.VERSION_11  // 目标字节码版本
}
```

**kotlinOptions**：Kotlin编译选项
```kotlin
kotlinOptions {
    jvmTarget = '11'  // Kotlin编译目标JVM版本
}
```

**buildFeatures**：构建特性开关
```kotlin
buildFeatures {
    compose true        // 启用Jetpack Compose
    buildConfig true    // 启用BuildConfig类生成
    viewBinding false   // 视图绑定（本项目使用Compose，不需要）
    dataBinding false   // 数据绑定（本项目使用Compose，不需要）
}
```

**packaging**：打包选项
```kotlin
packaging {
    resources {
        excludes += "/META-INF/{AL2.0,LGPL2.1}"  // 排除许可证文件
    }
}
```

---

## 依赖管理

### dependencies块

```60:135:app/build.gradle
dependencies {
    // Core Android
    implementation libs.androidx.core.ktx
    implementation libs.androidx.splashscreen
    
    // Lifecycle
    implementation libs.androidx.lifecycle.runtime.ktx
    implementation libs.androidx.lifecycle.viewmodel.compose
    implementation libs.androidx.lifecycle.viewmodel.ktx
    implementation libs.androidx.lifecycle.livedata.ktx
    
    // Compose
    implementation libs.androidx.activity.compose
    implementation platform(libs.androidx.compose.bom)
    implementation libs.androidx.compose.ui
    implementation libs.androidx.compose.ui.graphics
    implementation libs.androidx.compose.ui.tooling.preview
    implementation libs.androidx.compose.material3
    implementation libs.androidx.compose.material.icons.extended
    
    // Navigation
    implementation libs.androidx.navigation.compose
    
    // Room Database
    implementation libs.androidx.room.runtime
    implementation libs.androidx.room.ktx
    kapt libs.androidx.room.compiler
    
    // Hilt Dependency Injection
    implementation libs.hilt.android
    kapt libs.hilt.compiler
    implementation libs.hilt.navigation.compose
    
    // Networking
    implementation libs.retrofit
    implementation libs.retrofit.gson
    implementation libs.okhttp
    implementation libs.okhttp.logging
    
    // Coroutines
    implementation libs.kotlinx.coroutines.core
    implementation libs.kotlinx.coroutines.android
    
    // DataStore
    implementation libs.androidx.datastore.preferences
    implementation libs.androidx.datastore.core
    
    // WorkManager
    implementation libs.androidx.work.runtime.ktx
    
    // CameraX
    implementation libs.androidx.camera.core
    implementation libs.androidx.camera.camera2
    implementation libs.androidx.camera.lifecycle
    implementation libs.androidx.camera.view
    
    // Paging
    implementation libs.androidx.paging.runtime
    implementation libs.androidx.paging.compose
    
    // Image Loading
    implementation libs.coil.compose
    
    // Credentials (可选 - 需要使用正确的版本如1.2.0)
    // implementation "androidx.credentials:credentials:1.2.0"
    // implementation "androidx.credentials:credentials-play-services-auth:1.2.0"
    
    // Testing
    testImplementation libs.junit
    androidTestImplementation libs.androidx.junit
    androidTestImplementation libs.androidx.espresso.core
    androidTestImplementation platform(libs.androidx.compose.bom)
    androidTestImplementation libs.androidx.compose.ui.test.junit4
    debugImplementation libs.androidx.compose.ui.tooling
    debugImplementation libs.androidx.compose.ui.test.manifest
}
```

### 依赖配置类型

#### 1. implementation（推荐）
```kotlin
implementation libs.androidx.core.ktx
```
- **用途**：编译时和运行时依赖
- **特点**：依赖不会暴露给其他模块
- **优势**：加快构建速度，避免依赖泄漏

#### 2. api（已过时，不推荐）
```kotlin
api libs.some.library  // 不推荐
```
- **用途**：依赖会暴露给其他模块
- **问题**：会导致依赖传递，增加构建时间

#### 3. compileOnly
```kotlin
compileOnly libs.annotation.api
```
- **用途**：仅在编译时需要，运行时不需要
- **场景**：注解库、编译时工具

#### 4. runtimeOnly
```kotlin
runtimeOnly libs.some.runtime.library
```
- **用途**：仅在运行时需要，编译时不需要
- **场景**：较少使用

#### 5. kapt（Kotlin注解处理器）
```kotlin
kapt libs.androidx.room.compiler
kapt libs.hilt.compiler
```
- **用途**：Kotlin注解处理
- **场景**：Room、Hilt等需要代码生成的库
- **注意**：KSP（Kotlin Symbol Processing）正在替代KAPT，性能更好

#### 6. testImplementation
```kotlin
testImplementation libs.junit
```
- **用途**：单元测试依赖
- **特点**：仅在运行单元测试时使用

#### 7. androidTestImplementation
```kotlin
androidTestImplementation libs.androidx.junit
```
- **用途**：Android集成测试依赖
- **特点**：仅在运行Android测试时使用

#### 8. debugImplementation
```kotlin
debugImplementation libs.androidx.compose.ui.tooling
```
- **用途**：仅在Debug构建中使用
- **场景**：调试工具、开发工具

#### 9. platform（BOM - Bill of Materials）
```kotlin
implementation platform(libs.androidx.compose.bom)
implementation libs.androidx.compose.ui  // 版本由BOM管理
```
- **用途**：统一管理一组库的版本
- **优势**：确保Compose库版本兼容性

---

## 构建变体（Build Variants）

### 构建变体的组成

构建变体 = **构建类型（Build Type）** × **产品风味（Product Flavor）**

### 默认构建变体

当前项目只有构建类型，没有产品风味，因此构建变体为：
- `debug`：Debug构建类型
- `release`：Release构建类型

### 构建变体示例（带产品风味）

```kotlin
android {
    buildTypes {
        debug { }
        release { }
    }
    
    flavorDimensions += "version"
    productFlavors {
        create("free") {
            dimension = "version"
            applicationIdSuffix = ".free"
            versionNameSuffix = "-free"
        }
        create("paid") {
            dimension = "version"
            applicationIdSuffix = ".paid"
            versionNameSuffix = "-paid"
        }
    }
}
```

**生成的构建变体**：
- `freeDebug`
- `freeRelease`
- `paidDebug`
- `paidRelease`

---

## 构建类型（Build Types）

### Debug构建类型（默认）

```kotlin
buildTypes {
    debug {
        debuggable true           // 允许调试
        minifyEnabled false       // 不启用代码混淆
        shrinkResources false     // 不启用资源压缩
        signingConfig signingConfigs.debug  // 使用Debug签名
    }
}
```

**特点**：
- 包含调试信息
- 未优化，构建速度快
- 使用默认Debug签名（不安全，仅用于开发）

### Release构建类型

```kotlin
buildTypes {
    release {
        debuggable false          // 不允许调试
        minifyEnabled true        // 启用代码混淆
        shrinkResources true      // 启用资源压缩
        proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'),
                      'proguard-rules.pro'
        signingConfig signingConfigs.release  // 使用Release签名
    }
}
```

**特点**：
- 代码混淆，保护源代码
- 资源压缩，减小APK体积
- 使用正式签名，用于发布

### 自定义构建类型

```kotlin
buildTypes {
    create("staging") {
        initWith(getByName("release"))
        applicationIdSuffix = ".staging"
        versionNameSuffix = "-staging"
        debuggable true
    }
}
```

---

## 产品风味（Product Flavors）

### 产品风味的用途

- **多版本应用**：免费版、付费版
- **多环境**：开发、测试、生产
- **多渠道**：Google Play、华为应用市场等

### 产品风味配置示例

```kotlin
android {
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
```

### 多维度产品风味

```kotlin
android {
    flavorDimensions += "version"
    flavorDimensions += "environment"
    
    productFlavors {
        create("free") {
            dimension = "version"
            applicationIdSuffix = ".free"
        }
        create("paid") {
            dimension = "version"
            applicationIdSuffix = ".paid"
        }
        
        create("dev") {
            dimension = "environment"
            buildConfigField("String", "API_URL", "\"https://dev.api.com\"")
        }
        create("prod") {
            dimension = "environment"
            buildConfigField("String", "API_URL", "\"https://api.com\"")
        }
    }
}
```

**生成的构建变体**：
- `freeDevDebug`、`freeDevRelease`
- `freeProdDebug`、`freeProdRelease`
- `paidDevDebug`、`paidDevRelease`
- `paidProdDebug`、`paidProdRelease`

---

## 签名配置（Signing Configs）

### Debug签名（默认）

Debug构建自动使用默认Debug签名，无需配置。

### Release签名配置

#### 1. 在build.gradle中配置（不推荐，密钥暴露）

```kotlin
android {
    signingConfigs {
        create("release") {
            storeFile = file("release.keystore")
            storePassword = "password"
            keyAlias = "release"
            keyPassword = "password"
        }
    }
    
    buildTypes {
        getByName("release") {
            signingConfig = signingConfigs.getByName("release")
        }
    }
}
```

#### 2. 使用gradle.properties（推荐）

**gradle.properties**：
```properties
RELEASE_STORE_FILE=release.keystore
RELEASE_STORE_PASSWORD=your_store_password
RELEASE_KEY_ALIAS=your_key_alias
RELEASE_KEY_PASSWORD=your_key_password
```

**build.gradle**：
```kotlin
android {
    signingConfigs {
        create("release") {
            storeFile = file(project.findProperty("RELEASE_STORE_FILE") as String)
            storePassword = project.findProperty("RELEASE_STORE_PASSWORD") as String
            keyAlias = project.findProperty("RELEASE_KEY_ALIAS") as String
            keyPassword = project.findProperty("RELEASE_KEY_PASSWORD") as String
        }
    }
}
```

#### 3. 使用环境变量（最安全）

```kotlin
android {
    signingConfigs {
        create("release") {
            storeFile = file(System.getenv("RELEASE_STORE_FILE") ?: "release.keystore")
            storePassword = System.getenv("RELEASE_STORE_PASSWORD") ?: ""
            keyAlias = System.getenv("RELEASE_KEY_ALIAS") ?: ""
            keyPassword = System.getenv("RELEASE_KEY_PASSWORD") ?: ""
        }
    }
}
```

### 生成签名密钥

```bash
keytool -genkey -v -keystore release.keystore -alias release -keyalg RSA -keysize 2048 -validity 10000
```

---

## 版本目录（Version Catalogs）

### 什么是Version Catalog？

Version Catalog是Gradle 7.0+引入的功能，用于统一管理依赖版本，提供类型安全的依赖访问。

### libs.versions.toml文件结构

```1:115:gradle/libs.versions.toml
[versions]
agp = "8.13.2"
kotlin = "2.0.21"
coreKtx = "1.17.0"
junit = "4.13.2"
junitVersion = "1.3.0"
espressoCore = "3.7.0"
lifecycleRuntimeKtx = "2.10.0"
lifecycleViewmodelCompose = "2.10.0"
activityCompose = "1.12.2"
composeBom = "2024.09.00"
navigationCompose = "2.8.4"
room = "2.6.1"
hilt = "2.52"
hiltNavigationCompose = "1.2.0"
retrofit = "2.11.0"
okhttp = "4.12.0"
coroutines = "1.9.0"
datastore = "1.1.1"
workManager = "2.10.0"
camerax = "1.4.0"
paging = "3.3.4"
glide = "4.17.0"
coil = "2.7.0"
splashScreen = "1.2.0"
kotlinxSerialization = "1.7.3"
kotlinxSerializationConverter = "1.0.0"
kotlinCompilerExtension = "1.5.16"

[libraries]
# Core
androidx-core-ktx = { group = "androidx.core", name = "core-ktx", version.ref = "coreKtx" }
androidx-splashscreen = { group = "androidx.core", name = "core-splashscreen", version.ref = "splashScreen" }

# Testing
junit = { group = "junit", name = "junit", version.ref = "junit" }
androidx-junit = { group = "androidx.test.ext", name = "junit", version.ref = "junitVersion" }
androidx-espresso-core = { group = "androidx.test.espresso", name = "espresso-core", version.ref = "espressoCore" }

# Lifecycle
androidx-lifecycle-runtime-ktx = { group = "androidx.lifecycle", name = "lifecycle-runtime-ktx", version.ref = "lifecycleRuntimeKtx" }
androidx-lifecycle-viewmodel-compose = { group = "androidx.lifecycle", name = "lifecycle-viewmodel-compose", version.ref = "lifecycleViewmodelCompose" }
androidx-lifecycle-viewmodel-ktx = { group = "androidx.lifecycle", name = "lifecycle-viewmodel-ktx", version.ref = "lifecycleViewmodelCompose" }
androidx-lifecycle-livedata-ktx = { group = "androidx.lifecycle", name = "lifecycle-livedata-ktx", version.ref = "lifecycleViewmodelCompose" }

# Compose
androidx-activity-compose = { group = "androidx.activity", name = "activity-compose", version.ref = "activityCompose" }
androidx-compose-bom = { group = "androidx.compose", name = "compose-bom", version.ref = "composeBom" }
androidx-compose-ui = { group = "androidx.compose.ui", name = "ui" }
androidx-compose-ui-graphics = { group = "androidx.compose.ui", name = "ui-graphics" }
androidx-compose-ui-tooling = { group = "androidx.compose.ui", name = "ui-tooling" }
androidx-compose-ui-tooling-preview = { group = "androidx.compose.ui", name = "ui-tooling-preview" }
androidx-compose-ui-test-manifest = { group = "androidx.compose.ui", name = "ui-test-manifest" }
androidx-compose-ui-test-junit4 = { group = "androidx.compose.ui", name = "ui-test-junit4" }
androidx-compose-material3 = { group = "androidx.compose.material3", name = "material3" }
androidx-compose-material-icons-extended = { group = "androidx.compose.material", name = "material-icons-extended" }

# Navigation
androidx-navigation-compose = { group = "androidx.navigation", name = "navigation-compose", version.ref = "navigationCompose" }

# Room Database
androidx-room-runtime = { group = "androidx.room", name = "room-runtime", version.ref = "room" }
androidx-room-ktx = { group = "androidx.room", name = "room-ktx", version.ref = "room" }
androidx-room-compiler = { group = "androidx.room", name = "room-compiler", version.ref = "room" }

# Hilt Dependency Injection
hilt-android = { group = "com.google.dagger", name = "hilt-android", version.ref = "hilt" }
hilt-compiler = { group = "com.google.dagger", name = "hilt-compiler", version.ref = "hilt" }
hilt-navigation-compose = { group = "androidx.hilt", name = "hilt-navigation-compose", version.ref = "hiltNavigationCompose" }

# Networking
retrofit = { group = "com.squareup.retrofit2", name = "retrofit", version.ref = "retrofit" }
retrofit-gson = { group = "com.squareup.retrofit2", name = "converter-gson", version.ref = "retrofit" }
okhttp = { group = "com.squareup.okhttp3", name = "okhttp", version.ref = "okhttp" }
okhttp-logging = { group = "com.squareup.okhttp3", name = "logging-interceptor", version.ref = "okhttp" }

# Coroutines
kotlinx-coroutines-core = { group = "org.jetbrains.kotlinx", name = "kotlinx-coroutines-core", version.ref = "coroutines" }
kotlinx-coroutines-android = { group = "org.jetbrains.kotlinx", name = "kotlinx-coroutines-android", version.ref = "coroutines" }

# DataStore
androidx-datastore-preferences = { group = "androidx.datastore", name = "datastore-preferences", version.ref = "datastore" }
androidx-datastore-core = { group = "androidx.datastore", name = "datastore-core", version.ref = "datastore" }

# WorkManager
androidx-work-runtime-ktx = { group = "androidx.work", name = "work-runtime-ktx", version.ref = "workManager" }
androidx-work-runtime = { group = "androidx.work", name = "work-runtime", version.ref = "workManager" }

# CameraX
androidx-camera-core = { group = "androidx.camera", name = "camera-core", version.ref = "camerax" }
androidx-camera-camera2 = { group = "androidx.camera", name = "camera-camera2", version.ref = "camerax" }
androidx-camera-lifecycle = { group = "androidx.camera", name = "camera-lifecycle", version.ref = "camerax" }
androidx-camera-view = { group = "androidx.camera", name = "camera-view", version.ref = "camerax" }

# Paging
androidx-paging-runtime = { group = "androidx.paging", name = "paging-runtime", version.ref = "paging" }
androidx-paging-compose = { group = "androidx.paging", name = "paging-compose", version.ref = "paging" }

# Image Loading
coil-compose = { group = "io.coil-kt", name = "coil-compose", version.ref = "coil" }
glide = { group = "com.github.bumptech.glide", name = "glide", version.ref = "glide" }

# Credentials (可选 - 如需要请使用正确版本，例如: 1.2.0)
# androidx-credentials = { group = "androidx.credentials", name = "credentials", version = "1.2.0" }
# androidx-credentials-play-services-auth = { group = "androidx.credentials", name = "credentials-play-services-auth", version = "1.2.0" }

[plugins]
android-application = { id = "com.android.application", version.ref = "agp" }
kotlin-android = { id = "org.jetbrains.kotlin.android", version.ref = "kotlin" }
kotlin-compose = { id = "org.jetbrains.kotlin.plugin.compose", version.ref = "kotlin" }
kotlin-kapt = { id = "org.jetbrains.kotlin.kapt", version.ref = "kotlin" }
hilt = { id = "com.google.dagger.hilt.android", version.ref = "hilt" }
kotlinx-serialization = { id = "org.jetbrains.kotlin.plugin.serialization", version.ref = "kotlin" }
```

### Version Catalog的优势

1. **统一版本管理**：所有版本在一个文件中管理
2. **类型安全**：IDE提供自动补全和类型检查
3. **易于维护**：更新版本只需修改一处
4. **共享配置**：多模块项目可以共享版本目录

### 使用Version Catalog

**在build.gradle中使用**：
```kotlin
dependencies {
    // 使用版本目录中的库
    implementation libs.androidx.core.ktx
    implementation libs.hilt.android
    
    // 使用版本目录中的插件
    alias(libs.plugins.android.application)
}
```

**添加新依赖**：
1. 在`[versions]`中添加版本号
2. 在`[libraries]`中添加库定义
3. 在`build.gradle`中使用`libs.xxx`

---

## Gradle Kotlin DSL

### 什么是Kotlin DSL？

Gradle支持使用Kotlin DSL编写构建脚本（`build.gradle.kts`），替代Groovy DSL（`build.gradle`）。

### Kotlin DSL vs Groovy DSL

#### Groovy DSL（当前项目使用）
```groovy
android {
    compileSdk 34
    
    defaultConfig {
        minSdk 24
    }
}
```

#### Kotlin DSL
```kotlin
android {
    compileSdk = 34
    
    defaultConfig {
        minSdk = 24
    }
}
```

### Kotlin DSL的优势

- **类型安全**：编译时类型检查
- **IDE支持**：更好的自动补全和重构
- **可读性**：更清晰的语法
- **重构支持**：IDE可以安全重构

### 迁移到Kotlin DSL

1. 将`build.gradle`重命名为`build.gradle.kts`
2. 修改语法：
   - 字符串：`"string"` → `"string"`
   - 方法调用：`method()` → `method()`
   - 属性赋值：`property value` → `property = value`
   - 闭包：`{ }` → `{ }`（语法类似）

---

## 构建优化

### 1. 启用构建缓存

**gradle.properties**：
```properties
org.gradle.caching=true
org.gradle.parallel=true
org.gradle.configureondemand=true
```

### 2. 增加JVM内存

**gradle.properties**：
```properties
org.gradle.jvmargs=-Xmx4096m -XX:MaxMetaspaceSize=512m -XX:+HeapDumpOnOutOfMemoryError
```

### 3. 启用增量编译

Kotlin和Java编译器默认支持增量编译，确保：
```kotlin
kotlinOptions {
    incremental = true  // 默认启用
}
```

### 4. 使用KSP替代KAPT

KSP（Kotlin Symbol Processing）比KAPT快2-3倍：

```kotlin
plugins {
    id("com.google.devtools.ksp") version "1.9.0-1.0.13"
}

dependencies {
    ksp libs.androidx.room.compiler
    ksp libs.hilt.compiler
}
```

### 5. 启用非传递依赖

```kotlin
dependencies {
    implementation(libs.some.library) {
        isTransitive = false
    }
}
```

### 6. 使用构建分析

```bash
./gradlew build --profile --scan
```

---

## 常见问题

### 1. 依赖冲突

**问题**：多个库依赖了不同版本的同一个库

**解决**：
```kotlin
dependencies {
    implementation(libs.library1) {
        exclude(group = "com.example", module = "conflicting-library")
    }
}
```

或强制使用特定版本：
```kotlin
configurations.all {
    resolutionStrategy {
        force("com.example:library:1.0.0")
    }
}
```

### 2. 构建速度慢

**解决方案**：
- 启用构建缓存
- 使用KSP替代KAPT
- 增加JVM内存
- 启用并行构建
- 使用Gradle Daemon

### 3. 找不到依赖

**检查**：
- `settings.gradle`中的仓库配置
- 网络连接
- 依赖版本是否正确

### 4. 签名配置错误

**确保**：
- 密钥文件路径正确
- 密码正确
- 密钥别名正确

### 5. 版本不兼容

**解决**：
- 检查AGP版本与Gradle版本兼容性
- 检查Kotlin版本与AGP版本兼容性
- 查看官方兼容性矩阵

---

## 📝 项目实际配置总结

### 当前项目Gradle配置特点

1. **使用Version Catalog**：统一管理依赖版本
2. **现代插件语法**：使用`alias(libs.plugins.xxx)`
3. **Java 11**：`sourceCompatibility`和`targetCompatibility`设置为Java 11
4. **Kotlin 2.0.21**：最新Kotlin版本
5. **AGP 8.13.2**：最新Android Gradle Plugin
6. **Compose支持**：启用Compose编译器插件
7. **KAPT**：使用KAPT进行注解处理（可考虑迁移到KSP）

### 构建命令

```bash
# 构建Debug APK
./gradlew assembleDebug

# 构建Release APK
./gradlew assembleRelease

# 安装Debug版本
./gradlew installDebug

# 运行测试
./gradlew test

# 清理构建
./gradlew clean

# 查看构建变体
./gradlew tasks --all
```

---

## 📚 推荐资源

- [Gradle官方文档](https://docs.gradle.org/)
- [Android Gradle Plugin文档](https://developer.android.com/studio/build)
- [Version Catalog文档](https://docs.gradle.org/current/userguide/platforms.html)
- [Kotlin DSL文档](https://docs.gradle.org/current/userguide/kotlin_dsl.html)
- [Android构建配置指南](https://developer.android.com/studio/build)

---

*最后更新：2025年*


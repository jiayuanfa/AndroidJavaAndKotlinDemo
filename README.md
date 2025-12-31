# Android Java & Kotlin 混编项目

这是一个完整的Android项目示例，展示了Java和Kotlin混编，并集成了2025年Android开发的所有主要现代技术。

## 📱 项目特性

- ✅ **Java & Kotlin 混编** - 展示两种语言在同一项目中的完美协作
- ✅ **Jetpack Compose** - 现代化的声明式UI框架
- ✅ **Hilt 依赖注入** - 简洁的依赖注入解决方案
- ✅ **Room 数据库** - 本地数据持久化
- ✅ **Navigation Compose** - 类型安全的导航
- ✅ **ViewModel + StateFlow** - 响应式状态管理
- ✅ **Retrofit + OkHttp** - 网络请求
- ✅ **DataStore** - 现代化数据存储（替代SharedPreferences）
- ✅ **WorkManager** - 可靠的后台任务
- ✅ **CameraX** - 相机API
- ✅ **Paging 3** - 分页加载
- ✅ **Edge-to-Edge** - 现代UI设计

## 🏗️ 项目结构

```
app/src/main/java/com/example/androidjavaandkotlindemo/
├── data/
│   ├── User.java                    # 数据模型（Java编写）
│   ├── UserDao.kt                   # Room DAO（Kotlin编写，操作Java实体）
│   ├── AppDatabase.kt               # Room数据库（Kotlin）
│   ├── DataStoreManager.kt          # DataStore管理器（Kotlin）
│   └── api/
│       └── ApiService.kt            # 网络API接口（Kotlin）
├── repository/
│   └── UserRepository.kt            # 数据仓库（Kotlin，调用Java实体）
├── viewmodel/
│   └── UserViewModel.kt             # ViewModel（Kotlin）
├── di/
│   ├── DatabaseModule.kt            # Hilt数据库模块（Kotlin）
│   └── NetworkModule.kt             # Hilt网络模块（Kotlin）
├── ui/
│   └── screens/
│       ├── HomeScreen.kt            # 首页（Kotlin Compose）
│       └── UserListScreen.kt        # 用户列表页（Kotlin Compose）
├── navigation/
│   └── AppNavigation.kt             # 导航配置（Kotlin）
├── util/
│   ├── DateUtils.java               # 工具类（Java）
│   └── StringExtensions.kt          # Kotlin扩展函数（为Java类扩展功能）
├── work/
│   └── DataSyncWorker.kt            # WorkManager后台任务（Kotlin）
├── MainActivity.kt                  # 主Activity（Kotlin + Hilt）
└── MyApplication.kt                 # Application类（Kotlin + Hilt）
```

## 🔧 技术栈详解

### 1. Java & Kotlin 混编示例

#### Java类示例（User.java）
```java
@Entity(tableName = "users")
public class User {
    @PrimaryKey(autoGenerate = true)
    private Long id;
    private String name;
    private String email;
    private int age;
    // ... getters and setters
}
```

#### Kotlin调用Java类（UserDao.kt）
```kotlin
@Dao
interface UserDao {
    @Query("SELECT * FROM users")
    fun getAllUsers(): Flow<List<User>  // User是Java类
}
```

#### Kotlin扩展函数为Java类添加功能（StringExtensions.kt）
```kotlin
fun String.isValidEmail(): Boolean {
    return Patterns.EMAIL_ADDRESS.matcher(this).matches()
}
```

### 2. Jetpack Compose UI

- **声明式UI** - 使用@Composable函数构建UI
- **Material 3** - 最新的Material Design设计系统
- **状态管理** - 使用StateFlow和collectAsState()

### 3. Hilt 依赖注入

```kotlin
@HiltViewModel
class UserViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel()
```

### 4. Room 数据库

- **实体类**：User.java（Java编写）
- **DAO**：UserDao.kt（Kotlin编写）
- **数据库**：AppDatabase.kt（Kotlin编写）

### 5. Navigation Compose

```kotlin
NavHost(
    navController = navController,
    startDestination = "home"
) {
    composable("home") { HomeScreen(...) }
    composable("users") { UserListScreen(...) }
}
```

### 6. ViewModel + StateFlow

```kotlin
private val _users = MutableStateFlow<List<User>>(emptyList())
val users: StateFlow<List<User>> = _users.asStateFlow()
```

### 7. DataStore（替代SharedPreferences）

```kotlin
val userName: Flow<String> = context.dataStore.data.map { 
    preferences[USER_NAME_KEY] ?: "" 
}
```

### 8. WorkManager（后台任务）

```kotlin
class DataSyncWorker : CoroutineWorker(context, params) {
    override suspend fun doWork(): Result {
        // 执行后台任务
        return Result.success()
    }
}
```

## 🚀 快速开始

### 环境要求

- Android Studio Hedgehog (2023.1.1) 或更高版本
- JDK 11 或更高版本
- Android SDK API 24+ (Android 7.0)
- Target SDK 36 (Android 16)

### 构建步骤

1. **克隆项目**
   ```bash
   git clone <repository-url>
   cd AndroidJavaAndKotlinDemo
   ```

2. **同步Gradle**
   - 打开Android Studio
   - 点击 "Sync Project with Gradle Files"

3. **运行项目**
   - 连接Android设备或启动模拟器
   - 点击 "Run" 按钮

## 📦 依赖库版本

所有依赖版本在 `gradle/libs.versions.toml` 中统一管理：

- **AGP**: 8.13.2
- **Kotlin**: 2.0.21
- **Compose BOM**: 2024.09.00
- **Hilt**: 2.52
- **Room**: 2.6.1
- **Navigation**: 2.8.4
- **Retrofit**: 2.11.0
- **DataStore**: 1.1.1
- **WorkManager**: 2.10.0
- **CameraX**: 1.4.0
- **Paging**: 3.3.4

## 🎯 Java & Kotlin 互操作性

### Kotlin调用Java

1. **调用Java类**
   ```kotlin
   val user = User("张三", "zhangsan@example.com", 25)
   ```

2. **调用Java静态方法**
   ```kotlin
   val time = DateUtils.formatTime(Date())
   ```

### Java调用Kotlin

1. **调用Kotlin函数**
   ```java
   // Kotlin函数会被编译为静态方法
   String result = StringExtensionsKt.capitalizeFirst("hello");
   ```

2. **使用Kotlin扩展函数**
   ```java
   // 在Java中使用Kotlin扩展函数
   boolean isValid = StringExtensionsKt.isValidEmail("test@example.com");
   ```

## 🔍 核心功能演示

### 1. 用户列表管理
- 使用Room数据库存储用户数据
- ViewModel + StateFlow管理状态
- Compose UI展示数据

### 2. 网络请求
- Retrofit + OkHttp进行网络请求
- 支持GitHub API示例

### 3. 数据持久化
- Room数据库：结构化数据
- DataStore：键值对数据（替代SharedPreferences）

### 4. 后台任务
- WorkManager实现可靠的后台任务

## 📝 代码示例

### Java实体类 + Kotlin DAO

**User.java (Java)**
```java
@Entity(tableName = "users")
public class User {
    @PrimaryKey(autoGenerate = true)
    private Long id;
    private String name;
    // ...
}
```

**UserDao.kt (Kotlin)**
```kotlin
@Dao
interface UserDao {
    @Query("SELECT * FROM users")
    fun getAllUsers(): Flow<List<User>>
}
```

### Java工具类 + Kotlin扩展

**DateUtils.java (Java)**
```java
public class DateUtils {
    public static String formatTime(Date date) {
        // ...
    }
}
```

**StringExtensions.kt (Kotlin)**
```kotlin
fun String.isValidEmail(): Boolean {
    return Patterns.EMAIL_ADDRESS.matcher(this).matches()
}
```

## 🎓 学习要点

1. **Java和Kotlin可以在同一项目中无缝协作**
2. **Kotlin可以调用Java代码，反之亦然**
3. **Kotlin扩展函数可以为Java类添加功能**
4. **Room、Hilt等框架完美支持两种语言**
5. **Compose UI建议使用Kotlin编写**

## 📚 相关文档

- [Android官方文档](https://developer.android.com)
- [Kotlin官方文档](https://kotlinlang.org/docs/home.html)
- [Jetpack Compose](https://developer.android.com/jetpack/compose)
- [Hilt文档](https://developer.android.com/training/dependency-injection/hilt-android)
- [Room数据库](https://developer.android.com/training/data-storage/room)

## 🤝 贡献

欢迎提交Issue和Pull Request！

## 📄 许可证

本项目仅供学习和参考使用。

---

**注意**：本项目展示了2025年Android开发的最佳实践和现代技术栈。所有代码都遵循Google的官方推荐方案。

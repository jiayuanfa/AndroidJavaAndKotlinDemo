# Framework 功能列表 - 框架技术学习路径

## 📚 目录
1. [Jetpack Compose](#jetpack-compose)
2. [Hilt依赖注入](#hilt依赖注入)
3. [Room数据库](#room数据库)
4. [Navigation组件](#navigation组件)
5. [Retrofit网络框架](#retrofit网络框架)
6. [OkHttp HTTP客户端](#okhttp-http客户端)
7. [DataStore数据存储](#datastore数据存储)
8. [WorkManager后台任务](#workmanager后台任务)
9. [CameraX相机框架](#camerax相机框架)
10. [Paging分页库](#paging分页库)
11. [ViewModel和LiveData](#viewmodel和livedata)
12. [Kotlin协程框架](#kotlin协程框架)
13. [Coil图片加载](#coil图片加载)
14. [Material Design组件](#material-design组件)
15. [Gradle构建框架](#gradle构建框架)
16. [KSP注解处理](#ksp注解处理)
17. [其他Jetpack组件](#其他jetpack组件)
18. [第三方框架集成](#第三方框架集成)

---

## Jetpack Compose

### 1.1 Compose基础概念
- [ ] 声明式UI理念
- [ ] Composable函数
- [ ] 重组（Recomposition）机制
- [ ] 状态和记忆化（State & Remember）
- [ ] 副作用（Side Effects）
- [ ] Compose性能优化

### 1.2 Compose布局系统
- [ ] Column、Row、Box基础布局
- [ ] Modifier修饰符系统
- [ ] 布局约束（Constraints）
- [ ] 自定义布局
- [ ] LazyColumn和LazyRow（列表布局）
- [ ] 布局性能优化

### 1.3 Material 3组件
- [ ] Button、TextField、Card等基础组件
- [ ] Scaffold和TopAppBar
- [ ] NavigationRail和NavigationDrawer
- [ ] Material图标系统
- [ ] Material主题系统
- [ ] Material动画

### 1.4 Compose状态管理
- [ ] State和MutableState
- [ ] StateFlow集成（collectAsState）
- [ ] ViewModel集成
- [ ] 状态提升（State Hoisting）
- [ ] 状态恢复（State Restoration）

### 1.5 Compose导航
- [ ] Navigation Compose配置
- [ ] NavController使用
- [ ] 路由定义和参数传递
- [ ] 深层链接（Deep Links）
- [ ] 嵌套导航

### 1.6 Compose动画
- [ ] animateAsState
- [ ] Transition动画
- [ ] 手势动画
- [ ] 自定义动画

### 1.7 Compose高级特性
- [ ] 与View系统互操作
- [ ] Canvas自定义绘制
- [ ] 性能分析工具
- [ ] Compose测试

---

## Hilt依赖注入

### 2.1 Hilt基础
- [ ] Hilt的配置和设置
- [ ] @HiltAndroidApp注解
- [ ] @AndroidEntryPoint注解
- [ ] Hilt的工作原理

### 2.2 Hilt模块（Modules）
- [ ] @Module注解
- [ ] @Provides方法
- [ ] @InstallIn和组件作用域
- [ ] SingletonComponent
- [ ] ActivityComponent和FragmentComponent
- [ ] ViewModelComponent

### 2.3 Hilt注入
- [ ] 构造函数注入（@Inject）
- [ ] 字段注入
- [ ] 方法注入
- [ ] @HiltViewModel
- [ ] Hilt与Compose集成

### 2.4 Hilt限定符（Qualifiers）
- [ ] @Named限定符
- [ ] 自定义限定符
- [ ] 限定符的使用场景

### 2.5 Hilt作用域
- [ ] @Singleton作用域
- [ ] @ActivityRetainedScoped
- [ ] @ActivityScoped
- [ ] @FragmentScoped
- [ ] @ViewModelScoped

### 2.6 Hilt最佳实践
- [ ] 模块组织
- [ ] 依赖关系管理
- [ ] 测试中的Hilt使用

---

## Room数据库

### 3.1 Room基础
- [ ] Room架构组件
- [ ] Room的配置和依赖
- [ ] Room的三层架构（Entity、DAO、Database）

### 3.2 Entity实体类
- [ ] @Entity注解
- [ ] @PrimaryKey主键
- [ ] @ColumnInfo列信息
- [ ] @Ignore忽略字段
- [ ] 实体类的设计原则

### 3.3 DAO数据访问对象
- [ ] @Dao接口定义
- [ ] @Query查询方法
- [ ] @Insert插入方法
- [ ] @Update更新方法
- [ ] @Delete删除方法
- [ ] 复杂查询（JOIN、子查询等）

### 3.4 Database数据库类
- [ ] @Database注解
- [ ] 数据库版本管理
- [ ] 数据库迁移（Migration）
- [ ] fallbackToDestructiveMigration

### 3.5 Room高级特性
- [ ] 关系（Relations）
- [ ] 类型转换器（Type Converters）
- [ ] 数据库视图（Database Views）
- [ ] 全文搜索（FTS）
- [ ] Room与Flow集成
- [ ] Room与协程集成

### 3.6 Room性能优化
- [ ] 索引优化
- [ ] 查询优化
- [ ] 数据库性能分析

---

## Navigation组件

### 4.1 Navigation基础
- [ ] Navigation Component架构
- [ ] 导航图（Navigation Graph）
- [ ] NavController
- [ ] NavHost和NavHostFragment

### 4.2 Navigation Compose
- [ ] Navigation Compose配置
- [ ] composable()路由定义
- [ ] NavController在Compose中使用
- [ ] 参数传递（Arguments）
- [ ] 深层链接（Deep Links）

### 4.3 Navigation高级特性
- [ ] 导航选项（NavOptions）
- [ ] 导航结果（Navigation Result）
- [ ] 条件导航
- [ ] 嵌套导航图
- [ ] 自定义导航器

### 4.4 Navigation与Hilt集成
- [ ] hilt-navigation-compose
- [ ] ViewModel注入
- [ ] 导航作用域

---

## Retrofit网络框架

### 5.1 Retrofit基础
- [ ] Retrofit的配置
- [ ] Retrofit.Builder
- [ ] 基础URL配置
- [ ] Converter工厂

### 5.2 API接口定义
- [ ] 接口方法定义
- [ ] @GET、@POST、@PUT、@DELETE注解
- [ ] @Path路径参数
- [ ] @Query查询参数
- [ ] @Body请求体
- [ ] @Header和@Headers
- [ ] @FormUrlEncoded和@Field
- [ ] @Multipart文件上传

### 5.3 Retrofit转换器
- [ ] GsonConverterFactory
- [ ] MoshiConverterFactory
- [ ] 自定义Converter
- [ ] 响应类型处理

### 5.4 Retrofit拦截器
- [ ] 请求拦截器
- [ ] 响应拦截器
- [ ] 认证拦截器
- [ ] 日志拦截器

### 5.5 Retrofit与协程
- [ ] suspend函数
- [ ] 异常处理
- [ ] Flow集成

### 5.6 Retrofit最佳实践
- [ ] API接口设计
- [ ] 错误处理
- [ ] 重试机制
- [ ] 缓存策略

---

## OkHttp HTTP客户端

### 6.1 OkHttp基础
- [ ] OkHttpClient配置
- [ ] Request和Response
- [ ] 同步和异步请求
- [ ] Call和CallBack

### 6.2 OkHttp拦截器
- [ ] Interceptor接口
- [ ] 应用拦截器（Application Interceptors）
- [ ] 网络拦截器（Network Interceptors）
- [ ] 拦截器链（Chain）
- [ ] 请求和响应修改

### 6.3 OkHttp缓存
- [ ] Cache配置
- [ ] 缓存策略
- [ ] 缓存控制（Cache-Control）
- [ ] 缓存验证

### 6.4 OkHttp连接管理
- [ ] ConnectionPool连接池
- [ ] 连接复用
- [ ] 超时配置
- [ ] 重试机制

### 6.5 OkHttp与Retrofit集成
- [ ] Retrofit使用OkHttp作为底层客户端
- [ ] 统一配置和管理

---

## DataStore数据存储

### 7.1 DataStore基础
- [ ] DataStore的优势（vs SharedPreferences）
- [ ] Preferences DataStore
- [ ] Proto DataStore
- [ ] DataStore的配置

### 7.2 Preferences DataStore
- [ ] Preferences DataStore创建
- [ ] 数据读写操作
- [ ] key定义和使用
- [ ] 数据类型支持

### 7.3 Proto DataStore
- [ ] Protocol Buffers
- [ ] Proto定义
- [ ] Proto DataStore使用
- [ ] 类型安全

### 7.4 DataStore迁移
- [ ] 从SharedPreferences迁移
- [ ] 数据迁移策略

### 7.5 DataStore与Flow集成
- [ ] DataStore作为Flow数据源
- [ ] 响应式数据更新
- [ ] 在ViewModel中使用

---

## WorkManager后台任务

### 8.1 WorkManager基础
- [ ] WorkManager的优势
- [ ] WorkManager的配置
- [ ] Worker类
- [ ] WorkRequest
- [ ] WorkManager调度

### 8.2 Worker类型
- [ ] Worker（同步任务）
- [ ] CoroutineWorker（协程任务）
- [ ] RxWorker（RxJava任务）
- [ ] ListenableWorker

### 8.3 工作请求类型
- [ ] OneTimeWorkRequest（一次性任务）
- [ ] PeriodicWorkRequest（周期性任务）
- [ ] 工作约束（Constraints）
- [ ] 工作输入和输出

### 8.4 工作链和组合
- [ ] WorkContinuation
- [ ] 顺序执行（beginWith、then）
- [ ] 并行执行（combine）
- [ ] 工作链取消

### 8.5 工作状态和观察
- [ ] WorkInfo
- [ ] 工作状态观察
- [ ] 工作状态查询

### 8.6 WorkManager最佳实践
- [ ] 任务设计原则
- [ ] 性能考虑
- [ ] 电池优化

---

## CameraX相机框架

### 9.1 CameraX基础
- [ ] CameraX架构
- [ ] CameraX的优势
- [ ] CameraX的配置和依赖

### 9.2 CameraX用例（Use Cases）
- [ ] Preview用例（预览）
- [ ] ImageCapture用例（拍照）
- [ ] ImageAnalysis用例（图像分析）
- [ ] VideoCapture用例（录制视频）

### 9.3 CameraX生命周期
- [ ] 生命周期绑定（LifecycleOwner）
- [ ] ProcessCameraProvider
- [ ] CameraSelector
- [ ] Camera实例管理

### 9.4 CameraX高级特性
- [ ] 相机控制（CameraControl）
- [ ] 相机信息（CameraInfo）
- [ ] 图像处理和分析
- [ ] 多相机支持

### 9.5 CameraX最佳实践
- [ ] 性能优化
- [ ] 权限处理
- [ ] 错误处理

---

## Paging分页库

### 10.1 Paging基础
- [ ] Paging 3架构
- [ ] PagingData
- [ ] Pager配置
- [ ] PagingSource

### 10.2 数据源类型
- [ ] RemoteMediator（网络+本地）
- [ ] PagingSource（单一数据源）
- [ ] 数据加载策略

### 10.3 Paging与UI集成
- [ ] RecyclerView集成
- [ ] Compose集成（collectAsLazyPagingItems）
- [ ] 加载状态处理
- [ ] 占位符（Placeholder）

### 10.4 Paging高级特性
- [ ] 数据转换
- [ ] 错误处理
- [ ] 刷新和重试
- [ ] 预加载配置

---

## ViewModel和LiveData

### 11.1 ViewModel
- [ ] ViewModel生命周期
- [ ] ViewModel的创建
- [ ] ViewModel与Activity/Fragment
- [ ] ViewModel与Compose
- [ ] ViewModelFactory

### 11.2 LiveData
- [ ] LiveData概念
- [ ] MutableLiveData
- [ ] LiveData观察（observe）
- [ ] Transformations（map、switchMap）
- [ ] MediatorLiveData

### 11.3 ViewModel与LiveData集成
- [ ] ViewModel中暴露LiveData
- [ ] LiveData在UI中的使用
- [ ] LiveData vs StateFlow

---

## Kotlin协程框架

### 12.1 协程基础（在Android中）
- [ ] 协程在Android中的应用
- [ ] CoroutineScope
- [ ] viewModelScope
- [ ] lifecycleScope
- [ ] Dispatchers（Main、IO、Default）

### 12.2 协程与Android组件集成
- [ ] 协程与Room集成
- [ ] 协程与Retrofit集成
- [ ] 协程与WorkManager集成

### 12.3 Flow在Android中的应用
- [ ] StateFlow和SharedFlow
- [ ] Flow收集（collect）
- [ ] Flow与UI集成（collectAsState）
- [ ] Flow操作符

---

## Coil图片加载

### 13.1 Coil基础
- [ ] Coil的配置
- [ ] ImageLoader
- [ ] 基本图片加载

### 13.2 Coil高级特性
- [ ] 图片转换（Transformations）
- [ ] 占位符和错误图片
- [ ] 缓存策略
- [ ] 内存和磁盘缓存

### 13.3 Coil与Compose集成
- [ ] AsyncImage组件
- [ ] rememberAsyncImagePainter
- [ ] Compose中的图片加载

---

## Material Design组件

### 14.1 Material Components基础
- [ ] Material Design 3
- [ ] Material主题系统
- [ ] Material颜色系统
- [ ] Material排版系统

### 14.2 Material Components（View系统）
- [ ] MaterialButton
- [ ] MaterialCardView
- [ ] TextInputLayout
- [ ] BottomNavigationView
- [ ] NavigationView

### 14.3 Material Components（Compose）
- [ ] Material 3组件库
- [ ] Material主题配置
- [ ] Material图标

---

## Gradle构建框架

### 15.1 Gradle基础
- [ ] Gradle构建系统
- [ ] build.gradle文件
- [ ] Gradle插件
- [ ] 任务（Tasks）

### 15.2 Android Gradle Plugin
- [ ] AGP配置
- [ ] 构建变体（Build Variants）
- [ ] 构建类型（Build Types）
- [ ] 产品风味（Product Flavors）
- [ ] 签名配置

### 15.3 依赖管理
- [ ] 依赖声明
- [ ] 版本目录（Version Catalogs）
- [ ] 依赖解析
- [ ] 依赖冲突解决

### 15.4 Gradle Kotlin DSL
- [ ] build.gradle.kts
- [ ] Kotlin DSL语法
- [ ] 类型安全的配置

---

## KSP注解处理

### 16.1 KSP基础
- [ ] KSP vs KAPT
- [ ] KSP的配置
- [ ] KSP的优势（性能）

### 16.2 KSP使用场景
- [ ] Room使用KSP
- [ ] Hilt使用KSP
- [ ] 自定义注解处理

---

## 其他Jetpack组件

### 17.1 Data Binding
- [ ] Data Binding配置
- [ ] 布局表达式
- [ ] 双向数据绑定
- [ ] BindingAdapter

### 17.2 View Binding
- [ ] View Binding配置
- [ ] View Binding使用
- [ ] View Binding vs findViewById

### 17.3 App Startup
- [ ] App Startup库
- [ ] 初始化优化
- [ ] Initializer定义

### 17.4 Security
- [ ] EncryptedSharedPreferences
- [ ] EncryptedFile
- [ ] 密钥管理

---

## 第三方框架集成

### 18.1 图片处理框架
- [ ] Glide
- [ ] Picasso
- [ ] Coil（已包含）

### 18.2 JSON解析框架
- [ ] Gson
- [ ] Moshi
- [ ] Jackson

### 18.3 日志框架
- [ ] Timber
- [ ] Logger

### 18.4 数据库框架
- [ ] Room（已包含）
- [ ] Realm
- [ ] GreenDAO

### 18.5 事件总线
- [ ] EventBus
- [ ] RxBus（RxJava）
- [ ] Kotlin Flow替代

---

## 📝 项目中的应用示例

### 当前项目中使用的框架：

1. **Jetpack Compose**
   - 声明式UI框架
   - Material 3主题
   - Navigation Compose
   - StateFlow状态管理

2. **Hilt依赖注入**
   - @HiltAndroidApp
   - @AndroidEntryPoint
   - @Module和@Provides
   - @HiltViewModel
   - DatabaseModule和NetworkModule

3. **Room数据库**
   - Entity（User.java）
   - DAO（UserDao.kt）
   - Database（AppDatabase.kt）
   - Flow集成

4. **Navigation Compose**
   - NavHost配置
   - 路由定义
   - 参数传递

5. **Retrofit + OkHttp**
   - Retrofit配置
   - ApiService接口定义
   - OkHttp拦截器
   - 协程集成

6. **DataStore**
   - DataStoreManager
   - Preferences DataStore
   - Flow集成

7. **WorkManager**
   - DataSyncWorker
   - CoroutineWorker
   - 后台任务管理

8. **ViewModel + StateFlow**
   - UserViewModel
   - StateFlow状态管理
   - viewModelScope

9. **Kotlin协程**
   - suspend函数
   - Flow响应式编程
   - viewModelScope

---

## 🎯 学习建议

1. **初学者路径**：
   Room → ViewModel → Navigation → Hilt → Retrofit

2. **进阶路径**：
   Jetpack Compose → WorkManager → DataStore → CameraX → Paging

3. **高级路径**：
   框架原理深入 → 性能优化 → 自定义框架 → 框架集成最佳实践

4. **现代Android开发重点**：
   Jetpack Compose + Hilt + Room + Navigation + ViewModel + 协程

---

## 📚 推荐资源

- [Jetpack官方文档](https://developer.android.com/jetpack)
- [Android开发者指南](https://developer.android.com/guide)
- [各框架官方GitHub仓库](https://github.com/android)
- [Android架构指南](https://developer.android.com/topic/architecture)

---

## 🔄 Jetpack组件演进

- **2017年**: Architecture Components发布（Room、LiveData、ViewModel）
- **2018年**: Navigation Component发布
- **2019年**: Jetpack Compose预览版发布
- **2020年**: Hilt发布（替代Dagger Android）
- **2021年**: Jetpack Compose 1.0正式版
- **2022年**: Material 3支持、Compose稳定
- **2023年**: Compose性能优化、新组件
- **2024年**: Compose持续演进、新特性

---

*最后更新：2025年*


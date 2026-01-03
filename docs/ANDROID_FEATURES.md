# Android 功能列表 - 重难点学习路径

## 📚 目录
1. [Android基础架构](#android基础架构)
2. [Activity和Fragment](#activity和fragment)
3. [UI开发基础](#ui开发基础)
4. [Jetpack Compose](#jetpack-compose)
5. [数据存储](#数据存储)
6. [网络请求](#网络请求)
7. [架构组件（Architecture Components）](#架构组件architecture-components)
8. [依赖注入](#依赖注入)
9. [导航（Navigation）](#导航navigation)
10. [后台任务](#后台任务)
11. [权限管理](#权限管理)
12. [多媒体开发](#多媒体开发)
13. [通知系统](#通知系统)
14. [应用生命周期](#应用生命周期)
15. [性能优化](#性能优化)
16. [安全性](#安全性)
17. [测试](#测试)
18. [发布和分发](#发布和分发)

---

## Android基础架构

### 1.1 Android系统架构
- [ ] Android系统分层架构
  - [ ] Linux内核层
  - [ ] 硬件抽象层（HAL）
  - [ ] Android Runtime（ART）
  - [ ] 原生C/C++库
  - [ ] Java API框架
  - [ ] 系统应用层
- [ ] Android应用组件
- [ ] AndroidManifest.xml的作用和配置

### 1.2 应用基础知识
- [ ] 应用包名（Package Name）
- [ ] 应用签名（Application Signing）
- [ ] 应用版本（Version Code和Version Name）
- [ ] 最小SDK和目标SDK
- [ ] 应用权限声明
- [ ] 应用图标和名称

### 1.3 Gradle构建系统
- [ ] build.gradle文件结构
- [ ] 依赖管理（Dependencies）
- [ ] 构建变体（Build Variants）
- [ ] 构建类型（Build Types）
- [ ] 产品风味（Product Flavors）
- [ ] 签名配置（Signing Configs）

---

## Activity和Fragment

### 2.1 Activity基础
- [ ] Activity生命周期
  - [ ] onCreate()
  - [ ] onStart()
  - [ ] onResume()
  - [ ] onPause()
  - [ ] onStop()
  - [ ] onDestroy()
  - [ ] onRestart()
- [ ] Activity的创建和启动
- [ ] Intent和Intent Filter
- [ ] Activity之间的数据传递
- [ ] Activity启动模式（Launch Mode）
- [ ] Activity任务栈（Task Stack）

### 2.2 Fragment基础
- [ ] Fragment生命周期
- [ ] Fragment的创建和添加
- [ ] Fragment与Activity通信
- [ ] Fragment之间的通信
- [ ] Fragment事务（Transaction）
- [ ] Fragment回退栈（Back Stack）

### 2.3 Activity和Fragment高级
- [ ] ViewModel在Activity和Fragment中的使用
- [ ] 配置变更处理（Configuration Changes）
- [ ] 保存和恢复状态（Save/Restore State）
- [ ] Fragment结果API（Fragment Result API）
- [ ] Navigation Component与Fragment

---

## UI开发基础

### 3.1 View系统
- [ ] View和ViewGroup
- [ ] View的绘制流程（Measure、Layout、Draw）
- [ ] 自定义View
- [ ] 自定义ViewGroup
- [ ] View的事件分发机制（Touch Event）
- [ ] 动画（Animation和Animator）

### 3.2 布局（Layout）
- [ ] LinearLayout
- [ ] RelativeLayout
- [ ] ConstraintLayout（推荐）
- [ ] FrameLayout
- [ ] GridLayout
- [ ] TableLayout
- [ ] 布局性能优化

### 3.3 常用UI组件
- [ ] TextView和EditText
- [ ] Button和ImageButton
- [ ] ImageView
- [ ] RecyclerView和ListView
- [ ] ScrollView和NestedScrollView
- [ ] Spinner和AutoCompleteTextView
- [ ] CheckBox和RadioButton
- [ ] ProgressBar和ProgressDialog
- [ ] WebView

### 3.4 Material Design
- [ ] Material Design设计原则
- [ ] Material Components库
- [ ] 主题（Theme）和样式（Style）
- [ ] 颜色系统（Color System）
- [ ] 文字排版（Typography）
- [ ] 形状（Shape）
- [ ] 阴影和Elevation

### 3.5 资源管理
- [ ] 资源类型（drawable、layout、values等）
- [ ] 资源限定符（Qualifiers）
- [ ] 多屏幕支持（Multi-screen Support）
- [ ] 字符串资源（String Resources）
- [ ] 颜色资源（Color Resources）
- [ ] 尺寸资源（Dimension Resources）

---

## Jetpack Compose

### 4.1 Compose基础
- [ ] Compose的声明式UI理念
- [ ] @Composable函数
- [ ] Compose的构建和重组（Recomposition）
- [ ] 状态管理（State）
- [ ] 记忆化（Remember）
- [ ] 副作用（Side Effects）

### 4.2 Compose布局
- [ ] 基础布局组件（Column、Row、Box）
- [ ] 修饰符（Modifier）
- [ ] 间距和填充（Padding、Margin）
- [ ] 尺寸约束（Constraints）
- [ ] 自定义布局
- [ ] 布局性能优化

### 4.3 Compose Material
- [ ] Material 3组件
- [ ] Button、TextField、Card等组件
- [ ] 图标系统（Icons）
- [ ] 主题系统（Theme）
- [ ] 颜色系统（Color Scheme）
- [ ] 文字样式（Typography）

### 4.4 Compose状态管理
- [ ] 状态提升（State Hoisting）
- [ ] State和MutableState
- [ ] StateFlow和collectAsState()
- [ ] ViewModel与Compose集成
- [ ] 状态恢复（State Restoration）

### 4.5 Compose导航
- [ ] Navigation Compose
- [ ] NavController和NavHost
- [ ] 路由和参数传递
- [ ] 深链接（Deep Links）
- [ ] 嵌套导航

### 4.6 Compose动画
- [ ] 动画API（animateAsState、animateColorAsState等）
- [ ] Transition动画
- [ ] 手势动画
- [ ] 自定义动画

### 4.7 Compose高级特性
- [ ] 性能优化（LazyColumn、LazyRow）
- [ ] 自定义绘制（Canvas）
- [ ] 与View系统互操作
- [ ] Compose测试

---

## 数据存储

### 5.1 SharedPreferences
- [ ] SharedPreferences的使用
- [ ] 数据读写操作
- [ ] SharedPreferences的限制
- [ ] 多进程SharedPreferences

### 5.2 DataStore（推荐）
- [ ] DataStore的优势
- [ ] Preferences DataStore
- [ ] Proto DataStore
- [ ] DataStore迁移（Migration）
- [ ] DataStore与Flow集成

### 5.3 Room数据库
- [ ] Room架构组件
- [ ] Entity（实体类）
- [ ] DAO（数据访问对象）
- [ ] Database（数据库类）
- [ ] 数据库迁移（Migration）
- [ ] 关系（Relations）
- [ ] 类型转换器（Type Converters）
- [ ] Room与Flow集成

### 5.4 文件存储
- [ ] 内部存储（Internal Storage）
- [ ] 外部存储（External Storage）
- [ ] Scoped Storage（分区存储）
- [ ] MediaStore API
- [ ] SAF（Storage Access Framework）

### 5.5 内容提供者（ContentProvider）
- [ ] ContentProvider的概念
- [ ] ContentProvider的创建和使用
- [ ] ContentResolver
- [ ] URI和MIME类型
- [ ] 系统ContentProvider的使用

---

## 网络请求

### 6.1 HTTP基础
- [ ] HTTP协议基础
- [ ] HTTP方法（GET、POST、PUT、DELETE等）
- [ ] HTTP状态码
- [ ] HTTP头和Cookie

### 6.2 Retrofit
- [ ] Retrofit的配置
- [ ] API接口定义
- [ ] 请求注解（@GET、@POST等）
- [ ] 参数注解（@Path、@Query、@Body等）
- [ ] 请求和响应拦截器
- [ ] 错误处理
- [ ] Retrofit与协程集成

### 6.3 OkHttp
- [ ] OkHttp的配置
- [ ] Request和Response
- [ ] 拦截器（Interceptors）
- [ ] 缓存策略
- [ ] 连接池管理
- [ ] Cookie管理

### 6.4 数据解析
- [ ] JSON解析（Gson、Moshi）
- [ ] XML解析
- [ ] Protobuf
- [ ] 自定义转换器（Converter）

### 6.5 网络最佳实践
- [ ] 网络请求的最佳实践
- [ ] 错误处理和重试机制
- [ ] 网络状态监听
- [ ] 离线缓存策略

---

## 架构组件（Architecture Components）

### 7.1 ViewModel
- [ ] ViewModel的生命周期
- [ ] ViewModel的创建和使用
- [ ] ViewModel与Activity/Fragment
- [ ] ViewModel与Compose
- [ ] ViewModel的作用域

### 7.2 LiveData
- [ ] LiveData的概念和特点
- [ ] LiveData的观察（observe）
- [ ] MutableLiveData
- [ ] Transformations（map、switchMap）
- [ ] MediatorLiveData
- [ ] LiveData vs StateFlow

### 7.3 数据绑定（Data Binding）
- [ ] Data Binding的配置
- [ ] 布局表达式
- [ ] 双向数据绑定
- [ ] BindingAdapter

### 7.4 视图绑定（View Binding）
- [ ] View Binding的配置和使用
- [ ] View Binding vs findViewById
- [ ] View Binding与Fragment

### 7.5 生命周期感知组件
- [ ] LifecycleOwner和LifecycleObserver
- [ ] 生命周期状态和事件
- [ ] 自定义生命周期感知组件

---

## 依赖注入

### 8.1 依赖注入概念
- [ ] 依赖注入的原理和优势
- [ ] 控制反转（IoC）
- [ ] 手动依赖注入 vs 框架依赖注入

### 8.2 Hilt（推荐）
- [ ] Hilt的配置和设置
- [ ] @HiltAndroidApp
- [ ] @AndroidEntryPoint
- [ ] @HiltViewModel
- [ ] @Module和@Provides
- [ ] @InstallIn和组件作用域
- [ ] Hilt与Compose集成

### 8.3 Dagger
- [ ] Dagger的基础概念
- [ ] @Component和@Module
- [ ] @Inject和@Provides
- [ ] 作用域（@Singleton等）
- [ ] 子组件（Subcomponent）

### 8.4 Koin（Kotlin原生DI框架）
- [ ] Koin的配置
- [ ] 模块定义
- [ ] 依赖注入
- [ ] 作用域管理

---

## 导航（Navigation）

### 9.1 Navigation Component基础
- [ ] Navigation Component的配置
- [ ] 导航图（Navigation Graph）
- [ ] NavController
- [ ] NavHost和NavHostFragment
- [ ] 目标（Destination）和操作（Action）

### 9.2 Navigation Compose
- [ ] Navigation Compose的配置
- [ ] composable()路由定义
- [ ] NavController在Compose中的使用
- [ ] 参数传递
- [ ] 深层链接

### 9.3 导航高级特性
- [ ] 导航参数（Arguments）
- [ ] 导航选项（NavOptions）
- [ ] 导航结果（Navigation Result）
- [ ] 条件导航
- [ ] 嵌套导航图

---

## 后台任务

### 10.1 线程和Handler
- [ ] 主线程（UI线程）
- [ ] 工作线程
- [ ] Handler和Looper
- [ ] HandlerThread
- [ ] AsyncTask（已过时）

### 10.2 协程（Coroutines）
- [ ] 协程在Android中的应用
- [ ] CoroutineScope
- [ ] viewModelScope和lifecycleScope
- [ ] Dispatchers（Main、IO、Default）
- [ ] 协程与Room、Retrofit集成

### 10.3 WorkManager
- [ ] WorkManager的优势
- [ ] Worker和WorkRequest
- [ ] 一次性任务和周期性任务
- [ ] 工作约束（Constraints）
- [ ] 工作链（Work Chain）
- [ ] 工作状态观察
- [ ] 工作输入和输出

### 10.4 JobScheduler和AlarmManager
- [ ] JobScheduler的使用
- [ ] AlarmManager的使用
- [ ] 后台任务的选择

---

## 权限管理

### 11.1 权限系统
- [ ] 权限的类型（普通权限、危险权限）
- [ ] 权限声明（AndroidManifest.xml）
- [ ] 运行时权限（Runtime Permissions）

### 11.2 权限请求
- [ ] 权限请求流程
- [ ] Activity的权限请求
- [ ] Fragment的权限请求
- [ ] 权限请求结果处理
- [ ] 权限请求库（如PermissionsDispatcher）

### 11.3 常见权限
- [ ] 存储权限（Storage）
- [ ] 相机权限（Camera）
- [ ] 位置权限（Location）
- [ ] 电话权限（Phone）
- [ ] 联系人权限（Contacts）

---

## 多媒体开发

### 12.1 相机（Camera）
- [ ] Camera2 API
- [ ] CameraX（推荐）
  - [ ] Preview用例
  - [ ] ImageCapture用例
  - [ ] ImageAnalysis用例
  - [ ] CameraX生命周期绑定

### 12.2 图片处理
- [ ] 图片加载（Glide、Coil）
- [ ] 图片压缩
- [ ] 图片裁剪
- [ ] 图片缓存策略

### 12.3 音频和视频
- [ ] MediaPlayer
- [ ] ExoPlayer
- [ ] 音频录制（MediaRecorder）
- [ ] 视频录制

---

## 通知系统

### 13.1 通知基础
- [ ] NotificationManager
- [ ] NotificationChannel（Android 8.0+）
- [ ] 通知的创建和显示
- [ ] 通知样式（BigText、BigPicture等）

### 13.2 通知高级特性
- [ ] 通知操作（Actions）
- [ ] 通知分组
- [ ] 前台服务通知
- [ ] 通知优先级和重要性

---

## 应用生命周期

### 14.1 Application类
- [ ] Application生命周期
- [ ] Application的创建和配置
- [ ] 全局初始化

### 14.2 进程生命周期
- [ ] 前台进程
- [ ] 可见进程
- [ ] 服务进程
- [ ] 后台进程
- [ ] 空进程

### 14.3 内存管理
- [ ] 内存泄漏的识别和预防
- [ ] LeakCanary的使用
- [ ] 内存优化技巧

---

## 性能优化

### 15.1 启动优化
- [ ] 冷启动、温启动、热启动
- [ ] 启动时间优化
- [ ] 启动画面（Splash Screen）

### 15.2 布局优化
- [ ] 布局层次优化
- [ ] 过度绘制（Overdraw）优化
- [ ] 布局性能分析工具

### 15.3 内存优化
- [ ] 内存泄漏检测
- [ ] 大对象优化
- [ ] 图片内存优化

### 15.4 网络优化
- [ ] 网络请求优化
- [ ] 图片加载优化
- [ ] 缓存策略

### 15.5 电池优化
- [ ] 后台任务优化
- [ ] 位置服务优化
- [ ] 唤醒锁定（Wake Lock）管理

---

## 安全性

### 16.1 数据安全
- [ ] 数据加密（Encryption）
- [ ] SharedPreferences安全存储
- [ ] 密钥管理（KeyStore）

### 16.2 网络安全
- [ ] HTTPS和证书锁定（Certificate Pinning）
- [ ] 网络安全配置（Network Security Config）

### 16.3 代码安全
- [ ] 代码混淆（ProGuard/R8）
- [ ] 反编译防护
- [ ] 代码签名

---

## 测试

### 17.1 单元测试
- [ ] JUnit测试框架
- [ ] Mockito（Mock框架）
- [ ] ViewModel测试
- [ ] Repository测试

### 17.2 集成测试
- [ ] Espresso（UI测试）
- [ ] UI自动化测试
- [ ] 数据库测试

### 17.3 测试最佳实践
- [ ] 测试金字塔
- [ ] 测试覆盖率
- [ ] CI/CD集成测试

---

## 发布和分发

### 18.1 应用打包
- [ ] 构建APK
- [ ] 构建AAB（Android App Bundle）
- [ ] 签名配置
- [ ] 版本管理

### 18.2 Google Play发布
- [ ] Play Console配置
- [ ] 应用上架流程
- [ ] 应用更新
- [ ] 内测和公测

### 18.3 应用分析
- [ ] Firebase Analytics
- [ ] 崩溃报告（Crash Reporting）
- [ ] 性能监控

---

## 📝 项目中的应用示例

### 当前项目中使用的Android特性：

1. **Jetpack Compose** - `MainActivity.kt`, `HomeScreen.kt`, `UserListScreen.kt`
   - 声明式UI
   - Material 3主题
   - 状态管理（StateFlow）
   - Navigation Compose

2. **Room数据库** - `AppDatabase.kt`, `UserDao.kt`, `User.java`
   - Entity实体类
   - DAO数据访问
   - Flow响应式数据

3. **ViewModel** - `UserViewModel.kt`
   - viewModelScope
   - StateFlow状态管理
   - 与Compose集成

4. **Hilt依赖注入** - `MyApplication.kt`, `DatabaseModule.kt`, `NetworkModule.kt`
   - @HiltAndroidApp
   - @AndroidEntryPoint
   - @Module和@Provides
   - @HiltViewModel

5. **Navigation** - `AppNavigation.kt`
   - Navigation Compose
   - 路由配置

6. **DataStore** - `DataStoreManager.kt`
   - Preferences DataStore
   - Flow集成

7. **Retrofit + OkHttp** - `NetworkModule.kt`, `ApiService.kt`
   - Retrofit配置
   - OkHttp拦截器
   - 协程集成

8. **WorkManager** - `DataSyncWorker.kt`
   - CoroutineWorker
   - 后台任务

9. **Edge-to-Edge** - `MainActivity.kt`
   - enableEdgeToEdge()
   - 现代UI设计

---

## 🎯 学习建议

1. **初学者路径**：
   Android基础 → Activity/Fragment → UI开发 → 数据存储 → 网络请求

2. **进阶路径**：
   架构组件 → Jetpack Compose → 依赖注入 → 协程 → WorkManager

3. **高级路径**：
   性能优化 → 安全性 → 测试 → 发布分发 → 架构设计

4. **现代Android开发重点**：
   Jetpack Compose → Kotlin协程 → Hilt → Room → Navigation → ViewModel

---

## 📚 推荐资源

- [Android官方文档](https://developer.android.com)
- [Android开发者指南](https://developer.android.com/guide)
- [Jetpack文档](https://developer.android.com/jetpack)
- [Material Design指南](https://material.io/design)
- [Android官方示例代码](https://github.com/android)

---

## 🔄 Android版本演进

- **Android 5.0 (Lollipop)**: Material Design
- **Android 6.0 (Marshmallow)**: 运行时权限
- **Android 8.0 (Oreo)**: 通知渠道、后台限制
- **Android 9.0 (Pie)**: 分区存储、Wi-Fi限制
- **Android 10 (Q)**: 手势导航、暗黑主题
- **Android 11 (R)**: 对话通知、一次性权限
- **Android 12 (S)**: Material You、隐私仪表板
- **Android 13 (T)**: 主题图标、照片选择器
- **Android 14 (U)**: 部分照片访问、预测性返回
- **Android 15 (V)**: Edge-to-Edge、预测性返回动画

---

*最后更新：2025年*


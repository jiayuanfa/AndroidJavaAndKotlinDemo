# Kotlin 功能列表 - 重难点学习路径

## 📚 目录
1. [基础语法](#基础语法)
2. [面向对象编程](#面向对象编程)
3. [函数式编程](#函数式编程)
4. [协程（Coroutines）](#协程coroutines)
5. [扩展函数和属性](#扩展函数和属性)
6. [委托（Delegation）](#委托delegation)
7. [泛型（Generics）](#泛型generics)
8. [集合操作](#集合操作)
9. [空安全（Null Safety）](#空安全null-safety)
10. [数据类和密封类](#数据类和密封类)
11. [作用域函数](#作用域函数)
12. [操作符重载](#操作符重载)
13. [内联函数](#内联函数)
14. [反射（Reflection）](#反射reflection)
15. [注解处理](#注解处理)
16. [Kotlin与Java互操作](#kotlin与java互操作)
17. [DSL构建](#dsl构建)
18. [多平台开发（KMM）](#多平台开发kmm)

---

## 基础语法

### 1.1 变量声明
- [ ] `val` vs `var` 的区别和使用场景
- [ ] 类型推断（Type Inference）
- [ ] 显式类型声明
- [ ] 常量（const val）的使用

### 1.2 数据类型
- [ ] 基本数据类型（Int, Long, Double, Float, Boolean, Char）
- [ ] 可空类型（Nullable Types）和不可空类型
- [ ] 类型转换（显式和隐式）
- [ ] 字符串模板和原始字符串

### 1.3 控制流
- [ ] if表达式（作为表达式使用）
- [ ] when表达式（强大的switch替代）
- [ ] for循环和范围（Range）
- [ ] while和do-while循环
- [ ] break和continue标签

### 1.4 函数基础
- [ ] 函数声明和调用
- [ ] 默认参数
- [ ] 命名参数
- [ ] 可变参数（vararg）
- [ ] 单表达式函数

---

## 面向对象编程

### 2.1 类和对象
- [ ] 类声明（class）
- [ ] 构造函数（主构造函数和次构造函数）
- [ ] 初始化块（init）
- [ ] 对象声明（object）和单例模式
- [ ] 伴生对象（companion object）

### 2.2 属性和字段
- [ ] 属性声明（var/val）
- [ ] 自定义getter和setter
- [ ] 幕后字段（field）
- [ ] 延迟初始化（lateinit）
- [ ] 属性委托

### 2.3 继承和多态
- [ ] 类的继承（open关键字）
- [ ] 方法重写（override）
- [ ] 抽象类和接口
- [ ] 接口中的默认实现
- [ ] 多接口实现

### 2.4 可见性修饰符
- [ ] public, private, protected, internal
- [ ] 模块（Module）概念
- [ ] 可见性在包级别和类级别的区别

---

## 函数式编程

### 3.1 高阶函数
- [ ] 函数作为参数
- [ ] 函数作为返回值
- [ ] Lambda表达式语法
- [ ] it参数（单个参数的Lambda简写）
- [ ] 尾随Lambda（Trailing Lambda）

### 3.2 集合操作
- [ ] map, filter, reduce, fold
- [ ] flatMap, flatten
- [ ] groupBy, partition
- [ ] take, drop, slice
- [ ] distinct, sorted
- [ ] find, first, last
- [ ] any, all, none
- [ ] 序列（Sequence）的延迟计算

### 3.3 函数类型
- [ ] 函数类型声明（(Int, String) -> Boolean）
- [ ] 函数类型别名（typealias）
- [ ] 调用函数类型
- [ ] Lambda表达式类型推断

---

## 协程（Coroutines）

### 4.1 协程基础
- [ ] 协程概念和优势
- [ ] 协程vs线程
- [ ] 挂起函数（suspend）
- [ ] 协程构建器（launch, async, runBlocking）
- [ ] 协程作用域（CoroutineScope）

### 4.2 协程上下文和调度器
- [ ] Dispatchers.Main, IO, Default, Unconfined
- [ ] 协程上下文（CoroutineContext）
- [ ] Job和SupervisorJob
- [ ] 上下文切换（withContext）

### 4.3 流（Flow）
- [ ] Flow概念和创建
- [ ] 冷流vs热流
- [ ] StateFlow和SharedFlow
- [ ] Flow操作符（map, filter, transform等）
- [ ] Flow收集（collect）
- [ ] 背压（Backpressure）处理

### 4.4 协程异常处理
- [ ] try-catch在协程中的使用
- [ ] CoroutineExceptionHandler
- [ ] SupervisorJob的异常处理
- [ ] async的异常传播

### 4.5 Android中的协程
- [ ] viewModelScope
- [ ] lifecycleScope
- [ ] 协程与生命周期
- [ ] Room和Retrofit的suspend函数

---

## 扩展函数和属性

### 5.1 扩展函数
- [ ] 扩展函数语法和定义
- [ ] 扩展函数的接收者（Receiver）
- [ ] 为Java类添加扩展函数
- [ ] 扩展函数的作用域
- [ ] 成员函数vs扩展函数优先级

### 5.2 扩展属性
- [ ] 扩展属性的定义
- [ ] 扩展属性的限制
- [ ] 扩展属性的实际应用

### 5.3 扩展函数实践
- [ ] 字符串扩展函数
- [ ] 集合扩展函数
- [ ] View扩展函数（Android）
- [ ] Fragment/Activity扩展函数

---

## 委托（Delegation）

### 6.1 类委托
- [ ] 委托模式（Delegation Pattern）
- [ ] by关键字
- [ ] 委托实现接口

### 6.2 属性委托
- [ ] lazy（延迟初始化）
- [ ] observable和vetoable
- [ ] notNull
- [ ] 自定义属性委托
- [ ] 提供者（provideDelegate）

### 6.3 标准委托
- [ ] lazy的使用场景和线程安全
- [ ] Delegates.observable
- [ ] Delegates.vetoable

---

## 泛型（Generics）

### 7.1 泛型基础
- [ ] 泛型类和函数
- [ ] 类型参数声明
- [ ] 泛型约束（上界）
- [ ] 多个类型参数

### 7.2 型变（Variance）
- [ ] 协变（out）和逆变（in）
- [ ] 不变（Invariant）
- [ ] 使用处型变（Use-site Variance）
- [ ] 声明处型变（Declaration-site Variance）
- [ ] 星投影（Star Projection）

### 7.3 泛型实践
- [ ] 泛型在集合中的应用
- [ ] 泛型函数的高级用法
- [ ] reified类型参数（内联函数中）

---

## 集合操作

### 8.1 集合类型
- [ ] List, Set, Map
- [ ] 可变集合（MutableList等）
- [ ] 不可变集合
- [ ] 集合的创建和初始化

### 8.2 集合操作符
- [ ] 转换操作（map, flatMap, associate）
- [ ] 过滤操作（filter, filterNot, filterIndexed）
- [ ] 聚合操作（sum, average, count, min, max）
- [ ] 分组操作（groupBy, groupingBy）
- [ ] 排序操作（sorted, sortedBy, sortedWith）

### 8.3 序列（Sequence）
- [ ] 序列的创建
- [ ] 序列的延迟计算
- [ ] 序列vs集合的性能
- [ ] 序列的操作链

---

## 空安全（Null Safety）

### 9.1 可空类型
- [ ] 可空类型声明（String?）
- [ ] 安全调用操作符（?.）
- [ ] Elvis操作符（?:）
- [ ] 非空断言（!!）
- [ ] 安全转换（as?）

### 9.2 空安全实践
- [ ] 平台类型（Platform Types）
- [ ] 可空类型的集合
- [ ] let, also等作用域函数处理空值
- [ ] 空安全的最佳实践

---

## 数据类和密封类

### 10.1 数据类（Data Class）
- [ ] data class的定义
- [ ] 自动生成的函数（equals, hashCode, toString, copy）
- [ ] 数据类的限制
- [ ] 数据类的解构声明（Destructuring）
- [ ] 数据类的使用场景

### 10.2 密封类（Sealed Class）
- [ ] sealed class的定义
- [ ] 密封类的优势
- [ ] 密封类与when表达式
- [ ] 密封类vs枚举类
- [ ] 密封接口（Sealed Interface）

---

## 作用域函数

### 11.1 五大作用域函数
- [ ] let：在对象上执行代码块
- [ ] run：执行代码块并返回结果
- [ ] with：非扩展函数版本
- [ ] apply：配置对象并返回自身
- [ ] also：执行副作用并返回自身

### 11.2 作用域函数选择
- [ ] 各作用域函数的区别
- [ ] 使用场景和最佳实践
- [ ] 作用域函数的性能考虑
- [ ] 嵌套使用和作用域函数链

---

## 操作符重载

### 12.1 操作符重载基础
- [ ] 可重载的操作符
- [ ] 操作符函数定义（operator关键字）
- [ ] 常见操作符重载（+, -, *, /, ==等）

### 12.2 操作符重载实践
- [ ] 为自定义类重载操作符
- [ ] 集合操作符重载
- [ ] 中缀函数（infix）
- [ ] 操作符重载的最佳实践

---

## 内联函数

### 13.1 内联函数基础
- [ ] inline关键字
- [ ] 内联函数的优势（性能）
- [ ] 内联函数的限制
- [ ] noinline和crossinline

### 13.2 内联函数实践
- [ ] 内联函数的使用场景
- [ ] reified类型参数
- [ ] 内联属性（inline property）
- [ ] 标准库中的内联函数

---

## 反射（Reflection）

### 14.1 反射基础
- [ ] 反射的概念
- [ ] KClass, KFunction, KProperty
- [ ] 获取类信息
- [ ] 调用函数和属性

### 14.2 反射实践
- [ ] 反射的使用场景
- [ ] 反射的性能考虑
- [ ] 反射与注解结合
- [ ] 反射在框架中的应用

---

## 注解处理

### 15.1 注解基础
- [ ] 注解声明和使用
- [ ] 元注解（@Target, @Retention等）
- [ ] 注解参数
- [ ] 注解的使用处目标（Use-site Target）

### 15.2 注解处理
- [ ] 注解处理器（KAPT）
- [ ] Kotlin符号处理（KSP）
- [ ] 编译时注解处理
- [ ] 运行时注解（反射）

---

## Kotlin与Java互操作

### 16.1 Java调用Kotlin
- [ ] Kotlin属性在Java中的访问
- [ ] Kotlin函数在Java中的调用
- [ ] 包级函数
- [ ] 默认参数的处理
- [ ] @JvmName, @JvmStatic, @JvmOverloads

### 16.2 Kotlin调用Java
- [ ] 调用Java类和方法
- [ ] 平台类型（Platform Types）
- [ ] Java泛型在Kotlin中的使用
- [ ] SAM转换（Single Abstract Method）
- [ ] Getter/Setter转换

### 16.3 互操作最佳实践
- [ ] 空安全互操作
- [ ] 集合互操作
- [ ] 异常处理互操作
- [ ] 注解互操作

---

## DSL构建

### 17.1 DSL基础
- [ ] DSL（领域特定语言）概念
- [ ] Kotlin DSL的优势
- [ ] 带接收者的Lambda（Lambda with Receiver）
- [ ] 中缀函数在DSL中的应用

### 17.2 DSL实践
- [ ] Gradle Kotlin DSL
- [ ] HTML DSL（kotlinx.html）
- [ ] 自定义DSL设计
- [ ] DSL的类型安全

---

## 多平台开发（KMM）

### 18.1 KMM基础
- [ ] Kotlin Multiplatform概念
- [ ] 共享代码模块
- [ ] 平台特定实现（expect/actual）
- [ ] 项目结构

### 18.2 KMM实践
- [ ] 共享业务逻辑
- [ ] 共享UI（Compose Multiplatform）
- [ ] 平台间数据共享
- [ ] 构建和发布

---

## 📝 项目中的应用示例

### 当前项目中使用的Kotlin特性：

1. **扩展函数** - `StringExtensions.kt`
   - 为Java String类添加扩展函数
   - `isValidEmail()`, `isValidPhone()`, `capitalizeFirst()`

2. **协程和Flow** - `UserDao.kt`, `UserViewModel.kt`
   - suspend函数
   - Flow响应式数据流
   - viewModelScope

3. **数据类和密封类** - 数据模型
   - User数据类（Java，但Kotlin中常用data class）

4. **作用域函数** - 多处使用
   - apply, let, run等

5. **空安全** - 整个项目
   - 可空类型（User?）
   - 安全调用（?.）
   - Elvis操作符（?:）

6. **委托** - Hilt依赖注入
   - 属性委托（lazy等）

7. **泛型** - 集合和函数
   - List<User>, Flow<List<User>>

8. **高阶函数和Lambda** - 集合操作和回调
   - map, filter, forEach等

---

## 🎯 学习建议

1. **初学者路径**：基础语法 → 面向对象 → 空安全 → 扩展函数 → 协程基础
2. **进阶路径**：协程深入 → 委托 → 泛型 → 函数式编程 → DSL
3. **高级路径**：反射 → 编译器插件 → KMM → 性能优化

---

## 📚 推荐资源

- [Kotlin官方文档](https://kotlinlang.org/docs/home.html)
- [Kotlin协程指南](https://kotlinlang.org/docs/coroutines-guide.html)
- [Kotlin编码约定](https://kotlinlang.org/docs/coding-conventions.html)

---

*最后更新：2025年*


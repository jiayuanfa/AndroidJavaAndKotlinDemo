# Java 功能列表 - 重难点学习路径

## 📚 目录
1. [基础语法](#基础语法)
2. [面向对象编程](#面向对象编程)
3. [集合框架（Collections Framework）](#集合框架collections-framework)
4. [异常处理（Exception Handling）](#异常处理exception-handling)
5. [多线程编程（Multithreading）](#多线程编程multithreading)
6. [泛型（Generics）](#泛型generics)
7. [反射（Reflection）](#反射reflection)
8. [注解（Annotations）](#注解annotations)
9. [流式API（Stream API）](#流式apistream-api)
10. [Lambda表达式和函数式接口](#lambda表达式和函数式接口)
11. [IO和NIO](#io和nio)
12. [网络编程](#网络编程)
13. [JDBC数据库操作](#jdbc数据库操作)
14. [设计模式](#设计模式)
15. [Java 8+ 新特性](#java-8-新特性)
16. [Java 9+ 模块系统](#java-9-模块系统)
17. [Java与Kotlin互操作](#java与kotlin互操作)
18. [性能优化和JVM](#性能优化和jvm)

---

## 基础语法

### 1.1 变量和数据类型
- [ ] 基本数据类型（Primitive Types）
  - [ ] byte, short, int, long
  - [ ] float, double
  - [ ] char, boolean
- [ ] 引用数据类型（Reference Types）
- [ ] 包装类（Wrapper Classes）
- [ ] 自动装箱和拆箱（Autoboxing/Unboxing）
- [ ] 类型转换（Type Casting）
- [ ] 常量（final关键字）

### 1.2 运算符
- [ ] 算术运算符（+, -, *, /, %）
- [ ] 关系运算符（==, !=, <, >, <=, >=）
- [ ] 逻辑运算符（&&, ||, !）
- [ ] 位运算符（&, |, ^, ~, <<, >>, >>>）
- [ ] 赋值运算符（=, +=, -=等）
- [ ] 三元运算符（?:）
- [ ] instanceof运算符

### 1.3 控制流
- [ ] if-else语句
- [ ] switch语句（传统和增强型）
- [ ] for循环（传统、增强for循环）
- [ ] while和do-while循环
- [ ] break和continue语句
- [ ] 标签（Labels）

### 1.4 方法和函数
- [ ] 方法声明和调用
- [ ] 方法重载（Method Overloading）
- [ ] 方法参数传递（值传递和引用传递）
- [ ] 可变参数（Varargs）
- [ ] 递归方法
- [ ] 静态方法（static methods）

---

## 面向对象编程

### 2.1 类和对象
- [ ] 类声明和定义
- [ ] 对象的创建和使用（new关键字）
- [ ] 构造函数（Constructors）
  - [ ] 默认构造函数
  - [ ] 参数化构造函数
  - [ ] 构造函数重载
  - [ ] 构造函数链（this和super）
- [ ] 对象初始化顺序
- [ ] 静态初始化块（Static Block）
- [ ] 实例初始化块（Instance Block）

### 2.2 封装（Encapsulation）
- [ ] 访问修饰符（public, private, protected, package-private）
- [ ] Getter和Setter方法
- [ ] JavaBean规范
- [ ] 封装的优势和实践

### 2.3 继承（Inheritance）
- [ ] extends关键字
- [ ] 方法重写（Method Overriding）
- [ ] @Override注解
- [ ] super关键字
- [ ] 继承链和继承层次
- [ ] Object类及其方法（toString, equals, hashCode）
- [ ] final关键字（final类、final方法）

### 2.4 多态（Polymorphism）
- [ ] 运行时多态（Runtime Polymorphism）
- [ ] 方法重写实现多态
- [ ] 向上转型（Upcasting）和向下转型（Downcasting）
- [ ] 多态的优势和应用场景

### 2.5 抽象类和接口
- [ ] 抽象类（abstract class）
- [ ] 抽象方法（abstract method）
- [ ] 接口（interface）定义和实现
- [ ] 接口的多重实现
- [ ] 接口的默认方法（Java 8+）
- [ ] 接口的静态方法（Java 8+）
- [ ] 接口的私有方法（Java 9+）
- [ ] 抽象类vs接口的选择

### 2.6 内部类和嵌套类
- [ ] 成员内部类（Member Inner Class）
- [ ] 局部内部类（Local Inner Class）
- [ ] 匿名内部类（Anonymous Inner Class）
- [ ] 静态内部类（Static Nested Class）
- [ ] Lambda表达式替代匿名内部类

### 2.7 枚举（Enum）
- [ ] 枚举定义和使用
- [ ] 枚举的构造函数和方法
- [ ] 枚举实现接口
- [ ] 枚举的单例模式应用

---

## 集合框架（Collections Framework）

### 3.1 Collection接口
- [ ] Collection接口概述
- [ ] 集合的遍历（Iterator、增强for循环）
- [ ] Collection的常用方法

### 3.2 List接口
- [ ] ArrayList
  - [ ] 底层实现（动态数组）
  - [ ] 扩容机制
  - [ ] 性能特点
- [ ] LinkedList
  - [ ] 底层实现（双向链表）
  - [ ] 性能特点
- [ ] Vector（已过时，了解即可）
- [ ] Stack
- [ ] ArrayList vs LinkedList的选择

### 3.3 Set接口
- [ ] HashSet
  - [ ] 底层实现（HashMap）
  - [ ] hashCode和equals的重要性
- [ ] LinkedHashSet
- [ ] TreeSet
  - [ ] 排序机制（Comparable和Comparator）
- [ ] Set的去重原理

### 3.4 Map接口
- [ ] HashMap
  - [ ] 底层实现（数组+链表+红黑树）
  - [ ] 哈希冲突处理
  - [ ] 扩容机制（Java 8+）
  - [ ] 线程安全问题
- [ ] LinkedHashMap
- [ ] TreeMap
- [ ] Hashtable（已过时，了解即可）
- [ ] ConcurrentHashMap（线程安全的Map）

### 3.5 Queue接口
- [ ] Queue接口
- [ ] PriorityQueue
- [ ] Deque接口（双端队列）
- [ ] ArrayDeque
- [ ] BlockingQueue及其实现类

### 3.6 Collections工具类
- [ ] Collections.sort()
- [ ] Collections.reverse()
- [ ] Collections.shuffle()
- [ ] Collections.binarySearch()
- [ ] Collections.synchronizedXxx()（线程安全包装）

### 3.7 集合的最佳实践
- [ ] 选择合适的集合类型
- [ ] 性能优化技巧
- [ ] 并发安全处理

---

## 异常处理（Exception Handling）

### 4.1 异常基础
- [ ] 异常的概念和分类
- [ ] Error vs Exception
- [ ] Checked Exception vs Unchecked Exception
- [ ] 异常类层次结构

### 4.2 异常处理机制
- [ ] try-catch-finally块
- [ ] 多个catch块
- [ ] finally块的作用和执行时机
- [ ] try-with-resources（Java 7+）
- [ ] 异常链（Exception Chaining）

### 4.3 抛出异常
- [ ] throw关键字
- [ ] throws关键字
- [ ] 自定义异常类
- [ ] 异常信息的最佳实践

### 4.4 常见异常类型
- [ ] NullPointerException
- [ ] ArrayIndexOutOfBoundsException
- [ ] ClassCastException
- [ ] IllegalArgumentException
- [ ] IOException
- [ ] SQLException

---

## 多线程编程（Multithreading）

### 5.1 线程基础
- [ ] 进程和线程的概念
- [ ] 线程的创建方式
  - [ ] 继承Thread类
  - [ ] 实现Runnable接口
  - [ ] 实现Callable接口（Java 5+）
- [ ] 线程的生命周期
- [ ] 线程的优先级

### 5.2 线程同步
- [ ] 线程安全问题
- [ ] synchronized关键字
  - [ ] 同步方法
  - [ ] 同步代码块
- [ ] volatile关键字
- [ ] 死锁（Deadlock）
- [ ] 避免死锁的策略

### 5.3 线程通信
- [ ] wait()、notify()、notifyAll()
- [ ] 生产者-消费者模式
- [ ] 线程间通信的最佳实践

### 5.4 并发工具类（java.util.concurrent）
- [ ] Executor框架
- [ ] ExecutorService
- [ ] ThreadPoolExecutor
- [ ] Future和FutureTask
- [ ] CountDownLatch
- [ ] CyclicBarrier
- [ ] Semaphore
- [ ] ReentrantLock
- [ ] Condition

### 5.5 并发集合
- [ ] ConcurrentHashMap
- [ ] CopyOnWriteArrayList
- [ ] BlockingQueue及其实现类
- [ ] 线程安全的集合选择

---

## 泛型（Generics）

### 6.1 泛型基础
- [ ] 泛型的概念和优势
- [ ] 泛型类
- [ ] 泛型方法
- [ ] 泛型接口
- [ ] 类型参数命名约定（T, E, K, V等）

### 6.2 类型通配符
- [ ] 无界通配符（?）
- [ ] 上界通配符（? extends）
- [ ] 下界通配符（? super）
- [ ] PECS原则（Producer Extends, Consumer Super）

### 6.3 泛型的限制
- [ ] 类型擦除（Type Erasure）
- [ ] 不能使用基本类型
- [ ] 不能创建泛型数组
- [ ] 不能使用instanceof
- [ ] 不能捕获泛型异常

### 6.4 泛型的最佳实践
- [ ] 合理使用通配符
- [ ] 避免原始类型（Raw Types）
- [ ] 类型安全的设计

---

## 反射（Reflection）

### 7.1 反射基础
- [ ] 反射的概念和用途
- [ ] Class类
- [ ] 获取Class对象的方式
- [ ] 反射的优缺点

### 7.2 反射操作
- [ ] 获取类的信息（字段、方法、构造函数）
- [ ] 创建对象实例
- [ ] 访问和修改字段值
- [ ] 调用方法
- [ ] 操作私有成员

### 7.3 反射的应用场景
- [ ] 框架开发
- [ ] 注解处理
- [ ] 动态代理
- [ ] 序列化/反序列化

---

## 注解（Annotations）

### 8.1 注解基础
- [ ] 注解的概念
- [ ] 内置注解（@Override, @Deprecated, @SuppressWarnings）
- [ ] 元注解（@Target, @Retention, @Documented, @Inherited）
- [ ] 自定义注解

### 8.2 注解的使用
- [ ] 注解的声明
- [ ] 注解的元素（成员变量）
- [ ] 注解的默认值
- [ ] 注解的反射处理

### 8.3 常见注解框架
- [ ] Java标准注解
- [ ] Spring框架注解
- [ ] JUnit测试注解
- [ ] Lombok注解

---

## 流式API（Stream API）

### 9.1 Stream基础
- [ ] Stream的概念和特点
- [ ] Stream的创建方式
- [ ] 中间操作和终端操作
- [ ] 流的惰性求值

### 9.2 中间操作（Intermediate Operations）
- [ ] filter() - 过滤
- [ ] map() - 映射
- [ ] flatMap() - 扁平化映射
- [ ] distinct() - 去重
- [ ] sorted() - 排序
- [ ] peek() - 查看
- [ ] limit() 和 skip()

### 9.3 终端操作（Terminal Operations）
- [ ] forEach() - 遍历
- [ ] collect() - 收集
- [ ] reduce() - 归约
- [ ] count() - 计数
- [ ] anyMatch(), allMatch(), noneMatch()
- [ ] findFirst(), findAny()
- [ ] min(), max()

### 9.4 Collectors工具类
- [ ] toList(), toSet(), toMap()
- [ ] groupingBy() - 分组
- [ ] partitioningBy() - 分区
- [ ] joining() - 连接字符串
- [ ] summarizingInt/Long/Double()

### 9.5 并行流（Parallel Stream）
- [ ] parallel()和parallelStream()
- [ ] 并行流的性能考虑
- [ ] 并行流的适用场景

---

## Lambda表达式和函数式接口

### 10.1 Lambda表达式
- [ ] Lambda表达式的语法
- [ ] Lambda表达式的类型推断
- [ ] 方法引用（Method References）
  - [ ] 静态方法引用
  - [ ] 实例方法引用
  - [ ] 构造函数引用
- [ ] 变量捕获（Variable Capture）

### 10.2 函数式接口（Functional Interfaces）
- [ ] @FunctionalInterface注解
- [ ] 内置函数式接口
  - [ ] Function<T, R>
  - [ ] Consumer<T>
  - [ ] Supplier<T>
  - [ ] Predicate<T>
  - [ ] BiFunction<T, U, R>
  - [ ] 其他函数式接口

### 10.3 Lambda的应用
- [ ] 集合操作中的Lambda
- [ ] 事件处理中的Lambda
- [ ] 线程创建中的Lambda
- [ ] 替代匿名内部类

---

## IO和NIO

### 11.1 传统IO（java.io）
- [ ] 字节流（InputStream/OutputStream）
  - [ ] FileInputStream/FileOutputStream
  - [ ] BufferedInputStream/BufferedOutputStream
- [ ] 字符流（Reader/Writer）
  - [ ] FileReader/FileWriter
  - [ ] BufferedReader/BufferedWriter
- [ ] 转换流（InputStreamReader/OutputStreamWriter）
- [ ] 对象序列化（ObjectInputStream/ObjectOutputStream）

### 11.2 NIO（New IO, java.nio）
- [ ] NIO的概念和优势
- [ ] Channel（通道）
- [ ] Buffer（缓冲区）
- [ ] Selector（选择器）
- [ ] 文件操作（Files类）
- [ ] Path和Paths类

### 11.3 NIO.2（Java 7+）
- [ ] Files类的高级操作
- [ ] WatchService（文件监控）
- [ ] AsynchronousFileChannel（异步文件通道）

---

## 网络编程

### 12.1 Socket编程
- [ ] Socket和ServerSocket
- [ ] TCP/IP编程
- [ ] UDP编程（DatagramSocket）
- [ ] URL和URLConnection
- [ ] HttpURLConnection

### 12.2 HTTP客户端
- [ ] HttpURLConnection的使用
- [ ] Apache HttpClient（第三方库）
- [ ] OkHttp（第三方库，Android常用）

---

## JDBC数据库操作

### 13.1 JDBC基础
- [ ] JDBC的概念和架构
- [ ] JDBC驱动类型
- [ ] 加载数据库驱动
- [ ] 建立数据库连接（Connection）

### 13.2 JDBC操作
- [ ] Statement和PreparedStatement
- [ ] 执行SQL查询（SELECT）
- [ ] 执行SQL更新（INSERT, UPDATE, DELETE）
- [ ] ResultSet处理和遍历
- [ ] 事务处理（Transaction）
- [ ] 批处理（Batch Processing）

### 13.3 连接池
- [ ] 连接池的概念和优势
- [ ] HikariCP连接池
- [ ] C3P0连接池
- [ ] Druid连接池

---

## 设计模式

### 14.1 创建型模式
- [ ] 单例模式（Singleton）
- [ ] 工厂模式（Factory）
- [ ] 抽象工厂模式（Abstract Factory）
- [ ] 建造者模式（Builder）
- [ ] 原型模式（Prototype）

### 14.2 结构型模式
- [ ] 适配器模式（Adapter）
- [ ] 装饰者模式（Decorator）
- [ ] 代理模式（Proxy）
- [ ] 外观模式（Facade）
- [ ] 桥接模式（Bridge）
- [ ] 组合模式（Composite）
- [ ] 享元模式（Flyweight）

### 14.3 行为型模式
- [ ] 观察者模式（Observer）
- [ ] 策略模式（Strategy）
- [ ] 命令模式（Command）
- [ ] 责任链模式（Chain of Responsibility）
- [ ] 状态模式（State）
- [ ] 模板方法模式（Template Method）
- [ ] 迭代器模式（Iterator）
- [ ] 访问者模式（Visitor）
- [ ] 中介者模式（Mediator）
- [ ] 备忘录模式（Memento）

---

## Java 8+ 新特性

### 15.1 Java 8新特性
- [ ] Lambda表达式
- [ ] Stream API
- [ ] 函数式接口
- [ ] 方法引用
- [ ] 接口的默认方法和静态方法
- [ ] Optional类
- [ ] 新的日期时间API（java.time包）
- [ ] CompletableFuture

### 15.2 Java 9新特性
- [ ] 模块系统（Project Jigsaw）
- [ ] 接口的私有方法
- [ ] 改进的Stream API
- [ ] 改进的Optional
- [ ] HTTP/2客户端（预览）

### 15.3 Java 10+新特性
- [ ] 局部变量类型推断（var关键字）
- [ ] 文本块（Text Blocks）
- [ ] Records（记录类）
- [ ] Sealed Classes（密封类）
- [ ] Pattern Matching（模式匹配）
- [ ] Switch表达式

---

## Java 9+ 模块系统

### 16.1 模块系统基础
- [ ] 模块的概念（Module）
- [ ] module-info.java文件
- [ ] 模块的声明和导出
- [ ] 模块的依赖（requires）
- [ ] 服务的提供和使用

### 16.2 模块系统实践
- [ ] 创建模块化应用
- [ ] 模块的打包和运行
- [ ] 模块路径（module path）vs 类路径（classpath）

---

## Java与Kotlin互操作

### 17.1 Java调用Kotlin
- [ ] 调用Kotlin函数
- [ ] 访问Kotlin属性
- [ ] 调用Kotlin扩展函数
- [ ] 处理Kotlin的可空类型
- [ ] 调用Kotlin对象和伴生对象

### 17.2 Kotlin调用Java
- [ ] 调用Java类和方法
- [ ] 处理Java的可空性（平台类型）
- [ ] Java泛型在Kotlin中的使用
- [ ] Getter/Setter的自动转换
- [ ] SAM转换（Single Abstract Method）

### 17.3 互操作最佳实践
- [ ] 空安全互操作
- [ ] 集合互操作
- [ ] 异常处理互操作
- [ ] 注解互操作

---

## 性能优化和JVM

### 18.1 JVM基础
- [ ] JVM的内存模型
- [ ] 堆（Heap）和栈（Stack）
- [ ] 方法区（Method Area）
- [ ] 垃圾回收（Garbage Collection）
- [ ] 垃圾回收器（GC算法）

### 18.2 性能优化
- [ ] 字符串操作的优化（StringBuilder）
- [ ] 集合的选择和优化
- [ ] 对象创建的优化
- [ ] 内存泄漏的识别和解决
- [ ] JVM参数调优

### 18.3 调试和监控
- [ ] JVM监控工具
- [ ] 内存分析工具
- [ ] 性能分析工具

---

## 📝 项目中的应用示例

### 当前项目中使用的Java特性：

1. **类和对象** - `User.java`
   - 类声明和属性
   - Getter/Setter方法
   - 构造函数
   - @Entity注解（Room框架）

2. **工具类** - `DateUtils.java`
   - 静态方法（static methods）
   - 方法重载（Method Overloading）
   - 简单日期格式化

3. **Java与Kotlin互操作**
   - Kotlin调用Java类（User.java）
   - Kotlin调用Java静态方法（DateUtils）
   - Java类在Room数据库中的使用

4. **面向对象特性**
   - 封装（private字段，public getter/setter）
   - 继承（User类可以继承其他类）
   - 多态（User可以作为父类引用使用）

5. **注解使用**
   - @Entity（Room框架）
   - @PrimaryKey（Room框架）
   - @NonNull（Android注解）
   - @Ignore（Room框架）

---

## 🎯 学习建议

1. **初学者路径**：
   基础语法 → 面向对象 → 集合框架 → 异常处理 → IO操作

2. **进阶路径**：
   多线程 → 泛型 → 反射 → 注解 → Stream API → Lambda表达式

3. **高级路径**：
   设计模式 → JVM原理 → 性能优化 → 并发编程深入 → 模块系统

4. **Android开发重点**：
   面向对象 → 集合框架 → 多线程基础 → Java与Kotlin互操作

---

## 📚 推荐资源

- [Oracle Java官方文档](https://docs.oracle.com/javase/)
- [Java教程（Oracle）](https://docs.oracle.com/javase/tutorial/)
- [Java并发编程实战](https://jcip.net/)
- [Effective Java（Joshua Bloch）](https://www.oracle.com/technical-resources/articles/java/effectivejava.html)
- [Java编程思想（Thinking in Java）](https://www.mindview.net/Books/TIJ/)

---

## 🔄 Java版本演进

- **Java 8** (2014): Lambda, Stream API, 新日期时间API
- **Java 9** (2017): 模块系统, 接口私有方法
- **Java 10** (2018): var关键字
- **Java 11** (2018): LTS版本
- **Java 14** (2020): Records, Pattern Matching（预览）
- **Java 15** (2020): Sealed Classes（预览）
- **Java 17** (2021): LTS版本, 正式支持Records, Sealed Classes
- **Java 21** (2023): LTS版本, Virtual Threads, Pattern Matching正式支持

---

*最后更新：2025年*


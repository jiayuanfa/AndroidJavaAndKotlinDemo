package com.example.androidjavaandkotlindemo.data

/**
 * Java功能列表数据
 * 基于docs/JAVA_FEATURES.md文档
 */
object JavaFeaturesData {
    
    fun getJavaFeatures(): List<JavaFeature> {
        return listOf(
            JavaFeature(
                id = "basic_syntax",
                title = "基础语法",
                description = "Java语言的基础语法和核心概念",
                items = listOf(
                    JavaFeatureItem("var_decl", "变量和数据类型（基本类型、引用类型、包装类）"),
                    JavaFeatureItem("operators", "运算符（算术、关系、逻辑、位运算）"),
                    JavaFeatureItem("control_flow", "控制流（if-else、switch、for、while）"),
                    JavaFeatureItem("methods", "方法和函数（重载、参数传递、可变参数）")
                )
            ),
            JavaFeature(
                id = "oop",
                title = "面向对象编程",
                description = "Java面向对象的核心特性",
                items = listOf(
                    JavaFeatureItem("class_object", "类和对象（构造函数、初始化块）"),
                    JavaFeatureItem("encapsulation", "封装（访问修饰符、Getter/Setter）"),
                    JavaFeatureItem("inheritance", "继承（extends、方法重写、super）"),
                    JavaFeatureItem("polymorphism", "多态（运行时多态、向上转型、向下转型）"),
                    JavaFeatureItem("abstract_interface", "抽象类和接口（默认方法、静态方法）"),
                    JavaFeatureItem("inner_class", "内部类和嵌套类"),
                    JavaFeatureItem("enum", "枚举（Enum）")
                )
            ),
            JavaFeature(
                id = "collections",
                title = "集合框架",
                description = "Java集合框架的使用",
                items = listOf(
                    JavaFeatureItem("list", "List接口（ArrayList、LinkedList）"),
                    JavaFeatureItem("set", "Set接口（HashSet、LinkedHashSet、TreeSet）"),
                    JavaFeatureItem("map", "Map接口（HashMap、LinkedHashMap、TreeMap）"),
                    JavaFeatureItem("queue", "Queue接口（PriorityQueue、BlockingQueue）"),
                    JavaFeatureItem("collections_util", "Collections工具类"),
                    JavaFeatureItem("collections_best", "集合的最佳实践")
                )
            ),
            JavaFeature(
                id = "exception",
                title = "异常处理",
                description = "Java异常处理机制",
                items = listOf(
                    JavaFeatureItem("exception_basic", "异常基础（Error、Exception、Checked/Unchecked）"),
                    JavaFeatureItem("exception_handling", "异常处理机制（try-catch-finally）"),
                    JavaFeatureItem("throw_exception", "抛出异常（throw、throws）"),
                    JavaFeatureItem("common_exceptions", "常见异常类型")
                )
            ),
            JavaFeature(
                id = "multithreading",
                title = "多线程编程",
                description = "Java多线程和并发编程",
                items = listOf(
                    JavaFeatureItem("thread_basic", "线程基础（创建、生命周期）"),
                    JavaFeatureItem("thread_sync", "线程同步（synchronized、volatile）"),
                    JavaFeatureItem("thread_comm", "线程通信（wait、notify）"),
                    JavaFeatureItem("concurrent_utils", "并发工具类（Executor、Future、CountDownLatch）"),
                    JavaFeatureItem("concurrent_collections", "并发集合（ConcurrentHashMap、BlockingQueue）")
                )
            ),
            JavaFeature(
                id = "generics",
                title = "泛型",
                description = "Java泛型的使用",
                items = listOf(
                    JavaFeatureItem("generics_basic", "泛型基础（泛型类、方法、接口）"),
                    JavaFeatureItem("wildcards", "类型通配符（?、? extends、? super）"),
                    JavaFeatureItem("type_erasure", "类型擦除和限制"),
                    JavaFeatureItem("generics_best", "泛型的最佳实践")
                )
            ),
            JavaFeature(
                id = "reflection",
                title = "反射",
                description = "Java反射机制",
                items = listOf(
                    JavaFeatureItem("reflection_basic", "反射基础（Class类）"),
                    JavaFeatureItem("reflection_ops", "反射操作（获取信息、创建对象、调用方法）"),
                    JavaFeatureItem("reflection_usage", "反射的应用场景")
                )
            ),
            JavaFeature(
                id = "annotations",
                title = "注解",
                description = "Java注解的使用",
                items = listOf(
                    JavaFeatureItem("annotation_basic", "注解基础（内置注解、元注解）"),
                    JavaFeatureItem("custom_annotation", "自定义注解"),
                    JavaFeatureItem("annotation_frameworks", "常见注解框架")
                )
            ),
            JavaFeature(
                id = "stream_api",
                title = "流式API",
                description = "Java 8+ Stream API",
                items = listOf(
                    JavaFeatureItem("stream_basic", "Stream基础（创建、中间操作、终端操作）"),
                    JavaFeatureItem("intermediate_ops", "中间操作（filter、map、flatMap）"),
                    JavaFeatureItem("terminal_ops", "终端操作（forEach、collect、reduce）"),
                    JavaFeatureItem("collectors", "Collectors工具类"),
                    JavaFeatureItem("parallel_stream", "并行流（Parallel Stream）")
                )
            ),
            JavaFeature(
                id = "lambda",
                title = "Lambda表达式和函数式接口",
                description = "Java 8+ Lambda和函数式编程",
                items = listOf(
                    JavaFeatureItem("lambda_basic", "Lambda表达式语法"),
                    JavaFeatureItem("functional_interfaces", "函数式接口（Function、Consumer、Supplier、Predicate）"),
                    JavaFeatureItem("method_reference", "方法引用"),
                    JavaFeatureItem("lambda_usage", "Lambda的应用")
                )
            ),
            JavaFeature(
                id = "io_nio",
                title = "IO和NIO",
                description = "Java IO和NIO",
                items = listOf(
                    JavaFeatureItem("traditional_io", "传统IO（字节流、字符流）"),
                    JavaFeatureItem("nio", "NIO（Channel、Buffer、Selector）"),
                    JavaFeatureItem("nio2", "NIO.2（Files类、WatchService）")
                )
            ),
            JavaFeature(
                id = "network",
                title = "网络编程",
                description = "Java网络编程",
                items = listOf(
                    JavaFeatureItem("socket", "Socket编程（TCP/IP、UDP）"),
                    JavaFeatureItem("http_client", "HTTP客户端（HttpURLConnection）")
                )
            ),
            JavaFeature(
                id = "jdbc",
                title = "JDBC数据库操作",
                description = "Java数据库连接",
                items = listOf(
                    JavaFeatureItem("jdbc_basic", "JDBC基础（驱动、连接）"),
                    JavaFeatureItem("jdbc_ops", "JDBC操作（Statement、PreparedStatement、ResultSet）"),
                    JavaFeatureItem("connection_pool", "连接池（HikariCP、C3P0、Druid）")
                )
            ),
            JavaFeature(
                id = "design_patterns",
                title = "设计模式",
                description = "常用设计模式",
                items = listOf(
                    JavaFeatureItem("creational", "创建型模式（单例、工厂、建造者）"),
                    JavaFeatureItem("structural", "结构型模式（适配器、装饰者、代理）"),
                    JavaFeatureItem("behavioral", "行为型模式（观察者、策略、命令）")
                )
            ),
            JavaFeature(
                id = "java8_plus",
                title = "Java 8+ 新特性",
                description = "Java新版本特性",
                items = listOf(
                    JavaFeatureItem("java8", "Java 8（Lambda、Stream、Optional、新日期时间API）"),
                    JavaFeatureItem("java9", "Java 9（模块系统、接口私有方法）"),
                    JavaFeatureItem("java10_plus", "Java 10+（var关键字、Records、Sealed Classes）")
                )
            ),
            JavaFeature(
                id = "modules",
                title = "Java 9+ 模块系统",
                description = "Java模块系统",
                items = listOf(
                    JavaFeatureItem("modules_basic", "模块系统基础（module-info.java）"),
                    JavaFeatureItem("modules_practice", "模块系统实践")
                )
            ),
            JavaFeature(
                id = "interop",
                title = "Java与Kotlin互操作",
                description = "Java和Kotlin互操作性",
                items = listOf(
                    JavaFeatureItem("kotlin_call_java", "Kotlin调用Java"),
                    JavaFeatureItem("java_call_kotlin", "Java调用Kotlin"),
                    JavaFeatureItem("interop_best", "互操作最佳实践")
                )
            ),
            JavaFeature(
                id = "performance",
                title = "性能优化和JVM",
                description = "JVM和性能优化",
                items = listOf(
                    JavaFeatureItem("jvm_basic", "JVM基础（内存模型、垃圾回收）"),
                    JavaFeatureItem("performance_opt", "性能优化"),
                    JavaFeatureItem("debug_monitor", "调试和监控")
                )
            )
        )
    }
}


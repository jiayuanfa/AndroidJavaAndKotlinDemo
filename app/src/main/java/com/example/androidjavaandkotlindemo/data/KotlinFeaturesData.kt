package com.example.androidjavaandkotlindemo.data

/**
 * Kotlin功能列表数据
 */
object KotlinFeaturesData {
    
    fun getKotlinFeatures(): List<KotlinFeature> {
        return listOf(
            KotlinFeature(
                id = "basic_syntax",
                title = "基础语法",
                description = "Kotlin语言的基础语法和核心概念",
                items = listOf(
                    KotlinFeatureItem("var_decl", "val vs var、类型推断、常量"),
                    KotlinFeatureItem("data_types", "基本数据类型、可空类型、类型转换"),
                    KotlinFeatureItem("control_flow", "if表达式、when表达式、for循环、while循环"),
                    KotlinFeatureItem("functions", "函数声明、默认参数、命名参数、可变参数、单表达式函数")
                )
            ),
            KotlinFeature(
                id = "oop",
                title = "面向对象编程",
                description = "Kotlin面向对象的核心特性",
                items = listOf(
                    KotlinFeatureItem("class_object", "类声明、构造函数、初始化块、对象声明、伴生对象"),
                    KotlinFeatureItem("properties", "属性声明、自定义getter/setter、延迟初始化"),
                    KotlinFeatureItem("inheritance", "类的继承、方法重写、抽象类和接口"),
                    KotlinFeatureItem("visibility", "可见性修饰符（public、private、protected、internal）")
                )
            ),
            KotlinFeature(
                id = "functional",
                title = "函数式编程",
                description = "Kotlin函数式编程特性",
                items = listOf(
                    KotlinFeatureItem("higher_order", "高阶函数、Lambda表达式、it参数、尾随Lambda"),
                    KotlinFeatureItem("collections_ops", "map、filter、reduce、flatMap、groupBy等集合操作"),
                    KotlinFeatureItem("function_types", "函数类型、函数类型别名")
                )
            ),
            KotlinFeature(
                id = "coroutines",
                title = "协程（Coroutines）",
                description = "Kotlin协程和异步编程",
                items = listOf(
                    KotlinFeatureItem("coroutines_basic", "协程基础、挂起函数、协程构建器、协程作用域"),
                    KotlinFeatureItem("coroutines_context", "协程上下文和调度器、Job和SupervisorJob"),
                    KotlinFeatureItem("flow", "Flow响应式数据流、StateFlow和SharedFlow"),
                    KotlinFeatureItem("coroutines_exception", "协程异常处理"),
                    KotlinFeatureItem("android_coroutines", "Android中的协程（viewModelScope、lifecycleScope）")
                )
            ),
            KotlinFeature(
                id = "extensions",
                title = "扩展函数和属性",
                description = "Kotlin扩展机制",
                items = listOf(
                    KotlinFeatureItem("extension_functions", "扩展函数语法、为Java类添加扩展函数"),
                    KotlinFeatureItem("extension_properties", "扩展属性的定义和使用"),
                    KotlinFeatureItem("extension_practice", "扩展函数实践（字符串、集合、View扩展）")
                )
            ),
            KotlinFeature(
                id = "delegation",
                title = "委托（Delegation）",
                description = "Kotlin委托模式",
                items = listOf(
                    KotlinFeatureItem("class_delegation", "类委托、by关键字"),
                    KotlinFeatureItem("property_delegation", "属性委托（lazy、observable、vetoable）"),
                    KotlinFeatureItem("standard_delegates", "标准委托的使用")
                )
            ),
            KotlinFeature(
                id = "generics",
                title = "泛型（Generics）",
                description = "Kotlin泛型系统",
                items = listOf(
                    KotlinFeatureItem("generics_basic", "泛型类和函数、类型参数、泛型约束"),
                    KotlinFeatureItem("variance", "型变（协变out、逆变in、星投影）"),
                    KotlinFeatureItem("generics_practice", "泛型实践、reified类型参数")
                )
            ),
            KotlinFeature(
                id = "collections",
                title = "集合操作",
                description = "Kotlin集合框架",
                items = listOf(
                    KotlinFeatureItem("collection_types", "List、Set、Map、可变集合和不可变集合"),
                    KotlinFeatureItem("collection_operators", "集合操作符（转换、过滤、聚合、分组、排序）"),
                    KotlinFeatureItem("sequence", "序列（Sequence）的延迟计算")
                )
            ),
            KotlinFeature(
                id = "null_safety",
                title = "空安全（Null Safety）",
                description = "Kotlin空安全机制",
                items = listOf(
                    KotlinFeatureItem("nullable_types", "可空类型声明、安全调用操作符、Elvis操作符"),
                    KotlinFeatureItem("null_safety_practice", "空安全实践、平台类型处理")
                )
            ),
            KotlinFeature(
                id = "data_sealed",
                title = "数据类和密封类",
                description = "Kotlin特殊类",
                items = listOf(
                    KotlinFeatureItem("data_class", "数据类（data class）、解构声明"),
                    KotlinFeatureItem("sealed_class", "密封类（sealed class）、密封接口")
                )
            ),
            KotlinFeature(
                id = "scope_functions",
                title = "作用域函数",
                description = "Kotlin五大作用域函数",
                items = listOf(
                    KotlinFeatureItem("scope_functions", "let、run、with、apply、also的使用和选择")
                )
            ),
            KotlinFeature(
                id = "operator_overload",
                title = "操作符重载",
                description = "Kotlin操作符重载",
                items = listOf(
                    KotlinFeatureItem("operator_overload", "操作符重载基础、中缀函数")
                )
            ),
            KotlinFeature(
                id = "inline",
                title = "内联函数",
                description = "Kotlin内联函数",
                items = listOf(
                    KotlinFeatureItem("inline_functions", "inline关键字、noinline和crossinline、reified类型参数")
                )
            ),
            KotlinFeature(
                id = "reflection",
                title = "反射（Reflection）",
                description = "Kotlin反射机制",
                items = listOf(
                    KotlinFeatureItem("reflection_basic", "反射基础、KClass、KFunction、KProperty"),
                    KotlinFeatureItem("reflection_practice", "反射的应用场景")
                )
            ),
            KotlinFeature(
                id = "annotations",
                title = "注解处理",
                description = "Kotlin注解",
                items = listOf(
                    KotlinFeatureItem("annotations", "注解声明和使用、元注解、注解处理器（KAPT、KSP）")
                )
            ),
            KotlinFeature(
                id = "interop",
                title = "Kotlin与Java互操作",
                description = "Kotlin和Java互操作性",
                items = listOf(
                    KotlinFeatureItem("java_call_kotlin", "Java调用Kotlin、@JvmName、@JvmStatic、@JvmOverloads"),
                    KotlinFeatureItem("kotlin_call_java", "Kotlin调用Java、平台类型、SAM转换"),
                    KotlinFeatureItem("interop_best", "互操作最佳实践")
                )
            ),
            KotlinFeature(
                id = "dsl",
                title = "DSL构建",
                description = "Kotlin DSL构建",
                items = listOf(
                    KotlinFeatureItem("dsl_basic", "DSL基础、带接收者的Lambda、Gradle Kotlin DSL"),
                    KotlinFeatureItem("dsl_practice", "自定义DSL设计")
                )
            ),
            KotlinFeature(
                id = "kmm",
                title = "多平台开发（KMM）",
                description = "Kotlin Multiplatform",
                items = listOf(
                    KotlinFeatureItem("kmm_basic", "KMM基础、共享代码模块、平台特定实现"),
                    KotlinFeatureItem("kmm_practice", "KMM实践、Compose Multiplatform")
                )
            )
        )
    }
}


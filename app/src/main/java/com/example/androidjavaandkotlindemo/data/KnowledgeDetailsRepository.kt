package com.example.androidjavaandkotlindemo.data

/**
 * 知识详情数据仓库
 * 存储所有知识点的详细学习内容
 */
object KnowledgeDetailsRepository {
    
    /**
     * 根据知识点ID获取知识详情
     */
    fun getKnowledgeDetail(id: String): KnowledgeDetail? {
        return allKnowledgeDetails.find { it.id == id }
    }
    
    /**
     * 所有知识详情数据
     */
    private val allKnowledgeDetails = listOf(
        // ========== Kotlin 基础语法 ==========
        
        // 1. 变量声明（val vs var、类型推断、常量）
        KnowledgeDetail(
            id = "var_decl",
            title = "变量声明（val vs var、类型推断、常量）",
            overview = "Kotlin中的变量声明是编程的基础。理解val和var的区别、类型推断机制以及常量的使用，是掌握Kotlin语言的第一步。",
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：val 和 var 的区别",
                    code = """
                        // val 用于声明不可变变量（类似Java的final）
                        val name = "Kotlin"  // 类型推断为String
                        val age: Int = 25    // 显式声明类型为Int
                        // name = "Java"     // ❌ 错误！val变量不能重新赋值
                        
                        // var 用于声明可变变量
                        var count = 0        // 类型推断为Int
                        var price: Double = 99.99  // 显式声明类型为Double
                        count = 10           // ✅ 正确！var变量可以重新赋值
                        price = 199.99       // ✅ 正确！
                        
                        // 使用建议：
                        // 1. 优先使用val，只有在确实需要修改变量值时才使用var
                        // 2. 这有助于编写更安全、更易于理解的代码
                    """.trimIndent(),
                    explanation = "val声明的变量只能赋值一次，var声明的变量可以多次赋值。Kotlin推荐优先使用val，这样可以减少意外的状态变更。"
                ),
                CodeExample(
                    title = "示例2：类型推断",
                    code = """
                        // Kotlin的类型推断机制可以自动推断变量类型
                        val number = 42           // 推断为Int
                        val price = 29.99         // 推断为Double
                        val text = "Hello"        // 推断为String
                        val isActive = true       // 推断为Boolean
                        
                        // 如果需要显式指定类型，可以这样做：
                        val number2: Long = 42    // 显式指定为Long类型
                        val price2: Float = 29.99f // 显式指定为Float类型（注意f后缀）
                        
                        // 复杂类型推断
                        val list = listOf(1, 2, 3)  // 推断为List<Int>
                        val map = mapOf("key" to "value")  // 推断为Map<String, String>
                    """.trimIndent(),
                    explanation = "Kotlin编译器会根据赋值表达式自动推断变量类型，大多数情况下无需显式声明类型，让代码更简洁。"
                ),
                CodeExample(
                    title = "示例3：常量（const val）",
                    code = """
                        // const val 用于编译时常量（必须在顶层或object中声明）
                        const val MAX_SIZE = 100        // ✅ 编译时常量
                        const val APP_NAME = "MyApp"    // ✅ 编译时常量
                        
                        // 不能在函数内部使用const val
                        // fun test() {
                        //     const val LOCAL = 10  // ❌ 错误！
                        // }
                        
                        // 普通val vs const val的区别：
                        object Config {
                            const val API_URL = "https://api.example.com"  // 编译时常量
                            val timestamp = System.currentTimeMillis()     // 运行时常量
                        }
                        
                        // const val的特点：
                        // 1. 必须是基本类型（Int, Long, Double, Float, Boolean, Char, String）
                        // 2. 值在编译时就确定
                        // 3. 可以直接通过类名访问，无需创建对象实例
                    """.trimIndent(),
                    explanation = "const val用于声明编译时常量，值在编译时就确定，必须是基本类型或String，且必须在顶层或object中声明。"
                )
            ),
            useCases = listOf(
                "配置信息存储：使用const val存储应用配置常量（如API地址、版本号）",
                "不可变数据：使用val存储不会改变的数据（如用户ID、创建时间）",
                "计数器或状态：使用var存储需要变化的值（如循环计数器、开关状态）",
                "函数参数和局部变量：根据是否需要修改选择val或var",
                "性能优化：const val在编译时确定，比普通val访问更快"
            ),
            keyPoints = listOf(
                "val = 不可变变量（类似Java的final），只能赋值一次",
                "var = 可变变量，可以多次赋值",
                "优先使用val，提高代码安全性和可读性",
                "类型推断：Kotlin可以自动推断变量类型，大多数情况无需显式声明",
                "const val = 编译时常量，必须是基本类型，值在编译时确定"
            ),
            notes = listOf(
                "val虽然不可重新赋值，但如果指向可变对象（如List），对象内容仍可修改",
                "类型推断失败时，必须显式声明类型",
                "const val只能在顶层或object中声明，不能在函数内部使用",
                "常量命名通常使用大写下划线分隔（UPPER_SNAKE_CASE）"
            ),
            practiceTips = "建议：在编写代码时，先尝试使用val，只有在确实需要修改变量值时才改为var。这有助于养成编写不可变代码的习惯，减少bug的发生。"
        ),
        
        // 2. 数据类型（基本数据类型、可空类型、类型转换）
        KnowledgeDetail(
            id = "data_types",
            title = "数据类型（基本数据类型、可空类型、类型转换）",
            overview = "Kotlin提供了丰富的数据类型系统，包括基本数据类型、可空类型和灵活的类型转换机制。理解这些类型系统是编写类型安全代码的基础。",
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：基本数据类型",
                    code = """
                        // Kotlin的基本数据类型（首字母大写的包装类型）
                        val byte: Byte = 127           // 8位，范围：-128 到 127
                        val short: Short = 32767       // 16位，范围：-32768 到 32767
                        val int: Int = 2147483647      // 32位，范围：-2^31 到 2^31-1
                        val long: Long = 9223372036854775807L  // 64位，注意L后缀
                        
                        val float: Float = 3.14f       // 32位浮点数，注意f后缀
                        val double: Double = 3.14159   // 64位浮点数，默认小数类型
                        
                        val boolean: Boolean = true    // 布尔类型：true 或 false
                        val char: Char = 'A'           // 字符类型，单引号
                        
                        // 数字类型转换（Kotlin不进行隐式类型转换）
                        val x: Int = 100
                        val y: Long = x.toLong()       // ✅ 显式转换
                        val z: Double = x.toDouble()   // ✅ 显式转换
                        // val y2: Long = x             // ❌ 错误！不能隐式转换
                        
                        // 字符串模板
                        val name = "Kotlin"
                        val message = "Hello, ${'$'}name!"           // 简单变量：${'$'}变量名
                        val length = "Length is ${'$'}{name.length}" // 表达式：${'$'}{表达式}
                    """.trimIndent(),
                    explanation = "Kotlin的基本数据类型都是类（首字母大写），不进行隐式类型转换，必须显式调用转换方法。"
                ),
                CodeExample(
                    title = "示例2：可空类型（Nullable Types）",
                    code = """
                        // 可空类型：类型后加?表示该变量可以为null
                        var name: String? = null       // ✅ 可空String类型
                        var age: Int? = null           // ✅ 可空Int类型
                        
                        // 不可空类型：默认类型不允许null
                        var title: String = "Kotlin"   // ✅ 不可空String
                        // var title2: String = null   // ❌ 错误！不可空类型不能为null
                        
                        // 安全调用操作符 ?.
                        val length1 = name?.length     // 如果name为null，返回null；否则返回name.length
                        val length2 = name?.length ?: 0  // Elvis操作符：如果为null，返回默认值0
                        
                        // 非空断言操作符 !!
                        val length3 = name!!.length    // 强制认为name不为null，如果为null会抛出异常
                        
                        // 安全调用链
                        val result = user?.address?.street?.length  // 链式安全调用
                    """.trimIndent(),
                    explanation = "Kotlin通过可空类型系统在编译时防止空指针异常。?表示可空，?.用于安全调用，?:提供默认值，!!用于非空断言（需谨慎使用）。"
                ),
                CodeExample(
                    title = "示例3：类型转换和检查",
                    code = """
                        // 类型检查：is 和 !is
                        fun checkType(obj: Any) {
                            if (obj is String) {
                                println(obj.length)  // 智能转换：obj自动转换为String类型
                            }
                            if (obj !is String) {
                                println("Not a String")
                            }
                        }
                        
                        // when表达式中的智能转换
                        fun describe(obj: Any): String = when (obj) {
                            is Int -> "Integer: ${'$'}obj"
                            is String -> "String with length ${'$'}{obj.length}"  // 智能转换
                            is Boolean -> "Boolean: ${'$'}obj"
                            else -> "Unknown type"
                        }
                        
                        // 显式类型转换：as 和 as?
                        val str: Any = "Hello"
                        val string1 = str as String        // 强制转换，失败抛出异常
                        val string2 = str as? String       // 安全转换，失败返回null
                        
                        // 数字类型转换方法
                        val num = 100
                        num.toByte()    // 转换为Byte
                        num.toShort()   // 转换为Short
                        num.toInt()     // 转换为Int
                        num.toLong()    // 转换为Long
                        num.toFloat()   // 转换为Float
                        num.toDouble()  // 转换为Double
                        num.toChar()    // 转换为Char
                    """.trimIndent(),
                    explanation = "Kotlin使用is进行类型检查，编译器会智能转换类型。as用于显式类型转换，as?用于安全转换。"
                )
            ),
            useCases = listOf(
                "API响应处理：使用可空类型处理可能缺失的数据字段",
                "类型安全：使用类型检查确保数据处理正确",
                "数值计算：根据精度需求选择合适的数字类型",
                "字符串处理：使用字符串模板简化字符串拼接",
                "数据验证：使用可空类型表示可选或未初始化的数据"
            ),
            keyPoints = listOf(
                "基本数据类型都是类（首字母大写），没有原始类型",
                "Kotlin不进行隐式类型转换，必须显式调用转换方法",
                "可空类型用?表示，提供编译时的空安全保护",
                "安全调用?.、Elvis操作符?:、非空断言!!是处理可空类型的工具",
                "is进行类型检查，编译器会智能转换类型"
            ),
            notes = listOf(
                "数字类型转换可能丢失精度（如Double转Int）",
                "非空断言!!可能抛出NullPointerException，需谨慎使用",
                "Long类型字面量需要L后缀，Float需要f后缀",
                "字符使用单引号，字符串使用双引号",
                "Any是Kotlin中所有非空类型的超类，类似Java的Object"
            ),
            practiceTips = "建议：优先使用可空类型和安全调用操作符，避免使用非空断言。在类型转换时，优先使用安全转换as?而不是强制转换as，这样可以避免运行时异常。"
        ),
        
        // 3. 控制流（if表达式、when表达式、for循环、while循环）
        KnowledgeDetail(
            id = "control_flow",
            title = "控制流（if表达式、when表达式、for循环、while循环）",
            overview = "Kotlin的控制流语句既强大又简洁。if和when可以作为表达式使用，for循环支持多种迭代方式，while循环与其他语言类似。",
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：if表达式",
                    code = """
                        // if作为表达式（Kotlin中if可以返回值）
                        val max = if (a > b) a else b  // ✅ if表达式返回a或b
                        
                        // 传统if语句
                        if (a > b) {
                            println("a is greater")
                        } else if (a < b) {
                            println("b is greater")
                        } else {
                            println("a equals b")
                        }
                        
                        // if表达式的多行形式
                        val result = if (score >= 90) {
                            "优秀"
                        } else if (score >= 80) {
                            "良好"
                        } else if (score >= 60) {
                            "及格"
                        } else {
                            "不及格"
                        }
                        
                        // if表达式用于函数返回值
                        fun getGrade(score: Int) = if (score >= 60) "Pass" else "Fail"
                    """.trimIndent(),
                    explanation = "Kotlin中if可以作为表达式使用，返回最后一个表达式的值。这使得代码更简洁，无需三元运算符。"
                ),
                CodeExample(
                    title = "示例2：when表达式（强大的switch）",
                    code = """
                        // when表达式的基本用法
                        when (x) {
                            1 -> println("One")
                            2 -> println("Two")
                            3, 4 -> println("Three or Four")  // 多个值
                            in 5..10 -> println("Between 5 and 10")  // 范围
                            !in 11..20 -> println("Not between 11 and 20")
                            else -> println("Other")
                        }
                        
                        // when作为表达式
                        val description = when (x) {
                            1 -> "One"
                            2 -> "Two"
                            else -> "Other"
                        }
                        
                        // when用于类型检查
                        when (obj) {
                            is String -> println("String: ${'$'}{obj.length}")
                            is Int -> println("Integer: ${'$'}obj")
                            is Boolean -> println("Boolean: ${'$'}obj")
                            else -> println("Unknown type")
                        }
                        
                        // when无参数形式（类似if-else链）
                        when {
                            x > 0 -> println("Positive")
                            x < 0 -> println("Negative")
                            else -> println("Zero")
                        }
                    """.trimIndent(),
                    explanation = "when是Kotlin中强大的条件表达式，可以匹配值、范围、类型等，比Java的switch更灵活。"
                ),
                CodeExample(
                    title = "示例3：for循环",
                    code = """
                        // 遍历范围
                        for (i in 1..5) {           // 1到5（包含5）
                            println(i)
                        }
                        
                        for (i in 1 until 5) {      // 1到4（不包含5）
                            println(i)
                        }
                        
                        for (i in 5 downTo 1) {     // 5到1（倒序）
                            println(i)
                        }
                        
                        for (i in 1..10 step 2) {   // 步长为2：1, 3, 5, 7, 9
                            println(i)
                        }
                        
                        // 遍历集合
                        val list = listOf("a", "b", "c")
                        for (item in list) {
                            println(item)
                        }
                        
                        // 遍历带索引
                        for ((index, value) in list.withIndex()) {
                            println("${'$'}index: ${'$'}value")
                        }
                        
                        // 遍历Map
                        val map = mapOf("a" to 1, "b" to 2, "c" to 3)
                        for ((key, value) in map) {
                            println("${'$'}key -> ${'$'}value")
                        }
                    """.trimIndent(),
                    explanation = "Kotlin的for循环支持多种迭代方式：范围、集合、带索引、Map等，语法简洁直观。"
                ),
                CodeExample(
                    title = "示例4：while和do-while循环",
                    code = """
                        // while循环
                        var i = 0
                        while (i < 5) {
                            println(i)
                            i++
                        }
                        
                        // do-while循环（至少执行一次）
                        var j = 0
                        do {
                            println(j)
                            j++
                        } while (j < 5)
                        
                        // break和continue
                        for (i in 1..10) {
                            if (i == 5) continue  // 跳过当前迭代
                            if (i == 8) break     // 跳出循环
                            println(i)
                        }
                        
                        // 标签（Label）
                        outer@ for (i in 1..3) {
                            inner@ for (j in 1..3) {
                                if (j == 2) break@inner  // 跳出内层循环
                                if (i == 2) break@outer  // 跳出外层循环
                                println("i=${'$'}i, j=${'$'}j")
                            }
                        }
                    """.trimIndent(),
                    explanation = "while和do-while循环与其他语言类似。Kotlin支持标签（Label）来精确控制break和continue的作用范围。"
                )
            ),
            useCases = listOf(
                "条件判断：使用if表达式进行简单的条件判断和赋值",
                "多分支选择：使用when表达式替代多个if-else，代码更清晰",
                "类型匹配：使用when进行类型检查和处理",
                "集合遍历：使用for循环遍历List、Set、Map等集合",
                "范围迭代：使用for循环遍历数字范围、字符范围",
                "循环控制：使用break和continue控制循环流程"
            ),
            keyPoints = listOf(
                "if可以作为表达式使用，返回最后一个表达式的值",
                "when是强大的条件表达式，可以匹配值、范围、类型等",
                "for循环支持范围（..、until、downTo、step）、集合、Map等",
                "while和do-while循环与其他语言类似",
                "标签（Label）可以精确控制break和continue的作用范围"
            ),
            notes = listOf(
                "..创建包含结束值的范围，until创建不包含结束值的范围",
                "when表达式必须覆盖所有可能的情况，或者有else分支",
                "when作为表达式时，所有分支必须返回相同类型",
                "for循环中的变量是只读的，不能在循环体内修改",
                "break和continue默认作用于最近的循环，可以使用标签指定目标"
            ),
            practiceTips = "建议：优先使用when表达式替代多个if-else链，代码更简洁易读。在使用for循环时，优先使用in操作符和范围，而不是传统的索引方式。"
        ),
        
        // 4. 函数（函数声明、默认参数、命名参数、可变参数、单表达式函数）
        KnowledgeDetail(
            id = "functions",
            title = "函数（函数声明、默认参数、命名参数、可变参数、单表达式函数）",
            overview = "Kotlin的函数系统非常灵活强大，支持默认参数、命名参数、可变参数等特性，让函数调用更加简洁和易读。",
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：函数声明和调用",
                    code = """
                        // 标准函数声明
                        fun greet(name: String): String {
                            return "Hello, ${'$'}name!"
                        }
                        
                        // 单表达式函数（函数体只有一个表达式时）
                        fun greet2(name: String): String = "Hello, ${'$'}name!"
                        
                        // 类型推断的单表达式函数（返回类型可省略）
                        fun greet3(name: String) = "Hello, ${'$'}name!"
                        
                        // 无返回值函数（Unit可以省略）
                        fun printGreeting(name: String): Unit {
                            println("Hello, ${'$'}name!")
                        }
                        // 等价于
                        fun printGreeting2(name: String) {
                            println("Hello, ${'$'}name!")
                        }
                        
                        // 函数调用
                        val message = greet("Kotlin")
                        println(message)
                    """.trimIndent(),
                    explanation = "Kotlin函数使用fun关键字声明。单表达式函数可以使用=简化，返回类型可以推断。Unit类型表示无返回值，可以省略。"
                ),
                CodeExample(
                    title = "示例2：默认参数",
                    code = """
                        // 带默认参数的函数
                        fun greet(name: String, prefix: String = "Hello", suffix: String = "!") {
                            println("${'$'}prefix, ${'$'}name${'$'}suffix")
                        }
                        
                        // 调用方式
                        greet("Kotlin")                    // 使用所有默认参数
                        greet("Kotlin", "Hi")             // 只覆盖第一个默认参数
                        greet("Kotlin", "Hi", "!!!")      // 覆盖所有参数
                        
                        // 默认参数可以大大减少函数重载的需要
                        fun createUser(
                            name: String,
                            age: Int = 0,
                            email: String = "",
                            isActive: Boolean = true
                        ) {
                            // 创建用户逻辑
                        }
                        
                        createUser("Alice")  // 只提供必需参数
                        createUser("Bob", age = 25)  // 使用命名参数（见示例3）
                    """.trimIndent(),
                    explanation = "默认参数允许函数参数有默认值，调用时可以不提供这些参数，减少函数重载的需要。"
                ),
                CodeExample(
                    title = "示例3：命名参数",
                    code = """
                        // 命名参数：调用函数时使用参数名
                        fun createUser(name: String, age: Int, email: String) {
                            // 创建用户逻辑
                        }
                        
                        // 传统方式（位置参数）
                        createUser("Alice", 25, "alice@example.com")
                        
                        // 使用命名参数（更清晰易读）
                        createUser(
                            name = "Alice",
                            age = 25,
                            email = "alice@example.com"
                        )
                        
                        // 混合使用位置参数和命名参数
                        createUser("Alice", age = 25, email = "alice@example.com")
                        // 注意：位置参数必须在命名参数之前
                        
                        // 命名参数的优势
                        createUser(
                            email = "alice@example.com",
                            name = "Alice",
                            age = 25
                        )  // 参数顺序可以改变，代码更易读
                    """.trimIndent(),
                    explanation = "命名参数使用参数名指定参数值，提高代码可读性，参数顺序可以改变。位置参数必须在命名参数之前。"
                ),
                CodeExample(
                    title = "示例4：可变参数（vararg）",
                    code = """
                        // 可变参数：使用vararg关键字
                        fun sum(vararg numbers: Int): Int {
                            var total = 0
                            for (number in numbers) {
                                total += number
                            }
                            return total
                        }
                        
                        // 调用可变参数函数
                        sum(1, 2, 3)              // 传入多个参数
                        sum(1, 2, 3, 4, 5)        // 传入任意数量的参数
                        
                        // 将数组展开为可变参数（使用*操作符）
                        val numbers = intArrayOf(1, 2, 3, 4, 5)
                        sum(*numbers)             // 展开数组
                        
                        // 混合固定参数和可变参数
                        fun printNames(prefix: String, vararg names: String) {
                            names.forEach { name ->
                                println("${'$'}prefix ${'$'}name")
                            }
                        }
                        
                        printNames("Hello", "Alice", "Bob", "Charlie")
                        // 输出：
                        // Hello Alice
                        // Hello Bob
                        // Hello Charlie
                    """.trimIndent(),
                    explanation = "vararg允许函数接受可变数量的参数，类似Java的可变参数。使用*操作符可以将数组展开为可变参数。"
                ),
                CodeExample(
                    title = "示例5：单表达式函数和函数类型",
                    code = """
                        // 单表达式函数（简洁写法）
                        fun double(x: Int): Int = x * 2
                        fun max(a: Int, b: Int) = if (a > b) a else b
                        fun isEven(n: Int) = n % 2 == 0
                        
                        // 函数类型（函数可以作为参数和返回值）
                        fun operate(x: Int, y: Int, operation: (Int, Int) -> Int): Int {
                            return operation(x, y)
                        }
                        
                        // 调用高阶函数
                        val sum = operate(5, 3) { a, b -> a + b }  // Lambda表达式
                        val product = operate(5, 3) { a, b -> a * b }
                        
                        // 函数作为返回值
                        fun getOperation(type: String): (Int, Int) -> Int {
                            return when (type) {
                                "add" -> { a, b -> a + b }
                                "multiply" -> { a, b -> a * b }
                                else -> { _, _ -> 0 }
                            }
                        }
                    """.trimIndent(),
                    explanation = "单表达式函数使用=简化写法。函数类型允许函数作为参数和返回值，支持函数式编程。"
                )
            ),
            useCases = listOf(
                "API设计：使用默认参数提供合理的默认值，简化函数调用",
                "配置函数：使用命名参数提高可读性，特别是参数较多时",
                "工具函数：使用可变参数处理不定数量的参数",
                "简化代码：使用单表达式函数简化简单函数",
                "函数式编程：使用函数类型实现高阶函数"
            ),
            keyPoints = listOf(
                "函数使用fun关键字声明，单表达式函数可以用=简化",
                "默认参数允许参数有默认值，减少函数重载",
                "命名参数提高可读性，参数顺序可以改变",
                "vararg用于可变参数，*操作符展开数组",
                "函数类型支持函数作为参数和返回值"
            ),
            notes = listOf(
                "默认参数必须在非默认参数之后",
                "位置参数必须在命名参数之前",
                "一个函数只能有一个vararg参数，通常放在最后",
                "单表达式函数可以省略返回类型（类型推断）",
                "函数类型语法：(参数类型) -> 返回类型"
            ),
            practiceTips = "建议：对于参数较多的函数，使用默认参数和命名参数提高可读性。优先使用单表达式函数简化简单函数。在API设计时，合理使用默认参数可以减少函数重载的需要。"
        )
    )
}






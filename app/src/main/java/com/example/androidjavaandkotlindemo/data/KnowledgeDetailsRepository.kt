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
        ),
        
        // ========== Kotlin 面向对象编程 ==========
        
        // 1. 类声明、构造函数、初始化块、对象声明、伴生对象
        KnowledgeDetail(
            id = "class_object",
            title = "类声明、构造函数、初始化块、对象声明、伴生对象",
            overview = "Kotlin的类系统比Java更简洁强大。理解类的声明方式、主构造函数和次构造函数、初始化块、对象声明和伴生对象，是掌握Kotlin面向对象编程的基础。",
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：类声明和主构造函数",
                    code = """
                        // 最简单的类声明
                        class Person
                        
                        // 带主构造函数的类（推荐方式）
                        class Person(val name: String, var age: Int) {
                            // 类体
                        }
                        
                        // 主构造函数可以包含初始化代码
                        class Person(val name: String, var age: Int) {
                            init {
                                // 初始化块，在对象创建时执行
                                require(age >= 0) { "Age must be non-negative" }
                                println("Person created: ${'$'}name, age: ${'$'}age")
                            }
                        }
                        
                        // 主构造函数参数可以有默认值
                        class Person(
                            val name: String,
                            var age: Int = 0,
                            val email: String = ""
                        )
                        
                        // 使用
                        val person1 = Person("Alice", 25)
                        val person2 = Person("Bob")  // age使用默认值0
                        val person3 = Person("Charlie", 30, "charlie@example.com")
                    """.trimIndent(),
                    explanation = "Kotlin的类声明非常简洁。主构造函数直接写在类名后面，参数可以声明为val或var，自动成为类的属性。init块在对象创建时执行。"
                ),
                CodeExample(
                    title = "示例2：次构造函数",
                    code = """
                        class Person(val name: String, var age: Int) {
                            // 次构造函数必须委托给主构造函数或其他次构造函数
                            constructor(name: String) : this(name, 0) {
                                println("Secondary constructor called")
                            }
                            
                            // 多个次构造函数
                            constructor() : this("Unknown", 0) {
                                println("Default constructor called")
                            }
                        }
                        
                        // 使用
                        val person1 = Person("Alice", 25)  // 主构造函数
                        val person2 = Person("Bob")        // 次构造函数
                        val person3 = Person()             // 默认次构造函数
                    """.trimIndent(),
                    explanation = "次构造函数使用constructor关键字声明，必须委托给主构造函数或其他次构造函数。Kotlin推荐优先使用主构造函数的默认参数，而不是次构造函数。"
                ),
                CodeExample(
                    title = "示例3：初始化块（init）",
                    code = """
                        class Person(val name: String, var age: Int) {
                            // 可以有多个init块，按顺序执行
                            init {
                                println("First init block")
                            }
                            
                            val description: String
                            
                            init {
                                description = "Person: ${'$'}name, Age: ${'$'}age"
                                println("Second init block")
                            }
                            
                            // init块可以访问主构造函数参数和属性
                            init {
                                if (age < 18) {
                                    println("Warning: ${'$'}name is a minor")
                                }
                            }
                        }
                        
                        // 执行顺序：
                        // 1. 主构造函数参数初始化
                        // 2. 属性初始化
                        // 3. init块按顺序执行
                        // 4. 次构造函数体执行（如果有）
                    """.trimIndent(),
                    explanation = "init块在对象创建时按顺序执行，可以访问主构造函数参数和属性。多个init块按声明顺序执行。"
                ),
                CodeExample(
                    title = "示例4：对象声明（object）",
                    code = """
                        // 对象声明：单例模式
                        object DatabaseManager {
                            private var connectionCount = 0
                            
                            fun connect() {
                                connectionCount++
                                println("Connected. Total connections: ${'$'}connectionCount")
                            }
                            
                            fun disconnect() {
                                connectionCount--
                                println("Disconnected. Total connections: ${'$'}connectionCount")
                            }
                        }
                        
                        // 使用（直接通过对象名访问，无需创建实例）
                        DatabaseManager.connect()
                        DatabaseManager.disconnect()
                        
                        // 对象声明可以实现接口
                        interface Clickable {
                            fun click()
                        }
                        
                        object Button : Clickable {
                            override fun click() {
                                println("Button clicked")
                            }
                        }
                    """.trimIndent(),
                    explanation = "object关键字用于创建单例对象。对象声明在首次访问时创建，整个程序运行期间只有一个实例。可以直接通过对象名访问，无需创建实例。"
                ),
                CodeExample(
                    title = "示例5：伴生对象（companion object）",
                    code = """
                        class MyClass {
                            // 伴生对象：类似Java的静态成员
                            companion object {
                                // 伴生对象的常量
                                const val MAX_SIZE = 100
                                
                                // 伴生对象的函数
                                fun create(): MyClass {
                                    return MyClass()
                                }
                                
                                // 伴生对象可以有自己的名称
                                fun getInstance(): MyClass {
                                    return MyClass()
                                }
                            }
                        }
                        
                        // 使用（通过类名直接访问）
                        val maxSize = MyClass.MAX_SIZE
                        val instance = MyClass.create()
                        
                        // 伴生对象可以实现接口
                        interface Factory<T> {
                            fun create(): T
                        }
                        
                        class MyClass {
                            companion object : Factory<MyClass> {
                                override fun create(): MyClass {
                                    return MyClass()
                                }
                            }
                        }
                        
                        // 伴生对象可以有名称
                        class MyClass {
                            companion object Named {
                                fun create() = MyClass()
                            }
                        }
                        
                        // 使用命名伴生对象
                        val instance = MyClass.Named.create()
                    """.trimIndent(),
                    explanation = "companion object用于在类中定义类似Java静态成员的内容。可以通过类名直接访问，无需创建类实例。伴生对象可以有名称，也可以实现接口。"
                )
            ),
            useCases = listOf(
                "数据模型：使用主构造函数快速定义数据类",
                "单例模式：使用object声明实现单例",
                "工具类：使用object或companion object创建工具类",
                "工厂方法：在companion object中定义工厂方法",
                "初始化逻辑：使用init块进行对象初始化验证和设置"
            ),
            keyPoints = listOf(
                "主构造函数直接写在类名后面，参数可以声明为val或var",
                "init块在对象创建时按顺序执行，可以访问主构造函数参数",
                "次构造函数必须委托给主构造函数或其他次构造函数",
                "object声明创建单例对象，首次访问时创建",
                "companion object类似Java的静态成员，可以通过类名直接访问"
            ),
            notes = listOf(
                "Kotlin推荐使用主构造函数的默认参数，而不是次构造函数",
                "object声明不能有构造函数",
                "companion object可以有名称，也可以实现接口",
                "init块可以访问主构造函数参数，但不能访问次构造函数参数",
                "主构造函数参数如果声明为val或var，会自动成为类的属性"
            ),
            practiceTips = "建议：优先使用主构造函数和默认参数，减少次构造函数的使用。对于单例模式，使用object声明比Java的静态方法更优雅。在companion object中定义工厂方法和常量，保持代码组织清晰。"
        ),
        
        // 2. 属性声明、自定义getter/setter、延迟初始化
        KnowledgeDetail(
            id = "properties",
            title = "属性声明、自定义getter/setter、延迟初始化",
            overview = "Kotlin的属性系统非常强大，支持自动生成getter/setter、自定义访问器、延迟初始化等特性。理解这些特性可以让代码更简洁、更安全。",
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：属性声明",
                    code = """
                        class Person {
                            // 只读属性（val）：只有getter，不能重新赋值
                            val name: String = "Alice"
                            
                            // 可变属性（var）：有getter和setter，可以重新赋值
                            var age: Int = 25
                            
                            // 类型推断
                            val email = "alice@example.com"  // 推断为String
                            var count = 0                     // 推断为Int
                        }
                        
                        val person = Person()
                        println(person.name)  // 访问getter
                        // person.name = "Bob"  // ❌ 错误！val属性不能重新赋值
                        person.age = 26       // ✅ 正确！var属性可以重新赋值
                        println(person.age)   // 访问getter
                    """.trimIndent(),
                    explanation = "Kotlin的属性默认有getter和setter。val属性只有getter，var属性有getter和setter。访问属性时自动调用getter，赋值时自动调用setter。"
                ),
                CodeExample(
                    title = "示例2：自定义getter",
                    code = """
                        class Rectangle(val width: Int, val height: Int) {
                            // 自定义getter：计算属性
                            val area: Int
                                get() = width * height
                            
                            // 自定义getter：带逻辑
                            val isSquare: Boolean
                                get() {
                                    return width == height
                                }
                            
                            // 自定义getter：简化写法
                            val perimeter: Int
                                get() = 2 * (width + height)
                        }
                        
                        val rect = Rectangle(10, 20)
                        println(rect.area)        // 200
                        println(rect.isSquare)   // false
                        println(rect.perimeter)   // 60
                    """.trimIndent(),
                    explanation = "可以使用自定义getter创建计算属性。getter在每次访问属性时执行，可以包含逻辑计算。"
                ),
                CodeExample(
                    title = "示例3：自定义setter",
                    code = """
                        class Person {
                            var name: String = ""
                                set(value) {
                                    // 自定义setter：验证和转换
                                    field = value.trim().capitalize()
                                }
                            
                            var age: Int = 0
                                set(value) {
                                    // 自定义setter：验证
                                    if (value < 0) {
                                        throw IllegalArgumentException("Age cannot be negative")
                                    }
                                    field = value
                                }
                            
                            // 使用field关键字访问幕后字段
                            var email: String = ""
                                set(value) {
                                    if (value.contains("@")) {
                                        field = value
                                    } else {
                                        throw IllegalArgumentException("Invalid email")
                                    }
                                }
                        }
                        
                        val person = Person()
                        person.name = "  alice  "  // 自动trim和capitalize
                        println(person.name)       // "Alice"
                        person.age = 25           // ✅ 正确
                        // person.age = -1         // ❌ 抛出异常
                    """.trimIndent(),
                    explanation = "可以使用自定义setter在赋值时进行验证和转换。在setter中使用field关键字访问幕后字段（backing field），避免递归调用。"
                ),
                CodeExample(
                    title = "示例4：延迟初始化（lateinit）",
                    code = """
                        class MyClass {
                            // lateinit用于延迟初始化非空属性
                            lateinit var name: String
                            lateinit var service: MyService
                            
                            fun initialize() {
                                name = "Alice"
                                service = MyService()
                            }
                            
                            fun useProperty() {
                                // 使用前检查是否已初始化
                                if (::name.isInitialized) {
                                    println(name)
                                }
                            }
                        }
                        
                        val obj = MyClass()
                        // println(obj.name)  // ❌ 错误！未初始化
                        obj.initialize()
                        println(obj.name)     // ✅ 正确！已初始化
                        
                        // lateinit的限制：
                        // 1. 只能用于var属性
                        // 2. 不能用于基本类型（Int、Double等）
                        // 3. 不能用于可空类型
                        // 4. 不能有自定义getter/setter
                    """.trimIndent(),
                    explanation = "lateinit用于延迟初始化非空属性，适用于需要在对象创建后某个时刻初始化的属性。使用::property.isInitialized检查是否已初始化。"
                ),
                CodeExample(
                    title = "示例5：lazy延迟初始化",
                    code = """
                        class MyClass {
                            // lazy：首次访问时初始化，之后复用结果
                            val expensiveProperty: String by lazy {
                                println("Initializing expensive property")
                                // 执行昂贵的初始化操作
                                "Expensive Value"
                            }
                            
                            // lazy是线程安全的（默认）
                            val threadSafeProperty: String by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
                                "Thread Safe Value"
                            }
                            
                            // 非线程安全的lazy（性能更好，但只适用于单线程）
                            val nonThreadSafeProperty: String by lazy(LazyThreadSafetyMode.NONE) {
                                "Non Thread Safe Value"
                            }
                        }
                        
                        val obj = MyClass()
                        // 此时expensiveProperty还未初始化
                        println(obj.expensiveProperty)  // 首次访问，执行初始化
                        println(obj.expensiveProperty)  // 直接返回缓存值，不执行初始化
                    """.trimIndent(),
                    explanation = "lazy是属性委托，用于延迟初始化。首次访问时执行初始化代码，之后直接返回缓存值。默认是线程安全的，也可以指定非线程安全模式以提高性能。"
                )
            ),
            useCases = listOf(
                "计算属性：使用自定义getter创建计算属性（如面积、周长）",
                "数据验证：使用自定义setter验证和转换数据",
                "延迟初始化：使用lateinit延迟初始化需要在外部注入的属性",
                "性能优化：使用lazy延迟初始化昂贵的计算或资源",
                "依赖注入：在Android中使用lateinit初始化View和依赖"
            ),
            keyPoints = listOf(
                "val属性只有getter，var属性有getter和setter",
                "自定义getter用于创建计算属性",
                "自定义setter用于验证和转换数据，使用field访问幕后字段",
                "lateinit用于延迟初始化非空var属性，不能用于基本类型",
                "lazy是属性委托，首次访问时初始化，之后复用结果"
            ),
            notes = listOf(
                "在自定义setter中必须使用field关键字，不能直接使用属性名（会递归调用）",
                "lateinit只能用于var属性，不能用于基本类型和可空类型",
                "使用::property.isInitialized检查lateinit属性是否已初始化",
                "lazy默认是线程安全的，也可以指定非线程安全模式",
                "计算属性（只有getter的属性）没有幕后字段"
            ),
            practiceTips = "建议：优先使用val属性，只有在确实需要修改时才使用var。对于需要验证的属性，使用自定义setter。在Android开发中，使用lateinit初始化View和依赖，使用lazy延迟初始化昂贵的资源。"
        ),
        
        // 3. 类的继承、方法重写、抽象类和接口
        KnowledgeDetail(
            id = "inheritance",
            title = "类的继承、方法重写、抽象类和接口",
            overview = "Kotlin的继承系统与Java有所不同：所有类默认是final的，需要显式使用open关键字才能被继承。理解继承、方法重写、抽象类和接口的使用，是掌握Kotlin面向对象编程的关键。",
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：类继承",
                    code = """
                        // Kotlin中所有类默认是final的，不能被继承
                        // class Person  // 默认final，不能被继承
                        
                        // 使用open关键字允许继承
                        open class Person(val name: String, var age: Int) {
                            // 默认方法也是final的，不能被重写
                            fun introduce() {
                                println("I am ${'$'}name, ${'$'}age years old")
                            }
                            
                            // 使用open关键字允许重写
                            open fun greet() {
                                println("Hello, I'm ${'$'}name")
                            }
                        }
                        
                        // 继承：使用:符号
                        class Student(name: String, age: Int, val studentId: String) : Person(name, age) {
                            // 重写open方法
                            override fun greet() {
                                println("Hello, I'm ${'$'}name, student ID: ${'$'}studentId")
                            }
                            
                            // 可以添加新方法
                            fun study() {
                                println("${'$'}name is studying")
                            }
                        }
                        
                        val student = Student("Alice", 20, "S001")
                        student.introduce()  // 继承的方法
                        student.greet()       // 重写的方法
                        student.study()       // 新方法
                    """.trimIndent(),
                    explanation = "Kotlin中所有类默认是final的，需要使用open关键字才能被继承。方法也需要使用open关键字才能被重写。继承使用:符号，子类必须调用父类构造函数。"
                ),
                CodeExample(
                    title = "示例2：方法重写",
                    code = """
                        open class Animal(val name: String) {
                            // open方法可以被重写
                            open fun makeSound() {
                                println("Some sound")
                            }
                            
                            // final方法不能被重写（默认）
                            fun eat() {
                                println("Eating")
                            }
                        }
                        
                        class Dog(name: String) : Animal(name) {
                            // 重写open方法
                            override fun makeSound() {
                                println("${'$'}name barks: Woof!")
                            }
                            
                            // 可以调用父类方法
                            fun makeSoundAndEat() {
                                super.makeSound()  // 调用父类方法
                                eat()              // 调用继承的方法
                            }
                        }
                        
                        // 禁止重写：使用final关键字
                        open class Base {
                            open fun method1() {}
                            
                            final fun method2() {  // 即使父类是open，也可以标记为final
                                // 这个方法不能被重写
                            }
                        }
                        
                        class Derived : Base() {
                            override fun method1() {}  // ✅ 可以重写
                            // override fun method2() {}  // ❌ 错误！不能重写final方法
                        }
                    """.trimIndent(),
                    explanation = "使用override关键字重写open方法。可以使用super关键字调用父类方法。使用final关键字可以禁止重写（即使父类是open的）。"
                ),
                CodeExample(
                    title = "示例3：抽象类",
                    code = """
                        // 抽象类：使用abstract关键字
                        abstract class Animal(val name: String) {
                            // 抽象方法：必须被重写
                            abstract fun makeSound()
                            
                            // 抽象类可以有具体方法
                            fun eat() {
                                println("${'$'}name is eating")
                            }
                            
                            // 抽象类可以有open方法
                            open fun sleep() {
                                println("${'$'}name is sleeping")
                            }
                        }
                        
                        // 实现抽象类
                        class Dog(name: String) : Animal(name) {
                            // 必须实现抽象方法
                            override fun makeSound() {
                                println("${'$'}name barks: Woof!")
                            }
                            
                            // 可以选择重写open方法
                            override fun sleep() {
                                println("${'$'}name sleeps in a dog bed")
                            }
                        }
                        
                        class Cat(name: String) : Animal(name) {
                            override fun makeSound() {
                                println("${'$'}name meows: Meow!")
                            }
                        }
                        
                        // 抽象类不能实例化
                        // val animal = Animal("Unknown")  // ❌ 错误！
                        val dog = Dog("Buddy")
                        dog.makeSound()  // "Buddy barks: Woof!"
                        dog.eat()        // "Buddy is eating"
                    """.trimIndent(),
                    explanation = "抽象类使用abstract关键字，可以包含抽象方法（必须被重写）和具体方法。抽象类不能实例化，必须被继承。"
                ),
                CodeExample(
                    title = "示例4：接口",
                    code = """
                        // 接口：可以包含抽象方法和默认实现
                        interface Clickable {
                            // 抽象方法（默认是抽象的）
                            fun click()
                            
                            // 默认实现方法
                            fun showOff() {
                                println("I'm clickable!")
                            }
                        }
                        
                        interface Focusable {
                            fun setFocus(b: Boolean) {
                                println("I ${'$'}{if (b) "got" else "lost"} focus.")
                            }
                            
                            fun showOff() {
                                println("I'm focusable!")
                            }
                        }
                        
                        // 实现接口
                        class Button : Clickable {
                            override fun click() {
                                println("Button was clicked")
                            }
                        }
                        
                        // 实现多个接口
                        class Button2 : Clickable, Focusable {
                            override fun click() {
                                println("Button was clicked")
                            }
                            
                            // 必须重写冲突的默认方法
                            override fun showOff() {
                                super<Clickable>.showOff()  // 调用Clickable的实现
                                super<Focusable>.showOff()  // 调用Focusable的实现
                            }
                        }
                        
                        // 接口可以有属性
                        interface User {
                            val nickname: String  // 抽象属性
                            
                            // 可以有默认实现
                            val email: String
                                get() = "${'$'}nickname@example.com"
                        }
                        
                        class PrivateUser(override val nickname: String) : User
                        class SubscribingUser(val email: String) : User {
                            override val nickname: String
                                get() = email.substringBefore('@')
                        }
                    """.trimIndent(),
                    explanation = "Kotlin接口可以包含抽象方法和默认实现。类可以实现多个接口。如果多个接口有相同的方法签名，必须显式重写并指定调用哪个父接口的实现。接口可以有抽象属性和带getter的属性。"
                ),
                CodeExample(
                    title = "示例5：继承和接口的组合",
                    code = """
                        // 抽象类
                        abstract class Animal(val name: String) {
                            abstract fun makeSound()
                        }
                        
                        // 接口
                        interface Flyable {
                            fun fly()
                        }
                        
                        interface Swimmable {
                            fun swim()
                        }
                        
                        // 继承抽象类并实现接口
                        class Bird(name: String) : Animal(name), Flyable {
                            override fun makeSound() {
                                println("${'$'}name chirps")
                            }
                            
                            override fun fly() {
                                println("${'$'}name is flying")
                            }
                        }
                        
                        // 实现多个接口
                        class Duck(name: String) : Animal(name), Flyable, Swimmable {
                            override fun makeSound() {
                                println("${'$'}name quacks")
                            }
                            
                            override fun fly() {
                                println("${'$'}name is flying")
                            }
                            
                            override fun swim() {
                                println("${'$'}name is swimming")
                            }
                        }
                        
                        val bird = Bird("Sparrow")
                        bird.makeSound()  // 继承的方法
                        bird.fly()        // 接口方法
                        
                        val duck = Duck("Donald")
                        duck.makeSound()  // 继承的方法
                        duck.fly()       // 接口方法
                        duck.swim()      // 接口方法
                    """.trimIndent(),
                    explanation = "Kotlin支持单继承多实现。类可以继承一个抽象类（或open类），同时实现多个接口。继承使用:，接口也使用:，用逗号分隔。"
                )
            ),
            useCases = listOf(
                "代码复用：使用继承复用父类的代码",
                "多态：使用抽象类和接口实现多态",
                "契约定义：使用接口定义类的契约和行为",
                "默认实现：在接口中提供默认实现，减少重复代码",
                "组合优于继承：使用接口组合实现灵活的设计"
            ),
            keyPoints = listOf(
                "Kotlin中所有类默认是final的，需要使用open才能被继承",
                "方法也需要使用open才能被重写，使用override关键字重写",
                "抽象类使用abstract关键字，可以包含抽象方法和具体方法",
                "接口可以包含抽象方法和默认实现，类可以实现多个接口",
                "继承使用:符号，子类必须调用父类构造函数"
            ),
            notes = listOf(
                "Kotlin推荐优先使用接口和组合，而不是继承",
                "如果多个接口有相同的方法签名，必须显式重写",
                "使用super<InterfaceName>.method()调用特定接口的默认实现",
                "抽象类不能实例化，接口也不能实例化",
                "接口可以有抽象属性和带getter的属性"
            ),
            practiceTips = "建议：优先使用接口和组合，而不是继承。使用接口定义契约，使用抽象类提供公共实现。在Android开发中，接口特别有用，可以实现多个接口来组合不同的行为。"
        ),
        
        // 4. 可见性修饰符（public、private、protected、internal）
        KnowledgeDetail(
            id = "visibility",
            title = "可见性修饰符（public、private、protected、internal）",
            overview = "Kotlin的可见性修饰符与Java有所不同，增加了internal修饰符，并且默认可见性是public。理解这些修饰符的作用范围，有助于编写更好的封装代码。",
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：可见性修饰符概述",
                    code = """
                        // public：默认可见性，任何地方都可以访问
                        public class PublicClass {
                            public val publicProperty = "Public"
                            public fun publicMethod() {}
                        }
                        
                        // 可以省略public关键字（默认就是public）
                        class DefaultPublicClass {
                            val defaultProperty = "Default Public"
                            fun defaultMethod() {}
                        }
                        
                        // private：只在当前类内部可以访问
                        class PrivateExample {
                            private val privateProperty = "Private"
                            private fun privateMethod() {
                                println(privateProperty)  // ✅ 可以访问
                            }
                            
                            fun publicMethod() {
                                // privateMethod()  // ✅ 可以访问
                                // println(privateProperty)  // ✅ 可以访问
                            }
                        }
                        
                        // 外部无法访问private成员
                        val example = PrivateExample()
                        // example.privateProperty  // ❌ 错误！
                        // example.privateMethod()  // ❌ 错误！
                    """.trimIndent(),
                    explanation = "public是默认可见性，任何地方都可以访问。private只在当前类内部可以访问。Kotlin中默认可见性是public，与Java的包私有不同。"
                ),
                CodeExample(
                    title = "示例2：protected可见性",
                    code = """
                        open class Base {
                            private val privateMember = "Private"
                            protected val protectedMember = "Protected"
                            public val publicMember = "Public"
                            internal val internalMember = "Internal"
                            
                            private fun privateMethod() {}
                            protected fun protectedMethod() {
                                println("Protected method in Base")
                            }
                        }
                        
                        class Derived : Base() {
                            fun test() {
                                // privateMember  // ❌ 错误！不能访问父类的private成员
                                println(protectedMember)  // ✅ 可以访问父类的protected成员
                                println(publicMember)     // ✅ 可以访问
                                println(internalMember)   // ✅ 可以访问
                                
                                protectedMethod()  // ✅ 可以调用父类的protected方法
                            }
                        }
                        
                        // 外部访问
                        val derived = Derived()
                        // derived.protectedMember  // ❌ 错误！protected成员不能从外部访问
                        println(derived.publicMember)   // ✅ 可以访问
                        println(derived.internalMember) // ✅ 可以访问（如果在同一模块）
                    """.trimIndent(),
                    explanation = "protected成员在类内部和子类中可以访问，但不能从外部访问。与Java不同，Kotlin的protected成员在子类中可见，但不能在包级别访问。"
                ),
                CodeExample(
                    title = "示例3：internal可见性",
                    code = """
                        // internal：在同一模块内可见（模块 = 一起编译的一组Kotlin文件）
                        internal class InternalClass {
                            internal val internalProperty = "Internal"
                            internal fun internalMethod() {}
                        }
                        
                        // 在同一模块的其他文件中可以访问
                        fun testInternal() {
                            val obj = InternalClass()  // ✅ 可以访问（同一模块）
                            println(obj.internalProperty)  // ✅ 可以访问
                            obj.internalMethod()  // ✅ 可以访问
                        }
                        
                        // 在不同模块中无法访问
                        // 假设这是另一个模块的代码
                        // val obj = InternalClass()  // ❌ 错误！不同模块无法访问
                        
                        // internal常用于库开发
                        // 库的公共API使用public
                        // 库的内部实现使用internal，对库的使用者隐藏
                        public class PublicAPI {
                            public fun publicMethod() {}
                            internal fun internalMethod() {}  // 库内部使用
                        }
                    """.trimIndent(),
                    explanation = "internal是Kotlin特有的可见性修饰符，表示在同一模块内可见。模块是指一起编译的一组Kotlin文件（如一个Gradle模块）。internal常用于库开发，隐藏内部实现。"
                ),
                CodeExample(
                    title = "示例4：可见性修饰符在类成员上的应用",
                    code = """
                        class Example {
                            // 属性可见性
                            public val publicProp = "Public"
                            private val privateProp = "Private"
                            protected val protectedProp = "Protected"
                            internal val internalProp = "Internal"
                            
                            // 方法可见性
                            public fun publicMethod() {}
                            private fun privateMethod() {}
                            protected fun protectedMethod() {}
                            internal fun internalMethod() {}
                            
                            // 主构造函数可见性
                            class PublicConstructor public constructor(val name: String)
                            class PrivateConstructor private constructor(val name: String)
                            class InternalConstructor internal constructor(val name: String)
                            
                            // 默认构造函数是public的
                            class DefaultConstructor(val name: String)  // public
                        }
                        
                        // 使用
                        val public = Example.PublicConstructor("Public")
                        // val private = Example.PrivateConstructor("Private")  // ❌ 错误！
                        val internal = Example.InternalConstructor("Internal")  // ✅ 同一模块可以访问
                    """.trimIndent(),
                    explanation = "可见性修饰符可以应用于类、属性、方法、构造函数等。主构造函数可以指定可见性，如果指定了可见性，constructor关键字不能省略。"
                ),
                CodeExample(
                    title = "示例5：可见性修饰符最佳实践",
                    code = """
                        // 1. 默认使用private，只在需要时提升可见性
                        class BankAccount {
                            private var balance: Double = 0.0  // 私有，保护数据
                            
                            fun deposit(amount: Double) {  // 公共方法
                                if (amount > 0) {
                                    balance += amount
                                }
                            }
                            
                            fun withdraw(amount: Double): Boolean {
                                if (amount > 0 && balance >= amount) {
                                    balance -= amount
                                    return true
                                }
                                return false
                            }
                            
                            fun getBalance(): Double = balance  // 只读访问
                        }
                        
                        // 2. 使用internal隐藏库的内部实现
                        // 库的公共API
                        public class UserService {
                            public fun getUser(id: String): User? {
                                return internalGetUser(id)
                            }
                            
                            // 内部实现，库使用者无法访问
                            internal fun internalGetUser(id: String): User? {
                                // 内部实现逻辑
                                return null
                            }
                        }
                        
                        // 3. 使用protected在继承层次中共享
                        open class BaseRepository {
                            protected fun validateData(data: Any): Boolean {
                                // 子类可以访问，外部不能访问
                                return true
                            }
                        }
                    """.trimIndent(),
                    explanation = "最佳实践：默认使用private，只在需要时提升可见性。使用internal隐藏库的内部实现。使用protected在继承层次中共享。遵循最小可见性原则，提高代码的封装性和安全性。"
                )
            ),
            useCases = listOf(
                "数据封装：使用private保护类的内部数据",
                "API设计：使用public定义公共API，使用internal隐藏内部实现",
                "继承设计：使用protected在继承层次中共享成员",
                "库开发：使用internal隐藏库的内部实现，只暴露公共API",
                "模块化：使用internal实现模块内部的封装"
            ),
            keyPoints = listOf(
                "public是默认可见性，任何地方都可以访问",
                "private只在当前类内部可以访问",
                "protected在类内部和子类中可以访问，但不能从外部访问",
                "internal在同一模块内可见，是Kotlin特有的修饰符",
                "主构造函数可以指定可见性"
            ),
            notes = listOf(
                "Kotlin中默认可见性是public，与Java的包私有不同",
                "Kotlin的protected成员在子类中可见，但不能在包级别访问（与Java不同）",
                "模块是指一起编译的一组Kotlin文件（如一个Gradle模块）",
                "如果主构造函数指定了可见性，constructor关键字不能省略",
                "遵循最小可见性原则，默认使用private"
            ),
            practiceTips = "建议：遵循最小可见性原则，默认使用private，只在需要时提升可见性。在库开发中，使用internal隐藏内部实现，只暴露必要的公共API。在Android开发中，合理使用可见性修饰符可以提高代码的安全性和可维护性。"
        )
    )
}






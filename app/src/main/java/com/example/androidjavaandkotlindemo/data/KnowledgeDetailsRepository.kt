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
        ),
        
        // ========== Kotlin 函数式编程 ==========
        
        // 1. 高阶函数、Lambda表达式、it参数、尾随Lambda
        KnowledgeDetail(
            id = "higher_order",
            title = "高阶函数、Lambda表达式、it参数、尾随Lambda",
            overview = "Kotlin的函数式编程能力非常强大。高阶函数、Lambda表达式是Kotlin函数式编程的核心。理解这些概念可以让代码更简洁、更优雅。",
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：高阶函数基础",
                    code = """
                        // 高阶函数：接受函数作为参数或返回函数的函数
                        
                        // 接受函数作为参数
                        fun calculate(x: Int, y: Int, operation: (Int, Int) -> Int): Int {
                            return operation(x, y)
                        }
                        
                        // 使用Lambda表达式调用
                        val sum = calculate(5, 3) { a, b -> a + b }
                        val product = calculate(5, 3) { a, b -> a * b }
                        println(sum)     // 8
                        println(product)  // 15
                        
                        // 返回函数的函数
                        fun getOperation(type: String): (Int, Int) -> Int {
                            return when (type) {
                                "add" -> { a, b -> a + b }
                                "multiply" -> { a, b -> a * b }
                                else -> { _, _ -> 0 }
                            }
                        }
                        
                        val addOp = getOperation("add")
                        val result = addOp(10, 20)  // 30
                    """.trimIndent(),
                    explanation = "高阶函数是接受函数作为参数或返回函数的函数。Kotlin中函数是一等公民，可以像普通值一样传递和返回。"
                ),
                CodeExample(
                    title = "示例2：Lambda表达式语法",
                    code = """
                        // Lambda表达式的基本语法：{ 参数 -> 函数体 }
                        
                        // 完整语法
                        val add: (Int, Int) -> Int = { a: Int, b: Int -> a + b }
                        
                        // 类型推断
                        val add2 = { a: Int, b: Int -> a + b }
                        
                        // 单参数Lambda可以省略参数类型
                        val square = { x: Int -> x * x }
                        
                        // 无参数Lambda
                        val greet = { println("Hello!") }
                        
                        // 多行Lambda
                        val process = { x: Int ->
                            val doubled = x * 2
                            val squared = doubled * doubled
                            squared
                        }
                        
                        // 使用
                        println(add(3, 4))      // 7
                        println(square(5))      // 25
                        greet()                // "Hello!"
                        println(process(3))    // 36
                    """.trimIndent(),
                    explanation = "Lambda表达式是匿名函数的简洁写法。语法为 { 参数 -> 函数体 }。Kotlin可以推断Lambda的类型，使代码更简洁。"
                ),
                CodeExample(
                    title = "示例3：it参数（单参数Lambda的简化）",
                    code = """
                        // 当Lambda只有一个参数时，可以使用it代替参数名
                        
                        val numbers = listOf(1, 2, 3, 4, 5)
                        
                        // 完整写法
                        val doubled1 = numbers.map { number -> number * 2 }
                        
                        // 使用it简化
                        val doubled2 = numbers.map { it * 2 }
                        
                        // it在多个Lambda中的使用
                        val result = numbers
                            .filter { it > 2 }        // it代表列表中的元素
                            .map { it * it }          // it代表过滤后的元素
                            .find { it > 10 }          // it代表映射后的元素
                        
                        // 嵌套Lambda中的it
                        val nested = listOf(listOf(1, 2), listOf(3, 4))
                        val flattened = nested.flatMap { it.map { it * 2 } }
                        // 外层it是子列表，内层it是子列表中的元素
                        
                        // 注意：如果Lambda有多个参数，必须显式声明参数名
                        val map = mapOf("a" to 1, "b" to 2)
                        map.forEach { key, value ->  // 不能使用it，因为有两个参数
                            println("${'$'}key -> ${'$'}value")
                        }
                    """.trimIndent(),
                    explanation = "当Lambda只有一个参数时，可以使用it关键字代替参数名，使代码更简洁。嵌套Lambda中，it指向最近的Lambda参数。"
                ),
                CodeExample(
                    title = "示例4：尾随Lambda（Trailing Lambda）",
                    code = """
                        // 如果函数的最后一个参数是函数类型，可以将Lambda写在括号外
                        
                        // 定义函数
                        fun performOperation(x: Int, y: Int, operation: (Int, Int) -> Int): Int {
                            return operation(x, y)
                        }
                        
                        // 传统调用方式
                        val result1 = performOperation(5, 3, { a, b -> a + b })
                        
                        // 尾随Lambda：将Lambda移到括号外
                        val result2 = performOperation(5, 3) { a, b -> a + b }
                        
                        // 如果Lambda是唯一参数，可以省略括号
                        fun execute(operation: () -> Unit) {
                            operation()
                        }
                        
                        execute { println("Hello!") }  // 省略括号
                        
                        // DSL风格的代码（大量使用尾随Lambda）
                        fun buildString(builder: StringBuilder.() -> Unit): String {
                            val sb = StringBuilder()
                            sb.builder()  // 调用带接收者的Lambda
                            return sb.toString()
                        }
                        
                        val text = buildString {
                            append("Hello")
                            append(" ")
                            append("World")
                        }
                        // 这就是Kotlin DSL的基础
                    """.trimIndent(),
                    explanation = "尾随Lambda是Kotlin的语法糖，当函数的最后一个参数是函数类型时，可以将Lambda写在括号外，使代码更易读。这是Kotlin DSL的基础。"
                ),
                CodeExample(
                    title = "示例5：高阶函数实践",
                    code = """
                        // 1. 集合操作
                        val numbers = listOf(1, 2, 3, 4, 5)
                        val evens = numbers.filter { it % 2 == 0 }
                        val doubled = numbers.map { it * 2 }
                        val sum = numbers.reduce { acc, n -> acc + n }
                        
                        // 2. 自定义高阶函数
                        fun <T> List<T>.customFilter(predicate: (T) -> Boolean): List<T> {
                            val result = mutableListOf<T>()
                            for (item in this) {
                                if (predicate(item)) {
                                    result.add(item)
                                }
                            }
                            return result
                        }
                        
                        val filtered = numbers.customFilter { it > 3 }
                        
                        // 3. 函数组合
                        fun <T, R, U> compose(f: (T) -> R, g: (R) -> U): (T) -> U {
                            return { x -> g(f(x)) }
                        }
                        
                        val addOne = { x: Int -> x + 1 }
                        val multiplyTwo = { x: Int -> x * 2 }
                        val composed = compose(addOne, multiplyTwo)
                        println(composed(5))  // (5 + 1) * 2 = 12
                        
                        // 4. 条件执行
                        fun <T> T.also(block: (T) -> Unit): T {
                            block(this)
                            return this
                        }
                        
                        val result = "Hello"
                            .also { println("Processing: ${'$'}it") }
                            .uppercase()
                            .also { println("Result: ${'$'}it") }
                    """.trimIndent(),
                    explanation = "高阶函数在实际开发中非常有用，可以用于集合操作、函数组合、条件执行等场景。Kotlin标准库提供了丰富的高阶函数。"
                )
            ),
            useCases = listOf(
                "集合操作：使用高阶函数处理集合数据（filter、map、reduce等）",
                "回调函数：使用Lambda作为回调函数，简化异步编程",
                "DSL构建：使用尾随Lambda构建领域特定语言（如Gradle DSL）",
                "函数组合：组合多个函数创建新的函数",
                "条件执行：使用also、let等作用域函数执行副作用"
            ),
            keyPoints = listOf(
                "高阶函数是接受函数作为参数或返回函数的函数",
                "Lambda表达式是匿名函数的简洁写法：{ 参数 -> 函数体 }",
                "单参数Lambda可以使用it关键字简化",
                "尾随Lambda：最后一个参数是函数类型时，可以将Lambda写在括号外",
                "Kotlin标准库提供了丰富的高阶函数（map、filter、reduce等）"
            ),
            notes = listOf(
                "Lambda表达式可以访问外部作用域的变量（闭包）",
                "嵌套Lambda中，it指向最近的Lambda参数",
                "如果Lambda有多个参数，必须显式声明参数名",
                "尾随Lambda是Kotlin DSL的基础",
                "高阶函数可以提高代码的复用性和可读性"
            ),
            practiceTips = "建议：优先使用Kotlin标准库提供的高阶函数（map、filter、reduce等），而不是手动编写循环。使用it简化单参数Lambda。合理使用尾随Lambda提高代码可读性。在Android开发中，高阶函数特别适合处理集合数据和异步回调。"
        ),
        
        // 2. map、filter、reduce、flatMap、groupBy等集合操作
        KnowledgeDetail(
            id = "collections_ops",
            title = "map、filter、reduce、flatMap、groupBy等集合操作",
            overview = "Kotlin提供了丰富的集合操作函数，这些函数式编程风格的API让集合处理变得简洁优雅。掌握这些操作符是编写现代Kotlin代码的关键。",
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：map - 转换操作",
                    code = """
                        // map：将集合中的每个元素转换为另一个元素
                        
                        val numbers = listOf(1, 2, 3, 4, 5)
                        
                        // 转换为平方
                        val squares = numbers.map { it * it }
                        println(squares)  // [1, 4, 9, 16, 25]
                        
                        // 转换为字符串
                        val strings = numbers.map { "Number: ${'$'}it" }
                        println(strings)  // [Number: 1, Number: 2, ...]
                        
                        // 转换类型
                        data class Person(val name: String, val age: Int)
                        val people = listOf(
                            Person("Alice", 25),
                            Person("Bob", 30)
                        )
                        val names = people.map { it.name }
                        println(names)  // [Alice, Bob]
                        
                        // mapIndexed：同时访问索引和元素
                        val indexed = numbers.mapIndexed { index, value ->
                            "Index ${'$'}index: ${'$'}value"
                        }
                    """.trimIndent(),
                    explanation = "map函数将集合中的每个元素通过转换函数映射为另一个元素，返回新的集合。这是最常用的集合操作之一。"
                ),
                CodeExample(
                    title = "示例2：filter - 过滤操作",
                    code = """
                        // filter：根据条件过滤集合元素
                        
                        val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                        
                        // 过滤偶数
                        val evens = numbers.filter { it % 2 == 0 }
                        println(evens)  // [2, 4, 6, 8, 10]
                        
                        // 过滤大于5的数
                        val large = numbers.filter { it > 5 }
                        println(large)  // [6, 7, 8, 9, 10]
                        
                        // filterIndexed：同时使用索引和元素
                        val filtered = numbers.filterIndexed { index, value ->
                            index % 2 == 0 && value > 3
                        }
                        
                        // filterNot：过滤不满足条件的元素
                        val odds = numbers.filterNot { it % 2 == 0 }
                        
                        // filterNotNull：过滤null值
                        val nullable = listOf(1, null, 2, null, 3)
                        val nonNull = nullable.filterNotNull()
                        println(nonNull)  // [1, 2, 3]
                    """.trimIndent(),
                    explanation = "filter函数根据条件过滤集合元素，返回满足条件的新集合。filterNot返回不满足条件的元素，filterNotNull过滤null值。"
                ),
                CodeExample(
                    title = "示例3：reduce和fold - 聚合操作",
                    code = """
                        // reduce：将集合元素累积为单个值
                        
                        val numbers = listOf(1, 2, 3, 4, 5)
                        
                        // 求和
                        val sum = numbers.reduce { acc, n -> acc + n }
                        println(sum)  // 15
                        
                        // 求最大值
                        val max = numbers.reduce { acc, n -> if (n > acc) n else acc }
                        println(max)  // 5
                        
                        // fold：类似reduce，但可以指定初始值
                        val sumWithInit = numbers.fold(10) { acc, n -> acc + n }
                        println(sumWithInit)  // 25 (10 + 1 + 2 + 3 + 4 + 5)
                        
                        // 字符串拼接
                        val words = listOf("Hello", "World", "Kotlin")
                        val sentence = words.fold("") { acc, word ->
                            if (acc.isEmpty()) word else "${'$'}acc ${'$'}word"
                        }
                        println(sentence)  // "Hello World Kotlin"
                        
                        // reduceRight和foldRight：从右到左累积
                        val rightSum = numbers.reduceRight { n, acc -> acc + n }
                    """.trimIndent(),
                    explanation = "reduce将集合元素累积为单个值，从第一个元素开始。fold类似但可以指定初始值。reduceRight和foldRight从右到左累积。"
                ),
                CodeExample(
                    title = "示例4：flatMap - 扁平化映射",
                    code = """
                        // flatMap：先map再flatten，将嵌套集合扁平化
                        
                        // 示例1：将嵌套列表扁平化
                        val nested = listOf(
                            listOf(1, 2, 3),
                            listOf(4, 5),
                            listOf(6, 7, 8, 9)
                        )
                        val flattened = nested.flatMap { it }
                        println(flattened)  // [1, 2, 3, 4, 5, 6, 7, 8, 9]
                        
                        // 示例2：每个元素映射为多个元素
                        val words = listOf("hello", "world")
                        val chars = words.flatMap { it.toList() }
                        println(chars)  // [h, e, l, l, o, w, o, r, l, d]
                        
                        // 示例3：复杂转换
                        data class Author(val name: String, val books: List<String>)
                        val authors = listOf(
                            Author("Alice", listOf("Book1", "Book2")),
                            Author("Bob", listOf("Book3"))
                        )
                        val allBooks = authors.flatMap { it.books }
                        println(allBooks)  // [Book1, Book2, Book3]
                        
                        // flatten：只扁平化，不映射
                        val simpleFlatten = nested.flatten()
                    """.trimIndent(),
                    explanation = "flatMap先对每个元素应用map操作，然后将结果集合扁平化。常用于处理嵌套集合或一对多的映射关系。"
                ),
                CodeExample(
                    title = "示例5：groupBy、partition、associate - 分组和关联",
                    code = """
                        // groupBy：根据键对集合分组
                        
                        val words = listOf("apple", "banana", "apricot", "blueberry", "cherry")
                        val grouped = words.groupBy { it.first() }
                        // {a=[apple, apricot], b=[banana, blueberry], c=[cherry]}
                        
                        // 按长度分组
                        val byLength = words.groupBy { it.length }
                        // {5=[apple], 6=[banana, cherry], 7=[apricot], 9=[blueberry]}
                        
                        // partition：将集合分为两部分
                        val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                        val (evens, odds) = numbers.partition { it % 2 == 0 }
                        println(evens)  // [2, 4, 6, 8, 10]
                        println(odds)   // [1, 3, 5, 7, 9]
                        
                        // associate：将集合转换为Map
                        val people = listOf("Alice", "Bob", "Charlie")
                        val nameToLength = people.associate { it to it.length }
                        // {Alice=5, Bob=3, Charlie=7}
                        
                        // associateBy：使用元素作为值
                        val byFirstChar = people.associateBy { it.first() }
                        // {A=Alice, B=Bob, C=Charlie}
                        
                        // associateWith：使用元素作为键
                        val withLength = people.associateWith { it.length }
                        // {Alice=5, Bob=3, Charlie=7}
                    """.trimIndent(),
                    explanation = "groupBy根据键对集合分组，partition将集合分为两部分，associate系列函数将集合转换为Map。这些函数在处理数据时非常有用。"
                ),
                CodeExample(
                    title = "示例6：其他常用集合操作",
                    code = """
                        val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                        
                        // take和drop：取前N个或跳过前N个
                        val first3 = numbers.take(3)      // [1, 2, 3]
                        val skip3 = numbers.drop(3)       // [4, 5, 6, 7, 8, 9, 10]
                        val takeWhile = numbers.takeWhile { it < 5 }  // [1, 2, 3, 4]
                        
                        // distinct：去重
                        val duplicates = listOf(1, 2, 2, 3, 3, 3, 4)
                        val unique = duplicates.distinct()  // [1, 2, 3, 4]
                        
                        // sorted：排序
                        val unsorted = listOf(3, 1, 4, 1, 5, 9, 2, 6)
                        val sorted = unsorted.sorted()  // [1, 1, 2, 3, 4, 5, 6, 9]
                        val sortedDesc = unsorted.sortedDescending()
                        
                        // any、all、none：条件检查
                        val hasEven = numbers.any { it % 2 == 0 }    // true
                        val allPositive = numbers.all { it > 0 }      // true
                        val noNegative = numbers.none { it < 0 }      // true
                        
                        // find和first：查找元素
                        val firstEven = numbers.find { it % 2 == 0 }  // 2
                        val firstLarge = numbers.first { it > 5 }      // 6
                        
                        // count：计数
                        val evenCount = numbers.count { it % 2 == 0 }  // 5
                    """.trimIndent(),
                    explanation = "Kotlin提供了丰富的集合操作函数，包括take/drop、distinct、sorted、any/all/none、find/first、count等，可以满足各种集合处理需求。"
                )
            ),
            useCases = listOf(
                "数据转换：使用map转换集合元素",
                "数据过滤：使用filter过滤集合元素",
                "数据聚合：使用reduce/fold计算聚合值",
                "嵌套处理：使用flatMap处理嵌套集合",
                "数据分组：使用groupBy对数据进行分组",
                "条件检查：使用any/all/none检查集合条件"
            ),
            keyPoints = listOf(
                "map：将集合元素转换为另一个元素",
                "filter：根据条件过滤集合元素",
                "reduce/fold：将集合元素累积为单个值",
                "flatMap：先map再flatten，处理嵌套集合",
                "groupBy：根据键对集合分组",
                "partition：将集合分为两部分"
            ),
            notes = listOf(
                "集合操作函数返回新集合，不修改原集合（不可变集合）",
                "可以链式调用多个操作函数",
                "操作函数是延迟计算的（Sequence），可以提高性能",
                "reduce从第一个元素开始，fold可以指定初始值",
                "flatMap常用于处理一对多的映射关系"
            ),
            practiceTips = "建议：优先使用集合操作函数而不是手动编写循环，代码更简洁易读。对于大数据集，使用Sequence进行延迟计算可以提高性能。合理组合多个操作函数，但要注意可读性，避免过度嵌套。"
        ),
        
        // 3. 函数类型、函数类型别名
        KnowledgeDetail(
            id = "function_types",
            title = "函数类型、函数类型别名",
            overview = "Kotlin中函数是一等公民，函数类型是函数式编程的基础。理解函数类型和类型别名可以让代码更清晰、更易维护。",
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：函数类型基础",
                    code = """
                        // 函数类型语法：(参数类型) -> 返回类型
                        
                        // 无参数无返回值
                        val action: () -> Unit = { println("Hello") }
                        
                        // 单参数
                        val square: (Int) -> Int = { x -> x * x }
                        
                        // 多参数
                        val add: (Int, Int) -> Int = { a, b -> a + b }
                        
                        // 可空函数类型
                        val nullable: ((String) -> String)? = null
                        
                        // 函数类型作为参数
                        fun process(x: Int, operation: (Int) -> Int): Int {
                            return operation(x)
                        }
                        
                        // 函数类型作为返回值
                        fun getOperation(type: String): (Int, Int) -> Int {
                            return when (type) {
                                "add" -> { a, b -> a + b }
                                "multiply" -> { a, b -> a * b }
                                else -> { _, _ -> 0 }
                            }
                        }
                        
                        // 使用
                        val result = process(5) { it * it }  // 25
                        val addOp = getOperation("add")
                        println(addOp(3, 4))  // 7
                    """.trimIndent(),
                    explanation = "函数类型使用 (参数类型) -> 返回类型 的语法。函数可以像普通值一样作为参数传递和返回。"
                ),
                CodeExample(
                    title = "示例2：函数类型别名（typealias）",
                    code = """
                        // 使用typealias为函数类型创建别名，提高可读性
                        
                        // 定义函数类型别名
                        typealias IntOperation = (Int) -> Int
                        typealias BinaryOperation = (Int, Int) -> Int
                        typealias Predicate<T> = (T) -> Boolean
                        typealias EventHandler = (String) -> Unit
                        
                        // 使用别名
                        val square: IntOperation = { it * it }
                        val add: BinaryOperation = { a, b -> a + b }
                        val isEven: Predicate<Int> = { it % 2 == 0 }
                        val onEvent: EventHandler = { event -> println("Event: ${'$'}event") }
                        
                        // 在函数中使用
                        fun applyOperation(x: Int, op: IntOperation): Int {
                            return op(x)
                        }
                        
                        fun filterList(list: List<Int>, predicate: Predicate<Int>): List<Int> {
                            return list.filter(predicate)
                        }
                        
                        // 复杂函数类型别名
                        typealias Transform<T, R> = (T) -> R
                        typealias Callback<T> = (Result<T>) -> Unit
                        
                        fun <T, R> mapList(list: List<T>, transform: Transform<T, R>): List<R> {
                            return list.map(transform)
                        }
                    """.trimIndent(),
                    explanation = "typealias可以为函数类型创建别名，提高代码可读性。特别是对于复杂的函数类型，使用别名可以让代码更清晰。"
                ),
                CodeExample(
                    title = "示例3：函数类型与Lambda",
                    code = """
                        // 函数类型变量可以存储Lambda表达式
                        
                        // 直接赋值
                        val operation: (Int, Int) -> Int = { a, b -> a + b }
                        
                        // 从函数引用赋值
                        fun multiply(a: Int, b: Int): Int = a * b
                        val multiplyOp: (Int, Int) -> Int = ::multiply
                        
                        // 使用函数引用
                        val numbers = listOf(1, 2, 3, 4, 5)
                        val doubled = numbers.map(::multiplyByTwo)
                        
                        fun multiplyByTwo(x: Int): Int = x * 2
                        
                        // 方法引用
                        class Calculator {
                            fun add(a: Int, b: Int): Int = a + b
                        }
                        
                        val calc = Calculator()
                        val addMethod: (Int, Int) -> Int = calc::add
                        
                        // 属性引用转换为函数类型
                        data class Person(val name: String, val age: Int)
                        val people = listOf(Person("Alice", 25), Person("Bob", 30))
                        val names = people.map(Person::name)  // 使用属性引用
                    """.trimIndent(),
                    explanation = "函数类型变量可以存储Lambda表达式、函数引用、方法引用等。函数引用使用::语法，可以简化代码。"
                ),
                CodeExample(
                    title = "示例4：高阶函数类型",
                    code = """
                        // 函数类型本身也可以作为参数和返回值
                        
                        // 接受函数类型作为参数的函数类型
                        typealias HigherOrder = ((Int) -> Int) -> Int
                        
                        fun applyTwice(f: (Int) -> Int): (Int) -> Int {
                            return { x -> f(f(x)) }
                        }
                        
                        val double = { x: Int -> x * 2 }
                        val quadruple = applyTwice(double)
                        println(quadruple(5))  // 20 (5 * 2 * 2)
                        
                        // 函数组合
                        typealias IntFunction = (Int) -> Int
                        
                        fun compose(f: IntFunction, g: IntFunction): IntFunction {
                            return { x -> g(f(x)) }
                        }
                        
                        val addOne: IntFunction = { it + 1 }
                        val multiplyTwo: IntFunction = { it * 2 }
                        val composed = compose(addOne, multiplyTwo)
                        println(composed(5))  // (5 + 1) * 2 = 12
                        
                        // 柯里化（Currying）
                        fun <A, B, C> curry(f: (A, B) -> C): (A) -> (B) -> C {
                            return { a -> { b -> f(a, b) } }
                        }
                        
                        val curriedAdd = curry { a: Int, b: Int -> a + b }
                        val addFive = curriedAdd(5)
                        println(addFive(3))  // 8
                    """.trimIndent(),
                    explanation = "函数类型可以作为其他函数的参数和返回值，实现函数组合、柯里化等高级函数式编程技术。"
                ),
                CodeExample(
                    title = "示例5：函数类型实践",
                    code = """
                        // 1. 回调函数
                        typealias OnSuccess<T> = (T) -> Unit
                        typealias OnError = (Throwable) -> Unit
                        
                        fun fetchData(
                            onSuccess: OnSuccess<String>,
                            onError: OnError
                        ) {
                            try {
                                val data = "Data loaded"
                                onSuccess(data)
                            } catch (e: Exception) {
                                onError(e)
                            }
                        }
                        
                        fetchData(
                            onSuccess = { data -> println("Success: ${'$'}data") },
                            onError = { error -> println("Error: ${'$'}error") }
                        )
                        
                        // 2. 策略模式
                        typealias SortStrategy<T> = (List<T>) -> List<T>
                        
                        fun <T : Comparable<T>> sortAscending(list: List<T>): List<T> {
                            return list.sorted()
                        }
                        
                        fun <T : Comparable<T>> sortDescending(list: List<T>): List<T> {
                            return list.sortedDescending()
                        }
                        
                        fun <T> sortList(list: List<T>, strategy: SortStrategy<T>): List<T> {
                            return strategy(list)
                        }
                        
                        val numbers = listOf(3, 1, 4, 1, 5)
                        val ascending = sortList(numbers, ::sortAscending)
                        val descending = sortList(numbers, ::sortDescending)
                        
                        // 3. 函数工厂
                        typealias Validator<T> = (T) -> Boolean
                        
                        fun <T> createValidator(predicate: (T) -> Boolean): Validator<T> {
                            return predicate
                        }
                        
                        val isPositive = createValidator<Int> { it > 0 }
                        val isEven = createValidator<Int> { it % 2 == 0 }
                    """.trimIndent(),
                    explanation = "函数类型在实际开发中非常有用，可以用于回调函数、策略模式、函数工厂等场景。使用typealias可以提高代码可读性。"
                )
            ),
            useCases = listOf(
                "回调函数：使用函数类型定义回调接口",
                "策略模式：使用函数类型实现策略模式",
                "函数组合：组合多个函数创建新函数",
                "API设计：使用函数类型设计灵活的API",
                "代码复用：通过函数类型提高代码复用性"
            ),
            keyPoints = listOf(
                "函数类型语法：(参数类型) -> 返回类型",
                "typealias可以为函数类型创建别名，提高可读性",
                "函数类型变量可以存储Lambda、函数引用、方法引用",
                "函数类型可以作为参数和返回值，实现高阶函数",
                "函数类型是函数式编程的基础"
            ),
            notes = listOf(
                "函数类型是一等公民，可以像普通值一样传递",
                "使用typealias可以让复杂的函数类型更易读",
                "函数引用使用::语法，可以引用函数、方法、属性",
                "函数类型支持泛型，可以创建通用的函数类型",
                "函数类型在Kotlin标准库中广泛使用"
            ),
            practiceTips = "建议：对于复杂的函数类型，使用typealias创建别名提高可读性。在API设计时，合理使用函数类型可以让API更灵活。在Android开发中，函数类型特别适合用于回调函数和事件处理。"
        ),
        
        // ========== Kotlin 协程（Coroutines） ==========
        
        // 1. 协程基础、挂起函数、协程构建器、协程作用域
        KnowledgeDetail(
            id = "coroutines_basic",
            title = "协程基础、挂起函数、协程构建器、协程作用域",
            overview = "Kotlin协程是轻量级的线程，用于简化异步编程。理解协程的基础概念、挂起函数、协程构建器和作用域，是掌握Kotlin异步编程的关键。",
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：协程基础概念",
                    code = """
                        // 协程是轻量级的线程，可以在不阻塞线程的情况下挂起和恢复
                        
                        import kotlinx.coroutines.*
                        
                        // 最简单的协程
                        fun main() = runBlocking {
                            launch {
                                delay(1000L)  // 非阻塞延迟1秒
                                println("World!")
                            }
                            println("Hello,")  // 立即执行
                        }
                        // 输出：Hello, World!
                        
                        // 协程的特点：
                        // 1. 轻量级：可以创建数千个协程而不会导致性能问题
                        // 2. 挂起：可以在不阻塞线程的情况下暂停执行
                        // 3. 结构化并发：协程有明确的生命周期和作用域
                        
                        // 对比线程
                        fun compareWithThread() = runBlocking {
                            // 创建1000个协程
                            repeat(1000) {
                                launch {
                                    delay(1000L)
                                    print(".")
                                }
                            }
                            // 创建1000个线程会消耗大量资源，但协程很轻量
                        }
                    """.trimIndent(),
                    explanation = "协程是轻量级的线程，可以在不阻塞线程的情况下挂起和恢复。协程比线程更轻量，可以创建大量协程而不会导致性能问题。"
                ),
                CodeExample(
                    title = "示例2：挂起函数（suspend function）",
                    code = """
                        // 挂起函数：使用suspend关键字标记，可以在协程中调用
                        
                        import kotlinx.coroutines.*
                        
                        // 挂起函数定义
                        suspend fun fetchData(): String {
                            delay(1000L)  // 模拟网络请求
                            return "Data loaded"
                        }
                        
                        // 挂起函数可以调用其他挂起函数
                        suspend fun processData(): String {
                            val data = fetchData()  // 调用挂起函数
                            delay(500L)  // 模拟处理
                            return data.uppercase()
                        }
                        
                        // 在协程中调用挂起函数
                        fun main() = runBlocking {
                            val result = fetchData()
                            println(result)  // "Data loaded"
                            
                            val processed = processData()
                            println(processed)  // "DATA LOADED"
                        }
                        
                        // 挂起函数的特点：
                        // 1. 只能在协程或其他挂起函数中调用
                        // 2. 可以挂起协程，不阻塞线程
                        // 3. 挂起时释放线程，线程可以执行其他任务
                        
                        // 错误示例：不能在普通函数中直接调用挂起函数
                        // fun normalFunction() {
                        //     fetchData()  // ❌ 错误！
                        // }
                    """.trimIndent(),
                    explanation = "挂起函数使用suspend关键字标记，可以在协程中调用。挂起函数可以挂起协程而不阻塞线程，这是协程的核心特性。"
                ),
                CodeExample(
                    title = "示例3：协程构建器（launch、async、runBlocking）",
                    code = """
                        import kotlinx.coroutines.*
                        
                        // 1. launch：启动一个协程，不返回结果
                        fun main() = runBlocking {
                            val job = launch {
                                delay(1000L)
                                println("World!")
                            }
                            println("Hello,")
                            job.join()  // 等待协程完成
                        }
                        
                        // 2. async：启动一个协程，返回Deferred结果
                        fun main() = runBlocking {
                            val deferred = async {
                                delay(1000L)
                                "Result"
                            }
                            println("Waiting...")
                            val result = deferred.await()  // 等待并获取结果
                            println(result)  // "Result"
                        }
                        
                        // 3. runBlocking：阻塞当前线程直到协程完成
                        fun main() {
                            runBlocking {
                                delay(1000L)
                                println("Blocked for 1 second")
                            }
                            println("After runBlocking")
                        }
                        
                        // 并发执行多个async
                        fun main() = runBlocking {
                            val deferred1 = async { fetchData1() }
                            val deferred2 = async { fetchData2() }
                            
                            val result1 = deferred1.await()
                            val result2 = deferred2.await()
                            println("${'$'}result1 and ${'$'}result2")
                        }
                        
                        suspend fun fetchData1(): String {
                            delay(1000L)
                            return "Data1"
                        }
                        
                        suspend fun fetchData2(): String {
                            delay(1000L)
                            return "Data2"
                        }
                        // 总耗时约1秒（并发执行），而不是2秒
                    """.trimIndent(),
                    explanation = "协程构建器用于启动协程。launch用于启动不返回结果的协程，async用于启动返回Deferred结果的协程，runBlocking用于阻塞线程直到协程完成。"
                ),
                CodeExample(
                    title = "示例4：协程作用域（CoroutineScope）",
                    code = """
                        import kotlinx.coroutines.*
                        
                        // 协程作用域定义了协程的生命周期
                        
                        // 1. GlobalScope：全局作用域，不推荐使用
                        fun globalScopeExample() {
                            GlobalScope.launch {
                                delay(1000L)
                                println("GlobalScope")
                            }
                            // 协程可能不会执行完，因为程序可能提前结束
                        }
                        
                        // 2. runBlocking作用域
                        fun runBlockingExample() = runBlocking {
                            launch {
                                delay(1000L)
                                println("In runBlocking scope")
                            }
                            // runBlocking会等待所有子协程完成
                        }
                        
                        // 3. coroutineScope：创建新的作用域，挂起直到所有子协程完成
                        suspend fun coroutineScopeExample() = coroutineScope {
                            launch {
                                delay(1000L)
                                println("Task 1")
                            }
                            launch {
                                delay(2000L)
                                println("Task 2")
                            }
                            // coroutineScope会等待所有子协程完成
                        }
                        
                        // 4. 自定义作用域
                        class MyActivity {
                            private val scope = CoroutineScope(Dispatchers.Main)
                            
                            fun loadData() {
                                scope.launch {
                                    val data = fetchData()
                                    updateUI(data)
                                }
                            }
                            
                            fun onDestroy() {
                                scope.cancel()  // 取消作用域中的所有协程
                            }
                        }
                        
                        // 5. 结构化并发
                        suspend fun structuredConcurrency() = coroutineScope {
                            val parent = launch {
                                val child1 = launch {
                                    delay(1000L)
                                    println("Child 1")
                                }
                                val child2 = launch {
                                    delay(2000L)
                                    println("Child 2")
                                }
                            }
                            // 如果parent被取消，child1和child2也会被取消
                        }
                    """.trimIndent(),
                    explanation = "协程作用域定义了协程的生命周期。结构化并发确保子协程的生命周期不会超过父协程。coroutineScope创建新的作用域并等待所有子协程完成。"
                ),
                CodeExample(
                    title = "示例5：协程实践",
                    code = """
                        import kotlinx.coroutines.*
                        
                        // 1. 网络请求示例
                        suspend fun fetchUserData(userId: String): User {
                            return withContext(Dispatchers.IO) {
                                // 在IO线程执行网络请求
                                apiService.getUser(userId)
                            }
                        }
                        
                        // 2. 并发处理多个请求
                        suspend fun fetchMultipleUsers(userIds: List<String>): List<User> {
                            return coroutineScope {
                                userIds.map { id ->
                                    async { fetchUserData(id) }
                                }.awaitAll()
                            }
                        }
                        
                        // 3. 超时处理
                        suspend fun fetchWithTimeout(): String {
                            return withTimeoutOrNull(5000L) {
                                delay(3000L)
                                "Success"
                            } ?: "Timeout"
                        }
                        
                        // 4. 取消协程
                        fun cancelExample() = runBlocking {
                            val job = launch {
                                try {
                                    repeat(1000) { i ->
                                        println("Job: I'm sleeping ${'$'}i ...")
                                        delay(500L)
                                    }
                                } catch (e: CancellationException) {
                                    println("Job cancelled")
                                    throw e
                                }
                            }
                            
                            delay(1300L)
                            println("Cancelling job")
                            job.cancel()
                            job.join()
                        }
                        
                        // 5. 协程与Flow结合
                        fun flowExample() = runBlocking {
                            flow {
                                for (i in 1..5) {
                                    delay(100)
                                    emit(i)
                                }
                            }.collect { value ->
                                println(value)
                            }
                        }
                    """.trimIndent(),
                    explanation = "协程在实际开发中用于网络请求、并发处理、超时控制、取消操作等场景。合理使用协程可以简化异步编程，提高代码可读性。"
                )
            ),
            useCases = listOf(
                "网络请求：使用协程处理异步网络请求",
                "并发处理：使用async并发执行多个任务",
                "后台任务：使用协程执行后台任务而不阻塞主线程",
                "超时控制：使用withTimeout控制操作超时",
                "取消操作：使用Job取消不需要的协程"
            ),
            keyPoints = listOf(
                "协程是轻量级的线程，可以创建大量协程而不会导致性能问题",
                "挂起函数使用suspend关键字，可以在协程中调用",
                "launch启动不返回结果的协程，async启动返回Deferred结果的协程",
                "协程作用域定义协程的生命周期，结构化并发确保子协程不会超过父协程",
                "runBlocking阻塞线程，coroutineScope挂起但不阻塞线程"
            ),
            notes = listOf(
                "挂起函数只能在协程或其他挂起函数中调用",
                "GlobalScope不推荐使用，应该使用自定义作用域",
                "结构化并发确保子协程的生命周期不会超过父协程",
                "协程挂起时不阻塞线程，线程可以执行其他任务",
                "使用Job可以取消协程，取消时会抛出CancellationException"
            ),
            practiceTips = "建议：优先使用coroutineScope而不是GlobalScope。合理使用async并发执行多个任务。在Android开发中，使用viewModelScope和lifecycleScope管理协程生命周期。避免在协程中使用runBlocking，除非在测试中。"
        ),
        
        // 2. 协程上下文和调度器、Job和SupervisorJob
        KnowledgeDetail(
            id = "coroutines_context",
            title = "协程上下文和调度器、Job和SupervisorJob",
            overview = "协程上下文定义了协程的执行环境，包括调度器、Job等。理解协程上下文和调度器，以及Job和SupervisorJob的区别，是掌握协程高级特性的关键。",
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：协程上下文（CoroutineContext）",
                    code = """
                        import kotlinx.coroutines.*
                        
                        // 协程上下文是协程的执行环境，包含多个元素
                        
                        // 1. 查看当前协程上下文
                        fun main() = runBlocking {
                            println("Context: ${'$'}coroutineContext")
                            // 输出包含：Job、ContinuationInterceptor（调度器）等
                        }
                        
                        // 2. 上下文元素
                        // - Job：协程的作业
                        // - Dispatcher：调度器，决定协程在哪个线程执行
                        // - CoroutineName：协程名称
                        // - CoroutineExceptionHandler：异常处理器
                        
                        // 3. 组合上下文
                        fun main() = runBlocking {
                            val context = Dispatchers.Default + CoroutineName("MyCoroutine")
                            launch(context) {
                                println("Running in: ${'$'}coroutineContext")
                            }
                        }
                        
                        // 4. 继承和覆盖上下文
                        fun main() = runBlocking {
                            val parentContext = Dispatchers.Main + CoroutineName("Parent")
                            launch(parentContext) {
                                println("Parent: ${'$'}coroutineContext")
                                launch {
                                    // 继承父协程的上下文
                                    println("Child: ${'$'}coroutineContext")
                                }
                                launch(Dispatchers.IO) {
                                    // 覆盖调度器，但继承其他元素
                                    println("Child with IO: ${'$'}coroutineContext")
                                }
                            }
                        }
                    """.trimIndent(),
                    explanation = "协程上下文定义了协程的执行环境，包含Job、Dispatcher、CoroutineName等元素。子协程继承父协程的上下文，但可以覆盖特定元素。"
                ),
                CodeExample(
                    title = "示例2：调度器（Dispatcher）",
                    code = """
                        import kotlinx.coroutines.*
                        
                        // 调度器决定协程在哪个线程执行
                        
                        fun main() = runBlocking {
                            // 1. Dispatchers.Main：主线程（Android UI线程）
                            launch(Dispatchers.Main) {
                                println("Main: ${'$'}{Thread.currentThread().name}")
                                // 在Android中用于更新UI
                            }
                            
                            // 2. Dispatchers.Default：CPU密集型任务
                            launch(Dispatchers.Default) {
                                println("Default: ${'$'}{Thread.currentThread().name}")
                                // 用于计算密集型任务
                            }
                            
                            // 3. Dispatchers.IO：IO操作
                            launch(Dispatchers.IO) {
                                println("IO: ${'$'}{Thread.currentThread().name}")
                                // 用于网络请求、文件操作等
                            }
                            
                            // 4. Dispatchers.Unconfined：不限制线程
                            launch(Dispatchers.Unconfined) {
                                println("Unconfined: ${'$'}{Thread.currentThread().name}")
                                // 不推荐使用，除非有特殊需求
                            }
                            
                            // 5. 切换调度器
                            suspend fun switchDispatcher() {
                                withContext(Dispatchers.IO) {
                                    // 在IO线程执行
                                    val data = fetchData()
                                }
                                // 回到原来的线程
                                updateUI(data)
                            }
                            
                            // 6. 自定义调度器
                            val customDispatcher = Executors.newSingleThreadExecutor()
                                .asCoroutineDispatcher()
                            launch(customDispatcher) {
                                println("Custom: ${'$'}{Thread.currentThread().name}")
                            }
                        }
                    """.trimIndent(),
                    explanation = "调度器决定协程在哪个线程执行。Main用于UI操作，Default用于CPU密集型任务，IO用于IO操作。使用withContext可以切换调度器。"
                ),
                CodeExample(
                    title = "示例3：Job",
                    code = """
                        import kotlinx.coroutines.*
                        
                        // Job代表一个协程的作业，可以控制协程的生命周期
                        
                        fun main() = runBlocking {
                            // 1. 获取Job
                            val job = launch {
                                delay(1000L)
                                println("Job completed")
                            }
                            
                            // 2. 等待Job完成
                            job.join()
                            println("After job")
                            
                            // 3. 取消Job
                            val job2 = launch {
                                repeat(1000) { i ->
                                    println("Job: I'm sleeping ${'$'}i ...")
                                    delay(500L)
                                }
                            }
                            delay(1300L)
                            job2.cancel()  // 取消Job
                            job2.join()    // 等待取消完成
                            
                            // 4. 检查Job状态
                            val job3 = launch {
                                delay(1000L)
                            }
                            println("Is active: ${'$'}{job3.isActive}")    // true
                            println("Is completed: ${'$'}{job3.isCompleted}")  // false
                            job3.join()
                            println("Is completed: ${'$'}{job3.isCompleted}")  // true
                            
                            // 5. Job层次结构
                            val parentJob = launch {
                                val childJob1 = launch {
                                    delay(1000L)
                                }
                                val childJob2 = launch {
                                    delay(2000L)
                                }
                                // 如果parentJob被取消，childJob1和childJob2也会被取消
                            }
                        }
                    """.trimIndent(),
                    explanation = "Job代表协程的作业，可以控制协程的生命周期。Job有层次结构，取消父Job会取消所有子Job。可以使用isActive、isCompleted等属性检查Job状态。"
                ),
                CodeExample(
                    title = "示例4：SupervisorJob",
                    code = """
                        import kotlinx.coroutines.*
                        
                        // SupervisorJob：子Job的失败不会影响其他子Job和父Job
                        
                        fun main() = runBlocking {
                            // 1. 普通Job：一个子Job失败会取消所有子Job
                            val supervisor = SupervisorJob()
                            val scope = CoroutineScope(Dispatchers.Default + supervisor)
                            
                            val job1 = scope.launch {
                                delay(1000L)
                                throw Exception("Job1 failed")
                            }
                            
                            val job2 = scope.launch {
                                delay(2000L)
                                println("Job2 completed")
                            }
                            
                            delay(500L)
                            // job1失败不会影响job2
                            job2.join()  // Job2会正常完成
                            
                            // 2. supervisorScope：使用SupervisorJob的作用域
                            supervisorScope {
                                val child1 = launch {
                                    delay(1000L)
                                    throw Exception("Child1 failed")
                                }
                                
                                val child2 = launch {
                                    delay(2000L)
                                    println("Child2 completed")
                                }
                                
                                delay(500L)
                                // child1失败不会影响child2
                                child2.join()  // Child2会正常完成
                            }
                            
                            // 3. 对比普通Job
                            coroutineScope {
                                val child1 = launch {
                                    delay(1000L)
                                    throw Exception("Child1 failed")
                                }
                                
                                val child2 = launch {
                                    delay(2000L)
                                    println("Child2 completed")
                                }
                                
                                // child1失败会导致整个作用域失败，child2也会被取消
                            }
                        }
                    """.trimIndent(),
                    explanation = "SupervisorJob允许子Job独立失败，不会影响其他子Job和父Job。supervisorScope创建使用SupervisorJob的作用域。适用于需要独立处理多个任务的场景。"
                ),
                CodeExample(
                    title = "示例5：协程上下文实践",
                    code = """
                        import kotlinx.coroutines.*
                        
                        // 1. 在Android中使用
                        class MyViewModel : ViewModel() {
                            private val viewModelScope = CoroutineScope(
                                SupervisorJob() + Dispatchers.Main
                            )
                            
                            fun loadData() {
                                viewModelScope.launch {
                                    val data = withContext(Dispatchers.IO) {
                                        fetchData()
                                    }
                                    updateUI(data)
                                }
                            }
                            
                            override fun onCleared() {
                                super.onCleared()
                                viewModelScope.cancel()
                            }
                        }
                        
                        // 2. 异常处理
                        val exceptionHandler = CoroutineExceptionHandler { _, exception ->
                            println("Caught exception: ${'$'}exception")
                        }
                        
                        val scope = CoroutineScope(
                            SupervisorJob() + Dispatchers.Main + exceptionHandler
                        )
                        
                        scope.launch {
                            throw Exception("Error")
                        }
                        
                        // 3. 命名协程
                        fun main() = runBlocking {
                            launch(CoroutineName("DataLoader")) {
                                println("Running: ${'$'}{coroutineContext[CoroutineName]?.name}")
                            }
                        }
                        
                        // 4. 组合多个上下文元素
                        val customContext = Dispatchers.IO +
                                CoroutineName("MyCoroutine") +
                                CoroutineExceptionHandler { _, e -> println("Error: ${'$'}e") }
                        
                        CoroutineScope(customContext).launch {
                            // 使用自定义上下文
                        }
                    """.trimIndent(),
                    explanation = "在实际开发中，合理组合协程上下文元素可以创建适合特定场景的协程环境。在Android中，使用SupervisorJob可以防止一个任务失败影响其他任务。"
                )
            ),
            useCases = listOf(
                "线程切换：使用调度器在合适的线程执行任务",
                "任务管理：使用Job管理协程的生命周期",
                "错误隔离：使用SupervisorJob隔离任务错误",
                "上下文传递：通过上下文传递协程相关信息",
                "异常处理：使用CoroutineExceptionHandler处理异常"
            ),
            keyPoints = listOf(
                "协程上下文定义协程的执行环境，包含Job、Dispatcher等元素",
                "调度器决定协程在哪个线程执行（Main、Default、IO等）",
                "Job代表协程的作业，可以控制协程的生命周期",
                "SupervisorJob允许子Job独立失败，不会影响其他子Job",
                "子协程继承父协程的上下文，但可以覆盖特定元素"
            ),
            notes = listOf(
                "Dispatchers.Main在Android中用于更新UI",
                "Dispatchers.Default用于CPU密集型任务，IO用于IO操作",
                "取消父Job会取消所有子Job（普通Job）",
                "SupervisorJob适用于需要独立处理多个任务的场景",
                "使用withContext可以切换调度器"
            ),
            practiceTips = "建议：在Android中，使用Dispatchers.Main更新UI，使用Dispatchers.IO执行网络请求。使用SupervisorJob防止一个任务失败影响其他任务。合理组合上下文元素创建适合的协程环境。"
        ),
        
        // 3. Flow响应式数据流、StateFlow和SharedFlow
        KnowledgeDetail(
            id = "flow",
            title = "Flow响应式数据流、StateFlow和SharedFlow",
            overview = "Flow是Kotlin的响应式数据流，类似于RxJava的Observable。StateFlow和SharedFlow是Flow的特殊实现，用于状态管理和事件流。理解这些概念是掌握Kotlin响应式编程的关键。",
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：Flow基础",
                    code = """
                        import kotlinx.coroutines.*
                        import kotlinx.coroutines.flow.*
                        
                        // Flow是冷流（Cold Stream），只有在收集时才开始发射数据
                        
                        // 1. 创建Flow
                        fun simpleFlow(): Flow<Int> = flow {
                            for (i in 1..5) {
                                delay(100)
                                emit(i)  // 发射数据
                            }
                        }
                        
                        // 2. 收集Flow
                        fun main() = runBlocking {
                            simpleFlow().collect { value ->
                                println(value)
                            }
                            // 输出：1, 2, 3, 4, 5
                        }
                        
                        // 3. Flow操作符
                        fun main() = runBlocking {
                            flowOf(1, 2, 3, 4, 5)
                                .filter { it % 2 == 0 }  // 过滤
                                .map { it * it }         // 转换
                                .collect { println(it) }  // 收集
                            // 输出：4, 16
                        }
                        
                        // 4. 多个收集者
                        fun main() = runBlocking {
                            val flow = simpleFlow()
                            flow.collect { println("Collector 1: ${'$'}it") }
                            flow.collect { println("Collector 2: ${'$'}it") }
                            // 每个收集者都会触发Flow的重新执行
                        }
                    """.trimIndent(),
                    explanation = "Flow是冷流，只有在收集时才开始发射数据。可以使用flow构建器创建Flow，使用collect收集数据。Flow支持类似集合的操作符。"
                ),
                CodeExample(
                    title = "示例2：Flow操作符",
                    code = """
                        import kotlinx.coroutines.*
                        import kotlinx.coroutines.flow.*
                        
                        fun main() = runBlocking {
                            val numbers = flowOf(1, 2, 3, 4, 5)
                            
                            // 1. 转换操作符
                            numbers.map { it * it }
                                .collect { println(it) }  // 1, 4, 9, 16, 25
                            
                            // 2. 过滤操作符
                            numbers.filter { it % 2 == 0 }
                                .collect { println(it) }  // 2, 4
                            
                            // 3. 聚合操作符
                            val sum = numbers.reduce { acc, value -> acc + value }
                            println(sum)  // 15
                            
                            // 4. 展平操作符
                            flowOf(listOf(1, 2), listOf(3, 4))
                                .flatMapConcat { it.asFlow() }
                                .collect { println(it) }  // 1, 2, 3, 4
                            
                            // 5. 缓冲和背压
                            flow {
                                for (i in 1..5) {
                                    delay(100)
                                    emit(i)
                                }
                            }.buffer()  // 缓冲，提高吞吐量
                                .collect { value ->
                                    delay(300)
                                    println(value)
                                }
                            
                            // 6. 组合操作符
                            val flow1 = flowOf(1, 2, 3)
                            val flow2 = flowOf("a", "b", "c")
                            flow1.zip(flow2) { a, b -> "${'$'}a${'$'}b" }
                                .collect { println(it) }  // 1a, 2b, 3c
                        }
                    """.trimIndent(),
                    explanation = "Flow提供了丰富的操作符，包括转换（map）、过滤（filter）、聚合（reduce）、展平（flatMap）等。这些操作符可以链式调用，创建复杂的数据流处理管道。"
                ),
                CodeExample(
                    title = "示例3：StateFlow",
                    code = """
                        import kotlinx.coroutines.*
                        import kotlinx.coroutines.flow.*
                        
                        // StateFlow：状态流，用于管理状态
                        
                        // 1. 创建StateFlow
                        class ViewModel {
                            private val _uiState = MutableStateFlow(UiState())
                            val uiState: StateFlow<UiState> = _uiState.asStateFlow()
                            
                            fun updateState(newState: UiState) {
                                _uiState.value = newState
                            }
                        }
                        
                        data class UiState(
                            val isLoading: Boolean = false,
                            val data: String? = null,
                            val error: String? = null
                        )
                        
                        // 2. 收集StateFlow
                        fun main() = runBlocking {
                            val viewModel = ViewModel()
                            
                            viewModel.uiState.collect { state ->
                                println("State: ${'$'}state")
                            }
                            
                            viewModel.updateState(UiState(isLoading = true))
                            viewModel.updateState(UiState(data = "Loaded"))
                        }
                        
                        // 3. StateFlow特点
                        // - 总是有当前值（初始值）
                        // - 新收集者立即收到当前值
                        // - 只保留最新值
                        // - 线程安全
                        
                        // 4. 在Android中使用
                        class MyActivity : AppCompatActivity() {
                            private val viewModel: ViewModel by viewModels()
                            
                            override fun onCreate(savedInstanceState: Bundle?) {
                                super.onCreate(savedInstanceState)
                                
                                lifecycleScope.launch {
                                    viewModel.uiState.collect { state ->
                                        when {
                                            state.isLoading -> showLoading()
                                            state.error != null -> showError(state.error)
                                            state.data != null -> showData(state.data)
                                        }
                                    }
                                }
                            }
                        }
                    """.trimIndent(),
                    explanation = "StateFlow是状态流，用于管理状态。StateFlow总是有当前值，新收集者立即收到当前值。在Android中，StateFlow常用于ViewModel中管理UI状态。"
                ),
                CodeExample(
                    title = "示例4：SharedFlow",
                    code = """
                        import kotlinx.coroutines.*
                        import kotlinx.coroutines.flow.*
                        
                        // SharedFlow：共享流，用于事件流
                        
                        // 1. 创建SharedFlow
                        class EventBus {
                            private val _events = MutableSharedFlow<Event>()
                            val events: SharedFlow<Event> = _events.asSharedFlow()
                            
                            suspend fun emit(event: Event) {
                                _events.emit(event)
                            }
                        }
                        
                        sealed class Event {
                            data class UserLoggedIn(val userId: String) : Event()
                            data class UserLoggedOut : Event()
                        }
                        
                        // 2. 收集SharedFlow
                        fun main() = runBlocking {
                            val eventBus = EventBus()
                            
                            // 收集者1
                            launch {
                                eventBus.events.collect { event ->
                                    println("Collector 1: ${'$'}event")
                                }
                            }
                            
                            // 收集者2
                            launch {
                                eventBus.events.collect { event ->
                                    println("Collector 2: ${'$'}event")
                                }
                            }
                            
                            delay(100)
                            eventBus.emit(Event.UserLoggedIn("user123"))
                            // 两个收集者都会收到事件
                        }
                        
                        // 3. SharedFlow配置
                        val sharedFlow = MutableSharedFlow<Int>(
                            replay = 2,        // 新收集者收到最近2个值
                            extraBufferCapacity = 1  // 额外缓冲区容量
                        )
                        
                        // 4. StateFlow vs SharedFlow
                        // StateFlow：
                        // - 总是有当前值
                        // - 新收集者立即收到当前值
                        // - 用于状态管理
                        
                        // SharedFlow：
                        // - 可能没有当前值
                        // - 可以配置replay
                        // - 用于事件流
                    """.trimIndent(),
                    explanation = "SharedFlow是共享流，用于事件流。SharedFlow可以配置replay，让新收集者收到最近的值。StateFlow用于状态管理，SharedFlow用于事件流。"
                ),
                CodeExample(
                    title = "示例5：Flow实践",
                    code = """
                        import kotlinx.coroutines.*
                        import kotlinx.coroutines.flow.*
                        
                        // 1. 网络请求Flow
                        fun fetchUsersFlow(): Flow<List<User>> = flow {
                            while (true) {
                                val users = apiService.getUsers()
                                emit(users)
                                delay(5000)  // 每5秒刷新
                            }
                        }.flowOn(Dispatchers.IO)
                        
                        // 2. 数据库Flow
                        @Dao
                        interface UserDao {
                            @Query("SELECT * FROM users")
                            fun getAllUsers(): Flow<List<User>>
                        }
                        
                        // 3. 组合多个Flow
                        fun main() = runBlocking {
                            val flow1 = flowOf(1, 2, 3)
                            val flow2 = flowOf("a", "b")
                            
                            merge(flow1, flow2).collect { value ->
                                println(value)
                            }
                        }
                        
                        // 4. 错误处理
                        fun main() = runBlocking {
                            flow {
                                emit(1)
                                throw Exception("Error")
                                emit(2)
                            }.catch { e ->
                                println("Caught: ${'$'}e")
                                emit(-1)  // 发送默认值
                            }.collect { value ->
                                println(value)
                            }
                        }
                        
                        // 5. 在Android中使用
                        class MyViewModel : ViewModel() {
                            private val _searchQuery = MutableStateFlow("")
                            val searchQuery: StateFlow<String> = _searchQuery.asStateFlow()
                            
                            val searchResults: Flow<List<Item>> = searchQuery
                                .debounce(300)  // 防抖
                                .distinctUntilChanged()  // 去重
                                .filter { it.length > 2 }  // 过滤
                                .flatMapLatest { query ->
                                    searchItems(query)
                                }
                                .flowOn(Dispatchers.IO)
                            
                            fun updateQuery(query: String) {
                                _searchQuery.value = query
                            }
                        }
                    """.trimIndent(),
                    explanation = "Flow在实际开发中用于网络请求、数据库查询、搜索等功能。StateFlow用于状态管理，SharedFlow用于事件流。合理使用Flow操作符可以创建强大的响应式数据流。"
                )
            ),
            useCases = listOf(
                "状态管理：使用StateFlow管理UI状态",
                "事件流：使用SharedFlow处理事件流",
                "数据流：使用Flow处理异步数据流",
                "搜索功能：使用Flow实现搜索防抖和去重",
                "实时更新：使用Flow实现数据的实时更新"
            ),
            keyPoints = listOf(
                "Flow是冷流，只有在收集时才开始发射数据",
                "StateFlow用于状态管理，总是有当前值，新收集者立即收到当前值",
                "SharedFlow用于事件流，可以配置replay让新收集者收到最近的值",
                "Flow提供了丰富的操作符（map、filter、reduce等）",
                "StateFlow和SharedFlow都是热流，可以有多个收集者"
            ),
            notes = listOf(
                "Flow是冷流，每个收集者都会触发Flow的重新执行",
                "StateFlow是SharedFlow的特殊实现，replay=1且总是有当前值",
                "使用flowOn可以切换Flow的执行上下文",
                "使用catch可以处理Flow中的异常",
                "在Android中，StateFlow常用于ViewModel，SharedFlow用于事件总线"
            ),
            practiceTips = "建议：在Android中，使用StateFlow管理UI状态，使用SharedFlow处理事件流。合理使用Flow操作符创建数据流处理管道。使用debounce和distinctUntilChanged优化搜索等功能。"
        ),
        
        // 4. 协程异常处理
        KnowledgeDetail(
            id = "coroutines_exception",
            title = "协程异常处理",
            overview = "协程的异常处理与普通代码不同，需要理解异常传播机制、异常处理器、SupervisorJob等。正确处理协程异常是编写健壮异步代码的关键。",
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：异常传播机制",
                    code = """
                        import kotlinx.coroutines.*
                        
                        // 1. launch中的异常
                        fun main() = runBlocking {
                            val job = launch {
                                throw Exception("Error in launch")
                            }
                            job.join()
                            println("After launch")  // 会执行
                        }
                        // launch中的异常不会传播到父协程
                        
                        // 2. async中的异常
                        fun main() = runBlocking {
                            val deferred = async {
                                throw Exception("Error in async")
                            }
                            try {
                                deferred.await()
                            } catch (e: Exception) {
                                println("Caught: ${'$'}e")
                            }
                        }
                        // async中的异常在await时抛出
                        
                        // 3. 异常传播到父协程
                        fun main() = runBlocking {
                            try {
                                coroutineScope {
                                    launch {
                                        throw Exception("Error")
                                    }
                                    delay(100)
                                }
                            } catch (e: Exception) {
                                println("Caught: ${'$'}e")
                            }
                        }
                        // coroutineScope中的异常会传播
                    """.trimIndent(),
                    explanation = "launch中的异常不会传播到父协程，async中的异常在await时抛出，coroutineScope中的异常会传播。理解异常传播机制是正确处理异常的基础。"
                ),
                CodeExample(
                    title = "示例2：CoroutineExceptionHandler",
                    code = """
                        import kotlinx.coroutines.*
                        
                        // CoroutineExceptionHandler：全局异常处理器
                        
                        // 1. 创建异常处理器
                        val exceptionHandler = CoroutineExceptionHandler { _, exception ->
                            println("Caught exception: ${'$'}exception")
                        }
                        
                        // 2. 在launch中使用
                        fun main() = runBlocking {
                            val job = launch(exceptionHandler) {
                                throw Exception("Error")
                            }
                            job.join()
                        }
                        
                        // 3. 在作用域中使用
                        fun main() = runBlocking {
                            val scope = CoroutineScope(
                                SupervisorJob() + Dispatchers.Default + exceptionHandler
                            )
                            
                            scope.launch {
                                throw Exception("Error 1")
                            }
                            
                            scope.launch {
                                throw Exception("Error 2")
                            }
                            
                            delay(1000)
                        }
                        
                        // 4. 注意：CoroutineExceptionHandler只在根协程中有效
                        fun main() = runBlocking {
                            val handler = CoroutineExceptionHandler { _, e ->
                                println("Handler: ${'$'}e")
                            }
                            
                            val scope = CoroutineScope(SupervisorJob() + handler)
                            
                            scope.launch {
                                launch {
                                    // 这个异常不会被handler捕获
                                    throw Exception("Child error")
                                }
                            }
                            
                            delay(1000)
                        }
                    """.trimIndent(),
                    explanation = "CoroutineExceptionHandler用于处理未捕获的异常。只在根协程中有效，子协程的异常需要其他方式处理。"
                ),
                CodeExample(
                    title = "示例3：try-catch处理异常",
                    code = """
                        import kotlinx.coroutines.*
                        
                        // 在协程中使用try-catch
                        
                        // 1. 在挂起函数中
                        suspend fun fetchData(): String {
                            return try {
                                delay(1000)
                                "Data"
                            } catch (e: Exception) {
                                "Error: ${'$'}e"
                            }
                        }
                        
                        // 2. 在launch中
                        fun main() = runBlocking {
                            launch {
                                try {
                                    delay(1000)
                                    throw Exception("Error")
                                } catch (e: Exception) {
                                    println("Caught: ${'$'}e")
                                }
                            }
                        }
                        
                        // 3. 在async中
                        fun main() = runBlocking {
                            val deferred = async {
                                try {
                                    delay(1000)
                                    throw Exception("Error")
                                } catch (e: Exception) {
                                    "Error: ${'$'}e"
                                }
                            }
                            val result = deferred.await()
                            println(result)
                        }
                        
                        // 4. 处理多个异常
                        suspend fun fetchMultiple(): List<String> {
                            return coroutineScope {
                                val deferred1 = async { fetchData1() }
                                val deferred2 = async { fetchData2() }
                                
                                try {
                                    listOf(deferred1.await(), deferred2.await())
                                } catch (e: Exception) {
                                    // 处理异常
                                    emptyList()
                                }
                            }
                        }
                    """.trimIndent(),
                    explanation = "在协程中可以使用try-catch处理异常。在挂起函数、launch、async中都可以使用try-catch。对于多个并发任务，可以使用coroutineScope统一处理异常。"
                ),
                CodeExample(
                    title = "示例4：SupervisorJob和异常隔离",
                    code = """
                        import kotlinx.coroutines.*
                        
                        // SupervisorJob：子Job的异常不会影响其他子Job
                        
                        // 1. 使用SupervisorJob
                        fun main() = runBlocking {
                            val supervisor = SupervisorJob()
                            val scope = CoroutineScope(Dispatchers.Default + supervisor)
                            
                            val job1 = scope.launch {
                                delay(1000)
                                throw Exception("Job1 error")
                            }
                            
                            val job2 = scope.launch {
                                delay(2000)
                                println("Job2 completed")
                            }
                            
                            delay(500)
                            // job1失败不会影响job2
                            job2.join()  // Job2会正常完成
                        }
                        
                        // 2. supervisorScope
                        suspend fun supervisorExample() = supervisorScope {
                            val child1 = launch {
                                delay(1000)
                                throw Exception("Child1 error")
                            }
                            
                            val child2 = launch {
                                delay(2000)
                                println("Child2 completed")
                            }
                            
                            delay(500)
                            // child1失败不会影响child2
                            child2.join()
                        }
                        
                        // 3. 对比普通Job
                        suspend fun normalScope() = coroutineScope {
                            val child1 = launch {
                                delay(1000)
                                throw Exception("Child1 error")
                            }
                            
                            val child2 = launch {
                                delay(2000)
                                println("Child2 completed")
                            }
                            
                            // child1失败会导致整个作用域失败，child2也会被取消
                        }
                    """.trimIndent(),
                    explanation = "SupervisorJob允许子Job独立失败，不会影响其他子Job。supervisorScope创建使用SupervisorJob的作用域。适用于需要独立处理多个任务的场景。"
                ),
                CodeExample(
                    title = "示例5：异常处理最佳实践",
                    code = """
                        import kotlinx.coroutines.*
                        
                        // 1. 在ViewModel中处理异常
                        class MyViewModel : ViewModel() {
                            private val _uiState = MutableStateFlow<UiState>(UiState.Idle)
                            val uiState: StateFlow<UiState> = _uiState.asStateFlow()
                            
                            fun loadData() {
                                viewModelScope.launch {
                                    _uiState.value = UiState.Loading
                                    try {
                                        val data = repository.fetchData()
                                        _uiState.value = UiState.Success(data)
                                    } catch (e: Exception) {
                                        _uiState.value = UiState.Error(e.message ?: "Unknown error")
                                    }
                                }
                            }
                        }
                        
                        // 2. 使用Result封装结果
                        suspend fun fetchDataWithResult(): Result<String> {
                            return try {
                                val data = apiService.getData()
                                Result.success(data)
                            } catch (e: Exception) {
                                Result.failure(e)
                            }
                        }
                        
                        // 3. 重试机制
                        suspend fun fetchWithRetry(
                            maxRetries: Int = 3,
                            delay: Long = 1000
                        ): String {
                            repeat(maxRetries) { attempt ->
                                try {
                                    return apiService.getData()
                                } catch (e: Exception) {
                                    if (attempt == maxRetries - 1) throw e
                                    delay(delay * (attempt + 1))
                                }
                            }
                            throw Exception("Max retries reached")
                        }
                        
                        // 4. 超时处理
                        suspend fun fetchWithTimeout(): String {
                            return withTimeoutOrNull(5000L) {
                                apiService.getData()
                            } ?: throw TimeoutCancellationException("Timeout")
                        }
                        
                        // 5. 组合异常处理
                        suspend fun fetchMultipleSafely(): List<String> {
                            return supervisorScope {
                                val deferred1 = async { fetchData1() }
                                val deferred2 = async { fetchData2() }
                                
                                listOfNotNull(
                                    deferred1.awaitOrNull(),
                                    deferred2.awaitOrNull()
                                )
                            }
                        }
                        
                        suspend fun <T> Deferred<T>.awaitOrNull(): T? {
                            return try {
                                await()
                            } catch (e: Exception) {
                                null
                            }
                        }
                    """.trimIndent(),
                    explanation = "在实际开发中，应该合理处理协程异常。在ViewModel中使用try-catch更新UI状态，使用Result封装结果，实现重试机制和超时处理。使用SupervisorJob隔离任务异常。"
                )
            ),
            useCases = listOf(
                "错误处理：使用try-catch处理协程中的异常",
                "异常隔离：使用SupervisorJob隔离任务异常",
                "全局处理：使用CoroutineExceptionHandler处理未捕获的异常",
                "重试机制：实现带重试的网络请求",
                "超时处理：使用withTimeout处理超时操作"
            ),
            keyPoints = listOf(
                "launch中的异常不会传播到父协程，async中的异常在await时抛出",
                "CoroutineExceptionHandler只在根协程中有效",
                "SupervisorJob允许子Job独立失败，不会影响其他子Job",
                "在协程中可以使用try-catch处理异常",
                "使用supervisorScope创建使用SupervisorJob的作用域"
            ),
            notes = listOf(
                "launch中的异常需要CoroutineExceptionHandler或try-catch处理",
                "async中的异常在await时抛出，需要在await处处理",
                "coroutineScope中的异常会传播，需要使用try-catch",
                "SupervisorJob适用于需要独立处理多个任务的场景",
                "在Android中，ViewModel的异常应该更新UI状态而不是崩溃"
            ),
            practiceTips = "建议：在ViewModel中使用try-catch更新UI状态。使用SupervisorJob隔离任务异常。实现重试机制和超时处理。使用Result封装结果，而不是直接抛出异常。在Android中，确保异常不会导致应用崩溃。"
        ),
        
        // 5. Android中的协程（viewModelScope、lifecycleScope）
        KnowledgeDetail(
            id = "android_coroutines",
            title = "Android中的协程（viewModelScope、lifecycleScope）",
            overview = "Android提供了viewModelScope和lifecycleScope等协程作用域，用于管理协程的生命周期。理解这些作用域的使用是Android协程开发的关键。",
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：viewModelScope",
                    code = """
                        import androidx.lifecycle.ViewModel
                        import androidx.lifecycle.viewModelScope
                        import kotlinx.coroutines.launch
                        
                        // viewModelScope：ViewModel的协程作用域
                        
                        class MyViewModel : ViewModel() {
                            
                            // 1. 基本使用
                            fun loadData() {
                                viewModelScope.launch {
                                    val data = repository.fetchData()
                                    _uiState.value = UiState.Success(data)
                                }
                            }
                            
                            // 2. 异常处理
                            fun loadDataWithErrorHandling() {
                                viewModelScope.launch {
                                    try {
                                        _uiState.value = UiState.Loading
                                        val data = repository.fetchData()
                                        _uiState.value = UiState.Success(data)
                                    } catch (e: Exception) {
                                        _uiState.value = UiState.Error(e.message)
                                    }
                                }
                            }
                            
                            // 3. 并发任务
                            fun loadMultipleData() {
                                viewModelScope.launch {
                                    val deferred1 = async { repository.fetchData1() }
                                    val deferred2 = async { repository.fetchData2() }
                                    
                                    val data1 = deferred1.await()
                                    val data2 = deferred2.await()
                                    
                                    _uiState.value = UiState.Success(Pair(data1, data2))
                                }
                            }
                            
                            // 4. viewModelScope特点
                            // - 在ViewModel清除时自动取消
                            // - 使用Dispatchers.Main作为默认调度器
                            // - 使用SupervisorJob，子协程失败不会影响其他协程
                            
                            // 5. 切换调度器
                            fun loadDataFromNetwork() {
                                viewModelScope.launch {
                                    val data = withContext(Dispatchers.IO) {
                                        repository.fetchData()
                                    }
                                    // 回到Main线程更新UI
                                    _uiState.value = UiState.Success(data)
                                }
                            }
                        }
                    """.trimIndent(),
                    explanation = "viewModelScope是ViewModel的协程作用域，在ViewModel清除时自动取消。使用Dispatchers.Main作为默认调度器，使用SupervisorJob隔离异常。"
                ),
                CodeExample(
                    title = "示例2：lifecycleScope",
                    code = """
                        import androidx.lifecycle.lifecycleScope
                        import kotlinx.coroutines.launch
                        import kotlinx.coroutines.flow.collect
                        
                        // lifecycleScope：LifecycleOwner的协程作用域
                        
                        class MainActivity : AppCompatActivity() {
                            
                            override fun onCreate(savedInstanceState: Bundle?) {
                                super.onCreate(savedInstanceState)
                                
                                // 1. 基本使用
                                lifecycleScope.launch {
                                    val data = loadData()
                                    updateUI(data)
                                }
                                
                                // 2. 生命周期感知
                                lifecycleScope.launch {
                                    repeatOnLifecycle(Lifecycle.State.STARTED) {
                                        // 只在STARTED状态时执行
                                        viewModel.uiState.collect { state ->
                                            updateUI(state)
                                        }
                                    }
                                }
                                
                                // 3. 在特定生命周期执行
                                lifecycleScope.launchWhenCreated {
                                    // 在onCreate之后执行
                                    initializeData()
                                }
                                
                                lifecycleScope.launchWhenStarted {
                                    // 在onStart之后执行
                                    startObserving()
                                }
                                
                                lifecycleScope.launchWhenResumed {
                                    // 在onResume之后执行
                                    resumeUpdates()
                                }
                                
                                // 4. 收集Flow
                                lifecycleScope.launch {
                                    viewModel.searchResults.collect { results ->
                                        updateSearchResults(results)
                                    }
                                }
                            }
                            
                            // 5. lifecycleScope特点
                            // - 在Lifecycle销毁时自动取消
                            // - 使用Dispatchers.Main作为默认调度器
                            // - 可以感知生命周期状态
                        }
                    """.trimIndent(),
                    explanation = "lifecycleScope是LifecycleOwner的协程作用域，在Lifecycle销毁时自动取消。可以使用launchWhenCreated、launchWhenStarted等生命周期感知函数。"
                ),
                CodeExample(
                    title = "示例3：在Repository中使用协程",
                    code = """
                        import kotlinx.coroutines.flow.Flow
                        import kotlinx.coroutines.flow.flow
                        
                        // Repository层使用suspend函数和Flow
                        
                        class UserRepository(
                            private val apiService: ApiService,
                            private val userDao: UserDao
                        ) {
                            
                            // 1. suspend函数
                            suspend fun getUser(userId: String): User {
                                return apiService.getUser(userId)
                            }
                            
                            // 2. Flow从网络获取数据
                            fun getUserFlow(userId: String): Flow<User> = flow {
                                val user = apiService.getUser(userId)
                                emit(user)
                            }.flowOn(Dispatchers.IO)
                            
                            // 3. Flow从数据库获取数据
                            fun getUsersFromDb(): Flow<List<User>> {
                                return userDao.getAllUsers()
                            }
                            
                            // 4. 网络+数据库
                            fun getUsers(): Flow<List<User>> = flow {
                                // 先尝试从数据库获取
                                val cachedUsers = userDao.getAllUsers().first()
                                emit(cachedUsers)
                                
                                // 然后从网络获取
                                try {
                                    val networkUsers = apiService.getUsers()
                                    userDao.insertAll(networkUsers)
                                    emit(networkUsers)
                                } catch (e: Exception) {
                                    // 网络失败，使用缓存
                                }
                            }.flowOn(Dispatchers.IO)
                        }
                    """.trimIndent(),
                    explanation = "Repository层使用suspend函数和Flow处理数据。可以使用flow构建器创建Flow，使用flowOn切换执行上下文。"
                ),
                CodeExample(
                    title = "示例4：在ViewModel中使用Flow",
                    code = """
                        import androidx.lifecycle.ViewModel
                        import androidx.lifecycle.viewModelScope
                        import kotlinx.coroutines.flow.*
                        
                        class SearchViewModel(
                            private val repository: SearchRepository
                        ) : ViewModel() {
                            
                            private val _searchQuery = MutableStateFlow("")
                            val searchQuery: StateFlow<String> = _searchQuery.asStateFlow()
                            
                            // 1. 搜索结果的Flow
                            val searchResults: StateFlow<List<Item>> = _searchQuery
                                .debounce(300)  // 防抖
                                .distinctUntilChanged()  // 去重
                                .filter { it.length > 2 }  // 过滤
                                .flatMapLatest { query ->
                                    repository.search(query)
                                        .catch { emit(emptyList()) }  // 错误处理
                                }
                                .stateIn(
                                    scope = viewModelScope,
                                    started = SharingStarted.WhileSubscribed(5000),
                                    initialValue = emptyList()
                                )
                            
                            // 2. UI状态
                            private val _uiState = MutableStateFlow<UiState>(UiState.Idle)
                            val uiState: StateFlow<UiState> = _uiState.asStateFlow()
                            
                            fun updateQuery(query: String) {
                                _searchQuery.value = query
                            }
                            
                            // 3. 加载数据
                            fun loadData() {
                                viewModelScope.launch {
                                    _uiState.value = UiState.Loading
                                    try {
                                        val data = repository.fetchData()
                                        _uiState.value = UiState.Success(data)
                                    } catch (e: Exception) {
                                        _uiState.value = UiState.Error(e.message)
                                    }
                                }
                            }
                        }
                    """.trimIndent(),
                    explanation = "在ViewModel中使用Flow处理数据流。可以使用StateFlow管理UI状态，使用Flow操作符创建数据流处理管道。使用stateIn将Flow转换为StateFlow。"
                ),
                CodeExample(
                    title = "示例5：Android协程最佳实践",
                    code = """
                        import androidx.lifecycle.ViewModel
                        import androidx.lifecycle.viewModelScope
                        import androidx.lifecycle.lifecycleScope
                        import kotlinx.coroutines.*
                        import kotlinx.coroutines.flow.*
                        
                        // 1. ViewModel中使用viewModelScope
                        class MyViewModel : ViewModel() {
                            fun loadData() {
                                viewModelScope.launch {
                                    // 使用Dispatchers.IO执行网络请求
                                    val data = withContext(Dispatchers.IO) {
                                        repository.fetchData()
                                    }
                                    // 自动回到Main线程更新UI
                                    _uiState.value = UiState.Success(data)
                                }
                            }
                        }
                        
                        // 2. Activity/Fragment中使用lifecycleScope
                        class MainActivity : AppCompatActivity() {
                            override fun onCreate(savedInstanceState: Bundle?) {
                                super.onCreate(savedInstanceState)
                                
                                lifecycleScope.launch {
                                    repeatOnLifecycle(Lifecycle.State.STARTED) {
                                        viewModel.uiState.collect { state ->
                                            updateUI(state)
                                        }
                                    }
                                }
                            }
                        }
                        
                        // 3. 使用StateFlow管理状态
                        class MyViewModel : ViewModel() {
                            private val _uiState = MutableStateFlow<UiState>(UiState.Idle)
                            val uiState: StateFlow<UiState> = _uiState.asStateFlow()
                        }
                        
                        // 4. 使用SharedFlow处理事件
                        class MyViewModel : ViewModel() {
                            private val _events = MutableSharedFlow<Event>()
                            val events: SharedFlow<Event> = _events.asSharedFlow()
                            
                            fun triggerEvent(event: Event) {
                                viewModelScope.launch {
                                    _events.emit(event)
                                }
                            }
                        }
                        
                        // 5. 错误处理
                        class MyViewModel : ViewModel() {
                            fun loadData() {
                                viewModelScope.launch {
                                    try {
                                        _uiState.value = UiState.Loading
                                        val data = repository.fetchData()
                                        _uiState.value = UiState.Success(data)
                                    } catch (e: Exception) {
                                        _uiState.value = UiState.Error(e.message)
                                    }
                                }
                            }
                        }
                    """.trimIndent(),
                    explanation = "在Android中使用协程的最佳实践：使用viewModelScope和lifecycleScope管理协程生命周期，使用StateFlow管理状态，使用SharedFlow处理事件，合理处理异常。"
                )
            ),
            useCases = listOf(
                "状态管理：使用viewModelScope和StateFlow管理UI状态",
                "数据加载：使用协程加载网络数据",
                "生命周期感知：使用lifecycleScope感知生命周期",
                "事件处理：使用SharedFlow处理事件流",
                "数据流：使用Flow处理响应式数据流"
            ),
            keyPoints = listOf(
                "viewModelScope在ViewModel清除时自动取消，使用Dispatchers.Main作为默认调度器",
                "lifecycleScope在Lifecycle销毁时自动取消，可以感知生命周期状态",
                "使用withContext切换调度器，在IO线程执行网络请求，在Main线程更新UI",
                "使用StateFlow管理UI状态，使用SharedFlow处理事件流",
                "使用repeatOnLifecycle确保Flow收集只在特定生命周期状态执行"
            ),
            notes = listOf(
                "viewModelScope使用SupervisorJob，子协程失败不会影响其他协程",
                "lifecycleScope可以使用launchWhenCreated、launchWhenStarted等生命周期感知函数",
                "在Repository中使用suspend函数和Flow，在ViewModel中使用viewModelScope",
                "使用stateIn将Flow转换为StateFlow",
                "使用repeatOnLifecycle避免在后台收集Flow，节省资源"
            ),
            practiceTips = "建议：在ViewModel中使用viewModelScope，在Activity/Fragment中使用lifecycleScope。使用StateFlow管理UI状态，使用SharedFlow处理事件。使用withContext在IO线程执行网络请求。使用repeatOnLifecycle确保Flow收集只在需要时执行。合理处理异常，更新UI状态而不是崩溃。"
        ),
        
        // ========== Kotlin 扩展函数和属性 ==========
        
        // 1. 扩展函数语法、为Java类添加扩展函数
        KnowledgeDetail(
            id = "extension_functions",
            title = "扩展函数语法、为Java类添加扩展函数",
            overview = "扩展函数是Kotlin的强大特性，允许在不修改类定义的情况下为类添加新函数。扩展函数可以用于Kotlin类和Java类，让代码更简洁、更易读。",
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：扩展函数基础语法",
                    code = """
                        // 扩展函数语法：fun 接收者类型.函数名(参数): 返回类型
                        
                        // 为String类添加扩展函数
                        fun String.removeSpaces(): String {
                            return this.replace(" ", "")
                        }
                        
                        // 使用
                        val text = "Hello World"
                        val result = text.removeSpaces()  // "HelloWorld"
                        println(result)
                        
                        // this关键字指向接收者对象
                        fun String.firstChar(): Char {
                            return this[0]  // this指向调用扩展函数的String对象
                        }
                        
                        // 可以省略this
                        fun String.lastChar(): Char {
                            return this[length - 1]  // 可以直接访问length属性
                        }
                        
                        // 扩展函数可以有参数
                        fun String.repeat(n: Int): String {
                            return this.repeat(n)
                        }
                        
                        val repeated = "Hi".repeat(3)  // "HiHiHi"
                    """.trimIndent(),
                    explanation = "扩展函数使用 fun 接收者类型.函数名 的语法定义。this关键字指向接收者对象，可以省略。扩展函数可以像普通函数一样有参数和返回值。"
                ),
                CodeExample(
                    title = "示例2：为Java类添加扩展函数",
                    code = """
                        // Kotlin可以为Java类添加扩展函数
                        
                        // 1. 为Java的Date类添加扩展函数
                        import java.util.Date
                        
                        fun Date.formatDate(): String {
                            val formatter = java.text.SimpleDateFormat("yyyy-MM-dd")
                            return formatter.format(this)
                        }
                        
                        val date = Date()
                        println(date.formatDate())  // "2024-01-01"
                        
                        // 2. 为Java的File类添加扩展函数
                        import java.io.File
                        
                        fun File.readText(): String {
                            return this.readText()
                        }
                        
                        fun File.writeText(text: String) {
                            this.writeText(text)
                        }
                        
                        // 3. 为Java的List添加扩展函数
                        fun <T> java.util.List<T>.secondOrNull(): T? {
                            return if (this.size >= 2) this[1] else null
                        }
                        
                        val list = java.util.ArrayList<String>()
                        list.add("first")
                        list.add("second")
                        val second = list.secondOrNull()  // "second"
                        
                        // 4. 为Android的View添加扩展函数
                        // import android.view.View
                        // 
                        // fun View.show() {
                        //     this.visibility = View.VISIBLE
                        // }
                        // 
                        // fun View.hide() {
                        //     this.visibility = View.GONE
                        // }
                    """.trimIndent(),
                    explanation = "Kotlin可以为Java类添加扩展函数，这是Kotlin与Java互操作的重要特性。可以为任何Java类添加扩展函数，包括标准库类和第三方库类。"
                ),
                CodeExample(
                    title = "示例3：扩展函数的作用域和导入",
                    code = """
                        // 1. 扩展函数的作用域
                        // 扩展函数定义在顶层，可以在任何地方使用
                        
                        // 在同一个文件中
                        fun String.isEmail(): Boolean {
                            return this.contains("@") && this.contains(".")
                        }
                        
                        val email = "test@example.com"
                        println(email.isEmail())  // true
                        
                        // 2. 在不同文件中使用扩展函数
                        // 需要导入扩展函数
                        // import com.example.utils.isEmail
                        // 或者
                        // import com.example.utils.*
                        
                        // 3. 扩展函数可以定义在类中
                        class StringUtils {
                            fun String.capitalizeFirst(): String {
                                return if (this.isEmpty()) {
                                    this
                                } else {
                                    this[0].uppercaseChar() + this.substring(1)
                                }
                            }
                            
                            fun useExtension() {
                                val text = "hello"
                                println(text.capitalizeFirst())  // "Hello"
                            }
                        }
                        
                        // 4. 扩展函数可以定义在object中
                        object StringExtensions {
                            fun String.removeWhitespace(): String {
                                return this.replace("\\s".toRegex(), "")
                            }
                        }
                        
                        // 使用
                        val text = "Hello World"
                        StringExtensions.removeWhitespace(text)  // 需要显式调用
                        // 或者导入
                        // import StringExtensions.removeWhitespace
                        // text.removeWhitespace()
                    """.trimIndent(),
                    explanation = "扩展函数定义在顶层时可以在任何地方使用，但需要导入。扩展函数可以定义在类或object中，但使用方式有所不同。"
                ),
                CodeExample(
                    title = "示例4：扩展函数与成员函数",
                    code = """
                        // 1. 扩展函数不会覆盖成员函数
                        class MyClass {
                            fun print() {
                                println("Member function")
                            }
                        }
                        
                        fun MyClass.print() {
                            println("Extension function")
                        }
                        
                        val obj = MyClass()
                        obj.print()  // "Member function" - 成员函数优先
                        
                        // 2. 扩展函数可以重载
                        fun String.remove(char: Char): String {
                            return this.replace(char.toString(), "")
                        }
                        
                        fun String.remove(chars: String): String {
                            var result = this
                            for (char in chars) {
                                result = result.remove(char)
                            }
                            return result
                        }
                        
                        val text = "Hello World"
                        println(text.remove('l'))    // "Heo Word"
                        println(text.remove("lo"))   // "He Wrd"
                        
                        // 3. 扩展函数不能访问私有成员
                        class PrivateClass {
                            private val privateField = "Private"
                        }
                        
                        // fun PrivateClass.accessPrivate() {
                        //     println(this.privateField)  // ❌ 错误！不能访问私有成员
                        // }
                        
                        // 4. 扩展函数是静态解析的
                        open class Animal
                        class Dog : Animal()
                        
                        fun Animal.sound() = "Animal sound"
                        fun Dog.sound() = "Dog sound"
                        
                        fun makeSound(animal: Animal) {
                            println(animal.sound())  // "Animal sound" - 根据声明类型
                        }
                        
                        makeSound(Dog())  // "Animal sound"，不是"Dog sound"
                    """.trimIndent(),
                    explanation = "扩展函数不会覆盖成员函数，成员函数优先。扩展函数可以重载。扩展函数不能访问私有成员。扩展函数是静态解析的，根据声明类型而不是运行时类型。"
                ),
                CodeExample(
                    title = "示例5：扩展函数实践",
                    code = """
                        // 1. 字符串扩展函数
                        fun String.isValidEmail(): Boolean {
                            val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}\$".toRegex()
                            return emailRegex.matches(this)
                        }
                        
                        fun String.truncate(maxLength: Int): String {
                            return if (this.length <= maxLength) {
                                this
                            } else {
                                this.substring(0, maxLength) + "..."
                            }
                        }
                        
                        // 2. 集合扩展函数
                        fun <T> List<T>.second(): T {
                            return this[1]
                        }
                        
                        fun <T> List<T>.secondOrNull(): T? {
                            return if (this.size >= 2) this[1] else null
                        }
                        
                        // 3. 数字扩展函数
                        fun Int.isEven(): Boolean = this % 2 == 0
                        fun Int.isOdd(): Boolean = this % 2 != 0
                        
                        fun Double.round(decimals: Int): Double {
                            var multiplier = 1.0
                            repeat(decimals) { multiplier *= 10 }
                            return kotlin.math.round(this * multiplier) / multiplier
                        }
                        
                        // 4. 可空类型扩展函数
                        fun String?.orEmpty(): String {
                            return this ?: ""
                        }
                        
                        fun String?.isNullOrBlank(): Boolean {
                            return this == null || this.isBlank()
                        }
                        
                        // 5. 链式调用
                        fun String.removeSpaces(): String = this.replace(" ", "")
                        fun String.toUpperCase(): String = this.uppercase()
                        
                        val result = "hello world"
                            .removeSpaces()
                            .toUpperCase()
                        // "HELLOWORLD"
                    """.trimIndent(),
                    explanation = "扩展函数在实际开发中非常有用，可以为字符串、集合、数字等类型添加便捷函数。合理使用扩展函数可以让代码更简洁、更易读。"
                )
            ),
            useCases = listOf(
                "API增强：为现有类添加便捷函数",
                "代码复用：将常用操作封装为扩展函数",
                "Java互操作：为Java类添加Kotlin风格的函数",
                "工具函数：创建领域特定的工具函数",
                "代码组织：将相关函数组织在一起"
            ),
            keyPoints = listOf(
                "扩展函数语法：fun 接收者类型.函数名(参数): 返回类型",
                "this关键字指向接收者对象，可以省略",
                "扩展函数可以为Kotlin类和Java类添加",
                "扩展函数不会覆盖成员函数，成员函数优先",
                "扩展函数是静态解析的，根据声明类型而不是运行时类型"
            ),
            notes = listOf(
                "扩展函数不能访问私有成员",
                "扩展函数定义在顶层时需要在其他文件中导入",
                "扩展函数可以定义在类或object中",
                "扩展函数可以重载",
                "扩展函数不会修改原类，只是语法糖"
            ),
            practiceTips = "建议：合理使用扩展函数增强API，但不要过度使用。为常用操作创建扩展函数可以提高代码可读性。在Android开发中，可以为View、Context等类添加扩展函数简化代码。注意扩展函数的作用域和导入。"
        ),
        
        // 2. 扩展属性的定义和使用
        KnowledgeDetail(
            id = "extension_properties",
            title = "扩展属性的定义和使用",
            overview = "扩展属性允许在不修改类定义的情况下为类添加属性。扩展属性实际上是通过getter和setter实现的，没有实际的存储空间。",
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：扩展属性基础",
                    code = """
                        // 扩展属性语法：val/var 接收者类型.属性名: 类型
                        
                        // 1. 只读扩展属性（val）
                        val String.firstChar: Char
                            get() = this[0]
                        
                        val text = "Hello"
                        println(text.firstChar)  // 'H'
                        
                        // 2. 可变扩展属性（var）
                        var StringBuilder.lastChar: Char
                            get() = this[this.length - 1]
                            set(value) {
                                this.setCharAt(this.length - 1, value)
                            }
                        
                        val sb = StringBuilder("Hello")
                        sb.lastChar = '!'
                        println(sb)  // "Hell!"
                        
                        // 3. 扩展属性必须有getter
                        val String.lengthSquared: Int
                            get() = this.length * this.length
                        
                        // 4. 可变扩展属性必须有getter和setter
                        var String.firstChar: Char
                            get() = this[0]
                            set(value) {
                                // 不能修改String，因为String是不可变的
                                // 需要返回新String
                            }
                    """.trimIndent(),
                    explanation = "扩展属性使用 val/var 接收者类型.属性名 的语法定义。只读扩展属性只需要getter，可变扩展属性需要getter和setter。扩展属性没有实际的存储空间。"
                ),
                CodeExample(
                    title = "示例2：扩展属性的实现",
                    code = """
                        // 扩展属性实际上是通过getter和setter实现的
                        
                        // 1. 计算属性
                        val String.wordCount: Int
                            get() = this.split("\\s+".toRegex()).size
                        
                        val text = "Hello World Kotlin"
                        println(text.wordCount)  // 3
                        
                        // 2. 基于其他属性的扩展属性
                        val Int.isEven: Boolean
                            get() = this % 2 == 0
                        
                        val Int.isOdd: Boolean
                            get() = !this.isEven
                        
                        println(4.isEven)  // true
                        println(5.isOdd)  // true
                        
                        // 3. 可空类型的扩展属性
                        val String?.isNullOrEmpty: Boolean
                            get() = this == null || this.isEmpty()
                        
                        val nullable: String? = null
                        println(nullable.isNullOrEmpty)  // true
                        
                        // 4. 集合的扩展属性
                        val <T> List<T>.second: T
                            get() = this[1]
                        
                        val <T> List<T>.secondOrNull: T?
                            get() = if (this.size >= 2) this[1] else null
                        
                        val list = listOf(1, 2, 3)
                        println(list.second)  // 2
                    """.trimIndent(),
                    explanation = "扩展属性通过getter和setter实现，可以基于其他属性计算，也可以处理可空类型。扩展属性没有实际的存储空间，每次访问都会执行getter。"
                ),
                CodeExample(
                    title = "示例3：扩展属性的setter",
                    code = """
                        // 可变扩展属性需要setter
                        
                        // 1. StringBuilder的扩展属性
                        var StringBuilder.firstChar: Char
                            get() = if (this.isEmpty()) ' ' else this[0]
                            set(value) {
                                if (this.isNotEmpty()) {
                                    this.setCharAt(0, value)
                                }
                            }
                        
                        val sb = StringBuilder("Hello")
                        sb.firstChar = 'h'
                        println(sb)  // "hello"
                        
                        // 2. MutableList的扩展属性
                        var <T> MutableList<T>.last: T
                            get() = this[this.size - 1]
                            set(value) {
                                this[this.size - 1] = value
                            }
                        
                        val list = mutableListOf(1, 2, 3)
                        list.last = 4
                        println(list)  // [1, 2, 4]
                        
                        // 3. 自定义类的扩展属性
                        class Person(var name: String, var age: Int)
                        
                        var Person.fullInfo: String
                            get() = "${'$'}{this.name} (${'$'}{this.age})"
                            set(value) {
                                val parts = value.split(" (")
                                if (parts.size == 2) {
                                    this.name = parts[0]
                                    this.age = parts[1].removeSuffix(")").toIntOrNull() ?: 0
                                }
                            }
                        
                        val person = Person("Alice", 25)
                        person.fullInfo = "Bob (30)"
                        println(person.name)  // "Bob"
                        println(person.age)   // 30
                    """.trimIndent(),
                    explanation = "可变扩展属性需要setter来设置值。setter可以修改接收者对象的属性。扩展属性可以用于MutableList等可变集合。"
                ),
                CodeExample(
                    title = "示例4：扩展属性与扩展函数",
                    code = """
                        // 扩展属性和扩展函数可以结合使用
                        
                        // 1. 扩展属性可以调用扩展函数
                        val String.firstChar: Char
                            get() = this.first()
                        
                        fun String.first(): Char = this[0]
                        
                        // 2. 扩展函数可以返回扩展属性
                        fun String.getFirstChar(): Char = this.firstChar
                        
                        // 3. 扩展属性可以基于扩展函数
                        val String.wordCount: Int
                            get() = this.splitWords().size
                        
                        fun String.splitWords(): List<String> {
                            return this.split("\\s+".toRegex())
                        }
                        
                        // 4. 扩展属性和扩展函数的区别
                        // 扩展属性：访问时像属性，实现时是函数
                        val String.lengthSquared: Int
                            get() = this.length * this.length
                        
                        // 扩展函数：调用时像函数
                        fun String.lengthSquared(): Int {
                            return this.length * this.length
                        }
                        
                        // 使用
                        val text = "Hello"
                        println(text.lengthSquared)  // 属性方式
                        println(text.lengthSquared())  // 函数方式
                    """.trimIndent(),
                    explanation = "扩展属性和扩展函数可以结合使用。扩展属性访问时像属性，但实现时是函数。选择扩展属性还是扩展函数取决于使用场景。"
                ),
                CodeExample(
                    title = "示例5：扩展属性实践",
                    code = """
                        // 1. 日期时间扩展属性
                        import java.util.Date
                        import java.text.SimpleDateFormat
                        
                        val Date.formattedDate: String
                            get() = SimpleDateFormat("yyyy-MM-dd").format(this)
                        
                        val Date.formattedTime: String
                            get() = SimpleDateFormat("HH:mm:ss").format(this)
                        
                        val date = Date()
                        println(date.formattedDate)  // "2024-01-01"
                        println(date.formattedTime)  // "12:00:00"
                        
                        // 2. 集合扩展属性
                        val <T> List<T>.isEmpty: Boolean
                            get() = this.isEmpty()
                        
                        val <T> List<T>.isNotEmpty: Boolean
                            get() = !this.isEmpty()
                        
                        val <T> List<T>.firstOrNull: T?
                            get() = this.firstOrNull()
                        
                        val <T> List<T>.lastOrNull: T?
                            get() = this.lastOrNull()
                        
                        // 3. 数字扩展属性
                        val Int.isPositive: Boolean
                            get() = this > 0
                        
                        val Int.isNegative: Boolean
                            get() = this < 0
                        
                        val Double.isInteger: Boolean
                            get() = this % 1.0 == 0.0
                        
                        // 4. 字符串扩展属性
                        val String.isEmail: Boolean
                            get() = this.contains("@") && this.contains(".")
                        
                        val String.isPhoneNumber: Boolean
                            get() = this.matches("^1[3-9]\\d{9}\$".toRegex())
                        
                        // 5. 在Android中使用
                        // import android.view.View
                        // 
                        // val View.isVisible: Boolean
                        //     get() = this.visibility == View.VISIBLE
                        // 
                        // var View.isVisible: Boolean
                        //     get() = this.visibility == View.VISIBLE
                        //     set(value) {
                        //         this.visibility = if (value) View.VISIBLE else View.GONE
                        //     }
                    """.trimIndent(),
                    explanation = "扩展属性在实际开发中非常有用，可以为日期、集合、数字、字符串等类型添加便捷属性。在Android开发中，可以为View等类添加扩展属性简化代码。"
                )
            ),
            useCases = listOf(
                "属性访问：为类添加计算属性",
                "代码简化：使用扩展属性简化属性访问",
                "API增强：为现有类添加便捷属性",
                "状态检查：添加布尔类型的扩展属性",
                "格式化：为日期、数字等添加格式化属性"
            ),
            keyPoints = listOf(
                "扩展属性语法：val/var 接收者类型.属性名: 类型",
                "扩展属性通过getter和setter实现，没有实际的存储空间",
                "只读扩展属性只需要getter，可变扩展属性需要getter和setter",
                "扩展属性可以基于其他属性计算",
                "扩展属性可以处理可空类型"
            ),
            notes = listOf(
                "扩展属性没有实际的存储空间，每次访问都会执行getter",
                "扩展属性不能有幕后字段（backing field）",
                "可变扩展属性需要接收者对象是可变的",
                "扩展属性可以调用扩展函数",
                "选择扩展属性还是扩展函数取决于使用场景"
            ),
            practiceTips = "建议：合理使用扩展属性简化代码，但要注意扩展属性每次访问都会执行getter。对于计算复杂的属性，考虑使用扩展函数。在Android开发中，可以为View添加扩展属性简化状态管理。"
        ),
        
        // 3. 扩展函数实践（字符串、集合、View扩展）
        KnowledgeDetail(
            id = "extension_practice",
            title = "扩展函数实践（字符串、集合、View扩展）",
            overview = "扩展函数在实际开发中非常有用。通过为字符串、集合、View等常用类添加扩展函数，可以大大提高代码的可读性和开发效率。",
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：字符串扩展函数",
                    code = """
                        // 1. 验证函数
                        fun String.isValidEmail(): Boolean {
                            val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}\$".toRegex()
                            return emailRegex.matches(this)
                        }
                        
                        fun String.isValidPhone(): Boolean {
                            return this.matches("^1[3-9]\\d{9}\$".toRegex())
                        }
                        
                        fun String.isValidUrl(): Boolean {
                            return this.startsWith("http://") || this.startsWith("https://")
                        }
                        
                        // 2. 转换函数
                        fun String.toCamelCase(): String {
                            return this.split(" ").joinToString("") { word ->
                                word.lowercase().replaceFirstChar { it.uppercaseChar() }
                            }
                        }
                        
                        fun String.toSnakeCase(): String {
                            return this.replace(" ", "_").lowercase()
                        }
                        
                        fun String.truncate(maxLength: Int, suffix: String = "..."): String {
                            return if (this.length <= maxLength) {
                                this
                            } else {
                                this.substring(0, maxLength - suffix.length) + suffix
                            }
                        }
                        
                        // 3. 提取函数
                        fun String.extractNumbers(): String {
                            return this.filter { it.isDigit() }
                        }
                        
                        fun String.extractEmails(): List<String> {
                            val emailRegex = "[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}".toRegex()
                            return emailRegex.findAll(this).map { it.value }.toList()
                        }
                        
                        // 使用
                        val email = "test@example.com"
                        println(email.isValidEmail())  // true
                        
                        val text = "hello world"
                        println(text.toCamelCase())  // "HelloWorld"
                        println(text.toSnakeCase())  // "hello_world"
                    """.trimIndent(),
                    explanation = "字符串扩展函数可以用于验证、转换、提取等操作。合理使用字符串扩展函数可以让代码更简洁、更易读。"
                ),
                CodeExample(
                    title = "示例2：集合扩展函数",
                    code = """
                        // 1. 安全访问函数
                        fun <T> List<T>.secondOrNull(): T? {
                            return if (this.size >= 2) this[1] else null
                        }
                        
                        fun <T> List<T>.thirdOrNull(): T? {
                            return if (this.size >= 3) this[2] else null
                        }
                        
                        fun <T> List<T>.getOrNull(index: Int): T? {
                            return if (index in this.indices) this[index] else null
                        }
                        
                        // 2. 转换函数
                        fun <T> List<T>.chunked(size: Int): List<List<T>> {
                            return this.windowed(size, size, partialWindows = true)
                        }
                        
                        fun <T, R> List<T>.mapIndexedNotNull(transform: (Int, T) -> R?): List<R> {
                            return this.mapIndexed(transform).filterNotNull()
                        }
                        
                        // 3. 过滤函数
                        fun <T> List<T>.distinctBy(selector: (T) -> Any?): List<T> {
                            val seen = mutableSetOf<Any?>()
                            return this.filter { seen.add(selector(it)) }
                        }
                        
                        // 4. 分组函数
                        fun <T> List<T>.groupByCount(): Map<T, Int> {
                            return this.groupingBy { it }.eachCount()
                        }
                        
                        // 5. 统计函数
                        fun <T : Number> List<T>.averageOrNull(): Double? {
                            return if (this.isEmpty()) null else this.average()
                        }
                        
                        // 使用
                        val list = listOf(1, 2, 3, 4, 5)
                        println(list.secondOrNull())  // 2
                        println(list.chunked(2))  // [[1, 2], [3, 4], [5]]
                    """.trimIndent(),
                    explanation = "集合扩展函数可以用于安全访问、转换、过滤、分组、统计等操作。合理使用集合扩展函数可以简化集合操作代码。"
                ),
                CodeExample(
                    title = "示例3：Android View扩展函数",
                    code = """
                        // import android.view.View
                        // import android.view.ViewGroup
                        // import androidx.core.view.isVisible
                        
                        // 1. 可见性扩展函数
                        // fun View.show() {
                        //     this.visibility = View.VISIBLE
                        // }
                        // 
                        // fun View.hide() {
                        //     this.visibility = View.GONE
                        // }
                        // 
                        // fun View.invisible() {
                        //     this.visibility = View.INVISIBLE
                        // }
                        // 
                        // fun View.toggleVisibility() {
                        //     this.visibility = if (this.visibility == View.VISIBLE) {
                        //         View.GONE
                        //     } else {
                        //         View.VISIBLE
                        //     }
                        // }
                        
                        // 2. 点击扩展函数
                        // fun View.onClick(action: () -> Unit) {
                        //     this.setOnClickListener { action() }
                        // }
                        // 
                        // fun View.onLongClick(action: () -> Boolean) {
                        //     this.setOnLongClickListener { action() }
                        // }
                        
                        // 3. 布局扩展函数
                        // fun ViewGroup.removeAllViews() {
                        //     this.removeAllViews()
                        // }
                        // 
                        // fun ViewGroup.addView(view: View) {
                        //     this.addView(view)
                        // }
                        
                        // 4. 尺寸扩展函数
                        // fun View.setWidth(width: Int) {
                        //     val params = this.layoutParams
                        //     params.width = width
                        //     this.layoutParams = params
                        // }
                        // 
                        // fun View.setHeight(height: Int) {
                        //     val params = this.layoutParams
                        //     params.height = height
                        //     this.layoutParams = params
                        // }
                        
                        // 5. 使用示例
                        // val button = findViewById<Button>(R.id.button)
                        // button.show()
                        // button.onClick {
                        //     println("Button clicked")
                        // }
                    """.trimIndent(),
                    explanation = "Android View扩展函数可以简化View的操作，包括可见性、点击事件、布局、尺寸等。合理使用View扩展函数可以让Android代码更简洁。"
                ),
                CodeExample(
                    title = "示例4：Context扩展函数",
                    code = """
                        // import android.content.Context
                        // import android.widget.Toast
                        // 
                        // // 1. Toast扩展函数
                        // fun Context.showToast(message: String, duration: Int = Toast.LENGTH_SHORT) {
                        //     Toast.makeText(this, message, duration).show()
                        // }
                        // 
                        // fun Context.showLongToast(message: String) {
                        //     Toast.makeText(this, message, Toast.LENGTH_LONG).show()
                        // }
                        
                        // 2. 资源扩展函数
                        // fun Context.getString(resId: Int): String {
                        //     return this.getString(resId)
                        // }
                        // 
                        // fun Context.getColor(resId: Int): Int {
                        //     return ContextCompat.getColor(this, resId)
                        // }
                        // 
                        // fun Context.getDrawable(resId: Int): Drawable? {
                        //     return ContextCompat.getDrawable(this, resId)
                        // }
                        
                        // 3. Intent扩展函数
                        // fun Context.startActivity(clazz: Class<*>) {
                        //     startActivity(Intent(this, clazz))
                        // }
                        // 
                        // fun Context.startActivity(action: String) {
                        //     startActivity(Intent(action))
                        // }
                        
                        // 4. 权限扩展函数
                        // fun Context.hasPermission(permission: String): Boolean {
                        //     return ContextCompat.checkSelfPermission(
                        //         this,
                        //         permission
                        //     ) == PackageManager.PERMISSION_GRANTED
                        // }
                        
                        // 5. 使用示例
                        // class MainActivity : AppCompatActivity() {
                        //     override fun onCreate(savedInstanceState: Bundle?) {
                        //         super.onCreate(savedInstanceState)
                        //         
                        //         showToast("Hello")
                        //         startActivity(SecondActivity::class.java)
                        //     }
                        // }
                    """.trimIndent(),
                    explanation = "Context扩展函数可以简化Android开发中的常见操作，包括Toast、资源获取、Intent启动、权限检查等。合理使用Context扩展函数可以提高开发效率。"
                ),
                CodeExample(
                    title = "示例5：扩展函数最佳实践",
                    code = """
                        // 1. 组织扩展函数
                        // 将相关扩展函数放在同一个文件中
                        // StringExtensions.kt
                        fun String.isValidEmail(): Boolean { ... }
                        fun String.isValidPhone(): Boolean { ... }
                        
                        // CollectionExtensions.kt
                        fun <T> List<T>.secondOrNull(): T? { ... }
                        fun <T> List<T>.chunked(size: Int): List<List<T>> { ... }
                        
                        // ViewExtensions.kt
                        // fun View.show() { ... }
                        // fun View.hide() { ... }
                        
                        // 2. 命名规范
                        // 使用清晰的函数名
                        fun String.removeSpaces(): String { ... }  // ✅ 好
                        // fun String.rs(): String { ... }  // ❌ 不好
                        
                        // 3. 文档注释
                        /**
                         * 验证字符串是否为有效的邮箱地址
                         * @return true如果字符串是有效的邮箱地址，否则返回false
                         */
                        fun String.isValidEmail(): Boolean { ... }
                        
                        // 4. 避免过度使用
                        // 不要为每个小操作都创建扩展函数
                        // fun String.add(a: String): String = this + a  // ❌ 过度使用
                        
                        // 5. 考虑性能
                        // 对于频繁调用的扩展函数，考虑性能影响
                        fun String.process(): String {
                            // 复杂的处理逻辑
                            return this
                        }
                        
                        // 6. 测试扩展函数
                        // 扩展函数应该像普通函数一样进行测试
                        @Test
                        fun testIsValidEmail() {
                            assertTrue("test@example.com".isValidEmail())
                            assertFalse("invalid".isValidEmail())
                        }
                    """.trimIndent(),
                    explanation = "扩展函数的最佳实践包括：合理组织扩展函数、使用清晰的命名、添加文档注释、避免过度使用、考虑性能、进行测试等。遵循最佳实践可以让扩展函数更易维护。"
                )
            ),
            useCases = listOf(
                "字符串处理：为String添加验证、转换、提取等函数",
                "集合操作：为集合添加安全访问、转换、过滤等函数",
                "Android开发：为View、Context等类添加便捷函数",
                "工具函数：创建领域特定的工具函数",
                "代码复用：将常用操作封装为扩展函数"
            ),
            keyPoints = listOf(
                "字符串扩展函数可以用于验证、转换、提取等操作",
                "集合扩展函数可以用于安全访问、转换、过滤等操作",
                "Android View扩展函数可以简化View的操作",
                "Context扩展函数可以简化Android开发中的常见操作",
                "合理组织扩展函数，使用清晰的命名和文档注释"
            ),
            notes = listOf(
                "将相关扩展函数放在同一个文件中",
                "使用清晰的函数名，避免缩写",
                "为扩展函数添加文档注释",
                "避免过度使用扩展函数",
                "考虑扩展函数的性能影响"
            ),
            practiceTips = "建议：合理使用扩展函数增强API，但不要过度使用。将相关扩展函数组织在同一个文件中。使用清晰的命名和文档注释。在Android开发中，为View、Context等类添加扩展函数可以大大提高开发效率。注意扩展函数的性能影响。"
        ),
        
        // ========== Kotlin 委托（Delegation） ==========
        
        // 1. 类委托、by关键字
        KnowledgeDetail(
            id = "class_delegation",
            title = "类委托、by关键字",
            overview = "Kotlin支持类委托，通过by关键字将接口的实现委托给另一个对象。这是实现组合优于继承的优雅方式。",
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：类委托基础",
                    code = """
                        // 类委托：将接口实现委托给另一个对象
                        
                        interface Base {
                            fun print()
                        }
                        
                        class BaseImpl(val x: Int) : Base {
                            override fun print() {
                                println(x)
                            }
                        }
                        
                        // 使用by关键字委托
                        class Derived(b: Base) : Base by b
                        
                        // 使用
                        val b = BaseImpl(10)
                        val derived = Derived(b)
                        derived.print()  // 10
                        
                        // Derived类自动获得Base接口的所有方法
                        // 方法调用会转发给委托对象b
                    """.trimIndent(),
                    explanation = "使用by关键字可以将接口实现委托给另一个对象。委托类自动获得接口的所有方法，方法调用会转发给委托对象。"
                ),
                CodeExample(
                    title = "示例2：覆盖委托方法",
                    code = """
                        interface Base {
                            fun print()
                            fun printMessage()
                        }
                        
                        class BaseImpl(val x: Int) : Base {
                            override fun print() {
                                println(x)
                            }
                            
                            override fun printMessage() {
                                println("BaseImpl")
                            }
                        }
                        
                        // 可以覆盖委托的方法
                        class Derived(b: Base) : Base by b {
                            override fun printMessage() {
                                println("Derived")
                            }
                        }
                        
                        val b = BaseImpl(10)
                        val derived = Derived(b)
                        derived.print()         // 10 (委托给b)
                        derived.printMessage()  // "Derived" (覆盖的方法)
                    """.trimIndent(),
                    explanation = "委托类可以覆盖委托的方法。覆盖的方法会优先调用，未覆盖的方法会委托给委托对象。"
                ),
                CodeExample(
                    title = "示例3：委托多个接口",
                    code = """
                        interface A {
                            fun funA()
                        }
                        
                        interface B {
                            fun funB()
                        }
                        
                        class AImpl : A {
                            override fun funA() {
                                println("A")
                            }
                        }
                        
                        class BImpl : B {
                            override fun funB() {
                                println("B")
                            }
                        }
                        
                        // 可以委托多个接口
                        class AB(a: A, b: B) : A by a, B by b
                        
                        val ab = AB(AImpl(), BImpl())
                        ab.funA()  // "A"
                        ab.funB()  // "B"
                    """.trimIndent(),
                    explanation = "一个类可以委托多个接口，每个接口的实现可以委托给不同的对象。"
                ),
                CodeExample(
                    title = "示例4：委托的优势",
                    code = """
                        // 委托模式的优势：组合优于继承
                        
                        interface Repository {
                            fun save(data: String)
                            fun load(): String
                        }
                        
                        class DatabaseRepository : Repository {
                            override fun save(data: String) {
                                println("Saving to database: ${'$'}data")
                            }
                            
                            override fun load(): String {
                                return "Data from database"
                            }
                        }
                        
                        // 使用委托，可以轻松切换实现
                        class CachedRepository(private val repository: Repository) : Repository by repository {
                            private var cache: String? = null
                            
                            override fun load(): String {
                                if (cache == null) {
                                    cache = repository.load()
                                }
                                return cache!!
                            }
                        }
                        
                        // 使用
                        val dbRepo = DatabaseRepository()
                        val cachedRepo = CachedRepository(dbRepo)
                        cachedRepo.save("Data")  // 委托给dbRepo
                        cachedRepo.load()        // 使用缓存逻辑
                    """.trimIndent(),
                    explanation = "委托模式的优势是可以轻松组合功能，实现组合优于继承。可以创建装饰器模式，在不修改原类的情况下添加功能。"
                ),
                CodeExample(
                    title = "示例5：委托实践",
                    code = """
                        // 1. 装饰器模式
                        interface Window {
                            fun draw()
                        }
                        
                        class SimpleWindow : Window {
                            override fun draw() {
                                println("Drawing window")
                            }
                        }
                        
                        class DecoratedWindow(private val window: Window) : Window by window {
                            override fun draw() {
                                println("Decorating...")
                                window.draw()
                                println("Decorated")
                            }
                        }
                        
                        // 2. 适配器模式
                        interface Target {
                            fun request()
                        }
                        
                        class Adaptee {
                            fun specificRequest() {
                                println("Specific request")
                            }
                        }
                        
                        class Adapter(private val adaptee: Adaptee) : Target {
                            override fun request() {
                                adaptee.specificRequest()
                            }
                        }
                        
                        // 3. 代理模式
                        interface Subject {
                            fun doSomething()
                        }
                        
                        class RealSubject : Subject {
                            override fun doSomething() {
                                println("Real subject")
                            }
                        }
                        
                        class Proxy(private val subject: Subject) : Subject by subject {
                            override fun doSomething() {
                                println("Before")
                                subject.doSomething()
                                println("After")
                            }
                        }
                    """.trimIndent(),
                    explanation = "委托模式可以用于实现装饰器模式、适配器模式、代理模式等设计模式。委托让这些模式的实现更简洁。"
                )
            ),
            useCases = listOf(
                "组合优于继承：使用委托实现组合",
                "装饰器模式：在不修改原类的情况下添加功能",
                "适配器模式：适配不同的接口",
                "代理模式：控制对对象的访问",
                "功能扩展：轻松扩展类的功能"
            ),
            keyPoints = listOf(
                "使用by关键字将接口实现委托给另一个对象",
                "委托类自动获得接口的所有方法",
                "可以覆盖委托的方法，覆盖的方法优先调用",
                "一个类可以委托多个接口",
                "委托模式实现组合优于继承"
            ),
            notes = listOf(
                "委托只能用于接口，不能用于类",
                "委托的方法调用会转发给委托对象",
                "覆盖的方法会优先调用，未覆盖的方法会委托",
                "委托对象在委托类构造时传入",
                "委托模式比继承更灵活"
            ),
            practiceTips = "建议：优先使用委托而不是继承，实现组合优于继承。使用委托可以轻松切换实现，创建装饰器、适配器等模式。委托让代码更灵活、更易维护。"
        ),
        
        // 2. 属性委托（lazy、observable、vetoable）
        KnowledgeDetail(
            id = "property_delegation",
            title = "属性委托（lazy、observable、vetoable）",
            overview = "属性委托允许将属性的getter和setter委托给另一个对象。Kotlin提供了lazy、observable、vetoable等标准委托，也可以自定义委托。",
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：属性委托基础",
                    code = """
                        // 属性委托：将属性的访问委托给另一个对象
                        
                        class Delegate {
                            private var value: String = ""
                            
                            operator fun getValue(thisRef: Any?, property: kotlin.reflect.KProperty<*>): String {
                                println("Getting value")
                                return value
                            }
                            
                            operator fun setValue(thisRef: Any?, property: kotlin.reflect.KProperty<*>, value: String) {
                                println("Setting value to ${'$'}value")
                                this.value = value
                            }
                        }
                        
                        class Example {
                            var p: String by Delegate()
                        }
                        
                        val example = Example()
                        example.p = "Hello"  // "Setting value to Hello"
                        println(example.p)   // "Getting value" "Hello"
                    """.trimIndent(),
                    explanation = "属性委托需要实现getValue和setValue操作符。使用by关键字将属性委托给委托对象。"
                ),
                CodeExample(
                    title = "示例2：lazy委托",
                    code = """
                        // lazy：延迟初始化，首次访问时计算
                        
                        val lazyValue: String by lazy {
                            println("Computing...")
                            "Hello"
                        }
                        
                        println(lazyValue)  // "Computing..." "Hello"
                        println(lazyValue)  // "Hello" (不再计算)
                        
                        // lazy是线程安全的（默认）
                        val threadSafe: String by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
                            "Thread safe"
                        }
                        
                        // 非线程安全的lazy（性能更好）
                        val nonThreadSafe: String by lazy(LazyThreadSafetyMode.NONE) {
                            "Non thread safe"
                        }
                        
                        // 使用场景：昂贵的初始化
                        class MyClass {
                            val expensiveProperty: String by lazy {
                                // 执行昂贵的初始化
                                computeExpensiveValue()
                            }
                        }
                    """.trimIndent(),
                    explanation = "lazy委托用于延迟初始化，首次访问时计算，之后复用结果。默认是线程安全的，也可以指定非线程安全模式。"
                ),
                CodeExample(
                    title = "示例3：observable委托",
                    code = """
                        import kotlin.properties.Delegates
                        
                        // observable：属性变化时通知
                        
                        class User {
                            var name: String by Delegates.observable("Initial") { prop, old, new ->
                                println("${'$'}{prop.name} changed from ${'$'}old to ${'$'}new")
                            }
                        }
                        
                        val user = User()
                        user.name = "Alice"  // "name changed from Initial to Alice"
                        user.name = "Bob"   // "name changed from Alice to Bob"
                        
                        // 使用场景：数据绑定、日志记录
                        class ViewModel {
                            var data: String by Delegates.observable("") { _, old, new ->
                                if (old != new) {
                                    notifyDataChanged()
                                }
                            }
                        }
                    """.trimIndent(),
                    explanation = "observable委托在属性值变化时调用回调函数，可以用于数据绑定、日志记录等场景。"
                ),
                CodeExample(
                    title = "示例4：vetoable委托",
                    code = """
                        import kotlin.properties.Delegates
                        
                        // vetoable：可以否决属性值的变化
                        
                        class User {
                            var age: Int by Delegates.vetoable(0) { prop, old, new ->
                                if (new >= 0 && new <= 150) {
                                    println("${'$'}{prop.name} changed from ${'$'}old to ${'$'}new")
                                    true  // 接受新值
                                } else {
                                    println("Invalid age: ${'$'}new")
                                    false  // 拒绝新值
                                }
                            }
                        }
                        
                        val user = User()
                        user.age = 25   // "age changed from 0 to 25"
                        user.age = -1   // "Invalid age: -1" (值不变)
                        println(user.age)  // 25
                        
                        // 使用场景：数据验证
                        class Product {
                            var price: Double by Delegates.vetoable(0.0) { _, old, new ->
                                new >= 0.0  // 价格不能为负
                            }
                        }
                    """.trimIndent(),
                    explanation = "vetoable委托可以否决属性值的变化，回调函数返回true接受新值，返回false拒绝新值。用于数据验证。"
                ),
                CodeExample(
                    title = "示例5：自定义属性委托",
                    code = """
                        // 自定义属性委托
                        
                        class MapDelegate<T>(private val map: MutableMap<String, Any?>) {
                            operator fun getValue(thisRef: Any?, property: kotlin.reflect.KProperty<*>): T {
                                return map[property.name] as T
                            }
                            
                            operator fun setValue(thisRef: Any?, property: kotlin.reflect.KProperty<*>, value: T) {
                                map[property.name] = value
                            }
                        }
                        
                        class User(map: MutableMap<String, Any?>) {
                            var name: String by MapDelegate(map)
                            var age: Int by MapDelegate(map)
                        }
                        
                        val map = mutableMapOf<String, Any?>(
                            "name" to "Alice",
                            "age" to 25
                        )
                        val user = User(map)
                        println(user.name)  // "Alice"
                        println(user.age)   // 25
                        
                        user.name = "Bob"
                        println(map["name"])  // "Bob"
                    """.trimIndent(),
                    explanation = "可以自定义属性委托，实现getValue和setValue操作符。自定义委托可以实现各种功能，如从Map读取属性、属性验证等。"
                )
            ),
            useCases = listOf(
                "延迟初始化：使用lazy延迟初始化昂贵的属性",
                "数据绑定：使用observable监听属性变化",
                "数据验证：使用vetoable验证属性值",
                "属性映射：自定义委托从Map读取属性",
                "缓存：使用lazy缓存计算结果"
            ),
            keyPoints = listOf(
                "属性委托需要实现getValue和setValue操作符",
                "lazy用于延迟初始化，首次访问时计算",
                "observable在属性变化时通知，用于数据绑定",
                "vetoable可以否决属性值变化，用于数据验证",
                "可以自定义属性委托实现特定功能"
            ),
            notes = listOf(
                "lazy默认是线程安全的，也可以指定非线程安全模式",
                "observable的回调在值变化后执行",
                "vetoable的回调返回true接受新值，false拒绝新值",
                "属性委托可以用于val和var属性",
                "自定义委托需要实现getValue和setValue操作符"
            ),
            practiceTips = "建议：使用lazy延迟初始化昂贵的属性。使用observable实现数据绑定。使用vetoable验证属性值。自定义委托可以实现特定功能，但要保持简单。"
        ),
        
        // 3. 标准委托的使用
        KnowledgeDetail(
            id = "standard_delegates",
            title = "标准委托的使用",
            overview = "Kotlin标准库提供了多个标准委托，包括lazy、observable、vetoable、notNull等。理解这些标准委托的使用场景可以提高开发效率。",
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：lazy委托详解",
                    code = """
                        // lazy：延迟初始化
                        
                        // 1. 基本使用
                        val data: String by lazy {
                            println("Initializing...")
                            loadData()
                        }
                        
                        // 2. 线程安全模式
                        val safe: String by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
                            "Thread safe"
                        }
                        
                        // 3. 非线程安全模式（性能更好）
                        val fast: String by lazy(LazyThreadSafetyMode.NONE) {
                            "Non thread safe"
                        }
                        
                        // 4. 在类中使用
                        class MyClass {
                            val expensive: String by lazy {
                                computeExpensiveValue()
                            }
                        }
                        
                        // 5. 使用场景
                        // - 昂贵的初始化
                        // - 可能不使用的属性
                        // - 单例模式
                    """.trimIndent(),
                    explanation = "lazy委托用于延迟初始化，支持线程安全和非线程安全模式。适用于昂贵的初始化、可能不使用的属性等场景。"
                ),
                CodeExample(
                    title = "示例2：observable和vetoable",
                    code = """
                        import kotlin.properties.Delegates
                        
                        // 1. observable：监听变化
                        class ViewModel {
                            var data: String by Delegates.observable("") { _, old, new ->
                                if (old != new) {
                                    onDataChanged(new)
                                }
                            }
                        }
                        
                        // 2. vetoable：验证值
                        class User {
                            var email: String by Delegates.vetoable("") { _, old, new ->
                                new.isValidEmail()  // 验证邮箱
                            }
                        }
                        
                        // 3. 组合使用
                        class Product {
                            var price: Double by Delegates.vetoable(0.0) { _, old, new ->
                                if (new >= 0) {
                                    true
                                } else {
                                    println("Price cannot be negative")
                                    false
                                }
                            }
                            
                            var name: String by Delegates.observable("") { _, old, new ->
                                println("Name changed: ${'$'}old -> ${'$'}new")
                            }
                        }
                    """.trimIndent(),
                    explanation = "observable用于监听属性变化，vetoable用于验证属性值。可以组合使用实现数据验证和变化通知。"
                ),
                CodeExample(
                    title = "示例3：notNull委托",
                    code = """
                        import kotlin.properties.Delegates
                        
                        // notNull：非空属性，必须在初始化前赋值
                        
                        class MyClass {
                            var name: String by Delegates.notNull<String>()
                            
                            fun init(name: String) {
                                this.name = name
                            }
                        }
                        
                        val obj = MyClass()
                        // println(obj.name)  // ❌ 错误！未初始化
                        obj.init("Alice")
                        println(obj.name)  // ✅ "Alice"
                        
                        // 使用场景：需要在构造后初始化的属性
                        class ViewHolder {
                            var itemView: View by Delegates.notNull()
                            
                            fun bind(view: View) {
                                this.itemView = view
                            }
                        }
                    """.trimIndent(),
                    explanation = "notNull委托用于非空属性，必须在访问前初始化。如果未初始化就访问会抛出异常。"
                ),
                CodeExample(
                    title = "示例4：标准委托实践",
                    code = """
                        import kotlin.properties.Delegates
                        
                        // 1. Android ViewModel中使用
                        class MyViewModel : ViewModel() {
                            private var _uiState = MutableStateFlow<UiState>(UiState.Idle)
                            val uiState: StateFlow<UiState> = _uiState.asStateFlow()
                            
                            var data: String by Delegates.observable("") { _, _, new ->
                                _uiState.value = UiState.Loaded(new)
                            }
                        }
                        
                        // 2. 数据验证
                        class UserForm {
                            var email: String by Delegates.vetoable("") { _, _, new ->
                                new.isValidEmail()
                            }
                            
                            var age: Int by Delegates.vetoable(0) { _, _, new ->
                                new in 0..150
                            }
                        }
                        
                        // 3. 缓存
                        class Cache {
                            private val cache = mutableMapOf<String, String>()
                            
                            fun get(key: String): String by lazy {
                                cache[key] ?: loadFromNetwork(key)
                            }
                        }
                        
                        // 4. 配置管理
                        class Config {
                            var apiUrl: String by Delegates.observable("") { _, old, new ->
                                if (old != new) {
                                    updateApiClient(new)
                                }
                            }
                        }
                    """.trimIndent(),
                    explanation = "标准委托在实际开发中用于ViewModel状态管理、数据验证、缓存、配置管理等场景。合理使用标准委托可以提高代码质量。"
                ),
                CodeExample(
                    title = "示例5：委托选择指南",
                    code = """
                        // 1. 延迟初始化 -> lazy
                        val expensive: String by lazy { compute() }
                        
                        // 2. 监听变化 -> observable
                        var data: String by Delegates.observable("") { _, old, new ->
                            onChanged(old, new)
                        }
                        
                        // 3. 数据验证 -> vetoable
                        var age: Int by Delegates.vetoable(0) { _, _, new ->
                            new >= 0
                        }
                        
                        // 4. 非空属性 -> notNull
                        var view: View by Delegates.notNull()
                        
                        // 5. 自定义需求 -> 自定义委托
                        class CustomDelegate {
                            operator fun getValue(...) = ...
                            operator fun setValue(...) = ...
                        }
                    """.trimIndent(),
                    explanation = "根据需求选择合适的委托：延迟初始化用lazy，监听变化用observable，数据验证用vetoable，非空属性用notNull，特殊需求用自定义委托。"
                )
            ),
            useCases = listOf(
                "延迟初始化：使用lazy延迟初始化",
                "状态管理：使用observable管理状态变化",
                "数据验证：使用vetoable验证数据",
                "非空属性：使用notNull确保属性非空",
                "缓存：使用lazy缓存计算结果"
            ),
            keyPoints = listOf(
                "lazy用于延迟初始化，支持线程安全模式",
                "observable用于监听属性变化",
                "vetoable用于验证属性值",
                "notNull用于非空属性，必须在访问前初始化",
                "根据需求选择合适的标准委托"
            ),
            notes = listOf(
                "lazy默认是线程安全的，也可以指定非线程安全模式",
                "observable在值变化后执行回调",
                "vetoable返回true接受新值，false拒绝新值",
                "notNull未初始化就访问会抛出异常",
                "标准委托可以满足大部分需求，特殊需求可以自定义"
            ),
            practiceTips = "建议：根据需求选择合适的标准委托。延迟初始化用lazy，监听变化用observable，数据验证用vetoable。在Android开发中，合理使用委托可以简化代码，提高可维护性。"
        ),
        
        // ========== Kotlin 泛型（Generics） ==========
        
        // 1. 泛型类和函数、类型参数、泛型约束
        KnowledgeDetail(
            id = "generics_basic",
            title = "泛型类和函数、类型参数、泛型约束",
            overview = "Kotlin的泛型系统提供了类型安全的抽象。理解泛型类、泛型函数、类型参数和泛型约束是掌握Kotlin泛型的基础。",
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：泛型类",
                    code = """
                        // 泛型类：在类名后声明类型参数
                        
                        class Box<T>(val value: T)
                        
                        val intBox = Box(1)           // Box<Int>
                        val stringBox = Box("Hello")  // Box<String>
                        
                        // 多个类型参数
                        class Pair<A, B>(val first: A, val second: B)
                        
                        val pair = Pair(1, "Hello")  // Pair<Int, String>
                        
                        // 泛型类的方法可以使用类型参数
                        class Stack<T> {
                            private val items = mutableListOf<T>()
                            
                            fun push(item: T) {
                                items.add(item)
                            }
                            
                            fun pop(): T? {
                                return if (items.isEmpty()) null else items.removeAt(items.size - 1)
                            }
                        }
                        
                        val stack = Stack<Int>()
                        stack.push(1)
                        stack.push(2)
                        println(stack.pop())  // 2
                    """.trimIndent(),
                    explanation = "泛型类在类名后声明类型参数，可以在类的属性和方法中使用。可以声明多个类型参数。"
                ),
                CodeExample(
                    title = "示例2：泛型函数",
                    code = """
                        // 泛型函数：在函数名前声明类型参数
                        
                        fun <T> singletonList(item: T): List<T> {
                            return listOf(item)
                        }
                        
                        val list1 = singletonList(1)        // List<Int>
                        val list2 = singletonList("Hello")  // List<String>
                        
                        // 多个类型参数
                        fun <T, R> map(list: List<T>, transform: (T) -> R): List<R> {
                            return list.map(transform)
                        }
                        
                        val numbers = listOf(1, 2, 3)
                        val strings = map(numbers) { it.toString() }  // List<String>
                        
                        // 扩展函数也可以是泛型的
                        fun <T> List<T>.secondOrNull(): T? {
                            return if (this.size >= 2) this[1] else null
                        }
                        
                        val list = listOf(1, 2, 3)
                        println(list.secondOrNull())  // 2
                    """.trimIndent(),
                    explanation = "泛型函数在函数名前声明类型参数，Kotlin可以推断类型参数。扩展函数也可以是泛型的。"
                ),
                CodeExample(
                    title = "示例3：类型参数约束",
                    code = """
                        // 类型参数约束：限制类型参数必须是某个类型的子类型
                        
                        // 上界约束：T必须是Comparable的子类型
                        fun <T : Comparable<T>> maxOf(a: T, b: T): T {
                            return if (a > b) a else b
                        }
                        
                        val max = maxOf(1, 2)  // 2
                        val maxStr = maxOf("a", "b")  // "b"
                        
                        // 多个上界约束（使用where子句）
                        fun <T> copyWhenGreater(list: List<T>, threshold: T): List<String>
                            where T : CharSequence,
                                  T : Comparable<T> {
                            return list.filter { it > threshold }.map { it.toString() }
                        }
                        
                        // 默认上界是Any?
                        class Box<T>  // T : Any?
                        
                        // 非空类型参数
                        class NonNullBox<T : Any>  // T不能为null
                    """.trimIndent(),
                    explanation = "类型参数约束使用冒号语法，限制类型参数必须是某个类型的子类型。可以使用where子句指定多个约束。"
                ),
                CodeExample(
                    title = "示例4：泛型接口",
                    code = """
                        // 泛型接口
                        
                        interface Repository<T> {
                            fun save(item: T)
                            fun findById(id: String): T?
                            fun findAll(): List<T>
                        }
                        
                        // 实现泛型接口
                        class UserRepository : Repository<User> {
                            override fun save(item: User) {
                                // 保存用户
                            }
                            
                            override fun findById(id: String): User? {
                                // 查找用户
                                return null
                            }
                            
                            override fun findAll(): List<User> {
                                return emptyList()
                            }
                        }
                        
                        // 泛型接口也可以有类型参数
                        interface Mapper<in T, out R> {
                            fun map(input: T): R
                        }
                        
                        class StringToIntMapper : Mapper<String, Int> {
                            override fun map(input: String): Int {
                                return input.toIntOrNull() ?: 0
                            }
                        }
                    """.trimIndent(),
                    explanation = "接口也可以是泛型的，实现泛型接口时需要指定具体类型。泛型接口可以用于定义通用的数据访问模式。"
                ),
                CodeExample(
                    title = "示例5：泛型实践",
                    code = """
                        // 1. 通用容器
                        class Cache<K, V> {
                            private val map = mutableMapOf<K, V>()
                            
                            fun put(key: K, value: V) {
                                map[key] = value
                            }
                            
                            fun get(key: K): V? = map[key]
                        }
                        
                        // 2. 通用工厂
                        interface Factory<T> {
                            fun create(): T
                        }
                        
                        class StringFactory : Factory<String> {
                            override fun create(): String = "Default"
                        }
                        
                        fun <T> createInstance(factory: Factory<T>): T {
                            return factory.create()
                        }
                        
                        // 3. 通用工具函数
                        fun <T> List<T>.swap(index1: Int, index2: Int) {
                            val tmp = this[index1]
                            this[index1] = this[index2]
                            this[index2] = tmp
                        }
                        
                        // 4. 类型安全的构建器
                        class Builder<T> {
                            private var value: T? = null
                            
                            fun set(value: T) {
                                this.value = value
                            }
                            
                            fun build(): T = value ?: throw IllegalStateException()
                        }
                    """.trimIndent(),
                    explanation = "泛型在实际开发中用于创建通用容器、工厂模式、工具函数等。泛型提供了类型安全，避免了类型转换。"
                )
            ),
            useCases = listOf(
                "类型安全：使用泛型避免类型转换和运行时错误",
                "代码复用：创建通用的容器和工具类",
                "API设计：设计灵活的API接口",
                "集合操作：创建类型安全的集合操作",
                "工厂模式：实现通用的工厂模式"
            ),
            keyPoints = listOf(
                "泛型类在类名后声明类型参数",
                "泛型函数在函数名前声明类型参数",
                "类型参数约束使用冒号语法限制类型",
                "可以使用where子句指定多个约束",
                "默认上界是Any?，可以指定非空上界"
            ),
            notes = listOf(
                "Kotlin可以推断泛型类型参数",
                "类型参数约束限制类型参数必须是某个类型的子类型",
                "泛型接口可以用于定义通用的数据访问模式",
                "泛型提供了编译时类型安全",
                "可以使用多个类型参数"
            ),
            practiceTips = "建议：合理使用泛型提高代码的类型安全性和复用性。使用类型参数约束确保类型安全。在API设计时，使用泛型可以让API更灵活。"
        ),
        
        // 2. 型变（协变out、逆变in、星投影）
        KnowledgeDetail(
            id = "variance",
            title = "型变（协变out、逆变in、星投影）",
            overview = "Kotlin的型变系统包括协变（out）、逆变（in）和星投影（*）。理解型变是掌握Kotlin泛型高级特性的关键。",
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：协变（out）",
                    code = """
                        // 协变：子类型关系保持不变
                        // 如果A是B的子类型，那么Producer<A>是Producer<B>的子类型
                        
                        // 声明处型变：在类声明时使用out
                        interface Producer<out T> {
                            fun produce(): T
                        }
                        
                        class StringProducer : Producer<String> {
                            override fun produce(): String = "Hello"
                        }
                        
                        // 协变允许向上转型
                        val producer: Producer<Any> = StringProducer()  // ✅ 可以
                        
                        // 使用处型变：在使用时使用out
                        fun printProducer(producer: Producer<out Number>) {
                            val value: Number = producer.produce()
                            println(value)
                        }
                        
                        val intProducer: Producer<Int> = object : Producer<Int> {
                            override fun produce(): Int = 42
                        }
                        printProducer(intProducer)  // ✅ 可以
                        
                        // out关键字限制：只能作为返回类型，不能作为参数类型
                        // interface Producer<out T> {
                        //     fun produce(): T  // ✅ 可以
                        //     fun consume(item: T)  // ❌ 错误！不能作为参数
                        // }
                    """.trimIndent(),
                    explanation = "协变使用out关键字，表示类型参数只能作为返回类型。协变允许子类型向上转型，适用于只读操作。"
                ),
                CodeExample(
                    title = "示例2：逆变（in）",
                    code = """
                        // 逆变：子类型关系反转
                        // 如果A是B的子类型，那么Consumer<B>是Consumer<A>的子类型
                        
                        // 声明处型变：在类声明时使用in
                        interface Consumer<in T> {
                            fun consume(item: T)
                        }
                        
                        class AnyConsumer : Consumer<Any> {
                            override fun consume(item: Any) {
                                println(item)
                            }
                        }
                        
                        // 逆变允许向下转型
                        val consumer: Consumer<String> = AnyConsumer()  // ✅ 可以
                        consumer.consume("Hello")
                        
                        // 使用处型变：在使用时使用in
                        fun printConsumer(consumer: Consumer<in String>) {
                            consumer.consume("Hello")
                        }
                        
                        val anyConsumer: Consumer<Any> = object : Consumer<Any> {
                            override fun consume(item: Any) {
                                println(item)
                            }
                        }
                        printConsumer(anyConsumer)  // ✅ 可以
                        
                        // in关键字限制：只能作为参数类型，不能作为返回类型
                        // interface Consumer<in T> {
                        //     fun consume(item: T)  // ✅ 可以
                        //     fun produce(): T  // ❌ 错误！不能作为返回类型
                        // }
                    """.trimIndent(),
                    explanation = "逆变使用in关键字，表示类型参数只能作为参数类型。逆变允许父类型向下转型，适用于只写操作。"
                ),
                CodeExample(
                    title = "示例3：不变（invariant）",
                    code = """
                        // 不变：没有型变，类型必须完全匹配
                        
                        class MutableBox<T>(var value: T)
                        
                        val intBox = MutableBox(1)
                        // val numberBox: MutableBox<Number> = intBox  // ❌ 错误！
                        
                        // 不变类型不能相互转换
                        fun setValue(box: MutableBox<Number>) {
                            box.value = 3.14
                        }
                        
                        // setValue(intBox)  // ❌ 错误！不安全
                        // 如果允许，intBox.value会被设置为Double，但intBox是MutableBox<Int>
                        
                        // 同时读写需要不变
                        interface MutableList<T> {
                            fun get(index: Int): T
                            fun set(index: Int, value: T)
                        }
                    """.trimIndent(),
                    explanation = "不变类型没有型变，类型必须完全匹配。同时读写操作的类型需要不变，以保证类型安全。"
                ),
                CodeExample(
                    title = "示例4：星投影（*）",
                    code = """
                        // 星投影：使用*代替类型参数，表示未知类型
                        
                        // 1. 协变类型的星投影
                        interface Producer<out T> {
                            fun produce(): T
                        }
                        
                        fun printProducer(producer: Producer<*>) {
                            val value: Any? = producer.produce()  // 只能作为Any?使用
                            println(value)
                        }
                        
                        // 2. 逆变类型的星投影
                        interface Consumer<in T> {
                            fun consume(item: T)
                        }
                        
                        fun printConsumer(consumer: Consumer<*>) {
                            // consumer.consume(?)  // ❌ 不能调用，不知道具体类型
                        }
                        
                        // 3. 不变类型的星投影
                        class Box<T>(var value: T)
                        
                        fun printBox(box: Box<*>) {
                            val value: Any? = box.value  // 只能读取为Any?
                            // box.value = ?  // ❌ 不能写入，不知道具体类型
                        }
                        
                        // 4. 星投影的使用场景
                        fun processList(list: List<*>) {
                            // 不知道List的具体类型，只能作为List<Any?>使用
                            for (item in list) {
                                println(item)
                            }
                        }
                    """.trimIndent(),
                    explanation = "星投影使用*代替类型参数，表示未知类型。协变的星投影可以读取为Any?，逆变的星投影不能调用，不变的星投影只能读取不能写入。"
                ),
                CodeExample(
                    title = "示例5：型变实践",
                    code = """
                        // 1. List是协变的（只读）
                        val stringList: List<String> = listOf("a", "b")
                        val anyList: List<Any> = stringList  // ✅ 可以
                        
                        // 2. MutableList是不变的（可读写）
                        val mutableStringList: MutableList<String> = mutableListOf("a", "b")
                        // val mutableAnyList: MutableList<Any> = mutableStringList  // ❌ 错误！
                        
                        // 3. 函数类型是协变的
                        val intFunction: (Int) -> Number = { it.toDouble() }
                        val numberFunction: (Number) -> Number = intFunction  // ✅ 可以
                        
                        // 4. 使用处型变
                        fun copy(from: Array<out Any>, to: Array<in String>) {
                            // from可以读取为Any
                            // to可以写入String
                        }
                        
                        val intArray = arrayOf(1, 2, 3)
                        val anyArray = arrayOfNulls<Any>(3)
                        copy(intArray, anyArray)  // ✅ 可以
                        
                        // 5. 声明处型变 vs 使用处型变
                        // 声明处型变：在类声明时指定，所有使用都遵循型变
                        // 使用处型变：在使用时指定，只影响当前使用
                    """.trimIndent(),
                    explanation = "在实际开发中，List是协变的，MutableList是不变的。函数类型是协变的。可以使用声明处型变或使用处型变。理解型变有助于编写更灵活的代码。"
                )
            ),
            useCases = listOf(
                "只读集合：使用协变实现只读集合",
                "只写操作：使用逆变实现只写操作",
                "类型安全：使用不变保证类型安全",
                "API设计：使用型变设计灵活的API",
                "函数参数：使用使用处型变接受更广泛的类型"
            ),
            keyPoints = listOf(
                "协变（out）：子类型关系保持不变，只能作为返回类型",
                "逆变（in）：子类型关系反转，只能作为参数类型",
                "不变：没有型变，类型必须完全匹配",
                "星投影（*）：表示未知类型，使用有限制",
                "声明处型变在类声明时指定，使用处型变在使用时指定"
            ),
            notes = listOf(
                "out关键字限制类型参数只能作为返回类型",
                "in关键字限制类型参数只能作为参数类型",
                "同时读写操作的类型需要不变",
                "协变的星投影可以读取为Any?",
                "List是协变的，MutableList是不变的"
            ),
            practiceTips = "建议：理解协变、逆变和不变的区别。只读操作使用协变，只写操作使用逆变，同时读写使用不变。合理使用型变可以让API更灵活，同时保证类型安全。"
        ),
        
        // 3. 泛型实践、reified类型参数
        KnowledgeDetail(
            id = "generics_practice",
            title = "泛型实践、reified类型参数",
            overview = "reified类型参数允许在运行时访问类型信息，这是Kotlin泛型的高级特性。理解reified类型参数的使用场景可以提高代码的灵活性。",
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：reified类型参数基础",
                    code = """
                        // reified：使类型参数在运行时可用
                        // 只能用于内联函数（inline function）
                        
                        inline fun <reified T> getTypeName(): String {
                            return T::class.simpleName ?: "Unknown"
                        }
                        
                        println(getTypeName<Int>())      // "Int"
                        println(getTypeName<String>())    // "String"
                        
                        // 不使用reified（错误示例）
                        // fun <T> getTypeName(): String {
                        //     return T::class.simpleName  // ❌ 错误！T在运行时被擦除
                        // }
                        
                        // reified必须配合inline使用
                        inline fun <reified T> isInstance(value: Any): Boolean {
                            return value is T
                        }
                        
                        println(isInstance<String>("Hello"))  // true
                        println(isInstance<Int>("Hello"))     // false
                    """.trimIndent(),
                    explanation = "reified类型参数使用reified关键字，只能在inline函数中使用。reified允许在运行时访问类型信息，避免了类型擦除的问题。"
                ),
                CodeExample(
                    title = "示例2：reified类型参数实践",
                    code = """
                        // 1. 类型检查
                        inline fun <reified T> List<*>.filterIsInstance(): List<T> {
                            return this.filterIsInstance<T>()
                        }
                        
                        val mixed = listOf(1, "Hello", 2, "World")
                        val strings = mixed.filterIsInstance<String>()  // ["Hello", "World"]
                        
                        // 2. 创建实例
                        inline fun <reified T> createInstance(): T? {
                            return try {
                                T::class.java.getDeclaredConstructor().newInstance()
                            } catch (e: Exception) {
                                null
                            }
                        }
                        
                        val string = createInstance<String>()  // ""
                        val list = createInstance<ArrayList<String>>()  // ArrayList()
                        
                        // 3. 获取类型信息
                        inline fun <reified T> getTypeInfo(): String {
                            val kClass = T::class
                            return "Name: ${'$'}{kClass.simpleName}, Qualified: ${'$'}{kClass.qualifiedName}"
                        }
                        
                        println(getTypeInfo<Int>())  // "Name: Int, Qualified: kotlin.Int"
                    """.trimIndent(),
                    explanation = "reified类型参数可以用于类型检查、创建实例、获取类型信息等场景。reified让泛型函数更强大、更灵活。"
                ),
                CodeExample(
                    title = "示例3：reified在Android中的应用",
                    code = """
                        // 1. 启动Activity
                        // inline fun <reified T : Activity> Context.startActivity() {
                        //     startActivity(Intent(this, T::class.java))
                        // }
                        // 
                        // // 使用
                        // startActivity<MainActivity>()
                        
                        // 2. 获取Fragment参数
                        // inline fun <reified T> Fragment.getArgument(key: String): T? {
                        //     return arguments?.get(key) as? T
                        // }
                        // 
                        // // 使用
                        // val userId: String? = getArgument("userId")
                        
                        // 3. 依赖注入
                        inline fun <reified T> getService(): T {
                            return ServiceLocator.getService(T::class.java)
                        }
                        
                        // 使用
                        val apiService = getService<ApiService>()
                        
                        // 4. JSON解析
                        inline fun <reified T> String.fromJson(): T? {
                            return try {
                                Gson().fromJson(this, T::class.java)
                            } catch (e: Exception) {
                                null
                            }
                        }
                        
                        // 使用
                        val user: User? = jsonString.fromJson<User>()
                    """.trimIndent(),
                    explanation = "reified类型参数在Android开发中非常有用，可以简化Activity启动、Fragment参数获取、依赖注入、JSON解析等操作。"
                ),
                CodeExample(
                    title = "示例4：reified的限制",
                    code = """
                        // 1. reified只能用于inline函数
                        // fun <reified T> normalFunction() {  // ❌ 错误！
                        //     // reified必须配合inline
                        // }
                        
                        // 2. 不能用于非内联函数
                        inline fun <reified T> outerFunction() {
                            // 可以调用其他reified函数
                            innerFunction<T>()
                        }
                        
                        inline fun <reified T> innerFunction() {
                            println(T::class.simpleName)
                        }
                        
                        // 3. 不能用于非内联的lambda
                        inline fun <reified T> process(block: () -> Unit) {
                            block()
                            // 在block中不能使用T，因为block可能不是内联的
                        }
                        
                        // 4. 类型参数必须是reified
                        inline fun <reified T> checkType(value: Any): Boolean {
                            return value is T  // ✅ 可以，T是reified
                        }
                        
                        // fun <T> checkType(value: Any): Boolean {
                        //     return value is T  // ❌ 错误！T不是reified
                        // }
                    """.trimIndent(),
                    explanation = "reified类型参数只能用于inline函数，不能用于非内联函数或非内联的lambda。reified类型参数在运行时可用，非reified类型参数在运行时被擦除。"
                ),
                CodeExample(
                    title = "示例5：泛型最佳实践",
                    code = """
                        // 1. 使用类型参数约束
                        fun <T : Comparable<T>> sort(list: List<T>): List<T> {
                            return list.sorted()
                        }
                        
                        // 2. 使用协变和逆变
                        interface Repository<out T> {
                            fun findAll(): List<T>
                        }
                        
                        interface Writer<in T> {
                            fun write(item: T)
                        }
                        
                        // 3. 使用reified简化代码
                        inline fun <reified T> List<*>.filterByType(): List<T> {
                            return this.filterIsInstance<T>()
                        }
                        
                        // 4. 避免不必要的泛型
                        // 如果类型总是相同，不需要泛型
                        class StringList {  // 而不是 List<String>
                            // ...
                        }
                        
                        // 5. 使用类型别名简化复杂泛型
                        typealias StringMap = Map<String, String>
                        typealias Callback<T> = (T) -> Unit
                        
                        // 6. 合理使用星投影
                        fun process(items: List<*>) {
                            // 当不需要知道具体类型时使用星投影
                        }
                    """.trimIndent(),
                    explanation = "泛型最佳实践包括：使用类型参数约束、合理使用协变和逆变、使用reified简化代码、避免不必要的泛型、使用类型别名、合理使用星投影等。"
                )
            ),
            useCases = listOf(
                "类型检查：使用reified进行运行时类型检查",
                "实例创建：使用reified创建泛型类型的实例",
                "Android开发：简化Activity启动、Fragment参数获取等",
                "依赖注入：使用reified简化依赖注入",
                "JSON解析：使用reified简化JSON解析"
            ),
            keyPoints = listOf(
                "reified类型参数只能在inline函数中使用",
                "reified允许在运行时访问类型信息",
                "reified避免了类型擦除的问题",
                "reified可以用于类型检查、创建实例、获取类型信息",
                "reified在Android开发中非常有用"
            ),
            notes = listOf(
                "reified必须配合inline使用",
                "非reified类型参数在运行时被擦除",
                "reified类型参数在运行时可用",
                "reified不能用于非内联函数或非内联的lambda",
                "reified让泛型函数更强大、更灵活"
            ),
            practiceTips = "建议：合理使用reified类型参数简化代码，特别是在Android开发中。使用reified可以避免类型擦除的问题，让泛型函数更强大。注意reified只能用于inline函数。"
        ),
        
        // ========== Kotlin 集合操作 ==========
        
        // 1. List、Set、Map、可变集合和不可变集合
        KnowledgeDetail(
            id = "collection_types",
            title = "List、Set、Map、可变集合和不可变集合",
            overview = "Kotlin提供了丰富的集合类型，包括List、Set、Map，以及可变和不可变版本。理解这些集合类型的特点和使用场景是掌握Kotlin集合框架的基础。",
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：List集合",
                    code = """
                        // List：有序集合，可以包含重复元素
                        
                        // 不可变List（默认）
                        val immutableList = listOf(1, 2, 3, 4, 5)
                        // immutableList.add(6)  // ❌ 错误！不可变
                        
                        // 可变List
                        val mutableList = mutableListOf(1, 2, 3)
                        mutableList.add(4)  // ✅ 可以
                        mutableList.remove(2)  // ✅ 可以
                        
                        // 空List
                        val emptyList = emptyList<Int>()
                        val emptyMutableList = mutableListOf<Int>()
                        
                        // List操作
                        val list = listOf(1, 2, 3, 4, 5)
                        println(list[0])           // 1
                        println(list.first())      // 1
                        println(list.last())       // 5
                        println(list.size)         // 5
                        println(list.contains(3))  // true
                    """.trimIndent(),
                    explanation = "List是有序集合，可以包含重复元素。listOf创建不可变List，mutableListOf创建可变List。"
                ),
                CodeExample(
                    title = "示例2：Set集合",
                    code = """
                        // Set：无序集合，不包含重复元素
                        
                        // 不可变Set
                        val immutableSet = setOf(1, 2, 3, 3, 4)
                        println(immutableSet)  // [1, 2, 3, 4] (去重)
                        
                        // 可变Set
                        val mutableSet = mutableSetOf(1, 2, 3)
                        mutableSet.add(4)      // ✅ 可以
                        mutableSet.add(2)     // 不会添加，已存在
                        mutableSet.remove(1)   // ✅ 可以
                        
                        // Set操作
                        val set1 = setOf(1, 2, 3)
                        val set2 = setOf(3, 4, 5)
                        
                        println(set1.union(set2))        // [1, 2, 3, 4, 5]
                        println(set1.intersect(set2))    // [3]
                        println(set1.subtract(set2))     // [1, 2]
                        
                        // LinkedHashSet：保持插入顺序
                        val linkedSet = linkedSetOf(3, 1, 2)
                        println(linkedSet)  // [3, 1, 2] (保持顺序)
                    """.trimIndent(),
                    explanation = "Set是无序集合，不包含重复元素。setOf创建不可变Set，mutableSetOf创建可变Set。Set支持并集、交集、差集等操作。"
                ),
                CodeExample(
                    title = "示例3：Map集合",
                    code = """
                        // Map：键值对集合
                        
                        // 不可变Map
                        val immutableMap = mapOf(
                            "name" to "Alice",
                            "age" to 25,
                            "city" to "Beijing"
                        )
                        // immutableMap["email"] = "alice@example.com"  // ❌ 错误！
                        
                        // 可变Map
                        val mutableMap = mutableMapOf(
                            "name" to "Bob",
                            "age" to 30
                        )
                        mutableMap["city"] = "Shanghai"  // ✅ 可以
                        mutableMap.remove("age")         // ✅ 可以
                        
                        // Map操作
                        val map = mapOf("a" to 1, "b" to 2, "c" to 3)
                        println(map["a"])              // 1
                        println(map.getOrDefault("d", 0))  // 0
                        println(map.keys)             // [a, b, c]
                        println(map.values)           // [1, 2, 3]
                        println(map.entries)          // [a=1, b=2, c=3]
                        
                        // 遍历Map
                        for ((key, value) in map) {
                            println("${'$'}key -> ${'$'}value")
                        }
                    """.trimIndent(),
                    explanation = "Map是键值对集合。mapOf创建不可变Map，mutableMapOf创建可变Map。Map支持通过键访问值，可以遍历键值对。"
                ),
                CodeExample(
                    title = "示例4：可变集合和不可变集合",
                    code = """
                        // 1. 不可变集合（只读）
                        val immutableList = listOf(1, 2, 3)
                        // immutableList.add(4)  // ❌ 编译错误
        
                        // 2. 可变集合（可读写）
                        val mutableList = mutableListOf(1, 2, 3)
                        mutableList.add(4)  // ✅ 可以
        
                        // 3. 类型转换
                        val list = listOf(1, 2, 3)
                        val mutable = list.toMutableList()  // 转换为可变
                        mutable.add(4)
        
                        val mutable2 = mutableListOf(1, 2, 3)
                        val immutable = mutable2.toList()  // 转换为不可变
        
                        // 4. 协变关系
                        val stringList: List<String> = listOf("a", "b")
                        val anyList: List<Any> = stringList  // ✅ 可以（协变）
        
                        // val mutableStringList: MutableList<String> = mutableListOf("a")
                        // val mutableAnyList: MutableList<Any> = mutableStringList  // ❌ 错误！（不变）
        
                        // 5. 不可变集合的特点
                        // - 不能添加、删除、修改元素
                        // - 是协变的（List<String>是List<Any>的子类型）
                        // - 线程安全（多个线程可以同时读取）
                        // - 推荐使用，除非确实需要修改
                    """.trimIndent(),
                    explanation = "不可变集合是只读的，不能修改。可变集合可以修改。不可变集合是协变的，可变集合是不变的。推荐优先使用不可变集合。"
                ),
                CodeExample(
                    title = "示例5：集合创建和初始化",
                    code = """
                        // 1. 使用工厂函数
                        val list = listOf(1, 2, 3)
                        val set = setOf(1, 2, 3)
                        val map = mapOf("a" to 1, "b" to 2)
        
                        // 2. 使用构造函数
                        val list2 = ArrayList<Int>()
                        val set2 = HashSet<String>()
                        val map2 = HashMap<String, Int>()
        
                        // 3. 使用构建器
                        val list3 = buildList {
                            add(1)
                            add(2)
                            add(3)
                        }
        
                        val map3 = buildMap {
                            put("a", 1)
                            put("b", 2)
                        }
        
                        // 4. 从其他集合创建
                        val list4 = listOf(1, 2, 3).toMutableList()
                        val set4 = listOf(1, 2, 2, 3).toSet()  // 去重
                        val map4 = listOf("a", "b", "c").associateWith { it.length }
        
                        // 5. 空集合
                        val emptyList = emptyList<Int>()
                        val emptySet = emptySet<String>()
                        val emptyMap = emptyMap<String, Int>()
                    """.trimIndent(),
                    explanation = "Kotlin提供了多种方式创建集合，包括工厂函数、构造函数、构建器等。可以根据需求选择合适的创建方式。"
                )
            ),
            useCases = listOf(
                "数据存储：使用List存储有序数据，Set存储唯一数据，Map存储键值对",
                "不可变数据：使用不可变集合存储不会改变的数据",
                "数据转换：在可变和不可变集合之间转换",
                "集合操作：使用集合的并集、交集、差集等操作",
                "数据去重：使用Set自动去重"
            ),
            keyPoints = listOf(
                "List是有序集合，可以包含重复元素",
                "Set是无序集合，不包含重复元素",
                "Map是键值对集合",
                "不可变集合是只读的，可变集合可以修改",
                "不可变集合是协变的，可变集合是不变的"
            ),
            notes = listOf(
                "默认创建的集合是不可变的（listOf、setOf、mapOf）",
                "可变集合使用mutableListOf、mutableSetOf、mutableMapOf",
                "不可变集合不能添加、删除、修改元素",
                "推荐优先使用不可变集合，除非确实需要修改",
                "可以在可变和不可变集合之间转换"
            ),
            practiceTips = "建议：优先使用不可变集合（listOf、setOf、mapOf），只有在确实需要修改时才使用可变集合。不可变集合更安全、更易理解，是协变的。"
        ),
        
        // 2. 集合操作符（转换、过滤、聚合、分组、排序）
        KnowledgeDetail(
            id = "collection_operators",
            title = "集合操作符（转换、过滤、聚合、分组、排序）",
            overview = "Kotlin提供了丰富的集合操作符，包括转换、过滤、聚合、分组、排序等。这些操作符让集合处理变得简洁优雅。",
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：转换操作符",
                    code = """
                        val numbers = listOf(1, 2, 3, 4, 5)
        
                        // 1. map：转换每个元素
                        val doubled = numbers.map { it * 2 }  // [2, 4, 6, 8, 10]
                        val strings = numbers.map { it.toString() }  // ["1", "2", "3", "4", "5"]
        
                        // 2. mapIndexed：同时访问索引和元素
                        val indexed = numbers.mapIndexed { index, value ->
                            "Index ${'$'}index: ${'$'}value"
                        }
        
                        // 3. mapNotNull：转换并过滤null
                        val nullable = listOf(1, 2, null, 4, null)
                        val nonNull = nullable.mapNotNull { it?.times(2) }  // [2, 4, 8]
        
                        // 4. flatMap：展平嵌套集合
                        val nested = listOf(listOf(1, 2), listOf(3, 4))
                        val flattened = nested.flatMap { it }  // [1, 2, 3, 4]
        
                        // 5. associate：转换为Map
                        val map = numbers.associateWith { it * it }  // {1=1, 2=4, 3=9, 4=16, 5=25}
                        val map2 = numbers.associateBy { "key${'$'}it" }  // {"key1"=1, "key2"=2, ...}
                    """.trimIndent(),
                    explanation = "转换操作符用于将集合元素转换为另一种形式。map用于转换，flatMap用于展平，associate用于转换为Map。"
                ),
                CodeExample(
                    title = "示例2：过滤操作符",
                    code = """
                        val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        
                        // 1. filter：根据条件过滤
                        val evens = numbers.filter { it % 2 == 0 }  // [2, 4, 6, 8, 10]
                        val large = numbers.filter { it > 5 }  // [6, 7, 8, 9, 10]
        
                        // 2. filterIndexed：同时使用索引和元素
                        val filtered = numbers.filterIndexed { index, value ->
                            index % 2 == 0 && value > 3
                        }
        
                        // 3. filterNot：过滤不满足条件的元素
                        val odds = numbers.filterNot { it % 2 == 0 }  // [1, 3, 5, 7, 9]
        
                        // 4. filterNotNull：过滤null值
                        val nullable = listOf(1, null, 2, null, 3)
                        val nonNull = nullable.filterNotNull()  // [1, 2, 3]
        
                        // 5. take和drop：取前N个或跳过前N个
                        val first3 = numbers.take(3)      // [1, 2, 3]
                        val skip3 = numbers.drop(3)       // [4, 5, 6, 7, 8, 9, 10]
                        val takeWhile = numbers.takeWhile { it < 5 }  // [1, 2, 3, 4]
                    """.trimIndent(),
                    explanation = "过滤操作符用于根据条件过滤集合元素。filter用于过滤，filterNot用于反向过滤，take和drop用于取或跳过元素。"
                ),
                CodeExample(
                    title = "示例3：聚合操作符",
                    code = """
                        val numbers = listOf(1, 2, 3, 4, 5)
        
                        // 1. reduce：累积为单个值
                        val sum = numbers.reduce { acc, n -> acc + n }  // 15
                        val product = numbers.reduce { acc, n -> acc * n }  // 120
        
                        // 2. fold：类似reduce，但可以指定初始值
                        val sumWithInit = numbers.fold(10) { acc, n -> acc + n }  // 25
                        val productWithInit = numbers.fold(1) { acc, n -> acc * n }  // 120
        
                        // 3. 其他聚合函数
                        val max = numbers.maxOrNull()  // 5
                        val min = numbers.minOrNull()  // 1
                        val average = numbers.average()  // 3.0
                        val count = numbers.count()  // 5
                        val sum2 = numbers.sum()  // 15
        
                        // 4. reduceRight和foldRight：从右到左累积
                        val rightSum = numbers.reduceRight { n, acc -> acc + n }  // 15
        
                        // 5. 字符串聚合
                        val words = listOf("Hello", "World", "Kotlin")
                        val sentence = words.reduce { acc, word -> "${'$'}acc ${'$'}word" }  // "Hello World Kotlin"
                    """.trimIndent(),
                    explanation = "聚合操作符用于将集合元素累积为单个值。reduce从第一个元素开始，fold可以指定初始值。还有max、min、sum、average等聚合函数。"
                ),
                CodeExample(
                    title = "示例4：分组操作符",
                    code = """
                        val words = listOf("apple", "banana", "apricot", "blueberry", "cherry")
        
                        // 1. groupBy：根据键分组
                        val byFirstChar = words.groupBy { it.first() }
                        // {a=[apple, apricot], b=[banana, blueberry], c=[cherry]}
        
                        // 2. 按长度分组
                        val byLength = words.groupBy { it.length }
                        // {5=[apple], 6=[banana, cherry], 7=[apricot], 9=[blueberry]}
        
                        // 3. groupBy + mapValues：分组后转换值
                        val byFirstCharCount = words.groupBy({ it.first() }, { it.length })
                        // {a=[5, 7], b=[6, 9], c=[6]}
        
                        // 4. partition：分为两部分
                        val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                        val (evens, odds) = numbers.partition { it % 2 == 0 }
                        // evens = [2, 4, 6, 8, 10], odds = [1, 3, 5, 7, 9]
        
                        // 5. chunked：分块
                        val chunks = numbers.chunked(3)
                        // [[1, 2, 3], [4, 5, 6], [7, 8, 9], [10]]
                    """.trimIndent(),
                    explanation = "分组操作符用于对集合进行分组。groupBy根据键分组，partition分为两部分，chunked分块。"
                ),
                CodeExample(
                    title = "示例5：排序操作符",
                    code = """
                        val numbers = listOf(3, 1, 4, 1, 5, 9, 2, 6)
        
                        // 1. sorted：升序排序
                        val sorted = numbers.sorted()  // [1, 1, 2, 3, 4, 5, 6, 9]
        
                        // 2. sortedDescending：降序排序
                        val sortedDesc = numbers.sortedDescending()  // [9, 6, 5, 4, 3, 2, 1, 1]
        
                        // 3. sortedBy：根据转换函数排序
                        val words = listOf("apple", "banana", "apricot")
                        val sortedByLength = words.sortedBy { it.length }  // [apple, banana, apricot]
        
                        // 4. sortedByDescending：降序
                        val sortedByLengthDesc = words.sortedByDescending { it.length }
        
                        // 5. sortedWith：使用比较器排序
                        val sortedWith = words.sortedWith(compareBy { it.length })
        
                        // 6. reversed：反转顺序
                        val reversed = numbers.reversed()  // [6, 2, 9, 5, 1, 4, 1, 3]
        
                        // 7. distinct：去重
                        val distinct = numbers.distinct()  // [3, 1, 4, 5, 9, 2, 6, 9]
                    """.trimIndent(),
                    explanation = "排序操作符用于对集合进行排序。sorted用于升序，sortedDescending用于降序，sortedBy根据转换函数排序，distinct用于去重。"
                )
            ),
            useCases = listOf(
                "数据转换：使用map转换集合元素",
                "数据过滤：使用filter过滤集合元素",
                "数据聚合：使用reduce/fold计算聚合值",
                "数据分组：使用groupBy对数据进行分组",
                "数据排序：使用sorted对数据进行排序"
            ),
            keyPoints = listOf(
                "map用于转换元素，flatMap用于展平嵌套集合",
                "filter用于过滤元素，filterNot用于反向过滤",
                "reduce/fold用于聚合，可以指定初始值",
                "groupBy用于分组，partition用于分为两部分",
                "sorted用于排序，distinct用于去重"
            ),
            notes = listOf(
                "集合操作符返回新集合，不修改原集合",
                "可以链式调用多个操作符",
                "操作符是延迟计算的（Sequence），可以提高性能",
                "reduce从第一个元素开始，fold可以指定初始值",
                "sorted返回新集合，不修改原集合"
            ),
            practiceTips = "建议：优先使用集合操作符而不是手动编写循环，代码更简洁易读。对于大数据集，使用Sequence进行延迟计算可以提高性能。合理组合多个操作符，但要注意可读性。"
        ),
        
        // 3. 序列（Sequence）的延迟计算
        KnowledgeDetail(
            id = "sequence",
            title = "序列（Sequence）的延迟计算",
            overview = "Sequence是Kotlin的延迟计算集合，类似于Java 8的Stream。Sequence只在需要时才计算，可以提高性能，特别是对于大数据集。",
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：Sequence基础",
                    code = """
                        // Sequence：延迟计算的集合
        
                        // 1. 创建Sequence
                        val sequence = sequenceOf(1, 2, 3, 4, 5)
        
                        // 2. 从集合创建Sequence
                        val list = listOf(1, 2, 3, 4, 5)
                        val seq = list.asSequence()
        
                        // 3. 使用generateSequence创建无限序列
                        val infinite = generateSequence(1) { it + 1 }
                        val first10 = infinite.take(10).toList()  // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
        
                        // 4. 使用sequence函数创建
                        val seq2 = sequence {
                            yield(1)
                            yield(2)
                            yield(3)
                        }
        
                        // 5. Sequence是延迟计算的
                        val seq3 = sequenceOf(1, 2, 3)
                            .map { println("Map: ${'$'}it"); it * 2 }
                            .filter { println("Filter: ${'$'}it"); it > 2 }
                        // 此时还没有执行
        
                        val result = seq3.toList()
                        // 现在才执行，输出：
                        // Map: 1
                        // Filter: 2
                        // Map: 2
                        // Filter: 4
                        // Map: 3
                        // Filter: 6
                    """.trimIndent(),
                    explanation = "Sequence是延迟计算的集合，只在需要时才计算。可以使用sequenceOf、asSequence、generateSequence等创建Sequence。"
                ),
                CodeExample(
                    title = "示例2：Sequence vs List",
                    code = """
                        val numbers = (1..1_000_000).toList()
        
                        // List：立即计算，创建中间集合
                        val listResult = numbers
                            .map { it * 2 }        // 创建新List
                            .filter { it > 1000 }  // 创建新List
                            .take(10)              // 创建新List
                            .toList()
                        // 创建了3个中间集合，处理了100万个元素
        
                        // Sequence：延迟计算，不创建中间集合
                        val seqResult = numbers.asSequence()
                            .map { it * 2 }        // 不创建集合
                            .filter { it > 1000 }  // 不创建集合
                            .take(10)              // 只处理前10个满足条件的元素
                            .toList()
                        // 不创建中间集合，只处理必要的元素
        
                        // Sequence的优势：
                        // 1. 不创建中间集合，节省内存
                        // 2. 延迟计算，只处理必要的元素
                        // 3. 可以处理无限序列
                    """.trimIndent(),
                    explanation = "Sequence延迟计算，不创建中间集合，只处理必要的元素。对于大数据集，Sequence可以显著提高性能。"
                ),
                CodeExample(
                    title = "示例3：Sequence操作符",
                    code = """
                        val sequence = (1..10).asSequence()
        
                        // 1. 转换操作符（延迟计算）
                        val mapped = sequence.map { it * 2 }
                        val flatMapped = sequence.flatMap { listOf(it, it * 2) }
        
                        // 2. 过滤操作符（延迟计算）
                        val filtered = sequence.filter { it % 2 == 0 }
                        val taken = sequence.take(5)
                        val dropped = sequence.drop(5)
        
                        // 3. 聚合操作符（终端操作，立即计算）
                        val sum = sequence.sum()
                        val max = sequence.maxOrNull()
                        val count = sequence.count()
        
                        // 4. 终端操作（触发计算）
                        val list = sequence.toList()
                        val set = sequence.toSet()
                        val first = sequence.first()
                        val last = sequence.last()
        
                        // 5. 链式操作
                        val result = (1..100).asSequence()
                            .map { it * it }
                            .filter { it > 50 }
                            .take(10)
                            .toList()
                        // 只处理必要的元素，不创建中间集合
                    """.trimIndent(),
                    explanation = "Sequence支持与List相同的操作符，但延迟计算。终端操作（如toList、sum）会触发计算。"
                ),
                CodeExample(
                    title = "示例4：无限序列",
                    code = """
                        // 1. 生成无限序列
                        val infinite = generateSequence(1) { it + 1 }
                        val first10 = infinite.take(10).toList()  // [1, 2, 3, ..., 10]
        
                        // 2. 斐波那契数列
                        val fibonacci = generateSequence(Pair(0, 1)) { 
                            Pair(it.second, it.first + it.second) 
                        }.map { it.first }
                        val first10Fib = fibonacci.take(10).toList()
                        // [0, 1, 1, 2, 3, 5, 8, 13, 21, 34]
        
                        // 3. 文件读取（逐行读取，不加载整个文件）
                        // val lines = File("large.txt")
                        //     .useLines { it.asSequence() }
                        //     .filter { it.startsWith("ERROR") }
                        //     .take(10)
                        //     .toList()
        
                        // 4. 条件终止
                        val sequence = generateSequence(1) { 
                            if (it < 100) it * 2 else null  // null终止序列
                        }
                        val result = sequence.toList()  // [1, 2, 4, 8, 16, 32, 64]
                    """.trimIndent(),
                    explanation = "Sequence可以处理无限序列，使用generateSequence创建。可以用于生成数列、逐行读取文件等场景。"
                ),
                CodeExample(
                    title = "示例5：Sequence实践",
                    code = """
                        // 1. 大数据集处理
                        val largeList = (1..10_000_000).toList()
                        val result = largeList.asSequence()
                            .filter { it % 2 == 0 }
                            .map { it * it }
                            .take(100)
                            .toList()
                        // 只处理必要的元素，不创建中间集合
        
                        // 2. 文件处理
                        // val errors = File("log.txt")
                        //     .useLines { it.asSequence() }
                        //     .filter { it.contains("ERROR") }
                        //     .map { it.substringAfter("ERROR: ") }
                        //     .take(10)
                        //     .toList()
        
                        // 3. 数据库查询（模拟）
                        // val users = database.users.asSequence()
                        //     .filter { it.age > 18 }
                        //     .map { it.name }
                        //     .take(100)
                        //     .toList()
        
                        // 4. 性能对比
                        val numbers = (1..1_000_000).toList()
        
                        // List：处理所有元素
                        val listTime = measureTimeMillis {
                            numbers.map { it * 2 }.filter { it > 1000 }.take(10).toList()
                        }
        
                        // Sequence：只处理必要的元素
                        val seqTime = measureTimeMillis {
                            numbers.asSequence()
                                .map { it * 2 }
                                .filter { it > 1000 }
                                .take(10)
                                .toList()
                        }
                        // Sequence通常更快，特别是当只需要少量结果时
                    """.trimIndent(),
                    explanation = "Sequence在实际开发中用于处理大数据集、文件、数据库查询等场景。Sequence延迟计算，只处理必要的元素，可以提高性能。"
                )
            ),
            useCases = listOf(
                "大数据集处理：使用Sequence处理大数据集，不创建中间集合",
                "文件处理：逐行处理文件，不加载整个文件到内存",
                "数据库查询：延迟处理查询结果",
                "无限序列：生成和处理无限序列",
                "性能优化：对于只需要少量结果的操作，使用Sequence提高性能"
            ),
            keyPoints = listOf(
                "Sequence是延迟计算的集合，只在需要时才计算",
                "Sequence不创建中间集合，节省内存",
                "Sequence只处理必要的元素，可以提高性能",
                "终端操作（如toList、sum）会触发计算",
                "Sequence可以处理无限序列"
            ),
            notes = listOf(
                "Sequence操作符延迟计算，终端操作触发计算",
                "对于小数据集，List可能更快（没有Sequence的开销）",
                "对于大数据集或只需要少量结果，Sequence更快",
                "Sequence可以处理无限序列",
                "使用asSequence将集合转换为Sequence"
            ),
            practiceTips = "建议：对于大数据集或只需要少量结果的操作，使用Sequence提高性能。对于小数据集，List可能更快。使用Sequence处理文件、数据库查询等场景。注意Sequence是延迟计算的，终端操作才会触发计算。"
        ),
        
        // ========== Kotlin 空安全（Null Safety） ==========
        
        // 1. 可空类型声明、安全调用操作符、Elvis操作符
        KnowledgeDetail(
            id = "nullable_types",
            title = "可空类型声明、安全调用操作符、Elvis操作符",
            overview = "Kotlin的空安全机制是编译时的空指针保护。理解可空类型、安全调用操作符、Elvis操作符等是掌握Kotlin空安全的关键。",
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：可空类型声明",
                    code = """
                        // Kotlin中类型默认是非空的
                        
                        // 1. 非空类型（默认）
                        var name: String = "Hello"
                        // name = null  // ❌ 编译错误！非空类型不能为null
                        
                        // 2. 可空类型（使用?）
                        var nullableName: String? = "Hello"
                        nullableName = null  // ✅ 可以
                        
                        // 3. 可空类型必须显式声明
                        var age: Int? = null
                        var price: Double? = null
                        var isActive: Boolean? = null
                        
                        // 4. 可空类型的使用限制
                        var text: String? = "Hello"
                        // val length = text.length  // ❌ 错误！可空类型不能直接调用方法
                        
                        // 5. 类型推断
                        val inferred = null  // 推断为Nothing?
                        val inferred2: String? = null  // 显式声明为String?
                    """.trimIndent(),
                    explanation = "Kotlin中类型默认是非空的，不能为null。使用?声明可空类型，可空类型可以赋值为null。可空类型不能直接调用方法。"
                ),
                CodeExample(
                    title = "示例2：安全调用操作符（?.）",
                    code = """
                        // 安全调用操作符：如果对象为null，返回null而不是抛出异常
                        
                        var name: String? = "Hello"
                        
                        // 1. 安全调用
                        val length = name?.length  // Int?类型
                        println(length)  // 5
                        
                        name = null
                        val length2 = name?.length  // null，不会抛出异常
                        println(length2)  // null
                        
                        // 2. 安全调用链
                        class Address(val street: String?)
                        class Person(val address: Address?)
                        
                        val person: Person? = Person(Address("Main St"))
                        val street = person?.address?.street  // String?
                        println(street)  // "Main St"
                        
                        val person2: Person? = null
                        val street2 = person2?.address?.street  // null，不会抛出异常
                        
                        // 3. 安全调用与let
                        name?.let {
                            println("Name is ${'$'}it")  // 只在name不为null时执行
                        }
                        
                        // 4. 安全调用与also
                        name?.also {
                            println("Processing: ${'$'}it")
                        }
                    """.trimIndent(),
                    explanation = "安全调用操作符?.在对象为null时返回null而不是抛出异常。可以链式调用，形成安全调用链。可以与let、also等作用域函数结合使用。"
                ),
                CodeExample(
                    title = "示例3：Elvis操作符（?:）",
                    code = """
                        // Elvis操作符：如果左侧为null，返回右侧的值
                        
                        // 1. 基本用法
                        val name: String? = null
                        val displayName = name ?: "Unknown"  // "Unknown"
                        
                        val name2: String? = "Alice"
                        val displayName2 = name2 ?: "Unknown"  // "Alice"
                        
                        // 2. 链式使用
                        val person: Person? = null
                        val street = person?.address?.street ?: "No address"
                        
                        // 3. 抛出异常
                        val name3: String? = null
                        val required = name3 ?: throw IllegalArgumentException("Name is required")
                        
                        // 4. 返回
                        fun getName(): String {
                            val name: String? = getNullableName()
                            return name ?: return "Default"
                        }
                        
                        // 5. 复杂表达式
                        val result = nullableValue?.process() ?: defaultValue
                        val length = text?.length ?: 0
                    """.trimIndent(),
                    explanation = "Elvis操作符?:在左侧为null时返回右侧的值。可以用于提供默认值、抛出异常、返回等场景。"
                ),
                CodeExample(
                    title = "示例4：非空断言操作符（!!）",
                    code = """
                        // 非空断言：强制认为值不为null，如果为null会抛出异常
                        
                        // 1. 基本用法
                        val name: String? = "Hello"
                        val length = name!!.length  // ✅ 可以，name不为null
                        
                        val name2: String? = null
                        // val length2 = name2!!.length  // ❌ 运行时抛出KotlinNullPointerException
                        
                        // 2. 使用场景（谨慎使用）
                        // 只有在确定值不为null时才使用!!
                        fun processName(name: String?) {
                            if (name != null) {
                                val length = name!!.length  // 可以使用，但不推荐
                                // 更好的方式：使用智能转换
                                val length2 = name.length  // 智能转换，不需要!!
                            }
                        }
                        
                        // 3. 智能转换
                        fun processName2(name: String?) {
                            if (name != null) {
                                // 在if块内，name自动转换为非空类型
                                val length = name.length  // ✅ 不需要!!
                            }
                        }
                        
                        // 4. 避免使用!!
                        // 优先使用安全调用和Elvis操作符
                        val length = name?.length ?: 0  // ✅ 推荐
                        // val length = name!!.length  // ❌ 不推荐
                    """.trimIndent(),
                    explanation = "非空断言操作符!!强制认为值不为null，如果为null会抛出异常。应该谨慎使用，优先使用安全调用和Elvis操作符。Kotlin的智能转换可以自动转换类型。"
                ),
                CodeExample(
                    title = "示例5：空安全操作符组合",
                    code = """
                        // 1. 安全调用 + Elvis
                        val person: Person? = null
                        val street = person?.address?.street ?: "Unknown"
                        
                        // 2. 安全调用 + let
                        val name: String? = "Alice"
                        name?.let {
                            println("Name: ${'$'}it")
                            processName(it)  // it是非空的
                        }
                        
                        // 3. 多个可空值处理
                        val name: String? = "Alice"
                        val age: Int? = 25
                        
                        if (name != null && age != null) {
                            // 在if块内，name和age都是非空的
                            println("${'$'}name is ${'$'}age years old")
                        }
                        
                        // 4. 使用when处理可空值
                        val value: String? = getValue()
                        when (value) {
                            null -> println("Value is null")
                            else -> println("Value is ${'$'}value")
                        }
                        
                        // 5. 可空类型与集合
                        val list: List<String?> = listOf("a", null, "b", null, "c")
                        val nonNull = list.filterNotNull()  // [a, b, c]
                        val lengths = list.mapNotNull { it?.length }  // [1, 1, 1]
                    """.trimIndent(),
                    explanation = "可以组合使用安全调用、Elvis操作符、let等处理可空值。Kotlin的智能转换可以在条件检查后自动转换类型。集合操作符可以处理可空类型。"
                )
            ),
            useCases = listOf(
                "API响应处理：使用可空类型处理可能缺失的数据字段",
                "默认值：使用Elvis操作符提供默认值",
                "条件执行：使用安全调用和let在值不为null时执行代码",
                "数据验证：使用可空类型表示可选或未初始化的数据",
                "链式调用：使用安全调用链处理嵌套的可空对象"
            ),
            keyPoints = listOf(
                "Kotlin中类型默认是非空的，使用?声明可空类型",
                "安全调用操作符?.在对象为null时返回null",
                "Elvis操作符?:在左侧为null时返回右侧的值",
                "非空断言!!强制认为值不为null，应该谨慎使用",
                "Kotlin的智能转换可以自动转换类型"
            ),
            notes = listOf(
                "可空类型不能直接调用方法，需要使用安全调用",
                "安全调用可以链式调用，形成安全调用链",
                "Elvis操作符可以用于提供默认值、抛出异常等",
                "非空断言!!如果值为null会抛出异常",
                "优先使用安全调用和Elvis操作符，避免使用非空断言"
            ),
            practiceTips = "建议：优先使用安全调用操作符和Elvis操作符处理可空值，避免使用非空断言。利用Kotlin的智能转换自动转换类型。在API响应处理中，使用可空类型表示可能缺失的字段。"
        ),
        
        // 2. 空安全实践、平台类型处理
        KnowledgeDetail(
            id = "null_safety_practice",
            title = "空安全实践、平台类型处理",
            overview = "在实际开发中，正确处理可空类型和平台类型是编写健壮代码的关键。理解空安全的最佳实践和平台类型处理有助于编写更安全的代码。",
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：空安全最佳实践",
                    code = """
                        // 1. 优先使用不可空类型
                        fun processName(name: String) {  // 非空类型
                            println(name.length)
                        }
                        
                        // 2. 只在确实需要时才使用可空类型
                        fun findUser(id: String): User? {  // 可能找不到，返回可空
                            return users.find { it.id == id }
                        }
                        
                        // 3. 使用安全调用和Elvis操作符
                        val user = findUser("123")
                        val name = user?.name ?: "Unknown"
                        
                        // 4. 使用let处理可空值
                        user?.let {
                            println("User: ${'$'}{it.name}")
                            processUser(it)
                        }
                        
                        // 5. 使用when处理可空值
                        when (val user = findUser("123")) {
                            null -> println("User not found")
                            else -> println("User: ${'$'}{user.name}")
                        }
                        
                        // 6. 避免使用非空断言
                        // val name = user!!.name  // ❌ 不推荐
                        val name = user?.name ?: "Unknown"  // ✅ 推荐
                    """.trimIndent(),
                    explanation = "空安全最佳实践包括：优先使用不可空类型、使用安全调用和Elvis操作符、使用let和when处理可空值、避免使用非空断言。"
                ),
                CodeExample(
                    title = "示例2：平台类型（Platform Types）",
                    code = """
                        // 平台类型：从Java代码返回的类型，Kotlin不知道是否可空
                        
                        // 1. Java方法返回平台类型
                        // Java代码：
                        // public String getName() { return name; }
                        // 
                        // Kotlin中调用：
                        // val name = javaObject.getName()  // 平台类型String!
                        // name.length  // ⚠️ 可能抛出NullPointerException
                        
                        // 2. 处理平台类型
                        // 方式1：显式声明类型
                        // val name: String? = javaObject.getName()  // 声明为可空
                        // val length = name?.length ?: 0
                        
                        // 方式2：使用Elvis操作符
                        // val name = javaObject.getName() ?: "Default"
                        
                        // 方式3：使用非空断言（如果确定不为null）
                        // val name = javaObject.getName()!!
                        
                        // 3. Android中的平台类型
                        // findViewById返回平台类型
                        // val textView = findViewById<TextView>(R.id.textView)  // TextView!
                        // textView?.text = "Hello"  // 使用安全调用
                        
                        // 4. 注解平台类型
                        // 在Java代码中使用@Nullable和@NonNull注解
                        // @Nullable
                        // public String getName() { ... }
                        // 
                        // Kotlin会识别注解：
                        // val name: String? = javaObject.getName()  // 自动识别为可空
                        
                        // @NonNull
                        // public String getRequiredName() { ... }
                        // 
                        // val name: String = javaObject.getRequiredName()  // 自动识别为非空
                    """.trimIndent(),
                    explanation = "平台类型是从Java代码返回的类型，Kotlin不知道是否可空。应该显式声明类型或使用注解。Android的findViewById返回平台类型，需要使用安全调用。"
                ),
                CodeExample(
                    title = "示例3：空安全在Android中的应用",
                    code = """
                        // 1. View的findViewById
                        // val textView = findViewById<TextView>(R.id.textView)  // TextView!
                        // textView?.text = "Hello"  // 使用安全调用
                        // 
                        // 或者使用ViewBinding
                        // binding.textView.text = "Hello"  // 非空类型
                        
                        // 2. 数据类中的可空字段
                        data class User(
                            val id: String,
                            val name: String,
                            val email: String?  // 可空，可能没有邮箱
                        )
                        
                        val user = User("1", "Alice", null)
                        val displayEmail = user.email ?: "No email"
                        
                        // 3. API响应处理
                        data class ApiResponse(
                            val success: Boolean,
                            val data: UserData?,
                            val error: String?
                        )
                        
                        fun handleResponse(response: ApiResponse) {
                            when {
                                response.success && response.data != null -> {
                                    processData(response.data)
                                }
                                response.error != null -> {
                                    showError(response.error)
                                }
                                else -> {
                                    showError("Unknown error")
                                }
                            }
                        }
                        
                        // 4. 数据库查询
                        // @Query("SELECT * FROM users WHERE id = :id")
                        // suspend fun getUserById(id: String): User?  // 可能找不到
                        
                        // val user = getUserById("123")
                        // user?.let {
                        //     displayUser(it)
                        // } ?: showNotFound()
                    """.trimIndent(),
                    explanation = "在Android开发中，空安全用于处理findViewById、数据类字段、API响应、数据库查询等场景。合理使用可空类型可以提高代码的健壮性。"
                ),
                CodeExample(
                    title = "示例4：空安全工具函数",
                    code = """
                        // 1. 扩展函数处理可空值
                        fun String?.orEmpty(): String {
                            return this ?: ""
                        }
                        
                        val nullable: String? = null
                        val result = nullable.orEmpty()  // ""
                        
                        // 2. 扩展函数检查可空
                        fun String?.isNullOrBlank(): Boolean {
                            return this == null || this.isBlank()
                        }
                        
                        val text: String? = null
                        if (text.isNullOrBlank()) {
                            println("Text is null or blank")
                        }
                        
                        // 3. 安全转换
                        fun <T> safeCast(value: Any?): T? {
                            return value as? T
                        }
                        
                        val obj: Any? = "Hello"
                        val str: String? = safeCast<String>(obj)
                        
                        // 4. 可空集合处理
                        fun <T> List<T?>.filterNotNull(): List<T> {
                            return this.filterNotNull()
                        }
                        
                        val list = listOf(1, null, 2, null, 3)
                        val nonNull = list.filterNotNull()  // [1, 2, 3]
                        
                        // 5. 可空值验证
                        fun <T> T?.requireNotNull(): T {
                            return this ?: throw IllegalArgumentException("Value is null")
                        }
                        
                        val value: String? = "Hello"
                        val nonNullValue = value.requireNotNull()  // "Hello"
                    """.trimIndent(),
                    explanation = "可以创建扩展函数和工具函数处理可空值，如orEmpty、isNullOrBlank、safeCast等。这些函数可以简化可空值的处理。"
                ),
                CodeExample(
                    title = "示例5：空安全实践总结",
                    code = """
                        // 1. 设计API时考虑空安全
                        // 返回可空类型表示可能不存在
                        fun findUser(id: String): User? {
                            return users.find { it.id == id }
                        }
                        
                        // 返回非空类型表示一定存在
                        fun getUser(id: String): User {
                            return users.find { it.id == id } 
                                ?: throw IllegalArgumentException("User not found")
                        }
                        
                        // 2. 处理集合中的可空值
                        val list: List<String?> = listOf("a", null, "b")
                        val nonNull = list.filterNotNull()  // [a, b]
                        val lengths = list.mapNotNull { it?.length }  // [1, 1]
                        
                        // 3. 链式安全调用
                        val person: Person? = null
                        val street = person?.address?.street?.uppercase() ?: "Unknown"
                        
                        // 4. 使用let简化代码
                        person?.let {
                            println("Name: ${'$'}{it.name}")
                            println("Age: ${'$'}{it.age}")
                        }
                        
                        // 5. 使用when处理可空值
                        when (val user = findUser("123")) {
                            null -> handleNotFound()
                            else -> handleUser(user)
                        }
                        
                        // 6. 避免常见的空安全错误
                        // ❌ 错误：使用非空断言
                        // val name = user!!.name
                        
                        // ✅ 正确：使用安全调用和Elvis
                        // val name = user?.name ?: "Unknown"
                    """.trimIndent(),
                    explanation = "空安全实践总结：设计API时考虑空安全、处理集合中的可空值、使用链式安全调用、使用let和when简化代码、避免使用非空断言。"
                )
            ),
            useCases = listOf(
                "API设计：使用可空类型表示可能不存在的数据",
                "Android开发：处理findViewById、数据绑定等平台类型",
                "数据验证：使用可空类型表示可选或未初始化的数据",
                "错误处理：使用可空类型和Elvis操作符处理错误情况",
                "代码简化：使用let、when等简化可空值处理"
            ),
            keyPoints = listOf(
                "优先使用不可空类型，只在确实需要时使用可空类型",
                "平台类型是从Java返回的类型，需要显式处理",
                "使用安全调用和Elvis操作符处理可空值",
                "使用let、when等简化可空值处理",
                "避免使用非空断言，优先使用安全的方式"
            ),
            notes = listOf(
                "平台类型在Kotlin中显示为String!，需要显式处理",
                "可以使用@Nullable和@NonNull注解帮助Kotlin识别类型",
                "Android的findViewById返回平台类型，需要使用安全调用",
                "集合操作符可以处理可空类型（filterNotNull、mapNotNull）",
                "合理使用可空类型可以提高代码的健壮性"
            ),
            practiceTips = "建议：优先使用不可空类型，只在确实需要时使用可空类型。处理平台类型时显式声明类型或使用注解。在Android开发中，使用ViewBinding可以避免findViewById的平台类型问题。合理使用安全调用、Elvis操作符、let、when等处理可空值。"
        )
    )
}






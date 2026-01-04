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
        )
    )
}






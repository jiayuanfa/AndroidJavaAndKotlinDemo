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
        ),
        
        // ========== Kotlin 数据类和密封类 ==========
        
        // 1. 数据类（data class）、解构声明
        KnowledgeDetail(
            id = "data_class",
            title = "数据类（data class）、解构声明",
            overview = "数据类是Kotlin的特殊类，自动生成equals、hashCode、toString等方法。解构声明可以将对象解构为多个变量。理解数据类和解构声明是掌握Kotlin数据建模的关键。",
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：数据类基础",
                    code = """
                        // 数据类：使用data关键字声明
                        
                        data class Person(val name: String, val age: Int)
                        
                        // 数据类自动生成：
                        // 1. equals()和hashCode()
                        val person1 = Person("Alice", 25)
                        val person2 = Person("Alice", 25)
                        println(person1 == person2)  // true
                        
                        // 2. toString()
                        println(person1)  // Person(name=Alice, age=25)
                        
                        // 3. copy()方法
                        val person3 = person1.copy(age = 26)
                        println(person3)  // Person(name=Alice, age=26)
                        
                        // 4. componentN()方法（用于解构）
                        val (name, age) = person1
                        println("${'$'}name is ${'$'}age years old")  // "Alice is 25 years old"
                    """.trimIndent(),
                    explanation = "数据类使用data关键字声明，自动生成equals、hashCode、toString、copy和componentN方法。数据类主要用于存储数据。"
                ),
                CodeExample(
                    title = "示例2：数据类的限制和要求",
                    code = """
                        // 1. 数据类的要求
                        // - 主构造函数至少有一个参数
                        // - 主构造函数的参数必须使用val或var
                        // - 数据类不能是abstract、open、sealed或inner
                        
                        // ✅ 正确
                        data class User(val id: String, val name: String)
                        
                        // ❌ 错误：没有参数
                        // data class Empty()
                        
                        // ❌ 错误：参数没有val/var
                        // data class Bad(name: String)
                        
                        // 2. 数据类可以继承其他类
                        open class Base
                        data class Derived(val x: Int) : Base()
                        
                        // 3. 数据类可以实现接口
                        interface Serializable
                        data class Data(val value: String) : Serializable
                        
                        // 4. 数据类可以有默认参数
                        data class Person(
                            val name: String,
                            val age: Int = 0,
                            val email: String = ""
                        )
                        
                        val person = Person("Alice")  // age=0, email=""
                    """.trimIndent(),
                    explanation = "数据类有特定要求：主构造函数至少有一个参数，参数必须使用val或var，不能是abstract、open、sealed或inner。数据类可以继承类和实现接口。"
                ),
                CodeExample(
                    title = "示例3：copy方法",
                    code = """
                        // copy方法：创建数据类的副本，可以修改部分属性
                        
                        data class Person(val name: String, val age: Int, val city: String)
                        
                        val person1 = Person("Alice", 25, "Beijing")
                        
                        // 1. 完全复制
                        val person2 = person1.copy()
                        println(person1 == person2)  // true
                        
                        // 2. 修改部分属性
                        val person3 = person1.copy(age = 26)
                        println(person3)  // Person(name=Alice, age=26, city=Beijing)
                        
                        // 3. 修改多个属性
                        val person4 = person1.copy(age = 30, city = "Shanghai")
                        println(person4)  // Person(name=Alice, age=30, city=Shanghai)
                        
                        // 4. copy方法的使用场景
                        // 不可变数据：创建修改后的副本
                        fun updateAge(person: Person, newAge: Int): Person {
                            return person.copy(age = newAge)
                        }
                        
                        val updated = updateAge(person1, 26)
                        println(updated)  // Person(name=Alice, age=26, city=Beijing)
                    """.trimIndent(),
                    explanation = "copy方法用于创建数据类的副本，可以修改部分属性。copy方法支持不可变数据模式，创建修改后的新对象而不是修改原对象。"
                ),
                CodeExample(
                    title = "示例4：解构声明",
                    code = """
                        // 解构声明：将对象解构为多个变量
                        
                        data class Person(val name: String, val age: Int, val city: String)
                        
                        val person = Person("Alice", 25, "Beijing")
                        
                        // 1. 基本解构
                        val (name, age, city) = person
                        println("${'$'}name, ${'$'}age, ${'$'}city")  // "Alice, 25, Beijing"
                        
                        // 2. 部分解构（使用_跳过不需要的值）
                        val (name2, _, city2) = person
                        println("${'$'}name2 in ${'$'}city2")  // "Alice in Beijing"
                        
                        // 3. 在循环中使用解构
                        val people = listOf(
                            Person("Alice", 25, "Beijing"),
                            Person("Bob", 30, "Shanghai")
                        )
                        
                        for ((name, age, city) in people) {
                            println("${'$'}name (${'$'}age) from ${'$'}city")
                        }
                        
                        // 4. Map的解构
                        val map = mapOf("name" to "Alice", "age" to 25)
                        for ((key, value) in map) {
                            println("${'$'}key: ${'$'}value")
                        }
                        
                        // 5. 函数返回多个值
                        data class Result(val success: Boolean, val data: String)
                        
                        fun process(): Result {
                            return Result(true, "Data")
                        }
                        
                        val (success, data) = process()
                        if (success) {
                            println(data)
                        }
                    """.trimIndent(),
                    explanation = "解构声明可以将对象解构为多个变量。数据类自动生成componentN方法支持解构。可以使用_跳过不需要的值。解构在循环、Map遍历、函数返回多个值等场景中很有用。"
                ),
                CodeExample(
                    title = "示例5：数据类实践",
                    code = """
                        // 1. API响应数据类
                        data class ApiResponse<T>(
                            val success: Boolean,
                            val data: T?,
                            val error: String?
                        )
                        
                        // 2. UI状态数据类
                        data class UiState(
                            val isLoading: Boolean = false,
                            val data: String? = null,
                            val error: String? = null
                        )
                        
                        // 3. 使用copy更新状态
                        fun updateState(
                            currentState: UiState,
                            isLoading: Boolean? = null,
                            data: String? = null,
                            error: String? = null
                        ): UiState {
                            return currentState.copy(
                                isLoading = isLoading ?: currentState.isLoading,
                                data = data ?: currentState.data,
                                error = error ?: currentState.error
                            )
                        }
                        
                        // 4. 数据类与集合
                        data class User(val id: String, val name: String)
                        val users = listOf(
                            User("1", "Alice"),
                            User("2", "Bob")
                        )
                        
                        // 使用解构
                        users.forEach { (id, name) ->
                            println("${'$'}id: ${'$'}name")
                        }
                        
                        // 5. 嵌套数据类
                        data class Address(val street: String, val city: String)
                        data class Person(val name: String, val address: Address)
                        
                        val person = Person("Alice", Address("Main St", "Beijing"))
                        val (name, address) = person
                        val (street, city) = address
                        println("${'$'}name lives at ${'$'}street, ${'$'}city")
                    """.trimIndent(),
                    explanation = "数据类在实际开发中用于API响应、UI状态、数据模型等。使用copy方法更新状态，使用解构简化代码。数据类支持嵌套，可以解构嵌套的数据类。"
                )
            ),
            useCases = listOf(
                "数据模型：使用数据类表示数据模型",
                "API响应：使用数据类表示API响应",
                "UI状态：使用数据类表示UI状态",
                "不可变数据：使用copy方法创建修改后的副本",
                "代码简化：使用解构声明简化代码"
            ),
            keyPoints = listOf(
                "数据类使用data关键字声明，自动生成equals、hashCode、toString、copy等方法",
                "数据类主构造函数至少有一个参数，参数必须使用val或var",
                "copy方法用于创建数据类的副本，可以修改部分属性",
                "解构声明可以将对象解构为多个变量",
                "数据类支持嵌套，可以解构嵌套的数据类"
            ),
            notes = listOf(
                "数据类不能是abstract、open、sealed或inner",
                "数据类可以继承类和实现接口",
                "copy方法支持不可变数据模式",
                "解构声明使用componentN方法",
                "可以使用_跳过不需要的值"
            ),
            practiceTips = "建议：使用数据类表示数据模型、API响应、UI状态等。使用copy方法更新状态，实现不可变数据模式。使用解构声明简化代码，特别是在循环和函数返回多个值时。"
        ),
        
        // 2. 密封类（sealed class）、密封接口
        KnowledgeDetail(
            id = "sealed_class",
            title = "密封类（sealed class）、密封接口",
            overview = "密封类是受限的类层次结构，所有子类必须在同一文件中声明。密封类用于表示受限的类继承，常用于表示状态、结果等。",
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：密封类基础",
                    code = """
                        // 密封类：使用sealed关键字声明
                        
                        sealed class Result<out T> {
                            data class Success<T>(val data: T) : Result<T>()
                            data class Error(val message: String) : Result<Nothing>()
                            object Loading : Result<Nothing>()
                        }
                        
                        // 1. 密封类的特点
                        // - 所有子类必须在同一文件中声明
                        // - 密封类本身是抽象的，不能实例化
                        // - 子类可以是数据类、普通类、对象等
                        
                        // 2. 使用when表达式处理密封类
                        fun handleResult(result: Result<String>) {
                            when (result) {
                                is Result.Success -> println("Success: ${'$'}{result.data}")
                                is Result.Error -> println("Error: ${'$'}{result.message}")
                                is Result.Loading -> println("Loading...")
                                // 不需要else，因为所有情况都已覆盖
                            }
                        }
                        
                        // 3. when作为表达式
                        val message = when (result) {
                            is Result.Success -> "Success: ${'$'}{result.data}"
                            is Result.Error -> "Error: ${'$'}{result.message}"
                            is Result.Loading -> "Loading..."
                        }
                    """.trimIndent(),
                    explanation = "密封类使用sealed关键字声明，所有子类必须在同一文件中声明。密封类本身是抽象的，不能实例化。使用when表达式处理密封类时，不需要else分支。"
                ),
                CodeExample(
                    title = "示例2：密封类表示状态",
                    code = """
                        // 密封类常用于表示状态
                        
                        sealed class UiState {
                            object Idle : UiState()
                            object Loading : UiState()
                            data class Success(val data: String) : UiState()
                            data class Error(val message: String) : UiState()
                        }
                        
                        class ViewModel {
                            private var state: UiState = UiState.Idle
                            
                            fun loadData() {
                                state = UiState.Loading
                                // 加载数据
                                state = UiState.Success("Data loaded")
                            }
                            
                            fun handleState() {
                                when (state) {
                                    is UiState.Idle -> showIdle()
                                    is UiState.Loading -> showLoading()
                                    is UiState.Success -> showData(state.data)
                                    is UiState.Error -> showError(state.message)
                                }
                            }
                        }
                        
                        // 网络请求状态
                        sealed class NetworkState {
                            object Idle : NetworkState()
                            object Loading : NetworkState()
                            data class Success<T>(val data: T) : NetworkState()
                            data class Error(val exception: Throwable) : NetworkState()
                        }
                    """.trimIndent(),
                    explanation = "密封类常用于表示状态，如UI状态、网络请求状态等。使用when表达式处理状态，代码更清晰、更安全。"
                ),
                CodeExample(
                    title = "示例3：密封类表示结果",
                    code = """
                        // 密封类用于表示操作结果
                        
                        sealed class Result<out T> {
                            data class Success<T>(val data: T) : Result<T>()
                            data class Failure(val error: Throwable) : Result<Nothing>()
                        }
                        
                        fun fetchData(): Result<String> {
                            return try {
                                val data = apiService.getData()
                                Result.Success(data)
                            } catch (e: Exception) {
                                Result.Failure(e)
                            }
                        }
                        
                        fun handleResult(result: Result<String>) {
                            when (result) {
                                is Result.Success -> {
                                    println("Data: ${'$'}{result.data}")
                                }
                                is Result.Failure -> {
                                    println("Error: ${'$'}{result.error.message}")
                                }
                            }
                        }
                        
                        // 使用
                        val result = fetchData()
                        handleResult(result)
                        
                        // 扩展函数处理Result
                        fun <T> Result<T>.onSuccess(action: (T) -> Unit): Result<T> {
                            if (this is Result.Success) {
                                action(this.data)
                            }
                            return this
                        }
                        
                        fun <T> Result<T>.onFailure(action: (Throwable) -> Unit): Result<T> {
                            if (this is Result.Failure) {
                                action(this.error)
                            }
                            return this
                        }
                        
                        result.onSuccess { data ->
                            println("Success: ${'$'}data")
                        }.onFailure { error ->
                            println("Error: ${'$'}error")
                        }
                    """.trimIndent(),
                    explanation = "密封类用于表示操作结果，如API请求结果、数据库操作结果等。使用密封类可以避免使用异常或null表示错误，代码更清晰。"
                ),
                CodeExample(
                    title = "示例4：密封接口",
                    code = """
                        // 密封接口：Kotlin 1.5+支持
                        
                        sealed interface Animal {
                            val name: String
                        }
                        
                        data class Dog(override val name: String, val breed: String) : Animal
                        data class Cat(override val name: String, val color: String) : Animal
                        data class Bird(override val name: String, val canFly: Boolean) : Animal
                        
                        fun makeSound(animal: Animal) {
                            when (animal) {
                                is Dog -> println("${'$'}{animal.name} barks")
                                is Cat -> println("${'$'}{animal.name} meows")
                                is Bird -> println("${'$'}{animal.name} chirps")
                            }
                        }
                        
                        // 密封接口的优势
                        // 1. 可以实现多个密封接口
                        sealed interface Flyable {
                            fun fly()
                        }
                        
                        sealed interface Swimmable {
                            fun swim()
                        }
                        
                        data class Duck(
                            override val name: String
                        ) : Animal, Flyable, Swimmable {
                            override fun fly() {
                                println("${'$'}name is flying")
                            }
                            
                            override fun swim() {
                                println("${'$'}name is swimming")
                            }
                        }
                    """.trimIndent(),
                    explanation = "密封接口类似于密封类，但可以用于接口。密封接口允许实现多个接口，提供更灵活的类层次结构。"
                ),
                CodeExample(
                    title = "示例5：密封类实践",
                    code = """
                        // 1. 表达式树
                        sealed class Expr {
                            data class Number(val value: Int) : Expr()
                            data class Sum(val left: Expr, val right: Expr) : Expr()
                            data class Product(val left: Expr, val right: Expr) : Expr()
                        }
                        
                        fun eval(expr: Expr): Int = when (expr) {
                            is Expr.Number -> expr.value
                            is Expr.Sum -> eval(expr.left) + eval(expr.right)
                            is Expr.Product -> eval(expr.left) * eval(expr.right)
                        }
                        
                        // 2. 命令模式
                        sealed class Command {
                            object Start : Command()
                            object Stop : Command()
                            data class Update(val value: Int) : Command()
                        }
                        
                        fun execute(command: Command) {
                            when (command) {
                                is Command.Start -> start()
                                is Command.Stop -> stop()
                                is Command.Update -> update(command.value)
                            }
                        }
                        
                        // 3. 事件处理
                        sealed class Event {
                            data class UserLogin(val userId: String) : Event()
                            data class UserLogout(val userId: String) : Event()
                            object AppStart : Event()
                            object AppStop : Event()
                        }
                        
                        fun handleEvent(event: Event) {
                            when (event) {
                                is Event.UserLogin -> onUserLogin(event.userId)
                                is Event.UserLogout -> onUserLogout(event.userId)
                                is Event.AppStart -> onAppStart()
                                is Event.AppStop -> onAppStop()
                            }
                        }
                        
                        // 4. 在Android中使用
                        sealed class ViewState {
                            object Loading : ViewState()
                            data class Success(val items: List<Item>) : ViewState()
                            data class Error(val message: String) : ViewState()
                        }
                        
                        // ViewModel中
                        private val _state = MutableStateFlow<ViewState>(ViewState.Loading)
                        val state: StateFlow<ViewState> = _state.asStateFlow()
                        
                        // UI中
                        viewModel.state.collect { state ->
                            when (state) {
                                is ViewState.Loading -> showLoading()
                                is ViewState.Success -> showItems(state.items)
                                is ViewState.Error -> showError(state.message)
                            }
                        }
                    """.trimIndent(),
                    explanation = "密封类在实际开发中用于表达式树、命令模式、事件处理、UI状态等场景。密封类配合when表达式可以创建类型安全、易于维护的代码。"
                )
            ),
            useCases = listOf(
                "状态管理：使用密封类表示UI状态、网络状态等",
                "结果处理：使用密封类表示操作结果，避免使用异常或null",
                "表达式树：使用密封类表示表达式树等数据结构",
                "命令模式：使用密封类实现命令模式",
                "事件处理：使用密封类表示事件类型"
            ),
            keyPoints = listOf(
                "密封类使用sealed关键字声明，所有子类必须在同一文件中声明",
                "密封类本身是抽象的，不能实例化",
                "使用when表达式处理密封类时，不需要else分支",
                "密封类常用于表示状态、结果、表达式等",
                "密封接口类似于密封类，但可以用于接口"
            ),
            notes = listOf(
                "密封类的所有子类必须在同一文件中声明",
                "密封类配合when表达式可以创建类型安全的代码",
                "密封类常用于表示受限的类继承",
                "密封接口允许实现多个接口",
                "在Android开发中，密封类常用于表示UI状态"
            ),
            practiceTips = "建议：使用密封类表示状态、结果、事件等受限的类层次结构。密封类配合when表达式可以创建类型安全、易于维护的代码。在Android开发中，使用密封类表示UI状态可以简化状态管理。"
        ),
        
        // ========== Kotlin 作用域函数 ==========
        
        // 1. let、run、with、apply、also的使用和选择
        KnowledgeDetail(
            id = "scope_functions",
            title = "let、run、with、apply、also的使用和选择",
            overview = "Kotlin提供了5个作用域函数：let、run、with、apply、also。这些函数在对象的上下文中执行代码块，让代码更简洁。理解每个函数的特点和适用场景是掌握作用域函数的关键。",
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：let函数",
                    code = """
                        // let：将对象作为lambda参数，返回lambda结果
                        // 使用场景：空安全调用、转换对象
                        
                        // 1. 空安全调用
                        val name: String? = "Hello"
                        name?.let {
                            println(it.length)  // it是name
                            println(it.uppercase())
                        }
                        
                        // 2. 转换对象
                        val number: Int? = 5
                        val doubled = number?.let { it * 2 }  // 10
                        
                        // 3. 链式调用
                        val result = "Hello"
                            .let { it.uppercase() }
                            .let { it + " World" }
                            .let { it.length }
                        println(result)  // 12
                        
                        // 4. 避免变量名冲突
                        val outer = "Outer"
                        "Inner".let { inner ->
                            println("${'$'}outer and ${'$'}inner")  // 可以使用outer
                        }
                        
                        // 5. 处理可空值
                        val nullable: String? = null
                        nullable?.let {
                            // 只在不为null时执行
                            process(it)
                        }
                    """.trimIndent(),
                    explanation = "let函数将对象作为lambda参数（it），返回lambda结果。常用于空安全调用、转换对象、避免变量名冲突等场景。"
                ),
                CodeExample(
                    title = "示例2：run函数",
                    code = """
                        // run：在对象上下文中执行代码块，返回lambda结果
                        // 使用场景：对象配置和计算、执行表达式
                        
                        // 1. 扩展函数形式
                        val result = "Hello".run {
                            println(this)  // this是"Hello"
                            this.length * 2
                        }
                        println(result)  // 10
                        
                        // 2. 非扩展函数形式（在对象上下文中执行）
                        val person = Person("Alice", 25)
                        val info = run {
                            val name = person.name
                            val age = person.age
                            "${'$'}name is ${'$'}age years old"
                        }
                        println(info)  // "Alice is 25 years old"
                        
                        // 3. 对象配置
                        val person2 = Person("Bob", 30).run {
                            // 在person2的上下文中执行
                            println("Name: ${'$'}{this.name}")
                            this  // 返回person2
                        }
                        
                        // 4. 计算表达式
                        val sum = run {
                            val a = 10
                            val b = 20
                            a + b
                        }
                        println(sum)  // 30
                    """.trimIndent(),
                    explanation = "run函数在对象上下文中执行代码块，返回lambda结果。扩展函数形式使用this，非扩展函数形式在对象上下文中执行。常用于对象配置和计算。"
                ),
                CodeExample(
                    title = "示例3：with函数",
                    code = """
                        // with：在对象上下文中执行代码块，返回lambda结果
                        // 使用场景：对同一个对象执行多个操作
                        
                        class Person(var name: String, var age: Int)
                        
                        val person = Person("Alice", 25)
                        
                        // 1. 基本使用
                        val result = with(person) {
                            println("Name: ${'$'}name")  // 可以直接访问属性
                            println("Age: ${'$'}age")
                            "${'$'}name is ${'$'}age years old"  // 返回结果
                        }
                        println(result)  // "Alice is 25 years old"
                        
                        // 2. 修改对象
                        with(person) {
                            name = "Bob"  // 直接修改
                            age = 30
                        }
                        println(person.name)  // "Bob"
                        
                        // 3. 对同一个对象执行多个操作
                        val stringBuilder = StringBuilder()
                        with(stringBuilder) {
                            append("Hello")
                            append(" ")
                            append("World")
                        }
                        println(stringBuilder.toString())  // "Hello World"
                        
                        // 4. 与apply的区别
                        // with返回lambda结果，apply返回对象本身
                        val result1 = with(person) { name }  // String
                        val result2 = person.apply { name = "Charlie" }  // Person
                    """.trimIndent(),
                    explanation = "with函数在对象上下文中执行代码块，返回lambda结果。可以直接访问对象的属性和方法。常用于对同一个对象执行多个操作。"
                ),
                CodeExample(
                    title = "示例4：apply函数",
                    code = """
                        // apply：在对象上下文中执行代码块，返回对象本身
                        // 使用场景：对象初始化、配置对象
                        
                        class Person(var name: String, var age: Int)
                        
                        // 1. 对象初始化
                        val person = Person("Alice", 25).apply {
                            name = "Bob"  // 修改属性
                            age = 30
                        }
                        println(person.name)  // "Bob"
                        
                        // 2. 配置对象
                        val textView = TextView(context).apply {
                            text = "Hello"
                            textSize = 16f
                            setTextColor(Color.BLACK)
                        }
                        
                        // 3. 链式调用
                        val person2 = Person("Charlie", 35)
                            .apply { name = "David" }
                            .apply { age = 40 }
                        
                        // 4. 创建并配置
                        val list = mutableListOf<Int>().apply {
                            add(1)
                            add(2)
                            add(3)
                        }
                        
                        // 5. 与also的区别
                        // apply返回对象本身，also也返回对象本身，但also使用it
                        val person3 = Person("Eve", 25)
                            .apply { name = "Frank" }  // this是person3
                            .also { it.age = 30 }      // it是person3
                    """.trimIndent(),
                    explanation = "apply函数在对象上下文中执行代码块，返回对象本身。使用this访问对象。常用于对象初始化、配置对象等场景。"
                ),
                CodeExample(
                    title = "示例5：also函数",
                    code = """
                        // also：将对象作为lambda参数，返回对象本身
                        // 使用场景：执行副作用、调试、链式调用
                        
                        // 1. 执行副作用
                        val numbers = mutableListOf(1, 2, 3)
                        numbers.also {
                            println("Adding 4 to list")
                            it.add(4)
                        }
                        println(numbers)  // [1, 2, 3, 4]
                        
                        // 2. 调试
                        val result = "Hello"
                            .uppercase()
                            .also { println("After uppercase: ${'$'}it") }  // "HELLO"
                            .length
                        
                        // 3. 链式调用
                        val person = Person("Alice", 25)
                            .also { println("Created: ${'$'}{it.name}") }
                            .also { it.age = 26 }
                            .also { println("Updated age: ${'$'}{it.age}") }
                        
                        // 4. 与apply的区别
                        // also使用it，apply使用this
                        val person2 = Person("Bob", 30)
                            .apply { name = "Charlie" }  // this.name
                            .also { it.age = 35 }       // it.age
                        
                        // 5. 数据验证
                        val user = createUser()
                            .also { validateUser(it) }
                            .also { logUser(it) }
                    """.trimIndent(),
                    explanation = "also函数将对象作为lambda参数（it），返回对象本身。常用于执行副作用、调试、链式调用等场景。also使用it，apply使用this。"
                ),
                CodeExample(
                    title = "示例6：作用域函数选择指南",
                    code = """
                        // 选择作用域函数的指南
                        
                        // 1. let：空安全调用、转换对象
                        val name: String? = "Hello"
                        val length = name?.let { it.length } ?: 0
                        
                        // 2. run：对象配置和计算
                        val person = Person("Alice", 25).run {
                            name = "Bob"
            age = 30
            this  // 返回对象
                        }
                        
                        // 3. with：对同一个对象执行多个操作
                        with(person) {
                            println(name)
                            println(age)
                        }
                        
                        // 4. apply：对象初始化、配置对象
                        val textView = TextView(context).apply {
                            text = "Hello"
                            textSize = 16f
                        }
                        
                        // 5. also：执行副作用、调试
                        val result = processData()
                            .also { println("Result: ${'$'}it") }
                            .also { saveToCache(it) }
                        
                        // 选择原则：
                        // - 需要返回对象本身 -> apply或also
                        // - 需要返回lambda结果 -> let、run或with
                        // - 需要空安全调用 -> let
                        // - 需要执行副作用 -> also
                        // - 对同一对象多个操作 -> with
                    """.trimIndent(),
                    explanation = "选择作用域函数的指南：需要返回对象本身用apply或also，需要返回lambda结果用let、run或with，需要空安全调用用let，需要执行副作用用also，对同一对象多个操作用with。"
                )
            ),
            useCases = listOf(
                "空安全调用：使用let进行空安全调用",
                "对象配置：使用apply配置对象",
                "对象转换：使用let或run转换对象",
                "副作用：使用also执行副作用",
                "代码简化：使用作用域函数简化代码"
            ),
            keyPoints = listOf(
                "let：将对象作为lambda参数（it），返回lambda结果，常用于空安全调用",
                "run：在对象上下文中执行（this），返回lambda结果，常用于对象配置",
                "with：在对象上下文中执行（this），返回lambda结果，常用于多个操作",
                "apply：在对象上下文中执行（this），返回对象本身，常用于对象初始化",
                "also：将对象作为lambda参数（it），返回对象本身，常用于副作用"
            ),
            notes = listOf(
                "let和also使用it，run、with、apply使用this",
                "apply和also返回对象本身，let、run、with返回lambda结果",
                "let常用于空安全调用和转换对象",
                "apply常用于对象初始化和配置",
                "also常用于执行副作用和调试"
            ),
            practiceTips = "建议：根据需求选择合适的作用域函数。需要返回对象本身用apply或also，需要返回lambda结果用let、run或with。需要空安全调用用let。合理使用作用域函数可以让代码更简洁，但不要过度使用。"
        ),
        
        // ========== Kotlin 操作符重载 ==========
        
        // 1. 操作符重载基础、中缀函数
        KnowledgeDetail(
            id = "operator_overload",
            title = "操作符重载基础、中缀函数",
            overview = "Kotlin允许重载操作符，让自定义类型可以使用操作符语法。中缀函数允许使用更自然的语法调用函数。理解操作符重载和中缀函数可以让代码更简洁、更易读。",
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：算术操作符重载",
                    code = """
                        // 算术操作符：+、-、*、/、%
                        
                        data class Point(val x: Int, val y: Int) {
                            // 重载+操作符
                            operator fun plus(other: Point): Point {
                                return Point(x + other.x, y + other.y)
                            }
                            
                            // 重载-操作符
                            operator fun minus(other: Point): Point {
                                return Point(x - other.x, y - other.y)
                            }
                            
                            // 重载*操作符
                            operator fun times(factor: Int): Point {
                                return Point(x * factor, y * factor)
                            }
                        }
                        
                        val p1 = Point(10, 20)
                        val p2 = Point(5, 10)
                        
                        val sum = p1 + p2      // Point(15, 30)
                        val diff = p1 - p2     // Point(5, 10)
                        val scaled = p1 * 2    // Point(20, 40)
                        
                        // 也可以重载其他类型
                        operator fun Point.plus(value: Int): Point {
                            return Point(x + value, y + value)
                        }
                        
                        val p3 = p1 + 5  // Point(15, 25)
                    """.trimIndent(),
                    explanation = "使用operator关键字重载操作符。可以重载算术操作符（+、-、*、/、%），让自定义类型支持操作符语法。"
                ),
                CodeExample(
                    title = "示例2：比较操作符重载",
                    code = """
                        // 比较操作符：==、!=、<、>、<=、>=
                        
                        data class Money(val amount: Int, val currency: String) {
                            // 重载比较操作符
                            operator fun compareTo(other: Money): Int {
                                require(currency == other.currency) {
                                    "Cannot compare different currencies"
                                }
                                return amount.compareTo(other.amount)
                            }
                        }
                        
                        val money1 = Money(100, "USD")
                        val money2 = Money(200, "USD")
                        
                        println(money1 < money2)   // true
                        println(money1 > money2)   // false
                        println(money1 <= money2)   // true
                        println(money1 >= money2)   // false
                        
                        // ==和!=自动使用equals方法
                        val money3 = Money(100, "USD")
                        println(money1 == money3)   // true（数据类自动生成equals）
                        println(money1 != money2)   // true
                    """.trimIndent(),
                    explanation = "可以重载比较操作符（<、>、<=、>=），需要实现compareTo方法。==和!=自动使用equals方法，数据类自动生成equals。"
                ),
                CodeExample(
                    title = "示例3：索引操作符重载",
                    code = """
                        // 索引操作符：[]、[]=
                        
                        class Matrix(val rows: Int, val cols: Int) {
                            private val data = Array(rows) { IntArray(cols) }
                            
                            // 重载get操作符（读取）
                            operator fun get(row: Int, col: Int): Int {
                                return data[row][col]
                            }
                            
                            // 重载set操作符（写入）
                            operator fun set(row: Int, col: Int, value: Int) {
                                data[row][col] = value
                            }
                        }
                        
                        val matrix = Matrix(3, 3)
                        matrix[0, 0] = 1  // 调用set
                        matrix[0, 1] = 2
                        matrix[1, 0] = 3
        
                        println(matrix[0, 0])  // 1（调用get）
                        println(matrix[0, 1])  // 2
                        
                        // 也可以用于Map-like结构
                        class Registry {
                            private val map = mutableMapOf<String, Any>()
                            
                            operator fun get(key: String): Any? {
                                return map[key]
                            }
                            
                            operator fun set(key: String, value: Any) {
                                map[key] = value
                            }
                        }
                        
                        val registry = Registry()
                        registry["name"] = "Alice"
                        println(registry["name"])  // "Alice"
                    """.trimIndent(),
                    explanation = "可以重载索引操作符[]和[]=，需要实现get和set方法。常用于矩阵、Map-like结构等场景。"
                ),
                CodeExample(
                    title = "示例4：调用操作符重载",
                    code = """
                        // 调用操作符：()
                        
                        class Adder(val value: Int) {
                            operator fun invoke(amount: Int): Int {
                                return value + amount
                            }
                        }
                        
                        val adder = Adder(10)
                        val result = adder(5)  // 15，像函数一样调用
        
                        // 函数类型也可以重载invoke
                        class Calculator {
                            operator fun invoke(operation: String, a: Int, b: Int): Int {
                                return when (operation) {
                                    "add" -> a + b
                                    "multiply" -> a * b
                                    else -> 0
                                }
                            }
                        }
                        
                        val calc = Calculator()
                        val sum = calc("add", 5, 3)  // 8
                        val product = calc("multiply", 5, 3)  // 15
                        
                        // 用于DSL
                        class Html {
                            operator fun invoke(block: Html.() -> Unit): String {
                                block()
                                return toString()
                            }
                        }
                    """.trimIndent(),
                    explanation = "可以重载调用操作符()，让对象可以像函数一样调用。需要实现invoke方法。常用于函数对象、DSL等场景。"
                ),
                CodeExample(
                    title = "示例5：中缀函数",
                    code = """
                        // 中缀函数：使用infix关键字，可以省略点和括号
                        
                        // 1. 基本语法
                        infix fun Int.add(other: Int): Int {
                            return this + other
                        }
                        
                        val sum = 5 add 3  // 8，等价于 5.add(3)
                        
                        // 2. 自定义中缀函数
                        infix fun String.matches(regex: String): Boolean {
                            return this.matches(regex.toRegex())
                        }
                        
                        val isValid = "hello@example.com" matches "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}\$"
                        // 等价于 "hello@example.com".matches("...")
                        
                        // 3. 中缀函数的要求
                        // - 必须是成员函数或扩展函数
                        // - 只能有一个参数
                        // - 参数不能有默认值
                        // - 不能是可变参数
                        
                        class Person(val name: String) {
                            infix fun marriedTo(other: Person): Boolean {
                                return true  // 示例
                            }
                        }
                        
                        val alice = Person("Alice")
                        val bob = Person("Bob")
                        val areMarried = alice marriedTo bob  // 更自然的语法
                        
                        // 4. 中缀函数与操作符
                        infix fun <T> T.shouldBe(expected: T) {
                            if (this != expected) {
                                throw AssertionError("Expected ${'$'}expected but got ${'$'}this")
                            }
                        }
                        
                        val result = 2 + 2
                        result shouldBe 4  // 测试框架风格的语法
                    """.trimIndent(),
                    explanation = "中缀函数使用infix关键字，可以省略点和括号，让函数调用更自然。中缀函数必须是成员函数或扩展函数，只能有一个参数。"
                ),
                CodeExample(
                    title = "示例6：操作符重载实践",
                    code = """
                        // 1. 向量运算
                        data class Vector(val x: Double, val y: Double) {
                            operator fun plus(other: Vector) = Vector(x + other.x, y + other.y)
                            operator fun minus(other: Vector) = Vector(x - other.x, y - other.y)
                            operator fun times(scalar: Double) = Vector(x * scalar, y * scalar)
                            operator fun div(scalar: Double) = Vector(x / scalar, y / scalar)
                            
                            operator fun unaryMinus() = Vector(-x, -y)  // 一元操作符
                            operator fun unaryPlus() = this
                        }
                        
                        val v1 = Vector(1.0, 2.0)
                        val v2 = Vector(3.0, 4.0)
                        val sum = v1 + v2  // Vector(4.0, 6.0)
                        val negated = -v1  // Vector(-1.0, -2.0)
                        
                        // 2. 范围操作符
                        class Date(val year: Int, val month: Int, val day: Int) {
                            operator fun rangeTo(other: Date): DateRange {
                                return DateRange(this, other)
                            }
                        }
                        
                        val start = Date(2024, 1, 1)
                        val end = Date(2024, 12, 31)
                        val range = start..end  // 使用..操作符
                        
                        // 3. in操作符
                        class Container<T>(private val items: List<T>) {
                            operator fun contains(item: T): Boolean {
                                return items.contains(item)
                            }
                        }
                        
                        val container = Container(listOf(1, 2, 3))
                        val exists = 2 in container  // true
                        val notExists = 5 in container  // false
                        
                        // 4. 解构操作符（componentN）
                        data class Point3D(val x: Int, val y: Int, val z: Int)
                        
                        val point = Point3D(1, 2, 3)
                        val (x, y, z) = point  // 解构
                        
                        // 5. 中缀函数实践
                        infix fun <T> T.should(assertion: (T) -> Boolean): T {
                            if (!assertion(this)) {
                                throw AssertionError("Assertion failed")
                            }
                            return this
                        }
                        
                        val number = 10
                        number should { it > 5 }  // 测试风格
                    """.trimIndent(),
                    explanation = "操作符重载在实际开发中用于向量运算、范围操作、容器操作等场景。中缀函数可以让代码更自然、更易读。合理使用操作符重载可以提高代码的可读性。"
                )
            ),
            useCases = listOf(
                "数学运算：为自定义类型重载算术操作符",
                "容器操作：重载索引操作符和in操作符",
                "函数对象：重载调用操作符让对象可调用",
                "DSL构建：使用操作符重载和中缀函数构建DSL",
                "代码简化：使用中缀函数让代码更自然"
            ),
            keyPoints = listOf(
                "使用operator关键字重载操作符",
                "可以重载算术、比较、索引、调用等操作符",
                "中缀函数使用infix关键字，可以省略点和括号",
                "中缀函数必须是成员函数或扩展函数，只能有一个参数",
                "操作符重载可以让代码更简洁、更易读"
            ),
            notes = listOf(
                "操作符重载需要实现特定的函数（如plus、minus、compareTo等）",
                "==和!=自动使用equals方法",
                "中缀函数不能有默认参数和可变参数",
                "合理使用操作符重载，不要过度使用",
                "操作符重载常用于数学运算、容器操作、DSL等场景"
            ),
            practiceTips = "建议：合理使用操作符重载提高代码可读性，但不要过度使用。中缀函数可以让代码更自然，特别是在DSL和测试框架中。注意操作符重载的语义应该清晰明确。"
        ),
        
        // ========== Kotlin 内联函数 ==========
        
        // 1. inline关键字、noinline和crossinline、reified类型参数
        KnowledgeDetail(
            id = "inline_functions",
            title = "inline关键字、noinline和crossinline、reified类型参数",
            overview = "内联函数使用inline关键字，函数体在调用处展开，避免函数调用的开销。noinline和crossinline用于控制Lambda的内联行为。reified类型参数允许在运行时访问类型信息。",
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：inline关键字基础",
                    code = """
                        // inline函数：函数体在调用处展开，避免函数调用开销
                        
                        // 1. 基本使用
                        inline fun <T> measureTime(block: () -> T): T {
                            val start = System.currentTimeMillis()
                            val result = block()
                            val end = System.currentTimeMillis()
                            println("Time: ${'$'}{end - start}ms")
                            return result
                        }
                        
                        // 调用时，函数体会展开
                        val result = measureTime {
                            // 执行一些操作
                            Thread.sleep(100)
                            "Done"
                        }
                        // 编译后相当于：
                        // val start = System.currentTimeMillis()
                        // val result = "Done"
                        // val end = System.currentTimeMillis()
                        // println("Time: ${'$'}{end - start}ms")
                        
                        // 2. inline的优势
                        // - 避免函数调用开销（特别是高阶函数）
                        // - 允许非局部返回
                        // - 支持reified类型参数
                        
                        // 3. inline的限制
                        // - 函数体不能太大（会增加代码体积）
                        // - 不能用于递归函数
                        // - 不能用于函数引用
                    """.trimIndent(),
                    explanation = "inline函数使用inline关键字，函数体在调用处展开，避免函数调用开销。inline函数特别适合高阶函数，可以减少Lambda对象的创建。"
                ),
                CodeExample(
                    title = "示例2：非局部返回",
                    code = """
                        // inline函数支持非局部返回
                        
                        // 1. 普通函数（不能非局部返回）
                        fun normalFunction(block: () -> Unit) {
                            block()
                        }
                        
                        fun test1() {
                            normalFunction {
                                return  // ❌ 错误！不能从test1返回
                                // 只能使用return@normalFunction
                            }
                        }
                        
                        // 2. inline函数（支持非局部返回）
                        inline fun inlineFunction(block: () -> Unit) {
                            block()
                        }
                        
                        fun test2() {
                            inlineFunction {
                                return  // ✅ 可以！从test2返回
                            }
                            println("This won't execute")
                        }
                        
                        // 3. 实际应用
                        inline fun <T> List<T>.forEach(action: (T) -> Unit) {
                            for (element in this) {
                                action(element)
                            }
                        
                        fun findFirst(list: List<Int>, predicate: (Int) -> Boolean): Int? {
                            var result: Int? = null
                            list.forEach {
                                if (predicate(it)) {
                                    result = it
                                    return  // 从findFirst返回
                                }
                            }
                            return result
                        }
                    """.trimIndent(),
                    explanation = "inline函数支持非局部返回，Lambda中的return可以从外层函数返回。普通函数不支持非局部返回，只能使用return@label。"
                ),
                CodeExample(
                    title = "示例3：noinline",
                    code = """
                        // noinline：禁止特定Lambda参数的内联
                        
                        // 1. 基本使用
                        inline fun process(
                            action1: () -> Unit,
                            noinline action2: () -> Unit  // 不内联
                        ) {
                            action1()  // 内联
                            action2()  // 不内联，可以作为参数传递
                            // 可以将action2传递给其他函数
                            executeLater(action2)
                        }
                        
                        fun executeLater(action: () -> Unit) {
                            // 需要函数类型参数，不能是内联的
                        }
                        
                        // 2. 为什么需要noinline
                        // - 需要将Lambda作为参数传递给其他函数
                        // - 需要将Lambda存储在变量中
                        // - 需要从非inline函数返回Lambda
                        
                        inline fun <T> processData(
                            data: T,
                            transform: (T) -> T,
                            noinline validator: (T) -> Boolean  // 不内联
                        ) {
                            val transformed = transform(data)
                            if (validator(transformed)) {
                                // validator可以传递给其他函数
                                validateAndSave(transformed, validator)
                            }
                        }
                        
                        fun validateAndSave(data: Any, validator: (Any) -> Boolean) {
                            if (validator(data)) {
                                save(data)
                            }
                        }
                    """.trimIndent(),
                    explanation = "noinline用于禁止特定Lambda参数的内联。当需要将Lambda作为参数传递、存储在变量中或从非inline函数返回时，需要使用noinline。"
                ),
                CodeExample(
                    title = "示例4：crossinline",
                    code = """
                        // crossinline：禁止非局部返回，但允许内联
                        
                        // 1. 问题场景
                        inline fun execute(block: () -> Unit) {
                            // 在另一个上下文中执行block
                            runOnBackgroundThread {
                                block()  // ❌ 错误！block可能包含非局部返回
                            }
                        }
                        
                        // 2. 使用crossinline解决
                        inline fun execute(crossinline block: () -> Unit) {
                            runOnBackgroundThread {
                                block()  // ✅ 可以，但不能非局部返回
                            }
                        }
                        
                        fun runOnBackgroundThread(action: () -> Unit) {
                            // 在后台线程执行
                            action()
                        }
                        
                        // 3. crossinline的特点
                        // - Lambda会被内联（性能优势）
                        // - 但不能使用非局部返回（return）
                        // - 可以使用return@label
                        
                        inline fun measureTime(crossinline block: () -> Unit) {
                            val start = System.currentTimeMillis()
                            try {
                                block()
                            } finally {
                                val end = System.currentTimeMillis()
                                println("Time: ${'$'}{end - start}ms")
                            }
                        }
                        
                        fun test() {
                            measureTime {
                                // return  // ❌ 错误！不能非局部返回
                                return@measureTime  // ✅ 可以
                            }
                        }
                    """.trimIndent(),
                    explanation = "crossinline用于禁止非局部返回，但允许内联。当Lambda在另一个上下文中执行时（如另一个Lambda、局部对象等），需要使用crossinline。"
                ),
                CodeExample(
                    title = "示例5：reified类型参数",
                    code = """
                        // reified：使类型参数在运行时可用
                        // 只能用于inline函数
                        
                        // 1. 基本使用
                        inline fun <reified T> getTypeName(): String {
                            return T::class.simpleName ?: "Unknown"
                        }
                        
                        println(getTypeName<Int>())      // "Int"
                        println(getTypeName<String>())    // "String"
                        
                        // 2. 类型检查
                        inline fun <reified T> isInstance(value: Any): Boolean {
                            return value is T
                        }
                        
                        println(isInstance<String>("Hello"))  // true
                        println(isInstance<Int>("Hello"))     // false
                        
                        // 3. 创建实例
                        inline fun <reified T> createInstance(): T? {
                            return try {
                                T::class.java.getDeclaredConstructor().newInstance()
                            } catch (e: Exception) {
                                null
                            }
                        }
                        
                        val string = createInstance<String>()  // ""
                        val list = createInstance<ArrayList<String>>()  // ArrayList()
                        
                        // 4. 在Android中的应用
                        // inline fun <reified T : Activity> Context.startActivity() {
                        //     startActivity(Intent(this, T::class.java))
                        // }
                        // 
                        // // 使用
                        // startActivity<MainActivity>()
                        
                        // 5. 过滤类型
                        inline fun <reified T> List<*>.filterIsInstance(): List<T> {
                            return this.filterIsInstance<T>()
                        }
                        
                        val mixed = listOf(1, "Hello", 2, "World")
                        val strings = mixed.filterIsInstance<String>()  // ["Hello", "World"]
                    """.trimIndent(),
                    explanation = "reified类型参数只能在inline函数中使用，允许在运行时访问类型信息。reified避免了类型擦除的问题，可以用于类型检查、创建实例等场景。"
                ),
                CodeExample(
                    title = "示例6：内联函数实践",
                    code = """
                        // 1. 性能优化
                        inline fun <T> List<T>.filterInline(predicate: (T) -> Boolean): List<T> {
                            val result = mutableListOf<T>()
                            for (item in this) {
                                if (predicate(item)) {
                                    result.add(item)
                                }
                            }
                            return result
                        }
                        // 内联后避免创建Lambda对象
                        
                        // 2. 工具函数
                        inline fun <T> T.applyIf(condition: Boolean, block: T.() -> Unit): T {
                            if (condition) {
                                block()
                            }
                            return this
                        }
                        
                        val person = Person("Alice", 25)
                            .applyIf(true) { age = 26 }
                        
                        // 3. 测量性能
                        inline fun <T> measureTimeMillis(block: () -> T): Pair<T, Long> {
                            val start = System.currentTimeMillis()
                            val result = block()
                            val end = System.currentTimeMillis()
                            return Pair(result, end - start)
                        }
                        
                        val (result, time) = measureTimeMillis {
                            // 执行操作
                            Thread.sleep(100)
                            "Done"
                        }
                        
                        // 4. 条件执行
                        inline fun <T> T.takeIfInline(predicate: (T) -> Boolean): T? {
                            return if (predicate(this)) this else null
                        }
                        
                        // 5. 注意事项
                        // - 不要过度使用inline
                        // - 大函数不要内联（会增加代码体积）
                        // - 递归函数不能内联
                        // - 函数引用不能内联
                    """.trimIndent(),
                    explanation = "内联函数在实际开发中用于性能优化、工具函数、测量性能等场景。合理使用内联函数可以提高性能，但要注意不要过度使用，大函数不要内联。"
                )
            ),
            useCases = listOf(
                "性能优化：使用inline减少高阶函数的开销",
                "非局部返回：使用inline支持非局部返回",
                "类型信息：使用reified在运行时访问类型信息",
                "工具函数：创建内联工具函数提高性能",
                "DSL构建：使用inline构建DSL"
            ),
            keyPoints = listOf(
                "inline函数使用inline关键字，函数体在调用处展开",
                "inline函数支持非局部返回，Lambda中的return可以从外层函数返回",
                "noinline禁止特定Lambda参数的内联",
                "crossinline禁止非局部返回，但允许内联",
                "reified类型参数只能在inline函数中使用，允许在运行时访问类型信息"
            ),
            notes = listOf(
                "inline函数避免函数调用开销，特别适合高阶函数",
                "大函数不要内联，会增加代码体积",
                "递归函数不能内联",
                "函数引用不能内联",
                "reified避免了类型擦除的问题"
            ),
            practiceTips = "建议：合理使用inline函数提高性能，特别是对于高阶函数。使用reified在需要运行时类型信息时。注意不要过度使用inline，大函数不要内联。在Android开发中，inline函数特别有用，可以减少Lambda对象的创建。"
        ),
        
        // ========== Kotlin 反射（Reflection） ==========
        
        // 1. 反射基础、KClass、KFunction、KProperty
        KnowledgeDetail(
            id = "reflection_basic",
            title = "反射基础、KClass、KFunction、KProperty",
            overview = "Kotlin反射允许在运行时检查和操作类、函数、属性等。KClass表示类，KFunction表示函数，KProperty表示属性。反射提供了动态访问和操作代码的能力。",
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：KClass基础",
                    code = """
                        import kotlin.reflect.full.*
                        
                        // 1. 获取KClass
                        class Person(val name: String, var age: Int)
                        
                        val kClass = Person::class
                        println(kClass.simpleName)  // "Person"
                        println(kClass.qualifiedName)  // "com.example.Person"
                        
                        // 2. 获取类的成员
                        val properties = kClass.memberProperties
                        properties.forEach { prop ->
                            println("${'$'}{prop.name}: ${'$'}{prop.returnType}")
                        }
                        
                        // 3. 检查类信息
                        println(kClass.isAbstract)  // false
                        println(kClass.isData)  // false
                        println(kClass.isSealed)  // false
                        println(kClass.isCompanion)  // false
                        
                        // 4. 获取构造函数
                        val constructors = kClass.constructors
                        constructors.forEach { constructor ->
                            println("Constructor: ${'$'}{constructor.parameters}")
                        }
                        
                        // 5. 创建实例
                        val instance = kClass.createInstance()  // 需要无参构造函数
                        // 或使用带参数的构造函数
                        val constructor = kClass.primaryConstructor
                        val person = constructor?.call("Alice", 25)
                    """.trimIndent(),
                    explanation = "KClass表示类的反射信息，可以获取类名、属性、构造函数等信息，并可以创建实例。"
                ),
                CodeExample(
                    title = "示例2：KFunction",
                    code = """
                        import kotlin.reflect.full.*
                        
                        class Calculator {
                            fun add(a: Int, b: Int): Int = a + b
                            fun multiply(a: Int, b: Int): Int = a * b
                        }
                        
                        // 1. 获取函数引用
                        val addFunction = Calculator::add
                        println(addFunction.name)  // "add"
                        println(addFunction.returnType)  // kotlin.Int
                        
                        // 2. 调用函数
                        val calculator = Calculator()
                        val result = addFunction.call(calculator, 3, 5)  // 8
                        
                        // 3. 获取函数参数
                        val parameters = addFunction.parameters
                        parameters.forEach { param ->
                            println("${'$'}{param.name}: ${'$'}{param.type}")
                        }
                        
                        // 4. 检查函数特性
                        println(addFunction.isInline)  // false
                        println(addFunction.isSuspend)  // false
                        
                        // 5. 获取类的所有函数
                        val functions = Calculator::class.memberFunctions
                        functions.forEach { func ->
                            println("Function: ${'$'}{func.name}")
                        }
                    """.trimIndent(),
                    explanation = "KFunction表示函数的反射信息，可以获取函数名、参数、返回类型等信息，并可以动态调用函数。"
                ),
                CodeExample(
                    title = "示例3：KProperty",
                    code = """
                        import kotlin.reflect.full.*
                        
                        class Person(val name: String, var age: Int) {
                            var email: String = ""
                            private var salary: Double = 0.0
                        }
                        
                        // 1. 获取属性引用
                        val nameProperty = Person::name
                        println(nameProperty.name)  // "name"
                        println(nameProperty.returnType)  // kotlin.String
                        println(nameProperty.isConst)  // false
                        println(nameProperty.isLateinit)  // false
                        
                        // 2. 读取属性值
                        val person = Person("Alice", 25)
                        val nameValue = nameProperty.get(person)  // "Alice"
                        
                        // 3. 写入属性值（可变属性）
                        val ageProperty = Person::age
                        ageProperty.setter.call(person, 26)
                        println(person.age)  // 26
                        
                        // 4. 获取所有属性
                        val properties = Person::class.memberProperties
                        properties.forEach { prop ->
                            println("${'$'}{prop.name}: ${'$'}{prop.returnType}")
                            if (prop is KMutableProperty<*>) {
                                println("  Mutable")
                            }
                        }
                        
                        // 5. 检查属性可见性
                        val salaryProperty = Person::class.memberProperties
                            .find { it.name == "salary" }
                        println(salaryProperty?.visibility)  // PRIVATE
                    """.trimIndent(),
                    explanation = "KProperty表示属性的反射信息，可以获取属性名、类型等信息，并可以读取和写入属性值。"
                ),
                CodeExample(
                    title = "示例4：反射实践",
                    code = """
                        import kotlin.reflect.full.*
                        
                        // 1. 动态创建对象
                        fun <T : Any> createInstance(clazz: KClass<T>): T? {
                            return clazz.createInstance()
                        }
                        
                        val person = createInstance(Person::class)
                        
                        // 2. 动态调用方法
                        fun callMethod(instance: Any, methodName: String, vararg args: Any?): Any? {
                            val method = instance::class.memberFunctions
                                .find { it.name == methodName }
                            return method?.call(instance, *args)
                        }
                        
                        val calculator = Calculator()
                        val result = callMethod(calculator, "add", 3, 5)
                        
                        // 3. 动态访问属性
                        fun getPropertyValue(instance: Any, propertyName: String): Any? {
                            val property = instance::class.memberProperties
                                .find { it.name == propertyName }
                            return property?.get(instance)
                        }
                        
                        val person = Person("Alice", 25)
                        val name = getPropertyValue(person, "name")
                        
                        // 4. 序列化/反序列化
                        fun toMap(instance: Any): Map<String, Any?> {
                            return instance::class.memberProperties.associate { prop ->
                                prop.name to prop.get(instance)
                            }
                        }
                        
                        val person = Person("Alice", 25)
                        val map = toMap(person)  // {"name": "Alice", "age": 25}
                    """.trimIndent(),
                    explanation = "反射在实际开发中用于动态创建对象、调用方法、访问属性、序列化等场景。"
                )
            ),
            useCases = listOf(
                "动态创建对象：使用反射创建类的实例",
                "动态调用方法：根据方法名动态调用方法",
                "动态访问属性：获取和设置对象属性",
                "序列化/反序列化：将对象转换为Map或JSON",
                "框架开发：构建依赖注入、ORM等框架"
            ),
            keyPoints = listOf(
                "KClass表示类的反射信息，可以获取类名、属性、构造函数等",
                "KFunction表示函数的反射信息，可以动态调用函数",
                "KProperty表示属性的反射信息，可以读取和写入属性值",
                "反射提供了动态访问和操作代码的能力",
                "反射性能较低，应谨慎使用"
            ),
            notes = listOf(
                "反射需要导入kotlin-reflect库",
                "反射性能较低，应避免在性能关键路径使用",
                "反射可以访问private成员，但需要权限",
                "KClass、KFunction、KProperty是反射的核心类型",
                "反射常用于框架开发、序列化、测试等场景"
            ),
            practiceTips = "建议：反射功能强大但性能较低，应谨慎使用。在需要动态访问代码的场景（如框架开发、序列化）中使用反射。注意反射可以访问private成员，需要谨慎处理。"
        ),
        
        // 2. 反射的应用场景
        KnowledgeDetail(
            id = "reflection_practice",
            title = "反射的应用场景",
            overview = "反射在实际开发中有多种应用场景，包括依赖注入、ORM框架、序列化、测试框架、插件系统等。合理使用反射可以提高代码的灵活性和可扩展性。",
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：依赖注入框架",
                    code = """
                        import kotlin.reflect.full.*
                        
                        // 简单的依赖注入实现
                        class DIContainer {
                            private val instances = mutableMapOf<KClass<*>, Any>()
                            
                            fun <T : Any> register(clazz: KClass<T>, instance: T) {
                                instances[clazz] = instance
                            }
                            
                            fun <T : Any> get(clazz: KClass<T>): T {
                                return instances[clazz] as? T
                    ?: throw IllegalStateException("No instance registered for ${'$'}{clazz.simpleName}")
                            }
                            
                            fun <T : Any> create(clazz: KClass<T>): T {
                                val constructor = clazz.primaryConstructor
                    ?: throw IllegalStateException("No primary constructor for ${'$'}{clazz.simpleName}")
                                
                                val parameters = constructor.parameters.map { param ->
                                    get(param.type.classifier as KClass<*>)
                                }
                                
                                return constructor.call(*parameters.toTypedArray())
                            }
                        }
                        
                        // 使用
                        class UserService(private val userRepository: UserRepository)
                        class UserRepository
                        
                        val container = DIContainer()
                        container.register(UserRepository::class, UserRepository())
                        val userService = container.create(UserService::class)
                    """.trimIndent(),
                    explanation = "反射可以用于实现依赖注入框架，自动解析构造函数参数并注入依赖。"
                ),
                CodeExample(
                    title = "示例2：ORM框架",
                    code = """
                        import kotlin.reflect.full.*
                        
                        // 简单的ORM映射
                        annotation class Table(val name: String)
                        annotation class Column(val name: String)
                        
                        @Table("users")
                        class User(
                            @Column("id") val id: Int,
                            @Column("name") val name: String,
                            @Column("email") val email: String
                        )
                        
                        fun <T : Any> toInsertSQL(instance: T): String {
                            val kClass = instance::class
                            val tableName = kClass.findAnnotation<Table>()?.name
                    ?: kClass.simpleName?.lowercase() ?: "unknown"
                            
                            val columns = kClass.memberProperties
                                .filter { it.findAnnotation<Column>() != null }
                                .map { it.findAnnotation<Column>()!!.name }
                            
                            val values = kClass.memberProperties
                                .filter { it.findAnnotation<Column>() != null }
                                .map { prop ->
                                    val value = prop.get(instance)
                                    if (value is String) "'${'$'}value'" else value
                                }
                            
                            return "INSERT INTO ${'$'}tableName (${'$'}{columns.joinToString()}) VALUES (${'$'}{values.joinToString()})"
                        }
                        
                        val user = User(1, "Alice", "alice@example.com")
                        val sql = toInsertSQL(user)
                        // INSERT INTO users (id, name, email) VALUES (1, 'Alice', 'alice@example.com')
                    """.trimIndent(),
                    explanation = "反射可以用于ORM框架，根据注解自动生成SQL语句。"
                ),
                CodeExample(
                    title = "示例3：JSON序列化",
                    code = """
                        import kotlin.reflect.full.*
                        
                        // 简单的JSON序列化
                        fun toJSON(instance: Any): String {
                            val kClass = instance::class
                            val properties = kClass.memberProperties
                            
                            val jsonPairs = properties.map { prop ->
                                val name = prop.name
                                val value = prop.get(instance)
                                val jsonValue = when (value) {
                                    is String -> "\"${'$'}value\""
                                    is Number, is Boolean -> value.toString()
                                    null -> "null"
                                    else -> toJSON(value)
                                }
                                "\"${'$'}name\": ${'$'}jsonValue"
                            }
                            
                            return "{${'$'}{jsonPairs.joinToString(", ")}}"
                        }
                        
                        class Person(val name: String, val age: Int, val email: String?)
                        val person = Person("Alice", 25, "alice@example.com")
                        val json = toJSON(person)
                        // {"name": "Alice", "age": 25, "email": "alice@example.com"}
                    """.trimIndent(),
                    explanation = "反射可以用于JSON序列化，自动将对象转换为JSON字符串。"
                ),
                CodeExample(
                    title = "示例4：测试框架",
                    code = """
                        import kotlin.reflect.full.*
                        
                        // 简单的测试框架
                        annotation class Test
                        annotation class BeforeEach
                        
                        class TestRunner {
                            fun runTests(testClass: KClass<*>) {
                                val instance = testClass.createInstance()
                                
                                // 运行@BeforeEach方法
                                testClass.memberFunctions
                                    .filter { it.findAnnotation<BeforeEach>() != null }
                                    .forEach { it.call(instance) }
                                
                                // 运行@Test方法
                                testClass.memberFunctions
                                    .filter { it.findAnnotation<Test>() != null }
                                    .forEach { method ->
                                        try {
                                            method.call(instance)
                                            println("✓ ${'$'}{method.name}")
                                        } catch (e: Exception) {
                                            println("✗ ${'$'}{method.name}: ${'$'}{e.message}")
                                        }
                                    }
                            }
                        }
                        
                        class CalculatorTest {
                            @BeforeEach
                            fun setup() {
                                println("Setup")
                            }
                            
                            @Test
                            fun testAdd() {
                                val calc = Calculator()
                                assert(calc.add(2, 3) == 5)
                            }
                        }
                        
                        TestRunner().runTests(CalculatorTest::class)
                    """.trimIndent(),
                    explanation = "反射可以用于测试框架，自动发现和运行测试方法。"
                )
            ),
            useCases = listOf(
                "依赖注入：自动解析和注入依赖",
                "ORM框架：根据注解生成SQL语句",
                "序列化：将对象转换为JSON或其他格式",
                "测试框架：自动发现和运行测试",
                "插件系统：动态加载和调用插件"
            ),
            keyPoints = listOf(
                "反射常用于框架开发，提供灵活性和可扩展性",
                "依赖注入框架使用反射解析构造函数参数",
                "ORM框架使用反射和注解生成SQL",
                "序列化框架使用反射访问对象属性",
                "测试框架使用反射发现和运行测试方法"
            ),
            notes = listOf(
                "反射性能较低，应避免在性能关键路径使用",
                "反射可以访问private成员，需要谨慎处理",
                "反射常用于框架开发，而不是业务代码",
                "现代框架（如KSP）可以生成代码替代反射",
                "合理使用反射可以提高代码的灵活性和可扩展性"
            ),
            practiceTips = "建议：反射主要用于框架开发，而不是业务代码。在需要动态访问代码的场景中使用反射，但要注意性能影响。现代框架（如KSP）可以生成代码替代反射，性能更好。"
        ),
        
        // ========== Kotlin 注解处理 ==========
        
        // 1. 注解声明和使用、元注解、注解处理器（KAPT、KSP）
        KnowledgeDetail(
            id = "annotations",
            title = "注解声明和使用、元注解、注解处理器（KAPT、KSP）",
            overview = "Kotlin注解用于为代码添加元数据。可以声明注解、使用元注解控制注解行为，使用KAPT或KSP处理注解生成代码。注解处理器在编译时生成代码，提高运行时性能。",
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：注解声明",
                    code = """
                        // 1. 基本注解声明
                        annotation class Api(val version: String)
                        annotation class Deprecated(val message: String)
                        
                        // 2. 带参数的注解
                        annotation class Author(val name: String, val date: String)
                        
                        // 3. 注解参数类型限制
                        // - 基本类型（Int、String等）
                        // - 枚举
                        // - 类引用（KClass）
                        // - 其他注解
                        // - 上述类型的数组
                        
                        annotation class Test(
                            val timeout: Int = 1000,
                            val enabled: Boolean = true
                        )
                        
                        // 4. 使用注解
                        @Api("v1")
                        class UserController
                        
                        @Author(name = "Alice", date = "2024-01-01")
                        fun processData() {}
                        
                        @Test(timeout = 2000, enabled = false)
                        fun testMethod() {}
                    """.trimIndent(),
                    explanation = "注解使用annotation class声明，可以带参数。注解参数类型有限制，只能是基本类型、枚举、类引用、其他注解或这些类型的数组。"
                ),
                CodeExample(
                    title = "示例2：元注解",
                    code = """
                        // 1. @Target：指定注解可以应用的位置
                        @Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
                        annotation class MyAnnotation
                        
                        // AnnotationTarget包括：
                        // - CLASS：类
                        // - FUNCTION：函数
                        // - PROPERTY：属性
                        // - FIELD：字段
                        // - VALUE_PARAMETER：参数
                        // - CONSTRUCTOR：构造函数
                        // - TYPE：类型
                        // - 等等
                        
                        // 2. @Retention：指定注解保留策略
                        @Retention(AnnotationRetention.SOURCE)  // 仅源码
                        annotation class SourceOnly
                        
                        @Retention(AnnotationRetention.BINARY)  // 编译后
                        annotation class BinaryOnly
                        
                        @Retention(AnnotationRetention.RUNTIME)  // 运行时（默认）
                        annotation class RuntimeAvailable
                        
                        // 3. @Repeatable：允许重复使用
                        @Repeatable
                        annotation class Tag(val value: String)
                        
                        @Tag("important")
                        @Tag("urgent")
                        class Task
                        
                        // 4. @MustBeDocumented：包含在文档中
                        @MustBeDocumented
                        annotation class Documented
                        
                        // 5. 组合使用
                        @Target(AnnotationTarget.FUNCTION)
                        @Retention(AnnotationRetention.RUNTIME)
                        @MustBeDocumented
                        annotation class ApiEndpoint(val path: String, val method: String)
                    """.trimIndent(),
                    explanation = "元注解用于控制注解的行为，包括@Target（应用位置）、@Retention（保留策略）、@Repeatable（可重复）、@MustBeDocumented（文档化）等。"
                ),
                CodeExample(
                    title = "示例3：注解使用",
                    code = """
                        // 1. 类注解
                        @Deprecated("Use NewClass instead")
                        class OldClass
                        
                        // 2. 函数注解
                        @JvmStatic
                        fun staticMethod() {}
                        
                        // 3. 属性注解
                        class Person {
                            @SerializedName("full_name")
                            val name: String = ""
                        }
                        
                        // 4. 参数注解
                        fun process(@NotNull data: String) {}
                        
                        // 5. 构造函数注解
                        class User @Inject constructor(val name: String)
                        
                        // 6. 表达式注解
                        val result = @Suppress("UNUSED") 42
                        
                        // 7. 文件级注解
                        @file:JvmName("Utils")
                        package com.example
                        
                        // 8. 注解参数
                        @ApiEndpoint(path = "/users", method = "GET")
                        fun getUsers() {}
                    """.trimIndent(),
                    explanation = "注解可以应用在类、函数、属性、参数、构造函数、表达式等位置。注解参数可以使用命名参数或位置参数。"
                ),
                CodeExample(
                    title = "示例4：KAPT（Kotlin Annotation Processing Tool）",
                    code = """
                        // build.gradle.kts
                        plugins {
                            kotlin("kapt")
                        }
                        
                        dependencies {
                            kapt("com.google.dagger:dagger-compiler:2.48")
                        }
                        
                        // KAPT使用示例（Dagger）
                        @Component
                        interface AppComponent {
                            fun inject(app: MyApplication)
                        }
                        
                        @Module
                        class AppModule {
                            @Provides
                            fun provideRepository(): UserRepository {
                                return UserRepository()
                            }
                        }
                        
                        // KAPT会在编译时生成代码
                        // 生成的代码在build/generated/source/kapt/目录下
                        
                        // KAPT的优缺点：
                        // 优点：
                        // - 支持Java注解处理器
                        // - 成熟稳定
                        // 缺点：
                        // - 编译速度慢
                        // - 需要生成Java存根
                        // - 不支持增量编译
                    """.trimIndent(),
                    explanation = "KAPT是Kotlin的注解处理工具，支持Java注解处理器。KAPT会在编译时生成代码，但编译速度较慢。"
                ),
                CodeExample(
                    title = "示例5：KSP（Kotlin Symbol Processing）",
                    code = """
                        // build.gradle.kts
                        plugins {
                            id("com.google.devtools.ksp") version "1.9.0-1.0.13"
                        }
                        
                        dependencies {
                            ksp("com.google.dagger:dagger-compiler:2.48")
                        }
                        
                        // KSP使用示例
                        @Component
                        interface AppComponent {
                            fun inject(app: MyApplication)
                        }
                        
                        // KSP的优势：
                        // - 编译速度快（比KAPT快2倍以上）
                        // - 支持增量编译
                        // - 直接处理Kotlin代码，不需要Java存根
                        // - 更好的IDE支持
                        // - 支持多平台
                        
                        // KSP vs KAPT：
                        // - KSP是Kotlin原生的，KAPT基于Java
                        // - KSP性能更好，KAPT更成熟
                        // - 新项目推荐使用KSP
                    """.trimIndent(),
                    explanation = "KSP是Kotlin的符号处理工具，是KAPT的替代方案。KSP编译速度更快，支持增量编译，是Kotlin原生的注解处理工具。"
                ),
                CodeExample(
                    title = "示例6：自定义注解处理器",
                    code = """
                        // 1. 定义注解
                        @Target(AnnotationTarget.CLASS)
                        @Retention(AnnotationRetention.SOURCE)
                        annotation class Builder
                        
                        // 2. 使用注解
                        @Builder
                        class Person(val name: String, val age: Int)
                        
                        // 3. 注解处理器（KSP示例）
                        // class BuilderProcessor : SymbolProcessor {
                        //     override fun process(resolver: Resolver): List<KSAnnotated> {
                        //         val symbols = resolver.getSymbolsWithAnnotation(Builder::class.qualifiedName!!)
                        //         symbols.forEach { symbol ->
                        //             if (symbol is KSClassDeclaration) {
                        //                 generateBuilder(symbol)
                        //             }
                        //         }
                        //         return emptyList()
                        //     }
                        //     
                        //     private fun generateBuilder(classDeclaration: KSClassDeclaration) {
                        //         // 生成Builder代码
                        //     }
                        // }
                        
                        // 4. 生成的代码
                        // class PersonBuilder {
                        //     private var name: String = ""
                        //     private var age: Int = 0
                        //     
                        //     fun name(name: String) = apply { this.name = name }
                        //     fun age(age: Int) = apply { this.age = age }
                        //     fun build() = Person(name, age)
                        // }
                    """.trimIndent(),
                    explanation = "可以自定义注解处理器，在编译时根据注解生成代码。KSP提供了更好的API来编写Kotlin注解处理器。"
                )
            ),
            useCases = listOf(
                "依赖注入：使用注解标记需要注入的类和方法",
                "序列化：使用注解控制序列化行为",
                "路由框架：使用注解定义路由",
                "代码生成：使用注解生成样板代码",
                "测试框架：使用注解标记测试方法"
            ),
            keyPoints = listOf(
                "注解使用annotation class声明，可以带参数",
                "元注解控制注解的行为（@Target、@Retention等）",
                "KAPT支持Java注解处理器，但编译速度慢",
                "KSP是Kotlin原生的注解处理工具，性能更好",
                "注解处理器在编译时生成代码，提高运行时性能"
            ),
            notes = listOf(
                "注解参数类型有限制，只能是基本类型、枚举、类引用等",
                "@Retention指定注解保留策略（SOURCE、BINARY、RUNTIME）",
                "@Target指定注解可以应用的位置",
                "KSP比KAPT快2倍以上，推荐新项目使用KSP",
                "注解处理器在编译时运行，不影响运行时性能"
            ),
            practiceTips = "建议：合理使用注解提高代码的可读性和可维护性。新项目推荐使用KSP而不是KAPT，性能更好。注解处理器可以生成样板代码，减少重复代码。注意注解的保留策略，SOURCE级别的注解在运行时不可用。"
        ),
        
        // ========== Kotlin与Java互操作 ==========
        
        // 1. Java调用Kotlin、@JvmName、@JvmStatic、@JvmOverloads
        KnowledgeDetail(
            id = "java_call_kotlin",
            title = "Java调用Kotlin、@JvmName、@JvmStatic、@JvmOverloads",
            overview = "Kotlin代码可以被Java调用，但需要注意一些互操作性问题。@JvmName可以改变生成的Java方法名，@JvmStatic可以将函数编译为静态方法，@JvmOverloads可以为默认参数生成重载方法。",
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：Java调用Kotlin基础",
                    code = """
                        // Kotlin文件：Utils.kt
                        package com.example
                        
                        // 1. 顶层函数
                        fun topLevelFunction(name: String): String {
                            return "Hello, ${'$'}name"
                        }
                        
                        // Java调用：
                        // String result = UtilsKt.topLevelFunction("Alice");
                        
                        // 2. 顶层属性
                        var topLevelProperty: String = "Default"
                        
                        // Java调用：
                        // UtilsKt.setTopLevelProperty("New Value");
                        // String value = UtilsKt.getTopLevelProperty();
                        
                        // 3. 类成员
                        class Person(val name: String) {
                            fun greet(): String = "Hello, ${'$'}name"
                        }
                        
                        // Java调用：
                        // Person person = new Person("Alice");
                        // String greeting = person.greet();
                    """.trimIndent(),
                    explanation = "Kotlin的顶层函数和属性会被编译为静态方法，类成员函数会编译为实例方法。Java可以正常调用这些函数。"
                ),
                CodeExample(
                    title = "示例2：@JvmName",
                    code = """
                        // 1. 改变生成的Java方法名
                        @JvmName("createUser")
                        fun create(name: String): User {
                            return User(name)
                        }
                        
                        // Java调用：
                        // User user = UtilsKt.createUser("Alice");
                        // 而不是 UtilsKt.create("Alice")
                        
                        // 2. 解决类型擦除问题
                        @JvmName("filterStrings")
                        fun List<String>.filter(predicate: (String) -> Boolean): List<String> {
                            return this.filter(predicate)
                        }
                        
                        @JvmName("filterInts")
                        fun List<Int>.filter(predicate: (Int) -> Boolean): List<Int> {
                            return this.filter(predicate)
                        }
                        
                        // 3. 文件级@JvmName
                        @file:JvmName("StringUtils")
                        package com.example
                        
                        fun capitalize(str: String): String {
                            return str.capitalize()
                        }
                        
                        // Java调用：
                        // StringUtils.capitalize("hello");
                        // 而不是 StringUtilsKt.capitalize("hello")
                    """.trimIndent(),
                    explanation = "@JvmName可以改变生成的Java方法名，解决类型擦除问题，或提供更友好的Java API。"
                ),
                CodeExample(
                    title = "示例3：@JvmStatic",
                    code = """
                        class Calculator {
                            companion object {
                                // 1. 不使用@JvmStatic
                                fun add(a: Int, b: Int): Int = a + b
                                
                                // Java调用：
                                // Calculator.Companion.add(3, 5);
                            }
                            
                            companion object {
                                // 2. 使用@JvmStatic
                                @JvmStatic
                                fun multiply(a: Int, b: Int): Int = a * b
                                
                                // Java调用：
                                // Calculator.multiply(3, 5);  // 更简洁
                            }
                            
                            // 3. 对象声明
                            object Constants {
                                @JvmStatic
                                val PI = 3.14159
                                
                                @JvmStatic
                                fun getVersion(): String = "1.0"
                            }
                            
                            // Java调用：
                            // double pi = Calculator.Constants.getPI();
                            // String version = Calculator.Constants.getVersion();
                        }
                    """.trimIndent(),
                    explanation = "@JvmStatic可以将companion object或object中的函数编译为静态方法，Java可以直接通过类名调用，而不需要通过Companion。"
                ),
                CodeExample(
                    title = "示例4：@JvmOverloads",
                    code = """
                        // 1. 默认参数问题
                        class View {
                            fun setPadding(
                                left: Int,
                                top: Int,
                                right: Int,
                                bottom: Int = 0  // 默认参数
                            ) {}
                        }
                        
                        // Java调用时，必须提供所有参数：
                        // view.setPadding(10, 20, 30, 0);  // 必须提供bottom
                        
                        // 2. 使用@JvmOverloads
                        class View {
                            @JvmOverloads
                            fun setPadding(
                                left: Int,
                                top: Int,
                                right: Int,
                                bottom: Int = 0
                            ) {}
                        }
                        
                        // Java调用时，可以省略默认参数：
                        // view.setPadding(10, 20, 30);  // bottom使用默认值0
                        // view.setPadding(10, 20, 30, 40);  // 也可以提供所有参数
                        
                        // 3. 构造函数
                        class Person @JvmOverloads constructor(
                            val name: String,
                            val age: Int = 0,
                            val email: String = ""
                        )
                        
                        // Java调用：
                        // Person person1 = new Person("Alice");
                        // Person person2 = new Person("Alice", 25);
                        // Person person3 = new Person("Alice", 25, "alice@example.com");
                    """.trimIndent(),
                    explanation = "@JvmOverloads可以为带默认参数的函数生成重载方法，Java可以像调用重载方法一样调用，而不需要提供所有参数。"
                ),
                CodeExample(
                    title = "示例5：其他互操作注解",
                    code = """
                        // 1. @JvmField：暴露属性为Java字段
                        class Person {
                            @JvmField
                            val name: String = "Alice"
                            
                            // Java调用：
                            // String name = person.name;  // 直接访问字段
                            // 而不是 person.getName()
                        }
                        
                        // 2. @JvmSynthetic：隐藏对Java的可见性
                        @JvmSynthetic
                        fun internalFunction() {
                            // Java无法调用此函数
                        }
                        
                        // 3. @Throws：声明异常
                        @Throws(IOException::class)
                        fun readFile(path: String): String {
                            // Java调用时，需要处理IOException
                        }
                        
                        // 4. @JvmWildcard：使用通配符
                        fun process(list: List<@JvmWildcard String>) {
                            // Java中会生成 List<? extends String>
                        }
                        
                        // 5. @JvmSuppressWildcards：抑制通配符
                        fun process(list: List<@JvmSuppressWildcards String>) {
                            // Java中会生成 List<String>
                        }
                    """.trimIndent(),
                    explanation = "还有其他互操作注解，如@JvmField（暴露字段）、@JvmSynthetic（隐藏）、@Throws（声明异常）等，用于优化Java互操作。"
                )
            ),
            useCases = listOf(
                "API设计：使用@JvmName提供更友好的Java API",
                "静态方法：使用@JvmStatic将函数编译为静态方法",
                "默认参数：使用@JvmOverloads为Java生成重载方法",
                "字段访问：使用@JvmField暴露属性为Java字段",
                "异常处理：使用@Throws声明异常"
            ),
            keyPoints = listOf(
                "Kotlin代码可以被Java调用，但需要注意互操作性问题",
                "@JvmName可以改变生成的Java方法名",
                "@JvmStatic可以将函数编译为静态方法",
                "@JvmOverloads可以为默认参数生成重载方法",
                "还有其他互操作注解用于优化Java互操作"
            ),
            notes = listOf(
                "顶层函数会被编译为静态方法，类名是文件名+Kt",
                "@JvmName可以解决类型擦除问题",
                "@JvmStatic让Java可以直接通过类名调用",
                "@JvmOverloads为每个默认参数生成一个重载方法",
                "合理使用互操作注解可以提高Java互操作性"
            ),
            practiceTips = "建议：在需要Java互操作时，合理使用@JvmName、@JvmStatic、@JvmOverloads等注解，提供更友好的Java API。注意Kotlin的默认参数在Java中不可用，需要使用@JvmOverloads。"
        ),
        
        // 2. Kotlin调用Java、平台类型、SAM转换
        KnowledgeDetail(
            id = "kotlin_call_java",
            title = "Kotlin调用Java、平台类型、SAM转换",
            overview = "Kotlin可以无缝调用Java代码，但需要注意平台类型和SAM转换。平台类型是Kotlin对Java类型的表示，可能为null。SAM转换允许将Lambda表达式转换为Java的单一抽象方法接口。",
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：Kotlin调用Java基础",
                    code = """
                        // Java类
                        // public class Calculator {
                        //     public int add(int a, int b) {
                        //         return a + b;
                        //     }
                        //     
                        //     public static int multiply(int a, int b) {
                        //         return a * b;
                        //     }
                        // }
                        
                        // Kotlin调用
                        val calculator = Calculator()
                        val result = calculator.add(3, 5)  // 8
                        
                        val product = Calculator.multiply(3, 5)  // 15
                        
                        // 1. Getter/Setter
                        // Java: public String getName() { return name; }
                        // Kotlin: person.name  // 自动调用getName()
                        
                        // 2. Boolean属性
                        // Java: public boolean isActive() { return active; }
                        // Kotlin: person.isActive  // 自动调用isActive()
                        
                        // 3. 可变属性
                        // Java: public void setName(String name) { this.name = name; }
                        // Kotlin: person.name = "Alice"  // 自动调用setName()
                    """.trimIndent(),
                    explanation = "Kotlin可以无缝调用Java代码，Java的getter/setter会被映射为Kotlin属性，静态方法可以直接调用。"
                ),
                CodeExample(
                    title = "示例2：平台类型",
                    code = """
                        // 1. 平台类型
                        // Java方法返回String（可能为null）
                        // public String getName() { return name; }
                        
                        val name: String = javaObject.getName()  // 平台类型String!
                        // String!表示可能为null，但Kotlin不强制检查
                        
                        // 2. 处理平台类型
                        val name1: String? = javaObject.getName()  // 明确声明为可空
                        val name2: String = javaObject.getName() ?: ""  // 提供默认值
                        
                        // 3. 平台类型的问题
                        val list: List<String> = javaObject.getList()  // List<String>!
                        // list可能为null，但Kotlin不强制检查
                        val size = list.size  // 可能NPE
                        
                        // 4. 安全处理
                        val list2: List<String>? = javaObject.getList()
                        val size2 = list2?.size ?: 0
                        
                        // 5. 类型映射
                        // Java类型 -> Kotlin类型
                        // int -> Int
                        // Integer -> Int?
                        // String -> String!
                        // List<String> -> (Mutable)List<String>!
                    """.trimIndent(),
                    explanation = "平台类型是Kotlin对Java类型的表示，使用!标记（如String!），可能为null但Kotlin不强制检查。需要明确声明为可空类型或提供默认值。"
                ),
                CodeExample(
                    title = "示例3：SAM转换",
                    code = """
                        // 1. Java接口（单一抽象方法）
                        // public interface OnClickListener {
                        //     void onClick(View v);
                        // }
                        
                        // 2. 传统方式（匿名内部类）
                        button.setOnClickListener(object : OnClickListener {
                            override fun onClick(v: View) {
                                println("Clicked")
                            }
                        })
                        
                        // 3. SAM转换（Lambda）
                        button.setOnClickListener { v ->
                            println("Clicked")
                        }
                        
                        // 4. 多个参数
                        // public interface OnItemClickListener {
                        //     void onItemClick(View view, int position, long id);
                        // }
                        
                        listView.setOnItemClickListener { view, position, id ->
                            println("Item ${'$'}position clicked")
                        }
                        
                        // 5. 无参数
                        // public interface Runnable {
                        //     void run();
                        // }
                        
                        val runnable = Runnable {
                            println("Running")
                        }
                        
                        // 6. 返回值
                        // public interface Callback<T> {
                        //     T call();
                        // }
                        
                        val callback = Callback<String> {
                            "Result"
                        }
                    """.trimIndent(),
                    explanation = "SAM转换允许将Lambda表达式转换为Java的单一抽象方法接口，简化代码。Kotlin会自动将Lambda转换为接口实现。"
                ),
                CodeExample(
                    title = "示例4：Java泛型",
                    code = """
                        // 1. Java泛型
                        // public class Box<T> {
                        //     private T value;
                        //     public T getValue() { return value; }
                        //     public void setValue(T value) { this.value = value; }
                        // }
                        
                        val box = Box<String>()
                        box.setValue("Hello")
                        val value: String = box.getValue()
                        
                        // 2. 通配符
                        // public void process(List<? extends Number> numbers) {}
                        
                        val numbers: List<Number> = listOf(1, 2, 3)
                        javaObject.process(numbers)  // 可以传递
                        
                        // 3. 原始类型
                        // public void processRaw(List list) {}
                        
                        val list: List<String> = listOf("a", "b")
                        javaObject.processRaw(list)  // 可以传递，但失去类型安全
                    """.trimIndent(),
                    explanation = "Kotlin可以调用Java泛型代码，Java的通配符和原始类型在Kotlin中也可以使用，但需要注意类型安全。"
                ),
                CodeExample(
                    title = "示例5：Java数组",
                    code = """
                        // 1. Java数组
                        // public void processArray(int[] array) {}
                        
                        val array = intArrayOf(1, 2, 3)
                        javaObject.processArray(array)
                        
                        // 2. 对象数组
                        // public void processStringArray(String[] array) {}
                        
                        val stringArray = arrayOf("a", "b", "c")
                        javaObject.processStringArray(stringArray)
                        
                        // 3. 可变参数
                        // public void processVarargs(String... args) {}
                        
                        javaObject.processVarargs("a", "b", "c")
                        javaObject.processVarargs(*arrayOf("a", "b", "c"))  // 使用spread操作符
                    """.trimIndent(),
                    explanation = "Kotlin可以传递数组给Java方法，使用intArrayOf、arrayOf等创建数组，使用spread操作符传递可变参数。"
                )
            ),
            useCases = listOf(
                "调用Java库：在Kotlin中调用Java第三方库",
                "混合开发：在Kotlin和Java混合项目中互操作",
                "SAM转换：使用Lambda简化Java接口调用",
                "平台类型处理：安全处理Java可能为null的返回值",
                "泛型互操作：在Kotlin中使用Java泛型"
            ),
            keyPoints = listOf(
                "Kotlin可以无缝调用Java代码",
                "平台类型使用!标记，可能为null但Kotlin不强制检查",
                "SAM转换允许将Lambda转换为Java单一抽象方法接口",
                "Java的getter/setter会被映射为Kotlin属性",
                "需要注意Java可能为null的返回值"
            ),
            notes = listOf(
                "平台类型可能为null，需要明确处理",
                "SAM转换只适用于单一抽象方法接口",
                "Java的原始类型在Kotlin中失去类型安全",
                "合理使用SAM转换可以简化代码",
                "注意Java和Kotlin的类型映射差异"
            ),
            practiceTips = "建议：在Kotlin中调用Java代码时，注意平台类型可能为null，需要明确处理。使用SAM转换简化Java接口调用。注意Java和Kotlin的类型映射差异，特别是可空性。"
        ),
        
        // 3. 互操作最佳实践
        KnowledgeDetail(
            id = "interop_best",
            title = "互操作最佳实践",
            overview = "Kotlin与Java互操作的最佳实践包括：合理使用互操作注解、处理平台类型、优化SAM转换、处理泛型差异、处理异常等。遵循最佳实践可以提高互操作性和代码质量。",
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：API设计最佳实践",
                    code = """
                        // 1. 使用@JvmName提供友好的Java API
                        @JvmName("createUser")
                        fun create(name: String): User {
                            return User(name)
                        }
                        
                        // 2. 使用@JvmStatic提供静态方法
                        class Utils {
                            companion object {
                                @JvmStatic
                                fun process(data: String): String {
                                    return data.uppercase()
                                }
                            }
                        }
                        
                        // 3. 使用@JvmOverloads支持默认参数
                        class View {
                            @JvmOverloads
                            fun setPadding(
                                left: Int,
                                top: Int,
                                right: Int,
                                bottom: Int = 0
                            ) {}
                        }
                        
                        // 4. 使用@JvmField暴露常量
                        class Constants {
                            companion object {
                                @JvmField
                                val API_VERSION = "1.0"
                            }
                        }
                    """.trimIndent(),
                    explanation = "合理使用互操作注解，提供友好的Java API，让Java代码更容易使用Kotlin代码。"
                ),
                CodeExample(
                    title = "示例2：平台类型处理",
                    code = """
                        // 1. 明确处理平台类型
                        // ❌ 不好的做法
                        val name = javaObject.getName()  // String!
                        val length = name.length  // 可能NPE
                        
                        // ✅ 好的做法
                        val name: String? = javaObject.getName()
                        val length = name?.length ?: 0
                        
                        // 2. 使用扩展函数处理平台类型
                        fun <T> T?.orDefault(default: T): T {
                            return this ?: default
                        }
                        
                        val name = javaObject.getName().orDefault("Unknown")
                        
                        // 3. 使用Elvis操作符
                        val list = javaObject.getList() ?: emptyList()
                        val size = list.size
                        
                        // 4. 使用let处理可空
                        javaObject.getName()?.let { name ->
                            println("Name: ${'$'}name")
                        }
                    """.trimIndent(),
                    explanation = "明确处理平台类型，使用可空类型、Elvis操作符、let等安全处理可能为null的值。"
                ),
                CodeExample(
                    title = "示例3：SAM转换优化",
                    code = """
                        // 1. 使用Lambda简化代码
                        // ❌ 不好的做法
                        button.setOnClickListener(object : OnClickListener {
                            override fun onClick(v: View) {
                                handleClick(v)
                            }
                        })
                        
                        // ✅ 好的做法
                        button.setOnClickListener { v ->
                            handleClick(v)
                        }
                        
                        // 2. 方法引用
                        button.setOnClickListener(::handleClick)
                        
                        // 3. 多个SAM参数
                        // 如果方法有多个SAM参数，只有最后一个可以使用Lambda
                        // public void setCallbacks(
                        //     OnSuccess onSuccess,
                        //     OnError onError
                        // )
                        
                        api.setCallbacks(
                            OnSuccess { result -> handleSuccess(result) },
                            OnError { error -> handleError(error) }
                        )
                    """.trimIndent(),
                    explanation = "使用Lambda和方法引用简化SAM转换，提高代码可读性。注意多个SAM参数时，只有最后一个可以使用Lambda。"
                ),
                CodeExample(
                    title = "示例4：异常处理",
                    code = """
                        // 1. 使用@Throws声明异常
                        @Throws(IOException::class)
                        fun readFile(path: String): String {
                            return File(path).readText()
                        }
                        
                        // Java调用时，需要处理异常：
                        // try {
                        //     String content = UtilsKt.readFile("file.txt");
                        // } catch (IOException e) {
                        //     // 处理异常
                        // }
                        
                        // 2. Kotlin调用Java异常
                        // Java方法可能抛出异常
                        // public void process() throws IOException {}
                        
                        // Kotlin调用
                        try {
                            javaObject.process()
                        } catch (e: IOException) {
                            // 处理异常
                        }
                        
                        // 3. 运行时异常
                        // Java可能抛出运行时异常，Kotlin不强制处理
                        val result = javaObject.process()  // 可能抛出RuntimeException
                    """.trimIndent(),
                    explanation = "使用@Throws声明检查异常，让Java代码可以正确处理。Kotlin调用Java时，需要处理可能抛出的异常。"
                ),
                CodeExample(
                    title = "示例5：泛型互操作",
                    code = """
                        // 1. 通配符处理
                        // Java: public void process(List<? extends Number> numbers) {}
                        
                        val numbers: List<Number> = listOf(1, 2, 3)
                        javaObject.process(numbers)
                        
                        // 2. 原始类型
                        // 避免使用原始类型，保持类型安全
                        // ❌ 不好的做法
                        val rawList: List = javaObject.getRawList()
                        
                        // ✅ 好的做法
                        val typedList: List<String> = javaObject.getTypedList()
                        
                        // 3. 类型投影
                        fun processList(list: List<out Number>) {
                            // 只读访问
                        }
                        
                        fun modifyList(list: MutableList<in Number>) {
                            // 可写访问
                        }
                    """.trimIndent(),
                    explanation = "合理处理Java泛型，避免使用原始类型，保持类型安全。使用类型投影处理通配符。"
                ),
                CodeExample(
                    title = "示例6：性能优化",
                    code = """
                        // 1. 避免频繁的Java-Kotlin转换
                        // ❌ 不好的做法
                        for (i in 0..1000) {
                            val result = javaObject.process(i)  // 每次调用都有开销
                        }
                        
                        // ✅ 好的做法
                        val results = (0..1000).map { i ->
                            javaObject.process(i)
                        }
                        
                        // 2. 使用内联函数减少开销
                        inline fun <T> measureTime(block: () -> T): T {
                            val start = System.currentTimeMillis()
                            val result = block()
                            val end = System.currentTimeMillis()
                            println("Time: ${'$'}{end - start}ms")
                            return result
                        }
                        
                        // 3. 缓存Java对象
                        private val cachedJavaObject = JavaObject()
                        
                        fun process() {
                            cachedJavaObject.process()  // 复用对象
                        }
                    """.trimIndent(),
                    explanation = "优化Java-Kotlin互操作性能，避免频繁转换，使用内联函数，缓存Java对象等。"
                )
            ),
            useCases = listOf(
                "API设计：使用互操作注解提供友好的Java API",
                "类型安全：正确处理平台类型和泛型",
                "代码简化：使用SAM转换和方法引用",
                "异常处理：正确处理Java异常",
                "性能优化：优化互操作性能"
            ),
            keyPoints = listOf(
                "合理使用互操作注解，提供友好的Java API",
                "明确处理平台类型，避免NPE",
                "使用SAM转换和方法引用简化代码",
                "正确处理Java异常",
                "优化互操作性能"
            ),
            notes = listOf(
                "平台类型需要明确处理，避免NPE",
                "SAM转换只适用于单一抽象方法接口",
                "使用@Throws声明检查异常",
                "避免使用原始类型，保持类型安全",
                "合理优化互操作性能"
            ),
            practiceTips = "建议：遵循互操作最佳实践，合理使用互操作注解，明确处理平台类型，使用SAM转换简化代码，正确处理异常，优化性能。在混合项目中，注意Kotlin和Java的类型差异，特别是可空性。"
        ),
        
        // ========== Kotlin DSL构建 ==========
        
        // 1. DSL基础、带接收者的Lambda、Gradle Kotlin DSL
        KnowledgeDetail(
            id = "dsl_basic",
            title = "DSL基础、带接收者的Lambda、Gradle Kotlin DSL",
            overview = "DSL（领域特定语言）使用Kotlin的语法特性构建领域特定的API。带接收者的Lambda是构建DSL的核心，允许在Lambda内部使用接收者对象的成员。Gradle Kotlin DSL是DSL的实际应用。",
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：DSL基础",
                    code = """
                        // 1. 什么是DSL
                        // DSL是领域特定语言，用于特定领域的API设计
                        // 例如：HTML构建器、SQL构建器、路由配置等
                        
                        // 2. 传统方式
                        val person = Person()
                        person.name = "Alice"
                        person.age = 25
                        person.email = "alice@example.com"
                        
                        // 3. DSL方式
                        val person = person {
                            name = "Alice"
                            age = 25
                            email = "alice@example.com"
                        }
                        
                        // 4. DSL的优势
                        // - 更接近自然语言
                        // - 结构清晰
                        // - 类型安全
                        // - IDE支持好
                    """.trimIndent(),
                    explanation = "DSL是领域特定语言，使用Kotlin语法特性构建领域特定的API，提供更接近自然语言的代码。"
                ),
                CodeExample(
                    title = "示例2：带接收者的Lambda",
                    code = """
                        // 1. 带接收者的函数类型
                        class Person {
                            var name: String = ""
                            var age: Int = 0
                        }
                        
                        // 普通Lambda
                        fun createPerson(block: (Person) -> Unit): Person {
                            val person = Person()
                            block(person)
                            return person
                        }
                        
                        // 使用
                        val person = createPerson { p ->
                            p.name = "Alice"
                            p.age = 25
                        }
                        
                        // 2. 带接收者的Lambda
                        fun createPerson(block: Person.() -> Unit): Person {
                            val person = Person()
                            person.block()  // 在接收者上调用
                            return person
                        }
                        
                        // 使用（更简洁）
                        val person = createPerson {
                            name = "Alice"  // 直接访问，不需要p.
                            age = 25
                        }
                        
                        // 3. 带接收者的扩展函数
                        fun Person.configure(block: Person.() -> Unit): Person {
                            block()
                            return this
                        }
                        
                        val person = Person().configure {
                            name = "Alice"
                            age = 25
                        }
                    """.trimIndent(),
                    explanation = "带接收者的Lambda（T.() -> Unit）是构建DSL的核心，允许在Lambda内部直接访问接收者对象的成员，不需要显式引用。"
                ),
                CodeExample(
                    title = "示例3：HTML构建器",
                    code = """
                        // 1. HTML元素类
                        class HTML {
                            fun body(init: Body.() -> Unit) {
                                val body = Body()
                                body.init()
                            }
                        }
                        
                        class Body {
                            fun div(init: Div.() -> Unit) {
                                val div = Div()
                                div.init()
                            }
                        }
                        
                        class Div {
                            var text: String = ""
                            fun p(init: P.() -> Unit) {
                                val p = P()
                                p.init()
                            }
                        }
                        
                        class P {
                            var text: String = ""
                        }
                        
                        // 2. 使用DSL
                        val html = HTML()
                        html.body {
                            div {
                                text = "Container"
                                p {
                                    text = "Hello, World"
                                }
                            }
                        }
                        
                        // 3. 更完整的实现
                        interface Element {
                            fun render(builder: StringBuilder, indent: String)
                        }
                        
                        class HTML : Element {
                            private val children = mutableListOf<Element>()
                            
                            fun body(init: Body.() -> Unit) {
                                val body = Body()
                                body.init()
                                children.add(body)
                            }
                            
                            override fun render(builder: StringBuilder, indent: String) {
                                builder.append("<html>\\n")
                                children.forEach { it.render(builder, indent + "  ") }
                                builder.append("</html>\\n")
                            }
                        }
                    """.trimIndent(),
                    explanation = "HTML构建器是DSL的典型应用，使用带接收者的Lambda构建HTML结构，代码更清晰易读。"
                ),
                CodeExample(
                    title = "示例4：Gradle Kotlin DSL",
                    code = """
                        // build.gradle.kts
                        plugins {
                            id("com.android.application") version "8.1.0"
                            kotlin("android") version "1.9.0"
                        }
                        
                        android {
                            namespace = "com.example.app"
                            compileSdk = 34
                            
                            defaultConfig {
                                applicationId = "com.example.app"
                                minSdk = 24
                                targetSdk = 34
                                versionCode = 1
                                versionName = "1.0"
                            }
                            
                            buildTypes {
                                getByName("release") {
                                    isMinifyEnabled = true
                                    proguardFiles(
                                        getDefaultProguardFile("proguard-android-optimize.txt"),
                                        "proguard-rules.pro"
                                    )
                                }
                            }
                        }
                        
                        dependencies {
                            implementation("androidx.core:core-ktx:1.12.0")
                            implementation("androidx.appcompat:appcompat:1.6.1")
                        }
                        
                        // Gradle Kotlin DSL的优势：
                        // - 类型安全
                        // - IDE自动补全
                        // - 重构支持
                        // - 更好的错误提示
                    """.trimIndent(),
                    explanation = "Gradle Kotlin DSL是DSL的实际应用，使用Kotlin语法配置Gradle构建，提供类型安全、IDE支持等优势。"
                ),
                CodeExample(
                    title = "示例5：路由DSL",
                    code = """
                        // 1. 路由DSL
                        class Router {
                            private val routes = mutableListOf<Route>()
                            
                            fun route(path: String, init: Route.() -> Unit) {
                                val route = Route(path)
                                route.init()
                                routes.add(route)
                            }
                        }
                        
                        class Route(val path: String) {
                            var handler: (() -> Unit)? = null
                            var method: String = "GET"
                            
                            fun handler(block: () -> Unit) {
                                handler = block
                            }
                        }
                        
                        // 2. 使用DSL
                        val router = Router()
                        router.route("/users") {
                            method = "GET"
                            handler {
                                println("Get users")
                            }
                        }
                        
                        router.route("/users/:id") {
                            method = "GET"
                            handler {
                                println("Get user by id")
                            }
                        }
                        
                        // 3. 更复杂的DSL
                        router {
                            route("/api") {
                                get("/users") { /* ... */ }
                                post("/users") { /* ... */ }
                                put("/users/:id") { /* ... */ }
                                delete("/users/:id") { /* ... */ }
                            }
                        }
                    """.trimIndent(),
                    explanation = "路由DSL是DSL的另一个应用，使用带接收者的Lambda构建路由配置，代码更清晰易读。"
                )
            ),
            useCases = listOf(
                "HTML构建器：使用DSL构建HTML结构",
                "Gradle配置：使用Gradle Kotlin DSL配置构建",
                "路由配置：使用DSL配置路由",
                "SQL构建器：使用DSL构建SQL查询",
                "测试框架：使用DSL编写测试"
            ),
            keyPoints = listOf(
                "DSL是领域特定语言，使用Kotlin语法特性构建",
                "带接收者的Lambda（T.() -> Unit）是构建DSL的核心",
                "Gradle Kotlin DSL是DSL的实际应用",
                "DSL提供更接近自然语言的代码",
                "DSL具有类型安全和IDE支持的优势"
            ),
            notes = listOf(
                "带接收者的Lambda允许直接访问接收者对象的成员",
                "DSL常用于配置、构建器、测试框架等场景",
                "Gradle Kotlin DSL提供类型安全和IDE支持",
                "合理使用DSL可以提高代码可读性",
                "DSL设计需要考虑API的易用性和灵活性"
            ),
            practiceTips = "建议：合理使用DSL提高代码可读性，特别是在配置、构建器等场景。使用带接收者的Lambda构建DSL，提供类型安全和IDE支持。注意DSL设计要平衡易用性和灵活性。"
        ),
        
        // 2. 自定义DSL设计
        KnowledgeDetail(
            id = "dsl_practice",
            title = "自定义DSL设计",
            overview = "自定义DSL设计需要考虑API设计、作用域控制、类型安全、错误处理等方面。合理设计DSL可以提高代码的可读性和可维护性。",
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：配置DSL",
                    code = """
                        // 1. 配置类
                        class DatabaseConfig {
                            var host: String = "localhost"
                            var port: Int = 3306
                            var username: String = ""
                            var password: String = ""
                            var database: String = ""
                            
                            fun connection(init: ConnectionConfig.() -> Unit) {
                                val config = ConnectionConfig()
                                config.init()
                                this.host = config.host
                                this.port = config.port
                            }
                        }
                        
                        class ConnectionConfig {
                            var host: String = "localhost"
                            var port: Int = 3306
                        }
                        
                        // 2. DSL函数
                        fun database(init: DatabaseConfig.() -> Unit): DatabaseConfig {
                            val config = DatabaseConfig()
                            config.init()
                            return config
                        }
                        
                        // 3. 使用
                        val config = database {
                            connection {
                                host = "192.168.1.1"
                                port = 5432
                            }
                            username = "admin"
                            password = "secret"
                            database = "mydb"
                        }
                    """.trimIndent(),
                    explanation = "配置DSL使用带接收者的Lambda构建配置对象，提供清晰的配置结构。"
                ),
                CodeExample(
                    title = "示例2：作用域控制",
                    code = """
                        // 1. 使用@DslMarker控制作用域
                        @DslMarker
                        annotation class HtmlDsl
                        
                        @HtmlDsl
                        class HTML {
                            fun body(init: Body.() -> Unit) {
                                val body = Body()
                                body.init()
                            }
                        }
                        
                        @HtmlDsl
                        class Body {
                            fun div(init: Div.() -> Unit) {
                                val div = Div()
                                div.init()
                            }
                        }
                        
                        @HtmlDsl
                        class Div {
                            fun p(init: P.() -> Unit) {
                                val p = P()
                                p.init()
                            }
                        }
                        
                        // 2. 使用@DslMarker后，不能直接访问外层作用域
                        html {
                            body {
                                div {
                                    // p { }  // ✅ 可以
                                    // body { }  // ❌ 错误！不能直接访问外层body
                                }
                            }
                        }
                        
                        // 3. 显式访问外层作用域
                        html {
                            val outerBody = body {
                                div {
                                    outerBody.div { }  // ✅ 可以，显式引用
                                }
                            }
                        }
                    """.trimIndent(),
                    explanation = "@DslMarker用于控制DSL作用域，防止意外访问外层作用域，提高DSL的类型安全性。"
                ),
                CodeExample(
                    title = "示例3：类型安全",
                    code = """
                        // 1. 使用泛型提供类型安全
                        class QueryBuilder<T> {
                            private val conditions = mutableListOf<String>()
                            
                            fun where(condition: String) {
                                conditions.add(condition)
                            }
                            
                            fun build(): String {
                                return "SELECT * FROM ${'$'}T WHERE ${'$'}{conditions.joinToString(" AND ")}"
                            }
                        }
                        
                        // 2. 类型安全的查询
                        fun <T> select(init: QueryBuilder<T>.() -> Unit): String {
                            val builder = QueryBuilder<T>()
                            builder.init()
                            return builder.build()
                        }
                        
                        // 使用
                        val query = select<User> {
                            where("age > 18")
                            where("active = true")
                        }
                        
                        // 3. 使用sealed class提供类型安全
                        sealed class SQLOperator {
                            object Equals : SQLOperator()
                            object NotEquals : SQLOperator()
                            object GreaterThan : SQLOperator()
                            object LessThan : SQLOperator()
                        }
                        
                        class ConditionBuilder {
                            fun condition(column: String, operator: SQLOperator, value: Any) {
                                // 构建条件
                            }
                        }
                    """.trimIndent(),
                    explanation = "使用泛型和sealed class提供类型安全，防止DSL使用错误，提高代码的可靠性。"
                ),
                CodeExample(
                    title = "示例4：链式调用",
                    code = """
                        // 1. 链式DSL
                        class RequestBuilder {
                            private var url: String = ""
                            private var method: String = "GET"
                            private val headers = mutableMapOf<String, String>()
                            
                            fun url(url: String): RequestBuilder {
                                this.url = url
                                return this
                            }
                            
                            fun method(method: String): RequestBuilder {
                                this.method = method
                                return this
                            }
                            
                            fun header(name: String, value: String): RequestBuilder {
                                headers[name] = value
                                return this
                            }
                            
                            fun build(): Request {
                                return Request(url, method, headers)
                            }
                        }
                        
                        // 2. 使用链式调用
                        val request = RequestBuilder()
                            .url("https://api.example.com/users")
                            .method("POST")
                            .header("Content-Type", "application/json")
                            .header("Authorization", "Bearer token")
                            .build()
                        
                        // 3. 结合Lambda
                        fun request(init: RequestBuilder.() -> Unit): Request {
                            val builder = RequestBuilder()
                            builder.init()
                            return builder.build()
                        }
                        
                        val request2 = request {
                            url = "https://api.example.com/users"
                            method = "POST"
                            header("Content-Type", "application/json")
                            header("Authorization", "Bearer token")
                        }
                    """.trimIndent(),
                    explanation = "链式调用是DSL的另一种形式，提供流畅的API，可以结合Lambda使用。"
                ),
                CodeExample(
                    title = "示例5：错误处理",
                    code = """
                        // 1. 验证DSL
                        class FormBuilder {
                            private val fields = mutableListOf<Field>()
                            
                            fun field(name: String, init: Field.() -> Unit) {
                                val field = Field(name)
                                field.init()
                                fields.add(field)
                            }
                            
                            fun build(): Form {
                                // 验证
                                fields.forEach { field ->
                                    if (field.required && field.value.isBlank()) {
                                        throw IllegalArgumentException("Field ${'$'}{field.name} is required")
                                    }
                                }
                                return Form(fields)
                            }
                        }
                        
                        class Field(val name: String) {
                            var value: String = ""
                            var required: Boolean = false
                            var minLength: Int = 0
                            var maxLength: Int = Int.MAX_VALUE
                        }
                        
                        // 2. 使用
                        val form = form {
                            field("name") {
                                value = "Alice"
                                required = true
                                minLength = 3
                                maxLength = 50
                            }
                            field("email") {
                                value = "alice@example.com"
                                required = true
                            }
                        }.build()
                        
                        // 3. 延迟验证
                        class ValidatedFormBuilder {
                            private val validators = mutableListOf<() -> Unit>()
                            
                            fun validate(block: () -> Unit) {
                                validators.add(block)
                            }
                            
                            fun build() {
                                validators.forEach { it() }
                            }
                        }
                    """.trimIndent(),
                    explanation = "DSL中可以包含验证逻辑，在构建时或使用时进行验证，提供更好的错误处理。"
                )
            ),
            useCases = listOf(
                "配置管理：使用DSL管理配置",
                "API构建：使用DSL构建API请求",
                "表单构建：使用DSL构建表单",
                "查询构建：使用DSL构建查询",
                "测试DSL：使用DSL编写测试"
            ),
            keyPoints = listOf(
                "DSL设计需要考虑API的易用性和灵活性",
                "使用@DslMarker控制作用域，提高类型安全",
                "使用泛型和sealed class提供类型安全",
                "链式调用提供流畅的API",
                "合理处理错误和验证"
            ),
            notes = listOf(
                "@DslMarker防止意外访问外层作用域",
                "类型安全是DSL设计的重要考虑",
                "链式调用和Lambda可以结合使用",
                "错误处理应该在DSL中考虑",
                "DSL设计要平衡易用性和灵活性"
            ),
            practiceTips = "建议：设计DSL时，考虑API的易用性和灵活性，使用@DslMarker控制作用域，提供类型安全，合理处理错误。DSL应该接近自然语言，提供良好的IDE支持。"
        ),
        
        // ========== Kotlin多平台开发（KMM） ==========
        
        // 1. KMM基础、共享代码模块、平台特定实现
        KnowledgeDetail(
            id = "kmm_basic",
            title = "KMM基础、共享代码模块、平台特定实现",
            overview = "Kotlin Multiplatform Mobile（KMM）允许在Android和iOS之间共享代码。共享代码模块包含业务逻辑，平台特定实现处理UI和平台API。KMM提高了代码复用率，减少了维护成本。",
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：KMM项目结构",
                    code = """
                        // 项目结构：
                        // commonMain/
                        //   - 共享业务逻辑
                        //   - 数据模型
                        //   - 网络请求
                        // androidMain/
                        //   - Android特定实现
                        //   - Android UI
                        // iosMain/
                        //   - iOS特定实现
                        //   - iOS UI
                        
                        // build.gradle.kts (commonMain)
                        kotlin {
                            android()
                            ios()
                            
                            sourceSets {
                                val commonMain by getting {
                                    dependencies {
                                        // 共享依赖
                                    }
                                }
                                
                                val androidMain by getting {
                                    dependencies {
                                        // Android特定依赖
                                    }
                                }
                                
                                val iosMain by getting {
                                    dependencies {
                                        // iOS特定依赖
                                    }
                                }
                            }
                        }
                    """.trimIndent(),
                    explanation = "KMM项目结构包括commonMain（共享代码）、androidMain（Android实现）、iosMain（iOS实现）。"
                ),
                CodeExample(
                    title = "示例2：共享代码模块",
                    code = """
                        // commonMain/kotlin/User.kt
                        data class User(
                            val id: Int,
                            val name: String,
                            val email: String
                        )
                        
                        // commonMain/kotlin/UserRepository.kt
                        interface UserRepository {
                            suspend fun getUser(id: Int): User?
                            suspend fun getUsers(): List<User>
                            suspend fun saveUser(user: User)
                        }
                        
                        // commonMain/kotlin/UserUseCase.kt
                        class UserUseCase(private val repository: UserRepository) {
                            suspend fun getUserById(id: Int): User? {
                                return repository.getUser(id)
                            }
                            
                            suspend fun getAllUsers(): List<User> {
                                return repository.getUsers()
                            }
                        }
                        
                        // commonMain/kotlin/NetworkService.kt
                        interface NetworkService {
                            suspend fun fetchData(url: String): String
                        }
                    """.trimIndent(),
                    explanation = "共享代码模块包含数据模型、业务逻辑、接口定义等，可以在Android和iOS之间共享。"
                ),
                CodeExample(
                    title = "示例3：平台特定实现",
                    code = """
                        // 1. expect/actual机制
                        // commonMain/kotlin/Platform.kt
                        expect class Platform() {
                            val name: String
                        }
                        
                        // androidMain/kotlin/Platform.android.kt
                        actual class Platform {
                            actual val name: String = "Android"
                        }
                        
                        // iosMain/kotlin/Platform.ios.kt
                        actual class Platform {
                            actual val name: String = "iOS"
                        }
                        
                        // 2. 使用
                        // commonMain
                        fun getPlatformName(): String {
                            return Platform().name
                        }
                        
                        // 3. 平台特定API
                        // commonMain/kotlin/FileManager.kt
                        expect class FileManager {
                            fun readFile(path: String): String
                            fun writeFile(path: String, content: String)
                        }
                        
                        // androidMain/kotlin/FileManager.android.kt
                        import java.io.File
                        actual class FileManager {
                            actual fun readFile(path: String): String {
                                return File(path).readText()
                            }
                            
                            actual fun writeFile(path: String, content: String) {
                                File(path).writeText(content)
                            }
                        }
                        
                        // iosMain/kotlin/FileManager.ios.kt
                        // iOS实现使用iOS API
                        actual class FileManager {
                            actual fun readFile(path: String): String {
                                // iOS实现
                            }
                            
                            actual fun writeFile(path: String, content: String) {
                                // iOS实现
                            }
                        }
                    """.trimIndent(),
                    explanation = "expect/actual机制用于定义平台特定的实现，commonMain定义expect，各平台提供actual实现。"
                ),
                CodeExample(
                    title = "示例4：网络请求",
                    code = """
                        // commonMain/kotlin/ApiService.kt
                        interface ApiService {
                            suspend fun getUser(id: Int): User
                        }
                        
                        // 使用Ktor（支持KMM）
                        // commonMain/kotlin/ApiClient.kt
                        import io.ktor.client.*
                        import io.ktor.client.call.*
                        import io.ktor.client.request.*
                        
                        class ApiClient {
                            private val client = HttpClient()
                            
                            suspend fun getUser(id: Int): User {
                                return client.get("https://api.example.com/users/${'$'}id").body()
                            }
                        }
                        
                        // Ktor支持KMM，可以在commonMain中使用
                        // 网络引擎由各平台提供：
                        // - Android: OkHttp
                        // - iOS: NSURLSession
                    """.trimIndent(),
                    explanation = "KMM可以使用Ktor等支持多平台的库进行网络请求，网络引擎由各平台提供。"
                ),
                CodeExample(
                    title = "示例5：数据存储",
                    code = """
                        // 1. 使用expect/actual
                        // commonMain/kotlin/Storage.kt
                        expect class Storage {
                            fun save(key: String, value: String)
                            fun get(key: String): String?
                        }
                        
                        // androidMain/kotlin/Storage.android.kt
                        import android.content.SharedPreferences
                        actual class Storage {
                            private val prefs: SharedPreferences = // ...
                            
                            actual fun save(key: String, value: String) {
                                prefs.edit().putString(key, value).apply()
                            }
                            
                            actual fun get(key: String): String? {
                                return prefs.getString(key, null)
                            }
                        }
                        
                        // iosMain/kotlin/Storage.ios.kt
                        // 使用UserDefaults
                        actual class Storage {
                            actual fun save(key: String, value: String) {
                                // iOS实现
                            }
                            
                            actual fun get(key: String): String? {
                                // iOS实现
                            }
                        }
                        
                        // 2. 使用支持KMM的库
                        // 例如：Multiplatform Settings
                        // commonMain
                        val settings = Settings()
                        settings.putString("key", "value")
                        val value = settings.getStringOrNull("key")
                    """.trimIndent(),
                    explanation = "数据存储可以使用expect/actual机制，或使用支持KMM的库（如Multiplatform Settings）。"
                )
            ),
            useCases = listOf(
                "业务逻辑共享：在Android和iOS之间共享业务逻辑",
                "数据模型共享：共享数据模型和API接口",
                "网络请求：使用Ktor等库共享网络请求代码",
                "数据存储：使用expect/actual或支持KMM的库",
                "工具类共享：共享工具类和工具函数"
            ),
            keyPoints = listOf(
                "KMM允许在Android和iOS之间共享代码",
                "commonMain包含共享业务逻辑",
                "expect/actual机制用于平台特定实现",
                "Ktor等库支持KMM，可以在commonMain中使用",
                "UI和平台API需要在各平台单独实现"
            ),
            notes = listOf(
                "KMM提高了代码复用率，减少了维护成本",
                "expect/actual是KMM的核心机制",
                "共享代码不能直接使用平台API",
                "Ktor、Serialization等库支持KMM",
                "UI需要在各平台单独实现"
            ),
            practiceTips = "建议：使用KMM共享业务逻辑和数据模型，减少重复代码。使用expect/actual机制处理平台特定实现。注意共享代码不能直接使用平台API，需要使用expect/actual或支持KMM的库。UI需要在各平台单独实现。"
        ),
        
        // 2. KMM实践、Compose Multiplatform
        KnowledgeDetail(
            id = "kmm_practice",
            title = "KMM实践、Compose Multiplatform",
            overview = "KMM实践包括项目结构设计、依赖管理、测试策略等。Compose Multiplatform允许在Android和iOS之间共享UI代码，进一步提高了代码复用率。",
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：项目结构设计",
                    code = """
                        // 推荐的项目结构：
                        // shared/
                        //   commonMain/
                        //     kotlin/
                        //       data/
                        //         model/
                        //         repository/
                        //       domain/
                        //         usecase/
                        //       presentation/
                        //         viewmodel/
                        //   androidMain/
                        //     kotlin/
                        //       di/
                        //       platform/
                        //   iosMain/
                        //     kotlin/
                        //       di/
                        //       platform/
                        // androidApp/
                        //   - Android应用
                        // iosApp/
                        //   - iOS应用
                        
                        // 分层架构：
                        // - data层：数据模型、Repository实现
                        // - domain层：业务逻辑、UseCase
                        // - presentation层：ViewModel（共享状态管理）
                    """.trimIndent(),
                    explanation = "KMM项目应该采用清晰的分层架构，将共享代码和平台特定代码分离。"
                ),
                CodeExample(
                    title = "示例2：依赖注入",
                    code = """
                        // commonMain/kotlin/DI.kt
                        // 使用接口定义依赖
                        interface AppContainer {
                            val userRepository: UserRepository
                            val userUseCase: UserUseCase
                        }
                        
                        // androidMain/kotlin/AppContainer.android.kt
                        class AndroidAppContainer : AppContainer {
                            override val userRepository: UserRepository = 
                                AndroidUserRepository()
                            override val userUseCase: UserUseCase = 
                                UserUseCase(userRepository)
                        }
                        
                        // iosMain/kotlin/AppContainer.ios.kt
                        class IOSAppContainer : AppContainer {
                            override val userRepository: UserRepository = 
                                IOSUserRepository()
                            override val userUseCase: UserUseCase = 
                                UserUseCase(userRepository)
                        }
                        
                        // 使用
                        // commonMain
                        class App {
                            lateinit var container: AppContainer
                        }
                        
                        // androidMain
                        val app = App()
                        app.container = AndroidAppContainer()
                        
                        // iosMain
                        val app = App()
                        app.container = IOSAppContainer()
                    """.trimIndent(),
                    explanation = "依赖注入在KMM中通过接口定义，各平台提供具体实现。"
                ),
                CodeExample(
                    title = "示例3：Compose Multiplatform",
                    code = """
                        // 1. 添加依赖
                        // build.gradle.kts
                        kotlin {
                            android()
                            ios()
                            
                            sourceSets {
                                val commonMain by getting {
                                    dependencies {
                                        implementation("org.jetbrains.compose.ui:ui:1.5.0")
                                        implementation("org.jetbrains.compose.runtime:runtime:1.5.0")
                                    }
                                }
                            }
                        }
                        
                        // 2. 共享UI组件
                        // commonMain/kotlin/UserScreen.kt
                        @Composable
                        fun UserScreen(user: User) {
                            Column {
                                Text("Name: ${'$'}{user.name}")
                                Text("Email: ${'$'}{user.email}")
                            }
                        }
                        
                        // 3. 平台特定UI
                        // commonMain
                        @Composable
                        expect fun PlatformButton(
                            text: String,
                            onClick: () -> Unit
                        )
                        
                        // androidMain
                        @Composable
                        actual fun PlatformButton(
                            text: String,
                            onClick: () -> Unit
                        ) {
                            Button(onClick = onClick) {
                                Text(text)
                            }
                        }
                        
                        // iosMain
                        @Composable
                        actual fun PlatformButton(
                            text: String,
                            onClick: () -> Unit
                        ) {
                            // iOS实现
                        }
                        
                        // 4. 使用
                        @Composable
                        fun App() {
                            UserScreen(user = User(1, "Alice", "alice@example.com"))
                        }
                    """.trimIndent(),
                    explanation = "Compose Multiplatform允许在Android和iOS之间共享UI代码，使用expect/actual处理平台特定UI。"
                ),
                CodeExample(
                    title = "示例4：状态管理",
                    code = """
                        // commonMain/kotlin/UserViewModel.kt
                        class UserViewModel(
                            private val userUseCase: UserUseCase
                        ) {
                            private val _users = MutableStateFlow<List<User>>(emptyList())
                            val users: StateFlow<List<User>> = _users.asStateFlow()
                            
                            private val _loading = MutableStateFlow(false)
                            val loading: StateFlow<Boolean> = _loading.asStateFlow()
                            
                            fun loadUsers() {
                                viewModelScope.launch {
                                    _loading.value = true
                                    try {
                                        val users = userUseCase.getAllUsers()
                                        _users.value = users
                                    } finally {
                                        _loading.value = false
                                    }
                                }
                            }
                        }
                        
                        // 在Compose中使用
                        @Composable
                        fun UserListScreen(viewModel: UserViewModel) {
                            val users by viewModel.users.collectAsState()
                            val loading by viewModel.loading.collectAsState()
                            
                            if (loading) {
                                CircularProgressIndicator()
                            } else {
                                LazyColumn {
                                    items(users) { user ->
                                        UserItem(user = user)
                                    }
                                }
                            }
                        }
                    """.trimIndent(),
                    explanation = "状态管理可以在commonMain中共享，使用StateFlow等响应式API，在Compose中通过collectAsState使用。"
                ),
                CodeExample(
                    title = "示例5：测试策略",
                    code = """
                        // 1. 共享测试
                        // commonTest/kotlin/UserUseCaseTest.kt
                        class UserUseCaseTest {
                            @Test
                            fun testGetUser() {
                                val repository = MockUserRepository()
                                val useCase = UserUseCase(repository)
                                
                                runTest {
                                    val user = useCase.getUserById(1)
                                    assertNotNull(user)
                                }
                            }
                        }
                        
                        // 2. 平台特定测试
                        // androidTest/kotlin/AndroidUserRepositoryTest.kt
                        class AndroidUserRepositoryTest {
                            @Test
                            fun testSaveUser() {
                                // Android特定测试
                            }
                        }
                        
                        // 3. 使用Mock
                        class MockUserRepository : UserRepository {
                            private val users = mutableMapOf<Int, User>()
                            
                            override suspend fun getUser(id: Int): User? {
                                return users[id]
                            }
                            
                            override suspend fun saveUser(user: User) {
                                users[user.id] = user
                            }
                        }
                    """.trimIndent(),
                    explanation = "KMM测试策略包括共享测试（commonTest）和平台特定测试，使用Mock进行单元测试。"
                )
            ),
            useCases = listOf(
                "UI共享：使用Compose Multiplatform共享UI代码",
                "状态管理：共享ViewModel和状态管理逻辑",
                "业务逻辑：共享业务逻辑和UseCase",
                "数据层：共享数据模型和Repository接口",
                "测试：共享测试代码，减少重复"
            ),
            keyPoints = listOf(
                "KMM项目应该采用清晰的分层架构",
                "依赖注入通过接口定义，各平台提供实现",
                "Compose Multiplatform允许共享UI代码",
                "状态管理可以在commonMain中共享",
                "测试策略包括共享测试和平台特定测试"
            ),
            notes = listOf(
                "Compose Multiplatform进一步提高了代码复用率",
                "UI共享需要处理平台差异",
                "状态管理使用StateFlow等响应式API",
                "测试可以使用Mock进行单元测试",
                "合理设计项目结构可以提高可维护性"
            ),
            practiceTips = "建议：使用KMM共享业务逻辑和UI代码，采用清晰的分层架构。使用Compose Multiplatform共享UI，注意处理平台差异。合理设计依赖注入和测试策略，提高代码的可维护性。"
        ),
        
        // ========== Java 基础语法 ==========
        
        // 1. 变量和数据类型（基本类型、引用类型、包装类）
        KnowledgeDetail(
            id = "java_var_decl",
            title = "变量和数据类型（基本类型、引用类型、包装类）",
            overview = "Java中的数据类型分为基本类型和引用类型。基本类型有8种，包装类是对基本类型的封装。理解数据类型是Java编程的基础。",
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：基本数据类型",
                    code = """
                        // Java有8种基本数据类型
                        
                        // 1. 整数类型
                        byte b = 127;           // 1字节，-128到127
                        short s = 32767;       // 2字节，-32768到32767
                        int i = 2147483647;     // 4字节，-2^31到2^31-1
                        long l = 9223372036854775807L;  // 8字节，需要L后缀
                        
                        // 2. 浮点类型
                        float f = 3.14f;       // 4字节，需要f后缀
                        double d = 3.141592653589793;  // 8字节，默认浮点类型
                        
                        // 3. 字符类型
                        char c = 'A';          // 2字节，Unicode字符
                        
                        // 4. 布尔类型
                        boolean bool = true;   // 1位，true或false
                        
                        // 5. 默认值（成员变量）
                        class Test {
                            byte b;      // 默认值：0
                            short s;     // 默认值：0
                            int i;       // 默认值：0
                            long l;      // 默认值：0L
                            float f;     // 默认值：0.0f
                            double d;    // 默认值：0.0
                            char c;      // 默认值：'\\u0000'
                            boolean bool; // 默认值：false
                        }
                    """.trimIndent(),
                    explanation = "Java有8种基本数据类型：byte、short、int、long、float、double、char、boolean。成员变量有默认值，局部变量必须初始化。"
                ),
                CodeExample(
                    title = "示例2：引用类型",
                    code = """
                        // 引用类型包括类、接口、数组等
                        
                        // 1. 类类型
                        String str = "Hello";           // String是引用类型
                        Object obj = new Object();      // Object是引用类型
                        
                        // 2. 数组类型
                        int[] arr = new int[10];       // 数组是引用类型
                        String[] strs = {"a", "b", "c"}; // 数组字面量
                        
                        // 3. 接口类型
                        List<String> list = new ArrayList<>(); // 接口引用
                        
                        // 4. 引用类型的默认值
                        class Test {
                            String str;      // 默认值：null
                            Object obj;      // 默认值：null
                            int[] arr;       // 默认值：null
                        }
                        
                        // 5. 引用和对象
                        String s1 = "Hello";
                        String s2 = s1;      // s2和s1指向同一个对象
                        s2 = "World";        // s2指向新对象，s1不变
                    """.trimIndent(),
                    explanation = "引用类型包括类、接口、数组等，变量存储的是对象的引用（地址），默认值为null。多个引用可以指向同一个对象。"
                ),
                CodeExample(
                    title = "示例3：包装类",
                    code = """
                        // 包装类是对基本类型的封装
                        
                        // 1. 包装类类型
                        Integer i = new Integer(10);     // 装箱
                        Integer j = Integer.valueOf(10); // 推荐方式（缓存）
                        int k = i.intValue();            // 拆箱
                        
                        // 2. 自动装箱和拆箱（Java 5+）
                        Integer a = 10;      // 自动装箱
                        int b = a;          // 自动拆箱
                        
                        // 3. 包装类常量
                        System.out.println(Integer.MAX_VALUE);  // 2147483647
                        System.out.println(Integer.MIN_VALUE);  // -2147483648
                        System.out.println(Integer.SIZE);        // 32
                        
                        // 4. 包装类方法
                        String str = "123";
                        int num = Integer.parseInt(str);        // 字符串转int
                        String numStr = Integer.toString(123); // int转字符串
                        
                        // 5. 所有包装类
                        // Byte, Short, Integer, Long
                        // Float, Double
                        // Character
                        // Boolean
                        
                        // 6. 缓存机制
                        Integer x = 127;
                        Integer y = 127;
                        System.out.println(x == y);  // true（缓存范围内）
                        
                        Integer m = 128;
                        Integer n = 128;
                        System.out.println(m == n);  // false（超出缓存范围）
                        System.out.println(m.equals(n)); // true（值相等）
                    """.trimIndent(),
                    explanation = "包装类是对基本类型的封装，提供对象操作和方法。Java 5+支持自动装箱和拆箱。包装类有缓存机制（-128到127）。"
                ),
                CodeExample(
                    title = "示例4：类型转换",
                    code = """
                        // 1. 自动类型转换（隐式转换）
                        int i = 10;
                        long l = i;        // int自动转换为long
                        float f = i;       // int自动转换为float
                        double d = f;      // float自动转换为double
                        
                        // 2. 强制类型转换（显式转换）
                        double d = 3.14;
                        int i = (int) d;    // 强制转换为int，结果为3（截断）
                        
                        long l = 100L;
                        int i2 = (int) l;   // 强制转换
                        
                        // 3. 包装类转换
                        int i = 10;
                        Integer integer = Integer.valueOf(i);  // int转Integer
                        int j = integer.intValue();            // Integer转int
                        
                        // 4. 字符串转换
                        String str = "123";
                        int num = Integer.parseInt(str);      // 字符串转int
                        String numStr = String.valueOf(123);   // int转字符串
                        
                        // 5. 类型提升
                        byte b1 = 10;
                        byte b2 = 20;
                        // byte result = b1 + b2;  // 错误！运算结果提升为int
                        int result = b1 + b2;      // 正确
                        byte result2 = (byte)(b1 + b2); // 强制转换
                    """.trimIndent(),
                    explanation = "类型转换包括自动转换（小类型转大类型）和强制转换（大类型转小类型）。运算时会发生类型提升。"
                )
            ),
            useCases = listOf(
                "变量声明：声明和初始化变量",
                "类型选择：根据需求选择合适的数据类型",
                "包装类使用：在集合中使用包装类",
                "类型转换：在不同类型间转换",
                "性能优化：基本类型性能更好，包装类功能更丰富"
            ),
            keyPoints = listOf(
                "Java有8种基本数据类型：byte、short、int、long、float、double、char、boolean",
                "引用类型包括类、接口、数组，默认值为null",
                "包装类是对基本类型的封装，提供对象操作和方法",
                "Java 5+支持自动装箱和拆箱",
                "类型转换包括自动转换和强制转换"
            ),
            notes = listOf(
                "成员变量有默认值，局部变量必须初始化",
                "包装类有缓存机制（-128到127）",
                "基本类型性能更好，包装类功能更丰富",
                "集合只能存储引用类型，不能存储基本类型",
                "运算时会发生类型提升"
            ),
            practiceTips = "建议：根据需求选择合适的数据类型，基本类型性能更好，包装类功能更丰富。在集合中使用包装类，注意自动装箱和拆箱的性能影响。理解类型转换规则，避免精度丢失。"
        ),
        
        // 2. 运算符（算术、关系、逻辑、位运算）
        KnowledgeDetail(
            id = "java_operators",
            title = "运算符（算术、关系、逻辑、位运算）",
            overview = "Java提供了丰富的运算符，包括算术运算符、关系运算符、逻辑运算符、位运算符等。理解运算符的优先级和结合性是编写正确代码的基础。",
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：算术运算符",
                    code = """
                        // 1. 基本算术运算符
                        int a = 10;
                        int b = 3;
                        
                        System.out.println(a + b);  // 13，加法
                        System.out.println(a - b);  // 7，减法
                        System.out.println(a * b);  // 30，乘法
                        System.out.println(a / b);  // 3，除法（整数除法）
                        System.out.println(a % b);  // 1，取余
                        
                        // 2. 浮点运算
                        double x = 10.0;
                        double y = 3.0;
                        System.out.println(x / y);  // 3.333...，浮点除法
                        
                        // 3. 自增自减运算符
                        int i = 10;
                        System.out.println(i++);    // 10，先使用后自增
                        System.out.println(i);      // 11
                        
                        int j = 10;
                        System.out.println(++j);    // 11，先自增后使用
                        System.out.println(j);      // 11
                        
                        // 4. 复合赋值运算符
                        int num = 10;
                        num += 5;   // 等价于 num = num + 5
                        num -= 3;   // 等价于 num = num - 3
                        num *= 2;   // 等价于 num = num * 2
                        num /= 4;   // 等价于 num = num / 4
                        num %= 3;   // 等价于 num = num % 3
                    """.trimIndent(),
                    explanation = "算术运算符包括+、-、*、/、%，以及自增++、自减--。注意整数除法和浮点除法的区别。"
                ),
                CodeExample(
                    title = "示例2：关系运算符",
                    code = """
                        // 关系运算符返回boolean值
                        
                        int a = 10;
                        int b = 20;
                        
                        System.out.println(a == b);  // false，等于
                        System.out.println(a != b);  // true，不等于
                        System.out.println(a < b);   // true，小于
                        System.out.println(a > b);   // false，大于
                        System.out.println(a <= b);  // true，小于等于
                        System.out.println(a >= b);  // false，大于等于
                        
                        // 2. 对象比较
                        String s1 = "Hello";
                        String s2 = "Hello";
                        String s3 = new String("Hello");
                        
                        System.out.println(s1 == s2);      // true（字符串常量池）
                        System.out.println(s1 == s3);      // false（不同对象）
                        System.out.println(s1.equals(s3)); // true（值相等）
                        
                        // 3. 浮点数比较
                        double x = 0.1 + 0.2;
                        double y = 0.3;
                        System.out.println(x == y);        // false（精度问题）
                        System.out.println(Math.abs(x - y) < 1e-9); // true（误差比较）
                    """.trimIndent(),
                    explanation = "关系运算符用于比较值，返回boolean。注意==比较引用，equals()比较值。浮点数比较需要考虑精度问题。"
                ),
                CodeExample(
                    title = "示例3：逻辑运算符",
                    code = """
                        // 1. 逻辑与（&&）和逻辑或（||）
                        boolean a = true;
                        boolean b = false;
                        
                        System.out.println(a && b);  // false，逻辑与（短路）
                        System.out.println(a || b);  // true，逻辑或（短路）
                        System.out.println(!a);      // false，逻辑非
                        
                        // 2. 短路求值
                        int x = 10;
                        if (x > 0 && x++ < 20) {  // x++不会执行（短路）
                            System.out.println("OK");
                        }
                        System.out.println(x);  // 10
                        
                        // 3. 非短路运算符（&和|）
                        int y = 10;
                        if (y > 0 & y++ < 20) {  // y++会执行
                            System.out.println("OK");
                        }
                        System.out.println(y);  // 11
                        
                        // 4. 逻辑异或（^）
                        System.out.println(true ^ true);   // false
                        System.out.println(true ^ false);  // true
                        System.out.println(false ^ false); // false
                    """.trimIndent(),
                    explanation = "逻辑运算符包括&&（逻辑与，短路）、||（逻辑或，短路）、!（逻辑非）、&（按位与，非短路）、|（按位或，非短路）、^（异或）。"
                ),
                CodeExample(
                    title = "示例4：位运算符",
                    code = """
                        // 位运算符对二进制位进行操作
                        
                        int a = 5;   // 二进制：0101
                        int b = 3;   // 二进制：0011
                        
                        // 1. 按位与（&）
                        System.out.println(a & b);  // 1，二进制：0001
                        // 0101
                        // 0011
                        // ----
                        // 0001
                        
                        // 2. 按位或（|）
                        System.out.println(a | b);  // 7，二进制：0111
                        // 0101
                        // 0011
                        // ----
                        // 0111
                        
                        // 3. 按位异或（^）
                        System.out.println(a ^ b);  // 6，二进制：0110
                        // 0101
                        // 0011
                        // ----
                        // 0110
                        
                        // 4. 按位取反（~）
                        System.out.println(~a);     // -6，二进制：1111...1010
                        
                        // 5. 左移（<<）
                        System.out.println(a << 1); // 10，二进制：1010（左移1位，相当于*2）
                        
                        // 6. 右移（>>）
                        System.out.println(a >> 1); // 2，二进制：0010（右移1位，相当于/2）
                        
                        // 7. 无符号右移（>>>）
                        int c = -8;
                        System.out.println(c >> 1);  // -4（符号位填充）
                        System.out.println(c >>> 1); // 2147483644（0填充）
                    """.trimIndent(),
                    explanation = "位运算符对二进制位进行操作，包括&（按位与）、|（按位或）、^（按位异或）、~（按位取反）、<<（左移）、>>（右移）、>>>（无符号右移）。"
                ),
                CodeExample(
                    title = "示例5：运算符优先级",
                    code = """
                        // 运算符优先级（从高到低）
                        
                        // 1. 括号优先级最高
                        int result1 = (2 + 3) * 4;  // 20
                        int result2 = 2 + 3 * 4;     // 14
                        
                        // 2. 算术运算符 > 关系运算符 > 逻辑运算符
                        boolean b1 = 2 + 3 > 4 && 5 < 6;  // true
                        // 等价于：(2 + 3) > 4 && 5 < 6
                        
                        // 3. 常见优先级顺序
                        // 1. () [] .
                        // 2. ++ -- ! ~
                        // 3. * / %
                        // 4. + -
                        // 5. << >> >>>
                        // 6. < > <= >= instanceof
                        // 7. == !=
                        // 8. &
                        // 9. ^
                        // 10. |
                        // 11. &&
                        // 12. ||
                        // 13. ?:
                        // 14. = += -= *= /= %=
                        
                        // 4. 使用括号提高可读性
                        int x = 10;
                        int y = 20;
                        int z = 30;
                        boolean result = (x > 0) && (y > 0) || (z > 0);  // 清晰
                    """.trimIndent(),
                    explanation = "运算符有优先级，括号优先级最高。建议使用括号提高代码可读性，避免依赖优先级。"
                )
            ),
            useCases = listOf(
                "算术运算：进行数学计算",
                "条件判断：使用关系运算符和逻辑运算符",
                "位操作：进行位级别的操作（性能优化）",
                "数据转换：使用位移运算符进行快速乘除",
                "条件表达式：使用三元运算符简化代码"
            ),
            keyPoints = listOf(
                "算术运算符包括+、-、*、/、%、++、--",
                "关系运算符返回boolean值，用于比较",
                "逻辑运算符包括&&、||、!，支持短路求值",
                "位运算符对二进制位进行操作",
                "运算符有优先级，括号优先级最高"
            ),
            notes = listOf(
                "注意整数除法和浮点除法的区别",
                "==比较引用，equals()比较值",
                "&&和||支持短路求值，提高性能",
                "位运算符可以用于性能优化",
                "使用括号提高代码可读性"
            ),
            practiceTips = "建议：理解运算符的优先级和结合性，使用括号提高代码可读性。注意==和equals()的区别，浮点数比较考虑精度问题。合理使用位运算符进行性能优化。"
        ),
        
        // 3. 控制流（if-else、switch、for、while）
        KnowledgeDetail(
            id = "java_control_flow",
            title = "控制流（if-else、switch、for、while）",
            overview = "控制流语句用于控制程序的执行顺序，包括条件语句（if-else、switch）和循环语句（for、while、do-while）。理解控制流是编写逻辑代码的基础。",
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：if-else语句",
                    code = """
                        // 1. 基本if语句
                        int score = 85;
                        if (score >= 60) {
                            System.out.println("及格");
                        }
                        
                        // 2. if-else语句
                        if (score >= 90) {
                            System.out.println("优秀");
                        } else if (score >= 80) {
                            System.out.println("良好");
                        } else if (score >= 60) {
                            System.out.println("及格");
                        } else {
                            System.out.println("不及格");
                        }
                        
                        // 3. 三元运算符
                        String result = score >= 60 ? "及格" : "不及格";
                        
                        // 4. 嵌套if语句
                        if (score >= 60) {
                            if (score >= 90) {
                                System.out.println("优秀");
                            } else {
                                System.out.println("及格");
                            }
                        }
                    """.trimIndent(),
                    explanation = "if-else语句用于条件判断，支持多分支。三元运算符可以简化简单的if-else。"
                ),
                CodeExample(
                    title = "示例2：switch语句",
                    code = """
                        // 1. 传统switch语句
                        int day = 3;
                        switch (day) {
                            case 1:
                                System.out.println("星期一");
                                break;
                            case 2:
                                System.out.println("星期二");
                                break;
                            case 3:
                                System.out.println("星期三");
                                break;
                            default:
                                System.out.println("其他");
                        }
                        
                        // 2. switch表达式（Java 14+）
                        String dayName = switch (day) {
                            case 1 -> "星期一";
                            case 2 -> "星期二";
                            case 3 -> "星期三";
                            default -> "其他";
                        };
                        
                        // 3. yield关键字（Java 14+）
                        int result = switch (day) {
                            case 1, 2, 3, 4, 5 -> {
                                System.out.println("工作日");
                                yield 1;
                            }
                            case 6, 7 -> {
                                System.out.println("周末");
                                yield 2;
                            }
                            default -> 0;
                        };
                        
                        // 4. 字符串switch（Java 7+）
                        String color = "red";
                        switch (color) {
                            case "red":
                                System.out.println("红色");
                                break;
                            case "blue":
                                System.out.println("蓝色");
                                break;
                            default:
                                System.out.println("其他颜色");
                        }
                    """.trimIndent(),
                    explanation = "switch语句用于多分支选择，支持整数、字符、字符串、枚举。Java 14+支持switch表达式和yield关键字。"
                ),
                CodeExample(
                    title = "示例3：for循环",
                    code = """
                        // 1. 传统for循环
                        for (int i = 0; i < 10; i++) {
                            System.out.println(i);
                        }
                        
                        // 2. 增强for循环（for-each）
                        int[] arr = {1, 2, 3, 4, 5};
                        for (int num : arr) {
                            System.out.println(num);
                        }
                        
                        List<String> list = Arrays.asList("a", "b", "c");
                        for (String str : list) {
                            System.out.println(str);
                        }
                        
                        // 3. 嵌套for循环
                        for (int i = 1; i <= 9; i++) {
                            for (int j = 1; j <= i; j++) {
                                System.out.print(j + "*" + i + "=" + (i * j) + "\\t");
                            }
                            System.out.println();
                        }
                        
                        // 4. 循环控制
                        for (int i = 0; i < 10; i++) {
                            if (i == 5) {
                                break;      // 跳出循环
                            }
                            if (i % 2 == 0) {
                                continue;   // 跳过本次循环
                            }
                            System.out.println(i);
                        }
                    """.trimIndent(),
                    explanation = "for循环用于重复执行代码，支持传统for循环和增强for循环（for-each）。break跳出循环，continue跳过本次循环。"
                ),
                CodeExample(
                    title = "示例4：while和do-while循环",
                    code = """
                        // 1. while循环
                        int i = 0;
                        while (i < 10) {
                            System.out.println(i);
                            i++;
                        }
                        
                        // 2. do-while循环（至少执行一次）
                        int j = 0;
                        do {
                            System.out.println(j);
                            j++;
                        } while (j < 10);
                        
                        // 3. 无限循环
                        while (true) {
                            // 需要break或return退出
                            if (condition) {
                                break;
                            }
                        }
                        
                        // 4. 循环控制
                        int k = 0;
                        while (k < 10) {
                            if (k == 5) {
                                break;      // 跳出循环
                            }
                            if (k % 2 == 0) {
                                k++;
                                continue;   // 跳过本次循环
                            }
                            System.out.println(k);
                            k++;
                        }
                    """.trimIndent(),
                    explanation = "while循环先判断条件再执行，do-while循环先执行再判断（至少执行一次）。break跳出循环，continue跳过本次循环。"
                ),
                CodeExample(
                    title = "示例5：标签和跳转",
                    code = """
                        // 1. 标签break
                        outer: for (int i = 0; i < 3; i++) {
                            inner: for (int j = 0; j < 3; j++) {
                                if (i == 1 && j == 1) {
                                    break outer;  // 跳出外层循环
                                }
                                System.out.println(i + ", " + j);
                            }
                        }
                        
                        // 2. 标签continue
                        outer: for (int i = 0; i < 3; i++) {
                            inner: for (int j = 0; j < 3; j++) {
                                if (i == 1 && j == 1) {
                                    continue outer;  // 继续外层循环
                                }
                                System.out.println(i + ", " + j);
                            }
                        }
                        
                        // 3. return语句
                        public int findIndex(int[] arr, int target) {
                            for (int i = 0; i < arr.length; i++) {
                                if (arr[i] == target) {
                                    return i;  // 返回并退出方法
                                }
                            }
                            return -1;
                        }
                    """.trimIndent(),
                    explanation = "标签可以用于控制嵌套循环的跳转。return语句用于退出方法并返回值。"
                )
            ),
            useCases = listOf(
                "条件判断：使用if-else和switch进行条件判断",
                "循环处理：使用for、while进行重复操作",
                "数据遍历：使用增强for循环遍历集合",
                "流程控制：使用break、continue控制循环流程",
                "嵌套逻辑：使用嵌套控制流处理复杂逻辑"
            ),
            keyPoints = listOf(
                "if-else用于条件判断，支持多分支",
                "switch用于多分支选择，支持多种类型",
                "for循环用于重复执行，支持传统和增强for循环",
                "while和do-while用于条件循环",
                "break跳出循环，continue跳过本次循环"
            ),
            notes = listOf(
                "switch语句需要break，否则会继续执行（fall-through）",
                "增强for循环不能修改集合元素",
                "do-while至少执行一次",
                "标签可以用于控制嵌套循环",
                "合理使用控制流提高代码可读性"
            ),
            practiceTips = "建议：合理使用控制流语句，提高代码可读性。注意switch的fall-through特性，使用break避免意外执行。增强for循环适合遍历，但不能修改集合。使用标签控制嵌套循环的跳转。"
        ),
        
        // 4. 方法和函数（重载、参数传递、可变参数）
        KnowledgeDetail(
            id = "java_methods",
            title = "方法和函数（重载、参数传递、可变参数）",
            overview = "方法是Java中组织代码的基本单位。方法可以重载，支持可变参数，理解参数传递机制（值传递）是编写正确代码的关键。",
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：方法声明和调用",
                    code = """
                        // 1. 方法声明
                        public class Calculator {
                            // 方法修饰符 返回类型 方法名(参数列表)
                            public int add(int a, int b) {
                                return a + b;  // 返回值
                            }
                            
                            // 无返回值方法
                            public void print(String message) {
                                System.out.println(message);
                            }
                            
                            // 静态方法
                            public static int multiply(int a, int b) {
                                return a * b;
                            }
                        }
                        
                        // 2. 方法调用
                        Calculator calc = new Calculator();
                        int result = calc.add(3, 5);  // 实例方法调用
                        calc.print("Hello");
                        
                        int product = Calculator.multiply(3, 5);  // 静态方法调用
                    """.trimIndent(),
                    explanation = "方法包括修饰符、返回类型、方法名、参数列表和方法体。实例方法通过对象调用，静态方法通过类名调用。"
                ),
                CodeExample(
                    title = "示例2：方法重载",
                    code = """
                        // 方法重载：同一类中方法名相同，参数列表不同
                        public class MathUtils {
                            // 重载1：两个int参数
                            public int add(int a, int b) {
                                return a + b;
                            }
                            
                            // 重载2：三个int参数
                            public int add(int a, int b, int c) {
                                return a + b + c;
                            }
                            
                            // 重载3：两个double参数
                            public double add(double a, double b) {
                                return a + b;
                            }
                            
                            // 重载4：int和double参数
                            public double add(int a, double b) {
                                return a + b;
                            }
                        }
                        
                        // 使用
                        MathUtils utils = new MathUtils();
                        int result1 = utils.add(3, 5);        // 调用重载1
                        int result2 = utils.add(3, 5, 7);   // 调用重载2
                        double result3 = utils.add(3.0, 5.0); // 调用重载3
                        double result4 = utils.add(3, 5.0);   // 调用重载4
                        
                        // 注意：仅返回类型不同不能构成重载
                        // public int add(int a, int b) { ... }
                        // public double add(int a, int b) { ... }  // 错误！
                    """.trimIndent(),
                    explanation = "方法重载要求方法名相同，参数列表不同（参数类型、个数、顺序）。仅返回类型不同不能构成重载。"
                ),
                CodeExample(
                    title = "示例3：参数传递（值传递）",
                    code = """
                        // Java中参数传递是值传递
                        
                        // 1. 基本类型参数传递
                        public void modifyPrimitive(int x) {
                            x = 100;  // 修改的是副本，不影响原值
                        }
                        
                        int num = 10;
                        modifyPrimitive(num);
                        System.out.println(num);  // 10，未改变
                        
                        // 2. 引用类型参数传递
                        public void modifyReference(int[] arr) {
                            arr[0] = 100;  // 修改数组元素，影响原数组
                            arr = new int[]{999};  // 修改引用，不影响原引用
                        }
                        
                        int[] array = {1, 2, 3};
                        modifyReference(array);
                        System.out.println(array[0]);  // 100，改变了
                        System.out.println(array.length);  // 3，未改变
                        
                        // 3. 对象参数传递
                        class Person {
                            String name;
                            Person(String name) { this.name = name; }
                        }
                        
                        public void modifyObject(Person p) {
                            p.name = "Changed";  // 修改对象属性，影响原对象
                            p = new Person("New");  // 修改引用，不影响原引用
                        }
                        
                        Person person = new Person("Original");
                        modifyObject(person);
                        System.out.println(person.name);  // "Changed"，改变了
                    """.trimIndent(),
                    explanation = "Java参数传递是值传递：基本类型传递值副本，引用类型传递引用副本。修改引用不影响原引用，但修改对象属性会影响原对象。"
                ),
                CodeExample(
                    title = "示例4：可变参数",
                    code = """
                        // 可变参数（varargs）：参数数量可变
                        
                        // 1. 基本使用
                        public int sum(int... numbers) {
                            int total = 0;
                            for (int num : numbers) {
                                total += num;
                            }
                            return total;
                        }
                        
                        int result1 = sum(1, 2, 3);           // 3个参数
                        int result2 = sum(1, 2, 3, 4, 5);      // 5个参数
                        int result3 = sum();                   // 0个参数
                        
                        // 2. 可变参数本质是数组
                        public void print(String... messages) {
                            for (String msg : messages) {
                                System.out.println(msg);
                            }
                            // 等价于
                            // for (int i = 0; i < messages.length; i++) {
                            //     System.out.println(messages[i]);
                            // }
                        }
                        
                        // 3. 可变参数必须放在最后
                        public void method(String name, int... numbers) {
                            // 正确
                        }
                        
                        // public void method(int... numbers, String name) {
                        //     // 错误！可变参数必须在最后
                        // }
                        
                        // 4. 方法重载和可变参数
                        public void test(int a) {
                            System.out.println("一个参数");
                        }
                        
                        public void test(int... a) {
                            System.out.println("可变参数");
                        }
                        
                        test(1);      // 调用一个参数版本
                        test(1, 2);   // 调用可变参数版本
                    """.trimIndent(),
                    explanation = "可变参数使用...语法，本质是数组，必须放在参数列表最后。可以传递0个或多个参数。"
                ),
                CodeExample(
                    title = "示例5：方法返回值和return",
                    code = """
                        // 1. 有返回值方法
                        public int getMax(int a, int b) {
                            if (a > b) {
                                return a;  // 返回值并退出方法
                            }
                            return b;     // 返回值并退出方法
                        }
                        
                        // 2. 无返回值方法（void）
                        public void printMessage(String msg) {
                            System.out.println(msg);
                            // 可以提前返回
                            if (msg == null) {
                                return;  // 退出方法，不返回值
                            }
                            System.out.println("Message: " + msg);
                        }
                        
                        // 3. 返回对象
                        public Person createPerson(String name, int age) {
                            return new Person(name, age);
                        }
                        
                        // 4. 返回数组
                        public int[] getNumbers() {
                            return new int[]{1, 2, 3, 4, 5};
                        }
                        
                        // 5. 返回集合
                        public List<String> getNames() {
                            return Arrays.asList("Alice", "Bob", "Charlie");
                        }
                        
                        // 6. 方法链式调用
                        public class StringBuilder {
                            private String str = "";
                            
                            public StringBuilder append(String s) {
                                str += s;
                                return this;  // 返回自身，支持链式调用
                            }
                            
                            public String toString() {
                                return str;
                            }
                        }
                        
                        StringBuilder sb = new StringBuilder();
                        sb.append("Hello").append(" ").append("World");
                    """.trimIndent(),
                    explanation = "方法可以返回基本类型、对象、数组、集合等。void方法不返回值，可以使用return提前退出。返回this支持链式调用。"
                )
            ),
            useCases = listOf(
                "代码组织：使用方法组织代码逻辑",
                "代码复用：通过方法调用复用代码",
                "参数处理：使用重载和可变参数处理不同情况",
                "数据传递：理解值传递机制",
                "链式调用：返回this支持链式调用"
            ),
            keyPoints = listOf(
                "方法包括修饰符、返回类型、方法名、参数列表和方法体",
                "方法重载要求方法名相同，参数列表不同",
                "Java参数传递是值传递",
                "可变参数使用...语法，本质是数组",
                "方法可以返回基本类型、对象、数组、集合等"
            ),
            notes = listOf(
                "仅返回类型不同不能构成重载",
                "基本类型传递值副本，引用类型传递引用副本",
                "可变参数必须放在参数列表最后",
                "void方法可以使用return提前退出",
                "返回this支持链式调用"
            ),
            practiceTips = "建议：合理使用方法组织代码，提高代码复用性。使用方法重载处理不同参数情况。理解值传递机制，避免意外的副作用。可变参数适合处理参数数量不确定的情况。"
        ),
        
        // ========== Java 面向对象编程 ==========
        
        // 1. 类和对象（构造函数、初始化块）
        KnowledgeDetail(
            id = "java_class_object",
            title = "类和对象（构造函数、初始化块）",
            overview = "类是Java面向对象编程的基础，对象是类的实例。构造函数用于初始化对象，初始化块用于执行初始化代码。理解类和对象是掌握面向对象编程的关键。",
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：类声明和对象创建",
                    code = """
                        // 1. 类声明
                        public class Person {
                            // 成员变量（属性）
                            private String name;
                            private int age;
                            
                            // 方法
                            public void introduce() {
                                System.out.println("I'm " + name + ", " + age + " years old.");
                            }
                        }
                        
                        // 2. 对象创建
                        Person person = new Person();  // 使用new关键字创建对象
                        person.name = "Alice";
                        person.age = 25;
                        person.introduce();
                        
                        // 3. 对象引用
                        Person p1 = new Person();
                        Person p2 = p1;  // p2和p1指向同一个对象
                        p2.name = "Bob";
                        System.out.println(p1.name);  // "Bob"，因为指向同一个对象
                    """.trimIndent(),
                    explanation = "类使用class关键字声明，包含成员变量和方法。使用new关键字创建对象，对象变量存储的是对象的引用。"
                ),
                CodeExample(
                    title = "示例2：构造函数",
                    code = """
                        public class Person {
                            private String name;
                            private int age;
                            
                            // 1. 默认构造函数（无参）
                            public Person() {
                                this.name = "Unknown";
                                this.age = 0;
                            }
                            
                            // 2. 带参构造函数
                            public Person(String name, int age) {
                                this.name = name;  // this引用当前对象
                                this.age = age;
                            }
                            
                            // 3. 构造函数重载
                            public Person(String name) {
                                this(name, 0);  // 调用其他构造函数
                            }
                            
                            // 4. 私有构造函数（单例模式）
                            private Person(String name, int age, boolean flag) {
                                // 特殊用途
                            }
                        }
                        
                        // 使用
                        Person p1 = new Person();              // 调用无参构造函数
                        Person p2 = new Person("Alice", 25);   // 调用带参构造函数
                        Person p3 = new Person("Bob");         // 调用单参构造函数
                    """.trimIndent(),
                    explanation = "构造函数用于初始化对象，与类名相同，无返回类型。可以重载，支持this()调用其他构造函数。"
                ),
                CodeExample(
                    title = "示例3：初始化块",
                    code = """
                        public class Person {
                            private String name;
                            private int age;
                            
                            // 1. 实例初始化块（每次创建对象时执行）
                            {
                                System.out.println("实例初始化块执行");
                                name = "Default";
                                age = 0;
                            }
                            
                            // 2. 静态初始化块（类加载时执行一次）
                            static {
                                System.out.println("静态初始化块执行");
                            }
                            
                            // 3. 构造函数
                            public Person(String name, int age) {
                                System.out.println("构造函数执行");
                                this.name = name;
                                this.age = age;
                            }
                            
                            // 执行顺序：
                            // 1. 静态初始化块（类加载时）
                            // 2. 实例初始化块（对象创建时）
                            // 3. 构造函数（对象创建时）
                        }
                        
                        // 使用
                        Person p = new Person("Alice", 25);
                        // 输出：
                        // 静态初始化块执行（如果类未加载）
                        // 实例初始化块执行
                        // 构造函数执行
                    """.trimIndent(),
                    explanation = "初始化块用于执行初始化代码。实例初始化块每次创建对象时执行，静态初始化块类加载时执行一次。执行顺序：静态初始化块 -> 实例初始化块 -> 构造函数。"
                ),
                CodeExample(
                    title = "示例4：this关键字",
                    code = """
                        public class Person {
                            private String name;
                            private int age;
                            
                            public Person(String name, int age) {
                                this.name = name;      // this引用当前对象
                                this.age = age;
                            }
                            
                            // this调用其他构造函数
                            public Person(String name) {
                                this(name, 0);  // 必须放在第一行
                            }
                            
                            // this作为参数传递
                            public void printInfo() {
                                print(this);  // 传递当前对象
                            }
                            
                            public void print(Person p) {
                                System.out.println(p.name + ", " + p.age);
                            }
                            
                            // this返回当前对象（链式调用）
                            public Person setName(String name) {
                                this.name = name;
                                return this;  // 返回当前对象
                            }
                            
                            public Person setAge(int age) {
                                this.age = age;
                                return this;
                            }
                        }
                        
                        // 使用
                        Person p = new Person("Alice", 25);
                        p.setName("Bob").setAge(30);  // 链式调用
                    """.trimIndent(),
                    explanation = "this关键字引用当前对象，可以用于访问成员变量、调用其他构造函数、作为参数传递、返回当前对象支持链式调用。"
                )
            ),
            useCases = listOf(
                "对象建模：使用类建模现实世界实体",
                "代码组织：使用类组织相关代码",
                "对象创建：使用构造函数初始化对象",
                "初始化逻辑：使用初始化块执行初始化代码",
                "链式调用：返回this支持链式调用"
            ),
            keyPoints = listOf(
                "类使用class关键字声明，包含成员变量和方法",
                "使用new关键字创建对象，对象变量存储引用",
                "构造函数用于初始化对象，与类名相同",
                "初始化块用于执行初始化代码",
                "this关键字引用当前对象"
            ),
            notes = listOf(
                "对象变量存储的是对象的引用，不是对象本身",
                "构造函数可以重载，支持this()调用其他构造函数",
                "静态初始化块类加载时执行一次",
                "实例初始化块每次创建对象时执行",
                "this()调用必须放在构造函数第一行"
            ),
            practiceTips = "建议：合理设计类的结构，使用构造函数初始化对象。使用初始化块处理复杂的初始化逻辑。理解this关键字的使用，支持链式调用提高代码可读性。"
        ),
        
        // 2. 封装（访问修饰符、Getter/Setter）
        KnowledgeDetail(
            id = "java_encapsulation",
            title = "封装（访问修饰符、Getter/Setter）",
            overview = "封装是面向对象编程的核心特性之一，通过访问修饰符控制成员的可见性，使用Getter/Setter方法访问和修改私有属性。封装提高了代码的安全性和可维护性。",
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：访问修饰符",
                    code = """
                        public class AccessModifiers {
                            public int publicVar = 1;        // 公共，任何地方可访问
                            protected int protectedVar = 2;  // 受保护，同包或子类可访问
                            int defaultVar = 3;              // 默认，同包可访问
                            private int privateVar = 4;      // 私有，仅本类可访问
                            
                            public void test() {
                                System.out.println(publicVar);     // ✅ 本类可访问
                                System.out.println(protectedVar); // ✅ 本类可访问
                                System.out.println(defaultVar);    // ✅ 本类可访问
                                System.out.println(privateVar);    // ✅ 本类可访问
                            }
                        }
                        
                        class SubClass extends AccessModifiers {
                            public void test() {
                                System.out.println(publicVar);     // ✅ 子类可访问
                                System.out.println(protectedVar);   // ✅ 子类可访问
                                System.out.println(defaultVar);    // ✅ 同包可访问
                                // System.out.println(privateVar); // ❌ 私有，不可访问
                            }
                        }
                    """.trimIndent(),
                    explanation = "Java有4种访问修饰符：public（公共）、protected（受保护）、默认（包私有）、private（私有）。访问修饰符控制成员的可见性。"
                ),
                CodeExample(
                    title = "示例2：Getter/Setter方法",
                    code = """
                        public class Person {
                            // 私有属性
                            private String name;
                            private int age;
                            
                            // Getter方法（获取属性值）
                            public String getName() {
                                return name;
                            }
                            
                            public int getAge() {
                                return age;
                            }
                            
                            // Setter方法（设置属性值）
                            public void setName(String name) {
                                // 可以添加验证逻辑
                                if (name == null || name.trim().isEmpty()) {
                                    throw new IllegalArgumentException("Name cannot be empty");
                                }
                                this.name = name;
                            }
                            
                            public void setAge(int age) {
                                // 可以添加验证逻辑
                                if (age < 0 || age > 150) {
                                    throw new IllegalArgumentException("Invalid age");
                                }
                                this.age = age;
                            }
                        }
                        
                        // 使用
                        Person person = new Person();
                        person.setName("Alice");
                        person.setAge(25);
                        System.out.println(person.getName());  // "Alice"
                        System.out.println(person.getAge());   // 25
                    """.trimIndent(),
                    explanation = "Getter/Setter方法用于访问和修改私有属性。Getter返回属性值，Setter设置属性值，可以在Setter中添加验证逻辑。"
                ),
                CodeExample(
                    title = "示例3：封装的优点",
                    code = """
                        // 1. 数据保护
                        public class BankAccount {
                            private double balance;
                            
                            public void deposit(double amount) {
                                if (amount > 0) {
                                    balance += amount;
                                }
                            }
                            
                            public void withdraw(double amount) {
                                if (amount > 0 && amount <= balance) {
                                    balance -= amount;
                                } else {
                                    throw new IllegalArgumentException("Invalid amount");
                                }
                            }
                            
                            public double getBalance() {
                                return balance;
                            }
                        }
                        
                        // 2. 灵活性（可以改变实现而不影响调用者）
                        public class Temperature {
                            private double celsius;
                            
                            // 可以改变内部实现，但接口不变
                            public double getCelsius() {
                                return celsius;
                            }
                            
                            public double getFahrenheit() {
                                return celsius * 9.0 / 5.0 + 32;
                            }
                            
                            public void setCelsius(double celsius) {
                                this.celsius = celsius;
                            }
                            
                            public void setFahrenheit(double fahrenheit) {
                                this.celsius = (fahrenheit - 32) * 5.0 / 9.0;
                            }
                        }
                    """.trimIndent(),
                    explanation = "封装提供了数据保护、灵活性、可维护性等优点。可以控制数据的访问和修改，改变实现而不影响调用者。"
                )
            ),
            useCases = listOf(
                "数据保护：使用private保护数据，通过方法访问",
                "数据验证：在Setter中添加验证逻辑",
                "灵活性：改变实现而不影响调用者",
                "代码维护：封装提高代码的可维护性",
                "API设计：提供清晰的公共接口"
            ),
            keyPoints = listOf(
                "Java有4种访问修饰符：public、protected、默认、private",
                "Getter/Setter方法用于访问和修改私有属性",
                "封装提供了数据保护、灵活性、可维护性",
                "可以在Setter中添加验证逻辑",
                "封装是面向对象编程的核心特性"
            ),
            notes = listOf(
                "private成员仅本类可访问",
                "protected成员同包或子类可访问",
                "默认成员同包可访问",
                "public成员任何地方可访问",
                "合理使用访问修饰符提高代码安全性"
            ),
            practiceTips = "建议：合理使用访问修饰符控制成员的可见性，优先使用private保护数据。使用Getter/Setter方法访问和修改属性，在Setter中添加验证逻辑。封装提高代码的安全性和可维护性。"
        ),
        
        // 3. 继承（extends、方法重写、super）
        KnowledgeDetail(
            id = "java_inheritance",
            title = "继承（extends、方法重写、super）",
            overview = "继承是面向对象编程的核心特性，允许子类继承父类的成员。使用extends关键字实现继承，可以重写父类方法，使用super关键字访问父类成员。",
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：继承基础",
                    code = """
                        // 父类
                        public class Animal {
                            protected String name;
                            protected int age;
                            
                            public Animal(String name, int age) {
                                this.name = name;
                                this.age = age;
                            }
                            
                            public void eat() {
                                System.out.println(name + " is eating");
                            }
                            
                            public void sleep() {
                                System.out.println(name + " is sleeping");
                            }
                        }
                        
                        // 子类继承父类
                        public class Dog extends Animal {
                            private String breed;
                            
                            public Dog(String name, int age, String breed) {
                                super(name, age);  // 调用父类构造函数
                                this.breed = breed;
                            }
                            
                            // 子类可以添加新方法
                            public void bark() {
                                System.out.println(name + " is barking");
                            }
                        }
                        
                        // 使用
                        Dog dog = new Dog("Buddy", 3, "Golden Retriever");
                        dog.eat();    // 继承自父类
                        dog.sleep();  // 继承自父类
                        dog.bark();   // 子类特有方法
                    """.trimIndent(),
                    explanation = "使用extends关键字实现继承，子类继承父类的成员（属性和方法）。子类可以添加新成员，使用super调用父类构造函数。"
                ),
                CodeExample(
                    title = "示例2：方法重写（Override）",
                    code = """
                        public class Animal {
                            public void makeSound() {
                                System.out.println("Animal makes sound");
                            }
                            
                            public void move() {
                                System.out.println("Animal moves");
                            }
                        }
                        
                        public class Dog extends Animal {
                            // 重写父类方法
                            @Override
                            public void makeSound() {
                                System.out.println("Dog barks");
                            }
                            
                            // 可以调用父类方法
                            @Override
                            public void move() {
                                super.move();  // 调用父类方法
                                System.out.println("Dog runs");
                            }
                        }
                        
                        // 使用
                        Animal animal = new Dog();
                        animal.makeSound();  // "Dog barks"（多态）
                        animal.move();       // "Animal moves" + "Dog runs"
                    """.trimIndent(),
                    explanation = "方法重写使用@Override注解，子类可以重写父类方法。使用super调用父类方法。重写方法签名必须相同，访问权限不能更严格。"
                ),
                CodeExample(
                    title = "示例3：super关键字",
                    code = """
                        public class Animal {
                            protected String name;
                            
                            public Animal(String name) {
                                this.name = name;
                            }
                            
                            public void display() {
                                System.out.println("Animal: " + name);
                            }
                        }
                        
                        public class Dog extends Animal {
                            private String breed;
                            
                            public Dog(String name, String breed) {
                                super(name);  // 调用父类构造函数
                                this.breed = breed;
                            }
                            
                            @Override
                            public void display() {
                                super.display();  // 调用父类方法
                                System.out.println("Breed: " + breed);
                            }
                            
                            public void showInfo() {
                                System.out.println(super.name);  // 访问父类属性
                            }
                        }
                    """.trimIndent(),
                    explanation = "super关键字用于访问父类成员：super()调用父类构造函数，super.method()调用父类方法，super.variable访问父类属性。"
                ),
                CodeExample(
                    title = "示例4：继承的限制",
                    code = """
                        // 1. Java不支持多继承（一个类只能继承一个父类）
                        // public class Dog extends Animal, Mammal { }  // ❌ 错误
                        
                        // 2. final类不能被继承
                        final class FinalClass {
                            // ...
                        }
                        // class SubClass extends FinalClass { }  // ❌ 错误
                        
                        // 3. final方法不能被重写
                        public class Animal {
                            public final void cannotOverride() {
                                // ...
                            }
                        }
                        
                        public class Dog extends Animal {
                            // public void cannotOverride() { }  // ❌ 错误
                        }
                        
                        // 4. private方法不能被重写（实际上是被隐藏）
                        public class Animal {
                            private void privateMethod() {
                                // ...
                            }
                        }
                        
                        public class Dog extends Animal {
                            private void privateMethod() {  // 这是新方法，不是重写
                                // ...
                            }
                        }
                    """.trimIndent(),
                    explanation = "Java继承的限制：不支持多继承，final类不能被继承，final方法不能被重写，private方法不能被重写（被隐藏）。"
                )
            ),
            useCases = listOf(
                "代码复用：通过继承复用父类代码",
                "多态实现：通过继承实现多态",
                "扩展功能：子类扩展父类功能",
                "代码组织：使用继承组织类层次结构",
                "设计模式：继承是许多设计模式的基础"
            ),
            keyPoints = listOf(
                "使用extends关键字实现继承",
                "子类继承父类的成员（属性和方法）",
                "方法重写使用@Override注解",
                "super关键字用于访问父类成员",
                "Java不支持多继承"
            ),
            notes = listOf(
                "子类可以添加新成员，重写父类方法",
                "重写方法签名必须相同，访问权限不能更严格",
                "super()调用必须放在构造函数第一行",
                "final类不能被继承，final方法不能被重写",
                "合理使用继承提高代码复用性"
            ),
            practiceTips = "建议：合理使用继承提高代码复用性，注意继承的层次不要过深。使用方法重写实现多态，使用super访问父类成员。注意继承的限制，避免过度使用继承。"
        ),
        
        // 4. 多态（运行时多态、向上转型、向下转型）
        KnowledgeDetail(
            id = "java_polymorphism",
            title = "多态（运行时多态、向上转型、向下转型）",
            overview = "多态是面向对象编程的核心特性，允许同一接口处理不同类型的对象。运行时多态通过方法重写实现，向上转型和向下转型是多态的体现。",
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：运行时多态",
                    code = """
                        class Animal {
                            public void makeSound() {
                                System.out.println("Animal makes sound");
                            }
                        }
                        
                        class Dog extends Animal {
                            @Override
                            public void makeSound() {
                                System.out.println("Dog barks");
                            }
                        }
                        
                        class Cat extends Animal {
                            @Override
                            public void makeSound() {
                                System.out.println("Cat meows");
                            }
                        }
                        
                        // 运行时多态
                        Animal animal1 = new Dog();
                        Animal animal2 = new Cat();
                        animal1.makeSound();  // "Dog barks"（运行时决定）
                        animal2.makeSound();  // "Cat meows"（运行时决定）
                    """.trimIndent(),
                    explanation = "运行时多态通过方法重写实现，在运行时根据对象的实际类型调用相应的方法。"
                ),
                CodeExample(
                    title = "示例2：向上转型和向下转型",
                    code = """
                        class Animal {
                            public void eat() {
                                System.out.println("Animal eats");
                            }
                        }
                        
                        class Dog extends Animal {
                            @Override
                            public void eat() {
                                System.out.println("Dog eats");
                            }
                            
                            public void bark() {
                                System.out.println("Dog barks");
                            }
                        }
                        
                        // 向上转型（自动，安全）
                        Animal animal = new Dog();  // Dog向上转型为Animal
                        animal.eat();  // ✅ 可以调用
                        // animal.bark();  // ❌ 错误！Animal类型没有bark方法
                        
                        // 向下转型（需要强制转换，可能不安全）
                        if (animal instanceof Dog) {
                            Dog dog = (Dog) animal;  // 向下转型
                            dog.bark();  // ✅ 可以调用
                        }
                    """.trimIndent(),
                    explanation = "向上转型是自动的、安全的，向下转型需要强制转换，可能不安全，应使用instanceof检查。"
                ),
                CodeExample(
                    title = "示例3：多态的应用",
                    code = """
                        // 多态允许同一接口处理不同类型的对象
                        class Shape {
                            public void draw() {
                                System.out.println("Drawing shape");
                            }
                        }
                        
                        class Circle extends Shape {
                            @Override
                            public void draw() {
                                System.out.println("Drawing circle");
                            }
                        }
                        
                        class Rectangle extends Shape {
                            @Override
                            public void draw() {
                                System.out.println("Drawing rectangle");
                            }
                        }
                        
                        // 使用多态
                        Shape[] shapes = {new Circle(), new Rectangle(), new Circle()};
                        for (Shape shape : shapes) {
                            shape.draw();  // 多态调用
                        }
                    """.trimIndent(),
                    explanation = "多态允许同一接口处理不同类型的对象，提高代码的灵活性和可扩展性。"
                )
            ),
            useCases = listOf(
                "接口统一：使用多态统一处理不同类型的对象",
                "代码扩展：添加新类型不需要修改现有代码",
                "设计模式：多态是许多设计模式的基础",
                "框架设计：使用多态设计灵活的框架",
                "代码复用：通过多态提高代码复用性"
            ),
            keyPoints = listOf(
                "多态是面向对象编程的核心特性",
                "运行时多态通过方法重写实现",
                "向上转型是自动的、安全的",
                "向下转型需要强制转换，应使用instanceof检查",
                "多态提高代码的灵活性和可扩展性"
            ),
            notes = listOf(
                "运行时多态在运行时根据对象的实际类型调用方法",
                "向上转型后只能访问父类成员",
                "向下转型前应使用instanceof检查",
                "多态是方法重写的体现",
                "合理使用多态提高代码质量"
            ),
            practiceTips = "建议：合理使用多态提高代码的灵活性和可扩展性。注意向上转型和向下转型的区别，向下转型前使用instanceof检查。多态是面向对象编程的核心，理解多态有助于设计更好的代码结构。"
        ),
        
        // 5. 抽象类和接口（默认方法、静态方法）
        KnowledgeDetail(
            id = "java_abstract_interface",
            title = "抽象类和接口（默认方法、静态方法）",
            overview = "抽象类用于定义不能实例化的类，接口用于定义契约。Java 8+支持接口的默认方法和静态方法。抽象类和接口都支持多态。",
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：抽象类",
                    code = """
                        // 抽象类使用abstract关键字
                        abstract class Animal {
                            protected String name;
                            
                            // 抽象方法（必须被子类实现）
                            public abstract void makeSound();
                            
                            // 普通方法（可以有实现）
                            public void eat() {
                                System.out.println(name + " is eating");
                            }
                            
                            // 可以有构造函数
                            public Animal(String name) {
                                this.name = name;
                            }
                        }
                        
                        // 子类必须实现抽象方法
                        class Dog extends Animal {
                            public Dog(String name) {
                                super(name);
                            }
                            
                            @Override
                            public void makeSound() {
                                System.out.println(name + " barks");
                            }
                        }
                        
                        // 不能实例化抽象类
                        // Animal animal = new Animal("Test");  // ❌ 错误
                        Animal dog = new Dog("Buddy");  // ✅ 可以
                    """.trimIndent(),
                    explanation = "抽象类使用abstract关键字，可以包含抽象方法和普通方法。抽象类不能实例化，必须被子类继承并实现抽象方法。"
                ),
                CodeExample(
                    title = "示例2：接口",
                    code = """
                        // 接口定义契约
                        interface Flyable {
                            // 抽象方法（默认public abstract）
                            void fly();
                            
                            // Java 8+ 默认方法
                            default void takeOff() {
                                System.out.println("Taking off");
                            }
                            
                            // Java 8+ 静态方法
                            static void showInfo() {
                                System.out.println("This is a flyable object");
                            }
                        }
                        
                        // 类实现接口
                        class Bird implements Flyable {
                            @Override
                            public void fly() {
                                System.out.println("Bird is flying");
                            }
                        }
                        
                        // 使用
                        Bird bird = new Bird();
                        bird.fly();      // 实现的方法
                        bird.takeOff();  // 默认方法
                        Flyable.showInfo();  // 静态方法
                    """.trimIndent(),
                    explanation = "接口定义契约，类实现接口必须实现所有抽象方法。Java 8+支持默认方法和静态方法，默认方法可以在接口中提供实现。"
                ),
                CodeExample(
                    title = "示例3：接口的多继承",
                    code = """
                        // Java支持接口的多继承
                        interface A {
                            void methodA();
                        }
                        
                        interface B {
                            void methodB();
                        }
                        
                        // 接口可以继承多个接口
                        interface C extends A, B {
                            void methodC();
                        }
                        
                        // 类可以实现多个接口
                        class MyClass implements A, B, C {
                            @Override
                            public void methodA() { }
                            
                            @Override
                            public void methodB() { }
                            
                            @Override
                            public void methodC() { }
                        }
                    """.trimIndent(),
                    explanation = "Java支持接口的多继承，一个接口可以继承多个接口，一个类可以实现多个接口。"
                )
            ),
            useCases = listOf(
                "定义契约：使用接口定义契约",
                "代码复用：使用抽象类复用代码",
                "多态实现：通过抽象类和接口实现多态",
                "设计模式：抽象类和接口是许多设计模式的基础",
                "API设计：使用接口设计API"
            ),
            keyPoints = listOf(
                "抽象类使用abstract关键字，不能实例化",
                "接口定义契约，类实现接口",
                "Java 8+支持接口的默认方法和静态方法",
                "Java支持接口的多继承",
                "抽象类和接口都支持多态"
            ),
            notes = listOf(
                "抽象类可以包含抽象方法和普通方法",
                "接口中的方法默认public abstract",
                "默认方法可以在接口中提供实现",
                "静态方法通过接口名调用",
                "合理选择抽象类或接口"
            ),
            practiceTips = "建议：合理选择抽象类或接口，接口更适合定义契约，抽象类更适合代码复用。使用接口的默认方法和静态方法提供便利功能。理解抽象类和接口的区别，根据需求选择。"
        ),
        
        // 6. 内部类和嵌套类
        KnowledgeDetail(
            id = "java_inner_class",
            title = "内部类和嵌套类",
            overview = "内部类是定义在类内部的类，包括成员内部类、局部内部类、匿名内部类、静态嵌套类。内部类可以访问外部类的成员，提高代码的封装性。",
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：成员内部类",
                    code = """
                        class Outer {
                            private int outerVar = 10;
                            
                            // 成员内部类
                            class Inner {
                                private int innerVar = 20;
                                
                                public void display() {
                                    System.out.println("Outer: " + outerVar);  // 可以访问外部类成员
                                    System.out.println("Inner: " + innerVar);
                                }
                            }
                            
                            public void createInner() {
                                Inner inner = new Inner();
                                inner.display();
                            }
                        }
                        
                        // 使用
                        Outer outer = new Outer();
                        Outer.Inner inner = outer.new Inner();  // 创建内部类对象
                        inner.display();
                    """.trimIndent(),
                    explanation = "成员内部类定义在类内部，可以访问外部类的成员。创建内部类对象需要外部类对象。"
                ),
                CodeExample(
                    title = "示例2：静态嵌套类",
                    code = """
                        class Outer {
                            private static int staticVar = 10;
                            private int instanceVar = 20;
                            
                            // 静态嵌套类
                            static class StaticNested {
                                public void display() {
                                    System.out.println("Static: " + staticVar);  // 可以访问静态成员
                                    // System.out.println(instanceVar);  // ❌ 不能访问实例成员
                                }
                            }
                        }
                        
                        // 使用（不需要外部类对象）
                        Outer.StaticNested nested = new Outer.StaticNested();
                        nested.display();
                    """.trimIndent(),
                    explanation = "静态嵌套类使用static关键字，不能访问外部类的实例成员，只能访问静态成员。创建静态嵌套类对象不需要外部类对象。"
                ),
                CodeExample(
                    title = "示例3：局部内部类和匿名内部类",
                    code = """
                        class Outer {
                            public void method() {
                                // 局部内部类
                                class LocalInner {
                                    public void display() {
                                        System.out.println("Local inner class");
                                    }
                                }
                                
                                LocalInner local = new LocalInner();
                                local.display();
                                
                                // 匿名内部类
                                Runnable runnable = new Runnable() {
                                    @Override
                                    public void run() {
                                        System.out.println("Anonymous inner class");
                                    }
                                };
                                runnable.run();
                            }
                        }
                    """.trimIndent(),
                    explanation = "局部内部类定义在方法内部，匿名内部类是没有名字的内部类，常用于实现接口或继承类。"
                )
            ),
            useCases = listOf(
                "代码组织：使用内部类组织相关代码",
                "封装性：内部类提高代码的封装性",
                "回调：使用匿名内部类实现回调",
                "事件处理：使用内部类处理事件",
                "设计模式：内部类是某些设计模式的基础"
            ),
            keyPoints = listOf(
                "内部类包括成员内部类、局部内部类、匿名内部类、静态嵌套类",
                "成员内部类可以访问外部类成员",
                "静态嵌套类不能访问外部类实例成员",
                "局部内部类定义在方法内部",
                "匿名内部类常用于实现接口或继承类"
            ),
            notes = listOf(
                "成员内部类需要外部类对象创建",
                "静态嵌套类不需要外部类对象创建",
                "局部内部类只能访问final或effectively final的局部变量",
                "匿名内部类常用于事件处理和回调",
                "合理使用内部类提高代码封装性"
            ),
            practiceTips = "建议：合理使用内部类提高代码的封装性和组织性。注意不同类型内部类的访问规则，静态嵌套类适合工具类，匿名内部类适合简单的回调。"
        ),
        
        // 7. 枚举（Enum）
        KnowledgeDetail(
            id = "java_enum",
            title = "枚举（Enum）",
            overview = "枚举是Java 5引入的特性，用于定义一组常量。枚举类型安全，可以包含方法、构造函数、实现接口等。枚举是单例模式的天然实现。",
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：基本枚举",
                    code = """
                        // 基本枚举
                        enum Season {
                            SPRING, SUMMER, AUTUMN, WINTER
                        }
                        
                        // 使用
                        Season season = Season.SPRING;
                        System.out.println(season);  // SPRING
                        
                        // 遍历枚举
                        for (Season s : Season.values()) {
                            System.out.println(s);
                        }
                        
                        // 获取枚举名称和序号
                        System.out.println(season.name());      // SPRING
                        System.out.println(season.ordinal());  // 0
                    """.trimIndent(),
                    explanation = "枚举使用enum关键字定义，枚举值是常量。可以使用values()遍历，name()获取名称，ordinal()获取序号。"
                ),
                CodeExample(
                    title = "示例2：带构造函数的枚举",
                    code = """
                        enum Planet {
                            MERCURY(3.303e+23, 2.4397e6),
                            VENUS(4.869e+24, 6.0518e6),
                            EARTH(5.976e+24, 6.37814e6);
                            
                            private final double mass;
                            private final double radius;
                            
                            Planet(double mass, double radius) {
                                this.mass = mass;
                                this.radius = radius;
                            }
                            
                            public double getMass() {
                                return mass;
                            }
                            
                            public double getRadius() {
                                return radius;
                            }
                        }
                        
                        // 使用
                        Planet earth = Planet.EARTH;
                        System.out.println(earth.getMass());
                    """.trimIndent(),
                    explanation = "枚举可以包含构造函数、字段、方法。枚举值是单例，构造函数在枚举值定义时调用。"
                ),
                CodeExample(
                    title = "示例3：枚举实现接口",
                    code = """
                        interface Operation {
                            double apply(double x, double y);
                        }
                        
                        enum Calculator implements Operation {
                            PLUS {
                                @Override
                                public double apply(double x, double y) {
                                    return x + y;
                                }
                            },
                            MINUS {
                                @Override
                                public double apply(double x, double y) {
                                    return x - y;
                                }
                            };
                        }
                        
                        // 使用
                        double result = Calculator.PLUS.apply(10, 5);  // 15
                    """.trimIndent(),
                    explanation = "枚举可以实现接口，每个枚举值可以提供不同的实现。枚举适合实现策略模式。"
                )
            ),
            useCases = listOf(
                "常量定义：使用枚举定义常量",
                "状态机：使用枚举实现状态机",
                "策略模式：使用枚举实现策略模式",
                "单例模式：枚举是单例模式的天然实现",
                "类型安全：枚举提供类型安全"
            ),
            keyPoints = listOf(
                "枚举使用enum关键字定义",
                "枚举值是常量，是单例",
                "枚举可以包含构造函数、字段、方法",
                "枚举可以实现接口",
                "枚举提供类型安全"
            ),
            notes = listOf(
                "枚举值是单例，构造函数在枚举值定义时调用",
                "可以使用values()遍历枚举",
                "name()获取名称，ordinal()获取序号",
                "枚举适合实现策略模式和状态机",
                "枚举是类型安全的常量"
            ),
            practiceTips = "建议：使用枚举定义常量，提供类型安全。枚举可以包含方法和实现接口，适合实现策略模式和状态机。枚举是单例模式的天然实现。"
        ),
        
        // ========== Java 集合框架 ==========
        
        // 1. List接口（ArrayList、LinkedList）
        KnowledgeDetail(
            id = "java_list",
            title = "List接口（ArrayList、LinkedList）",
            overview = "List是有序集合，允许重复元素。ArrayList基于数组实现，适合随机访问。LinkedList基于链表实现，适合插入和删除。根据使用场景选择合适的实现。",
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：ArrayList",
                    code = """
                        // ArrayList基于数组实现
                        List<String> list = new ArrayList<>();
                        
                        // 添加元素
                        list.add("Apple");
                        list.add("Banana");
                        list.add("Orange");
                        
                        // 访问元素
                        String first = list.get(0);  // "Apple"
                        
                        // 遍历
                        for (String item : list) {
                            System.out.println(item);
                        }
                        
                        // 特点：适合随机访问，不适合频繁插入删除
                    """.trimIndent(),
                    explanation = "ArrayList基于数组实现，支持随机访问，适合查询操作。插入和删除需要移动元素，性能较低。"
                ),
                CodeExample(
                    title = "示例2：LinkedList",
                    code = """
                        // LinkedList基于链表实现
                        List<String> list = new LinkedList<>();
                        
                        list.add("Apple");
                        list.add("Banana");
                        list.addFirst("First");  // 在头部添加
                        list.addLast("Last");    // 在尾部添加
                        
                        // 特点：适合插入删除，不适合随机访问
                    """.trimIndent(),
                    explanation = "LinkedList基于链表实现，适合插入和删除操作。随机访问需要遍历，性能较低。"
                )
            ),
            useCases = listOf("有序集合：需要保持元素顺序", "重复元素：允许重复元素", "随机访问：ArrayList适合", "频繁插入删除：LinkedList适合"),
            keyPoints = listOf("List是有序集合，允许重复", "ArrayList基于数组，适合随机访问", "LinkedList基于链表，适合插入删除", "根据使用场景选择实现"),
            notes = listOf("ArrayList查询快，插入删除慢", "LinkedList插入删除快，查询慢", "List允许null元素", "List不是线程安全的"),
            practiceTips = "建议：根据使用场景选择合适的List实现。ArrayList适合查询操作，LinkedList适合频繁插入删除。注意List不是线程安全的，多线程环境使用并发集合。"
        ),
        
        // 2. Set接口（HashSet、LinkedHashSet、TreeSet）
        KnowledgeDetail(
            id = "java_set",
            title = "Set接口（HashSet、LinkedHashSet、TreeSet）",
            overview = "Set是不允许重复元素的集合。HashSet基于哈希表，无序。LinkedHashSet保持插入顺序。TreeSet基于红黑树，有序。",
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：HashSet",
                    code = """
                        Set<String> set = new HashSet<>();
                        set.add("Apple");
                        set.add("Banana");
                        set.add("Apple");  // 重复，不会添加
                        // 无序，不保证顺序
                    """.trimIndent(),
                    explanation = "HashSet基于哈希表实现，不允许重复，无序，查询性能高。"
                ),
                CodeExample(
                    title = "示例2：LinkedHashSet和TreeSet",
                    code = """
                        // LinkedHashSet保持插入顺序
                        Set<String> linkedSet = new LinkedHashSet<>();
                        
                        // TreeSet有序（自然顺序或Comparator）
                        Set<String> treeSet = new TreeSet<>();
                    """.trimIndent(),
                    explanation = "LinkedHashSet保持插入顺序，TreeSet有序。"
                )
            ),
            useCases = listOf("去重：使用Set去除重复元素", "唯一性：保证元素唯一", "快速查找：HashSet查询快"),
            keyPoints = listOf("Set不允许重复元素", "HashSet无序，查询快", "LinkedHashSet保持插入顺序", "TreeSet有序"),
            notes = listOf("Set不允许null（TreeSet）或允许一个null（HashSet）", "TreeSet需要元素实现Comparable或提供Comparator"),
            practiceTips = "建议：使用Set去除重复元素，根据需求选择实现。HashSet适合快速查找，TreeSet适合需要排序的场景。"
        ),
        
        // 3. Map接口（HashMap、LinkedHashMap、TreeMap）
        KnowledgeDetail(
            id = "java_map",
            title = "Map接口（HashMap、LinkedHashMap、TreeMap）",
            overview = "Map是键值对集合。HashMap基于哈希表，无序。LinkedHashMap保持插入顺序。TreeMap基于红黑树，按键排序。",
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：HashMap",
                    code = """
                        Map<String, Integer> map = new HashMap<>();
                        map.put("Apple", 1);
                        map.put("Banana", 2);
                        map.put("Orange", 3);
                        
                        // 获取值
                        Integer value = map.get("Apple");  // 1
                        
                        // 遍历
                        for (Map.Entry<String, Integer> entry : map.entrySet()) {
                            System.out.println(entry.getKey() + ": " + entry.getValue());
                        }
                    """.trimIndent(),
                    explanation = "HashMap基于哈希表，键值对存储，查询性能高，无序。"
                )
            ),
            useCases = listOf("键值对存储：使用Map存储键值对", "快速查找：HashMap查询快", "排序：TreeMap按键排序"),
            keyPoints = listOf("Map是键值对集合", "HashMap无序，查询快", "LinkedHashMap保持插入顺序", "TreeMap按键排序"),
            notes = listOf("HashMap允许一个null键和多个null值", "TreeMap需要键实现Comparable或提供Comparator"),
            practiceTips = "建议：使用Map存储键值对，根据需求选择实现。HashMap适合快速查找，TreeMap适合需要排序的场景。注意键的唯一性。"
        ),
        
        // 4. Queue接口（PriorityQueue、BlockingQueue）
        KnowledgeDetail(
            id = "java_queue",
            title = "Queue接口（PriorityQueue、BlockingQueue）",
            overview = "Queue是队列接口，FIFO（先进先出）。PriorityQueue是优先级队列。BlockingQueue是阻塞队列，支持并发操作。",
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：Queue和PriorityQueue",
                    code = """
                        Queue<String> queue = new LinkedList<>();
                        queue.offer("First");
                        queue.offer("Second");
                        queue.poll();  // 移除并返回头部元素
                        
                        // 优先级队列
                        PriorityQueue<Integer> pq = new PriorityQueue<>();
                        pq.offer(3);
                        pq.offer(1);
                        pq.offer(2);
                        pq.poll();  // 1（最小元素）
                    """.trimIndent(),
                    explanation = "Queue是FIFO队列，PriorityQueue是优先级队列，按优先级出队。"
                )
            ),
            useCases = listOf("队列操作：使用Queue实现队列", "优先级：使用PriorityQueue", "并发：使用BlockingQueue"),
            keyPoints = listOf("Queue是FIFO队列", "PriorityQueue是优先级队列", "BlockingQueue支持并发操作"),
            notes = listOf("Queue接口有多种实现", "PriorityQueue需要元素可比较", "BlockingQueue是线程安全的"),
            practiceTips = "建议：使用Queue实现队列操作，PriorityQueue适合优先级场景，BlockingQueue适合并发场景。"
        ),
        
        // 5. Collections工具类
        KnowledgeDetail(
            id = "java_collections_util",
            title = "Collections工具类",
            overview = "Collections工具类提供了操作集合的静态方法，包括排序、查找、同步、不可变集合等。",
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：Collections常用方法",
                    code = """
                        List<Integer> list = Arrays.asList(3, 1, 4, 1, 5);
                        
                        // 排序
                        Collections.sort(list);
                        
                        // 查找
                        int index = Collections.binarySearch(list, 4);
                        
                        // 反转
                        Collections.reverse(list);
                        
                        // 打乱
                        Collections.shuffle(list);
                        
                        // 同步包装
                        List<String> syncList = Collections.synchronizedList(new ArrayList<>());
                        
                        // 不可变集合
                        List<String> unmodifiable = Collections.unmodifiableList(list);
                    """.trimIndent(),
                    explanation = "Collections工具类提供了排序、查找、同步、不可变集合等方法。"
                )
            ),
            useCases = listOf("排序查找：使用Collections排序和查找", "同步：使用同步包装保证线程安全", "不可变：使用不可变集合"),
            keyPoints = listOf("Collections提供静态工具方法", "支持排序、查找、同步等操作", "可以创建不可变集合"),
            notes = listOf("Collections.sort需要元素可比较", "同步包装提供线程安全", "不可变集合不能修改"),
            practiceTips = "建议：使用Collections工具类操作集合，注意排序需要元素可比较，同步包装提供线程安全。"
        ),
        
        // 6. 集合的最佳实践
        KnowledgeDetail(
            id = "java_collections_best",
            title = "集合的最佳实践",
            overview = "集合使用的最佳实践包括选择合适的实现、注意线程安全、使用泛型、避免不必要的装箱拆箱、合理使用迭代器等。",
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：最佳实践",
                    code = """
                        // 1. 使用泛型
                        List<String> list = new ArrayList<>();  // ✅
                        // List list = new ArrayList();  // ❌ 不使用泛型
                        
                        // 2. 初始化容量（如果知道大小）
                        List<String> list2 = new ArrayList<>(100);
                        
                        // 3. 使用接口类型
                        List<String> list3 = new ArrayList<>();  // ✅
                        // ArrayList<String> list4 = new ArrayList<>();  // ❌
                        
                        // 4. 遍历集合
                        for (String item : list) {  // ✅ 推荐
                            System.out.println(item);
                        }
                        
                        // 5. 线程安全
                        List<String> syncList = Collections.synchronizedList(new ArrayList<>());
                        // 或使用并发集合
                        // ConcurrentHashMap, CopyOnWriteArrayList等
                    """.trimIndent(),
                    explanation = "集合使用的最佳实践包括使用泛型、初始化容量、使用接口类型、合理遍历、注意线程安全等。"
                )
            ),
            useCases = listOf("代码质量：遵循最佳实践提高代码质量", "性能优化：合理使用集合提高性能", "线程安全：注意多线程环境"),
            keyPoints = listOf("使用泛型保证类型安全", "初始化容量提高性能", "使用接口类型提高灵活性", "注意线程安全", "合理遍历集合"),
            notes = listOf("集合不是线程安全的", "使用泛型避免类型转换", "初始化容量减少扩容", "使用接口类型便于切换实现"),
            practiceTips = "建议：遵循集合使用的最佳实践，使用泛型、初始化容量、使用接口类型、注意线程安全。根据使用场景选择合适的集合实现。"
        ),
        
        // ========== Java 异常处理 ==========
        
        // 1. 异常基础（Error、Exception、Checked/Unchecked）
        KnowledgeDetail(
            id = "java_exception_basic",
            title = "异常基础（Error、Exception、Checked/Unchecked）",
            overview = "Java异常分为Error和Exception。Exception分为Checked异常和Unchecked异常。理解异常层次结构是处理异常的基础。",
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：异常层次结构",
                    code = """
                        // Throwable
                        //   ├── Error（系统错误，不应捕获）
                        //   │   ├── OutOfMemoryError
                        //   │   └── StackOverflowError
                        //   └── Exception（可处理异常）
                        //       ├── RuntimeException（Unchecked异常）
                        //       │   ├── NullPointerException
                        //       │   ├── IllegalArgumentException
                        //       │   └── IndexOutOfBoundsException
                        //       └── 其他Exception（Checked异常）
                        //           ├── IOException
                        //           └── SQLException
                        
                        // Checked异常：必须处理（try-catch或throws）
                        // Unchecked异常：可以不处理
                    """.trimIndent(),
                    explanation = "异常层次结构：Throwable -> Error/Exception。Exception分为Checked（必须处理）和Unchecked（可以不处理）异常。"
                )
            ),
            useCases = listOf("错误处理：使用异常处理错误", "代码健壮性：提高代码健壮性", "错误信息：提供错误信息"),
            keyPoints = listOf("Error是系统错误，不应捕获", "Checked异常必须处理", "Unchecked异常可以不处理", "RuntimeException是Unchecked异常"),
            notes = listOf("Error不应捕获", "Checked异常必须处理", "Unchecked异常可以不处理", "合理使用异常提高代码健壮性"),
            practiceTips = "建议：理解异常层次结构，Checked异常必须处理，Unchecked异常可以不处理。合理使用异常提高代码健壮性，不要捕获Error。"
        ),
        
        // 2. 异常处理机制（try-catch-finally）
        KnowledgeDetail(
            id = "java_exception_handling",
            title = "异常处理机制（try-catch-finally）",
            overview = "try-catch-finally用于捕获和处理异常。try块包含可能抛出异常的代码，catch块处理异常，finally块总是执行。",
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：try-catch-finally",
                    code = """
                        try {
                            // 可能抛出异常的代码
                            int result = 10 / 0;
                        } catch (ArithmeticException e) {
                            // 处理异常
                            System.out.println("除零错误: " + e.getMessage());
                        } catch (Exception e) {
                            // 处理其他异常
                            System.out.println("其他异常: " + e.getMessage());
                        } finally {
                            // 总是执行（用于清理资源）
                            System.out.println("清理资源");
                        }
                    """.trimIndent(),
                    explanation = "try-catch-finally用于捕获和处理异常。catch可以多个，finally总是执行。"
                )
            ),
            useCases = listOf("异常捕获：使用try-catch捕获异常", "资源清理：使用finally清理资源", "错误处理：处理各种错误情况"),
            keyPoints = listOf("try包含可能抛出异常的代码", "catch处理异常，可以多个", "finally总是执行", "try-with-resources自动关闭资源"),
            notes = listOf("catch按顺序匹配", "finally总是执行", "try-with-resources自动关闭资源", "合理使用异常处理"),
            practiceTips = "建议：使用try-catch-finally处理异常，使用try-with-resources自动关闭资源。finally用于清理资源，注意异常不要被吞掉。"
        ),
        
        // 3. 抛出异常（throw、throws）
        KnowledgeDetail(
            id = "java_throw_exception",
            title = "抛出异常（throw、throws）",
            overview = "throw用于抛出异常，throws用于声明方法可能抛出的异常。理解throw和throws的区别是编写正确异常处理代码的关键。",
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：throw和throws",
                    code = """
                        // throw：抛出异常
                        public void method() {
                            if (condition) {
                                throw new IllegalArgumentException("参数错误");
                            }
                        }
                        
                        // throws：声明可能抛出的异常
                        public void readFile() throws IOException {
                            // 可能抛出IOException
                        }
                        
                        // 调用者必须处理
                        try {
                            readFile();
                        } catch (IOException e) {
                            // 处理异常
                        }
                    """.trimIndent(),
                    explanation = "throw用于抛出异常，throws用于声明方法可能抛出的异常。调用者必须处理Checked异常。"
                )
            ),
            useCases = listOf("异常抛出：使用throw抛出异常", "异常声明：使用throws声明异常", "错误传播：传播错误信息"),
            keyPoints = listOf("throw用于抛出异常", "throws用于声明异常", "Checked异常必须声明", "调用者必须处理Checked异常"),
            notes = listOf("throw抛出异常对象", "throws声明异常类型", "Checked异常必须声明", "合理使用异常传播错误"),
            practiceTips = "建议：使用throw抛出异常，使用throws声明异常。Checked异常必须声明，调用者必须处理。合理使用异常传播错误信息。"
        ),
        
        // 4. 常见异常类型
        KnowledgeDetail(
            id = "java_common_exceptions",
            title = "常见异常类型",
            overview = "Java常见的异常类型包括NullPointerException、IllegalArgumentException、IndexOutOfBoundsException、IOException等。理解常见异常有助于快速定位问题。",
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：常见异常",
                    code = """
                        // NullPointerException：空指针异常
                        String str = null;
                        int length = str.length();  // 抛出NullPointerException
                        
                        // IllegalArgumentException：非法参数异常
                        if (age < 0) {
                            throw new IllegalArgumentException("年龄不能为负");
                        }
                        
                        // IndexOutOfBoundsException：索引越界异常
                        int[] arr = {1, 2, 3};
                        int value = arr[10];  // 抛出IndexOutOfBoundsException
                        
                        // IOException：IO异常
                        // FileNotFoundException、SocketException等
                    """.trimIndent(),
                    explanation = "常见异常包括NullPointerException、IllegalArgumentException、IndexOutOfBoundsException、IOException等。"
                )
            ),
            useCases = listOf("错误定位：快速定位错误", "异常处理：处理常见异常", "代码调试：理解异常原因"),
            keyPoints = listOf("NullPointerException：空指针", "IllegalArgumentException：非法参数", "IndexOutOfBoundsException：索引越界", "IOException：IO异常"),
            notes = listOf("常见异常需要熟悉", "合理处理常见异常", "避免常见异常"),
            practiceTips = "建议：熟悉常见异常类型，快速定位问题。合理处理常见异常，避免常见异常的发生。"
        ),
        
        // ========== Java 多线程编程 ==========
        
        // 1. 线程基础（创建、生命周期）
        KnowledgeDetail(
            id = "java_thread_basic",
            title = "线程基础（创建、生命周期）",
            overview = "线程是程序执行的最小单位。Java中可以通过继承Thread类或实现Runnable接口创建线程。理解线程生命周期是掌握多线程编程的基础。",
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：创建线程",
                    code = """
                        // 方式1：继承Thread类
                        class MyThread extends Thread {
                            @Override
                            public void run() {
                                System.out.println("Thread running");
                            }
                        }
                        MyThread thread = new MyThread();
                        thread.start();
                        
                        // 方式2：实现Runnable接口（推荐）
                        class MyRunnable implements Runnable {
                            @Override
                            public void run() {
                                System.out.println("Runnable running");
                            }
                        }
                        Thread thread2 = new Thread(new MyRunnable());
                        thread2.start();
                        
                        // 方式3：Lambda表达式
                        Thread thread3 = new Thread(() -> System.out.println("Lambda running"));
                        thread3.start();
                    """.trimIndent(),
                    explanation = "创建线程的方式：继承Thread类、实现Runnable接口（推荐）、Lambda表达式。使用start()启动线程。"
                )
            ),
            useCases = listOf("并发执行：使用线程实现并发", "异步处理：异步处理任务", "提高性能：利用多核CPU"),
            keyPoints = listOf("线程是程序执行的最小单位", "可以通过继承Thread或实现Runnable创建线程", "使用start()启动线程", "线程有生命周期"),
            notes = listOf("实现Runnable接口更灵活", "不要直接调用run()方法", "线程生命周期：新建、就绪、运行、阻塞、死亡"),
            practiceTips = "建议：使用实现Runnable接口的方式创建线程，更灵活。使用start()启动线程，不要直接调用run()。理解线程生命周期。"
        ),
        
        // 2. 线程同步（synchronized、volatile）
        KnowledgeDetail(
            id = "java_thread_sync",
            title = "线程同步（synchronized、volatile）",
            overview = "线程同步用于解决多线程并发访问共享资源的问题。synchronized用于同步代码块和方法，volatile用于保证变量可见性。",
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：synchronized",
                    code = """
                        class Counter {
                            private int count = 0;
                            
                            // 同步方法
                            public synchronized void increment() {
                                count++;
                            }
                            
                            // 同步代码块
                            public void increment2() {
                                synchronized (this) {
                                    count++;
                                }
                            }
                        }
                    """.trimIndent(),
                    explanation = "synchronized用于同步代码块和方法，保证同一时间只有一个线程可以执行同步代码。"
                ),
                CodeExample(
                    title = "示例2：volatile",
                    code = """
                        class Flag {
                            private volatile boolean flag = false;
                            
                            public void setFlag() {
                                flag = true;
                            }
                            
                            public boolean getFlag() {
                                return flag;
                            }
                        }
                    """.trimIndent(),
                    explanation = "volatile保证变量的可见性，一个线程修改后，其他线程立即可见。但不能保证原子性。"
                )
            ),
            useCases = listOf("线程安全：保证线程安全", "共享资源：同步访问共享资源", "可见性：保证变量可见性"),
            keyPoints = listOf("synchronized用于同步", "volatile保证可见性", "synchronized保证原子性和可见性", "volatile只保证可见性"),
            notes = listOf("synchronized有性能开销", "volatile不能保证原子性", "合理使用同步机制", "避免死锁"),
            practiceTips = "建议：合理使用synchronized和volatile，注意性能开销。synchronized保证原子性和可见性，volatile只保证可见性。避免死锁。"
        ),
        
        // 3. 线程通信（wait、notify）
        KnowledgeDetail(
            id = "java_thread_comm",
            title = "线程通信（wait、notify）",
            overview = "线程通信用于线程之间的协调。wait()使线程等待，notify()唤醒等待的线程。必须在synchronized块中使用。",
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：wait和notify",
                    code = """
                        class ProducerConsumer {
                            private Object lock = new Object();
                            private boolean produced = false;
                            
                            public void produce() {
                                synchronized (lock) {
                                    while (produced) {
                                        try {
                                            lock.wait();  // 等待
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                    // 生产
                                    produced = true;
                                    lock.notify();  // 唤醒
                                }
                            }
                            
                            public void consume() {
                                synchronized (lock) {
                                    while (!produced) {
                                        try {
                                            lock.wait();
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                    // 消费
                                    produced = false;
                                    lock.notify();
                                }
                            }
                        }
                    """.trimIndent(),
                    explanation = "wait()使线程等待，notify()唤醒等待的线程。必须在synchronized块中使用，使用while循环检查条件。"
                )
            ),
            useCases = listOf("线程协调：协调线程执行", "生产者消费者：实现生产者消费者模式", "线程等待：线程等待条件"),
            keyPoints = listOf("wait()使线程等待", "notify()唤醒线程", "必须在synchronized块中使用", "使用while循环检查条件"),
            notes = listOf("wait()会释放锁", "notify()唤醒一个线程", "notifyAll()唤醒所有线程", "使用while循环避免虚假唤醒"),
            practiceTips = "建议：使用wait()和notify()进行线程通信，必须在synchronized块中使用。使用while循环检查条件，避免虚假唤醒。"
        ),
        
        // 4. 并发工具类（Executor、Future、CountDownLatch）
        KnowledgeDetail(
            id = "java_concurrent_utils",
            title = "并发工具类（Executor、Future、CountDownLatch）",
            overview = "Java并发包提供了丰富的工具类，包括Executor框架、Future、CountDownLatch等。这些工具类简化了并发编程。",
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：Executor和Future",
                    code = """
                        ExecutorService executor = Executors.newFixedThreadPool(10);
                        Future<String> future = executor.submit(() -> {
                            return "Result";
                        });
                        String result = future.get();  // 获取结果
                        executor.shutdown();
                    """.trimIndent(),
                    explanation = "Executor框架管理线程池，Future用于获取异步任务的结果。"
                ),
                CodeExample(
                    title = "示例2：CountDownLatch",
                    code = """
                        CountDownLatch latch = new CountDownLatch(3);
                        // 3个线程完成后继续
                        for (int i = 0; i < 3; i++) {
                            new Thread(() -> {
                                // 执行任务
                                latch.countDown();  // 计数减1
                            }).start();
                        }
                        latch.await();  // 等待计数为0
                    """.trimIndent(),
                    explanation = "CountDownLatch用于等待多个线程完成，countDown()计数减1，await()等待计数为0。"
                )
            ),
            useCases = listOf("线程池：使用Executor管理线程", "异步任务：使用Future获取结果", "线程协调：使用CountDownLatch协调线程"),
            keyPoints = listOf("Executor框架管理线程池", "Future用于获取异步结果", "CountDownLatch用于等待多个线程", "并发工具类简化并发编程"),
            notes = listOf("ExecutorService需要关闭", "Future.get()会阻塞", "CountDownLatch是一次性的", "合理使用并发工具类"),
            practiceTips = "建议：使用Executor框架管理线程，使用Future获取异步结果，使用CountDownLatch协调线程。注意关闭ExecutorService。"
        ),
        
        // 5. 并发集合（ConcurrentHashMap、BlockingQueue）
        KnowledgeDetail(
            id = "java_concurrent_collections",
            title = "并发集合（ConcurrentHashMap、BlockingQueue）",
            overview = "并发集合是线程安全的集合，包括ConcurrentHashMap、BlockingQueue等。并发集合适合多线程环境使用。",
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：并发集合",
                    code = """
                        // ConcurrentHashMap：线程安全的HashMap
                        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
                        map.put("key", 1);
                        
                        // BlockingQueue：阻塞队列
                        BlockingQueue<String> queue = new LinkedBlockingQueue<>();
                        queue.put("item");  // 阻塞直到有空间
                        String item = queue.take();  // 阻塞直到有元素
                    """.trimIndent(),
                    explanation = "ConcurrentHashMap是线程安全的HashMap，BlockingQueue是阻塞队列，适合多线程环境。"
                )
            ),
            useCases = listOf("线程安全：使用并发集合保证线程安全", "生产者消费者：使用BlockingQueue实现", "并发访问：多线程访问集合"),
            keyPoints = listOf("ConcurrentHashMap是线程安全的", "BlockingQueue是阻塞队列", "并发集合适合多线程环境", "性能优于同步包装"),
            notes = listOf("并发集合性能更好", "BlockingQueue支持阻塞操作", "合理选择并发集合", "注意并发集合的特性"),
            practiceTips = "建议：在多线程环境使用并发集合，性能优于同步包装。ConcurrentHashMap适合并发访问，BlockingQueue适合生产者消费者模式。"
        ),
        
        // ========== Java 泛型 ==========
        
        // 1. 泛型基础（泛型类、方法、接口）
        KnowledgeDetail(
            id = "java_generics_basic",
            title = "泛型基础（泛型类、方法、接口）",
            overview = "泛型提供了类型安全，允许在编译时检查类型。可以定义泛型类、泛型方法、泛型接口。泛型提高了代码的复用性和类型安全。",
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：泛型类和方法",
                    code = """
                        // 泛型类
                        class Box<T> {
                            private T value;
                            public void set(T value) { this.value = value; }
                            public T get() { return value; }
                        }
                        
                        Box<String> stringBox = new Box<>();
                        stringBox.set("Hello");
                        String str = stringBox.get();
                        
                        // 泛型方法
                        public <T> T getValue(T value) {
                            return value;
                        }
                    """.trimIndent(),
                    explanation = "泛型类使用<T>定义类型参数，泛型方法在方法前定义类型参数。泛型提供类型安全。"
                )
            ),
            useCases = listOf("类型安全：提供类型安全", "代码复用：提高代码复用性", "集合：集合使用泛型"),
            keyPoints = listOf("泛型提供类型安全", "可以定义泛型类、方法、接口", "泛型在编译时检查类型", "避免类型转换"),
            notes = listOf("泛型在编译时检查", "类型擦除：运行时类型信息丢失", "不能使用基本类型", "合理使用泛型"),
            practiceTips = "建议：使用泛型提供类型安全，避免类型转换。注意类型擦除，不能使用基本类型。合理使用泛型提高代码质量。"
        ),
        
        // 2. 类型通配符（?、? extends、? super）
        KnowledgeDetail(
            id = "java_wildcards",
            title = "类型通配符（?、? extends、? super）",
            overview = "类型通配符用于表示未知类型。?表示任意类型，? extends表示上界，? super表示下界。理解通配符有助于编写灵活的泛型代码。",
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：通配符",
                    code = """
                        // ? 任意类型
                        List<?> list1 = new ArrayList<String>();
                        
                        // ? extends 上界（只读）
                        List<? extends Number> list2 = new ArrayList<Integer>();
                        // list2.add(1);  // ❌ 不能添加
                        Number num = list2.get(0);  // ✅ 可以读取
                        
                        // ? super 下界（只写）
                        List<? super Integer> list3 = new ArrayList<Number>();
                        list3.add(1);  // ✅ 可以添加
                        // Number num = list3.get(0);  // ❌ 不能读取为Number
                    """.trimIndent(),
                    explanation = "?表示任意类型，? extends表示上界（只读），? super表示下界（只写）。PECS原则：Producer Extends, Consumer Super。"
                )
            ),
            useCases = listOf("灵活类型：使用通配符提供灵活类型", "PECS原则：遵循PECS原则", "类型安全：保证类型安全"),
            keyPoints = listOf("?表示任意类型", "? extends表示上界（只读）", "? super表示下界（只写）", "PECS原则"),
            notes = listOf("? extends只读", "? super只写", "遵循PECS原则", "合理使用通配符"),
            practiceTips = "建议：使用通配符提供灵活类型，遵循PECS原则。? extends只读，? super只写。合理使用通配符提高代码灵活性。"
        ),
        
        // 3. 类型擦除和限制
        KnowledgeDetail(
            id = "java_type_erasure",
            title = "类型擦除和限制",
            overview = "Java泛型使用类型擦除实现，运行时类型信息丢失。类型擦除带来一些限制，如不能使用基本类型、不能创建泛型数组等。",
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：类型擦除",
                    code = """
                        // 编译时
                        List<String> list1 = new ArrayList<>();
                        List<Integer> list2 = new ArrayList<>();
                        
                        // 运行时（类型擦除后）
                        // List list1 = new ArrayList();
                        // List list2 = new ArrayList();
                        
                        // 类型擦除的限制
                        // 1. 不能使用基本类型
                        // List<int> list;  // ❌ 错误
                        
                        // 2. 不能创建泛型数组
                        // List<String>[] array = new List<String>[10];  // ❌ 错误
                        
                        // 3. 不能使用instanceof
                        // if (list instanceof List<String>) { }  // ❌ 错误
                    """.trimIndent(),
                    explanation = "类型擦除在运行时丢失类型信息，带来一些限制：不能使用基本类型、不能创建泛型数组、不能使用instanceof等。"
                )
            ),
            useCases = listOf("理解限制：理解类型擦除的限制", "避免错误：避免类型擦除相关错误", "设计代码：设计考虑类型擦除"),
            keyPoints = listOf("类型擦除在运行时丢失类型信息", "不能使用基本类型", "不能创建泛型数组", "不能使用instanceof"),
            notes = listOf("类型擦除是Java泛型的实现方式", "注意类型擦除的限制", "使用包装类代替基本类型", "合理设计泛型代码"),
            practiceTips = "建议：理解类型擦除的限制，避免相关错误。不能使用基本类型，使用包装类。不能创建泛型数组，使用List代替。"
        ),
        
        // 4. 泛型的最佳实践
        KnowledgeDetail(
            id = "java_generics_best",
            title = "泛型的最佳实践",
            overview = "泛型使用的最佳实践包括合理使用通配符、遵循PECS原则、避免原始类型、使用有意义的类型参数名等。",
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：最佳实践",
                    code = """
                        // 1. 使用有意义的类型参数名
                        class Box<T> { }  // ✅
                        class Box<Element> { }  // ✅ 更好
                        
                        // 2. 避免原始类型
                        List<String> list = new ArrayList<>();  // ✅
                        // List list = new ArrayList();  // ❌ 原始类型
                        
                        // 3. 遵循PECS原则
                        // Producer Extends, Consumer Super
                        public void copy(List<? extends T> src, List<? super T> dest) {
                            for (T item : src) {
                                dest.add(item);
                            }
                        }
                    """.trimIndent(),
                    explanation = "泛型最佳实践：使用有意义的类型参数名、避免原始类型、遵循PECS原则、合理使用通配符。"
                )
            ),
            useCases = listOf("代码质量：提高代码质量", "类型安全：保证类型安全", "代码可读性：提高代码可读性"),
            keyPoints = listOf("使用有意义的类型参数名", "避免原始类型", "遵循PECS原则", "合理使用通配符"),
            notes = listOf("遵循最佳实践提高代码质量", "注意类型安全", "提高代码可读性", "合理使用泛型"),
            practiceTips = "建议：遵循泛型最佳实践，使用有意义的类型参数名，避免原始类型，遵循PECS原则。合理使用泛型提高代码质量。"
        ),
        
        // ========== Java 反射 ==========
        
        // 1. 反射基础（Class类）
        KnowledgeDetail(
            id = "java_reflection_basic",
            title = "反射基础（Class类）",
            overview = "反射允许在运行时检查和操作类、方法、字段等。Class类表示类的元数据，是反射的入口。",
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：获取Class对象",
                    code = """
                        // 方式1：通过类名
                        Class<?> clazz = String.class;
                        
                        // 方式2：通过对象
                        String str = "Hello";
                        Class<?> clazz2 = str.getClass();
                        
                        // 方式3：通过类名字符串
                        Class<?> clazz3 = Class.forName("java.lang.String");
                    """.trimIndent(),
                    explanation = "获取Class对象的方式：类名.class、对象.getClass()、Class.forName()。Class是反射的入口。"
                )
            ),
            useCases = listOf("动态加载：动态加载类", "框架开发：框架中使用反射", "工具类：反射工具类"),
            keyPoints = listOf("Class类表示类的元数据", "反射允许运行时检查类", "反射是框架开发的基础"),
            notes = listOf("反射性能较低", "反射可以访问私有成员", "注意反射的安全限制"),
            practiceTips = "建议：理解反射机制，注意性能影响。反射适合框架开发，业务代码谨慎使用。"
        ),
        
        // 2. 反射操作（获取信息、创建对象、调用方法）
        KnowledgeDetail(
            id = "java_reflection_ops",
            title = "反射操作（获取信息、创建对象、调用方法）",
            overview = "反射可以获取类的信息（字段、方法、构造函数等），创建对象，调用方法。反射提供了动态访问代码的能力。",
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：反射操作",
                    code = """
                        Class<?> clazz = Person.class;
                        
                        // 获取字段
                        Field[] fields = clazz.getDeclaredFields();
                        
                        // 获取方法
                        Method[] methods = clazz.getDeclaredMethods();
                        
                        // 创建对象
                        Constructor<?> constructor = clazz.getConstructor(String.class, int.class);
                        Object obj = constructor.newInstance("Alice", 25);
                        
                        // 调用方法
                        Method method = clazz.getMethod("getName");
                        String name = (String) method.invoke(obj);
                    """.trimIndent(),
                    explanation = "反射可以获取字段、方法、构造函数，创建对象，调用方法。提供了动态访问代码的能力。"
                )
            ),
            useCases = listOf("动态创建：动态创建对象", "动态调用：动态调用方法", "框架开发：框架中使用"),
            keyPoints = listOf("可以获取字段、方法、构造函数", "可以创建对象", "可以调用方法"),
            notes = listOf("注意异常处理", "注意性能影响", "可以访问私有成员"),
            practiceTips = "建议：使用反射进行动态操作，注意异常处理和性能影响。反射适合框架开发。"
        ),
        
        // 3. 反射的应用场景
        KnowledgeDetail(
            id = "java_reflection_usage",
            title = "反射的应用场景",
            overview = "反射常用于框架开发、依赖注入、序列化、测试框架等场景。理解反射的应用场景有助于合理使用反射。",
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：应用场景",
                    code = """
                        // 1. 依赖注入框架
                        // 2. ORM框架（对象关系映射）
                        // 3. 序列化/反序列化
                        // 4. 测试框架（JUnit）
                        // 5. 注解处理器
                    """.trimIndent(),
                    explanation = "反射常用于框架开发、依赖注入、序列化、测试框架等场景。"
                )
            ),
            useCases = listOf("框架开发：框架中使用反射", "依赖注入：依赖注入框架", "序列化：序列化框架"),
            keyPoints = listOf("反射常用于框架开发", "依赖注入使用反射", "序列化使用反射"),
            notes = listOf("反射适合框架开发", "业务代码谨慎使用", "注意性能影响"),
            practiceTips = "建议：反射主要用于框架开发，业务代码谨慎使用。注意反射的性能影响和安全限制。"
        ),
        
        // ========== Java 注解 ==========
        
        // 1. 注解基础（内置注解、元注解）
        KnowledgeDetail(
            id = "java_annotation_basic",
            title = "注解基础（内置注解、元注解）",
            overview = "注解用于为代码添加元数据。Java提供了内置注解和元注解。理解注解的使用是掌握现代Java开发的基础。",
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：内置注解和元注解",
                    code = """
                        // 内置注解
                        @Override  // 方法重写
                        @Deprecated  // 已废弃
                        @SuppressWarnings("unchecked")  // 抑制警告
                        
                        // 元注解
                        @Target(ElementType.METHOD)  // 应用目标
                        @Retention(RetentionPolicy.RUNTIME)  // 保留策略
                        @Documented  // 包含在文档中
                        @Inherited  // 可继承
                        public @interface MyAnnotation {
                            String value() default "";
                        }
                    """.trimIndent(),
                    explanation = "内置注解包括@Override、@Deprecated、@SuppressWarnings。元注解包括@Target、@Retention、@Documented、@Inherited。"
                )
            ),
            useCases = listOf("代码标记：使用注解标记代码", "元数据：添加元数据", "框架：框架中使用注解"),
            keyPoints = listOf("注解用于添加元数据", "内置注解：@Override、@Deprecated等", "元注解控制注解行为"),
            notes = listOf("注解不影响代码逻辑", "注解需要处理器处理", "注意注解的保留策略"),
            practiceTips = "建议：理解注解的使用，注意注解的保留策略。注解需要处理器处理，常用于框架开发。"
        ),
        
        // 2. 自定义注解
        KnowledgeDetail(
            id = "java_custom_annotation",
            title = "自定义注解",
            overview = "可以定义自定义注解，使用@interface关键字。自定义注解可以包含成员变量，用于传递信息。",
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：自定义注解",
                    code = """
                        @Target(ElementType.METHOD)
                        @Retention(RetentionPolicy.RUNTIME)
                        public @interface Test {
                            String value() default "";
                            int timeout() default 0;
                        }
                        
                        // 使用
                        @Test(value = "testMethod", timeout = 1000)
                        public void testMethod() {
                            // ...
                        }
                    """.trimIndent(),
                    explanation = "自定义注解使用@interface定义，可以包含成员变量。使用元注解控制注解行为。"
                )
            ),
            useCases = listOf("框架开发：框架中使用自定义注解", "测试框架：测试框架使用注解", "代码生成：注解处理器"),
            keyPoints = listOf("使用@interface定义注解", "可以包含成员变量", "使用元注解控制行为"),
            notes = listOf("注解需要处理器处理", "注意保留策略", "合理设计注解"),
            practiceTips = "建议：合理设计自定义注解，注意保留策略。注解需要处理器处理，常用于框架开发。"
        ),
        
        // 3. 常见注解框架
        KnowledgeDetail(
            id = "java_annotation_frameworks",
            title = "常见注解框架",
            overview = "常见的注解框架包括Spring、JUnit、Hibernate等。这些框架大量使用注解，简化了开发。",
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：常见注解",
                    code = """
                        // Spring
                        @Component
                        @Service
                        @Autowired
                        
                        // JUnit
                        @Test
                        @Before
                        @After
                        
                        // Hibernate
                        @Entity
                        @Table
                        @Column
                    """.trimIndent(),
                    explanation = "常见注解框架包括Spring、JUnit、Hibernate等，大量使用注解简化开发。"
                )
            ),
            useCases = listOf("框架使用：使用框架注解", "简化开发：简化开发", "代码组织：组织代码"),
            keyPoints = listOf("Spring使用注解", "JUnit使用注解", "Hibernate使用注解"),
            notes = listOf("理解框架注解", "合理使用注解", "注意注解的配置"),
            practiceTips = "建议：熟悉常见注解框架的注解，合理使用注解简化开发。注意注解的配置和使用。"
        ),
        
        // ========== Java 流式API ==========
        
        // 1. Stream基础（创建、中间操作、终端操作）
        KnowledgeDetail(
            id = "java_stream_basic",
            title = "Stream基础（创建、中间操作、终端操作）",
            overview = "Stream API是Java 8引入的函数式编程特性，用于处理集合数据。Stream包括创建、中间操作、终端操作三个阶段。",
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：Stream基础",
                    code = """
                        List<String> list = Arrays.asList("a", "b", "c");
                        
                        // 创建Stream
                        Stream<String> stream = list.stream();
                        
                        // 中间操作（返回Stream）
                        stream.filter(s -> s.startsWith("a"))
                              .map(String::toUpperCase)
                              .forEach(System.out::println);
                        
                        // 终端操作（触发计算）
                        long count = list.stream().count();
                    """.trimIndent(),
                    explanation = "Stream包括创建、中间操作（返回Stream）、终端操作（触发计算）。中间操作是惰性的，终端操作才触发计算。"
                )
            ),
            useCases = listOf("集合处理：处理集合数据", "函数式编程：函数式编程", "代码简化：简化代码"),
            keyPoints = listOf("Stream用于处理集合", "包括创建、中间操作、终端操作", "中间操作是惰性的"),
            notes = listOf("中间操作不触发计算", "终端操作触发计算", "Stream只能使用一次"),
            practiceTips = "建议：使用Stream处理集合数据，注意中间操作是惰性的。Stream只能使用一次，终端操作触发计算。"
        ),
        
        // 2. 中间操作（filter、map、flatMap）
        KnowledgeDetail(
            id = "java_intermediate_ops",
            title = "中间操作（filter、map、flatMap）",
            overview = "中间操作包括filter（过滤）、map（映射）、flatMap（扁平化映射）等。中间操作返回Stream，是惰性的。",
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：中间操作",
                    code = """
                        List<String> list = Arrays.asList("apple", "banana", "orange");
                        
                        // filter：过滤
                        list.stream().filter(s -> s.length() > 5).forEach(System.out::println);
                        
                        // map：映射
                        list.stream().map(String::toUpperCase).forEach(System.out::println);
                        
                        // flatMap：扁平化映射
                        List<List<String>> nested = Arrays.asList(
                            Arrays.asList("a", "b"),
                            Arrays.asList("c", "d")
                        );
                        nested.stream().flatMap(List::stream).forEach(System.out::println);
                    """.trimIndent(),
                    explanation = "中间操作包括filter（过滤）、map（映射）、flatMap（扁平化映射）。中间操作返回Stream，是惰性的。"
                )
            ),
            useCases = listOf("数据过滤：使用filter过滤", "数据转换：使用map转换", "扁平化：使用flatMap扁平化"),
            keyPoints = listOf("filter用于过滤", "map用于映射", "flatMap用于扁平化", "中间操作是惰性的"),
            notes = listOf("中间操作不触发计算", "可以链式调用", "注意性能影响"),
            practiceTips = "建议：合理使用中间操作，注意性能影响。中间操作是惰性的，可以链式调用。"
        ),
        
        // 3. 终端操作（forEach、collect、reduce）
        KnowledgeDetail(
            id = "java_terminal_ops",
            title = "终端操作（forEach、collect、reduce）",
            overview = "终端操作触发Stream的计算，包括forEach（遍历）、collect（收集）、reduce（归约）等。终端操作是急切的。",
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：终端操作",
                    code = """
                        List<String> list = Arrays.asList("a", "b", "c");
                        
                        // forEach：遍历
                        list.stream().forEach(System.out::println);
                        
                        // collect：收集
                        List<String> upper = list.stream()
                                                .map(String::toUpperCase)
                                                .collect(Collectors.toList());
                        
                        // reduce：归约
                        Optional<String> result = list.stream()
                                                     .reduce((a, b) -> a + b);
                    """.trimIndent(),
                    explanation = "终端操作包括forEach（遍历）、collect（收集）、reduce（归约）。终端操作触发计算，是急切的。"
                )
            ),
            useCases = listOf("数据收集：使用collect收集", "数据归约：使用reduce归约", "数据遍历：使用forEach遍历"),
            keyPoints = listOf("终端操作触发计算", "forEach用于遍历", "collect用于收集", "reduce用于归约"),
            notes = listOf("终端操作是急切的", "Stream只能使用一次", "注意性能影响"),
            practiceTips = "建议：合理使用终端操作，注意性能影响。终端操作触发计算，Stream只能使用一次。"
        ),
        
        // 4. Collectors工具类
        KnowledgeDetail(
            id = "java_collectors",
            title = "Collectors工具类",
            overview = "Collectors提供了丰富的收集器，用于将Stream收集到集合、Map等。Collectors简化了数据收集操作。",
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：Collectors",
                    code = """
                        List<String> list = Arrays.asList("a", "b", "c");
                        
                        // 收集到List
                        List<String> list2 = list.stream().collect(Collectors.toList());
                        
                        // 收集到Set
                        Set<String> set = list.stream().collect(Collectors.toSet());
                        
                        // 收集到Map
                        Map<String, Integer> map = list.stream()
                            .collect(Collectors.toMap(s -> s, String::length));
                        
                        // 分组
                        Map<Integer, List<String>> grouped = list.stream()
                            .collect(Collectors.groupingBy(String::length));
                    """.trimIndent(),
                    explanation = "Collectors提供了丰富的收集器，包括toList()、toSet()、toMap()、groupingBy()等。"
                )
            ),
            useCases = listOf("数据收集：收集到集合", "数据分组：分组数据", "数据统计：统计数据"),
            keyPoints = listOf("Collectors提供收集器", "可以收集到List、Set、Map", "支持分组和统计"),
            notes = listOf("Collectors简化收集", "支持分组", "支持统计"),
            practiceTips = "建议：使用Collectors简化数据收集，支持分组和统计。合理使用Collectors提高代码可读性。"
        ),
        
        // 5. 并行流（Parallel Stream）
        KnowledgeDetail(
            id = "java_parallel_stream",
            title = "并行流（Parallel Stream）",
            overview = "并行流利用多核CPU并行处理数据，提高性能。使用parallelStream()创建并行流，适合大数据量处理。",
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：并行流",
                    code = """
                        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
                        
                        // 并行流
                        list.parallelStream()
                            .filter(i -> i > 2)
                            .forEach(System.out::println);
                        
                        // 注意：并行流不保证顺序
                        // 适合无状态操作
                        // 不适合有状态操作
                    """.trimIndent(),
                    explanation = "并行流使用parallelStream()创建，利用多核CPU并行处理。注意并行流不保证顺序，适合无状态操作。"
                )
            ),
            useCases = listOf("大数据处理：处理大数据量", "性能优化：提高性能", "并行计算：并行计算"),
            keyPoints = listOf("并行流利用多核CPU", "不保证顺序", "适合无状态操作", "注意线程安全"),
            notes = listOf("并行流不保证顺序", "适合无状态操作", "不适合有状态操作", "注意性能影响"),
            practiceTips = "建议：使用并行流处理大数据量，注意不保证顺序。适合无状态操作，不适合有状态操作。注意性能影响。"
        ),
        
        // ========== Java Lambda表达式和函数式接口 ==========
        
        // 1. Lambda表达式语法
        KnowledgeDetail(
            id = "java_lambda_basic",
            title = "Lambda表达式语法",
            overview = "Lambda表达式是Java 8引入的函数式编程特性，简化了匿名内部类的写法。Lambda表达式使代码更简洁。",
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：Lambda语法",
                    code = """
                        // 传统方式
                        Runnable r1 = new Runnable() {
                            @Override
                            public void run() {
                                System.out.println("Hello");
                            }
                        };
                        
                        // Lambda方式
                        Runnable r2 = () -> System.out.println("Hello");
                        
                        // 带参数
                        Comparator<String> c = (a, b) -> a.compareTo(b);
                        
                        // 方法引用
                        Comparator<String> c2 = String::compareTo;
                    """.trimIndent(),
                    explanation = "Lambda表达式简化了匿名内部类的写法，语法：(参数) -> 表达式。方法引用进一步简化。"
                )
            ),
            useCases = listOf("代码简化：简化代码", "函数式编程：函数式编程", "集合操作：集合操作"),
            keyPoints = listOf("Lambda简化匿名内部类", "语法：(参数) -> 表达式", "方法引用进一步简化"),
            notes = listOf("Lambda是语法糖", "需要函数式接口", "注意作用域"),
            practiceTips = "建议：使用Lambda简化代码，注意需要函数式接口。方法引用进一步简化。注意作用域和变量捕获。"
        ),
        
        // 2. 函数式接口（Function、Consumer、Supplier、Predicate）
        KnowledgeDetail(
            id = "java_functional_interfaces",
            title = "函数式接口（Function、Consumer、Supplier、Predicate）",
            overview = "函数式接口是只有一个抽象方法的接口。Java提供了Function、Consumer、Supplier、Predicate等常用函数式接口。",
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：函数式接口",
                    code = """
                        // Function：接受一个参数，返回一个结果
                        Function<String, Integer> f = String::length;
                        
                        // Consumer：接受一个参数，无返回值
                        Consumer<String> c = System.out::println;
                        
                        // Supplier：无参数，返回一个结果
                        Supplier<String> s = () -> "Hello";
                        
                        // Predicate：接受一个参数，返回boolean
                        Predicate<String> p = str -> str.length() > 5;
                    """.trimIndent(),
                    explanation = "函数式接口包括Function（转换）、Consumer（消费）、Supplier（供应）、Predicate（判断）。"
                )
            ),
            useCases = listOf("函数式编程：函数式编程", "代码简化：简化代码", "集合操作：集合操作"),
            keyPoints = listOf("函数式接口只有一个抽象方法", "Function用于转换", "Consumer用于消费", "Supplier用于供应", "Predicate用于判断"),
            notes = listOf("函数式接口可以标注@FunctionalInterface", "支持Lambda表达式", "合理使用函数式接口"),
            practiceTips = "建议：理解函数式接口，合理使用Function、Consumer、Supplier、Predicate。函数式接口支持Lambda表达式。"
        ),
        
        // 3. 方法引用
        KnowledgeDetail(
            id = "java_method_reference",
            title = "方法引用",
            overview = "方法引用是Lambda表达式的简化形式，用于引用已有的方法。方法引用使代码更简洁。",
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：方法引用",
                    code = """
                        List<String> list = Arrays.asList("a", "b", "c");
                        
                        // 静态方法引用
                        list.stream().map(String::valueOf);
                        
                        // 实例方法引用
                        list.stream().map(String::toUpperCase);
                        
                        // 构造函数引用
                        Supplier<List<String>> supplier = ArrayList::new;
                    """.trimIndent(),
                    explanation = "方法引用包括静态方法引用、实例方法引用、构造函数引用。方法引用简化Lambda表达式。"
                )
            ),
            useCases = listOf("代码简化：简化Lambda", "方法复用：复用方法", "代码可读性：提高可读性"),
            keyPoints = listOf("方法引用简化Lambda", "包括静态、实例、构造函数引用", "提高代码可读性"),
            notes = listOf("方法引用是语法糖", "需要函数式接口", "合理使用方法引用"),
            practiceTips = "建议：使用方法引用简化Lambda表达式，提高代码可读性。注意方法引用的使用场景。"
        ),
        
        // 4. Lambda的应用
        KnowledgeDetail(
            id = "java_lambda_usage",
            title = "Lambda的应用",
            overview = "Lambda表达式广泛应用于集合操作、事件处理、并发编程等场景。Lambda使代码更简洁、更易读。",
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：Lambda应用",
                    code = """
                        // 集合操作
                        list.stream().filter(s -> s.length() > 5).forEach(System.out::println);
                        
                        // 事件处理
                        button.setOnClickListener(e -> System.out.println("Clicked"));
                        
                        // 并发编程
                        executor.submit(() -> System.out.println("Task"));
                    """.trimIndent(),
                    explanation = "Lambda广泛应用于集合操作、事件处理、并发编程等场景，使代码更简洁。"
                )
            ),
            useCases = listOf("集合操作：集合操作", "事件处理：事件处理", "并发编程：并发编程"),
            keyPoints = listOf("Lambda应用广泛", "集合操作使用Lambda", "事件处理使用Lambda", "并发编程使用Lambda"),
            notes = listOf("Lambda使代码简洁", "注意性能影响", "合理使用Lambda"),
            practiceTips = "建议：合理使用Lambda简化代码，注意性能影响。Lambda使代码更简洁、更易读。"
        ),
        
        // ========== Java IO和NIO ==========
        
        // 1. 传统IO（字节流、字符流）
        KnowledgeDetail(
            id = "java_traditional_io",
            title = "传统IO（字节流、字符流）",
            overview = "传统IO包括字节流（InputStream/OutputStream）和字符流（Reader/Writer）。字节流处理二进制数据，字符流处理文本数据。",
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：字节流和字符流",
                    code = """
                        // 字节流
                        FileInputStream fis = new FileInputStream("file.txt");
                        byte[] buffer = new byte[1024];
                        int bytesRead = fis.read(buffer);
                        fis.close();
                        
                        // 字符流
                        FileReader fr = new FileReader("file.txt");
                        BufferedReader br = new BufferedReader(fr);
                        String line = br.readLine();
                        br.close();
                    """.trimIndent(),
                    explanation = "字节流处理二进制数据，字符流处理文本数据。使用缓冲流提高性能。"
                )
            ),
            useCases = listOf("文件读写：读写文件", "数据处理：处理数据", "网络通信：网络通信"),
            keyPoints = listOf("字节流处理二进制数据", "字符流处理文本数据", "使用缓冲流提高性能"),
            notes = listOf("注意关闭流", "使用try-with-resources", "注意异常处理"),
            practiceTips = "建议：使用try-with-resources自动关闭流，注意异常处理。字节流处理二进制数据，字符流处理文本数据。"
        ),
        
        // 2. NIO（Channel、Buffer、Selector）
        KnowledgeDetail(
            id = "java_nio",
            title = "NIO（Channel、Buffer、Selector）",
            overview = "NIO提供了非阻塞IO，包括Channel（通道）、Buffer（缓冲区）、Selector（选择器）。NIO适合高并发场景。",
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：NIO",
                    code = """
                        // Channel和Buffer
                        FileChannel channel = FileChannel.open(Paths.get("file.txt"));
                        ByteBuffer buffer = ByteBuffer.allocate(1024);
                        channel.read(buffer);
                        buffer.flip();
                        channel.close();
                        
                        // Selector用于多路复用
                        Selector selector = Selector.open();
                        ServerSocketChannel serverChannel = ServerSocketChannel.open();
                        serverChannel.configureBlocking(false);
                        serverChannel.register(selector, SelectionKey.OP_ACCEPT);
                    """.trimIndent(),
                    explanation = "NIO包括Channel、Buffer、Selector。NIO提供非阻塞IO，适合高并发场景。"
                )
            ),
            useCases = listOf("高并发：高并发场景", "非阻塞IO：非阻塞IO", "网络编程：网络编程"),
            keyPoints = listOf("NIO提供非阻塞IO", "Channel是通道", "Buffer是缓冲区", "Selector用于多路复用"),
            notes = listOf("NIO适合高并发", "注意Buffer的状态", "Selector用于多路复用"),
            practiceTips = "建议：使用NIO处理高并发场景，注意Buffer的状态。Selector用于多路复用，提高性能。"
        ),
        
        // 3. NIO.2（Files类、WatchService）
        KnowledgeDetail(
            id = "java_nio2",
            title = "NIO.2（Files类、WatchService）",
            overview = "NIO.2提供了Files类和WatchService，简化了文件操作和文件监控。Files类提供了丰富的文件操作方法。",
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：NIO.2",
                    code = """
                        // Files类
                        Path path = Paths.get("file.txt");
                        byte[] data = Files.readAllBytes(path);
                        List<String> lines = Files.readAllLines(path);
                        Files.write(path, data);
                        
                        // WatchService监控文件变化
                        WatchService watchService = FileSystems.getDefault().newWatchService();
                        Path dir = Paths.get(".");
                        dir.register(watchService, StandardWatchEventKinds.ENTRY_MODIFY);
                    """.trimIndent(),
                    explanation = "NIO.2提供了Files类和WatchService，简化了文件操作和文件监控。"
                )
            ),
            useCases = listOf("文件操作：文件操作", "文件监控：监控文件变化", "简化代码：简化代码"),
            keyPoints = listOf("Files类简化文件操作", "WatchService监控文件变化", "NIO.2提供便利方法"),
            notes = listOf("Files类提供便利方法", "WatchService用于监控", "注意异常处理"),
            practiceTips = "建议：使用Files类简化文件操作，使用WatchService监控文件变化。NIO.2提供了便利的方法。"
        ),
        
        // ========== Java 网络编程 ==========
        
        // 1. Socket编程（TCP/IP、UDP）
        KnowledgeDetail(
            id = "java_socket",
            title = "Socket编程（TCP/IP、UDP）",
            overview = "Socket编程用于网络通信，包括TCP和UDP。TCP是可靠连接，UDP是无连接。Socket是网络编程的基础。",
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：TCP Socket",
                    code = """
                        // 服务器端
                        ServerSocket serverSocket = new ServerSocket(8080);
                        Socket socket = serverSocket.accept();
                        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        String message = in.readLine();
                        socket.close();
                        
                        // 客户端
                        Socket clientSocket = new Socket("localhost", 8080);
                        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                        out.println("Hello");
                        clientSocket.close();
                    """.trimIndent(),
                    explanation = "TCP Socket提供可靠连接，ServerSocket用于服务器，Socket用于客户端。"
                )
            ),
            useCases = listOf("网络通信：网络通信", "客户端服务器：客户端服务器通信", "数据传输：数据传输"),
            keyPoints = listOf("TCP是可靠连接", "UDP是无连接", "ServerSocket用于服务器", "Socket用于客户端"),
            notes = listOf("TCP保证可靠性", "UDP性能更好", "注意异常处理", "注意资源释放"),
            practiceTips = "建议：使用TCP保证可靠性，使用UDP提高性能。注意异常处理和资源释放。"
        ),
        
        // 2. HTTP客户端（HttpURLConnection）
        KnowledgeDetail(
            id = "java_http_client",
            title = "HTTP客户端（HttpURLConnection）",
            overview = "HttpURLConnection用于HTTP通信，可以发送HTTP请求和接收HTTP响应。HttpURLConnection是Java标准库提供的HTTP客户端。",
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：HttpURLConnection",
                    code = """
                        URL url = new URL("http://example.com/api");
                        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                        conn.setRequestMethod("GET");
                        conn.setRequestProperty("Accept", "application/json");
                        
                        int responseCode = conn.getResponseCode();
                        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                        String response = in.readLine();
                        conn.disconnect();
                    """.trimIndent(),
                    explanation = "HttpURLConnection用于HTTP通信，可以设置请求方法和请求头，获取响应码和响应体。"
                )
            ),
            useCases = listOf("HTTP请求：发送HTTP请求", "API调用：调用API", "网络通信：网络通信"),
            keyPoints = listOf("HttpURLConnection用于HTTP通信", "可以设置请求方法和请求头", "可以获取响应码和响应体"),
            notes = listOf("注意异常处理", "注意资源释放", "可以使用更现代的HTTP客户端"),
            practiceTips = "建议：使用HttpURLConnection进行HTTP通信，注意异常处理和资源释放。可以使用更现代的HTTP客户端（如OkHttp）。"
        ),
        
        // ========== Java JDBC数据库操作 ==========
        
        // 1. JDBC基础（驱动、连接）
        KnowledgeDetail(
            id = "java_jdbc_basic",
            title = "JDBC基础（驱动、连接）",
            overview = "JDBC是Java数据库连接标准，用于连接和操作数据库。JDBC包括驱动加载、连接建立、语句执行等步骤。",
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：JDBC连接",
                    code = """
                        // 加载驱动
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        
                        // 建立连接
                        String url = "jdbc:mysql://localhost:3306/mydb";
                        String user = "root";
                        String password = "password";
                        Connection conn = DriverManager.getConnection(url, user, password);
                        
                        // 关闭连接
                        conn.close();
                    """.trimIndent(),
                    explanation = "JDBC连接包括驱动加载、连接建立、连接关闭。使用DriverManager.getConnection()建立连接。"
                )
            ),
            useCases = listOf("数据库操作：操作数据库", "数据访问：数据访问", "应用开发：应用开发"),
            keyPoints = listOf("JDBC是数据库连接标准", "需要加载驱动", "使用DriverManager建立连接", "注意关闭连接"),
            notes = listOf("注意异常处理", "注意资源释放", "使用try-with-resources", "注意SQL注入"),
            practiceTips = "建议：使用JDBC连接数据库，注意异常处理和资源释放。使用try-with-resources自动关闭连接。注意SQL注入防护。"
        ),
        
        // 2. JDBC操作（Statement、PreparedStatement、ResultSet）
        KnowledgeDetail(
            id = "java_jdbc_ops",
            title = "JDBC操作（Statement、PreparedStatement、ResultSet）",
            overview = "JDBC操作包括Statement、PreparedStatement、ResultSet。PreparedStatement性能更好且安全，ResultSet用于处理查询结果。",
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：JDBC操作",
                    code = """
                        // Statement（不推荐，有SQL注入风险）
                        Statement stmt = conn.createStatement();
                        ResultSet rs = stmt.executeQuery("SELECT * FROM users");
                        
                        // PreparedStatement（推荐）
                        String sql = "SELECT * FROM users WHERE id = ?";
                        PreparedStatement pstmt = conn.prepareStatement(sql);
                        pstmt.setInt(1, 1);
                        ResultSet rs2 = pstmt.executeQuery();
                        
                        // 处理结果
                        while (rs2.next()) {
                            int id = rs2.getInt("id");
                            String name = rs2.getString("name");
                        }
                    """.trimIndent(),
                    explanation = "PreparedStatement性能更好且安全，ResultSet用于处理查询结果。使用PreparedStatement避免SQL注入。"
                )
            ),
            useCases = listOf("数据查询：查询数据", "数据更新：更新数据", "数据插入：插入数据"),
            keyPoints = listOf("PreparedStatement性能更好", "PreparedStatement避免SQL注入", "ResultSet处理查询结果", "注意资源释放"),
            notes = listOf("使用PreparedStatement", "注意SQL注入", "注意异常处理", "注意资源释放"),
            practiceTips = "建议：使用PreparedStatement进行数据库操作，避免SQL注入。注意异常处理和资源释放。"
        ),
        
        // 3. 连接池（HikariCP、C3P0、Druid）
        KnowledgeDetail(
            id = "java_connection_pool",
            title = "连接池（HikariCP、C3P0、Druid）",
            overview = "连接池管理数据库连接，提高性能。常见的连接池包括HikariCP、C3P0、Druid。连接池复用连接，减少连接创建开销。",
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：连接池",
                    code = """
                        // HikariCP（推荐，性能最好）
                        HikariConfig config = new HikariConfig();
                        config.setJdbcUrl("jdbc:mysql://localhost:3306/mydb");
                        config.setUsername("root");
                        config.setPassword("password");
                        HikariDataSource dataSource = new HikariDataSource(config);
                        Connection conn = dataSource.getConnection();
                    """.trimIndent(),
                    explanation = "连接池管理数据库连接，提高性能。HikariCP性能最好，推荐使用。"
                )
            ),
            useCases = listOf("性能优化：提高性能", "连接管理：管理连接", "高并发：高并发场景"),
            keyPoints = listOf("连接池提高性能", "HikariCP性能最好", "连接池复用连接", "注意连接池配置"),
            notes = listOf("使用连接池提高性能", "注意连接池配置", "注意连接泄漏", "合理配置连接数"),
            practiceTips = "建议：使用连接池提高性能，HikariCP性能最好。注意连接池配置，避免连接泄漏。"
        ),
        
        // ========== Java 设计模式 ==========
        
        // 1. 创建型模式（单例、工厂、建造者）
        KnowledgeDetail(
            id = "java_creational",
            title = "创建型模式（单例、工厂、建造者）",
            overview = "创建型模式用于对象的创建，包括单例模式、工厂模式、建造者模式等。创建型模式提供了灵活的对象创建方式。",
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：单例模式",
                    code = """
                        // 懒汉式单例
                        class Singleton {
                            private static Singleton instance;
                            private Singleton() {}
                            public static synchronized Singleton getInstance() {
                                if (instance == null) {
                                    instance = new Singleton();
                                }
                                return instance;
                            }
                        }
                        
                        // 枚举单例（推荐）
                        enum SingletonEnum {
                            INSTANCE;
                        }
                    """.trimIndent(),
                    explanation = "单例模式确保一个类只有一个实例。枚举单例是推荐方式，线程安全且简洁。"
                )
            ),
            useCases = listOf("对象创建：灵活创建对象", "代码复用：代码复用", "设计优化：设计优化"),
            keyPoints = listOf("单例模式确保唯一实例", "工厂模式创建对象", "建造者模式构建复杂对象"),
            notes = listOf("理解设计模式", "合理使用设计模式", "注意线程安全"),
            practiceTips = "建议：理解创建型模式，合理使用单例、工厂、建造者模式。注意线程安全和性能。"
        ),
        
        // 2. 结构型模式（适配器、装饰者、代理）
        KnowledgeDetail(
            id = "java_structural",
            title = "结构型模式（适配器、装饰者、代理）",
            overview = "结构型模式用于组合类和对象，包括适配器模式、装饰者模式、代理模式等。结构型模式提供了灵活的结构设计。",
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：适配器模式",
                    code = """
                        // 适配器模式：将一个接口转换为另一个接口
                        interface Target {
                            void request();
                        }
                        
                        class Adaptee {
                            void specificRequest() { }
                        }
                        
                        class Adapter implements Target {
                            private Adaptee adaptee;
                            public void request() {
                                adaptee.specificRequest();
                            }
                        }
                    """.trimIndent(),
                    explanation = "适配器模式将一个接口转换为另一个接口，装饰者模式动态添加功能，代理模式控制访问。"
                )
            ),
            useCases = listOf("接口适配：适配接口", "功能扩展：扩展功能", "访问控制：控制访问"),
            keyPoints = listOf("适配器模式适配接口", "装饰者模式添加功能", "代理模式控制访问"),
            notes = listOf("理解结构型模式", "合理使用设计模式", "注意设计原则"),
            practiceTips = "建议：理解结构型模式，合理使用适配器、装饰者、代理模式。注意设计原则和性能。"
        ),
        
        // 3. 行为型模式（观察者、策略、命令）
        KnowledgeDetail(
            id = "java_behavioral",
            title = "行为型模式（观察者、策略、命令）",
            overview = "行为型模式用于对象间的通信，包括观察者模式、策略模式、命令模式等。行为型模式提供了灵活的交互方式。",
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：观察者模式",
                    code = """
                        // 观察者模式：定义对象间一对多的依赖关系
                        interface Observer {
                            void update(String message);
                        }
                        
                        class Subject {
                            private List<Observer> observers = new ArrayList<>();
                            public void addObserver(Observer observer) {
                                observers.add(observer);
                            }
                            public void notifyObservers(String message) {
                                for (Observer observer : observers) {
                                    observer.update(message);
                                }
                            }
                        }
                    """.trimIndent(),
                    explanation = "观察者模式定义对象间一对多的依赖，策略模式封装算法，命令模式封装请求。"
                )
            ),
            useCases = listOf("事件通知：事件通知", "算法封装：封装算法", "请求封装：封装请求"),
            keyPoints = listOf("观察者模式处理事件", "策略模式封装算法", "命令模式封装请求"),
            notes = listOf("理解行为型模式", "合理使用设计模式", "注意设计原则"),
            practiceTips = "建议：理解行为型模式，合理使用观察者、策略、命令模式。注意设计原则和代码质量。"
        ),
        
        // ========== Java 8+ 新特性 ==========
        
        // 1. Java 8（Lambda、Stream、Optional、新日期时间API）
        KnowledgeDetail(
            id = "java_java8",
            title = "Java 8（Lambda、Stream、Optional、新日期时间API）",
            overview = "Java 8引入了Lambda表达式、Stream API、Optional、新日期时间API等特性。这些特性使Java更现代化。",
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：Java 8特性",
                    code = """
                        // Lambda表达式
                        list.stream().filter(s -> s.length() > 5).forEach(System.out::println);
                        
                        // Optional
                        Optional<String> optional = Optional.of("Hello");
                        optional.ifPresent(System.out::println);
                        
                        // 新日期时间API
                        LocalDate date = LocalDate.now();
                        LocalDateTime dateTime = LocalDateTime.now();
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    """.trimIndent(),
                    explanation = "Java 8引入了Lambda、Stream、Optional、新日期时间API等特性，使Java更现代化。"
                )
            ),
            useCases = listOf("函数式编程：函数式编程", "代码简化：简化代码", "日期处理：日期处理"),
            keyPoints = listOf("Lambda表达式简化代码", "Stream API处理集合", "Optional处理空值", "新日期时间API"),
            notes = listOf("Java 8是重要版本", "理解新特性", "合理使用新特性"),
            practiceTips = "建议：掌握Java 8新特性，合理使用Lambda、Stream、Optional、新日期时间API。这些特性使Java更现代化。"
        ),
        
        // 2. Java 9（模块系统、接口私有方法）
        KnowledgeDetail(
            id = "java_java9",
            title = "Java 9（模块系统、接口私有方法）",
            overview = "Java 9引入了模块系统和接口私有方法。模块系统提供了更好的模块化支持，接口私有方法提供了代码复用。",
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：Java 9特性",
                    code = """
                        // 接口私有方法
                        interface MyInterface {
                            default void method1() {
                                privateMethod();
                            }
                            
                            private void privateMethod() {
                                // 私有方法
                            }
                        }
                        
                        // 模块系统（module-info.java）
                        // module com.example {
                        //     requires java.base;
                        //     exports com.example.api;
                        // }
                    """.trimIndent(),
                    explanation = "Java 9引入了模块系统和接口私有方法，提供了更好的模块化支持和代码复用。"
                )
            ),
            useCases = listOf("模块化：模块化开发", "代码复用：代码复用", "接口设计：接口设计"),
            keyPoints = listOf("模块系统提供模块化", "接口私有方法提供代码复用", "Java 9是重要版本"),
            notes = listOf("理解模块系统", "合理使用模块系统", "注意模块依赖"),
            practiceTips = "建议：理解Java 9的模块系统和接口私有方法，合理使用这些特性。模块系统提供了更好的模块化支持。"
        ),
        
        // 3. Java 10+（var关键字、Records、Sealed Classes）
        KnowledgeDetail(
            id = "java_java10_plus",
            title = "Java 10+（var关键字、Records、Sealed Classes）",
            overview = "Java 10+引入了var关键字、Records、Sealed Classes等特性。这些特性进一步简化了代码。",
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：Java 10+特性",
                    code = """
                        // var关键字（局部变量类型推断）
                        var list = new ArrayList<String>();
                        var name = "Hello";
                        
                        // Records（Java 14+）
                        record Person(String name, int age) {
                            // 自动生成构造函数、getter、equals、hashCode、toString
                        }
                        
                        // Sealed Classes（Java 17+）
                        // sealed class Shape permits Circle, Rectangle {
                        // }
                    """.trimIndent(),
                    explanation = "Java 10+引入了var关键字、Records、Sealed Classes等特性，进一步简化了代码。"
                )
            ),
            useCases = listOf("代码简化：简化代码", "数据类：数据类", "类型安全：类型安全"),
            keyPoints = listOf("var关键字简化类型声明", "Records简化数据类", "Sealed Classes提供类型安全"),
            notes = listOf("理解新特性", "合理使用新特性", "注意版本兼容性"),
            practiceTips = "建议：理解Java 10+的新特性，合理使用var、Records、Sealed Classes。这些特性进一步简化了代码。"
        ),
        
        // ========== Java 9+ 模块系统 ==========
        
        // 1. 模块系统基础（module-info.java）
        KnowledgeDetail(
            id = "java_modules_basic",
            title = "模块系统基础（module-info.java）",
            overview = "Java 9模块系统提供了更好的模块化支持。module-info.java定义模块，包括模块名、依赖、导出等。",
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：模块定义",
                    code = """
                        // module-info.java
                        module com.example.app {
                            requires java.base;
                            requires java.sql;
                            exports com.example.api;
                            opens com.example.internal;
                        }
                    """.trimIndent(),
                    explanation = "module-info.java定义模块，requires声明依赖，exports导出包，opens开放反射访问。"
                )
            ),
            useCases = listOf("模块化：模块化开发", "依赖管理：依赖管理", "封装：更好的封装"),
            keyPoints = listOf("模块系统提供模块化", "module-info.java定义模块", "requires声明依赖", "exports导出包"),
            notes = listOf("理解模块系统", "合理设计模块", "注意模块依赖"),
            practiceTips = "建议：理解Java 9模块系统，合理设计模块。module-info.java定义模块，注意模块依赖和导出。"
        ),
        
        // 2. 模块系统实践
        KnowledgeDetail(
            id = "java_modules_practice",
            title = "模块系统实践",
            overview = "模块系统实践包括模块设计、依赖管理、模块测试等。合理使用模块系统提高代码的可维护性。",
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：模块实践",
                    code = """
                        // 1. 模块设计：合理划分模块
                        // 2. 依赖管理：管理模块依赖
                        // 3. 模块测试：测试模块
                        // 4. 模块打包：打包模块
                    """.trimIndent(),
                    explanation = "模块系统实践包括模块设计、依赖管理、模块测试等。合理使用模块系统提高代码质量。"
                )
            ),
            useCases = listOf("模块设计：设计模块", "依赖管理：管理依赖", "代码组织：组织代码"),
            keyPoints = listOf("合理设计模块", "管理模块依赖", "测试模块", "打包模块"),
            notes = listOf("理解模块实践", "合理使用模块系统", "注意模块设计"),
            practiceTips = "建议：理解模块系统实践，合理设计模块，管理模块依赖。模块系统提高了代码的可维护性。"
        ),
        
        // ========== Java与Kotlin互操作 ==========
        
        // 1. Kotlin调用Java
        KnowledgeDetail(
            id = "java_kotlin_call_java",
            title = "Kotlin调用Java",
            overview = "Kotlin可以无缝调用Java代码。Kotlin会自动处理Java的可空性、getter/setter等。理解Kotlin调用Java的机制有助于混合开发。",
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：Kotlin调用Java",
                    code = """
                        // Java类
                        // public class JavaClass {
                        //     public String getName() { return "Java"; }
                        // }
                        
                        // Kotlin调用
                        // val javaClass = JavaClass()
                        // val name = javaClass.name  // 自动调用getName()
                    """.trimIndent(),
                    explanation = "Kotlin可以无缝调用Java代码，自动处理getter/setter，支持SAM转换。"
                )
            ),
            useCases = listOf("混合开发：混合开发", "代码复用：代码复用", "迁移：Kotlin迁移"),
            keyPoints = listOf("Kotlin可以调用Java", "自动处理getter/setter", "支持SAM转换", "注意可空性"),
            notes = listOf("理解互操作机制", "注意可空性处理", "合理使用互操作"),
            practiceTips = "建议：理解Kotlin调用Java的机制，注意可空性处理。Kotlin可以无缝调用Java代码。"
        ),
        
        // 2. Java调用Kotlin
        KnowledgeDetail(
            id = "java_java_call_kotlin",
            title = "Java调用Kotlin",
            overview = "Java可以调用Kotlin代码，但需要注意一些互操作性问题。使用@JvmName、@JvmStatic等注解优化Java调用。",
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：Java调用Kotlin",
                    code = """
                        // Kotlin文件
                        // @file:JvmName("Utils")
                        // fun topLevelFunction() { }
                        
                        // Java调用
                        // UtilsKt.topLevelFunction();
                        // 或 Utils.topLevelFunction();（使用@JvmName）
                    """.trimIndent(),
                    explanation = "Java可以调用Kotlin代码，使用@JvmName改变生成的类名，使用@JvmStatic提供静态方法。"
                )
            ),
            useCases = listOf("混合开发：混合开发", "代码复用：代码复用", "迁移：Kotlin迁移"),
            keyPoints = listOf("Java可以调用Kotlin", "使用@JvmName优化", "使用@JvmStatic优化", "注意互操作性问题"),
            notes = listOf("理解互操作机制", "使用注解优化", "注意互操作性问题"),
            practiceTips = "建议：理解Java调用Kotlin的机制，使用@JvmName、@JvmStatic等注解优化。注意互操作性问题。"
        ),
        
        // 3. 互操作最佳实践
        KnowledgeDetail(
            id = "java_interop_best",
            title = "互操作最佳实践",
            overview = "Java和Kotlin互操作的最佳实践包括合理使用注解、处理可空性、优化API设计等。遵循最佳实践提高互操作性。",
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：最佳实践",
                    code = """
                        // 1. 使用@JvmName优化Java调用
                        // 2. 使用@JvmStatic提供静态方法
                        // 3. 处理可空性
                        // 4. 优化API设计
                        // 5. 注意性能影响
                    """.trimIndent(),
                    explanation = "互操作最佳实践包括使用注解优化、处理可空性、优化API设计等。"
                )
            ),
            useCases = listOf("混合开发：混合开发", "代码质量：提高代码质量", "性能优化：性能优化"),
            keyPoints = listOf("使用注解优化", "处理可空性", "优化API设计", "注意性能影响"),
            notes = listOf("遵循最佳实践", "注意互操作性问题", "合理使用互操作"),
            practiceTips = "建议：遵循互操作最佳实践，使用注解优化，处理可空性，优化API设计。注意性能影响。"
        ),
        
        // ========== Java 性能优化和JVM ==========
        
        // 1. JVM基础（内存模型、垃圾回收）
        KnowledgeDetail(
            id = "java_jvm_basic",
            title = "JVM基础（内存模型、垃圾回收）",
            overview = "JVM是Java运行环境，包括内存模型和垃圾回收机制。理解JVM有助于性能优化和问题排查。",
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：JVM内存模型",
                    code = """
                        // JVM内存区域：
                        // 1. 程序计数器（PC）
                        // 2. 虚拟机栈（Stack）
                        // 3. 本地方法栈（Native Stack）
                        // 4. 堆（Heap）
                        // 5. 方法区（Method Area）
                        
                        // 垃圾回收算法：
                        // 1. 标记-清除
                        // 2. 复制
                        // 3. 标记-整理
                        // 4. 分代收集
                    """.trimIndent(),
                    explanation = "JVM内存包括程序计数器、栈、堆、方法区等。垃圾回收包括标记-清除、复制、标记-整理等算法。"
                )
            ),
            useCases = listOf("性能优化：性能优化", "问题排查：问题排查", "内存管理：内存管理"),
            keyPoints = listOf("理解JVM内存模型", "理解垃圾回收机制", "理解GC算法", "理解GC调优"),
            notes = listOf("理解JVM原理", "注意内存管理", "注意GC调优"),
            practiceTips = "建议：理解JVM内存模型和垃圾回收机制，有助于性能优化和问题排查。注意GC调优。"
        ),
        
        // 2. 性能优化
        KnowledgeDetail(
            id = "java_performance_opt",
            title = "性能优化",
            overview = "性能优化包括代码优化、JVM调优、并发优化等。理解性能优化技巧有助于提高应用性能。",
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：性能优化",
                    code = """
                        // 1. 代码优化
                        // - 避免不必要的对象创建
                        // - 使用StringBuilder代替String拼接
                        // - 合理使用集合
                        
                        // 2. JVM调优
                        // - 调整堆大小
                        // - 选择合适的GC算法
                        // - 监控GC
                        
                        // 3. 并发优化
                        // - 使用线程池
                        // - 避免锁竞争
                        // - 使用并发集合
                    """.trimIndent(),
                    explanation = "性能优化包括代码优化、JVM调优、并发优化等。理解性能优化技巧提高应用性能。"
                )
            ),
            useCases = listOf("性能提升：提升性能", "资源优化：优化资源", "响应优化：优化响应"),
            keyPoints = listOf("代码优化", "JVM调优", "并发优化", "监控和分析"),
            notes = listOf("理解性能优化", "注意性能测试", "注意监控"),
            practiceTips = "建议：理解性能优化技巧，包括代码优化、JVM调优、并发优化。注意性能测试和监控。"
        ),
        
        // 3. 调试和监控
        KnowledgeDetail(
            id = "java_debug_monitor",
            title = "调试和监控",
            overview = "调试和监控包括日志、性能监控、内存分析等。使用工具进行调试和监控有助于问题排查和性能优化。",
            codeExamples = listOf(
                CodeExample(
                    title = "示例1：调试和监控",
                    code = """
                        // 1. 日志
                        // Logger logger = Logger.getLogger("MyClass");
                        // logger.info("Message");
                        
                        // 2. 性能监控
                        // - JProfiler
                        // - VisualVM
                        // - JConsole
                        
                        // 3. 内存分析
                        // - MAT（Memory Analyzer Tool）
                        // - jmap
                        // - jstat
                    """.trimIndent(),
                    explanation = "调试和监控包括日志、性能监控、内存分析等。使用工具进行调试和监控。"
                )
            ),
            useCases = listOf("问题排查：排查问题", "性能分析：分析性能", "内存分析：分析内存"),
            keyPoints = listOf("使用日志", "使用性能监控工具", "使用内存分析工具", "理解工具使用"),
            notes = listOf("理解调试工具", "理解监控工具", "注意工具使用"),
            practiceTips = "建议：使用日志、性能监控、内存分析工具进行调试和监控。理解工具使用有助于问题排查和性能优化。"
        )
    )
}






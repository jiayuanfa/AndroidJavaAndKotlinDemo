// package声明：定义当前文件所属的包
package com.example.androidjavaandkotlindemo.util

// 导入Android的Patterns类：包含常用的正则表达式模式
// Patterns.EMAIL_ADDRESS：邮箱地址的正则表达式模式
import android.util.Patterns

/**
 * StringExtensions文件 - 使用Kotlin编写
 * 
 * 这个文件演示了：
 * 1. Kotlin扩展函数的使用
 * 2. 为Java类（String）添加扩展功能
 * 3. 扩展函数的定义和调用
 * 
 * 扩展函数说明：
 * - Kotlin可以为任何类（包括Java类）添加扩展函数
 * - 扩展函数看起来像类的成员函数，但定义在类外部
 * - 可以为String、List等Java类添加Kotlin特有的功能
 * - 这是Kotlin的强大特性，增强了代码的可读性和简洁性
 */

/**
 * isValidEmail扩展函数：判断字符串是否为有效的邮箱格式
 * 
 * 扩展函数语法说明：
 * - fun String.isValidEmail()：为String类添加isValidEmail()方法
 * - String.：接收者类型，表示这个函数是String的扩展函数
 * - this：在扩展函数内部，this指向接收者对象（调用扩展函数的String实例）
 * 
 * 返回类型Boolean说明：
 * - 返回true表示是有效邮箱，false表示无效
 * 
 * 使用示例：
 * val email = "test@example.com"
 * if (email.isValidEmail()) {
 *     // 邮箱格式正确
 * }
 * 
 * 工作原理：
 * 1. Patterns.EMAIL_ADDRESS：Android提供的邮箱正则表达式
 * 2. matcher(this)：创建匹配器，this是调用扩展函数的String实例
 * 3. matches()：检查是否完全匹配
 * 4. 返回匹配结果（true/false）
 */
fun String.isValidEmail(): Boolean {
    // Patterns.EMAIL_ADDRESS：Android内置的邮箱地址正则表达式
    // .matcher(this)：创建匹配器，this指向调用扩展函数的String对象
    // .matches()：检查整个字符串是否匹配正则表达式
    // 返回true表示是有效邮箱，false表示无效
    return android.util.Patterns.EMAIL_ADDRESS.matcher(this).matches()
}

/**
 * isValidPhone扩展函数：判断字符串是否为有效的手机号（简单验证）
 * 
 * 扩展函数说明：
 * - 为String类添加isValidPhone()方法
 * - 用于验证中国大陆手机号码
 * 
 * 正则表达式说明：
 * - ^：字符串开始
 * - 1：以1开头
 * - [3-9]：第二位是3-9之间的数字
 * - \\d{9}：后面9位数字（\\d表示数字，{9}表示9个）
 * - $：字符串结束
 * - 匹配示例：13812345678（11位，1开头，第二位3-9）
 * 
 * 使用示例：
 * val phone = "13812345678"
 * if (phone.isValidPhone()) {
 *     // 手机号格式正确
 * }
 */
fun String.isValidPhone(): Boolean {
    // this.matches(Regex("..."))：使用正则表达式匹配
    // this：调用扩展函数的String实例
    // Regex("...")：创建正则表达式对象
    // matches()：检查是否匹配
    return this.matches(Regex("^1[3-9]\\d{9}$"))
}

/**
 * capitalizeFirst扩展函数：首字母大写
 * 
 * 功能说明：
 * - 将字符串的第一个字符转为大写，其余字符转为小写
 * - 示例："hello WORLD" -> "Hello world"
 * - 空字符串返回空字符串
 * 
 * 使用示例：
 * val text = "hello world"
 * val capitalized = text.capitalizeFirst()  // "Hello world"
 */
fun String.capitalizeFirst(): String {
    // if (this.isEmpty())：检查字符串是否为空
    // isEmpty()：如果长度为0返回true
    return if (this.isEmpty()) {
        // 如果为空，直接返回（不进行任何转换）
        this
    } else {
        // this[0]：获取第一个字符（索引0）
        // .uppercaseChar()：将字符转为大写
        // +：字符串连接运算符
        // this.substring(1)：获取从索引1开始到结尾的子字符串
        // .lowercase()：将子字符串转为小写
        // 结果：第一个字符大写 + 其余字符小写
        this[0].uppercaseChar() + this.substring(1).lowercase()
    }
}

/**
 * Kotlin扩展函数详解：
 * 
 * 1. 扩展函数的本质：
 *    - 扩展函数是静态函数，编译后会转换为普通函数
 *    - 第一个参数是接收者对象（String实例）
 *    - 例如：fun String.isValidEmail() 编译后变成
 *            fun isValidEmail(receiver: String): Boolean
 * 
 * 2. 调用方式：
 *    // Kotlin中：
 *    val email = "test@example.com"
 *    email.isValidEmail()  // 像成员函数一样调用
 *    
 *    // Java中调用（如果需要）：
 *    StringExtensionsKt.isValidEmail(email)  // 静态函数调用
 * 
 * 3. 扩展函数的优势：
 *    - 增强代码可读性：email.isValidEmail() 比 isValidEmail(email) 更直观
 *    - 不需要修改原有类：可以为任何类（包括第三方库的类）添加功能
 *    - 代码组织：可以将相关功能组织在一起
 * 
 * 4. 扩展函数 vs 成员函数：
 *    - 扩展函数不能访问私有成员
 *    - 扩展函数可以被重载，但不能被重写
 *    - 如果扩展函数和成员函数同名，成员函数优先
 * 
 * 5. 为Java类添加扩展函数：
 *    - 可以为任何Java类添加Kotlin扩展函数
 *    - String、List、Map等Java类都可以扩展
 *    - 这是Kotlin和Java互操作性的强大体现
 */

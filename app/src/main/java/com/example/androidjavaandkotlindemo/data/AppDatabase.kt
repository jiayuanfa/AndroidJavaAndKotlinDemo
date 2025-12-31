// package声明：定义当前文件所属的包
package com.example.androidjavaandkotlindemo.data

// 导入Room框架的Database注解：用于标记Room数据库类
// Database注解告诉Room这是一个数据库定义类
import androidx.room.Database

// 导入Room框架的RoomDatabase抽象类：所有Room数据库类必须继承此类
// RoomDatabase提供了数据库的基础功能，Room会自动生成实现
import androidx.room.RoomDatabase

/**
 * AppDatabase抽象类 - 使用Kotlin编写
 * 
 * 这个类演示了Kotlin操作Java实体类：
 * - User::class 是Kotlin的类引用语法，指向User.java类
 * - Room可以使用Kotlin类引用操作Java类
 * 
 * @Database注解说明：
 * - entities = [User::class]：指定数据库包含的实体类列表
 *   - User::class 是Kotlin类引用，指向User.java类
 *   - 数组语法：[元素1, 元素2, ...]
 *   - 如果有多个实体，用逗号分隔：entities = [User::class, Product::class]
 * - version = 1：数据库版本号
 *   - 当修改实体类结构时，需要增加版本号
 *   - Room会使用Migration来处理版本升级
 * - exportSchema = false：不导出数据库架构JSON文件
 *   - false：开发阶段可以设为false，简化配置
 *   - true：生产环境建议设为true，用于版本迁移
 * 
 * abstract关键字说明：
 * - 抽象类不能直接实例化
 * - Room会在编译时生成实现类
 * - 我们需要提供抽象方法声明，Room会自动实现
 * 
 * 继承RoomDatabase说明：
 * - RoomDatabase是Room提供的抽象基类
 * - 提供了数据库的基础功能（连接、事务等）
 * - 我们只需要声明抽象方法，Room会生成具体实现
 */
@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    
    /**
     * userDao抽象方法：获取UserDao实例
     * 
     * abstract关键字说明：
     * - 抽象方法只有声明，没有实现
     * - Room会在编译时自动生成实现代码
     * - 生成的代码会返回UserDao的实现实例
     * 
     * 返回类型UserDao说明：
     * - UserDao是接口，Room会生成实现类
     * - 返回的是Room生成的UserDaoImpl实例
     * - 这个实例包含了所有@Query、@Insert等方法的具体实现
     * 
     * 使用场景：
     * - 通过database.userDao()获取DAO实例
     * - 然后使用DAO的方法进行数据库操作
     * 
     * 注意：
     * - 数据库实例由Hilt通过DatabaseModule提供（见DatabaseModule.kt）
     * - 不需要手动创建数据库实例
     * - 使用依赖注入获取AppDatabase实例
     */
    abstract fun userDao(): UserDao
}

/**
 * 原理解释：
 * 
 * 1. Room的工作流程：
 *    - 编译时：Room注解处理器读取@Database、@Dao、@Entity注解
 *    - 生成代码：自动生成UserDaoImpl、AppDatabase_Impl等实现类
 *    - 运行时：使用生成的代码执行数据库操作
 * 
 * 2. 数据库初始化（在DatabaseModule.kt中）：
 *    Room.databaseBuilder()
 *        .databaseBuilder(context, AppDatabase::class.java, "app_database")
 *        .build()
 * 
 * 3. 生成的代码位置：
 *    app/build/generated/source/kapt/debug/com/example/.../
 *    - AppDatabase_Impl.java（数据库实现）
 *    - UserDao_Impl.java（DAO实现）
 * 
 * 4. 性能优化：
 *    - Room使用SQLite，性能接近原生SQL
 *    - 编译时验证SQL语法，避免运行时错误
 *    - 支持协程和Flow，便于异步操作
 */

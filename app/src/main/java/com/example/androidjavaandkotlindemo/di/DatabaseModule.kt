// package声明：定义当前文件所属的包
// di表示Dependency Injection（依赖注入）
package com.example.androidjavaandkotlindemo.di

// 导入Android的Context类：应用程序上下文
// Context提供访问应用资源和系统服务的接口
import android.content.Context

// 导入Room的Room类：Room数据库构建器
// Room.databaseBuilder用于创建数据库实例
import androidx.room.Room

// 导入AppDatabase：Room数据库抽象类
import com.example.androidjavaandkotlindemo.data.AppDatabase

// 导入UserDao：Room数据访问对象接口
import com.example.androidjavaandkotlindemo.data.UserDao

// 导入Dagger的Module注解：标记这是一个依赖提供模块
// @Module告诉Hilt/Dagger这个类包含依赖提供方法
import dagger.Module

// 导入Dagger的Provides注解：标记方法为依赖提供者
// @Provides告诉Hilt这个方法提供某个类型的依赖
// Hilt会调用这个方法来创建依赖实例
import dagger.Provides

// 导入Hilt的InstallIn注解：指定模块安装的组件
// 决定这个模块的作用域和生命周期
import dagger.hilt.InstallIn

// 导入ApplicationContext限定符：标记Application级别的Context
// @ApplicationContext用于区分不同作用域的Context
// 例如：Activity Context vs Application Context
import dagger.hilt.android.qualifiers.ApplicationContext

// 导入SingletonComponent：单例组件，应用程序级别
// SingletonComponent表示这些依赖是单例，整个应用共享
import dagger.hilt.components.SingletonComponent

// 导入Singleton注解：标记为单例
// @Singleton表示整个应用程序中只有一个实例
import javax.inject.Singleton

/**
 * DatabaseModule对象 - 使用Kotlin编写
 * 
 * 这个模块演示了：
 * 1. Hilt Module的使用
 * 2. Room数据库的初始化
 * 3. 依赖提供的模式
 * 
 * @Module注解说明：
 * - 标记这是一个Hilt模块
 * - Hilt会扫描这个模块中的@Provides方法
 * - 用于提供无法通过构造函数注入的依赖（如Room数据库）
 * 
 * @InstallIn(SingletonComponent::class)说明：
 * - 指定模块安装在SingletonComponent中
 * - SingletonComponent是应用程序级别的组件
 * - 这些依赖在整个应用生命周期内存在
 * - 所有注入的AppDatabase和UserDao都是单例
 * 
 * object关键字说明：
 * - object是Kotlin的单例对象
 * - 相当于Java的静态类，但更简洁
 * - 不需要实例化，直接通过类名调用方法
 * - Hilt可以直接访问object中的方法
 */
@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    
    /**
     * provideAppDatabase方法：提供AppDatabase实例
     * 
     * @Provides注解说明：
     * - 标记这个方法提供AppDatabase类型的依赖
     * - 当其他地方需要AppDatabase时，Hilt会调用这个方法
     * - 方法名可以任意，重要的是返回类型
     * 
     * @Singleton注解说明：
     * - 标记为单例，整个应用只有一个AppDatabase实例
     * - Hilt会缓存这个实例，后续注入都返回同一个实例
     * - 确保数据库连接的唯一性
     * 
     * @ApplicationContext参数说明：
     * - @ApplicationContext是限定符，标记这是Application Context
     * - Hilt会自动提供Application Context
     * - 使用Application Context避免内存泄漏（不会持有Activity引用）
     * - context.applicationContext：确保获取的是Application Context
     * 
     * 返回类型AppDatabase说明：
     * - 返回Room数据库实例
     * - Room会根据AppDatabase类生成实现代码
     */
    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        // Room.databaseBuilder：Room数据库构建器
        // 用于创建数据库实例的工厂方法
        return Room.databaseBuilder(
            // context.applicationContext：Application级别的Context
            // 使用Application Context避免内存泄漏
            // 如果传入Activity Context，可能会持有Activity引用，导致内存泄漏
            context.applicationContext,
            
            // AppDatabase::class.java：Kotlin类引用转换为Java Class对象
            // Room需要Java Class对象来生成实现代码
            // ::class是Kotlin的类引用，.java转换为Java Class
            AppDatabase::class.java,
            
            // "app_database"：数据库文件名
            // Room会在/data/data/包名/databases/目录下创建这个数据库文件
            // 数据库文件扩展名是.db，完整路径是app_database.db
            "app_database"
        )
        // .fallbackToDestructiveMigration()：降级迁移策略
        // 当数据库版本升级时，如果找不到Migration，则删除旧数据重建
        // 注意：这会丢失所有数据！仅用于开发阶段
        // 生产环境应该使用addMigrations()添加具体的Migration
        .fallbackToDestructiveMigration()
        
        // .build()：构建数据库实例
        // 执行实际的数据库创建/打开操作
        // 返回AppDatabase的实现类实例（Room自动生成）
        .build()
    }
    
    /**
     * provideUserDao方法：提供UserDao实例
     * 
     * @Provides注解说明：
     * - 标记这个方法提供UserDao类型的依赖
     * - 当其他地方需要UserDao时，Hilt会调用这个方法
     * 
     * 参数说明：
     * @param database AppDatabase实例，由Hilt自动注入
     * - Hilt会先调用provideAppDatabase()获取database
     * - 然后调用provideUserDao(database)获取dao
     * - 这是依赖注入的依赖链
     * 
     * 返回类型UserDao说明：
     * - 返回UserDao的实现实例
     * - database.userDao()调用AppDatabase的抽象方法
     * - Room会自动生成userDao()的实现，返回UserDaoImpl实例
     * 
     * 为什么需要这个方法？
     * - 可以直接注入UserDao，而不需要先注入AppDatabase
     * - 简化依赖注入的使用
     * - 符合依赖注入的最佳实践
     */
    @Provides
    fun provideUserDao(database: AppDatabase): UserDao {
        // database.userDao()：调用AppDatabase的抽象方法
        // Room会自动生成这个方法的具体实现
        // 返回UserDaoImpl实例，包含所有@Query、@Insert等方法的实现
        return database.userDao()
    }
}

/**
 * Hilt依赖注入工作流程详解：
 * 
 * 1. 编译时：
 *    - Hilt注解处理器扫描@Module、@Provides注解
 *    - 生成依赖关系图
 *    - 生成依赖提供代码
 * 
 * 2. 运行时 - 第一次请求AppDatabase：
 *    - 某个类需要AppDatabase（如UserRepository需要UserDao，UserDao需要AppDatabase）
 *    - Hilt查找AppDatabase的提供者（找到provideAppDatabase方法）
 *    - 检查参数@ApplicationContext context，Hilt提供Application Context
 *    - 调用Room.databaseBuilder()创建数据库实例
 *    - 缓存实例（因为@Singleton）
 *    - 返回实例
 * 
 * 3. 运行时 - 请求UserDao：
 *    - 某个类需要UserDao（如UserRepository构造函数参数）
 *    - Hilt查找UserDao的提供者（找到provideUserDao方法）
 *    - 检查参数AppDatabase database，Hilt提供之前创建的AppDatabase实例
 *    - 调用database.userDao()获取UserDao实例
 *    - 返回实例
 * 
 * 4. 后续请求：
 *    - 由于@Singleton，Hilt直接返回缓存的实例
 *    - 不会重复创建，确保单例
 * 
 * 依赖关系链：
 * Context -> AppDatabase -> UserDao -> UserRepository -> UserViewModel
 * 
 * Hilt自动管理这个依赖链，确保：
 * - 正确的创建顺序
 * - 单例的正确性
 * - 内存的有效利用
 */

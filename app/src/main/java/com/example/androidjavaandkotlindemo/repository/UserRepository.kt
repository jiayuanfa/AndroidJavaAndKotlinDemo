// package声明：定义当前文件所属的包
package com.example.androidjavaandkotlindemo.repository

// 导入User数据模型类（Java类）：用于Repository操作的数据实体
// 这个类是Java编写的，但可以在Kotlin中无缝使用
import com.example.androidjavaandkotlindemo.data.User

// 导入UserDao接口（Kotlin接口）：Room数据库访问对象
// DAO定义了数据库操作方法，Repository封装DAO提供业务逻辑
import com.example.androidjavaandkotlindemo.data.UserDao

// 导入Kotlin协程的Flow类型：响应式数据流
// Flow是冷流，当数据变化时自动通知观察者
import kotlinx.coroutines.flow.Flow

// 导入Javax Inject的Inject注解：标记构造函数进行依赖注入
// @Inject告诉Hilt/Dagger这个构造函数需要注入依赖
// Hilt会自动创建UserRepository实例，并注入UserDao
import javax.inject.Inject

// 导入Javax Inject的Singleton注解：标记为单例
// @Singleton表示整个应用程序中只有一个UserRepository实例
// 所有使用UserRepository的地方共享同一个实例
import javax.inject.Singleton

/**
 * UserRepository类 - 使用Kotlin编写
 * 
 * 这个类演示了：
 * 1. Kotlin操作Java类（User.java）
 * 2. Hilt依赖注入的使用（构造函数注入）
 * 3. Repository模式：封装数据访问逻辑
 * 4. Flow响应式编程
 * 
 * Repository模式说明：
 * - Repository是数据访问的抽象层
 * - 封装了数据源（数据库、网络）的访问细节
 * - ViewModel只依赖Repository，不直接操作DAO或API
 * - 便于测试和维护
 * 
 * @Singleton注解说明：
 * - 标记为单例，整个应用只有一个实例
 * - Hilt会确保所有注入的UserRepository都是同一个实例
 * - 节省内存，提高性能
 * - 适合Repository这种无状态的类
 */
@Singleton
class UserRepository @Inject constructor(
    /**
     * userDao参数：Room数据库访问对象
     * 
     * @Inject constructor说明：
     * - 这是Hilt的构造函数注入方式
     * - @Inject标记构造函数，Hilt会自动调用这个构造函数
     * - 参数UserDao由Hilt自动提供（通过DatabaseModule）
     * - private val：私有不可变属性，只读
     * 
     * 工作原理：
     * 1. Hilt找到@Inject构造函数
     * 2. 查找UserDao的提供者（DatabaseModule.provideUserDao）
     * 3. 创建UserDao实例
     * 4. 调用UserRepository构造函数，传入UserDao
     * 5. 创建UserRepository实例（单例）
     */
    private val userDao: UserDao
) {
    /**
     * getAllUsers方法：获取所有用户
     * 
     * 返回类型Flow<List<User>>说明：
     * - Flow：Kotlin响应式数据流
     * - List<User>：User对象列表（User是Java类）
     * - 当数据库数据变化时，Flow会自动发出新数据
     * 
     * 工作原理：
     * 1. userDao.getAllUsers()返回Flow<List<User>>
     * 2. Room会自动观察users表的变化
     * 3. 当数据变化时，Flow发出新的列表
     * 4. 观察者（ViewModel）自动收到更新
     * 
     * 使用场景：
     * - ViewModel观察这个Flow，更新UI
     * - 不需要手动刷新，实现真正的响应式编程
     * 
     * 单表达式函数：
     * - = 表示这是单表达式函数
     * - 等价于 { return userDao.getAllUsers() }
     * - Kotlin语法糖，代码更简洁
     */
    fun getAllUsers(): Flow<List<User>> = userDao.getAllUsers()
    
    /**
     * getUserById方法：根据ID获取单个用户
     * 
     * suspend关键字说明：
     * - suspend函数是挂起函数，必须在协程中调用
     * - 数据库查询是IO操作，使用suspend避免阻塞线程
     * - 调用此方法时，当前协程会挂起，等待数据库操作完成
     * 
     * 参数说明：
     * @param id 用户ID，Long类型
     * 
     * 返回类型User?说明：
     * - User?：可空类型，可能返回null
     * - 如果找不到对应的用户，返回null
     * - 调用方需要处理null的情况（使用?.安全调用或if判断）
     * 
     * 单表达式函数：
     * - = 表示单表达式函数
     * - 等价于 { return userDao.getUserById(id) }
     */
    suspend fun getUserById(id: Long): User? = userDao.getUserById(id)
    
    /**
     * insertUser方法：插入用户
     * 
     * suspend关键字说明：
     * - 数据库插入是IO操作，使用suspend避免阻塞
     * - 必须在协程中调用（viewModelScope.launch { ... }）
     * 
     * 参数说明：
     * @param user 要插入的User对象（Java类）
     * 
     * 工作原理：
     * 1. userDao.insertUser(user)执行数据库插入
     * 2. Room会自动生成ID（如果user.id为null）
     * 3. 如果ID已存在，根据DAO的策略处理（REPLACE）
     * 4. 插入完成后，getAllUsers()的Flow会自动发出新数据
     * 
     * Unit返回类型：
     * - Unit相当于Java的void
     * - 表示函数不返回有意义的值
     * - 可以省略，Kotlin默认返回Unit
     */
    suspend fun insertUser(user: User) = userDao.insertUser(user)
    
    /**
     * updateUser方法：更新用户信息
     * 
     * suspend关键字说明：
     * - 数据库更新是IO操作，使用suspend避免阻塞
     * 
     * 参数说明：
     * @param user 要更新的User对象，必须包含有效的主键id
     * 
     * 工作原理：
     * 1. Room根据user.id查找数据库中的记录
     * 2. 将user的其他字段值更新到数据库
     * 3. 更新完成后，getAllUsers()的Flow会自动发出新数据
     */
    suspend fun updateUser(user: User) = userDao.updateUser(user)
    
    /**
     * deleteUser方法：删除用户
     * 
     * suspend关键字说明：
     * - 数据库删除是IO操作，使用suspend避免阻塞
     * 
     * 参数说明：
     * @param user 要删除的User对象，必须包含有效的主键id
     * 
     * 工作原理：
     * 1. Room根据user.id查找数据库中的记录
     * 2. 执行DELETE SQL语句删除该记录
     * 3. 删除完成后，getAllUsers()的Flow会自动发出新数据
     */
    suspend fun deleteUser(user: User) = userDao.deleteUser(user)
    
    /**
     * deleteAllUsers方法：删除所有用户
     * 
     * suspend关键字说明：
     * - 数据库删除是IO操作，使用suspend避免阻塞
     * 
     * 工作原理：
     * 1. Room执行DELETE FROM users SQL语句
     * 2. 删除表中所有记录
     * 3. 删除完成后，getAllUsers()的Flow会自动发出空列表
     */
    suspend fun deleteAllUsers() = userDao.deleteAllUsers()
}

/**
 * Repository模式详解：
 * 
 * 1. 为什么需要Repository？
 *    - 解耦：ViewModel不直接依赖DAO或API
 *    - 统一接口：可以切换数据源（数据库、网络、缓存）
 *    - 业务逻辑：可以在Repository中添加业务规则
 *    - 测试：可以轻松创建Mock Repository
 * 
 * 2. Repository的职责：
 *    - 封装数据访问逻辑
 *    - 提供统一的业务接口
 *    - 处理数据转换（如果需要）
 *    - 缓存策略（如果需要）
 * 
 * 3. 数据流向：
 *    UI -> ViewModel -> Repository -> DAO/API -> Database/Network
 * 
 * 4. Hilt注入流程：
 *    - @Singleton标记为单例
 *    - @Inject constructor进行构造函数注入
 *    - Hilt自动创建实例并注入依赖
 *    - 所有使用UserRepository的地方共享同一个实例
 */

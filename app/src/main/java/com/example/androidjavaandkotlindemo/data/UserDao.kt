// package声明：定义当前文件所属的包
// 包名通常与目录结构对应
package com.example.androidjavaandkotlindemo.data

// 导入Room框架的Dao注解：用于标记接口为数据访问对象（Data Access Object）
// Dao接口定义了数据库操作的方法，Room会自动生成实现代码
import androidx.room.Dao

// 导入Room框架的Query注解：用于标记SQL查询方法
// Query注解中编写SQL语句，Room会将其编译为数据库操作代码
import androidx.room.Query

// 导入Room框架的Insert注解：用于标记插入操作方法
// Insert会自动生成INSERT SQL语句
import androidx.room.Insert

// 导入Room框架的Update注解：用于标记更新操作方法
// Update会自动生成UPDATE SQL语句
import androidx.room.Update

// 导入Room框架的Delete注解：用于标记删除操作方法
// Delete会自动生成DELETE SQL语句
import androidx.room.Delete

// 导入Room框架的OnConflictStrategy枚举：用于处理插入/更新时的冲突策略
// 例如：当插入相同主键的记录时，应该如何处理（替换、忽略、失败等）
import androidx.room.OnConflictStrategy

// 导入Kotlin协程的Flow类型：用于返回响应式数据流
// Flow是Kotlin的冷流（Cold Stream），类似于RxJava的Observable
// 当数据变化时，Flow会自动通知所有观察者
import kotlinx.coroutines.flow.Flow

// 导入suspend关键字所需的基础类型（Kotlin协程）
// suspend函数是挂起函数，可以在协程中暂停和恢复执行

/**
 * UserDao接口 - 使用Kotlin编写
 * 
 * 这个接口演示了Kotlin和Java混编：
 * 1. 接口用Kotlin编写
 * 2. 操作的是User.java（Java类）
 * 3. Room会自动生成这个接口的实现类
 * 
 * @Dao注解说明：
 * - 标记这是一个数据访问对象接口
 * - Room的注解处理器会为这个接口生成实现代码
 * - 生成的代码在编译时创建，性能与手写SQL相当
 * 
 * 接口特性：
 * - Kotlin接口可以包含方法声明
 * - 所有方法都是抽象方法，需要Room自动实现
 * - 可以使用suspend函数进行异步操作
 * - 可以使用Flow返回响应式数据流
 */
@Dao
interface UserDao {
    
    /**
     * getAllUsers方法：获取所有用户
     * 
     * @Query注解说明：
     * - "SELECT * FROM users"：SQL查询语句，从users表查询所有列
     * - SELECT *：选择所有列
     * - FROM users：从users表查询（表名由User类的@Entity注解指定）
     * 
     * 返回类型Flow<List<User>>说明：
     * - Flow：Kotlin响应式数据流，当数据库变化时自动发出新数据
     * - List<User>：User对象列表，User是Java类
     * - 当users表有数据变化时，Flow会自动发出最新的列表
     * 
     * 使用场景：
     * - 在UI层观察这个Flow，当数据变化时自动更新UI
     * - 不需要手动刷新，实现了真正的响应式编程
     */
    @Query("SELECT * FROM users")
    fun getAllUsers(): Flow<List<User>>
    
    /**
     * getUserById方法：根据ID获取单个用户
     * 
     * @Query注解说明：
     * - "SELECT * FROM users WHERE id = :id"：SQL查询语句
     * - WHERE id = :id：条件查询，:id是方法参数id的占位符
     * - Room会将:id替换为实际参数值，防止SQL注入
     * 
     * suspend关键字说明：
     * - suspend函数是挂起函数，必须在协程中调用
     * - 数据库操作是IO操作，使用suspend避免阻塞主线程
     * - 调用此方法时，当前协程会挂起，等待数据库操作完成
     * 
     * 返回类型User?说明：
     * - User?：可空类型，可能返回null（如果找不到对应的用户）
     * - ?表示这个值可能为null
     * - 调用方需要处理null的情况
     * 
     * 参数说明：
     * @param id 用户ID，Long类型
     */
    @Query("SELECT * FROM users WHERE id = :id")
    suspend fun getUserById(id: Long): User?
    
    /**
     * insertUser方法：插入或替换用户
     * 
     * @Insert注解说明：
     * - onConflict = OnConflictStrategy.REPLACE：冲突处理策略
     * - REPLACE：如果已存在相同主键的记录，则替换它
     * - 其他策略：IGNORE（忽略）、ABORT（终止）、FAIL（失败）、ROLLBACK（回滚）
     * - Room会根据实体类的主键自动判断是否冲突
     * 
     * suspend关键字说明：
     * - 数据库插入是IO操作，使用suspend避免阻塞
     * - 必须在协程中调用
     * 
     * 参数说明：
     * @param user 要插入的User对象（Java类）
     * 
     * 工作原理：
     * - Room会将User对象转换为SQL INSERT语句
     * - 如果id为null，数据库会自动生成新ID
     * - 如果id已存在且使用REPLACE策略，会更新该记录
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: User)
    
    /**
     * updateUser方法：更新用户信息
     * 
     * @Update注解说明：
     * - Room会根据主键查找要更新的记录
     * - 只更新非null字段（如果是可空类型）
     * - 如果主键不存在，不会执行任何操作（不会报错）
     * 
     * suspend关键字说明：
     * - 数据库更新是IO操作，使用suspend避免阻塞
     * 
     * 参数说明：
     * @param user 要更新的User对象，必须包含有效的主键id
     * 
     * 工作原理：
     * - Room会根据user.id查找数据库中的记录
     * - 将user的其他字段值更新到数据库中
     * - 如果id不存在，返回受影响行数为0（不会报错）
     */
    @Update
    suspend fun updateUser(user: User)
    
    /**
     * deleteUser方法：删除用户
     * 
     * @Delete注解说明：
     * - Room会根据主键查找要删除的记录
     * - 如果主键不存在，不会执行任何操作（不会报错）
     * 
     * suspend关键字说明：
     * - 数据库删除是IO操作，使用suspend避免阻塞
     * 
     * 参数说明：
     * @param user 要删除的User对象，必须包含有效的主键id
     * 
     * 工作原理：
     * - Room会根据user.id查找数据库中的记录
     * - 执行DELETE SQL语句删除该记录
     * - 如果id不存在，返回受影响行数为0
     */
    @Delete
    suspend fun deleteUser(user: User)
    
    /**
     * deleteAllUsers方法：删除所有用户
     * 
     * @Query注解说明：
     * - "DELETE FROM users"：SQL删除语句
     * - DELETE FROM users：删除users表中的所有记录
     * - 不会删除表结构，只是清空数据
     * 
     * suspend关键字说明：
     * - 数据库删除是IO操作，使用suspend避免阻塞
     * 
     * 工作原理：
     * - Room会执行DELETE FROM users SQL语句
     * - 删除表中所有记录，但保留表结构
     * - 返回受影响的行数（即删除的记录数）
     */
    @Query("DELETE FROM users")
    suspend fun deleteAllUsers()
}

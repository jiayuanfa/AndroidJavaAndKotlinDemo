// package声明：定义当前文件所属的包
package com.example.androidjavaandkotlindemo.viewmodel

// 导入AndroidX Lifecycle的ViewModel类：用于存储和管理UI相关的数据
// ViewModel在配置变更（如屏幕旋转）时不会被销毁，保持数据状态
// 这是MVVM架构中的ViewModel层
import androidx.lifecycle.ViewModel

// 导入viewModelScope：ViewModel的生命周期感知协程作用域
// viewModelScope是一个CoroutineScope，当ViewModel被清除时自动取消所有协程
// 避免内存泄漏和崩溃
import androidx.lifecycle.viewModelScope

// 导入User数据模型类（Java类）：ViewModel操作的数据实体
import com.example.androidjavaandkotlindemo.data.User

// 导入UserRepository：数据仓库，封装数据访问逻辑
import com.example.androidjavaandkotlindemo.repository.UserRepository

// 导入Hilt的HiltViewModel注解：标记ViewModel启用Hilt依赖注入
// HiltViewModel告诉Hilt这个ViewModel需要依赖注入
// Hilt会自动为ViewModel创建工厂，并注入所需的依赖
import dagger.hilt.android.lifecycle.HiltViewModel

// 导入MutableStateFlow：可变的状态流，用于存储和管理状态
// MutableStateFlow是StateFlow的可变版本，可以修改值
// StateFlow是热流，会保存当前值，新的观察者会立即收到当前值
import kotlinx.coroutines.flow.MutableStateFlow

// 导入StateFlow：不可变的状态流，用于暴露状态给外部
// StateFlow是响应式编程的基础，UI可以观察StateFlow的变化
import kotlinx.coroutines.flow.StateFlow

// 导入asStateFlow扩展函数：将MutableStateFlow转换为StateFlow
// 隐藏可变接口，只暴露只读接口，防止外部修改状态
import kotlinx.coroutines.flow.asStateFlow

// 导入launch函数：启动协程的函数
// launch是协程构建器，用于启动一个新的协程
// viewModelScope.launch会在ViewModel作用域内启动协程
import kotlinx.coroutines.launch

// 导入Javax Inject的Inject注解：标记构造函数进行依赖注入
import javax.inject.Inject

/**
 * UserViewModel类 - 使用Kotlin编写
 * 
 * 这个类演示了：
 * 1. ViewModel + StateFlow的状态管理
 * 2. Hilt依赖注入在ViewModel中的使用
 * 3. Kotlin协程的异步操作
 * 4. Kotlin操作Java类（User.java）
 * 
 * ViewModel的作用：
 * - 存储UI相关的数据
 * - 在配置变更时保持数据（不会重新创建）
 * - 提供业务逻辑方法给UI调用
 * - 使用StateFlow暴露状态给UI观察
 * 
 * @HiltViewModel注解说明：
 * - 必须在ViewModel类上使用
 * - Hilt会为这个ViewModel创建工厂
 * - 可以在Activity/Fragment中使用hiltViewModel()获取实例
 * - 自动注入构造函数参数
 */
@HiltViewModel
class UserViewModel @Inject constructor(
    /**
     * userRepository参数：数据仓库，通过构造函数注入
     * 
     * @Inject constructor说明：
     * - Hilt会自动调用这个构造函数
     * - userRepository由Hilt自动提供（通过@Singleton UserRepository）
     * - private val：私有不可变属性
     */
    private val userRepository: UserRepository
) : ViewModel() {  // 继承ViewModel，获得生命周期感知能力
    
    /**
     * _users属性：私有的可变状态流，存储用户列表
     * 
     * private val说明：
     * - private：私有，只能在类内部访问
     * - val：不可变引用，但MutableStateFlow的内容可变
     * 
     * MutableStateFlow说明：
     * - 类型参数：List<User>，User是Java类
     * - 初始值：emptyList()，空列表
     * - 可以修改.value来更新状态
     * 
     * 命名约定：
     * - 下划线前缀_表示私有可变属性
     * - 公开的只读属性使用users（不带下划线）
     */
    private val _users = MutableStateFlow<List<User>>(emptyList())
    
    /**
     * users属性：公开的只读状态流，供UI观察
     * 
     * val说明：
     * - 不可变引用，但StateFlow的值可以变化
     * 
     * asStateFlow()说明：
     * - 将MutableStateFlow转换为StateFlow
     * - 隐藏可变接口，只暴露只读接口
     * - UI只能观察，不能修改
     * 
     * StateFlow特性：
     * - 是热流，保存当前值
     * - 新的观察者会立即收到当前值
     * - 值变化时自动通知所有观察者
     * 
     * 使用场景：
     * - UI使用collectAsState()观察这个Flow
     * - 当_users.value变化时，users会自动通知观察者
     */
    val users: StateFlow<List<User>> = _users.asStateFlow()
    
    /**
     * _isLoading属性：私有的可变状态流，存储加载状态
     * 
     * 作用：
     * - 标识数据加载状态（true=加载中，false=加载完成）
     * - UI可以根据这个状态显示/隐藏加载指示器
     * 
     * MutableStateFlow<Boolean>说明：
     * - Boolean类型：true或false
     * - 初始值：false（未加载）
     */
    private val _isLoading = MutableStateFlow(false)
    
    /**
     * isLoading属性：公开的只读状态流，供UI观察加载状态
     */
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()
    
    /**
     * init代码块：类初始化时执行
     * 
     * 执行时机：
     * - 对象创建时，构造函数执行后
     * - 只执行一次
     * 
     * 作用：
     * - 初始化数据，加载用户列表
     * - 确保ViewModel创建后立即开始观察数据
     */
    init {
        loadUsers()  // 调用加载用户方法
    }
    
    /**
     * loadUsers方法：加载用户列表
     * 
     * private fun说明：
     * - private：私有方法，只能在类内部调用
     * - fun：函数声明关键字
     * 
     * 工作原理：
     * 1. viewModelScope.launch：在ViewModel作用域启动协程
     * 2. userRepository.getAllUsers()：获取Flow<List<User>>
     * 3. .collect { ... }：收集Flow的值，当数据变化时执行lambda
     * 4. _users.value = userList：更新状态
     * 
     * Flow.collect说明：
     * - collect是挂起函数，会挂起协程
     * - 当Flow发出新值时，lambda会被调用
     * - 这个过程会一直持续，直到Flow完成或协程被取消
     * - Room的Flow会在数据库变化时自动发出新数据
     */
    private fun loadUsers() {
        // viewModelScope.launch：在ViewModel作用域启动协程
        // 当ViewModel被清除时，这个协程会自动取消
        viewModelScope.launch {
            // userRepository.getAllUsers()：返回Flow<List<User>>
            // collect：收集Flow的值，这是一个挂起函数
            userRepository.getAllUsers().collect { userList ->
                // 当数据库数据变化时，这里的lambda会被调用
                // userList：最新的用户列表
                // _users.value = userList：更新状态流的值
                // 当_users.value变化时，users StateFlow会自动通知所有观察者
                _users.value = userList
            }
        }
    }
    
    /**
     * addUser方法：添加用户
     * 
     * 参数说明：
     * @param name 用户姓名，String类型
     * @param email 用户邮箱，String类型
     * @param age 用户年龄，Int类型
     * 
     * 方法作用：
     * - 创建User对象（Java类）
     * - 调用Repository插入数据库
     * - 更新加载状态
     * 
     * 错误处理：
     * - try-catch-finally：捕获异常，确保finally中的代码执行
     * - finally：无论成功或失败，都会设置_isLoading = false
     */
    fun addUser(name: String, email: String, age: Int) {
        // viewModelScope.launch：启动协程
        viewModelScope.launch {
            // 设置加载状态为true，UI可以显示加载指示器
            _isLoading.value = true
            
            try {
                // User(name, email, age)：创建User对象（Java类）
                // 调用User.java的带参数构造函数（@Ignore标记的）
                val user = User(name, email, age)
                
                // userRepository.insertUser(user)：插入数据库
                // suspend函数，会挂起协程，等待数据库操作完成
                userRepository.insertUser(user)
                
                // 插入成功后，Room的Flow会自动发出新数据
                // loadUsers()中的collect lambda会被调用
                // _users.value会被更新，UI自动刷新
            } catch (e: Exception) {
                // 捕获异常，处理错误
                // 实际项目中可以记录日志、显示错误提示等
                // 处理错误
            } finally {
                // finally块：无论成功或失败都会执行
                // 设置加载状态为false，隐藏加载指示器
                _isLoading.value = false
            }
        }
    }
    
    /**
     * deleteUser方法：删除用户
     * 
     * 参数说明：
     * @param user 要删除的User对象（Java类）
     * 
     * 工作原理：
     * 1. 调用Repository删除数据库记录
     * 2. Room的Flow自动发出新数据（不包含被删除的用户）
     * 3. loadUsers()中的collect lambda被调用
     * 4. _users.value被更新，UI自动刷新
     */
    fun deleteUser(user: User) {
        // viewModelScope.launch：启动协程
        viewModelScope.launch {
            // userRepository.deleteUser(user)：删除数据库记录
            // suspend函数，会挂起协程，等待数据库操作完成
            userRepository.deleteUser(user)
            
            // 删除成功后，Room的Flow会自动发出新数据
            // UI会自动更新，被删除的用户从列表中消失
        }
    }
    
    /**
     * updateUser方法：更新用户信息
     * 
     * 参数说明：
     * @param user 要更新的User对象（Java类），必须包含有效的主键id
     * 
     * 工作原理：
     * 1. 调用Repository更新数据库记录
     * 2. Room的Flow自动发出新数据（包含更新后的用户）
     * 3. loadUsers()中的collect lambda被调用
     * 4. _users.value被更新，UI自动刷新
     */
    fun updateUser(user: User) {
        // viewModelScope.launch：启动协程
        viewModelScope.launch {
            // userRepository.updateUser(user)：更新数据库记录
            // suspend函数，会挂起协程，等待数据库操作完成
            userRepository.updateUser(user)
            
            // 更新成功后，Room的Flow会自动发出新数据
            // UI会自动更新，显示更新后的用户信息
        }
    }
}

/**
 * ViewModel生命周期详解：
 * 
 * 1. 创建：
 *    - Activity/Fragment调用hiltViewModel()获取实例
 *    - Hilt创建ViewModel实例，注入依赖
 *    - init代码块执行，loadUsers()被调用
 * 
 * 2. 运行：
 *    - loadUsers()启动协程，观察Flow
 *    - UI观察users和isLoading StateFlow
 *    - 当用户调用addUser/deleteUser/updateUser时，更新数据库
 *    - 数据库变化触发Flow，_users.value更新，UI自动刷新
 * 
 * 3. 配置变更（如屏幕旋转）：
 *    - Activity被销毁并重建
 *    - ViewModel不会被销毁，保持状态
 *    - UI重新观察StateFlow，立即收到当前值
 * 
 * 4. 销毁：
 *    - Activity被finish()或进程被杀死
 *    - ViewModel.onCleared()被调用
 *    - viewModelScope被取消，所有协程被取消
 *    - 避免内存泄漏
 * 
 * StateFlow vs LiveData：
 * 
 * 1. StateFlow：
 *    - Kotlin协程生态
 *    - 类型安全，编译时检查
 *    - 支持复杂的流操作（map、filter等）
 *    - 需要协程支持
 * 
 * 2. LiveData：
 *    - Android生命周期感知
 *    - 自动处理生命周期
 *    - 更简单，但功能有限
 *    - 推荐使用StateFlow（现代项目）
 */

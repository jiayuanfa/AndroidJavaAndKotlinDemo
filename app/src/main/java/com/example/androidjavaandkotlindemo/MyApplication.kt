// package声明：定义当前文件所属的包
package com.example.androidjavaandkotlindemo

// 导入Android的Application类：应用程序的基类
// Application类代表整个应用程序的生命周期
// 应用程序启动时创建，进程结束时销毁
import android.app.Application

// 导入Hilt框架的HiltAndroidApp注解：标记Application类启用Hilt
// HiltAndroidApp告诉Hilt这是一个Hilt应用程序的入口点
// Hilt会为这个Application类生成代码，设置依赖注入容器
import dagger.hilt.android.HiltAndroidApp

/**
 * MyApplication类 - 使用Kotlin编写
 * 
 * 这个类演示了Hilt依赖注入的使用：
 * - @HiltAndroidApp注解启用Hilt
 * - 继承Application类，作为应用程序的入口点
 * 
 * @HiltAndroidApp注解说明：
 * - 必须在Application类上使用，且只能有一个
 * - Hilt会为这个类生成Hilt_MyApplication子类
 * - 生成的类会初始化Hilt的依赖注入容器
 * - 应用程序启动时，Hilt会创建全局的依赖注入容器
 * 
 * 继承Application说明：
 * - Application是Android应用的基类
 * - 代表整个应用程序的生命周期
 * - 在AndroidManifest.xml中注册（android:name=".MyApplication"）
 * - onCreate()方法在应用程序启动时调用
 * 
 * 使用场景：
 * - 初始化全局资源（数据库、网络库等）
 * - 设置全局配置
 * - Hilt依赖注入的入口点
 * 
 * 工作原理：
 * 1. 编译时：Hilt生成Hilt_MyApplication类
 * 2. 运行时：系统创建Hilt_MyApplication实例
 * 3. Hilt初始化：创建ApplicationComponent依赖注入容器
 * 4. onCreate调用：执行初始化逻辑
 */
@HiltAndroidApp
class MyApplication : Application() {
    
    /**
     * onCreate方法：应用程序启动时调用
     * 
     * override关键字说明：
     * - 重写父类Application的onCreate方法
     * - 必须调用super.onCreate()，确保父类初始化完成
     * 
     * 调用时机：
     * - 应用程序进程启动时
     * - 在任何Activity、Service等组件创建之前
     * - 只调用一次（应用程序生命周期内）
     * 
     * 在这里可以：
     * - 初始化第三方库
     * - 设置全局配置
     * - 创建全局对象
     * 
     * 注意：
     * - 避免在这里执行耗时操作（会阻塞应用启动）
     * - 数据库、网络等初始化由Hilt管理，不需要手动初始化
     */
    override fun onCreate() {
        // super.onCreate()：调用父类Application的onCreate方法
        // 这是必须的，确保父类完成必要的初始化
        // 如果忘记调用，可能会导致运行时错误
        super.onCreate()
        
        // 应用初始化逻辑
        // 示例：可以在这里初始化日志库、崩溃报告等
        // 注意：使用Hilt的项目中，大部分初始化由依赖注入管理
        // 例如：数据库、网络客户端等通过@Provides方法提供
    }
}

/**
 * Hilt工作原理详解：
 * 
 * 1. 编译时处理：
 *    - @HiltAndroidApp注解触发Hilt注解处理器
 *    - 生成Hilt_MyApplication.java文件
 *    - 生成ApplicationComponent接口和实现
 * 
 * 2. 生成的代码结构：
 *    Hilt_MyApplication extends MyApplication {
 *        @Override
 *        void onCreate() {
 *            super.onCreate();
 *            // Hilt初始化代码
 *            initializeComponent();
 *        }
 *    }
 * 
 * 3. 依赖注入容器：
 *    - ApplicationComponent：应用程序级别的组件
 *    - SingletonComponent：单例组件，由ApplicationComponent提供
 *    - ActivityComponent、FragmentComponent等：其他组件
 * 
 * 4. 在AndroidManifest.xml中注册：
 *    <application android:name=".MyApplication" ...>
 * 
 * 5. 使用依赖注入：
 *    - @Inject：字段注入、构造函数注入
 *    - @Provides：提供依赖（在Module中）
 *    - @HiltViewModel：ViewModel注入
 *    - @AndroidEntryPoint：Activity、Fragment等注入
 */

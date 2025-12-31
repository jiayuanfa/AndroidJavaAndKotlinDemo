// package声明：定义当前文件所属的包
package com.example.androidjavaandkotlindemo

// 导入Android的Bundle类：用于在Activity之间传递数据
// Bundle是一个键值对集合，可以存储基本类型和Parcelable对象
import android.os.Bundle

// 导入Jetpack Compose Activity的ComponentActivity类：支持Compose的Activity基类
// ComponentActivity是AppCompatActivity的替代，专门为Compose设计
// 提供了setContent扩展函数来设置Compose UI
import androidx.activity.ComponentActivity

// 导入setContent扩展函数：用于将Compose内容设置为Activity的UI
// setContent是ComponentActivity的扩展函数，参数是一个@Composable lambda
import androidx.activity.compose.setContent

// 导入enableEdgeToEdge函数：启用Edge-to-Edge显示模式
// Edge-to-Edge是现代Android UI设计，内容延伸到系统栏（状态栏、导航栏）下方
// 让应用看起来更加沉浸式
import androidx.activity.enableEdgeToEdge

// 导入Compose的Modifier类：用于修改Composable的行为和外观
// Modifier是不可变的，可以通过链式调用组合多个修饰符
import androidx.compose.foundation.layout.fillMaxSize

// 导入Material 3的MaterialTheme：Material Design主题系统
// MaterialTheme提供了颜色、字体、形状等主题配置
import androidx.compose.material3.MaterialTheme

// 导入Material 3的Surface组件：Material Design的表面容器
// Surface提供了一个有背景色、阴影的容器，是Material Design的基础组件
import androidx.compose.material3.Surface

// 导入Compose的Modifier：用于修改组件
import androidx.compose.ui.Modifier

// 导入应用的主题配置：自定义的主题，定义了颜色、字体等
import com.example.androidjavaandkotlindemo.ui.theme.AndroidJavaAndKotlinDemoTheme

// 导入导航组件：应用的主要导航逻辑
import com.example.androidjavaandkotlindemo.navigation.AppNavigation

// 导入Hilt的AndroidEntryPoint注解：标记Activity启用Hilt依赖注入
// AndroidEntryPoint告诉Hilt这个Activity需要依赖注入
// Hilt会为这个Activity生成代码，注入所需的依赖
import dagger.hilt.android.AndroidEntryPoint

/**
 * MainActivity类 - 使用Kotlin编写
 * 
 * 这个类演示了：
 * 1. Hilt依赖注入在Activity中的使用
 * 2. Jetpack Compose UI的设置
 * 3. Edge-to-Edge现代UI设计
 * 4. Material 3主题系统
 * 
 * @AndroidEntryPoint注解说明：
 * - 必须在需要依赖注入的Activity上使用
 * - Hilt会为这个类生成Hilt_MainActivity子类
 * - 可以在Activity中直接使用@Inject注入依赖
 * - 可以在Activity中获取ViewModel（通过hiltViewModel()）
 * 
 * 继承ComponentActivity说明：
 * - ComponentActivity是支持Compose的Activity基类
 * - 提供了setContent()方法来设置Compose UI
 * - 替代了传统的setContentView()方法
 * - 这是Compose应用的推荐基类
 */
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    
    /**
     * onCreate方法：Activity创建时调用
     * 
     * override关键字说明：
     * - 重写父类ComponentActivity的onCreate方法
     * - 必须调用super.onCreate()，确保父类初始化完成
     * 
     * savedInstanceState参数说明：
     * - Bundle类型，保存了Activity之前的状态
     * - 如果Activity被系统杀死后重建，savedInstanceState不为null
     * - 可以用于恢复之前保存的数据
     * - 第一次创建时为null
     * 
     * 调用时机：
     * - Activity首次创建时
     * - Activity被系统杀死后重建时
     * - 在onStart()之前调用
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        // super.onCreate(savedInstanceState)：调用父类的onCreate方法
        // 这是必须的，确保Activity的基础初始化完成
        // 如果不调用，会导致运行时崩溃
        super.onCreate(savedInstanceState)
        
        // enableEdgeToEdge()：启用Edge-to-Edge显示模式
        // 作用：
        // - 让内容延伸到状态栏和导航栏下方
        // - 创建更加沉浸式的用户体验
        // - 是现代Android UI设计的最佳实践
        // 原理：
        // - 设置WindowCompat.setDecorFitsSystemWindows(window, false)
        // - 调整WindowInsets，让内容可以绘制到系统栏区域
        enableEdgeToEdge()
        
        // setContent：设置Activity的UI内容为Compose
        // 参数是一个@Composable lambda表达式
        // 这个lambda中的内容就是Activity的UI
        setContent {
            // AndroidJavaAndKotlinDemoTheme：应用的自定义主题
            // 作用：提供Material 3主题配置（颜色、字体、形状等）
            // 所有子组件都会继承这个主题
            // 这是一个Composable函数，参数是内容
            AndroidJavaAndKotlinDemoTheme {
                // Surface：Material Design的表面容器组件
                // 作用：
                // - 提供背景色（使用主题的背景色）
                // - 提供阴影效果（Elevation）
                // - 是Material Design的基础容器
                // 
                // modifier参数说明：
                // - Modifier.fillMaxSize()：填充整个可用空间
                // - fillMaxSize()：宽度和高度都填充父容器
                // - 相当于match_parent（XML中的）
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    // color参数：Surface的背景色
                    // MaterialTheme.colorScheme.background：使用主题的背景色
                    // MaterialTheme是Material 3的主题系统
                    // colorScheme.background是当前主题定义的背景色
                    color = MaterialTheme.colorScheme.background
                ) {
                    // AppNavigation()：应用的主要导航组件
                    // 这是一个Composable函数，定义了应用的导航结构
                    // 内部包含NavHost和所有的路由配置
                    // 这是应用的根UI组件，所有页面都在这里导航
                    AppNavigation()
                }
            }
        }
    }
}

/**
 * 代码执行流程详解：
 * 
 * 1. Activity启动：
 *    - 系统创建MainActivity实例
 *    - Hilt注入依赖（如果使用了@Inject）
 * 
 * 2. onCreate调用：
 *    - super.onCreate()：父类初始化
 *    - enableEdgeToEdge()：启用Edge-to-Edge
 *    - setContent { ... }：设置Compose UI
 * 
 * 3. Compose渲染：
 *    - AndroidJavaAndKotlinDemoTheme：应用主题
 *    - Surface：主容器
 *    - AppNavigation()：导航系统
 * 
 * 4. 导航初始化：
 *    - AppNavigation内部创建NavHost
 *    - 设置起始路由（startDestination = "home"）
 *    - 显示HomeScreen
 * 
 * Hilt依赖注入原理：
 * 
 * 1. 编译时：
 *    - @AndroidEntryPoint触发Hilt注解处理器
 *    - 生成Hilt_MainActivity.java
 * 
 * 2. 运行时：
 *    - 系统创建Hilt_MainActivity实例
 *    - Hilt注入所需的依赖
 *    - 调用onCreate方法
 * 
 * 3. 使用依赖：
 *    - 在Activity中可以使用@Inject注入字段
 *    - 可以使用hiltViewModel()获取ViewModel
 *    - 所有依赖由Hilt自动管理
 */

// package声明：定义当前文件所属的包
package com.example.androidjavaandkotlindemo.di

// 导入ApiService：网络API接口
import com.example.androidjavaandkotlindemo.data.api.ApiService

// 导入Dagger和Hilt相关注解
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

// 导入OkHttp相关类：HTTP客户端
import okhttp3.OkHttpClient

// 导入HttpLoggingInterceptor：HTTP日志拦截器
// 用于在开发时打印HTTP请求和响应的详细信息
import okhttp3.logging.HttpLoggingInterceptor

// 导入Retrofit相关类：REST API客户端
import retrofit2.Retrofit

// 导入GsonConverterFactory：Gson转换器工厂
// 用于将JSON响应自动转换为Kotlin对象
import retrofit2.converter.gson.GsonConverterFactory

// 导入Singleton注解
import javax.inject.Singleton

/**
 * NetworkModule对象 - 使用Kotlin编写
 * 
 * 这个模块演示了：
 * 1. Retrofit和OkHttp的配置
 * 2. 网络依赖的提供
 * 3. 单例模式在网络库中的使用
 * 
 * @Module和@InstallIn说明：
 * - 与DatabaseModule类似
 * - 提供网络相关的依赖
 */
@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    
    /**
     * BASE_URL常量：API的基础URL
     * 
     * private const val说明：
     * - private：私有，只能在模块内部访问
     * - const val：编译时常量，必须是基本类型或String
     * - 编译时确定值，性能更好
     * 
     * 注意：实际项目中应该从配置文件中读取
     */
    private const val BASE_URL = "https://api.github.com/"
    
    /**
     * provideOkHttpClient方法：提供OkHttpClient实例
     * 
     * @Provides和@Singleton说明：
     * - 提供OkHttpClient单例
     * - 整个应用共享同一个OkHttpClient实例
     * - 复用连接池，提高性能
     * 
     * OkHttpClient作用：
     * - HTTP客户端，用于发送HTTP请求
     * - 提供连接池、缓存、拦截器等功能
     * - Retrofit底层使用OkHttp
     */
    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        // HttpLoggingInterceptor：HTTP日志拦截器
        // 用于在开发时打印HTTP请求和响应的详细信息
        // 方便调试网络请求
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            // apply作用域函数：在对象上执行多个操作
            // this指向loggingInterceptor对象
            
            // level = HttpLoggingInterceptor.Level.BODY：设置日志级别
            // BODY：打印请求和响应的完整内容（包括body）
            // 其他级别：NONE（不打印）、BASIC（基本信息）、HEADERS（包含headers）
            level = HttpLoggingInterceptor.Level.BODY
        }
        
        // OkHttpClient.Builder()：构建OkHttpClient
        // Builder模式，链式调用配置客户端
        return OkHttpClient.Builder()
            // .addInterceptor(loggingInterceptor)：添加拦截器
            // 拦截器可以修改请求、记录日志、重试等
            // addInterceptor：添加到拦截器链，会拦截所有请求
            .addInterceptor(loggingInterceptor)
            
            // .build()：构建OkHttpClient实例
            // 返回配置好的客户端
            .build()
    }
    
    /**
     * provideRetrofit方法：提供Retrofit实例
     * 
     * 参数说明：
     * @param okHttpClient OkHttpClient实例，由Hilt自动注入
     * - Hilt会先调用provideOkHttpClient()获取客户端
     * - 然后调用provideRetrofit(okHttpClient)
     * 
     * Retrofit作用：
     * - REST API客户端，将HTTP API转换为Kotlin接口
     * - 自动处理请求序列化和响应反序列化
     * - 支持协程、RxJava、Call等
     */
    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        // Retrofit.Builder()：构建Retrofit
        return Retrofit.Builder()
            // .baseUrl(BASE_URL)：设置基础URL
            // 所有API接口的URL会基于这个URL
            // 例如：baseUrl = "https://api.github.com/"
            //      接口路径 = "users/octocat"
            //      最终URL = "https://api.github.com/users/octocat"
            .baseUrl(BASE_URL)
            
            // .client(okHttpClient)：设置OkHttp客户端
            // Retrofit使用这个客户端发送HTTP请求
            // 可以自定义拦截器、超时时间等
            .client(okHttpClient)
            
            // .addConverterFactory(GsonConverterFactory.create())：添加转换器
            // GsonConverterFactory：将JSON响应转换为Kotlin对象
            // create()：创建Gson转换器工厂实例
            // 如果没有转换器，Retrofit只能返回ResponseBody
            .addConverterFactory(GsonConverterFactory.create())
            
            // .build()：构建Retrofit实例
            .build()
    }
    
    /**
     * provideApiService方法：提供ApiService实例
     * 
     * 参数说明：
     * @param retrofit Retrofit实例，由Hilt自动注入
     * 
     * Retrofit.create说明：
     * - 动态代理创建接口实现
     * - 将接口方法转换为HTTP请求
     * - 返回接口的实现类实例
     */
    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService {
        // retrofit.create(ApiService::class.java)：创建接口实现
        // ApiService::class.java：Kotlin类引用转换为Java Class
        // create()：使用动态代理创建ApiService的实现
        // 返回的实例会在调用方法时发送HTTP请求
        return retrofit.create(ApiService::class.java)
    }
}

/**
 * Retrofit工作原理详解：
 * 
 * 1. 接口定义（ApiService.kt）：
 *    @GET("users/{username}")
 *    suspend fun getUser(@Path("username") username: String): GitHubUser
 * 
 * 2. Retrofit.create()创建实现：
 *    - 使用动态代理（Proxy.newProxyInstance）
 *    - 当调用getUser()时，触发InvocationHandler
 *    - Retrofit解析注解（@GET、@Path等）
 *    - 构建HTTP请求
 * 
 * 3. 发送请求：
 *    - 使用OkHttpClient发送HTTP请求
 *    - 拦截器处理请求（日志、认证等）
 *    - 发送到服务器
 * 
 * 4. 处理响应：
 *    - 接收HTTP响应
 *    - GsonConverterFactory将JSON转换为GitHubUser对象
 *    - 返回给调用者
 * 
 * 使用示例：
 * val apiService = hiltViewModel().apiService  // 通过依赖注入获取
 * val user = apiService.getUser("octocat")     // 调用接口方法
 * // Retrofit自动发送GET请求到 https://api.github.com/users/octocat
 * // 将JSON响应转换为GitHubUser对象
 */

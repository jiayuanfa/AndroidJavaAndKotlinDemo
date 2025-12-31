// package声明：定义当前文件所属的包
package com.example.androidjavaandkotlindemo.util;

// 导入SimpleDateFormat类：日期格式化类
// 用于将Date对象格式化为字符串，或将字符串解析为Date
import java.text.SimpleDateFormat;

// 导入Date类：表示日期和时间
// Date是Java中表示时间点的类（已过时，但这里作为示例）
import java.util.Date;

// 导入Locale类：表示地区/语言环境
// 用于指定日期格式化的语言和地区（如：中文、英文等）
import java.util.Locale;

/**
 * DateUtils工具类 - 使用Java编写
 * 
 * 这个类演示了：
 * 1. Java静态工具类的编写
 * 2. Kotlin调用Java静态方法
 * 3. 工具类的设计模式
 * 
 * public class说明：
 * - public：公开类，可以被其他包访问
 * - 工具类通常设计为final，防止继承（这里省略）
 * 
 * 工具类设计：
 * - 所有方法都是static静态方法
 * - 不需要实例化，直接通过类名调用
 * - 提供通用的工具函数
 */
public class DateUtils {
    
    /**
     * DEFAULT_FORMAT常量：默认日期时间格式
     * 
     * private static final说明：
     * - private：私有，只能在类内部访问
     * - static：静态，属于类而不是实例
     * - final：常量，不可修改
     * 
     * 格式说明：
     * - yyyy：4位年份
     * - MM：2位月份（01-12）
     * - dd：2位日期（01-31）
     * - HH：2位小时（00-23，24小时制）
     * - mm：2位分钟（00-59）
     * - ss：2位秒数（00-59）
     * 示例输出：2024-12-25 14:30:45
     */
    private static final String DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss";
    
    /**
     * formatCurrentTime方法：格式化当前时间
     * 
     * public static说明：
     * - public：公开方法，可以被其他类访问
     * - static：静态方法，通过类名调用（DateUtils.formatCurrentTime()）
     * - 不需要创建DateUtils实例
     * 
     * 返回类型String说明：
     * - 返回格式化后的日期时间字符串
     * 
     * 工作原理：
     * 1. 创建当前时间的Date对象
     * 2. 调用formatTime(Date)方法格式化
     * 3. 返回格式化后的字符串
     * 
     * Kotlin调用方式：
     * val time = DateUtils.formatCurrentTime()
     */
    public static String formatCurrentTime() {
        // new Date()：创建表示当前时间的Date对象
        // Date()无参构造函数会获取当前系统时间
        // 调用formatTime方法，传入当前时间的Date对象
        return formatTime(new Date());
    }
    
    /**
     * formatTime方法：格式化指定时间（使用默认格式）
     * 
     * 参数说明：
     * @param date 要格式化的Date对象
     * 
     * 方法重载说明：
     * - 这是formatTime方法的重载版本
     * - 使用默认格式DEFAULT_FORMAT
     * - 另一个重载版本可以指定自定义格式
     */
    public static String formatTime(Date date) {
        // new SimpleDateFormat(...)：创建日期格式化器
        // DEFAULT_FORMAT：使用默认格式字符串
        // Locale.getDefault()：使用系统默认的语言环境
        //   - 例如：中文环境使用中文日期格式
        //   - 英文环境使用英文日期格式
        SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_FORMAT, Locale.getDefault());
        
        // sdf.format(date)：将Date对象格式化为字符串
        // format()方法根据格式字符串将Date转换为String
        // 例如：Date -> "2024-12-25 14:30:45"
        return sdf.format(date);
    }
    
    /**
     * formatTime方法：格式化指定时间（自定义格式）
     * 
     * 方法重载说明：
     * - 与上面的formatTime(Date)方法同名，但参数不同
     * - Java通过参数列表区分重载方法（参数类型或数量不同）
     * - 调用时会根据参数自动选择合适的方法
     * 
     * 参数说明：
     * @param date 要格式化的Date对象
     * @param pattern 自定义格式字符串
     *   - 例如："yyyy年MM月dd日" -> "2024年12月25日"
     *   - 例如："HH:mm:ss" -> "14:30:45"
     *   - 例如："yyyy-MM-dd" -> "2024-12-25"
     */
    public static String formatTime(Date date, String pattern) {
        // new SimpleDateFormat(pattern, Locale.getDefault())：
        // 使用自定义格式创建日期格式化器
        SimpleDateFormat sdf = new SimpleDateFormat(pattern, Locale.getDefault());
        
        // 格式化Date对象为字符串
        return sdf.format(date);
    }
}

/**
 * Kotlin调用Java静态方法说明：
 * 
 * 1. 直接调用：
 *    val time = DateUtils.formatCurrentTime()
 *    // Kotlin可以直接调用Java的静态方法，语法相同
 * 
 * 2. 导入后调用：
 *    import com.example.androidjavaandkotlindemo.util.DateUtils
 *    val time = formatCurrentTime()  // 可以直接调用方法名
 * 
 * 3. 使用对象：
 *    // Kotlin中，Java的静态方法可以通过类名或对象访问
 *    val time1 = DateUtils.formatCurrentTime()
 *    val time2 = DateUtils.formatTime(Date())
 * 
 * 注意事项：
 * - Java的静态方法在Kotlin中可以直接调用
 * - 不需要创建类的实例
 * - 语法与Java相同
 * - 这是Java和Kotlin互操作性的体现
 */

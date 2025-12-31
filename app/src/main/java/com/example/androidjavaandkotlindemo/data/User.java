// package声明：定义当前类所属的包，用于组织和管理代码
// 包名通常与目录结构对应，这里的路径是 com/example/androidjavaandkotlindemo/data/
package com.example.androidjavaandkotlindemo.data;

// 导入Room框架的Entity注解：用于标记一个类为Room数据库的实体类
// Entity注解告诉Room这个类对应数据库中的一张表
import androidx.room.Entity;

// 导入Room框架的Ignore注解：用于标记字段或构造函数，告诉Room忽略这个元素
// 当实体类有多个构造函数时，用@Ignore标记不需要Room使用的构造函数
import androidx.room.Ignore;

// 导入Room框架的PrimaryKey注解：用于标记主键字段
// PrimaryKey表示这个字段是数据库表的主键
import androidx.room.PrimaryKey;

// 导入Android的NonNull注解：用于标记参数、返回值或字段不能为null
// 这有助于代码的可读性和防止空指针异常（Kotlin中通过类型系统实现）
import androidx.annotation.NonNull;

/**
 * User数据模型类 - 使用Java编写
 * 这个类演示了Java和Kotlin混编：
 * 1. 这个类用Java编写
 * 2. UserDao.kt（Kotlin）会操作这个Java类
 * 3. Repository和ViewModel（Kotlin）会使用这个Java类
 * 
 * @Entity注解说明：
 * - tableName = "users"：指定数据库表名为"users"
 * - Room会根据这个类自动创建users表
 * - 如果没有指定tableName，表名默认为类名（User）
 */
@Entity(tableName = "users")
public class User {
    
    /**
     * id字段：用户唯一标识符
     * @PrimaryKey：标记为主键，每个实体类必须有且仅有一个主键
     * autoGenerate = true：自动生成主键值，数据库会自动递增
     * @NonNull：标记为不能为null，确保数据完整性
     * Long类型：使用Long而不是long，因为Room要求主键可以为null（用于新对象）
     */
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private Long id;  // 私有字段，通过getter/setter访问（JavaBean规范）
    
    /**
     * name字段：用户姓名
     * String类型可以为null，表示用户可能没有填写姓名
     */
    private String name;
    
    /**
     * email字段：用户邮箱
     * String类型可以为null
     */
    private String email;
    
    /**
     * age字段：用户年龄
     * int是原始类型，不能为null，默认值为0
     */
    private int age;
    
    /**
     * 无参构造函数（默认构造函数）
     * Room必须使用这个构造函数来创建实体实例
     * Room会通过反射调用这个构造函数，然后使用setter方法设置字段值
     * 注意：如果没有显式声明，Java会自动提供一个无参构造函数
     *       但如果声明了其他构造函数，就必须显式声明无参构造函数
     */
    public User() {
        // 空的构造函数体，所有字段使用默认值
        // id = null（因为还未插入数据库）
        // name = null, email = null
        // age = 0
    }
    
    /**
     * 带参数的构造函数 - 用于业务代码中方便地创建User对象
     * @Ignore注解：告诉Room忽略这个构造函数，Room不会使用它来创建实体
     * 这个构造函数用于在业务逻辑中创建User对象，而不是Room数据库操作
     * 
     * 参数说明：
     * @param name 用户姓名
     * @param email 用户邮箱
     * @param age 用户年龄
     * 
     * 注意：这个构造函数不设置id，因为id是自动生成的
     */
    @Ignore
    public User(String name, String email, int age) {
        // this关键字：指向当前对象实例，用于区分参数和字段
        this.name = name;    // 将参数name赋值给字段this.name
        this.email = email;  // 将参数email赋值给字段this.email
        this.age = age;      // 将参数age赋值给字段this.age
    }
    
    /**
     * getId方法：获取用户ID
     * @return 返回Long类型的id值
     * @NonNull注解：表示返回值不会为null
     * 
     * Getter方法：JavaBean规范要求使用getXxx()命名
     * Room可以使用getter/setter来访问私有字段
     */
    @NonNull
    public Long getId() {
        return id;  // 返回私有字段id的值
    }
    
    /**
     * setId方法：设置用户ID
     * @param id 要设置的ID值
     * @NonNull注解：表示参数不能为null
     * 
     * Setter方法：JavaBean规范要求使用setXxx()命名
     * Room在从数据库读取数据时，会调用setter方法来设置字段值
     */
    public void setId(@NonNull Long id) {
        this.id = id;  // 将参数id赋值给字段this.id
    }
    
    /**
     * getName方法：获取用户姓名
     * @return 返回String类型的name值，可能为null
     * 
     * 注意：返回类型是String（对象类型），可以为null
     */
    public String getName() {
        return name;  // 返回私有字段name的值
    }
    
    /**
     * setName方法：设置用户姓名
     * @param name 要设置的姓名值，可以为null
     */
    public void setName(String name) {
        this.name = name;  // 将参数name赋值给字段this.name
    }
    
    /**
     * getEmail方法：获取用户邮箱
     * @return 返回String类型的email值，可能为null
     */
    public String getEmail() {
        return email;  // 返回私有字段email的值
    }
    
    /**
     * setEmail方法：设置用户邮箱
     * @param email 要设置的邮箱值，可以为null
     */
    public void setEmail(String email) {
        this.email = email;  // 将参数email赋值给字段this.email
    }
    
    /**
     * getAge方法：获取用户年龄
     * @return 返回int类型的age值
     * 
     * 注意：返回类型是int（原始类型），不能为null，默认值为0
     */
    public int getAge() {
        return age;  // 返回私有字段age的值
    }
    
    /**
     * setAge方法：设置用户年龄
     * @param age 要设置的年龄值
     */
    public void setAge(int age) {
        this.age = age;  // 将参数age赋值给字段this.age
    }
    
    /**
     * toString方法：将对象转换为字符串表示
     * @Override注解：表示重写父类Object的toString方法
     * 
     * 这个方法用于调试和日志输出，方便查看对象的内容
     * 格式：User{id=1, name='张三', email='zhangsan@example.com', age=25}
     */
    @Override
    public String toString() {
        // 字符串拼接：使用+运算符连接多个字符串
        // '\''：单引号的转义字符，在字符串字面量中表示单引号
        // 示例输出：User{id=1, name='张三', email='test@example.com', age=25}
        return "User{" +
                "id=" + id +                    // 拼接id值
                ", name='" + name + '\'' +      // 拼接name值（用单引号包围）
                ", email='" + email + '\'' +    // 拼接email值（用单引号包围）
                ", age=" + age +                // 拼接age值
                '}';                            // 闭合大括号
    }
}

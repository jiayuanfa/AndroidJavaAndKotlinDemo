package com.example.androidjavaandkotlindemo.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.androidjavaandkotlindemo.util.DateUtils
import com.example.androidjavaandkotlindemo.util.capitalizeFirst
import java.util.Date

/**
 * HomeScreen - 使用Kotlin编写
 * 演示Java和Kotlin混编：调用Java工具类和Kotlin扩展函数
 */
@Composable
fun HomeScreen(
    onNavigateToUsers: () -> Unit,
    onNavigateToKotlin: () -> Unit = {},
    onNavigateToJava: () -> Unit = {},
    onNavigateToAndroid: () -> Unit = {},
    onNavigateToFramework: () -> Unit = {},
    onNavigateToAdvanced: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())  // 记住滚动状态，增加垂直滚动修饰符
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // 标题
        Text(
            text = "Android Java & Kotlin 混编项目",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )
        
        Spacer(modifier = Modifier.height(8.dp))
        
        // 演示调用Java工具类
        Text(
            text = "当前时间: ${DateUtils.formatTime(Date())}",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        
        Spacer(modifier = Modifier.height(32.dp))
        
        // 四个模块按钮 - 使用网格布局
        Text(
            text = "功能模块",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.fillMaxWidth()
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        // 第一行：Kotlin 和 Java
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            ModuleCard(
                title = "Kotlin",
                description = "Kotlin语言特性与最佳实践",
                icon = Icons.Default.Code,
                onClick = onNavigateToKotlin,
                modifier = Modifier.weight(1f)
            )
            
            ModuleCard(
                title = "Java",
                description = "Java语言特性与设计模式",
                icon = Icons.Default.Computer,
                onClick = onNavigateToJava,
                modifier = Modifier.weight(1f)
            )
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        // 第二行：Android 和 Framework
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            ModuleCard(
                title = "Android",
                description = "Android开发与Jetpack组件",
                icon = Icons.Default.PhoneAndroid,
                onClick = onNavigateToAndroid,
                modifier = Modifier.weight(1f)
            )
            
            ModuleCard(
                title = "Framework",
                description = "框架设计与架构模式",
                icon = Icons.Default.Build,
                onClick = onNavigateToFramework,
                modifier = Modifier.weight(1f)
            )
        }
        
        Spacer(modifier = Modifier.height(32.dp))
        
        // 进阶模块按钮
        ModuleCard(
            title = "进阶模块",
            description = "高级开发工程师进阶主题",
            icon = Icons.Default.TrendingUp,
            onClick = onNavigateToAdvanced,
            modifier = Modifier.fillMaxWidth(),
            height = 160.dp  // 增加高度以完整显示描述文字
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        // 其他功能按钮
        Button(
            onClick = onNavigateToUsers,
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(Icons.Default.People, contentDescription = null)
            Spacer(modifier = Modifier.width(8.dp))
            Text("查看用户列表")
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        // 项目技术栈卡片
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "项目技术栈",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text("• Jetpack Compose UI")
                Text("• Hilt 依赖注入")
                Text("• Room 数据库")
                Text("• Navigation Compose")
                Text("• ViewModel + StateFlow")
                Text("• Retrofit + OkHttp")
            }
        }
    }
}

/**
 * 模块卡片组件
 */
@Composable
fun ModuleCard(
    title: String,
    description: String,
    icon: ImageVector,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    height: androidx.compose.ui.unit.Dp = 140.dp
) {
    Card(
        onClick = onClick,
        modifier = modifier.height(height),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = title,
                modifier = Modifier.size(48.dp),
                tint = MaterialTheme.colorScheme.primary
            )
            
            Spacer(modifier = Modifier.height(12.dp))
            
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
            
            Spacer(modifier = Modifier.height(4.dp))
            
            Text(
                text = description,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                maxLines = 2,  // 允许最多2行显示
                overflow = TextOverflow.Ellipsis  // 如果超过2行，显示省略号
            )
        }
    }
}


package com.example.androidjavaandkotlindemo.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
    onNavigateToUsers: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Android Java & Kotlin 混编项目",
            style = MaterialTheme.typography.headlineMedium
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        // 演示调用Java工具类
        Text(
            text = "当前时间: ${DateUtils.formatTime(Date())}",
            style = MaterialTheme.typography.bodyMedium
        )
        
        Spacer(modifier = Modifier.height(8.dp))
        
        // 演示调用Kotlin扩展函数（为Java String添加的功能）
        val demoText = "hello world"
        Text(
            text = "扩展函数示例: \"${demoText}\" -> \"${demoText.capitalizeFirst()}\"",
            style = MaterialTheme.typography.bodyMedium
        )
        
        Spacer(modifier = Modifier.height(32.dp))
        
        Button(
            onClick = onNavigateToUsers,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("查看用户列表")
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "项目技术栈",
                    style = MaterialTheme.typography.titleMedium
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text("• Jetpack Compose UI")
                Text("• Hilt 依赖注入")
                Text("• Room 数据库")
                Text("• Navigation Compose")
                Text("• ViewModel + StateFlow")
                Text("• Retrofit + OkHttp")
                Text("• DataStore")
                Text("• WorkManager")
                Text("• CameraX")
                Text("• Paging 3")
            }
        }
    }
}


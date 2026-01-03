package com.example.androidjavaandkotlindemo.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * AdvancedTopicsScreen - 进阶模块页面
 * 展示高级Android开发工程师需要关注的进阶主题
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdvancedTopicsScreen(
    onNavigateBack: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("进阶模块") },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "返回")
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "进阶模块",
                style = MaterialTheme.typography.headlineLarge
            )
            
            Spacer(modifier = Modifier.height(16.dp))
            
            Text(
                text = "高级Android开发工程师进阶主题\n包括架构设计、性能优化、代码质量、CI/CD等",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            
            Spacer(modifier = Modifier.height(24.dp))
            
            Card(
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = "主要模块",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = androidx.compose.ui.text.font.FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text("• 架构设计")
                    Text("• 性能优化")
                    Text("• 代码质量与工程化")
                    Text("• 测试策略与质量保证")
                    Text("• CI/CD持续集成部署")
                    Text("• 安全性深入")
                    Text("• 监控与分析")
                    Text("• 团队协作与流程")
                    Text("• 新技术与趋势")
                    Text("• 业务理解与产品思维")
                    Text("• 系统底层与原理")
                    Text("• 跨平台技术")
                }
            }
        }
    }
}


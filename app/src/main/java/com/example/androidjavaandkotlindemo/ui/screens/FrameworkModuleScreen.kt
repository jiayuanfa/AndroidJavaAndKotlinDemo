package com.example.androidjavaandkotlindemo.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.androidjavaandkotlindemo.data.FrameworkFeature
import com.example.androidjavaandkotlindemo.data.FrameworkFeaturesData

/**
 * FrameworkModuleScreen - Framework模块页面
 * 展示框架功能学习列表
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FrameworkModuleScreen(
    onNavigateBack: () -> Unit,
    onNavigateToDetail: (String, String?, String?) -> Unit = { _, _, _ -> }
) {
    val frameworkFeatures = remember { FrameworkFeaturesData.getFrameworkFeatures() }
    
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Framework 模块") },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "返回")
                    }
                }
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(vertical = 16.dp)
        ) {
            item {
                Text(
                    text = "Framework 功能学习列表",
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(
                    text = "涵盖Android框架技术和架构模式",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
            }
            
            items(frameworkFeatures) { feature ->
                ExpandableFrameworkFeatureCard(
                    feature = feature,
                    onItemClick = { item ->
                        onNavigateToDetail(item.name, item.description, item.id)
                    }
                )
            }
        }
    }
}

/**
 * 可展开的Framework功能卡片
 */
@Composable
fun ExpandableFrameworkFeatureCard(
    feature: FrameworkFeature,
    onItemClick: (com.example.androidjavaandkotlindemo.data.FrameworkFeatureItem) -> Unit = {}
) {
    var isExpanded by remember { mutableStateOf(false) }
    
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = feature.title,
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold
                    )
                    if (feature.description != null) {
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = feature.description,
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
                
                IconButton(
                    onClick = { isExpanded = !isExpanded }
                ) {
                    Icon(
                        imageVector = if (isExpanded) Icons.Default.ExpandLess else Icons.Default.ExpandMore,
                        contentDescription = if (isExpanded) "折叠" else "展开"
                    )
                }
            }
            
            if (isExpanded && feature.items.isNotEmpty()) {
                Spacer(modifier = Modifier.height(12.dp))
                Divider(modifier = Modifier.padding(vertical = 8.dp))
                Column(
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    feature.items.forEach { item ->
                        FrameworkFeatureItemRow(
                            item = item,
                            onClick = { onItemClick(item) }
                        )
                    }
                }
            }
            
            if (feature.items.isNotEmpty()) {
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "${feature.items.size} 个知识点",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}

/**
 * Framework功能项行
 */
@Composable
fun FrameworkFeatureItemRow(
    item: com.example.androidjavaandkotlindemo.data.FrameworkFeatureItem,
    onClick: () -> Unit = {}
) {
    Card(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = item.isCompleted,
                onCheckedChange = null,
                modifier = Modifier.size(20.dp)
            )
            
            Spacer(modifier = Modifier.width(12.dp))
            
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = item.name,
                    style = MaterialTheme.typography.bodyMedium
                )
                if (item.description != null) {
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = item.description,
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }
    }
}

package com.example.androidjavaandkotlindemo.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.androidjavaandkotlindemo.data.KnowledgeDetailsRepository

/**
 * FeatureDetailScreen - 功能详情页面
 * 展示知识点的详细学习内容，包括代码示例、适用场景、注意事项等
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FeatureDetailScreen(
    title: String, // 知识点标题
    description: String? = null, // 知识点描述（可选）
    knowledgeId: String? = null, // 知识点ID，用于获取详细内容
    onNavigateBack: () -> Unit // 返回上一页的导航回调
) {
    // 根据knowledgeId获取知识详情
    val knowledgeDetail = knowledgeId?.let { KnowledgeDetailsRepository.getKnowledgeDetail(it) }
    
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(title) },
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
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {
            // 如果有知识详情数据，显示详细内容
            if (knowledgeDetail != null) {
                KnowledgeDetailContent(knowledgeDetail = knowledgeDetail)
            } else {
                // 否则显示简单的标题和描述
                SimpleDetailContent(title = title, description = description)
            }
        }
    }
}

/**
 * 知识详情内容组件
 */
@Composable
private fun KnowledgeDetailContent(knowledgeDetail: com.example.androidjavaandkotlindemo.data.KnowledgeDetail) {
    // 标题
    Text(
        text = knowledgeDetail.title,
        style = MaterialTheme.typography.headlineMedium,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(bottom = 16.dp)
    )
    
    // 概述
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 24.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.3f)
        )
    ) {
        Text(
            text = knowledgeDetail.overview,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(16.dp),
            color = MaterialTheme.colorScheme.onSurface
        )
    }
    
    // 核心要点
    if (knowledgeDetail.keyPoints.isNotEmpty()) {
        SectionTitle("核心要点")
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
            )
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                knowledgeDetail.keyPoints.forEach { point ->
                    Text(
                        text = "• $point",
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(vertical = 4.dp)
                    )
                }
            }
        }
    }
    
    // 代码示例
    if (knowledgeDetail.codeExamples.isNotEmpty()) {
        SectionTitle("代码示例")
        knowledgeDetail.codeExamples.forEachIndexed { index, example ->
            CodeExampleCard(
                example = example,
                index = index + 1,
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }
    }
    
    // 适用场景
    if (knowledgeDetail.useCases.isNotEmpty()) {
        SectionTitle("适用场景")
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.3f)
            )
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                knowledgeDetail.useCases.forEach { useCase ->
                    Text(
                        text = "• $useCase",
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(vertical = 4.dp)
                    )
                }
            }
        }
    }
    
    // 注意事项
    if (knowledgeDetail.notes.isNotEmpty()) {
        SectionTitle("注意事项")
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.errorContainer.copy(alpha = 0.2f)
            )
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                knowledgeDetail.notes.forEach { note ->
                    Text(
                        text = "⚠ $note",
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(vertical = 4.dp),
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }
    }
    
    // 实践建议
    if (!knowledgeDetail.practiceTips.isNullOrEmpty()) {
        SectionTitle("实践建议")
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.tertiaryContainer.copy(alpha = 0.3f)
            )
        ) {
            Text(
                text = knowledgeDetail.practiceTips,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(16.dp),
                color = MaterialTheme.colorScheme.onSurface
            )
        }
    }
}

/**
 * 代码示例卡片组件
 */
@Composable
private fun CodeExampleCard(
    example: com.example.androidjavaandkotlindemo.data.CodeExample,
    index: Int,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            // 代码示例标题
            Text(
                text = "示例$index：${example.title}",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 12.dp)
            )
            
            // 代码块
            CodeBlock(code = example.code)
            
            // 代码说明
            if (!example.explanation.isNullOrEmpty()) {
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = example.explanation,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(top = 8.dp)
                )
            }
        }
    }
}

/**
 * 代码块组件（使用等宽字体显示代码）
 */
@Composable
private fun CodeBlock(code: String) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.6f),
        tonalElevation = 1.dp
    ) {
        Text(
            text = code,
            style = MaterialTheme.typography.bodySmall,
            fontFamily = FontFamily.Monospace, // 等宽字体
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}

/**
 * 章节标题组件
 */
@Composable
private fun SectionTitle(title: String) {
    Text(
        text = title,
        style = MaterialTheme.typography.titleLarge,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(bottom = 12.dp, top = 8.dp),
        color = MaterialTheme.colorScheme.primary
    )
}

/**
 * 简单详情内容（当没有知识详情数据时显示）
 */
@Composable
private fun SimpleDetailContent(title: String, description: String?) {
    Text(
        text = title,
        style = MaterialTheme.typography.headlineMedium,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(bottom = 16.dp)
    )
    
    if (description != null) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.3f)
            )
        ) {
            Text(
                text = description,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
    
    Text(
        text = "详细内容正在完善中...",
        style = MaterialTheme.typography.bodyMedium,
        color = MaterialTheme.colorScheme.onSurfaceVariant,
        modifier = Modifier.padding(top = 16.dp)
    )
}

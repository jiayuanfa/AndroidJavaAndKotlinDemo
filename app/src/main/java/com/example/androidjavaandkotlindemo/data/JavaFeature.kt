package com.example.androidjavaandkotlindemo.data

/**
 * Java功能项数据模型
 * 用于展示Java功能列表
 */
data class JavaFeature(
    val id: String,
    val title: String,
    val description: String? = null,
    val items: List<JavaFeatureItem> = emptyList()
)

/**
 * Java功能子项数据模型
 */
data class JavaFeatureItem(
    val id: String,
    val name: String,
    val description: String? = null,
    val isCompleted: Boolean = false  // 学习进度标记
)


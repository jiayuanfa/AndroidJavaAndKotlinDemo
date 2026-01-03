package com.example.androidjavaandkotlindemo.data

/**
 * Framework功能项数据模型
 */
data class FrameworkFeature(
    val id: String,
    val title: String,
    val description: String? = null,
    val items: List<FrameworkFeatureItem> = emptyList()
)

/**
 * Framework功能子项数据模型
 */
data class FrameworkFeatureItem(
    val id: String,
    val name: String,
    val description: String? = null,
    val isCompleted: Boolean = false
)


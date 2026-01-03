package com.example.androidjavaandkotlindemo.data

/**
 * 进阶功能项数据模型
 */
data class AdvancedFeature(
    val id: String,
    val title: String,
    val description: String? = null,
    val items: List<AdvancedFeatureItem> = emptyList()
)

/**
 * 进阶功能子项数据模型
 */
data class AdvancedFeatureItem(
    val id: String,
    val name: String,
    val description: String? = null,
    val isCompleted: Boolean = false
)


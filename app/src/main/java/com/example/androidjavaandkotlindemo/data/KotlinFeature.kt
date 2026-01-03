package com.example.androidjavaandkotlindemo.data

/**
 * Kotlin功能项数据模型
 */
data class KotlinFeature(
    val id: String,
    val title: String,
    val description: String? = null,
    val items: List<KotlinFeatureItem> = emptyList()
)

/**
 * Kotlin功能子项数据模型
 */
data class KotlinFeatureItem(
    val id: String,
    val name: String,
    val description: String? = null,
    val isCompleted: Boolean = false
)


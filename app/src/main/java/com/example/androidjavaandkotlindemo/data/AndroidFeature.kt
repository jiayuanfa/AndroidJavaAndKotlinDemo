package com.example.androidjavaandkotlindemo.data

/**
 * Android功能项数据模型
 */
data class AndroidFeature(
    val id: String,
    val title: String,
    val description: String? = null,
    val items: List<AndroidFeatureItem> = emptyList()
)

/**
 * Android功能子项数据模型
 */
data class AndroidFeatureItem(
    val id: String,
    val name: String,
    val description: String? = null,
    val isCompleted: Boolean = false
)


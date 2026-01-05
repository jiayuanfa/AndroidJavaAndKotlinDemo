package com.example.androidjavaandkotlindemo.data

/**
 * 代码示例数据模型
 * 用于展示知识点中的代码示例
 */
data class CodeExample(
    val title: String, // 代码示例的标题
    val code: String, // 代码内容（带注释）
    val explanation: String? = null // 代码说明（可选）
)

/**
 * 知识详情数据模型
 * 包含一个知识点的完整学习内容
 */
data class KnowledgeDetail(
    val id: String, // 知识点ID，用于匹配
    val title: String, // 知识点标题
    val overview: String, // 知识点概述
    val codeExamples: List<CodeExample> = emptyList(), // 代码示例列表
    val useCases: List<String> = emptyList(), // 适用场景列表
    val keyPoints: List<String> = emptyList(), // 核心要点列表
    val notes: List<String> = emptyList(), // 注意事项列表
    val practiceTips: String? = null // 实践建议（可选）
)






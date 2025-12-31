package com.example.androidjavaandkotlindemo.data.api

import retrofit2.http.GET
import retrofit2.http.Path

/**
 * API服务接口 - 使用Kotlin编写
 * 定义网络请求接口
 */
interface ApiService {
    
    @GET("users/{username}")
    suspend fun getUser(@Path("username") username: String): GitHubUser
    
    data class GitHubUser(
        val login: String,
        val id: Int,
        val name: String?,
        val email: String?,
        val bio: String?
    )
}


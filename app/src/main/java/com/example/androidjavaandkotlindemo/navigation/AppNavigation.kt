package com.example.androidjavaandkotlindemo.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.androidjavaandkotlindemo.ui.screens.*
import java.net.URLDecoder
import java.nio.charset.StandardCharsets

/**
 * AppNavigation - 使用Kotlin编写
 * 使用Jetpack Compose Navigation进行导航
 */
@Composable
fun AppNavigation(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable("home") {
            HomeScreen(
                onNavigateToUsers = {
                    navController.navigate("users")
                },
                onNavigateToKotlin = {
                    navController.navigate("kotlin")
                },
                onNavigateToJava = {
                    navController.navigate("java")
                },
                onNavigateToAndroid = {
                    navController.navigate("android")
                },
                onNavigateToFramework = {
                    navController.navigate("framework")
                },
                onNavigateToAdvanced = {
                    navController.navigate("advanced")
                }
            )
        }
        
        composable("users") {
            UserListScreen(
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }
        
        composable("kotlin") {
            KotlinModuleScreen(
                onNavigateBack = {
                    navController.popBackStack()
                },
                onNavigateToDetail = { title, description, knowledgeId ->
                    val encodedTitle = java.net.URLEncoder.encode(title, StandardCharsets.UTF_8.toString())
                    val encodedDesc = java.net.URLEncoder.encode(description ?: "", StandardCharsets.UTF_8.toString())
                    val encodedId = java.net.URLEncoder.encode(knowledgeId ?: "", StandardCharsets.UTF_8.toString())
                    navController.navigate("detail/$encodedTitle/$encodedDesc/$encodedId")
                }
            )
        }
        
        composable("java") {
            JavaModuleScreen(
                onNavigateBack = {
                    navController.popBackStack()
                },
                onNavigateToDetail = { title, description, knowledgeId ->
                    val encodedTitle = java.net.URLEncoder.encode(title, StandardCharsets.UTF_8.toString())
                    val encodedDesc = java.net.URLEncoder.encode(description ?: "", StandardCharsets.UTF_8.toString())
                    val encodedId = java.net.URLEncoder.encode(knowledgeId ?: "", StandardCharsets.UTF_8.toString())
                    navController.navigate("detail/$encodedTitle/$encodedDesc/$encodedId")
                }
            )
        }
        
        composable("android") {
            AndroidModuleScreen(
                onNavigateBack = {
                    navController.popBackStack()
                },
                onNavigateToDetail = { title, description, knowledgeId ->
                    val encodedTitle = java.net.URLEncoder.encode(title, StandardCharsets.UTF_8.toString())
                    val encodedDesc = java.net.URLEncoder.encode(description ?: "", StandardCharsets.UTF_8.toString())
                    val encodedId = java.net.URLEncoder.encode(knowledgeId ?: "", StandardCharsets.UTF_8.toString())
                    navController.navigate("detail/$encodedTitle/$encodedDesc/$encodedId")
                }
            )
        }
        
        composable("framework") {
            FrameworkModuleScreen(
                onNavigateBack = {
                    navController.popBackStack()
                },
                onNavigateToDetail = { title, description, knowledgeId ->
                    val encodedTitle = java.net.URLEncoder.encode(title, StandardCharsets.UTF_8.toString())
                    val encodedDesc = java.net.URLEncoder.encode(description ?: "", StandardCharsets.UTF_8.toString())
                    val encodedId = java.net.URLEncoder.encode(knowledgeId ?: "", StandardCharsets.UTF_8.toString())
                    navController.navigate("detail/$encodedTitle/$encodedDesc/$encodedId")
                }
            )
        }
        
        composable("advanced") {
            AdvancedTopicsScreen(
                onNavigateBack = {
                    navController.popBackStack()
                },
                onNavigateToDetail = { title, description, knowledgeId ->
                    val encodedTitle = java.net.URLEncoder.encode(title, StandardCharsets.UTF_8.toString())
                    val encodedDesc = java.net.URLEncoder.encode(description ?: "", StandardCharsets.UTF_8.toString())
                    val encodedId = java.net.URLEncoder.encode(knowledgeId ?: "", StandardCharsets.UTF_8.toString())
                    navController.navigate("detail/$encodedTitle/$encodedDesc/$encodedId")
                }
            )
        }
        
            // 详情页路由
            composable(
                route = "detail/{title}/{description}/{knowledgeId}",
                arguments = listOf(
                    navArgument("title") { type = NavType.StringType },
                    navArgument("description") { type = NavType.StringType },
                    navArgument("knowledgeId") { 
                        type = NavType.StringType
                        defaultValue = ""
                        nullable = true
                    }
                )
            ) { backStackEntry ->
                val title = URLDecoder.decode(backStackEntry.arguments?.getString("title") ?: "", StandardCharsets.UTF_8.toString())
                val description = URLDecoder.decode(backStackEntry.arguments?.getString("description") ?: "", StandardCharsets.UTF_8.toString())
                val knowledgeId = backStackEntry.arguments?.getString("knowledgeId")?.takeIf { it.isNotEmpty() }
                
                FeatureDetailScreen(
                    title = title,
                    description = if (description.isEmpty()) null else description,
                    knowledgeId = knowledgeId,
                    onNavigateBack = {
                        navController.popBackStack()
                    }
                )
            }
    }
}


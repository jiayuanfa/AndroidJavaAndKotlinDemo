package com.example.androidjavaandkotlindemo.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.androidjavaandkotlindemo.ui.screens.*

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
                }
            )
        }
        
        composable("java") {
            JavaModuleScreen(
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }
        
        composable("android") {
            AndroidModuleScreen(
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }
        
        composable("framework") {
            FrameworkModuleScreen(
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }
        
        composable("advanced") {
            AdvancedTopicsScreen(
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}


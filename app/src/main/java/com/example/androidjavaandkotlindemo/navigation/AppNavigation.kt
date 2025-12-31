package com.example.androidjavaandkotlindemo.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.androidjavaandkotlindemo.ui.screens.HomeScreen
import com.example.androidjavaandkotlindemo.ui.screens.UserListScreen

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
    }
}


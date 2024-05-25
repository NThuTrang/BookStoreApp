package com.example.bookstoreapp.ui.theme

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.bookstoreapp.BottomBarScreen
import com.example.bookstoreapp.screens.AddScreen
import com.example.bookstoreapp.screens.FindScreen
import com.example.bookstoreapp.screens.HomeScreen
import com.example.bookstoreapp.screens.ProductsScreen

@Composable
fun BottomNavGraph(
    navController: NavController
) {
    NavHost(navController = navController as NavHostController, startDestination = BottomBarScreen.Home.route) {
        // hiển thị màn hình Home
        composable(route = BottomBarScreen.Home.route) {
            HomeScreen()
        }
        composable(route = BottomBarScreen.Products.route) {
            ProductsScreen()
        }
        composable(route = BottomBarScreen.AddBook.route) {
            AddScreen()
        }
        composable(route = BottomBarScreen.Find.route) {
            FindScreen()
        }
    }
}
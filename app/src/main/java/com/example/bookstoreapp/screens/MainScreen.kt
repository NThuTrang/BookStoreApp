package com.example.bookstoreapp.screens

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.bookstoreapp.BottomBarScreen
import com.example.bookstoreapp.ui.theme.BottomNavGraph

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomBar(navController = navController)
        }
    ) {
        BottomNavGraph(navController = navController)
    }
}

@Composable
fun BottomBar(navController: NavHostController) {
    // danh sách các màn hình
    val screens = listOf(
        BottomBarScreen.Home,
        BottomBarScreen.Products,
        BottomBarScreen.AddBook,
        BottomBarScreen.Find
    )
    // biến nhớ vị trí của navigation
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    // biến ghi nhớ vị trí hiện tại của navigation
    val currentDestination = navBackStackEntry?.destination
    // duyệt danh sách các item để vẽ
    BottomNavigation {
        screens.forEach { scr ->
            AddItem(
                screen = scr,
                currentDestination = currentDestination,
                navController = navController
            )
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: BottomBarScreen,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    BottomNavigationItem(
        label = {
            Text(text = screen.title)
        },
        icon = {
            Icon(
                imageVector = screen.icon,
                contentDescription = ""
            )
        },
        selected = currentDestination?.hierarchy?.any {
            it.route == screen.route
        } == true,
        unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled),
        onClick = {
            navController.navigate(screen.route) {
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        })
}

@Preview (showBackground = true)
@Composable
fun MainPre(){
    MainScreen()
}
package com.example.bookstoreapp

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Home: BottomBarScreen(
        route = "home",
        title = "Home",
        icon = Icons.Default.Home
    )
    object Products: BottomBarScreen(
        route = "product",
        title = "Product",
        icon = Icons.Default.AccountBox
    )
    object AddBook: BottomBarScreen(
        route = "addBook",
        title = "AddBook",
        icon = Icons.Default.Add
    )
    object Find: BottomBarScreen(
        route = "find",
        title = "Find",
        icon = Icons.Default.Search
    )
}

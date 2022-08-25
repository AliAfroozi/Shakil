package com.example.shakil

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.shakil.data.MockData
import com.example.shakil.ui.component.NavigationBottom
import com.example.shakil.ui.component.TopAppBar
import com.example.shakil.ui.screen.*
import com.example.shakil.ui.theme.ShakilTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShakilTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Content()
                }
            }
        }
    }
}

@Composable
fun Content() {

    val navController = rememberNavController()
    val fullScreen = remember { mutableStateOf(false) }
    val selectedNavigationBottom = remember { mutableStateOf("home") }


    Scaffold(
        bottomBar = { if (!fullScreen.value) NavigationBottom(navController , selectedNavigationBottom) },
        topBar = { if (!fullScreen.value) TopAppBar() }
    ) {

        val navHost = NavHost(navController = navController, startDestination = "home") {
            composable("home") {
                val systemUiController = rememberSystemUiController()
                if (!isSystemInDarkTheme()) {
                    systemUiController.setSystemBarsColor(Color.White)
                    systemUiController.setStatusBarColor(Color.White)
                    systemUiController.statusBarDarkContentEnabled
                }

                selectedNavigationBottom.value = "home"

                fullScreen.value = false
                MainScreen(MockData.stories, navController, fullScreen)
            }
            composable("search") {
                fullScreen.value = false
                selectedNavigationBottom.value = "search"
                SearchScreen()
            }
            composable("addPost") {
                fullScreen.value = false
                selectedNavigationBottom.value = "addPost"
                ActivitiesScreen()
            }
            composable("activity") {
                fullScreen.value = false
                selectedNavigationBottom.value = "activity"
                AddPostScreen()
            }
            composable("profile") {
                fullScreen.value = false
                selectedNavigationBottom.value = "profile"
                ProfileScreen()
            }
            composable(
                "ShowStory/{index}",
                arguments = listOf(navArgument("index") { type = NavType.IntType })
            ) { backStack ->

                val systemUiController = rememberSystemUiController()
                systemUiController.setSystemBarsColor(Color.Black)

                fullScreen.value = true
                ShowStoryScreen(backStack.arguments?.get("index") as Int)

            }
        }

    }

}




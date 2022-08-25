package com.example.shakil

import android.content.res.Resources
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.core.graphics.toColor
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

    Scaffold(
        bottomBar = { if (!fullScreen.value) NavigationBottom(navController) },
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

                fullScreen.value = false
                MainScreen(MockData.stories, navController, fullScreen)
            }
            composable("search") {
                fullScreen.value = false
                SearchScreen()
            }
            composable("addPost") {
                fullScreen.value = false
                ActivitiesScreen()
            }
            composable("activity") {
                fullScreen.value = false
                AddPostScreen()
            }
            composable("profile") {
                fullScreen.value = false
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




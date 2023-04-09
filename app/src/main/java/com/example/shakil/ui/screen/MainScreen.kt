package com.example.shakil.ui.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.shakil.data.MockData
import com.example.shakil.ui.component.NavigationBottom
import com.example.shakil.ui.component.TopAppBar
import com.google.accompanist.systemuicontroller.rememberSystemUiController


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainScreen() {

        val navController = rememberNavController()
        val fullScreen = remember { mutableStateOf(false) }
        val selectedNavigationBottom = remember { mutableStateOf("home") }


        Scaffold(
            bottomBar = { if (!fullScreen.value) NavigationBottom(navController , selectedNavigationBottom) },
            topBar = { if (!fullScreen.value) TopAppBar() }
        ) {

            val navHost = NavHost(navController = navController, startDestination = "splash") {


                composable("splash") {
                    fullScreen.value = true
                    SplashScreen(navController)
                }

                composable("login") {
                    fullScreen.value = true
                    LoginScreen(navController)
                }

                composable("home") {
                    val systemUiController = rememberSystemUiController()
                    if (!isSystemInDarkTheme()) {
                        systemUiController.setSystemBarsColor(Color.White)
                        systemUiController.setStatusBarColor(Color.White)
                        systemUiController.statusBarDarkContentEnabled
                    }


                    selectedNavigationBottom.value = "home"

                    fullScreen.value = false
                    HomeScreen(MockData.stories, navController, fullScreen)
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
                    fullScreen.value = true
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
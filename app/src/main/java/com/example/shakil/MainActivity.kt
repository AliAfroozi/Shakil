package com.example.shakil

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.shakil.data.MockData
import com.example.shakil.ui.component.NavigationBottom
import com.example.shakil.ui.component.TopAppBar
import com.example.shakil.ui.screen.*
import com.example.shakil.ui.theme.ShakilTheme

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

    Scaffold(
        bottomBar = {
        NavigationBottom(navController) },
        topBar = { TopAppBar() }
    ) {

        val navHost = NavHost(navController = navController , startDestination = "home"){
            composable("home") {
                MainScreen(MockData.stories)
            }
            composable("search"){
                SearchScreen()
            }
            composable("addPost"){
                ActivitiesScreen()
            }
            composable("activity"){
                AddPostScreen()
            }
            composable("profile"){
                ProfileScreen()
            }
        }

    }

}




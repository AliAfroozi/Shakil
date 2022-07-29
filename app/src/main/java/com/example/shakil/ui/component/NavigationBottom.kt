package com.example.shakil.ui.component

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.*
import androidx.compose.material.icons.materialIcon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.shakil.utils.NavigationItems

@Composable
fun NavigationBottom(navController: NavController) {

    val selectedBottom = remember { mutableStateOf("home")}

    var items = listOf(
        NavigationItems.home,
        NavigationItems.search,
        NavigationItems.addPost,
        NavigationItems.activity,
        NavigationItems.profile
    )

    BottomNavigation(
    ) {
        items.forEach {
            BottomNavigationItem(
                icon = {
                    Icon(painter = painterResource(id = it.icon), contentDescription = it.title)
                },
                selected = selectedBottom.value == it.route,
                onClick = {
                    selectedBottom.value = it.route
                    navController.navigate(it.route) {
                        popUpTo("home") {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }

                },
            )
        }

    }

}
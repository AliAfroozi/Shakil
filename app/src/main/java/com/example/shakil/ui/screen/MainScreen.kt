package com.example.shakil.ui.screen

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.shakil.data.MockData
import com.example.shakil.model.Story
import com.example.shakil.ui.component.PostView
import com.example.shakil.ui.component.StoryRow
import com.example.shakil.ui.theme.lightGray
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun MainScreen(
    stories: MutableList<Story>,
    navController: NavHostController,
    bottomAndTopBarState: MutableState<Boolean>
) {

    Column() {
        StoryRow(stories , navController , bottomAndTopBarState)
        Divider(
            modifier = Modifier
                .padding(12.dp , 5.dp),
            color = lightGray,
            thickness = 1.dp
        )
        PostView(MockData.posts)
    }

}




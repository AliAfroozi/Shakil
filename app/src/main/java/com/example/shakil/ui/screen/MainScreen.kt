package com.example.shakil.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.shakil.data.MockData
import com.example.shakil.model.Story
import com.example.shakil.ui.component.PostView
import com.example.shakil.ui.component.StoryRow
import com.example.shakil.ui.theme.lightGray

@Composable
fun MainScreen(stories: MutableList<Story>) {

    Column() {
        StoryRow(stories)
        Divider(
            modifier = Modifier
                .padding(12.dp , 5.dp),
            color = lightGray,
            thickness = 1.dp
        )
        PostView(MockData.posts)
    }

}




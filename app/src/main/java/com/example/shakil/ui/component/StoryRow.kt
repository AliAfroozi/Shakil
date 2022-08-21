package com.example.shakil.ui.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.outlined.AddCircle
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.compose.ui.unit.sp
import com.example.shakil.R
import com.example.shakil.model.Story
import com.example.shakil.model.User
import com.example.shakil.ui.theme.Purple700
import com.example.shakil.ui.theme.RedColor
import com.example.shakil.ui.theme.ShadowColor
import com.example.shakil.ui.theme.violet
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun StoryRow(stories: MutableList<Story>) {

    Row() {
        StoryItem(
            item = Story(
                User("Ali Afroozi" , "https://s25.picofile.com/file/8452348234/photo_2022_08_20_20_35_21.jpg"  , "Ali Afroozi"),
                false
            ), true
        )
        LazyRow() {
            items(items = stories, itemContent = { item ->
                StoryItem(item)
            })
        }
    }


}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun StoryItem(item: Story, isMe: Boolean = false) {
    Box(
        modifier = Modifier.padding(5.dp, 5.dp)
    ) {
        Card(
            modifier = Modifier
                .height(100.dp)
                .width(70.dp),
            border = if (!isMe) BorderStroke(
                2.dp,
                if (item.isLive) RedColor
                else violet
            ) else null,
            shape = RoundedCornerShape(25),
            onClick = { TODO("implement click on story  ") },
            elevation = 8.dp
        ) {


            GlideImage(
                imageModel = item.user.profileImage,
                // Crop, Fit, Inside, FillHeight, FillWidth, None
                contentScale = ContentScale.Crop,
                // shows a placeholder while loading the image.
                loading = {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .align(Alignment.Center)
                    ) {
                        CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                    }

                },
                failure = {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(0.dp, 20.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Request failed",
                            color = RedColor,
                            fontSize = 8.sp
                        )
                    }
                }
            )

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(ShadowColor)
            )

            if (item.isLive) {
                Box(modifier = Modifier.align(Alignment.BottomCenter)) {
                    Text(
                        text = "live", modifier = Modifier
                            .background(RedColor)
                            .align(Alignment.BottomCenter)
                            .padding(5.dp, 0.dp),
                        color = Color.White,
                        fontSize = 11.sp
                    )
                }


            }
        }


        if (isMe) {
            Icon(
                Icons.Outlined.AddCircle, contentDescription = "", modifier = Modifier
                    .align(
                        Alignment.Center
                    )
                    .size(35.dp, 35.dp), tint = Color.White
            )
        }



        Text(
            text = if (item.user.userName.length >= 12) {
                item.user.userName.substring(0, 12) + "..."
            } else item.user.userName,

            color = Color.Black,
            fontSize = 10.sp,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(
                    0.dp, 100
                        .dp, 0.dp, 0.dp
                )
        )
    }
}





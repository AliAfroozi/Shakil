package com.example.shakil.ui.component

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shakil.R
import com.example.shakil.model.Post
import com.skydoves.landscapist.glide.GlideImage
import java.util.ArrayList


@Composable
fun PostView(posts: ArrayList<Post>) {

    LazyColumn {
        items(posts, itemContent = { item ->
            if (posts[posts.size - 1] == item) {
                PostItem(item = item, true)
            } else
                PostItem(item)
        })
    }

}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun PostItem(item: Post, isLastPost: Boolean = false) {
    Column(modifier = Modifier.padding(5.dp)) {
        Row() {

            Card(
                modifier = Modifier
                    .height(50.dp)
                    .width(50.dp),
                shape = RoundedCornerShape(40),
                elevation = 6.dp,
                onClick = { TODO("implement click on profile image and go to user profile  ") },
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
                                .align(CenterVertically)
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

                            Icon(
                                painterResource(id = R.drawable.ic_baseline_error_outline_24),
                                contentDescription = "",
                                tint = Color.Red,
                                modifier = Modifier
                                    .size(30.dp, 30.dp)
                                    .align(CenterHorizontally)

                            )
                        }
                    })
            }

            Spacer(modifier = Modifier.width(12.dp))

            Column(modifier = Modifier.align(CenterVertically)) {
                Text(text = item.user.userName, fontSize = 14.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(3.dp))
                Text(text = item.postLocation, fontSize = 11.sp, color = Color.Gray)
            }
            Spacer(modifier = Modifier.weight(1f))
            IconButton(onClick = { /*TODO*/ }, modifier = Modifier.align(CenterVertically)) {
                Icon(
                    Icons.Outlined.MoreVert,
                    contentDescription = "",
                    modifier = Modifier.size(26.dp),
                    tint = if (isSystemInDarkTheme()) Color.LightGray else Color.Black
                )
            }
        }

        Spacer(modifier = Modifier.height(10.dp))


        Card(
            modifier = Modifier
                .fillMaxSize(),
            shape = RoundedCornerShape(10),

            ) {
            GlideImage(
                imageModel = item.postImage,
                // Crop, Fit, Inside, FillHeight, FillWidth, None
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize(),
                // shows a placeholder while loading the image.
                loading = {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .align(CenterHorizontally)
                    ) {
                        CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                    }

                },
                failure = {

                    Column() {
                        Spacer(modifier = Modifier.height(80.dp))
                        Icon(
                            painterResource(id = R.drawable.ic_baseline_broken_image_24),
                            contentDescription = "",
                            modifier = Modifier
                                .fillMaxSize()
                                .align(CenterHorizontally)
                        )
                        Spacer(modifier = Modifier.height(80.dp))
                    }


                })
        }

        Spacer(modifier = Modifier.height(10.dp))

    }

    if (isLastPost) {
        Spacer(modifier = Modifier.height(70.dp))
    }

}

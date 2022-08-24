package com.example.shakil.ui.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Bottom
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterStart
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.HorizontalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shakil.R
import com.example.shakil.data.MockData
import com.example.shakil.model.Story
import com.example.shakil.ui.theme.RedColor
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.skydoves.landscapist.glide.GlideImage
import java.util.ArrayList

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ShowStoryScreen(index: Int) {


    var text by remember { mutableStateOf(TextFieldValue("")) }

    var favoriteSate = remember {
        mutableStateOf(false)
    }


    val stories = MockData.stories
    val users = MockData.users

    Column() {
        Box(modifier = Modifier.weight(1f)) {

            Card(
                modifier = Modifier.fillMaxSize()
            ) {
                GlideImage(
                    imageModel = stories[index].storyImage,
                    modifier = Modifier.fillMaxSize(),
                    // Crop, Fit, Inside, FillHeight, FillWidth, None
                    contentScale = ContentScale.Crop,
                    // shows a placeholder while loading the image.
                    loading = {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
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
                                fontSize = 24.sp
                            )
                        }
                    }
                )
            }



            Row(modifier = Modifier.padding(10.dp, 20.dp)) {

                Card(
                    modifier = Modifier
                        .height(45.dp)
                        .width(45.dp),
                    shape = RoundedCornerShape(40),
                    elevation = 6.dp,
                    onClick = { TODO("implement click on profile image and go to user profile  ") },
                ) {
                    GlideImage(
                        imageModel = stories[index].user.profileImage,
                        // Crop, Fit, Inside, FillHeight, FillWidth, None
                        contentScale = ContentScale.Crop,
                        // shows a placeholder while loading the image.
                        loading = {
                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .align(Alignment.CenterVertically)
                            ) {
                                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                            }

                        },
                        failure = {
                            Column(
                                modifier = Modifier
                                    .fillMaxSize(),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {

                                Icon(
                                    painterResource(id = R.drawable.ic_baseline_error_outline_24),
                                    contentDescription = "",
                                    tint = Color.Red,
                                    modifier = Modifier
                                        .size(30.dp, 30.dp)
                                        .align(Alignment.CenterHorizontally)

                                )
                            }
                        })
                }

                Spacer(modifier = Modifier.width(12.dp))

                Column(modifier = Modifier.align(Alignment.CenterVertically)) {
                    Text(
                        text = stories[index].user.userName,
                        color = Color.White,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                IconButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.align(Alignment.CenterVertically)
                ) {
                    Icon(
                        Icons.Outlined.MoreVert,
                        contentDescription = "",
                        modifier = Modifier.size(26.dp),
                        tint = if (isSystemInDarkTheme()) Color.LightGray else Color.White
                    )
                }
            }
        }

        Row(
            modifier = Modifier
                .height(80.dp)
                .background(Color.Black)
                .fillMaxSize(),
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(0.dp, 10.dp)
                    .background(Color.Black)
            ) {
                Spacer(
                    modifier = Modifier
                        .width(10.dp)
                        .background(Color.Black)
                )
                Card(
                    modifier = Modifier
                        .height(55.dp)
                        .width(100.dp)
                        .padding(5.dp, 0.dp)
                        .background(Color.Black)
                        .weight(1f),
                    shape = RoundedCornerShape(40),
                    elevation = 6.dp,
                    border = BorderStroke(0.2.dp, Color.Gray)
                ) {


                    Box(
                        contentAlignment = CenterStart,
                        modifier = Modifier
                            .background(Color.Black)
                            .fillMaxSize()
                    ) {

                        TextField(
                            value = text,
                            modifier = Modifier.fillMaxSize().background(Color.Black),
                            onValueChange = {
                                text = it
                            },
                            placeholder = { Text(text = "Send message" , color = Color.White) },
                            colors = TextFieldDefaults.textFieldColors(textColor = Color.White , backgroundColor = Color(200, 0 , 0) )
                        )
                    }

                }

                IconButton(
                    onClick = { favoriteSate.value = !favoriteSate.value }) {

                    Icon(
                        if (favoriteSate.value) painterResource(id = R.drawable.ic_baseline_favorite_24)
                        else painterResource(id = R.drawable.ic_baseline_favorite_border_24),
                        contentDescription = "",
                        tint = if (favoriteSate.value) Color.Red else Color.LightGray,
                        modifier = Modifier
                            .size(24.dp)
                    )
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        painterResource(id = R.drawable.ic_baseline_send_24),
                        contentDescription = "",
                        tint = Color.LightGray,
                        modifier = Modifier
                            .size(24.dp)
                    )
                }
            }


        }
    }

}



package com.example.shakil.ui.component

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.shakil.R
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun GlideImageCreator(modifier: Modifier , shape : RoundedCornerShape , image : String ) {
    Card(
        modifier = modifier,
        shape = shape,
    ) {
        GlideImage(
            imageModel = image,
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
}
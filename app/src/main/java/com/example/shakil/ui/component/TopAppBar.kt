package com.example.shakil.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shakil.R

@Preview
@Composable
fun TopAppBar() {
    Row(
        modifier = Modifier.padding(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            text = "shakil",
            color = Color.White,
            modifier = Modifier.weight(1F),
            fontFamily = FontFamily.Cursive,
            fontSize = 24.sp,
        )

        IconButton(onClick = { /*TODO*/ }) {
            Box( contentAlignment = Alignment.BottomEnd) {
                Icon(painterResource(id = R.drawable.ic_baseline_send_24) , contentDescription = "")

                Card(
                    shape = RoundedCornerShape(45),
                    modifier = Modifier.size(13.dp),
                    backgroundColor = Color.Red,
                ) {
                    Text(text = "+9",
                        color = Color.White,
                        fontSize = 8.sp,
                        textAlign = TextAlign.Center
                    )
                }


            }
        }


    }
}
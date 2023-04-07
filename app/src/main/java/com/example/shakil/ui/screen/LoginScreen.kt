package com.example.shakil.ui.screen

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.shakil.R
import com.example.shakil.data.MockData
import com.example.shakil.model.User
import com.example.shakil.ui.theme.DarkPurple

@Composable
fun LoginScreen(navController: NavHostController) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val context = LocalContext.current
    Box(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(DarkPurple)
        ) {
            Row(
                Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .padding(25.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                IconButton(onClick = { /*TODO*/ }) {
                    Box(modifier = Modifier.clip(RoundedCornerShape(50))) {
                        Image(
                            painter = painterResource(id = R.drawable.google),
                            contentDescription = "Login By Google",
                            modifier = Modifier
                                .size(30.dp)
                                .background(Color.White)
                                .padding(5.dp)
                                .align(Alignment.Center)
                        )
                    }
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Box(modifier = Modifier.clip(RoundedCornerShape(50))) {
                        Image(
                            painter = painterResource(id = R.drawable.facebook),
                            contentDescription = "Login By Facebook",
                            modifier = Modifier
                                .size(30.dp)
                                .background(Color.White)
                                .padding(5.dp)
                                .align(Alignment.Center)
                        )
                    }
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Box(modifier = Modifier.clip(RoundedCornerShape(50))) {
                        Image(
                            painter = painterResource(id = R.drawable.twitter),
                            contentDescription = "Login By Twitter",
                            modifier = Modifier
                                .size(30.dp)
                                .background(Color.White)
                                .padding(5.dp)
                                .align(Alignment.Center)
                        )
                    }
                }
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(630.dp)
                .clip(RoundedCornerShape(0.dp, 0.dp, 60.dp, 60.dp))
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
            ) {
                Column(
                    Modifier
                        .fillMaxWidth()
                        .padding(25.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = com.example.shakil.R.drawable.shakil_logo),
                        contentDescription = "",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(250.dp)
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(text = "Login", fontSize = 28.sp)
                    Spacer(modifier = Modifier.height(8.dp))
                    OutlinedTextField(
                        value = username,
                        onValueChange = { username = it },
                        modifier = Modifier.fillMaxWidth(),
                        label = {
                            Text(text = "Username")
                        },
                        singleLine = true,
                        shape = RoundedCornerShape(50)
                    )
                    OutlinedTextField(
                        value = password,
                        onValueChange = { password = it },
                        modifier = Modifier.fillMaxWidth(),
                        label = {
                            Text(text = "Password")
                        },
                        singleLine = true,
                        shape = RoundedCornerShape(50)
                    )
                    Spacer(modifier = Modifier.height(21.dp))
                    Button(
                        onClick = {
                            if (checkUser(username , password))
                            navController.navigate("home") else Toast.makeText(
                                context,
                                "Password or username is not correct.",
                                Toast.LENGTH_LONG
                            ).show()
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                            .clip(RoundedCornerShape(50)),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = DarkPurple,
                            contentColor = Color.White
                        )
                    ) {
                        Text(text = "Login")
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        TextButton(onClick = { /*TODO*/ }) {
                            Text(
                                text = "Forget Password",
                                fontSize = 12.sp,
                                color = Color.LightGray
                            )
                        }
                        TextButton(onClick = { /*TODO*/ }) {
                            Text(text = "Register", fontSize = 12.sp, color = Color.LightGray)
                        }
                    }
                }
            }
        }
    }
}

fun checkUser(username : String , password: String): Boolean {
    var users = MockData.users
    users.forEach {
        if (it.userName == username && it.password == password)
            return true
    }
    return false
}

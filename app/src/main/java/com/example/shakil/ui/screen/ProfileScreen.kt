package com.example.shakil.ui.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material.icons.rounded.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shakil.data.MockData
import com.example.shakil.model.User
import com.example.shakil.ui.component.GlideImageCreator
import com.example.shakil.ui.utils.GlideImageWithText
import com.example.shakil.ui.utils.ImageVectorWithText
import com.example.shakil.ui.utils.UserCredential


@ExperimentalFoundationApi
@Composable
fun ProfileScreen() {

    var listNumber = remember {
        mutableStateOf<List<Int>>(listOf(10 , 12, 13 , 14 , 18 ,19 , 15))
    }

    Column(modifier = Modifier.fillMaxSize().padding(bottom = 50.dp)) {
        TopBar(
            name = UserCredential.Companion.userName,
            modifier = Modifier
                .padding(20.dp, 20.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        ProfileSection()
        Spacer(modifier = Modifier.height(25.dp))
        HighlightSection(
            highlights = listOf(
                GlideImageWithText(
                    image = "https://picsum.photos/200/300?random=1",
                    text = "projects"
                ),
                GlideImageWithText(
                    image = "https://picsum.photos/200/300?random=2",
                    text = "companies"
                ),
                GlideImageWithText(
                    image = "https://picsum.photos/200/300?random=3",
                    text = "interests"
                )
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        PostTabView(
            imageWithTexts = listOf(
                ImageVectorWithText(
                    image = Icons.Outlined.Face,
                    text = "Posts"
                ),
                ImageVectorWithText(
                    image = Icons.Filled.List,
                    text = "Reels"
                ),
                ImageVectorWithText(
                    image = Icons.Filled.Person,
                    text = "Profile"
                ),
            )
        ) {
            when (it) {
                0 -> listNumber.value = listOf(10 , 12, 13 , 14 , 18 ,19 , 15)
                1 -> listNumber.value = listOf(30 ,21 , 32 , 33 , 34 , 35 , 36)
                2 -> listNumber.value = listOf(40 ,41 ,42 , 43 ,44 , 45 , 46)
            }
        }
        PostSection(
            listNumber,
            modifier = Modifier.fillMaxWidth()
        )
    }
}


@Composable
fun TopBar(
    name: String,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
    ) {

        Text(
            text = name,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )

        Spacer(modifier = Modifier.fillMaxWidth(0.8f))

        Icon(
            imageVector = Icons.Rounded.Add,
            contentDescription = "Create",
            tint = Color.Black,
            modifier = Modifier.size(24.dp)
        )

        Spacer(modifier = Modifier.width(10.dp))

        Icon(
            imageVector = Icons.Filled.Settings,
            contentDescription = "Setting",
            tint = Color.Black,
            modifier = Modifier.size(20.dp)
        )
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ProfileSection(
    modifier: Modifier = Modifier
) {
    val users = MockData.users
    var user = User()
    users.forEach {
        if (it.userName == UserCredential.Companion.userName) {
            user = it
        }
    }
    Column(modifier = modifier.fillMaxWidth()) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            GlideImageCreator(
                modifier = Modifier
                    .width(90.dp)
                    .height(90.dp), shape = RoundedCornerShape(40.dp), image = user.profileImage
            )
            Spacer(modifier = Modifier.width(16.dp))
            StatSection(modifier = Modifier.weight(7f))
        }
        Spacer(modifier = Modifier.height(5.dp))
        ProfileDescription(
            displayName = "Sina Mohammadi",
            description = "3 years developing Software\n" +
                    "for tutorials see my YouTube channel!",
            job = "Android Developer",
            url = "https://youtube.com/c/Sina.M",
        )
    }
}


@Composable
fun StatSection(modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier
    ) {
        ProfileStat(numberText = "20", text = "Posts")
        ProfileStat(numberText = "180", text = "Followers")
        ProfileStat(numberText = "60", text = "Following")
    }
}

@Composable
fun ProfileStat(
    numberText: String,
    text: String,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Text(
            text = numberText,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = text)
    }
}

@Composable
fun ProfileDescription(
    displayName: String,
    job: String,
    description: String,
    url: String,
) {
    val letterSpacing = 0.5.sp
    val lineHeight = 20.sp
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ) {
        Text(
            text = displayName,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )
        Text(
            text = job,
            fontWeight = FontWeight.SemiBold,
            fontSize = 14.sp,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )
        Text(
            text = description,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )
        Text(
            text = url,
            color = Color(0xFF3D3D91),
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )
    }
}

@Composable
fun HighlightSection(
    modifier: Modifier = Modifier,
    highlights: List<GlideImageWithText>
) {
    LazyRow(modifier = modifier) {
        items(highlights.size) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(end = 15.dp)
            ) {
                GlideImageCreator(
                    modifier = Modifier.size(60.dp),
                    shape = RoundedCornerShape(55.dp),
                    image = highlights[it].image
                )
                Text(
                    text = highlights[it].text,
                    overflow = TextOverflow.Ellipsis,
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Composable
fun PostTabView(
    modifier: Modifier = Modifier,
    imageWithTexts: List<ImageVectorWithText>,
    onTabSelected: (selectedIndex: Int) -> Unit
) {
    var selectedTabIndex by remember {
        mutableStateOf(0)
    }
    val inactiveColor = Color(0xFF777777)
    TabRow(
        selectedTabIndex = selectedTabIndex,
        backgroundColor = Color.Transparent,
        contentColor = Color.Black,
        modifier = modifier
    ) {
        imageWithTexts.forEachIndexed { index, item ->
            Tab(
                selected = selectedTabIndex == index,
                selectedContentColor = Color.Black,
                unselectedContentColor = inactiveColor,
                onClick = {
                    selectedTabIndex = index
                    onTabSelected(index)
                }
            ) {
                Icon(
                    imageVector = item.image,
                    contentDescription = item.text,
                    tint = if (selectedTabIndex == index) Color.Black else inactiveColor,
                    modifier = Modifier
                        .padding(10.dp)
                        .size(20.dp)
                )
            }
        }
    }
}

@ExperimentalFoundationApi
@Composable
fun PostSection(
    listNumber: MutableState<List<Int>>,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        cells = GridCells.Fixed(3),
        modifier = modifier
            .scale(1.01f)
    ) {
        items(listNumber.value.size) {
            GlideImageCreator(
                modifier = Modifier
                    .aspectRatio(1f)
                    .border(2.dp, color = Color.White),
                shape = RoundedCornerShape(0.dp),
                image = "https://picsum.photos/400/350?random=${listNumber.value[it]}"
            )
        }
    }
}
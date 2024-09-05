package com.thoen.mechat.feafure.chats

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.thoen.mechat.R
import com.thoen.mechat.router.ChatDetail

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatScreen(
    navController: NavController,
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.logos),
                            contentDescription = "logo",
                            modifier = Modifier
                                .size(50.dp)
                        )
                        Spacer(modifier = Modifier.size(12.dp))
                        Image(
                            painter = painterResource(id = R.drawable.me_chats),
                            contentDescription = "me_chats",
                            modifier = Modifier
                                .height(20.dp)
                                .align(Alignment.CenterVertically)
                        )

                    }
                },
                actions = {
                    Image(
                        painter = painterResource(id = R.drawable.add),
                        contentDescription = "Add",
                        modifier = Modifier
                            .size(26.dp)
                    )
                    Spacer(modifier = Modifier.size(12.dp))
                }
            )
        },
        bottomBar = {
            Box(modifier = Modifier.fillMaxWidth().height(80.dp))
        },
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .imePadding()
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .verticalScroll(rememberScrollState())

            ) {
                BodyChat(navController)
            }

        }

    }


}

@Composable
fun BodyChat(
    navController: NavController
) {
    Column(
        modifier = Modifier
            .padding(16.dp)
    ) {
        SearchBarCustom()
        Spacer(modifier = Modifier.size(16.dp))
        for (i in 1..10) {
            ItemChat(
                onClick = {
                    navController.navigate(ChatDetail.route)
                }
            )
            Spacer(modifier = Modifier.size(8.dp))
        }

    }
}



@Composable
fun ItemChat(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
    ) {
    Box (
        modifier = Modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(8.dp))
            .clickable(
                onClick = onClick
            )
            .background(Color.White)
            .padding(12.dp)

    ){
        Row (
            verticalAlignment = Alignment.CenterVertically
        ){
            Image(
                painter = painterResource(id = R.drawable.thoen),
                contentDescription = "Profile",
                modifier = Modifier
                    .size(50.dp)
                    .clip(RoundedCornerShape(100))
            )
            Spacer(modifier = Modifier.size(12.dp))
            Column (
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = "Chorn Thoen",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W600,
                    color = Color(0xFF2D3C52)
                )
                Spacer(modifier = Modifier.size(4.dp))
                Text(
                    text = "Message here ",
                    fontSize = 14.sp,
                    color = Color(0xFF2D3C52),
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1

                )
            }
            Column(
                horizontalAlignment = Alignment.End
            ) {
                Text(
                    text = "12:00 pm",
                    fontSize = 14.sp,
                    color = Color(0xFF2D3C52)
                )
                Spacer(modifier = Modifier.size(4.dp))
                Box(
                    modifier = Modifier
                        .size(14.dp)
                        .clip(shape = RoundedCornerShape(12.dp))
                        .background(Color(0xFF2D3C52)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "9",
                        fontSize = 8.sp,
                        lineHeight = 8.sp,
                        color = Color.White,
                    )
                }
            }
        }
    }
}

@Composable
fun SearchBarCustom(modifier: Modifier = Modifier) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(34.dp))
            .background(Color(0xFFFFFFFF))
            .padding(horizontal = 16.dp, vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.search),
            contentDescription = "avatar",
            modifier = Modifier
                .size(24.dp),
            colorFilter = ColorFilter.tint(Color(0xFF2D3C52)),
        )
        Text(
            text = "Search",
            fontSize = 14.sp,
            fontWeight = FontWeight.W500,
            color = Color(0xFF2D3C52),
            modifier = Modifier.padding(8.dp)
        )
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ChatScreenPreview() {
    ChatScreen(navController = rememberNavController())
}

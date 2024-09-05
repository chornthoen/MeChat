package com.thoen.mechat.feafure.chats

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.thoen.mechat.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatScreen(
    navController: NavController,
) {
    Scaffold (
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                modifier = Modifier
                    .background(Color.Red),
                title = {
                    Row (
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                    ){
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
        }
    ) { innerPadding ->
        Box (
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ){

            BodyChat()

        }

    }


}

@Composable
fun BodyChat(){
    Column {
        Text(text = "Chat")
    }
}

@Preview(showBackground = true , showSystemUi = true)
@Composable
fun ChatScreenPreview() {
    ChatScreen(navController = rememberNavController())
}

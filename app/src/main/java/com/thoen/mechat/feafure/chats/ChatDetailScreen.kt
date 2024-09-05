package com.thoen.mechat.feafure.chats

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatDetailScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Chorn Thoen",
                        color = Color.Black,
                        fontWeight = FontWeight.W500,
                        fontSize = 16.sp
                    )
                },
                navigationIcon = {
                    Box(
                        modifier = Modifier
                            .size(48.dp)
                            .clip(shape = RoundedCornerShape(100))

                            .clickable {
                                navController.popBackStack()
                            },
                        contentAlignment = Alignment.Center

                    ) {

                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                            contentDescription = "Back",
                            tint = Color.Black,
                            modifier = Modifier.size(28.dp)
                        )
                    }

                },
                actions = {

                    Spacer(modifier = Modifier.size(12.dp))
                }
            )

        },

        ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(16.dp)

        ) {
            Column {
                Text(
                    text = "Chat Detail",

                    )
            }

        }
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewChatDetailScreen() {
    ChatDetailScreen(navController = rememberNavController())
}
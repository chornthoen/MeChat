package com.thoen.mechat.feafure.authen.signin

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.thoen.mechat.R
import com.thoen.mechat.feafure.components.CardSocialMedia
import com.thoen.mechat.feafure.components.CustomTextField
import com.thoen.mechat.feafure.components.FilledButtonCustom
import com.thoen.mechat.router.Navigation
import com.thoen.mechat.router.SignUp


@SuppressLint("UnrememberedMutableInteractionSource")
@Composable
fun SignInScreen(
    navController: NavController,
) {
    val keyboardController = LocalSoftwareKeyboardController.current

    Scaffold { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .imePadding()
                .clickable(
                    onClick = {
                        keyboardController?.hide()
                    },
                    interactionSource = MutableInteractionSource(),
                    indication = null
                )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 24.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                BodySignIn(navController)
            }
        }
    }
}

@Composable
fun BodySignIn(
    navController: NavController
) {
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }

    val viewModel: SignInViewModel = hiltViewModel()


    val uiState = viewModel.signInState.collectAsState()

    val context = LocalContext.current

    LaunchedEffect(key1 = uiState.value) {
        when (uiState.value) {
            SignInState.Success -> {
//                Toast.makeText(context, "Sign In Success", Toast.LENGTH_SHORT).show()
                navController.navigate(Navigation.route)
            }
            SignInState.Error -> {
                Toast.makeText(context, "Sign In Error", Toast.LENGTH_SHORT).show()
            }
            else -> {}
        }
    }

    Column {
        Box {
            Image(
                painter = painterResource(id = R.drawable.logo_mechat),
                contentDescription = "logo",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )
        }
        Text(
            text = "Welcome Back to Mechat",
            modifier = Modifier.padding(16.dp),
            fontSize = 22.sp,
            fontWeight = FontWeight.W500,
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = "Email Address",
            fontSize = 12.sp,
            lineHeight = 12.sp
        )
        Spacer(modifier = Modifier.height(8.dp))
        CustomTextField(
            keyboardType = KeyboardType.Email,
            label = "Email",
            value = email,
            onTextChanged = { email = it },
            passwordVisible = true
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = "Password",
            fontSize = 12.sp,
            lineHeight = 12.sp
        )
        Spacer(modifier = Modifier.height(8.dp))
        CustomTextField(
            keyboardType = KeyboardType.Password,
            label = "Password",
            value = password,
            onTextChanged = { password = it },
        )
        Row {
            Box(
                modifier = Modifier
                    .weight(1f)
            )
            TextButton(
                onClick = {},
                modifier = Modifier
                    .padding(horizontal = 1.dp),
                shape = RoundedCornerShape(8.dp),
            ) {
                Text(
                    text = "Forgot Password?",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W500,
                    textDecoration = TextDecoration.Underline
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        if (uiState.value == SignInState.Loading) {
            CircularProgressIndicator(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            )
        } else {
            FilledButtonCustom(
                onClick = {
                    viewModel.signIn(email, password)
                },
                text = "Sign In",
                enabled = email.isNotBlank() && password.isNotBlank() && uiState.value != SignInState.Loading
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Box(
                modifier = Modifier
                    .height(1.dp)
                    .width(100.dp)
                    .background(Color(0xFFE0E0E0))
                    .weight(1f)
            )
            Text(
                text = "OR",
                fontSize = 16.sp,
                fontWeight = FontWeight.W400,
                modifier = Modifier.padding(horizontal = 4.dp)
            )
            Box(
                modifier = Modifier
                    .height(1.dp)
                    .width(100.dp)
                    .background(Color(0xFFE0E0E0))
                    .weight(1f)
            )
        }
        Box(
            modifier = Modifier
                .height(8.dp)
        )
        CardSocialMedia(
            text = "Continue with Google",
            onClick = {},
            icon = R.drawable.google
        )
        CardSocialMedia(
            text = "Continue with Facebook",
            onClick = {},
            icon = R.drawable.facebook
        )
        Box(
            modifier = Modifier
                .height(16.dp)
        )
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Text(
                text = "Don't have an account?",
                fontSize = 16.sp,
                lineHeight = 12.sp
            )
            TextButton(
                onClick = {
                    navController.navigate(SignUp.route)
                },
                shape = RoundedCornerShape(8.dp),
            ) {
                Text(
                    text = "Sign Up",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W500,
                    textDecoration = TextDecoration.Underline
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewSignInScreen() {
    SignInScreen(navController = rememberNavController())
}
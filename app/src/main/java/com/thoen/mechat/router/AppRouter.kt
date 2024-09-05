package com.thoen.mechat.router

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.firebase.auth.FirebaseAuth
import com.thoen.mechat.feafure.authen.signin.SignInScreen
import com.thoen.mechat.feafure.authen.signup.SignUpScreen
import com.thoen.mechat.feafure.chats.ChatScreen
import com.thoen.mechat.feafure.navigation.NavigationScreen
import com.thoen.mechat.feafure.settings.SettingScreen

@Composable
fun AppRouter() {
    val navController = rememberNavController()
    val currentUser = FirebaseAuth.getInstance().currentUser
    val start = if (currentUser != null) Navigation.route else SignIn.route
    NavHost(
        navController = navController,
        startDestination = start,
        builder = {
            composable(SignIn.route) {
                SignInScreen(navController)
            }
            composable(SignUp.route) {
                SignUpScreen(navController)
            }
            composable(Chat.route) {
                ChatScreen(navController)
            }
            composable(Setting.route) {
                SettingScreen(navController)
            }
            composable(Navigation.route) {
                NavigationScreen(navController)
            }

        }
    )
}
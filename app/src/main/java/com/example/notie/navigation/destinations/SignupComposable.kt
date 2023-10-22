package com.example.notie.navigation.destinations

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.notie.ui.auth.SignupScreen
import com.example.notie.utils.Constants.SIGNUP_SCREEN

fun NavGraphBuilder.signupComposable(
  navigateToLoginScreen: () -> Unit
) {
  composable(route = SIGNUP_SCREEN){
    SignupScreen(navigateToLoginScreen = navigateToLoginScreen)
  }
}
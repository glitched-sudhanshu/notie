package com.example.notie.navigation.destinations

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.notie.ui.auth.LoginScreen
import com.example.notie.utils.Constants.LOGIN_SCREEN

fun NavGraphBuilder.loginComposable(
  navigateToSignUpScreen: () -> Unit
) {
  composable(route = LOGIN_SCREEN){
    LoginScreen(navigateToSignUpScreen = navigateToSignUpScreen)
  }
}
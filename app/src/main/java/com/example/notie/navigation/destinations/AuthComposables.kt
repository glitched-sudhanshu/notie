package com.example.notie.navigation.destinations

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.notie.ui.auth.ForgetPasswordScreen
import com.example.notie.ui.auth.LoginScreen
import com.example.notie.ui.auth.OnboardingScreen
import com.example.notie.ui.auth.SignupScreen
import com.example.notie.utils.Constants

fun NavGraphBuilder.loginComposable(
  navigateToSignUpScreen: () -> Unit,
  navigateToForgetPasswordScreen: () -> Unit
) {
  composable(route = Constants.LOGIN_SCREEN){
    LoginScreen(navigateToSignUpScreen = navigateToSignUpScreen, navigateToForgetPasswordScreen = navigateToForgetPasswordScreen)
  }
}

fun NavGraphBuilder.onboardingComposable(
  navigateToSignUpScreen: () -> Unit,
  navigateToLoginScreen: () -> Unit
){
  composable(
    route = Constants.ONBOARDING_SCREEN,
  ){
    OnboardingScreen(
      navigateToLoginScreen = navigateToLoginScreen,
      navigateToSignUpScreen = navigateToSignUpScreen
    )
  }
}

fun NavGraphBuilder.signupComposable(
  navigateToLoginScreen: () -> Unit
) {
  composable(route = Constants.SIGNUP_SCREEN){
    SignupScreen(navigateToLoginScreen = navigateToLoginScreen)
  }
}

fun NavGraphBuilder.forgetPasswordComposable(){
  composable(route = Constants.FORGET_PASSWORD_SCREEN){
    ForgetPasswordScreen()
  }
}


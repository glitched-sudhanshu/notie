package com.example.notie.navigation.destinations

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.notie.ui.auth.AuthViewModel
import com.example.notie.ui.auth.OnboardingScreen
import com.example.notie.ui.components.sharedViewModel
import com.example.notie.utils.Constants

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
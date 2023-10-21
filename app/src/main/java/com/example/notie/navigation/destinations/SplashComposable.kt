package com.example.notie.navigation.destinations

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.notie.ui.splash.SplashScreen
import com.example.notie.utils.Constants.SPLASH_SCREEN

fun NavGraphBuilder.splashComposable(
  navigateToListScreen: () -> Unit,
  navigateToOnboardingScreen: () -> Unit
){
  composable(
    route = SPLASH_SCREEN,
  ){
     SplashScreen(navigateToListScreen = navigateToListScreen, navigateToOnboardingScreen = navigateToOnboardingScreen)
  }
}
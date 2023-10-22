package com.example.notie.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.navigation
import com.example.notie.navigation.destinations.forgetPasswordComposable
import com.example.notie.navigation.destinations.listComposable
import com.example.notie.navigation.destinations.loginComposable
import com.example.notie.navigation.destinations.noteComposable
import com.example.notie.navigation.destinations.onboardingComposable
import com.example.notie.navigation.destinations.signupComposable
import com.example.notie.navigation.destinations.splashComposable
import com.example.notie.utils.Constants.AUTH
import com.example.notie.utils.Constants.LIST_SCREEN
import com.example.notie.utils.Constants.NOTES_FEATURE
import com.example.notie.utils.Constants.ONBOARDING_SCREEN
import com.example.notie.utils.Constants.SPLASH_SCREEN

@Composable
fun SetupNavigation(
  navHostController: NavHostController
) {
  val screen = remember(navHostController) {
    Screens(navHostController = navHostController)
  }

  NavHost(navController = navHostController, startDestination = SPLASH_SCREEN) {
    splashComposable(
      navigateToListScreen = screen.splash,
      navigateToOnboardingScreen = screen.onboarding
    )
    navigation(startDestination = ONBOARDING_SCREEN, route = AUTH) {
      onboardingComposable(
        navigateToLoginScreen = screen.login,
        navigateToSignUpScreen = screen.signup
      )
      loginComposable(navigateToSignUpScreen = screen.signup, navigateToForgetPasswordScreen = screen.forgetPassword)
      signupComposable(navigateToLoginScreen = screen.login)
      forgetPasswordComposable()
    }
    navigation(startDestination = LIST_SCREEN, route = NOTES_FEATURE) {
      listComposable(navigateToTaskScreen = screen.list)
      noteComposable(navigateToListScreen = screen.note)
    }
  }
}
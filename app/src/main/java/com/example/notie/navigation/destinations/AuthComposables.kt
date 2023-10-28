package com.example.notie.navigation.destinations

import android.app.Activity.RESULT_OK
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.notie.ui.auth.GoogleAuthUiClient
import com.example.notie.ui.auth.SignInViewModel
import com.example.notie.ui.auth.screens.ForgetPasswordScreen
import com.example.notie.ui.auth.screens.LoginScreen
import com.example.notie.ui.auth.screens.OnboardingScreen
import com.example.notie.ui.auth.screens.SignupScreen
import com.example.notie.utils.Constants
import com.example.notie.utils.Constants.LIST_SCREEN
import com.example.notie.utils.sharedViewModel
import kotlinx.coroutines.launch

fun NavGraphBuilder.loginComposable(
  navigateToSignUpScreen: () -> Unit,
  navigateToForgetPasswordScreen: () -> Unit,
  navHostController: NavHostController,
  googleAuthUiClient: GoogleAuthUiClient
) {
  composable(route = Constants.LOGIN_SCREEN) {
    val viewModel = it.sharedViewModel<SignInViewModel>(navController = navHostController)

    LoginScreen(
      navigateToSignUpScreen = navigateToSignUpScreen,
      navigateToForgetPasswordScreen = navigateToForgetPasswordScreen,
      viewModel = viewModel
    )
  }
}

fun NavGraphBuilder.onboardingComposable(
  navigateToSignUpScreen: () -> Unit,
  navigateToLoginScreen: () -> Unit,
  navigateToListScreen: () -> Unit,
  navHostController: NavHostController,
  googleAuthUiClient: GoogleAuthUiClient
) {
  composable(
    route = Constants.ONBOARDING_SCREEN,
  ) {
    val viewModel = it.sharedViewModel<SignInViewModel>(navController = navHostController)

    LaunchedEffect(key1 = Unit){
      if(googleAuthUiClient.getSignedInUser() != null){
        navHostController.navigate(LIST_SCREEN)
      }
    }

   val lifecycleScope = LocalLifecycleOwner.current.lifecycleScope

    val launcher = rememberLauncherForActivityResult(
      contract = ActivityResultContracts.StartIntentSenderForResult(),
      onResult = { result ->
        if(result.resultCode == RESULT_OK) {
          lifecycleScope.launch {
            val signInResult = googleAuthUiClient.signInWithIntent(
              intent = result.data ?: return@launch
            )
            viewModel.onSignInResult(signInResult)
          }
        }
      }
    )
    OnboardingScreen(
      navigateToLoginScreen = navigateToLoginScreen,
      navigateToSignUpScreen = navigateToSignUpScreen,
      navigateToListScreen = navigateToListScreen,
      viewModel = viewModel
    ) {
      lifecycleScope.launch {
        val signInIntentSender = googleAuthUiClient.signIn()
        launcher.launch(
          IntentSenderRequest.Builder(
            signInIntentSender ?: return@launch
          ).build()
        )
      }
    }
  }
}

fun NavGraphBuilder.signupComposable(
  navigateToLoginScreen: () -> Unit,
  navHostController: NavHostController
) {
  composable(route = Constants.SIGNUP_SCREEN) {
    val viewModel = it.sharedViewModel<SignInViewModel>(navController = navHostController)
    SignupScreen(navigateToLoginScreen = navigateToLoginScreen, viewModel = viewModel)
  }
}

fun NavGraphBuilder.forgetPasswordComposable(
  navHostController: NavHostController
) {
  composable(route = Constants.FORGET_PASSWORD_SCREEN) {
    val viewModel = it.sharedViewModel<SignInViewModel>(navController = navHostController)
    ForgetPasswordScreen(viewModel = viewModel)
  }
}


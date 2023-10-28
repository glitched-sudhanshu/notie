package com.example.notie

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.notie.navigation.SetupNavigation
import com.example.notie.ui.auth.GoogleAuthUiClient
import com.example.notie.ui.theme.NotieTheme
import com.google.android.gms.auth.api.identity.Identity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

  private lateinit var navController: NavHostController

  private val googleAuthUiClient by lazy {
    GoogleAuthUiClient(
      context = applicationContext,
      oneTapClient = Identity.getSignInClient(applicationContext)
    )
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      NotieTheme{
        navController = rememberNavController()
        SetupNavigation(navHostController = navController, googleAuthUiClient = googleAuthUiClient)
      }
    }
  }
}

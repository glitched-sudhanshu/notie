package com.example.notie

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.notie.navigation.SetupNavigation
import com.example.notie.ui.auth.AuthViewModel
import com.example.notie.ui.theme.NotieTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

  private val sharedViewModel : AuthViewModel by viewModels()
  private lateinit var navController: NavHostController

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      NotieTheme{
        navController = rememberNavController()
        SetupNavigation(navHostController = navController)
      }
    }
  }
}

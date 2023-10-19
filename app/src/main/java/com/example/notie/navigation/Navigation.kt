package com.example.notie.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.notie.navigation.destinations.listComposable
import com.example.notie.navigation.destinations.noteComposable
import com.example.notie.navigation.destinations.splashComposable
import com.example.notie.utils.Constants.SPLASH_SCREEN

@Composable
fun SetupNavigation(
  navHostController: NavHostController
)
{
  val screen = remember(navHostController){
    Screens(navHostController = navHostController)
  }

  NavHost(navController = navHostController, startDestination = SPLASH_SCREEN){
    splashComposable(navigateToListScreen = screen.splash)
    listComposable(navigateToTaskScreen = screen.list)
    noteComposable(navigateToListScreen = screen.note)
  }
}
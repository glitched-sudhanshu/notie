package com.example.notie.navigation.destinations

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.notie.utils.Action
import com.example.notie.utils.Constants

fun NavGraphBuilder.noteComposable(
  navigateToListScreen: (Action) -> Unit
){
  composable(
    route = Constants.NOTE_SCREEN,
    arguments = listOf(navArgument(Constants.NOTE_ARGUMENT_KEY){
      type = NavType.IntType
    })
  ){

  }
}
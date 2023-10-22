package com.example.notie.navigation

import androidx.navigation.NavHostController
import com.example.notie.utils.Action
import com.example.notie.utils.Constants.AUTH
import com.example.notie.utils.Constants.LIST_SCREEN
import com.example.notie.utils.Constants.SPLASH_SCREEN

class Screens(navHostController: NavHostController) {

  val splash: () -> Unit = {
    navHostController.navigate("list/${Action.NO_ACTION.name}"){
        popUpTo(SPLASH_SCREEN){
          inclusive = true
        }
    }
  }

  val list: (Int) -> Unit = { taskId ->
    navHostController.navigate("note/$taskId")
  }

  val onboarding: () -> Unit = {
    navHostController.navigate(AUTH){
      popUpTo(SPLASH_SCREEN){
        inclusive = true
      }
    }
  }

  val login: () -> Unit = {
    navHostController.navigate("login")
  }

  val signup: () -> Unit = {
    navHostController.navigate("signup")
  }

  val note: (Action) -> Unit = { action ->
    navHostController.navigate("list/${action.name}") {
      popUpTo(LIST_SCREEN) {
        inclusive = true
      }
    }
  }
}